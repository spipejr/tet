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
public class reportEmpAvgBean {
    private String code;
    private String no;
    private String dept;
    private String perqty;
    private String t1;
    private String t2;
    private String t3;
    public List<reportEmpAvgBean> children = new ArrayList<reportEmpAvgBean>();

    public reportEmpAvgBean(String code, String no, String dept, String perqty, String t1, String t2, String t3) {
        this.code = code;
        this.no = no;
        this.dept = dept;
        this.perqty = perqty;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public List<reportEmpAvgBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportEmpAvgBean> children) {
        this.children = children;
    }

    public reportEmpAvgBean() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPerqty() {
        return perqty;
    }

    public void setPerqty(String perqty) {
        this.perqty = perqty;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }
    
}
