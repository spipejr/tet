/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.browseMasterSAP;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ping.interfaceSAP.entity.sap_mastercode_cashbank;
import ping.interfaceSAP.utilitySAP;

/**
 *
 * @author soneping
 */
public class browse_sap_cashbank extends javax.swing.JDialog {

    /**
     * Creates new form browse_sap_cashbank
     */
    DefaultTableModel model;
    utilitySAP us = new utilitySAP();
    sap_mastercode_cashbank smc = new sap_mastercode_cashbank();
    ArrayList<sap_mastercode_cashbank> list;
    String cashcode = "";
    String cashname = "";

    public browse_sap_cashbank(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        model = us.setTable(jTable1, "1,", "0,", ",");

        us.resetTable(model);
        list = smc.seekAll();
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                        list.get(i).getCash_code(),
                        list.get(i).getCash_name()
                    });

        }
        if (jTable1.getRowCount() > 0) {
            jTable1.setRowSelectionInterval(0, 0);
            jTable1.setFocusable(true);
            jTable1.requestFocus();
        }
    }

    public String getCashcode() {
        return cashcode;
    }

    public String getCashname() {
        return cashname;
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
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Code", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(330);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-460)/2, (screenSize.height-680)/2, 460, 680);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            pickup();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            pickup();
        } else if (evt.getKeyCode() == evt.VK_ESCAPE) {
            this.cashcode = "";
            this.cashname = "";
            dispose();
        }
    }//GEN-LAST:event_jTable1KeyPressed

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
            java.util.logging.Logger.getLogger(browse_sap_cashbank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(browse_sap_cashbank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(browse_sap_cashbank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(browse_sap_cashbank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                browse_sap_cashbank dialog = new browse_sap_cashbank(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void pickup() {
        int row = jTable1.getSelectedRow();

        this.cashcode = jTable1.getValueAt(row, 0).toString();
        this.cashname = jTable1.getValueAt(row, 1).toString();
        dispose();
    }
}