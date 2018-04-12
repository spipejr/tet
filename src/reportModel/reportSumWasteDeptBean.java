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
public class reportSumWasteDeptBean {
    private String s_bran;
    private String s_dept;
    private String pname;
    private String qty;
    private String amt;
    
    public List<reportSumWasteDeptBean> children = new ArrayList<reportSumWasteDeptBean>();

    public reportSumWasteDeptBean() {
    }

    public reportSumWasteDeptBean(String s_bran, String s_dept, String pname,  String e_qty, String e_amt) {
        this.s_bran = s_bran;
        this.s_dept = s_dept;
        this.pname = pname;
        this.qty = e_qty;
        this.amt = e_amt;
    }

    public List<reportSumWasteDeptBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSumWasteDeptBean> children) {
        this.children = children;
    }

 

    public String getE_amt() {
        return amt;
    }

    public void setE_amt(String e_amt) {
        this.amt = e_amt;
    }

    public String getE_qty() {
        return qty;
    }

    public void setE_qty(String e_qty) {
        this.qty = e_qty;
    }


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    
}
