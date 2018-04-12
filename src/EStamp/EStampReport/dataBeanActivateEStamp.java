/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EStamp.EStampReport;

import dbutility.dbUtility;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author pos
 */
public class dataBeanActivateEStamp {
//EStamp.EStampReport.dataBeanActivateEStamp

    private String bcode;
    private String bname;
    private String barcode;
    private String phone;
    private String custname;
    private String dateact;
    private String timeact;
    private String macnoact;
    private String cashieract;
    private String conDate;
    private String conBarcode;
    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public dataBeanActivateEStamp() {
    }

    public dataBeanActivateEStamp(String bcode, String bname, String barcode, String phone, String custname, String dateact,
            String timeact, String macnoact, String cashieract, String conDate, String conBarcode) {

        this.bcode = bcode;
        this.bname = bname;
        this.barcode = barcode;
        this.phone = phone;
        this.custname = custname;
        this.dateact = dateact;
        this.timeact = timeact;
        this.macnoact = macnoact;
        this.cashieract = cashieract;
        this.conDate = conDate;
        this.conBarcode = conBarcode;

    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getDateact() {
        return dateact;
    }

    public void setDateact(String dateact) {
        this.dateact = dateact;
    }

    public String getTimeact() {
        return timeact;
    }

    public void setTimeact(String timeact) {
        this.timeact = timeact;
    }

    public String getMacnoact() {
        return macnoact;
    }

    public void setMacnoact(String macnoact) {
        this.macnoact = macnoact;
    }

    public String getCashieract() {
        return cashieract;
    }

    public void setCashieract(String cashieract) {
        this.cashieract = cashieract;
    }

    public String getConDate() {
        return conDate;
    }

    public void setConDate(String conDate) {
        this.conDate = conDate;
    }

    public String getConBarcode() {
        return conBarcode;
    }

    public void setConBarcode(String conBarcode) {
        this.conBarcode = conBarcode;
    }

    public static Collection getCollection(String Seek, String conDate, String conBarcode) {
        String sql = Seek;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<dataBeanActivateEStamp> col = new ArrayList();

        try {
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (db.Char_Set.equalsIgnoreCase("utf-8")) {
                        col.add(new dataBeanActivateEStamp(
                                rs.getString("s.stamp_branchact"),
                                rs.getString("b.name"),
                                rs.getString("s.stamp_barcode"),
                                rs.getString("s.stamp_phone"),
                                rs.getString("s.stamp_custname"),
                                Format.dateFmtShow.format(rs.getDate("s.stamp_dateact")),
                                rs.getString("s.stamp_timeact"),
                                rs.getString("s.stamp_macnoact"),
                                rs.getString("s.stamp_cashieract"),
                                conDate,
                                conBarcode
                        ));
                    } else {
                        col.add(new dataBeanActivateEStamp(
                                cvth.ASCII2Unicode(rs.getString("s.stamp_branchact")),
                                cvth.ASCII2Unicode(rs.getString("b.name")),
                                cvth.ASCII2Unicode(rs.getString("s.stamp_barcode")),
                                cvth.ASCII2Unicode(rs.getString("s.stamp_phone")),
                                cvth.ASCII2Unicode(rs.getString("s.stamp_custname")),
                                Format.dateFmtShow.format(rs.getDate("s.stamp_dateact")),
                                cvth.ASCII2Unicode(rs.getString("s.stamp_timeact")),
                                cvth.ASCII2Unicode(rs.getString("s.stamp_macnoact")),
                                cvth.ASCII2Unicode(rs.getString("s.stamp_cashieract")),
                                conDate,
                                conBarcode
                        ));
                    }
                } while (rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return col;
    }
}
