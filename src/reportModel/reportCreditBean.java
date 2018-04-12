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
public class reportCreditBean {
    private String s_bran;
    private String Date;
    private String crcode;
    private String crname;
    private String cramt;
    private String cracc;
    private String crld;
    public List<reportCreditBean> children = new ArrayList<reportCreditBean>();

    public reportCreditBean(String s_bran,String Date, String crcode, String crname, String cramt, String cracc, String crld) {
        this.s_bran = s_bran;
        this.Date = Date;
        this.crcode = crcode;
        this.crname = crname;
        this.cramt = cramt;
        this.cracc = cracc;
        this.crld = crld;
        
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public reportCreditBean() {
    }

    public List<reportCreditBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportCreditBean> children) {
        this.children = children;
    }

    public String getCracc() {
        return cracc;
    }

    public void setCracc(String cracc) {
        this.cracc = cracc;
    }

    public String getCramt() {
        return cramt;
    }

    public void setCramt(String cramt) {
        this.cramt = cramt;
    }

    public String getCrcode() {
        return crcode;
    }

    public void setCrcode(String crcode) {
        this.crcode = crcode;
    }

    public String getCrld() {
        return crld;
    }

    public void setCrld(String crld) {
        this.crld = crld;
    }

    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
    }

    public String getS_bran() {
        return s_bran;
    }

    public void setS_bran(String s_bran) {
        this.s_bran = s_bran;
    }
    
}
