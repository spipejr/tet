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
public class reportRangDateBean {
    private String code;
    private String no;
    private String dept;
    private String desc;
    private String m1;
    private String m2;
    private String m3;
    private String m4;
     public List<reportRangDateBean> children = new ArrayList<reportRangDateBean>();

    public reportRangDateBean() {
    }

    public reportRangDateBean(String code, String no, String dept, String desc, String m1, String m2, String m3, String m4) {
        this.code = code;
        this.no = no;
        this.dept = dept;
        this.desc = desc;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
    }

    public List<reportRangDateBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportRangDateBean> children) {
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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
     
}
