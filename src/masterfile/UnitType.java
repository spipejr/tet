/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GroupFile.java
 *
 * Created on May 18, 2012, 4:03:52 PM
 */
package masterfile;

import Entity.Groupfile;
import dbutility.dbUtility;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author natee
 */
public class UnitType extends javax.swing.JDialog {

    dbUtility db = new dbUtility();
    private DefaultTableModel model;
    private Statement stmt;
    DefaultTableModel tblProduct_model;
ThaiUtilities cvth = new ThaiUtilities();

    /** Creates new form GroupFile */
    public UnitType(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tblProduct_model = (DefaultTableModel) UnitList.getModel();
        UnitList.setShowGrid(true);
        UnitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        UnitList.setRowSelectionAllowed(true);
        UnitList.setBackground(java.awt.Color.WHITE);
        UnitList.setGridColor(java.awt.Color.gray);

        JTableHeader header = UnitList.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
        UnitList.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
        UnitList.setRowHeight(25);

        db.dbconnect();
        try {
            stmt = (Statement) dbUtility.con.createStatement();
        } catch (Exception e) {
        }
        displayGroupFile();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        P_Unit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        UnitList = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("กำหนดข้อมูลหน่วยนับหลัก");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton7.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete-icons.png"))); // NOI18N
        jButton7.setText("ลบข้อมูล");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setIconTextGap(0);
        jButton7.setRequestFocusEnabled(false);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save-icon.png"))); // NOI18N
        jButton6.setText("บันทึกข้อมูล");
        jButton6.setAlignmentY(0.0F);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setIconTextGap(0);
        jButton6.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jButton6.setRequestFocusEnabled(false);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LogOut-icon.png"))); // NOI18N
        jButton1.setText("ออก(Exit)");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setIconTextGap(0);
        jButton1.setRequestFocusEnabled(false);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("หน่วยนับหลัก");

        P_Unit.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        P_Unit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                P_UnitFocusLost(evt);
            }
        });
        P_Unit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                P_UnitKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                P_UnitKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(P_Unit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(P_Unit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        UnitList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        UnitList.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        UnitList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "หน่วยนับ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        UnitList.setRowHeight(25);
        UnitList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UnitListMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UnitListMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(UnitList);
        UnitList.getColumnModel().getColumn(0).setResizable(false);
        UnitList.getColumnModel().getColumn(0).setPreferredWidth(120);

        jMenu1.setText("ฟังก์ชั่นการทำงาน");
        jMenu1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem1.setText("ยกเลิก");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem2.setText("บันทึก");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem3.setText("ลบ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem4.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem4.setText("ออก");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, 0, 392, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-541)/2, 400, 541);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void P_UnitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_P_UnitKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_P_UnitKeyReleased

    private void P_UnitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_P_UnitKeyPressed
    }//GEN-LAST:event_P_UnitKeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        remove();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        if (!P_Unit.getText().equals("")) {
            bntSaveClick();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void UnitListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnitListMouseReleased
    }//GEN-LAST:event_UnitListMouseReleased

    private void P_UnitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P_UnitFocusLost
    }//GEN-LAST:event_P_UnitFocusLost

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (!P_Unit.getText().equals("")) {
            bntSaveClick();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        remove();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void UnitListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnitListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UnitListMouseClicked

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
            java.util.logging.Logger.getLogger(UnitType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnitType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnitType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnitType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                UnitType dialog = new UnitType(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField P_Unit;
    private javax.swing.JTable UnitList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public void bntSaveClick() {
        if (CheckValidSave()) {
            if (isCheck(P_Unit.getText()) == true) {
                
                try {
                    if(db.Char_Set.equalsIgnoreCase("utf-8"))
                    {
                    stmt = (Statement) dbUtility.con.createStatement();
                    String UpdateGroup = "update unitfile set unitname=? ";
                    PreparedStatement prm = (PreparedStatement) dbUtility.con.prepareStatement(UpdateGroup);

                    prm.setString(1, P_Unit.getText());
                    prm.executeUpdate();
                    stmt.close();
                    clear();
                    displayGroupFile();
                    }
                    else
                    {
                    stmt = (Statement) dbUtility.con.createStatement();
                    String UpdateGroup = "update unitfile set unitname=? ";
                    PreparedStatement prm = (PreparedStatement) dbUtility.con.prepareStatement(UpdateGroup);

                    prm.setString(1, cvth.Unicode2ASCII(P_Unit.getText()));
                    prm.executeUpdate();
                    stmt.close();
                    clear();
                    displayGroupFile();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Update Database Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    if(db.Char_Set.equalsIgnoreCase("utf-8"))
                    {
                    stmt = (Statement) dbUtility.con.createStatement();
                    String InsertGroup = "insert into unitfile (unitname) "
                            + "values (?)";
                    PreparedStatement prm = (PreparedStatement) dbUtility.con.prepareStatement(InsertGroup);

                    prm.setString(1, P_Unit.getText());
                    prm.executeUpdate();
                    stmt.close();
                    clear();
                    displayGroupFile();
                    }
                    else
                    {
                    stmt = (Statement) dbUtility.con.createStatement();
                    String InsertGroup = "insert into unitfile (unitname) "
                            + "values (?)";
                    PreparedStatement prm = (PreparedStatement) dbUtility.con.prepareStatement(InsertGroup);

                    prm.setString(1, cvth.Unicode2ASCII(P_Unit.getText()));
                    prm.executeUpdate();
                    stmt.close();
                    clear();
                    displayGroupFile();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Insert Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }

    public void remove() {

        try {
            int confirm = JOptionPane.showConfirmDialog(this, "คุณต้องการลบข้อมูลรายการนี้หรือไม่...?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if(db.Char_Set.equalsIgnoreCase("utf-8"))
                    {
                stmt = dbUtility.con.createStatement();
                int rowSelect = UnitList.getSelectedRow();
                String pcode_display = tblProduct_model.getValueAt(rowSelect, 0).toString();

                String sql = "Delete From unitfile WHERE unitname ='" + pcode_display + "'";
                stmt.executeUpdate(sql);

                clear();
                displayGroupFile();
                    }
                else
                {
                 stmt = dbUtility.con.createStatement();
                int rowSelect = UnitList.getSelectedRow();
                String pcode_display = tblProduct_model.getValueAt(rowSelect, 0).toString();

                String sql = "Delete From unitfile WHERE unitname ='" + cvth.Unicode2ASCII(pcode_display) + "'";
                stmt.executeUpdate(sql);

                clear();
                displayGroupFile();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public boolean CheckValidSave() {
        boolean RetVal = true;

        if (P_Unit.getText().length() > 10) {
            JOptionPane.showMessageDialog(this, "กำหนดหน่วยนับไม่ถูกต้อง...(ตัองมีขนาดไม่เกิน 10 ตัวอักษร)");
            RetVal = false;
            P_Unit.requestFocus();
        } 
        return RetVal;
    }

    public boolean isCheck(String pcodeCheck) {
        ResultSet rs = null;
        boolean isCheck = false;
        try {
            if(db.Char_Set.equalsIgnoreCase("utf-8"))
                    {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "SELECT *FROM unitfile where unitname ='" + pcodeCheck + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                isCheck = true;
            }
                    }
            else
            {
             stmt = (Statement) dbUtility.con.createStatement();
            String sql = "SELECT *FROM unitfile where unitname ='" + cvth.Unicode2ASCII(pcodeCheck) + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                isCheck = true;
            }
            }
        } catch (Exception e) {
        }
        return isCheck;
    }

    private void displayGroupFile() {
        List groupFile = displayGroupfile2();
        int cnt = tblProduct_model.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                tblProduct_model.removeRow(0);
            }
        }
        for (int i = 0; i < groupFile.size(); i++) {
            Groupfile data = (Groupfile) groupFile.get(i);
            String[] aa = {data.getGroupCode(), data.getGroupName()};
            tblProduct_model.addRow(aa);
        }

    }

    public List displayGroupfile2() {
        stmt = null;
        ResultSet rs = null;
        List groupfile = new ArrayList();
        try {
            if(db.Char_Set.equalsIgnoreCase("utf-8"))
                    {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from unitfile order by unitname ASC ;";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Groupfile data = new Groupfile();
                data.setGroupCode(rs.getString("unitname"));

                groupfile.add(data);
            }
                    }
            else
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from unitfile order by unitname ASC ;";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Groupfile data = new Groupfile();
                data.setGroupCode(cvth.ASCII2Unicode(rs.getString("unitname")));

                groupfile.add(data);
            }
            }
        } catch (Exception e) {
        }
        return groupfile;
    }

    private void clear() {

        P_Unit.setText("");

    }
}
