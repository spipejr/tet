/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package masterfile;

import borfunction.GetApplicationName;
import borfunction.GetUser;
import com.mysql.jdbc.PreparedStatement;
import dbutility.dbUtility;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
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
import javax.swing.table.*;
import javax.swing.text.JTextComponent;
import jxl.write.WriteException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import report.Report;
import utilititiesfunction.*;

/**
 *
 * @author s386
 */
public class setBorMenuGroup extends javax.swing.JDialog {

    /**
     * Creates new form setBorMenuGroup
     */
    DefaultTableModel tbPLU;
    dbUtility db = new dbUtility();
    Statement stmt;
    int indexplutbl = -1;
    int indexcoupontbl = -1;
    String frmName = "setbormenugroup";
    ThaiUtilities cvth = new ThaiUtilities();
    getLanguage lang = new getLanguage();
    DecimalFormat DoubleFmt = new DecimalFormat("##,###,##0.00");
    SimpleDateFormat dateFmtSave = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    SimpleDateFormat dateFmtShow = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    private DefaultTableModel tbmodel;
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
    String Mast25 = "0"; //Master EStamp
    String Mast26 = "0";//Master EStamp
    String Mast27 = "0";//Master EStamp
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
    String Rpt51 = "0";
    String Rpt52 = "0"; //Report EStamp
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

    String Mast28 = "0";
    String Mast29 = "0";
    String Mast30 = "0";

    public setBorMenuGroup(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        checkuserconfig();
        //this.setUndecorated(true); 

        JComboBox cbo = new JComboBox();
        cbo.addItem("0");
        cbo.addItem("1");
        cbo.addItem("2");
        cbo.addItem("3");
        TableColumn tbc = tbl3.getColumnModel().getColumn(3);
        tbc.setCellEditor(new DefaultCellEditor(cbo));
        db.dbconnect();
        loadtblGroup();
        initable();
        initable2();
        //this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        db_lblh2 = new javax.swing.JLabel();
        db_btnsave = new javax.swing.JButton();
        db_btnexit = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        t_groupuser = new javax.swing.JTextField();
        db_btnOK = new javax.swing.JButton();
        db_btnCancel = new javax.swing.JButton();
        db_lblh1 = new javax.swing.JLabel();
        db_btndelete = new javax.swing.JButton();
        db_btnexcel = new javax.swing.JButton();
        db_btnprint = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        db_lblh3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl3 = new javax.swing.JTable();
        db_btndelete1 = new javax.swing.JButton();
        cboset = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        db_btnsave.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnsave.setText("บันทึก");
        db_btnsave.setName("db_btnOK"); // NOI18N
        db_btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnsaveActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(db_lblh1)
                        .addGap(18, 18, 18)
                        .addComponent(t_groupuser, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(db_btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        db_lblh3.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_lblh3.setText("สิทธิ์การใช้งาน");
        db_lblh3.setName("db_lblh1"); // NOI18N

        tbl3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "กลุ่มเมนู", "Mcode", "รายการ/รายละเอียดเมนู", "สิทธิ์การใช้งาน"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl3.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(tbl3);
        tbl3.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl3.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl3.getColumnModel().getColumn(1).setMinWidth(0);
        tbl3.getColumnModel().getColumn(1).setPreferredWidth(0);
        tbl3.getColumnModel().getColumn(1).setMaxWidth(0);
        tbl3.getColumnModel().getColumn(2).setPreferredWidth(300);
        tbl3.getColumnModel().getColumn(3).setPreferredWidth(80);

        db_btndelete1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btndelete1.setText("Set To All");
        db_btndelete1.setName("db_btnCancel"); // NOI18N
        db_btndelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btndelete1ActionPerformed(evt);
            }
        });

        cboset.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        cboset.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(db_lblh3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboset, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btndelete1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(db_btndelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(db_lblh3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(db_btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(db_btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 99, Short.MAX_VALUE)
                        .addComponent(db_btnexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db_btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(db_btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(db_btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(db_btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(db_btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(db_btnexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1032)/2, (screenSize.height-796)/2, 1032, 796);
    }// </editor-fold>//GEN-END:initComponents
    private void checkuserconfig() {
        //MenuName = Mast1
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getCont3().equals("1")) {
            db_btnsave.setEnabled(false);
            db_btndelete.setEnabled(false);
        }
        if (userrec.getCont3().equals("2")) {
            db_btnsave.setEnabled(true);
            db_btndelete.setEnabled(false);
        }
        if (userrec.getCont3().equals("3")) {
            db_btnsave.setEnabled(true);
            db_btndelete.setEnabled(true);
        }
    }
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

    private void tbl1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int rowSelect = tbl1.getSelectedRow();
            t_groupuser.setText(tbl1.getValueAt(rowSelect, 0).toString());
            t_groupuser.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1KeyPressed

    private void tbl1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1KeyReleased

    private void db_btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnsaveActionPerformed
        save();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnsaveActionPerformed

    private void db_btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnexitActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnexitActionPerformed

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
        if (!t_groupuser.getText().equals("")) {
            loadDataTbl2(t_groupuser.getText());
            tbl3.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "ข้อมูลไม่ถูกต้อง กรุณากรอกข้อมูลก่อน");
            t_groupuser.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnOKActionPerformed

    private void db_btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnCancelActionPerformed

        clearDisplay();
        t_groupuser.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnCancelActionPerformed

    private void db_btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btndeleteActionPerformed
        if (!t_groupuser.getText().equals("") && tbl3.getRowCount() > 0) {
            delete();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btndeleteActionPerformed

    private void db_btnexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnexcelActionPerformed
        if (!t_groupuser.getText().equals("") && tbl3.getRowCount() > 0) {
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
                        test.writetableNoSum(tbl3, tbl3.getColumnModel(), "UserGroup : " + t_groupuser.getText());
                    } catch (WriteException ex) {
                    }
                }

            } catch (IOException e) {
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnexcelActionPerformed

    private void db_btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnprintActionPerformed
        if (validatesave()) {
            Map parm = new HashMap();
            JRBeanCollectionDataSource ds = null;
            ds = new JRBeanCollectionDataSource(report.databean4Field.getBorUserGroup(tbl3));
            parm.put("companyName", lang.getTextCompanyReport());
            parm.put("Reportheader", lang.getTextReport(frmName, "texthead"));

            parm.put("code", lang.getTextReport(frmName, "code"));
            parm.put("name", lang.getTextReport(frmName, "name"));
            parm.put("other1", lang.getTextReport(frmName, "other1"));
            parm.put("other2", lang.getTextReport(frmName, "other2"));

            parm.put("forname", lang.getTextReport(frmName, "forname") + " : " + t_groupuser.getText());
            parm.put("application", new GetApplicationName().getApplicationName());
            parm.put("user", new GetUser().getUser());
            parm.put("currentDate", Format.dateFmtReport.format(new java.util.Date()));

            String rptName = "rptborusergroup";
            Report rpt = new Report();
            rpt.viewReportbean(rptName, parm, frmName, ds);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnprintActionPerformed

    private void db_btndelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btndelete1ActionPerformed
        setToAll(cboset.getSelectedItem().toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btndelete1ActionPerformed

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
            java.util.logging.Logger.getLogger(setBorMenuGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setBorMenuGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setBorMenuGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setBorMenuGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                setBorMenuGroup dialog = new setBorMenuGroup(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cboset;
    private javax.swing.JButton db_btnCancel;
    private javax.swing.JButton db_btnOK;
    private javax.swing.JButton db_btndelete;
    private javax.swing.JButton db_btndelete1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField t_groupuser;
    private javax.swing.JTable tbl1;
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
                Rpt51 = rs.getString("Rpt51");
//                Rpt52 = rs.getString("Rpt52");
                Mast28 = rs.getString("Mast28");
                Mast29 = rs.getString("Mast29");
                Mast30 = rs.getString("Mast30");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private void setDataFormTbl() {
        for (int i = 0; i < tbl3.getRowCount(); i++) {
            String mcode = tbl3.getValueAt(i, 1).toString();
            String onact = tbl3.getValueAt(i, 3).toString();
            if (mcode.equals("Mast1")) {
                Mast1 = onact;
            } else if (mcode.equals("Mast2")) {
                Mast2 = onact;
            } else if (mcode.equals("Mast3")) {
                Mast3 = onact;
            } else if (mcode.equals("Mast4")) {
                Mast4 = onact;
            } else if (mcode.equals("Mast5")) {
                Mast5 = onact;
            } else if (mcode.equals("Mast6")) {
                Mast6 = onact;
            } else if (mcode.equals("Mast7")) {
                Mast7 = onact;
            } else if (mcode.equals("Mast8")) {
                Mast8 = onact;
            } else if (mcode.equals("Mast9")) {
                Mast9 = onact;
            } else if (mcode.equals("Mast10")) {
                Mast10 = onact;
            } else if (mcode.equals("Mast11")) {
                Mast11 = onact;
            } else if (mcode.equals("Mast12")) {
                Mast12 = onact;
            } else if (mcode.equals("Mast13")) {
                Mast13 = onact;
            } else if (mcode.equals("Mast14")) {
                Mast14 = onact;
            } else if (mcode.equals("Mast15")) {
                Mast15 = onact;
            } else if (mcode.equals("Mast16")) {
                Mast16 = onact;
            } else if (mcode.equals("Mast17")) {
                Mast17 = onact;
            } else if (mcode.equals("Mast18")) {
                Mast18 = onact;
            } else if (mcode.equals("Mast19")) {
                Mast19 = onact;
            } else if (mcode.equals("Mast20")) {
                Mast20 = onact;
            } else if (mcode.equals("Mast21")) {
                Mast21 = onact;
            } else if (mcode.equals("Mast22")) {
                Mast22 = onact;
            } else if (mcode.equals("Mast23")) {
                Mast23 = onact;
            } else if (mcode.equals("Mast24")) {
                Mast24 = onact;
            } else if (mcode.equals("Mast25")) {
                Mast25 = onact;

            } else if (mcode.equals("M212")) {
                M212 = onact;
            } else if (mcode.equals("M213")) {
                M213 = onact;
            } else if (mcode.equals("M214")) {
                M214 = onact;
            } else if (mcode.equals("M215")) {
                M215 = onact;
            } else if (mcode.equals("M216")) {
                M216 = onact;
            } else if (mcode.equals("M217")) {
                M217 = onact;

            } else if (mcode.equals("Plu1")) {
                Plu1 = onact;
            } else if (mcode.equals("Plu2")) {
                Plu2 = onact;
            } else if (mcode.equals("Plu3")) {
                Plu3 = onact;
            } else if (mcode.equals("Plu4")) {
                Plu4 = onact;
            } else if (mcode.equals("Plu5")) {
                Plu5 = onact;
            } else if (mcode.equals("Plu6")) {
                Plu6 = onact;
            } else if (mcode.equals("Plu7")) {
                Plu7 = onact;
            } else if (mcode.equals("Plu8")) {
                Plu8 = onact;
            } else if (mcode.equals("Plu9")) {
                Plu9 = onact;
            } else if (mcode.equals("Plu10")) {
                Plu10 = onact;
            } else if (mcode.equals("Plu11")) {
                Plu11 = onact;
            } else if (mcode.equals("Plu12")) {
                Plu12 = onact;
            } else if (mcode.equals("Plu13")) {
                Plu13 = onact;
            } else if (mcode.equals("Plu14")) {
                Plu14 = onact;
            } else if (mcode.equals("Plu15")) {
                Plu15 = onact;
            } else if (mcode.equals("Plu16")) {
                Plu16 = onact;
            } else if (mcode.equals("Plu17")) {
                Plu17 = onact;
            } else if (mcode.equals("Plu18")) {
                Plu18 = onact;
            } else if (mcode.equals("Plu19")) {
                Plu19 = onact;
            } else if (mcode.equals("Plu20")) {
                Plu20 = onact;
            } else if (mcode.equals("Tran1")) {
                Tran1 = onact;
            } else if (mcode.equals("Tran2")) {
                Tran2 = onact;
            } else if (mcode.equals("Tran3")) {
                Tran3 = onact;
            } else if (mcode.equals("Tran4")) {
                Tran4 = onact;
            } else if (mcode.equals("Tran5")) {
                Tran5 = onact;
            } else if (mcode.equals("Tran6")) {
                Tran6 = onact;
            } else if (mcode.equals("Tran7")) {
                Tran7 = onact;
            } else if (mcode.equals("Tran8")) {
                Tran8 = onact;
            } else if (mcode.equals("Tran9")) {
                Tran9 = onact;
            } else if (mcode.equals("Tran10")) {
                Tran10 = onact;
            } else if (mcode.equals("Tran11")) {
                Tran11 = onact;
            } else if (mcode.equals("Rpt1")) {
                Rpt1 = onact;
            } else if (mcode.equals("Rpt2")) {
                Rpt2 = onact;
            } else if (mcode.equals("Rpt3")) {
                Rpt3 = onact;
            } else if (mcode.equals("Rpt4")) {
                Rpt4 = onact;
            } else if (mcode.equals("Rpt5")) {
                Rpt5 = onact;
            } else if (mcode.equals("Rpt6")) {
                Rpt6 = onact;
            } else if (mcode.equals("Rpt7")) {
                Rpt7 = onact;
            } else if (mcode.equals("Rpt8")) {
                Rpt8 = onact;
            } else if (mcode.equals("Rpt9")) {
                Rpt9 = onact;
            } else if (mcode.equals("Rpt10")) {
                Rpt10 = onact;
            } else if (mcode.equals("Rpt11")) {
                Rpt11 = onact;
            } else if (mcode.equals("Rpt12")) {
                Rpt12 = onact;
            } else if (mcode.equals("Rpt13")) {
                Rpt13 = onact;
            } else if (mcode.equals("Rpt14")) {
                Rpt14 = onact;
            } else if (mcode.equals("Rpt15")) {
                Rpt15 = onact;
            } else if (mcode.equals("Rpt16")) {
                Rpt16 = onact;
            } else if (mcode.equals("Rpt17")) {
                Rpt17 = onact;
            } else if (mcode.equals("Rpt18")) {
                Rpt18 = onact;
            } else if (mcode.equals("Rpt19")) {
                Rpt19 = onact;
            } else if (mcode.equals("Rpt20")) {
                Rpt20 = onact;
            } else if (mcode.equals("Rpt21")) {
                Rpt21 = onact;
            } else if (mcode.equals("Rpt22")) {
                Rpt22 = onact;
            } else if (mcode.equals("Rpt23")) {
                Rpt23 = onact;
            } else if (mcode.equals("Rpt24")) {
                Rpt24 = onact;
            } else if (mcode.equals("Rpt25")) {
                Rpt25 = onact;
            } else if (mcode.equals("Rpt26")) {
                Rpt26 = onact;
            } else if (mcode.equals("Rpt27")) {
                Rpt27 = onact;
            } else if (mcode.equals("Rpt28")) {
                Rpt28 = onact;
            } else if (mcode.equals("Rpt29")) {
                Rpt29 = onact;
            } else if (mcode.equals("Rpt30")) {
                Rpt30 = onact;
            } else if (mcode.equals("Rpt31")) {
                Rpt31 = onact;
            } else if (mcode.equals("Rpt32")) {
                Rpt32 = onact;
            } else if (mcode.equals("Rpt33")) {
                Rpt33 = onact;
            } else if (mcode.equals("Rpt34")) {
                Rpt34 = onact;
            } else if (mcode.equals("Rpt35")) {
                Rpt35 = onact;
            } else if (mcode.equals("Rpt36")) {
                Rpt36 = onact;
            } else if (mcode.equals("Rpt37")) {
                Rpt37 = onact;
            } else if (mcode.equals("Rpt38")) {
                Rpt38 = onact;
            } else if (mcode.equals("Rpt39")) {
                Rpt39 = onact;
            } else if (mcode.equals("Rpt40")) {
                Rpt40 = onact;
            } else if (mcode.equals("Rpt41")) {
                Rpt41 = onact;
            } else if (mcode.equals("Rpt42")) {
                Rpt42 = onact;
            } else if (mcode.equals("Rpt43")) {
                Rpt43 = onact;
            } else if (mcode.equals("Rpt44")) {
                Rpt44 = onact;
            } else if (mcode.equals("Rpt45")) {
                Rpt45 = onact;
            } else if (mcode.equals("Rpt46")) {
                Rpt46 = onact;
            } else if (mcode.equals("Rpt47")) {
                Rpt47 = onact;
            } else if (mcode.equals("Rpt48")) {
                Rpt48 = onact;
            } else if (mcode.equals("Rpt49")) {
                Rpt49 = onact;
            } else if (mcode.equals("Rpt50")) {
                Rpt50 = onact;
            } else if (mcode.equals("Cont1")) {
                Cont1 = onact;
            } else if (mcode.equals("Cont2")) {
                Cont2 = onact;
            } else if (mcode.equals("Cont3")) {
                Cont3 = onact;
            } else if (mcode.equals("Cont4")) {
                Cont4 = onact;
            } else if (mcode.equals("Cont5")) {
                Cont5 = onact;
            } else if (mcode.equals("Cont6")) {
                Cont6 = onact;
            } else if (mcode.equals("Cont7")) {
                Cont7 = onact;
            } else if (mcode.equals("Cont8")) {
                Cont8 = onact;
            } else if (mcode.equals("Cont9")) {
                Cont9 = onact;
            } else if (mcode.equals("Cont10")) {
                Cont10 = onact;
            } else if (mcode.equals("Cont10")) {
                Cont10 = onact;
            } else if (mcode.equals("Mast26")) {
                Mast26 = onact;
            } else if (mcode.equals("Mast27")) {
                Mast27 = onact;
            } else if (mcode.equals("Rpt51")) {
                Rpt51 = onact;
            } else if (mcode.equals("Mast28")) {
                Mast28 = onact;
            } else if (mcode.equals("Mast29")) {
                Mast29 = onact;
            } else if (mcode.equals("Mast30")) {
                Mast30 = onact;
            } 
//            else if (mcode.equals("Rpt52")) {
//                Rpt52 = onact;
//            }
        }

    }

    private void loadDataTbl2(String GroupCode) {
        stmt = null;
        ResultSet rs = null;
        removetbl(tbl3);
        tbmodel = (DefaultTableModel) tbl3.getModel();
        try {

            if (!chkgroup(GroupCode)) {
                if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                    setMenuUpdate();
                    stmt = (Statement) dbUtility.con.createStatement();
                    String sql = "select * from bormenulinux ";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tbmodel.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("mgroup")),
                            cvth.ASCII2Unicode(rs.getString("mcode")),
                            cvth.ASCII2Unicode(rs.getString("mdesc")),
                            rs.getString("onact")
                        });
                    }
                } else {
                    setMenuUpdate();
                    stmt = (Statement) dbUtility.con.createStatement();
                    String sql = "select * from bormenulinux ";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tbmodel.addRow(new Object[]{rs.getString("mgroup"),
                            rs.getString("mcode"),
                            rs.getString("mdesc"),
                            rs.getString("onact")
                        });
                    }
                }

            } else {
                if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                    setMenuUpdate();
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
                    setMenuUpdate();
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
                    } else if (mcode.equals("Rpt51")) {
                        tbl3.setValueAt(Rpt51, i, 3);
                    } else if (mcode.equals("Mast28")) {
                        tbl3.setValueAt(Mast28, i, 3);
                    } else if (mcode.equals("Mast29")) {
                        tbl3.setValueAt(Mast29, i, 3);
                    } else if (mcode.equals("Mast30")) {
                        tbl3.setValueAt(Mast30, i, 3);
                    } 
//                    else if (mcode.equals("Rpt52")) {
//                        tbl3.setValueAt(Rpt52, i, 3);
//                    }

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
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) db.con.createStatement();
                String sql = "select * from borgrouplinux where usergroup ='" + cvth.Unicode2ASCII(code) + "'";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    chk = true;
                }

            } else {
                stmt = (Statement) db.con.createStatement();
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

    private void setMenuUpdate() {

        try {

            stmt = (Statement) db.con.createStatement();
            String sql = "update bormenulinux set onact = '0'";
            stmt.executeUpdate(sql);
            stmt.close();
            indexplutbl = -1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
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
        tbl1.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
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
        tbl3.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
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

    private void save() {
        try {

            setDataFormTbl();
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                if (validatesave()) {
                    if (chkgroup(t_groupuser.getText())) {

                        //update
                        String sql2 = "Update borgrouplinux Set Mast1 = ?,Mast2 = ?,Mast3 = ?,Mast4 = ?,Mast5 = ?,Mast6 = ?,Mast7 = ?,Mast8 = ?"
                                + ",Mast9 = ?,Mast10 = ?,Mast11 = ?,Mast12 = ?,Mast13 = ?,Mast14 = ?,Mast15 = ?,Mast16 = ?,Mast17 = ?,Mast18 = ?"
                                + ",Mast19 = ?,Mast20 = ?,Mast21 = ?,Mast22 = ?,Mast23 = ?,Mast24 = ?,Mast25 = ?"
                                + ",Plu1 = ?,Plu2 = ?,Plu3 = ?,Plu4 = ?,Plu5 = ?,Plu6 = ?,Plu7 = ?,Plu8 = ?,Plu9 = ?,Plu10 = ?"
                                + ",Plu11 = ?,Plu12 = ?,Plu13 = ?,Plu14 = ?,Plu15 = ?,Plu16 = ?,Plu17 = ?,Plu18 = ?,Plu19 = ?,Plu20 = ?"
                                + ",Tran1 = ?,Tran2 = ?,Tran3 = ?,Tran4 = ?,Tran5 = ?,Tran6 = ?,Tran7 = ?,Tran8 = ?,Tran9 = ?,Tran10 = ?,Tran11 = ?"
                                + ",Rpt1 = ?,Rpt2 = ?,Rpt3 = ?,Rpt4 = ?,Rpt5 = ?,Rpt6 = ?,Rpt7 = ?,Rpt8 = ?,Rpt9 = ?,Rpt10 = ?"
                                + ",Rpt11 = ?,Rpt12 = ?,Rpt13 = ?,Rpt14 = ?,Rpt15 = ?,Rpt16 = ?,Rpt17 = ?,Rpt18 = ?,Rpt19 = ?,Rpt20 = ?"
                                + ",Rpt21 = ?,Rpt22 = ?,Rpt23 = ?,Rpt24 = ?,Rpt25 = ?,Rpt26 = ?,Rpt27 = ?,Rpt28 = ?,Rpt29 = ?,Rpt30 = ?"
                                + ",Rpt31 = ?,Rpt32 = ?,Rpt33 = ?,Rpt34 = ?,Rpt35 = ?,Rpt36 = ?,Rpt37 = ?,Rpt38 = ?,Rpt39 = ?,Rpt40 = ?"
                                + ",Rpt41 = ?,Rpt42 = ?,Rpt43 = ?,Rpt44 = ?,Rpt45 = ?,Rpt46 = ?,Rpt47 = ?,Rpt48 = ?,Rpt49 = ?,Rpt50 = ?"
                                + ",Cont1 = ?,Cont2 = ?,Cont3 = ?,Cont4 = ?,Cont5 = ?,Cont6 = ?,Cont7 = ?,Cont8 = ?,Cont9 = ?,Cont10 = ? "
                                + ",M212 = ?, M213 = ?, M214 = ?, M215 = ?, M216 = ? ,M217 = ?"
                                + ",Mast26 = ? ,Mast27 = ?, Rpt51 = ?, Mast28 = ?, Mast29 = ?, Mast30 = ? "
//                                + ", Rpt52 = ? "
                                + "where usergroup=?";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);

                        prm.setString(1, Mast1);
                        prm.setString(2, Mast2);
                        prm.setString(3, Mast3);
                        prm.setString(4, Mast4);
                        prm.setString(5, Mast5);
                        prm.setString(6, Mast6);
                        prm.setString(7, Mast7);
                        prm.setString(8, Mast8);
                        prm.setString(9, Mast9);
                        prm.setString(10, Mast10);
                        prm.setString(11, Mast11);
                        prm.setString(12, Mast12);
                        prm.setString(13, Mast13);
                        prm.setString(14, Mast14);
                        prm.setString(15, Mast15);
                        prm.setString(16, Mast16);
                        prm.setString(17, Mast17);
                        prm.setString(18, Mast18);
                        prm.setString(19, Mast19);
                        prm.setString(20, Mast20);
                        prm.setString(21, Mast21);
                        prm.setString(22, Mast22);
                        prm.setString(23, Mast23);
                        prm.setString(24, Mast24);
                        prm.setString(25, Mast25);
                        prm.setString(26, Plu1);
                        prm.setString(27, Plu2);
                        prm.setString(28, Plu3);
                        prm.setString(29, Plu4);
                        prm.setString(30, Plu5);
                        prm.setString(31, Plu6);
                        prm.setString(32, Plu7);
                        prm.setString(33, Plu8);
                        prm.setString(34, Plu9);
                        prm.setString(35, Plu10);
                        prm.setString(36, Plu11);
                        prm.setString(37, Plu12);
                        prm.setString(38, Plu13);
                        prm.setString(39, Plu14);
                        prm.setString(40, Plu15);
                        prm.setString(41, Plu16);
                        prm.setString(42, Plu17);
                        prm.setString(43, Plu18);
                        prm.setString(44, Plu19);
                        prm.setString(45, Plu20);
                        prm.setString(46, Tran1);
                        prm.setString(47, Tran2);
                        prm.setString(48, Tran3);
                        prm.setString(49, Tran4);
                        prm.setString(50, Tran5);
                        prm.setString(51, Tran6);
                        prm.setString(52, Tran7);
                        prm.setString(53, Tran8);
                        prm.setString(54, Tran9);
                        prm.setString(55, Tran10);
                        prm.setString(56, Tran11);
                        prm.setString(57, Rpt1);
                        prm.setString(58, Rpt2);
                        prm.setString(59, Rpt3);
                        prm.setString(60, Rpt4);
                        prm.setString(61, Rpt5);
                        prm.setString(62, Rpt6);
                        prm.setString(63, Rpt7);
                        prm.setString(64, Rpt8);
                        prm.setString(65, Rpt9);
                        prm.setString(66, Rpt10);
                        prm.setString(67, Rpt11);
                        prm.setString(68, Rpt12);
                        prm.setString(69, Rpt13);
                        prm.setString(70, Rpt14);
                        prm.setString(71, Rpt15);
                        prm.setString(72, Rpt16);
                        prm.setString(73, Rpt17);
                        prm.setString(74, Rpt18);
                        prm.setString(75, Rpt19);
                        prm.setString(76, Rpt20);
                        prm.setString(77, Rpt21);
                        prm.setString(78, Rpt22);
                        prm.setString(79, Rpt23);
                        prm.setString(80, Rpt24);
                        prm.setString(81, Rpt25);
                        prm.setString(82, Rpt26);
                        prm.setString(83, Rpt27);
                        prm.setString(84, Rpt28);
                        prm.setString(85, Rpt29);
                        prm.setString(86, Rpt30);
                        prm.setString(87, Rpt31);
                        prm.setString(88, Rpt32);
                        prm.setString(89, Rpt33);
                        prm.setString(90, Rpt34);
                        prm.setString(91, Rpt35);
                        prm.setString(92, Rpt36);
                        prm.setString(93, Rpt37);
                        prm.setString(94, Rpt38);
                        prm.setString(95, Rpt39);
                        prm.setString(96, Rpt40);
                        prm.setString(97, Rpt41);
                        prm.setString(98, Rpt42);
                        prm.setString(99, Rpt43);
                        prm.setString(100, Rpt44);
                        prm.setString(101, Rpt45);
                        prm.setString(102, Rpt46);
                        prm.setString(103, Rpt47);
                        prm.setString(104, Rpt48);
                        prm.setString(105, Rpt49);
                        prm.setString(106, Rpt50);
                        prm.setString(107, Cont1);
                        prm.setString(108, Cont2);
                        prm.setString(109, Cont3);
                        prm.setString(110, Cont4);
                        prm.setString(111, Cont5);
                        prm.setString(112, Cont6);
                        prm.setString(113, Cont7);
                        prm.setString(114, Cont8);
                        prm.setString(115, Cont9);
                        prm.setString(116, Cont10);

                        prm.setString(117, M212);
                        prm.setString(118, M213);
                        prm.setString(119, M214);
                        prm.setString(120, M215);
                        prm.setString(121, M216);
                        prm.setString(122, M217);

                        prm.setString(123, Mast26);
                        prm.setString(124, Mast27);
                        prm.setString(125, Rpt51);
                        prm.setString(126, Mast28);
                        prm.setString(127, Mast29);
                        prm.setString(128, Mast30);
//                        prm.setString(129, Rpt52);
                        prm.setString(129, cvth.Unicode2ASCII(t_groupuser.getText()));
                        prm.executeUpdate();
                        prm.close();
                    } else {
                        //insert

                        String sql2 = "Insert Into borgrouplinux (Mast1 ,Mast2 ,Mast3 ,Mast4 ,Mast5 ,Mast6 ,Mast7 ,Mast8 "
                                + ",Mast9 ,Mast10 ,Mast11 ,Mast12 ,Mast13 ,Mast14 ,Mast15 ,Mast16 ,Mast17 ,Mast18 "
                                + ",Mast19 ,Mast20 ,Mast21 ,Mast22 ,Mast23 ,Mast24 ,Mast25 "
                                + ",Plu1 ,Plu2 ,Plu3 ,Plu4 ,Plu5 ,Plu6 ,Plu7 ,Plu8 ,Plu9 ,Plu10 "
                                + ",Plu11 ,Plu12 ,Plu13 ,Plu14 ,Plu15 ,Plu16 ,Plu17 ,Plu18 ,Plu19 ,Plu20 "
                                + ",Tran1 ,Tran2 ,Tran3 ,Tran4 ,Tran5 ,Tran6 ,Tran7 ,Tran8 ,Tran9 ,Tran10 ,Tran11 "
                                + ",Rpt1 ,Rpt2 ,Rpt3 ,Rpt4 ,Rpt5 ,Rpt6 ,Rpt7 ,Rpt8 ,Rpt9 ,Rpt10 "
                                + ",Rpt11 ,Rpt12 ,Rpt13 ,Rpt14 ,Rpt15 ,Rpt16 ,Rpt17 ,Rpt18 ,Rpt19 ,Rpt20 "
                                + ",Rpt21 ,Rpt22 ,Rpt23 ,Rpt24 ,Rpt25 ,Rpt26 ,Rpt27 ,Rpt28 ,Rpt29 ,Rpt30 "
                                + ",Rpt31 ,Rpt32 ,Rpt33 ,Rpt34 ,Rpt35 ,Rpt36 ,Rpt37 ,Rpt38 ,Rpt39 ,Rpt40 "
                                + ",Rpt41 ,Rpt42 ,Rpt43 ,Rpt44 ,Rpt45 ,Rpt46 ,Rpt47 ,Rpt48 ,Rpt49 ,Rpt50 "
                                + ",Cont1 ,Cont2 ,Cont3 ,Cont4 ,Cont5 ,Cont6 ,Cont7 ,Cont8 ,Cont9 ,Cont10 "
                                + ",usergroup"
                                + ",M212 ,M213 ,M214, M215, M216, M217, Mast26, Mast27 ,Rpt51, Mast28, Mast29, Mast30"
//                                + ", Rpt52"
                                + ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                                + ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                                + ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                                + ",?,?,?,?,?,?,?,?,?, ?,?,?"
//                                + ",?"
                                + ")";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);

                        prm.setString(1, Mast1);
                        prm.setString(2, Mast2);
                        prm.setString(3, Mast3);
                        prm.setString(4, Mast4);
                        prm.setString(5, Mast5);
                        prm.setString(6, Mast6);
                        prm.setString(7, Mast7);
                        prm.setString(8, Mast8);
                        prm.setString(9, Mast9);
                        prm.setString(10, Mast10);
                        prm.setString(11, Mast11);
                        prm.setString(12, Mast12);
                        prm.setString(13, Mast13);
                        prm.setString(14, Mast14);
                        prm.setString(15, Mast15);
                        prm.setString(16, Mast16);
                        prm.setString(17, Mast17);
                        prm.setString(18, Mast18);
                        prm.setString(19, Mast19);
                        prm.setString(20, Mast20);
                        prm.setString(21, Mast21);
                        prm.setString(22, Mast22);
                        prm.setString(23, Mast23);
                        prm.setString(24, Mast24);
                        prm.setString(25, Mast25);
                        prm.setString(26, Plu1);
                        prm.setString(27, Plu2);
                        prm.setString(28, Plu3);
                        prm.setString(29, Plu4);
                        prm.setString(30, Plu5);
                        prm.setString(31, Plu6);
                        prm.setString(32, Plu7);
                        prm.setString(33, Plu8);
                        prm.setString(34, Plu9);
                        prm.setString(35, Plu10);
                        prm.setString(36, Plu11);
                        prm.setString(37, Plu12);
                        prm.setString(38, Plu13);
                        prm.setString(39, Plu14);
                        prm.setString(40, Plu15);
                        prm.setString(41, Plu16);
                        prm.setString(42, Plu17);
                        prm.setString(43, Plu18);
                        prm.setString(44, Plu19);
                        prm.setString(45, Plu20);
                        prm.setString(46, Tran1);
                        prm.setString(47, Tran2);
                        prm.setString(48, Tran3);
                        prm.setString(49, Tran4);
                        prm.setString(50, Tran5);
                        prm.setString(51, Tran6);
                        prm.setString(52, Tran7);
                        prm.setString(53, Tran8);
                        prm.setString(54, Tran9);
                        prm.setString(55, Tran10);
                        prm.setString(56, Tran11);
                        prm.setString(57, Rpt1);
                        prm.setString(58, Rpt2);
                        prm.setString(59, Rpt3);
                        prm.setString(60, Rpt4);
                        prm.setString(61, Rpt5);
                        prm.setString(62, Rpt6);
                        prm.setString(63, Rpt7);
                        prm.setString(64, Rpt8);
                        prm.setString(65, Rpt9);
                        prm.setString(66, Rpt10);
                        prm.setString(67, Rpt11);
                        prm.setString(68, Rpt12);
                        prm.setString(69, Rpt13);
                        prm.setString(70, Rpt14);
                        prm.setString(71, Rpt15);
                        prm.setString(72, Rpt16);
                        prm.setString(73, Rpt17);
                        prm.setString(74, Rpt18);
                        prm.setString(75, Rpt19);
                        prm.setString(76, Rpt20);
                        prm.setString(77, Rpt21);
                        prm.setString(78, Rpt22);
                        prm.setString(79, Rpt23);
                        prm.setString(80, Rpt24);
                        prm.setString(81, Rpt25);
                        prm.setString(82, Rpt26);
                        prm.setString(83, Rpt27);
                        prm.setString(84, Rpt28);
                        prm.setString(85, Rpt29);
                        prm.setString(86, Rpt30);
                        prm.setString(87, Rpt31);
                        prm.setString(88, Rpt32);
                        prm.setString(89, Rpt33);
                        prm.setString(90, Rpt34);
                        prm.setString(91, Rpt35);
                        prm.setString(92, Rpt36);
                        prm.setString(93, Rpt37);
                        prm.setString(94, Rpt38);
                        prm.setString(95, Rpt39);
                        prm.setString(96, Rpt40);
                        prm.setString(97, Rpt41);
                        prm.setString(98, Rpt42);
                        prm.setString(99, Rpt43);
                        prm.setString(100, Rpt44);
                        prm.setString(101, Rpt45);
                        prm.setString(102, Rpt46);
                        prm.setString(103, Rpt47);
                        prm.setString(104, Rpt48);
                        prm.setString(105, Rpt49);
                        prm.setString(106, Rpt50);
                        prm.setString(107, Cont1);
                        prm.setString(108, Cont2);
                        prm.setString(109, Cont3);
                        prm.setString(110, Cont4);
                        prm.setString(111, Cont5);
                        prm.setString(112, Cont6);
                        prm.setString(113, Cont7);
                        prm.setString(114, Cont8);
                        prm.setString(115, Cont9);
                        prm.setString(116, Cont10);
                        prm.setString(117, cvth.Unicode2ASCII(t_groupuser.getText()));

                        prm.setString(118, M212);
                        prm.setString(119, M213);
                        prm.setString(120, M214);
                        prm.setString(121, M215);
                        prm.setString(122, M216);
                        prm.setString(123, M217);
                        prm.setString(124, Mast26);
                        prm.setString(125, Mast27);
                        prm.setString(126, Rpt51);
                        prm.setString(127, Mast28);
                        prm.setString(128, Mast29);
                        prm.setString(129, Mast30);
//                        prm.setString(130, Rpt52);
                        prm.executeUpdate();
                        prm.close();
                    }
                    clearDisplay();
                }
            } else {
                if (validatesave()) {
                    if (chkgroup(t_groupuser.getText())) {

                        //update
                        String sql2 = "Update borgrouplinux Set Mast1 = ?,Mast2 = ?,Mast3 = ?,Mast4 = ?,Mast5 = ?,Mast6 = ?,Mast7 = ?,Mast8 = ?"
                                + ",Mast9 = ?,Mast10 = ?,Mast11 = ?,Mast12 = ?,Mast13 = ?,Mast14 = ?,Mast15 = ?,Mast16 = ?,Mast17 = ?,Mast18 = ?"
                                + ",Mast19 = ?,Mast20 = ?,Mast21 = ?,Mast22 = ?,Mast23 = ?,Mast24 = ?,Mast25 = ?"
                                + ",Plu1 = ?,Plu2 = ?,Plu3 = ?,Plu4 = ?,Plu5 = ?,Plu6 = ?,Plu7 = ?,Plu8 = ?,Plu9 = ?,Plu10 = ?"
                                + ",Plu11 = ?,Plu12 = ?,Plu13 = ?,Plu14 = ?,Plu15 = ?,Plu16 = ?,Plu17 = ?,Plu18 = ?,Plu19 = ?,Plu20 = ?"
                                + ",Tran1 = ?,Tran2 = ?,Tran3 = ?,Tran4 = ?,Tran5 = ?,Tran6 = ?,Tran7 = ?,Tran8 = ?,Tran9 = ?,Tran10 = ?,Tran11 = ?"
                                + ",Rpt1 = ?,Rpt2 = ?,Rpt3 = ?,Rpt4 = ?,Rpt5 = ?,Rpt6 = ?,Rpt7 = ?,Rpt8 = ?,Rpt9 = ?,Rpt10 = ?"
                                + ",Rpt11 = ?,Rpt12 = ?,Rpt13 = ?,Rpt14 = ?,Rpt15 = ?,Rpt16 = ?,Rpt17 = ?,Rpt18 = ?,Rpt19 = ?,Rpt20 = ?"
                                + ",Rpt21 = ?,Rpt22 = ?,Rpt23 = ?,Rpt24 = ?,Rpt25 = ?,Rpt26 = ?,Rpt27 = ?,Rpt28 = ?,Rpt29 = ?,Rpt30 = ?"
                                + ",Rpt31 = ?,Rpt32 = ?,Rpt33 = ?,Rpt34 = ?,Rpt35 = ?,Rpt36 = ?,Rpt37 = ?,Rpt38 = ?,Rpt39 = ?,Rpt40 = ?"
                                + ",Rpt41 = ?,Rpt42 = ?,Rpt43 = ?,Rpt44 = ?,Rpt45 = ?,Rpt46 = ?,Rpt47 = ?,Rpt48 = ?,Rpt49 = ?,Rpt50 = ?"
                                + ",Cont1 = ?,Cont2 = ?,Cont3 = ?,Cont4 = ?,Cont5 = ?,Cont6 = ?,Cont7 = ?,Cont8 = ?,Cont9 = ?,Cont10 = ? "
                                + ",M212 = ?, M213 = ?, M214 = ?, M215 = ?, M216 = ?, M217 = ? "
                                + ",Mast26 = ? ,Mast27 = ? ,Rpt51 = ?, Mast28 = ?, Mast29 = ?, Mast30 = ? "
//                                + ",Rpt52 = ? "
                                + "where usergroup=?";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);

                        prm.setString(1, Mast1);
                        prm.setString(2, Mast2);
                        prm.setString(3, Mast3);
                        prm.setString(4, Mast4);
                        prm.setString(5, Mast5);
                        prm.setString(6, Mast6);
                        prm.setString(7, Mast7);
                        prm.setString(8, Mast8);
                        prm.setString(9, Mast9);
                        prm.setString(10, Mast10);
                        prm.setString(11, Mast11);
                        prm.setString(12, Mast12);
                        prm.setString(13, Mast13);
                        prm.setString(14, Mast14);
                        prm.setString(15, Mast15);
                        prm.setString(16, Mast16);
                        prm.setString(17, Mast17);
                        prm.setString(18, Mast18);
                        prm.setString(19, Mast19);
                        prm.setString(20, Mast20);
                        prm.setString(21, Mast21);
                        prm.setString(22, Mast22);
                        prm.setString(23, Mast23);
                        prm.setString(24, Mast24);
                        prm.setString(25, Mast25);
                        prm.setString(26, Plu1);
                        prm.setString(27, Plu2);
                        prm.setString(28, Plu3);
                        prm.setString(29, Plu4);
                        prm.setString(30, Plu5);
                        prm.setString(31, Plu6);
                        prm.setString(32, Plu7);
                        prm.setString(33, Plu8);
                        prm.setString(34, Plu9);
                        prm.setString(35, Plu10);
                        prm.setString(36, Plu11);
                        prm.setString(37, Plu12);
                        prm.setString(38, Plu13);
                        prm.setString(39, Plu14);
                        prm.setString(40, Plu15);
                        prm.setString(41, Plu16);
                        prm.setString(42, Plu17);
                        prm.setString(43, Plu18);
                        prm.setString(44, Plu19);
                        prm.setString(45, Plu20);
                        prm.setString(46, Tran1);
                        prm.setString(47, Tran2);
                        prm.setString(48, Tran3);
                        prm.setString(49, Tran4);
                        prm.setString(50, Tran5);
                        prm.setString(51, Tran6);
                        prm.setString(52, Tran7);
                        prm.setString(53, Tran8);
                        prm.setString(54, Tran9);
                        prm.setString(55, Tran10);
                        prm.setString(56, Tran11);
                        prm.setString(57, Rpt1);
                        prm.setString(58, Rpt2);
                        prm.setString(59, Rpt3);
                        prm.setString(60, Rpt4);
                        prm.setString(61, Rpt5);
                        prm.setString(62, Rpt6);
                        prm.setString(63, Rpt7);
                        prm.setString(64, Rpt8);
                        prm.setString(65, Rpt9);
                        prm.setString(66, Rpt10);
                        prm.setString(67, Rpt11);
                        prm.setString(68, Rpt12);
                        prm.setString(69, Rpt13);
                        prm.setString(70, Rpt14);
                        prm.setString(71, Rpt15);
                        prm.setString(72, Rpt16);
                        prm.setString(73, Rpt17);
                        prm.setString(74, Rpt18);
                        prm.setString(75, Rpt19);
                        prm.setString(76, Rpt20);
                        prm.setString(77, Rpt21);
                        prm.setString(78, Rpt22);
                        prm.setString(79, Rpt23);
                        prm.setString(80, Rpt24);
                        prm.setString(81, Rpt25);
                        prm.setString(82, Rpt26);
                        prm.setString(83, Rpt27);
                        prm.setString(84, Rpt28);
                        prm.setString(85, Rpt29);
                        prm.setString(86, Rpt30);
                        prm.setString(87, Rpt31);
                        prm.setString(88, Rpt32);
                        prm.setString(89, Rpt33);
                        prm.setString(90, Rpt34);
                        prm.setString(91, Rpt35);
                        prm.setString(92, Rpt36);
                        prm.setString(93, Rpt37);
                        prm.setString(94, Rpt38);
                        prm.setString(95, Rpt39);
                        prm.setString(96, Rpt40);
                        prm.setString(97, Rpt41);
                        prm.setString(98, Rpt42);
                        prm.setString(99, Rpt43);
                        prm.setString(100, Rpt44);
                        prm.setString(101, Rpt45);
                        prm.setString(102, Rpt46);
                        prm.setString(103, Rpt47);
                        prm.setString(104, Rpt48);
                        prm.setString(105, Rpt49);
                        prm.setString(106, Rpt50);
                        prm.setString(107, Cont1);
                        prm.setString(108, Cont2);
                        prm.setString(109, Cont3);
                        prm.setString(110, Cont4);
                        prm.setString(111, Cont5);
                        prm.setString(112, Cont6);
                        prm.setString(113, Cont7);
                        prm.setString(114, Cont8);
                        prm.setString(115, Cont9);
                        prm.setString(116, Cont10);

                        prm.setString(117, M212);
                        prm.setString(118, M213);
                        prm.setString(119, M214);
                        prm.setString(120, M215);
                        prm.setString(121, M216);
                        prm.setString(122, M217);

                        prm.setString(123, Mast26);
                        prm.setString(124, Mast27);
                        prm.setString(125, Rpt51);
                        prm.setString(126, Mast28);
                        prm.setString(127, Mast29);
                        prm.setString(128, Mast30);
//                        prm.setString(129, Rpt52);

                        prm.setString(129, t_groupuser.getText());
                        prm.executeUpdate();
                        prm.close();
                    } else {
                        //insert

                        String sql2 = "Insert Into borgrouplinux (Mast1 ,Mast2 ,Mast3 ,Mast4 ,Mast5 ,Mast6 ,Mast7 ,Mast8 "
                                + ",Mast9 ,Mast10 ,Mast11 ,Mast12 ,Mast13 ,Mast14 ,Mast15 ,Mast16 ,Mast17 ,Mast18 "
                                + ",Mast19 ,Mast20 ,Mast21 ,Mast22 ,Mast23 ,Mast24 ,Mast25 "
                                + ",Plu1 ,Plu2 ,Plu3 ,Plu4 ,Plu5 ,Plu6 ,Plu7 ,Plu8 ,Plu9 ,Plu10 "
                                + ",Plu11 ,Plu12 ,Plu13 ,Plu14 ,Plu15 ,Plu16 ,Plu17 ,Plu18 ,Plu19 ,Plu20 "
                                + ",Tran1 ,Tran2 ,Tran3 ,Tran4 ,Tran5 ,Tran6 ,Tran7 ,Tran8 ,Tran9 ,Tran10 ,Tran11 "
                                + ",Rpt1 ,Rpt2 ,Rpt3 ,Rpt4 ,Rpt5 ,Rpt6 ,Rpt7 ,Rpt8 ,Rpt9 ,Rpt10 "
                                + ",Rpt11 ,Rpt12 ,Rpt13 ,Rpt14 ,Rpt15 ,Rpt16 ,Rpt17 ,Rpt18 ,Rpt19 ,Rpt20 "
                                + ",Rpt21 ,Rpt22 ,Rpt23 ,Rpt24 ,Rpt25 ,Rpt26 ,Rpt27 ,Rpt28 ,Rpt29 ,Rpt30 "
                                + ",Rpt31 ,Rpt32 ,Rpt33 ,Rpt34 ,Rpt35 ,Rpt36 ,Rpt37 ,Rpt38 ,Rpt39 ,Rpt40 "
                                + ",Rpt41 ,Rpt42 ,Rpt43 ,Rpt44 ,Rpt45 ,Rpt46 ,Rpt47 ,Rpt48 ,Rpt49 ,Rpt50 "
                                + ",Cont1 ,Cont2 ,Cont3 ,Cont4 ,Cont5 ,Cont6 ,Cont7 ,Cont8 ,Cont9 ,Cont10 "
                                + ",usergroup  "
                                + ",M212 ,M213, M214, M215, M216, M217, Mast26, Mast27, Rpt51, Mast28, Mast29, Mast30"
//                                + ",Rpt52"
                                + ")"
                                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                                + ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                                + ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                                + ",?,?,?,?,?,?,?,?,?, ?,?,?"
//                                + ",?"
                                + ")";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);

                        prm.setString(1, Mast1);
                        prm.setString(2, Mast2);
                        prm.setString(3, Mast3);
                        prm.setString(4, Mast4);
                        prm.setString(5, Mast5);
                        prm.setString(6, Mast6);
                        prm.setString(7, Mast7);
                        prm.setString(8, Mast8);
                        prm.setString(9, Mast9);
                        prm.setString(10, Mast10);
                        prm.setString(11, Mast11);
                        prm.setString(12, Mast12);
                        prm.setString(13, Mast13);
                        prm.setString(14, Mast14);
                        prm.setString(15, Mast15);
                        prm.setString(16, Mast16);
                        prm.setString(17, Mast17);
                        prm.setString(18, Mast18);
                        prm.setString(19, Mast19);
                        prm.setString(20, Mast20);
                        prm.setString(21, Mast21);
                        prm.setString(22, Mast22);
                        prm.setString(23, Mast23);
                        prm.setString(24, Mast24);
                        prm.setString(25, Mast25);
                        prm.setString(26, Plu1);
                        prm.setString(27, Plu2);
                        prm.setString(28, Plu3);
                        prm.setString(29, Plu4);
                        prm.setString(30, Plu5);
                        prm.setString(31, Plu6);
                        prm.setString(32, Plu7);
                        prm.setString(33, Plu8);
                        prm.setString(34, Plu9);
                        prm.setString(35, Plu10);
                        prm.setString(36, Plu11);
                        prm.setString(37, Plu12);
                        prm.setString(38, Plu13);
                        prm.setString(39, Plu14);
                        prm.setString(40, Plu15);
                        prm.setString(41, Plu16);
                        prm.setString(42, Plu17);
                        prm.setString(43, Plu18);
                        prm.setString(44, Plu19);
                        prm.setString(45, Plu20);
                        prm.setString(46, Tran1);
                        prm.setString(47, Tran2);
                        prm.setString(48, Tran3);
                        prm.setString(49, Tran4);
                        prm.setString(50, Tran5);
                        prm.setString(51, Tran6);
                        prm.setString(52, Tran7);
                        prm.setString(53, Tran8);
                        prm.setString(54, Tran9);
                        prm.setString(55, Tran10);
                        prm.setString(56, Tran11);
                        prm.setString(57, Rpt1);
                        prm.setString(58, Rpt2);
                        prm.setString(59, Rpt3);
                        prm.setString(60, Rpt4);
                        prm.setString(61, Rpt5);
                        prm.setString(62, Rpt6);
                        prm.setString(63, Rpt7);
                        prm.setString(64, Rpt8);
                        prm.setString(65, Rpt9);
                        prm.setString(66, Rpt10);
                        prm.setString(67, Rpt11);
                        prm.setString(68, Rpt12);
                        prm.setString(69, Rpt13);
                        prm.setString(70, Rpt14);
                        prm.setString(71, Rpt15);
                        prm.setString(72, Rpt16);
                        prm.setString(73, Rpt17);
                        prm.setString(74, Rpt18);
                        prm.setString(75, Rpt19);
                        prm.setString(76, Rpt20);
                        prm.setString(77, Rpt21);
                        prm.setString(78, Rpt22);
                        prm.setString(79, Rpt23);
                        prm.setString(80, Rpt24);
                        prm.setString(81, Rpt25);
                        prm.setString(82, Rpt26);
                        prm.setString(83, Rpt27);
                        prm.setString(84, Rpt28);
                        prm.setString(85, Rpt29);
                        prm.setString(86, Rpt30);
                        prm.setString(87, Rpt31);
                        prm.setString(88, Rpt32);
                        prm.setString(89, Rpt33);
                        prm.setString(90, Rpt34);
                        prm.setString(91, Rpt35);
                        prm.setString(92, Rpt36);
                        prm.setString(93, Rpt37);
                        prm.setString(94, Rpt38);
                        prm.setString(95, Rpt39);
                        prm.setString(96, Rpt40);
                        prm.setString(97, Rpt41);
                        prm.setString(98, Rpt42);
                        prm.setString(99, Rpt43);
                        prm.setString(100, Rpt44);
                        prm.setString(101, Rpt45);
                        prm.setString(102, Rpt46);
                        prm.setString(103, Rpt47);
                        prm.setString(104, Rpt48);
                        prm.setString(105, Rpt49);
                        prm.setString(106, Rpt50);
                        prm.setString(107, Cont1);
                        prm.setString(108, Cont2);
                        prm.setString(109, Cont3);
                        prm.setString(110, Cont4);
                        prm.setString(111, Cont5);
                        prm.setString(112, Cont6);
                        prm.setString(113, Cont7);
                        prm.setString(114, Cont8);
                        prm.setString(115, Cont9);
                        prm.setString(116, Cont10);
                        prm.setString(117, t_groupuser.getText());

                        prm.setString(118, M212);
                        prm.setString(119, M213);
                        prm.setString(120, M214);
                        prm.setString(121, M215);
                        prm.setString(122, M216);
                        prm.setString(123, M217);

                        prm.setString(124, Mast26);
                        prm.setString(125, Mast27);
                        prm.setString(126, Rpt51);
                        prm.setString(127, Mast28);
                        prm.setString(128, Mast29);
                        prm.setString(129, Mast30);
//                        prm.setString(130, Rpt52);
                        prm.executeUpdate();
                        prm.close();
                    }
                    clearDisplay();
                }

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private boolean validatesave() {
        boolean chk = true;

        if (t_groupuser.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "กำหนด กลุ่มผู้ใช้ ไม่ถูกต้อง... กรุณากำหนดให้ถูกต้อง");
            t_groupuser.requestFocus();

            chk = false;
        } else if (t_groupuser.getText().length() > 20) {

            JOptionPane.showMessageDialog(this, "กำหนด กลุ่มผู้ใช้ ไม่ถูกต้อง... (ต้องมีขนาดไม่เกิน 20 ตัวอักษร)");
            t_groupuser.requestFocus();
            chk = false;
        } else if (tbl3.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "กรุณากดปุ่ม OK เพื่อดูรายการกำหนดสิทธิ์");
            db_btnOK.requestFocus();
            chk = false;
        }

        return chk;
    }

    private void clearDisplay() {
        loadtblGroup();
        removetbl(tbl3);
        t_groupuser.setText("");
        t_groupuser.requestFocus();
        cboset.setSelectedIndex(0);
    }

    public int chkdelete(String code) {

        ResultSet rs = null;
        int count = 0;
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) db.con.createStatement();
                String sql = "select * from boruserlinux where usergroup ='" + cvth.Unicode2ASCII(code) + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    count++;
                }
            } else {
                stmt = (Statement) db.con.createStatement();
                String sql = "select * from boruserlinux where usergroup ='" + code + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    count++;
                }
            }
        } catch (Exception e) {
        }
        return count;
    }

    public void delete() {
        ResultSet rs = null;
        try {
            if (chkdelete(t_groupuser.getText()) == 0) {
                int confirm = JOptionPane.showConfirmDialog(this, "คุณต้องการลบข้อมูลรายการนี้หรือไม่...?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                        stmt = (Statement) db.con.createStatement();
                        String sql = "Delete from borgrouplinux where usergroup=?";
                        java.sql.PreparedStatement prm = (java.sql.PreparedStatement) db.con.prepareStatement(sql);
                        prm.setString(1, cvth.Unicode2ASCII(t_groupuser.getText()));
                        prm.executeUpdate();
                    } else {
                        stmt = (Statement) db.con.createStatement();
                        String sql = "Delete from borgrouplinux where usergroup=?";
                        java.sql.PreparedStatement prm = (java.sql.PreparedStatement) db.con.prepareStatement(sql);
                        prm.setString(1, t_groupuser.getText());
                        prm.executeUpdate();
                        stmt.close();
                    }
                    clearDisplay();
                }
            } else {
                JOptionPane.showMessageDialog(this, "ไม่สามารถลบข้อมูลได้ เนื่องจากมีข้อมูลอยู่ใน BorUser จำนวน " + chkdelete(t_groupuser.getText()) + " รายการ");
            }

        } catch (Exception e) {
        }
    }

    private void setToAll(String txtSet) {
        if (tbl3.getRowCount() > 0) {
            for (int i = 0; i < tbl3.getRowCount(); i++) {
                tbl3.setValueAt(txtSet, i, 3);
            }
        }
    }
}
