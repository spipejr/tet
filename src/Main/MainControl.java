/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import EStamp.EStampdetail;
import EStamp.criteriaActivateEStampBarcode;
import EStamp.criteriaEStampGive;
import EStamp.criteriaEStampRedeem;
import EStamp.criteriaSummaryEStampByCampaign;
import EStamp.criteriaSummaryEStampByBarcode;
import EStamp.criteriaSummaryEStampByBranch;
import EStamp.dForm_masterCampaign;
import EStamp.dForm_masterProRedeem;
import EStamp.dForm_masterPromotion;
import convertplu.mainconvert;
import dbutility.dbUtility;
import ingredent_bom.*;
import ingredent_bom.s_bom.report_sbom;
import ingredent_bom_other.setup_ingredent_morn;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.*;
import masterfile.*;
import ping.interfaceSAP.checkData.main_import_json;
import ping.interfaceSAP.entity.article;
import ping.interfaceSAP.entity.site;
import ping.interfaceSAP.mapMaster.masterSAP_Department;
import ping.interfaceSAP.mapMaster.masterSAP_code_cashbank;
import ping.interfaceSAP.mapMaster.masterSAP_code_distype;
import ping.interfaceSAP.mapMaster.masterSAP_code_inout;
import ping.interfaceSAP.mapMaster.sap_updatemaster;
import ping.interfaceSAP.mapMaster.sap_updatemaster_csv;
import ping.interfaceSAP.report.criteriaSAPBranch;
import ping.interfaceSAP.report.criteriaSAPProduct;
import reportfile.*;
import utilititiesfunction.Format;
import utilititiesfunction.PUtility;
import utilititiesfunction.UserLogin;
import Treport.MainReportHourly;

/**
 *
 * @author shady
 */
public class MainControl extends javax.swing.JFrame {

    //getLanguage lang;
    dbUtility db = new dbUtility();
    Statement stmt;
    PVersion pv = new PVersion();

    /**
     * Creates new form MainControl
     */
    public MainControl() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Font myfont = new Font("Norasi", Font.PLAIN, 14);
        UIManager.put("Label.font", myfont);
        UIManager.put("Button.font", myfont);
        this.setExtendedState(MainControl.MAXIMIZED_BOTH);
        loginform();
        initComponents();
        this.setTitle(pv.getTitleSoftware() + " " + pv.getVersion() + " " + pv.getUpdate());
        db.dbconnect();
        SetEnableMenu();
        //MainMenu.setVisible(false);
        //lang = new getLanguage();
        //lang.setText(fromname, this, lang.getChklang());
        updateeffectiveprice();
        
        String fileName = "completeMapping" + new formatDateNumber().dateFmtSQL(new formatDateNumber().nowDate()) + ".csv";
//        article ar = new article();
//        ar.exportProductMapping("/home/soneping/Desktop/" + fileName);

//        site si = new site();
//        si.exportBranfileMapping("/home/soneping/Desktop/" + fileName);
    }
    
    public MainControl(int chk) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Font myfont = new Font("Norasi", Font.PLAIN, 14);
        UIManager.put("Label.font", myfont);
        UIManager.put("Button.font", myfont);
        this.setExtendedState(MainControl.MAXIMIZED_BOTH);

        // loginform();
        initComponents();
        // SetEnableMenu();
        //MainMenu.setVisible(false);
        //lang = new getLanguage();
        //lang.setText(fromname, this, lang.getChklang());
        db.dbconnect();
        updateeffectiveprice();
    }
    
    public void loginform() {
        this.setVisible(false);
        logincontrol frm = new logincontrol(this, true);
        frm.setVisible(true);
        this.setVisible(true);
    }
    
    public void SetEnableMenu() {
        UserLogin userrec = UserLogin.userlogin;
        userlogin.setText(userrec.getUserName());
        username.setText(userrec.getName());
        if (userrec.getMast1().equals("0")) {
            Mast1.setEnabled(false);
        } else {
            Mast1.setEnabled(true);
        }
        if (userrec.getMast2().equals("0")) {
            Mast2.setEnabled(false);
        } else {
            Mast2.setEnabled(true);
        }
        if (userrec.getMast3().equals("0")) {
            Mast3.setEnabled(false);
        } else {
            Mast3.setEnabled(true);
        }
        if (userrec.getMast4().equals("0")) {
            Mast4.setEnabled(false);
        } else {
            Mast4.setEnabled(true);
        }
        if (userrec.getMast5().equals("0")) {
            Mast5.setEnabled(false);
        } else {
            Mast5.setEnabled(true);
        }
        
        if (userrec.getMast6().equals("0")) {
            Mast6.setEnabled(false);
        } else {
            Mast6.setEnabled(true);
        }
        if (userrec.getMast7().equals("0")) {
            Mast7.setEnabled(false);
        } else {
            Mast7.setEnabled(true);
        }
        if (userrec.getMast8().equals("0")) {
            Mast8.setEnabled(false);
        } else {
            Mast8.setEnabled(true);
        }
        if (userrec.getMast9().equals("0")) {
            Mast9.setEnabled(false);
        } else {
            Mast9.setEnabled(true);
        }
        if (userrec.getMast10().equals("0")) {
            Mast10.setEnabled(false);
        } else {
            Mast10.setEnabled(true);
        }
        
        if (userrec.getMast11().equals("0")) {
            Mast11.setEnabled(false);
        } else {
            Mast11.setEnabled(true);
        }
        if (userrec.getMast12().equals("0")) {
            Mast12.setEnabled(false);
        } else {
            Mast12.setEnabled(true);
        }
        if (userrec.getMast13().equals("0")) {
            Mast13.setEnabled(false);
        } else {
            Mast13.setEnabled(true);
        }
        if (userrec.getMast14().equals("0")) {
            Mast14.setEnabled(false);
        } else {
            Mast14.setEnabled(true);
        }
        if (userrec.getMast15().equals("0")) {
            Mast15.setEnabled(false);
        } else {
            Mast15.setEnabled(true);
        }
        
        if (userrec.getMast16().equals("0")) {
            Mast16.setEnabled(false);
        } else {
            Mast16.setEnabled(true);
        }
        if (userrec.getMast17().equals("0")) {
            Mast17.setEnabled(false);
        } else {
            Mast17.setEnabled(true);
        }
        if (userrec.getMast18().equals("0")) {
            Mast18.setEnabled(false);
        } else {
            Mast18.setEnabled(true);
        }
        if (userrec.getMast19().equals("0")) {
            Mast19.setEnabled(false);
        } else {
            Mast19.setEnabled(true);
        }
        if (userrec.getMast20().equals("0")) {
            Mast20.setEnabled(false);
        } else {
            Mast20.setEnabled(true);
        }
        if (userrec.getMast21().equals("0")) {
            Mast21.setEnabled(false);
        } else {
            Mast21.setEnabled(true);
        }
        if (userrec.getMast22().equals("0")) {
            Mast22.setEnabled(false);
        } else {
            Mast22.setEnabled(true);
        }

        //****************************************************************
        if (userrec.getPlu1().equals("0")) {
            Plu1.setEnabled(false);
        } else {
            Plu1.setEnabled(true);
        }
        
        if (userrec.getPlu2().equals("0")) {
            Plu2.setEnabled(false);
        } else {
            Plu2.setEnabled(true);
        }
        if (userrec.getPlu3().equals("0")) {
            Plu3.setEnabled(false);
        } else {
            Plu3.setEnabled(true);
        }
        if (userrec.getPlu4().equals("0")) {
            Plu4.setEnabled(false);
        } else {
            Plu4.setEnabled(true);
        }
        if (userrec.getPlu5().equals("0")) {
            Plu5.setEnabled(false);
        } else {
            Plu5.setEnabled(true);
        }
        if (userrec.getPlu1().equals("0")) {
            Plu6.setEnabled(false);
        } else {
            Plu6.setEnabled(true);
        }
        if (userrec.getPlu7().equals("0")) {
            Plu7.setEnabled(false);
        } else {
            Plu7.setEnabled(true);
        }
        if (userrec.getPlu8().equals("0")) {
            Plu8.setEnabled(false);
        } else {
            Plu8.setEnabled(true);
        }
        if (userrec.getPlu9().equals("0")) {
            Plu9.setEnabled(false);
        } else {
            Plu9.setEnabled(true);
        }
        if (userrec.getPlu10().equals("0")) {
            Plu10.setEnabled(false);
        } else {
            Plu10.setEnabled(true);
        }
        if (userrec.getPlu11().equals("0")) {
            Plu11.setEnabled(false);
        } else {
            Plu11.setEnabled(true);
        }
        if (userrec.getPlu12().equals("0")) {
            Plu12.setEnabled(false);
        } else {
            Plu12.setEnabled(true);
        }
        if (userrec.getPlu13().equals("0")) {
            Plu13.setEnabled(false);
        } else {
            Plu13.setEnabled(true);
        }
        if (userrec.getPlu14().equals("0")) {
            Plu14.setEnabled(false);
        } else {
            Plu14.setEnabled(true);
        }
        //*************************************
        if (userrec.getTran1().equals("0")) {
            Tran1.setEnabled(false);
        } else {
            Tran2.setEnabled(true);
        }
        if (userrec.getTran2().equals("0")) {
            Tran2.setEnabled(false);
        } else {
            Tran2.setEnabled(true);
        }
        if (userrec.getTran3().equals("0")) {
            Tran3.setEnabled(false);
        } else {
            Tran3.setEnabled(true);
        }
        if (userrec.getTran4().equals("0")) {
            Tran4.setEnabled(false);
        } else {
            Tran4.setEnabled(true);
        }
        if (userrec.getTran5().equals("0")) {
            Tran5.setEnabled(false);
        } else {
            Tran5.setEnabled(true);
        }
        if (userrec.getTran6().equals("0")) {
            Tran6.setEnabled(false);
        } else {
            Tran6.setEnabled(true);
        }
        if (userrec.getTran7().equals("0")) {
            Tran7.setEnabled(false);
        } else {
            Tran7.setEnabled(true);
        }
        //*************************************
        if (userrec.getRpt1().equals("0")) {
            Rpt1.setEnabled(false);
        } else {
            Rpt1.setEnabled(true);
        }
        if (userrec.getRpt2().equals("0")) {
            Rpt2.setEnabled(false);
        } else {
            Rpt2.setEnabled(true);
        }
        if (userrec.getRpt3().equals("0")) {
            Rpt3.setEnabled(false);
        } else {
            Rpt3.setEnabled(true);
        }
        if (userrec.getRpt4().equals("0")) {
            Rpt4.setEnabled(false);
        } else {
            Rpt4.setEnabled(true);
        }
        if (userrec.getRpt5().equals("0")) {
            Rpt5.setEnabled(false);
        } else {
            Rpt5.setEnabled(true);
        }
        if (userrec.getRpt6().equals("0")) {
            Rpt6.setEnabled(false);
        } else {
            Rpt6.setEnabled(true);
        }
        if (userrec.getRpt7().equals("0")) {
            Rpt7.setEnabled(false);
        } else {
            Rpt7.setEnabled(true);
        }
        if (userrec.getRpt8().equals("0")) {
            Rpt8.setEnabled(false);
        } else {
            Rpt8.setEnabled(true);
        }
        if (userrec.getRpt9().equals("0")) {
            Rpt9.setEnabled(false);
        } else {
            Rpt9.setEnabled(true);
        }
        if (userrec.getRpt10().equals("0")) {
            Rpt10.setEnabled(false);
        } else {
            Rpt10.setEnabled(true);
        }
        
        if (userrec.getRpt11().equals("0")) {
            Rpt11.setEnabled(false);
        } else {
            Rpt11.setEnabled(true);
        }
        if (userrec.getRpt12().equals("0")) {
            Rpt12.setEnabled(false);
        } else {
            Rpt12.setEnabled(true);
        }
        if (userrec.getRpt13().equals("0")) {
            Rpt13.setEnabled(false);
        } else {
            Rpt13.setEnabled(true);
        }
        if (userrec.getRpt14().equals("0")) {
            Rpt14.setEnabled(false);
        } else {
            Rpt14.setEnabled(true);
        }
        if (userrec.getRpt15().equals("0")) {
            Rpt15.setEnabled(false);
        } else {
            Rpt15.setEnabled(true);
        }
        if (userrec.getRpt16().equals("0")) {
            Rpt16.setEnabled(false);
        } else {
            Rpt16.setEnabled(true);
        }
        if (userrec.getRpt17().equals("0")) {
            Rpt17.setEnabled(false);
        } else {
            Rpt17.setEnabled(true);
        }
        if (userrec.getRpt18().equals("0")) {
            Rpt18.setEnabled(false);
        } else {
            Rpt18.setEnabled(true);
        }
        if (userrec.getRpt19().equals("0")) {
            Rpt19.setEnabled(false);
        } else {
            Rpt19.setEnabled(true);
        }
        if (userrec.getRpt20().equals("0")) {
            Rpt20.setEnabled(false);
        } else {
            Rpt20.setEnabled(true);
        }
        
        if (userrec.getRpt21().equals("0")) {
            Rpt21.setEnabled(false);
        } else {
            Rpt21.setEnabled(true);
        }
        if (userrec.getRpt22().equals("0")) {
            Rpt22.setEnabled(false);
        } else {
            Rpt22.setEnabled(true);
        }
        if (userrec.getRpt23().equals("0")) {
            Rpt23.setEnabled(false);
        } else {
            Rpt23.setEnabled(true);
        }
        if (userrec.getRpt24().equals("0")) {
            Rpt24.setEnabled(false);
        } else {
            Rpt24.setEnabled(true);
        }
        if (userrec.getRpt25().equals("0")) {
            Rpt25.setEnabled(false);
        } else {
            Rpt25.setEnabled(true);
        }
        if (userrec.getRpt26().equals("0")) {
            Rpt26.setEnabled(false);
        } else {
            Rpt26.setEnabled(true);
        }
        if (userrec.getRpt27().equals("0")) {
            Rpt27.setEnabled(false);
        } else {
            Rpt27.setEnabled(true);
        }
        if (userrec.getRpt28().equals("0")) {
            Rpt28.setEnabled(false);
        } else {
            Rpt28.setEnabled(true);
        }
        if (userrec.getRpt29().equals("0")) {
            Rpt29.setEnabled(false);
        } else {
            Rpt29.setEnabled(true);
        }
        if (userrec.getRpt30().equals("0")) {
            Rpt30.setEnabled(false);
        } else {
            Rpt30.setEnabled(true);
        }
        
        if (userrec.getRpt31().equals("0")) {
            Rpt31.setEnabled(false);
        } else {
            Rpt31.setEnabled(true);
        }
        if (userrec.getRpt32().equals("0")) {
            Rpt32.setEnabled(false);
        } else {
            Rpt32.setEnabled(true);
        }
        if (userrec.getRpt33().equals("0")) {
            Rpt33.setEnabled(false);
        } else {
            Rpt33.setEnabled(true);
        }
        if (userrec.getRpt34().equals("0")) {
            Rpt34.setEnabled(false);
        } else {
            Rpt34.setEnabled(true);
        }
        if (userrec.getRpt35().equals("0")) {
            Rpt35.setEnabled(false);
        } else {
            Rpt35.setEnabled(true);
        }
        if (userrec.getRpt36().equals("0")) {
            Rpt36.setEnabled(false);
        } else {
            Rpt36.setEnabled(true);
        }
        if (userrec.getRpt37().equals("0")) {
            Rpt37.setEnabled(false);
        } else {
            Rpt37.setEnabled(true);
        }
        if (userrec.getRpt38().equals("0")) {
            Rpt38.setEnabled(false);
        } else {
            Rpt38.setEnabled(true);
        }
        if (userrec.getRpt39().equals("0")) {
            Rpt39.setEnabled(false);
        } else {
            Rpt39.setEnabled(true);
        }
        if (userrec.getRpt40().equals("0")) {
            Rpt40.setEnabled(false);
        } else {
            Rpt40.setEnabled(true);
        }
        
        if (userrec.getRpt41().equals("0")) {
            Rpt41.setEnabled(false);
        } else {
            Rpt41.setEnabled(true);
        }
        if (userrec.getRpt42().equals("0")) {
            Rpt42.setEnabled(false);
        } else {
            Rpt42.setEnabled(true);
        }
        if (userrec.getRpt43().equals("0")) {
            Rpt43.setEnabled(false);
        } else {
            Rpt43.setEnabled(true);
        }
        if (userrec.getRpt44().equals("0")) {
            Rpt44.setEnabled(false);
        } else {
            Rpt44.setEnabled(true);
        }
        if (userrec.getRpt45().equals("0")) {
            Rpt45.setEnabled(false);
        } else {
            Rpt45.setEnabled(true);
        }
        
        if (userrec.getCont1().equals("0")) {
            Cont1.setEnabled(false);
        } else {
            Cont1.setEnabled(true);
        }
        if (userrec.getCont2().equals("0")) {
            Cont2.setEnabled(false);
        } else {
            Cont2.setEnabled(true);
        }
        if (userrec.getCont3().equals("0")) {
            Cont3.setEnabled(false);
        } else {
            Cont3.setEnabled(true);
        }
        if (userrec.getCont4().equals("0")) {
            Cont4.setEnabled(false);
        } else {
            Cont4.setEnabled(true);
        }
        
        if (userrec.getMast26().equals("0")) {
            Mast26.setEnabled(false);
        } else {
            Mast26.setEnabled(true);
        }
        if (userrec.getMast27().equals("0")) {
            Mast27.setEnabled(false);
        } else {
            Mast27.setEnabled(true);
        }
        if (userrec.getMast28().equals("0")) {
            Mast28.setEnabled(false);
        } else {
            Mast28.setEnabled(true);
        }
        if (userrec.getMast29().equals("0")) {
            Mast29.setEnabled(false);
        } else {
            Mast29.setEnabled(true);
        }
        if (userrec.getMast30().equals("0")) {
            Mast30.setEnabled(false);
        } else {
            Mast30.setEnabled(true);
        }
        if (userrec.getRpt51().equals("0")) {
            Rpt51.setEnabled(false);
        } else {
            Rpt51.setEnabled(true);
        }
        Rpt52.setEnabled(true);
//        if (userrec.getRpt52().equals("0")) {
//            if (userlogin.equals("6786")) {
//                Rpt52.setEnabled(true);
//            } else {
//                Rpt52.setEnabled(false);
//            }
//        } else {
//            Rpt52.setEnabled(true);
//        }
    }
    
    public void updateeffectiveprice() {
        Date CurDate = new Date();
        try {
            String sql = "";
            stmt = (Statement) dbUtility.con.createStatement();
            sql = "select *from effective "
                    + " where eff_date='" + Format.dateFmtSql.format(CurDate) + "' and flage ='N'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //uudate blink
                Statement stmt2 = dbUtility.con.createStatement();
                String sql2 = "update blink set price1=?,price2=?,price3=?,price4=?,price5=?,"
                        + "promotion1=?,promotion2=?,promotion3=?,lastup=? "
                        + "where pcode=? and bgroup=?";
                PreparedStatement prm = (PreparedStatement) db.con.prepareStatement(sql2);
                prm.setDouble(1, rs.getDouble("price1"));
                prm.setDouble(2, rs.getDouble("price2"));
                prm.setDouble(3, rs.getDouble("price3"));
                prm.setDouble(4, rs.getDouble("price4"));
                prm.setDouble(5, rs.getDouble("price5"));
                prm.setString(6, rs.getString("promotion1"));
                prm.setString(7, rs.getString("promotion2"));
                prm.setString(8, rs.getString("promotion3"));
                prm.setString(9, Format.dateFmtSql.format(CurDate));
                prm.setString(10, rs.getString("pcode"));
                prm.setString(11, rs.getString("bgroup"));
                prm.executeUpdate();
                stmt2.close();
                // update effectine
                Statement stmt3 = dbUtility.con.createStatement();
                String sql3 = "update effective set flage='Y' "
                        + "where pcode=? and bgroup=? and eff_date=?";
                PreparedStatement prm3 = (PreparedStatement) db.con.prepareStatement(sql3);
                prm3.setString(1, rs.getString("pcode"));
                prm3.setString(2, rs.getString("bgroup"));
                prm3.setString(3, Format.dateFmtSql.format(CurDate));
                prm3.executeUpdate();
                stmt3.close();
            }
        } catch (Exception e) {
            PUtility.ShowMsg(e.getMessage().toString());
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        loginpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userlogin = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        MainMenu = new javax.swing.JMenuBar();
        Mast0 = new javax.swing.JMenu();
        Mast1 = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        MastGroup1 = new javax.swing.JMenu();
        Mast2 = new javax.swing.JMenuItem();
        Mast3 = new javax.swing.JMenuItem();
        Mast4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Mast5 = new javax.swing.JMenuItem();
        Mast6 = new javax.swing.JMenuItem();
        Mast7 = new javax.swing.JMenuItem();
        Mast8 = new javax.swing.JMenuItem();
        Mast9 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Mast10 = new javax.swing.JMenuItem();
        Mast11 = new javax.swing.JMenuItem();
        Mast12 = new javax.swing.JMenuItem();
        Mast13 = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        Mast14 = new javax.swing.JMenuItem();
        Mast15 = new javax.swing.JMenuItem();
        MastGroup2 = new javax.swing.JMenu();
        Mast16 = new javax.swing.JMenuItem();
        Mast17 = new javax.swing.JMenuItem();
        Mast18 = new javax.swing.JMenuItem();
        Mast19 = new javax.swing.JMenuItem();
        Mast20 = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        Mast21 = new javax.swing.JMenuItem();
        Mast22 = new javax.swing.JMenuItem();
        Mast23 = new javax.swing.JMenuItem();
        Mast24 = new javax.swing.JMenuItem();
        Mast25 = new javax.swing.JMenuItem();
        Mast26 = new javax.swing.JMenuItem();
        Mast27 = new javax.swing.JMenuItem();
        Mast28 = new javax.swing.JMenuItem();
        Mast29 = new javax.swing.JMenuItem();
        Mast30 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        Plu1_1 = new javax.swing.JMenu();
        jSeparator25 = new javax.swing.JPopupMenu.Separator();
        Plu1 = new javax.swing.JMenuItem();
        Plu2 = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        Plu3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        Plu4 = new javax.swing.JMenuItem();
        Plu5 = new javax.swing.JMenuItem();
        Plu6 = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        Plu7 = new javax.swing.JMenuItem();
        jSeparator28 = new javax.swing.JPopupMenu.Separator();
        Plu8 = new javax.swing.JMenuItem();
        jSeparator29 = new javax.swing.JPopupMenu.Separator();
        Plu9 = new javax.swing.JMenuItem();
        Plu10 = new javax.swing.JMenuItem();
        Plu11 = new javax.swing.JMenuItem();
        jSeparator30 = new javax.swing.JPopupMenu.Separator();
        Plu12 = new javax.swing.JMenuItem();
        Plu13 = new javax.swing.JMenuItem();
        Plu14 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        Tran0 = new javax.swing.JMenu();
        Tran1 = new javax.swing.JMenuItem();
        Tran2 = new javax.swing.JMenuItem();
        Tran3 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        Tran4 = new javax.swing.JMenuItem();
        Tran5 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        Tran6 = new javax.swing.JMenuItem();
        Tran7 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        Tran8 = new javax.swing.JMenuItem();
        Tran9 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        Rpt0 = new javax.swing.JMenu();
        RptGroup1 = new javax.swing.JMenu();
        Rpt1 = new javax.swing.JMenuItem();
        Rpt2 = new javax.swing.JMenuItem();
        Rpt3 = new javax.swing.JMenuItem();
        Rpt4 = new javax.swing.JMenuItem();
        Rpt5 = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        Rpt6 = new javax.swing.JMenuItem();
        Rpt7 = new javax.swing.JMenuItem();
        Rpt46 = new javax.swing.JMenuItem();
        RptGroup2 = new javax.swing.JMenu();
        jMenuItem33 = new javax.swing.JMenuItem();
        Rpt8 = new javax.swing.JMenuItem();
        Rpt9 = new javax.swing.JMenuItem();
        Rpt10 = new javax.swing.JMenuItem();
        Rpt11 = new javax.swing.JMenuItem();
        Rpt12 = new javax.swing.JMenuItem();
        Rpt13 = new javax.swing.JMenuItem();
        Rpt14 = new javax.swing.JMenuItem();
        Rpt15 = new javax.swing.JMenuItem();
        Rpt16 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        Rpt17 = new javax.swing.JMenuItem();
        Rpt18 = new javax.swing.JMenuItem();
        Rpt19 = new javax.swing.JMenuItem();
        Rpt20 = new javax.swing.JMenuItem();
        Rpt47 = new javax.swing.JMenuItem();
        Rpt48 = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        Rpt49 = new javax.swing.JMenuItem();
        Rpt50 = new javax.swing.JMenuItem();
        Rpt51 = new javax.swing.JMenuItem();
        Rpt52 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        RptGroup3 = new javax.swing.JMenu();
        Rpt21 = new javax.swing.JMenuItem();
        Rpt22 = new javax.swing.JMenuItem();
        Rpt23 = new javax.swing.JMenuItem();
        Rpt24 = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        Rpt25 = new javax.swing.JMenuItem();
        Rpt26 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        Rpt27 = new javax.swing.JMenuItem();
        Rpt28 = new javax.swing.JMenuItem();
        Rpt29 = new javax.swing.JMenuItem();
        Rpt30 = new javax.swing.JMenuItem();
        Rpt31 = new javax.swing.JMenu();
        jMenuItem74 = new javax.swing.JMenuItem();
        jMenuItem75 = new javax.swing.JMenuItem();
        jMenuItem76 = new javax.swing.JMenuItem();
        jMenuItem77 = new javax.swing.JMenuItem();
        Rpt32 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        RptGroup4 = new javax.swing.JMenu();
        Rpt33 = new javax.swing.JMenuItem();
        Rpt34 = new javax.swing.JMenuItem();
        Rpt35 = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        Rpt36 = new javax.swing.JMenuItem();
        Rpt37 = new javax.swing.JMenuItem();
        Rpt38 = new javax.swing.JMenuItem();
        Rpt39 = new javax.swing.JMenuItem();
        Rpt40 = new javax.swing.JMenuItem();
        Rpt41 = new javax.swing.JMenuItem();
        Rpt42 = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        Rpt43 = new javax.swing.JMenuItem();
        Rpt44 = new javax.swing.JMenuItem();
        Rpt45 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        Cont0 = new javax.swing.JMenu();
        Cont1 = new javax.swing.JMenuItem();
        jSeparator31 = new javax.swing.JPopupMenu.Separator();
        Cont2 = new javax.swing.JMenuItem();
        Cont3 = new javax.swing.JMenuItem();
        Cont4 = new javax.swing.JMenuItem();
        jSeparator32 = new javax.swing.JPopupMenu.Separator();
        jMenuItem128 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem92 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BOR SYSTEM (Linux Supported) UD20171101001");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/layoutmainbor.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1020, 710);

        loginpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        loginpanel.setName("Loginpanel"); // NOI18N
        loginpanel.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(251, 249, 249));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Login User");

        jLabel3.setFont(new java.awt.Font("Norasi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(251, 249, 249));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("User Name");

        userlogin.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        userlogin.setText("Surapol");
        userlogin.setFocusable(false);
        userlogin.setRequestFocusEnabled(false);

        username.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        username.setText("Surapol");
        username.setFocusable(false);
        username.setRequestFocusEnabled(false);

        javax.swing.GroupLayout loginpanelLayout = new javax.swing.GroupLayout(loginpanel);
        loginpanel.setLayout(loginpanelLayout);
        loginpanelLayout.setHorizontalGroup(
            loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userlogin, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(username))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        loginpanelLayout.setVerticalGroup(
            loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLayeredPane1.setLayer(loginpanel, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(loginpanel);
        loginpanel.setBounds(300, 280, 410, 110);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLayeredPane1.add(jPanel1);
        jPanel1.setBounds(370, 420, 100, 100);

        MainMenu.setPreferredSize(new java.awt.Dimension(498, 34));

        Mast0.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Mast0.setText("แฟ้มข้อมูลหลัก (Master File)");
        Mast0.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N

        Mast1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast1.setText("แฟ้มข้อมูลบริษัท ");
        Mast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast1ActionPerformed(evt);
            }
        });
        Mast0.add(Mast1);
        Mast0.add(jSeparator21);

        MastGroup1.setText("แฟ้มข้อมูลสำหรับการกำหนดรายละเอียดของสาขา");
        MastGroup1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        MastGroup1.setOpaque(true);

        Mast2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast2.setText("แฟ้มข้อมูลกลุ่มสาขา");
        Mast2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast2ActionPerformed(evt);
            }
        });
        MastGroup1.add(Mast2);

        Mast3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast3.setText("แฟ้มข้อมูลประเภทธุรกิจ");
        Mast3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast3ActionPerformed(evt);
            }
        });
        MastGroup1.add(Mast3);

        Mast4.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast4.setText("แฟ้มข้อมูล Brand");
        Mast4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast4ActionPerformed(evt);
            }
        });
        MastGroup1.add(Mast4);
        MastGroup1.add(jSeparator1);

        Mast5.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast5.setText("แฟ้มข้อมูลประเภทสาขา");
        Mast5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast5ActionPerformed(evt);
            }
        });
        MastGroup1.add(Mast5);

        Mast6.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast6.setText("แฟ้มข้อมูลเขตการขาย");
        Mast6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast6ActionPerformed(evt);
            }
        });
        MastGroup1.add(Mast6);

        Mast7.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast7.setText("แฟ้มข้อมูลลักษณะร้าน (สาขา/Shop)");
        Mast7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast7ActionPerformed(evt);
            }
        });
        MastGroup1.add(Mast7);

        Mast8.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast8.setText("แฟ้มข้อมูลลักษณะการลงทุน/การเช่า");
        Mast8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast8ActionPerformed(evt);
            }
        });
        MastGroup1.add(Mast8);

        Mast9.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast9.setText("แฟ้มข้อมูลลักษณะที่ตั้งตามห้างสรรพสินค้า");
        Mast9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast9ActionPerformed(evt);
            }
        });
        MastGroup1.add(Mast9);
        MastGroup1.add(jSeparator2);

        Mast10.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast10.setText("แฟ้มข้อมูล Credit Area");
        Mast10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast10ActionPerformed(evt);
            }
        });
        MastGroup1.add(Mast10);

        Mast11.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast11.setText("แฟ้มข้อมูล Bank Code และเลขที่บัญชีสำหรับบัตรเครดิต");
        Mast11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast11ActionPerformed(evt);
            }
        });
        MastGroup1.add(Mast11);

        Mast0.add(MastGroup1);

        Mast12.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast12.setText("แฟ้มข้อมูลรายละเอียดสาขา");
        Mast12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast12ActionPerformed(evt);
            }
        });
        Mast0.add(Mast12);

        Mast13.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast13.setText("แฟ้มข้อมูลจำนวนพนักงานของแต่ละสาขา");
        Mast13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast13ActionPerformed(evt);
            }
        });
        Mast0.add(Mast13);
        Mast0.add(jSeparator22);

        Mast14.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast14.setText("แฟ้มข้อมูลเทศกาล");
        Mast14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast14ActionPerformed(evt);
            }
        });
        Mast0.add(Mast14);

        Mast15.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast15.setText("แฟ้มข้อมูลเคมเปญ");
        Mast15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast15ActionPerformed(evt);
            }
        });
        Mast0.add(Mast15);

        MastGroup2.setText("แฟ้มข้อมูลควบคุมเครื่อง POS");
        MastGroup2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        MastGroup2.setOpaque(true);

        Mast16.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast16.setText("แฟ้มข้อมูลรหัสธนาคาร");
        Mast16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast16ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast16);

        Mast17.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast17.setText("แฟ้มข้อมูลรหัสบัตรเครดิต");
        Mast17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast17ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast17);

        Mast18.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast18.setText("แฟ้มข้อมูลรายการโปรโมชั่น");
        Mast18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast18ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast18);

        Mast19.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast19.setText("แฟ้มข้อมูลรายการบัตรคูปองพิเศษ");
        Mast19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast19ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast19);

        Mast20.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast20.setText("แฟ้มข้อมูลการกำหนดค่าเริ่มต้นสำหรับควบคุมเครื่อง POS");
        Mast20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast20ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast20);
        MastGroup2.add(jSeparator23);

        Mast21.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast21.setText("แฟ้มข้อมูลกำหนดกลุ่มผู้ใช้งานสำหรับเครื่อง POS");
        Mast21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast21ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast21);

        Mast22.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast22.setText("แฟ้มข้อมูลรหัสผู้ใช้งานสำหรับเครื่อง POS");
        Mast22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast22ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast22);

        Mast23.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast23.setText("แฟ้มข้อมูลบัตรคูปองอิเล็กทรอนิกส์(e-Coupon)");
        Mast23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast23ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast23);

        Mast24.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast24.setText("แฟ้มข้อมูลโปรโมชั่นรับสิทธิ์ชิงรางวัล");
        Mast24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast24ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast24);

        Mast25.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast25.setText("แฟ่มข้อมูล E-Stamp Campaign");
        Mast25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast25ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast25);

        Mast26.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast26.setText("แฟ่มข้อมูล E-Stamp setting (แจกแสตมป์)");
        Mast26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast26ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast26);

        Mast27.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast27.setText("แฟ่มข้อมูล E-Stamp setting (แลกแสตมป์)");
        Mast27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast27ActionPerformed(evt);
            }
        });
        MastGroup2.add(Mast27);

        Mast0.add(MastGroup2);

        Mast28.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast28.setText("แฟ้มข้อมูล MovementType (SAP)");
        Mast28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast28ActionPerformed(evt);
            }
        });
        Mast0.add(Mast28);

        Mast29.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast29.setText("แฟ้มข้อมูลรหัสส่วนลดในการขาย (SAP Mapping)");
        Mast29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast29ActionPerformed(evt);
            }
        });
        Mast0.add(Mast29);

        Mast30.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Mast30.setText("แฟ้มข้อมูลธนาคารเพื่อนำเงินสดเข้าระบบ (SAP Mapping)");
        Mast30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mast30ActionPerformed(evt);
            }
        });
        Mast0.add(Mast30);

        jMenuItem17.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem17.setText("แฟ้มข้อมูลหน่วยงาน (SAP)");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        Mast0.add(jMenuItem17);

        jMenuItem18.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem18.setText("แฟ้มข้อมูลการโอนระหว่างรหัส");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        Mast0.add(jMenuItem18);
        Mast0.add(jSeparator7);

        jMenu2.setText("แฟ้มข้อมูล Void&Permission");
        jMenu2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N

        jMenuItem25.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem25.setText("แฟ้มข้อมูล mail server และ SMS API User-Key");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem25);

        jMenuItem26.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem26.setText("แฟ้มข้อมูลผู้ควบคุมการ Void");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem26);

        jMenuItem27.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem27.setText("แฟ้มข้อมูลกำหนดสิทธิ์การ Void");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem27);
        jMenu2.add(jSeparator9);

        jMenuItem28.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem28.setText("แฟ้มข้อมูลหมายเหตุการ Void นอก (Refund)");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem28);

        jMenuItem29.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem29.setText("แฟ้มข้อมูลหมายเหตุการ Void ใน");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem29);

        Mast0.add(jMenu2);

        MainMenu.add(Mast0);

        Plu1_1.setText("รายการเกี่ยวกับสินค้า/วัตถุดิบ ");
        Plu1_1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        Plu1_1.add(jSeparator25);

        Plu1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu1.setText("แฟ้มข้อมูล DEPT สินค้า Product Department");
        Plu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu1ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu1);

        Plu2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu2.setText("แฟ้มข้อมูลผู้ผลิต/จำหน่ายสินค้า");
        Plu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu2ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu2);
        Plu1_1.add(jSeparator26);

        Plu3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu3.setText("แฟ้มข้อมูลสินค้า (PLU)");
        Plu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu3ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu3);

        jMenuItem7.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem7.setText("แฟ้มข้อมูลรายการวัตถุดิบ(POS BOM)");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        Plu1_1.add(jMenuItem7);

        Plu4.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu4.setText("แฟ้มข้อมูลรายการสินค้าที่จำหน่ายแต่ละสาขา");
        Plu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu4ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu4);

        Plu5.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu5.setText("แฟ้มข้อมูลการกำหนดราคาขายล่วงหน้า");
        Plu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu5ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu5);

        Plu6.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu6.setText("การปรับราคาขายอัตโนมัติ");
        Plu1_1.add(Plu6);
        Plu1_1.add(jSeparator27);

        Plu7.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu7.setText("แฟ้มข้อมูลกำหนดส่วนประกอบสินค้าเพื่อการแปรรูป");
        Plu7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu7ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu7);
        Plu1_1.add(jSeparator28);

        Plu8.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu8.setText("แฟ้มข้อมูลรหัสเลขเมนู ในเล่มเมนูอาหาร");
        Plu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu8ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu8);
        Plu1_1.add(jSeparator29);

        Plu9.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu9.setText("แฟ้มข้อมูลกลุ่มวัตถุดิบ");
        Plu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu9ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu9);

        Plu10.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu10.setText("แฟ้มข้อมูลรายการวัตถุดิบ");
        Plu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu10ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu10);

        Plu11.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu11.setText("แฟ้มข้อมูลสูตรอาหาร/ส่วนประกอบ/ส่วนผสม");
        Plu11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu11ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu11);
        Plu1_1.add(jSeparator30);

        Plu12.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu12.setText("รายงานแสดงรายการสินค้า (PLU)");
        Plu12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu12ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu12);

        Plu13.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu13.setText("รายงานแสดงรายการสินค้าในแต่ละกลุ่มสาขา");
        Plu13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu13ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu13);

        Plu14.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Plu14.setText("รายงานแสดงรายการวัตถุดิบ");
        Plu14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plu14ActionPerformed(evt);
            }
        });
        Plu1_1.add(Plu14);
        Plu1_1.add(jSeparator4);

        jMenuItem8.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem8.setText("รายงาน POS BOM");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        Plu1_1.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem9.setText("บันทึกต้นทุนวัตถุดิบ (สำหรับส่งข้อมูลให้ JDE)");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        Plu1_1.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem10.setText("บันทึกแฟ้มข้อมูลหน่วยสินค้า");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        Plu1_1.add(jMenuItem10);

        jMenuItem11.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem11.setText("บันทึกรหัสบัญชีของ DEPT สินค้า");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        Plu1_1.add(jMenuItem11);

        jMenuItem15.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem15.setText("กำหนดรายการสินค้า/วัตถุดิบสำหรับบัญชีเพื่อส่งเข้า JDE");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        Plu1_1.add(jMenuItem15);

        jMenuItem13.setText("Export BOM To JDE");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        Plu1_1.add(jMenuItem13);

        jMenuItem16.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem16.setText("รายงานการใช้วัตถุดิบ (BOM)");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        Plu1_1.add(jMenuItem16);

        MainMenu.add(Plu1_1);

        Tran0.setText("การรับ/ส่งข้อมูลกับสาขา");
        Tran0.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        Tran0.setName("menu3"); // NOI18N

        Tran1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Tran1.setText("ตรวจสอบข้อมูลการขายจากสาขา");
        Tran1.setName("m3-1"); // NOI18N
        Tran1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tran1ActionPerformed(evt);
            }
        });
        Tran0.add(Tran1);

        Tran2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Tran2.setText("บันทึกยอดการขายจากสาขาเข้า Master File");
        Tran2.setName("m3-2"); // NOI18N
        Tran2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tran2ActionPerformed(evt);
            }
        });
        Tran0.add(Tran2);

        Tran3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Tran3.setText("รายงานการบันทึกข้อมูลจากสาขาเข้า Master File");
        Tran3.setName("m3-3"); // NOI18N
        Tran3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tran3ActionPerformed(evt);
            }
        });
        Tran0.add(Tran3);
        Tran0.add(jSeparator8);

        Tran4.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Tran4.setText("ตรวจสอบข้อมูลเพื่ออัพเดทข้อมูลที่สาขา");
        Tran4.setName("m3-4"); // NOI18N
        Tran0.add(Tran4);

        Tran5.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Tran5.setText("สร้างไฟล์อัพเดทข้อมูลสาขา (Center->Branch) เป็น Zip File");
        Tran5.setName("m3-5"); // NOI18N
        Tran5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tran5ActionPerformed(evt);
            }
        });
        Tran0.add(Tran5);
        Tran0.add(jSeparator10);

        Tran6.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Tran6.setText("ส่งข้อความสั้นไปยังสาขา");
        Tran6.setName("m3-6"); // NOI18N
        Tran6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tran6ActionPerformed(evt);
            }
        });
        Tran0.add(Tran6);

        Tran7.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Tran7.setText("ส่ง Logo Screen ไปยังสาขา");
        Tran7.setName("m3-7"); // NOI18N
        Tran7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tran7ActionPerformed(evt);
            }
        });
        Tran0.add(Tran7);
        Tran0.add(jSeparator3);

        Tran8.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Tran8.setText("Update Master From SAP");
        Tran8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tran8ActionPerformed(evt);
            }
        });
        Tran0.add(Tran8);

        Tran9.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Tran9.setText("Import CSV File (Mapping SAP master)");
        Tran9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tran9ActionPerformed(evt);
            }
        });
        Tran0.add(Tran9);

        jMenuItem5.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem5.setText("Import Result SAP From Branch");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Tran0.add(jMenuItem5);

        MainMenu.add(Tran0);

        Rpt0.setText("รายงานต่างๆ");
        Rpt0.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        Rpt0.setName("menu4"); // NOI18N
        Rpt0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt0ActionPerformed(evt);
            }
        });

        RptGroup1.setText("Opearation Sales Report");
        RptGroup1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        RptGroup1.setName("m4-1"); // NOI18N

        Rpt1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt1.setText("ยอดการขายตามรหัสสินค้า (PLU Report)");
        Rpt1.setName("m4-1-1"); // NOI18N
        Rpt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt1ActionPerformed(evt);
            }
        });
        RptGroup1.add(Rpt1);

        Rpt2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt2.setText("ยอดการขายตามแผนก (DEPT Report)");
        Rpt2.setName("m4-1-2"); // NOI18N
        Rpt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt2ActionPerformed(evt);
            }
        });
        RptGroup1.add(Rpt2);

        Rpt3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt3.setText("ยอดการเงิน (Terminal Report)");
        Rpt3.setName("m4-1-3"); // NOI18N
        Rpt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt3ActionPerformed(evt);
            }
        });
        RptGroup1.add(Rpt3);

        Rpt4.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt4.setText("รายงานบัตรเครดิต (Credit Report)");
        Rpt4.setName("m4-1-4"); // NOI18N
        Rpt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt4ActionPerformed(evt);
            }
        });
        RptGroup1.add(Rpt4);

        Rpt5.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt5.setText("รายงานการขายรายชั่วโมง (Hourly Report)");
        Rpt5.setName("m4-1-5"); // NOI18N
        Rpt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt5ActionPerformed(evt);
            }
        });
        RptGroup1.add(Rpt5);
        RptGroup1.add(jSeparator14);

        Rpt6.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt6.setText("รายงานใบรายการรับจ่าย (RJ)");
        Rpt6.setName("m4-1-6"); // NOI18N
        Rpt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt6ActionPerformed(evt);
            }
        });
        RptGroup1.add(Rpt6);

        Rpt7.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt7.setText("รายงานสต๊อกเค้กรายวัน (Stock Cake)");
        Rpt7.setName("m4-1-7"); // NOI18N
        Rpt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt7ActionPerformed(evt);
            }
        });
        RptGroup1.add(Rpt7);

        Rpt46.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt46.setText("รายงานโปรโมชั่นรับสิทธิ์ลุ้นรางวัล");
        Rpt46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt46ActionPerformed(evt);
            }
        });
        RptGroup1.add(Rpt46);

        Rpt0.add(RptGroup1);

        RptGroup2.setText("Daily Sales & Consolidate Report");
        RptGroup2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        RptGroup2.setName("m4-2"); // NOI18N

        jMenuItem33.setText("jMenuItem33");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        RptGroup2.add(jMenuItem33);

        Rpt8.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt8.setText("สรุปยอดการขายตามรหัสสินค้า (Summary Plu)");
        Rpt8.setName("m4-2-1"); // NOI18N
        Rpt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt8ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt8);

        Rpt9.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt9.setText("สรุปยอดการขายตามรหัสสินค้า (Summary PLU By Date)");
        Rpt9.setName("m4-2-2"); // NOI18N
        Rpt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt9ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt9);

        Rpt10.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt10.setText("สรุปยอดการขายตามแผนกสินค้า (Summary Dept)");
        Rpt10.setName("m4-2-3"); // NOI18N
        Rpt10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt10ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt10);

        Rpt11.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt11.setText("สรุปยอดการขายตามแนกสินค้า (Summary Dept By Date)");
        Rpt11.setName("m4-2-4"); // NOI18N
        Rpt11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt11ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt11);

        Rpt12.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt12.setText("รายงานใบรายการรับจ่าย (RJ)");
        Rpt12.setName("m4-2-5"); // NOI18N
        Rpt12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt12ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt12);

        Rpt13.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt13.setText("รายงานยอดการเงิน (Summary Terminal Report)");
        Rpt13.setName("m4-2-6"); // NOI18N
        Rpt13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt13ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt13);

        Rpt14.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt14.setText("รายงานยอดการเงิน (Summary Terminal By Date)");
        Rpt14.setName("m4-2-7"); // NOI18N
        Rpt14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt14ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt14);

        Rpt15.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt15.setText("รายงานอันดับสินค้าขายดี (ตามจำนวนที่ขาย)");
        Rpt15.setName("m4-2-8"); // NOI18N
        Rpt15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt15ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt15);

        Rpt16.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt16.setText("รายงานอันดับสินค้าขายดี (ตามมูลค่าที่ขาย)");
        Rpt16.setName("m4-2-9"); // NOI18N
        Rpt16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt16ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt16);
        RptGroup2.add(jSeparator15);

        Rpt17.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt17.setText("รายงานสต๊อกเค้กรายวัน");
        Rpt17.setName("m4-2-10"); // NOI18N
        Rpt17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt17ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt17);

        Rpt18.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt18.setText("รายงานใบรายการรับจ่าย (RJ จากศูนย์ข้อมูล)");
        Rpt18.setName("m4-2-11"); // NOI18N
        RptGroup2.add(Rpt18);

        Rpt19.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt19.setText("รายงานยอดบัตรส่วนลดพิเศษคูปอง (Special Cupon)");
        Rpt19.setName("m4-2-12"); // NOI18N
        Rpt19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt19ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt19);

        Rpt20.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt20.setText("รายงานยอดส่วนลดโปรโมชั่น (Promotion Discount)");
        Rpt20.setName("m4-2-13"); // NOI18N
        Rpt20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt20ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt20);

        Rpt47.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt47.setText("รายงานสรุปยอดการแจก e-Coupon");
        Rpt47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt47ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt47);

        Rpt48.setText("รายงานสรุปการแจกและการแลกคะแนน E-Stamp");
        Rpt48.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N

        jMenuItem30.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem30.setText("แยกตามแคมเปญ");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        Rpt48.add(jMenuItem30);

        jMenuItem31.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem31.setText("แยกตามรหัสบัตร E-Stamp");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        Rpt48.add(jMenuItem31);

        jMenuItem6.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem6.setText("แยกตามสาขา");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        Rpt48.add(jMenuItem6);

        RptGroup2.add(Rpt48);

        Rpt49.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt49.setText("รายงานแสดงรายละเอียดการแจกคะแนน E-Stamp");
        Rpt49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt49ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt49);

        Rpt50.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt50.setText("รายงานแสดงรายละเอียดการแลกคะแนน E-Stamp");
        Rpt50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt50ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt50);

        Rpt51.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt51.setText("รายงานตรวจสอบการใช้บัตร E-Stamp");
        Rpt51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt51ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt51);

        Rpt52.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt52.setText("รายงานการเปิดใช้งานบัตร E-Stamp");
        Rpt52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt52ActionPerformed(evt);
            }
        });
        RptGroup2.add(Rpt52);
        RptGroup2.add(jSeparator5);

        jMenuItem19.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem19.setText("สรุปการบันทึกของเสียตามรหัสสินค้า (Summay waste by PLU)");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        RptGroup2.add(jMenuItem19);

        jMenuItem20.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem20.setText("สรุปการบันทึกของเสียตามแผนกสินค้า (Summary Waste by dept)");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        RptGroup2.add(jMenuItem20);

        jMenuItem21.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem21.setText("รายงานการขายรายชั่วโมงแยกตามรหัสสินค้า (Hourly By PLU Report)");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        RptGroup2.add(jMenuItem21);

        Rpt0.add(RptGroup2);

        RptGroup3.setText("Analysis Sales Report");
        RptGroup3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        RptGroup3.setName("m4-3"); // NOI18N

        Rpt21.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt21.setText("รายงานยอดการขายและรับเงินสด/บัตรเครดิต จากสาขา");
        Rpt21.setName("m4-3-1"); // NOI18N
        Rpt21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt21ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt21);

        Rpt22.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt22.setText("รายงานเปรียบเทียบยอดขายตามรหัสสินค้า (PLU Code)");
        Rpt22.setName("m4-3-2"); // NOI18N
        Rpt22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt22ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt22);

        Rpt23.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt23.setText("รายงานเปรียบเทียบยอดขายเฉลี่ยประจำสัปดาห์");
        Rpt23.setName("m4-3-3"); // NOI18N
        Rpt23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt23ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt23);

        Rpt24.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt24.setText("รายงานการขายรวมหน้าร้าน/จัดส่ง/ปิ่นโต (ประจำเดือน)");
        Rpt24.setName("m4-3-4"); // NOI18N
        Rpt24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt24ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt24);
        RptGroup3.add(jSeparator16);

        Rpt25.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt25.setText("รายงานเปรียบเทียบต้นทุนขายต่อยอดขาย (ตามรหัสสินค้า)");
        Rpt25.setName("m4-3-5"); // NOI18N
        Rpt25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt25ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt25);

        Rpt26.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt26.setText("รายงานเปรียบเทียบต้นทุนขายต่อยอดขาย (ตามแผนกสินค้า)");
        Rpt26.setName("m4-3-6"); // NOI18N
        Rpt26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt26ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt26);
        RptGroup3.add(jSeparator17);

        Rpt27.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt27.setText("รายงานวิเคราะห์ยอดขายต่อจำนวนพนักงาน");
        Rpt27.setName("m4-3-7"); // NOI18N
        Rpt27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt27ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt27);

        Rpt28.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt28.setText("รายงานวิเคราะห์ยอดซื้อต่อหัวของลูกค้า");
        Rpt28.setName("m4-3-8"); // NOI18N
        Rpt28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt28ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt28);

        Rpt29.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt29.setText("รายงานวิเคราะห์ยอดขายต่อพื้นที่(ตรม)(ประจำเดือน)");
        Rpt29.setName("m4-3-9"); // NOI18N
        Rpt29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt29ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt29);

        Rpt30.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt30.setText("รายงานภาษีขายประจำเดือน");
        Rpt30.setName("m4-3-10"); // NOI18N
        Rpt30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt30ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt30);

        Rpt31.setText("รายงานสรุปยอดการใช้วัตถุดิบ");
        Rpt31.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt31.setName("m4-3-11"); // NOI18N

        jMenuItem74.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem74.setText("รายงานสรุปยอดการใช้วัตถุดิบ");
        jMenuItem74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem74ActionPerformed(evt);
            }
        });
        Rpt31.add(jMenuItem74);

        jMenuItem75.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem75.setText("รายงานสรุปยอดการใช้วัตถุดิบ By PLU");
        jMenuItem75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem75ActionPerformed(evt);
            }
        });
        Rpt31.add(jMenuItem75);

        jMenuItem76.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem76.setText("รายงานอันดับการใช้วัตถุดิบ (ตามจำนวน)");
        jMenuItem76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem76ActionPerformed(evt);
            }
        });
        Rpt31.add(jMenuItem76);

        jMenuItem77.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem77.setText("รายงานอันดับการใช้วัตถุดิบ (ตามมูลค่า)");
        jMenuItem77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem77ActionPerformed(evt);
            }
        });
        Rpt31.add(jMenuItem77);

        RptGroup3.add(Rpt31);

        Rpt32.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt32.setText("รายงานสรุปการขายตามช่วงเวลา");
        Rpt32.setName("m4-3-12"); // NOI18N
        Rpt32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt32ActionPerformed(evt);
            }
        });
        RptGroup3.add(Rpt32);

        jMenuItem3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem3.setText("รายงานสรุปยอดสินค้าจัดชุด");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        RptGroup3.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem4.setText("รายงานสรุปยอดสินค้าจัดชุด By Plu");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        RptGroup3.add(jMenuItem4);

        Rpt0.add(RptGroup3);

        RptGroup4.setText("Analysis Month Report");
        RptGroup4.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        RptGroup4.setName("m4-4"); // NOI18N

        Rpt33.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt33.setText("บันทึกเป้าการขายตามรหัสสินค้า (ตามเทศกาล)");
        Rpt33.setName("m4-4-1"); // NOI18N
        Rpt33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt33ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt33);

        Rpt34.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt34.setText("บันทึกเป้าการขายของแต่ละสาขา (ตาม RJ Form)");
        Rpt34.setName("m4-4-2"); // NOI18N
        Rpt34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt34ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt34);

        Rpt35.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt35.setText("บันทึกรายการลำดับ PLU Code");
        Rpt35.setName("m4-4-3"); // NOI18N
        Rpt35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt35ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt35);
        RptGroup4.add(jSeparator18);

        Rpt36.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt36.setText("รายงานแสดงยอดการขาย/ตามเทศกาล (แสดงแยกรายวัน)");
        Rpt36.setName("m4-4-4"); // NOI18N
        Rpt36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt36ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt36);

        Rpt37.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt37.setText("รายงานสรุปยอดการขาย/ตามเทศกาล (แสดงยอดรวม)");
        Rpt37.setName("m4-4-5"); // NOI18N
        Rpt37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt37ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt37);

        Rpt38.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt38.setText("รายงานสรุปยอดการขายรายเดือน");
        Rpt38.setName("m4-4-6"); // NOI18N
        Rpt38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt38ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt38);

        Rpt39.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt39.setText("รายงานเปรียบเทียบยอดการขายของเทศกาล (ตามช่วงเวลา)");
        Rpt39.setName("m4-4-7"); // NOI18N
        Rpt39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt39ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt39);

        Rpt40.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt40.setText("รายงานสรุปยอดการขายเทียบเป้าประจำเดือน");
        Rpt40.setName("m4-4-8"); // NOI18N
        Rpt40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt40ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt40);

        Rpt41.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt41.setText("รายงานขาย/เสียตาม RJ Form");
        Rpt41.setName("m4-4-9"); // NOI18N
        Rpt41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt41ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt41);

        Rpt42.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt42.setText("รายงานขาย/เสีย (แสดงยอดตามแผนกสินค้า DEPT)");
        Rpt42.setName("m4-4-10"); // NOI18N
        Rpt42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt42ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt42);
        RptGroup4.add(jSeparator19);

        Rpt43.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt43.setText("รายงานการบันทึกเป้าการขาย (ตาม RJ Form)");
        Rpt43.setName("m4-4-11"); // NOI18N
        Rpt43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt43ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt43);

        Rpt44.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt44.setText("รายงานเป้าการขายตามรหัสสินค้า (ตามเทศกาล)");
        Rpt44.setName("m4-4-12"); // NOI18N
        Rpt44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt44ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt44);

        Rpt45.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Rpt45.setText("รายงานเปรียบเทียบยอดขายตามช่วงเวลา");
        Rpt45.setName("m4-4-13"); // NOI18N
        Rpt45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rpt45ActionPerformed(evt);
            }
        });
        RptGroup4.add(Rpt45);

        Rpt0.add(RptGroup4);

        jMenu1.setText("Report SAP");
        jMenu1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem1.setText("รายงานสาขา Mapping SAP");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem2.setText("รายงานสินค้า Mapping SAP");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        Rpt0.add(jMenu1);

        jMenu3.setText("รายงานการ Void(ใน)");
        jMenu3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N

        jMenuItem34.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem34.setText("รายงานการVoid(ใน)แบบละเอียด");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem34);

        jMenuItem35.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem35.setText("รายงานการVoide(ใน)แบบสรุป");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem35);

        jMenuItem36.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem36.setText("สรุปสาเหตุการVoid Item");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem36);

        Rpt0.add(jMenu3);

        jMenu4.setText("รายงานการVoid(นอก)");
        jMenu4.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N

        jMenuItem37.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem37.setText("รายงานการVoid(นอก)แบบละเอียด");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem37);

        jMenuItem38.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem38.setText("รายงานการVoid(นอก)แบบสรุป");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem38);

        jMenuItem39.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem39.setText("สรุปสาเหตุการยกเลิก");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem39);

        Rpt0.add(jMenu4);
        Rpt0.add(jSeparator6);

        jMenuItem22.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem22.setText("รายงานการโอนระหว่างสาขา");
        Rpt0.add(jMenuItem22);

        jMenuItem23.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem23.setText("รายงานการโอนให้หน่วยงาน");
        Rpt0.add(jMenuItem23);

        jMenuItem24.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem24.setText("ข้อมูลการโอนสินค้าระหว่างสาขาเพื่อทำการปรับต้นทุนระหว่างกัน");
        Rpt0.add(jMenuItem24);

        MainMenu.add(Rpt0);

        Cont0.setText("ระบบควบคุม");
        Cont0.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        Cont0.setName("menu5"); // NOI18N

        Cont1.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Cont1.setText("การตั้งค่าภาษา สำหรับระบบ");
        Cont1.setName("m5-1"); // NOI18N
        Cont1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cont1ActionPerformed(evt);
            }
        });
        Cont0.add(Cont1);
        Cont0.add(jSeparator31);

        Cont2.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Cont2.setText("กำหนด Path สำหรับรับ-ส่งข้อมูล");
        Cont2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cont2ActionPerformed(evt);
            }
        });
        Cont0.add(Cont2);

        Cont3.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Cont3.setText("กำหนดรหัสกลุ่มผู้ใช้งานระบบ");
        Cont3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cont3ActionPerformed(evt);
            }
        });
        Cont0.add(Cont3);

        Cont4.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        Cont4.setText("กำหนดรหัสผู้ใช้งานระบบ");
        Cont4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cont4ActionPerformed(evt);
            }
        });
        Cont0.add(Cont4);
        Cont0.add(jSeparator32);

        jMenuItem128.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem128.setText("About This Software");
        Cont0.add(jMenuItem128);

        jMenuItem12.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem12.setText("ปรับยอดบัตรเครดิต");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        Cont0.add(jMenuItem12);

        jMenuItem14.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem14.setText("Convert PLU DEPT 0088");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        Cont0.add(jMenuItem14);

        MainMenu.add(Cont0);

        jMenu6.setText("ออกจากระบบ");
        jMenu6.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jMenu6.setName("menu6"); // NOI18N
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem92.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem92.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        jMenuItem92.setText("ออกจากระบบ");
        jMenuItem92.setName("m6-1"); // NOI18N
        jMenuItem92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem92ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem92);

        MainMenu.add(jMenu6);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1035, 791));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    String fromname = "maincontrol";

    private void Cont1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cont1ActionPerformed
        //ConfigLanguage frm = new ConfigLanguage(this, true,fromname);
        //frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Cont1ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        
        this.dispose();
//        System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenuItem92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem92ActionPerformed
        
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem92ActionPerformed

    private void Plu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu3ActionPerformed
        // TODO add your handling code here:
        productPLU frm = new productPLU(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu3ActionPerformed

    private void Plu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu2ActionPerformed
        // TODO add your handling code here:
        VenderFile frm = new VenderFile(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu2ActionPerformed

    private void Plu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu10ActionPerformed
        // TODO add your handling code here:
        UpdateMaterial frm = new UpdateMaterial(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu10ActionPerformed

    private void Plu11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu11ActionPerformed
        // TODO add your handling code here:
        menusetup frm = new menusetup(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu11ActionPerformed

    private void Plu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu9ActionPerformed
        // TODO add your handling code here:
        IngGroup frm = new IngGroup(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu9ActionPerformed

    private void Mast5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast5ActionPerformed
        // TODO add your handling code here:
        Branchtype frm = new Branchtype();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast5ActionPerformed

    private void Mast6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast6ActionPerformed
        // TODO add your handling code here:
        BranchArea frm = new BranchArea();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast6ActionPerformed

    private void Mast7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast7ActionPerformed
        // TODO add your handling code here:
        Bshopsize frm = new Bshopsize();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast7ActionPerformed

    private void Mast8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast8ActionPerformed
        // TODO add your handling code here:
        Bplane frm = new Bplane();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast8ActionPerformed

    private void Mast9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast9ActionPerformed
        // TODO add your handling code here:
        GroupStore frm = new GroupStore();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast9ActionPerformed

    private void Mast12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast12ActionPerformed
        // TODO add your handling code here:
        BranchSetting frm = new BranchSetting(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast12ActionPerformed

    private void Plu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu4ActionPerformed
        // TODO add your handling code here:
        frmSetSalePriceofBranchGroup frm = new frmSetSalePriceofBranchGroup(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu4ActionPerformed

    private void Mast13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast13ActionPerformed
        // TODO add your handling code here:
        BranchPerUser frm = new BranchPerUser(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast13ActionPerformed

    private void Mast16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast16ActionPerformed
        // TODO add your handling code here:
        BankFile frm = new BankFile();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast16ActionPerformed

    private void Mast17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast17ActionPerformed
        // TODO add your handling code here:
        CreditCardSetup frm = new CreditCardSetup();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast17ActionPerformed

    private void Mast19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast19ActionPerformed
        // TODO add your handling code here:
        SpacialCouponSetup frm = new SpacialCouponSetup(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast19ActionPerformed

    private void Mast20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast20ActionPerformed
        // TODO add your handling code here:
        POSConfigSetup frm = new POSConfigSetup();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast20ActionPerformed

    private void Mast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast1ActionPerformed
        // TODO add your handling code here:
        CompanySet frm = new CompanySet();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast1ActionPerformed

    private void Mast2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast2ActionPerformed
        // TODO add your handling code here:
        BranchGroup frm = new BranchGroup();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast2ActionPerformed

    private void Mast10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast10ActionPerformed
        // TODO add your handling code here:
        CrArea frm = new CrArea();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast10ActionPerformed

    private void Mast11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast11ActionPerformed
        // TODO add your handling code here:
        CrAccNo frm = new CrAccNo();
        frm.setVisible(true);
    }//GEN-LAST:event_Mast11ActionPerformed

    private void Mast3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast3ActionPerformed
        // TODO add your handling code here:
        Businesstype frm = new Businesstype(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast3ActionPerformed

    private void Mast4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast4ActionPerformed
        // TODO add your handling code here:
        Brandfile frm = new Brandfile(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast4ActionPerformed

    private void Mast14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast14ActionPerformed
        // TODO add your handling code here:
        Fastivalfile frm = new Fastivalfile(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast14ActionPerformed

    private void Mast15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast15ActionPerformed
        // TODO add your handling code here:
        Campaignfile frm = new Campaignfile(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast15ActionPerformed

    private void Mast18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast18ActionPerformed
        // TODO add your handling code here:
        PromotionSetup frm = new PromotionSetup(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast18ActionPerformed

    private void Tran5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tran5ActionPerformed
        // TODO add your handling code here:
        senddatatobranch2 frm = new senddatatobranch2();
        frm.setVisible(true);
    }//GEN-LAST:event_Tran5ActionPerformed

    private void Cont2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cont2ActionPerformed
        // TODO add your handling code here:
        PathSetup frm = new PathSetup(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Cont2ActionPerformed

    private void Tran6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tran6ActionPerformed
        // TODO add your handling code here:
        SendMessageToBranch frm = new SendMessageToBranch(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Tran6ActionPerformed

    private void Tran7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tran7ActionPerformed
        // TODO add your handling code here:
        SendLogoToBranch frm = new SendLogoToBranch(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Tran7ActionPerformed

    private void Tran3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tran3ActionPerformed
        // TODO add your handling code here:
        rptChkpost frm = new rptChkpost(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Tran3ActionPerformed

    private void Tran1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tran1ActionPerformed
        // TODO add your handling code here:
        checkfile frm = new checkfile();
        frm.setVisible(true);
    }//GEN-LAST:event_Tran1ActionPerformed

    private void Tran2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tran2ActionPerformed
        // TODO add your handling code here:
        PostData frm = new PostData();
        frm.setVisible(true);
    }//GEN-LAST:event_Tran2ActionPerformed

    private void Plu12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu12ActionPerformed
        // TODO add your handling code here:
        rptShowPLU frm = new rptShowPLU(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu12ActionPerformed

    private void Plu13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu13ActionPerformed
        // TODO add your handling code here:
        rptShowPluByType frm = new rptShowPluByType(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu13ActionPerformed

    private void Plu14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu14ActionPerformed
        // TODO add your handling code here:
        rptShowMenuSetup frm = new rptShowMenuSetup(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu14ActionPerformed

    private void Rpt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt1ActionPerformed
        // TODO add your handling code here:
        criteriaSaleOfPlu frm = new criteriaSaleOfPlu(this, true);
        frm.setVisible(true);

    }//GEN-LAST:event_Rpt1ActionPerformed

    private void Mast21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast21ActionPerformed
        // TODO add your handling code here:
        setUserGroup frm = new setUserGroup(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast21ActionPerformed

    private void Mast22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast22ActionPerformed
        // TODO add your handling code here:
        setPosUser frm = new setPosUser(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast22ActionPerformed

    private void Plu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu5ActionPerformed
        // TODO add your handling code here:
        setEffective frm = new setEffective(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu5ActionPerformed

    private void Plu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu8ActionPerformed
        // TODO add your handling code here:
        setMenuList frm = new setMenuList(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu8ActionPerformed

    private void Plu7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu7ActionPerformed
        // TODO add your handling code here:
        SetPingredent frm = new SetPingredent(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu7ActionPerformed

    private void Cont3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cont3ActionPerformed
        // TODO add your handling code here:
        UserLogin userrec = UserLogin.userlogin;
        String Tempuser = userrec.getUserName();
        setBorMenuGroup frm = new setBorMenuGroup(this, true);
        frm.setVisible(true);
        UserLogin login = new UserLogin();
        if (login.setActionMenu(Tempuser)) {
            SetEnableMenu();
        } else {
            JOptionPane.showMessageDialog(this, "ไม่สามารถ Load สิทธิ์การใช้งานของผู้ใช้งานคนนี้ได้ ...");
        }
    }//GEN-LAST:event_Cont3ActionPerformed

    private void Cont4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cont4ActionPerformed
        // TODO add your handling code here:
        UserLogin userrec = UserLogin.userlogin;
        String Tempuser = userrec.getUserName();
        setBorUser frm = new setBorUser(this, true);
        frm.setVisible(true);
        UserLogin login = new UserLogin();
        if (login.setActionMenu(Tempuser)) {
            SetEnableMenu();
        } else {
            JOptionPane.showMessageDialog(this, "ไม่สามารถ Load สิทธิ์การใช้งานของผู้ใช้งานคนนี้ได้ ...");
        }
    }//GEN-LAST:event_Cont4ActionPerformed

    private void Rpt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt2ActionPerformed
        // TODO add your handling code here:
        criteriaSaleOfDept frm = new criteriaSaleOfDept(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt2ActionPerformed

    private void Rpt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt3ActionPerformed
        // TODO add your handling code here:
        criteriaTerminal frm = new criteriaTerminal(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt3ActionPerformed

    private void Rpt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt4ActionPerformed
        // TODO add your handling code here:
        criteriaCreditReport frm = new criteriaCreditReport(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt4ActionPerformed

    private void Rpt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt5ActionPerformed
        // TODO add your handling code here:
        criteriaHourly frm = new criteriaHourly(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt5ActionPerformed

    private void Rpt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt6ActionPerformed
        // TODO add your handling code here:
        criteriaRjfile frm = new criteriaRjfile(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt6ActionPerformed

    private void Rpt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt7ActionPerformed
        // TODO add your handling code here:
        criteriaStockCake frm = new criteriaStockCake(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt7ActionPerformed

    private void Rpt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt8ActionPerformed
        // TODO add your handling code here:
        criteriaSumSaleOfPlu frm = new criteriaSumSaleOfPlu(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt8ActionPerformed

    private void Rpt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt9ActionPerformed
        // TODO add your handling code here:
        criteriaSumSaleOfDate frm = new criteriaSumSaleOfDate(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt9ActionPerformed

    private void Rpt10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt10ActionPerformed
        // TODO add your handling code here:
        criteriaSumSaleOfDept frm = new criteriaSumSaleOfDept(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt10ActionPerformed

    private void Rpt11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt11ActionPerformed
        // TODO add your handling code here:
        criteriaSumSaleOfDeptByDate frm = new criteriaSumSaleOfDeptByDate(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt11ActionPerformed

    private void Rpt12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt12ActionPerformed
        // TODO add your handling code here:
        criteriaSumRjfile frm = new criteriaSumRjfile(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt12ActionPerformed

    private void Rpt13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt13ActionPerformed
        // TODO add your handling code here:
        criteriaSumTerminal frm = new criteriaSumTerminal(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt13ActionPerformed

    private void Rpt14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt14ActionPerformed
        // TODO add your handling code here:
        criteriaSumTerminalByDate frm = new criteriaSumTerminalByDate(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt14ActionPerformed

    private void Rpt15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt15ActionPerformed
        // TODO add your handling code here:
        criteriaTopSaleByQty frm = new criteriaTopSaleByQty(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt15ActionPerformed

    private void Rpt16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt16ActionPerformed
        // TODO add your handling code here:
        criteriaTopSaleByAmt frm = new criteriaTopSaleByAmt(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt16ActionPerformed

    private void Rpt17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt17ActionPerformed
        // TODO add your handling code here:
        criteriaSumStockCake frm = new criteriaSumStockCake(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt17ActionPerformed

    private void Rpt19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt19ActionPerformed
        // TODO add your handling code here:
        criteriaSumCupon frm = new criteriaSumCupon(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt19ActionPerformed

    private void Rpt20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt20ActionPerformed
        // TODO add your handling code here:
        criteriaPromotion frm = new criteriaPromotion(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt20ActionPerformed

    private void Rpt25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt25ActionPerformed
        criteriaSumPluCost frm = new criteriaSumPluCost(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt25ActionPerformed

    private void Rpt26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt26ActionPerformed
        criteriaSumDeptCost frm = new criteriaSumDeptCost(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt26ActionPerformed

    private void Rpt27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt27ActionPerformed
        criteriaEmpAvg frm = new criteriaEmpAvg(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt27ActionPerformed

    private void Rpt28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt28ActionPerformed
        criteriaCustAvg frm = new criteriaCustAvg(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt28ActionPerformed

    private void Rpt29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt29ActionPerformed
        criteriaPlaceAvg frm = new criteriaPlaceAvg(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt29ActionPerformed

    private void Rpt30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt30ActionPerformed
        criteriaVat frm = new criteriaVat(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt30ActionPerformed

    private void Rpt21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt21ActionPerformed
        criteriaCreditReport frm = new criteriaCreditReport(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt21ActionPerformed

    private void Rpt23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt23ActionPerformed
        criteriaWeeklyAvg frm = new criteriaWeeklyAvg(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt23ActionPerformed

    private void Rpt32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt32ActionPerformed
        criteriaSumHourly frm = new criteriaSumHourly(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt32ActionPerformed

    private void Rpt22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt22ActionPerformed
        criteriaComPlu frm = new criteriaComPlu(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt22ActionPerformed

    private void jMenuItem74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem74ActionPerformed
        criteriaSumPluIng frm = new criteriaSumPluIng(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem74ActionPerformed

    private void jMenuItem75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem75ActionPerformed
        criteriaSumPluIngByPlu frm = new criteriaSumPluIngByPlu(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem75ActionPerformed

    private void jMenuItem76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem76ActionPerformed
        criteriaTopPluIngByQty frm = new criteriaTopPluIngByQty(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem76ActionPerformed

    private void jMenuItem77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem77ActionPerformed
        criteriaTopPluIngByAmt frm = new criteriaTopPluIngByAmt(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem77ActionPerformed

    private void Rpt33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt33ActionPerformed
        setBudFastival frm = new setBudFastival(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt33ActionPerformed

    private void Rpt34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt34ActionPerformed
        setBudRjFile frm = new setBudRjFile(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt34ActionPerformed

    private void Rpt35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt35ActionPerformed
        TempPLU frm = new TempPLU(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt35ActionPerformed

    private void Rpt38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt38ActionPerformed
        criteriaSumMonth frm = new criteriaSumMonth(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt38ActionPerformed

    private void Rpt42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt42ActionPerformed
        criteriaLostDept frm = new criteriaLostDept(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt42ActionPerformed

    private void Rpt43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt43ActionPerformed
        criteriaSumBud frm = new criteriaSumBud(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt43ActionPerformed

    private void Rpt44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt44ActionPerformed
        criteriaBudFast frm = new criteriaBudFast(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt44ActionPerformed

    private void Rpt24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt24ActionPerformed
        criteriaDalilySale frm = new criteriaDalilySale(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt24ActionPerformed

    private void Rpt36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt36ActionPerformed
        criteriaDailyPlu frm = new criteriaDailyPlu(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt36ActionPerformed

    private void Rpt37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt37ActionPerformed
        criteriaDailyPluSum frm = new criteriaDailyPluSum(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt37ActionPerformed

    private void Rpt39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt39ActionPerformed
        criteriaFastival frm = new criteriaFastival(this, true);
        frm.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt39ActionPerformed

    private void Rpt40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt40ActionPerformed
        criteriaRptMonth frm = new criteriaRptMonth(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt40ActionPerformed

    private void Rpt41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt41ActionPerformed
        criteriaSumSaleLost frm = new criteriaSumSaleLost(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt41ActionPerformed

    private void Rpt45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt45ActionPerformed
        criteriaRangDate frm = new criteriaRangDate(this, true);
        frm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Rpt45ActionPerformed

    private void Mast23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast23ActionPerformed
        // TODO add your handling code here:
        eCouponSetup frm = new eCouponSetup(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast23ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        criteriaSumSTranSet frm = new criteriaSumSTranSet(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void Rpt47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt47ActionPerformed
        // TODO add your handling code here:
        criteriaSumeCupon frm = new criteriaSumeCupon(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt47ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        criteriaSumPSetByPlu frm = new criteriaSumPSetByPlu(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void Plu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plu1ActionPerformed
        // TODO add your handling code here:
        Deptfile frm = new Deptfile(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Plu1ActionPerformed

    private void Mast24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast24ActionPerformed
        // TODO add your handling code here:
        PropointSetup frm = new PropointSetup(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast24ActionPerformed

    private void Rpt46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt46ActionPerformed
        // TODO add your handling code here:
        checpoint frm = new checpoint();
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt46ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        setup_ingredent frm = new setup_ingredent(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getM213().equals("0")) {
            JOptionPane.showMessageDialog(null, "ำนักงานนี้ไม่สามารถเข้าใช้งาน Menu นี้ได้...");
        } else {
            report_posbom frm = new report_posbom(this, true);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getM214().equals("0")) {
            JOptionPane.showMessageDialog(null, "ำนักงานนี้ไม่สามารถเข้าใช้งาน Menu นี้ได้...");
        } else {
            setup_ingredent_standardcost frm = new setup_ingredent_standardcost(null, true);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getM215().equals("0")) {
            JOptionPane.showMessageDialog(null, "ำนักงานนี้ไม่สามารถเข้าใช้งาน Menu นี้ได้...");
        } else {
            setup_unit frm = new setup_unit(null, true);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getM216().equals("0")) {
            JOptionPane.showMessageDialog(null, "ำนักงานนี้ไม่สามารถเข้าใช้งาน Menu นี้ได้...");
        } else {
            setup_bomacc frm = new setup_bomacc(null, true);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void Rpt0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt0ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_Rpt0ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getM217().equals("0")) {
            JOptionPane.showMessageDialog(null, "ำนักงานนี้ไม่สามารถเข้าใช้งาน Menu นี้ได้...");
        } else {
            export_costproduct frm = new export_costproduct(null, true);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        GetPassword frm = new GetPassword(this, true);
        frm.setVisible(true);
        if (frm.ValidPassword) {
            processcr frm2 = new processcr(null, true);
            frm2.setVisible(true);
            
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        mainconvert frm = new mainconvert(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getM214().equals("0")) {
            JOptionPane.showMessageDialog(null, "ำนักงานนี้ไม่สามารถเข้าใช้งาน Menu นี้ได้...");
        } else {
            setup_ingredent_morn frm = new setup_ingredent_morn(null, true);
            frm.setVisible(true);
        }

    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        UserLogin userrec = UserLogin.userlogin;
        if (userrec.getM217().equals("0")) {
            JOptionPane.showMessageDialog(null, "สำนักงานนี้ไม่สามารถเข้าใช้งาน Menu นี้ได้...");
        } else {
            report_sbom frm = new report_sbom(null, true);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void Mast25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast25ActionPerformed
        // TODO add your handling code here:
        dForm_masterCampaign frm = new dForm_masterCampaign(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast25ActionPerformed

    private void Mast26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast26ActionPerformed
        // TODO add your handling code here:
        dForm_masterPromotion frm = new dForm_masterPromotion(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast26ActionPerformed

    private void Mast27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast27ActionPerformed
        dForm_masterProRedeem frm = new dForm_masterProRedeem(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Mast27ActionPerformed

    private void Mast28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast28ActionPerformed
        new masterSAP_code_inout(this, true).setVisible(true);
    }//GEN-LAST:event_Mast28ActionPerformed

    private void Mast29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast29ActionPerformed
        new masterSAP_code_distype(this, true).setVisible(true);
    }//GEN-LAST:event_Mast29ActionPerformed

    private void Mast30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mast30ActionPerformed
        masterSAP_code_cashbank mcc = new masterSAP_code_cashbank(this, true);
        mcc.setVisible(true);
    }//GEN-LAST:event_Mast30ActionPerformed

    private void Tran8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tran8ActionPerformed
        sap_updatemaster su = new sap_updatemaster(this, true);
        su.setVisible(true);
    }//GEN-LAST:event_Tran8ActionPerformed

    private void Tran9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tran9ActionPerformed
        sap_updatemaster_csv sucsv = new sap_updatemaster_csv(this, true);
        sucsv.setVisible(true);
    }//GEN-LAST:event_Tran9ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        criteriaSummaryEStampByCampaign frm = new criteriaSummaryEStampByCampaign(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        criteriaSummaryEStampByBarcode frm = new criteriaSummaryEStampByBarcode(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void Rpt51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt51ActionPerformed
        EStampdetail frm = new EStampdetail(null, true, "");
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt51ActionPerformed

    private void Rpt50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt50ActionPerformed
        criteriaEStampRedeem frm = new criteriaEStampRedeem(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt50ActionPerformed

    private void Rpt49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt49ActionPerformed
        criteriaEStampGive frm = new criteriaEStampGive(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt49ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        criteriaSAPBranch frm = new criteriaSAPBranch(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        criteriaSAPProduct frm = new criteriaSAPProduct(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void Rpt52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rpt52ActionPerformed
        criteriaActivateEStampBarcode frm = new criteriaActivateEStampBarcode(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_Rpt52ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        main_import_json mij = new main_import_json(this, true);
        mij.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        criteriaSummaryEStampByBranch frm = new criteriaSummaryEStampByBranch(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        new masterSAP_Department(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        SetTrancode frm = new SetTrancode(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        criteriaSumwasteplu frm = new criteriaSumwasteplu(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        criteriaSumwastedept frm = new criteriaSumwastedept(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
        criteriaHourlyByPlu frm = new criteriaHourlyByPlu(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        // TODO add your handling code here:
        VoidUserSetup frm = new VoidUserSetup();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        // TODO add your handling code here:
        VoidConfigSetup frm = new VoidConfigSetup();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        // TODO add your handling code here:
        Voidmailserver frm = new Voidmailserver();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        // TODO add your handling code here:
        refundMessqge frm = new refundMessqge();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        // TODO add your handling code here:
        voidmessage frm = new voidmessage();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        VoidCancel_Maindetail vcsd = new VoidCancel_Maindetail(this, true);
        vcsd.setVisible(true);
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        VoidItem_Maindetail vitd = new VoidItem_Maindetail(this, true);
        vitd.setVisible(true);
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        VoidItem_MainPoint vitp = new VoidItem_MainPoint(this, true);
        vitp.setVisible(true);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        VoidItem_Maincause vitc = new VoidItem_Maincause(this, true);
        vitc.setVisible(true);
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
      VoidCancel_MainPoint vcsp=new VoidCancel_MainPoint(this, true);
      vcsp.setVisible(true);
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        VoidCancel_MainCause vcsc=new VoidCancel_MainCause(this, true);
        vcsc.setVisible(true);
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        MainReportHourly frm = new MainReportHourly(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem33ActionPerformed

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
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new MainControl().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Cont0;
    private javax.swing.JMenuItem Cont1;
    private javax.swing.JMenuItem Cont2;
    private javax.swing.JMenuItem Cont3;
    private javax.swing.JMenuItem Cont4;
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JMenu Mast0;
    private javax.swing.JMenuItem Mast1;
    private javax.swing.JMenuItem Mast10;
    private javax.swing.JMenuItem Mast11;
    private javax.swing.JMenuItem Mast12;
    private javax.swing.JMenuItem Mast13;
    private javax.swing.JMenuItem Mast14;
    private javax.swing.JMenuItem Mast15;
    private javax.swing.JMenuItem Mast16;
    private javax.swing.JMenuItem Mast17;
    private javax.swing.JMenuItem Mast18;
    private javax.swing.JMenuItem Mast19;
    private javax.swing.JMenuItem Mast2;
    private javax.swing.JMenuItem Mast20;
    private javax.swing.JMenuItem Mast21;
    private javax.swing.JMenuItem Mast22;
    private javax.swing.JMenuItem Mast23;
    private javax.swing.JMenuItem Mast24;
    private javax.swing.JMenuItem Mast25;
    private javax.swing.JMenuItem Mast26;
    private javax.swing.JMenuItem Mast27;
    private javax.swing.JMenuItem Mast28;
    private javax.swing.JMenuItem Mast29;
    private javax.swing.JMenuItem Mast3;
    private javax.swing.JMenuItem Mast30;
    private javax.swing.JMenuItem Mast4;
    private javax.swing.JMenuItem Mast5;
    private javax.swing.JMenuItem Mast6;
    private javax.swing.JMenuItem Mast7;
    private javax.swing.JMenuItem Mast8;
    private javax.swing.JMenuItem Mast9;
    private javax.swing.JMenu MastGroup1;
    private javax.swing.JMenu MastGroup2;
    private javax.swing.JMenuItem Plu1;
    private javax.swing.JMenuItem Plu10;
    private javax.swing.JMenuItem Plu11;
    private javax.swing.JMenuItem Plu12;
    private javax.swing.JMenuItem Plu13;
    private javax.swing.JMenuItem Plu14;
    private javax.swing.JMenu Plu1_1;
    private javax.swing.JMenuItem Plu2;
    private javax.swing.JMenuItem Plu3;
    private javax.swing.JMenuItem Plu4;
    private javax.swing.JMenuItem Plu5;
    private javax.swing.JMenuItem Plu6;
    private javax.swing.JMenuItem Plu7;
    private javax.swing.JMenuItem Plu8;
    private javax.swing.JMenuItem Plu9;
    private javax.swing.JMenu Rpt0;
    private javax.swing.JMenuItem Rpt1;
    private javax.swing.JMenuItem Rpt10;
    private javax.swing.JMenuItem Rpt11;
    private javax.swing.JMenuItem Rpt12;
    private javax.swing.JMenuItem Rpt13;
    private javax.swing.JMenuItem Rpt14;
    private javax.swing.JMenuItem Rpt15;
    private javax.swing.JMenuItem Rpt16;
    private javax.swing.JMenuItem Rpt17;
    private javax.swing.JMenuItem Rpt18;
    private javax.swing.JMenuItem Rpt19;
    private javax.swing.JMenuItem Rpt2;
    private javax.swing.JMenuItem Rpt20;
    private javax.swing.JMenuItem Rpt21;
    private javax.swing.JMenuItem Rpt22;
    private javax.swing.JMenuItem Rpt23;
    private javax.swing.JMenuItem Rpt24;
    private javax.swing.JMenuItem Rpt25;
    private javax.swing.JMenuItem Rpt26;
    private javax.swing.JMenuItem Rpt27;
    private javax.swing.JMenuItem Rpt28;
    private javax.swing.JMenuItem Rpt29;
    private javax.swing.JMenuItem Rpt3;
    private javax.swing.JMenuItem Rpt30;
    private javax.swing.JMenu Rpt31;
    private javax.swing.JMenuItem Rpt32;
    private javax.swing.JMenuItem Rpt33;
    private javax.swing.JMenuItem Rpt34;
    private javax.swing.JMenuItem Rpt35;
    private javax.swing.JMenuItem Rpt36;
    private javax.swing.JMenuItem Rpt37;
    private javax.swing.JMenuItem Rpt38;
    private javax.swing.JMenuItem Rpt39;
    private javax.swing.JMenuItem Rpt4;
    private javax.swing.JMenuItem Rpt40;
    private javax.swing.JMenuItem Rpt41;
    private javax.swing.JMenuItem Rpt42;
    private javax.swing.JMenuItem Rpt43;
    private javax.swing.JMenuItem Rpt44;
    private javax.swing.JMenuItem Rpt45;
    private javax.swing.JMenuItem Rpt46;
    private javax.swing.JMenuItem Rpt47;
    private javax.swing.JMenu Rpt48;
    private javax.swing.JMenuItem Rpt49;
    private javax.swing.JMenuItem Rpt5;
    private javax.swing.JMenuItem Rpt50;
    private javax.swing.JMenuItem Rpt51;
    private javax.swing.JMenuItem Rpt52;
    private javax.swing.JMenuItem Rpt6;
    private javax.swing.JMenuItem Rpt7;
    private javax.swing.JMenuItem Rpt8;
    private javax.swing.JMenuItem Rpt9;
    private javax.swing.JMenu RptGroup1;
    private javax.swing.JMenu RptGroup2;
    private javax.swing.JMenu RptGroup3;
    private javax.swing.JMenu RptGroup4;
    private javax.swing.JMenu Tran0;
    private javax.swing.JMenuItem Tran1;
    private javax.swing.JMenuItem Tran2;
    private javax.swing.JMenuItem Tran3;
    private javax.swing.JMenuItem Tran4;
    private javax.swing.JMenuItem Tran5;
    private javax.swing.JMenuItem Tran6;
    private javax.swing.JMenuItem Tran7;
    private javax.swing.JMenuItem Tran8;
    private javax.swing.JMenuItem Tran9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem128;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem74;
    private javax.swing.JMenuItem jMenuItem75;
    private javax.swing.JMenuItem jMenuItem76;
    private javax.swing.JMenuItem jMenuItem77;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItem92;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator25;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JPopupMenu.Separator jSeparator27;
    private javax.swing.JPopupMenu.Separator jSeparator28;
    private javax.swing.JPopupMenu.Separator jSeparator29;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator30;
    private javax.swing.JPopupMenu.Separator jSeparator31;
    private javax.swing.JPopupMenu.Separator jSeparator32;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JPanel loginpanel;
    private javax.swing.JTextField userlogin;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
