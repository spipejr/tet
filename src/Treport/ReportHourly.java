/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treport;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import jxl.write.WriteException;
import net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor;
import org.jdesktop.swingx.JXTree;
//import reportModel.reportSaleOfPluModel;
//import reportModel.reportSumSaleOfPluModel;
//import reportfile.rptSaleOfPlu;
//import static reportfile.rptSumSaleOfPlu.barea1;
//import static reportfile.rptSumSaleOfPlu.barea2;
//import static reportfile.rptSumSaleOfPlu.bplan1;
//import static reportfile.rptSumSaleOfPlu.bplan2;
//import static reportfile.rptSumSaleOfPlu.branch1;
//import static reportfile.rptSumSaleOfPlu.branch2;
//import static reportfile.rptSumSaleOfPlu.brand1;
//import static reportfile.rptSumSaleOfPlu.brand2;
//import static reportfile.rptSumSaleOfPlu.bsize1;
//import static reportfile.rptSumSaleOfPlu.bsize2;
//import static reportfile.rptSumSaleOfPlu.bstore1;
//import static reportfile.rptSumSaleOfPlu.bstore2;
//import static reportfile.rptSumSaleOfPlu.btype1;
//import static reportfile.rptSumSaleOfPlu.btype2;
//import static reportfile.rptSumSaleOfPlu.bustype1;
//import static reportfile.rptSumSaleOfPlu.bustype2;
//import static reportfile.rptSumSaleOfPlu.code;
//import static reportfile.rptSumSaleOfPlu.company1;
//import static reportfile.rptSumSaleOfPlu.company2;
//import static reportfile.rptSumSaleOfPlu.date1;
//import static reportfile.rptSumSaleOfPlu.date2;
//import static reportfile.rptSumSaleOfPlu.dept1;
//import static reportfile.rptSumSaleOfPlu.dept2;
//import static reportfile.rptSumSaleOfPlu.name;
//import static reportfile.rptSumSaleOfPlu.plu1;
//import static reportfile.rptSumSaleOfPlu.plu2;
//import static reportfile.rptSumSaleOfPlu.strday;
import utilititiesfunction.*;
public class ReportHourly extends javax.swing.JDialog {

     public static String date1 = "",date2 ="",dept1="",dept2="",plu1="",plu2="",branch1="",branch2="",btype1="",btype2=""
            ,barea1="",barea2="",bsize1="",bsize2="",bplan1="",bplan2="",bstore1="",bstore2="",strday=""
            ,company1="",company2="",brand1="",brand2="",bustype1="",bustype2="",code="",name="";
    private Font fontbold = new Font("Norasi", Font.BOLD, 14);
    private Font fontplain = new Font("Norasi", Font.PLAIN, 14);
    String frmName = "ReportHourly";
    ThaiUtilities cvth = new ThaiUtilities();
    private String condition = "";
    
    
    
    public ReportHourly(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inittbl();
        getLanguage lang = new getLanguage();
        lang.setText(frmName, this, lang.getChklang());
        setTxt();
    }

    public ReportHourly() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new org.jdesktop.swingx.JXTreeTable();
        db_btnPrint = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lbldate = new javax.swing.JLabel();
        db_lblh1 = new javax.swing.JLabel();
        db_btnExpand = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        tbl.setName("tbl"); // NOI18N
        jScrollPane1.setViewportView(tbl);

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

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbldate.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lbldate.setText("-");
        lbldate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        db_lblh1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh1.setText("วันที่ (Date)");
        db_lblh1.setName("db_lblh1"); // NOI18N

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
                .addComponent(db_lblh1)
                .addGap(18, 18, 18)
                .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addComponent(db_btnExpand)
                .addGap(5, 5, 5))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(db_btnExpand)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(db_lblh1)
                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
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

                if(curFile.exists())
                {
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
                    JOptionPane.showMessageDialog(this, ex);
                }

            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_db_btnExelActionPerformed

    private void db_btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnPrintActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnPrintActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExit1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReportHourly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportHourly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportHourly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportHourly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportHourly dialog = new ReportHourly(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbldate;
    private org.jdesktop.swingx.JXTreeTable tbl;
    // End of variables declaration//GEN-END:variables
private void inittbl()
{
    try {
            
            TableColumnModel tcm = new DefaultTableColumnModel();
            
            TableColumn tc1 = new TableColumn(0,300);
            tc1.setHeaderValue("S_branch");
            TableColumn tc2 = new TableColumn(1,100);
            tc2.setHeaderValue("ช่วงเวลา");
            TableColumn tc3 = new TableColumn(2,100);
            tc3.setHeaderValue("รหัสสินค้า");
            TableColumn tc4 = new TableColumn(3,250);
            tc4.setHeaderValue("ชื่อสินค้า");
            TableColumn tc5 = new TableColumn(4,100);
            tc5.setHeaderValue("จำนวน");
            TableColumn tc6 = new TableColumn(5,100);
            tc6.setHeaderValue("ราคา");
            TableColumn tc7 = new TableColumn(6,100);
            tc7.setHeaderValue("หน่วยนับ");
            
            tcm.addColumn(tc1);
            tcm.addColumn(tc2);
            tcm.addColumn(tc3);
            tcm.addColumn(tc4);
            tcm.addColumn(tc5);
            tcm.addColumn(tc6);
            tcm.addColumn(tc7);
            
 
        
        tcm.getColumn(0).setCellRenderer(FormatCell.l());
        tcm.getColumn(1).setCellRenderer(FormatCell.l());
        tcm.getColumn(2).setCellRenderer(FormatCell.l());
        tcm.getColumn(3).setCellRenderer(FormatCell.l());
        tcm.getColumn(4).setCellRenderer(FormatCell.r());
        tcm.getColumn(5).setCellRenderer(FormatCell.r());
        tcm.getColumn(6).setCellRenderer(FormatCell.l());
       
        
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
            if(!date1.equals(""))
            {
            Date d = Format.dateFmtShow.parse(date1);
            d1= Format.dateFmtSql.format(d);
            }
            if(!date2.equals(""))
            {
            Date dd = Format.dateFmtShow.parse(date2);
            d2= Format.dateFmtSql.format(dd);
            }
            String sql="";
            if(dbutility.dbUtility.Char_Set.equalsIgnoreCase("utf-8"))
            {
//            sql = "SELECT punit1,s_price,pdesc,s_pcode,pgroup,b.name as branchname,bt.btname as Btypename,ar.name as BAreaname"
//                        + ",si.name as BSizename,pl.name as BPlanname,st.name as BStorename,com.name as Companyname"
//                        + ",bf.brandname as Brandname,bust.busname as Bustypename,gf.groupname as PGroupName"
//                        + ",p.pgroup as PGroupCode,b.code as BranchCode,b.btype as BtypeCode,b.barea as BAreacode"
//                        + ",b.bsize as BSizecode,b.bplane as BPlancode,b.bstore as BStorecode,b.companycode as Companycode"
//                        + ",b.brandcode as Brandcode,b.buscode as Bustypecode"
//                        + ",sum(e_qty) as e_qty,sum(e_amt) as e_amt,sum(e_disc) as e_disc,sum(e_net) as e_net"
//                        + ",sum(t_qty) as t_qty,sum(t_amt) as t_amt,sum(t_disc) as t_disc,sum(t_net) as t_net"
//                        + ",sum(d_qty) as d_qty,sum(d_amt) as d_amt,sum(d_disc) as d_disc,sum(d_net) as d_net"
//                        + ",sum(p_qty) as p_qty,sum(p_amt) as p_amt,sum(p_disc) as p_disc,sum(p_net) as p_net"
//                        + ",sum(w_qty) as w_qty,sum(w_amt) as w_amt,sum(w_disc) as w_disc,sum(w_net) as w_net"
//                        + ",sum(s_qty) as s_qty,sum(s_amt) as s_amt,sum(s_disc) as s_disc,sum(s_net) as s_net "
//                        + "FROM dplu d "
//                        + "inner join branfile b on d.s_bran = b.code "
//                        + "left join product p on d.s_pcode = p.pcode "
//                        + "left join groupfile gf on p.pgroup = gf.groupcode "
//                        + "left join btype bt on b.btype = bt.btcode "
//                        + "left join area ar on b.barea = ar.code "
//                        + "left join size si on b.bsize = si.code "
//                        + "left join plane pl on b.bplane = pl.code "
//                        + "left join store st on b.bstore = st.code "
//                        + "left join businesstype bust on b.buscode = bust.buscode "
//                        + "left join brandfile bf on b.brandcode = bf.brandcode "
//                        + "left join company com on b.companycode = com.code "
//                        +"where " 
//                        +"d.s_date>= '"+d1+"' and d.s_date<='"+d2+"' "
//                        +"and (p.pgroup >='"+dept1+"' and p.pgroup <= '"+dept2+"' or p.pgroup is null) "
//                        +"and d.s_pcode >= '"+plu1+"' and d.s_pcode <= '"+plu2+"' "
//                        +"and d.s_bran >= '"+branch1+"' and d.s_bran <= '"+branch2+"' "
//                        +"and b.btype >= '"+btype1+"' and b.btype <= '"+btype2+"' "
//                        +"and b.barea >= '"+barea1+"' and b.barea <= '"+barea2+"' "
//                        +"and b.bsize >= '"+bsize1+"' and b.bsize <= '"+bsize2+"' "
//                        +"and b.bplane >= '"+bplan1+"' and b.bplane <= '"+bplan2+"' "
//                        +"and b.bstore >= '"+bstore1+"' and b.bstore <= '"+bstore2+"' "
//                        +"and b.companycode >= '"+company1+"' and b.companycode <= '"+company2+"' "
//                        +"and b.brandcode >= '"+brand1+"' and b.brandcode <= '"+brand2+"' "
//                        +"and b.buscode >= '"+bustype1+"' and b.buscode <= '"+bustype2+"' "
//                        +"and locate(dayofweek(d.s_date),'"+strday+"')>0 "
//                        +"group by "+code+",s_pcode order by "+code+",s_pcode";
            
            sql = "Select Hour(PTimeOut),dkictran.PCode,PDesc,Sum(PQty) as Qty,PPrice11,PUnit1,bf.brandname as Brandname,b.code as BranchCode "
                    + "From dkictran "
                    + "inner join product Product On Product.PCode=dkictran.PCode "
                    + "inner join branfile b on dkictran.s_bran = b.code "
                    + "left join brandfile bf on b.brandcode = bf.brandcode "
                    + "Where (PDate between '" + d1 + "' and '" + d2 + "') and (PFlage='Y') "
                    + "Group By Hour(PTimeOut),dkictran.PCode "
                    + "Order By Hour(PTimeOut),Qty Desc";
            
            }
            else
            {
//                  sql = "Select Hour(PTimeOut) as time,dkictran.PCode as PCode ,PDesc as PDesc,Sum(PQty) as Qty,PPrice11 as price,PUnit1 as unit,b.name as branchname,b.code as BranchCode "
//                    + "From dkictran "
//                    + "left join product Product On Product.PCode=dkictran.PCode "
//                    + "left join branfile b on dkictran.s_bran = b.code "
//                    //+ "left join brandfile bf on b.brandcode = bf.brandcode "
//                    + "Where (PDate between '" + d1 + "' and '" + d2 + "') and (PFlage='Y') "
//                    +"group by "+code+",time,PCode order by "+code+",time,PCode";
                  
                sql = "Select Hour(PTimeOut) as time,dk.PCode as PCode ,PDesc as PDesc,Sum(PQty) as Qty,PPrice11 as price,PUnit1 as unit,b.name as branchname,b.code as BranchCode "
                + " From dkictran dk"
                + " left join product P On dk.PCode = P.PCode  "
                + " left join branfile b on dk.s_bran = b.code "
                + "Where (PDate between '" + d1 + "' and '" + d2 + "') and (PFlage='Y') "
                +"group by "+code+",time,PCode order by "+code+",time,PCode";
                
                
                
//                sql = "SELECT punit1,s_price,pdesc,s_pcode,pgroup,b.name as branchname,bt.btname as Btypename,ar.name as BAreaname"
//                        + ",si.name as BSizename,pl.name as BPlanname,st.name as BStorename,com.name as Companyname"
//                        + ",bf.brandname as Brandname,bust.busname as Bustypename,gf.groupname as PGroupName"
//                        + ",p.pgroup as PGroupCode,b.code as BranchCode,b.btype as BtypeCode,b.barea as BAreacode"
//                        + ",b.bsize as BSizecode,b.bplane as BPlancode,b.bstore as BStorecode,b.companycode as Companycode"
//                        + ",b.brandcode as Brandcode,b.buscode as Bustypecode"
//                        + ",sum(e_qty) as e_qty,sum(e_amt) as e_amt,sum(e_disc) as e_disc,sum(e_net) as e_net"
//                        + ",sum(t_qty) as t_qty,sum(t_amt) as t_amt,sum(t_disc) as t_disc,sum(t_net) as t_net"
//                        + ",sum(d_qty) as d_qty,sum(d_amt) as d_amt,sum(d_disc) as d_disc,sum(d_net) as d_net"
//                        + ",sum(p_qty) as p_qty,sum(p_amt) as p_amt,sum(p_disc) as p_disc,sum(p_net) as p_net"
//                        + ",sum(w_qty) as w_qty,sum(w_amt) as w_amt,sum(w_disc) as w_disc,sum(w_net) as w_net"
//                        + ",sum(s_qty) as s_qty,sum(s_amt) as s_amt,sum(s_disc) as s_disc,sum(s_net) as s_net "
//                        + "FROM dplu d "
//                        + "inner join branfile b on d.s_bran = b.code "
//                        + "left join product p on d.s_pcode = p.pcode "
//                        + "left join groupfile gf on p.pgroup = gf.groupcode "
//                        + "left join btype bt on b.btype = bt.btcode "
//                        + "left join area ar on b.barea = ar.code "
//                        + "left join size si on b.bsize = si.code "
//                        + "left join plane pl on b.bplane = pl.code "
//                        + "left join store st on b.bstore = st.code "
//                        + "left join businesstype bust on b.buscode = bust.buscode "
//                        + "left join brandfile bf on b.brandcode = bf.brandcode "
//                        + "left join company com on b.companycode = com.code "
//                        +"where " 
//                        +"d.s_date>= '"+d1+"' and d.s_date<='"+d2+"' "
//                        +"and (p.pgroup >='"+cvth.Unicode2ASCII(dept1)+"' and p.pgroup <= '"+cvth.Unicode2ASCII(dept2)+"' or p.pgroup is null) "
//                        +"and d.s_pcode >= '"+cvth.Unicode2ASCII(plu1)+"' and d.s_pcode <= '"+cvth.Unicode2ASCII(plu2)+"' "
//                        +"and d.s_bran >= '"+cvth.Unicode2ASCII(branch1)+"' and d.s_bran <= '"+cvth.Unicode2ASCII(branch2)+"' "
//                        +"and b.btype >= '"+cvth.Unicode2ASCII(btype1)+"' and b.btype <= '"+cvth.Unicode2ASCII(btype2)+"' "
//                        +"and b.barea >= '"+cvth.Unicode2ASCII(barea1)+"' and b.barea <= '"+cvth.Unicode2ASCII(barea2)+"' "
//                        +"and b.bsize >= '"+cvth.Unicode2ASCII(bsize1)+"' and b.bsize <= '"+cvth.Unicode2ASCII(bsize2)+"' "
//                        +"and b.bplane >= '"+cvth.Unicode2ASCII(bplan1)+"' and b.bplane <= '"+cvth.Unicode2ASCII(bplan2)+"' "
//                        +"and b.bstore >= '"+cvth.Unicode2ASCII(bstore1)+"' and b.bstore <= '"+cvth.Unicode2ASCII(bstore2)+"' "
//                        +"and b.companycode >= '"+cvth.Unicode2ASCII(company1)+"' and b.companycode <= '"+cvth.Unicode2ASCII(company2)+"' "
//                        +"and b.brandcode >= '"+cvth.Unicode2ASCII(brand1)+"' and b.brandcode <= '"+cvth.Unicode2ASCII(brand2)+"' "
//                        +"and b.buscode >= '"+cvth.Unicode2ASCII(bustype1)+"' and b.buscode <= '"+cvth.Unicode2ASCII(bustype2)+"' "
//                        +"and locate(dayofweek(d.s_date),'"+strday+"')>0 "
//                        +"group by "+code+",s_pcode order by "+code+",s_pcode";
            }
            ReportHourlyofplumodel treemodel = new ReportHourlyofplumodel(sql,code,name);
            tbl.setTreeTableModel(treemodel);
            tbl.setColumnModel(tcm);
            tbl.setRootVisible(true);
            ((JXTree)tbl.getCellRenderer(0,tbl.getHierarchicalColumn())).setFont(fontplain);
            setTxt();
            JTableHeader h = tbl.getTableHeader();
            h.setFont(fontbold);
            //h.setReorderingAllowed(false);
            tbl.setLeafIcon(null);
        } catch (ParseException ex) {
//            Logger.getLogger(rptSaleOfPlu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
//            Logger.getLogger(rptSaleOfPlu.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void setTxt()
    {
        String date = "";
        String branch = "";
        String dept = "";
        String plu = "";
        if(!date1.equals(""))
        {
        date = date1+" - ";
        }
        else
        {
        date = " - ";
        }

        if(!date2.equals("31/12/9999"))
        {
            date += date2;
        }

        if(!branch1.equals(""))
        {
            branch = branch1+" - ";
        }
        else
        {
            branch = " - ";
        }

        if(!branch2.equals("ZZZ"))
        {
            branch += branch2;
        }

        if(!dept1.equals(""))
        {
            dept = dept1+" - ";
        }
        else
        {
            dept = " - ";
        }

        if(!dept2.equals("ZZZZ"))
        {
            dept += dept2;
        }

        if(!plu1.equals(""))
        {
            plu = plu1+" - ";
        }
        else
        {
            plu = " - ";
        }

        if(!plu2.equals("ZZZZZZZZZZZZZ"))
        {
            plu += plu2;
        }

        lbldate.setText(date);

        condition = this.getTitle()+" Date : "+date+" Dept : "+dept+" PLU : "+plu;
    }
    

}

