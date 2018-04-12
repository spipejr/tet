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
public class reportSumStockCakeAllBean {
    
    private String dept;
    private String pcode;
    private String pname;
    private String price;
    private String unit;
    private String rec;
    private String tfr;
    private String wid;
    private String ret;
    private String rfn;
    private String sal;
    private String adj;
    public List<reportSumStockCakeAllBean> children = new ArrayList<reportSumStockCakeAllBean>();

    public reportSumStockCakeAllBean() {
    }

    public reportSumStockCakeAllBean(String dept, String pcode, String pname, String price, String unit, String rec, String tfr, String wid, String ret, String rfn, String sal, String adj) {
        this.dept = dept;
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.unit = unit;
        this.rec = rec;
        this.tfr = tfr;
        this.wid = wid;
        this.ret = ret;
        this.rfn = rfn;
        this.sal = sal;
        this.adj = adj;
    }

    public String getAdj() {
        return adj;
    }

    public void setAdj(String adj) {
        this.adj = adj;
    }

    public List<reportSumStockCakeAllBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSumStockCakeAllBean> children) {
        this.children = children;
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

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getRfn() {
        return rfn;
    }

    public void setRfn(String rfn) {
        this.rfn = rfn;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getTfr() {
        return tfr;
    }

    public void setTfr(String tfr) {
        this.tfr = tfr;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }
    
    
    
}
