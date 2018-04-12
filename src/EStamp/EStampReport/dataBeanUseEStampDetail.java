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
public class dataBeanUseEStampDetail {

    private String dType = "";
    private String dCampaign = "";
    private String dPromotion = "";
    private String dBranch = "";
    private String dUseDate = "";
    private String dUseTime = "";
    private String dUseBillno = "";
    private double dUsePoint = 0;
    private String dUseCashier = "";
    private String dUseMacno = "";
    private String dVoid = "";
    private String dVoidBranch = "";
    private String dVoidDate = "";
    private String dVoidTime = "";
    private String dVoidCashier = "";
    private String dVoidMacno = "";

    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public dataBeanUseEStampDetail() {
    }

    public dataBeanUseEStampDetail(String dType, String dCampaign, String dPromotion, String dBranch, String dUseDate, String dUseTime,
            String dUseBillno, double dUsePoint, String dUseCashier, String dUseMacno, String dVoid, String dVoidBranch, String dVoidDate,
            String dVoidTime, String dVoidCashier, String dVoidMacno) {
        this.dType = dType;
        this.dCampaign = dCampaign;
        this.dPromotion = dPromotion;
        this.dBranch = dBranch;
        this.dUseDate = dUseDate;
        this.dUseTime = dUseTime;
        this.dUseBillno = dUseBillno;
        this.dUsePoint = dUsePoint;
        this.dUseCashier = dUseCashier;
        this.dUseMacno = dUseMacno;
        this.dVoid = dVoid;
        this.dVoidBranch = dVoidBranch;
        this.dVoidDate = dVoidDate;
        this.dVoidTime = dVoidTime;
        this.dVoidCashier = dVoidCashier;
        this.dVoidMacno = dVoidMacno;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public String getdCampaign() {
        return dCampaign;
    }

    public void setdCampaign(String dCampaign) {
        this.dCampaign = dCampaign;
    }

    public String getdPromotion() {
        return dPromotion;
    }

    public void setdPromotion(String dPromotion) {
        this.dPromotion = dPromotion;
    }

    public String getdBranch() {
        return dBranch;
    }

    public void setdBranch(String dBranch) {
        this.dBranch = dBranch;
    }

    public String getdUseDate() {
        return dUseDate;
    }

    public void setdUseDate(String dUseDate) {
        this.dUseDate = dUseDate;
    }

    public String getdUseTime() {
        return dUseTime;
    }

    public void setdUseTime(String dUseTime) {
        this.dUseTime = dUseTime;
    }

    public String getdUseBillno() {
        return dUseBillno;
    }

    public void setdUseBillno(String dUseBillno) {
        this.dUseBillno = dUseBillno;
    }

    public double getdUsePoint() {
        return dUsePoint;
    }

    public void setdUsePoint(double dUsePoint) {
        this.dUsePoint = dUsePoint;
    }

    public String getdUseCashier() {
        return dUseCashier;
    }

    public void setdUseCashier(String dUseCashier) {
        this.dUseCashier = dUseCashier;
    }

    public String getdUseMacno() {
        return dUseMacno;
    }

    public void setdUseMacno(String dUseMacno) {
        this.dUseMacno = dUseMacno;
    }

    public String getdVoid() {
        return dVoid;
    }

    public void setdVoid(String dVoid) {
        this.dVoid = dVoid;
    }

    public String getdVoidBranch() {
        return dVoidBranch;
    }

    public void setdVoidBranch(String dVoidBranch) {
        this.dVoidBranch = dVoidBranch;
    }

    public String getdVoidDate() {
        return dVoidDate;
    }

    public void setdVoidDate(String dVoidDate) {
        this.dVoidDate = dVoidDate;
    }

    public String getdVoidTime() {
        return dVoidTime;
    }

    public void setdVoidTime(String dVoidTime) {
        this.dVoidTime = dVoidTime;
    }

    public String getdVoidCashier() {
        return dVoidCashier;
    }

    public void setdVoidCashier(String dVoidCashier) {
        this.dVoidCashier = dVoidCashier;
    }

    public String getdVoidMacno() {
        return dVoidMacno;
    }

    public void setdVoidMacno(String dVoidMacno) {
        this.dVoidMacno = dVoidMacno;
    }

//EStamp.EStampReport.dataBeanUseEStampDetail.getCollectionUseEStampDetail
    public static Collection getCollectionUseEStampDetail(String seek) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<dataBeanUseEStampDetail> col = new ArrayList();
        String sql = seek;
        String type = "";
        String campaign = "";
        String promotion = "";
        String branch = "";
        String useDate = "";
        String useTime = "";
        String useBillno = "";
        double usePoint = 0;
        String useMacno = "";
        String useCashier = "";
        String Void = "";
        String VoidBranch = "";
        String VoidDate = "";
        String VoidTime = "";
        String VoidCashier = "";
        String VoidMacno = "";

        try {
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                        campaign = cvth.ASCII2Unicode(rs.getString("st.stamp_campaign")) + " - " + cvth.ASCII2Unicode(rs.getString("sc.s_campaignname"));
                        branch = cvth.ASCII2Unicode(rs.getString("st.use_branch")) + " - " + cvth.ASCII2Unicode(rs.getString("b.name"));
                        useDate = Format.dateFmtShow.format(rs.getDate("st.use_date"));
                        useTime = rs.getString("st.use_time");
                        useBillno = rs.getString("st.use_billno");
                        useMacno = rs.getString("st.use_macno");
                        useCashier = rs.getString("st.use_cashier");
                        Void = rs.getString("st.void_bill");

                        if (rs.getInt("st.stamp_point") > 0) {
                            type = "Point";
                            usePoint = rs.getInt("stamp_point");
                            promotion = cvth.ASCII2Unicode(rs.getString("st.stamp_promotion")) + " - "
                                    + cvth.ASCII2Unicode(getNamePromotion(rs.getString("st.stamp_promotion"), rs.getString("st.stamp_campaign")));
                        } else {
                            type = "Redeem";
                            usePoint = rs.getDouble("st.stamp_redeem");
                            promotion = cvth.ASCII2Unicode(rs.getString("st.stamp_promotion")) + " - "
                                    + cvth.ASCII2Unicode(getNameProRedeem(rs.getString("st.stamp_promotion"), rs.getString("st.stamp_campaign")));
                        }

                        if (Void.equals("Y")) {
                            VoidBranch = cvth.ASCII2Unicode(rs.getString("st.void_branch")) + " - " + cvth.ASCII2Unicode(rs.getString("bv.name"));
                            VoidDate = Format.dateFmtShow.format(rs.getDate("st.void_date"));
                            VoidTime = rs.getString("st.void_time");
                            VoidCashier = rs.getString("st.void_cashier");
                            VoidMacno = rs.getString("st.void_macno");
                        } else {
                            VoidBranch = "";
                            VoidDate = "";
                            VoidTime = "";
                            VoidCashier = "";
                            VoidMacno = "";
                        }
                    } else {
                        campaign = rs.getString("stamp_campaign") + " - " + rs.getString("stamp_campaign");
                        branch = rs.getString("st.use_branch") + " - " + rs.getString("b.name");
                        useDate = Format.dateFmtShow.format(rs.getDate("st.use_date"));
                        useTime = rs.getString("st.use_time");
                        useBillno = rs.getString("st.use_billno");
                        useMacno = rs.getString("st.use_macno");
                        useCashier = rs.getString("st.use_cashier");

                        if (rs.getInt("stamp_point") > 0) {
                            type = "Point";
                            usePoint = rs.getInt("stamp_point");
                            promotion = rs.getString("st.stamp_promotion") + " - "
                                    + getNamePromotion(rs.getString("st.stamp_promotion"), rs.getString("st.stamp_campaign"));
                        } else {
                            type = "Redeem";
                            usePoint = rs.getDouble("stamp_redeem");
                            promotion = rs.getString("st.stamp_promotion") + " - "
                                    + getNameProRedeem(rs.getString("st.stamp_promotion"), rs.getString("st.stamp_campaign"));
                        }

                        if (Void.equals("Y")) {
                            VoidBranch = rs.getString("st.void_branch") + " - " + rs.getString("bv.name");
                            VoidDate = Format.dateFmtShow.format(rs.getDate("st.void_date"));
                            VoidTime = rs.getString("st.void_time");
                            VoidCashier = rs.getString("st.void_cashier");
                            VoidMacno = rs.getString("st.void_macno");
                        } else {
                            VoidBranch = "";
                            VoidDate = "";
                            VoidTime = "";
                            VoidCashier = "";
                            VoidMacno = "";
                        }
                    }

                    col.add(new dataBeanUseEStampDetail(
                            type,
                            campaign,
                            promotion,
                            branch,
                            useDate,
                            useTime,
                            useBillno,
                            usePoint,
                            useCashier,
                            useMacno,
                            Void,
                            VoidBranch,
                            VoidDate,
                            VoidTime,
                            VoidCashier,
                            VoidMacno
                    ));
                } while (rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return col;
    }

    private static String getNamePromotion(String procode, String camapigncode) {
        String proname = "";
        try {
            String sql = "select sp_name from stamppromotion where sp_code='" + procode + "' and sp_campaign='" + camapigncode + "' ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                proname = rs.getString("sp_name");
            } else {
                proname = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return proname;
    }

    private static String getNameProRedeem(String redeemcode, String camapigncode) {
        String proname = "";
        try {
            String sql = "select sr_name from stamppromotion where sr_code='" + redeemcode + "' and sr_campaign='" + camapigncode + "' ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                proname = rs.getString("sr_name");
            } else {
                proname = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return proname;
    }
}
