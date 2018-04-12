/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frmlist;

import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import utilititiesfunction.ThaiUtilities;
import utilititiesfunction.Format;
import utilititiesfunction.getLanguage;

/**
 *
 * @author s386
 */
public class listPOSConfig extends javax.swing.JDialog {

    /**
     * Creates new form listPOSConfig
     */
    SimpleDateFormat dateFmtShow = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    DefaultTableModel tbCoupon ;
    dbUtility db = new dbUtility();
    Statement stmt ;
    String frmName = "listposconfig";
    ThaiUtilities cvth = new ThaiUtilities();
    public String bcode = "";
    public String bname = "";
    int index = 0;
    public listPOSConfig(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        DefaultTableCellRenderer r;
        r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer c;
        c = new DefaultTableCellRenderer();
        c.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer l;
        l = new DefaultTableCellRenderer();
        l.setHorizontalAlignment(SwingConstants.LEFT);
 
        
        //tblCoupon
        tbCoupon = (DefaultTableModel) tblCoupon.getModel();
        tblCoupon.setShowGrid(true);
        tblCoupon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblCoupon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblCoupon.setRowSelectionAllowed(true);
        tblCoupon.setBackground(java.awt.Color.WHITE);
        tblCoupon.setGridColor(java.awt.Color.gray);
        JTableHeader headerc = tblCoupon.getTableHeader();
        headerc.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tblCoupon.setRowHeight(25);
      
        tblCoupon.setAutoCreateRowSorter(true);
        TableColumnModel tcmc = tblCoupon.getColumnModel();
        tcmc.getColumn(0).setCellRenderer(l);
        tcmc.getColumn(1).setCellRenderer(l);
        tcmc.getColumn(2).setCellRenderer(l);
        tcmc.getColumn(3).setCellRenderer(l);
        tcmc.getColumn(4).setCellRenderer(l);
        tcmc.getColumn(5).setCellRenderer(l);
        tcmc.getColumn(6).setCellRenderer(l);
        tcmc.getColumn(7).setCellRenderer(l);
        tcmc.getColumn(8).setCellRenderer(l);
        tcmc.getColumn(9).setCellRenderer(l);
        tcmc.getColumn(10).setCellRenderer(l);
        tcmc.getColumn(11).setCellRenderer(l);
        tcmc.getColumn(12).setCellRenderer(l);
        tcmc.getColumn(13).setCellRenderer(l);
        tcmc.getColumn(14).setCellRenderer(l);
        tcmc.getColumn(15).setCellRenderer(l);
        tcmc.getColumn(16).setCellRenderer(l);
        tcmc.getColumn(17).setCellRenderer(l);
        tcmc.getColumn(18).setCellRenderer(l);
        tcmc.getColumn(19).setCellRenderer(l);
        tcmc.getColumn(20).setCellRenderer(l);
        tcmc.getColumn(21).setCellRenderer(l);
        tcmc.getColumn(22).setCellRenderer(l);
        tcmc.getColumn(23).setCellRenderer(l);
        tcmc.getColumn(24).setCellRenderer(l);
        tcmc.getColumn(25).setCellRenderer(l);
        tcmc.getColumn(26).setCellRenderer(l);
        tcmc.getColumn(27).setCellRenderer(l);
        tcmc.getColumn(28).setCellRenderer(l);
        tcmc.getColumn(29).setCellRenderer(l);
        tcmc.getColumn(30).setCellRenderer(l);
        tcmc.getColumn(31).setCellRenderer(l);
        tcmc.getColumn(32).setCellRenderer(l);
        tcmc.getColumn(33).setCellRenderer(l);
        tcmc.getColumn(34).setCellRenderer(l);
        tcmc.getColumn(35).setCellRenderer(l);
        tcmc.getColumn(36).setCellRenderer(l);
        tcmc.getColumn(37).setCellRenderer(l);
        tcmc.getColumn(38).setCellRenderer(l);
        tcmc.getColumn(39).setCellRenderer(l);
        tcmc.getColumn(40).setCellRenderer(l);
        tcmc.getColumn(41).setCellRenderer(l);
        tcmc.getColumn(42).setCellRenderer(l);
        tcmc.getColumn(43).setCellRenderer(l);
        tcmc.getColumn(44).setCellRenderer(l);
        
        
        //tblBtype.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tblCoupon.setRowHeight(25);
        db.dbconnect();
        showdata();
        
        getLanguage lang = new getLanguage();
        lang.setText(frmName, this, lang.getChklang());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblCoupon = new javax.swing.JTable();
        db_btnOK = new javax.swing.JButton();
        db_btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblCoupon.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tblCoupon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCoupon.setName("tbl");
        tblCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCouponMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCouponMouseReleased(evt);
            }
        });
        tblCoupon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCouponKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCouponKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblCouponKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tblCoupon);
        tblCoupon.getColumnModel().getColumn(1).setPreferredWidth(200);

        db_btnOK.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnOK.setText("ตกลง (OK)");
        db_btnOK.setName("db_btnOK");
        db_btnOK.setPreferredSize(new java.awt.Dimension(77, 36));
        db_btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnOKActionPerformed(evt);
            }
        });

        db_btnExit.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnExit.setText("ออก (Exit)");
        db_btnExit.setName("db_btnExit");
        db_btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(db_btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(db_btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-851)/2, (screenSize.height-507)/2, 851, 507);
    }// </editor-fold>//GEN-END:initComponents

    private void tblCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCouponMouseClicked
        index = tblCoupon.getSelectedRow();
        if (evt.getClickCount() == 2) {
            index = tblCoupon.getSelectedRow();
            if (index != -1) {

                try {


                    bcode = tblCoupon.getValueAt(index, 0).toString();
                    bname = tblCoupon.getValueAt(index, 1).toString();
                    this.dispose();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCouponMouseClicked

    private void tblCouponMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCouponMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCouponMouseReleased

    private void tblCouponKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCouponKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            index = tblCoupon.getSelectedRow();
            if (index != -1) {

                try {

                    bcode = tblCoupon.getValueAt(index, 0).toString();
                    bname = tblCoupon.getValueAt(index, 1).toString();
                    this.dispose();

                } catch (Exception e) {
                }

            }
        }

        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            this.dispose();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCouponKeyPressed

    private void tblCouponKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCouponKeyReleased
        index = tblCoupon.getSelectedRow();

        // TODO add your handling code here:
    }//GEN-LAST:event_tblCouponKeyReleased

    private void tblCouponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCouponKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCouponKeyTyped

    private void db_btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnOKActionPerformed
        bcode = tblCoupon.getValueAt(index, 0).toString();
        bname = tblCoupon.getValueAt(index, 1).toString();
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnOKActionPerformed

    private void db_btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnExitActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(listPOSConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listPOSConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listPOSConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listPOSConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                listPOSConfig dialog = new listPOSConfig(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton db_btnExit;
    private javax.swing.JButton db_btnOK;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCoupon;
    // End of variables declaration//GEN-END:variables
private void showdata() {
    stmt = null;
    ResultSet rs = null;
    
   
    tbCoupon = (DefaultTableModel) tblCoupon.getModel();
     int cnt = tbCoupon.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                tbCoupon.removeRow(0);
            }
        }
    try {
        stmt = (Statement) dbUtility.con.createStatement();
        String sql = "SELECT * FROM posconfigsetup p inner join branchgroup b on p.p_terminal = b.bgroupcode order by p_terminal";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            tbCoupon.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("p_terminal")),
                                      cvth.ASCII2Unicode(rs.getString("bgroupname")),
                                      Format.doubleFmt.format(rs.getDouble("p_vat")),
                                      cvth.ASCII2Unicode(rs.getString("p_vattype")),
                                      cvth.ASCII2Unicode(rs.getString("p_servicetype")),
                                      cvth.ASCII2Unicode(rs.getString("p_vatprn")),
                                      Format.doubleFmt.format(rs.getDouble("p_service")),
                                      cvth.ASCII2Unicode(rs.getString("p_billcopy")),
                                      cvth.ASCII2Unicode(rs.getString("p_billcopyone")),
                                      cvth.ASCII2Unicode(rs.getString("p_empuse")),
                                      cvth.ASCII2Unicode(rs.getString("p_codeprn")),
                                      cvth.ASCII2Unicode(rs.getString("p_checkbillbeforcash")),
                                      cvth.ASCII2Unicode(rs.getString("p_printdetailonrecp")),
                                      cvth.ASCII2Unicode(rs.getString("p_discround")),
                                      cvth.ASCII2Unicode(rs.getString("p_serviceround")),
                                      cvth.ASCII2Unicode(rs.getString("p_serchkbysaletype")),
                                      cvth.ASCII2Unicode(rs.getString("p_discchkbysaletype")),
                                      cvth.ASCII2Unicode(rs.getString("p_discbathchk")),
                                      Format.doubleFmt.format(rs.getDouble("p_discbathmax")),
                                      Format.doubleFmt.format(rs.getDouble("p_memamount")),
                                      Format.doubleFmt.format(rs.getDouble("p_memscore")),
                                      cvth.ASCII2Unicode(rs.getString("p_fastdisc")),
                                      cvth.ASCII2Unicode(rs.getString("p_fastdiscget")),
                                      cvth.ASCII2Unicode(rs.getString("p_fastdiscchk")),
                                      cvth.ASCII2Unicode(rs.getString("p_fastdiscmax")),
                                      cvth.ASCII2Unicode(rs.getString("p_empdisc")),
                                      cvth.ASCII2Unicode(rs.getString("p_empdiscget")),
                                      cvth.ASCII2Unicode(rs.getString("p_empdiscchk")),
                                      cvth.ASCII2Unicode(rs.getString("p_empdiscmax")),
                                      cvth.ASCII2Unicode(rs.getString("p_subdisc")),
                                      cvth.ASCII2Unicode(rs.getString("p_subdiscget")),
                                      cvth.ASCII2Unicode(rs.getString("p_subdiscchk")),
                                      cvth.ASCII2Unicode(rs.getString("p_subdiscmax")),
                                      cvth.ASCII2Unicode(rs.getString("p_memdisc")),
                                      cvth.ASCII2Unicode(rs.getString("p_memdiscget")),
                                      cvth.ASCII2Unicode(rs.getString("p_memdiscchk")),
                                      cvth.ASCII2Unicode(rs.getString("p_memdiscmax")),
                                      cvth.ASCII2Unicode(rs.getString("p_traindisc")),
                                      cvth.ASCII2Unicode(rs.getString("p_traindiscget")),
                                      cvth.ASCII2Unicode(rs.getString("p_traindiscchk")),
                                      cvth.ASCII2Unicode(rs.getString("p_traindiscmax")),
                                      cvth.ASCII2Unicode(rs.getString("p_printrecpmessage")),
                                      cvth.ASCII2Unicode(rs.getString("p_footer1")),
                                      cvth.ASCII2Unicode(rs.getString("p_footer2")),
                                      cvth.ASCII2Unicode(rs.getString("p_footer3")),
                                      cvth.ASCII2Unicode(rs.getString("p_footer4"))    
                                           });
            }
            else
            {
            tbCoupon.addRow(new Object[]{rs.getString("p_terminal"),
                                      rs.getString("bgroupname"),
                                      Format.doubleFmt.format(rs.getDouble("p_vat")),
                                      rs.getString("p_vattype"),
                                      rs.getString("p_servicetype"),
                                      rs.getString("p_vatprn"),
                                      Format.doubleFmt.format(rs.getDouble("p_service")),
                                      rs.getString("p_billcopy"),
                                      rs.getString("p_billcopyone"),
                                      rs.getString("p_empuse"),
                                      rs.getString("p_codeprn"),
                                      rs.getString("p_checkbillbeforcash"),
                                      rs.getString("p_printdetailonrecp"),
                                      rs.getString("p_discround"),
                                      rs.getString("p_serviceround"),
                                      rs.getString("p_serchkbysaletype"),
                                      rs.getString("p_discchkbysaletype"),
                                      rs.getString("p_discbathchk"),
                                      Format.doubleFmt.format(rs.getDouble("p_discbathmax")),
                                      Format.doubleFmt.format(rs.getDouble("p_memamount")),
                                      Format.doubleFmt.format(rs.getDouble("p_memscore")),
                                      rs.getString("p_fastdisc"),
                                      rs.getString("p_fastdiscget"),
                                      rs.getString("p_fastdiscchk"),
                                      rs.getString("p_fastdiscmax"),
                                      rs.getString("p_empdisc"),
                                      rs.getString("p_empdiscget"),
                                      rs.getString("p_empdiscchk"),
                                      rs.getString("p_empdiscmax"),
                                      rs.getString("p_subdisc"),
                                      rs.getString("p_subdiscget"),
                                      rs.getString("p_subdiscchk"),
                                      rs.getString("p_subdiscmax"),
                                      rs.getString("p_memdisc"),
                                      rs.getString("p_memdiscget"),
                                      rs.getString("p_memdiscchk"),
                                      rs.getString("p_memdiscmax"),
                                      rs.getString("p_traindisc"),
                                      rs.getString("p_traindiscget"),
                                      rs.getString("p_traindiscchk"),
                                      rs.getString("p_traindiscmax"),
                                      rs.getString("p_printrecpmessage"),
                                      rs.getString("p_footer1"),
                                      rs.getString("p_footer2"),
                                      rs.getString("p_footer3"),
                                      rs.getString("p_footer4")    
                                           });
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
    }
}
