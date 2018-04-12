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
public class reportLostDeptBean {
    private String s_bran;
    private String dept;
    private String deptname;
    private String sale;
    private String lost;
    private String per;
     public List<reportLostDeptBean> children = new ArrayList<reportLostDeptBean>();

    public reportLostDeptBean() {
    }

    public reportLostDeptBean(String s_bran, String dept, String deptname, String sale, String lost, String per) {
        this.s_bran = s_bran;
        this.dept = dept;
        this.deptname = deptname;
        this.sale = sale;
        this.lost = lost;
        this.per = per;
    }

    public List<reportLostDeptBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportLostDeptBean> children) {
        this.children = children;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public String getS_bran() {
        return s_bran;
    }

    public void setS_bran(String s_bran) {
        this.s_bran = s_bran;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
     
     
}
