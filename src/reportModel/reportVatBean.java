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
public class reportVatBean {
    private String code;
    private String area;
    private String date;
    private String m11;
    private String m12;
    private String m13;
    private String m14;
    private String m21;
    private String m22;
    private String m23;
    private String m24;
    private String m31;
    private String m32;
    private String m33;
    private String m34;
    private String t1;
    private String t2;
    
    
    public List<reportVatBean> children = new ArrayList<reportVatBean>();

    public reportVatBean(String code, String area, String date, String m11, String m12, String m13, String m14, String m21, String m22, String m23, String m24, String m31, String m32, String m33, String m34, String t1, String t2) {
        this.code = code;
        this.area = area;
        this.date = date;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m14 = m14;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m24 = m24;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        this.m34 = m34;
        this.t1 = t1;
        this.t2 = t2;
    }

    public reportVatBean() {
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<reportVatBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportVatBean> children) {
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getM13() {
        return m13;
    }

    public void setM13(String m13) {
        this.m13 = m13;
    }

    public String getM14() {
        return m14;
    }

    public void setM14(String m14) {
        this.m14 = m14;
    }

    public String getM21() {
        return m21;
    }

    public void setM21(String m21) {
        this.m21 = m21;
    }

    public String getM22() {
        return m22;
    }

    public void setM22(String m22) {
        this.m22 = m22;
    }

    public String getM23() {
        return m23;
    }

    public void setM23(String m23) {
        this.m23 = m23;
    }

    public String getM24() {
        return m24;
    }

    public void setM24(String m24) {
        this.m24 = m24;
    }

    public String getM31() {
        return m31;
    }

    public void setM31(String m31) {
        this.m31 = m31;
    }

    public String getM32() {
        return m32;
    }

    public void setM32(String m32) {
        this.m32 = m32;
    }

    public String getM33() {
        return m33;
    }

    public void setM33(String m33) {
        this.m33 = m33;
    }

    public String getM34() {
        return m34;
    }

    public void setM34(String m34) {
        this.m34 = m34;
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
    
    
}
