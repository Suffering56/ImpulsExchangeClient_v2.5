package impulsexchangeclient;

import impulsexchangeclient.common.OrderEntity;
import impulsexchangeclient.common.Options;
import impulsexchangeclient.common.Service;
import impulsexchangeclient.menu.FrameArchive;
import impulsexchangeclient.menu.FrameSearch;
import impulsexchangeclient.menu.FrameHelpManual;
import impulsexchangeclient.menu.FrameAccessOptions;
import impulsexchangeclient.menu.FrameMonitorViewer;
import impulsexchangeclient.mysql.MySqlSender;
import impulsexchangeclient.ftp.FTPExportPreLauncher;
import impulsexchangeclient.menu.FrameHelpAdditional;
import impulsexchangeclient.menu.FrameHelpErrors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class FrameMain extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addOrderBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jOrdersList = new javax.swing.JList();
        deleteOrderBtn = new javax.swing.JButton();
        toExportBtn = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        departmentOptionsCallBtn = new javax.swing.JMenuItem();
        ftpOptionsCallBtn = new javax.swing.JMenuItem();
        firebirdOptionsCallBtn = new javax.swing.JMenuItem();
        mySqlOptionsCallBtn = new javax.swing.JMenuItem();
        adminOptionsCallBtn = new javax.swing.JMenuItem();
        exitMenuBtn = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        monitorViewerCallBtn = new javax.swing.JMenuItem();
        archivesMenu = new javax.swing.JMenu();
        archiveCallBtn = new javax.swing.JMenuItem();
        doSearchBtn = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpManualCallBtn = new javax.swing.JMenuItem();
        helpAdditionalCallBtn = new javax.swing.JMenuItem();
        helpErrorsCallBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusable(false);
        setName("mainFrame"); // NOI18N
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        addOrderBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addOrderBtn.setText("Добавить новый заказ");
        addOrderBtn.setFocusPainted(false);
        addOrderBtn.setPreferredSize(new java.awt.Dimension(151, 21));
        addOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderBtnActionPerformed(evt);
            }
        });
        addOrderBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generalKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Заказы:");
        jLabel2.setAlignmentX(0.5F);
        jLabel2.setFocusable(false);

        jOrdersList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jOrdersList.setModel(exportOrdersModel);
        jOrdersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jOrdersList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generalKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jOrdersList);

        deleteOrderBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteOrderBtn.setText("Убрать выделенный заказ");
        deleteOrderBtn.setFocusPainted(false);
        deleteOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderBtnActionPerformed(evt);
            }
        });
        deleteOrderBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generalKeyPressed(evt);
            }
        });

        toExportBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        toExportBtn.setText("Отправить на сервер");
        toExportBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toExportBtn.setFocusPainted(false);
        toExportBtn.setPreferredSize(new java.awt.Dimension(151, 23));
        toExportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toExportBtnActionPerformed(evt);
            }
        });
        toExportBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generalKeyPressed(evt);
            }
        });

        progressBar.setToolTipText("");
        progressBar.setFocusable(false);
        progressBar.setStringPainted(true);

        mainMenu.setText("Главное меню");

        departmentOptionsCallBtn.setText("Настройки отдела");
        departmentOptionsCallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentOptionsCallBtnActionPerformed(evt);
            }
        });
        mainMenu.add(departmentOptionsCallBtn);

        ftpOptionsCallBtn.setText("Настройки FTP");
        ftpOptionsCallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftpOptionsCallBtnActionPerformed(evt);
            }
        });
        mainMenu.add(ftpOptionsCallBtn);

        firebirdOptionsCallBtn.setText("Настройки Firebird");
        firebirdOptionsCallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firebirdOptionsCallBtnActionPerformed(evt);
            }
        });
        mainMenu.add(firebirdOptionsCallBtn);

        mySqlOptionsCallBtn.setText("Настройки MySQL");
        mySqlOptionsCallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mySqlOptionsCallBtnActionPerformed(evt);
            }
        });
        mainMenu.add(mySqlOptionsCallBtn);

        adminOptionsCallBtn.setText("Настройки администратора");
        adminOptionsCallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminOptionsCallBtnActionPerformed(evt);
            }
        });
        mainMenu.add(adminOptionsCallBtn);

        exitMenuBtn.setText("Выход");
        exitMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuBtnActionPerformed(evt);
            }
        });
        mainMenu.add(exitMenuBtn);

        jMenuBar1.add(mainMenu);

        jMenu1.setText("Отгрузка");

        monitorViewerCallBtn.setText("Просмотр готовности заказов");
        monitorViewerCallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitorViewerCallBtnActionPerformed(evt);
            }
        });
        jMenu1.add(monitorViewerCallBtn);

        jMenuBar1.add(jMenu1);

        archivesMenu.setText("Архив");

        archiveCallBtn.setText("Последние 25 заказов");
        archiveCallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archiveCallBtnActionPerformed(evt);
            }
        });
        archivesMenu.add(archiveCallBtn);

        doSearchBtn.setText("Поиск по заказам");
        doSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doSearchBtnActionPerformed(evt);
            }
        });
        archivesMenu.add(doSearchBtn);

        jMenuBar1.add(archivesMenu);

        helpMenu.setText("Справка");

        helpManualCallBtn.setText("Руководство по использованию");
        helpManualCallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpManualCallBtnActionPerformed(evt);
            }
        });
        helpMenu.add(helpManualCallBtn);

        helpAdditionalCallBtn.setText("Дополнительные функции");
        helpAdditionalCallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpAdditionalCallBtnActionPerformed(evt);
            }
        });
        helpMenu.add(helpAdditionalCallBtn);

        helpErrorsCallBtn.setText("Возможные ошибки");
        helpErrorsCallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpErrorsCallBtnActionPerformed(evt);
            }
        });
        helpMenu.add(helpErrorsCallBtn);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteOrderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(addOrderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toExportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jScrollPane2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addOrderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(deleteOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(toExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public FrameMain() {
        initComponents();
        setLocationRelativeTo(null);
        addOrderBtn.requestFocusInWindow();
    }

    private void addOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderBtnActionPerformed
        new FrameNewOrder(this).setVisible(true);
    }//GEN-LAST:event_addOrderBtnActionPerformed

    private void deleteOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderBtnActionPerformed
        if (jOrdersList.getSelectedIndex() != -1) {
            String deletedOrderName = exportOrdersModel.remove(jOrdersList.getSelectedIndex());
            //удаляем данные для экспорта в отгрузку
            for (OrderEntity entity : monitorEntityList) {
                if (entity.getFullOrderName().equals(deletedOrderName)) {
                    deletingInternalItems(entity);
                    monitorEntityList.remove(entity);
                    break;
                }
            }
        }
    }//GEN-LAST:event_deleteOrderBtnActionPerformed

    /**
     * В случае ручного удаления пользователем заказа (кнопка "Убрать выделенный
     * заказ") данная функция производит корректное удаление всех данных,
     * связанных с этим заказом из буфера программы, чтобы при последующих
     * расчетах этот заказ не учитывался.
     *
     * @param entity данные об удаляемом заказе.
     */
    private void deletingInternalItems(OrderEntity entity) {
        Map<String, Integer> difficultMap = entity.getDifficultOrderMap();
        if (!entity.getDifficultOrderMap().isEmpty()) {
            for (String key : difficultMap.keySet()) {
                int value = difficultMap.get(key);
                Service.deleteInternalItem(key, value);
            }
        } else {
            Service.deleteInternalItem(entity.getProductionDate(), entity.getCapacity());
        }
    }

    private void toExportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toExportBtnActionPerformed
        if (!exportOrdersModel.isEmpty()) {
            if (Service.preScreeningFTP()) {   //<-предварительная проверка соединения с FTP
                //экспорт в отгрузку
                MySqlSender sender = new MySqlSender(monitorEntityList);
                boolean isSuccesfulExport = sender.runTransaction();
                if (isSuccesfulExport) {
                    Service.INTERNAL_CAPACITIES_MAP.clear();
                    monitorEntityList.clear();
                    //запуск экспорта на FTP
                    FTPExportPreLauncher launcher = new FTPExportPreLauncher(progressBar, exportOrdersModel);
                    launcher.runExport();
                } else {
                    progressBar.setString("Ошибка!");
                }
            }   //else не нужен
        } else {
            JOptionPane.showMessageDialog(null, "Вы не добавили в список ни одного заказа!");
        }
    }//GEN-LAST:event_toExportBtnActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.setTitle("Отдел № " + Options.getDepartmentName());
    }//GEN-LAST:event_formWindowGainedFocus

    private void archiveCallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archiveCallBtnActionPerformed
        new FrameArchive(this).setVisible(true);
    }//GEN-LAST:event_archiveCallBtnActionPerformed

    private void doSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doSearchBtnActionPerformed
        new FrameSearch(this).setVisible(true);
    }//GEN-LAST:event_doSearchBtnActionPerformed

    private void departmentOptionsCallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentOptionsCallBtnActionPerformed
        new FrameAccessOptions(this, "Department").setVisible(true);
    }//GEN-LAST:event_departmentOptionsCallBtnActionPerformed

    private void ftpOptionsCallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftpOptionsCallBtnActionPerformed
        new FrameAccessOptions(this, "FTP").setVisible(true);
    }//GEN-LAST:event_ftpOptionsCallBtnActionPerformed

    private void firebirdOptionsCallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firebirdOptionsCallBtnActionPerformed
        new FrameAccessOptions(this, "Firebird").setVisible(true);
    }//GEN-LAST:event_firebirdOptionsCallBtnActionPerformed

    private void mySqlOptionsCallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mySqlOptionsCallBtnActionPerformed
        new FrameAccessOptions(this, "MySQL").setVisible(true);
    }//GEN-LAST:event_mySqlOptionsCallBtnActionPerformed

    private void exitMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuBtnActionPerformed

    private void generalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generalKeyPressed
        if (evt.getKeyCode() == 10) {
            addOrderBtn.doClick();
        } else if ((evt.getKeyCode() == 127) || (evt.getKeyCode() == 110)) {
            deleteOrderBtn.doClick();
        }
    }//GEN-LAST:event_generalKeyPressed

    private void monitorViewerCallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitorViewerCallBtnActionPerformed
        new FrameMonitorViewer(this).setVisible(true);
    }//GEN-LAST:event_monitorViewerCallBtnActionPerformed

    private void helpManualCallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpManualCallBtnActionPerformed
        new FrameHelpManual(this).setVisible(true);
    }//GEN-LAST:event_helpManualCallBtnActionPerformed

    private void helpAdditionalCallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAdditionalCallBtnActionPerformed
        new FrameHelpAdditional(this).setVisible(true);
    }//GEN-LAST:event_helpAdditionalCallBtnActionPerformed

    private void helpErrorsCallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpErrorsCallBtnActionPerformed
        new FrameHelpErrors(this).setVisible(true);
    }//GEN-LAST:event_helpErrorsCallBtnActionPerformed

    private void adminOptionsCallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminOptionsCallBtnActionPerformed
        new FrameAccessOptions(this, "ADMIN").setVisible(true);
    }//GEN-LAST:event_adminOptionsCallBtnActionPerformed

    public DefaultListModel getExportOrdersModel() {
        return exportOrdersModel;
    }

    public List<OrderEntity> getMonitorEntityList() {
        return monitorEntityList;
    }

    private final DefaultListModel<String> exportOrdersModel = new DefaultListModel();
    private final List<OrderEntity> monitorEntityList = new ArrayList<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOrderBtn;
    private javax.swing.JMenuItem adminOptionsCallBtn;
    private javax.swing.JMenuItem archiveCallBtn;
    private javax.swing.JMenu archivesMenu;
    private javax.swing.JButton deleteOrderBtn;
    private javax.swing.JMenuItem departmentOptionsCallBtn;
    private javax.swing.JMenuItem doSearchBtn;
    private javax.swing.JMenuItem exitMenuBtn;
    private javax.swing.JMenuItem firebirdOptionsCallBtn;
    private javax.swing.JMenuItem ftpOptionsCallBtn;
    private javax.swing.JMenuItem helpAdditionalCallBtn;
    private javax.swing.JMenuItem helpErrorsCallBtn;
    private javax.swing.JMenuItem helpManualCallBtn;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JList jOrdersList;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenuItem monitorViewerCallBtn;
    private javax.swing.JMenuItem mySqlOptionsCallBtn;
    public javax.swing.JProgressBar progressBar;
    private javax.swing.JButton toExportBtn;
    // End of variables declaration//GEN-END:variables
}
