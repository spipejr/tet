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
public class reportSumMonthBean {
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
    private String m7;
    private String m8;
    private String m9;
    private String m10;
    private String m11;
    private String m12;
    private String total;
     public List<reportSumMonthBean> children = new ArrayList<reportSumMonthBean>();

    public reportSumMonthBean() {
        
    }

    public reportSumMonthBean(String code, String no, String dept, String desc, String m1, String m2, String m3, String m4, String m5, String m6, String m7, String m8, String m9, String m10, String m11, String m12, String total) {
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
        this.m7 = m7;
        this.m8 = m8;
        this.m9 = m9;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.total = total;
    }

    public List<reportSumMonthBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSumMonthBean> children) {
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

    public String getM10() {
        return m10;
    }

    public void setM10(String m10) {
        this.m10 = m10;
    }

    public String getM11() {
        return m11;
    }

    public void setM11(String m11) {
        this.m11 = m11;
    }

    public String getM12() {
        return m12;
    }

    public void setM12(String m12) {
        this.m12 = m12;
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

    public String getM7() {
        return m7;
    }

    public void setM7(String m7) {
        this.m7 = m7;
    }

    public String getM8() {
        return m8;
    }

    public void setM8(String m8) {
        this.m8 = m8;
    }

    public String getM9() {
        return m9;
    }

    public void setM9(String m9) {
        this.m9 = m9;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
     
     
}
