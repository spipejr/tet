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
public class import_posbom extends javax.swing.JDialog {

    /**
     * Creates new form import_posbom
     */
    showMessage msn = new showMessage();
    formatDateNumber f = new formatDateNumber();
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public import_posbom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        db.dbconnect();
        clearAll();
    }

    public class processThread extends Thread {

        String pcode = "";
        String plcode = "";
        Double pqty = 0.000;
        String saletype = "";
        int formula = 0;
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
                            pcode = temp[0];
                            plcode = temp[1];
                            pqty = Double.parseDouble(f.convertDoubleString(temp[2]));
                            saletype = temp[3];
                            formula = Integer.parseInt(f.convertDoubleString(temp[4]));

                            try {
                                String sql = "select pcode, plcode from posbom where pcode=? and plcode=? and formula=?";
                                String sqlDel = "delete from posbom where pcode=? and plcode=? and formula=?";
                                String sqlIns = "insert into posbom(pcode, plcode, pqty, saletype, formula) values(?,?,?,?,?)";
                                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                                    PreparedStatement pre = dbUtility.con.prepareStatement(sql);
                                    pre.setString(1, cvth.Unicode2ASCII(pcode));
                                    pre.setString(2, cvth.Unicode2ASCII(plcode));
                                    pre.setInt(3, formula);
                                    ResultSet rs = pre.executeQuery();
                                    rs.first();
                                    if (rs.getRow() != 0) {
                                        PreparedStatement del = dbUtility.con.prepareStatement(sqlDel);
                                        del.setString(1, cvth.Unicode2ASCII(pcode));
                                        del.setString(2, cvth.Unicode2ASCII(plcode));
                                        del.setInt(3, formula);
                                        del.executeUpdate();
                                        del.close();
                                        del = null;
                                    }
                                    rs.close();
                                    pre.close();
                                    rs = null;
                                    pre = null;

                                    pre = dbUtility.con.prepareStatement(sqlIns);
                                    pre.setString(1, cvth.Unicode2ASCII(pcode));
                                    pre.setString(2, cvth.Unicode2ASCII(plcode));
                                    pre.setDouble(3, pqty);
                                    pre.setString(4, cvth.Unicode2ASCII(saletype));
                                    pre.setInt(5, formula);
                                    pre.executeUpdate();
                                    pre.close();
                                    pre = null;
                                } else {
                                    PreparedStatement pre = dbUtility.con.prepareStatement(sql);
                                    pre.setString(1, (pcode));
                                    pre.setString(2, (plcode));
                                    pre.setInt(3, formula);
                                    ResultSet rs = pre.executeQuery();
                                    rs.first();
                                    if (rs.getRow() != 0) {
                                        PreparedStatement del = dbUtility.con.prepareStatement(sqlDel);
                                        del.setString(1, (pcode));
                                        del.setString(2, (plcode));
                                        del.setInt(3, formula);
                                        del.executeUpdate();
                                        del.close();
                                        del = null;
                                    }
                                    rs.close();
                                    pre.close();
                                    rs = null;
                                    pre = null;

                                    pre = dbUtility.con.prepareStatement(sqlIns);
                                    pre.setString(1, (pcode));
                                    pre.setString(2, (plcode));
                                    pre.setDouble(3, pqty);
                                    pre.setString(4, (saletype));
                                    pre.setInt(5, formula);
                                    pre.executeUpdate();
                                    pre.close();
                                    pre = null;
                                }
                            } catch (Exception e) {
                                msn.showMessageError("<html>เกิดข้อผิดพลาดบางประการ<br>" + e + "</html>");
                                e.printStackTrace();
                                return;
                            }

                            txtArea.append("        รายการที่ " + count + "      " + pcode + "       " + plcode + "\n");
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
        setTitle("import POSBom");

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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
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

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-548)/2, (screenSize.height-508)/2, 548, 508);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btn_path2fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_path2fileActionPerformed
        browsePathToFile();
    }//GEN-LAST:event_btn_path2fileActionPerformed

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
            java.util.logging.Logger.getLogger(import_posbom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(import_posbom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(import_posbom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(import_posbom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                import_posbom dialog = new import_posbom(new javax.swing.JFrame(), true);
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
