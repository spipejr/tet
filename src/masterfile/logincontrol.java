package masterfile;


/*
 * loginform.java
 *
 * Created on 24 พฤศจิกายน 2551, 0:11 น.
 */
import Main.PVersion;
import MenuBOR.addmenuforEStamp;
import dbutility.dbUtility;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import utilititiesfunction.PUtility;
import utilititiesfunction.ThaiUtilities;
import utilititiesfunction.UserLogin;

/**
 *
 * @author Surapol
 */
public class logincontrol extends javax.swing.JDialog {

    static JDialog login;
    static String UserCode;
    static String UserName;
    static String BranCode;
    static String BranName;
    static String UserGroup;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();
    static SimpleDateFormat DatefmtShow = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static DecimalFormat IntFmt = new DecimalFormat("#,##0");
    PVersion pv = new PVersion();
     addmenuforEStamp addMenuFormES = new addmenuforEStamp();//idea

    public logincontrol(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        db.dbconnect();
        initComponents();
        c_loginname.setText("1111");
        c_loginpassword.setText("1001");
        c_loginname.requestFocus();
        
        addMenuFormES.addmenu(); //idea

        this.setTitle(this.getTitle() + " " + pv.getVersion() + " " + pv.getUpdate());
    }

    public void clearlogin() {
        c_loginname.setText("");
        c_loginpassword.setText("");
        c_loginname.requestFocus();
    }

    public String getLoinUser() {
        return UserCode;
    }

    public void checkuserlogin() {
        boolean ProcessPass = false;
        db.dbconnect();
        String loginname = c_loginname.getText();
        char[] pass = c_loginpassword.getPassword();
        String password = "";
        for (int i = 0; i < pass.length; i++) {
            password = password + pass[i];
        }
        if ((loginname.length() == 0) || (password.length() == 0)) {
            JOptionPane.showMessageDialog(this, "กรุณาป้อนรหัสผู้ใช้งาน(Username)/รหัสผ่าน(Password)", "Username/Password  Warning !!!", JOptionPane.WARNING_MESSAGE);
            clearlogin();
            return;
        }
        try {
            Statement stmt = dbUtility.con.createStatement();
            String SQLQuery = "";
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                SQLQuery = "select  * from boruserlinux Where(username= '" + cvth.Unicode2ASCII(loginname) + "') and (password='" + cvth.Unicode2ASCII(password) + "')";;
            } else {
                SQLQuery = "select  * from boruserlinux Where(username= '" + loginname + "') and (password='" + password + "')";;
            }
            ResultSet rec = stmt.executeQuery(SQLQuery);
            rec.first();
            if (rec.getRow() == 0) {
                JOptionPane.showMessageDialog(this, "รหัสผู้ใช้งาน (Username) และรหัสผ่าน (Password) ไม่ถูกต้อง !!! ", "Username/Password  Error !!!", JOptionPane.ERROR_MESSAGE);
                clearlogin();
            } else {
                //**************************************************************
                Date TempLastUpdate = new Date();
                if (PUtility.ChkValidDate(rec.getDate("lastchangepassword"))) {
                    TempLastUpdate = rec.getDate("lastchangepassword");
                } else {
                    TempLastUpdate = new Date();
                }
                Calendar ca1 = new GregorianCalendar();
                Calendar ca2 = new GregorianCalendar();
                ca1 = PUtility.StrToCalendar(DatefmtShow.format(TempLastUpdate));
                int PasswordUserDay = PUtility.getDaysBetween(ca1, ca2);
                if (PasswordUserDay >= 90) {
                    PUtility.ShowMsg("Password ของท่านใช้งานมา " + IntFmt.format(PasswordUserDay) + " วัน แล้ว...กรุณาเปลี่ยน Password...");
                    ChangePassword frm = new ChangePassword(null, true);
                    frm.setVisible(true);
                    ProcessPass = frm.ChangePasswordOK;
                    if (!ProcessPass) {
                        PUtility.ShowMsg("Password ของท่านใช้งานมา " + IntFmt.format(PasswordUserDay) + " วัน แล้ว...กรุณาเปลี่ยน Password...ก่อนถึงจะสามารถเข้าใช้งานระบบได้...");
                    }

                } else {
                    if (PasswordUserDay >= 75) {
                        PUtility.ShowMsg("Password ของท่านใช้งานมา " + IntFmt.format(PasswordUserDay) + " วัน แล้ว...กรุณาเปลี่ยน Password...");
                        ChangePassword frm = new ChangePassword(null, true);
                        frm.setVisible(true);
                        ProcessPass = true;

                    } else {
                        ProcessPass = true;
                    }
                }
                //********************************************************
                if (ProcessPass) {
                    UserLogin login = new UserLogin();
                    if (login.setActionMenu(loginname)) {
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "ไม่สามารถ Load สิทธิ์การใช้งานของผู้ใช้งานคนนี้ได้ ...");
                        clearlogin();
                    }
                }
            }
            rec.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Error Message", JOptionPane.ERROR_MESSAGE);
            clearlogin();
        }

    }

    public void keyboardcheck(java.awt.event.KeyEvent evt, String cpname) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (cpname.equals("c_loginname")) {
                c_loginpassword.requestFocus();
            } else if (cpname.equals("c_loginpassword")) {
                c_bntloginok.requestFocus();
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        userloginpanel = new javax.swing.JPanel();
        c_loginpassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        c_loginname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_bntloginok = new javax.swing.JButton();
        c_bntlogincancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Login Module (POS Control) UD201701010001");
        setBackground(new java.awt.Color(252, 251, 13));
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setModal(true);
        setName("loginfrom"); // NOI18N
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLayeredPane1.setBackground(new java.awt.Color(135, 176, 255));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jLayeredPane1.setOpaque(true);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LOGINBOR600.png"))); // NOI18N
        jLayeredPane1.add(jLabel8);
        jLabel8.setBounds(10, 10, 640, 380);
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(50, 70, 0, 0);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.PALETTE_LAYER);

        userloginpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        userloginpanel.setOpaque(false);

        c_loginpassword.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        c_loginpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                c_loginpasswordKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Password");

        c_loginname.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        c_loginname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                c_loginnameKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Username");

        c_bntloginok.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        c_bntloginok.setText("ตกลง (OK)");
        c_bntloginok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntloginokMouseClicked(evt);
            }
        });
        c_bntloginok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_bntloginokActionPerformed(evt);
            }
        });
        c_bntloginok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                c_bntloginokKeyPressed(evt);
            }
        });

        c_bntlogincancel.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        c_bntlogincancel.setText("Exit (ออก)");
        c_bntlogincancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_bntlogincancelActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(24, 24, 158));
        jButton1.setText("เปลี่ยนรหัสผ่าน (Change Password)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userloginpanelLayout = new javax.swing.GroupLayout(userloginpanel);
        userloginpanel.setLayout(userloginpanelLayout);
        userloginpanelLayout.setHorizontalGroup(
            userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userloginpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userloginpanelLayout.createSequentialGroup()
                        .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(1, 1, 1)
                        .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_loginname, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_loginpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_bntloginok, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(c_bntlogincancel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        userloginpanelLayout.setVerticalGroup(
            userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userloginpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_bntloginok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(userloginpanelLayout.createSequentialGroup()
                        .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_loginname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_loginpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_bntlogincancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLayeredPane1.add(userloginpanel);
        userloginpanel.setBounds(130, 130, 390, 140);
        jLayeredPane1.setLayer(userloginpanel, javax.swing.JLayeredPane.PALETTE_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel7)
                .addContainerGap(555, Short.MAX_VALUE))
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(660, 401));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void c_bntlogincancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_bntlogincancelActionPerformed

        System.exit(0);

    }//GEN-LAST:event_c_bntlogincancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    private void c_bntloginokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_bntloginokActionPerformed
}//GEN-LAST:event_c_bntloginokActionPerformed

    private void c_bntloginokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_bntloginokKeyPressed
        //System.out.println(evt) ;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            checkuserlogin();
        }
    }//GEN-LAST:event_c_bntloginokKeyPressed

    private void c_bntloginokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntloginokMouseClicked
        checkuserlogin();
    }//GEN-LAST:event_c_bntloginokMouseClicked

    private void c_loginnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_loginnameKeyPressed
        keyboardcheck(evt, "c_loginname");
    }//GEN-LAST:event_c_loginnameKeyPressed

    private void c_loginpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_loginpasswordKeyPressed
        keyboardcheck(evt, "c_loginpassword");
    }//GEN-LAST:event_c_loginpasswordKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        try {
//            Statement stmt = dbUtility.con.createStatement();
//            String SQLQuery = "select  *from branch";
//
//            ResultSet rec = stmt.executeQuery(SQLQuery);
//            rec.first();
//            if (rec.getRow() == 0) {
//                JOptionPane.showMessageDialog(this, "กรุณาป้อนรหัสสาขา (Branch Code) ก่อนการใช้งาน !!! ", "Data  Error !!!", JOptionPane.ERROR_MESSAGE);
//                rec.close();
//                System.exit(0);
//            } else {
//
//                String storename = rec.getString("code") + " - " + rec.getString("name");
//                
//                BranName = rec.getString("name");
//                BranCode = rec.getString("code");
//                rec.close();
//            }
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Error Message", JOptionPane.ERROR_MESSAGE);
//            System.exit(0);
//        }
    }//GEN-LAST:event_formWindowOpened

private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    c_loginname.requestFocus();
}//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ChangePassword frm = new ChangePassword(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                logincontrol dialog = new logincontrol(new javax.swing.JFrame(), true);

                // dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                //     @Override
                // public void windowClosing(java.awt.event.WindowEvent e) {
                //         System.exit(0);
                //     }
                // });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton c_bntlogincancel;
    private javax.swing.JButton c_bntloginok;
    private javax.swing.JTextField c_loginname;
    private javax.swing.JPasswordField c_loginpassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel userloginpanel;
    // End of variables declaration//GEN-END:variables

    class TimeOfDay implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
            SimpleDateFormat tf = new SimpleDateFormat("dd/MM/yyyy  (HH:mm:ss)", Locale.ENGLISH);
            String St = tf.format(new Date());

        }
    }
}
