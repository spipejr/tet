/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package masterfile;

import borfunction.GetApplicationName;
import borfunction.GetUser;
import com.mysql.jdbc.PreparedStatement;
import dbutility.dbUtility;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;
import jxl.write.WriteException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import report.Report;
import utilititiesfunction.*;

/**
 *
 * @author s386
 */
public class setUserGroup extends javax.swing.JDialog {

    /**
     * Creates new form setUserGroup
     */
    DefaultTableModel tbPLU ;
    dbUtility db = new dbUtility();
    Statement stmt ;
    int indexplutbl = -1;
    int indexcoupontbl = -1;
    String frmName = "setusergroup";
    ThaiUtilities cvth = new ThaiUtilities();
    getLanguage lang = new getLanguage();
    DecimalFormat DoubleFmt = new DecimalFormat("##,###,##0.00");
    SimpleDateFormat dateFmtSave = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    SimpleDateFormat dateFmtShow = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    private DefaultTableModel tbmodel;
    boolean Cont0 = setBoolean("N");
    boolean Cont1 = setBoolean("N");
    boolean Cont2 = setBoolean("N");
    boolean Cont3 = setBoolean("N");
    boolean Cont4 = setBoolean("N");
    boolean Cont5 = setBoolean("N");
    boolean Cont6 = setBoolean("N");
    boolean Cont7 = setBoolean("N");
    boolean Cont8 = setBoolean("N");
    boolean Cont9 = setBoolean("N");
    boolean Cont10 = setBoolean("N");
    boolean Cont11 = setBoolean("N");
    boolean Cont12 = setBoolean("N");
    boolean Cont13 = setBoolean("N");
    boolean Sale1 = setBoolean("N");
    boolean Sale2 = setBoolean("N");
    boolean Sale3 = setBoolean("N");
    boolean Sale4 = setBoolean("N");
    boolean Sale5 = setBoolean("N");
    boolean Sale6 = setBoolean("N");
    boolean Sale7 = setBoolean("N");
    boolean Sale8 = setBoolean("N");
    boolean Sale9 = setBoolean("N");
    boolean Sale10 = setBoolean("N");
    boolean Sale11 = setBoolean("N");
    boolean Sale12 = setBoolean("N");
    boolean Sale13 = setBoolean("N");
    boolean Sale14 = setBoolean("N");
    boolean Sale15 = setBoolean("N");
    boolean Sale16 = setBoolean("N");
    boolean Sale17 = setBoolean("N");
    boolean Sale18 = setBoolean("N");
    boolean Sale19 = setBoolean("N");
    boolean Sale20 = setBoolean("N");
    boolean Sale21 = setBoolean("N");
    boolean Sale22 = setBoolean("N");
    boolean Sale23 = setBoolean("N");
    boolean Sale24 = setBoolean("N");
    boolean Sale25 = setBoolean("N");
    boolean Sale26 = setBoolean("N");
    boolean Sale27 = setBoolean("N");
    boolean Sale28 = setBoolean("N");
    boolean Sale29 = setBoolean("N");
    boolean Sale30 = setBoolean("N");
    boolean Sale31 = setBoolean("N");
    boolean Sale32 = setBoolean("N");
    boolean Sale33 = setBoolean("N");
    boolean Sale34 = setBoolean("N");
    boolean Sale35 = setBoolean("N");
    boolean Sale36 = setBoolean("N");
    boolean Stock0 = setBoolean("N");
    boolean Stock1 = setBoolean("N");
    boolean Stock2 = setBoolean("N");
    boolean Stock3 = setBoolean("N");
    boolean Stock4 = setBoolean("N");
    boolean Stock5 = setBoolean("N");
    boolean Stock6 = setBoolean("N");
    boolean Stock7 = setBoolean("N");
    boolean Stock8 = setBoolean("N");
    boolean Stock9 = setBoolean("N");
    boolean Stock10 = setBoolean("N");
    boolean Stock11 = setBoolean("N");
    boolean Stock12 = setBoolean("N");
    boolean Stock13 = setBoolean("N");
    boolean Stock14 = setBoolean("N");
    boolean Stock15 = setBoolean("N");
    boolean Stock16 = setBoolean("N");
    boolean Stock17 = setBoolean("N");
    boolean Stock18 = setBoolean("N");
    boolean Stock19 = setBoolean("N");
    boolean Stock20 = setBoolean("N");
    boolean Stock21 = setBoolean("N");
    boolean Stock22 = setBoolean("N");
    boolean Stock23 = setBoolean("N");
    boolean Stock24 = setBoolean("N");
    boolean Stock25 = setBoolean("N");
    boolean Stock26 = setBoolean("N");
    boolean Stock27 = setBoolean("N");
    boolean Stock28 = setBoolean("N");
    boolean Stock29 = setBoolean("N");
    boolean Stock30 = setBoolean("N");
    boolean Stock31 = setBoolean("N");
    boolean Stock32 = setBoolean("N");
    boolean Stock33 = setBoolean("N");
    boolean Stock34 = setBoolean("N");
    boolean Stock35 = setBoolean("N");
    boolean Stock36 = setBoolean("N");
    boolean Stock37 = setBoolean("N");
    boolean Stock38 = setBoolean("N");
    boolean Stock39 = setBoolean("N");
    boolean Stock40 = setBoolean("N");
    boolean Stock41 = setBoolean("N");
    boolean Stock42 = setBoolean("N");
    boolean Stock43 = setBoolean("N");
    boolean Stock44 = setBoolean("N");
    boolean Stock45 = setBoolean("N");
    
    String sCont0 = "N";
    String sCont1 = "N";
    String sCont2 = "N";
    String sCont3 = "N";
    String sCont4 = "N";
    String sCont5 = "N";
    String sCont6 = "N";
    String sCont7 = "N";
    String sCont8 = "N";
    String sCont9 = "N";
    String sCont10 = "N";
    String sCont11 = "N";
    String sCont12 = "N";
    String sCont13 = "N";
    String sSale1 = "N";
    String sSale2 = "N";
    String sSale3 = "N";
    String sSale4 = "N";
    String sSale5 = "N";
    String sSale6 = "N";
    String sSale7 = "N";
    String sSale8 = "N";
    String sSale9 = "N";
    String sSale10 = "N";
    String sSale11 = "N";
    String sSale12 = "N";
    String sSale13 = "N";
    String sSale14 = "N";
    String sSale15 = "N";
    String sSale16 = "N";
    String sSale17 = "N";
    String sSale18 = "N";
    String sSale19 = "N";
    String sSale20 = "N";
    String sSale21 = "N";
    String sSale22 = "N";
    String sSale23 = "N";
    String sSale24 = "N";
    String sSale25 = "N";
    String sSale26 = "N";
    String sSale27 = "N";
    String sSale28 = "N";
    String sSale29 = "N";
    String sSale30 = "N";
    String sSale31 = "N";
    String sSale32 = "N";
    String sSale33 = "N";
    String sSale34 = "N";
    String sSale35 = "N";
    String sSale36 = "N";
    String sStock0 = "N";
    String sStock1 = "N";
    String sStock2 = "N";
    String sStock3 = "N";
    String sStock4 = "N";
    String sStock5 = "N";
    String sStock6 = "N";
    String sStock7 = "N";
    String sStock8 = "N";
    String sStock9 = "N";
    String sStock10 = "N";
    String sStock11 = "N";
    String sStock12 = "N";
    String sStock13 = "N";
    String sStock14 = "N";
    String sStock15 = "N";
    String sStock16 = "N";
    String sStock17 = "N";
    String sStock18 = "N";
    String sStock19 = "N";
    String sStock20 = "N";
    String sStock21 = "N";
    String sStock22 = "N";
    String sStock23 = "N";
    String sStock24 = "N";
    String sStock25 = "N";
    String sStock26 = "N";
    String sStock27 = "N";
    String sStock28 = "N";
    String sStock29 = "N";
    String sStock30 = "N";
    String sStock31 = "N";
    String sStock32 = "N";
    String sStock33 = "N";
    String sStock34 = "N";
    String sStock35 = "N";
    String sStock36 = "N";
    String sStock37 = "N";
    String sStock38 = "N";
    String sStock39 = "N";
    String sStock40 = "N";
    String sStock41 = "N";
    String sStock42 = "N";
    String sStock43 = "N";
    String sStock44 = "N";
    String sStock45 = "N";
    
    
    public setUserGroup(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        checkuserconfig();
        db.dbconnect();
        initable();
        initable2();
        loadtblGroup();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        t_groupuser = new javax.swing.JTextField();
        db_btnOK = new javax.swing.JButton();
        db_btnCancel = new javax.swing.JButton();
        db_lblh1 = new javax.swing.JLabel();
        db_btnsave = new javax.swing.JButton();
        db_btndelete = new javax.swing.JButton();
        db_btnexcel = new javax.swing.JButton();
        db_btnprint = new javax.swing.JButton();
        db_btnexit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl3 = new javax.swing.JTable();
        db_lblh3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        db_lblh2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("กำหนดกลุ่มผู้ใช้งาน");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
        db_lblh1.setText("รหัสกลุ่มผู้ใช้งาน");
        db_lblh1.setName("db_lblh1"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(db_lblh1)
                        .addGap(18, 18, 18)
                        .addComponent(t_groupuser, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(db_btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(db_btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_groupuser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db_lblh1))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(db_btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        db_btnsave.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnsave.setText("บันทึก");
        db_btnsave.setName("db_btnOK"); // NOI18N
        db_btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnsaveActionPerformed(evt);
            }
        });

        db_btndelete.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btndelete.setText("ลบข้อมูล");
        db_btndelete.setName("db_btnCancel"); // NOI18N
        db_btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btndeleteActionPerformed(evt);
            }
        });

        db_btnexcel.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Excel-icon.png"))); // NOI18N
        db_btnexcel.setText("Excel");
        db_btnexcel.setName("db_btnOK"); // NOI18N
        db_btnexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnexcelActionPerformed(evt);
            }
        });

        db_btnprint.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Printer-icon.png"))); // NOI18N
        db_btnprint.setText("พิมพ์");
        db_btnprint.setName("db_btnCancel"); // NOI18N
        db_btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnprintActionPerformed(evt);
            }
        });

        db_btnexit.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LogOut-icon.png"))); // NOI18N
        db_btnexit.setText("ออก");
        db_btnexit.setName("db_btnCancel"); // NOI18N
        db_btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnexitActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbl3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tbl3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "กลุ่ม", "mcode", "ชื่อเมนู/รายการ", "สิทธิการใช้งาน"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl3.setName("tbl3"); // NOI18N
        tbl3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl3MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl3MouseReleased(evt);
            }
        });
        tbl3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbl3FocusGained(evt);
            }
        });
        tbl3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl3KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl3);
        tbl3.getColumnModel().getColumn(1).setMinWidth(0);
        tbl3.getColumnModel().getColumn(1).setPreferredWidth(0);
        tbl3.getColumnModel().getColumn(1).setMaxWidth(0);
        tbl3.getColumnModel().getColumn(2).setPreferredWidth(250);

        db_lblh3.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh3.setText("สิทธิ์การใช้งาน");
        db_lblh3.setName("db_lblh1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addComponent(db_lblh3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(db_lblh3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

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
        tbl1.setName("tbl1"); // NOI18N
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl1MouseReleased(evt);
            }
        });
        tbl1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl1);

        db_lblh2.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh2.setText("กลุ่มผู้ใช้งาน");
        db_lblh2.setName("db_lblh1"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(db_lblh2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(db_lblh2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(db_btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(db_btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(db_btnexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(db_btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(db_btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(db_btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(db_btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(db_btnexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1024)/2, (screenSize.height-768)/2, 1024, 768);
    }// </editor-fold>//GEN-END:initComponents
private void checkuserconfig() {
        //MenuName = Mast1
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getMast21().equals("1")) {
            db_btnsave.setEnabled(false);
            db_btndelete.setEnabled(false);
        }
        if (userrec.getMast21().equals("2")) {
            db_btnsave.setEnabled(true);
            db_btndelete.setEnabled(false);
        }
        if (userrec.getMast21().equals("3")) {
            db_btnsave.setEnabled(true);
            db_btndelete.setEnabled(true);
        }
    }
    private void t_groupuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_groupuserFocusGained
        t_groupuser.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_t_groupuserFocusGained

    private void t_groupuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_groupuserFocusLost
       

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
        //txtfBgroup1.setText(txtfBgroup1.getText().toUpperCase());
        // TODO add your handling code here:
    }//GEN-LAST:event_t_groupuserKeyReleased

    private void db_btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnOKActionPerformed
        if(!t_groupuser.getText().equals(""))
        {
        loadDataTbl2(t_groupuser.getText());
        tbl3.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "ข้อมูลไม่ถูกต้อง กรุณากรอกข้อมูลก่อน");
            t_groupuser.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnOKActionPerformed

    private void db_btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnCancelActionPerformed
//        clearplutxt();
       clearDisplay();
        t_groupuser.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnCancelActionPerformed

    private void tbl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl3MouseClicked
//        int row = tbl3.getSelectedRow();
//        int col = tbl3.getSelectedColumn();
//        if(col == 3)
//        {
//            if (tbl3.editCellAt(row, col))
//            {
//                Component editor = tbl3.getEditorComponent();
//                editor.requestFocusInWindow();
//                ((JTextComponent)editor).selectAll();
//            }
//        
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl3MouseClicked

    private void tbl3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl3MouseReleased
//        if (evt.getClickCount() == 2) {
//            int rowSelect = tbl2.getSelectedRow();
//            String pcode = tbl2.getValueAt(rowSelect, 0).toString();
//            String pname = tbl2.getValueAt(rowSelect, 1).toString();
//
//            String pro1 = tbl2.getValueAt(rowSelect, 8).toString();
//            String pro2 = tbl2.getValueAt(rowSelect, 9).toString();
//            String pro3 = tbl2.getValueAt(rowSelect, 10).toString();
//            txtfBgroup1.setText(pcode);
//
//
//
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl3MouseReleased

    private void tbl3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl3KeyReleased
        
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl3KeyReleased

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1MouseClicked

    private void tbl1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseReleased
        if (evt.getClickCount() == 2) {
            int rowSelect = tbl1.getSelectedRow();
            t_groupuser.setText(tbl1.getValueAt(rowSelect, 0).toString());

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1MouseReleased

    private void tbl1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1KeyReleased

    private void db_btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnsaveActionPerformed
        save();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnsaveActionPerformed

    private void db_btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btndeleteActionPerformed
        if(!t_groupuser.getText().equals("")&&tbl3.getRowCount()>0)
        {
        delete();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btndeleteActionPerformed

    private void tbl3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl3KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            int row = tbl3.getSelectedRow();
        int col = tbl3.getSelectedColumn();
        if(col == 3)
        {
            if (tbl3.editCellAt(row, col))
            {
                Component editor = tbl3.getEditorComponent();
                editor.requestFocusInWindow();
                ((JTextComponent)editor).selectAll();
                
            }
        }
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl3KeyPressed

    private void tbl3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl3FocusGained
        
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl3FocusGained

    private void tbl1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl1KeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            int rowSelect = tbl1.getSelectedRow();
            t_groupuser.setText(tbl1.getValueAt(rowSelect, 0).toString());
            t_groupuser.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1KeyPressed

    private void db_btnexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnexcelActionPerformed
        if(!t_groupuser.getText().equals("")&&tbl3.getRowCount()>0)
        {
        Export2Excel test = new Export2Excel();
        JFileChooser chooser = new JFileChooser();

        try {
            File f = new File(new File("excel.xls").getCanonicalPath());

            chooser.setSelectedFile(f);
            int confirm = chooser.showSaveDialog(this);
            if (confirm == JFileChooser.APPROVE_OPTION) {
                File curFile = chooser.getSelectedFile();


                test.setOutputFile(curFile.toString());
                try {
                    test.writetableToUsergroup(tbl3, tbl3.getColumnModel(),"UserGroup : "+t_groupuser.getText());
                } catch (WriteException ex) {
                }
            }

        } catch (IOException e) {
        }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnexcelActionPerformed

    private void db_btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnprintActionPerformed
        if(validatesave())
        {
        Map parm = new HashMap();
        JRBeanCollectionDataSource ds = null;
        ds = new JRBeanCollectionDataSource(report.databean4Field.getUserGroup(tbl3));
        parm.put("companyName", lang.getTextCompanyReport());
        parm.put("Reportheader", lang.getTextReport(frmName, "texthead"));

        parm.put("code", lang.getTextReport(frmName, "code"));
        parm.put("name", lang.getTextReport(frmName, "name"));
        parm.put("other1", lang.getTextReport(frmName, "other1"));
        parm.put("other2", lang.getTextReport(frmName, "other2"));
        
        parm.put("forname", lang.getTextReport(frmName, "forname")+" : "+t_groupuser.getText());
        parm.put("application",new GetApplicationName().getApplicationName());
        parm.put("user", new GetUser().getUser());
        parm.put("currentDate", Format.dateFmtReport.format(new java.util.Date()));
        
        String rptName = "rptusergroup";
        Report rpt = new Report();
        rpt.viewReportbean(rptName, parm,frmName, ds); 
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnprintActionPerformed

    private void db_btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnexitActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnexitActionPerformed

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
            java.util.logging.Logger.getLogger(setUserGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setUserGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setUserGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setUserGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                setUserGroup dialog = new setUserGroup(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton db_btndelete;
    private javax.swing.JButton db_btnexcel;
    private javax.swing.JButton db_btnexit;
    private javax.swing.JButton db_btnprint;
    private javax.swing.JButton db_btnsave;
    private javax.swing.JLabel db_lblh1;
    private javax.swing.JLabel db_lblh2;
    private javax.swing.JLabel db_lblh3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField t_groupuser;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tbl3;
    // End of variables declaration//GEN-END:variables
    public boolean setBoolean(String chk)
    {
        boolean bl = true;
        if(chk.equals("N"))
        {
            bl = false;
        }
        else
        {
            bl = true;
        }
        return bl;
    }
    
    public String cvString(boolean chk)
    {
        String bl = "";
        if(chk)
        {
            bl = "Y";
        }
        else
        {
            bl = "N";
        }
        return bl;
    }
    private void ClearTemp()
    {
        Cont0 = setBoolean("N");
        Cont1 = setBoolean("N");
        Cont2 = setBoolean("N");
        Cont3 = setBoolean("N");
        Cont4 = setBoolean("N");
        Cont5 = setBoolean("N");
        Cont6 = setBoolean("N");
        Cont7 = setBoolean("N");
        Cont8 = setBoolean("N");
        Cont9 = setBoolean("N");
        Cont10 = setBoolean("N");
        Cont11 = setBoolean("N");
        Cont12 = setBoolean("N");
        Cont13 = setBoolean("N");
        Sale1 = setBoolean("N");
        Sale2 = setBoolean("N");
        Sale3 = setBoolean("N");
        Sale4 = setBoolean("N");
        Sale5 = setBoolean("N");
        Sale6 = setBoolean("N");
        Sale7 = setBoolean("N");
        Sale8 = setBoolean("N");
        Sale9 = setBoolean("N");
        Sale10 = setBoolean("N");
        Sale11 = setBoolean("N");
        Sale12 = setBoolean("N");
        Sale13 = setBoolean("N");
        Sale14 = setBoolean("N");
        Sale15 = setBoolean("N");
        Sale16 = setBoolean("N");
        Sale17 = setBoolean("N");
        Sale18 = setBoolean("N");
        Sale19 = setBoolean("N");
        Sale20 = setBoolean("N");
        Sale21 = setBoolean("N");
        Sale22 = setBoolean("N");
        Sale23 = setBoolean("N");
        Sale24 = setBoolean("N");
        Sale25 = setBoolean("N");
        Sale26 = setBoolean("N");
        Sale27 = setBoolean("N");
        Sale28 = setBoolean("N");
        Sale29 = setBoolean("N");
        Sale30 = setBoolean("N");
        Sale31 = setBoolean("N");
        Sale32 = setBoolean("N");
        Sale33 = setBoolean("N");
        Sale34 = setBoolean("N");
        Sale35 = setBoolean("N");
        Sale36 = setBoolean("N");
        Stock0 = setBoolean("N");
        Stock1 = setBoolean("N");
        Stock2 = setBoolean("N");
        Stock3 = setBoolean("N");
        Stock4 = setBoolean("N");
        Stock5 = setBoolean("N");
        Stock6 = setBoolean("N");
        Stock7 = setBoolean("N");
        Stock8 = setBoolean("N");
        Stock9 = setBoolean("N");
        Stock10 = setBoolean("N");
        Stock11 = setBoolean("N");
        Stock12 = setBoolean("N");
        Stock13 = setBoolean("N");
        Stock14 = setBoolean("N");
        Stock15 = setBoolean("N");
        Stock16 = setBoolean("N");
        Stock17 = setBoolean("N");
        Stock18 = setBoolean("N");
        Stock19 = setBoolean("N");
        Stock20 = setBoolean("N");
        Stock21 = setBoolean("N");
        Stock22 = setBoolean("N");
        Stock23 = setBoolean("N");
        Stock24 = setBoolean("N");
        Stock25 = setBoolean("N");
        Stock26 = setBoolean("N");
        Stock27 = setBoolean("N");
        Stock28 = setBoolean("N");
        Stock29 = setBoolean("N");
        Stock30 = setBoolean("N");
        Stock31 = setBoolean("N");
        Stock32 = setBoolean("N");
        Stock33 = setBoolean("N");
        Stock34 = setBoolean("N");
        Stock35 = setBoolean("N");
        Stock36 = setBoolean("N");
        Stock37 = setBoolean("N");
        Stock38 = setBoolean("N");
        Stock39 = setBoolean("N");
        Stock40 = setBoolean("N");
        Stock41 = setBoolean("N");
        Stock42 = setBoolean("N");
        Stock43 = setBoolean("N");
        Stock44 = setBoolean("N");
        Stock45 = setBoolean("N");
    }
    
    private void setMenuUpdate() {
       
        
        
            
            try {
            
               stmt = (Statement) db.con.createStatement();
               String sql = "update usermenu set onact = 'N'";
               stmt.executeUpdate(sql);
               stmt.close();
               indexplutbl = -1;
               
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
            }
                
        
        
        
    }
    public void removetbl(JTable tb)
    {
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
            String sql = "select * from usergroup";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                
                  
                        
                        tbmodel.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("username"))
                                    
                        });
                    
                
            }
            
            }
            else
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from usergroup";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                
                  
                        
                        tbmodel.addRow(new Object[]{rs.getString("username")
                                    
                        });
                    
                
            }
            }
            stmt.close();
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
            
            
        if(!chkgroup(GroupCode))
        {
                if(!db.Char_Set.equalsIgnoreCase("utf-8"))
                {
                setMenuUpdate();
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from usermenu";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                            tbmodel.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("mgroup")),
                                                        cvth.ASCII2Unicode(rs.getString("mcode")),
                                                        cvth.ASCII2Unicode(rs.getString("mdesc")),
                                                        setBoolean(rs.getString("onact"))
                                        
                            });
                }
                }
                else
                {
                setMenuUpdate();
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from usermenu";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                            tbmodel.addRow(new Object[]{rs.getString("mgroup"),
                                                        rs.getString("mcode"),
                                                        rs.getString("mdesc"),
                                                        setBoolean(rs.getString("onact"))
                                        
                            });
                }
                }
           
        }
        else
        {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
                {
                setMenuUpdate();
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from usermenu";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                            tbmodel.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("mgroup")),
                                                        cvth.ASCII2Unicode(rs.getString("mcode")),
                                                        cvth.ASCII2Unicode(rs.getString("mdesc")),
                                                        setBoolean(rs.getString("onact"))
                                        
                            });
                }
                }
            else{
                setMenuUpdate();
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from usermenu";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                            tbmodel.addRow(new Object[]{rs.getString("mgroup"),
                                                        rs.getString("mcode"),
                                                        rs.getString("mdesc"),
                                                        setBoolean(rs.getString("onact"))
                                        
                            });
                }
            }
                
                setDataFormDb(GroupCode);
                for(int i = 0;i<tbl3.getRowCount();i++ )
                    {
                        String mcode = tbl3.getValueAt(i, 1).toString();
                        
                        if(mcode.equals("Cont0"))
                        {
                            tbl3.setValueAt(Cont0, i, 3);
                        }
                        else if(mcode.equals("Cont1"))
                        {
                            tbl3.setValueAt(Cont1, i, 3);
                        }
                        else if(mcode.equals("Cont2"))
                        {
                            tbl3.setValueAt(Cont2, i, 3);
                        }
                        else if(mcode.equals("Cont3"))
                        {
                            tbl3.setValueAt(Cont3, i, 3);
                        }
                        else if(mcode.equals("Cont4"))
                        {
                            tbl3.setValueAt(Cont4, i, 3);
                        }
                        else if(mcode.equals("Cont5"))
                        {
                            tbl3.setValueAt(Cont5, i, 3);
                        }
                        else if(mcode.equals("Cont6"))
                        {
                            tbl3.setValueAt(Cont6, i, 3);
                        }
                        else if(mcode.equals("Cont7"))
                        {
                            tbl3.setValueAt(Cont7, i, 3);
                        }
                        else if(mcode.equals("Cont8"))
                        {
                            tbl3.setValueAt(Cont8, i, 3);
                        }
                        else if(mcode.equals("Cont9"))
                        {
                            tbl3.setValueAt(Cont9, i, 3);
                        }
                        else if(mcode.equals("Cont10"))
                        {
                            tbl3.setValueAt(Cont10, i, 3);
                        }
                        else if(mcode.equals("Cont11"))
                        {
                            tbl3.setValueAt(Cont11, i, 3);
                        }
                        else if(mcode.equals("Cont12"))
                        {
                            tbl3.setValueAt(Cont12, i, 3);
                        }
                        else if(mcode.equals("Cont13"))
                        {
                            tbl3.setValueAt(Cont13, i, 3);
                        }else if(mcode.equals("Sale1"))
                        {
                            tbl3.setValueAt(Sale1, i, 3);
                        }else if(mcode.equals("Sale2"))
                        {
                            tbl3.setValueAt(Sale2, i, 3);
                        }else if(mcode.equals("Sale3"))
                        {
                            tbl3.setValueAt(Sale3, i, 3);
                        }else if(mcode.equals("Sale4"))
                        {
                            tbl3.setValueAt(Sale4, i, 3);
                        }else if(mcode.equals("Sale5"))
                        {
                            tbl3.setValueAt(Sale5, i, 3);
                        }else if(mcode.equals("Sale6"))
                        {
                            tbl3.setValueAt(Sale6, i, 3);
                        }else if(mcode.equals("Sale7"))
                        {
                            tbl3.setValueAt(Sale7, i, 3);
                        }else if(mcode.equals("Sale8"))
                        {
                            tbl3.setValueAt(Sale8, i, 3);
                        }else if(mcode.equals("Sale9"))
                        {
                            tbl3.setValueAt(Sale9, i, 3);
                        }else if(mcode.equals("Sale10"))
                        {
                            tbl3.setValueAt(Sale10, i, 3);
                        }else if(mcode.equals("Sale11"))
                        {
                            tbl3.setValueAt(Sale11, i, 3);
                        }
                        else if(mcode.equals("Sale12"))
                        {
                            tbl3.setValueAt(Sale12, i, 3);
                        }
                        else if(mcode.equals("Sale13"))
                        {
                            tbl3.setValueAt(Sale13, i, 3);
                        }
                        else if(mcode.equals("Sale14"))
                        {
                            tbl3.setValueAt(Sale14, i, 3);
                        }
                        else if(mcode.equals("Sale15"))
                        {
                            tbl3.setValueAt(Sale15, i, 3);
                        }
                        else if(mcode.equals("Sale16"))
                        {
                            tbl3.setValueAt(Sale16, i, 3);
                        }
                        else if(mcode.equals("Sale17"))
                        {
                            tbl3.setValueAt(Sale17, i, 3);
                        }
                        else if(mcode.equals("Sale18"))
                        {
                            tbl3.setValueAt(Sale18, i, 3);
                        }
                        else if(mcode.equals("Sale19"))
                        {
                            tbl3.setValueAt(Sale19, i, 3);
                        }
                        else if(mcode.equals("Sale20"))
                        {
                            tbl3.setValueAt(Sale20, i, 3);
                        }else if(mcode.equals("Sale21"))
                        {
                            tbl3.setValueAt(Sale21, i, 3);
                        }
                        else if(mcode.equals("Sale22"))
                        {
                            tbl3.setValueAt(Sale22, i, 3);
                        }
                        else if(mcode.equals("Sale23"))
                        {
                            tbl3.setValueAt(Sale23, i, 3);
                        }
                        else if(mcode.equals("Sale24"))
                        {
                            tbl3.setValueAt(Sale24, i, 3);
                        }
                        else if(mcode.equals("Sale25"))
                        {
                            tbl3.setValueAt(Sale25, i, 3);
                        }
                        else if(mcode.equals("Sale26"))
                        {
                            tbl3.setValueAt(Sale26, i, 3);
                        }
                        else if(mcode.equals("Sale27"))
                        {
                            tbl3.setValueAt(Sale27, i, 3);
                        }
                        else if(mcode.equals("Sale28"))
                        {
                            tbl3.setValueAt(Sale28, i, 3);
                        }
                        else if(mcode.equals("Sale29"))
                        {
                            tbl3.setValueAt(Sale29, i, 3);
                        }
                        else if(mcode.equals("Sale30"))
                        {
                            tbl3.setValueAt(Sale30, i, 3);
                        }else if(mcode.equals("Sale31"))
                        {
                            tbl3.setValueAt(Sale31, i, 3);
                        }
                        else if(mcode.equals("Sale32"))
                        {
                            tbl3.setValueAt(Sale32, i, 3);
                        }else if(mcode.equals("Sale33"))
                        {
                            tbl3.setValueAt(Sale33, i, 3);
                        }else if(mcode.equals("Sale34"))
                        {
                            tbl3.setValueAt(Sale34, i, 3);
                        }else if(mcode.equals("Sale35"))
                        {
                            tbl3.setValueAt(Sale35, i, 3);
                        }else if(mcode.equals("Sale36"))
                        {
                            tbl3.setValueAt(Sale36, i, 3);
                        }else if(mcode.equals("Stock0"))
                        {
                            tbl3.setValueAt(Stock0, i, 3);
                        }else if(mcode.equals("Stock1"))
                        {
                            tbl3.setValueAt(Stock1, i, 3);
                        }else if(mcode.equals("Stock2"))
                        {
                            tbl3.setValueAt(Stock2, i, 3);
                        }else if(mcode.equals("Stock3"))
                        {
                            tbl3.setValueAt(Stock3, i, 3);
                        }else if(mcode.equals("Stock4"))
                        {
                            tbl3.setValueAt(Stock4, i, 3);
                        }else if(mcode.equals("Stock5"))
                        {
                            tbl3.setValueAt(Stock5, i, 3);
                        }else if(mcode.equals("Stock6"))
                        {
                            tbl3.setValueAt(Stock6, i, 3);
                        }else if(mcode.equals("Stock7"))
                        {
                            tbl3.setValueAt(Stock7, i, 3);
                        }else if(mcode.equals("Stock8"))
                        {
                            tbl3.setValueAt(Stock8, i, 3);
                        }else if(mcode.equals("Stock9"))
                        {
                            tbl3.setValueAt(Stock9, i, 3);
                        }else if(mcode.equals("Stock10"))
                        {
                            tbl3.setValueAt(Stock10, i, 3);
                        }else if(mcode.equals("Stock11"))
                        {
                            tbl3.setValueAt(Stock11, i, 3);
                        }else if(mcode.equals("Stock12"))
                        {
                            tbl3.setValueAt(Stock12, i, 3);
                        }else if(mcode.equals("Stock13"))
                        {
                            tbl3.setValueAt(Stock13, i, 3);
                        }else if(mcode.equals("Stock14"))
                        {
                            tbl3.setValueAt(Stock14, i, 3);
                        }else if(mcode.equals("Stock15"))
                        {
                            tbl3.setValueAt(Stock15, i, 3);
                        }else if(mcode.equals("Stock16"))
                        {
                            tbl3.setValueAt(Stock16, i, 3);
                        }else if(mcode.equals("Stock17"))
                        {
                            tbl3.setValueAt(Stock17, i, 3);
                        }else if(mcode.equals("Stock18"))
                        {
                            tbl3.setValueAt(Stock18, i, 3);
                        }else if(mcode.equals("Stock19"))
                        {
                            tbl3.setValueAt(Stock19, i, 3);
                        }else if(mcode.equals("Stock20"))
                        {
                            tbl3.setValueAt(Stock20, i, 3);
                        }else if(mcode.equals("Stock21"))
                        {
                            tbl3.setValueAt(Stock21, i, 3);
                        }else if(mcode.equals("Stock22"))
                        {
                            tbl3.setValueAt(Stock22, i, 3);
                        }else if(mcode.equals("Stock23"))
                        {
                            tbl3.setValueAt(Stock23, i, 3);
                        }else if(mcode.equals("Stock24"))
                        {
                            tbl3.setValueAt(Stock24, i, 3);
                        }else if(mcode.equals("Stock25"))
                        {
                            tbl3.setValueAt(Stock25, i, 3);
                        }else if(mcode.equals("Stock26"))
                        {
                            tbl3.setValueAt(Stock26, i, 3);
                        }else if(mcode.equals("Stock27"))
                        {
                            tbl3.setValueAt(Stock27, i, 3);
                        }else if(mcode.equals("Stock28"))
                        {
                            tbl3.setValueAt(Stock28, i, 3);
                        }else if(mcode.equals("Stock29"))
                        {
                            tbl3.setValueAt(Stock29, i, 3);
                        }else if(mcode.equals("Stock30"))
                        {
                            tbl3.setValueAt(Stock30, i, 3);
                        }else if(mcode.equals("Stock31"))
                        {
                            tbl3.setValueAt(Stock31, i, 3);
                        }else if(mcode.equals("Stock32"))
                        {
                            tbl3.setValueAt(Stock32, i, 3);
                        }else if(mcode.equals("Stock33"))
                        {
                            tbl3.setValueAt(Stock33, i, 3);
                        }else if(mcode.equals("Stock34"))
                        {
                            tbl3.setValueAt(Stock34, i, 3);
                        }else if(mcode.equals("Stock35"))
                        {
                            tbl3.setValueAt(Stock35, i, 3);
                        }else if(mcode.equals("Stock36"))
                        {
                            tbl3.setValueAt(Stock36, i, 3);
                        }else if(mcode.equals("Stock37"))
                        {
                            tbl3.setValueAt(Stock37, i, 3);
                        }else if(mcode.equals("Stock38"))
                        {
                            tbl3.setValueAt(Stock38, i, 3);
                        }else if(mcode.equals("Stock39"))
                        {
                            tbl3.setValueAt(Stock39, i, 3);
                        }else if(mcode.equals("Stock40"))
                        {
                            tbl3.setValueAt(Stock40, i, 3);
                        }else if(mcode.equals("Stock41"))
                        {
                            tbl3.setValueAt(Stock41, i, 3);
                        }else if(mcode.equals("Stock42"))
                        {
                            tbl3.setValueAt(Stock42, i, 3);
                        }else if(mcode.equals("Stock43"))
                        {
                            tbl3.setValueAt(Stock43, i, 3);
                        }else if(mcode.equals("Stock44"))
                        {
                            tbl3.setValueAt(Stock44, i, 3);
                        }else if(mcode.equals("Stock45"))
                        {
                            tbl3.setValueAt(Stock45, i, 3);
                        }
                        
                        
                        
                    }
            
        }
         } catch (SQLException ex) {
                Logger.getLogger(setUserGroup.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private boolean chkgroup(String code) {
        boolean chk = false;
    ResultSet rs = null;
    try {
        if(!db.Char_Set.equalsIgnoreCase("utf-8"))
        {
        stmt = (Statement) db.con.createStatement();
        String sql = "select * from usergroup where username ='"+cvth.Unicode2ASCII(code)+"'";
        rs = stmt.executeQuery(sql);
        if(rs.next())
        {
           chk = true;
        }
      
        }
        else
        {
        stmt = (Statement) db.con.createStatement();
        String sql = "select * from usergroup where username ='"+code+"'";
        rs = stmt.executeQuery(sql);
         if(rs.next())
        {
            chk = true;
            
        }
        
        }
    } catch (Exception e) {
        
    }
    return chk;
    }
    private void setDataFormTbl()
    {
                    for(int i = 0;i<tbl3.getRowCount();i++ )
                    {
                        String mcode = tbl3.getValueAt(i, 1).toString();
                        boolean onact = Boolean.parseBoolean(tbl3.getValueAt(i, 3).toString());
                        if(mcode.equals("Cont0"))
                        {
                           sCont0 = cvString(onact);
                        }
                        else if(mcode.equals("Cont1"))
                        {
                            sCont1 = cvString(onact);
                        }
                        else if(mcode.equals("Cont2"))
                        {
                            sCont2 = cvString(onact);
                        }
                        else if(mcode.equals("Cont3"))
                        {
                            sCont3 = cvString(onact);
                        }
                        else if(mcode.equals("Cont4"))
                        {
                            sCont4 = cvString(onact);
                        }
                        else if(mcode.equals("Cont5"))
                        {
                            sCont5 = cvString(onact);
                        }
                        else if(mcode.equals("Cont6"))
                        {
                            sCont6 = cvString(onact);
                        }
                        else if(mcode.equals("Cont7"))
                        {
                            sCont7 = cvString(onact);
                        }
                        else if(mcode.equals("Cont8"))
                        {
                            sCont8 = cvString(onact);
                        }
                        else if(mcode.equals("Cont9"))
                        {
                            sCont9 = cvString(onact);
                        }
                        else if(mcode.equals("Cont10"))
                        {
                            sCont10 = cvString(onact);
                        }
                        else if(mcode.equals("Cont11"))
                        {
                            sCont11 = cvString(onact);
                        }
                        else if(mcode.equals("Cont12"))
                        {
                            sCont12 = cvString(onact);
                        }
                        else if(mcode.equals("Cont13"))
                        {
                            sCont13 = cvString(onact);
                        }else if(mcode.equals("Sale1"))
                        {
                            sSale1 = cvString(onact);
                        }else if(mcode.equals("Sale2"))
                        {
                            sSale2 = cvString(onact);
                        }else if(mcode.equals("Sale3"))
                        {
                            sSale3 = cvString(onact);
                        }else if(mcode.equals("Sale4"))
                        {
                            sSale4 = cvString(onact);
                        }else if(mcode.equals("Sale5"))
                        {
                            sSale5 = cvString(onact);
                        }else if(mcode.equals("Sale6"))
                        {
                            sSale6 = cvString(onact);
                        }else if(mcode.equals("Sale7"))
                        {
                            sSale7 = cvString(onact);
                        }else if(mcode.equals("Sale8"))
                        {
                            sSale8 = cvString(onact);
                        }else if(mcode.equals("Sale9"))
                        {
                            sSale9 = cvString(onact);
                        }else if(mcode.equals("Sale10"))
                        {
                            sSale10 = cvString(onact);
                        }else if(mcode.equals("Sale11"))
                        {
                            sSale11 = cvString(onact);
                        }
                        else if(mcode.equals("Sale12"))
                        {
                            sSale12 = cvString(onact);
                        }
                        else if(mcode.equals("Sale13"))
                        {
                            sSale13 = cvString(onact);
                        }
                        else if(mcode.equals("Sale14"))
                        {
                            sSale14 = cvString(onact);
                        }
                        else if(mcode.equals("Sale15"))
                        {
                            sSale15 = cvString(onact);
                        }
                        else if(mcode.equals("Sale16"))
                        {
                            sSale16 = cvString(onact);
                        }
                        else if(mcode.equals("Sale17"))
                        {
                            sSale17 = cvString(onact);
                        }
                        else if(mcode.equals("Sale18"))
                        {
                            sSale18 = cvString(onact);
                        }
                        else if(mcode.equals("Sale19"))
                        {
                            sSale19 = cvString(onact);
                        }
                        else if(mcode.equals("Sale20"))
                        {
                            sSale20 = cvString(onact);
                        }else if(mcode.equals("Sale21"))
                        {
                            sSale21 = cvString(onact);
                        }
                        else if(mcode.equals("Sale22"))
                        {
                            sSale22 = cvString(onact);
                        }
                        else if(mcode.equals("Sale23"))
                        {
                            sSale23 = cvString(onact);
                        }
                        else if(mcode.equals("Sale24"))
                        {
                            sSale24 = cvString(onact);
                        }
                        else if(mcode.equals("Sale25"))
                        {
                            sSale25 = cvString(onact);
                        }
                        else if(mcode.equals("Sale26"))
                        {
                            sSale26 = cvString(onact);
                        }
                        else if(mcode.equals("Sale27"))
                        {
                            sSale27 = cvString(onact);
                        }
                        else if(mcode.equals("Sale28"))
                        {
                            sSale28 = cvString(onact);
                        }
                        else if(mcode.equals("Sale29"))
                        {
                            sSale29 = cvString(onact);
                        }
                        else if(mcode.equals("Sale30"))
                        {
                            sSale30 = cvString(onact);
                        }else if(mcode.equals("Sale31"))
                        {
                            sSale31 = cvString(onact);
                        }
                        else if(mcode.equals("Sale32"))
                        {
                            sSale32 = cvString(onact);
                        }else if(mcode.equals("Sale33"))
                        {
                            sSale33 = cvString(onact);
                        }else if(mcode.equals("Sale34"))
                        {
                            sSale34 = cvString(onact);
                        }else if(mcode.equals("Sale35"))
                        {
                            sSale35 = cvString(onact);
                        }else if(mcode.equals("Sale36"))
                        {
                            sSale36 = cvString(onact);
                        }else if(mcode.equals("Stock0"))
                        {
                            sStock0 = cvString(onact);
                        }else if(mcode.equals("Stock1"))
                        {
                            sStock1 = cvString(onact);
                        }else if(mcode.equals("Stock2"))
                        {
                            sStock2 = cvString(onact);
                        }else if(mcode.equals("Stock3"))
                        {
                            sStock3 = cvString(onact);
                        }else if(mcode.equals("Stock4"))
                        {
                            sStock4 = cvString(onact);
                        }else if(mcode.equals("Stock5"))
                        {
                            sStock5 = cvString(onact);
                        }else if(mcode.equals("Stock6"))
                        {
                            sStock6 = cvString(onact);
                        }else if(mcode.equals("Stock7"))
                        {
                            sStock7 = cvString(onact);
                        }else if(mcode.equals("Stock8"))
                        {
                            sStock8 = cvString(onact);
                        }else if(mcode.equals("Stock9"))
                        {
                            sStock9 = cvString(onact);
                        }else if(mcode.equals("Stock10"))
                        {
                            sStock10 = cvString(onact);
                        }else if(mcode.equals("Stock11"))
                        {
                            sStock11 = cvString(onact);
                        }else if(mcode.equals("Stock12"))
                        {
                            sStock12 = cvString(onact);
                        }else if(mcode.equals("Stock13"))
                        {
                            sStock13 = cvString(onact);
                        }else if(mcode.equals("Stock14"))
                        {
                            sStock14 = cvString(onact);
                        }else if(mcode.equals("Stock15"))
                        {
                            sStock15 = cvString(onact);
                        }else if(mcode.equals("Stock16"))
                        {
                            sStock16 = cvString(onact);
                        }else if(mcode.equals("Stock17"))
                        {
                            sStock17 = cvString(onact);
                        }else if(mcode.equals("Stock18"))
                        {
                            sStock18 = cvString(onact);
                        }else if(mcode.equals("Stock19"))
                        {
                            sStock19 = cvString(onact);
                        }else if(mcode.equals("Stock20"))
                        {
                            sStock20 = cvString(onact);
                        }else if(mcode.equals("Stock21"))
                        {
                            sStock21 = cvString(onact);
                        }else if(mcode.equals("Stock22"))
                        {
                            sStock22 = cvString(onact);
                        }else if(mcode.equals("Stock23"))
                        {
                            sStock23 = cvString(onact);
                        }else if(mcode.equals("Stock24"))
                        {
                            sStock24 = cvString(onact);
                        }else if(mcode.equals("Stock25"))
                        {
                            sStock25 = cvString(onact);
                        }else if(mcode.equals("Stock26"))
                        {
                            sStock26 = cvString(onact);
                        }else if(mcode.equals("Stock27"))
                        {
                            sStock27 = cvString(onact);
                        }else if(mcode.equals("Stock28"))
                        {
                            sStock28 = cvString(onact);
                        }else if(mcode.equals("Stock29"))
                        {
                            sStock29 = cvString(onact);
                        }else if(mcode.equals("Stock30"))
                        {
                            sStock30 = cvString(onact);
                        }else if(mcode.equals("Stock31"))
                        {
                            sStock31 = cvString(onact);
                        }else if(mcode.equals("Stock32"))
                        {
                            sStock32 = cvString(onact);
                        }else if(mcode.equals("Stock33"))
                        {
                            sStock33 = cvString(onact);
                        }else if(mcode.equals("Stock34"))
                        {
                            sStock34 = cvString(onact);
                        }else if(mcode.equals("Stock35"))
                        {
                            sStock35 = cvString(onact);
                        }else if(mcode.equals("Stock36"))
                        {
                            sStock36 = cvString(onact);
                        }else if(mcode.equals("Stock37"))
                        {
                            sStock37 = cvString(onact);
                        }else if(mcode.equals("Stock38"))
                        {
                            sStock38 = cvString(onact);
                        }else if(mcode.equals("Stock39"))
                        {
                            sStock39 = cvString(onact);
                        }else if(mcode.equals("Stock40"))
                        {
                            sStock40 = cvString(onact);
                        }else if(mcode.equals("Stock41"))
                        {
                            sStock41 = cvString(onact);
                        }else if(mcode.equals("Stock42"))
                        {
                            sStock42 = cvString(onact);
                        }else if(mcode.equals("Stock43"))
                        {
                            sStock43 = cvString(onact);
                        }else if(mcode.equals("Stock44"))
                        {
                            sStock44 = cvString(onact);
                        }else if(mcode.equals("Stock45"))
                        {
                            sStock45 = cvString(onact);
                        }
                        
                        
                        
                    }
       
    }
    private void setDataFormDb(String GroupCode)
    {
        
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String sql = "";
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                sql = "select * from usergroup where username = '"+cvth.Unicode2ASCII(GroupCode)+"'";
            }
            else
            {
                sql = "select * from usergroup where username = '"+GroupCode+"'";
            }
            
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
            {
                Cont0 = setBoolean(rs.getString("Cont0"));
                Cont1 = setBoolean(rs.getString("Cont1"));
                Cont2 = setBoolean(rs.getString("Cont2"));
                Cont3 = setBoolean(rs.getString("Cont3"));
                Cont4 = setBoolean(rs.getString("Cont4"));
                Cont5 = setBoolean(rs.getString("Cont5"));
                Cont6 = setBoolean(rs.getString("Cont6"));
                Cont7 = setBoolean(rs.getString("Cont7"));
                Cont8 = setBoolean(rs.getString("Cont8"));
                Cont9 = setBoolean(rs.getString("Cont9"));
                Cont10 = setBoolean(rs.getString("Cont10"));
                Cont11 = setBoolean(rs.getString("Cont11"));
                Cont12 = setBoolean(rs.getString("Cont12"));
                Cont13 = setBoolean(rs.getString("Cont13"));
                Sale1 = setBoolean(rs.getString("Sale1"));
                Sale2 = setBoolean(rs.getString("Sale2"));
                Sale3 = setBoolean(rs.getString("Sale3"));
                Sale4 = setBoolean(rs.getString("Sale4"));
                Sale5 = setBoolean(rs.getString("Sale5"));
                Sale6 = setBoolean(rs.getString("Sale6"));
                Sale7 = setBoolean(rs.getString("Sale7"));
                Sale8 = setBoolean(rs.getString("Sale8"));
                Sale9 = setBoolean(rs.getString("Sale9"));
                Sale10 = setBoolean(rs.getString("Sale10"));
                Sale11 = setBoolean(rs.getString("Sale11"));
                Sale12 = setBoolean(rs.getString("Sale12"));
                Sale13 = setBoolean(rs.getString("Sale13"));
                Sale14 = setBoolean(rs.getString("Sale14"));
                Sale15 = setBoolean(rs.getString("Sale15"));
                Sale16 = setBoolean(rs.getString("Sale16"));
                Sale17 = setBoolean(rs.getString("Sale17"));
                Sale18 = setBoolean(rs.getString("Sale18"));
                Sale19 = setBoolean(rs.getString("Sale19"));
                Sale20 = setBoolean(rs.getString("Sale20"));
                Sale21 = setBoolean(rs.getString("Sale21"));
                Sale22 = setBoolean(rs.getString("Sale22"));
                Sale23 = setBoolean(rs.getString("Sale23"));
                Sale24 = setBoolean(rs.getString("Sale24"));
                Sale25 = setBoolean(rs.getString("Sale25"));
                Sale26 = setBoolean(rs.getString("Sale26"));
                Sale27 = setBoolean(rs.getString("Sale27"));
                Sale28 = setBoolean(rs.getString("Sale28"));
                Sale29 = setBoolean(rs.getString("Sale29"));
                Sale30 = setBoolean(rs.getString("Sale30"));
                Sale31 = setBoolean(rs.getString("Sale31"));
                Sale32 = setBoolean(rs.getString("Sale32"));
                Sale33 = setBoolean(rs.getString("Sale33"));
                Sale34 = setBoolean(rs.getString("Sale34"));
                Sale35 = setBoolean(rs.getString("Sale35"));
                Sale36 = setBoolean(rs.getString("Sale36"));
                Stock0 = setBoolean(rs.getString("Stock0"));
                Stock1 = setBoolean(rs.getString("Stock1"));
                Stock2 = setBoolean(rs.getString("Stock2"));
                Stock3 = setBoolean(rs.getString("Stock3"));
                Stock4 = setBoolean(rs.getString("Stock4"));
                Stock5 = setBoolean(rs.getString("Stock5"));
                Stock6 = setBoolean(rs.getString("Stock6"));
                Stock7 = setBoolean(rs.getString("Stock7"));
                Stock8 = setBoolean(rs.getString("Stock8"));
                Stock9 = setBoolean(rs.getString("Stock9"));
                Stock10 = setBoolean(rs.getString("Stock10"));
                Stock11 = setBoolean(rs.getString("Stock11"));
                Stock12 = setBoolean(rs.getString("Stock12"));
                Stock13 = setBoolean(rs.getString("Stock13"));
                Stock14 = setBoolean(rs.getString("Stock14"));
                Stock15 = setBoolean(rs.getString("Stock15"));
                Stock16 = setBoolean(rs.getString("Stock16"));
                Stock17 = setBoolean(rs.getString("Stock17"));
                Stock18 = setBoolean(rs.getString("Stock18"));
                Stock19 = setBoolean(rs.getString("Stock19"));
                Stock20 = setBoolean(rs.getString("Stock20"));
                Stock21 = setBoolean(rs.getString("Stock21"));
                Stock22 = setBoolean(rs.getString("Stock22"));
                Stock23 = setBoolean(rs.getString("Stock23"));
                Stock24 = setBoolean(rs.getString("Stock24"));
                Stock25 = setBoolean(rs.getString("Stock25"));
                Stock26 = setBoolean(rs.getString("Stock26"));
                Stock27 = setBoolean(rs.getString("Stock27"));
                Stock28 = setBoolean(rs.getString("Stock28"));
                Stock29 = setBoolean(rs.getString("Stock29"));
                Stock30 = setBoolean(rs.getString("Stock30"));
                Stock31 = setBoolean(rs.getString("Stock31"));
                Stock32 = setBoolean(rs.getString("Stock32"));
                Stock33 = setBoolean(rs.getString("Stock33"));
                Stock34 = setBoolean(rs.getString("Stock34"));
                Stock35 = setBoolean(rs.getString("Stock35"));
                Stock36 = setBoolean(rs.getString("Stock36"));
                Stock37 = setBoolean(rs.getString("Stock37"));
                Stock38 = setBoolean(rs.getString("Stock38"));
                Stock39 = setBoolean(rs.getString("Stock39"));
                Stock40 = setBoolean(rs.getString("Stock40"));
                Stock41 = setBoolean(rs.getString("Stock41"));
                Stock42 = setBoolean(rs.getString("Stock42"));
                Stock43 = setBoolean(rs.getString("Stock43"));
                Stock44 = setBoolean(rs.getString("Stock44"));
                Stock45 = setBoolean(rs.getString("Stock45"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(setUserGroup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void save() {
        try {

            setDataFormTbl();
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                if (validatesave()) {
                    if (chkgroup(t_groupuser.getText())) {

                        //update
                        String sql2 = "Update usergroup Set Cont0=?,Cont1=?,Cont2=?,Cont3=?,"
                                + "Cont4=?,Cont5=?,Cont6=?,Cont7=?,Cont8=?,Cont9=?,Cont10=?,"
                                + "Cont11=?,Cont12=?,Cont13=?,"
                                + "Sale1=?,Sale2=?,Sale3=?,Sale4=?,Sale5=?,Sale6=?,Sale7=?,"
                                + "Sale8=?,Sale9=?,Sale10=?,Sale11=?,Sale12=?,Sale13=?,"
                                + "Sale14=?,Sale15=?,Sale16=?,Sale17=?,Sale18=?,Sale19=?,"
                                + "Sale20=?,Sale21=?,Sale22=?,Sale23=?,Sale24=?,Sale25=?,Sale26=?,"
                                + "Sale27=?,Sale28=?,Sale29=?,Sale30=?,Sale31=?,Sale32=?,Sale33=?,"
                                + "Sale34=?,Sale35=?,Sale36=?,"
                                + "Stock0=?,Stock1=?,Stock2=?,Stock3=?,Stock4=?,Stock5=?,Stock6=?,"
                                + "Stock7=?,Stock8=?,Stock9=?,Stock10=?,Stock11=?,Stock12=?,Stock13=?,"
                                + "Stock14=?,Stock15=?,Stock16=?,Stock17=?,Stock18=?,Stock19=?,Stock20=?,"
                                + "Stock21=?,Stock22=?,Stock23=?,Stock24=?,Stock25=?,Stock26=?,Stock27=?,"
                                + "Stock28=?,Stock29=?,Stock30=?,Stock31=?,Stock32=?,Stock33=?,Stock34=?,"
                                + "Stock35=?,Stock36=?,Stock37=?,Stock38=?,Stock39=?,Stock40=?,Stock41=?,"
                                + "Stock42=?,Stock43=?,Stock44=?,Stock45=?,PassWord=? "
                                + "where UserName=?";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);

                        prm.setString(1, sCont0);
                        prm.setString(2, sCont1);
                        prm.setString(3, sCont2);
                        prm.setString(4, sCont3);
                        prm.setString(5, sCont4);
                        prm.setString(6, sCont5);
                        prm.setString(7, sCont6);
                        prm.setString(8, sCont7);
                        prm.setString(9, sCont8);
                        prm.setString(10, sCont9);
                        prm.setString(11, sCont10);
                        prm.setString(12, sCont11);
                        prm.setString(13, sCont12);
                        prm.setString(14, sCont13);
                        prm.setString(15, sSale1);
                        prm.setString(16, sSale2);
                        prm.setString(17, sSale3);
                        prm.setString(18, sSale4);
                        prm.setString(19, sSale5);
                        prm.setString(20, sSale6);
                        prm.setString(21, sSale7);
                        prm.setString(22, sSale8);
                        prm.setString(23, sSale9);
                        prm.setString(24, sSale10);
                        prm.setString(25, sSale11);
                        prm.setString(26, sSale12);
                        prm.setString(27, sSale13);
                        prm.setString(28, sSale14);
                        prm.setString(29, sSale15);
                        prm.setString(30, sSale16);
                        prm.setString(31, sSale17);
                        prm.setString(32, sSale18);
                        prm.setString(33, sSale19);
                        prm.setString(34, sSale20);
                        prm.setString(35, sSale21);
                        prm.setString(36, sSale22);
                        prm.setString(37, sSale23);
                        prm.setString(38, sSale24);
                        prm.setString(39, sSale25);
                        prm.setString(40, sSale26);
                        prm.setString(41, sSale27);
                        prm.setString(42, sSale28);
                        prm.setString(43, sSale29);
                        prm.setString(44, sSale30);
                        prm.setString(45, sSale31);
                        prm.setString(46, sSale32);
                        prm.setString(47, sSale33);
                        prm.setString(48, sSale34);
                        prm.setString(49, sSale35);
                        prm.setString(50, sSale36);
                        prm.setString(51, sStock0);
                        prm.setString(52, sStock1);
                        prm.setString(53, sStock2);
                        prm.setString(54, sStock3);
                        prm.setString(55, sStock4);
                        prm.setString(56, sStock5);
                        prm.setString(57, sStock6);
                        prm.setString(58, sStock7);
                        prm.setString(59, sStock8);
                        prm.setString(60, sStock9);
                        prm.setString(61, sStock10);
                        prm.setString(62, sStock11);
                        prm.setString(63, sStock12);
                        prm.setString(64, sStock13);
                        prm.setString(65, sStock14);
                        prm.setString(66, sStock15);
                        prm.setString(67, sStock16);
                        prm.setString(68, sStock17);
                        prm.setString(69, sStock18);
                        prm.setString(70, sStock19);
                        prm.setString(71, sStock20);
                        prm.setString(72, sStock21);
                        prm.setString(73, sStock22);
                        prm.setString(74, sStock23);
                        prm.setString(75, sStock24);
                        prm.setString(76, sStock25);
                        prm.setString(77, sStock26);
                        prm.setString(78, sStock27);
                        prm.setString(79, sStock28);
                        prm.setString(80, sStock29);
                        prm.setString(81, sStock30);
                        prm.setString(82, sStock31);
                        prm.setString(83, sStock32);
                        prm.setString(84, sStock33);
                        prm.setString(85, sStock34);
                        prm.setString(86, sStock35);
                        prm.setString(87, sStock36);
                        prm.setString(88, sStock37);
                        prm.setString(89, sStock38);
                        prm.setString(90, sStock39);
                        prm.setString(91, sStock40);
                        prm.setString(92, sStock41);
                        prm.setString(93, sStock42);
                        prm.setString(94, sStock43);
                        prm.setString(95, sStock44);
                        prm.setString(96, sStock45);
                        prm.setString(97, "");
                        prm.setString(98, cvth.Unicode2ASCII(t_groupuser.getText()));
                        prm.executeUpdate();
                        prm.close();
                    } else {
                        //insert

                        String sql2 = "Insert Into usergroup (Cont0 ,Cont1 ,Cont2 ,Cont3 ,"
                                + "Cont4 ,Cont5 ,Cont6 ,Cont7 ,Cont8 ,Cont9,Cont10 ,"
                                + "Cont11 ,Cont12 ,Cont13 ,"
                                + "Sale1 ,Sale2 ,Sale3 ,Sale4 ,Sale5 ,Sale6 ,Sale7 ,"
                                + "Sale8 ,Sale9 ,Sale10 ,Sale11 ,Sale12 ,Sale13 ,"
                                + "Sale14 ,Sale15 ,Sale16 ,Sale17 ,Sale18 ,Sale19 ,"
                                + "Sale20 ,Sale21 ,Sale22 ,Sale23 ,Sale24 ,Sale25 ,Sale26 ,"
                                + "Sale27 ,Sale28 ,Sale29 ,Sale30 ,Sale31 ,Sale32 ,Sale33 ,"
                                + "Sale34 ,Sale35 ,Sale36 ,"
                                + "Stock0 ,Stock1 ,Stock2 ,Stock3 ,Stock4 ,Stock5 ,Stock6 ,"
                                + "Stock7 ,Stock8 ,Stock9 ,Stock10 ,Stock11 ,Stock12 ,Stock13 ,"
                                + "Stock14 ,Stock15 ,Stock16 ,Stock17 ,Stock18 ,Stock19 ,Stock20 ,"
                                + "Stock21 ,Stock22 ,Stock23 ,Stock24 ,Stock25 ,Stock26 ,Stock27 ,"
                                + "Stock28 ,Stock29 ,Stock30 ,Stock31 ,Stock32 ,Stock33 ,Stock34 ,"
                                + "Stock35 ,Stock36 ,Stock37 ,Stock38 ,Stock39 ,Stock40 ,Stock41 ,"
                                + "Stock42 ,Stock43 ,Stock44 ,Stock45 ,PassWord ,UserName ) "
                                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);

                        prm.setString(1, sCont0);
                        prm.setString(2, sCont1);
                        prm.setString(3, sCont2);
                        prm.setString(4, sCont3);
                        prm.setString(5, sCont4);
                        prm.setString(6, sCont5);
                        prm.setString(7, sCont6);
                        prm.setString(8, sCont7);
                        prm.setString(9, sCont8);
                        prm.setString(10, sCont9);
                        prm.setString(11, sCont10);
                        prm.setString(12, sCont11);
                        prm.setString(13, sCont12);
                        prm.setString(14, sCont13);
                        prm.setString(15, sSale1);
                        prm.setString(16, sSale2);
                        prm.setString(17, sSale3);
                        prm.setString(18, sSale4);
                        prm.setString(19, sSale5);
                        prm.setString(20, sSale6);
                        prm.setString(21, sSale7);
                        prm.setString(22, sSale8);
                        prm.setString(23, sSale9);
                        prm.setString(24, sSale10);
                        prm.setString(25, sSale11);
                        prm.setString(26, sSale12);
                        prm.setString(27, sSale13);
                        prm.setString(28, sSale14);
                        prm.setString(29, sSale15);
                        prm.setString(30, sSale16);
                        prm.setString(31, sSale17);
                        prm.setString(32, sSale18);
                        prm.setString(33, sSale19);
                        prm.setString(34, sSale20);
                        prm.setString(35, sSale21);
                        prm.setString(36, sSale22);
                        prm.setString(37, sSale23);
                        prm.setString(38, sSale24);
                        prm.setString(39, sSale25);
                        prm.setString(40, sSale26);
                        prm.setString(41, sSale27);
                        prm.setString(42, sSale28);
                        prm.setString(43, sSale29);
                        prm.setString(44, sSale30);
                        prm.setString(45, sSale31);
                        prm.setString(46, sSale32);
                        prm.setString(47, sSale33);
                        prm.setString(48, sSale34);
                        prm.setString(49, sSale35);
                        prm.setString(50, sSale36);
                        prm.setString(51, sStock0);
                        prm.setString(52, sStock1);
                        prm.setString(53, sStock2);
                        prm.setString(54, sStock3);
                        prm.setString(55, sStock4);
                        prm.setString(56, sStock5);
                        prm.setString(57, sStock6);
                        prm.setString(58, sStock7);
                        prm.setString(59, sStock8);
                        prm.setString(60, sStock9);
                        prm.setString(61, sStock10);
                        prm.setString(62, sStock11);
                        prm.setString(63, sStock12);
                        prm.setString(64, sStock13);
                        prm.setString(65, sStock14);
                        prm.setString(66, sStock15);
                        prm.setString(67, sStock16);
                        prm.setString(68, sStock17);
                        prm.setString(69, sStock18);
                        prm.setString(70, sStock19);
                        prm.setString(71, sStock20);
                        prm.setString(72, sStock21);
                        prm.setString(73, sStock22);
                        prm.setString(74, sStock23);
                        prm.setString(75, sStock24);
                        prm.setString(76, sStock25);
                        prm.setString(77, sStock26);
                        prm.setString(78, sStock27);
                        prm.setString(79, sStock28);
                        prm.setString(80, sStock29);
                        prm.setString(81, sStock30);
                        prm.setString(82, sStock31);
                        prm.setString(83, sStock32);
                        prm.setString(84, sStock33);
                        prm.setString(85, sStock34);
                        prm.setString(86, sStock35);
                        prm.setString(87, sStock36);
                        prm.setString(88, sStock37);
                        prm.setString(89, sStock38);
                        prm.setString(90, sStock39);
                        prm.setString(91, sStock40);
                        prm.setString(92, sStock41);
                        prm.setString(93, sStock42);
                        prm.setString(94, sStock43);
                        prm.setString(95, sStock44);
                        prm.setString(96, sStock45);
                        prm.setString(97, "");
                        prm.setString(98, cvth.Unicode2ASCII(t_groupuser.getText()));
                        prm.executeUpdate();
                        prm.close();
                    }
                    updatePosUser();
                    clearDisplay();
                }
            } else {
                if (validatesave()) {
                    if (chkgroup(t_groupuser.getText())) {

                        //update
                        String sql2 = "Update usergroup Set Cont0=?,Cont1=?,Cont2=?,Cont3=?,"
                                + "Cont4=?,Cont5=?,Cont6=?,Cont7=?,Cont8=?,Cont9=?,Cont10=?,"
                                + "Cont11=?,Cont12=?,Cont13=?,"
                                + "Sale1=?,Sale2=?,Sale3=?,Sale4=?,Sale5=?,Sale6=?,Sale7=?,"
                                + "Sale8=?,Sale9=?,Sale10=?,Sale11=?,Sale12=?,Sale13=?,"
                                + "Sale14=?,Sale15=?,Sale16=?,Sale17=?,Sale18=?,Sale19=?,"
                                + "Sale20=?,Sale21=?,Sale22=?,Sale23=?,Sale24=?,Sale25=?,Sale26=?,"
                                + "Sale27=?,Sale28=?,Sale29=?,Sale30=?,Sale31=?,Sale32=?,Sale33=?,"
                                + "Sale34=?,Sale35=?,Sale36=?,"
                                + "Stock0=?,Stock1=?,Stock2=?,Stock3=?,Stock4=?,Stock5=?,Stock6=?,"
                                + "Stock7=?,Stock8=?,Stock9=?,Stock10=?,Stock11=?,Stock12=?,Stock13=?,"
                                + "Stock14=?,Stock15=?,Stock16=?,Stock17=?,Stock18=?,Stock19=?,Stock20=?,"
                                + "Stock21=?,Stock22=?,Stock23=?,Stock24=?,Stock25=?,Stock26=?,Stock27=?,"
                                + "Stock28=?,Stock29=?,Stock30=?,Stock31=?,Stock32=?,Stock33=?,Stock34=?,"
                                + "Stock35=?,Stock36=?,Stock37=?,Stock38=?,Stock39=?,Stock40=?,Stock41=?,"
                                + "Stock42=?,Stock43=?,Stock44=?,Stock45=?,PassWord=? "
                                + "where UserName=?";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);

                        prm.setString(1, sCont0);
                        prm.setString(2, sCont1);
                        prm.setString(3, sCont2);
                        prm.setString(4, sCont3);
                        prm.setString(5, sCont4);
                        prm.setString(6, sCont5);
                        prm.setString(7, sCont6);
                        prm.setString(8, sCont7);
                        prm.setString(9, sCont8);
                        prm.setString(10, sCont9);
                        prm.setString(11, sCont10);
                        prm.setString(12, sCont11);
                        prm.setString(13, sCont12);
                        prm.setString(14, sCont13);
                        prm.setString(15, sSale1);
                        prm.setString(16, sSale2);
                        prm.setString(17, sSale3);
                        prm.setString(18, sSale4);
                        prm.setString(19, sSale5);
                        prm.setString(20, sSale6);
                        prm.setString(21, sSale7);
                        prm.setString(22, sSale8);
                        prm.setString(23, sSale9);
                        prm.setString(24, sSale10);
                        prm.setString(25, sSale11);
                        prm.setString(26, sSale12);
                        prm.setString(27, sSale13);
                        prm.setString(28, sSale14);
                        prm.setString(29, sSale15);
                        prm.setString(30, sSale16);
                        prm.setString(31, sSale17);
                        prm.setString(32, sSale18);
                        prm.setString(33, sSale19);
                        prm.setString(34, sSale20);
                        prm.setString(35, sSale21);
                        prm.setString(36, sSale22);
                        prm.setString(37, sSale23);
                        prm.setString(38, sSale24);
                        prm.setString(39, sSale25);
                        prm.setString(40, sSale26);
                        prm.setString(41, sSale27);
                        prm.setString(42, sSale28);
                        prm.setString(43, sSale29);
                        prm.setString(44, sSale30);
                        prm.setString(45, sSale31);
                        prm.setString(46, sSale32);
                        prm.setString(47, sSale33);
                        prm.setString(48, sSale34);
                        prm.setString(49, sSale35);
                        prm.setString(50, sSale36);
                        prm.setString(51, sStock0);
                        prm.setString(52, sStock1);
                        prm.setString(53, sStock2);
                        prm.setString(54, sStock3);
                        prm.setString(55, sStock4);
                        prm.setString(56, sStock5);
                        prm.setString(57, sStock6);
                        prm.setString(58, sStock7);
                        prm.setString(59, sStock8);
                        prm.setString(60, sStock9);
                        prm.setString(61, sStock10);
                        prm.setString(62, sStock11);
                        prm.setString(63, sStock12);
                        prm.setString(64, sStock13);
                        prm.setString(65, sStock14);
                        prm.setString(66, sStock15);
                        prm.setString(67, sStock16);
                        prm.setString(68, sStock17);
                        prm.setString(69, sStock18);
                        prm.setString(70, sStock19);
                        prm.setString(71, sStock20);
                        prm.setString(72, sStock21);
                        prm.setString(73, sStock22);
                        prm.setString(74, sStock23);
                        prm.setString(75, sStock24);
                        prm.setString(76, sStock25);
                        prm.setString(77, sStock26);
                        prm.setString(78, sStock27);
                        prm.setString(79, sStock28);
                        prm.setString(80, sStock29);
                        prm.setString(81, sStock30);
                        prm.setString(82, sStock31);
                        prm.setString(83, sStock32);
                        prm.setString(84, sStock33);
                        prm.setString(85, sStock34);
                        prm.setString(86, sStock35);
                        prm.setString(87, sStock36);
                        prm.setString(88, sStock37);
                        prm.setString(89, sStock38);
                        prm.setString(90, sStock39);
                        prm.setString(91, sStock40);
                        prm.setString(92, sStock41);
                        prm.setString(93, sStock42);
                        prm.setString(94, sStock43);
                        prm.setString(95, sStock44);
                        prm.setString(96, sStock45);
                        prm.setString(97, "");
                        prm.setString(98, t_groupuser.getText());
                        prm.executeUpdate();
                        prm.close();
                    } else {
                        //insert

                        String sql2 = "Insert Into usergroup (Cont0 ,Cont1 ,Cont2 ,Cont3 ,"
                                + "Cont4 ,Cont5 ,Cont6 ,Cont7 ,Cont8 ,Cont9,Cont10 ,"
                                + "Cont11 ,Cont12 ,Cont13 ,"
                                + "Sale1 ,Sale2 ,Sale3 ,Sale4 ,Sale5 ,Sale6 ,Sale7 ,"
                                + "Sale8 ,Sale9 ,Sale10 ,Sale11 ,Sale12 ,Sale13 ,"
                                + "Sale14 ,Sale15 ,Sale16 ,Sale17 ,Sale18 ,Sale19 ,"
                                + "Sale20 ,Sale21 ,Sale22 ,Sale23 ,Sale24 ,Sale25 ,Sale26 ,"
                                + "Sale27 ,Sale28 ,Sale29 ,Sale30 ,Sale31 ,Sale32 ,Sale33 ,"
                                + "Sale34 ,Sale35 ,Sale36 ,"
                                + "Stock0 ,Stock1 ,Stock2 ,Stock3 ,Stock4 ,Stock5 ,Stock6 ,"
                                + "Stock7 ,Stock8 ,Stock9 ,Stock10 ,Stock11 ,Stock12 ,Stock13 ,"
                                + "Stock14 ,Stock15 ,Stock16 ,Stock17 ,Stock18 ,Stock19 ,Stock20 ,"
                                + "Stock21 ,Stock22 ,Stock23 ,Stock24 ,Stock25 ,Stock26 ,Stock27 ,"
                                + "Stock28 ,Stock29 ,Stock30 ,Stock31 ,Stock32 ,Stock33 ,Stock34 ,"
                                + "Stock35 ,Stock36 ,Stock37 ,Stock38 ,Stock39 ,Stock40 ,Stock41 ,"
                                + "Stock42 ,Stock43 ,Stock44 ,Stock45 ,PassWord ,UserName ) "
                                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);

                        prm.setString(1, sCont0);
                        prm.setString(2, sCont1);
                        prm.setString(3, sCont2);
                        prm.setString(4, sCont3);
                        prm.setString(5, sCont4);
                        prm.setString(6, sCont5);
                        prm.setString(7, sCont6);
                        prm.setString(8, sCont7);
                        prm.setString(9, sCont8);
                        prm.setString(10, sCont9);
                        prm.setString(11, sCont10);
                        prm.setString(12, sCont11);
                        prm.setString(13, sCont12);
                        prm.setString(14, sCont13);
                        prm.setString(15, sSale1);
                        prm.setString(16, sSale2);
                        prm.setString(17, sSale3);
                        prm.setString(18, sSale4);
                        prm.setString(19, sSale5);
                        prm.setString(20, sSale6);
                        prm.setString(21, sSale7);
                        prm.setString(22, sSale8);
                        prm.setString(23, sSale9);
                        prm.setString(24, sSale10);
                        prm.setString(25, sSale11);
                        prm.setString(26, sSale12);
                        prm.setString(27, sSale13);
                        prm.setString(28, sSale14);
                        prm.setString(29, sSale15);
                        prm.setString(30, sSale16);
                        prm.setString(31, sSale17);
                        prm.setString(32, sSale18);
                        prm.setString(33, sSale19);
                        prm.setString(34, sSale20);
                        prm.setString(35, sSale21);
                        prm.setString(36, sSale22);
                        prm.setString(37, sSale23);
                        prm.setString(38, sSale24);
                        prm.setString(39, sSale25);
                        prm.setString(40, sSale26);
                        prm.setString(41, sSale27);
                        prm.setString(42, sSale28);
                        prm.setString(43, sSale29);
                        prm.setString(44, sSale30);
                        prm.setString(45, sSale31);
                        prm.setString(46, sSale32);
                        prm.setString(47, sSale33);
                        prm.setString(48, sSale34);
                        prm.setString(49, sSale35);
                        prm.setString(50, sSale36);
                        prm.setString(51, sStock0);
                        prm.setString(52, sStock1);
                        prm.setString(53, sStock2);
                        prm.setString(54, sStock3);
                        prm.setString(55, sStock4);
                        prm.setString(56, sStock5);
                        prm.setString(57, sStock6);
                        prm.setString(58, sStock7);
                        prm.setString(59, sStock8);
                        prm.setString(60, sStock9);
                        prm.setString(61, sStock10);
                        prm.setString(62, sStock11);
                        prm.setString(63, sStock12);
                        prm.setString(64, sStock13);
                        prm.setString(65, sStock14);
                        prm.setString(66, sStock15);
                        prm.setString(67, sStock16);
                        prm.setString(68, sStock17);
                        prm.setString(69, sStock18);
                        prm.setString(70, sStock19);
                        prm.setString(71, sStock20);
                        prm.setString(72, sStock21);
                        prm.setString(73, sStock22);
                        prm.setString(74, sStock23);
                        prm.setString(75, sStock24);
                        prm.setString(76, sStock25);
                        prm.setString(77, sStock26);
                        prm.setString(78, sStock27);
                        prm.setString(79, sStock28);
                        prm.setString(80, sStock29);
                        prm.setString(81, sStock30);
                        prm.setString(82, sStock31);
                        prm.setString(83, sStock32);
                        prm.setString(84, sStock33);
                        prm.setString(85, sStock34);
                        prm.setString(86, sStock35);
                        prm.setString(87, sStock36);
                        prm.setString(88, sStock37);
                        prm.setString(89, sStock38);
                        prm.setString(90, sStock39);
                        prm.setString(91, sStock40);
                        prm.setString(92, sStock41);
                        prm.setString(93, sStock42);
                        prm.setString(94, sStock43);
                        prm.setString(95, sStock44);
                        prm.setString(96, sStock45);
                        prm.setString(97, "");
                        prm.setString(98, t_groupuser.getText());
                        prm.executeUpdate();
                        prm.close();
                    }
                    updatePosUser();
                    clearDisplay();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    private void clearDisplay()
    {
        loadtblGroup();
        removetbl(tbl3);
        t_groupuser.setText("");
        t_groupuser.requestFocus();
    }
    
    private void updatePosUser()
    {
        try {
                    if(!db.Char_Set.equalsIgnoreCase("utf-8"))
                    {
                    //update posuser
                    String sql2 = "Update posuser Set Cont0=?,Cont1=?,Cont2=?,Cont3=?,"
                            + "Cont4=?,Cont5=?,Cont6=?,Cont7=?,Cont8=?,Cont9=?,Cont10=?,"
                            + "Cont11=?,Cont12=?,Cont13=?,"
                            + "Sale1=?,Sale2=?,Sale3=?,Sale4=?,Sale5=?,Sale6=?,Sale7=?,"
                            + "Sale8=?,Sale9=?,Sale10=?,Sale11=?,Sale12=?,Sale13=?,"
                            + "Sale14=?,Sale15=?,Sale16=?,Sale17=?,Sale18=?,Sale19=?,"
                            + "Sale20=?,Sale21=?,Sale22=?,Sale23=?,Sale24=?,Sale25=?,Sale26=?,"
                            + "Sale27=?,Sale28=?,Sale29=?,Sale30=?,Sale31=?,Sale32=?,Sale33=?,"
                            + "Sale34=?,Sale35=?,Sale36=?,"
                            + "Stock0=?,Stock1=?,Stock2=?,Stock3=?,Stock4=?,Stock5=?,Stock6=?,"
                            + "Stock7=?,Stock8=?,Stock9=?,Stock10=?,Stock11=?,Stock12=?,Stock13=?,"
                            + "Stock14=?,Stock15=?,Stock16=?,Stock17=?,Stock18=?,Stock19=?,Stock20=?,"
                            + "Stock21=?,Stock22=?,Stock23=?,Stock24=?,Stock25=?,Stock26=?,Stock27=?,"
                            + "Stock28=?,Stock29=?,Stock30=?,Stock31=?,Stock32=?,Stock33=?,Stock34=?,"
                            + "Stock35=?,Stock36=?,Stock37=?,Stock38=?,Stock39=?,Stock40=?,Stock41=?,"
                            + "Stock42=?,Stock43=?,Stock44=?,Stock45=? "
                            + "where usergroup=?";
                   PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);
                  
                   prm.setString(1, sCont0);
                        prm.setString(2, sCont1);
                        prm.setString(3, sCont2);
                        prm.setString(4, sCont3);
                        prm.setString(5, sCont4);
                        prm.setString(6, sCont5);
                        prm.setString(7, sCont6);
                        prm.setString(8, sCont7);
                        prm.setString(9, sCont8);
                        prm.setString(10, sCont9);
                        prm.setString(11, sCont10);
                        prm.setString(12, sCont11);
                        prm.setString(13, sCont12);
                        prm.setString(14, sCont13);
                        prm.setString(15, sSale1);
                        prm.setString(16, sSale2);
                        prm.setString(17, sSale3);
                        prm.setString(18, sSale4);
                        prm.setString(19, sSale5);
                        prm.setString(20, sSale6);
                        prm.setString(21, sSale7);
                        prm.setString(22, sSale8);
                        prm.setString(23, sSale9);
                        prm.setString(24, sSale10);
                        prm.setString(25, sSale11);
                        prm.setString(26, sSale12);
                        prm.setString(27, sSale13);
                        prm.setString(28, sSale14);
                        prm.setString(29, sSale15);
                        prm.setString(30, sSale16);
                        prm.setString(31, sSale17);
                        prm.setString(32, sSale18);
                        prm.setString(33, sSale19);
                        prm.setString(34, sSale20);
                        prm.setString(35, sSale21);
                        prm.setString(36, sSale22);
                        prm.setString(37, sSale23);
                        prm.setString(38, sSale24);
                        prm.setString(39, sSale25);
                        prm.setString(40, sSale26);
                        prm.setString(41, sSale27);
                        prm.setString(42, sSale28);
                        prm.setString(43, sSale29);
                        prm.setString(44, sSale30);
                        prm.setString(45, sSale31);
                        prm.setString(46, sSale32);
                        prm.setString(47, sSale33);
                        prm.setString(48, sSale34);
                        prm.setString(49, sSale35);
                        prm.setString(50, sSale36);
                        prm.setString(51, sStock0);
                        prm.setString(52, sStock1);
                        prm.setString(53, sStock2);
                        prm.setString(54, sStock3);
                        prm.setString(55, sStock4);
                        prm.setString(56, sStock5);
                        prm.setString(57, sStock6);
                        prm.setString(58, sStock7);
                        prm.setString(59, sStock8);
                        prm.setString(60, sStock9);
                        prm.setString(61, sStock10);
                        prm.setString(62, sStock11);
                        prm.setString(63, sStock12);
                        prm.setString(64, sStock13);
                        prm.setString(65, sStock14);
                        prm.setString(66, sStock15);
                        prm.setString(67, sStock16);
                        prm.setString(68, sStock17);
                        prm.setString(69, sStock18);
                        prm.setString(70, sStock19);
                        prm.setString(71, sStock20);
                        prm.setString(72, sStock21);
                        prm.setString(73, sStock22);
                        prm.setString(74, sStock23);
                        prm.setString(75, sStock24);
                        prm.setString(76, sStock25);
                        prm.setString(77, sStock26);
                        prm.setString(78, sStock27);
                        prm.setString(79, sStock28);
                        prm.setString(80, sStock29);
                        prm.setString(81, sStock30);
                        prm.setString(82, sStock31);
                        prm.setString(83, sStock32);
                        prm.setString(84, sStock33);
                        prm.setString(85, sStock34);
                        prm.setString(86, sStock35);
                        prm.setString(87, sStock36);
                        prm.setString(88, sStock37);
                        prm.setString(89, sStock38);
                        prm.setString(90, sStock39);
                        prm.setString(91, sStock40);
                        prm.setString(92, sStock41);
                        prm.setString(93, sStock42);
                        prm.setString(94, sStock43);
                        prm.setString(95, sStock44);
                        prm.setString(96, sStock45);
                   prm.setString(97, cvth.Unicode2ASCII(t_groupuser.getText()));
                   prm.executeUpdate();
                    }
                    else
                    {
                        String sql2 = "Update posuser Set Cont0=?,Cont1=?,Cont2=?,Cont3=?,"
                            + "Cont4=?,Cont5=?,Cont6=?,Cont7=?,Cont8=?,Cont9=?,Cont10=?,"
                            + "Cont11=?,Cont12=?,Cont13=?,"
                            + "Sale1=?,Sale2=?,Sale3=?,Sale4=?,Sale5=?,Sale6=?,Sale7=?,"
                            + "Sale8=?,Sale9=?,Sale10=?,Sale11=?,Sale12=?,Sale13=?,"
                            + "Sale14=?,Sale15=?,Sale16=?,Sale17=?,Sale18=?,Sale19=?,"
                            + "Sale20=?,Sale21=?,Sale22=?,Sale23=?,Sale24=?,Sale25=?,Sale26=?,"
                            + "Sale27=?,Sale28=?,Sale29=?,Sale30=?,Sale31=?,Sale32=?,Sale33=?,"
                            + "Sale34=?,Sale35=?,Sale36=?,"
                            + "Stock0=?,Stock1=?,Stock2=?,Stock3=?,Stock4=?,Stock5=?,Stock6=?,"
                            + "Stock7=?,Stock8=?,Stock9=?,Stock10=?,Stock11=?,Stock12=?,Stock13=?,"
                            + "Stock14=?,Stock15=?,Stock16=?,Stock17=?,Stock18=?,Stock19=?,Stock20=?,"
                            + "Stock21=?,Stock22=?,Stock23=?,Stock24=?,Stock25=?,Stock26=?,Stock27=?,"
                            + "Stock28=?,Stock29=?,Stock30=?,Stock31=?,Stock32=?,Stock33=?,Stock34=?,"
                            + "Stock35=?,Stock36=?,Stock37=?,Stock38=?,Stock39=?,Stock40=?,Stock41=?,"
                            + "Stock42=?,Stock43=?,Stock44=?,Stock45=? "
                            + "where usergroup=?";
                   PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);
                  
                   prm.setString(1, sCont0);
                        prm.setString(2, sCont1);
                        prm.setString(3, sCont2);
                        prm.setString(4, sCont3);
                        prm.setString(5, sCont4);
                        prm.setString(6, sCont5);
                        prm.setString(7, sCont6);
                        prm.setString(8, sCont7);
                        prm.setString(9, sCont8);
                        prm.setString(10, sCont9);
                        prm.setString(11, sCont10);
                        prm.setString(12, sCont11);
                        prm.setString(13, sCont12);
                        prm.setString(14, sCont13);
                        prm.setString(15, sSale1);
                        prm.setString(16, sSale2);
                        prm.setString(17, sSale3);
                        prm.setString(18, sSale4);
                        prm.setString(19, sSale5);
                        prm.setString(20, sSale6);
                        prm.setString(21, sSale7);
                        prm.setString(22, sSale8);
                        prm.setString(23, sSale9);
                        prm.setString(24, sSale10);
                        prm.setString(25, sSale11);
                        prm.setString(26, sSale12);
                        prm.setString(27, sSale13);
                        prm.setString(28, sSale14);
                        prm.setString(29, sSale15);
                        prm.setString(30, sSale16);
                        prm.setString(31, sSale17);
                        prm.setString(32, sSale18);
                        prm.setString(33, sSale19);
                        prm.setString(34, sSale20);
                        prm.setString(35, sSale21);
                        prm.setString(36, sSale22);
                        prm.setString(37, sSale23);
                        prm.setString(38, sSale24);
                        prm.setString(39, sSale25);
                        prm.setString(40, sSale26);
                        prm.setString(41, sSale27);
                        prm.setString(42, sSale28);
                        prm.setString(43, sSale29);
                        prm.setString(44, sSale30);
                        prm.setString(45, sSale31);
                        prm.setString(46, sSale32);
                        prm.setString(47, sSale33);
                        prm.setString(48, sSale34);
                        prm.setString(49, sSale35);
                        prm.setString(50, sSale36);
                        prm.setString(51, sStock0);
                        prm.setString(52, sStock1);
                        prm.setString(53, sStock2);
                        prm.setString(54, sStock3);
                        prm.setString(55, sStock4);
                        prm.setString(56, sStock5);
                        prm.setString(57, sStock6);
                        prm.setString(58, sStock7);
                        prm.setString(59, sStock8);
                        prm.setString(60, sStock9);
                        prm.setString(61, sStock10);
                        prm.setString(62, sStock11);
                        prm.setString(63, sStock12);
                        prm.setString(64, sStock13);
                        prm.setString(65, sStock14);
                        prm.setString(66, sStock15);
                        prm.setString(67, sStock16);
                        prm.setString(68, sStock17);
                        prm.setString(69, sStock18);
                        prm.setString(70, sStock19);
                        prm.setString(71, sStock20);
                        prm.setString(72, sStock21);
                        prm.setString(73, sStock22);
                        prm.setString(74, sStock23);
                        prm.setString(75, sStock24);
                        prm.setString(76, sStock25);
                        prm.setString(77, sStock26);
                        prm.setString(78, sStock27);
                        prm.setString(79, sStock28);
                        prm.setString(80, sStock29);
                        prm.setString(81, sStock30);
                        prm.setString(82, sStock31);
                        prm.setString(83, sStock32);
                        prm.setString(84, sStock33);
                        prm.setString(85, sStock34);
                        prm.setString(86, sStock35);
                        prm.setString(87, sStock36);
                        prm.setString(88, sStock37);
                        prm.setString(89, sStock38);
                        prm.setString(90, sStock39);
                        prm.setString(91, sStock40);
                        prm.setString(92, sStock41);
                        prm.setString(93, sStock42);
                        prm.setString(94, sStock43);
                        prm.setString(95, sStock44);
                        prm.setString(96, sStock45);
                   prm.setString(97, t_groupuser.getText());
                   prm.executeUpdate();
                    }
         } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex);
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
     private void initable2() {
        tbPLU = (DefaultTableModel) tbl3.getModel();
        tbl3.setShowGrid(true);
        //tblPLU.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
        tbl3.setAutoCreateRowSorter(true);
    }
     
     public void delete()
{
    ResultSet rs = null;
    try {
        if(chkdelete(t_groupuser.getText())==0)
            {
        int confirm = JOptionPane.showConfirmDialog(this, "คุณต้องการลบข้อมูลรายการนี้หรือไม่...?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                     if(!db.Char_Set.equalsIgnoreCase("utf-8"))
                    {
                    stmt = (Statement) db.con.createStatement();
                    String sql = "Delete from usergroup where username=?";
                    java.sql.PreparedStatement prm = (java.sql.PreparedStatement) db.con.prepareStatement(sql);
                    prm.setString(1, cvth.Unicode2ASCII(t_groupuser.getText()));
                    prm.executeUpdate();
                    }
                    else
                    {
        stmt = (Statement) db.con.createStatement();
               String sql = "Delete from usergroup where username=?";
               java.sql.PreparedStatement prm = (java.sql.PreparedStatement) db.con.prepareStatement(sql);
               prm.setString(1, t_groupuser.getText());
               prm.executeUpdate();
               stmt.close();
                    }
               clearDisplay();
                }
            }else
        {
             JOptionPane.showMessageDialog(this, "ไม่สามารถลบข้อมูลได้ เนื่องจากมีข้อมูลอยู่ใน PosUser จำนวน "+chkdelete(t_groupuser.getText())+" รายการ");
        }
       
    } catch (Exception e) {
        
    }
}
public int chkdelete(String code) {
        
        ResultSet rs = null;
        int count = 0;
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) db.con.createStatement();
                String sql = "select * from posuser where usergroup ='" + cvth.Unicode2ASCII(code) + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    count++;
                }
            } else {
                stmt = (Statement) db.con.createStatement();
                String sql = "select * from posuser where usergroup ='" + code + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    count++;
                }
            }
        } catch (Exception e) {
        }
        return count;
    }

    private boolean validatesave()
     {
         boolean chk = true;
         
         if(t_groupuser.getText().equals("")){
             
               JOptionPane.showMessageDialog(this, "กำหนด กลุ่มผู้ใช้ ไม่ถูกต้อง... กรุณากำหนดให้ถูกต้อง");
             t_groupuser.requestFocus();
             
             chk = false;
         }
         else if(t_groupuser.getText().length()>15){
             
               JOptionPane.showMessageDialog(this, "กำหนด กลุ่มผู้ใช้ ไม่ถูกต้อง... (ต้องมีขนาดไม่เกิน 7 ตัวอักษร)");
             t_groupuser.requestFocus();
             chk = false;
         }
         else if(tbl3.getRowCount()<1)
         {
             JOptionPane.showMessageDialog(this, "กรุณากดปุ่ม OK เพื่อดูรายการกำหนดสิทธิ์");
             db_btnOK.requestFocus();
             chk = false;
         }
         
         
         return chk;
     }
}
