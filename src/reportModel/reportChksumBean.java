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
public class reportChksumBean {
    private String area;
    private String bran;
    private String name;
    private String totaldate;
    private String plu;
    private String terminal;
    private String cashier;
    private String cupon;
    private String inv;
    private String hour;
    private String rj;
    private String stc;
    private String credit;
    private String kitchen;
    private String charge;
    private String bi;
    
    public List<reportChksumBean> children = new ArrayList<reportChksumBean>();

    public reportChksumBean() {
    }

    public reportChksumBean(String area, String bran, String name, String totaldate, String plu, String terminal, String cashier, String cupon, String inv, String hour, String rj, String stc, String credit, String kitchen, String charge, String bi) {
        this.area = area;
        this.bran = bran;
        this.name = name;
        this.totaldate = totaldate;
        this.plu = plu;
        this.terminal = terminal;
        this.cashier = cashier;
        this.cupon = cupon;
        this.inv = inv;
        this.hour = hour;
        this.rj = rj;
        this.stc = stc;
        this.credit = credit;
        this.kitchen = kitchen;
        this.charge = charge;
        this.bi = bi;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getBran() {
        return bran;
    }

    public void setBran(String bran) {
        this.bran = bran;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public List<reportChksumBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportChksumBean> children) {
        this.children = children;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCupon() {
        return cupon;
    }

    public void setCupon(String cupon) {
        this.cupon = cupon;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getInv() {
        return inv;
    }

    public void setInv(String inv) {
        this.inv = inv;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlu() {
        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public String getRj() {
        return rj;
    }

    public void setRj(String rj) {
        this.rj = rj;
    }

    public String getStc() {
        return stc;
    }

    public void setStc(String stc) {
        this.stc = stc;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getTotaldate() {
        return totaldate;
    }

    public void setTotaldate(String totaldate) {
        this.totaldate = totaldate;
    }
    
    
}
