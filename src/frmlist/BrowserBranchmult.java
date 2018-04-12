/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VenderList.java
 *
 * Created on Jun 9, 2012, 9:28:34 PM
 */
package frmlist;

import Entity.BranchCodeName;
import com.mysql.jdbc.PreparedStatement;
import dbutility.dbUtility;
import java.awt.Font;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utilititiesfunction.ThaiUtilities;
import utilititiesfunction.UserLogin;

/**
 *
 * @author natee
 */
public class BrowserBranchmult extends javax.swing.JDialog {

    dbUtility db = new dbUtility();
    private DefaultTableModel model;
    public BranchCodeName dataRecord;
    public String code;
    public String name;
    private Statement stmt;
    DefaultTableModel tbl_model;
    ThaiUtilities cvth = new ThaiUtilities();
    DefaultTableModel model3;

    /** Creates new form VenderList */
    public BrowserBranchmult(java.awt.Frame parent, boolean modal, String code, DefaultTableModel model3) {
        super(parent, modal);
        initComponents();
        checkuserconfig();
        db.dbconnect();
        this.code = code;
        try {
            stmt = (Statement) dbUtility.con.createStatement();
        } catch (Exception e) {
        }
        this.model3 = model3;

        tbl_model = (DefaultTableModel) tblList.getModel();
        tblList.setShowGrid(true);
        tblList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tblList.setRowSelectionAllowed(true);
        tblList.setAutoCreateRowSorter(true);
        tblList.setBackground(java.awt.Color.WHITE);
        tblList.setGridColor(java.awt.Color.gray);
        JTableHeader header = tblList.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
        tblList.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
        tblList.setRowHeight(25);
        initTable();
    }

    public BrowserBranchmult(java.awt.Frame parent, boolean modal, Point point) {
        this(parent, modal, "", new DefaultTableModel());
        this.setLocation(point);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "เลือก", "รหัสกลุ่มสาขา", "รหัสสาขา", "ชื่อสาขา"
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
        tblList.getColumnModel().getColumn(0).setResizable(false);
        tblList.getColumnModel().getColumn(0).setPreferredWidth(70);
        tblList.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblList.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblList.getColumnModel().getColumn(3).setPreferredWidth(280);

        btnok.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ok.png"))); // NOI18N
        btnok.setText("ตกลง (OK)");
        btnok.setName("DBbtnok"); // NOI18N
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });

        btnok1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnok1.setText("ยกเลิก");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnok2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnok3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnok1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnok2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnok3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnok1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-578)/2, (screenSize.height-627)/2, 578, 627);
    }// </editor-fold>//GEN-END:initComponents
    private void checkuserconfig() {
         UserLogin userrec = UserLogin.userlogin;
        if (userrec.getMast19().equals("1")) {
            btnok.setEnabled(false);
        }
        if (userrec.getMast19().equals("2")) {
            btnok.setEnabled(true);
        }
        if (userrec.getMast19().equals("3")) {
            btnok.setEnabled(true);
        }
    
}
    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
    }//GEN-LAST:event_tblListMouseClicked

    private void tblListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListKeyPressed

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed


        try {
            for (int i = 0; i < tblList.getRowCount(); i++) {
//                    int a = tblList.getSelectedRow();
                String chkbox = tblList.getValueAt(i, 0).toString();
//                    JOptionPane.showMessageDialog(this, chkbox);
                if (chkbox.equalsIgnoreCase("true")) {
                    if (!chk(code, tblList.getValueAt(i, 2).toString())) {
                        if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                            stmt = (Statement) dbUtility.con.createStatement();
                            String sql = "Insert into fixbranch (bcode,cucode) "
                                    + " values(?,?)";
                            PreparedStatement prm2 = (PreparedStatement) dbUtility.con.prepareStatement(sql);
                            prm2.setString(2, cvth.Unicode2ASCII(code));
                            prm2.setString(1, cvth.Unicode2ASCII(tblList.getValueAt(i, 2).toString()));
                            prm2.executeUpdate();
                            stmt.close();
                        } else {
                            stmt = (Statement) dbUtility.con.createStatement();
                            String sql = "Insert into fixbranch (bcode,cucode) "
                                    + " values(?,?)";
                            PreparedStatement prm2 = (PreparedStatement) dbUtility.con.prepareStatement(sql);
                            prm2.setString(2, code);
                            prm2.setString(1, tblList.getValueAt(i, 2).toString());
                            prm2.executeUpdate();
                            stmt.close();
                        }
                    } 
                } else {
                        stmt = (Statement) dbUtility.con.createStatement();
                        String sql2 = "Delete from fixbranch where bcode = ? and CuCode = '" + code + "'";
                        PreparedStatement prm2 = (PreparedStatement) dbUtility.con.prepareStatement(sql2);
                        prm2.setString(1, tblList.getValueAt(i, 2).toString());
                        prm2.executeUpdate();
                        stmt.close();
                    }
            }
            dispose();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            for (int i = 0; i < tblList.getRowCount(); i++) {
//                    int a = tblList.getSelectedRow();
                String chkbox = tblList.getValueAt(i, 0).toString();
//                    JOptionPane.showMessageDialog(this, chkbox);
                if (chkbox.equalsIgnoreCase("true")) {
                    if (!chk(code, tblList.getValueAt(i, 2).toString())) {
                        if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                            
              
                            
                            stmt = (Statement) dbUtility.con.createStatement();
                            String sql = "Insert into culink (bcode,cucode,fixbranch) "
                                    + " values(?,?)";
                            PreparedStatement prm2 = (PreparedStatement) dbUtility.con.prepareStatement(sql);
                            prm2.setString(2, cvth.Unicode2ASCII(code));
                            prm2.setString(1, cvth.Unicode2ASCII(tblList.getValueAt(i, 2).toString()));
                            prm2.executeUpdate();
                            stmt.close();
                        } else {
                            stmt = (Statement) dbUtility.con.createStatement();
                            String sql = "Insert into fixbranch (bcode,cucode) "
                                    + " values(?,?)";
                            PreparedStatement prm2 = (PreparedStatement) dbUtility.con.prepareStatement(sql);
                            prm2.setString(2, code);
                            prm2.setString(1, tblList.getValueAt(i, 2).toString());
                            prm2.executeUpdate();
                            stmt.close();
                        }
                    }
                }
            }
            dispose();
        } catch (Exception e) {
            System.out.println(e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnokActionPerformed

    private void btnok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnok1ActionPerformed

        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnok1ActionPerformed

    private void btnok2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnok2ActionPerformed


        int cnt = model.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                model.removeRow(0);
            }
        }

        try {
            String where = "";
            for (int i = 0; i < model3.getRowCount(); i++) {
                if (i == 0) {
                    where = "bgroup = '" + model3.getValueAt(i, 0) + "'";
                } else {
                    where += " or bgroup = '" + model3.getValueAt(i, 0) + "'";
                }
            }

            String sql = "select bgroup,name,code "
                    + "from branfile where " + where + " ";
            stmt = dbUtility.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                    model.addRow(new Object[]{true,
                                cvth.ASCII2Unicode(rs.getString("bgroup")),
                                cvth.ASCII2Unicode(rs.getString("code")),
                                cvth.ASCII2Unicode(rs.getString("name")),});
                } else {
                    model.addRow(new Object[]{true,
                                rs.getString("bgroup"),
                                rs.getString("code"),
                                rs.getString("name"),});
                }
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnok2ActionPerformed

    private void btnok3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnok3ActionPerformed

        int cnt = model.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                model.removeRow(0);
            }
        }

        try {
            String where = "";
            for (int i = 0; i < model3.getColumnCount(); i++) {
                if (i == 0) {
                    where = "bgroup = '" + model3.getValueAt(i, 0) + "'";
                } else {
                    where += " or bgroup = '" + model3.getValueAt(i, 0) + "'";
                }
            }

            String sql = "select bgroup,name,code "
                    + "from branfile where " + where + " order by bgroup,code ";
            stmt = dbUtility.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                    model.addRow(new Object[]{false,
                                cvth.ASCII2Unicode(rs.getString("bgroup")),
                                cvth.ASCII2Unicode(rs.getString("code")),
                                cvth.ASCII2Unicode(rs.getString("name")),});
                } else {
                    model.addRow(new Object[]{true,
                                rs.getString("bgroup"),
                                rs.getString("code"),
                                rs.getString("name"),});
                }
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(BrowserBranchmult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrowserBranchmult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrowserBranchmult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrowserBranchmult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                BrowserBranchmult dialog = new BrowserBranchmult(new javax.swing.JFrame(), true, "", new DefaultTableModel());
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblList;
    // End of variables declaration//GEN-END:variables

    private void initTable() {

        model = (DefaultTableModel) tblList.getModel();
        tblList.setRowHeight(24);
        tblList.setFont(new Font("Norasi", Font.PLAIN, 14));
        JTableHeader tHeader = tblList.getTableHeader();
        tHeader.setFont(new Font("Norasi", Font.BOLD, 14));
        try {
            String sql = "select branfile.bgroup,name,code from branfile "
                    + "left join culink on culink.bgroup=branfile.bgroup "
                    + "where cucode='"+code+"' "
                    + "order by branfile.bgroup,code ";
            stmt = dbUtility.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                    model.addRow(new Object[]{chk(code, cvth.ASCII2Unicode(rs.getString("code"))),
                                cvth.ASCII2Unicode(rs.getString("bgroup")),
                                cvth.ASCII2Unicode(rs.getString("code")),
                                cvth.ASCII2Unicode(rs.getString("name")),});
                } else {
                    model.addRow(new Object[]{chk(code, rs.getString("code")),
                                rs.getString("bgroup"),
                                rs.getString("code"),
                                rs.getString("name"),});
                }
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public BranchCodeName getDataRecord() {
        return dataRecord;
    }

    public boolean chk(String code, String bcode) {
        ResultSet rs;
        boolean chk = false;
        String sql;
        BranchCodeName fb = new BranchCodeName();

        try {
            sql = "SELECT * FROM fixbranch WHERE bcode='" + bcode + "' and cucode = '" + code + "'";
            stmt = dbUtility.con.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return chk = true;
            }
        } catch (Exception e) {
        }
        return chk;
    }

    public BranchCodeName getRecordAt(String GroupCode) {
        ResultSet rs;
        String sql;
        BranchCodeName fb = new BranchCodeName();

        try {
            sql = "SELECT * FROM branfile WHERE Code='" + GroupCode + "'";
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
        } catch (SQLException ex) {
            return null;
        }
    }
    
   
}
