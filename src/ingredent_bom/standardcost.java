/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;

/**
 *
 * @author natee
 */
public class standardcost {
    private String group = "";
    private String pcode = "";
    private String pdesc = "";
    private Double pscost = 0.0000;
    private String punit1 = "";
    private String bomacc = "";
    
    public standardcost(String group, String pcode, String pdesc, Double pscost, String punit1, String bomacc) {
        this.group = group;
        this.pcode = pcode;
        this.pdesc = pdesc;
        this.pscost = pscost;
        this.punit1 = punit1;
        this.bomacc = bomacc;
    }

    public String getBomacc() {
        return bomacc;
    }

    public void setBomacc(String bomacc) {
        this.bomacc = bomacc;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public Double getPscost() {
        return pscost;
    }

    public void setPscost(Double pscost) {
        this.pscost = pscost;
    }

    public String getPunit1() {
        return punit1;
    }

    public void setPunit1(String punit1) {
        this.punit1 = punit1;
    }
    
}
