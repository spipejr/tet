package EStamp;

import dbutility.dbUtility;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import jxl.write.WriteException;
import net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor;
import org.jdesktop.swingx.JXTree;
import report.Report;
import utilititiesfunction.Export2Excel;
import utilititiesfunction.Format;
import utilititiesfunction.FormatCell;
//import reportmodel.reportDetailCreateSMS_Vender;
//import reportmodel.reportEStampGive;
//import static smscode.rptDetailUseSMS_Vender.branch;
//import static smscode.rptDetailUseSMS_Vender.branch1;
//import static smscode.rptDetailUseSMS_Vender.campaign;
//import static smscode.rptDetailUseSMS_Vender.campaign1;
//import static smscode.rptDetailUseSMS_Vender.date1;
//import static smscode.rptDetailUseSMS_Vender.date2;
//import static smscode.rptDetailUseSMS_Vender.vender;
//import static smscode.rptDetailUseSMS_Vender.vender1;
//import smscode.utilities.Report;
//import smscode.utilities.format;
//import smscode.utilities.showMessage;
//import smscode.utilities.Export2Excel;
//import smscode.utilities.Format1;
//import smscode.utilities.FormatCell;

public class rptDetailUseSMS_Branch extends javax.swing.JDialog {

    public static String vender = "", vender1 = "", campaign = "", campaign1 = "",
            lot = "", lot1 = "", date1 = "", date2 = "", branch = "", branch1 = "", code = "";
    private Font fontbold = new Font("Norasi", Font.BOLD, 14);
    private Font fontplain = new Font("Norasi", Font.PLAIN, 14);
    //String frmName = "rptCreateSMS";
    private String condition = "รายงานแสดงรายละเอียดการใช้ SMS แยกตามสาขา (Detail Use Branch)";
    showMessage msn = new showMessage();
    dbUtility db = new dbUtility();
    PreparedStatement pre = null;
    ResultSet rs = null;

    Report r;
    String path = "/smscode/report/";
    String fileName = "rFile_DetailUseSMS_Branch1";

    public rptDetailUseSMS_Branch(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        db.dbconnect();

        loadtbl();
        settext();
    }

    rptDetailUseSMS_Branch() {

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
        lblbranch = new javax.swing.JLabel();
        db_lblh1 = new javax.swing.JLabel();
        db_lblh3 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        lblvender = new javax.swing.JLabel();
        db_lblh2 = new javax.swing.JLabel();
        db_btnExpand = new javax.swing.JButton();
        lblcampaign = new javax.swing.JLabel();
        db_lblh4 = new javax.swing.JLabel();
        db_btnExel = new javax.swing.JButton();
        db_btnPrint = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new org.jdesktop.swingx.JXTreeTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("รายงานแสดงรายละเอียดการใช้ SMS แยกตามสาขา ");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblbranch.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lblbranch.setText("-");
        lblbranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        db_lblh1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh1.setText("สาขา");
        db_lblh1.setName("db_lblh1"); // NOI18N

        db_lblh3.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh3.setText("ลูกค้า");
        db_lblh3.setName("db_lblh3"); // NOI18N

        lbldate.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lbldate.setText("-");
        lbldate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblvender.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lblvender.setText("-");
        lblvender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        db_lblh2.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh2.setText("วันที่ (Date)");
        db_lblh2.setName("db_lblh2"); // NOI18N

        db_btnExpand.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnExpand.setText("Expand On/Off");
        db_btnExpand.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        db_btnExpand.setIconTextGap(0);
        db_btnExpand.setName("db_btnExpand"); // NOI18N
        db_btnExpand.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        db_btnExpand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnExpandActionPerformed(evt);
            }
        });

        lblcampaign.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lblcampaign.setText("-");
        lblcampaign.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        db_lblh4.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh4.setText("แคมเปญ");
        db_lblh4.setName("db_lblh2"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(db_lblh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(db_lblh3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblbranch, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_lblh2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblvender, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_lblh4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblcampaign, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(db_btnExpand)
                .addGap(5, 5, 5))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(db_btnExpand)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblcampaign, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(db_lblh1)
                            .addComponent(db_lblh2)
                            .addComponent(lblbranch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(db_lblh3)
                            .addComponent(lblvender, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(db_lblh4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        db_btnExel.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnExel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Excel-icon.png"))); // NOI18N
        db_btnExel.setText("Excel File");
        db_btnExel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        db_btnExel.setIconTextGap(0);
        db_btnExel.setName("db_btnExel"); // NOI18N
        db_btnExel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        db_btnExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnExelActionPerformed(evt);
            }
        });

        db_btnPrint.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Printer-icon.png"))); // NOI18N
        db_btnPrint.setText("พิมพ์");
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
        btnExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogOut-icon.png"))); // NOI18N
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

        tbl.setName("tbl"); // NOI18N
        jScrollPane1.setViewportView(tbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnExel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(db_btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(db_btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_btnExel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1036, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void db_btnExpandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnExpandActionPerformed
        if (tbl.isExpanded(0)) {
            tbl.collapseAll();
        } else {
            tbl.expandAll();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnExpandActionPerformed

    private void db_btnExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnExelActionPerformed
        Export2Excel test = new Export2Excel();
        JFileChooser chooser = new JFileChooser();
        settext();
        try {

            chooser.setSelectedFile(test.getDefaulepath());
            chooser.setFileFilter(new JRSingleSheetXlsSaveContributor(Locale.ENGLISH, null));
            int confirm = chooser.showSaveDialog(this);
            if (confirm == JFileChooser.APPROVE_OPTION) {
                File curFile = chooser.getSelectedFile();

                if (curFile.exists()) {
                    int confirm2 = JOptionPane.showConfirmDialog(this, "ข้อมูลนี้มีอยู่แล้ว คุณต้องการบันทึกรายการนี้หรือไม่...?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm2 == JOptionPane.NO_OPTION) {
                        test.setDefaultpath(curFile);
                        db_btnExelActionPerformed(null);
                        return;
                    }
                }
                try {
                    test.setOutputFile(curFile.toString());
                    test.writeTreetableContditionNoSum(tbl, tbl.getColumnModel(), condition);
                    test.setDefaultpath(curFile);
                } catch (WriteException ex) {
                    msn.showMessageError("rptSumCreate & Use (Excel)" + ex.getMessage());
                }
            }
        } catch (IOException e) {
            msn.showMessageError("rptSumCreate & Use (Excel)" + e.getMessage());
        }
    }//GEN-LAST:event_db_btnExelActionPerformed

    private void db_btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnPrintActionPerformed
        btnPrint();
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
            java.util.logging.Logger.getLogger(rptDetailUseSMS_Branch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rptDetailUseSMS_Branch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rptDetailUseSMS_Branch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rptDetailUseSMS_Branch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                rptDetailUseSMS_Branch dialog = new rptDetailUseSMS_Branch(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton db_btnExel;
    private javax.swing.JButton db_btnExpand;
    private javax.swing.JButton db_btnPrint;
    private javax.swing.JLabel db_lblh1;
    private javax.swing.JLabel db_lblh2;
    private javax.swing.JLabel db_lblh3;
    private javax.swing.JLabel db_lblh4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbranch;
    private javax.swing.JLabel lblcampaign;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblvender;
    private org.jdesktop.swingx.JXTreeTable tbl;
    // End of variables declaration//GEN-END:variables

    private void loadtbl() {
        try {
            TableColumnModel tcm = new DefaultTableColumnModel();
            TableColumn tc1 = new TableColumn(0, 300);
            tc1.setHeaderValue("สาขา");
            TableColumn tc2 = new TableColumn(1, 220);
            tc2.setHeaderValue("รหัส SMS");
            TableColumn tc3 = new TableColumn(2, 120);
            tc3.setHeaderValue("วันที่ใช้");
            TableColumn tc4 = new TableColumn(3, 200);
            tc4.setHeaderValue("เลขที่บิล");
            TableColumn tc5 = new TableColumn(4, 100);
            tc5.setHeaderValue("จำนวนเงิน");
            TableColumn tc6 = new TableColumn(5, 100);
            tc6.setHeaderValue("ส่วนลด");
            TableColumn tc7 = new TableColumn(6, 150);
            tc7.setHeaderValue("ส่วนลด Coupon SMS");
            TableColumn tc8 = new TableColumn(7, 150);
            tc8.setHeaderValue("แทนเงินสด (Voucher)");
            TableColumn tc9 = new TableColumn(8, 150);
            tc9.setHeaderValue("ลูกหนี้ SMS");
            TableColumn tc10 = new TableColumn(9, 100);
            tc10.setHeaderValue("พนักงานขาย");
            TableColumn tc11 = new TableColumn(10, 120);
            tc11.setHeaderValue("หมายเลขโทรศัพท์");
            TableColumn tc12 = new TableColumn(11, 100);
            tc12.setHeaderValue("หมายเลขอ้างอิง");
            TableColumn tc13 = new TableColumn(12, 280);
            tc13.setHeaderValue("ลูกค้า");
            TableColumn tc14 = new TableColumn(13, 250);
            tc14.setHeaderValue("แคมเปญ");

            tcm.addColumn(tc1);
            tcm.addColumn(tc2);
            tcm.addColumn(tc3);
            tcm.addColumn(tc4);
            tcm.addColumn(tc5);
            tcm.addColumn(tc6);
            tcm.addColumn(tc7);
            tcm.addColumn(tc8);
            tcm.addColumn(tc9);
            tcm.addColumn(tc10);
            tcm.addColumn(tc11);
            tcm.addColumn(tc12);
            tcm.addColumn(tc13);
            tcm.addColumn(tc14);

            tcm.getColumn(0).setCellRenderer(FormatCell.l());
            tcm.getColumn(1).setCellRenderer(FormatCell.l());
            tcm.getColumn(2).setCellRenderer(FormatCell.l());
            tcm.getColumn(3).setCellRenderer(FormatCell.l());
            tcm.getColumn(4).setCellRenderer(FormatCell.r());
            tcm.getColumn(5).setCellRenderer(FormatCell.r());
            tcm.getColumn(6).setCellRenderer(FormatCell.r());
            tcm.getColumn(7).setCellRenderer(FormatCell.r());
            tcm.getColumn(8).setCellRenderer(FormatCell.r());
            tcm.getColumn(9).setCellRenderer(FormatCell.l());
            tcm.getColumn(10).setCellRenderer(FormatCell.l());
            tcm.getColumn(11).setCellRenderer(FormatCell.l());
            tcm.getColumn(12).setCellRenderer(FormatCell.l());
            tcm.getColumn(13).setCellRenderer(FormatCell.l());

            tbl.setEditable(false);//ห้ามแก้ไขตาราง
            tbl.setShowGrid(true);
            tbl.setFont(fontplain);
            tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbl.setRowSelectionAllowed(true);
            tbl.setBackground(java.awt.Color.WHITE);
            tbl.setGridColor(java.awt.Color.gray);
            tbl.setRowHeight(24);

            tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            String d1 = "";
            String d2 = "";

            if (!date1.equals("")) {
                Date d = Format.dateFmtShow.parse(date1);
                d1 = Format.dateFmtSql.format(d);
            }
            if (!date2.equals("")) {
                Date dd = Format.dateFmtShow.parse(date2);
                d2 = Format.dateFmtSql.format(dd);
            }

            String sql = "SELECT sm.v_code , v.v_name , sm.c_code , c.c_name ,sm.l_code, sm.u_branch , "
                    + "b.name , sm.u_refno , sm.u_amount , sm.u_discount , sm.u_cashier , "
                    + "sm.u_mobile , sm.u_reference , sm.sms_code , sm.u_date, "
                    + "sm.u_coupon, sm.u_voucher, sm.u_ar "
                    + "FROM smscode sm "
                    + "left join campaign c on c.c_code = sm.c_code "
                    + "left join vender v on v.v_code = sm.v_code "
                    + "left join branfile b on b.code = sm.u_branch "
                    + "where sm.sms_status = '2' "
                    + "and sm.c_code >= '" + campaign + "' and sm.c_code <= '" + campaign1 + "' "
                    + "and sm.u_branch >= '" + branch + "' and sm.u_branch <= '" + branch1 + "' "
                    + "and sm.v_code >= '" + vender + "' and sm.v_code <= '" + vender1 + "' "
                    + "and cast(sm.u_date as DATE) >= '" + d1 + "' and cast(sm.u_date as DATE) <= '" + d2 + "' "
                    + "order by sm.u_branch ,sm.u_date ,sm.l_code, sm.sms_code ";

            System.out.println("sql2 //   " + sql);
            reportEStampGive treemodel = new reportEStampGive(sql, code);
            tbl.setTreeTableModel(treemodel);
            tbl.setColumnModel(tcm);
            tbl.setRootVisible(true);
            ((JXTree) tbl.getCellRenderer(0, tbl.getHierarchicalColumn())).setFont(fontplain);
            settext();
            JTableHeader h = tbl.getTableHeader();
            h.setFont(fontbold);
            tbl.setLeafIcon(null);
        } catch (Exception e) {
            e.printStackTrace();
            msn.showMessageError(e.getMessage());
        }
    }

    private void settext() {
        String v = "";
        String c = "";
        String date = "";
        String b = "";

        if (!date1.equals("")) {
            date = date1 + " - ";
        } else {
            date = " - ";
        }
        if (!date2.equals("31/12/9999")) {
            date += date2;
        }

        ////////////////////////////
        if (!vender.equals("")) {
            v = vender + " - ";
        } else {
            v = " - ";
        }

        if (!vender1.equals("ZZZ")) {
            v += vender1;
        }

        ///////////////////////////
        if (!campaign.equals("")) {
            c = campaign + " - ";
        } else {
            c = " - ";
        }

        if (!campaign1.equals("ZZZZ")) {
            c += campaign1;
        }
        ///////////////////////////
        if (!branch.equals("")) {
            b = branch + " - ";
        } else {
            b = " - ";
        }

        if (!branch1.equals("ZZZZ")) {
            b += branch1;
        }

        lblvender.setText(v);
        lblcampaign.setText(c);
        lbldate.setText(date);
        lblbranch.setText(b);
//        System.out.println("DD :" + date+ v);
        condition = this.getTitle() + "Date : " + date + "Vender :" + v;
    }

    private void btnPrint() {
        checkpara();
        String dd1 = "";
        String dd2 = "";

//        dd1 = f.convertDateshowToSQL(date1);
//        dd2 = f.convertDateshowToSQL(date2);
        String Companyname = "";
        try {
            String sql = "SELECT * FROM company";
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                Companyname = rs.getString("Name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Date su1 = new Date();
        Date su2 = new Date();
//        su1 = f.dateFmtShow.parse(date1);
//        su2 = f.dateFmtShow.parse(date2);

        String condition = "เงื่อนไข :  (รหัสสาขา " + branch + " ถึง " + branch1 + "  )     "
                + " (รหัสลูกค้า " + vender + " ถึง " + vender1 + "  )     "
                + " (รหัสแคมเปญ " + campaign + " ถึง " + campaign1 + "  )     "
                + " (วันที่ " + branch + " ถึง " + branch1 + "  )   ";

//        r = new Report(path);
        r = new Report();
        Map map = new HashMap();
        map.put("Companyname", Companyname);
        map.put("Projectname", "SMS Sales Corporate.");
        map.put("Reportname", "รายงานแสดงรายละเอียดการใช้ SMS แยกตามสาขา");
        map.put("vender1", vender);
        map.put("vender2", vender1);
        map.put("campaign1", campaign);
        map.put("campaign2", campaign1);
        map.put("branch1", branch);
        map.put("branch2", branch1);
        map.put("date1", dd1);
        map.put("date2", dd2);
        map.put("condition", condition);
//        r.viewReport(fileName, map);
    }

    private void checkpara() {
        if (vender.equals("")) {
            vender = "";
        }
        if (vender1.equals("")) {
            vender1 = "zzz";
        }
        if (campaign.equals("")) {
            campaign = "";
        }
        if (campaign1.equals("")) {
            campaign1 = "zzz";
        }
        if (branch.equals("")) {
            branch = "";
        }
        if (branch1.equals("")) {
            branch1 = "zzz";
        }
        if (date1.equals("")) {
            date1 = "";
        }
        if (date2.equals("")) {
            date2 = "31/12/9999";
        }
    }
}
