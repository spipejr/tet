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
public class reportTopSaleByAmtBean {
    
    private String s_bran;
    private String s_dept;
    private String no;
    private String s_pcode;
    private String pname;
    private String pprice;
    private String punit;
    private String sumqty;
    private String sumamt;
    public List<reportTopSaleByAmtBean> children = new ArrayList<reportTopSaleByAmtBean>();

    public reportTopSaleByAmtBean() {
    }

    public reportTopSaleByAmtBean(String s_bran, String s_dept, String no, String s_pcode, String pname, String pprice, String punit, String sumqty, String sumamt) {
        this.s_bran = s_bran;
        this.s_dept = s_dept;
        this.no = no;
        this.s_pcode = s_pcode;
        this.pname = pname;
        this.pprice = pprice;
        this.punit = punit;
        this.sumqty = sumqty;
        this.sumamt = sumamt;
    }

    public List<reportTopSaleByAmtBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportTopSaleByAmtBean> children) {
        this.children = children;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getSumamt() {
        return sumamt;
    }

    public void setSumamt(String sumamt) {
        this.sumamt = sumamt;
    }

    public String getSumqty() {
        return sumqty;
    }

    public void setSumqty(String sumqty) {
        this.sumqty = sumqty;
    }
    
    
}
