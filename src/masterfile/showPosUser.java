/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package masterfile;

import borfunction.*;
import dbutility.dbUtility;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import jxl.write.WriteException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor;
import report.Report;
import utilities.DateChooser.DateUtil;
import utilititiesfunction.*;

/**
 *
 * @author s386
 */
public class showPosUser extends javax.swing.JDialog {

    /**
     * Creates new form showPosUser
     */
    String frmName = "showposuser";
    ThaiUtilities cvth = new ThaiUtilities();
    btnFind btn = new btnFind();
    dbUtility db = new dbUtility();
    Statement stmt ;
    getLanguage lang = new getLanguage();
    SimpleDateFormat dateTimeFmtSave = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    SimpleDateFormat dateTimeFmtShow = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
    public showPosUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        db.dbconnect();
        initTable();
        //lang.setText(frmName, this, lang.getChklang());
        setDataToTbl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        d_branch = new javax.swing.JLabel();
        d_branch2 = new javax.swing.JLabel();
        t_branch1 = new javax.swing.JFormattedTextField();
        btn7 = new javax.swing.JButton();
        t_branch2 = new javax.swing.JFormattedTextField();
        btn17 = new javax.swing.JButton();
        d_branch3 = new javax.swing.JLabel();
        db_btnProcress = new javax.swing.JButton();
        db_btnExel1 = new javax.swing.JButton();
        db_btnPrint = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("แสดงรายการผู้ใช้งาน");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        d_branch.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        d_branch.setText("กำหนดช่วงสาขา (Branch)");
        d_branch.setName("d_branch"); // NOI18N

        d_branch2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        d_branch2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        d_branch2.setText("รหัสสาขา");
        d_branch2.setName("d_branch2"); // NOI18N

        t_branch1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_branch1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_branch1FocusLost(evt);
            }
        });
        t_branch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_branch1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_branch1KeyTyped(evt);
            }
        });

        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        btn7.setFocusable(false);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        t_branch2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_branch2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_branch2FocusLost(evt);
            }
        });
        t_branch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_branch2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_branch2KeyTyped(evt);
            }
        });

        btn17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        btn17.setFocusable(false);
        btn17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn17ActionPerformed(evt);
            }
        });

        d_branch3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        d_branch3.setText("ถึงสาขา");
        d_branch3.setName("d_branch3"); // NOI18N

        db_btnProcress.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnProcress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Hourglass-icon.png"))); // NOI18N
        db_btnProcress.setText("F5-ประมวลผล");
        db_btnProcress.setName("db_btnProcress"); // NOI18N
        db_btnProcress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnProcressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(d_branch2)
                        .addGap(18, 18, 18)
                        .addComponent(t_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(d_branch3)
                        .addGap(2, 2, 2)
                        .addComponent(t_branch2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(db_btnProcress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(d_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(db_btnProcress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(d_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(d_branch2)
                                .addComponent(t_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(t_branch2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(d_branch3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        db_btnExel1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnExel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Excel-icon.png"))); // NOI18N
        db_btnExel1.setText("Exel File");
        db_btnExel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        db_btnExel1.setIconTextGap(0);
        db_btnExel1.setName("db_btnExel"); // NOI18N
        db_btnExel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        db_btnExel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnExel1ActionPerformed(evt);
            }
        });

        db_btnPrint.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Printer-icon.png"))); // NOI18N
        db_btnPrint.setText("พิมม์");
        db_btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        db_btnPrint.setIconTextGap(0);
        db_btnPrint.setName("db_btnPrint"); // NOI18N
        db_btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        db_btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnPrintActionPerformed(evt);
            }
        });

        btnExit1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LogOut-icon.png"))); // NOI18N
        btnExit1.setText("Exit");
        btnExit1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit1.setIconTextGap(0);
        btnExit1.setName("db_btnExit"); // NOI18N
        btnExit1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(db_btnExel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(db_btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(db_btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_btnExel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "สาขา", "ชื่อสาขา", "ชื่อพนักงาน", "User", "PassWord", "UserGroup", "LastChangePassword", "Branch Change"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.setName("tbl"); // NOI18N
        jScrollPane1.setViewportView(tbl);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(170);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(6).setPreferredWidth(120);
        tbl.getColumnModel().getColumn(7).setPreferredWidth(80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1032)/2, (screenSize.height-796)/2, 1032, 796);
    }// </editor-fold>//GEN-END:initComponents

    private void t_branch1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_branch1FocusGained
        t_branch1.setText(t_branch1.getText());
        t_branch1.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_t_branch1FocusGained

    private void t_branch1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_branch1FocusLost
        t_branch1.select(0, 0);
        // TODO add your handling code here:
    }//GEN-LAST:event_t_branch1FocusLost

    private void t_branch1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_branch1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            t_branch2.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btnFindBranch(t_branch1);
        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
            Procress();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_branch1KeyPressed

    private void t_branch1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_branch1KeyTyped
        settext.setTextLength(evt, t_branch1, 3);
        // TODO add your handling code here:
    }//GEN-LAST:event_t_branch1KeyTyped

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        btn.btnFindBranch(t_branch1);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn7ActionPerformed

    private void t_branch2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_branch2FocusGained
        t_branch2.setText(t_branch2.getText());
        t_branch2.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_t_branch2FocusGained

    private void t_branch2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_branch2FocusLost
        t_branch2.select(0, 0);
        // TODO add your handling code here:
    }//GEN-LAST:event_t_branch2FocusLost

    private void t_branch2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_branch2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            t_branch1.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btnFindBranch(t_branch2);
        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
            Procress();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_branch2KeyPressed

    private void t_branch2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_branch2KeyTyped
        settext.setTextLength(evt, t_branch2, 3);
        // TODO add your handling code here:
    }//GEN-LAST:event_t_branch2KeyTyped

    private void btn17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn17ActionPerformed
        btn.btnFindBranch(t_branch2);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn17ActionPerformed

    private void db_btnExel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnExel1ActionPerformed

        Export2Excel test = new Export2Excel();
        JFileChooser chooser = new JFileChooser();

        try {
           

            chooser.setSelectedFile(test.getDefaulepath());
            chooser.setFileFilter(new JRSingleSheetXlsSaveContributor(Locale.ENGLISH, null));
            int confirm = chooser.showSaveDialog(this);
            if (confirm == JFileChooser.APPROVE_OPTION) {
                File curFile = chooser.getSelectedFile();
                if(curFile.exists())
                {
                    int confirm2 = JOptionPane.showConfirmDialog(this, "ข้อมูลนี้มีอยู่แล้ว คุณต้องการบันทึกรายการนี้หรือไม่...?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm2 == JOptionPane.NO_OPTION) {
                        test.setDefaultpath(curFile);
                        db_btnExel1ActionPerformed(null);
                        
                        return;

                    }
                    
                }

                test.setOutputFile(curFile.toString());
                try {
                    test.writeTreetableNoSum2(tbl, tbl.getColumnModel());
                    test.setDefaultpath(curFile);
                } catch (WriteException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_db_btnExel1ActionPerformed

    private void db_btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnPrintActionPerformed
        Map parm = new HashMap();
        JRBeanCollectionDataSource ds = null;

        setCondition();
        
        ds = new JRBeanCollectionDataSource(report.databeanReportPlu.getPosUser(branch1, branch2));
        parm.put("companyName", lang.getTextCompanyReport());
        parm.put("Reportheader", lang.getTextReport(frmName, "texthead"));
        parm.put("branch1", t_branch1.getText());
        parm.put("branch2", t_branch2.getText());
        parm.put("forname", lang.getTextReport(frmName, "for"));
        parm.put("code", lang.getTextReport(frmName, "code"));
        parm.put("name", lang.getTextReport(frmName, "name"));
        parm.put("other2", lang.getTextReport(frmName, "other2"));
        parm.put("other3", lang.getTextReport(frmName, "other3"));
        parm.put("other4", lang.getTextReport(frmName, "other4"));
        parm.put("other5", lang.getTextReport(frmName, "other5"));
        parm.put("total", lang.getTextReport(frmName, "total"));
        parm.put("totalall", lang.getTextReport(frmName, "totalall"));
        parm.put("branchtxt", lang.getTextReport(frmName, "branchtxt"));
        parm.put("application", new GetApplicationName().getApplicationName());
        parm.put("user", new GetUser().getUser());
        parm.put("currentDate", Format.dateFmtReport.format(new java.util.Date()));
        String rptName = "rptPosUser";
        Report rpt = new Report();
        rpt.viewReportbean(rptName, parm, frmName, ds);

        

        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnPrintActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExit1ActionPerformed

    private void db_btnProcressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnProcressActionPerformed
        Procress();
    }//GEN-LAST:event_db_btnProcressActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(showPosUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showPosUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showPosUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showPosUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                showPosUser dialog = new showPosUser(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btnExit1;
    private javax.swing.JLabel d_branch;
    private javax.swing.JLabel d_branch2;
    private javax.swing.JLabel d_branch3;
    private javax.swing.JButton db_btnExel1;
    private javax.swing.JButton db_btnPrint;
    private javax.swing.JButton db_btnProcress;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField t_branch1;
    private javax.swing.JFormattedTextField t_branch2;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
    private void Procress()
   {
       setDataToTbl();
   }
    String branch1 = "",branch2 ="";
   private void setCondition()
    {
         
         
         if(!t_branch1.getText().trim().equals(""))
        {
            branch1= t_branch1.getText();
        }
        else
        {
            branch1 = "";
        }
         
         if(!t_branch2.getText().trim().equals(""))
        {
            branch2= t_branch2.getText();
        }
        else
        {
            branch2= "ZZZ";
        }
    }
   private void clearTbl()
    {
        
    DefaultTableModel tb = (DefaultTableModel) tbl.getModel();
     int cnt = tb.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                tb.removeRow(0);
            }
        }
    }
    private void setDataToTbl() {
        clearTbl();
        setCondition();
        try {
        if(!db.Char_Set.equalsIgnoreCase("utf-8"))
        {
            ResultSet rs = null;
            DefaultTableModel dtb = (DefaultTableModel) tbl.getModel();
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from posuser "
                    + "left join branfile on posuser.macno = branfile.code "
                    + "where macno>='"+cvth.Unicode2ASCII(branch1)+"' and macno<='"+cvth.Unicode2ASCII(branch2)+"' order by username";
            rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                dtb.addRow(new Object[]{    cvth.ASCII2Unicode(rs.getString("macno")),
                                            cvth.ASCII2Unicode(rs.getString("branfile.name")),
                                            cvth.ASCII2Unicode(rs.getString("posuser.name")),
                                            cvth.ASCII2Unicode(rs.getString("username")),
                                            cvth.ASCII2Unicode(rs.getString("password")),
                                            cvth.ASCII2Unicode(rs.getString("usergroup")),
                                            dateTimeFmtShow.format(dateTimeFmtSave.parse(rs.getString("lastchangepassword"))),
                                            cvth.ASCII2Unicode(rs.getString("branchchange"))
                                            
                                            });
            
            }
            
            
        }
        else
        {
            ResultSet rs = null;
            DefaultTableModel dtb = (DefaultTableModel) tbl.getModel();
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from posuser "
                    + "left join branfile on posuser.macno = branfile.code "
                    + "where macno>='"+cvth.Unicode2ASCII(branch1)+"' and macno<='"+cvth.Unicode2ASCII(branch2)+"' order by username";
            rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                dtb.addRow(new Object[]{    rs.getString("macno"),
                                            rs.getString("branfile.name"),
                                            rs.getString("posuser.name"),
                                            rs.getString("username"),
                                            rs.getString("password"),
                                            rs.getString("usergroup"),
                                            dateTimeFmtShow.format(rs.getString("lastchangepassword")),
                                            rs.getString("branchchange")
                                            
                                            });
            
            }
            
        }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
     private void initTable() {
        
        //tblCoupon
        DefaultTableModel tblc = (DefaultTableModel) tbl.getModel();
        tbl.setShowGrid(true);
       // tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl.setRowSelectionAllowed(true);
        tbl.setBackground(java.awt.Color.WHITE);
        tbl.setGridColor(java.awt.Color.gray);
        JTableHeader headerc = tbl.getTableHeader();
        headerc.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tbl.setRowHeight(25);
      

        TableColumnModel tcmc = tbl.getColumnModel();
        tcmc.getColumn(0).setCellRenderer(FormatCell.l());
        tcmc.getColumn(1).setCellRenderer(FormatCell.l());
        tcmc.getColumn(2).setCellRenderer(FormatCell.l());
        tcmc.getColumn(3).setCellRenderer(FormatCell.l());
        tcmc.getColumn(4).setCellRenderer(FormatCell.l());
        tcmc.getColumn(5).setCellRenderer(FormatCell.l());
        tcmc.getColumn(6).setCellRenderer(FormatCell.l());
        tcmc.getColumn(7).setCellRenderer(FormatCell.l());
        
        //tblBtype.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tbl.setRowHeight(25);
        tbl.setAutoCreateRowSorter(true);
    }
     
}
