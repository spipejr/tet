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
public class dataBeanSumUse_ByCapaign {

    private String campaign;
    private String dateStr;
    private String dateEnd;
    private int point;
    private int redeem;

    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public dataBeanSumUse_ByCapaign() {
    }

    public dataBeanSumUse_ByCapaign(String campaign, String dateStr, String dateEnd, int point, int redeem) {
        this.campaign = campaign;
        this.dateStr = dateStr;
        this.dateEnd = dateEnd;
        this.point = point;
        this.redeem = redeem;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
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
    
//EStamp.EStampReport.dataBeanSumUse_ByCapaign.getCollectionSumUseByCapaign
    public static Collection getCollectionSumUseByCapaign(String seek) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<dataBeanSumUse_ByCapaign> col = new ArrayList();
        String sql = seek;
        try {
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (db.Char_Set.equalsIgnoreCase("utf-8")) {
                        col.add(new dataBeanSumUse_ByCapaign(
                                rs.getString("ccode") + " " + rs.getString("cname"),
                                Format.dateFmtShow.format(rs.getDate("dateStr")),
                                Format.dateFmtShow.format(rs.getDate("dateEnd")),
                                rs.getInt("point"),
                                rs.getInt("redeem")
                        ));
                    } else {
                        col.add(new dataBeanSumUse_ByCapaign(
                                cvth.ASCII2Unicode(rs.getString("ccode")) + " " + cvth.ASCII2Unicode(rs.getString("cname")),
                                Format.dateFmtShow.format(rs.getDate("dateStr")),
                                Format.dateFmtShow.format(rs.getDate("dateEnd")),
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
