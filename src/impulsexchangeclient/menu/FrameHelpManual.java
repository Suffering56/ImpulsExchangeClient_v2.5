package impulsexchangeclient.menu;

import impulsexchangeclient.FrameMain;

public class FrameHelpManual extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Справка");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(249, 249, 249));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(5);
        jTextArea1.setText("\tДля того, чтобы отправить заказ, нажмите кнопку \"Добавить новый заказ\". Откроется новое окно. Введите номер заказа в соответствующее поле (без номера отдела и символа \"/\"). \n\tЕсли данные о заказе не нужно отправлять в \"Отгрузку\", то установите соответствующую 'галочку' в активное положение.\n\tЕсли все-таки нужно отправлять заказ в \"Отгрузку\", то просто нажмите кнопку \"Далее\". На экране появится новое окно с данными об указанном заказе, взятые из базы программы \"СуперОкна\". Информацию о клиенте можно изменить. Обязательно нужно выбрать дату монтажа из выпадающего списка. Так же можно указать дополнительную информацию (описание заказа, комментарий, ламинация, вывоз мусора).\n\tЕсли все необходимые данные были заполнены, вы можете нажать кнопку \"Готово\". Заказ готов, для отправки. Вы так же можете добавить еще несколько заказов, чтобы не отправлять их по-одному.\n\tКогда все заказы были добавлены, нужно будет нажать на кнопку \"Отправить на сервер\". По окончании операции должно отобразиться сообщение \"Завершено!\". Это означает, что все заказы были отправлены в главный отдел, и добавлены в отгрузку (если этого требовалось).");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setMargin(new java.awt.Insets(7, 7, 7, 7));
        jTextArea1.setSelectionColor(new java.awt.Color(249, 249, 249));
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generalKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Руководство по использованию");
        jLabel1.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jScrollPane1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public FrameHelpManual(FrameMain mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        mainFrame.setEnabled(false);
        setLocationRelativeTo(null);
        jTextArea1.requestFocusInWindow();
    }

    private void generalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generalKeyPressed
        if (evt.getKeyCode() == 27) {
            mainFrame.setEnabled(true);
            this.dispose();
        }
    }//GEN-LAST:event_generalKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        mainFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private final FrameMain mainFrame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
