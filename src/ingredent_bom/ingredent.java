/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;

/**
 *
 * @author natee
 */
public class ingredent {
    private String pcode = "";
    private String pdesc = "";
    private String pgroup = "";
    private String groupname = "";
    private String punit1 = "";
    private String psubunit = "";
    private Double pscale = 0.000;
    private Double pacost = 0.0000;
    
    public ingredent(String pcode, String pdesc, String pgroup, String groupname,
            String punit1, String psubunit, Double pscale, Double pacost) {
        this.pcode = pcode;
        this.pdesc = pdesc;
        this.pgroup = pgroup;
        this.groupname = groupname;
        this.punit1 = punit1;
        this.psubunit = psubunit;
        this.pscale = pscale;
        this.pacost = pacost;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Double getPacost() {
        return pacost;
    }

    public void setPacost(Double pacost) {
        this.pacost = pacost;
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

    public String getPgroup() {
        return pgroup;
    }

    public void setPgroup(String pgroup) {
        this.pgroup = pgroup;
    }

    public Double getPscale() {
        return pscale;
    }

    public void setPscale(Double pscale) {
        this.pscale = pscale;
    }

    public String getPsubunit() {
        return psubunit;
    }

    public void setPsubunit(String psubunit) {
        this.psubunit = psubunit;
    }

    public String getPunit1() {
        return punit1;
    }

    public void setPunit1(String punit1) {
        this.punit1 = punit1;
    }
    
}
