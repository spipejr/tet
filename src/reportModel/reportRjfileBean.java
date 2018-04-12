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
public class reportRjfileBean {
    private String s_bran;
    private String Date;
    private String no;
    private String dept;
    private String accno;
    private String subacc;
    private String desc;
    private String mac1;
    private String mac2;
    private String mac3;
    private String total;
    public List<reportRjfileBean> children = new ArrayList<reportRjfileBean>();
    
    public reportRjfileBean() {
        
    }

    public reportRjfileBean(String s_bran,String Date, String no, String dept, String accno, String subacc, String desc, String mac1, String mac2, String mac3, String total) {
        this.s_bran = s_bran;
        this.Date = Date;
        this.no = no;
        this.dept = dept;
        this.accno = accno;
        this.subacc = subacc;
        this.desc = desc;
        this.mac1 = mac1;
        this.mac2 = mac2;
        this.mac3 = mac3;
        this.total = total;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public List<reportRjfileBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportRjfileBean> children) {
        this.children = children;
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

    public String getMac1() {
        return mac1;
    }

    public void setMac1(String mac1) {
        this.mac1 = mac1;
    }

    public String getMac2() {
        return mac2;
    }

    public void setMac2(String mac2) {
        this.mac2 = mac2;
    }

    public String getMac3() {
        return mac3;
    }

    public void setMac3(String mac3) {
        this.mac3 = mac3;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getS_bran() {
        return s_bran;
    }

    public void setS_bran(String s_bran) {
        this.s_bran = s_bran;
    }

    public String getSubacc() {
        return subacc;
    }

    public void setSubacc(String subacc) {
        this.subacc = subacc;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
}
