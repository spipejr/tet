/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom.s_bom;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natee
 */
public class reportSBom_bean {
    private String branch;
    private String date;
    private String dept;
    private String bomacc;
    private String pcode;
    private String pqty;
    private String plbomacc;
    private String plcode;
    private String plqty;
    private String price;
    private String amount;
    public List<reportSBom_bean> children = new ArrayList<reportSBom_bean>();
    
    public reportSBom_bean(String date,String branch, String dept, String bomacc, String pcode,
            String pqty, String plbomacc, String plcode, String plqty, String price, String amount) {
        this.branch = branch;
        this.date = date;
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
    
    public reportSBom_bean() {
        
    }

    public List<reportSBom_bean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSBom_bean> children) {
        this.children = children;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBomacc() {
        return bomacc;
    }

    public void setBomacc(String bomacc) {
        this.bomacc = bomacc;
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

    public String getPlbomacc() {
        return plbomacc;
    }

    public void setPlbomacc(String plbomacc) {
        this.plbomacc = plbomacc;
    }

    public String getPlcode() {
        return plcode;
    }

    public void setPlcode(String plcode) {
        this.plcode = plcode;
    }

    public String getPlqty() {
        return plqty;
    }

    public void setPlqty(String plqty) {
        this.plqty = plqty;
    }

    public String getPqty() {
        return pqty;
    }

    public void setPqty(String pqty) {
        this.pqty = pqty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
