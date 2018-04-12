package masterfile;


import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import utilititiesfunction.PUtility;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChangePassword.java
 *
 * Created on Sep 5, 2010, 5:51:10 AM
 */
/**
 *
 * @author user
 */
public class ChangePassword extends javax.swing.JDialog {

    String password;
    String password1;
    String password2;
    static SimpleDateFormat Datefmt = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    static SimpleDateFormat DateTimefmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    static boolean ChangePasswordOK;
    dbUtility db = new dbUtility();

    /** Creates new form ChangePassword */
    public ChangePassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        db.dbconnect();
        ChangePasswordOK = false;
        clearlogin();
    }

    public void inputfrombnt(String str) {

        if (c_loginname.hasFocus()) {
            String tempstr = "";
            tempstr = c_loginname.getText();
            tempstr = tempstr + str;
            c_loginname.setText(tempstr);
        }
        if (c_loginpassword.hasFocus()) {
            char[] pass = c_loginpassword.getPassword();
            password = "";
            for (int i = 0; i < pass.length; i++) {
                password = password + pass[i];
            }
            password = password + str;
            c_loginpassword.setText(password);
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
                this.dispose();
            }
        }
    }

    public void clearlogin() {
        c_loginname.setText("");
        c_loginpassword.setText("");
        new_password1.setText("");
        new_password2.setText("");
        EmpName.setText("");
        password = "";
        password1 = "";
        password2 = "";
        c_loginname.requestFocus();
    }

    public void c_loginpasswordExit() {
        String loginname = c_loginname.getText();
        char[] pass = c_loginpassword.getPassword();
        password = "";
        for (int i = 0; i < pass.length; i++) {
            password = password + pass[i];
        }
        if (!password.equals("")) {
            if ((loginname.length() == 0) || (password.length() == 0)) {
                clearlogin();
                JOptionPane.showMessageDialog(this, "กรุณาป้อนรหัสผู้ใช้งาน(Username)/รหัสผ่าน(Password)", "Username/Password  Warning !!!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    Statement stmt = (Statement) dbUtility.con.createStatement();
                    String SQLQuery = "select  *from boruserlinux Where(username= '" + loginname + "') and (password='" + password + "')";

                    ResultSet rec = stmt.executeQuery(SQLQuery);
                    rec.first();
                    if (rec.getRow() == 0) {
                        clearlogin();
                        JOptionPane.showMessageDialog(this, "รหัสผู้ใช้งาน (Username) และรหัสผ่าน (Password) ไม่ถูกต้อง !!! ", "Username/Password  Error !!!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //EmpName.setText("ชื่อพนักงาน : " + rec.getString("name"));
                        new_password1.requestFocus();
                    }
                } catch (SQLException e) {
                    clearlogin();
                    JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void checkuserlogin() {
        String OnAct = "";
        String MacNoOnAct = "";
        String loginname = c_loginname.getText();
        char[] pass = c_loginpassword.getPassword();
        password = "";
        for (int i = 0; i < pass.length; i++) {
            password = password + pass[i];
        }
        if (!password1.equals("")) {
            if ((loginname.length() == 0) || (password.length() == 0)) {
                clearlogin();
                JOptionPane.showMessageDialog(this, "กรุณาป้อนรหัสผู้ใช้งาน(Username)/รหัสผ่าน(Password)", "Username/Password  Warning !!!", JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    Statement stmt = (Statement) dbUtility.con.createStatement();
                    String SQLQuery = "select  *from boruserlinux Where(username= '" + loginname + "') and (password='" + password + "')";

                    ResultSet rec = stmt.executeQuery(SQLQuery);
                    rec.first();
                    if (rec.getRow() == 0) {
                        clearlogin();
                        JOptionPane.showMessageDialog(this, "รหัสผู้ใช้งาน (Username) และรหัสผ่าน (Password) ไม่ถูกต้อง !!! ", "Username/Password  Error !!!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if ((password1.length() > 0) && (password1.equals(password2))) {
                            try {
                                // Insert Transection
                                Statement stmt2 = (Statement) dbUtility.con.createStatement();
                                String SQLQuery2 = "insert into boruserchange (changedate,usercode,newpassword,changetime) "
                                        + "values ('" + Datefmt.format(new Date()) + "','" + loginname + "','" + password1 + "','" + DateTimefmt.format(new Date()) + "')";
                                stmt2.executeUpdate(SQLQuery2);
                                stmt2.close();
                                //Update Change password
                                Statement stmt3 = (Statement) dbUtility.con.createStatement();
                                String SQLQuery3 = "update boruserlinux set password='"+password1+"',lastchangepassword='"+DateTimefmt.format(new Date())+"' where username='"+loginname+"' " ;
                                       
                                stmt3.executeUpdate(SQLQuery3);
                                stmt3.close();
                                
                                PUtility.ShowMsg("การเปลี่ยน password ใหม่ เรียบร้อยแล้ว ...");
                                ChangePasswordOK = true;
                            } catch (SQLException e) {
                                JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Error Message", JOptionPane.ERROR_MESSAGE);
                                clearlogin();
                            }
                            this.dispose();
                        } else {
                            PUtility.ShowMsg("ป้อน Password ใหม่ไม่ถูกต้อง..กรุณาป้อนใหม่...");
                            new_password1.setText("");
                            new_password2.setText("");
                            new_password1.requestFocus();
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "SQL Error Message", JOptionPane.ERROR_MESSAGE);
                    clearlogin();
                }

            }
        }
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
        calc = new javax.swing.JPanel();
        c_bnt7 = new javax.swing.JButton();
        c_bnt8 = new javax.swing.JButton();
        c_bnt9 = new javax.swing.JButton();
        c_bntplus = new javax.swing.JButton();
        c_bntbs = new javax.swing.JButton();
        c_bnt4 = new javax.swing.JButton();
        c_bnt5 = new javax.swing.JButton();
        c_bnt6 = new javax.swing.JButton();
        c_bntsub = new javax.swing.JButton();
        c_bntesc = new javax.swing.JButton();
        c_bnt1 = new javax.swing.JButton();
        c_bnt2 = new javax.swing.JButton();
        c_bnt3 = new javax.swing.JButton();
        c_bntmulti = new javax.swing.JButton();
        c_bntenter = new javax.swing.JButton();
        c_bnt0 = new javax.swing.JButton();
        c_bntdot = new javax.swing.JButton();
        c_bntclr = new javax.swing.JButton();
        c_bntsal = new javax.swing.JButton();
        loginpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_bntlogincancel = new javax.swing.JButton();
        userloginpanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        c_loginname = new javax.swing.JTextField();
        c_loginpassword = new javax.swing.JPasswordField();
        EmpName = new javax.swing.JLabel();
        c_bntloginok = new javax.swing.JButton();
        userloginpanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        new_password1 = new javax.swing.JPasswordField();
        new_password2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("หน้าจอการเปลี่ยนรหัสผ่าน (Password)");

        jPanel1.setBackground(new java.awt.Color(242, 20, 25));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        calc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        calc.setRequestFocusEnabled(false);
        calc.setVerifyInputWhenFocusTarget(false);
        calc.setLayout(new java.awt.GridLayout(4, 0));

        c_bnt7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bnt7.setText("7");
        c_bnt7.setFocusable(false);
        c_bnt7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bnt7MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bnt7MouseReleased(evt);
            }
        });
        calc.add(c_bnt7);

        c_bnt8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bnt8.setText("8");
        c_bnt8.setFocusable(false);
        c_bnt8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bnt8MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bnt8MouseReleased(evt);
            }
        });
        c_bnt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_bnt8ActionPerformed(evt);
            }
        });
        calc.add(c_bnt8);

        c_bnt9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bnt9.setText("9");
        c_bnt9.setFocusable(false);
        c_bnt9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bnt9MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bnt9MouseReleased(evt);
            }
        });
        calc.add(c_bnt9);

        c_bntplus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bntplus.setText("+");
        c_bntplus.setFocusable(false);
        c_bntplus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntplusMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bntplusMouseReleased(evt);
            }
        });
        calc.add(c_bntplus);

        c_bntbs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        c_bntbs.setText("<-BS");
        c_bntbs.setFocusable(false);
        c_bntbs.setMargin(new java.awt.Insets(1, 1, 1, 1));
        c_bntbs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntbsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bntbsMouseReleased(evt);
            }
        });
        calc.add(c_bntbs);

        c_bnt4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bnt4.setText("4");
        c_bnt4.setFocusable(false);
        c_bnt4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bnt4MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bnt4MouseReleased(evt);
            }
        });
        calc.add(c_bnt4);

        c_bnt5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bnt5.setText("5");
        c_bnt5.setFocusable(false);
        c_bnt5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bnt5MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bnt5MouseReleased(evt);
            }
        });
        calc.add(c_bnt5);

        c_bnt6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bnt6.setText("6");
        c_bnt6.setFocusable(false);
        c_bnt6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bnt6MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bnt6MouseReleased(evt);
            }
        });
        calc.add(c_bnt6);

        c_bntsub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bntsub.setText("-");
        c_bntsub.setFocusable(false);
        c_bntsub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntsubMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bntsubMouseReleased(evt);
            }
        });
        c_bntsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_bntsubActionPerformed(evt);
            }
        });
        calc.add(c_bntsub);

        c_bntesc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        c_bntesc.setText("ESC");
        c_bntesc.setFocusable(false);
        c_bntesc.setMargin(new java.awt.Insets(1, 1, 1, 1));
        c_bntesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntescMouseClicked(evt);
            }
        });
        calc.add(c_bntesc);

        c_bnt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bnt1.setText("1");
        c_bnt1.setFocusable(false);
        c_bnt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bnt1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bnt1MouseReleased(evt);
            }
        });
        calc.add(c_bnt1);

        c_bnt2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bnt2.setText("2");
        c_bnt2.setFocusable(false);
        c_bnt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bnt2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bnt2MouseReleased(evt);
            }
        });
        calc.add(c_bnt2);

        c_bnt3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bnt3.setText("3");
        c_bnt3.setFocusable(false);
        c_bnt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bnt3MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bnt3MouseReleased(evt);
            }
        });
        calc.add(c_bnt3);

        c_bntmulti.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bntmulti.setText("*");
        c_bntmulti.setFocusable(false);
        c_bntmulti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntmultiMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bntmultiMouseReleased(evt);
            }
        });
        calc.add(c_bntmulti);

        c_bntenter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        c_bntenter.setText("ENT");
        c_bntenter.setFocusable(false);
        c_bntenter.setMargin(new java.awt.Insets(1, 1, 1, 1));
        c_bntenter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntenterMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bntenterMouseReleased(evt);
            }
        });
        calc.add(c_bntenter);

        c_bnt0.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bnt0.setText("0");
        c_bnt0.setFocusable(false);
        c_bnt0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bnt0MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bnt0MouseReleased(evt);
            }
        });
        calc.add(c_bnt0);

        c_bntdot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bntdot.setText(".");
        c_bntdot.setFocusable(false);
        c_bntdot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntdotMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bntdotMouseReleased(evt);
            }
        });
        calc.add(c_bntdot);

        c_bntclr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bntclr.setText("CLR");
        c_bntclr.setFocusable(false);
        c_bntclr.setMargin(new java.awt.Insets(1, 1, 1, 1));
        c_bntclr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntclrMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bntclrMouseReleased(evt);
            }
        });
        calc.add(c_bntclr);

        c_bntsal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_bntsal.setText("/");
        c_bntsal.setFocusable(false);
        c_bntsal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntsalMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bntsalMouseReleased(evt);
            }
        });
        calc.add(c_bntsal);

        loginpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        loginpanel.setRequestFocusEnabled(false);
        loginpanel.setVerifyInputWhenFocusTarget(false);

        c_bntlogincancel.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        c_bntlogincancel.setText("Cancel");
        c_bntlogincancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_bntlogincancelActionPerformed(evt);
            }
        });

        userloginpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Century Schoolbook L", 0, 16)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Century Schoolbook L", 0, 16)); // NOI18N
        jLabel4.setText("Password");

        c_loginname.setFont(new java.awt.Font("Norasi", 0, 16)); // NOI18N
        c_loginname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                c_loginnameKeyPressed(evt);
            }
        });

        c_loginpassword.setFont(new java.awt.Font("Norasi", 0, 16)); // NOI18N
        c_loginpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_loginpasswordFocusLost(evt);
            }
        });
        c_loginpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                c_loginpasswordKeyPressed(evt);
            }
        });

        EmpName.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        EmpName.setText("ชื่อพนักงาน : นายสุรพล เอี่ยมประดิษฐ์");

        javax.swing.GroupLayout userloginpanelLayout = new javax.swing.GroupLayout(userloginpanel);
        userloginpanel.setLayout(userloginpanelLayout);
        userloginpanelLayout.setHorizontalGroup(
            userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userloginpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userloginpanelLayout.createSequentialGroup()
                        .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(userloginpanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(17, 17, 17))
                            .addGroup(userloginpanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_loginpassword)
                            .addComponent(c_loginname, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                    .addComponent(EmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userloginpanelLayout.setVerticalGroup(
            userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userloginpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_loginname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userloginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_loginpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        c_bntloginok.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        c_bntloginok.setText("OK");
        c_bntloginok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_bntloginokMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c_bntloginokMouseReleased(evt);
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

        userloginpanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(226, 13, 13));
        jLabel6.setText("Password ใหม่");

        jLabel7.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(226, 13, 13));
        jLabel7.setText("กด Password ใหม่อีกครั้ง");

        new_password1.setFont(new java.awt.Font("Norasi", 0, 16)); // NOI18N
        new_password1.setForeground(new java.awt.Color(230, 17, 17));
        new_password1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                new_password1KeyPressed(evt);
            }
        });

        new_password2.setFont(new java.awt.Font("Norasi", 0, 16)); // NOI18N
        new_password2.setForeground(new java.awt.Color(230, 17, 17));
        new_password2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                new_password2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout userloginpanel1Layout = new javax.swing.GroupLayout(userloginpanel1);
        userloginpanel1.setLayout(userloginpanel1Layout);
        userloginpanel1Layout.setHorizontalGroup(
            userloginpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userloginpanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userloginpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userloginpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(new_password2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(new_password1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        userloginpanel1Layout.setVerticalGroup(
            userloginpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userloginpanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userloginpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_password1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userloginpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_password2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(218, 17, 17));
        jLabel2.setText("ป้อน Password ใหม่ ของท่าน");

        jLabel5.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel5.setText("ป้อน Username และ Password เดิม ของท่าน");

        javax.swing.GroupLayout loginpanelLayout = new javax.swing.GroupLayout(loginpanel);
        loginpanel.setLayout(loginpanelLayout);
        loginpanelLayout.setHorizontalGroup(
            loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(loginpanelLayout.createSequentialGroup()
                        .addGroup(loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(userloginpanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, loginpanelLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(c_bntloginok, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_bntlogincancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(userloginpanel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1))))
        );
        loginpanelLayout.setVerticalGroup(
            loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginpanelLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addContainerGap(244, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(loginpanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(281, 281, 281))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginpanelLayout.createSequentialGroup()
                        .addComponent(userloginpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userloginpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_bntloginok, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_bntlogincancel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(calc, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(loginpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(calc, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-550)/2, (screenSize.height-643)/2, 550, 643);
    }// </editor-fold>//GEN-END:initComponents

    private void c_bnt7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt7MouseClicked
        //inputfrombnt("7") ;
}//GEN-LAST:event_c_bnt7MouseClicked

    private void c_bnt7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt7MouseReleased
        // TODO add your handling code here:
        inputfrombnt("7");
}//GEN-LAST:event_c_bnt7MouseReleased

    private void c_bnt8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt8MouseClicked
        //inputfrombnt("8") ;
}//GEN-LAST:event_c_bnt8MouseClicked

    private void c_bnt8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt8MouseReleased
        // TODO add your handling code here:
        inputfrombnt("8");
}//GEN-LAST:event_c_bnt8MouseReleased

    private void c_bnt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_bnt8ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_c_bnt8ActionPerformed

    private void c_bnt9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt9MouseClicked
        //inputfrombnt("9") ;
}//GEN-LAST:event_c_bnt9MouseClicked

    private void c_bnt9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt9MouseReleased
        // TODO add your handling code here:
        inputfrombnt("9");
}//GEN-LAST:event_c_bnt9MouseReleased

    private void c_bntplusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntplusMouseClicked
        //inputfrombnt("+") ;
}//GEN-LAST:event_c_bntplusMouseClicked

    private void c_bntplusMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntplusMouseReleased
        // TODO add your handling code here:
        inputfrombnt("+");
}//GEN-LAST:event_c_bntplusMouseReleased

    private void c_bntbsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntbsMouseClicked
}//GEN-LAST:event_c_bntbsMouseClicked

    private void c_bntbsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntbsMouseReleased
        if (c_loginname.hasFocus()) {
            String tempstr = "";
            String tempstr2 = "";
            tempstr = c_loginname.getText();
            for (int i = 0; i < tempstr.length() - 1; i++) {
                tempstr2 = tempstr2 + tempstr.charAt(i);
            }
            c_loginname.setText(tempstr2);
        }
        if (c_loginpassword.hasFocus()) {
            char[] pass = c_loginpassword.getPassword();
            password = "";
            for (int i = 0; i < pass.length - 1; i++) {
                password = password + pass[i];
            }
            c_loginpassword.setText(password);
        }
}//GEN-LAST:event_c_bntbsMouseReleased

    private void c_bnt4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt4MouseClicked
        //inputfrombnt("4") ;
}//GEN-LAST:event_c_bnt4MouseClicked

    private void c_bnt4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt4MouseReleased
        // TODO add your handling code here:
        inputfrombnt("4");
}//GEN-LAST:event_c_bnt4MouseReleased

    private void c_bnt5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt5MouseClicked
        //inputfrombnt("5") ;
}//GEN-LAST:event_c_bnt5MouseClicked

    private void c_bnt5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt5MouseReleased
        // TODO add your handling code here:
        inputfrombnt("5");
}//GEN-LAST:event_c_bnt5MouseReleased

    private void c_bnt6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt6MouseClicked
        //inputfrombnt("6") ;
}//GEN-LAST:event_c_bnt6MouseClicked

    private void c_bnt6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt6MouseReleased
        // TODO add your handling code here:
        inputfrombnt("6");
}//GEN-LAST:event_c_bnt6MouseReleased

    private void c_bntsubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntsubMouseClicked
        // inputfrombnt("-") ;
}//GEN-LAST:event_c_bntsubMouseClicked

    private void c_bntsubMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntsubMouseReleased
        // TODO add your handling code here:
        inputfrombnt("-");
}//GEN-LAST:event_c_bntsubMouseReleased

    private void c_bntsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_bntsubActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_c_bntsubActionPerformed

    private void c_bntescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntescMouseClicked
        this.dispose();
}//GEN-LAST:event_c_bntescMouseClicked

    private void c_bnt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt1MouseClicked
        // inputfrombnt("1") ;
}//GEN-LAST:event_c_bnt1MouseClicked

    private void c_bnt1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt1MouseReleased
        // TODO add your handling code here:
        inputfrombnt("1");
}//GEN-LAST:event_c_bnt1MouseReleased

    private void c_bnt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt2MouseClicked
        //inputfrombnt("2") ;
}//GEN-LAST:event_c_bnt2MouseClicked

    private void c_bnt2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt2MouseReleased
        // TODO add your handling code here:
        inputfrombnt("2");
}//GEN-LAST:event_c_bnt2MouseReleased

    private void c_bnt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt3MouseClicked
        //inputfrombnt("3") ;
}//GEN-LAST:event_c_bnt3MouseClicked

    private void c_bnt3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt3MouseReleased
        // TODO add your handling code here:
        inputfrombnt("3");
}//GEN-LAST:event_c_bnt3MouseReleased

    private void c_bntmultiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntmultiMouseClicked
        //inputfrombnt("*") ;
}//GEN-LAST:event_c_bntmultiMouseClicked

    private void c_bntmultiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntmultiMouseReleased
        // TODO add your handling code here:
        inputfrombnt("*");
}//GEN-LAST:event_c_bntmultiMouseReleased

    private void c_bntenterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntenterMouseClicked
}//GEN-LAST:event_c_bntenterMouseClicked

    private void c_bntenterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntenterMouseReleased
        if (c_loginname.hasFocus()) {
            c_loginpassword.requestFocus();
        }
        if (c_loginpassword.hasFocus()) {
            c_bntloginok.requestFocus();
        }
}//GEN-LAST:event_c_bntenterMouseReleased

    private void c_bnt0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt0MouseClicked
        //inputfrombnt("0") ;
}//GEN-LAST:event_c_bnt0MouseClicked

    private void c_bnt0MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bnt0MouseReleased
        inputfrombnt("0");
}//GEN-LAST:event_c_bnt0MouseReleased

    private void c_bntdotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntdotMouseClicked
        ///inputfrombnt(".") ;
}//GEN-LAST:event_c_bntdotMouseClicked

    private void c_bntdotMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntdotMouseReleased
        // TODO add your handling code here:
        inputfrombnt(".");
}//GEN-LAST:event_c_bntdotMouseReleased

    private void c_bntclrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntclrMouseClicked
}//GEN-LAST:event_c_bntclrMouseClicked

    private void c_bntclrMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntclrMouseReleased
        if (c_loginname.hasFocus()) {
            c_loginname.setText("");
        }
        if (c_loginpassword.hasFocus()) {
            c_loginpassword.setText("");
        }
}//GEN-LAST:event_c_bntclrMouseReleased

    private void c_bntsalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntsalMouseClicked
        //inputfrombnt("/") ;
}//GEN-LAST:event_c_bntsalMouseClicked

    private void c_bntsalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntsalMouseReleased
        // TODO add your handling code here:
        inputfrombnt("/");
}//GEN-LAST:event_c_bntsalMouseReleased

    private void c_bntlogincancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_bntlogincancelActionPerformed

        this.dispose();
    }//GEN-LAST:event_c_bntlogincancelActionPerformed

    private void c_loginnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_loginnameKeyPressed
        keyboardcheck(evt, "c_loginname");
}//GEN-LAST:event_c_loginnameKeyPressed

    private void c_loginpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_loginpasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            c_loginpasswordExit();
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                this.dispose();
            }
        }
}//GEN-LAST:event_c_loginpasswordKeyPressed

    private void c_bntloginokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntloginokMouseClicked
        //checkuserlogin();
}//GEN-LAST:event_c_bntloginokMouseClicked

    private void c_bntloginokMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_bntloginokMouseReleased
        // TODO add your handling code here:
        //checkuserlogin() ;
        char[] pass = c_loginpassword.getPassword();
        password = "";
        for (int i = 0; i < pass.length; i++) {
            password = password + pass[i];
        }
        pass = new_password1.getPassword();
        password1 = "";
        for (int i = 0; i < pass.length; i++) {
            password1 = password1 + pass[i];
        }
        pass = new_password2.getPassword();
        password2 = "";
        for (int i = 0; i < pass.length; i++) {
            password2 = password2 + pass[i];
        }
        if ((password.length() > 0) || (password1.length() > 0) || (password2.length() > 0)) {
            if (!password1.equals("")) {
                if (password1.equals(password)) {
                    PUtility.ShowMsg("กรุณาป้อน Password ใหม่ ให้แตกต่างจาก Password เดิม...");
                    new_password1.setText("");
                    new_password2.setText("");
                    new_password1.requestFocus();

                } else {
                    if (!password2.equals("")) {
                        if (password1.equals(password2)) {
                            checkuserlogin();
                        } else {
                            PUtility.ShowMsg("ป้อน Password ใหม่ไม่ถูกต้อง..กรุณาป้อนใหม่...");
                            new_password1.setText("");
                            new_password2.setText("");
                            new_password1.requestFocus();
                        }
                    } else {
                        PUtility.ShowMsg("ป้อน Password ใหม่ไม่ถูกต้อง..กรุณาป้อนใหม่...");
                        new_password1.setText("");
                        new_password2.setText("");
                        new_password1.requestFocus();
                    }
                }
            } else {
                PUtility.ShowMsg("ป้อน Password ใหม่ไม่ถูกต้อง..กรุณาป้อนใหม่...");
                new_password1.setText("");
                new_password2.setText("");
                new_password1.requestFocus();
            }
        } else {
            PUtility.ShowMsg("กรุณาป้อนข้อมูลการเปลี่ยน Username / Password ให้ถูกต้อง...");
        }
}//GEN-LAST:event_c_bntloginokMouseReleased

    private void c_bntloginokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_bntloginokActionPerformed
}//GEN-LAST:event_c_bntloginokActionPerformed

    private void c_bntloginokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_bntloginokKeyPressed
        //System.out.println(evt) ;
        // if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        //     checkuserlogin();
        // }
}//GEN-LAST:event_c_bntloginokKeyPressed

    private void new_password1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_new_password1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            char[] pass = new_password1.getPassword();
            password1 = "";
            for (int i = 0; i < pass.length; i++) {
                password1 = password1 + pass[i];
            }
            if (!password1.equals("")) {
                if (password1.equals(password)) {
                    PUtility.ShowMsg("กรุณาป้อน Password ใหม่ ให้แตกต่างจาก Password เดิม...");
                    new_password1.setText("");
                    new_password1.requestFocus();
                } else {
                    new_password2.requestFocus();
                }
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                this.dispose();
            }

        }

    }//GEN-LAST:event_new_password1KeyPressed

    private void new_password2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_new_password2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            char[] pass = c_loginpassword.getPassword();
            password = "";
            for (int i = 0; i < pass.length; i++) {
                password = password + pass[i];
            }
            pass = new_password1.getPassword();
            password1 = "";
            for (int i = 0; i < pass.length; i++) {
                password1 = password1 + pass[i];
            }
            pass = new_password2.getPassword();
            password2 = "";
            for (int i = 0; i < pass.length; i++) {
                password2 = password2 + pass[i];
            }
            if ((password.length() > 0) || (password1.length() > 0) || (password2.length() > 0)) {
                if (!password1.equals("")) {
                    if (password1.equals(password)) {
                        PUtility.ShowMsg("กรุณาป้อน Password ใหม่ ให้แตกต่างจาก Password เดิม...");
                        new_password1.setText("");
                        new_password2.setText("");
                        new_password1.requestFocus();

                    } else {
                        if (!password2.equals("")) {
                            if (password1.equals(password2)) {
                                checkuserlogin();
                            } else {
                                PUtility.ShowMsg("ป้อน Password ใหม่ไม่ถูกต้อง..กรุณาป้อนใหม่...");
                                new_password1.setText("");
                                new_password2.setText("");
                                new_password1.requestFocus();
                            }
                        } else {
                            PUtility.ShowMsg("ป้อน Password ใหม่ไม่ถูกต้อง..กรุณาป้อนใหม่...");
                            new_password1.setText("");
                            new_password2.setText("");
                            new_password1.requestFocus();
                        }
                    }
                } else {
                    PUtility.ShowMsg("ป้อน Password ใหม่ไม่ถูกต้อง..กรุณาป้อนใหม่...");
                    new_password1.setText("");
                    new_password2.setText("");
                    new_password1.requestFocus();
                }
            } else {
                PUtility.ShowMsg("กรุณาป้อนข้อมูลการเปลี่ยน Username / Password ให้ถูกต้อง...");
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                this.dispose();
            }
        }

    }//GEN-LAST:event_new_password2KeyPressed

    private void c_loginpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_loginpasswordFocusLost
        // TODO add your handling code here:
        c_loginpasswordExit();

    }//GEN-LAST:event_c_loginpasswordFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ChangePassword dialog = new ChangePassword(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        //System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmpName;
    private javax.swing.JButton c_bnt0;
    private javax.swing.JButton c_bnt1;
    private javax.swing.JButton c_bnt2;
    private javax.swing.JButton c_bnt3;
    private javax.swing.JButton c_bnt4;
    private javax.swing.JButton c_bnt5;
    private javax.swing.JButton c_bnt6;
    private javax.swing.JButton c_bnt7;
    private javax.swing.JButton c_bnt8;
    private javax.swing.JButton c_bnt9;
    private javax.swing.JButton c_bntbs;
    private javax.swing.JButton c_bntclr;
    private javax.swing.JButton c_bntdot;
    private javax.swing.JButton c_bntenter;
    private javax.swing.JButton c_bntesc;
    private javax.swing.JButton c_bntlogincancel;
    private javax.swing.JButton c_bntloginok;
    private javax.swing.JButton c_bntmulti;
    private javax.swing.JButton c_bntplus;
    private javax.swing.JButton c_bntsal;
    private javax.swing.JButton c_bntsub;
    private javax.swing.JTextField c_loginname;
    private javax.swing.JPasswordField c_loginpassword;
    private javax.swing.JPanel calc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel loginpanel;
    private javax.swing.JPasswordField new_password1;
    private javax.swing.JPasswordField new_password2;
    private javax.swing.JPanel userloginpanel;
    private javax.swing.JPanel userloginpanel1;
    // End of variables declaration//GEN-END:variables
}
