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
public class dataBeanRedeem {

    private String sr_campaign;
    private String sr_campaignname;
    private String sr_code;
    private String sr_name;
    private String sr_startdate;
    private String sr_enddate;
    private String sr_day;
    private String sr_saletype;
    private String sr_saletimeS;
    private String sr_saletimeE;
    private int sr_saleitem;
    private int sr_point;

    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public dataBeanRedeem() {
    }

    public dataBeanRedeem(String sr_campaign, String sr_campaignname, String sr_code, String sr_name, String sr_startdate, String sr_enddate, String sr_day,
            String sr_saletype, String sr_saletimeS, String sr_saletimeE, int sr_saleitem, int sr_point) {
        this.sr_campaign = sr_campaign;
        this.sr_campaignname = sr_campaignname;
        this.sr_code = sr_code;
        this.sr_name = sr_name;
        this.sr_startdate = sr_startdate;
        this.sr_enddate = sr_enddate;
        this.sr_day = sr_day;
        this.sr_saletype = sr_saletype;
        this.sr_saletimeS = sr_saletimeS;
        this.sr_saletimeE = sr_saletimeE;
        this.sr_saleitem = sr_saleitem;
        this.sr_point = sr_point;
    }

    public String getSr_campaign() {
        return sr_campaign;
    }

    public void setSr_campaign(String sr_campaign) {
        this.sr_campaign = sr_campaign;
    }

    public String getSr_campaignname() {
        return sr_campaignname;
    }

    public void setSr_campaignname(String sr_campaignname) {
        this.sr_campaignname = sr_campaignname;
    }

    public String getSr_code() {
        return sr_code;
    }

    public void setSr_code(String sr_code) {
        this.sr_code = sr_code;
    }

    public String getSr_name() {
        return sr_name;
    }

    public void setSr_name(String sr_name) {
        this.sr_name = sr_name;
    }

    public String getSr_startdate() {
        return sr_startdate;
    }

    public void setSr_startdate(String sr_startdate) {
        this.sr_startdate = sr_startdate;
    }

    public String getSr_enddate() {
        return sr_enddate;
    }

    public void setSr_enddate(String sr_enddate) {
        this.sr_enddate = sr_enddate;
    }

    public String getSr_day() {
        return sr_day;
    }

    public void setSr_day(String sr_day) {
        this.sr_day = sr_day;
    }

    public String getSr_saletype() {
        return sr_saletype;
    }

    public void setSr_saletype(String sr_saletype) {
        this.sr_saletype = sr_saletype;
    }

    public String getSr_saletimeS() {
        return sr_saletimeS;
    }

    public void setSr_saletimeS(String sr_saletimeS) {
        this.sr_saletimeS = sr_saletimeS;
    }

    public String getSr_saletimeE() {
        return sr_saletimeE;
    }

    public void setSr_saletimeE(String sr_saletimeE) {
        this.sr_saletimeE = sr_saletimeE;
    }

    public int getSr_saleitem() {
        return sr_saleitem;
    }

    public void setSr_saleitem(int sr_saleitem) {
        this.sr_saleitem = sr_saleitem;
    }

    public int getSr_point() {
        return sr_point;
    }

    public void setSr_point(int sr_point) {
        this.sr_point = sr_point;
    }

//EStamp.EStampReport.dataBeanRedeem.getCollectionPromotion

    public static Collection getCollectionRedeem(String campaignFrom, String campaignTo, String proFrom, String proTo, String date1, String date2) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<dataBeanRedeem> col = new ArrayList();

        try {
            String sql = "select * from stampredeem sr "
                    + "left join stampcampaign s on sr.sr_campaign = s.s_campaigncode  "
                    + "where sr.sr_campaign >='" + campaignFrom + "' and sr.sr_campaign <='" + campaignTo + "' "
                    + "and sr.sr_code >='" + proFrom + "' and sr.sr_code <='" + proTo + "' "
                    + "and sr.sr_startdate >='" + date1 + "' and sr.sr_startdate <='" + date2 + "' "
                    + "order by sr.sr_campaign, sr.sr_code";
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (db.Char_Set.equalsIgnoreCase("utf-8")) {
                        col.add(new dataBeanRedeem(
                                rs.getString("sr.sr_campaign"),
                                rs.getString("s.s_campaignname"),
                                rs.getString("sr.sr_code"),
                                rs.getString("sr.sr_name"),
                                Format.dateFmtShow.format(rs.getDate("sr.sr_startdate")),
                                Format.dateFmtShow.format(rs.getDate("sr.sr_enddate")),
                                rs.getString("sr.sr_day"),
                                rs.getString("sr.sr_saletype"),
                                rs.getString("sr.sr_saletimeS"),
                                rs.getString("sr.sr_saletimeE"),
                                rs.getInt("sr.sr_saleitem"),
                                rs.getInt("sr.sr_point")
                        ));
                    } else {
                        col.add(new dataBeanRedeem(
                                cvth.ASCII2Unicode(rs.getString("sr.sr_campaign")),
                                cvth.ASCII2Unicode(rs.getString("s.s_campaignname")),
                                cvth.ASCII2Unicode(rs.getString("sr.sr_code")),
                                cvth.ASCII2Unicode(rs.getString("sr.sr_name")),
                                Format.dateFmtShow.format(rs.getDate("sr.sr_startdate")),
                                Format.dateFmtShow.format(rs.getDate("sr.sr_enddate")),
                                cvth.ASCII2Unicode(rs.getString("sr.sr_day")),
                                cvth.ASCII2Unicode(rs.getString("sr.sr_saletype")),
                                cvth.ASCII2Unicode(rs.getString("sr.sr_saletimeS")),
                                cvth.ASCII2Unicode(rs.getString("sr.sr_saletimeE")),
                                rs.getInt("sr.sr_saleitem"),
                                rs.getInt("sr.sr_point")
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
