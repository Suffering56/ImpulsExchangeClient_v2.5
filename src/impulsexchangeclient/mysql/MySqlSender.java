package impulsexchangeclient.mysql;

import impulsexchangeclient.common.OrderEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

public class MySqlSender {

    public MySqlSender(List<OrderEntity> monitorEntityList) {
        this.monitorEntityList = monitorEntityList;
    }

    /**
     * Запуск всех функций и методов для отправки всех указанных пользователем
     * заказов в отгрузочную программу.
     *
     * @return boolean: true - если процесс экспорта был успешно завершен. false
     * - если во время экспорта возникли какие-либо ошибки.
     */
    public boolean export() {
        boolean result = false;
        MySqlConnector mySqlInstance = MySqlConnector.getInstance();
        Connection connection = mySqlInstance.connect();
        if (connection != null) {
            try {
                statement = connection.createStatement();

                for (OrderEntity entity : monitorEntityList) {
                    String fOrder = entity.getFullOrderName();
                    if (!orderExistenceCheck(fOrder)) {                         //если такого заказа НЕТ В ОТГРУЗКЕ
                        queriesPreparation(entity);                             //!!!
                    } else if (showConfirmDlg(fOrder) == 0) {                   //если была нажата кнопка "Заменить"
                        replaceOrder(entity);
                    }
                }
                result = true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка при работе с базой данных MySQL. \r\n"
                        + "ex.toString(): " + ex, "MySqlSender.export()", JOptionPane.ERROR_MESSAGE);
            } finally {
                mySqlInstance.disconnect();
            }
        }
        return result;
    }

    /**
     * Инициализация и запуск запросов к отгрузочной программе, для экспорта
     * информации о заказах. Если заказ - simple, то будет выполнен один запрос
     * в БД, если заказ - difficult, то - несколько(зависит от сложности заказа)
     *
     * @param entity Объект класса OrderEntity содержащий всю необходимую
     * информацию об экспортируемом заказе.
     */
    private void queriesPreparation(OrderEntity entity) throws SQLException {
        if (entity.getDifficultOrderMap().isEmpty()) {
            executeMainQuery(entity, entity.getFullOrderName(), entity.getProductionDate(), entity.getCapacity());
        } else {
            int counter = 0;
            String nz;
            for (String datap : entity.getDifficultOrderMap().keySet()) {
                int nagruz = entity.getDifficultOrderMap().get(datap);
                if (counter == 0) {
                    nz = entity.getFullOrderName();
                } else {
                    nz = "_" + entity.getFullOrderName();
                }
                executeMainQuery(entity, nz, datap, nagruz);
                counter++;
            }
        }
    }

    /**
     * Замена уже существующего в отгрузке заказа новым, в случае совпадения их
     * имен.
     *
     * @param entity Объект класса OrderEntity содержащий всю необходимую
     * информацию об экспортируемом заказе.
     */
    private void replaceOrder(OrderEntity entity) throws SQLException {
        String fOrder = entity.getFullOrderName();
        int deleteResult = statement.executeUpdate("DELETE FROM `jos_zakazi` "
                + "WHERE `nz` LIKE '" + fOrder + "'");                          //удаляем старый заказ
        deleteResult += statement.executeUpdate("DELETE FROM `jos_zakazi` "
                + "WHERE `nz` LIKE '" + "_" + fOrder + "'");                    //удаляем дополнительные заказы (если заказ difficult)
        if (deleteResult > 0) {
            queriesPreparation(entity);                                         //добавляем новый заказ в отгрузку!!!
        } else {                                                                //если заказ почему-то не удалился
            JOptionPane.showMessageDialog(null, "Произошла ошибка при удалении заказа №" + fOrder + ">\r\n"
                    + "Заказ остался в отгрузочной программе без изменений", "MySqlSender.export()", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Инициализация запроса на добавление нового заказа в отгрузку.
     *
     * @param entity Объект класса OrderEntity содержащий всю необходимую
     * информацию об экспортируемом заказе.
     * @param nz номер заказа (для сложных заказов в начало номера заказа будет
     * добавлен символ "_" - что означает, что они - части одного большого
     * заказа, и не являются самостоятельными)
     * @param datap дата произвоодства
     * @param nagruz - нагрузка
     * @throws SQLException
     */
    private void executeMainQuery(OrderEntity entity, String nz, String datap, int nagruz) throws SQLException {
        String query = "INSERT INTO `jos_zakazi` "
                + "(`idz`, `nz`, `klient`, `adr`,"
                + " `kolkon`, `dost`, `demont`, `mont`,"
                + " `nagruz`, `zamer`, `brig`, `sbor`,"
                + " `datap`, `datam`, `kont`, `g`,"
                + " `s`, `musor`, `lm`, `komkol`, `kom`"
                + ") VALUES ("
                + "NULL, '" + nz + SEPARATOR + entity.getClient() + SEPARATOR + entity.getAddress() + SEPARATOR
                + entity.getConstructionsCount() + SEPARATOR + entity.getDelivery() + SEPARATOR + entity.getDismantling() + SEPARATOR + entity.getMounting() + SEPARATOR
                + nagruz + SEPARATOR + entity.getMaster() + SEPARATOR + "1" + SEPARATOR + "1" + SEPARATOR
                + datap + SEPARATOR + entity.getMountingDate() + SEPARATOR + entity.getContacts() + SEPARATOR + "0" + SEPARATOR
                + "0" + SEPARATOR + entity.getGarbage() + SEPARATOR + entity.getLamination() + SEPARATOR + entity.getDescription() + SEPARATOR + entity.getComment() + "')";
        statement.executeUpdate(query);
    }

    /**
     * Проверяет есть ли такой заказ в отгрузочной программе.
     *
     * @param fullOrderName номер заказа.
     * @return boolean: true - если такой заказ уже есть в отгрузке и необходимо
     * что-то предпринять. false - в случае если такого заказа нет, и можно
     * спокойно его экспортировать.
     */
    private boolean orderExistenceCheck(String fullOrderName) throws SQLException {
        String query = "SELECT count(*) FROM `jos_zakazi` WHERE `nz` LIKE '" + fullOrderName + "'";
        ResultSet rs = statement.executeQuery(query);
        int count = 0;
        while (rs.next()) {
            count = rs.getInt("count(*)");
        }
        return count > 0;
    }

    /**
     * Создание и отображение диалогового окна с надписью "Такой заказ уже есть
     * в отгрузочной программе" и предложением выбора дальнейших действий.
     *
     * @param fOrder номер заказа.
     * @return int: '0' - если была нажата кнопка "Заменить". '1' - если была
     * нажата кнопка "Отмена. '-1' - если был нажат красный крестик в правом
     * верхнем углу.
     */
    private int showConfirmDlg(String fOrder) {
        return JOptionPane.showOptionDialog(null, "Заказ №" + fOrder + "> уже есть в отгрузочной программе!\r\n"
                + "Заменить его?", "Предупреждение!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                null, new Object[]{"Заменить", "Отмена"}, "Заменить");
    }

    private final List<OrderEntity> monitorEntityList;
    private Statement statement;
    private static final String SEPARATOR = "', '";
}
