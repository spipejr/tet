/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package masterfile;

import borfunction.GetApplicationName;
import borfunction.GetUser;
import dbutility.dbUtility;
import frmlist.ShowBranchOfBGroup;
import ingredent_bom.formatDateNumber;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import report.Report;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;
import utilititiesfunction.UserLogin;
import utilititiesfunction.getLanguage;

/**
 *
 * @author s386
 */
public class voidmessage extends javax.swing.JFrame {

    /**
     * Creates new form BranchGroup
     */
    formatDateNumber f = new formatDateNumber();
    DefaultTableModel tbBranctype;
    dbUtility db = new dbUtility();
    Statement stmt;
    String frmName = "creditcardsetup";
    ThaiUtilities cvth = new ThaiUtilities();
    getLanguage lang = new getLanguage();

    public voidmessage() {
        initComponents();
        checkuserconfig();
        tbBranctype = (DefaultTableModel) tblBtype.getModel();
        tblBtype.setShowGrid(true);
        tblBtype.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblBtype.setRowSelectionAllowed(true);
        tblBtype.setBackground(java.awt.Color.WHITE);
        tblBtype.setGridColor(java.awt.Color.gray);
        JTableHeader header = tblBtype.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tblBtype.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tblBtype.setRowHeight(25);
        db.dbconnect();
        showdataintb();
        clear();
        lang.setText(frmName, this, lang.getChklang());
        txtfBtypeCode.requestFocus();
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
        lblBtypeCode = new javax.swing.JLabel();
        lblDiscription = new javax.swing.JLabel();
        txtfDiscription = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        _voidget = new javax.swing.JComboBox<>();
        txtfBtypeCode = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBtype = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDetete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        db_btnPrint = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuFunc = new javax.swing.JMenu();
        menuCancel = new javax.swing.JMenuItem();
        menuSave = new javax.swing.JMenuItem();
        menuDelete = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("กำหนดหมายเหตุการ Void นอก (Refund)");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        lblBtypeCode.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        lblBtypeCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBtypeCode.setText("รหัส Code");
        lblBtypeCode.setName("d_lblBtypeCode"); // NOI18N
        jPanel2.add(lblBtypeCode);
        lblBtypeCode.setBounds(14, 17, 106, 24);

        lblDiscription.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        lblDiscription.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiscription.setText("รายละเอียด");
        lblDiscription.setName("d_lblDiscription"); // NOI18N
        jPanel2.add(lblDiscription);
        lblDiscription.setBounds(14, 50, 106, 24);

        txtfDiscription.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        txtfDiscription.setName("txtfDiscription"); // NOI18N
        txtfDiscription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfDiscriptionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfDiscriptionFocusLost(evt);
            }
        });
        txtfDiscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfDiscriptionActionPerformed(evt);
            }
        });
        txtfDiscription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfDiscriptionKeyPressed(evt);
            }
        });
        jPanel2.add(txtfDiscription);
        txtfDiscription.setBounds(140, 50, 291, 30);

        jLabel1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel1.setText("บันทึกหมายเหตุการ Void ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(670, 55, 144, 24);

        _voidget.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        _voidget.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        jPanel2.add(_voidget);
        _voidget.setBounds(830, 50, 60, 33);

        txtfBtypeCode.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtfBtypeCode.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtfBtypeCode.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        txtfBtypeCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfBtypeCodeFocusLost(evt);
            }
        });
        txtfBtypeCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfBtypeCodeKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfBtypeCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfBtypeCodeKeyReleased(evt);
            }
        });
        jPanel2.add(txtfBtypeCode);
        txtfBtypeCode.setBounds(140, 20, 50, 30);

        tblBtype.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        tblBtype.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัส Code", "รายละเอียด", "บันทึกหมายเหตุ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBtype.setName("tblBtype"); // NOI18N
        tblBtype.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblBtypeMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblBtype);
        if (tblBtype.getColumnModel().getColumnCount() > 0) {
            tblBtype.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblBtype.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblBtype.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCancel.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel-icon.png"))); // NOI18N
        btnCancel.setText("ยกเลิก");
        btnCancel.setFocusable(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setIconTextGap(0);
        btnCancel.setName("db_btnCancel"); // NOI18N
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save-icon.png"))); // NOI18N
        btnSave.setText("บันทึกข้อมูล");
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setIconTextGap(0);
        btnSave.setName("db_btnSave"); // NOI18N
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDetete.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnDetete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete-icons.png"))); // NOI18N
        btnDetete.setText("ลบข้อมูล");
        btnDetete.setFocusable(false);
        btnDetete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetete.setIconTextGap(0);
        btnDetete.setName("db_btnDetete"); // NOI18N
        btnDetete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDetete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeteteActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LogOut-icon.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setFocusable(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setIconTextGap(0);
        btnExit.setName("db_btnExit"); // NOI18N
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        db_btnPrint.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        db_btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Printer-icon.png"))); // NOI18N
        db_btnPrint.setText("พิมม์");
        db_btnPrint.setFocusable(false);
        db_btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        db_btnPrint.setIconTextGap(0);
        db_btnPrint.setName("db_btnPrint"); // NOI18N
        db_btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        db_btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDetete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(db_btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(db_btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnDetete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        menuFunc.setText("ฟังก์ชั่น");
        menuFunc.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        menuFunc.setName("menuFunc"); // NOI18N

        menuCancel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuCancel.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        menuCancel.setText("ยกเลิก");
        menuCancel.setName("menuCancel"); // NOI18N
        menuCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCancelActionPerformed(evt);
            }
        });
        menuFunc.add(menuCancel);

        menuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSave.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        menuSave.setText("บันทึกข้อมูล");
        menuSave.setName("menuSave"); // NOI18N
        menuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveActionPerformed(evt);
            }
        });
        menuFunc.add(menuSave);

        menuDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menuDelete.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        menuDelete.setText("ลบข้อมูล");
        menuDelete.setName("menuDelete"); // NOI18N
        menuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteActionPerformed(evt);
            }
        });
        menuFunc.add(menuDelete);

        jSeparator1.setName("jSpeparator1"); // NOI18N
        menuFunc.add(jSeparator1);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        menuExit.setText("Exit");
        menuExit.setName("menuExit"); // NOI18N
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFunc.add(menuExit);

        jMenuBar2.add(menuFunc);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(939, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkuserconfig() {
        //MenuName = Mast1
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getMast2().equals("1")) {
            btnSave.setEnabled(false);
            btnDetete.setEnabled(false);
            menuSave.setEnabled(false);
            menuDelete.setEnabled(false);
        }
        if (userrec.getMast2().equals("2")) {
            btnSave.setEnabled(true);
            btnDetete.setEnabled(false);
            menuSave.setEnabled(true);
            menuDelete.setEnabled(false);
        }
        if (userrec.getMast2().equals("3")) {
            btnSave.setEnabled(true);
            btnDetete.setEnabled(true);
            menuSave.setEnabled(true);
            menuDelete.setEnabled(true);
        }
    }
    private void txtfDiscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfDiscriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfDiscriptionActionPerformed

    private void tblBtypeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBtypeMouseReleased
        if (evt.getClickCount() == 2) {
            int index = tblBtype.getSelectedRow();
            String typecode = tblBtype.getValueAt(index, 0).toString();
            if (!typecode.equals("")) {
                txtfBtypeCode.setText(typecode);
                enter();
            }
            setFocus(true);
            txtfDiscription.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBtypeMouseReleased

    private void txtfDiscriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfDiscriptionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            txtfBtypeCode.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfDiscriptionKeyPressed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!txtfBtypeCode.getText().equals("")) {
            btnsave();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeteteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeteteActionPerformed
        if (!txtfBtypeCode.getText().trim().equals("") && chkdata(txtfBtypeCode.getText()) && txtfDiscription.isFocusable()) {
            delete();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeteteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void db_btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_btnPrintActionPerformed
        Map parm = new HashMap();
        String other = "สูตรที่ใช้";
        JRBeanCollectionDataSource ds = null;
        ds = new JRBeanCollectionDataSource(report.databeanMasterfile.getBranchGroup());
        parm.put("companyName", lang.getTextCompanyReport());
//        parm.put("companyName", "");
        parm.put("Reportheader", lang.getTextReport(frmName, "texthead"));
//        parm.put("Reportheader", "");

        parm.put("code", lang.getTextReport(frmName, "code"));
//        parm.put("code", "Group Code");
        parm.put("name", lang.getTextReport(frmName, "name"));
//        parm.put("name", "Group name");
        parm.put("other", other);

        parm.put("totalall", lang.getTextReport(frmName, "totalall"));
//        parm.put("totalall", "");
        parm.put("branchtxt", lang.getTextReport(frmName, "branchtxt"));
//        parm.put("branchtxt", "");
        parm.put("application", new GetApplicationName().getApplicationName());
        parm.put("user", new GetUser().getUser());
        parm.put("currentDate", Format.dateFmtReport.format(new java.util.Date()));

        String rptName = "rptbranchgroup";
        Report rpt = new Report();
        rpt.viewReportbean(rptName, parm, frmName, ds);
        // TODO add your handling code here:
    }//GEN-LAST:event_db_btnPrintActionPerformed

    private void menuCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCancelActionPerformed
        btnCancelActionPerformed(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCancelActionPerformed

    private void menuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveActionPerformed
        btnSaveActionPerformed(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSaveActionPerformed

    private void menuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteActionPerformed
        btnDeteteActionPerformed(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_menuDeleteActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        btnExitActionPerformed(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_menuExitActionPerformed

    private void txtfDiscriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfDiscriptionFocusGained
        txtfDiscription.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfDiscriptionFocusGained

    private void txtfDiscriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfDiscriptionFocusLost
        txtfDiscription.select(0, 0);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfDiscriptionFocusLost

    private void txtfBtypeCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfBtypeCodeFocusLost
        // TODO add your handling code here:
        if (!txtfBtypeCode.getText().equals("")) {
            enter();
        } else {
            txtfBtypeCode.requestFocus();
        }
    }//GEN-LAST:event_txtfBtypeCodeFocusLost

    private void txtfBtypeCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfBtypeCodeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtfBtypeCode.getText().equals("")) {
                setFocus(true);
                txtfDiscription.requestFocus();
            }
        }
    }//GEN-LAST:event_txtfBtypeCodeKeyPressed

    private void txtfBtypeCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfBtypeCodeKeyReleased
        // TODO add your handling code here:
        String get = txtfBtypeCode.getText();
        String out = get.toUpperCase();
        txtfBtypeCode.setText(out);
    }//GEN-LAST:event_txtfBtypeCodeKeyReleased

    private void txtfBtypeCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfBtypeCodeKeyTyped
        // TODO add your handling code here:
        if (txtfBtypeCode.getText().length() >= 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfBtypeCodeKeyTyped

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
            java.util.logging.Logger.getLogger(voidmessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(voidmessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(voidmessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(voidmessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new voidmessage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> _voidget;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDetete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton db_btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblBtypeCode;
    private javax.swing.JLabel lblDiscription;
    private javax.swing.JMenuItem menuCancel;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFunc;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JTable tblBtype;
    private javax.swing.JFormattedTextField txtfBtypeCode;
    private javax.swing.JTextField txtfDiscription;
    // End of variables declaration//GEN-END:variables

    public boolean ChkValidEnter() {
        boolean chk = true;
        if (txtfBtypeCode.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "กรุณากำหนดรหัส Code ก่อน");
            chk = false;
            txtfBtypeCode.requestFocus();
        }
        txtfBtypeCode.setBackground(java.awt.Color.white);
        txtfBtypeCode.setEditable(true);
        return chk;
    }

    public void showdataintb() {
        stmt = null;
        ResultSet rs = null;

        tbBranctype = (DefaultTableModel) tblBtype.getModel();
        int cnt = tbBranctype.getRowCount();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                tbBranctype.removeRow(0);
            }
        }
        try {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from voidmessage order by voidcode";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                    tbBranctype.addRow(new Object[]{cvth.ASCII2Unicode(rs.getString("voidcode")), cvth.ASCII2Unicode(rs.getString("voidmsg")), rs.getString("voidget")});
                } else {
                    tbBranctype.addRow(new Object[]{rs.getString("voidcode"), rs.getString("voidmsg"), rs.getString("voidget")});
                }
            }
        } catch (Exception e) {
        }
    }

    public void clear() {
        txtfBtypeCode.setText("");
        txtfDiscription.setText("");
        setFocus(false);
        txtfBtypeCode.requestFocus();
    }

    public boolean validateSave() {
        boolean chk = true;
        if (!txtfDiscription.isFocusable()) {
            chk = false;
        } else if (txtfBtypeCode.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "กรุณากำหนดรหัสการ Void ");
            chk = false;
            txtfBtypeCode.requestFocus();
        } else if (txtfDiscription.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "กรุณากำหนดรายละเอียดให้ถูกต้อง");
            chk = false;
            txtfDiscription.requestFocus();
        } else if (txtfDiscription.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "กำหนดรายละเอียดไม่ถูกต้อง... (ต้องมีขนาดไม่เกิน 50 ตัวอักษร)");
            chk = false;
            txtfDiscription.requestFocus();
        }
        return chk;
    }

    public boolean chkdata(String pk) {
        boolean chk = false;
        ResultSet rs = null;
        try {
            stmt = (Statement) db.con.createStatement();
            String sql = "select * from voidmessage where voidcode ='" + pk + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                chk = true;
            }

        } catch (Exception e) {
        }
        return chk;
    }

    public void btnsave() {
        int formula = 1;
        String chkrefno = "";
        String voidget = "";
        if (_voidget.getSelectedIndex() == 0) {
            voidget = "Y";
        } else {
            voidget = "N";
        }
        if (validateSave()) {
            if (chkdata(txtfBtypeCode.getText())) {
                try {
                    if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                        stmt = (Statement) db.con.createStatement();
                        String sql = "Update voidmessage set voidmsg = ?,voidget=?  where voidcode = ?";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql);
                        prm.setString(1, cvth.Unicode2ASCII(txtfDiscription.getText()));
                        prm.setString(2, voidget);
                        prm.setString(3, txtfBtypeCode.getText());
                        prm.executeUpdate();
                    } else {
                        stmt = (Statement) db.con.createStatement();
                        String sql = "Update voidmessage set voidmsg = ?, voidget=?  where voidcode = ?";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql);
                        prm.setString(1, txtfDiscription.getText());
                        prm.setString(2, voidget);
                        prm.setString(3, txtfBtypeCode.getText());
                        prm.executeUpdate();
                    }
                    stmt.close();
                    clear();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                        stmt = (Statement) db.con.createStatement();
                        String sql = "Insert into voidmessage (voidcode,voidmsg,voidget) values(?,?,?)";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql);
                        prm.setString(1, cvth.Unicode2ASCII(txtfBtypeCode.getText().trim()));
                        prm.setString(2, cvth.Unicode2ASCII(txtfDiscription.getText()));
                        prm.setString(3, voidget);
                        prm.executeUpdate();
                    } else {
                        stmt = (Statement) db.con.createStatement();
                        String sql = "Insert into voidmessage (voidcode,voidmsg,voidget) values(?,?,?)";
                        PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql);
                        prm.setString(1, txtfBtypeCode.getText().trim());
                        prm.setString(2, txtfDiscription.getText());
                        prm.setString(4, voidget);
                        prm.executeUpdate();
                    }
                    stmt.close();
                    clear();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Insert Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            showdataintb();
        }
    }

    public void enter() {
        ResultSet rs = null;
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) db.con.createStatement();
                String sql = "select * from voidmessage where voidcode ='" + txtfBtypeCode.getText() + "'";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    txtfDiscription.setText(cvth.ASCII2Unicode(rs.getString("voidmsg")));
                    if (rs.getString("voidget").equals("Y")) {
                        _voidget.setSelectedIndex(0);
                    } else {
                        _voidget.setSelectedIndex(1);
                    }
                    setFocus(true);
                    txtfDiscription.requestFocus();
                } else {
                    setFocus(true);
                    txtfDiscription.requestFocus();
                }
            } else {
                stmt = (Statement) db.con.createStatement();
                String sql = "select * from voidmessage where voidcode ='" + txtfBtypeCode.getText() + "'";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    txtfDiscription.setText(rs.getString("voidmsg"));
                    if (rs.getString("voidget").equals("Y")) {
                        _voidget.setSelectedIndex(0);
                    } else {
                        _voidget.setSelectedIndex(1);
                    }
                    setFocus(true);
                    txtfDiscription.requestFocus();
                } else {
                    setFocus(true);
                    txtfDiscription.requestFocus();
                }
            }
        } catch (Exception e) {
        }
    }

    public void delete() {
        ResultSet rs = null;
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "คุณต้องการลบข้อมูลรายการนี้หรือไม่...?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                    stmt = (Statement) db.con.createStatement();
                    String sql = "Delete from voidmessage where voidcode=?";
                    PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql);
                    prm.setString(1, cvth.Unicode2ASCII(txtfBtypeCode.getText()));
                    prm.executeUpdate();
                } else {
                    stmt = (Statement) db.con.createStatement();
                    String sql = "Delete from voidmessage where voidcode=?";
                    PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql);
                    prm.setString(1, txtfBtypeCode.getText());
                    prm.executeUpdate();
                    stmt.close();
                }
                clear();
                showdataintb();
            }

        } catch (Exception e) {
        }
    }

    private void setFocus(boolean chk) {
        //txtfCode.setFocusable(chk);
        txtfDiscription.setFocusable(chk);

        if (chk == false) {
            txtfBtypeCode.setFocusable(true);
            txtfBtypeCode.setBackground(Color.WHITE);
        } else {
            txtfBtypeCode.setBackground(new java.awt.Color(255, 246, 143));
            txtfBtypeCode.setFocusable(false);
        }
    }
}