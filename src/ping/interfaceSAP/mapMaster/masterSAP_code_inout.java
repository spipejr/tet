/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.mapMaster;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import ping.interfaceSAP.eventFocus;
import ping.interfaceSAP.formatDateNum;
import ping.interfaceSAP.showMessage;
import ping.interfaceSAP.utilitySAP;
import utilititiesfunction.UserLogin;

/**
 *
 * @author soneping
 */
public class masterSAP_code_inout extends javax.swing.JDialog {

    /**
     * Creates new form masterSAP_code_inout
     */
    DefaultTableModel model;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String user = UserLogin.userlogin.getUserName();
    private String sap_code;
    private String sap_name;
    private String sap_createuser = user;
    private String sap_createdate;
    private String sap_createtime;
    private String sap_type = "OUT";
    formatDateNum fdn = new formatDateNum();
    showMessage msn = new showMessage();
    utilitySAP us = new utilitySAP();
    eventFocus ef = new eventFocus();

    public masterSAP_code_inout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        model = us.setTable(jTable1, "0,1,3", "2", "");
        clearForm();

        ef.setMaxKeyChar(txtCode, 5);
        ef.setMaxKeyChar(txtName, 50);
        ef.setFocusSwing(txtCode);
        ef.setFocusSwing(txtName);

//        btn_print.setVisible(false);
    }

    private void closePS(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
                ps = null;
            }
        } catch (Exception e) {
        }
    }

    private void closeRS(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        r_in = new javax.swing.JRadioButton();
        r_out = new javax.swing.JRadioButton();
        r_branch = new javax.swing.JRadioButton();
        r_dept = new javax.swing.JRadioButton();
        r_nonactive = new javax.swing.JRadioButton();
        r_active = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_createNew = new javax.swing.JMenuItem();
        menuu_cancle = new javax.swing.JMenuItem();
        menu_save = new javax.swing.JMenuItem();
        menu_remove = new javax.swing.JMenuItem();
        menu_exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("แฟ้มข้อมูลประเภทการโอนภายใน (SAP Code Setup)");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_add.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add-icon.png"))); // NOI18N
        btn_add.setText("เพิ่ม");
        btn_add.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_add.setIconTextGap(3);
        btn_add.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_cancel.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel-icon.png"))); // NOI18N
        btn_cancel.setText("ยกเลิก");
        btn_cancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cancel.setIconTextGap(3);
        btn_cancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_save.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save-icon.png"))); // NOI18N
        btn_save.setText("บันทึก");
        btn_save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_save.setIconTextGap(3);
        btn_save.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_del.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btn_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete-icons.png"))); // NOI18N
        btn_del.setText("ลบ");
        btn_del.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_del.setIconTextGap(3);
        btn_del.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_exit.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Close-Program-icon .png"))); // NOI18N
        btn_exit.setText("Exit");
        btn_exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_exit.setIconTextGap(3);
        btn_exit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "รหัส", "คำอธิบาย", "ประเภท", "ภายใน/หน่วยงาน", "Active", "ผู้สร้าง"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(75);
        }

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("รหัส");

        jLabel2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("คำอธิบาย");

        txtCode.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        txtCode.setText("ZE10");
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeKeyPressed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        txtName.setText("ZE10");

        jLabel3.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ประเภท");

        buttonGroup1.add(r_in);
        r_in.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        r_in.setText("รับเข้า");

        buttonGroup1.add(r_out);
        r_out.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        r_out.setText("จ่ายออก");

        buttonGroup2.add(r_branch);
        r_branch.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        r_branch.setText("โอนภายในสาขา");

        buttonGroup2.add(r_dept);
        r_dept.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        r_dept.setText("โอนหน่วยงาน");

        buttonGroup3.add(r_nonactive);
        r_nonactive.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        r_nonactive.setText("Non Active");

        buttonGroup3.add(r_active);
        r_active.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        r_active.setText("Active");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r_branch)
                            .addComponent(r_in)
                            .addComponent(r_active))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r_out)
                            .addComponent(r_dept)
                            .addComponent(r_nonactive))))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(r_in)
                    .addComponent(r_out))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_branch)
                    .addComponent(r_dept))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_active)
                    .addComponent(r_nonactive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("ฟังก์ชันการทำงาน");
        jMenu1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N

        menu_createNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menu_createNew.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        menu_createNew.setText("เพิ่ม (Create New)");
        menu_createNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_createNewActionPerformed(evt);
            }
        });
        jMenu1.add(menu_createNew);

        menuu_cancle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuu_cancle.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        menuu_cancle.setText("ยกเลิก (Cancle)");
        menuu_cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuu_cancleActionPerformed(evt);
            }
        });
        jMenu1.add(menuu_cancle);

        menu_save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menu_save.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        menu_save.setText("บันทึก (Save)");
        menu_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_saveActionPerformed(evt);
            }
        });
        jMenu1.add(menu_save);

        menu_remove.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menu_remove.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        menu_remove.setText("ลบ (Remove)");
        menu_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_removeActionPerformed(evt);
            }
        });
        jMenu1.add(menu_remove);

        menu_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menu_exit.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        menu_exit.setText("ออกจากระบบ");
        menu_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_exitActionPerformed(evt);
            }
        });
        jMenu1.add(menu_exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_createNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_createNewActionPerformed
        btn_addActionPerformed(null);
    }//GEN-LAST:event_menu_createNewActionPerformed

    private void menuu_cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuu_cancleActionPerformed
        btn_cancelActionPerformed(null);
    }//GEN-LAST:event_menuu_cancleActionPerformed

    private void menu_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_saveActionPerformed
        btn_saveActionPerformed(null);
    }//GEN-LAST:event_menu_saveActionPerformed

    private void menu_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_removeActionPerformed
        btn_delActionPerformed(null);
    }//GEN-LAST:event_menu_removeActionPerformed

    private void menu_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_exitActionPerformed
        btn_exitActionPerformed(null);
    }//GEN-LAST:event_menu_exitActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        btnSave();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        btnDel();
    }//GEN-LAST:event_btn_delActionPerformed

    private void txtCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyPressed
        this.sap_code = txtCode.getText().trim();
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (this.sap_code.length() > 0) {
                seek();
            }
        }
    }//GEN-LAST:event_txtCodeKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            int row = jTable1.getSelectedRow();
            int column = 0;
            txtCode.setText(jTable1.getValueAt(row, column).toString());
            seek();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(masterSAP_code_inout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(masterSAP_code_inout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(masterSAP_code_inout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(masterSAP_code_inout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                masterSAP_code_inout dialog = new masterSAP_code_inout(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_save;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem menu_createNew;
    private javax.swing.JMenuItem menu_exit;
    private javax.swing.JMenuItem menu_remove;
    private javax.swing.JMenuItem menu_save;
    private javax.swing.JMenuItem menuu_cancle;
    private javax.swing.JRadioButton r_active;
    private javax.swing.JRadioButton r_branch;
    private javax.swing.JRadioButton r_dept;
    private javax.swing.JRadioButton r_in;
    private javax.swing.JRadioButton r_nonactive;
    private javax.swing.JRadioButton r_out;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void clearForm() {
//        btn_print.setVisible(false);

        btn_add.setFocusable(false);
        btn_cancel.setFocusable(false);
        btn_save.setFocusable(false);
        btn_del.setFocusable(false);
//        btn_print.setFocusable(false);
        btn_exit.setFocusable(false);
        r_in.setFocusable(false);
        r_out.setFocusable(false);
        r_branch.setFocusable(false);
        r_dept.setFocusable(false);
        r_active.setFocusable(false);
        r_nonactive.setFocusable(false);
        us.resetTable(model);

        String sql = "SELECT * FROM sap_mastercode_inout order by sap_trantype,sap_code";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    String sap_TranType = "" ;
                    if (rs.getString("sap_trantype").equals("B")) {
                           sap_TranType =  "โอนภายในสาขา" ;
                        } else {
                            sap_TranType = "โอนหน่วยงาน" ;
                        }
                    model.addRow(new Object[]{
                        rs.getString("sap_code"),
                        rs.getString("sap_name"),
                        rs.getString("sap_type"),
                        sap_TranType ,
                        rs.getString("sap_active"),
                        rs.getString("sap_createuser")
                    });
                } while (rs.next());
            }
        } catch (Exception e) {
            msn.showMessageError(e.getMessage(), "clearForm");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        sap_code = "";
        sap_name = "";
        sap_type = "OUT";
        sap_createuser = user;
        sap_createdate = "";
        sap_createtime = "";
        us.openTextFiled(txtCode, true, true);
        us.closeTextFiled(txtName, true);
        r_in.setSelected(true);
        r_branch.setSelected(true);
        r_active.setSelected(true);
        checkuserconfig();
    }

    private void openForm() {
        us.closeTextFiled(txtCode, false);
        us.openTextFiled(txtName, false, true);
    }

    private void btnSave() {
        this.sap_code = txtCode.getText().trim();
        this.sap_name = txtName.getText();
        this.sap_createuser = user;
        this.sap_createdate = fdn.dateFmtSQL(fdn.nowDate());
        this.sap_createtime = fdn.timeFmt(fdn.nowDate());
        this.sap_type = "OUT";
        if (r_in.isSelected()) {
            this.sap_type = "IN";
        }
        String sql = "SELECT * FROM sap_mastercode_inout where sap_code=? order by sap_code";
        String execute = "insert into sap_mastercode_inout(sap_name, sap_type, sap_createuser, sap_createdate, sap_createtime, sap_code,sap_trantype,sap_active) values(?,?,?,?,?,?,?,?)";

        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.sap_code);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                execute = "update sap_mastercode_inout set "
                        + "sap_name=?, sap_type=?, sap_createuser=?, sap_createdate=?, sap_createtime=?,sap_trantype=?,sap_active=? "
                        + "where sap_code=?";
            } else {
                execute = "insert into sap_mastercode_inout(sap_name, sap_type, sap_createuser, sap_createdate, sap_createtime, sap_trantype,sap_active,sap_code) values(?,?,?,?,?,?,?,?)";
            }
            String sap_trantype = "" ;
            String sap_active = "" ;
            if (r_branch.isSelected()) {
                sap_trantype = "B" ;
            } else {
                sap_trantype = "D" ;
            }
            if (r_active.isSelected()) {
                sap_active = "Y" ;
            } else {
                sap_active = "N" ;
            }
            ps = dbutility.dbUtility.con.prepareStatement(execute);
            ps.setString(1, this.sap_name);
            ps.setString(2, this.sap_type);
            ps.setString(3, this.sap_createuser);
            ps.setString(4, this.sap_createdate);
            ps.setString(5, this.sap_createtime);
            ps.setString(6, sap_trantype);
            ps.setString(7, sap_active);
            ps.setString(8, this.sap_code);
            ps.executeUpdate();
            clearForm();
        } catch (Exception e) {
            msn.showMessageError(e.getMessage(), "btnSave");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
    }

    private void btnDel() {
        boolean haveStcard = false;
        this.sap_code = txtCode.getText().trim();
        String sql = "delete from sap_mastercode_inout where sap_code=?";

        if (this.sap_code.length() > 0) {
            try {
                ps = dbutility.dbUtility.con.prepareStatement(sql);
                ps.setString(1, this.sap_code);
                ps.executeUpdate();
                clearForm();
            } catch (Exception e) {
                msn.showMessageError(e.getMessage(), "btnDel(delete)");
            } finally {
                closePS(ps);
                closeRS(rs);
            }
        }
    }

    private void btnPrint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void seek() {
        this.sap_code = txtCode.getText().trim();
        String sql = "SELECT * FROM sap_mastercode_inout where sap_code=? order by sap_code";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.sap_code);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                txtCode.setText(rs.getString("sap_code"));
                txtName.setText(rs.getString("sap_name"));
                if (rs.getString("sap_type").equals("IN")) {
                    r_in.setSelected(true);
                } else {
                    r_out.setSelected(true);
                }
                if (rs.getString("sap_trantype").equals("B")) {
                    r_branch.setSelected(true);
                } else {
                    r_dept.setSelected(true);
                }
                if (rs.getString("sap_active").equals("Y")) {
                    r_active.setSelected(true);
                } else {
                    r_nonactive.setSelected(true);
                }
            }
            openForm();
        } catch (Exception e) {
            msn.showMessageError(e.getMessage(), "seek");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
    }

    private void checkuserconfig() {
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getMast28().equals("1")) {
            btn_add.setEnabled(false);
            btn_cancel.setEnabled(false);
            btn_save.setEnabled(false);
            btn_del.setEnabled(false);

            menu_createNew.setEnabled(false);
            menuu_cancle.setEnabled(false);
            menu_save.setEnabled(false);
            menu_remove.setEnabled(false);
        } else if (userrec.getMast28().equals("2")) {
            btn_add.setEnabled(true);
            btn_cancel.setEnabled(true);
            btn_save.setEnabled(true);
            btn_del.setEnabled(false);

            menu_createNew.setEnabled(true);
            menuu_cancle.setEnabled(true);
            menu_save.setEnabled(true);
            menu_remove.setEnabled(false);
        } else if (userrec.getMast28().equals("3")) {
            btn_add.setEnabled(true);
            btn_cancel.setEnabled(true);
            btn_save.setEnabled(true);
            btn_del.setEnabled(true);

            menu_createNew.setEnabled(true);
            menuu_cancle.setEnabled(true);
            menu_save.setEnabled(true);
            menu_remove.setEnabled(true);
        }
    }
}
