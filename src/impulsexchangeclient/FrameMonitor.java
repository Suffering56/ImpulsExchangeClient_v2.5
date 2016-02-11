package impulsexchangeclient;

import impulsexchangeclient.common.MountingDateFilter;
import impulsexchangeclient.common.Service;
import impulsexchangeclient.common.EnabledJComboBoxRenderer;
import impulsexchangeclient.common.OrderEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;

public class FrameMonitor extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        laminationBox = new javax.swing.JCheckBox();
        garbageBox = new javax.swing.JCheckBox();
        dateLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        commentArea = new javax.swing.JTextArea();
        descriptionLabel = new javax.swing.JLabel();
        commentLabel = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        okBtn = new javax.swing.JButton();
        mountingDateComboBox = new javax.swing.JComboBox();
        fullOrderNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        constructionsCountField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        masterField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        isMountingField = new javax.swing.JTextField();
        isDismantlingField = new javax.swing.JTextField();
        isDeliveryField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        contactsField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        clientField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Экспорт в отгрузку");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        laminationBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        laminationBox.setText("Ламинация");
        laminationBox.setFocusPainted(false);
        laminationBox.setFocusable(false);

        garbageBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        garbageBox.setText("Вывоз мусора");
        garbageBox.setFocusPainted(false);
        garbageBox.setFocusable(false);

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Дата монтажа: ");
        dateLabel.setFocusable(false);

        descriptionArea.setColumns(20);
        descriptionArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descriptionAreaKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(descriptionArea);

        commentArea.setColumns(20);
        commentArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                commentAreaKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(commentArea);

        descriptionLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptionLabel.setText("Описание заказа:");
        descriptionLabel.setFocusable(false);

        commentLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        commentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        commentLabel.setText("Комментарии к заказу:");
        commentLabel.setFocusable(false);

        cancelBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cancelBtn.setText("Отмена");
        cancelBtn.setFocusPainted(false);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        cancelBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                activeFieldKeyPressed(evt);
            }
        });

        okBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        okBtn.setText("Готово");
        okBtn.setFocusPainted(false);
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        okBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                activeFieldKeyPressed(evt);
            }
        });

        mountingDateComboBox.setMaximumRowCount(15);
        mountingDateComboBox.setFocusable(false);
        mountingDateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mountingDateComboBoxActionPerformed(evt);
            }
        });

        fullOrderNameField.setEditable(false);
        fullOrderNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fullOrderNameField.setToolTipText("");
        fullOrderNameField.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Номер заказа:");
        jLabel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Кол-во конструкций:");
        jLabel2.setFocusable(false);

        constructionsCountField.setEditable(false);
        constructionsCountField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        constructionsCountField.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Замерщик:");
        jLabel3.setFocusable(false);

        masterField.setEditable(false);
        masterField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        masterField.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Доставка:");
        jLabel4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Демонтаж:");
        jLabel5.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Монтаж:");
        jLabel6.setFocusable(false);

        isMountingField.setEditable(false);
        isMountingField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        isMountingField.setFocusable(false);

        isDismantlingField.setEditable(false);
        isDismantlingField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        isDismantlingField.setFocusable(false);

        isDeliveryField.setEditable(false);
        isDeliveryField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        isDeliveryField.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Клиент:");
        jLabel7.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Адрес:");
        jLabel8.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Контакты:");
        jLabel9.setFocusable(false);

        contactsField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contactsField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                activeFieldKeyPressed(evt);
            }
        });

        addressField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                activeFieldKeyPressed(evt);
            }
        });

        clientField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clientField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                activeFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(mountingDateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(laminationBox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(garbageBox, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(commentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(fullOrderNameField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(constructionsCountField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(masterField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(addressField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(clientField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                            .addComponent(contactsField, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(isDeliveryField))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(isDismantlingField, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                    .addComponent(isMountingField))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {garbageBox, laminationBox});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel7, jLabel8, jLabel9});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {isDeliveryField, isDismantlingField, isMountingField});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {constructionsCountField, fullOrderNameField, masterField});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelBtn, commentLabel, descriptionLabel, jScrollPane3, jScrollPane4, okBtn});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dateLabel, mountingDateComboBox});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(fullOrderNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(masterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(constructionsCountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel8)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(contactsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(isMountingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(isDismantlingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(isDeliveryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mountingDateComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descriptionLabel)
                            .addComponent(commentLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(laminationBox, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(garbageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okBtn)
                    .addComponent(cancelBtn))
                .addGap(12, 12, 12))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelBtn, okBtn});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dateLabel, garbageBox, laminationBox, mountingDateComboBox});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {constructionsCountField, fullOrderNameField, jLabel1, jLabel2, jLabel3, masterField});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {isDeliveryField, isDismantlingField, isMountingField, jLabel4, jLabel5, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addressField, clientField, contactsField, jLabel7, jLabel8, jLabel9});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public FrameMonitor(FrameMain mainFrame, OrderEntity entity) {
        this.mainFrame = mainFrame;
        this.entity = entity;
        mFilter = new MountingDateFilter(entity.getCapacity());
        if (mFilter.getCapacitiesMap() != null) {
            initComponents();
            setLocationRelativeTo(null);
            readData();
            comboBoxInit();
            fullOrderNameField.setToolTipText("Нагрузка: " + String.valueOf(entity.getCapacity())
                    + " (Необходимо дней: " + orderReqDays + ")"
            );
            clientField.requestFocusInWindow();
        } else {    //если возникла ошибка при работе с MySQL
            mainFrame.setEnabled(true);
            this.dispose();
        }
    }

    /**
     * Инициализация элементов списка дат монтажа. Вычисление, какие даты будут
     * доступны для выбора пользователем, а какие сделать неактивными.
     */
    private void comboBoxInit() {
        orderReqDays = Service.extractOrderReqDays(entity.getCapacity());
        mCalendarList.clear();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,
                Service.MINIMAL_DATE_OFFSET + orderReqDays);                    //смещаемся на первую доступную дату монтажа

        for (int i = 0; i < Service.MONTH_DURATION; i++) {
            mountingDateComboBox.addItem(new Formatter().format("%1$td-%1$tB-%1$tY(%1$tA)", calendar).toString());
            mCalendarList.add((Calendar) calendar.clone());
            if (mFilter.mountingDateValidation(calendar)) {
                enabledItemIndexes.add(i);
                renderModel.addSelectionInterval(i, i);
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        EnabledJComboBoxRenderer enableRenderer = new EnabledJComboBoxRenderer(renderModel);
        mountingDateComboBox.setRenderer(enableRenderer);
        mountingDateComboBox.setSelectedIndex(-1);
    }

    /**
     * Установка выбранной даты монтажа для дальнейшего экспорта в отгрузку, а
     * вместе с ней установка соответствующей даты производства или списка дат
     * производства (в зависимости от сложности заказа).
     */
    private void applyEntityDates() {
        Calendar mountCalendar = (Calendar) mCalendarList.get(mountingDateComboBox.getSelectedIndex()).clone();
        entity.setMountingDate(Service.convertToSqlDate(mountCalendar));
        capacitiesMap = mFilter.getCapacitiesMap();
        entity.getDifficultOrderMap().clear();
        String pDate;
        if (orderReqDays > 1) {
            int totalRemaining = entity.getCapacity();
            mountCalendar.add(Calendar.DAY_OF_MONTH, -orderReqDays);
            for (int i = 0; i < orderReqDays; i++) {
                pDate = Service.convertToSqlDate(mountCalendar);
                int remaining = Service.getDailyBalance(pDate, capacitiesMap);
                if (totalRemaining < remaining) {
                    entity.getDifficultOrderMap().put(pDate, totalRemaining);
                } else {
                    entity.getDifficultOrderMap().put(pDate, remaining);
                }
                Service.addInternalItem(pDate, entity.getDifficultOrderMap().get(pDate));
                mountCalendar.add(Calendar.DAY_OF_MONTH, 1);                    //смещаемся на следующий день производства
                totalRemaining -= remaining;
            }
        } else if (orderReqDays == 0) {
        } else {
            if (mountCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {   //выборка даты для datam == ПОНЕДЕЛЬНИК
                mountCalendar.add(Calendar.DAY_OF_MONTH, -2);                   //смещаемся на СУББОТУ
                pDate = Service.convertToSqlDate(mountCalendar);
                if (Service.getDailyBalance(pDate, capacitiesMap) < entity.getCapacity()) {
                    mountCalendar.add(Calendar.DAY_OF_MONTH, +1);               //смещаемся на ВОСКРЕСЕНЬЕ
                    pDate = Service.convertToSqlDate(mountCalendar);
                }
            } else {
                mountCalendar.add(Calendar.DAY_OF_MONTH, -1);
                pDate = Service.convertToSqlDate(mountCalendar);
            }
            entity.setProductionDate(pDate);
            Service.addInternalItem(entity.getProductionDate(), entity.getCapacity());
        }
    }

    /**
     * Установка остальных значений, вводимых/измененных пользователем, для их
     * экспорта в отгрузку.
     */
    private void applyOtherValues() {
        entity.setClient(clientField.getText());
        entity.setAddress(addressField.getText());
        entity.setContacts(contactsField.getText());

        entity.setLamination(reverseBoolConvert(laminationBox.isSelected()));
        entity.setGarbage(reverseBoolConvert(garbageBox.isSelected()));

        entity.setDescription(descriptionArea.getText());
        entity.setComment(commentArea.getText());
    }

    /**
     * Установка полученной из базы СуперОкна информации в соответствующие
     * элементы фрейма.
     */
    private void readData() {
        fullOrderNameField.setText(entity.getFullOrderName());
        masterField.setText(entity.getMaster());
        constructionsCountField.setText(String.valueOf(entity.getConstructionsCount()));

        clientField.setText(entity.getClient());
        addressField.setText(entity.getAddress());
        contactsField.setText(entity.getContacts());

        isMountingField.setText(convert(entity.getMounting()));
        isDismantlingField.setText(convert(entity.getDismantling()));
        isDeliveryField.setText(convert(entity.getDelivery()));
    }

    private String convert(int value) {
        if (value == 1) {
            return "Да";
        } else {
            return "Нет";
        }
    }

    private int reverseBoolConvert(boolean value) {
        if (value == true) {
            return 1;
        } else {
            return 0;
        }
    }

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        if (mountingDateComboBox.getSelectedIndex() != -1) {
            applyEntityDates();
            applyOtherValues();
            mainFrame.getExportOrdersModel().addElement(entity.getFullOrderName()); //<-добавляем заказ в список на экспорт
            mainFrame.getMonitorEntityList().add(entity);                           //<-добавляем заказ для дальнейшей отгрузки (monitor)
            mainFrame.setEnabled(true);                                             //<-активируем mainFrame
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Выберите дату монтажа.");
        }
    }//GEN-LAST:event_okBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        mainFrame.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        mainFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void mountingDateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mountingDateComboBoxActionPerformed
        if (!enabledItemIndexes.contains(mountingDateComboBox.getSelectedIndex())) {
            mountingDateComboBox.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_mountingDateComboBoxActionPerformed

    private void activeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_activeFieldKeyPressed
        if (evt.getKeyCode() == 27) {
            cancelBtn.doClick();
        }
    }//GEN-LAST:event_activeFieldKeyPressed

    private void descriptionAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionAreaKeyPressed
        if (evt.getKeyCode() == 27) {
            cancelBtn.doClick();
        } else if (evt.getKeyCode() == 9) {
            commentArea.requestFocusInWindow();
        }
    }//GEN-LAST:event_descriptionAreaKeyPressed

    private void commentAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_commentAreaKeyPressed
        if (evt.getKeyCode() == 27) {
            cancelBtn.doClick();
        } else if (evt.getKeyCode() == 9) {
            clientField.requestFocusInWindow();
        }
    }//GEN-LAST:event_commentAreaKeyPressed

    private final FrameMain mainFrame;
    private final OrderEntity entity;
    private final MountingDateFilter mFilter;
    private final DefaultListSelectionModel renderModel = new DefaultListSelectionModel();
    private final Set<Integer> enabledItemIndexes = new HashSet<>();
    private final ArrayList<Calendar> mCalendarList = new ArrayList<>();
    private Map<String, Integer> capacitiesMap;
    private int orderReqDays = 0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField clientField;
    private javax.swing.JTextArea commentArea;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JTextField constructionsCountField;
    private javax.swing.JTextField contactsField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField fullOrderNameField;
    private javax.swing.JCheckBox garbageBox;
    private javax.swing.JTextField isDeliveryField;
    private javax.swing.JTextField isDismantlingField;
    private javax.swing.JTextField isMountingField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JCheckBox laminationBox;
    private javax.swing.JTextField masterField;
    private javax.swing.JComboBox mountingDateComboBox;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables
}
