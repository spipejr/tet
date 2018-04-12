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
public class reportComPluBean {
    private String bran;
    private String dept;
    private String pcode;
    private String pname;
    private String price;
    private String punit;
    private String com1;
    private String com2;
    private String com3;
    private String com4;
    private String com5;
    private String com6;
    private String com7;
    private String com8;
    public List<reportComPluBean> children = new ArrayList<reportComPluBean>();

    public reportComPluBean(String bran, String dept, String pcode, String pname, String price, String punit, String com1, String com2, String com3, String com4, String com5, String com6, String com7, String com8) {
        this.bran = bran;
        this.dept = dept;
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.punit = punit;
        this.com1 = com1;
        this.com2 = com2;
        this.com3 = com3;
        this.com4 = com4;
        this.com5 = com5;
        this.com6 = com6;
        this.com7 = com7;
        this.com8 = com8;
    }

    public reportComPluBean() {
    }

    public String getBran() {
        return bran;
    }

    public void setBran(String bran) {
        this.bran = bran;
    }

    public List<reportComPluBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportComPluBean> children) {
        this.children = children;
    }

    public String getCom1() {
        return com1;
    }

    public void setCom1(String com1) {
        this.com1 = com1;
    }

    public String getCom2() {
        return com2;
    }

    public void setCom2(String com2) {
        this.com2 = com2;
    }

    public String getCom3() {
        return com3;
    }

    public void setCom3(String com3) {
        this.com3 = com3;
    }

    public String getCom4() {
        return com4;
    }

    public void setCom4(String com4) {
        this.com4 = com4;
    }

    public String getCom5() {
        return com5;
    }

    public void setCom5(String com5) {
        this.com5 = com5;
    }

    public String getCom6() {
        return com6;
    }

    public void setCom6(String com6) {
        this.com6 = com6;
    }

    public String getCom7() {
        return com7;
    }

    public void setCom7(String com7) {
        this.com7 = com7;
    }

    public String getCom8() {
        return com8;
    }

    public void setCom8(String com8) {
        this.com8 = com8;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    public String getPunit() {
        return punit;
    }

    public void setPunit(String punit) {
        this.punit = punit;
    }
    
    
}
