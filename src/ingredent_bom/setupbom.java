/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;

/**
 *
 * @author natee
 */
public class setupbom {
    private int formula = 1;
    private String plcode = "";
    private String plname = "";
    private Double pqty = 0.000;
    private String psubunit = "";
    private String saletype = "";
    
    public setupbom(int formula, String plcode, String plname, Double pqty, String psubunit, String saletype) {
        this.formula = formula;
        this.plcode = plcode;
        this.plname = plname;
        this.pqty = pqty;
        this.psubunit = psubunit;
        this.saletype = saletype;
    }

    public int getFormula() {
        return formula;
    }

    public void setFormula(int formula) {
        this.formula = formula;
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

    public String getPsubunit() {
        return psubunit;
    }

    public void setPsubunit(String psubunit) {
        this.psubunit = psubunit;
    }

    public String getSaletype() {
        return saletype;
    }

    public void setSaletype(String saletype) {
        this.saletype = saletype;
    }
    
}
