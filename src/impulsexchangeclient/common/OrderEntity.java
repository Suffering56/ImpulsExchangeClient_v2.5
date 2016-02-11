package impulsexchangeclient.common;

import java.util.Map;
import java.util.TreeMap;

public class OrderEntity {

    public OrderEntity(String fullOrderName, int invno, int clnum) {
        this.fullOrderName = fullOrderName;
        this.invno = invno;
        this.clnum = clnum;
    }

    public void setClient(String client) {
        if (client != null) {
            this.client = client;
        }
    }

    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
    }

    public void setContacts(String contacts) {
        if (contacts != null) {
            this.contacts = contacts;
        }
    }

    public void setMaster(String master) {
        if (master != null) {
            this.master = master;
        }
    }

    public void setConstructionsCount(int constructionsCount) {
        this.constructionsCount = constructionsCount;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public void setMounting(int mounting) {
        this.mounting = mounting;
    }

    public void setDismantling(int dismantling) {
        this.dismantling = dismantling;
    }

    public void setMountingDate(String mountingDate) {
        this.mountingDate = mountingDate;
    }

    public void setLamination(int lamination) {
        this.lamination = lamination;
    }

    public void setGarbage(int garbage) {
        this.garbage = garbage;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getFullOrderName() {
        return fullOrderName;
    }

    public int getInvno() {
        return invno;
    }

    public int getClnum() {
        return clnum;
    }

    public String getClient() {
        return client;
    }

    public String getAddress() {
        return address;
    }

    public String getContacts() {
        return contacts;
    }

    public String getMaster() {
        return master;
    }

    public int getConstructionsCount() {
        return constructionsCount;
    }

    public int getDelivery() {
        return delivery;
    }

    public int getMounting() {
        return mounting;
    }

    public int getDismantling() {
        return dismantling;
    }

    public String getMountingDate() {
        return mountingDate;
    }

    public int getLamination() {
        return lamination;
    }

    public int getGarbage() {
        return garbage;
    }

    public String getComment() {
        return comment;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public Map<String, Integer> getDifficultOrderMap() {
        return difficultOrderMap;
    }

    @Override
    public String toString() {
        String orderMap = "difficultOrderMap(size = " + difficultOrderMap.size() + "): ";
        for (String key : difficultOrderMap.keySet()) {
            orderMap += ("\r\n" + "datap = " + key + ", capacity = " + difficultOrderMap.get(key));
        }
        return "OrderEntity{" + "fullOrderName=" + fullOrderName + ", invno=" + invno + ", \r\n"
                + "clnum=" + clnum + ", client=" + client + ", address=" + address + ",  \r\n"
                + "contacts=" + contacts + ", constructionsCount=" + constructionsCount + ",  \r\n"
                + "capacity=" + capacity + ", delivery=" + delivery + ", mounting=" + mounting + ",  \r\n"
                + "dismantling=" + dismantling + ", master=" + master + ", mountingDate=" + mountingDate + ",  \r\n"
                + "productionDate=" + productionDate + ", lamination=" + lamination + ", garbage=" + garbage + ",  \r\n"
                + "comment=" + comment + ", description=" + description + ", \r\n" + orderMap + '}';
    }

    //обязательные поля
    private final String fullOrderName;             //номер заказа
    private final int invno;                        //идентификатор, необходимой для извлечения данных о конструкциях
    private final int clnum;                        //идентификатор, необходимый для извлечения данных о клиентах
    //изменяемые поля
    private String client = "не указано";
    private String address = "не указано";
    private String contacts = "не указано";
    //неизменяемые поля
    private int constructionsCount = 0;             //количество конструкций
    private int capacity = 0;                       //нагрузка заказа (в минутах)
    private int delivery = 0;                       //доставка
    private int mounting = 0;                       //монтаж
    private int dismantling = 0;                    //демонтаж
    private String master = "не указано";           //замерщик
    //данные, вводимые дилерами
    private String mountingDate = "НЕ УКАЗАНО";     //дата монтажа
    private String productionDate = "НЕ УКАЗАНО";   //дата производства
    private int lamination = 0;                     //ламинация
    private int garbage = 0;                        //вывоз мусора
    private String comment = "";                    //комментарии к заказу
    private String description = "";                //описание

    /**
     * Используется только для сложных (capacity > 720) заказов. Хранит в себе
     * распределение нагрузок по соответствующим датам производства в формате:
     * <datap, nagruz>. Эта таблица (карта) необходима для выполнения
     * SQL-запросов, во время экспорта заказа в отгрузку.
     */
    private final Map<String, Integer> difficultOrderMap = new TreeMap();
}
