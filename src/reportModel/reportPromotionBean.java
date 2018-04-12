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
public class reportPromotionBean {
    private String s_bran;
    private String branname;
    private String type;
    private String procode;
    private String proname;
    private String sumqty;
    private String sumamt;
    public List<reportPromotionBean> children = new ArrayList<reportPromotionBean>();

    public reportPromotionBean() {
    }

    public reportPromotionBean(String s_bran, String branname, String type, String procode, String proname, String sumqty, String sumamt) {
        this.s_bran = s_bran;
        this.branname = branname;
        this.type = type;
        this.procode = procode;
        this.proname = proname;
        this.sumqty = sumqty;
        this.sumamt = sumamt;
    }

    public String getBranname() {
        return branname;
    }

    public void setBranname(String branname) {
        this.branname = branname;
    }

    public List<reportPromotionBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportPromotionBean> children) {
        this.children = children;
    }

    public String getProcode() {
        return procode;
    }

    public void setProcode(String procode) {
        this.procode = procode;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
