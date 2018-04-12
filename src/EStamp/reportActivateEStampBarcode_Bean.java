/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EStamp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pos
 */
class reportActivateEStampBarcode_Bean {

    private String stamp_barcode;
    private String stamp_custphone;
    private String stamp_custname;
    private String stamp_branchact;
    private String stamp_date;
    private String stamp_time;
    private String stamp_macno;
    private String stamp_cashier;

    public List<reportActivateEStampBarcode_Bean> children = new ArrayList<reportActivateEStampBarcode_Bean>();

    public reportActivateEStampBarcode_Bean() {

    }

    public reportActivateEStampBarcode_Bean(String stamp_branchact, String stamp_barcode, String stamp_custphone, String stamp_custname,
            String stamp_date, String stamp_time, String stamp_macno, String stamp_cashier) {
        this.stamp_branchact = stamp_branchact;
        this.stamp_barcode = stamp_barcode;
        this.stamp_custphone = stamp_custphone;
        this.stamp_custname = stamp_custname;
        this.stamp_date = stamp_date;
        this.stamp_time = stamp_time;
        this.stamp_macno = stamp_macno;
        this.stamp_cashier = stamp_cashier;
    }

    public String getStamp_barcode() {
        return stamp_barcode;
    }

    public void setStamp_barcode(String stamp_barcode) {
        this.stamp_barcode = stamp_barcode;
    }

    public String getStamp_custphone() {
        return stamp_custphone;
    }

    public void setStamp_custphone(String stamp_custphone) {
        this.stamp_custphone = stamp_custphone;
    }

    public String getStamp_custname() {
        return stamp_custname;
    }

    public void setStamp_custname(String stamp_custname) {
        this.stamp_custname = stamp_custname;
    }

    public String getStamp_branchact() {
        return stamp_branchact;
    }

    public void setStamp_branchact(String stamp_branchact) {
        this.stamp_branchact = stamp_branchact;
    }

    public String getStamp_date() {
        return stamp_date;
    }

    public void setStamp_date(String stamp_date) {
        this.stamp_date = stamp_date;
    }

    public String getStamp_time() {
        return stamp_time;
    }

    public void setStamp_time(String stamp_time) {
        this.stamp_time = stamp_time;
    }

    public String getStamp_macno() {
        return stamp_macno;
    }

    public void setStamp_macno(String stamp_macno) {
        this.stamp_macno = stamp_macno;
    }

    public String getStamp_cashier() {
        return stamp_cashier;
    }

    public void setStamp_cashier(String stamp_cashier) {
        this.stamp_cashier = stamp_cashier;
    }

    public List<reportActivateEStampBarcode_Bean> getChildren() {
        return children;
    }

    public void setChildren(List<reportActivateEStampBarcode_Bean> children) {
        this.children = children;
    }

}
