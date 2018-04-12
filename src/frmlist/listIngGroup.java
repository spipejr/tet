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
public class listIngGroup extends javax.swing.JDialog {

    /**
     * Creates new form listIngGroup
     */
    DefaultTableModel tbList ;
    dbUtility db = new dbUtility();
    Statement stmt ;
    String frmName = "listinggroup";
    ThaiUtilities cvth = new ThaiUtilities();
    public String code = "";
    public String name = "";
    int index = 0;
    public listIngGroup(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tbList = (DefaultTableModel) tblList.getModel();
        tblList.setShowGrid(true);
        tblList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblList.setRowSelectionAllowed(true);
        tblList.setBackground(java.awt.Color.WHITE);
        tblList.setGridColor(java.awt.Color.gray);
        JTableHeader header = tblList.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        //tblBtype.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tblList.setRowHeight(25);
        tblList.setAutoCreateRowSorter(true);
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

        db_btnOK = new javax.swing.JButton();
        db_btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        tblList.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัสกลุ่มวัตถุดิบ", "รายละเอียด"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.setName("tblList");
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        tblList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblListKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);
        tblList.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblList.getColumnModel().getColumn(1).setPreferredWidth(250);

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
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(db_btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-460)/2, (screenSize.height-507)/2, 460, 507);
    }// </editor-fold>//GEN-END:initComponents

    private void db_btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnOKActionPerformed
        code = tblList.getValueAt(index, 0).toString();
        name = tblList.getValueAt(index, 1).toString();
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnOKActionPerformed

    private void db_btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnExitActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnExitActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        index = tblList.getSelectedRow();
        if (evt.getClickCount() == 2) {
            index = tblList.getSelectedRow();
            if (index != -1) {

                try {


                    code = tblList.getValueAt(index, 0).toString();
                    name = tblList.getValueAt(index, 1).toString();
                    this.dispose();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListMouseClicked

    private void tblListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {
            index = tblList.getSelectedRow();
            if (index != -1) {

                try {

                    code = tblList.getValueAt(index, 0).toString();
                    name = tblList.getValueAt(index, 1).toString();
                    this.dispose();

                } catch (Exception e) {
                }

            }
        }

        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            this.dispose();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListKeyPressed

    private void tblListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListKeyReleased
        index = tblList.getSelectedRow();
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListKeyReleased

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
            java.util.logging.Logger.getLogger(listIngGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listIngGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listIngGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listIngGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                listIngGroup dialog = new listIngGroup(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblList;
    // End of variables declaration//GEN-END:variables

private void showdata() {
    stmt = null;
    ResultSet rs = null;
    
   
    tbList = (DefaultTableModel) tblList.getModel();
     int cnt = tbList.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                tbList.removeRow(0);
            }
        }
    try {
        stmt = (Statement) dbUtility.con.createStatement();
        String sql = "select * from inggroup order by inggroupcode";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            tbList.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("inggroupcode")),cvth.ASCII2Unicode(rs.getString("inggroupname"))});
            }
            else
            {
            tbList.addRow(new Object[]{rs.getString("inggroupcode"),rs.getString("inggroupname")});
            }
        }
    } catch (Exception e) {
    }
    }
}
