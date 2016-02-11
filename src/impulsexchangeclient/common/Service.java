package impulsexchangeclient.common;

import impulsexchangeclient.ftp.FTPConnector;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;

public class Service {

    /**
     * Определение количества дней, необходимых для производства заказа, на
     * основе его нагрузки (capacity).
     *
     * @param capacity - Нагрузка, выраженная в минутах, при условии, что длина
     * рабочего дня - 720 минут (Service.MAX_DAILY_CAPACITY).
     * @return int - количество дней, необходимых для производства заказа.
     * Учитывается только время его производства рабочими в цеху. (т.е. время,
     * необходимое на закупку материалов и т.д. не учитывается)
     */
    public static int extractOrderReqDays(int capacity) {
        int orderReqDays = Math.round((float) Math.ceil(
                (double) capacity / (double) Service.MAX_DAILY_CAPACITY));
        return orderReqDays;
    }

    /**
     * Преобразуем дату (calendar) в формат необходимый для SQL-запросов.
     *
     * @param c Дата, представленная, как объект Calendar.
     * @return String - строка вида: "гггг-мм-дд". Например, для даты '23 ноября
     * 2015 года' будет возвращена строка: "2015-11-23".
     */
    public static String convertToSqlDate(Calendar c) {
        return new Formatter().format("%1$tY-%1$tm-%1$td", c).toString();
    }

    /**
     * Вычисляет остаток свободного времени в указанный день у рабочих цеха.
     *
     * @param datap Дата производства, по которой и будет вычисляться остаток.
     * @param capacitiesMap Таблица нагрузок за весь необходимый для вычислений
     * период (30 дней + orderReqDays)
     * @return int - остаток свободного времени у рабочих за указанный день.
     * Означает, что на такое количество минут еще можно нагрузить цех.
     */
    public static int getDailyBalance(String datap, Map<String, Integer> capacitiesMap) {
        int dailyBalance = Service.MAX_DAILY_CAPACITY;
        if (capacitiesMap.containsKey(datap)) {
            dailyBalance -= capacitiesMap.get(datap);
        }
        if (Service.INTERNAL_CAPACITIES_MAP.containsKey(datap)) {
            dailyBalance -= Service.INTERNAL_CAPACITIES_MAP.get(datap);
        }
        return dailyBalance;
    }

    /*
     Удаление элемента таблицы InternalItem. Либо вычитание значения 
     из соответствующего элемента таблицы, 
     если указанное значение меньше имеющегося в таблице.
     */
    public static void deleteInternalItem(String pDate, int value) {
        if (INTERNAL_CAPACITIES_MAP.containsKey(pDate)) {
            int currentValue = INTERNAL_CAPACITIES_MAP.get(pDate);
            if (value != currentValue) {
                INTERNAL_CAPACITIES_MAP.put(pDate, (currentValue - value));
            } else {
                INTERNAL_CAPACITIES_MAP.remove(pDate);
            }
        }
    }

    /*
     Добавление элемента таблицы InternalItem. Либо прибавка значения 
     к уже имеющемуся значению соответствующего элемента таблицы.
     */
    public static void addInternalItem(String pDate, int value) {
        if (INTERNAL_CAPACITIES_MAP.containsKey(pDate)) {
            int currentValue = INTERNAL_CAPACITIES_MAP.get(pDate);
            INTERNAL_CAPACITIES_MAP.put(pDate, (currentValue + value));
        } else {
            INTERNAL_CAPACITIES_MAP.put(pDate, value);
        }
    }

    /**
     * Данная функция используется для хоть какого-то шифрования важных настроек
     * программы.
     *
     * @param normalText Строка, которая будет зашифрована.
     * @return String - зашифрованная строка.
     */
    public static String encode(String normalText) {
        char[] encodedChars = new char[normalText.length()];
        for (int i = 0; i < normalText.length(); i++) {
            encodedChars[i] = (char) ((byte) normalText.charAt(i) + 5);
        }
        return String.valueOf(encodedChars);
    }

    /**
     * Данная функция используется для расшифровки настроек, хранящихся в XML.
     *
     * @param xmlText Строка, которая будет расшифрована.
     * @return String - расшифрованная строка.
     */
    public static String decode(String xmlText) {
        char[] decodedChars = new char[xmlText.length()];
        for (int i = 0; i < xmlText.length(); i++) {
            decodedChars[i] = (char) ((byte) xmlText.charAt(i) - 5);
        }
        return String.valueOf(decodedChars);
    }

    /**
     * Предварительная проверка соединения с FTP-сервером.
     *
     * @return boolean: true - если проверка была успешно пройдена. В противном
     * случае возвращает - false.
     */
    public static boolean preScreeningFTP() {
        boolean result = false;
        FTPConnector ftpInstance = FTPConnector.getInstance();
        FTPClient ftpConnection = ftpInstance.connect();
        Path swndFilePath = new File(Options.getSwndFilePath()).toPath();
        if (ftpConnection != null) {
            if (Files.exists(swndFilePath)) {
                result = true;
            } else {
                JOptionPane.showMessageDialog(null, "Указан неверный путь к файлу обмена <"
                        + Options.getSwndFileName() + ">\r\n" + "Пожалуйста проверьте настройки программы. "
                        + "Меню -> Настройки отдела.", "Service.preScreeningFTP()", JOptionPane.ERROR_MESSAGE);
            }
            ftpInstance.disconnect();
        }
        return result;
    }

    /**
     * Минимальное количество дней, необходимое для производства заказа.
     */
    public static final int MINIMAL_DATE_OFFSET = 3;
    /**
     * Длина списка для выбора даты монтажа.
     */
    public static final int MONTH_DURATION = 30;
    /**
     * Максимальная суточная нагрузка. Увеличение данного значения может
     * привести к тому, что рабочие цеха станут не успевать выполнять заказы.
     */
    public static final int MAX_DAILY_CAPACITY = 720;
    /**
     * Содержит список нагрузок заказов которые пользователь(дилер) выбрал для
     * дальнейшего экспорта в отгрузку. Необходим для того чтобы при добавлении
     * нового заказа на экспорт при выборе доступных дат монтажа учитывались уже
     * выбранные для экспорта, но еще не отправленные в отгрузку заказы.
     */
    public static final Map<String, Integer> INTERNAL_CAPACITIES_MAP = new HashMap<>();
}
