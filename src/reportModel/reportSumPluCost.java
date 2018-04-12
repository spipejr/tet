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
public class reportSumPluCost {
    private String s_bran;
    private String s_dept;
    private String s_pcode;
    private String pname;
    private String pprice;
    private String punit;
    private String s_qty;
    private String s_amt;
    private String totalcost;
    private String s_per;
    public List<reportSumPluCost> children = new ArrayList<reportSumPluCost>();

    public reportSumPluCost(String s_bran, String s_dept, String s_pcode, String pname, String pprice, String punit, String s_qty, String s_amt, String totalcost, String s_per) {
        this.s_bran = s_bran;
        this.s_dept = s_dept;
        this.s_pcode = s_pcode;
        this.pname = pname;
        this.pprice = pprice;
        this.punit = punit;
        this.s_qty = s_qty;
        this.s_amt = s_amt;
        this.totalcost = totalcost;
        this.s_per = s_per;
    }

    public reportSumPluCost() {
    }

    public List<reportSumPluCost> getChildren() {
        return children;
    }

    public void setChildren(List<reportSumPluCost> children) {
        this.children = children;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }

    public String getPunit() {
        return punit;
    }

    public void setPunit(String punit) {
        this.punit = punit;
    }

    public String getS_amt() {
        return s_amt;
    }

    public void setS_amt(String s_amt) {
        this.s_amt = s_amt;
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

    public String getS_pcode() {
        return s_pcode;
    }

    public void setS_pcode(String s_pcode) {
        this.s_pcode = s_pcode;
    }

    public String getS_per() {
        return s_per;
    }

    public void setS_per(String s_per) {
        this.s_per = s_per;
    }

    public String getS_qty() {
        return s_qty;
    }

    public void setS_qty(String s_qty) {
        this.s_qty = s_qty;
    }

    public String getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost;
    }
    
    
    
}
