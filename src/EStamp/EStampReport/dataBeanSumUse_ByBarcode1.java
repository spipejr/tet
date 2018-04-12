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
public class dataBeanSumUse_ByBarcode1 {

    private String campaign;
    private String custtel;
    private String custname;
    private int point;
    private int redeem;

    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public dataBeanSumUse_ByBarcode1() {
    }

    public dataBeanSumUse_ByBarcode1(String campaign, String custtel, String custname, int point, int redeem) {
        this.campaign = campaign;
        this.custtel = custtel;
        this.custname = custname;
        this.point = point;
        this.redeem = redeem;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getCusttel() {
        return custtel;
    }

    public void setCusttel(String custtel) {
        this.custtel = custtel;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getRedeem() {
        return redeem;
    }

    public void setRedeem(int redeem) {
        this.redeem = redeem;
    }

//EStamp.EStampReport.dataBeanSumUse_ByBarcode.getCollectionSumUseByBarcode
    public static Collection getCollectionSumUseByBarcode(String seek) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<dataBeanSumUse_ByBarcode1> col = new ArrayList();
        String sql = seek;
        try {
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (db.Char_Set.equalsIgnoreCase("utf-8")) {
                        col.add(new dataBeanSumUse_ByBarcode1(
                                rs.getString("ccode") + " " + rs.getString("cname"),
                                rs.getString("custtel"),
                                rs.getString("custname"),
                                rs.getInt("point"),
                                rs.getInt("redeem")
                        ));
                    } else {
                        col.add(new dataBeanSumUse_ByBarcode1(
                                cvth.ASCII2Unicode(rs.getString("ccode")) + " " + cvth.ASCII2Unicode(rs.getString("cname")),
                                cvth.ASCII2Unicode(rs.getString("custtel")),
                                cvth.ASCII2Unicode(rs.getString("custname")),
                                rs.getInt("point"),
                                rs.getInt("redeem")
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
