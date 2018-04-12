package ping.interfaceSAP.report;

import EStamp.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pos
 */
public class report_sapproductbean {

    private String pgroup;
    private String pcode;
    private String pname;
    private String pactive;
    private String pbgroup;
    private String sapcode;
    private String sapname;

    public List<report_sapproductbean> children = new ArrayList<report_sapproductbean>();

    public report_sapproductbean(String pgroup, String pcode, String pname, String pactive , String sapcode, String sapname,String pbgroup) {
        this.pgroup = pgroup;
        this.pcode = pcode;
        this.pname = pname;
        this.pactive = pactive;
        this.pbgroup = pbgroup;
        this.sapcode = sapcode;
        this.sapname = sapname;

    }

    public report_sapproductbean() {

    }

    public String getPgroup() {
        return pgroup;
    }

    public void setPgroup(String pgroup) {
        this.pgroup = pgroup;
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

    public String getPactive() {
        return pactive;
    }

    public void setPactive(String pactive) {
        this.pactive = pactive;
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

    public String getPbgroup() {
        return pbgroup;
    }

    public void setPbgroup(String pbgroup) {
        this.pbgroup = pbgroup;
    }

    public List<report_sapproductbean> getChildren() {
        return children;
    }

    public void setChildren(List<report_sapproductbean> children) {
        this.children = children;
    }

}
