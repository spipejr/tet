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
public class reportSumCuponBean {
    private String s_bran;
    private String branname;
    private String cucode;
    private String cuname;
    private String sumqty;
    private String sumamt;
    public List<reportSumCuponBean> children = new ArrayList<reportSumCuponBean>();

    public reportSumCuponBean() {
    }

    public reportSumCuponBean(String s_bran, String branname, String cucode, String cuname, String sumqty, String sumamt) {
        this.s_bran = s_bran;
        this.branname = branname;
        this.cucode = cucode;
        this.cuname = cuname;
        this.sumqty = sumqty;
        this.sumamt = sumamt;
    }

    public String getBranname() {
        return branname;
    }

    public void setBranname(String branname) {
        this.branname = branname;
    }

    public List<reportSumCuponBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSumCuponBean> children) {
        this.children = children;
    }

    public String getCucode() {
        return cucode;
    }

    public void setCucode(String cucode) {
        this.cucode = cucode;
    }

    public String getCuname() {
        return cuname;
    }

    public void setCuname(String cuname) {
        this.cuname = cuname;
    }

    public String getS_bran() {
        return s_bran;
    }

    public void setS_bran(String s_bran) {
        this.s_bran = s_bran;
    }

    public String getSumamt() {
        return sumamt;
    }

    public void setSumamt(String sumamt) {
        this.sumamt = sumamt;
    }

    public String getSumqty() {
        return sumqty;
    }

    public void setSumqty(String sumqty) {
        this.sumqty = sumqty;
    }
    
    
    
}
