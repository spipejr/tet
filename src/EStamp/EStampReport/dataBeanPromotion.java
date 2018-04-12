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
public class dataBeanPromotion {

    private String sp_campaign;
    private String sp_campaignname;
    private String sp_code;
    private String sp_name;
    private String sp_startdate;
    private String sp_enddate;
    private String sp_day;
    private String sp_saletype;
    private String sp_saletimeS;
    private String sp_saletimeE;
    private int sp_saleitem;
    private int sp_point;

    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public dataBeanPromotion() {
    }

    public dataBeanPromotion(String sp_campaign, String sp_campaignname, String sp_code, String sp_name, String sp_startdate, String sp_enddate, String sp_day,
            String sp_saletype, String sp_saletimeS, String sp_saletimeE, int sp_saleitem, int sp_point) {
        this.sp_campaign = sp_campaign;
        this.sp_campaignname = sp_campaignname;
        this.sp_code = sp_code;
        this.sp_name = sp_name;
        this.sp_startdate = sp_startdate;
        this.sp_enddate = sp_enddate;
        this.sp_day = sp_day;
        this.sp_saletype = sp_saletype;
        this.sp_saletimeS = sp_saletimeS;
        this.sp_saletimeE = sp_saletimeE;
        this.sp_saleitem = sp_saleitem;
        this.sp_point = sp_point;
    }

    public String getSp_campaign() {
        return sp_campaign;
    }

    public void setSp_campaign(String sp_campaign) {
        this.sp_campaign = sp_campaign;
    }

    public String getSp_campaignname() {
        return sp_campaignname;
    }

    public void setSp_campaignname(String sp_campaignname) {
        this.sp_campaignname = sp_campaignname;
    }

    public String getSp_code() {
        return sp_code;
    }

    public void setSp_code(String sp_code) {
        this.sp_code = sp_code;
    }

    public String getSp_name() {
        return sp_name;
    }

    public void setSp_name(String sp_name) {
        this.sp_name = sp_name;
    }

    public String getSp_startdate() {
        return sp_startdate;
    }

    public void setSp_startdate(String sp_startdate) {
        this.sp_startdate = sp_startdate;
    }

    public String getSp_enddate() {
        return sp_enddate;
    }

    public void setSp_enddate(String sp_enddate) {
        this.sp_enddate = sp_enddate;
    }

    public String getSp_day() {
        return sp_day;
    }

    public void setSp_day(String sp_day) {
        this.sp_day = sp_day;
    }

    public String getSp_saletype() {
        return sp_saletype;
    }

    public void setSp_saletype(String sp_saletype) {
        this.sp_saletype = sp_saletype;
    }

    public String getSp_saletimeS() {
        return sp_saletimeS;
    }

    public void setSp_saletimeS(String sp_saletimeS) {
        this.sp_saletimeS = sp_saletimeS;
    }

    public String getSp_saletimeE() {
        return sp_saletimeE;
    }

    public void setSp_saletimeE(String sp_saletimeE) {
        this.sp_saletimeE = sp_saletimeE;
    }

    public int getSp_saleitem() {
        return sp_saleitem;
    }

    public void setSp_saleitem(int sp_saleitem) {
        this.sp_saleitem = sp_saleitem;
    }

    public int getSp_point() {
        return sp_point;
    }

    public void setSp_point(int sp_point) {
        this.sp_point = sp_point;
    }
//EStamp.EStampReport.dataBeanPromotion.getCollectionPromotion

    public static Collection getCollectionPromotion(String campaignFrom, String campaignTo, String proFrom, String proTo, String date1, String date2) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<dataBeanPromotion> col = new ArrayList();

        try {
            String sql = "select * from stamppromotion sp "
                    + "left join stampcampaign s on sp.sp_campaign = s.s_campaigncode  "
                    + "where sp.sp_campaign >='" + campaignFrom + "' and sp.sp_campaign <='" + campaignTo + "' "
                    + "and sp.sp_code >='" + proFrom + "' and sp.sp_code <='" + proTo + "' "
                    + "and sp.sp_startdate >='" + date1 + "' and sp.sp_startdate <='" + date2 + "' "
                    + "order by sp.sp_campaign, sp.sp_code";
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (db.Char_Set.equalsIgnoreCase("utf-8")) {
                        col.add(new dataBeanPromotion(
                                rs.getString("sp.sp_campaign"),
                                rs.getString("s.s_campaignname"),
                                rs.getString("sp.sp_code"),
                                rs.getString("sp.sp_name"),
                                Format.dateFmtShow.format(rs.getDate("sp.sp_startdate")),
                                Format.dateFmtShow.format(rs.getDate("sp.sp_enddate")),
                                rs.getString("sp.sp_day"),
                                rs.getString("sp.sp_saletype"),
                                rs.getString("sp.sp_saletimeS"),
                                rs.getString("sp.sp_saletimeE"),
                                rs.getInt("sp.sp_saleitem"),
                                rs.getInt("sp.sp_point")
                        ));
                    } else {
                        col.add(new dataBeanPromotion(
                                cvth.ASCII2Unicode(rs.getString("sp.sp_campaign")),
                                 cvth.ASCII2Unicode(rs.getString("s.s_campaignname")),
                                cvth.ASCII2Unicode(rs.getString("sp.sp_code")),
                                cvth.ASCII2Unicode(rs.getString("sp.sp_name")),
                                Format.dateFmtShow.format(rs.getDate("sp.sp_startdate")),
                                Format.dateFmtShow.format(rs.getDate("sp.sp_enddate")),
                                cvth.ASCII2Unicode(rs.getString("sp.sp_day")),
                                cvth.ASCII2Unicode(rs.getString("sp.sp_saletype")),
                                cvth.ASCII2Unicode(rs.getString("sp.sp_saletimeS")),
                                cvth.ASCII2Unicode(rs.getString("sp.sp_saletimeE")),
                                rs.getInt("sp.sp_saleitem"),
                                rs.getInt("sp.sp_point")
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
