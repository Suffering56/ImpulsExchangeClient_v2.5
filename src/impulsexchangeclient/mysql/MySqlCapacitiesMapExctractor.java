package impulsexchangeclient.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class MySqlCapacitiesMapExctractor {

    public MySqlCapacitiesMapExctractor(String startDatap, String finishDatap) {
        this.initialDatap = startDatap;
        this.finalDatap = finishDatap;
    }

    /**
     * Запуск процесса извлечения capacitiesMap.
     *
     * @return Map <datap, capacity> capacitiesMap, в случае успешного
     * выполнениия запросов. null - в случае возникновения ошибок.
     */
    public Map<String, Integer> extract() {
        createStatement();
        if (statement != null) {
            extractCapacitiesMap();
        }
        mySqlInstance.disconnect();
        return capacitiesMap;
    }

    /**
     * получаем список нагрузок (nagruz) по дням, необходимый для запрета выбора
     * дилерами тех дат монтажа, когда нагрузка на производство слишком большая
     * (nagruz > 720)
     */
    private void extractCapacitiesMap() {
        try {
            capacitiesMap = new HashMap<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM `jos_zakazi` WHERE "
                    + "`datap` >= '" + initialDatap + "' AND"
                    + "`datap` <= '" + finalDatap + "'");
            while (rs.next()) {
                String datap = rs.getString("datap");
                if (!capacitiesMap.containsKey(datap)) {
                    capacitiesMap.put(datap, rs.getInt("nagruz"));
                } else {
                    capacitiesMap.put(datap, capacitiesMap.get(datap) + rs.getInt("nagruz"));
                }
            }

        } catch (SQLException ex) {
            capacitiesMap = null;
            JOptionPane.showMessageDialog(null, "Ошибка при работе с базой данных MySQL. \r\n"
                    + "ex.toString(): " + ex, "MySqlCapacitiesMapExctractor.extractCapacitiesMap()", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Создаем объект statement, необходимый для работы с БД.
     */
    private void createStatement() {
        mySqlInstance = MySqlConnector.getInstance();
        Connection connection = mySqlInstance.connect();
        if (connection != null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка при работе с базой данных MySQL. \r\n"
                        + "ex.toString(): " + ex, "MySqlCapacitiesMapExctractor.createStatement()", JOptionPane.ERROR_MESSAGE);
                statement = null;
            }
        } else {
            statement = null;
        }
    }

    private MySqlConnector mySqlInstance;
    private Statement statement;
    private Map<String, Integer> capacitiesMap;
    private final String initialDatap;
    private final String finalDatap;
}
