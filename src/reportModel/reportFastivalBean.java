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
public class reportFastivalBean {
    
    
    private String code;
    private String que;
    private String pcode;
    private String pname;
    private String price;
    private String unit;
    private String d1;
    private String d2;
    private String d3;
    private String d4;
    private String d5;
    private String d6;
    public List<reportFastivalBean> children = new ArrayList<reportFastivalBean>();

    public reportFastivalBean() {
    }

    public reportFastivalBean(String code, String que, String pcode, String pname, String price, String unit, String d1, String d2, String d3, String d4, String d5, String d6) {
        this.code = code;
        this.que = que;
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.unit = unit;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
        this.d6 = d6;
    }

    public List<reportFastivalBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportFastivalBean> children) {
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public String getD3() {
        return d3;
    }

    public void setD3(String d3) {
        this.d3 = d3;
    }

    public String getD4() {
        return d4;
    }

    public void setD4(String d4) {
        this.d4 = d4;
    }

    public String getD5() {
        return d5;
    }

    public void setD5(String d5) {
        this.d5 = d5;
    }

    public String getD6() {
        return d6;
    }

    public void setD6(String d6) {
        this.d6 = d6;
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
