/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package masterfile;

import com.mysql.jdbc.PreparedStatement;
import dbutility.dbUtility;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import utilititiesfunction.TableTestFormatRenderer;
import utilititiesfunction.ThaiUtilities;
import utilititiesfunction.UserLogin;

/**
 *
 * @author s386
 */
public class setBorUser extends javax.swing.JDialog {

    /**
     * Creates new form setBorUser
     */
    DefaultTableModel tbPLU;
    dbUtility db = new dbUtility();
    Statement stmt;
    int indexplutbl = -1;
    int indexcoupontbl = -1;
    String frmName = "setsalepriceofbranchgroup";
    ThaiUtilities cvth = new ThaiUtilities();
    DecimalFormat DoubleFmt = new DecimalFormat("##,###,##0.00");
    SimpleDateFormat dateFmtSave = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    SimpleDateFormat dateTimeFmtSave = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    SimpleDateFormat dateTimeFmtShow = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
    SimpleDateFormat dateFmtShow = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    private DefaultTableModel tbmodel;
    String tempPass = "";
    String Mast1 = "0";
    String Mast2 = "0";
    String Mast3 = "0";
    String Mast4 = "0";
    String Mast5 = "0";
    String Mast6 = "0";
    String Mast7 = "0";
    String Mast8 = "0";
    String Mast9 = "0";
    String Mast10 = "0";
    String Mast11 = "0";
    String Mast12 = "0";
    String Mast13 = "0";
    String Mast14 = "0";
    String Mast15 = "0";
    String Mast16 = "0";
    String Mast17 = "0";
    String Mast18 = "0";
    String Mast19 = "0";
    String Mast20 = "0";
    String Mast21 = "0";
    String Mast22 = "0";
    String Mast23 = "0";
    String Mast24 = "0";
    String Mast25 = "0";
    String M212 = "0";
    String M213 = "0";
    String M214 = "0";
    String M215 = "0";
    String M216 = "0";
    String M217 = "0";
    String Plu1 = "0";
    String Plu2 = "0";
    String Plu3 = "0";
    String Plu4 = "0";
    String Plu5 = "0";
    String Plu6 = "0";
    String Plu7 = "0";
    String Plu8 = "0";
    String Plu9 = "0";
    String Plu10 = "0";
    String Plu11 = "0";
    String Plu12 = "0";
    String Plu13 = "0";
    String Plu14 = "0";
    String Plu15 = "0";
    String Plu16 = "0";
    String Plu17 = "0";
    String Plu18 = "0";
    String Plu19 = "0";
    String Plu20 = "0";
    String Tran1 = "0";
    String Tran2 = "0";
    String Tran3 = "0";
    String Tran4 = "0";
    String Tran5 = "0";
    String Tran6 = "0";
    String Tran7 = "0";
    String Tran8 = "0";
    String Tran9 = "0";
    String Tran10 = "0";
    String Tran11 = "0";
    String Rpt1 = "0";
    String Rpt2 = "0";
    String Rpt3 = "0";
    String Rpt4 = "0";
    String Rpt5 = "0";
    String Rpt6 = "0";
    String Rpt7 = "0";
    String Rpt8 = "0";
    String Rpt9 = "0";
    String Rpt10 = "0";
    String Rpt11 = "0";
    String Rpt12 = "0";
    String Rpt13 = "0";
    String Rpt14 = "0";
    String Rpt15 = "0";
    String Rpt16 = "0";
    String Rpt17 = "0";
    String Rpt18 = "0";
    String Rpt19 = "0";
    String Rpt20 = "0";
    String Rpt21 = "0";
    String Rpt22 = "0";
    String Rpt23 = "0";
    String Rpt24 = "0";
    String Rpt25 = "0";
    String Rpt26 = "0";
    String Rpt27 = "0";
    String Rpt28 = "0";
    String Rpt29 = "0";
    String Rpt30 = "0";
    String Rpt31 = "0";
    String Rpt32 = "0";
    String Rpt33 = "0";
    String Rpt34 = "0";
    String Rpt35 = "0";
    String Rpt36 = "0";
    String Rpt37 = "0";
    String Rpt38 = "0";
    String Rpt39 = "0";
    String Rpt40 = "0";
    String Rpt41 = "0";
    String Rpt42 = "0";
    String Rpt43 = "0";
    String Rpt44 = "0";
    String Rpt45 = "0";
    String Rpt46 = "0";
    String Rpt47 = "0";
    String Rpt48 = "0";
    String Rpt49 = "0";
    String Rpt50 = "0";
    String Cont1 = "0";
    String Cont2 = "0";
    String Cont3 = "0";
    String Cont4 = "0";
    String Cont5 = "0";
    String Cont6 = "0";
    String Cont7 = "0";
    String Cont8 = "0";
    String Cont9 = "0";
    String Cont10 = "0";

    String Mast26 = "0";
    String Mast27 = "0";
    String Mast28 = "0";
    String Mast29 = "0";
    String Mast30 = "0";
    String Rpt51 = "0";
    String Rpt52 = "0";

    public setBorUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        checkuserconfig();
        db.dbconnect();
        inittblAll();
        loadtblGroup();
        loadtblPosUser();
        setFocus(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();
        db_lblh7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        t_user = new javax.swing.JTextField();
        db_btnOK = new javax.swing.JButton();
        db_btnCancel = new javax.swing.JButton();
        db_lblh1 = new javax.swing.JLabel();
        db_lblh2 = new javax.swing.JLabel();
        t_pass = new javax.swing.JTextField();
        db_lblh3 = new javax.swing.JLabel();
        t_name = new javax.swing.JTextField();
        db_lblh4 = new javax.swing.JLabel();
        t_groupuser = new javax.swing.JTextField();
        db_btnchangepw = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl3 = new javax.swing.JTable();
        db_lblh8 = new javax.swing.JLabel();
        db_btnshow = new javax.swing.JButton();
        db_lblCount5 = new javax.swing.JLabel();
        db_btndelete = new javax.swing.JButton();
        db_btnsave = new javax.swing.JButton();
        db_lblCount = new javax.swing.JLabel();
        db_lblCount4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        db_lblh6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbl2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserGroup", "User", "ชื่อพนักงาน", "LastUpDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl2.setName("tbl"); // NOI18N
        tbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl2MouseReleased(evt);
            }
        });
        tbl2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl2KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbl2);
        tbl2.getColumnModel().getColumn(0).setPreferredWidth(70);
        tbl2.getColumnModel().getColumn(1).setPreferredWidth(70);
        tbl2.getColumnModel().getColumn(2).setPreferredWidth(140);
        tbl2.getColumnModel().getColumn(3).setPreferredWidth(130);

        db_lblh7.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh7.setText("รายชื่อผู้ใช้งาน");
        db_lblh7.setName("db_lblh1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(db_lblh7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(db_lblh7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        t_user.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        t_user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_userFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_userFocusLost(evt);
            }
        });
        t_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_userKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_userKeyReleased(evt);
            }
        });

        db_btnOK.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnOK.setText("OK");
        db_btnOK.setName("db_btnOK"); // NOI18N
        db_btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnOKActionPerformed(evt);
            }
        });

        db_btnCancel.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnCancel.setText("Cancel");
        db_btnCancel.setName("db_btnCancel"); // NOI18N
        db_btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnCancelActionPerformed(evt);
            }
        });

        db_lblh1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh1.setText("รหัสผู้ใช้งาน");
        db_lblh1.setName("db_lblh1"); // NOI18N

        db_lblh2.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh2.setText("รหัสผ่าน");
        db_lblh2.setName("db_lblh1"); // NOI18N

        t_pass.setBackground(new java.awt.Color(253, 129, 135));
        t_pass.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        t_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_passFocusLost(evt);
            }
        });
        t_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_passKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_passKeyReleased(evt);
            }
        });

        db_lblh3.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh3.setText("ชื่อพนักงาน");
        db_lblh3.setName("db_lblh1"); // NOI18N

        t_name.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        t_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_nameFocusLost(evt);
            }
        });
        t_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_nameKeyReleased(evt);
            }
        });

        db_lblh4.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        db_lblh4.setText("กลุ่มผู้ใช้งาน");
        db_lblh4.setName("db_lblh1"); // NOI18N

        t_groupuser.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        t_groupuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_groupuserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_groupuserFocusLost(evt);
            }
        });
        t_groupuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_groupuserKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_groupuserKeyReleased(evt);
            }
        });

        db_btnchangepw.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnchangepw.setText("Change Password");
        db_btnchangepw.setName("db_btnOK"); // NOI18N
        db_btnchangepw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnchangepwActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(db_lblh4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(db_lblh3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(db_lblh2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(db_lblh1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(t_pass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(t_user, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnchangepw))
                    .addComponent(t_name, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(db_btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(db_btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(t_groupuser, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_lblh1))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_lblh2)
                    .addComponent(db_btnchangepw, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_lblh3))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_groupuser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_lblh4))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(db_btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbl3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tbl3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "กลุ่ม", "mcode", "ชื่อเมนู/รายการ", "สิทธิการใช้งาน"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl3.setName("tbl3"); // NOI18N
        tbl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl3MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl3MouseReleased(evt);
            }
        });
        tbl3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl3KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl3);
        tbl3.getColumnModel().getColumn(1).setMinWidth(0);
        tbl3.getColumnModel().getColumn(1).setPreferredWidth(0);
        tbl3.getColumnModel().getColumn(1).setMaxWidth(0);
        tbl3.getColumnModel().getColumn(2).setPreferredWidth(190);

        db_lblh8.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh8.setText("สิทธิ์การใช้งาน");
        db_lblh8.setName("db_lblh1"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
            .addComponent(db_lblh8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(db_lblh8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
        );

        db_btnshow.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnshow.setText("แสดงรายการทั้งหมด");
        db_btnshow.setName("db_btnCancel"); // NOI18N
        db_btnshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnshowActionPerformed(evt);
            }
        });

        db_lblCount5.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        db_lblCount5.setText("รายการ");
        db_lblCount5.setName("xb_lblCount2"); // NOI18N

        db_btndelete.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btndelete.setText("ลบข้อมูล");
        db_btndelete.setName("db_btnCancel"); // NOI18N
        db_btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btndeleteActionPerformed(evt);
            }
        });

        db_btnsave.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnsave.setText("บันทึก");
        db_btnsave.setName("db_btnOK"); // NOI18N
        db_btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnsaveActionPerformed(evt);
            }
        });

        db_lblCount.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        db_lblCount.setText("0");

        db_lblCount4.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        db_lblCount4.setText("จำนวนทั้งหมด");
        db_lblCount4.setName("xb_lblCount1"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbl1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Group Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl1.setName("tbl"); // NOI18N
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl1MouseReleased(evt);
            }
        });
        tbl1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl1);

        db_lblh6.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh6.setText("กลุ่มผู้ใช้งาน");
        db_lblh6.setName("db_lblh1"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(db_lblh6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(db_lblh6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(db_btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(db_btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(db_btnshow)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(db_lblCount4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_lblCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_lblCount5)
                        .addGap(414, 414, 414))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(db_btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(db_btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(db_btnshow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(db_lblCount)
                    .addComponent(db_lblCount4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(db_lblCount5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1032)/2, (screenSize.height-796)/2, 1032, 796);
    }// </editor-fold>//GEN-END:initComponents

    private void checkuserconfig() {
        //MenuName = Mast1
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getCont4().equals("1")) {
            db_btnsave.setEnabled(false);
            db_btndelete.setEnabled(false);
            db_btnchangepw.setEnabled(false);
        }
        if (userrec.getCont4().equals("2")) {
            db_btnsave.setEnabled(true);
            db_btndelete.setEnabled(false);
            db_btnchangepw.setEnabled(true);
        }
        if (userrec.getCont4().equals("3")) {
            db_btnsave.setEnabled(true);
            db_btndelete.setEnabled(true);
            db_btnchangepw.setEnabled(true);
        }
    }
    private void tbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl2MouseClicked

    private void tbl2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseReleased
        if (evt.getClickCount() == 2) {
            int rowSelect = tbl2.getSelectedRow();
            if (rowSelect > -1) {
                t_user.setText(tbl2.getValueAt(rowSelect, 1).toString());
                settextbox(t_user.getText());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl2MouseReleased

    private void tbl2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl2KeyReleased

    private void t_userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_userFocusGained
        t_user.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_t_userFocusGained

    private void t_userFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_userFocusLost
        if (t_user.getText().length() <= 20) {
            if (!t_user.getText().equals("")) {
                settextbox(t_user.getText());
            }
        } else {
            JOptionPane.showMessageDialog(this, "กำหนด รหัสผู้ใช้ ไม่ถูกต้อง... (ต้องมีขนาดไม่เกิน 20 ตัวอักษร)");
            t_user.setText("");
            setFocus(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_userFocusLost

    private void t_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_userKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!t_user.getText().equals("")) {
                setFocus(true);
                if (t_pass.isFocusable()) {
                    t_pass.requestFocus();
                } else {
                    t_name.requestFocus();
                }
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_userKeyPressed

    private void t_userKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_userKeyReleased
        t_user.setText(t_user.getText().toUpperCase());
        // TODO add your handling code here:
    }//GEN-LAST:event_t_userKeyReleased

    private void db_btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnOKActionPerformed
        if (!t_user.getText().equals("")) {
            if (!t_groupuser.getText().equals("") && chkgroup(t_groupuser.getText())) {
                loadDataTbl2(t_groupuser.getText());
                //tbl3.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "กรุณากรอกข้อมูลกลุ่มผู้ใช้ให้ถูกต้อง");
                t_groupuser.requestFocus();
                removetbl(tbl3);
            }
        } else {
            t_user.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnOKActionPerformed

    private void db_btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnCancelActionPerformed

        clearDisplay();
        t_user.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnCancelActionPerformed

    private void t_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passFocusGained
        t_pass.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_t_passFocusGained

    private void t_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passFocusLost
        t_pass.select(0, 0);
        // TODO add your handling code here:
    }//GEN-LAST:event_t_passFocusLost

    private void t_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_passKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            t_name.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_passKeyPressed

    private void t_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_passKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_passKeyReleased

    private void t_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nameFocusGained
        t_name.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nameFocusGained

    private void t_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nameFocusLost
        t_name.select(0, 0);
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nameFocusLost

    private void t_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            t_groupuser.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nameKeyPressed

    private void t_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nameKeyReleased

    private void t_groupuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_groupuserFocusGained
        t_groupuser.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_t_groupuserFocusGained

    private void t_groupuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_groupuserFocusLost
        t_groupuser.select(0, 0);
        // TODO add your handling code here:
    }//GEN-LAST:event_t_groupuserFocusLost

    private void t_groupuserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_groupuserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            db_btnOK.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_groupuserKeyPressed

    private void t_groupuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_groupuserKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_groupuserKeyReleased

    private void db_btnchangepwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnchangepwActionPerformed
        if (chkpos(t_user.getText()) && !t_pass.isFocusable()) {
            int confirm = JOptionPane.showConfirmDialog(this, "คุณต้องการเปลี่ยน Password ใช่หรือไม่ ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                t_pass.setFocusable(true);
                t_pass.requestFocus();
                tempPass = t_pass.getText();
                t_pass.setBackground(Color.WHITE);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnchangepwActionPerformed

    private void tbl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl3MouseClicked
//        indexplutbl = tbl.getSelectedRow();
        // TODO add your handling code here:
   }//GEN-LAST:event_tbl3MouseClicked

    private void tbl3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl3MouseReleased
        // TODO add your handling code here:
   }//GEN-LAST:event_tbl3MouseReleased

    private void tbl3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl3KeyReleased
//        indexplutbl = tbl.getSelectedRow();
        // TODO add your handling code here:
   }//GEN-LAST:event_tbl3KeyReleased

    private void db_btnshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnshowActionPerformed
        showBorUser frm = new showBorUser(new NimbusFrame(), true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnshowActionPerformed

    private void db_btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btndeleteActionPerformed
        if (!t_user.getText().equals("") && tbl3.getRowCount() > 0 && chkpos(t_user.getText())) {
            delete();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btndeleteActionPerformed

    private void db_btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnsaveActionPerformed

        save();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnsaveActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1MouseClicked

    private void tbl1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseReleased
        if (evt.getClickCount() == 2) {

            int rowSelect = tbl1.getSelectedRow();
            if (rowSelect > -1) {
                t_groupuser.setText(tbl1.getValueAt(rowSelect, 0).toString());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1MouseReleased

    private void tbl1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1KeyReleased

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
            java.util.logging.Logger.getLogger(setBorUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setBorUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setBorUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setBorUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                setBorUser dialog = new setBorUser(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton db_btnCancel;
    private javax.swing.JButton db_btnOK;
    private javax.swing.JButton db_btnchangepw;
    private javax.swing.JButton db_btndelete;
    private javax.swing.JButton db_btnsave;
    private javax.swing.JButton db_btnshow;
    private javax.swing.JLabel db_lblCount;
    private javax.swing.JLabel db_lblCount4;
    private javax.swing.JLabel db_lblCount5;
    private javax.swing.JLabel db_lblh1;
    private javax.swing.JLabel db_lblh2;
    private javax.swing.JLabel db_lblh3;
    private javax.swing.JLabel db_lblh4;
    private javax.swing.JLabel db_lblh6;
    private javax.swing.JLabel db_lblh7;
    private javax.swing.JLabel db_lblh8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField t_groupuser;
    private javax.swing.JTextField t_name;
    private javax.swing.JTextField t_pass;
    private javax.swing.JTextField t_user;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tbl2;
    private javax.swing.JTable tbl3;
    // End of variables declaration//GEN-END:variables

    public void removetbl(JTable tb) {
        DefaultTableModel tbmodel = (DefaultTableModel) tb.getModel();
        int cnt = tbmodel.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                tbmodel.removeRow(0);
            }
        }
    }

    public void loadtblGroup() {
        stmt = null;
        ResultSet rs = null;

        removetbl(tbl1);
        tbmodel = (DefaultTableModel) tbl1.getModel();

        try {
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {

                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from borgrouplinux";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    tbmodel.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("usergroup"))
                    });

                }

            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from borgrouplinux";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    tbmodel.addRow(new Object[]{rs.getString("usergroup")
                    });

                }
            }
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void loadtblPosUser() {

        stmt = null;
        ResultSet rs = null;

        removetbl(tbl2);
        tbmodel = (DefaultTableModel) tbl2.getModel();

        try {
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {

                stmt = (com.mysql.jdbc.Statement) dbUtility.con.createStatement();
                String sql = "select * from boruserlinux";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    tbmodel.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("usergroup")),
                        cvth.ASCII2Unicode(rs.getString("username")),
                        cvth.ASCII2Unicode(rs.getString("name")),
                        dateTimeFmtShow.format(dateTimeFmtSave.parse(rs.getString("lastchangepassword")))
                    });

                }

            } else {
                stmt = (com.mysql.jdbc.Statement) dbUtility.con.createStatement();
                String sql = "select * from posuser";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    tbmodel.addRow(new Object[]{rs.getString("usergroup"),
                        rs.getString("username"),
                        rs.getString("name"),
                        dateTimeFmtShow.format(dateTimeFmtSave.parse(rs.getString("lastchangepassword")))
                    });

                }
            }
            stmt.close();
            setCountUser();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void clearDisplay() {
        loadtblGroup();
        loadtblPosUser();
        removetbl(tbl3);
        t_user.setText("");
        t_pass.setText("");
        t_name.setText("");
        t_groupuser.setText("");

        tempPass = "";
        setFocus(false);
    }

    private void setFocus(boolean chk) {

        t_name.setFocusable(chk);
        t_groupuser.setFocusable(chk);
        tbl1.setEnabled(chk);
        if (chk == false) {
            t_user.setFocusable(true);
            t_user.setBackground(Color.WHITE);

        } else {
            t_user.setBackground(new java.awt.Color(255, 246, 143));
            t_user.setFocusable(false);

        }

        if (chkpos(t_user.getText())) {
            t_pass.setFocusable(false);
            t_pass.setBackground(new java.awt.Color(255, 246, 143));
        } else {
            if (!t_user.getText().equals("")) {
                t_pass.setFocusable(true);
                t_pass.setBackground(Color.WHITE);
            } else {
                t_pass.setFocusable(false);
                t_pass.setBackground(Color.WHITE);
            }
        }
    }

    private void setCountUser() {
        db_lblCount.setText(tbl2.getRowCount() + "");
    }

    private boolean chkpos(String code) {
        boolean chk = false;
        ResultSet rs = null;
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (com.mysql.jdbc.Statement) db.con.createStatement();
                String sql = "select * from boruserlinux where username ='" + cvth.Unicode2ASCII(code) + "'";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    chk = true;
                }

            } else {
                stmt = (com.mysql.jdbc.Statement) db.con.createStatement();
                String sql = "select * from boruserlinux where username ='" + code + "'";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    chk = true;

                }

            }
        } catch (Exception e) {
        }
        return chk;
    }

    private boolean chkgroup(String code) {
        boolean chk = false;
        ResultSet rs = null;
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (com.mysql.jdbc.Statement) db.con.createStatement();
                String sql = "select * from borgrouplinux where usergroup ='" + cvth.Unicode2ASCII(code) + "'";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    chk = true;
                }

            } else {
                stmt = (com.mysql.jdbc.Statement) db.con.createStatement();
                String sql = "select * from borgrouplinux where usergroup ='" + code + "'";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    chk = true;

                }

            }
        } catch (Exception e) {
        }
        return chk;
    }

    private void settextbox(String code) {
        boolean chk = false;
        ResultSet rs = null;
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (com.mysql.jdbc.Statement) db.con.createStatement();
                String sql = "select * from boruserlinux where username ='" + cvth.Unicode2ASCII(code) + "'";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    t_user.setText(cvth.ASCII2Unicode(rs.getString("username")));
                    t_pass.setText(cvth.ASCII2Unicode(rs.getString("password")));
                    t_name.setText(cvth.ASCII2Unicode(rs.getString("name")));
                    t_groupuser.setText(cvth.ASCII2Unicode(rs.getString("usergroup")));
                    t_pass.setFocusable(false);
                    tempPass = t_pass.getText();
                }

            } else {
                stmt = (com.mysql.jdbc.Statement) db.con.createStatement();
                String sql = "select * from boruserlinux where username ='" + code + "'";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    t_user.setText(rs.getString("username"));
                    t_pass.setText(rs.getString("password"));
                    t_name.setText(rs.getString("name"));
                    t_groupuser.setText(rs.getString("usergroup"));
                    t_pass.setFocusable(false);
                    tempPass = t_pass.getText();
                }

            }
            setFocus(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void loadDataTbl2(String GroupCode) {
        stmt = null;
        ResultSet rs = null;
        removetbl(tbl3);
        tbmodel = (DefaultTableModel) tbl3.getModel();
        try {
            if (!chkgroup(GroupCode)) {
                JOptionPane.showMessageDialog(this, "UserGroup ไม่ถูกต้อง กรุณาเลือกให้ถูกต้อง");
                t_groupuser.requestFocus();
            } else {
                if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                    stmt = (Statement) dbUtility.con.createStatement();
                    String sql = "select * from bormenulinux";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tbmodel.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("mgroup")),
                            cvth.ASCII2Unicode(rs.getString("mcode")),
                            cvth.ASCII2Unicode(rs.getString("mdesc")),
                            rs.getString("onact")
                        });
                    }
                } else {
                    stmt = (Statement) dbUtility.con.createStatement();
                    String sql = "select * from bormenulinux";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tbmodel.addRow(new Object[]{rs.getString("mgroup"),
                            rs.getString("mcode"),
                            rs.getString("mdesc"),
                            rs.getString("onact")
                        });
                    }
                }

                setDataFormDb(GroupCode);
                for (int i = 0; i < tbl3.getRowCount(); i++) {
                    String mcode = tbl3.getValueAt(i, 1).toString();

                    if (mcode.equals("Mast1")) {
                        tbl3.setValueAt(Mast1, i, 3);
                    } else if (mcode.equals("Mast2")) {
                        tbl3.setValueAt(Mast2, i, 3);
                    } else if (mcode.equals("Mast3")) {
                        tbl3.setValueAt(Mast3, i, 3);
                    } else if (mcode.equals("Mast4")) {
                        tbl3.setValueAt(Mast4, i, 3);
                    } else if (mcode.equals("Mast5")) {
                        tbl3.setValueAt(Mast5, i, 3);
                    } else if (mcode.equals("Mast6")) {
                        tbl3.setValueAt(Mast6, i, 3);
                    } else if (mcode.equals("Mast7")) {
                        tbl3.setValueAt(Mast7, i, 3);
                    } else if (mcode.equals("Mast8")) {
                        tbl3.setValueAt(Mast8, i, 3);
                    } else if (mcode.equals("Mast9")) {
                        tbl3.setValueAt(Mast9, i, 3);
                    } else if (mcode.equals("Mast10")) {
                        tbl3.setValueAt(Mast10, i, 3);
                    } else if (mcode.equals("Mast11")) {
                        tbl3.setValueAt(Mast11, i, 3);
                    } else if (mcode.equals("Mast12")) {
                        tbl3.setValueAt(Mast12, i, 3);
                    } else if (mcode.equals("Mast13")) {
                        tbl3.setValueAt(Mast13, i, 3);
                    } else if (mcode.equals("Mast14")) {
                        tbl3.setValueAt(Mast14, i, 3);
                    } else if (mcode.equals("Mast15")) {
                        tbl3.setValueAt(Mast15, i, 3);
                    } else if (mcode.equals("Mast16")) {
                        tbl3.setValueAt(Mast16, i, 3);
                    } else if (mcode.equals("Mast17")) {
                        tbl3.setValueAt(Mast17, i, 3);
                    } else if (mcode.equals("Mast18")) {
                        tbl3.setValueAt(Mast18, i, 3);
                    } else if (mcode.equals("Mast19")) {
                        tbl3.setValueAt(Mast19, i, 3);
                    } else if (mcode.equals("Mast20")) {
                        tbl3.setValueAt(Mast20, i, 3);
                    } else if (mcode.equals("Mast21")) {
                        tbl3.setValueAt(Mast21, i, 3);
                    } else if (mcode.equals("Mast22")) {
                        tbl3.setValueAt(Mast22, i, 3);
                    } else if (mcode.equals("Mast23")) {
                        tbl3.setValueAt(Mast23, i, 3);
                    } else if (mcode.equals("Mast24")) {
                        tbl3.setValueAt(Mast24, i, 3);
                    } else if (mcode.equals("Mast25")) {
                        tbl3.setValueAt(Mast25, i, 3);
                    } else if (mcode.equals("M212")) {
                        tbl3.setValueAt(M212, i, 3);
                    } else if (mcode.equals("M213")) {
                        tbl3.setValueAt(M213, i, 3);
                    } else if (mcode.equals("M214")) {
                        tbl3.setValueAt(M214, i, 3);
                    } else if (mcode.equals("M215")) {
                        tbl3.setValueAt(M215, i, 3);
                    } else if (mcode.equals("M216")) {
                        tbl3.setValueAt(M216, i, 3);
                    } else if (mcode.equals("M217")) {
                        tbl3.setValueAt(M217, i, 3);
                    } else if (mcode.equals("Plu1")) {
                        tbl3.setValueAt(Plu1, i, 3);
                    } else if (mcode.equals("Plu2")) {
                        tbl3.setValueAt(Plu2, i, 3);
                    } else if (mcode.equals("Plu3")) {
                        tbl3.setValueAt(Plu3, i, 3);
                    } else if (mcode.equals("Plu4")) {
                        tbl3.setValueAt(Plu4, i, 3);
                    } else if (mcode.equals("Plu5")) {
                        tbl3.setValueAt(Plu5, i, 3);
                    } else if (mcode.equals("Plu6")) {
                        tbl3.setValueAt(Plu6, i, 3);
                    } else if (mcode.equals("Plu7")) {
                        tbl3.setValueAt(Plu7, i, 3);
                    } else if (mcode.equals("Plu8")) {
                        tbl3.setValueAt(Plu8, i, 3);
                    } else if (mcode.equals("Plu9")) {
                        tbl3.setValueAt(Plu9, i, 3);
                    } else if (mcode.equals("Plu10")) {
                        tbl3.setValueAt(Plu10, i, 3);
                    } else if (mcode.equals("Plu11")) {
                        tbl3.setValueAt(Plu11, i, 3);
                    } else if (mcode.equals("Plu12")) {
                        tbl3.setValueAt(Plu12, i, 3);
                    } else if (mcode.equals("Plu13")) {
                        tbl3.setValueAt(Plu13, i, 3);
                    } else if (mcode.equals("Plu14")) {
                        tbl3.setValueAt(Plu14, i, 3);
                    } else if (mcode.equals("Plu15")) {
                        tbl3.setValueAt(Plu15, i, 3);
                    } else if (mcode.equals("Plu16")) {
                        tbl3.setValueAt(Plu16, i, 3);
                    } else if (mcode.equals("Plu17")) {
                        tbl3.setValueAt(Plu17, i, 3);
                    } else if (mcode.equals("Plu18")) {
                        tbl3.setValueAt(Plu18, i, 3);
                    } else if (mcode.equals("Plu19")) {
                        tbl3.setValueAt(Plu19, i, 3);
                    } else if (mcode.equals("Plu20")) {
                        tbl3.setValueAt(Plu20, i, 3);
                    } else if (mcode.equals("Tran1")) {
                        tbl3.setValueAt(Tran1, i, 3);
                    } else if (mcode.equals("Tran2")) {
                        tbl3.setValueAt(Tran2, i, 3);
                    } else if (mcode.equals("Tran3")) {
                        tbl3.setValueAt(Tran3, i, 3);
                    } else if (mcode.equals("Tran4")) {
                        tbl3.setValueAt(Tran4, i, 3);
                    } else if (mcode.equals("Tran5")) {
                        tbl3.setValueAt(Tran5, i, 3);
                    } else if (mcode.equals("Tran6")) {
                        tbl3.setValueAt(Tran6, i, 3);
                    } else if (mcode.equals("Tran7")) {
                        tbl3.setValueAt(Tran7, i, 3);
                    } else if (mcode.equals("Tran8")) {
                        tbl3.setValueAt(Tran8, i, 3);
                    } else if (mcode.equals("Tran9")) {
                        tbl3.setValueAt(Tran9, i, 3);
                    } else if (mcode.equals("Tran10")) {
                        tbl3.setValueAt(Tran10, i, 3);
                    } else if (mcode.equals("Tran11")) {
                        tbl3.setValueAt(Tran11, i, 3);
                    } else if (mcode.equals("Rpt1")) {
                        tbl3.setValueAt(Rpt1, i, 3);
                    } else if (mcode.equals("Rpt2")) {
                        tbl3.setValueAt(Rpt2, i, 3);
                    } else if (mcode.equals("Rpt3")) {
                        tbl3.setValueAt(Rpt3, i, 3);
                    } else if (mcode.equals("Rpt4")) {
                        tbl3.setValueAt(Rpt4, i, 3);
                    } else if (mcode.equals("Rpt5")) {
                        tbl3.setValueAt(Rpt5, i, 3);
                    } else if (mcode.equals("Rpt6")) {
                        tbl3.setValueAt(Rpt6, i, 3);
                    } else if (mcode.equals("Rpt7")) {
                        tbl3.setValueAt(Rpt7, i, 3);
                    } else if (mcode.equals("Rpt8")) {
                        tbl3.setValueAt(Rpt8, i, 3);
                    } else if (mcode.equals("Rpt9")) {
                        tbl3.setValueAt(Rpt9, i, 3);
                    } else if (mcode.equals("Rpt10")) {
                        tbl3.setValueAt(Rpt10, i, 3);
                    } else if (mcode.equals("Rpt11")) {
                        tbl3.setValueAt(Rpt11, i, 3);
                    } else if (mcode.equals("Rpt12")) {
                        tbl3.setValueAt(Rpt12, i, 3);
                    } else if (mcode.equals("Rpt13")) {
                        tbl3.setValueAt(Rpt13, i, 3);
                    } else if (mcode.equals("Rpt14")) {
                        tbl3.setValueAt(Rpt14, i, 3);
                    } else if (mcode.equals("Rpt15")) {
                        tbl3.setValueAt(Rpt15, i, 3);
                    } else if (mcode.equals("Rpt16")) {
                        tbl3.setValueAt(Rpt16, i, 3);
                    } else if (mcode.equals("Rpt17")) {
                        tbl3.setValueAt(Rpt17, i, 3);
                    } else if (mcode.equals("Rpt18")) {
                        tbl3.setValueAt(Rpt18, i, 3);
                    } else if (mcode.equals("Rpt19")) {
                        tbl3.setValueAt(Rpt19, i, 3);
                    } else if (mcode.equals("Rpt20")) {
                        tbl3.setValueAt(Rpt20, i, 3);
                    } else if (mcode.equals("Rpt21")) {
                        tbl3.setValueAt(Rpt21, i, 3);
                    } else if (mcode.equals("Rpt22")) {
                        tbl3.setValueAt(Rpt22, i, 3);
                    } else if (mcode.equals("Rpt23")) {
                        tbl3.setValueAt(Rpt23, i, 3);
                    } else if (mcode.equals("Rpt24")) {
                        tbl3.setValueAt(Rpt24, i, 3);
                    } else if (mcode.equals("Rpt25")) {
                        tbl3.setValueAt(Rpt25, i, 3);
                    } else if (mcode.equals("Rpt26")) {
                        tbl3.setValueAt(Rpt26, i, 3);
                    } else if (mcode.equals("Rpt27")) {
                        tbl3.setValueAt(Rpt27, i, 3);
                    } else if (mcode.equals("Rpt28")) {
                        tbl3.setValueAt(Rpt28, i, 3);
                    } else if (mcode.equals("Rpt29")) {
                        tbl3.setValueAt(Rpt29, i, 3);
                    } else if (mcode.equals("Rpt30")) {
                        tbl3.setValueAt(Rpt30, i, 3);
                    } else if (mcode.equals("Rpt31")) {
                        tbl3.setValueAt(Rpt31, i, 3);
                    } else if (mcode.equals("Rpt32")) {
                        tbl3.setValueAt(Rpt32, i, 3);
                    } else if (mcode.equals("Rpt33")) {
                        tbl3.setValueAt(Rpt33, i, 3);
                    } else if (mcode.equals("Rpt34")) {
                        tbl3.setValueAt(Rpt34, i, 3);
                    } else if (mcode.equals("Rpt35")) {
                        tbl3.setValueAt(Rpt35, i, 3);
                    } else if (mcode.equals("Rpt36")) {
                        tbl3.setValueAt(Rpt36, i, 3);
                    } else if (mcode.equals("Rpt37")) {
                        tbl3.setValueAt(Rpt37, i, 3);
                    } else if (mcode.equals("Rpt38")) {
                        tbl3.setValueAt(Rpt38, i, 3);
                    } else if (mcode.equals("Rpt39")) {
                        tbl3.setValueAt(Rpt39, i, 3);
                    } else if (mcode.equals("Rpt40")) {
                        tbl3.setValueAt(Rpt40, i, 3);
                    } else if (mcode.equals("Rpt41")) {
                        tbl3.setValueAt(Rpt41, i, 3);
                    } else if (mcode.equals("Rpt42")) {
                        tbl3.setValueAt(Rpt42, i, 3);
                    } else if (mcode.equals("Rpt43")) {
                        tbl3.setValueAt(Rpt43, i, 3);
                    } else if (mcode.equals("Rpt44")) {
                        tbl3.setValueAt(Rpt44, i, 3);
                    } else if (mcode.equals("Rpt45")) {
                        tbl3.setValueAt(Rpt45, i, 3);
                    } else if (mcode.equals("Rpt46")) {
                        tbl3.setValueAt(Rpt46, i, 3);
                    } else if (mcode.equals("Rpt47")) {
                        tbl3.setValueAt(Rpt47, i, 3);
                    } else if (mcode.equals("Rpt48")) {
                        tbl3.setValueAt(Rpt48, i, 3);
                    } else if (mcode.equals("Rpt49")) {
                        tbl3.setValueAt(Rpt49, i, 3);
                    } else if (mcode.equals("Rpt50")) {
                        tbl3.setValueAt(Rpt50, i, 3);
                    } else if (mcode.equals("Cont1")) {
                        tbl3.setValueAt(Cont1, i, 3);
                    } else if (mcode.equals("Cont2")) {
                        tbl3.setValueAt(Cont2, i, 3);
                    } else if (mcode.equals("Cont3")) {
                        tbl3.setValueAt(Cont3, i, 3);
                    } else if (mcode.equals("Cont4")) {
                        tbl3.setValueAt(Cont4, i, 3);
                    } else if (mcode.equals("Cont5")) {
                        tbl3.setValueAt(Cont5, i, 3);
                    } else if (mcode.equals("Cont6")) {
                        tbl3.setValueAt(Cont6, i, 3);
                    } else if (mcode.equals("Cont7")) {
                        tbl3.setValueAt(Cont7, i, 3);
                    } else if (mcode.equals("Cont8")) {
                        tbl3.setValueAt(Cont8, i, 3);
                    } else if (mcode.equals("Cont9")) {
                        tbl3.setValueAt(Cont9, i, 3);
                    } else if (mcode.equals("Cont10")) {
                        tbl3.setValueAt(Cont10, i, 3);
                    } else if (mcode.equals("Mast26")) {
                        tbl3.setValueAt(Mast26, i, 3);
                    } else if (mcode.equals("Mast27")) {
                        tbl3.setValueAt(Mast27, i, 3);
                    } else if (mcode.equals("Mast28")) {
                        tbl3.setValueAt(Mast28, i, 3);
                    } else if (mcode.equals("Mast29")) {
                        tbl3.setValueAt(Mast29, i, 3);
                    } else if (mcode.equals("Mast30")) {
                        tbl3.setValueAt(Mast30, i, 3);
                    } else if (mcode.equals("Rpt51")) {
                        tbl3.setValueAt(Rpt51, i, 3);
                    }
//                    else if (mcode.equals("Rpt52")) {
//                        tbl3.setValueAt(Rpt52, i, 3);
//                    }

                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private void setDataFormDb(String GroupCode) {

        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String sql = "";
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                sql = "select * from borgrouplinux where usergroup = '" + cvth.Unicode2ASCII(GroupCode) + "'";
            } else {
                sql = "select * from borgrouplinux where usergroup = '" + GroupCode + "'";
            }

            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Mast1 = rs.getString("Mast1");
                Mast2 = rs.getString("Mast2");
                Mast3 = rs.getString("Mast3");
                Mast4 = rs.getString("Mast4");
                Mast5 = rs.getString("Mast5");
                Mast6 = rs.getString("Mast6");
                Mast7 = rs.getString("Mast7");
                Mast8 = rs.getString("Mast8");
                Mast9 = rs.getString("Mast9");
                Mast10 = rs.getString("Mast10");
                Mast11 = rs.getString("Mast11");
                Mast12 = rs.getString("Mast12");
                Mast13 = rs.getString("Mast13");
                Mast14 = rs.getString("Mast14");
                Mast15 = rs.getString("Mast15");
                Mast16 = rs.getString("Mast16");
                Mast17 = rs.getString("Mast17");
                Mast18 = rs.getString("Mast18");
                Mast19 = rs.getString("Mast19");
                Mast20 = rs.getString("Mast20");
                Mast21 = rs.getString("Mast21");
                Mast22 = rs.getString("Mast22");
                Mast23 = rs.getString("Mast23");
                Mast24 = rs.getString("Mast24");
                Mast25 = rs.getString("Mast25");

                M212 = rs.getString("M212");
                M213 = rs.getString("M213");
                M214 = rs.getString("M214");
                M215 = rs.getString("M215");
                M216 = rs.getString("M216");
                M217 = rs.getString("M217");

                Plu1 = rs.getString("Plu1");
                Plu2 = rs.getString("Plu2");
                Plu3 = rs.getString("Plu3");
                Plu4 = rs.getString("Plu4");
                Plu5 = rs.getString("Plu5");
                Plu6 = rs.getString("Plu6");
                Plu7 = rs.getString("Plu7");
                Plu8 = rs.getString("Plu8");
                Plu9 = rs.getString("Plu9");
                Plu10 = rs.getString("Plu10");
                Plu11 = rs.getString("Plu11");
                Plu12 = rs.getString("Plu12");
                Plu13 = rs.getString("Plu13");
                Plu14 = rs.getString("Plu14");
                Plu15 = rs.getString("Plu15");
                Plu16 = rs.getString("Plu16");
                Plu17 = rs.getString("Plu17");
                Plu18 = rs.getString("Plu18");
                Plu19 = rs.getString("Plu19");
                Plu20 = rs.getString("Plu20");
                Tran1 = rs.getString("Tran1");
                Tran2 = rs.getString("Tran2");
                Tran3 = rs.getString("Tran3");
                Tran4 = rs.getString("Tran4");
                Tran5 = rs.getString("Tran5");
                Tran6 = rs.getString("Tran6");
                Tran7 = rs.getString("Tran7");
                Tran8 = rs.getString("Tran8");
                Tran9 = rs.getString("Tran9");
                Tran10 = rs.getString("Tran10");
                Tran11 = rs.getString("Tran11");
                Rpt1 = rs.getString("Rpt1");
                Rpt2 = rs.getString("Rpt2");
                Rpt3 = rs.getString("Rpt3");
                Rpt4 = rs.getString("Rpt4");
                Rpt5 = rs.getString("Rpt5");
                Rpt6 = rs.getString("Rpt6");
                Rpt7 = rs.getString("Rpt7");
                Rpt8 = rs.getString("Rpt8");
                Rpt9 = rs.getString("Rpt9");
                Rpt10 = rs.getString("Rpt10");
                Rpt11 = rs.getString("Rpt11");
                Rpt12 = rs.getString("Rpt12");
                Rpt13 = rs.getString("Rpt13");
                Rpt14 = rs.getString("Rpt14");
                Rpt15 = rs.getString("Rpt15");
                Rpt16 = rs.getString("Rpt16");
                Rpt17 = rs.getString("Rpt17");
                Rpt18 = rs.getString("Rpt18");
                Rpt19 = rs.getString("Rpt19");
                Rpt20 = rs.getString("Rpt20");
                Rpt21 = rs.getString("Rpt21");
                Rpt22 = rs.getString("Rpt22");
                Rpt23 = rs.getString("Rpt23");
                Rpt24 = rs.getString("Rpt24");
                Rpt25 = rs.getString("Rpt25");
                Rpt26 = rs.getString("Rpt26");
                Rpt27 = rs.getString("Rpt27");
                Rpt28 = rs.getString("Rpt28");
                Rpt29 = rs.getString("Rpt29");
                Rpt30 = rs.getString("Rpt30");
                Rpt31 = rs.getString("Rpt31");
                Rpt32 = rs.getString("Rpt32");
                Rpt33 = rs.getString("Rpt33");
                Rpt34 = rs.getString("Rpt34");
                Rpt35 = rs.getString("Rpt35");
                Rpt36 = rs.getString("Rpt36");
                Rpt37 = rs.getString("Rpt37");
                Rpt38 = rs.getString("Rpt38");
                Rpt39 = rs.getString("Rpt39");
                Rpt40 = rs.getString("Rpt40");
                Rpt41 = rs.getString("Rpt41");
                Rpt42 = rs.getString("Rpt42");
                Rpt43 = rs.getString("Rpt43");
                Rpt44 = rs.getString("Rpt44");
                Rpt45 = rs.getString("Rpt45");
                Rpt46 = rs.getString("Rpt46");
                Rpt47 = rs.getString("Rpt47");
                Rpt48 = rs.getString("Rpt48");
                Rpt49 = rs.getString("Rpt49");
                Rpt50 = rs.getString("Rpt50");
                Cont1 = rs.getString("Cont1");
                Cont2 = rs.getString("Cont2");
                Cont3 = rs.getString("Cont3");
                Cont4 = rs.getString("Cont4");
                Cont5 = rs.getString("Cont5");
                Cont6 = rs.getString("Cont6");
                Cont7 = rs.getString("Cont7");
                Cont8 = rs.getString("Cont8");
                Cont9 = rs.getString("Cont9");
                Cont10 = rs.getString("Cont10");

                Mast26 = rs.getString("Mast26");
                Mast27 = rs.getString("Mast27");
                Mast28 = rs.getString("Mast28");
                Mast29 = rs.getString("Mast29");
                Mast30 = rs.getString("Mast30");
                Rpt51 = rs.getString("Rpt51");
//                Rpt52 = rs.getString("Rpt52");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private boolean validatesave() {
        boolean chk = true;
        if (t_user.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "กำหนดรหัสผู้ใช้ไม่ถูกต้อง กรุณากำหนดให้ถูกต้อง");
            t_user.requestFocus();
            chk = false;
        } else if (tbl3.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "กรุณากดปุ่ม OK เพื่อดูรายการกำหนดสิทธิ์");
            db_btnOK.requestFocus();
            chk = false;
        } else if (t_pass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "กำหนด Password ไม่ถูกต้อง กรุณากำหนดให้ถูกต้อง");
            t_pass.requestFocus();
            chk = false;
        } else if (t_name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "กำหนด ชื่อพนักงาน ไม่ถูกต้อง กรุณากำหนดให้ถูกต้อง");
            t_name.requestFocus();
            chk = false;
        } else if (t_user.getText().length() > 20) {
            JOptionPane.showMessageDialog(this, "กำหนด รหัสผู้ใช้ ไม่ถูกต้อง... (ต้องมีขนาดไม่เกิน 20 ตัวอักษร)");
            t_user.requestFocus();
            chk = false;
        } else if (t_pass.getText().length() > 20) {
            JOptionPane.showMessageDialog(this, "กำหนด Password ไม่ถูกต้อง... (ต้องมีขนาดไม่เกิน 20 ตัวอักษร)");
            t_pass.requestFocus();
            chk = false;
        } else if (t_name.getText().length() > 40) {
            JOptionPane.showMessageDialog(this, "กำหนด ชื่อพนักงาน ไม่ถูกต้อง... (ต้องมีขนาดไม่เกิน 40 ตัวอักษร)");
            t_name.requestFocus();
            chk = false;
        } else if (!chkgroup(t_groupuser.getText())) {

            JOptionPane.showMessageDialog(this, "กำหนด กลุ่มผู้ใช้ ไม่ถูกต้อง... กรุณากำหนดให้ถูกต้อง");
            t_groupuser.requestFocus();
            chk = false;
        } else if (tbl3.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "กรุณากดปุ่ม OK เพื่อดูรายการกำหนดสิทธิ์");
            db_btnOK.requestFocus();
            chk = false;
        }

        return chk;
    }

    private void save() {
        try {
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                if (validatesave()) {

                    if (chkpos(t_user.getText())) {

                        //update
                        String sql2 = "Update boruserlinux Set PassWord=?,usergroup=?,name=?"
                                + "where username=?";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);

                        prm.setString(1, cvth.Unicode2ASCII(t_pass.getText()));
                        prm.setString(2, cvth.Unicode2ASCII(t_groupuser.getText()));
                        prm.setString(3, cvth.Unicode2ASCII(t_name.getText()));
                        prm.setString(4, cvth.Unicode2ASCII(t_user.getText()));
                        prm.executeUpdate();
                        prm.close();

                        updatelastpassword();
                    } else {
                        //insert

                        String sql2 = "Insert Into boruserlinux (PassWord ,UserName ,usergroup,name ) "
                                + "values(?,?,?,?)";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);

                        prm.setString(1, cvth.Unicode2ASCII(t_pass.getText()));
                        prm.setString(2, cvth.Unicode2ASCII(t_user.getText()));
                        prm.setString(3, cvth.Unicode2ASCII(t_groupuser.getText()));
                        prm.setString(4, cvth.Unicode2ASCII(t_name.getText()));
                        prm.executeUpdate();
                        prm.close();
                    }

                    clearDisplay();
                }
            } else {
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private void updatelastpassword() {
        if (!tempPass.equals(t_pass.getText())) {

            try {

                if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                    stmt = (com.mysql.jdbc.Statement) db.con.createStatement();
                    String sql = "update boruserlinux set lastchangepassword = ? where username =?";
                    java.sql.PreparedStatement prm = (java.sql.PreparedStatement) db.con.prepareStatement(sql);
                    prm.setString(1, dateTimeFmtSave.format(new java.util.Date()));
                    prm.setString(2, cvth.Unicode2ASCII(t_user.getText()));
                    prm.executeUpdate();

                    String sql2 = "insert into boruserchange (usercode,newpassword,changedate,changetime) values(?,?,?,?)";
                    java.sql.PreparedStatement prm2 = (java.sql.PreparedStatement) db.con.prepareStatement(sql2);
                    prm2.setString(1, cvth.Unicode2ASCII(t_user.getText()));
                    prm2.setString(2, cvth.Unicode2ASCII(t_pass.getText()));
                    prm2.setString(3, dateFmtSave.format(new java.util.Date()));
                    prm2.setString(4, dateTimeFmtSave.format(new java.util.Date()));
                    prm2.executeUpdate();

                } else {
                    stmt = (com.mysql.jdbc.Statement) db.con.createStatement();
                    String sql = "update boruserlinux set lastchangepassword = ? where username =?";
                    java.sql.PreparedStatement prm = (java.sql.PreparedStatement) db.con.prepareStatement(sql);
                    prm.setString(1, dateTimeFmtSave.format(new java.util.Date()));
                    prm.setString(2, t_user.getText());
                    prm.executeUpdate();

                    String sql2 = "insert into boruserchange (usercode,newpassword,changedate,changetime) values(?,?,?,?)";
                    java.sql.PreparedStatement prm2 = (java.sql.PreparedStatement) db.con.prepareStatement(sql2);
                    prm2.setString(1, t_user.getText());
                    prm2.setString(2, t_pass.getText());
                    prm2.setString(3, dateFmtSave.format(new java.util.Date()));
                    prm2.setString(4, dateTimeFmtSave.format(new java.util.Date()));
                    prm2.executeUpdate();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }

    public void delete() {
        ResultSet rs = null;
        try {

            int confirm = JOptionPane.showConfirmDialog(this, "คุณต้องการลบข้อมูลรายการนี้หรือไม่...?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                    stmt = (com.mysql.jdbc.Statement) db.con.createStatement();
                    String sql = "Delete from boruserlinux where username=?";
                    java.sql.PreparedStatement prm = (java.sql.PreparedStatement) db.con.prepareStatement(sql);
                    prm.setString(1, cvth.Unicode2ASCII(t_user.getText()));
                    prm.executeUpdate();
                } else {
                    stmt = (com.mysql.jdbc.Statement) db.con.createStatement();
                    String sql = "Delete from boruserlinux where username=?";
                    java.sql.PreparedStatement prm = (java.sql.PreparedStatement) db.con.prepareStatement(sql);
                    prm.setString(1, t_user.getText());
                    prm.executeUpdate();
                    stmt.close();
                }
                clearDisplay();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void initable() {
        tbPLU = (DefaultTableModel) tbl1.getModel();
        tbl1.setShowGrid(true);
        //tblPLU.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl1.setRowSelectionAllowed(true);
        tbl1.setBackground(java.awt.Color.WHITE);
        tbl1.setGridColor(java.awt.Color.gray);
        JTableHeader header = tbl1.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        //tblBtype.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tbl1.setRowHeight(24);
        TableTestFormatRenderer t;
        t = new TableTestFormatRenderer(DoubleFmt);
        t.setHorizontalAlignment(SwingConstants.RIGHT);

        DefaultTableCellRenderer r;
        r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer c;
        c = new DefaultTableCellRenderer();
        c.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer l;
        l = new DefaultTableCellRenderer();
        l.setHorizontalAlignment(SwingConstants.LEFT);

        TableColumnModel tcm = tbl1.getColumnModel();
        tcm.getColumn(0).setCellRenderer(l);

    }

    private void initable3() {
        tbPLU = (DefaultTableModel) tbl3.getModel();
        tbl3.setShowGrid(true);
        tbl3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl3.setRowSelectionAllowed(true);
        tbl3.setBackground(java.awt.Color.WHITE);
        tbl3.setGridColor(java.awt.Color.gray);
        JTableHeader header = tbl3.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        //tblBtype.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tbl3.setRowHeight(24);
        TableTestFormatRenderer t;
        t = new TableTestFormatRenderer(DoubleFmt);
        t.setHorizontalAlignment(SwingConstants.RIGHT);
        tbl3.setAutoCreateRowSorter(true);

        DefaultTableCellRenderer r;
        r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer c;
        c = new DefaultTableCellRenderer();
        c.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer l;
        l = new DefaultTableCellRenderer();
        l.setHorizontalAlignment(SwingConstants.LEFT);

        TableColumnModel tcm = tbl3.getColumnModel();
        tcm.getColumn(0).setCellRenderer(l);
        tcm.getColumn(1).setCellRenderer(l);
        tcm.getColumn(2).setCellRenderer(l);

        //tcm.getColumn(3).setCellRenderer(FormatCell.centerColor());
    }

    private void initable2() {
        tbPLU = (DefaultTableModel) tbl2.getModel();
        tbl2.setShowGrid(true);
        //tblPLU.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl2.setRowSelectionAllowed(true);
        tbl2.setBackground(java.awt.Color.WHITE);
        tbl2.setGridColor(java.awt.Color.gray);
        JTableHeader header = tbl2.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        //tblBtype.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tbl2.setRowHeight(24);
        TableTestFormatRenderer t;
        t = new TableTestFormatRenderer(DoubleFmt);
        t.setHorizontalAlignment(SwingConstants.RIGHT);
        tbl2.setAutoCreateRowSorter(true);

        DefaultTableCellRenderer r;
        r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer c;
        c = new DefaultTableCellRenderer();
        c.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer l;
        l = new DefaultTableCellRenderer();
        l.setHorizontalAlignment(SwingConstants.LEFT);
        tbl2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel tcm = tbl2.getColumnModel();
        tcm.getColumn(0).setCellRenderer(l);
        tcm.getColumn(1).setCellRenderer(l);
        tcm.getColumn(2).setCellRenderer(l);
        tcm.getColumn(3).setCellRenderer(l);

    }

    private void inittblAll() {
        initable();
        initable2();
        initable3();
    }
}
