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

public class reportSumDeptCostBean {
    private String s_bran;
    private String s_dept;
    private String pname;
    private String s_qty;
    private String s_amt;
    private String totalcost;
    private String s_per;
    public List<reportSumDeptCostBean> children = new ArrayList<reportSumDeptCostBean>();

    public reportSumDeptCostBean(String s_bran, String s_dept, String pname, String s_qty, String s_amt, String totalcost, String s_per) {
        this.s_bran = s_bran;
        this.s_dept = s_dept;
        this.pname = pname;
        this.s_qty = s_qty;
        this.s_amt = s_amt;
        this.totalcost = totalcost;
        this.s_per = s_per;
    }

    public reportSumDeptCostBean() {
    }

    public List<reportSumDeptCostBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSumDeptCostBean> children) {
        this.children = children;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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
