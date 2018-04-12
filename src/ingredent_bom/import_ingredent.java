/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;

import dbutility.dbUtility;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author natee
 */
public class import_ingredent extends javax.swing.JDialog {

    /**
     * Creates new form import_ingredent
     */
    showMessage msn = new showMessage();
    formatDateNumber f = new formatDateNumber();
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public import_ingredent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        db.dbconnect();
        clearAll();
    }

    public class processThread extends Thread {

        String pcode = "";
        String pdesc = "";
        String pgroup = "";
        String punit1 = "";
        String psubunit = "";
        String fix = "L";
        Double pscale = 0.000;
        Double pacost = 0.000;
        String plastupdate = f.dateFmtSQL(f.nowDate());
        String plasttime = f.timeFmt(f.nowDate());
        String pathFile = "";

        public processThread(String pathFile) {
            this.pathFile = pathFile;
        }

        public void run() {
            txtArea.append("########## เริ่มการนำเข้าข้อมูล ##########\n");
            int count = 0;
            try {
                boolean eof = false;
                //                FileReader inFile = new FileReader(pathFile);
//                BufferedReader buff = new BufferedReader(inFile);
                File file = new File(pathFile);
                BufferedReader buff = new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream(file), "UTF8"));

                while (!eof) {
                    String line = buff.readLine();
                    if (line == null) {
                        eof = true;
                    } else {
                        if (!line.equals("")) {
                            count++;
                            String[] temp = line.split("\\t");
                            boolean done = false;
                            pcode = temp[0];
                            pdesc = temp[1];
                            pgroup = temp[2];
                            punit1 = temp[3];
                            psubunit = temp[4];
                            pscale = Double.parseDouble(f.convertDoubleString(temp[5]));
                            pacost = Double.parseDouble(f.convertDoubleString(temp[6]));

                            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                                try {
                                    String seekPcode = "select pcode,fix from product where pcode=?";
                                    PreparedStatement pre = dbUtility.con.prepareStatement(seekPcode);
                                    pre.setString(1, cvth.Unicode2ASCII(pcode));
                                    ResultSet rs = pre.executeQuery();
                                    rs.first();
                                    if (rs.getRow() != 0) {
                                        if (cvth.ASCII2Unicode(rs.getString("fix")).equalsIgnoreCase("l")) {
                                            updateProduct();
                                            done = true;
                                        }
                                    } else {
                                        insertProduct();
                                        done = true;
                                    }
                                    rs.close();
                                    pre.close();
                                    rs = null;
                                    pre = null;
                                } catch (Exception e) {
                                    msn.showMessageError("<html>เกิดข้อผิดพลาดบางประการ<br>" + e + "</html>");
                                    e.printStackTrace();
                                    return;
                                }
                            } else {
                                try {
                                    String seekPcode = "select pcode from product where pcode=?";
                                    PreparedStatement pre = dbUtility.con.prepareStatement(seekPcode);
                                    pre.setString(1, pcode);
                                    ResultSet rs = pre.executeQuery();
                                    rs.first();
                                    if (rs.getRow() != 0) {
                                        if (rs.getString("p.fix").equalsIgnoreCase("l")) {
                                            updateProduct();
                                            done = true;
                                        }
                                    } else {
                                        insertProduct();
                                        done = true;
                                    }
                                    rs.close();
                                    pre.close();
                                    rs = null;
                                    pre = null;
                                } catch (Exception e) {
                                    msn.showMessageError("<html>เกิดข้อผิดพลาดบางประการ<br>" + e + "</html>");
                                    e.printStackTrace();
                                    return;
                                }
                            }

                            if (done) {
                                txtArea.append("        รายการที่ " + count + "      " + pcode + "       " + pdesc + "\n");
                            }
                        }
                    }
                }
                buff.close();
                txtArea.append("########## จบการนำเข้าข้อมูล ##########\n");
                txt_path2file.requestFocus();
            } catch (Exception e) {
                msn.showMessageError("<html>เกิดข้อผิดพลาดบางประการ(Thread)<br>" + e + "</html>");
                e.printStackTrace();
                this.interrupt();
                return;
            }
            this.interrupt();
        }

        private void insertProduct() {
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                try {
                    String insPLU = "insert into product("
                            + "pcode,       pdesc,      pgroup,     punit1,"
                            + "psubunit,    pscale,     pacost,     fix,"
                            + "plastupdate, plasttime) values("
                            + "?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement preIns = dbUtility.con.prepareStatement(insPLU);
                    preIns.setString(1, cvth.Unicode2ASCII(pcode));
                    preIns.setString(2, cvth.Unicode2ASCII(pdesc));
                    preIns.setString(3, cvth.Unicode2ASCII(pgroup));
                    preIns.setString(4, cvth.Unicode2ASCII(punit1));
                    preIns.setString(5, cvth.Unicode2ASCII(psubunit));
                    preIns.setDouble(6, pscale);
                    preIns.setDouble(7, pacost);
                    preIns.setString(8, cvth.Unicode2ASCII(fix));
                    preIns.setString(9, cvth.Unicode2ASCII(plastupdate));
                    preIns.setString(10, cvth.Unicode2ASCII(plasttime));
                    preIns.executeUpdate();
                    preIns.close();
                    preIns = null;
                } catch (Exception e) {
                    msn.showMessageError("<html>เกิดข้อผิดพลาดบางประการ(insertProduct)<br>" + e + "</html>");
                    e.printStackTrace();
                    this.interrupt();
                    return;
                }
            } else {
                try {
                    String insPLU = "insert into product("
                            + "pcode,       pdesc,      pgroup,     punit1,"
                            + "psubunit,    pscale,     pacost,     fix,"
                            + "plastupdate, plasttime) values("
                            + "?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement preIns = dbUtility.con.prepareStatement(insPLU);
                    preIns.setString(1, (pcode));
                    preIns.setString(2, (pdesc));
                    preIns.setString(3, (pgroup));
                    preIns.setString(4, (punit1));
                    preIns.setString(5, (psubunit));
                    preIns.setDouble(6, pscale);
                    preIns.setDouble(7, pacost);
                    preIns.setString(8, (fix));
                    preIns.setString(9, (plastupdate));
                    preIns.setString(10, (plasttime));
                    preIns.executeUpdate();
                    preIns.close();
                    preIns = null;
                } catch (Exception e) {
                    msn.showMessageError("<html>เกิดข้อผิดพลาดบางประการ(insertProduct)<br>" + e + "</html>");
                    e.printStackTrace();
                    this.interrupt();
                    return;
                }
            }

        }

        private void updateProduct() {
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                try {
                    String updPLU = "update product set "
                            + "pdesc=?,     pgroup=?,   punit1=?,   psubunit=?,"
                            + "pscale=?,    pacost=?,   "
                            + "plastupdate=?,"
                            + "plasttime=? "
                            + "where pcode=?";
                    PreparedStatement preUpd = dbUtility.con.prepareStatement(updPLU);

                    preUpd.setString(1, cvth.Unicode2ASCII(pdesc));
                    preUpd.setString(2, cvth.Unicode2ASCII(pgroup));
                    preUpd.setString(3, cvth.Unicode2ASCII(punit1));
                    preUpd.setString(4, cvth.Unicode2ASCII(psubunit));
                    preUpd.setDouble(5, pscale);
                    preUpd.setDouble(6, pacost);
                    preUpd.setString(7, cvth.Unicode2ASCII(plastupdate));
                    preUpd.setString(8, cvth.Unicode2ASCII(plasttime));
                    preUpd.setString(9, cvth.Unicode2ASCII(pcode));
                    preUpd.executeUpdate();
                    preUpd.close();
                    preUpd = null;
                } catch (Exception e) {
                    msn.showMessageError("<html>เกิดข้อผิดพลาดบางประการ(updateProduct)<br>" + e + "</html>");
                    e.printStackTrace();
                    this.interrupt();
                    return;
                }
            } else {
                try {
                    String updPLU = "update product set "
                            + "pdesc=?,     pgroup=?,   punit1=?,   psubunit=?,"
                            + "pscale=?,    pacost=?,   "
                            + "plastupdate=?,"
                            + "plasttime=? "
                            + "where pcode=?";
                    PreparedStatement preUpd = dbUtility.con.prepareStatement(updPLU);

                    preUpd.setString(1, (pdesc));
                    preUpd.setString(2, (pgroup));
                    preUpd.setString(3, (punit1));
                    preUpd.setString(4, (psubunit));
                    preUpd.setDouble(5, pscale);
                    preUpd.setDouble(6, pacost);
                    preUpd.setString(7, (plastupdate));
                    preUpd.setString(8, (plasttime));
                    preUpd.setString(9, (pcode));
                    preUpd.executeUpdate();
                    preUpd.close();
                    preUpd = null;
                } catch (Exception e) {
                    msn.showMessageError("<html>เกิดข้อผิดพลาดบางประการ(updateProduct)<br>" + e + "</html>");
                    e.printStackTrace();
                    this.interrupt();
                    return;
                }
            }

        }
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
        jLabel1 = new javax.swing.JLabel();
        txt_path2file = new javax.swing.JTextField();
        btn_path2file = new javax.swing.JButton();
        btn_process = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("import Ingredent");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel1.setText("Text File");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        txt_path2file.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        txt_path2file.setText("txt_path2file");
        txt_path2file.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_path2fileFocusGained(evt);
            }
        });
        txt_path2file.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_path2fileKeyPressed(evt);
            }
        });
        jPanel1.add(txt_path2file, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 380, 30));

        btn_path2file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Folder-Open-icon .png"))); // NOI18N
        btn_path2file.setToolTipText("");
        btn_path2file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_path2fileActionPerformed(evt);
            }
        });
        jPanel1.add(btn_path2file, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 30, 30));

        btn_process.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btn_process.setText("F5-นำเข้าข้อมูล");
        btn_process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_processActionPerformed(evt);
            }
        });
        btn_process.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_processKeyPressed(evt);
            }
        });
        jPanel1.add(btn_process, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 150, 30));

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_path2fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_path2fileActionPerformed
        browsePathToFile();
    }//GEN-LAST:event_btn_path2fileActionPerformed

    private void txt_path2fileFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_path2fileFocusGained
        String data = txt_path2file.getText().trim();
        if (data.length() > 0) {
            txt_path2file.selectAll();
        } else {
            txt_path2file.setText("1");
            txt_path2file.selectAll();
            txt_path2file.setText("");
        }
    }//GEN-LAST:event_txt_path2fileFocusGained

    private void txt_path2fileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_path2fileKeyPressed
        String data = txt_path2file.getText().trim();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (data.length() <= 0) {
                return;
            }
            btn_process.setFocusable(true);
            btn_process.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (data.length() <= 0) {
                dispose();
            } else {
                txt_path2file.setText("");
                txt_path2file.requestFocus();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            browsePathToFile();
        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
            btnProcess();
        }
    }//GEN-LAST:event_txt_path2fileKeyPressed

    private void btn_processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_processActionPerformed
        btnProcess();
    }//GEN-LAST:event_btn_processActionPerformed

    private void btn_processKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_processKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!f.chkos.equalsIgnoreCase("linux")) {
                btnProcess();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txt_path2file.requestFocus();
        }
    }//GEN-LAST:event_btn_processKeyPressed

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
            java.util.logging.Logger.getLogger(import_ingredent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(import_ingredent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(import_ingredent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(import_ingredent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                import_ingredent dialog = new import_ingredent(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_path2file;
    private javax.swing.JButton btn_process;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txt_path2file;
    // End of variables declaration//GEN-END:variables

    private void browsePathToFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(null);
        File selectedPfile = chooser.getSelectedFile();
        try {
            txt_path2file.setText(selectedPfile.getCanonicalPath());
            txt_path2file.setFocusable(true);
            txt_path2file.requestFocus();
        } catch (IOException ex) {
            msn.showMessageError("เกิดข้อผิดพลาดบางประการ");
            ex.printStackTrace();
        }
    }

    private void clearAll() {
        txt_path2file.setText("");
        txt_path2file.setFocusable(true);
        txt_path2file.requestFocus();

        btn_path2file.setFocusable(false);
        btn_process.setFocusable(false);

        txtArea.removeAll();
        txtArea.setFocusable(false);
    }

    private void btnProcess() {
        String pathFile = txt_path2file.getText().trim();
        File file = new File(pathFile);
        if (!file.exists()) {
            msn.showMessageError("<html>ไม่พบไฟล์ที่ระบุ( " + pathFile + " )<br>กรุณาตรวจสอบ</html>");
            txt_path2file.requestFocus();
            return;
        }
        new processThread(pathFile).start();
    }
}
