package EStamp;

import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;

public class reportSummaryEStampByBranch extends AbstractTreeTableModel {

    private Statement stmt;
    private reportSummaryEStampByBranch_Bean myroot;
    dbUtility db = new dbUtility();
    showMessage msn = new showMessage();
    ThaiUtilities cvth = new ThaiUtilities();

    public reportSummaryEStampByBranch(String sql, String code) throws SQLException {
        db.dbconnect();
        stmt = null;
        double total4 = 0, total5 = 0, total1 = 0, total2 = 0, total3 = 0,
                total6 = 0, total7 = 0, total8 = 0, total9 = 0, total10 = 0, total11 = 0, totalCoupon = 0, totalVoucher = 0, totalAr = 0;
        double totalgroup1 = 0, totalgroup2 = 0, totalgroup3 = 0, totalgroup6 = 0, totalgroup7 = 0,
                totalgroup8 = 0, totalgroup9 = 0, totalgroup10 = 0, totalgroup4 = 0, totalgroup5 = 0, totalgroup11 = 0,
                totalgCoupon = 0, totalgVoucher = 0, totalgAr = 0;
        int countPoint = 0;
        int countRedeem = 0;
        int i = 1;

        ResultSet rs = null;
        stmt = (Statement) dbUtility.con.createStatement();
        rs = stmt.executeQuery(sql);
        reportSummaryEStampByCampaign_Bean subtree = null;
        myroot = new reportSummaryEStampByBranch_Bean();

        String tempC = "", tempCname = "";
        String _tempC = "", _tempCname = "";

        String branch = "", campaigncode = "", campaignname = "", point = "", redeem = "";
        while (rs.next()) {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                tempC = rs.getString("ccode");
                tempCname = rs.getString("cname");

//                campaign = cvth.ASCII2Unicode(rs.getString("ccode")) + " " + cvth.ASCII2Unicode(rs.getString("cname"));
//                branch = cvth.ASCII2Unicode(rs.getString("custtel")) + " " + cvth.ASCII2Unicode(rs.getString("custname"));
                branch = cvth.ASCII2Unicode(rs.getString("ccode")) + " " + cvth.ASCII2Unicode(rs.getString("cname"));
                campaigncode = cvth.ASCII2Unicode(rs.getString("custtel"));
                campaignname = cvth.ASCII2Unicode(rs.getString("custname"));
                point = cvth.ASCII2Unicode(rs.getString("point"));
                redeem = cvth.ASCII2Unicode(rs.getString("redeem"));
            } else {
                tempC = rs.getString("ccode");
                tempCname = rs.getString("cname");

                branch = rs.getString("ccode") + " " + rs.getString("cname");
                campaigncode = rs.getString("custtel");
                campaignname = rs.getString("custname");
                point = rs.getString("point");
                redeem = rs.getString("redeem");

            }

            myroot.getChildren().add(new reportSummaryEStampByBranch_Bean(branch, campaigncode, campaignname, point, redeem));

            countPoint = countPoint + rs.getInt("point");
            countRedeem = countRedeem + rs.getInt("redeem");
        }
//        if (subtree != null) {
//            subtree.getChildren().add(new reportSummaryEStampByCampaign_Bean("รวมของสาขา " + _tempC, "", ""));
//            subtree.setCampaign(tempC + "-" + tempCname);
//            myroot.getChildren().add(subtree);
//        }
        myroot.getChildren().add(new reportSummaryEStampByBranch_Bean("ยอดรวมทั้งสิ้น", "", "", countPoint + "", countRedeem + ""));

        myroot.setBranch("Report List ");
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getValueAt(Object node, int column) {
        reportSummaryEStampByBranch_Bean treenode = (reportSummaryEStampByBranch_Bean) node;
        switch (column) {
            case 0:
                return treenode.getBranch();
            case 1:
                return treenode.getCampaogncode();
            case 2:
                return treenode.getCampaognname();
            case 3:
                return treenode.getPoint();
            case 4:
                return treenode.getRedeem();

            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int column) {
        reportSummaryEStampByBranch_Bean treenode = (reportSummaryEStampByBranch_Bean) node;
        return treenode.getChildren().get(column);
    }

    @Override
    public int getChildCount(Object parent) {
        reportSummaryEStampByBranch_Bean treenode = (reportSummaryEStampByBranch_Bean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        reportSummaryEStampByBranch_Bean treenode = (reportSummaryEStampByBranch_Bean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportSummaryEStampByBranch_Bean treenode = (reportSummaryEStampByBranch_Bean) node;
        if (treenode.getChildren().size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    public Object getRoot() {
        return myroot;
    }

}
