/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;

/**
 *
 * @author natee
 */
public class bom {

    private String pcode = "";
    private String pdesc = "";
    private String unit = "";
    private Double price = 0.000;
    private int qty = 0;
    private String plcode = "";
    private String plname = "";
    private Double pqty = 0.000;
    private String psubunit = "";
    private String saletype = "";
    private int formula = 0;
    private String pactive = "";

    public bom(String pcode, String pdesc, String unit, Double price, int qty,
            String plcode, String plname, Double pqty, String psubunit, String saletype,
            int formula,String pactive) {
        this.pcode = pcode;
        this.pdesc = pdesc;
        this.unit = unit;
        this.price = price;
        this.qty = qty;
        this.plcode = plcode;
        this.plname = plname;
        this.pqty = pqty;
        this.psubunit = psubunit;
        this.saletype = saletype;
        this.formula = formula;
        this.pactive = pactive;
    }

    public int getFormula() {
        return formula;
    }

    public void setFormula(int formula) {
        this.formula = formula;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPlcode() {
        return plcode;
    }

    public void setPlcode(String plcode) {
        this.plcode = plcode;
    }

    public String getPlname() {
        return plname;
    }

    public void setPlname(String plname) {
        this.plname = plname;
    }

    public Double getPqty() {
        return pqty;
    }

    public void setPqty(Double pqty) {
        this.pqty = pqty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPsubunit() {
        return psubunit;
    }

    public void setPsubunit(String psubunit) {
        this.psubunit = psubunit;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSaletype() {
        return saletype;
    }

    public void setSaletype(String saletype) {
        this.saletype = saletype;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPactive() {
        return pactive;
    }

    public void setPactive(String pactive) {
        this.pactive = pactive;
    }

}
