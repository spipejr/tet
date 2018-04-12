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
public class reportBudFastBean {
     private String code;
    private String que;
    private String pcode;
    private String pname;
    private String price;
    private String unit;
    private String amount;
     public List<reportBudFastBean> children = new ArrayList<reportBudFastBean>();

    public reportBudFastBean() {
    }

    

    public reportBudFastBean(String code, String que, String pcode, String pname, String price, String unit, String amount) {
        this.code = code;
        this.que = que;
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.unit = unit;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<reportBudFastBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportBudFastBean> children) {
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
     
     
}
