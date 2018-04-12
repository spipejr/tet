/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package masterfile;

import borfunction.GetApplicationName;
import borfunction.GetUser;
import borfunction.btnFind;
import dbutility.dbUtility;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import jxl.write.WriteException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor;
import report.Report;
import utilititiesfunction.*;

/**
 *
 * @author s386
 */
public class showBorUser extends javax.swing.JDialog {

    /**
     * Creates new form showBorUser
     */
     String frmName = "showboruser";
    ThaiUtilities cvth = new ThaiUtilities();
    btnFind btn = new btnFind();
    dbUtility db = new dbUtility();
    Statement stmt ;
    getLanguage lang = new getLanguage();
    SimpleDateFormat dateTimeFmtSave = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    SimpleDateFormat dateTimeFmtShow = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
    public showBorUser(java.awt.Frame parent, boolean modal) {
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
        db_btnExel1 = new javax.swing.JButton();
        db_btnPrint = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("แสดงรายการผู้ใช้ระบบ BOR");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                .addContainerGap(716, Short.MAX_VALUE)
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
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ชื่อพนักงาน", "User", "PassWord", "UserGroup", "LastChangePassword"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.setName("tbl"); // NOI18N
        jScrollPane1.setViewportView(tbl);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(220);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(150);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1032)/2, (screenSize.height-796)/2, 1032, 796);
    }// </editor-fold>//GEN-END:initComponents

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


        ds = new JRBeanCollectionDataSource(report.databeanReportPlu.getBorUser());
        parm.put("companyName", lang.getTextCompanyReport());
        parm.put("Reportheader", lang.getTextReport(frmName, "texthead"));
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
        String rptName = "rptBorUser";
        Report rpt = new Report();
        rpt.viewReportbean(rptName, parm, frmName, ds);



        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnPrintActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExit1ActionPerformed

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
            java.util.logging.Logger.getLogger(showBorUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showBorUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showBorUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showBorUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                showBorUser dialog = new showBorUser(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnExit1;
    private javax.swing.JButton db_btnExel1;
    private javax.swing.JButton db_btnPrint;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
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
        try {
        if(!db.Char_Set.equalsIgnoreCase("utf-8"))
        {
            ResultSet rs = null;
            DefaultTableModel dtb = (DefaultTableModel) tbl.getModel();
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from boruserlinux ";
                   
            rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                dtb.addRow(new Object[]{    
                                            cvth.ASCII2Unicode(rs.getString("name")),
                                            cvth.ASCII2Unicode(rs.getString("username")),
                                            cvth.ASCII2Unicode(rs.getString("password")),
                                            cvth.ASCII2Unicode(rs.getString("usergroup")),
                                            dateTimeFmtShow.format(dateTimeFmtSave.parse(rs.getString("lastchangepassword")))
                                            
                                            
                                            });
            
            }
            
            
        }
        else
        {
            ResultSet rs = null;
            DefaultTableModel dtb = (DefaultTableModel) tbl.getModel();
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from boruserlinux ";
                    
            rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                dtb.addRow(new Object[]{    rs.getString("name"),
                                            rs.getString("username"),
                                            rs.getString("password"),
                                            rs.getString("usergroup"),
                                            dateTimeFmtShow.format(dateTimeFmtSave.parse(rs.getString("lastchangepassword")))
                                            
                                            
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
        
        //tblBtype.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tbl.setRowHeight(25);
        tbl.setAutoCreateRowSorter(true);
    }
}
