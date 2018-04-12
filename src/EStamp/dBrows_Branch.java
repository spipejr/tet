package EStamp;

import Entity.BranchCodeName;
import com.mysql.jdbc.PreparedStatement;
import dbutility.dbUtility;
import frmlist.BrowserBranchGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import masterfile.NimbusFrame;
import utilititiesfunction.ThaiUtilities;

public class dBrows_Branch extends javax.swing.JDialog {

    dbUtility db = new dbUtility();
    showMessage msn = new showMessage();

    public BranchCodeName dataRecord;
    public String scode;
    public String procode;
    public String name;
    private Statement stmt;

    ThaiUtilities cvth = new ThaiUtilities();

    JCheckBox checkbox = new JCheckBox();

    public dBrows_Branch(java.awt.Frame parent, boolean modal, String scode, String procode) {
        super(parent, modal);
        initComponents();
        checkuserconfig();
        db.dbconnect();
        this.scode = scode;
        this.procode = procode;
        try {
            stmt = (Statement) dbUtility.con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTable();
        clearForm();
        loadBranchgroup();
    }

    public dBrows_Branch(java.awt.Frame parent, boolean modal, Point point) {
        this(parent, modal, "", "");
        this.setLocation(point);
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
        tblList = new javax.swing.JTable();
        btnok = new javax.swing.JButton();
        btnok1 = new javax.swing.JButton();
        btnok2 = new javax.swing.JButton();
        btnok3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("แสดงรายการสาขา (ฺBranchfile)");

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "เลือก", "กลุ่มสาขา", "รหัสสาขา", "ชื่อสาขา"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        tblList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblListKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);
        if (tblList.getColumnModel().getColumnCount() > 0) {
            tblList.getColumnModel().getColumn(0).setResizable(false);
            tblList.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblList.getColumnModel().getColumn(1).setPreferredWidth(90);
            tblList.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblList.getColumnModel().getColumn(3).setPreferredWidth(275);
        }

        btnok.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnok.setText("ตกลง (OK)");
        btnok.setName("DBbtnok"); // NOI18N
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });

        btnok1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnok1.setText("ยกเลิก (Cancel)");
        btnok1.setName("DBbtnok"); // NOI18N
        btnok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnok1ActionPerformed(evt);
            }
        });

        btnok2.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnok2.setText("Check All");
        btnok2.setName("DBbtnok"); // NOI18N
        btnok2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnok2ActionPerformed(evt);
            }
        });

        btnok3.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnok3.setText("UnCheck All");
        btnok3.setName("DBbtnok"); // NOI18N
        btnok3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnok3ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel3.setText("จำนวน  0  รายการ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnok2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnok3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnok, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnok1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnok2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnok3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnok, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnok1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        setSize(new java.awt.Dimension(560, 656));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private void checkuserconfig() {
        //MenuName = Mast1

    }
    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
    }//GEN-LAST:event_tblListMouseClicked

    private void tblListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListKeyPressed

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed
        try {
            for (int i = 0; i < tblList.getRowCount(); i++) {
                String chkbox = tblList.getValueAt(i, 0).toString();
                if (chkbox.equalsIgnoreCase("true")) {
                    if (!chk(scode, procode, tblList.getValueAt(i, 2).toString())) {
                        stmt = (Statement) dbUtility.con.createStatement();
                        String sql = "Insert into stamppro_linkbranch (s_code,sp_code,bcode) "
                                + " values(?,?,?)";
                        PreparedStatement prm2 = (PreparedStatement) dbUtility.con.prepareStatement(sql);
                        prm2.setString(1, scode);
                        prm2.setString(2, procode);
                        prm2.setString(3, tblList.getValueAt(i, 2).toString());
                        prm2.executeUpdate();
                        stmt.close();
                    }
                } else {
                    stmt = (Statement) dbUtility.con.createStatement();
                    String sql2 = "Delete from stamppro_linkbranch where bcode = ? and sp_code = '" + procode + "' and s_code='" + scode + "' ";
                    PreparedStatement prm2 = (PreparedStatement) dbUtility.con.prepareStatement(sql2);
                    prm2.setString(1, tblList.getValueAt(i, 2).toString());
                    prm2.executeUpdate();
                    stmt.close();
                }
            }
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnokActionPerformed

    private void btnok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnok1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnok1ActionPerformed

    private void btnok2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnok2ActionPerformed
        int cnt = model.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                model.removeRow(0);
            }
        }
        try {
            String sql = "select bgroup,name,code "
                    + "from branfile order by bgroup,code ";
            stmt = dbUtility.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{true,
                    cvth.ASCII2Unicode(rs.getString("bgroup")),
                    cvth.ASCII2Unicode(rs.getString("code")),
                    cvth.ASCII2Unicode(rs.getString("name"))
                });
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_btnok2ActionPerformed

    private void btnok3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnok3ActionPerformed
        int cnt = model.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                model.removeRow(0);
            }
        }
        try {
            String sql = "select bgroup,name,code "
                    + "from branfile order by bgroup,code ";
            stmt = dbUtility.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{false,
                    cvth.ASCII2Unicode(rs.getString("bgroup")),
                    cvth.ASCII2Unicode(rs.getString("code")),
                    cvth.ASCII2Unicode(rs.getString("name"))
                });
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnok3ActionPerformed

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
            java.util.logging.Logger.getLogger(dBrows_Branch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dBrows_Branch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dBrows_Branch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dBrows_Branch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                dBrows_Branch dialog = new dBrows_Branch(new javax.swing.JFrame(), true, "", "");
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
    private javax.swing.JButton btnok;
    private javax.swing.JButton btnok1;
    private javax.swing.JButton btnok2;
    private javax.swing.JButton btnok3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblList;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel model;

    private void resetTable() {
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            model.removeRow(0);
        }
    }

    private void setTable() {
        model = (DefaultTableModel) tblList.getModel();

        tblList.setShowGrid(true);
        tblList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblList.setRowSelectionAllowed(true);
        tblList.setShowGrid(true);
        tblList.setBackground(Color.WHITE);
        tblList.setGridColor(Color.LIGHT_GRAY);

        JTableHeader header = tblList.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tblList.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
        tblList.setRowHeight(25);
        tblList.setAutoCreateRowSorter(true);

        ((DefaultTableCellRenderer) tblList.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        TableColumnModel tcm = tblList.getColumnModel();
        DefaultTableCellRenderer d;

        d = new DefaultTableCellRenderer();
        d.setHorizontalAlignment(SwingConstants.CENTER);
        tcm.getColumn(1).setCellRenderer(d);
        tcm.getColumn(2).setCellRenderer(d);

        d = new DefaultTableCellRenderer();
        d.setHorizontalAlignment(SwingConstants.LEFT);
        tcm.getColumn(3).setCellRenderer(d);

        d = new DefaultTableCellRenderer();
        d.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    public BranchCodeName getDataRecord() {
        return dataRecord;
    }

    public boolean chk(String scode, String pcode, String bcode) {
        ResultSet rs;
        boolean chk = false;
        String sql;
        BranchCodeName fb = new BranchCodeName();

        try {
            sql = "SELECT * FROM stamppro_linkbranch WHERE bcode='" + bcode + "' and sp_code = '" + pcode + "' and s_code='" + scode + "' ";
            stmt = dbUtility.con.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return chk = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chk;
    }

    public BranchCodeName getRecordAt(String GroupCode) {
        ResultSet rs;
        String sql;
        BranchCodeName fb = new BranchCodeName();

        try {
            sql = "SELECT * FROM branfilepro WHERE Code='" + GroupCode + "'";
            stmt = dbUtility.con.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs != null) {

                while (rs.next()) {
                    if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                        fb.setCode(cvth.ASCII2Unicode(rs.getString("Code")));
                        fb.setName(cvth.ASCII2Unicode(rs.getString("Name")));
                    } else {
                        fb.setCode(rs.getString("Code"));
                        fb.setName(rs.getString("Name"));
                    }
                }
                return fb;

            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private void browsBranchgroup(JTextField bgcode, JButton jbt) {
        Point point = jbt.getLocation();
        point.setLocation(point.getX() + 1, point.getY() + 1);
        BrowserBranchGroup dialog = new BrowserBranchGroup(new NimbusFrame(), true, point);
        dialog.setVisible(true);

        try {
            if (!dialog.code.equals("")) {
                BranchCodeName hrb = dialog.getDataRecord();
                bgcode.setText(dialog.code);
                jbt.requestFocus();
            } else {
                bgcode.requestFocus();
            }
        } catch (Exception e) {
            bgcode.requestFocus();
        }

        try {

//            dBrows_Branchgroup frm = new dBrows_Branchgroup(null, true);
//            frm.setVisible(true);
//            if (frm.getBgcode().length() > 0) {
//                bgcode.setText(frm.getBgcode());
//            } else {
//                bgcode.setText("");
//                bgcode.requestFocus();
//            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }


    private void loadBranchgroup() {
        resetTable();
        try {
            String sql = "select b.bgroup,b.name,b.code "
                    + "from branfile b  "
                    + "left join stamppro_linkbgroup sg on b.bgroup = sg.bgcode "
                    + "where sg.s_code='" + scode + "' and sg.sp_code='" + procode + "' "
                    + "order by bgroup,code ";
            stmt = dbUtility.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    chk(scode, procode, rs.getString("code")),
                    cvth.ASCII2Unicode(rs.getString("bgroup")),
                    cvth.ASCII2Unicode(rs.getString("code")),
                    cvth.ASCII2Unicode(rs.getString("name"))
                });
            }
            int row = tblList.getRowCount();
            jLabel3.setText("จำนวน  " + row + "  รายการ");
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearForm() {
        jLabel3.setText("");
    }
}
