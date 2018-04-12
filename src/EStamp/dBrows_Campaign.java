package EStamp;

import dbutility.dbUtility;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import utilititiesfunction.ThaiUtilities;

public class dBrows_Campaign extends javax.swing.JDialog {

    dbUtility db = new dbUtility();
    PreparedStatement pre = null;
    PreparedStatement preUp = null;
    ResultSet rs = null;

    showMessage msn = new showMessage();
    formatStamp f = new formatStamp();

    String sccode = "";
    String scname = "";
    String scdateStr = "";
    String scdateEnd = "";

    public String getSccode() {
        return sccode;
    }

    public String getScname() {
        return scname;
    }

    public String getScdateStr() {
        return scdateStr;
    }

    public String getScdateEnd() {
        return scdateEnd;
    }

    public dBrows_Campaign(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setTable();
        loadDataCampaignAll();
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
        tbl_campaign = new javax.swing.JTable();
        btn_choose = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("แสดงรายการแคมเปญ");

        tbl_campaign.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "รหัส", "ชื่อแคมเปญ", "วันที่เริ่ม", "วันที่สิ้นสุด", "หมายเหตุ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_campaign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_campaignMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_campaign);
        if (tbl_campaign.getColumnModel().getColumnCount() > 0) {
            tbl_campaign.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbl_campaign.getColumnModel().getColumn(1).setPreferredWidth(240);
            tbl_campaign.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbl_campaign.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbl_campaign.getColumnModel().getColumn(4).setPreferredWidth(260);
        }

        btn_choose.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btn_choose.setText("เลือก");
        btn_choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chooseActionPerformed(evt);
            }
        });

        btn_cancel.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btn_cancel.setText("ยกเลิก");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_choose, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_choose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(789, 497));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_campaignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_campaignMouseClicked
        int index = tbl_campaign.getSelectedRow();
        if (evt.getClickCount() == 2) {
            sccode = tbl_campaign.getValueAt(index, 0).toString();
            scname = tbl_campaign.getValueAt(index, 1).toString();
            scdateStr = tbl_campaign.getValueAt(index, 2).toString();
            scdateEnd = tbl_campaign.getValueAt(index, 3).toString();
            dispose();
        }
    }//GEN-LAST:event_tbl_campaignMouseClicked

    private void btn_chooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chooseActionPerformed
        int index = tbl_campaign.getSelectedRow();
        sccode = tbl_campaign.getValueAt(index, 0).toString();
        scname = tbl_campaign.getValueAt(index, 1).toString();
        scdateStr = tbl_campaign.getValueAt(index, 2).toString();
        scdateEnd = tbl_campaign.getValueAt(index, 3).toString();
        dispose();
    }//GEN-LAST:event_btn_chooseActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        sccode = "";
        scname = "";
        scdateStr = "";
        scdateEnd = "";
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(dBrows_Campaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dBrows_Campaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dBrows_Campaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dBrows_Campaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dBrows_Campaign dialog = new dBrows_Campaign(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_choose;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_campaign;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel model;

    private void resetTable() {
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            model.removeRow(0);
        }
    }

    private void setTable() {
        model = (DefaultTableModel) tbl_campaign.getModel();
        tbl_campaign.setShowGrid(true);
        tbl_campaign.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl_campaign.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl_campaign.setRowSelectionAllowed(true);
        tbl_campaign.setShowGrid(true);
        tbl_campaign.setBackground(Color.WHITE);
        tbl_campaign.setGridColor(Color.LIGHT_GRAY);

        JTableHeader header = tbl_campaign.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tbl_campaign.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
        tbl_campaign.setRowHeight(25);
        tbl_campaign.setAutoCreateRowSorter(true);

        ((DefaultTableCellRenderer) tbl_campaign.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        DecimalFormat DoubleFmt = new DecimalFormat("##,###,##0.00");
        DecimalFormat IntegerFmt = new DecimalFormat("##,###,##0");
        DecimalFormat PersentFmt = new DecimalFormat("#,##0.00%");

        TableColumnModel tcm = tbl_campaign.getColumnModel();

        DefaultTableCellRenderer d;

        d = new DefaultTableCellRenderer();
        d.setHorizontalAlignment(SwingConstants.CENTER);
        tcm.getColumn(2).setCellRenderer(d);
        tcm.getColumn(3).setCellRenderer(d);

        d = new DefaultTableCellRenderer();
        d.setHorizontalAlignment(SwingConstants.LEFT);
        tcm.getColumn(0).setCellRenderer(d);
        tcm.getColumn(1).setCellRenderer(d);
        tcm.getColumn(4).setCellRenderer(d);

    }

    ThaiUtilities cvth = new ThaiUtilities();

    private void loadDataCampaignAll() {
        resetTable();
        try {
            String sql = "select * from stampcampaign order by s_campaigncode ";
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                    do {
                        model.addRow(new Object[]{
                            cvth.ASCII2Unicode(rs.getString("s_campaigncode")),
                            cvth.ASCII2Unicode(rs.getString("s_campaignname")),
                            f.convertDatesqlToShow(rs.getString("s_campaignstart")),
                            f.convertDatesqlToShow(rs.getString("s_campaignend")),
                            cvth.ASCII2Unicode(rs.getString("s_campaignremark"))
                        });
                    } while (rs.next());
                } else {
                    do {
                        model.addRow(new Object[]{
                            rs.getString("s_campaigncode"),
                            rs.getString("s_campaignname"),
                            f.convertDatesqlToShow(rs.getString("s_campaignstart")),
                            f.convertDatesqlToShow(rs.getString("s_campaignend")),
                            rs.getString("s_campaignremark")
                        });
                    } while (rs.next());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            msn.showMessageError(e.getMessage());
        }
    }
}