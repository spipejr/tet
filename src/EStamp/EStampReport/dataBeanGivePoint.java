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
public class dataBeanGivePoint {

    private String stamp_barcode;
    private String stamp_campaign;
    private String stamp_promotion;
    private String ues_branchcode;
    private String ues_branchname;
    private String use_refno;
    private String ues_date;
    private int stamp_point;

    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public dataBeanGivePoint() {
    }

    public dataBeanGivePoint(String stamp_barcode, String stamp_campaign, String stamp_promotion, String ues_branchcode, String ues_branchname,
            String use_refno, String ues_date, int stamp_point) {
        this.stamp_barcode = stamp_barcode;
        this.stamp_campaign = stamp_campaign;
        this.stamp_promotion = stamp_promotion;
        this.ues_branchcode = ues_branchcode;
        this.ues_branchname = ues_branchname;
        this.use_refno = use_refno;
        this.ues_date = ues_date;
        this.stamp_point = stamp_point;
    }

    public String getStamp_barcode() {
        return stamp_barcode;
    }

    public void setStamp_barcode(String stamp_barcode) {
        this.stamp_barcode = stamp_barcode;
    }

    public String getStamp_campaign() {
        return stamp_campaign;
    }

    public void setStamp_campaign(String stamp_campaign) {
        this.stamp_campaign = stamp_campaign;
    }

    public String getStamp_promotion() {
        return stamp_promotion;
    }

    public void setStamp_promotion(String stamp_promotion) {
        this.stamp_promotion = stamp_promotion;
    }

    public String getUes_branchcode() {
        return ues_branchcode;
    }

    public void setUes_branchcode(String ues_branchcode) {
        this.ues_branchcode = ues_branchcode;
    }

    public String getUes_branchname() {
        return ues_branchname;
    }

    public void setUes_branchname(String ues_branchname) {
        this.ues_branchname = ues_branchname;
    }

    public String getUse_refno() {
        return use_refno;
    }

    public void setUse_refno(String use_refno) {
        this.use_refno = use_refno;
    }

    public String getUes_date() {
        return ues_date;
    }

    public void setUes_date(String ues_date) {
        this.ues_date = ues_date;
    }

    public int getStamp_point() {
        return stamp_point;
    }

    public void setStamp_point(int stamp_point) {
        this.stamp_point = stamp_point;
    }

//EStamp.EStampReport.dataBeanGivePoint.getCollectionGivePoint
    public static Collection getCollectionGivePoint(String seek) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<dataBeanGivePoint> col = new ArrayList();
        String sql = seek;
        try {
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (db.Char_Set.equalsIgnoreCase("utf-8")) {
                        col.add(new dataBeanGivePoint(
                                rs.getString("barcode"),
                                rs.getString("campaign"),
                                rs.getString("promotion"),
                                rs.getString("sb.use_branch"),
                                rs.getString("b.name"),
                                rs.getString("sb.use_billno"),
                                Format.dateFmtShow.format(rs.getDate("sb.use_date")) + " "+rs.getString("sb.use_time"),
                                rs.getInt("point")
                        ));
                    } else {
                        col.add(new dataBeanGivePoint(
                                cvth.ASCII2Unicode(rs.getString("barcode")),
                                cvth.ASCII2Unicode(rs.getString("campaign")),
                                cvth.ASCII2Unicode(rs.getString("promotion")),
                                cvth.ASCII2Unicode(rs.getString("sb.use_branch")),
                                cvth.ASCII2Unicode(rs.getString("b.name")),
                                cvth.ASCII2Unicode(rs.getString("sb.use_billno")),
                                Format.dateFmtShow.format(rs.getDate("sb.use_date"))+ " "+cvth.ASCII2Unicode(rs.getString("sb.use_time")),
                                rs.getInt("point")
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
