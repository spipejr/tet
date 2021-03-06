/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.report;

import EStamp.showMessage;
import borfunction.GetApplicationName;
import borfunction.GetUser;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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
import utilititiesfunction.Export2Excel;
import utilititiesfunction.FormatCell;
import utilititiesfunction.ThaiUtilities;
import utilititiesfunction.getLanguage;

/**
 *
 * @author pos
 */
public class report_veiw_sapproduct extends javax.swing.JDialog {

    public static String code = "", name = "", product1 = "", product2 = "", pgroup1 = "", pgroup2 = "", cpctive = "N", cmapsap = "N";
    public static String blink1 = "", blink2 = "";
    private Font fontbold = new Font("Norasi", Font.BOLD, 14);
    private Font fontplain = new Font("Norasi", Font.PLAIN, 14);
    String frmName = "report_veiw_sapproduct";
    ThaiUtilities cvth = new ThaiUtilities();
    private String condition = "";
    private String Seek = "";
    showMessage msn = new showMessage();

    public report_veiw_sapproduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inittbl();
//        getLanguage lang = new getLanguage();
//        lang.setText(frmName, this, lang.getChklang());
        setTxt();
    }

    public report_veiw_sapproduct() {

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
        lbldate = new javax.swing.JLabel();
        db_lblh1 = new javax.swing.JLabel();
        db_lblh2 = new javax.swing.JLabel();
        lblbranch = new javax.swing.JLabel();
        db_btnExpand = new javax.swing.JButton();
        db_btnExel = new javax.swing.JButton();
        db_btnPrint = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new org.jdesktop.swingx.JXTreeTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbldate.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lbldate.setText("-");
        lbldate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        db_lblh1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh1.setText("รหัสสินค้า");
        db_lblh1.setName("db_lblh1"); // NOI18N

        db_lblh2.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh2.setText("กลุ่มสินค้า");
        db_lblh2.setName("db_lblh2"); // NOI18N

        lblbranch.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lblbranch.setText("-");
        lblbranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(db_lblh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(db_lblh2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbranch, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(db_btnExpand)
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(db_btnExpand)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(db_lblh1)
                            .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(db_lblh2)
                            .addComponent(lblbranch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jScrollPane2.setViewportView(tbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnExel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(db_btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1010, 780));
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
        if (tbl.getRowCount() > 2) {
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
        } else {
            msn.showMessageInformation("ไม่พบข้อมูลตามเงื่อนไขที่ระบุ...");
        }

    }//GEN-LAST:event_db_btnExelActionPerformed

    private void db_btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnPrintActionPerformed
        //        ProcessPrint();
        if (tbl.getRowCount() > 2) {
            ProcessPrintBean();
        } else {
            msn.showMessageInformation("ไม่พบข้อมูลตามเงื่อนไขที่ระบุ...");
        }
    }//GEN-LAST:event_db_btnPrintActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        this.dispose();
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
            java.util.logging.Logger.getLogger(report_veiw_sapproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(report_veiw_sapproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(report_veiw_sapproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(report_veiw_sapproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                report_veiw_sapproduct dialog = new report_veiw_sapproduct(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblbranch;
    private javax.swing.JLabel lbldate;
    private org.jdesktop.swingx.JXTreeTable tbl;
    // End of variables declaration//GEN-END:variables

    private void inittbl() {
        try {
            TableColumnModel tcm = new DefaultTableColumnModel();

            TableColumn tc1 = new TableColumn(0, 210);
            tc1.setHeaderValue("กลุ่มสินค้า");
            TableColumn tc2 = new TableColumn(1, 90);
            tc2.setHeaderValue("รหัสสินค้า");
            TableColumn tc3 = new TableColumn(2, 220);
            tc3.setHeaderValue("รายละเอียด");
            TableColumn tc4 = new TableColumn(3, 50);
            tc4.setHeaderValue("Active");
//            TableColumn tc5 = new TableColumn(4, 50);
//            tc5.setHeaderValue("กลุ่มสาขา");
            TableColumn tc5 = new TableColumn(4, 150);
            tc5.setHeaderValue("SAP Article");
            TableColumn tc6 = new TableColumn(5, 220);
            tc6.setHeaderValue("SAP Article Name");

            tcm.addColumn(tc1);
            tcm.addColumn(tc2);
            tcm.addColumn(tc3);
            tcm.addColumn(tc4);
            tcm.addColumn(tc5);
            tcm.addColumn(tc6);
//            tcm.addColumn(tc7);

            tcm.getColumn(0).setCellRenderer(FormatCell.l());
            tcm.getColumn(1).setCellRenderer(FormatCell.l());
            tcm.getColumn(2).setCellRenderer(FormatCell.l());
            tcm.getColumn(3).setCellRenderer(FormatCell.c());
//            tcm.getColumn(4).setCellRenderer(FormatCell.c());
            tcm.getColumn(4).setCellRenderer(FormatCell.colorL());
            tcm.getColumn(5).setCellRenderer(FormatCell.colorL());

            tbl.setEditable(false);//ห้ามแก้ไขตาราง
            tbl.setShowGrid(true);
            tbl.setFont(fontplain);
            tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbl.setRowSelectionAllowed(true);
            tbl.setBackground(java.awt.Color.WHITE);
            tbl.setGridColor(java.awt.Color.gray);
            tbl.setRowHeight(24);

            tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            if (dbutility.dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
//                Seek = "select p.pgroup as pgroup, g.groupname as groupname, p.pcode as pcode, p.pdesc as pdesc, "
//                        + "p.pactive as pactive,  p.sap_article as sap_article, p.sap_article_name as sap_article_name, bl.bgroup as bgroup  "
//                        + "from product p "
//                        + "left join groupfile g on p.pgroup = g.groupcode "
//                        + "left join blink bl on bl.pcode = p.pcode "
//                        + "where p.pcode>='" + product1 + "' and p.pcode<='" + product2 + "' "
//                        + "and p.pgroup>='" + pgroup1 + "' and p.pgroup<='" + pgroup2 + "' "
//                        + "and bl.bgroup>='" + blink1 + "' and  bl.bgroup<='" + blink2 + "' ";

                Seek = "select bl.pdept as pgroup, g.groupname as groupname, bl.pcode as pcode, p.pdesc as pdesc, "
                        + "p.pactive as pactive,  bl.bgroup as bgroup  ,p.sap_article as sap_article, p.sap_article_name as sap_article_name "
                        + "from blink bl "
                        + "left join groupfile g on bl.pdept = g.groupcode "
                        + "left join product p on bl.pcode = p.pcode "
                        + "where  bl.pcode>='" + product1 + "' and bl.pcode<='" + product2 + "' "
                        + "and bl.pdept>='" + pgroup1 + "' and bl.pdept<='" + pgroup2 + "' "
                        + "and bl.bgroup>='" + blink1 + "' and  bl.bgroup<='" + blink2 + "' ";

                if (cpctive.equals("1")) {
                    Seek += " and p.pactive='Y' ";
                } else if (cpctive.equals("2")) {
                    Seek += " and p.pactive='N' ";
                }

                if (cmapsap.equals("1")) {
                    Seek += " and p.sap_article !='' ";
                } else if (cmapsap.equals("2")) {
                    Seek += " and p.sap_article='' ";
                }
                Seek += "group by bl.pcode  ";
                Seek += "order by bl.pcode, bl.pdept, bl.bgroup, p.sap_article";
//                Seek += "group by bl.bgroup,p.pcode ";
//                Seek += "order by bl.bgroup, p.pgroup, p.pcode, p.sap_article";
            } else {
//                Seek = "select p.pgroup as pgroup, g.groupname as groupname, p.pcode as pcode, p.pdesc as pdesc, "
//                        + "p.pactive as pactive,  p.sap_article as sap_article, p.sap_article_name as sap_article_name, bl.bgroup as bgroup "
//                        + "from product p "
//                        + "left join groupfile g on p.pgroup = g.groupcode "
//                        + "left join blink bl on bl.pcode = p.pcode "
//                        + "where p.pcode>='" + cvth.Unicode2ASCII(product1) + "' and p.pcode<='" + cvth.Unicode2ASCII(product2) + "' "
//                        + "and p.pgroup>='" + cvth.Unicode2ASCII(pgroup1) + "' and p.pgroup<='" + cvth.Unicode2ASCII(pgroup2) + "' "
//                        + "and bl.bgroup>='" + cvth.Unicode2ASCII(blink1) + "' and  bl.bgroup<='" + cvth.Unicode2ASCII(blink2) + "' ";

                Seek = "select bl.pdept as pgroup, g.groupname as groupname, bl.pcode as pcode, p.pdesc as pdesc, "
                        + "p.pactive as pactive,  bl.bgroup as bgroup  ,p.sap_article as sap_article, p.sap_article_name as sap_article_name "
                        + "from blink bl "
                        + "left join groupfile g on bl.pdept = g.groupcode "
                        + "left join product p on bl.pcode = p.pcode "
                        + "where  bl.pcode>='" + cvth.Unicode2ASCII(product1) + "' and bl.pcode<='" + cvth.Unicode2ASCII(product2) + "' "
                        + "and bl.pdept>='" + cvth.Unicode2ASCII(pgroup1) + "' and bl.pdept<='" + cvth.Unicode2ASCII(pgroup2) + "' "
                        + "and bl.bgroup>='" + cvth.Unicode2ASCII(blink1) + "' and  bl.bgroup<='" + cvth.Unicode2ASCII(blink2) + "' ";

                if (cpctive.equals("1")) {
                    Seek += " and p.pactive='Y' ";
                } else if (cpctive.equals("2")) {
                    Seek += " and p.pactive='N' ";
                }

                if (cmapsap.equals("1")) {
                    Seek += " and p.sap_article !='' ";
                } else if (cmapsap.equals("2")) {
                    Seek += " and p.sap_article='' ";
                }

                Seek += "group by bl.pcode  ";
                Seek += "order by bl.pcode, bl.pdept, bl.bgroup, p.sap_article";
//                Seek += "group by bl.bgroup,p.pcode ";
//                Seek += "order by bl.bgroup, p.pgroup, p.pcode, p.sap_article";
            }
            System.out.println("seek//" + Seek);
            report_sapproduct treemodel = new report_sapproduct(Seek, code);
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTxt() {
        String pcode = "";
        String pgroup = "";
        if (!product1.equals("")) {
            pcode = product1 + " - ";
        } else {
            pcode = " - ";
        }

        if (!product2.equals("")) {
            pcode += product2;
        } else {
            pcode += "ZZZZ";
        }

        if (!pgroup1.equals("")) {
            pgroup = pgroup1 + " - ";
        } else {
            pgroup = " - ";
        }

        if (!pgroup2.equals("")) {
            pgroup += pgroup2;
        } else {
            pgroup += "ZZZZ";
        }

        lbldate.setText(pcode);
        lblbranch.setText(pgroup);
        this.setTitle("รายงานแสดงรายการสินค้า ");
        condition = "รายงานแสดงรายการสินค้า  " + " รหัสสินค้า : " + pcode + "  ,กลุ่มสินค้า " + pgroup;
    }

    private void ProcessPrintBean() {
        try {
            getLanguage lang = new getLanguage();
            Map parm = new HashMap();
            JRBeanCollectionDataSource ds = null;
            ds = new JRBeanCollectionDataSource(ping.interfaceSAP.report.databean_sap_product.getCollection(Seek));
            parm.put("companyname", lang.getTextCompanyReport());
            parm.put("application", new GetApplicationName().getApplicationName());
            parm.put("user", new GetUser().getUser());

            String frmName = "report_veiw_sapproduct";
            String rptName = "reportfile_sapproduct";
            Report_SAP rpt = new Report_SAP();
            rpt.viewReportbean(rptName, parm, frmName, ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
