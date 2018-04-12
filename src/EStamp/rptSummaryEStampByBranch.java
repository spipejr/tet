/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EStamp;

import EStamp.EStampReport.Report_ES;
import borfunction.GetApplicationName;
import borfunction.GetUser;
import dbutility.dbUtility;
import reportfile.*;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor;
import org.jdesktop.swingx.JXTree;
import report.Report;
import utilititiesfunction.*;

/**
 *
 * @author s386
 */
public class rptSummaryEStampByBranch extends javax.swing.JDialog {

    /**
     * Creates new form rptSumCupon
     */
    public static String ccode1 = "", ccode2 = "", code = "", name = "", date1 = "", date2 = "", barcode1 = "", barcode2 = "",
            branch1 = "", branch2 = "", btype1 = "", btype2 = "", barea1 = "", barea2 = "", bsize1 = "", bsize2 = "", bplan1 = "", bplan2 = "",
            bstore1 = "", bstore2 = "", company1 = "", company2 = "", brand1 = "", brand2 = "", bustype1 = "", bustype2 = "", strday = "";
    private Font fontbold = new Font("Norasi", Font.BOLD, 14);
    private Font fontplain = new Font("Norasi", Font.PLAIN, 14);
    String frmName = "rptSumCupon";
    ThaiUtilities cvth = new ThaiUtilities();
    private String condition = "";
    private String Seek = "";

    public rptSummaryEStampByBranch(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getLanguage lang = new getLanguage();
        lang.setText(frmName, this, lang.getChklang());
        setTxt();
        insertToTempPoint();
        inittbl();
    }

    public rptSummaryEStampByBranch() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        db_btnExel = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        db_btnPrint = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        db_btnExpand = new javax.swing.JButton();
        db_lblh1 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblBarcode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCampaign = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new org.jdesktop.swingx.JXTreeTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("รายงานสรุปการแจกและการแลก E-Stamp แยกตามสาขา");

        db_btnExel.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnExel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Excel-icon.png"))); // NOI18N
        db_btnExel.setText("Exel File");
        db_btnExel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        db_btnExel.setIconTextGap(0);
        db_btnExel.setName("db_btnExel"); // NOI18N
        db_btnExel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        db_btnExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnExelActionPerformed(evt);
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

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        db_lblh1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh1.setText("วันที่ (Date)");
        db_lblh1.setName("db_lblh1"); // NOI18N

        lbldate.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lbldate.setText("-");
        lbldate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("รหัสบัตร");

        lblBarcode.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lblBarcode.setText("-");
        lblBarcode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("แคมเปญ");

        lblCampaign.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lblCampaign.setText("-");
        lblCampaign.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(db_lblh1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCampaign, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(db_btnExpand)
                .addGap(86, 86, 86))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(db_lblh1)
                            .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCampaign, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(db_btnExpand))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(tbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnExel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(db_btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(db_btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_btnExel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1032, 796));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void db_btnExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnExelActionPerformed

        Export2Excel test = new Export2Excel();
        JFileChooser chooser = new JFileChooser();
        setTxt();
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
                    JOptionPane.showMessageDialog(this, "บันทึกข้อมูลเรับร้อยแล้ว...");
                } catch (WriteException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_db_btnExelActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExit1ActionPerformed

    private void db_btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnPrintActionPerformed
//        ProcessPrint();
        ProcessPrintBean();
  }//GEN-LAST:event_db_btnPrintActionPerformed

    private void db_btnExpandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnExpandActionPerformed
        if (tbl.isExpanded(0)) {
            tbl.collapseAll();
        } else {
            tbl.expandAll();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnExpandActionPerformed

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
            java.util.logging.Logger.getLogger(rptSummaryEStampByBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rptSummaryEStampByBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rptSummaryEStampByBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rptSummaryEStampByBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                rptSummaryEStampByBranch dialog = new rptSummaryEStampByBranch(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblCampaign;
    private javax.swing.JLabel lbldate;
    private org.jdesktop.swingx.JXTreeTable tbl;
    // End of variables declaration//GEN-END:variables

    private void inittbl() {
        try {
            TableColumnModel tcm = new DefaultTableColumnModel();

            TableColumn tc1 = new TableColumn(0, 300);
            tc1.setHeaderValue("สาขา");
            TableColumn tc2 = new TableColumn(1, 120);
            tc2.setHeaderValue("รหัสแคมเปญ");
            TableColumn tc3 = new TableColumn(2, 200);
            tc3.setHeaderValue("ชื่อแคมเปญ");
            TableColumn tc4 = new TableColumn(3, 170);
            tc4.setHeaderValue("รวมแต้มที่ได้รับ");
            TableColumn tc5 = new TableColumn(4, 170);
            tc5.setHeaderValue("รวมแต้มที่ใช้แลก");

            tcm.addColumn(tc1);
            tcm.addColumn(tc2);
            tcm.addColumn(tc3);
            tcm.addColumn(tc4);
            tcm.addColumn(tc5);

            tcm.getColumn(0).setCellRenderer(FormatCell.l());
            tcm.getColumn(1).setCellRenderer(FormatCell.l());
            tcm.getColumn(2).setCellRenderer(FormatCell.l());
            tcm.getColumn(3).setCellRenderer(FormatCell.color1());
            tcm.getColumn(4).setCellRenderer(FormatCell.color1());

            tbl.setEditable(false);//ห้ามแก้ไขตาราง
            tbl.setShowGrid(true);
            tbl.setFont(fontplain);
            tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbl.setRowSelectionAllowed(true);
            tbl.setBackground(java.awt.Color.WHITE);
            tbl.setGridColor(java.awt.Color.gray);
            tbl.setRowHeight(24);

            tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            Seek = "select * from stamptempreportsum order by ccode";

            reportSummaryEStampByBranch treemodel = new reportSummaryEStampByBranch(Seek, code);
            tbl.setTreeTableModel(treemodel);
            tbl.setColumnModel(tcm);
            tbl.setRootVisible(true);
            ((JXTree) tbl.getCellRenderer(0, tbl.getHierarchicalColumn())).setFont(fontplain);
            setTxt();
            JTableHeader h = tbl.getTableHeader();
            h.setFont(fontbold);
            //  h.setReorderingAllowed(false);
            tbl.setLeafIcon(null);
            //tbl.getColumnModel().removeColumn(tc4);
        } catch (SQLException ex) {
            Logger.getLogger(rptSaleOfPlu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setTxt() {
        lbldate.setText(date1 + " - " + date2);
        lblCampaign.setText(ccode1 + " - " + ccode2);
        lblBarcode.setText(barcode1 + " - " + barcode2);
        this.setTitle("รายงานสรุปการแจกและการแลก E-Stamp แยกรหัสบัตร E-Stamp");
        condition = "รายงานสรุปการแจกและการแลก E-Stamp แยกรหัสบัตร E-Stamp " + " : " + barcode1 + " ถึง " + barcode2;
    }

    private void ProcessPrint() {
        try {
            getLanguage lang = new getLanguage();
            Map parm = new HashMap();
            parm.put("companyName", lang.getTextCompanyReport());
            parm.put("application", new GetApplicationName().getApplicationName());
            parm.put("user", new GetUser().getUser());

            String frmName = "ES_rptSumByBarcode";
            String rptName = "ES_rptSumByBarcode";
            Report rpt = new Report();
            rpt.viewReport(rptName, parm, frmName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteTempreportestamp() {
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String sqldelete = "delete from stamptempreportsum";
            stmt.executeUpdate(sqldelete);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void insertToTempPoint() {
        deleteTempreportestamp();
        int point = 0;
        int redeem = 0;
        try {

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
            String sql = "";
            if (!dbutility.dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                sql = "select st.use_branch, b.name ,  st.stamp_campaign, sc.s_campaignname, "
                        + "sum(st.stamp_point) as stamppoint,sum(st.stamp_redeem) as stamppredeem   from stamptran st "
                        + "left join stampbarcode sb on st.stamp_barcode = sb.stamp_barcode "
                        + "left join branfile b on st.use_branch = b.code "
                        + "left join stampcampaign sc on st.stamp_campaign = sc.s_campaigncode "
                        + "where st.use_date >= '" + d1 + "' and st.use_date <= '" + d2 + "' "
                        + "and st.stamp_campaign >='" + cvth.Unicode2ASCII(ccode1) + "' and st.stamp_campaign <='" + cvth.Unicode2ASCII(ccode2) + "' "
                        + "and st.stamp_barcode>='" + cvth.Unicode2ASCII(barcode1) + "' and  st.stamp_barcode <='" + cvth.Unicode2ASCII(barcode2) + "' and st.void_bill='N' "
                        + "and st.use_branch >= '" + cvth.Unicode2ASCII(branch1) + "' and st.use_branch <= '" + cvth.Unicode2ASCII(branch2) + "' "
                        + "and b.btype >= '" + cvth.Unicode2ASCII(btype1) + "' and b.btype <= '" + cvth.Unicode2ASCII(btype2) + "' "
                        + "and b.barea >= '" + cvth.Unicode2ASCII(barea1) + "' and b.barea <= '" + cvth.Unicode2ASCII(barea2) + "' "
                        + "and b.bsize >= '" + cvth.Unicode2ASCII(bsize1) + "' and b.bsize <= '" + cvth.Unicode2ASCII(bsize2) + "' "
                        + "and b.bplane >= '" + cvth.Unicode2ASCII(bplan1) + "' and b.bplane <= '" + cvth.Unicode2ASCII(bplan2) + "' "
                        + "and b.bstore >= '" + cvth.Unicode2ASCII(bstore1) + "' and b.bstore <= '" + cvth.Unicode2ASCII(bstore2) + "' "
                        + "and b.companycode >= '" + cvth.Unicode2ASCII(company1) + "' and b.companycode <= '" + cvth.Unicode2ASCII(company2) + "' "
                        + "and b.brandcode >= '" + cvth.Unicode2ASCII(brand1) + "' and b.brandcode <= '" + cvth.Unicode2ASCII(brand2) + "' "
                        + "and b.buscode >= '" + cvth.Unicode2ASCII(bustype1) + "' and b.buscode <= '" + cvth.Unicode2ASCII(bustype2) + "' "
                        + "and locate(dayofweek(st.use_date),'" + cvth.Unicode2ASCII(strday) + "')>0 "
                        + "group by st.use_branch "
                        + "order by st.use_branch ";
            } else {
                sql = "select st.use_branch, b.name , st.stamp_campaign, sc.s_campaignname,"
                        + "sum(st.stamp_point) as stamppoint,sum(st.stamp_redeem) as stamppredeem    from stamptran st "
                        + "left join stampbarcode sb on st.stamp_barcode = sb.stamp_barcode "
                        + "left join branfile b on st.use_branch = b.code "
                        + "left join stampcampaign sc on st.stamp_campaign = sc.s_campaigncode "
                        + "where st.use_date >= '" + d1 + "' and st.use_date <= '" + d2 + "' "
                        + "and st.stamp_campaign >='" + ccode1 + "' and st.stamp_campaign <='" + ccode2 + "' "
                        + "and st.stamp_barcode>='" + barcode1 + "' and  st.stamp_barcode <='" + barcode2 + "' and st.void_bill='N' "
                        + "and st.use_branch >= '" + branch1 + "' and st.use_branch <= '" + branch2 + "' "
                        + "and b.btype >= '" + btype1 + "' and b.btype <= '" + btype2 + "' "
                        + "and b.barea >= '" + barea1 + "' and b.barea <= '" + barea2 + "' "
                        + "and b.bsize >= '" + bsize1 + "' and b.bsize <= '" + bsize2 + "' "
                        + "and b.bplane >= '" + bplan1 + "' and b.bplane <= '" + bplan2 + "' "
                        + "and b.bstore >= '" + bstore1 + "' and b.bstore <= '" + bstore2 + "' "
                        + "and b.companycode >= '" + company1 + "' and b.companycode <= '" + company2 + "' "
                        + "and b.brandcode >= '" + brand1 + "' and b.brandcode <= '" + brand2 + "' "
                        + "and b.buscode >= '" + bustype1 + "' and b.buscode <= '" + bustype2 + "' "
                        + "and locate(dayofweek(st.use_date),'" + strday + "')>0 "
                        + "group by st.use_branch "
                        + "order by st.use_branch ";
            }
            System.out.println("sql// " + sql);
            PreparedStatement pre1 = dbUtility.con.prepareStatement(sql);
            ResultSet rsP = pre1.executeQuery();
            rsP.first();
            if (rsP.getRow() != 0) {
                if (!dbutility.dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                    do {
                        String strCampaignname = "";
                        if (rsP.getString("sc.s_campaignname").length() > 40) {
                            strCampaignname = rsP.getString("sc.s_campaignname").substring(0, 40);
                        } else {
                            strCampaignname = rsP.getString("sc.s_campaignname");
                        }
                        String inst = "insert into stamptempreportsum(ccode,cname,point,redeem, custtel, custname) values(?,?,?,?,?,?)";
                        Statement stmt = (Statement) dbUtility.con.createStatement();
                        PreparedStatement prm = dbUtility.con.prepareStatement(inst);
                        prm.setString(1, cvth.Unicode2ASCII(rsP.getString("st.use_branch")));
                        prm.setString(2, cvth.Unicode2ASCII(rsP.getString("b.name")));
                        prm.setInt(3, rsP.getInt("stamppoint"));
                        prm.setInt(4, rsP.getInt("stamppredeem"));
                        prm.setString(5, cvth.Unicode2ASCII(rsP.getString("st.stamp_campaign")));
                        prm.setString(6, cvth.Unicode2ASCII(strCampaignname));
                        prm.executeUpdate();
                    } while (rsP.next());
                } else {
                    do {
                        String strCampaignname = "";
                        if (rsP.getString("sc.s_campaignname").length() > 40) {
                            strCampaignname = rsP.getString("sc.s_campaignname").substring(0, 40);
                        } else {
                            strCampaignname = rsP.getString("sc.s_campaignname");
                        }
                        String inst = "insert into stamptempreportsum(ccode,cname,point,redeem, custtel, custname) values(?,?,?,?,?,?)";
                        Statement stmt = (Statement) dbUtility.con.createStatement();
                        PreparedStatement prm = dbUtility.con.prepareStatement(inst);
                        prm.setString(1, rsP.getString("st.use_branch"));
                        prm.setString(2, rsP.getString("b.name"));
                        prm.setInt(3, rsP.getInt("stamppoint"));
                        prm.setInt(4, rsP.getInt("stamppredeem"));
                        prm.setString(5, rsP.getString("st.stamp_campaign"));
                        prm.setString(6, strCampaignname);
                        prm.executeUpdate();
                    } while (rsP.next());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void ProcessPrintBean() {
        try {
            getLanguage lang = new getLanguage();
            Map parm = new HashMap();
            JRBeanCollectionDataSource ds = null;
            ds = new JRBeanCollectionDataSource(EStamp.EStampReport.dataBeanSumUse_ByBarcode1.getCollectionSumUseByBarcode(Seek));
            parm.put("companyName", lang.getTextCompanyReport());
            parm.put("application", new GetApplicationName().getApplicationName());
            parm.put("user", new GetUser().getUser());

            String frmName = "rptSummaryEStampByBranch";
            String rptName = "ES_rptSumUsebyBranch";
            Report_ES rpt = new Report_ES();
            rpt.viewReportbean(rptName, parm, frmName, ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}