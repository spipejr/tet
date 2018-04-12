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
public class dataBeanCampaignfile {

    private String campaigncode;
    private String campaignname;
    private String campaigndateStr;
    private String campaigndateEnd;
    private String campaignremark;
    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public dataBeanCampaignfile() {
    }

    public dataBeanCampaignfile(String campaigncode, String campaignname, String campaigndateStr, String campaigndateEnd, String campaignremark) {
        this.campaigncode = campaigncode;
        this.campaignname = campaignname;
        this.campaigndateStr = campaigndateStr;
        this.campaigndateEnd = campaigndateEnd;
        this.campaignremark = campaignremark;
    }

    public String getCampaigncode() {
        return campaigncode;
    }

    public void setCampaigncode(String campaigncode) {
        this.campaigncode = campaigncode;
    }

    public String getCampaignname() {
        return campaignname;
    }

    public void setCampaignname(String campaignname) {
        this.campaignname = campaignname;
    }

    public String getCampaigndateStr() {
        return campaigndateStr;
    }

    public void setCampaigndateStr(String campaigndateStr) {
        this.campaigndateStr = campaigndateStr;
    }

    public String getCampaigndateEnd() {
        return campaigndateEnd;
    }

    public void setCampaigndateEnd(String campaigndateEnd) {
        this.campaigndateEnd = campaigndateEnd;
    }

    public String getCampaignremark() {
        return campaignremark;
    }

    public void setCampaignremark(String campaignremark) {
        this.campaignremark = campaignremark;
    }

    public static Collection getCollectionCampaign(String s_camapaigncode1, String s_camapaigncode2, String s_camapaigndate1, String s_camapaigndate2) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<dataBeanCampaignfile> col = new ArrayList();

        try {
            String sql = "select * from stampcampaign "
                    + "where s_campaigncode>='" + s_camapaigncode1 + "' and  s_campaigncode <='" + s_camapaigncode2 + "' "
                    + "and s_campaignstart>='" + s_camapaigndate1 + "' and s_campaignend <='" + s_camapaigndate2 + "' "
                    + "order by s_campaigncode ";
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (db.Char_Set.equalsIgnoreCase("utf-8")) {
                        col.add(new dataBeanCampaignfile(rs.getString("s_campaigncode"),
                                rs.getString("s_campaignname"),
                                Format.dateFmtShow.format(rs.getDate("s_campaignstart")),
                                Format.dateFmtShow.format(rs.getDate("s_campaignend")),
                                rs.getString("s_campaignremark")
                        ));
                    } else {
                        col.add(new dataBeanCampaignfile(cvth.ASCII2Unicode(rs.getString("s_campaigncode")),
                                cvth.ASCII2Unicode(rs.getString("s_campaignname")),
                                Format.dateFmtShow.format(rs.getDate("s_campaignstart")),
                                Format.dateFmtShow.format(rs.getDate("s_campaignend")),
                                cvth.ASCII2Unicode(rs.getString("s_campaignremark"))
                        ));
                    }
                } while (rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("col " + col.toString());
        return col;
    }
}
