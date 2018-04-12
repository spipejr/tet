/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natee
 */

public class reportSaleOfPluBean {
    private String s_bran;
    private String s_dept;
    private String Date;
    private String s_pcode;
    private String pname;
    private String pprice;
    private String punit;
    private String e_qty;
    private String e_amt;
    private String e_disc;
    private String e_net;
    private String t_qty;
    private String t_amt;
    private String t_disc;
    private String t_net;
     private String d_qty;
    private String d_amt;
    private String d_disc;
    private String d_net;
    private String p_qty;
    private String p_amt;
    private String p_disc;
    private String p_net;
    private String w_qty;
    private String w_amt;
    private String w_disc;
    private String w_net;
    private String s_qty;
    private String s_amt;
    private String s_disc;
    private String s_net;
    private String s_price;
    public List<reportSaleOfPluBean> children = new ArrayList<reportSaleOfPluBean>();

    public reportSaleOfPluBean() 
    {
    }
    public reportSaleOfPluBean(String s_bran,String Date, String s_dept, String s_pcode, String pname, String pprice, String punit, String e_qty, String e_amt, String e_disc, String e_net, String t_qty, String t_amt, String t_disc, String t_net, String d_qty, String d_amt, String d_disc, String d_net, String p_qty, String p_amt, String p_disc, String p_net, String w_qty, String w_amt, String w_disc, String w_net, String s_qty, String s_amt, String s_disc, String s_net) {
        this.s_bran = s_bran;
        this.Date = Date;
        this.s_dept = s_dept;
        this.s_pcode = s_pcode;
        this.pname = pname;
        this.pprice = pprice;
        this.punit = punit;
        this.e_qty = e_qty;
        this.e_amt = e_amt;
        this.e_disc = e_disc;
        this.e_net = e_net;
        this.t_qty = t_qty;
        this.t_amt = t_amt;
        this.t_disc = t_disc;
        this.t_net = t_net;
        this.d_qty = d_qty;
        this.d_amt = d_amt;
        this.d_disc = d_disc;
        this.d_net = d_net;
        this.p_qty = p_qty;
        this.p_amt = p_amt;
        this.p_disc = p_disc;
        this.p_net = p_net;
        this.w_qty = w_qty;
        this.w_amt = w_amt;
        this.w_disc = w_disc;
        this.w_net = w_net;
        this.s_qty = s_qty;
        this.s_amt = s_amt;
        this.s_disc = s_disc;
        this.s_net = s_net;
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

    public String getS_dept() {
        return s_dept;
    }

    public void setS_dept(String s_dept) {
        this.s_dept = s_dept;
    }

    public String getD_amt() {
        return d_amt;
    }

    public void setD_amt(String d_amt) {
        this.d_amt = d_amt;
    }

    public String getD_disc() {
        return d_disc;
    }

    public void setD_disc(String d_disc) {
        this.d_disc = d_disc;
    }

    public String getD_net() {
        return d_net;
    }

    public void setD_net(String d_net) {
        this.d_net = d_net;
    }

    public String getD_qty() {
        return d_qty;
    }

    public void setD_qty(String d_qty) {
        this.d_qty = d_qty;
    }

    public String getE_amt() {
        return e_amt;
    }

    public void setE_amt(String e_amt) {
        this.e_amt = e_amt;
    }

    public String getE_disc() {
        return e_disc;
    }

    public void setE_disc(String e_disc) {
        this.e_disc = e_disc;
    }

    public String getE_net() {
        return e_net;
    }

    public void setE_net(String e_net) {
        this.e_net = e_net;
    }

    public String getE_qty() {
        return e_qty;
    }

    public void setE_qty(String e_qty) {
        this.e_qty = e_qty;
    }

    public String getP_amt() {
        return p_amt;
    }

    public void setP_amt(String p_amt) {
        this.p_amt = p_amt;
    }

    public String getP_disc() {
        return p_disc;
    }

    public void setP_disc(String p_disc) {
        this.p_disc = p_disc;
    }

    public String getP_net() {
        return p_net;
    }

    public void setP_net(String p_net) {
        this.p_net = p_net;
    }

    public String getP_qty() {
        return p_qty;
    }

    public void setP_qty(String p_qty) {
        this.p_qty = p_qty;
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

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    

    public String getS_disc() {
        return s_disc;
    }

    public void setS_disc(String s_disc) {
        this.s_disc = s_disc;
    }

    public String getS_net() {
        return s_net;
    }

    public void setS_net(String s_net) {
        this.s_net = s_net;
    }

    public String getS_pcode() {
        return s_pcode;
    }

    public void setS_pcode(String s_pcode) {
        this.s_pcode = s_pcode;
    }

    public String getS_price() {
        return s_price;
    }

    public void setS_price(String s_price) {
        this.s_price = s_price;
    }

    public String getS_qty() {
        return s_qty;
    }

    public void setS_qty(String s_qty) {
        this.s_qty = s_qty;
    }

    public String getT_amt() {
        return t_amt;
    }

    public void setT_amt(String t_amt) {
        this.t_amt = t_amt;
    }

    public String getT_disc() {
        return t_disc;
    }

    public void setT_disc(String t_disc) {
        this.t_disc = t_disc;
    }

    public String getT_net() {
        return t_net;
    }

    public void setT_net(String t_net) {
        this.t_net = t_net;
    }

    public String getT_qty() {
        return t_qty;
    }

    public void setT_qty(String t_qty) {
        this.t_qty = t_qty;
    }

    public String getW_amt() {
        return w_amt;
    }

    public void setW_amt(String w_amt) {
        this.w_amt = w_amt;
    }

    public String getW_disc() {
        return w_disc;
    }

    public void setW_disc(String w_disc) {
        this.w_disc = w_disc;
    }

    public String getW_net() {
        return w_net;
    }

    public void setW_net(String w_net) {
        this.w_net = w_net;
    }

    public String getW_qty() {
        return w_qty;
    }

    public void setW_qty(String w_qty) {
        this.w_qty = w_qty;
    }
    public List<reportSaleOfPluBean> getChildren() 
	{
		return children;
	}
}
