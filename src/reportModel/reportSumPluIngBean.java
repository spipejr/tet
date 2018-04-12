/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s386
 */
public class reportSumPluIngBean {
    private String s_bran;
    private String s_dept;
    private String s_deptname;
    private String pcode;
    private String pname;
    private String price;
    private String unit;
    private String qty;
    private String totcost;
    public List<reportSumPluIngBean> children = new ArrayList<reportSumPluIngBean>();

    public reportSumPluIngBean(String s_bran, String s_dept, String s_deptname, String pcode, String pname, String price, String unit, String qty, String totcost) {
        this.s_bran = s_bran;
        this.s_dept = s_dept;
        this.s_deptname = s_deptname;
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.unit = unit;
        this.qty = qty;
        this.totcost = totcost;
    }

    public reportSumPluIngBean() {
    }

    public List<reportSumPluIngBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSumPluIngBean> children) {
        this.children = children;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getS_bran() {
        return s_bran;
    }

    public void setS_bran(String s_bran) {
        this.s_bran = s_bran;
    }

    public String getS_dept() {
        return s_dept;
    }

    public void setS_dept(String s_dept) {
        this.s_dept = s_dept;
    }

    public String getS_deptname() {
        return s_deptname;
    }

    public void setS_deptname(String s_deptname) {
        this.s_deptname = s_deptname;
    }

    public String getTotcost() {
        return totcost;
    }

    public void setTotcost(String totcost) {
        this.totcost = totcost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
}
