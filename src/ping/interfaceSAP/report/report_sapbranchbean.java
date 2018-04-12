package ping.interfaceSAP.report;

import EStamp.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pos
 */
public class report_sapbranchbean {

    private String btype;
    private String branchcode;
    private String branchname;
    private String sapcode;
    private String sapname;
    private String sapcashank;

    public List<report_sapbranchbean> children = new ArrayList<report_sapbranchbean>();

    public report_sapbranchbean(String btype, String branchcode, String branchname, String sapcode, String sapname, String sapcashank) {
        this.btype = btype;
        this.branchcode = branchcode;
        this.branchname = branchname;
        this.sapcode = sapcode;
        this.sapname = sapname;
        this.sapcashank = sapcashank;

    }
    
     public report_sapbranchbean() {

    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getSapcode() {
        return sapcode;
    }

    public void setSapcode(String sapcode) {
        this.sapcode = sapcode;
    }

    public String getSapname() {
        return sapname;
    }

    public void setSapname(String sapname) {
        this.sapname = sapname;
    }

    public String getSapcashank() {
        return sapcashank;
    }

    public void setSapcashank(String sapcashank) {
        this.sapcashank = sapcashank;
    }

    public List<report_sapbranchbean> getChildren() {
        return children;
    }

    public void setChildren(List<report_sapbranchbean> children) {
        this.children = children;
    }

}
