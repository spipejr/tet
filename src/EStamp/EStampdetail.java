package EStamp;

import EStamp.EStampReport.Report_ES;
import borfunction.GetApplicationName;
import borfunction.GetUser;
import borfunction.btnFind;
import dbutility.dbUtility;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import jxl.write.WriteException;
import masterfile.logincontrol;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor;
import report.Report;
import utilities.DateChooser.DateUtil;
import utilititiesfunction.Export2Excel;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;
import utilititiesfunction.UserLogin;
import utilititiesfunction.getLanguage;

public class EStampdetail extends javax.swing.JDialog {

    PreparedStatement pre = null;
    PreparedStatement preUp = null;
    ResultSet rs = null;
    showMessage msn = new showMessage();
    btnFind btn = new btnFind();

    String refCode = ""; //brarchcode+macno
    String _date = "";
    String Macno = "";

    dbUtility db = new dbUtility();

    String Seek = "";

    public EStampdetail(java.awt.Frame parent, boolean modal, String refCode) {
        super(parent, modal);
        initComponents();
        this.refCode = refCode;
        clearForm();
        UserLogin userrec = UserLogin.userlogin;
        Macno = userrec.getUserName();
    }

    private void btnSearch() {
        resetTable();
        if (txtBarcode.getText().equals("")) {
            msn.showMessageWarning("กรุณาระบุรหัสบัตร E-Stamp ที่ต้องการตรวจสอบ ...");
            txtBarcode.requestFocus();
            return;
        }

        if (txt_date1.getText().equals("")) {
            msn.showMessageWarning("กรุณาระบุช่วงวันที่ที่ต้องการตรวจสอบ ...");
            txt_date1.requestFocus();
            return;
        }

        if (txt_date2.getText().equals("")) {
            msn.showMessageWarning("กรุณาระบุช่วงวันที่ที่ต้องการตรวจสอบ ...");
            txt_date2.requestFocus();
            return;
        }
        getData(txtBarcode.getText().trim());
        ProcessSearch();
    }

    private void getData(String bracode) {
        try {
            String sql = "select *from stampbarcode where stamp_barcode='" + bracode + "' ";
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                    lbl_Custname.setText(cvth.ASCII2Unicode(rs.getString("stamp_custname")));
                    lbl_tel.setText(cvth.ASCII2Unicode(rs.getString("stamp_phone")));
                } else {
                    lbl_Custname.setText(rs.getString("stamp_custname"));
                    lbl_tel.setText(rs.getString("stamp_phone"));
                }
            } else {
                lbl_Custname.setText("");
                lbl_tel.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msn.showMessageError(e.getMessage());
        }
    }

    private void ProcessExcelFile() {
        Export2Excel test = new Export2Excel();
        JFileChooser chooser = new JFileChooser();
        File f;

        String condition = "รายงานตรวจสอบการใช้งานของรหัสบัตร E-Stamp : " + txtBarcode.getText().trim()
                + " ตั้งแต่วันที่ " + txt_date1.getText() + " ถึง " + txt_date2.getText();
        String alert_save = "มีไฟล์ข้อมูลชื่อนี้อยู่แล้ว คุณต้องการบันทึกรายการนี้หรือไม่...?";
        try {
            f = new File(new File("estampdetail.xls").getCanonicalPath());
            chooser.setSelectedFile(f);
            chooser.setFileFilter(new JRSingleSheetXlsSaveContributor(Locale.ENGLISH, null));
            int confirm2 = chooser.showSaveDialog(this);
            if (confirm2 == JFileChooser.APPROVE_OPTION) {

                File curFile = chooser.getSelectedFile();

                if (curFile.exists()) {
                    int confirm = msn.showMessageConfirm("Yes", "No", alert_save);
                    if (confirm == 1) {
                        return;
                    } else {
                        try {
                            test.setOutputFile(curFile.toString());
                            test.writetableNoSum(tblShow, tblShow.getColumnModel(), condition);
                            msn.showMessageInformation("บันทึกข้อมูลเรียบร้อบแล้ว");
                        } catch (IOException ex) {
                        } catch (WriteException ex) {
                        }
                    }
                } else {
                    try {
                        test.setOutputFile(curFile.toString());
                        test.writetableNoSum(tblShow, tblShow.getColumnModel(), condition);
                        msn.showMessageInformation("บันทึกข้อมูลเรียบร้อบแล้ว");
                    } catch (IOException ex) {
                    } catch (WriteException ex) {
                    }
                }
            }
        } catch (IOException e) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblShow = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtBarcode = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtBranch1 = new javax.swing.JTextField();
        btnDate4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtBranch2 = new javax.swing.JTextField();
        btnDate3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txt_date1 = new javax.swing.JTextField();
        txt_date2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnDate1 = new javax.swing.JButton();
        btnDate2 = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl_Custname = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_tel = new javax.swing.JLabel();
        btnExcel = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ตรวจสอบบัตร E-Stamp");

        tblShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ประเภท", "แคมเปญ", "โปรโมชั่น", "สาขาที่ทำรายการ", "วันที่", "เวลา", "เลขที่บิล", "คะแนน", "พนักงาน", "เลขเครื่อง", "ยกเลิกบิล", "สาขาที่ยกเลิก", "วันที่", "เวลา", "พนักงานที่ยกเลิก", "เลขเครื่อง"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblShow);
        if (tblShow.getColumnModel().getColumnCount() > 0) {
            tblShow.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblShow.getColumnModel().getColumn(1).setPreferredWidth(210);
            tblShow.getColumnModel().getColumn(2).setPreferredWidth(210);
            tblShow.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblShow.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblShow.getColumnModel().getColumn(5).setPreferredWidth(65);
            tblShow.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblShow.getColumnModel().getColumn(7).setPreferredWidth(80);
            tblShow.getColumnModel().getColumn(8).setPreferredWidth(70);
            tblShow.getColumnModel().getColumn(9).setPreferredWidth(70);
            tblShow.getColumnModel().getColumn(10).setPreferredWidth(60);
            tblShow.getColumnModel().getColumn(11).setPreferredWidth(150);
            tblShow.getColumnModel().getColumn(12).setPreferredWidth(80);
            tblShow.getColumnModel().getColumn(13).setPreferredWidth(65);
            tblShow.getColumnModel().getColumn(14).setPreferredWidth(70);
            tblShow.getColumnModel().getColumn(15).setPreferredWidth(70);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "E-Stamp Barcode ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Norasi", 1, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBarcode.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        txtBarcode.setText("txtBarcode");
        txtBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarcodeActionPerformed(evt);
            }
        });
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyPressed(evt);
            }
        });
        jPanel4.add(txtBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 150, 90));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ช่วงสาขา", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Norasi", 1, 14))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBranch1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        txtBranch1.setText("txtBranch1");
        txtBranch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBranch1ActionPerformed(evt);
            }
        });
        txtBranch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBranch1KeyPressed(evt);
            }
        });
        jPanel5.add(txtBranch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, 30));

        btnDate4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        btnDate4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDate4ActionPerformed(evt);
            }
        });
        jPanel5.add(btnDate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 34, 30));

        jLabel4.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ถึง");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 30, 30));

        txtBranch2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        txtBranch2.setText("txtBranch2");
        txtBranch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBranch2ActionPerformed(evt);
            }
        });
        txtBranch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBranch2KeyPressed(evt);
            }
        });
        jPanel5.add(txtBranch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 50, 30));

        btnDate3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Windows-Magnifier-icon.png"))); // NOI18N
        btnDate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDate3ActionPerformed(evt);
            }
        });
        jPanel5.add(btnDate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 34, 30));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 5, 240, 90));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ช่วงวันที่", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Norasi", 1, 14))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_date1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        txt_date1.setText("txt_date1");
        txt_date1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date1KeyPressed(evt);
            }
        });
        jPanel6.add(txt_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, 30));

        txt_date2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        txt_date2.setText("txt_date2");
        txt_date2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date2KeyPressed(evt);
            }
        });
        jPanel6.add(txt_date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 90, 30));

        jLabel9.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ถึง");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 40, 30));

        btnDate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Date-and-Time-icon .png"))); // NOI18N
        btnDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDate1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 34, 30));

        btnDate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Date-and-Time-icon .png"))); // NOI18N
        btnDate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDate2ActionPerformed(evt);
            }
        });
        jPanel6.add(btnDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 34, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 5, 320, 90));

        btnSearch.setFont(new java.awt.Font("Norasi", 1, 15)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Hourglass-icon.png"))); // NOI18N
        btnSearch.setText("ประมวลผล");
        btnSearch.setIconTextGap(10);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel3.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 15, 180, 45));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Norasi", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel6.setText("ชื่อลูกค้า :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 12, 70, 25));

        lbl_Custname.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lbl_Custname.setText("lbl_Custname");
        jPanel2.add(lbl_Custname, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 12, 203, 25));

        jLabel7.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("เบอร์โทร :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 12, 75, 25));

        lbl_tel.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        lbl_tel.setText("lbl_tel");
        jPanel2.add(lbl_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 12, 250, 25));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 720, 50));

        btnExcel.setFont(new java.awt.Font("Norasi", 1, 15)); // NOI18N
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Excel-icon.png"))); // NOI18N
        btnExcel.setText("Excel File");
        btnExcel.setIconTextGap(10);
        btnExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });
        jPanel3.add(btnExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 62, 180, 45));

        btnPrint.setFont(new java.awt.Font("Norasi", 1, 15)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Printer-icon.png"))); // NOI18N
        btnPrint.setText("พิมพ์");
        btnPrint.setIconTextGap(15);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 109, 180, 45));

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1010, 745));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        ProcessExcelFile();
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        btnSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (!txtBarcode.getText().trim().equals("")) {
                txtBranch1.requestFocus();
            } else {
                msn.showMessageWarning("กรุณาระบุ E-Stamp Barcode ที่ต้องการค้นหา ...");
                txtBarcode.requestFocus();
            }
        }
    }//GEN-LAST:event_txtBarcodeKeyPressed

    private void btnDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDate1ActionPerformed
        DateUtil.showDateChooserDialog(txt_date1, btnDate1);
        txt_date1.requestFocus();
    }//GEN-LAST:event_btnDate1ActionPerformed

    private void btnDate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDate2ActionPerformed
        DateUtil.showDateChooserDialog(txt_date2, btnDate2);
        txt_date2.requestFocus();
    }//GEN-LAST:event_btnDate2ActionPerformed

    private void txtBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarcodeActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
//        ProcessPrint();
        ProcessPrintBean();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtBranch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBranch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBranch2ActionPerformed

    private void txtBranch2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBranch2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_date1.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btnFindBranch(txtBranch2);
        }
    }//GEN-LAST:event_txtBranch2KeyPressed

    private void btnDate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDate3ActionPerformed
        btn.btnFindBranch(txtBranch2);
    }//GEN-LAST:event_btnDate3ActionPerformed

    private void txtBranch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBranch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBranch1ActionPerformed

    private void txtBranch1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBranch1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtBranch2.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            btn.btnFindBranch(txtBranch1);
        }
    }//GEN-LAST:event_txtBranch1KeyPressed

    private void btnDate4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDate4ActionPerformed
        btn.btnFindBranch(txtBranch1);
    }//GEN-LAST:event_btnDate4ActionPerformed

    private void txt_date1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_date2.requestFocus();
        }
    }//GEN-LAST:event_txt_date1KeyPressed

    private void txt_date2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSearch.requestFocus();
        }
    }//GEN-LAST:event_txt_date2KeyPressed

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
            java.util.logging.Logger.getLogger(EStampdetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EStampdetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EStampdetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EStampdetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EStampdetail dialog = new EStampdetail(new javax.swing.JFrame(), true, "");
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
    private javax.swing.JButton btnDate1;
    private javax.swing.JButton btnDate2;
    private javax.swing.JButton btnDate3;
    private javax.swing.JButton btnDate4;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Custname;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JTable tblShow;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtBranch1;
    private javax.swing.JTextField txtBranch2;
    private javax.swing.JTextField txt_date1;
    private javax.swing.JTextField txt_date2;
    // End of variables declaration//GEN-END:variables

    ThaiUtilities cvth = new ThaiUtilities();

    private void ProcessSearch() {
        txtBarcode.setFocusable(false);
        resetTable();
        String Barcode = txtBarcode.getText().trim();

        String type = "";
        String campaign = "";
        String promotion = "";
        String branch = "";
        String useDate = "";
        String useTime = "";
        String useBillno = "";
        double usePoint = 0;
        String useMacno = "";
        String useCashier = "";
        String Void = "";
        String VoidBranch = "";
        String VoidDate = "";
        String VoidTime = "";
        String VoidCashier = "";
        String VoidMacno = "";

        String dateFrom = "";
        String dateTo = "";
        String branchFrom = txtBranch1.getText();
        String branchTo = txtBranch2.getText();
        try {
            if (!txt_date1.getText().equals("")) {
                Date dd1 = Format.dateFmtShow.parse(txt_date1.getText());
                dateFrom = Format.dateFmtSql.format(dd1);
            } else {
                dateFrom = "1900-01-01";
            }

            if (!txt_date1.getText().equals("")) {
                Date dd2 = Format.dateFmtShow.parse(txt_date2.getText());
                dateTo = Format.dateFmtSql.format(dd2);
            } else {
                dateTo = "3000-01-01";
            }

            if (branchTo.equals("")) {
                branchTo = "ZZZ";
            }

            Seek = "select * from stamptran st "
                    + "left join stampcampaign sc on st.stamp_campaign = sc.s_campaigncode "
                    //                    + "left join stamppromotion sp on st.stamp_campaign = sp.sp_campaign and st.stamp_promotion "
                    //                    + "left join stampredeem sd on st.stamp_campaign = sd.sr_campaign and st.stamp_promotion "
                    + "left join branfile b on st.use_branch = b.code "
                    + "left join branfile bv on st.void_branch = bv.code "
                    + "where  stamp_barcode='" + Barcode + "' "
                    + "and use_branch >='" + branchFrom + "' and use_branch <='" + branchTo + "' "
                    + "and use_date >='" + dateFrom + "' and use_date <='" + dateTo + "' "
                    + "order by use_date, use_time";

            System.out.println("Seek //" + Seek);
            pre = dbUtility.con.prepareStatement(Seek);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                        campaign = cvth.ASCII2Unicode(rs.getString("st.stamp_campaign")) + " - " + cvth.ASCII2Unicode(rs.getString("sc.s_campaignname"));
                        branch = cvth.ASCII2Unicode(rs.getString("st.use_branch")) + " - " + cvth.ASCII2Unicode(rs.getString("b.name"));
                        useDate = Format.dateFmtShow.format(rs.getDate("st.use_date"));
                        useTime = rs.getString("st.use_time");
                        useBillno = rs.getString("st.use_billno");
                        useMacno = rs.getString("st.use_macno");
                        useCashier = rs.getString("st.use_cashier");
                        Void = rs.getString("st.void_bill");

                        if (rs.getInt("st.stamp_point") > 0) {
                            type = "Point";
                            usePoint = rs.getInt("stamp_point");
                            promotion = cvth.ASCII2Unicode(rs.getString("st.stamp_promotion")) + " - "
                                    + cvth.ASCII2Unicode(getNamePromotion(rs.getString("st.stamp_promotion"), rs.getString("st.stamp_campaign")));
                        } else {
                            type = "Redeem";
                            usePoint = rs.getDouble("st.stamp_redeem");
                            promotion = cvth.ASCII2Unicode(rs.getString("st.stamp_promotion")) + " - "
                                    + cvth.ASCII2Unicode(getNameProRedeem(rs.getString("st.stamp_promotion"), rs.getString("st.stamp_campaign")));
                        }

                        if (Void.equals("Y")) {
                            VoidBranch = cvth.ASCII2Unicode(rs.getString("st.void_branch")) + " - " + cvth.ASCII2Unicode(rs.getString("bv.name"));
                            VoidDate = Format.dateFmtShow.format(rs.getDate("st.void_date"));
                            VoidTime = rs.getString("st.void_time");
                            VoidCashier = rs.getString("st.void_cashier");
                            VoidMacno = rs.getString("st.void_macno");
                        } else {
                            VoidBranch = "";
                            VoidDate = "";
                            VoidTime = "";
                            VoidCashier = "";
                            VoidMacno = "";
                        }
                    } else {
                        campaign = rs.getString("stamp_campaign") + " - " + rs.getString("stamp_campaign");
                        branch = rs.getString("st.use_branch") + " - " + rs.getString("b.name");
                        useDate = Format.dateFmtShow.format(rs.getDate("st.use_date"));
                        useTime = rs.getString("st.use_time");
                        useBillno = rs.getString("st.use_billno");
                        useMacno = rs.getString("st.use_macno");
                        useCashier = rs.getString("st.use_cashier");

                        if (rs.getInt("stamp_point") > 0) {
                            type = "Point";
                            usePoint = rs.getInt("stamp_point");
                            promotion = rs.getString("st.stamp_promotion") + " - "
                                    + getNamePromotion(rs.getString("st.stamp_promotion"), rs.getString("st.stamp_campaign"));
                        } else {
                            type = "Redeem";
                            usePoint = rs.getDouble("stamp_redeem");
                            promotion = rs.getString("st.stamp_promotion") + " - "
                                    + getNameProRedeem(rs.getString("st.stamp_promotion"), rs.getString("st.stamp_campaign"));
                        }
                        if (Void.equals("Y")) {
                            VoidBranch = rs.getString("st.void_branch") + " - " + rs.getString("bv.name");
                            VoidDate = Format.dateFmtShow.format(rs.getDate("st.void_date"));
                            VoidTime = rs.getString("st.void_time");
                            VoidCashier = rs.getString("st.void_cashier");
                            VoidMacno = rs.getString("st.void_macno");
                        } else {
                            VoidBranch = "";
                            VoidDate = "";
                            VoidTime = "";
                            VoidCashier = "";
                            VoidMacno = "";
                        }
                    }

                    model.addRow(new Object[]{
                        type,
                        campaign,
                        promotion,
                        branch,
                        useDate,
                        useTime,
                        useBillno,
                        usePoint,
                        useCashier,
                        useMacno,
                        Void,
                        VoidBranch,
                        VoidDate,
                        VoidTime,
                        VoidCashier,
                        VoidMacno
                    });

//                    insertToTemp(type, campaign, promotion, branch, rs.getString("st.use_date"), useTime, useBillno, usePoint, useMacno, useCashier);
                } while (rs.next());
            } else {
                msn.showMessageInformation("ไม่พบข้อมูลการใช้งานของรหัส E-Stamp " + Barcode + " ...");
//                txtBarcode.setText("");
//                lbl_Custname.setText("");
//                lbl_tel.setText("");
                txtBarcode.requestFocus();
            }

            txtBarcode.setFocusable(true);
        } catch (Exception e) {
            e.printStackTrace();
            msn.showMessageError(e.getMessage());
        }

    }

    private void clearForm() {
        txtBranch1.setText("");
        txtBranch2.setText("");
        txt_date1.setText("");
        txt_date2.setText("");

        lbl_Custname.setText("");
        lbl_tel.setText("");

        txt_date1.setText(Format.dateFmtShow.format(new java.util.Date()));
        txt_date2.setText(Format.dateFmtShow.format(new java.util.Date()));

        txtBarcode.setText("");
        txtBarcode.requestFocus();
        btnSearch.setFocusable(false);
        btnExcel.setFocusable(false);
        btnPrint.setFocusable(false);

        setTable();
        resetTable();
//        LoadToGrid();
    }

    DefaultTableModel model;

    private void resetTable() {
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            model.removeRow(0);
        }
    }

    private void setTable() {
        model = (DefaultTableModel) tblShow.getModel();
        tblShow.setShowGrid(true);
        tblShow.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblShow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblShow.setRowSelectionAllowed(true);
        tblShow.setShowGrid(true);
        tblShow.setBackground(Color.WHITE);
        tblShow.setGridColor(Color.LIGHT_GRAY);

        JTableHeader header = tblShow.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 15));
        tblShow.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 15));
        tblShow.setRowHeight(26);
        tblShow.setAutoCreateRowSorter(true);

        ((DefaultTableCellRenderer) tblShow.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        DecimalFormat DoubleFmt = new DecimalFormat("##,###,##0.00");
        DecimalFormat IntegerFmt = new DecimalFormat("##,###,##0");
        DecimalFormat PersentFmt = new DecimalFormat("#,##0.00%");

        TableColumnModel tcm = tblShow.getColumnModel();

        DefaultTableCellRenderer d;

        d = new DefaultTableCellRenderer();
        d.setHorizontalAlignment(SwingConstants.CENTER);
        tcm.getColumn(0).setCellRenderer(d);
        tcm.getColumn(4).setCellRenderer(d);
        tcm.getColumn(5).setCellRenderer(d);
        tcm.getColumn(10).setCellRenderer(d);
        tcm.getColumn(12).setCellRenderer(d);
        tcm.getColumn(13).setCellRenderer(d);

        d = new DefaultTableCellRenderer();
        d.setHorizontalAlignment(SwingConstants.LEFT);
        tcm.getColumn(1).setCellRenderer(d);
        tcm.getColumn(2).setCellRenderer(d);
        tcm.getColumn(3).setCellRenderer(d);
        tcm.getColumn(6).setCellRenderer(d);
        tcm.getColumn(8).setCellRenderer(d);
        tcm.getColumn(9).setCellRenderer(d);
        tcm.getColumn(11).setCellRenderer(d);
        tcm.getColumn(14).setCellRenderer(d);
        tcm.getColumn(15).setCellRenderer(d);

        d = new DefaultTableCellRenderer();
        d.setHorizontalAlignment(SwingConstants.RIGHT);
        tcm.getColumn(7).setCellRenderer(d);
    }

    private void insertToTemp(String type, String campaign, String promotion, String branch, String useDate, String useTime, String useBillno, double usePoint, String useMacno, String useCashier) {
        try {
            String inst = "insert into stamptemptran(stamptype, campaign, promotion, use_branch, use_date, " //5
                    + "use_time, use_billno, use_point, use_macno, use_cashier, " //10
                    + "macno) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preUp1 = dbUtility.con.prepareStatement(inst);
            preUp1.setString(1, type);
            preUp1.setString(2, campaign);
            preUp1.setString(3, promotion);
            preUp1.setString(4, branch);
            preUp1.setString(5, useDate);
            preUp1.setString(6, useTime);
            preUp1.setString(7, useBillno);
            preUp1.setDouble(8, usePoint);
            preUp1.setString(9, useMacno);
            preUp1.setString(10, useCashier);
            preUp1.setString(11, Macno);
            preUp1.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            msn.showMessageError(e.getMessage());
        }
    }

    private void ProcessPrint() {
        String macno = "";
        String dateS1 = txt_date1.getText();
        String dateS2 = txt_date2.getText();
        String barcode = txtBarcode.getText();
        try {
            Map map = new HashMap();
            map.put("macno", Macno);
            map.put("barcode", barcode);
            map.put("dateS1", dateS1);
            map.put("dateS2", dateS2);

            JRBeanCollectionDataSource ds = null;
            String frmName = "EStampdetail";
            String rptName = "ES_rptStamptran";
            Report_ES rpt = new Report_ES();
            rpt.viewReportbean(rptName, map, frmName, ds);

//            rpt.viewReport(fileName, map, fileName);
//            r.viewReport(fileName, map);
        } catch (Exception e) {
            e.printStackTrace();
            msn.showMessageError(e.getMessage());
        }
    }

    private void ProcessPrintBean() {
        String branchFrom = "";
        String branchTo = "";
        if (txtBranch1.getText().equals("")) {
            branchFrom = "0";
        }
        if (txtBranch2.getText().equals("")) {
            branchTo = "ZZZZ";
        }

        try {
            getLanguage lang = new getLanguage();
            Map parm = new HashMap();
            JRBeanCollectionDataSource ds = null;
            ds = new JRBeanCollectionDataSource(EStamp.EStampReport.dataBeanUseEStampDetail.getCollectionUseEStampDetail(Seek));
            parm.put("companyName", lang.getTextCompanyReport());
            parm.put("application", new GetApplicationName().getApplicationName());
            parm.put("user", new GetUser().getUser());
            parm.put("custname", lbl_Custname.getText());
            parm.put("custtel", lbl_tel.getText());
            parm.put("stampbarcode", txtBarcode.getText());
            parm.put("branchFrom", branchFrom);
            parm.put("branchTo", branchTo);
            parm.put("dateFrom", txt_date1.getText());
            parm.put("dateTo", txt_date2.getText());
            parm.put("point", "0");
            parm.put("redeem", "0");
            parm.put("balance", "0");

            String frmName = "EStampdetail";
            String rptName = "ES_rptUseEStampDetail";
            Report_ES rpt = new Report_ES();
            rpt.viewReportbean(rptName, parm, frmName, ds);
        } catch (Exception e) {
            e.printStackTrace();
            msn.showMessageError(e.getMessage());
        }
    }

    private String getNamePromotion(String procode, String camapigncode) {
        String proname = "";
        try {
            String sql = "select sp_name from stamppromotion where sp_code='" + procode + "' and sp_campaign='" + camapigncode + "' ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                proname = rs.getString("sp_name");
            } else {
                proname = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return proname;
    }

    private String getNameProRedeem(String redeemcode, String camapigncode) {
        String proname = "";
        try {
            String sql = "select sr_name from stampredeem where sr_code='" + redeemcode + "' and sr_campaign='" + camapigncode + "' ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                proname = rs.getString("sr_name");
            } else {
                proname = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return proname;
    }
}
