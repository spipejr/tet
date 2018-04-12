/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natee
 */
public class reportPOSBOM_bean {

    private String pcode;
    private String plcode;
    private String plname;
    private String pqty;
    private String psubunit;
    private String saletype;
    private String formula;
    private String pactive;
    public List<reportPOSBOM_bean> children = new ArrayList<reportPOSBOM_bean>();

    public reportPOSBOM_bean(String pcode, String plcode, String plname, String pactive, String pqty,
            String psubunit, String saletype, String formula) {
        this.pcode = pcode;
        this.plcode = plcode;
        this.plname = plname;
        this.pqty = pqty;
        this.psubunit = psubunit;
        this.saletype = saletype;
        this.formula = formula;
        this.pactive = pactive;
    }

    public reportPOSBOM_bean() {

    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public List<reportPOSBOM_bean> getChildren() {
        return children;
    }

    public void setChildren(List<reportPOSBOM_bean> children) {
        this.children = children;
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

    public String getPlname() {
        return plname;
    }

    public void setPlname(String plname) {
        this.plname = plname;
    }

    public String getPqty() {
        return pqty;
    }

    public void setPqty(String pqty) {
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

    public String getPactive() {
        return pactive;
    }

    public void setPactive(String pactive) {
        this.pactive = pactive;
    }

}
