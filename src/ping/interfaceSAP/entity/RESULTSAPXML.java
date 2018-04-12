/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.json.*;
import ping.interfaceSAP.showMessage;

/**
 *
 * @author soneping
 */
public class RESULTSAPXML {
    private String strdate;
    private String filename;
    private String sitecode;
    private String sitecondition;
    private String costcenter;
    private String branchtype;
    private String branchcode;
    
    private String ZRTINT16_filename;
    private String ZRTINT16_haveData;
    private String ZRTINT16_haveArticle;
    private String ZRTINT16_error;
    
    private String ZGLINT04_filename;
    private String ZGLINT04_haveData;
    private String ZGLINT04_error;
    
    private String ZRTINT08_305_filename;
    private String ZRTINT08_305_haveData;
    private String ZRTINT08_305_haveArticle;
    private String ZRTINT08_305_error;
    
    private String ZRTINT08_303_filename;
    private String ZRTINT08_303_haveData;
    private String ZRTINT08_303_haveArticle;
    private String ZRTINT08_303_error;
    
    private String ZRTINT15_filename;
    private String ZRTINT15_haveData;
    private String ZRTINT15_haveArticle;
    private String ZRTINT15_error;
    
    private String ZRTINT05_filename;
    private String ZRTINT05_haveData;
    private String ZRTINT05_haveArticle;
    private String ZRTINT05_error;
    
    private String ZRTINT10_filename;
    private String ZRTINT10_haveData;
    private String ZRTINT10_haveArticle;
    private String ZRTINT10_error;
    private double ZRTINT10_zPOS;
    private String ZRTINT10_zPOSSIGN;
    private double ZRTINT10_sumX;
    private double ZRTINT10_sumX_sumZS11_Service;
    private double ZRTINT10_sumX_sumTAX;
    private double ZRTINT10_sumX_sumZAR0_SIGNPLUS;
    private double ZRTINT10_sumX_sumACTUALSALEPRICE;
    private double ZRTINT10_sumX_sumZDIF_SIGNPLUS;
    private double ZRTINT10_sumY;
    private double ZRTINT10_sumY_sumZGIF;
    private double ZRTINT10_sumY_sumZEVC;
    private double ZRTINT10_sumY_sumCD123;
    private double ZRTINT10_sumY_sumZD14_Mem;
    private double ZRTINT10_sumY_sumZDIF_SIGN_;
    private double ZRTINT10_sumY_sumSMS;
    private double ZRTINT10_sumY_sumPAYIN;
    private double ZRTINT10_sumY_sumZD08;
    private double ZRTINT10_sumY_sumZD07;
    private double ZRTINT10_sumY_sumZVCH;
    private double ZRTINT10_sumY_sumZARC;
    private double ZRTINT10_sumY_sumSMC;
    private double ZRTINT10_sumY_sumZD04_Deposit;
    private double ZRTINT10_sumY_sumZD13_Emp;
    private double ZRTINT10_sumY_sumZD15_Pro;
    private double ZRTINT10_sumY_sumZAR0_SIGN_;
    private double ZRTINT10_sumY_sumZT2P;
    private ArrayList<RESULTSAPXML_articlelost> listLost;
    
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

    public String getStrdate() {
        return strdate;
    }

    public void setStrdate(String strdate) {
        this.strdate = strdate;
    }

    public RESULTSAPXML() {
    }

    public RESULTSAPXML(String strdate, String filename, String sitecode, String sitecondition, String costcenter, String branchtype, String branchcode, String ZRTINT16_filename, String ZRTINT16_haveData, String ZRTINT16_haveArticle, String ZRTINT16_error, String ZGLINT04_filename, String ZGLINT04_haveData, String ZGLINT04_error, String ZRTINT08_305_filename, String ZRTINT08_305_haveData, String ZRTINT08_305_haveArticle, String ZRTINT08_305_error, String ZRTINT08_303_filename, String ZRTINT08_303_haveData, String ZRTINT08_303_haveArticle, String ZRTINT08_303_error, String ZRTINT15_filename, String ZRTINT15_haveData, String ZRTINT15_haveArticle, String ZRTINT15_error, String ZRTINT05_filename, String ZRTINT05_haveData, String ZRTINT05_haveArticle, String ZRTINT05_error, String ZRTINT10_filename, String ZRTINT10_haveData, String ZRTINT10_haveArticle, String ZRTINT10_error, double ZRTINT10_zPOS, String ZRTINT10_zPOSSIGN, double ZRTINT10_sumX, double ZRTINT10_sumX_sumZS11_Service, double ZRTINT10_sumX_sumTAX, double ZRTINT10_sumX_sumZAR0_SIGNPLUS, double ZRTINT10_sumX_sumACTUALSALEPRICE, double ZRTINT10_sumX_sumZDIF_SIGNPLUS, double ZRTINT10_sumY, double ZRTINT10_sumY_sumZGIF, double ZRTINT10_sumY_sumZEVC, double ZRTINT10_sumY_sumCD123, double ZRTINT10_sumY_sumZD14_Mem, double ZRTINT10_sumY_sumZDIF_SIGN_, double ZRTINT10_sumY_sumSMS, double ZRTINT10_sumY_sumPAYIN, double ZRTINT10_sumY_sumZD08, double ZRTINT10_sumY_sumZD07, double ZRTINT10_sumY_sumZVCH, double ZRTINT10_sumY_sumZARC, double ZRTINT10_sumY_sumSMC, double ZRTINT10_sumY_sumZD04_Deposit, double ZRTINT10_sumY_sumZD13_Emp, double ZRTINT10_sumY_sumZD15_Pro, double ZRTINT10_sumY_sumZAR0_SIGN_, double ZRTINT10_sumY_sumZT2P) {
        this.strdate = strdate;
        this.filename = filename;
        this.sitecode = sitecode;
        this.sitecondition = sitecondition;
        this.costcenter = costcenter;
        this.branchtype = branchtype;
        this.branchcode = branchcode;
        this.ZRTINT16_filename = ZRTINT16_filename;
        this.ZRTINT16_haveData = ZRTINT16_haveData;
        this.ZRTINT16_haveArticle = ZRTINT16_haveArticle;
        this.ZRTINT16_error = ZRTINT16_error;
        this.ZGLINT04_filename = ZGLINT04_filename;
        this.ZGLINT04_haveData = ZGLINT04_haveData;
        this.ZGLINT04_error = ZGLINT04_error;
        this.ZRTINT08_305_filename = ZRTINT08_305_filename;
        this.ZRTINT08_305_haveData = ZRTINT08_305_haveData;
        this.ZRTINT08_305_haveArticle = ZRTINT08_305_haveArticle;
        this.ZRTINT08_305_error = ZRTINT08_305_error;
        this.ZRTINT08_303_filename = ZRTINT08_303_filename;
        this.ZRTINT08_303_haveData = ZRTINT08_303_haveData;
        this.ZRTINT08_303_haveArticle = ZRTINT08_303_haveArticle;
        this.ZRTINT08_303_error = ZRTINT08_303_error;
        this.ZRTINT15_filename = ZRTINT15_filename;
        this.ZRTINT15_haveData = ZRTINT15_haveData;
        this.ZRTINT15_haveArticle = ZRTINT15_haveArticle;
        this.ZRTINT15_error = ZRTINT15_error;
        this.ZRTINT05_filename = ZRTINT05_filename;
        this.ZRTINT05_haveData = ZRTINT05_haveData;
        this.ZRTINT05_haveArticle = ZRTINT05_haveArticle;
        this.ZRTINT05_error = ZRTINT05_error;
        this.ZRTINT10_filename = ZRTINT10_filename;
        this.ZRTINT10_haveData = ZRTINT10_haveData;
        this.ZRTINT10_haveArticle = ZRTINT10_haveArticle;
        this.ZRTINT10_error = ZRTINT10_error;
        this.ZRTINT10_zPOS = ZRTINT10_zPOS;
        this.ZRTINT10_zPOSSIGN = ZRTINT10_zPOSSIGN;
        this.ZRTINT10_sumX = ZRTINT10_sumX;
        this.ZRTINT10_sumX_sumZS11_Service = ZRTINT10_sumX_sumZS11_Service;
        this.ZRTINT10_sumX_sumTAX = ZRTINT10_sumX_sumTAX;
        this.ZRTINT10_sumX_sumZAR0_SIGNPLUS = ZRTINT10_sumX_sumZAR0_SIGNPLUS;
        this.ZRTINT10_sumX_sumACTUALSALEPRICE = ZRTINT10_sumX_sumACTUALSALEPRICE;
        this.ZRTINT10_sumX_sumZDIF_SIGNPLUS = ZRTINT10_sumX_sumZDIF_SIGNPLUS;
        this.ZRTINT10_sumY = ZRTINT10_sumY;
        this.ZRTINT10_sumY_sumZGIF = ZRTINT10_sumY_sumZGIF;
        this.ZRTINT10_sumY_sumZEVC = ZRTINT10_sumY_sumZEVC;
        this.ZRTINT10_sumY_sumCD123 = ZRTINT10_sumY_sumCD123;
        this.ZRTINT10_sumY_sumZD14_Mem = ZRTINT10_sumY_sumZD14_Mem;
        this.ZRTINT10_sumY_sumZDIF_SIGN_ = ZRTINT10_sumY_sumZDIF_SIGN_;
        this.ZRTINT10_sumY_sumSMS = ZRTINT10_sumY_sumSMS;
        this.ZRTINT10_sumY_sumPAYIN = ZRTINT10_sumY_sumPAYIN;
        this.ZRTINT10_sumY_sumZD08 = ZRTINT10_sumY_sumZD08;
        this.ZRTINT10_sumY_sumZD07 = ZRTINT10_sumY_sumZD07;
        this.ZRTINT10_sumY_sumZVCH = ZRTINT10_sumY_sumZVCH;
        this.ZRTINT10_sumY_sumZARC = ZRTINT10_sumY_sumZARC;
        this.ZRTINT10_sumY_sumSMC = ZRTINT10_sumY_sumSMC;
        this.ZRTINT10_sumY_sumZD04_Deposit = ZRTINT10_sumY_sumZD04_Deposit;
        this.ZRTINT10_sumY_sumZD13_Emp = ZRTINT10_sumY_sumZD13_Emp;
        this.ZRTINT10_sumY_sumZD15_Pro = ZRTINT10_sumY_sumZD15_Pro;
        this.ZRTINT10_sumY_sumZAR0_SIGN_ = ZRTINT10_sumY_sumZAR0_SIGN_;
        this.ZRTINT10_sumY_sumZT2P = ZRTINT10_sumY_sumZT2P;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSitecode() {
        return sitecode;
    }

    public void setSitecode(String sitecode) {
        this.sitecode = sitecode;
    }

    public String getSitecondition() {
        return sitecondition;
    }

    public void setSitecondition(String sitecondition) {
        this.sitecondition = sitecondition;
    }

    public String getCostcenter() {
        return costcenter;
    }

    public void setCostcenter(String costcenter) {
        this.costcenter = costcenter;
    }

    public String getBranchtype() {
        return branchtype;
    }

    public void setBranchtype(String branchtype) {
        this.branchtype = branchtype;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getZRTINT16_filename() {
        return ZRTINT16_filename;
    }

    public void setZRTINT16_filename(String ZRTINT16_filename) {
        this.ZRTINT16_filename = ZRTINT16_filename;
    }

    public String getZRTINT16_haveData() {
        return ZRTINT16_haveData;
    }

    public void setZRTINT16_haveData(String ZRTINT16_haveData) {
        this.ZRTINT16_haveData = ZRTINT16_haveData;
    }

    public String getZRTINT16_haveArticle() {
        return ZRTINT16_haveArticle;
    }

    public void setZRTINT16_haveArticle(String ZRTINT16_haveArticle) {
        this.ZRTINT16_haveArticle = ZRTINT16_haveArticle;
    }

    public String getZRTINT16_error() {
        return ZRTINT16_error;
    }

    public void setZRTINT16_error(String ZRTINT16_error) {
        this.ZRTINT16_error = ZRTINT16_error;
    }

    public String getZGLINT04_filename() {
        return ZGLINT04_filename;
    }

    public void setZGLINT04_filename(String ZGLINT04_filename) {
        this.ZGLINT04_filename = ZGLINT04_filename;
    }

    public String getZGLINT04_haveData() {
        return ZGLINT04_haveData;
    }

    public void setZGLINT04_haveData(String ZGLINT04_haveData) {
        this.ZGLINT04_haveData = ZGLINT04_haveData;
    }

    public String getZGLINT04_error() {
        return ZGLINT04_error;
    }

    public void setZGLINT04_error(String ZGLINT04_error) {
        this.ZGLINT04_error = ZGLINT04_error;
    }

    public String getZRTINT08_305_filename() {
        return ZRTINT08_305_filename;
    }

    public void setZRTINT08_305_filename(String ZRTINT08_305_filename) {
        this.ZRTINT08_305_filename = ZRTINT08_305_filename;
    }

    public String getZRTINT08_305_haveData() {
        return ZRTINT08_305_haveData;
    }

    public void setZRTINT08_305_haveData(String ZRTINT08_305_haveData) {
        this.ZRTINT08_305_haveData = ZRTINT08_305_haveData;
    }

    public String getZRTINT08_305_haveArticle() {
        return ZRTINT08_305_haveArticle;
    }

    public void setZRTINT08_305_haveArticle(String ZRTINT08_305_haveArticle) {
        this.ZRTINT08_305_haveArticle = ZRTINT08_305_haveArticle;
    }

    public String getZRTINT08_305_error() {
        return ZRTINT08_305_error;
    }

    public void setZRTINT08_305_error(String ZRTINT08_305_error) {
        this.ZRTINT08_305_error = ZRTINT08_305_error;
    }

    public String getZRTINT08_303_filename() {
        return ZRTINT08_303_filename;
    }

    public void setZRTINT08_303_filename(String ZRTINT08_303_filename) {
        this.ZRTINT08_303_filename = ZRTINT08_303_filename;
    }

    public String getZRTINT08_303_haveData() {
        return ZRTINT08_303_haveData;
    }

    public void setZRTINT08_303_haveData(String ZRTINT08_303_haveData) {
        this.ZRTINT08_303_haveData = ZRTINT08_303_haveData;
    }

    public String getZRTINT08_303_haveArticle() {
        return ZRTINT08_303_haveArticle;
    }

    public void setZRTINT08_303_haveArticle(String ZRTINT08_303_haveArticle) {
        this.ZRTINT08_303_haveArticle = ZRTINT08_303_haveArticle;
    }

    public String getZRTINT08_303_error() {
        return ZRTINT08_303_error;
    }

    public void setZRTINT08_303_error(String ZRTINT08_303_error) {
        this.ZRTINT08_303_error = ZRTINT08_303_error;
    }

    public String getZRTINT15_filename() {
        return ZRTINT15_filename;
    }

    public void setZRTINT15_filename(String ZRTINT15_filename) {
        this.ZRTINT15_filename = ZRTINT15_filename;
    }

    public String getZRTINT15_haveData() {
        return ZRTINT15_haveData;
    }

    public void setZRTINT15_haveData(String ZRTINT15_haveData) {
        this.ZRTINT15_haveData = ZRTINT15_haveData;
    }

    public String getZRTINT15_haveArticle() {
        return ZRTINT15_haveArticle;
    }

    public void setZRTINT15_haveArticle(String ZRTINT15_haveArticle) {
        this.ZRTINT15_haveArticle = ZRTINT15_haveArticle;
    }

    public String getZRTINT15_error() {
        return ZRTINT15_error;
    }

    public void setZRTINT15_error(String ZRTINT15_error) {
        this.ZRTINT15_error = ZRTINT15_error;
    }

    public String getZRTINT05_filename() {
        return ZRTINT05_filename;
    }

    public void setZRTINT05_filename(String ZRTINT05_filename) {
        this.ZRTINT05_filename = ZRTINT05_filename;
    }

    public String getZRTINT05_haveData() {
        return ZRTINT05_haveData;
    }

    public void setZRTINT05_haveData(String ZRTINT05_haveData) {
        this.ZRTINT05_haveData = ZRTINT05_haveData;
    }

    public String getZRTINT05_haveArticle() {
        return ZRTINT05_haveArticle;
    }

    public void setZRTINT05_haveArticle(String ZRTINT05_haveArticle) {
        this.ZRTINT05_haveArticle = ZRTINT05_haveArticle;
    }

    public String getZRTINT05_error() {
        return ZRTINT05_error;
    }

    public void setZRTINT05_error(String ZRTINT05_error) {
        this.ZRTINT05_error = ZRTINT05_error;
    }

    public String getZRTINT10_filename() {
        return ZRTINT10_filename;
    }

    public void setZRTINT10_filename(String ZRTINT10_filename) {
        this.ZRTINT10_filename = ZRTINT10_filename;
    }

    public String getZRTINT10_haveData() {
        return ZRTINT10_haveData;
    }

    public void setZRTINT10_haveData(String ZRTINT10_haveData) {
        this.ZRTINT10_haveData = ZRTINT10_haveData;
    }

    public String getZRTINT10_haveArticle() {
        return ZRTINT10_haveArticle;
    }

    public void setZRTINT10_haveArticle(String ZRTINT10_haveArticle) {
        this.ZRTINT10_haveArticle = ZRTINT10_haveArticle;
    }

    public String getZRTINT10_error() {
        return ZRTINT10_error;
    }

    public void setZRTINT10_error(String ZRTINT10_error) {
        this.ZRTINT10_error = ZRTINT10_error;
    }

    public double getZRTINT10_zPOS() {
        return ZRTINT10_zPOS;
    }

    public void setZRTINT10_zPOS(double ZRTINT10_zPOS) {
        this.ZRTINT10_zPOS = ZRTINT10_zPOS;
    }

    public String getZRTINT10_zPOSSIGN() {
        return ZRTINT10_zPOSSIGN;
    }

    public void setZRTINT10_zPOSSIGN(String ZRTINT10_zPOSSIGN) {
        this.ZRTINT10_zPOSSIGN = ZRTINT10_zPOSSIGN;
    }

    public double getZRTINT10_sumX() {
        return ZRTINT10_sumX;
    }

    public void setZRTINT10_sumX(double ZRTINT10_sumX) {
        this.ZRTINT10_sumX = ZRTINT10_sumX;
    }

    public double getZRTINT10_sumX_sumZS11_Service() {
        return ZRTINT10_sumX_sumZS11_Service;
    }

    public void setZRTINT10_sumX_sumZS11_Service(double ZRTINT10_sumX_sumZS11_Service) {
        this.ZRTINT10_sumX_sumZS11_Service = ZRTINT10_sumX_sumZS11_Service;
    }

    public double getZRTINT10_sumX_sumTAX() {
        return ZRTINT10_sumX_sumTAX;
    }

    public void setZRTINT10_sumX_sumTAX(double ZRTINT10_sumX_sumTAX) {
        this.ZRTINT10_sumX_sumTAX = ZRTINT10_sumX_sumTAX;
    }

    public double getZRTINT10_sumX_sumZAR0_SIGNPLUS() {
        return ZRTINT10_sumX_sumZAR0_SIGNPLUS;
    }

    public void setZRTINT10_sumX_sumZAR0_SIGNPLUS(double ZRTINT10_sumX_sumZAR0_SIGNPLUS) {
        this.ZRTINT10_sumX_sumZAR0_SIGNPLUS = ZRTINT10_sumX_sumZAR0_SIGNPLUS;
    }

    public double getZRTINT10_sumX_sumACTUALSALEPRICE() {
        return ZRTINT10_sumX_sumACTUALSALEPRICE;
    }

    public void setZRTINT10_sumX_sumACTUALSALEPRICE(double ZRTINT10_sumX_sumACTUALSALEPRICE) {
        this.ZRTINT10_sumX_sumACTUALSALEPRICE = ZRTINT10_sumX_sumACTUALSALEPRICE;
    }

    public double getZRTINT10_sumX_sumZDIF_SIGNPLUS() {
        return ZRTINT10_sumX_sumZDIF_SIGNPLUS;
    }

    public void setZRTINT10_sumX_sumZDIF_SIGNPLUS(double ZRTINT10_sumX_sumZDIF_SIGNPLUS) {
        this.ZRTINT10_sumX_sumZDIF_SIGNPLUS = ZRTINT10_sumX_sumZDIF_SIGNPLUS;
    }

    public double getZRTINT10_sumY() {
        return ZRTINT10_sumY;
    }

    public void setZRTINT10_sumY(double ZRTINT10_sumY) {
        this.ZRTINT10_sumY = ZRTINT10_sumY;
    }

    public double getZRTINT10_sumY_sumZGIF() {
        return ZRTINT10_sumY_sumZGIF;
    }

    public void setZRTINT10_sumY_sumZGIF(double ZRTINT10_sumY_sumZGIF) {
        this.ZRTINT10_sumY_sumZGIF = ZRTINT10_sumY_sumZGIF;
    }

    public double getZRTINT10_sumY_sumZEVC() {
        return ZRTINT10_sumY_sumZEVC;
    }

    public void setZRTINT10_sumY_sumZEVC(double ZRTINT10_sumY_sumZEVC) {
        this.ZRTINT10_sumY_sumZEVC = ZRTINT10_sumY_sumZEVC;
    }

    public double getZRTINT10_sumY_sumCD123() {
        return ZRTINT10_sumY_sumCD123;
    }

    public void setZRTINT10_sumY_sumCD123(double ZRTINT10_sumY_sumCD123) {
        this.ZRTINT10_sumY_sumCD123 = ZRTINT10_sumY_sumCD123;
    }

    public double getZRTINT10_sumY_sumZD14_Mem() {
        return ZRTINT10_sumY_sumZD14_Mem;
    }

    public void setZRTINT10_sumY_sumZD14_Mem(double ZRTINT10_sumY_sumZD14_Mem) {
        this.ZRTINT10_sumY_sumZD14_Mem = ZRTINT10_sumY_sumZD14_Mem;
    }

    public double getZRTINT10_sumY_sumZDIF_SIGN_() {
        return ZRTINT10_sumY_sumZDIF_SIGN_;
    }

    public void setZRTINT10_sumY_sumZDIF_SIGN_(double ZRTINT10_sumY_sumZDIF_SIGN_) {
        this.ZRTINT10_sumY_sumZDIF_SIGN_ = ZRTINT10_sumY_sumZDIF_SIGN_;
    }

    public double getZRTINT10_sumY_sumSMS() {
        return ZRTINT10_sumY_sumSMS;
    }

    public void setZRTINT10_sumY_sumSMS(double ZRTINT10_sumY_sumSMS) {
        this.ZRTINT10_sumY_sumSMS = ZRTINT10_sumY_sumSMS;
    }

    public double getZRTINT10_sumY_sumPAYIN() {
        return ZRTINT10_sumY_sumPAYIN;
    }

    public void setZRTINT10_sumY_sumPAYIN(double ZRTINT10_sumY_sumPAYIN) {
        this.ZRTINT10_sumY_sumPAYIN = ZRTINT10_sumY_sumPAYIN;
    }

    public double getZRTINT10_sumY_sumZD08() {
        return ZRTINT10_sumY_sumZD08;
    }

    public void setZRTINT10_sumY_sumZD08(double ZRTINT10_sumY_sumZD08) {
        this.ZRTINT10_sumY_sumZD08 = ZRTINT10_sumY_sumZD08;
    }

    public double getZRTINT10_sumY_sumZD07() {
        return ZRTINT10_sumY_sumZD07;
    }

    public void setZRTINT10_sumY_sumZD07(double ZRTINT10_sumY_sumZD07) {
        this.ZRTINT10_sumY_sumZD07 = ZRTINT10_sumY_sumZD07;
    }

    public double getZRTINT10_sumY_sumZVCH() {
        return ZRTINT10_sumY_sumZVCH;
    }

    public void setZRTINT10_sumY_sumZVCH(double ZRTINT10_sumY_sumZVCH) {
        this.ZRTINT10_sumY_sumZVCH = ZRTINT10_sumY_sumZVCH;
    }

    public double getZRTINT10_sumY_sumZARC() {
        return ZRTINT10_sumY_sumZARC;
    }

    public void setZRTINT10_sumY_sumZARC(double ZRTINT10_sumY_sumZARC) {
        this.ZRTINT10_sumY_sumZARC = ZRTINT10_sumY_sumZARC;
    }

    public double getZRTINT10_sumY_sumSMC() {
        return ZRTINT10_sumY_sumSMC;
    }

    public void setZRTINT10_sumY_sumSMC(double ZRTINT10_sumY_sumSMC) {
        this.ZRTINT10_sumY_sumSMC = ZRTINT10_sumY_sumSMC;
    }

    public double getZRTINT10_sumY_sumZD04_Deposit() {
        return ZRTINT10_sumY_sumZD04_Deposit;
    }

    public void setZRTINT10_sumY_sumZD04_Deposit(double ZRTINT10_sumY_sumZD04_Deposit) {
        this.ZRTINT10_sumY_sumZD04_Deposit = ZRTINT10_sumY_sumZD04_Deposit;
    }

    public double getZRTINT10_sumY_sumZD13_Emp() {
        return ZRTINT10_sumY_sumZD13_Emp;
    }

    public void setZRTINT10_sumY_sumZD13_Emp(double ZRTINT10_sumY_sumZD13_Emp) {
        this.ZRTINT10_sumY_sumZD13_Emp = ZRTINT10_sumY_sumZD13_Emp;
    }

    public double getZRTINT10_sumY_sumZD15_Pro() {
        return ZRTINT10_sumY_sumZD15_Pro;
    }

    public void setZRTINT10_sumY_sumZD15_Pro(double ZRTINT10_sumY_sumZD15_Pro) {
        this.ZRTINT10_sumY_sumZD15_Pro = ZRTINT10_sumY_sumZD15_Pro;
    }

    public double getZRTINT10_sumY_sumZAR0_SIGN_() {
        return ZRTINT10_sumY_sumZAR0_SIGN_;
    }

    public void setZRTINT10_sumY_sumZAR0_SIGN_(double ZRTINT10_sumY_sumZAR0_SIGN_) {
        this.ZRTINT10_sumY_sumZAR0_SIGN_ = ZRTINT10_sumY_sumZAR0_SIGN_;
    }

    public double getZRTINT10_sumY_sumZT2P() {
        return ZRTINT10_sumY_sumZT2P;
    }

    public void setZRTINT10_sumY_sumZT2P(double ZRTINT10_sumY_sumZT2P) {
        this.ZRTINT10_sumY_sumZT2P = ZRTINT10_sumY_sumZT2P;
    }

    public ArrayList<RESULTSAPXML_articlelost> getListLost() {
        return listLost;
    }

    public void setListLost(ArrayList<RESULTSAPXML_articlelost> listLost) {
        this.listLost = listLost;
    }
    
    public void readFile(String path2filename, String strdate) {
        ArrayList<RESULTSAPXML_articlelost> list = new ArrayList<RESULTSAPXML_articlelost>();
        
        String strPath2File = path2filename;
        String strFile = "";
        File fObject = null;
        if (strPath2File.length() <= 0) {
        } else {
            fObject = new File(strPath2File);
            strFile = fObject.getName();

            int index = strFile.indexOf(".csv");
            if (strFile.substring(index, strFile.length()).equals(".csv")) {
                if (!fObject.canRead()) {
                    new showMessage().showMessageError("ไม่สามารถอ่านไฟล์ได้", "readFile(" + path2filename + ")");
                } else {
                    try {
                        boolean eof = false;
                        FileReader file = new FileReader(strPath2File);
                        BufferedReader buff = new BufferedReader(file);

                        while (!eof) {
                            String line = buff.readLine();
                            if (line == null) {
                                eof = true;
                            } else if (!line.equals("")) {
                                String json = line;
                                String branch = "";
                                JSONObject jsonObject = new JSONObject(json);
                                JSONObject subObject;
                                
                                this.filename = fObject.getName();
                                
                                subObject = jsonObject.getJSONObject("Branchfile");
                                branch = subObject.getString("Branchcode");
                                
                                this.strdate = strdate;
                                this.branchcode = branch;
                                this.branchtype = subObject.getString("BranchType");
                                this.costcenter = subObject.getString("Costcenter");
                                this.sitecode = subObject.getString("Sitecode");
                                this.sitecondition = subObject.getString("SiteCondition");
                                
                                subObject = jsonObject.getJSONObject("ZRTINT16");
                                this.ZRTINT16_filename =subObject.getString("fileName"); 
                                this.ZRTINT16_haveData =subObject.getString("haveData"); 
                                this.ZRTINT16_haveArticle = subObject.getString("haveArticle");
                                this.ZRTINT16_error = subObject.getString("errorZRTINT16");
                                
                                subObject = jsonObject.getJSONObject("ZRTINT08_305");
                                this.ZRTINT08_305_filename = subObject.getString("fileName");
                                this.ZRTINT08_305_haveData = subObject.getString("haveData");
                                this.ZRTINT08_305_haveArticle = subObject.getString("haveArticle");
                                this.ZRTINT08_305_error = subObject.getString("errorZRTINT08_305");
                                
                                subObject = jsonObject.getJSONObject("ZRTINT08_303");
                                this.ZRTINT08_303_filename = subObject.getString("fileName");
                                this.ZRTINT08_303_haveData = subObject.getString("haveData");
                                this.ZRTINT08_303_haveArticle = subObject.getString("haveArticle");
                                this.ZRTINT08_303_error = subObject.getString("errorZRTINT08_303");
                                
                                subObject = jsonObject.getJSONObject("ZRTINT05");
                                this.ZRTINT05_filename = subObject.getString("fileName");
                                this.ZRTINT05_haveData = subObject.getString("haveData");
                                this.ZRTINT05_haveArticle = subObject.getString("haveArticle");
                                this.ZRTINT05_error = subObject.getString("errorZRTINT05");
                                
                                subObject = jsonObject.getJSONObject("ZRTINT15");
                                this.ZRTINT15_filename = subObject.getString("fileName");
                                this.ZRTINT15_haveData = subObject.getString("haveData");
                                this.ZRTINT15_haveArticle = subObject.getString("haveArticle");
                                this.ZRTINT15_error = subObject.getString("errorZRTINT15");
                                
                                subObject = jsonObject.getJSONObject("ZGLINT04");
                                this.ZGLINT04_filename = subObject.getString("fileName");
                                this.ZGLINT04_haveData = subObject.getString("haveData");
                                this.ZGLINT04_error = subObject.getString("errorZGLINT04");
                                
                                subObject = jsonObject.getJSONObject("ZRTINT10");
                                this.ZRTINT10_filename = subObject.getString("fileName");
                                this.ZRTINT10_haveData = subObject.getString("haveData");
                                this.ZRTINT10_haveArticle = subObject.getString("haveArticle");
                                this.ZRTINT10_error = subObject.getString("errorZRTINT10");
                                
                                subObject = subObject.getJSONObject("zPOS");
                                this.ZRTINT10_zPOS = subObject.getDouble("ZPOS");
                                this.ZRTINT10_zPOSSIGN = subObject.getString("ZPOSSIGN");
                                
                                JSONObject SUMY = subObject.getJSONObject("SUMY");
                                JSONObject SUMX = subObject.getJSONObject("SUMX");
                                
                                this.ZRTINT10_sumX = SUMX.getDouble("sumX");
                                this.ZRTINT10_sumX_sumACTUALSALEPRICE = SUMX.getDouble("sumACTUALSALEPRICE");
                                this.ZRTINT10_sumX_sumTAX = SUMX.getDouble("sumTAX");
                                this.ZRTINT10_sumX_sumZAR0_SIGNPLUS = SUMX.getDouble("sumZAR0_SIGNPLUS");
                                this.ZRTINT10_sumX_sumZDIF_SIGNPLUS = SUMX.getDouble("sumZDIF_SIGNPLUS");
                                this.ZRTINT10_sumX_sumZS11_Service = SUMX.getDouble("sumZS11_Service");
                                
                                this.ZRTINT10_sumY = SUMY.getDouble("sumY");
                                this.ZRTINT10_sumY_sumCD123 = SUMY.getDouble("sumCD123");
                                this.ZRTINT10_sumY_sumPAYIN = SUMY.getDouble("sumPAYIN");
                                this.ZRTINT10_sumY_sumSMC = SUMY.getDouble("sumSMC");
                                this.ZRTINT10_sumY_sumSMS = SUMY.getDouble("sumSMS");
                                this.ZRTINT10_sumY_sumZAR0_SIGN_ = SUMY.getDouble("sumZAR0_SIGN_");
                                this.ZRTINT10_sumY_sumZARC = SUMY.getDouble("sumZARC");
                                this.ZRTINT10_sumY_sumZD04_Deposit = SUMY.getDouble("sumZD04_Deposit");
                                this.ZRTINT10_sumY_sumZD07 = SUMY.getDouble("sumZD07");
                                this.ZRTINT10_sumY_sumZD08 = SUMY.getDouble("sumZD08");
                                this.ZRTINT10_sumY_sumZD13_Emp = SUMY.getDouble("sumZD13_Emp");
                                this.ZRTINT10_sumY_sumZD14_Mem = SUMY.getDouble("sumZD14_Mem");
                                this.ZRTINT10_sumY_sumZD15_Pro = SUMY.getDouble("sumZD15_Pro");
                                this.ZRTINT10_sumY_sumZDIF_SIGN_ = SUMY.getDouble("sumZDIF_SIGN_");
                                this.ZRTINT10_sumY_sumZEVC = SUMY.getDouble("sumZEVC");
                                this.ZRTINT10_sumY_sumZGIF = SUMY.getDouble("sumZGIF");
                                this.ZRTINT10_sumY_sumZT2P = SUMY.getDouble("sumZT2P");
                                this.ZRTINT10_sumY_sumZVCH = SUMY.getDouble("sumZVCH");
                                
                                JSONArray arr = jsonObject.getJSONArray("ArticleLost");
                                for (int i = 0; i < arr.length(); i++) {
                                    list.add(new RESULTSAPXML_articlelost(fObject.getName(), strdate, branch, arr.getJSONObject(i).getString("PLU")));
                                }
                                this.listLost = list;
                                execute();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        new showMessage().showMessageError(e.getMessage(), "readFile");
                    } finally {
                    }
                }
            }
        }
    }
    
    public void execute() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "delete from resultsapxml where strdate=? and branchcode=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, strdate);
            ps.setString(2, branchcode);
            ps.executeUpdate();
            
            sql = "delete FROM articlelost where strdate=? and branchcode=?";
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, strdate);
            ps.setString(2, branchcode);
            ps.executeUpdate();
            
            sql = "insert into resultsapxml("
                    + "strdate,    filename,   sitecode,   sitecondition,  costcenter, branchtype, branchcode,"//7
                    + "ZGLINT04_filename,   ZGLINT04_haveData,      ZGLINT04_error,"//10
                    + "ZRTINT05_filename,   ZRTINT05_haveData,      ZRTINT05_haveArticle,   ZRTINT05_error,"//14
                    + "ZRTINT08_303_filename,   ZRTINT08_303_haveData,  ZRTINT08_303_haveArticle,   ZRTINT08_303_error,"//18
                    + "ZRTINT08_305_filename,   ZRTINT08_305_haveData,  ZRTINT08_305_haveArticle,   ZRTINT08_305_error,"//22
                    + "ZRTINT10_filename,   ZRTINT10_haveData,      ZRTINT10_haveArticle,   ZRTINT10_error,"//26
                    + "ZRTINT10_zPOS,      ZRTINT10_zPOSSIGN,"//28
                    + "ZRTINT10_sumX,"//29
                    + "ZRTINT10_sumX_sumZS11_Service,   ZRTINT10_sumX_sumTAX,   ZRTINT10_sumX_sumZAR0_SIGNPLUS,"//32
                    + "ZRTINT10_sumX_sumACTUALSALEPRICE,    ZRTINT10_sumX_sumZDIF_SIGNPLUS,"//34
                    + "ZRTINT10_sumY,"//35
                    + "ZRTINT10_sumY_sumZGIF,            ZRTINT10_sumY_sumZEVC,            ZRTINT10_sumY_sumCD123,"//38
                    + "ZRTINT10_sumY_sumZD14_Mem,     ZRTINT10_sumY_sumZDIF_SIGN_,    ZRTINT10_sumY_sumSMS,"//41
                    + "ZRTINT10_sumY_sumPAYIN,          ZRTINT10_sumY_sumZD08,            ZRTINT10_sumY_sumZD07,"//44
                    + "ZRTINT10_sumY_sumZVCH,           ZRTINT10_sumY_sumZARC,           ZRTINT10_sumY_sumSMC,"//47
                    + "ZRTINT10_sumY_sumZD04_Deposit,   ZRTINT10_sumY_sumZD13_Emp,     ZRTINT10_sumY_sumZD15_Pro,"//50
                    + "ZRTINT10_sumY_sumZAR0_SIGN_,   ZRTINT10_sumY_sumZT2P,"//52
                    + "ZRTINT15_filename,       ZRTINT15_haveData,      ZRTINT15_haveArticle,       ZRTINT15_error,"//56
                    + "ZRTINT16_filename,       ZRTINT16_haveData,      ZRTINT16_haveArticle,       ZRTINT16_error"//60
                    + ") values(?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?)";
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, strdate);
            ps.setString(2, filename);
            ps.setString(3, sitecode);
            ps.setString(4, sitecondition);
            ps.setString(5, costcenter);
            ps.setString(6, branchtype);
            ps.setString(7, branchcode);
            ps.setString(8, ZGLINT04_filename);
            ps.setString(9, ZGLINT04_haveData);
            ps.setString(10, ZGLINT04_error);
            ps.setString(11, ZRTINT05_filename);
            ps.setString(12, ZRTINT05_haveData);
            ps.setString(13, ZRTINT05_haveArticle);
            ps.setString(14, ZRTINT05_error);
            ps.setString(15, ZRTINT08_303_filename);
            ps.setString(16, ZRTINT08_303_haveData);
            ps.setString(17, ZRTINT08_303_haveArticle);
            ps.setString(18, ZRTINT08_303_error);
            ps.setString(19, ZRTINT08_305_filename);
            ps.setString(20, ZRTINT08_305_haveData);
            ps.setString(21, ZRTINT08_305_haveArticle);
            ps.setString(22, ZRTINT08_305_error);
            ps.setString(23, ZRTINT10_filename);
            ps.setString(24, ZRTINT10_haveData);
            ps.setString(25, ZRTINT10_haveArticle);
            ps.setString(26, ZRTINT10_error);
            ps.setDouble(27, ZRTINT10_zPOS);
            ps.setString(28, ZRTINT10_zPOSSIGN);
            ps.setDouble(29, ZRTINT10_sumX);
            ps.setDouble(30, ZRTINT10_sumX_sumZS11_Service);
            ps.setDouble(31, ZRTINT10_sumX_sumTAX);
            ps.setDouble(32, ZRTINT10_sumX_sumZAR0_SIGNPLUS);
            ps.setDouble(33, ZRTINT10_sumX_sumACTUALSALEPRICE);
            ps.setDouble(34, ZRTINT10_sumX_sumZDIF_SIGNPLUS);
            ps.setDouble(35, ZRTINT10_sumY);
            ps.setDouble(36, ZRTINT10_sumY_sumZGIF);
            ps.setDouble(37, ZRTINT10_sumY_sumZEVC);
            ps.setDouble(38, ZRTINT10_sumY_sumCD123);
            ps.setDouble(39, ZRTINT10_sumY_sumZD14_Mem);
            ps.setDouble(40, ZRTINT10_sumY_sumZDIF_SIGN_);
            ps.setDouble(41, ZRTINT10_sumY_sumSMS);
            ps.setDouble(42, ZRTINT10_sumY_sumPAYIN);
            ps.setDouble(43, ZRTINT10_sumY_sumZD08);
            ps.setDouble(44, ZRTINT10_sumY_sumZD07);
            ps.setDouble(45, ZRTINT10_sumY_sumZVCH);
            ps.setDouble(46, ZRTINT10_sumY_sumZARC);
            ps.setDouble(47, ZRTINT10_sumY_sumSMC);
            ps.setDouble(48, ZRTINT10_sumY_sumZD04_Deposit);
            ps.setDouble(49, ZRTINT10_sumY_sumZD13_Emp);
            ps.setDouble(50, ZRTINT10_sumY_sumZD15_Pro);
            ps.setDouble(51, ZRTINT10_sumY_sumZAR0_SIGN_);
            ps.setDouble(52, ZRTINT10_sumY_sumZT2P);
            ps.setString(53, ZRTINT15_filename);
            ps.setString(54, ZRTINT15_haveData);
            ps.setString(55, ZRTINT15_haveArticle);
            ps.setString(56, ZRTINT15_error);
            ps.setString(57, ZRTINT16_filename);
            ps.setString(58, ZRTINT16_haveData);
            ps.setString(59, ZRTINT16_haveArticle);
            ps.setString(60, ZRTINT16_error);
            ps.executeUpdate();
            
            RESULTSAPXML_articlelost ral = new RESULTSAPXML_articlelost();
            ral.execute(listLost);
        } catch (Exception e) {
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "RESULTSAPXML.execute()");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
    }
}
