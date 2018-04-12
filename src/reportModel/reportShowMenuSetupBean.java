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
public class reportShowMenuSetupBean {
    private String no;
    private String ing;
    private String pcode;
    private String name;
    private String qty;
    private String unit;
    private String cost;
    private String price;
    private String percent;
    public List<reportShowMenuSetupBean> children = new ArrayList<reportShowMenuSetupBean>();

    public reportShowMenuSetupBean(String no,String ing, String pcode, String name, String qty, String unit, String cost, String price, String percent) {
        this.no = no;
        this.ing = ing;
        this.pcode = pcode;
        this.name = name;
        this.qty = qty;
        this.unit = unit;
        this.cost = cost;
        this.price = price;
        this.percent = percent;
    }

    public reportShowMenuSetupBean() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List<reportShowMenuSetupBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportShowMenuSetupBean> children) {
        this.children = children;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    
}
