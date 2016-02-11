package impulsexchangeclient.menu;

import impulsexchangeclient.common.Options;
import impulsexchangeclient.common.OptionsHandler;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameOptionsAdmin extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        newPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Смена пароля");
        setName("optionsFrame"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Введите новый пароль:");
        jLabel5.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Подтверждение пароля:");
        jLabel6.setFocusable(false);

        cancelBtn.setText("Отмена");
        cancelBtn.setFocusPainted(false);
        cancelBtn.setFocusable(false);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Сохранить");
        saveBtn.setFocusPainted(false);
        saveBtn.setFocusable(false);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        newPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newPasswordFieldKeyPressed(evt);
            }
        });

        confirmPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmPasswordFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPasswordField)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newPasswordField))
                .addGap(24, 24, 24))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {confirmPasswordField, jLabel5, jLabel6, newPasswordField});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(saveBtn))
                .addGap(12, 12, 12))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {confirmPasswordField, jLabel5, jLabel6, newPasswordField});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public FrameOptionsAdmin(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        setLocationRelativeTo(null);
        mainFrame.setEnabled(false);
        newPasswordField.requestFocusInWindow();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        mainFrame.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        mainFrame.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (newPasswordField.getText().equals(confirmPasswordField.getText())) {
            Options.setAdminPassword(newPasswordField.getText());
            OptionsHandler.saveOptions("ADMIN");
            mainFrame.setEnabled(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Введенные пароли не совпадают!");
            newPasswordField.setText("");
            confirmPasswordField.setText("");
            newPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void newPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPasswordFieldKeyPressed
        if (evt.getKeyCode() == 10) {
            confirmPasswordField.requestFocusInWindow();
        } else if (evt.getKeyCode() == 27) {
            cancelBtn.doClick();
        }
    }//GEN-LAST:event_newPasswordFieldKeyPressed

    private void confirmPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordFieldKeyPressed
        if (evt.getKeyCode() == 10) {
            saveBtn.doClick();
        } else if (evt.getKeyCode() == 27) {
            cancelBtn.doClick();
        }
    }//GEN-LAST:event_confirmPasswordFieldKeyPressed

    private final JFrame mainFrame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
