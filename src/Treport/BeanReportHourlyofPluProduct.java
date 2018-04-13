/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treport;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pos
 */
public class BeanReportHourlyofPluProduct {
    private String pUnit;
    private String hour;
    private String pcode;
    private String pdesc;
    private String qty;
    private String price;
    public List<BeanReportHourlyofPluProduct> children = new ArrayList<BeanReportHourlyofPluProduct>();
    private String s_bran;
    
    public BeanReportHourlyofPluProduct() {
    }

    public BeanReportHourlyofPluProduct(String s_bran, String hour, String pcode, String pdesc, String qty, String price,String pUnit) {
        this.s_bran = s_bran;
        this.pUnit = pUnit;
        this.hour = hour;
        this.pcode = pcode;
        this.pdesc = pdesc;
        this.qty = qty;
        this.price = price;
    }

    
    public List<BeanReportHourlyofPluProduct> getChildren() {
        return children;
    }

    public void setChildren(List<BeanReportHourlyofPluProduct> children) {
        this.children = children;
    }
    
    public String getPUnit() {
        return pUnit;
    }

    public void setPUnit(String pUnit) {
        this.pUnit = pUnit;
    }
    
    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
    
    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
    
    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }
    
    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getS_bran() {
        return s_bran;
    }

    public void setS_bran(String s_bran) {
        this.s_bran = s_bran;
    }
}
