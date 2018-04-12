/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package masterfile;

import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utilititiesfunction.ThaiUtilities;
import utilititiesfunction.getLanguage;

/**
 *
 * @author s386
 */
public class listBranchGroup extends javax.swing.JDialog {

    /**
     * Creates new form listBranchGroup
     */
    DefaultTableModel tbBranctype ;
    dbUtility db = new dbUtility();
    Statement stmt ;
    String frmName = "listbranchgroup";
    ThaiUtilities cvth = new ThaiUtilities();
    public String bcode = "";
    public String bname = "";
    int index = 0;
    public listBranchGroup(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tbBranctype = (DefaultTableModel) tblBgroup.getModel();
        tblBgroup.setShowGrid(true);
        tblBgroup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblBgroup.setRowSelectionAllowed(true);
        tblBgroup.setBackground(java.awt.Color.WHITE);
        tblBgroup.setGridColor(java.awt.Color.gray);
        JTableHeader header = tblBgroup.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        //tblBtype.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tblBgroup.setRowHeight(25);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBgroup = new javax.swing.JTable();
        db_btnOK = new javax.swing.JButton();
        db_btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("แสดงรายการกลุ่มสาขา (Branch Group)");

        tblBgroup.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tblBgroup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ประเภทสาขา", "รายละเอียด"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBgroup.setName("tblBgroup");
        tblBgroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBgroupMouseClicked(evt);
            }
        });
        tblBgroup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblBgroupKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblBgroupKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblBgroup);
        tblBgroup.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblBgroup.getColumnModel().getColumn(1).setPreferredWidth(250);

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
        setBounds((screenSize.width-460)/2, (screenSize.height-507)/2, 460, 507);
    }// </editor-fold>//GEN-END:initComponents

    private void db_btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnOKActionPerformed
                    bcode = tblBgroup.getValueAt(index, 0).toString();
                    bname = tblBgroup.getValueAt(index, 1).toString();  
                    this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnOKActionPerformed

    private void db_btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnExitActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnExitActionPerformed

    private void tblBgroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBgroupMouseClicked
         index = tblBgroup.getSelectedRow();
        if (evt.getClickCount() == 2) {
             index = tblBgroup.getSelectedRow();
            if (index != -1) {
                
                try {

                    
                    bcode = tblBgroup.getValueAt(index, 0).toString();
                    bname = tblBgroup.getValueAt(index, 1).toString();  
                    this.dispose();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBgroupMouseClicked

    private void tblBgroupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblBgroupKeyPressed
         
        if (evt.getKeyCode() == evt.VK_ENTER) {
             index = tblBgroup.getSelectedRow();
            if (index != -1) {
                
                try {

                   bcode = tblBgroup.getValueAt(index, 0).toString();
                   bname = tblBgroup.getValueAt(index, 1).toString();  
                   this.dispose();

                } catch (Exception e) {
                }

            }
        }

        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            this.dispose();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBgroupKeyPressed

    private void tblBgroupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblBgroupKeyReleased
        index = tblBgroup.getSelectedRow();
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBgroupKeyReleased

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
            java.util.logging.Logger.getLogger(listBranchGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listBranchGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listBranchGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listBranchGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                listBranchGroup dialog = new listBranchGroup(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblBgroup;
    // End of variables declaration//GEN-END:variables

    private void showdata() {
    stmt = null;
    ResultSet rs = null;
    
   
    tbBranctype = (DefaultTableModel) tblBgroup.getModel();
     int cnt = tbBranctype.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                tbBranctype.removeRow(0);
            }
        }
    try {
        stmt = (Statement) dbUtility.con.createStatement();
        String sql = "select * from branchgroup order by bgroupcode";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            tbBranctype.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("bgroupcode")),cvth.ASCII2Unicode(rs.getString("bgroupname"))});
            }
            else
            {
            tbBranctype.addRow(new Object[]{rs.getString("bgroupcode"),rs.getString("bgroupname")});
            }
        }
    } catch (Exception e) {
    }
    }
}
