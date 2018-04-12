package reportfile;

import borfunction.btnFind;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import masterfile.NimbusFrame;

public class VoidItem_Maindetail extends javax.swing.JDialog {

    SimpleDateFormat DateFmt = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    SimpleDateFormat consert = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    btnFind btn = new btnFind();
//    String condate01 = "", condate02 = "", bran1 = "", bran2 = "", area1 = "", area2 = "", cash1 = "", cash2 = "";

    public VoidItem_Maindetail(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtdate1.setText(DateFmt.format(date));
        txtdate2.setText(DateFmt.format(date));
    }
    String condate01 = "", condate02 = "", bran1 = "", bran2 = "", area1 = "", area2 = "", cash1 = "", cash2 = "", gradr1 = "", grade2 = "", otp1 = "", otp2 = "", dateshow1 = "", dateshow2 = "";

    public void setParamiter2() {
        try {
            Voiditem_Deailed vids = new Voiditem_Deailed();
            if (!txtdate1.getText().trim().equals("")) {
                String date1 = txtdate1.getText();
                vids.dateshow1 = date1;
                Date date001 = DateFmt.parse(date1);
                condate01 = consert.format(date001);
                vids.condate01 = condate01;
            } else {
                vids.condate01 = "";
            }
            if (!txtdate2.getText().trim().equals("")) {
                String date2 = txtdate2.getText();
                vids.dateshow2 = date2;
                Date date002 = DateFmt.parse(date2);
                condate02 = consert.format(date002);
                vids.condate02 = condate02;
            } else {
                vids.condate02 = "";
            }
            if (!txtbran1.getText().trim().equals("")) {
                vids.bran1 = txtbran1.getText();
            } else {
                vids.bran1 = "";
            }
            if (!txtbran2.getText().trim().equals("")) {
                vids.bran2 = txtbran2.getText();
            } else {
                vids.bran2 = "ZZZ";
            }
            if (!txtArea1.getText().trim().equals("")) {
                vids.area1 = txtArea1.getText();
            } else {
                vids.area1 = "";
            }
            if (!txtArea2.getText().trim().equals("")) {
                vids.area2 = txtArea2.getText();
            } else {
                vids.area2 = "ZZZ";
            }
            if (!txtGarde1.getText().trim().equals("")) {
                vids.gradr1 = txtGarde1.getText();
            } else {
                vids.gradr1 = "";
            }
            if (!txtGrade2.getText().trim().equals("")) {
                vids.grade2 = txtGrade2.getText();
            } else {
                vids.grade2 = "ZZZ";
            }
            if (!txtcash1.getText().trim().equals("")) {
                vids.cash1 = txtcash1.getText();
            } else {
                vids.cash1 = "";
            }
            if (!txtcash2.getText().trim().equals("")) {
                vids.cash2 = txtcash2.getText();
            } else {
                vids.cash2 = "ZZZZZ";
            }
            if (chkvALL.isSelected()) {
                vids.otp1 = "";
                vids.otp2 = "ZZZZ";
            } else if (chkOUT.isSelected()) {
                vids.otp1 = "0";
                vids.otp2 = "ZZZZ";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel19 = new javax.swing.JPanel();
        chkVoidAll = new javax.swing.JCheckBox();
        chkVoidOut = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        xb_h12 = new javax.swing.JLabel();
        d_h13 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtbran1 = new javax.swing.JTextField();
        txtbran2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        txtdate1 = new javax.swing.JFormattedTextField();
        cmddate1 = new javax.swing.JButton();
        txtdate2 = new javax.swing.JFormattedTextField();
        cmddate2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txtcash1 = new javax.swing.JTextField();
        txtcash2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        txtArea1 = new javax.swing.JTextField();
        txtArea2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        txtGarde1 = new javax.swing.JTextField();
        txtGrade2 = new javax.swing.JTextField();
        cmdGade1 = new javax.swing.JButton();
        cmdGrade2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmd_OKcoidItem = new javax.swing.JButton();
        cmd_exitVoidItem = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        chkvALL = new javax.swing.JRadioButton();
        chkOUT = new javax.swing.JRadioButton();

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chkVoidAll.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        chkVoidAll.setText("รายการvoid ทั้้งหมด");

        chkVoidOut.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        chkVoidOut.setText("รายการvoidเกินมาตราฐาน");

        jLabel1.setFont(new java.awt.Font("Norasi", 0, 16)); // NOI18N
        jLabel1.setText("รายการVoid");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkVoidAll)
                            .addComponent(chkVoidOut)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel1)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkVoidAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkVoidOut)
                .addGap(12, 12, 12))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel8.setLayout(null);

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        xb_h12.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        xb_h12.setText("รายงานการ Void(ใน) แบบละเอียด (Void Item Detail Report)");
        xb_h12.setName("lb_h1"); // NOI18N

        d_h13.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        d_h13.setText("(Void Item Detail)");
        d_h13.setName("d_h2"); // NOI18N

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel29)
                .addGap(28, 28, 28)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xb_h12)
                    .addComponent(d_h13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(xb_h12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(d_h13)
                        .addGap(0, 13, Short.MAX_VALUE))))
        );

        jPanel8.add(jPanel13);
        jPanel13.setBounds(6, 6, 758, 94);

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtbran1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbran1ActionPerformed(evt);
            }
        });
        txtbran1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbran1KeyPressed(evt);
            }
        });

        txtbran2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbran2ActionPerformed(evt);
            }
        });
        txtbran2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbran2KeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel6.setText("ถึงสาขา");

        jLabel4.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel4.setText("สาขา");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtbran1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbran2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbran1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbran2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtdate1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdate1ActionPerformed(evt);
            }
        });
        txtdate1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdate1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdate1KeyReleased(evt);
            }
        });

        cmddate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Date-and-Time-icon .png"))); // NOI18N
        cmddate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmddate1ActionPerformed(evt);
            }
        });

        txtdate2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdate2ActionPerformed(evt);
            }
        });
        txtdate2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdate2KeyPressed(evt);
            }
        });

        cmddate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Date-and-Time-icon .png"))); // NOI18N
        cmddate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmddate2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel5.setText("ถึงวันที่");

        jLabel2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel2.setText("วันที่");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmddate1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmddate2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmddate2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(cmddate1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        txtcash1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcash1KeyPressed(evt);
            }
        });

        txtcash2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcash2KeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel8.setText("ถึง");

        jLabel11.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel11.setText("แคชเชียร์");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcash1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcash2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcash2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcash1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        txtArea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArea1ActionPerformed(evt);
            }
        });
        txtArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArea1KeyPressed(evt);
            }
        });

        txtArea2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArea2KeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel7.setText("ถึงเขต");

        jLabel10.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel10.setText("เขต");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel23.setPreferredSize(new java.awt.Dimension(360, 60));

        txtGarde1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGarde1ActionPerformed(evt);
            }
        });
        txtGarde1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGarde1KeyPressed(evt);
            }
        });

        txtGrade2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGrade2MouseClicked(evt);
            }
        });
        txtGrade2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGrade2KeyPressed(evt);
            }
        });

        cmdGade1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        cmdGade1.setText("jButton1");
        cmdGade1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdGade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGade1ActionPerformed(evt);
            }
        });

        cmdGrade2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        cmdGrade2.setText("jButton2");
        cmdGrade2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdGrade2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGrade2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel9.setText("ถึงเกรด");

        jLabel12.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jLabel12.setText("เกรด");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtGarde1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdGade1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGrade2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdGrade2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGrade2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdGrade2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdGade1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGarde1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel8.add(jPanel14);
        jPanel14.setBounds(6, 112, 450, 350);

        cmd_OKcoidItem.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        cmd_OKcoidItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ok.png"))); // NOI18N
        cmd_OKcoidItem.setText("ตกลง (OK)");
        cmd_OKcoidItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_OKcoidItemActionPerformed(evt);
            }
        });
        cmd_OKcoidItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmd_OKcoidItemKeyPressed(evt);
            }
        });
        jPanel8.add(cmd_OKcoidItem);
        cmd_OKcoidItem.setBounds(460, 400, 150, 60);

        cmd_exitVoidItem.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        cmd_exitVoidItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LogOut-icon.png"))); // NOI18N
        cmd_exitVoidItem.setText("ออก (Exit)");
        cmd_exitVoidItem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cmd_exitVoidItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_exitVoidItemActionPerformed(evt);
            }
        });
        jPanel8.add(cmd_exitVoidItem);
        cmd_exitVoidItem.setBounds(610, 400, 150, 60);

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        jLabel3.setText("รายการ Void ");

        buttonGroup2.add(chkvALL);
        chkvALL.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        chkvALL.setSelected(true);
        chkvALL.setText("รายการ Void ทั้งหมด");

        buttonGroup2.add(chkOUT);
        chkOUT.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        chkOUT.setText("รายการ Void เกินมาตราฐาน");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(76, 76, 76))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkOUT)
                    .addComponent(chkvALL))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkvALL)
                .addGap(18, 18, 18)
                .addComponent(chkOUT)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel15);
        jPanel15.setBounds(460, 110, 310, 120);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_exitVoidItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_exitVoidItemActionPerformed
        dispose();
    }//GEN-LAST:event_cmd_exitVoidItemActionPerformed

    private void cmd_OKcoidItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_OKcoidItemActionPerformed

        setParamiter2();
        Voiditem_Deailed vids = new Voiditem_Deailed(new NimbusFrame(), true);
        vids.setVisible(true);


    }//GEN-LAST:event_cmd_OKcoidItemActionPerformed

    private void cmddate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmddate1ActionPerformed
        Point point = cmddate1.getLocationOnScreen();
        utilities.DateChooser.DateChooserDialog dcd = new utilities.DateChooser.DateChooserDialog(null, true, point);
        dcd.setVisible(true);
        txtdate1.setText(DateFmt.format(dcd.getSelectedDate().getTime()));
        txtdate2.requestFocus();
        partdate();
    }//GEN-LAST:event_cmddate1ActionPerformed

    private void cmddate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmddate2ActionPerformed
        Point point = cmddate2.getLocationOnScreen();
        utilities.DateChooser.DateChooserDialog dcd = new utilities.DateChooser.DateChooserDialog(null, true, point);
        dcd.setVisible(true);
        txtdate2.setText(DateFmt.format(dcd.getSelectedDate().getTime()));
        partdate();
    }//GEN-LAST:event_cmddate2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        btn.btnFindBranch(txtbran1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        btn.btnFindBranch(txtbran2);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        btn.btnFindBarea(txtArea1);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        btn.btnFindBarea(txtArea2);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtbran1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbran1ActionPerformed
//        bran1 = txtbran1.getText();
    }//GEN-LAST:event_txtbran1ActionPerformed

    private void txtbran2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbran2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbran2ActionPerformed

    private void txtdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdate1ActionPerformed
//        partdate();
    }//GEN-LAST:event_txtdate1ActionPerformed

    private void txtdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdate2ActionPerformed
//        partdate();
    }//GEN-LAST:event_txtdate2ActionPerformed

    private void txtArea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArea1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArea1ActionPerformed

    private void txtdate1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdate1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btncalendar(txtdate1, cmddate1);
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtdate2.requestFocus();
        }
    }//GEN-LAST:event_txtdate1KeyPressed

    private void txtdate1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdate1KeyReleased
//partdate();
    }//GEN-LAST:event_txtdate1KeyReleased

    private void cmdGade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGade1ActionPerformed
        btn.btnvoidconfig(txtGarde1);
    }//GEN-LAST:event_cmdGade1ActionPerformed

    private void cmdGrade2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGrade2ActionPerformed
        btn.btnvoidconfig(txtGrade2);
    }//GEN-LAST:event_cmdGrade2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        btn.btncashierNumber(txtcash1);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        btn.btncashierNumber(txtcash2);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtGarde1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGarde1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGarde1ActionPerformed

    private void txtdate2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdate2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btncalendar(txtdate2, cmddate2);
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtbran1.requestFocus();
        }
    }//GEN-LAST:event_txtdate2KeyPressed

    private void txtbran1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbran1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtbran2.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btnFindBranch(txtbran1);
        }
    }//GEN-LAST:event_txtbran1KeyPressed

    private void txtbran2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbran2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtArea1.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btnFindBranch(txtbran2);
        }
    }//GEN-LAST:event_txtbran2KeyPressed

    private void txtArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArea1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtArea2.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btnFindBarea(txtArea1);
        }
    }//GEN-LAST:event_txtArea1KeyPressed

    private void txtArea2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArea2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtcash1.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btnFindBarea(txtArea2);
        }
    }//GEN-LAST:event_txtArea2KeyPressed

    private void txtcash1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcash1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtcash2.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btncashierNumber(txtcash1);
        }
    }//GEN-LAST:event_txtcash1KeyPressed

    private void txtcash2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcash2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtGarde1.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btncashierNumber(txtcash2);
        }
    }//GEN-LAST:event_txtcash2KeyPressed

    private void txtGarde1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGarde1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtGrade2.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btnvoidconfig(txtGarde1);
        }
    }//GEN-LAST:event_txtGarde1KeyPressed

    private void txtGrade2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGrade2MouseClicked

    }//GEN-LAST:event_txtGrade2MouseClicked

    private void txtGrade2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrade2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtdate1.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btnvoidconfig(txtGrade2);
        }
    }//GEN-LAST:event_txtGrade2KeyPressed

    private void cmd_OKcoidItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmd_OKcoidItemKeyPressed
        
    }//GEN-LAST:event_cmd_OKcoidItemKeyPressed

    private void partdate() {
//        Date date = new Date();
        String date1 = txtdate1.getText().trim();
        String date2 = txtdate2.getText().trim();
        try {
            Date date001 = DateFmt.parse(date1);  // เปลี่ยน string วันที่ มาเป็น dd/MM/yyy
            condate01 = consert.format(date001); // เปลี่ยนจาก dd/MM/yyyy  >>>>>>>> yyyy/MM/dd
//            System.out.println(condate01);
            Date date002 = DateFmt.parse(date2);
            condate02 = consert.format(date002);
//            System.out.println(condate02);

        } catch (ParseException ex) {
            Logger.getLogger(VoidItem_Maindetail.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(VoidItem_Maindetail.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoidItem_Maindetail.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoidItem_Maindetail.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoidItem_Maindetail.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VoidItem_Maindetail dialog = new VoidItem_Maindetail(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton chkOUT;
    private javax.swing.JCheckBox chkVoidAll;
    private javax.swing.JCheckBox chkVoidOut;
    private javax.swing.JRadioButton chkvALL;
    private javax.swing.JButton cmdGade1;
    private javax.swing.JButton cmdGrade2;
    private javax.swing.JButton cmd_OKcoidItem;
    private javax.swing.JButton cmd_exitVoidItem;
    private javax.swing.JButton cmddate1;
    private javax.swing.JButton cmddate2;
    private javax.swing.JLabel d_h13;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField txtArea1;
    private javax.swing.JTextField txtArea2;
    private javax.swing.JTextField txtGarde1;
    private javax.swing.JTextField txtGrade2;
    private javax.swing.JTextField txtbran1;
    private javax.swing.JTextField txtbran2;
    private javax.swing.JTextField txtcash1;
    private javax.swing.JTextField txtcash2;
    private javax.swing.JFormattedTextField txtdate1;
    private javax.swing.JFormattedTextField txtdate2;
    private javax.swing.JLabel xb_h12;
    // End of variables declaration//GEN-END:variables
}
