/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frmlist;

import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utilititiesfunction.ThaiUtilities;
import utilititiesfunction.getLanguage;

/**
 *
 * @author s386
 */
public class listCampaign extends javax.swing.JDialog {

    /**
     * Creates new form listCampaign
     */
    DefaultTableModel tbBranctype ;
    dbUtility db = new dbUtility();
    Statement stmt ;
    String frmName = "listcampaign";
    ThaiUtilities cvth = new ThaiUtilities();
    public String bcode = "";
    public String bname = "";
    int index = 0;
    public listCampaign(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tbBranctype = (DefaultTableModel) tbl.getModel();
        tbl.setShowGrid(true);
        tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl.setRowSelectionAllowed(true);
        tbl.setBackground(java.awt.Color.WHITE);
        tbl.setGridColor(java.awt.Color.gray);
        JTableHeader header = tbl.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        //tblBtype.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tbl.setRowHeight(25);
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

        db_btnExit = new javax.swing.JButton();
        db_btnOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        db_btnExit.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnExit.setText("ออก (Exit)");
        db_btnExit.setName("db_btnExit");
        db_btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnExitActionPerformed(evt);
            }
        });

        db_btnOK.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnOK.setText("ตกลง (OK)");
        db_btnOK.setName("db_btnOK");
        db_btnOK.setPreferredSize(new java.awt.Dimension(77, 36));
        db_btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnOKActionPerformed(evt);
            }
        });

        tbl.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ชื่อแคมเปญ", "รายละเอียด"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.setName("tbl");
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(0);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(250);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(db_btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(db_btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(db_btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-460)/2, (screenSize.height-504)/2, 460, 504);
    }// </editor-fold>//GEN-END:initComponents

    private void db_btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnExitActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnExitActionPerformed

    private void db_btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnOKActionPerformed
        bcode = tbl.getValueAt(index, 0).toString();
        bname = tbl.getValueAt(index, 1).toString();
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnOKActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        index = tbl.getSelectedRow();
        if (evt.getClickCount() == 2) {
            index = tbl.getSelectedRow();
            if (index != -1) {

                try {


                    bcode = tbl.getValueAt(index, 0).toString();
                    bname = tbl.getValueAt(index, 1).toString();
                    this.dispose();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMouseClicked

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {
            index = tbl.getSelectedRow();
            if (index != -1) {

                try {

                    bcode = tbl.getValueAt(index, 0).toString();
                    bname = tbl.getValueAt(index, 1).toString();
                    this.dispose();

                } catch (Exception e) {
                }

            }
        }

        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            this.dispose();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKeyPressed

    private void tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyReleased
        index = tbl.getSelectedRow();
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKeyReleased

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
            java.util.logging.Logger.getLogger(listCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                listCampaign dialog = new listCampaign(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
private void showdata() {
    stmt = null;
    ResultSet rs = null;
    
   
    tbBranctype = (DefaultTableModel) tbl.getModel();
     int cnt = tbBranctype.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                tbBranctype.removeRow(0);
            }
        }
    try {
        stmt = (Statement) dbUtility.con.createStatement();
        String sql = "select * from campaignfile order by campaign_code";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            tbBranctype.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("campaign_code")),cvth.ASCII2Unicode(rs.getString("campaign_name"))});
            }
            else
            {
            tbBranctype.addRow(new Object[]{rs.getString("campaign_Acode"),rs.getString("campaign_name")});
            }
        }
    } catch (Exception e) {
    }
    }
}
