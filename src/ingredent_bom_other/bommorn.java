/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom_other;
//ingredent_bom_other.bommorn
/**
 *
 * @author user
 */
public class bommorn {

    String pcode = "";
    String pdesc = "";
    String pgroup = "";
    String groupname = "";
    String punit1 = "";
    String psubunit = "";
    Double pscale = 0.000;
    Double pacost = 0.0000;
    String bomacc = "";
    String account = "";
    String fix = "";

    public bommorn(String pcode, String pdesc, String pgroup, String groupname, String punit1,
            String psubunit, Double pscale, Double pacost, String bomacc, String account,
            String fix) {
        this.pcode = pcode;
        this.pdesc = pdesc;
        this.pgroup = pgroup;
        this.groupname = groupname;
        this.punit1 = punit1;
        this.psubunit = psubunit;
        this.pscale = pscale;
        this.pacost = pacost;
        this.bomacc = bomacc;
        this.account = account;
        this.fix = fix;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBomacc() {
        return bomacc;
    }

    public void setBomacc(String bomacc) {
        this.bomacc = bomacc;
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
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
