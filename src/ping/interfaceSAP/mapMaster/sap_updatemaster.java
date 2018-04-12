/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.mapMaster;

import dbutility.dbUtility;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ping.interfaceSAP.entity.article;
import ping.interfaceSAP.entity.site;
import ping.interfaceSAP.showMessage;
import ping.interfaceSAP.utilitySAP;
import utilititiesfunction.UserLogin;

/**
 *
 * @author soneping
 */
public class sap_updatemaster extends javax.swing.JDialog {

    /**
     * Creates new form sap_updatemaster
     */
    PreparedStatement ps = null;
    ResultSet rs = null;
    //=================================
    dbUtility db = new dbUtility();
    utilitySAP us = new utilitySAP();
    article a = new article();
    site s = new site();
    String pathDir_article = "";
    ArrayList<String> listArticle = new ArrayList<String>();
    String pathDir_site = "";
    ArrayList<String> listSite = new ArrayList<String>();

    public sap_updatemaster(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        db.dbconnect();
        clearForm();
        loadBorpath();

        loadFileArticle();
        loadFileSite();

    }

    private void closePS(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
                ps = null;
            }
        } catch (Exception e) {
        }
    }

    private void closeRS(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception e) {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_Article = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_Site = new javax.swing.JTextArea();
        progressBar = new javax.swing.JProgressBar();
        btnExit = new javax.swing.JButton();
        btn_updatearticle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Update Master From SAP");

        jTabbedPane1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N

        txtArea_Article.setColumns(20);
        txtArea_Article.setRows(5);
        jScrollPane1.setViewportView(txtArea_Article);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Article Master", jPanel1);

        txtArea_Site.setColumns(20);
        txtArea_Site.setRows(5);
        jScrollPane2.setViewportView(txtArea_Site);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Site Master", jPanel2);

        btnExit.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btn_updatearticle.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btn_updatearticle.setText("Update Article Master");
        btn_updatearticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updatearticleActionPerformed(evt);
            }
        });
        btn_updatearticle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_updatearticleKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit))
                    .addComponent(btn_updatearticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_updatearticle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btn_updatearticleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_updatearticleKeyPressed
        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            btnExitActionPerformed(null);
        } else if (evt.getKeyCode() == evt.VK_F5) {

        }
    }//GEN-LAST:event_btn_updatearticleKeyPressed

    private void btn_updatearticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updatearticleActionPerformed
        new processMainThread().start();
    }//GEN-LAST:event_btn_updatearticleActionPerformed

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
            java.util.logging.Logger.getLogger(sap_updatemaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sap_updatemaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sap_updatemaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sap_updatemaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sap_updatemaster dialog = new sap_updatemaster(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btn_updatearticle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextArea txtArea_Article;
    private javax.swing.JTextArea txtArea_Site;
    // End of variables declaration//GEN-END:variables

    private void checkuserconfig() {
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getTran8().equals("1")) {
            btn_updatearticle.setEnabled(false);
        } else {
            btn_updatearticle.setEnabled(true);
        }
    }

    class processMainThread extends Thread {

        public processMainThread() {
            super();
        }

        public void run() {
            updateArticle();
            updateSite();
        }

        private void updateArticle() {
            jTabbedPane1.setSelectedIndex(0);
            for (int i = 0; i < listArticle.size(); i++) {
                String[] sp = listArticle.get(i).split("\\|\\|");
                String path2file = sp[0];
                String fileName = sp[1];
                String isBackup = sp[2];

                if (isBackup.equals("N")) {
                    progressBar.setIndeterminate(true);
                    progressBar.setString("Process : " + fileName);
                    a.readZRTINT02_Article(path2file, progressBar, txtArea_Article);
                    if (us.copyFileProcess(path2file, pathDir_article + "/backup_" + fileName)) {
                        File _file = new File(path2file);
                        if (_file.delete()) {
                        }
                    }
                    progressBar.setString("");
                }
            }
        }

        private void updateSite() {
            jTabbedPane1.setSelectedIndex(1);
            for (int i = 0; i < listSite.size(); i++) {
                String[] sp = listSite.get(i).split("\\|\\|");
                String path2file = sp[0];
                String fileName = sp[1];
                String isBackup = sp[2];

                if (isBackup.equals("N")) {
                    progressBar.setIndeterminate(true);
                    progressBar.setString("Process : " + fileName);
                    s.readZRTINT01_SiteMaster(path2file, progressBar, txtArea_Site);
                    if (us.copyFileProcess(path2file, pathDir_site + "/backup_" + fileName)) {
                        File _file = new File(path2file);
                        if (_file.delete()) {
                            System.out.println("isDelete");
                        }
                    }
                    progressBar.setString("");
                }
            }
        }
    }

    private void clearForm() {
        jTabbedPane1.setSelectedIndex(0);

        btn_updatearticle.setFocusable(true);
        btn_updatearticle.requestFocus();

        txtArea_Article.setText("");
        txtArea_Article.setFocusable(false);
        txtArea_Site.setText("");
        txtArea_Site.setFocusable(false);

        progressBar.setString("");
        progressBar.setStringPainted(true);
        progressBar.setMaximum(100);
        progressBar.setValue(0);
        checkuserconfig();
    }

    private void loadBorpath() {
        try {
            String sql = "select path_sap_article, path_sap_site from borpathsetup";
            ps = dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                pathDir_article = rs.getString("path_sap_article");
                pathDir_site = rs.getString("path_sap_site");
            }
        } catch (Exception e) {
            new showMessage().showMessageError(e.getMessage(), "loadBorpath");
            e.printStackTrace();
        } finally {
            closePS(ps);
            closeRS(rs);
        }
    }

    private void loadFileArticle() {
        try {
            File folder = new File(pathDir_article);
            File[] listOfFiles = folder.listFiles();
            if (listOfFiles != null) {
                if (listOfFiles.length > 0) {
                    for (int i = 0; i < listOfFiles.length; i++) {
                        String pathToFile = listOfFiles[i].getAbsoluteFile().toString();
                        String fileName = listOfFiles[i].getName();

                        if (fileName.indexOf(".xml") > 0 && fileName.substring(fileName.length() - 4, fileName.length()).equals(".xml")) {
                            String str = "";
                            String isBack = "N";
                            if (fileName.substring(0, 6).equalsIgnoreCase("backup")) {
                                isBack = "Y";
                            }
                            str = pathToFile + "||" + fileName + "||" + isBack;
                            listArticle.add(str);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFileSite() {
        try {
            File folder = new File(pathDir_site);
            File[] listOfFiles = folder.listFiles();
            if (listOfFiles != null) {
                if (listOfFiles.length > 0) {
                    for (int i = 0; i < listOfFiles.length; i++) {
                        String pathToFile = listOfFiles[i].getAbsoluteFile().toString();
                        String fileName = listOfFiles[i].getName();

                        if (fileName.indexOf(".xml") > 0 && fileName.substring(fileName.length() - 4, fileName.length()).equals(".xml")) {
                            String str = "";
                            String isBack = "N";
                            if (fileName.substring(0, 6).equalsIgnoreCase("backup")) {
                                isBack = "Y";
                            }
                            str = pathToFile + "||" + fileName + "||" + isBack;
                            listSite.add(str);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
