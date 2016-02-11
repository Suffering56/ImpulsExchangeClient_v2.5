package impulsexchangeclient.menu;

import impulsexchangeclient.FrameMain;
import impulsexchangeclient.common.ExtendedDefaultTableModel;
import impulsexchangeclient.common.MonitorViewEntity;
import impulsexchangeclient.common.Service;
import impulsexchangeclient.mysql.MySqlViewHandler;
import java.beans.PropertyChangeEvent;
import java.util.Calendar;
import java.util.List;

public class FrameMonitorViewer extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchBtn = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jCalendar = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        closeBtn.setText("Закрыть окно");
        closeBtn.setFocusPainted(false);
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        closeBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generalKeyPressed(evt);
            }
        });

        jTable1.setModel(tableModel);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setFocusable(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        searchBtn.setText("Поиск заказа");
        searchBtn.setFocusPainted(false);
        searchBtn.setFocusable(false);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        searchBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generalKeyPressed(evt);
            }
        });

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        jCalendar.setFocusable(false);
        jCalendar.setWeekOfYearVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBtn)
                        .addGap(101, 101, 101))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBtn)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(closeBtn)))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public FrameMonitorViewer(FrameMain mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        setLocationRelativeTo(null);
        handler = new MySqlViewHandler();
        mainFrame.setEnabled(false);
        otherInit();
    }

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        List<MonitorViewEntity> resultList = handler.getQueryResult("SEARCH", searchField.getText().trim());
        int size = showResult(resultList);
        this.setTitle("Поиск по заказу: <" + searchField.getText() + ">. Найдено " + size + " совпадений");
        searchField.setText("");
    }//GEN-LAST:event_searchBtnActionPerformed

    private void jCalendarListener(PropertyChangeEvent evt) {
        if (isUserAction) {
            cal.setTime(jCalendar.getDate());
            String mDate = Service.convertToSqlDate(cal);
            List<MonitorViewEntity> resultList = handler.getQueryResult("CALENDAR", mDate);
            int size = showResult(resultList);
            this.setTitle("Поиск по дате монтажа: <" + mDate + ">. Найдено " + size + " совпадений");
        }
    }

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        if (evt.getKeyCode() == 10) {
            searchBtn.doClick();
        } else if (evt.getKeyCode() == 27) {
            closeBtn.doClick();
        }
    }//GEN-LAST:event_searchFieldKeyPressed

    private void generalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generalKeyPressed
        if (evt.getKeyCode() == 27) {
            closeBtn.doClick();
        }
    }//GEN-LAST:event_generalKeyPressed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        isUserAction = false;
        handler.closeConnection();
        mainFrame.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        isUserAction = false;
        handler.closeConnection();
        mainFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private int showResult(List<MonitorViewEntity> resultList) {
        tableModel.setRowCount(0);  //Очищаем предыдущие результаты
        int size = 0;
        if (resultList != null) {
            size = resultList.size();
            for (int i = 0; i < size; i++) {
                tableModel.insertRow(0, new Object[]{
                    resultList.get(i).getOrderName(),
                    resultList.get(i).getMountingDate(),
                    resultList.get(i).getAccessoriesStatus(),
                    resultList.get(i).getProductionStatus()
                });
            }
        }
        return size;
    }

    private void otherInit() {
        tableModel.addColumn("№ заказа");
        tableModel.addColumn("Дата монтажа");
        tableModel.addColumn("Комплектация");
        tableModel.addColumn("Производство");
        tableModel.setRowCount(0);
        searchField.requestFocusInWindow();
        cal = Calendar.getInstance();
        isUserAction = true;
        jCalendar.getDayChooser().addPropertyChangeListener(this::jCalendarListener);
    }

    private Calendar cal;
    private final FrameMain mainFrame;
    private final MySqlViewHandler handler;
    private final ExtendedDefaultTableModel tableModel = new ExtendedDefaultTableModel();

    /**
     * Нужна для избежания ошибки, которая возникала при закрытии фрейма.
     * Почему-то после всех событий formWindowClosing вызывалось событие
     * JCalendar.PropertyChange, и программа пыталась выполнить запрос к БД,
     * после вызова disconnect(), что приводило к ошибке SQL.
     */
    private boolean isUserAction;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
