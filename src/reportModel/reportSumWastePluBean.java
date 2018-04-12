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
public class reportSumWastePluBean {
    private String s_bran;
    private String s_dept;
    private String s_pcode;
    private String pname;
    private String pprice;
    private String punit;
    private String qty;
    private String amt;
    
    public List<reportSumWastePluBean> children = new ArrayList<reportSumWastePluBean>();

    public reportSumWastePluBean() {
    }

    public reportSumWastePluBean(String s_bran, String s_dept, String s_pcode, String pname, String pprice, String punit, String e_qty, String e_amt) {
        this.s_bran = s_bran;
        this.s_dept = s_dept;
        this.s_pcode = s_pcode;
        this.pname = pname;
        this.pprice = pprice;
        this.punit = punit;
        this.qty = e_qty;
        this.amt = e_amt;
    }

    public List<reportSumWastePluBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSumWastePluBean> children) {
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

    
}
