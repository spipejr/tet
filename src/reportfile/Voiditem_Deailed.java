/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportfile;

import dbutility.dbUtility;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import jxl.write.WriteException;
import masterfile.NimbusFrame;
import net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor;
import static report.databeanMasterfile.cvth;
import utilititiesfunction.Export2Excel;

/**
 *
 * @author march
 */
public class Voiditem_Deailed extends javax.swing.JDialog {

    dbUtility db = new dbUtility();
    DefaultTableModel model = new DefaultTableModel();
    VoidItem_Maindetail vm = new VoidItem_Maindetail(new NimbusFrame(), true);
    public static String condate01 = "", condate02 = "", bran1 = "", bran2 = "", area1 = "", area2 = "", cash1 = "", cash2 = "", gradr1 = "", grade2 = "", otp1 = "", otp2 = "", dateshow1 = "", dateshow2 = "";
    private String condition = "";

    public Voiditem_Deailed(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        new dbUtility().dbconnect();
        LoadinTable();
        settable();
        setText();
//        jTable1.setAutoResizeMode ( jTable1.AUTO_RESIZE_ALL_COLUMNS );
//JScrollPane tableScroll = new JScrollPane ( jTable1 );
    }

    public Voiditem_Deailed() {

    }

    public void settable() {
        jTable1.setShowGrid(true);
//        Jtable_DataVoid.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.setRowSelectionAllowed(true);
        jTable1.setShowGrid(true);
        jTable1.setBackground(Color.WHITE);
        jTable1.setGridColor(Color.LIGHT_GRAY);

        JTableHeader header = jTable1.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
        jTable1.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
        jTable1.setRowHeight(30);
//        TableColumn header_ = jTable1.getTableHeader().getColumnModel().getColumn(0);
//        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
//        jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(1).setPreferredWidth(60);
//        jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
//        jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
//        jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
//        jTable1.getColumnModel().getColumn(6).setPreferredWidth(120);
//        jTable1.getColumnModel().getColumn(7).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(8).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(9).setPreferredWidth(120);
//        jTable1.getColumnModel().getColumn(10).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(11).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(12).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(13).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(14).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(15).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(16).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(17).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(18).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(19).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(20).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(21).setPreferredWidth(70);
//        jTable1.getColumnModel().getColumn(22).setPreferredWidth(50);
    }

    public void setText() {
        txtshowdate1.setText(dateshow1);
        txtshowdate2.setText(dateshow2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtshowdate1 = new javax.swing.JLabel();
        txtshowdate2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        jLabel1.setText("รายงานการVoid(ใน)แบบละเอียด");

        jLabel2.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        jLabel2.setText("วันที่");

        txtshowdate1.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        txtshowdate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtshowdate1.setText("xx/xx/xxxx");

        txtshowdate2.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        txtshowdate2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtshowdate2.setText("xx/xx/xxxx");

        jLabel5.setFont(new java.awt.Font("Norasi", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("-");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton1.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LogOut-icon.png"))); // NOI18N
        jButton1.setText("Exit");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Printer-icon.png"))); // NOI18N
        jButton2.setText("Print");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton3.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Excel-icon.png"))); // NOI18N
        jButton3.setText("Exel File");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtshowdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtshowdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(jLabel1)))
                .addGap(73, 73, 73)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtshowdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtshowdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(605, 605, 605))
        );

        jTable1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัสสาขา", "เขต", "เกรด", "เครื่องNO", "รหัสแคชเชียร์", "ชื่อ-นามสกุล", "วันที่", "เลขที่บิล", "PLU", "ชื่อสินค้า", "จำนวน", "ราคา", "เวลาเปิดบิล", "เวลาบันทึก", "เวลาพักบิล", "เวลาพิมพ์บิล", "เวลาชำระเงิน", "เวลาVoid", "ผู้Void", "OTP", "เหตุผล", "สถานะ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Export2Excel test = new Export2Excel();
        JFileChooser chooser = new JFileChooser();

        chooser.setSelectedFile(test.getDefaulepath());
        chooser.setFileFilter(new JRSingleSheetXlsSaveContributor(Locale.ENGLISH, null));

        int confirm = chooser.showSaveDialog(this);
        if (confirm == JFileChooser.APPROVE_OPTION) {

            File curFile = chooser.getSelectedFile();

            if (curFile.exists()) {
                int confirm2 = JOptionPane.showConfirmDialog(this, "ข้อมูลนี้มีอยู่แล้ว คุณต้องการบันทึกรายการนี้หรือไม่...?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm2 == JOptionPane.NO_OPTION) {
                    test.setDefaultpath(curFile);
                    jButton3ActionPerformed(null);

                    return;

                }

            }
            DefaultTableModel dtb;
            JTableHeader jtb;
            dtb = (DefaultTableModel) jTable1.getModel();
            jtb = jTable1.getTableHeader();
            try {
                test.setOutputFile(curFile.toString());
                test.write2single(dtb, jtb);
                test.setDefaultpath(curFile);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex);
            } catch (WriteException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void LoadinTable() {
//        String otp1 = "";
//        String otp2 = "";

        String sql = "SELECT S_Bran,bf.BArea,bf.voidgroup,sv.MacNo,Cashier,pos.Name,sv.s_Date,Ref_No,sv.PCode,pro.PDesc,qty,Amt,logintime,Time,holdtime,prnbilltime,cashtime,VoidTime,VoidUser,OTP,r_voidmsg,voidoption\n"
                + "from s_void sv "
                + "left join branfile bf on sv.S_Bran = bf.Code "
                + "left join posuser pos on sv.VoidUser = pos.UserName "
                + "left join product pro on sv.PCode = pro.PCode "
                + "where "
                + "sv.s_Date>='" + cvth.Unicode2ASCII(condate01) + "' and s_Date<='" + cvth.Unicode2ASCII(condate02) + "' "
                + "and sv.S_Bran >='" + cvth.Unicode2ASCII(bran1) + "'and sv.S_Bran<='" + cvth.Unicode2ASCII(bran2) + "' "
                + "and BArea >='" + cvth.Unicode2ASCII(area1) + "'and Barea<='" + cvth.Unicode2ASCII(area2) + "' "
                + "and substring_index(cashier,'-',1) >='" + cvth.Unicode2ASCII(cash1) + "' and substring_index(cashier,'-',1)<='" + cvth.Unicode2ASCII(cash2) + "' "
                + "and voidgroup >='" + cvth.Unicode2ASCII(gradr1) + "'and voidgroup<='" + cvth.Unicode2ASCII(grade2) + "' "
                + "and OTP>=' " + otp1 + "'and OTP<='" + otp2 + "' "
                + "order by s_bran ";
//                + "limit 4000";
        try {
            Statement st = (Statement) dbUtility.con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] row;
                row = new Object[22];
                row[0] = rs.getString("s_bran");
                row[1] = rs.getString("BArea");
                row[2] = rs.getString("bf.voidgroup");
                row[3] = rs.getString("MacNo");
                row[4] = rs.getString("Cashier");
                row[5] = cvth.ASCII2Unicode(rs.getString("Pos.Name"));
                row[6] = rs.getString("S_date");
                row[7] = rs.getString("Ref_No");
                row[8] = rs.getString("PCode");
                row[9] = cvth.ASCII2Unicode(rs.getString("pro.PDesc"));
                row[10] = rs.getString("qty");
                row[11] = rs.getString("Amt");
                row[12] = rs.getString("logintime");
                row[13] = rs.getString("Time");
                row[14] = rs.getString("holdtime");
                row[15] = rs.getString("prnbilltime");
                row[16] = rs.getString("cashtime");
                row[17] = rs.getString("VoidTime");
                row[18] = rs.getString("VoidUser");
                row[19] = rs.getString("OTP");
                row[20] = rs.getString("r_voidmsg");
                row[21] = rs.getString("voidoption");

                model.addRow(row);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

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
            java.util.logging.Logger.getLogger(Voiditem_Deailed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Voiditem_Deailed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Voiditem_Deailed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Voiditem_Deailed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Voiditem_Deailed dialog = new Voiditem_Deailed(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtshowdate1;
    private javax.swing.JLabel txtshowdate2;
    // End of variables declaration//GEN-END:variables
}
