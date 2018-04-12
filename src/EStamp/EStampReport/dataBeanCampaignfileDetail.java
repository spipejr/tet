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
import utilititiesfunction.getLanguage;

/**
 *
 * @author pos
 */
public class dataBeanCampaignfileDetail {

    private String s_campaigncode;
    private String s_campaignname;
    private String s_campaigndateStr;
    private String s_campaigndateEnd;
    private String s_campaignRemark;
    private String s_protype;
    private String s_procode;
    private String s_proname;
    private String s_prodateStr;
    private String s_prodateEnd;
    private String s_proday;
    private String s_prosaletype;
    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();
    

    public dataBeanCampaignfileDetail() {
    }

    public dataBeanCampaignfileDetail(String s_campaigncode, String s_campaignname, String s_campaigndateStr, String s_campaigndateEnd,
            String s_campaignRemark, String s_protype, String s_procode, String s_proname, String s_prodateStr, String s_prodateEnd, String s_proday,
            String s_prosaletype) {
        this.s_campaigncode = s_campaigncode;
        this.s_campaignname = s_campaignname;
        this.s_campaigndateStr = s_campaigndateStr;
        this.s_campaigndateEnd = s_campaigndateEnd;
        this.s_campaignRemark = s_campaignRemark;
        this.s_protype = s_protype;
        this.s_procode = s_procode;
        this.s_proname = s_proname;
        this.s_prodateStr = s_prodateStr;
        this.s_prodateEnd = s_prodateEnd;
        this.s_proday = s_proday;
        this.s_prosaletype = s_prosaletype;
    }

    public String getS_campaigncode() {
        return s_campaigncode;
    }

    public void setS_campaigncode(String s_campaigncode) {
        this.s_campaigncode = s_campaigncode;
    }

    public String getS_campaignname() {
        return s_campaignname;
    }

    public void setS_campaignname(String s_campaignname) {
        this.s_campaignname = s_campaignname;
    }

    public String getS_campaigndateStr() {
        return s_campaigndateStr;
    }

    public void setS_campaigndateStr(String s_campaigndateStr) {
        this.s_campaigndateStr = s_campaigndateStr;
    }

    public String getS_campaigndateEnd() {
        return s_campaigndateEnd;
    }

    public void setS_campaigndateEnd(String s_campaigndateEnd) {
        this.s_campaigndateEnd = s_campaigndateEnd;
    }

    public String getS_campaignRemark() {
        return s_campaignRemark;
    }

    public void setS_campaignRemark(String s_campaignRemark) {
        this.s_campaignRemark = s_campaignRemark;
    }

    public String getS_protype() {
        return s_protype;
    }

    public void setS_protype(String s_protype) {
        this.s_protype = s_protype;
    }

    public String getS_procode() {
        return s_procode;
    }

    public void setS_procode(String s_procode) {
        this.s_procode = s_procode;
    }

    public String getS_proname() {
        return s_proname;
    }

    public void setS_proname(String s_proname) {
        this.s_proname = s_proname;
    }

    public String getS_prodateStr() {
        return s_prodateStr;
    }

    public void setS_prodateStr(String s_prodateStr) {
        this.s_prodateStr = s_prodateStr;
    }

    public String getS_prodateEnd() {
        return s_prodateEnd;
    }

    public void setS_prodateEnd(String s_prodateEnd) {
        this.s_prodateEnd = s_prodateEnd;
    }

    public String getS_proday() {
        return s_proday;
    }

    public void setS_proday(String s_proday) {
        this.s_proday = s_proday;
    }

    public String getS_prosaletype() {
        return s_prosaletype;
    }

    public void setS_prosaletype(String s_prosaletype) {
        this.s_prosaletype = s_prosaletype;
    }

    public static Collection getCollectionCampaignDetail() {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<dataBeanCampaignfileDetail> col = new ArrayList();

        try {
            String sql = "select * from stamptempproreport "
                    + "group by s_campaigncode,s_protype,s_procode "
                    + "order by s_campaigncode,s_protype,s_procode ";
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (db.Char_Set.equalsIgnoreCase("utf-8")) {
                        col.add(new dataBeanCampaignfileDetail(rs.getString("s_campaigncode"),
                                rs.getString("s_campaignname"),
                                Format.dateFmtShow.format(rs.getDate("s_campaigndateStr")),
                                Format.dateFmtShow.format(rs.getDate("s_campaigndateEnd")),
                                rs.getString("s_campaignRemark"),
                                rs.getString("s_protype"),
                                rs.getString("s_procode"),
                                rs.getString("s_proname"),
                                Format.dateFmtShow.format(rs.getDate("s_prodateStr")),
                                Format.dateFmtShow.format(rs.getDate("s_prodateEnd")),
                                rs.getString("s_proday"),
                                rs.getString("s_prosaletype")
                        ));
                    } else {
                        col.add(new dataBeanCampaignfileDetail(
                                cvth.ASCII2Unicode(rs.getString("s_campaigncode")),
                                cvth.ASCII2Unicode(rs.getString("s_campaignname")),
                                Format.dateFmtShow.format(rs.getDate("s_campaigndateStr")),
                                Format.dateFmtShow.format(rs.getDate("s_campaigndateEnd")),
                                cvth.ASCII2Unicode(rs.getString("s_campaignRemark")),
                                cvth.ASCII2Unicode(rs.getString("s_protype")),
                                cvth.ASCII2Unicode(rs.getString("s_procode")),
                                cvth.ASCII2Unicode(rs.getString("s_proname")),
                                Format.dateFmtShow.format(rs.getDate("s_prodateStr")),
                                Format.dateFmtShow.format(rs.getDate("s_prodateEnd")),
                                cvth.ASCII2Unicode(rs.getString("s_proday")),
                                cvth.ASCII2Unicode(rs.getString("s_prosaletype"))
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
