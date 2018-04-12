/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom.s_bom;
//ingredent_bom.s_bom.sbom
/**
 *
 * @author natee
 */
public class sbom {
    private String date = "";
    private String branch = "";
    private String dept = "";
    private String bomacc = "";
    private String pcode = "";
    private double pqty = 0;
    private String plbomacc = "";
    private String plcode = "";
    private double plqty = 0;
    private double price = 0;
    private double amount = 0;
    
    public sbom(String date, String bran, String dept, String bomacc,
            String pcode, double pqty, String plbomacc, String plcode, double plqty, double price, double amount) {
        this.date = date;
        this.branch = bran;
        this.dept = dept;
        this.bomacc = bomacc;
        this.pcode = pcode;
        this.pqty = pqty;
        this.plbomacc = plbomacc;
        this.plcode = plcode;
        this.plqty = plqty;
        this.price = price;
        this.amount = amount;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getPlcode() {
        return plcode;
    }

    public void setPlcode(String plcode) {
        this.plcode = plcode;
    }

    public double getPlqty() {
        return plqty;
    }

    public void setPlqty(double plqty) {
        this.plqty = plqty;
    }

    public double getPqty() {
        return pqty;
    }

    public void setPqty(double pqty) {
        this.pqty = pqty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBomacc() {
        return bomacc;
    }

    public void setBomacc(String bomacc) {
        this.bomacc = bomacc;
    }

    public String getPlbomacc() {
        return plbomacc;
    }

    public void setPlbomacc(String plbomacc) {
        this.plbomacc = plbomacc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
