package impulsexchangeclient.common;

import impulsexchangeclient.mysql.MySqlCapacitiesMapExctractor;
import java.util.Calendar;
import java.util.Map;

public class MountingDateFilter {

    public MountingDateFilter(int capacity) {
        this.capacity = capacity;
        orderReqDays = Service.extractOrderReqDays(capacity);
        init();
    }

    /**
     * Проверяет, возможно ли на указанную дату монтажа ставить заказ.
     *
     * @param c Дата монтажа, необходимая для дальнейших проверок.
     * @return boolean: возвращает true, если на указанную дату монтажа можно
     * поставить заказ. Возвращает false, если выбор данной даты может привести
     * к перегрузке в цеху, либо если указанная дата монтажа - ВОСКРЕСЕНЬЕ.
     */
    public boolean mountingDateValidation(Calendar c) {
        Calendar calendar = (Calendar) c.clone();                       //создаем клон, чтобы не менять ничего в основном календаре
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {    //если дата монтажа - ВОСКРЕСЕНЬЕ
            return false;                                               //на ВОСКРЕСЕНЬЕ ставить монтаж нельзя
        }
        if (orderReqDays == 1) {                                        //обычный одинарный заказ
            return simpleDateSelector(calendar);
        } else if (orderReqDays > 1) {                                  //сложные заказы (на несколько дней)
            return difficultOrderCalculation(calendar);
        } else {                                                        //заказ с нулевой нагрузкой
            return true;
        }
    }

    /**
     * Производит расчет для сложных заказов (нагрузка > 720). Возможность
     * выбора пользователем указанной даты монтажа будет вычисляться на основе
     * нескольких дней (а не одного - как это делается для простых заказов),
     * предшествующих указанной дате монтажа.
     *
     * @param calendar Дата монтажа.
     * @return boolean: true, если выбор данной даты монтажа не приведет к
     * перегрузке в цеху. В противном случае будет возвращено false.
     *
     */
    private boolean difficultOrderCalculation(Calendar calendar) {
        int space = 0;
        calendar.add(Calendar.DAY_OF_MONTH, -orderReqDays);             //смещаемся на 1й день производства
        for (int i = 0; i < orderReqDays; i++) {
            String datap = Service.convertToSqlDate(calendar);
            space += Service.getDailyBalance(datap, capacitiesMap);
            calendar.add(Calendar.DAY_OF_MONTH, 1);                     //смещаемся на следующий день производства
        }
        return space >= capacity;
    }

    /**
     * Производит расчет для простых заказов (нагрузка <=720). Для вычислений
     * используются данные одного дня (идущего непосредственно перед днем
     * монтажа). Либо данные двух дней, если дата монтажа - ПОНЕДЕЛЬНИК, т.к. в
     * противном случае суббота будет всегда свободна.
     *
     * @param calendar Дата монтажа.
     * @return boolean: true, если выбор данной даты монтажа не приведет к
     * перегрузке в цеху. В противном случае будет возвращено false.
     */
    private boolean simpleDateSelector(Calendar calendar) {
        if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {    //если дата монтажа - обычный день (ВТОРНИК-СУББОТА) - включительно
            calendar.add(Calendar.DAY_OF_MONTH, -1);                    //переносим datam на 1 день назад чтобы получить datap
            return simpleValidation(calendar);
        } else {                                                        //если дата монтажа - ПОНЕДЕЛЬНИК
            calendar.add(Calendar.DAY_OF_MONTH, -2);                    //переносим datap на СУББОТУ (datap)       
            if (simpleValidation(calendar)) {                           //если можно поставить производство на СУББОТУ
                return true;
            } else {                                                    //если поставить производство на СУББОТУ не получается
                calendar.add(Calendar.DAY_OF_MONTH, +1);                //смещаемся на ВОСКРЕСЕНЬЕ
                return simpleValidation(calendar);
            }
        }
    }

    /**
     *
     * @param calendar Дата производства.
     * @return boolean: true, если заказ может быть произведен в указанный день
     * производства.
     */
    private boolean simpleValidation(Calendar calendar) {
        String datap = Service.convertToSqlDate(calendar);
        int balance = Service.getDailyBalance(datap, capacitiesMap);
        return capacity <= balance;
    }

    /**
     * Инициализация таблицы (карты) capacitiesMap, крайне необходимой для
     * дальнейших вычислений.
     */
    private void init() {
        Calendar calendar = Calendar.getInstance();                             //получаем текущий день - СЕГОДНЯ
        calendar.add(Calendar.DAY_OF_MONTH, -orderReqDays);
        String initialDatap = Service.convertToSqlDate(calendar);
        calendar.add(Calendar.DAY_OF_MONTH, (Service.MONTH_DURATION
                + Service.MINIMAL_DATE_OFFSET + orderReqDays));                 //смещаемся на месяц вперед (с запасом - чтобы уж точно никаких ошибок не было)
        String finalDatap = Service.convertToSqlDate(calendar);

        MySqlCapacitiesMapExctractor mapExctractor = new MySqlCapacitiesMapExctractor(initialDatap, finalDatap);
        capacitiesMap = mapExctractor.extract();                                //получаем список нагрузок по дням на ближайшие 30 дней
    }

    public Map<String, Integer> getCapacitiesMap() {
        return capacitiesMap;
    }

    private final int capacity;
    private final int orderReqDays;
    private Map<String, Integer> capacitiesMap;
}
