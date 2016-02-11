package impulsexchangeclient.mysql;

import impulsexchangeclient.common.MonitorViewEntity;
import impulsexchangeclient.common.Options;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MySqlViewHandler {

    public MySqlViewHandler() {
        mySqlInstance = MySqlConnector.getInstance();
        createStatement();
    }

    /**
     *
     * @param from переключатель. Определяет на основе каких данных выполнять
     * запрос. Если параметр = "SEARCH", то будет возвращен список заказов, чьи
     * <b>наименования (nz)</b> совпадают c именем указанном в параметре
     * <b>value</b>. Если параметр = "CALENDAR", то будет возвращен список
     * заказов, чья <b>дата монтажа (datam)</b> соответствует значению
     * <b>value</b>.
     * @param value параметр выборки для запросов к БД.
     * @return Список заказов, соответствующих указанным пользователем
     * параметрам.
     */
    public ArrayList<MonitorViewEntity> getQueryResult(String from, String value) {
        try {
            resultList = new ArrayList<>();
            ResultSet rs = null;
            switch (from) {
                case "SEARCH":
                    rs = statement.executeQuery("SELECT * FROM `jos_zakazi` WHERE "
                            + "`nz` LIKE '" + Options.getDepartmentName() + "/%" + value + "%'");
                    break;
                case "CALENDAR":
                    rs = statement.executeQuery("SELECT * FROM `jos_zakazi` WHERE "
                            + "`nz` LIKE '" + Options.getDepartmentName() + "/%' AND "
                            + "`datam` = '" + value + "'");
                    break;
            }

            while (rs.next()) {
                String nz = rs.getString("nz");
                String datam = rs.getString("datam");
                String accessoriesStatus = convertStatus(rs.getInt("gk"));
                String productionStatus = convertStatus(rs.getInt("g"));
                resultList.add(new MonitorViewEntity(nz, datam, accessoriesStatus, productionStatus));
            }
        } catch (SQLException ex) {
            resultList = null;
            JOptionPane.showMessageDialog(null, "Ошибка при работе с базой данных MySQL. \r\n"
                    + "ex.toString(): " + ex, "MySqlViewHandler.getQueryResult()", JOptionPane.ERROR_MESSAGE);
        }
        return resultList;
    }

    private String convertStatus(int value) {
        String newValue;
        if (value == 0) {
            newValue = "Нет";
        } else {
            newValue = "Да";
        }
        return newValue;
    }

    private void createStatement() {
        Connection connection = mySqlInstance.connect();
        if (connection != null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка при работе с базой данных MySQL. \r\n"
                        + "ex.toString(): " + ex, "MySqlViewHandler.createStatement()", JOptionPane.ERROR_MESSAGE);
                statement = null;
            }
        } else {
            statement = null;
        }
    }

    public void closeConnection() {
        mySqlInstance.disconnect();
    }

    private final MySqlConnector mySqlInstance;
    private Statement statement;
    private ArrayList<MonitorViewEntity> resultList;
}
