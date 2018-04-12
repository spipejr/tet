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
public class reportSumStockCakeBean {
    private String s_bran;
    private String s_name;
    private String dept;
    private String pcode;
    private String pname;
    private String price;
    private String unit;
    private String bod;
    private String rec;
    private String tfr;
    private String wid;
    private String ret;
    private String rfn;
    private String sal;
    private String adj;
    private String eod;
    private String pret;
    private String amt ;
    public List<reportSumStockCakeBean> children = new ArrayList<reportSumStockCakeBean>();

    public reportSumStockCakeBean() {
    }

    public reportSumStockCakeBean(String s_bran, String s_name, String dept, String pcode, String pname, String price, String unit, String bod, String rec, String tfr, String wid, String ret, String rfn, String sal, String adj, String eod, String pret,String amt) {
        this.s_bran = s_bran;
        this.s_name = s_name;
        this.dept = dept;
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.unit = unit;
        this.bod = bod;
        this.rec = rec;
        this.tfr = tfr;
        this.wid = wid;
        this.ret = ret;
        this.rfn = rfn;
        this.sal = sal;
        this.adj = adj;
        this.eod = eod;
        this.pret = pret;
        this.amt = amt ;
    }

    public String getAdj() {
        return adj;
    }

    public void setAdj(String adj) {
        this.adj = adj;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public List<reportSumStockCakeBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSumStockCakeBean> children) {
        this.children = children;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEod() {
        return eod;
    }

    public void setEod(String eod) {
        this.eod = eod;
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

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
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

    public String getS_bran() {
        return s_bran;
    }

    public void setS_bran(String s_bran) {
        this.s_bran = s_bran;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
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
    public String getAmt() {
        return amt;
    }

    public void setAmt(String wid) {
        this.amt = wid;
    }
    
}
