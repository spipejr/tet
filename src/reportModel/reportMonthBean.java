/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natee
 */
public class reportMonthBean {
    private String code;
    private String no;
    private String dept;
    private String desc;
    private String m1;
    private String m2;
    private String m3;
    private String m4;
    private String m5;
    private String m6;
     public List<reportMonthBean> children = new ArrayList<reportMonthBean>();

    public reportMonthBean() {
    }

    public reportMonthBean(String code, String no, String dept, String desc, String m1, String m2, String m3, String m4, String m5, String m6) {
        this.code = code;
        this.no = no;
        this.dept = dept;
        this.desc = desc;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
        this.m6 = m6;
    }

    public List<reportMonthBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportMonthBean> children) {
        this.children = children;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getM3() {
        return m3;
    }

    public void setM3(String m3) {
        this.m3 = m3;
    }

    public String getM4() {
        return m4;
    }

    public void setM4(String m4) {
        this.m4 = m4;
    }

    public String getM5() {
        return m5;
    }

    public void setM5(String m5) {
        this.m5 = m5;
    }

    public String getM6() {
        return m6;
    }

    public void setM6(String m6) {
        this.m6 = m6;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
     
     
}
