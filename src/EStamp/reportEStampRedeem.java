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

public class reportEStampRedeem extends AbstractTreeTableModel {

    private Statement stmt;
    private reportEStampRedeem_Bean myroot;
    dbUtility db = new dbUtility();
    showMessage msn = new showMessage();
    ThaiUtilities cvth = new ThaiUtilities();

    public reportEStampRedeem(String sql, String code) throws SQLException {
        db.dbconnect();
        stmt = null;
        String tempvender = "", tempvenderold = "", tempvname = "", tempvnameold = "";
        String tempcampaign = "", tempcampaignold = "", tempcname = "";
        String tempbran = "", tempbranold = "", tempbname = "", tempbnameold = "";
        String tempdate = "", tempdateold = "";
        String dateU = "";
        double total4 = 0, total5 = 0, total1 = 0, total2 = 0, total3 = 0,
                total6 = 0, total7 = 0, total8 = 0, total9 = 0, total10 = 0, total11 = 0, totalCoupon = 0, totalVoucher = 0, totalAr = 0;
        double totalgroup1 = 0, totalgroup2 = 0, totalgroup3 = 0, totalgroup6 = 0, totalgroup7 = 0,
                totalgroup8 = 0, totalgroup9 = 0, totalgroup10 = 0, totalgroup4 = 0, totalgroup5 = 0, totalgroup11 = 0,
                totalgCoupon = 0, totalgVoucher = 0, totalgAr = 0;
        int countgroup = 0;
        int counttotal = 0;
        int i = 1;

        ResultSet rs = null;
        stmt = (Statement) dbUtility.con.createStatement();
        rs = stmt.executeQuery(sql);
        reportEStampRedeem_Bean subtree = null;
        myroot = new reportEStampRedeem_Bean();

        if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
            while (rs.next()) {
                tempbran = cvth.ASCII2Unicode(rs.getString("use_branch"));
                tempbname = cvth.ASCII2Unicode(rs.getString("name"));
                Date dds, dde;
                try {
                    dds = Format.dateFmtSql.parse(rs.getString("use_date"));
                    dateU = Format.dateFmtShow.format(dds);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                if (!tempbranold.equals(tempbran)) {
                    if (subtree != null) {
//                        subtree.getChildren().add(new reportEStampRedeem_Bean(tempbranold, "", "", " ", " ", " "));
                         subtree.getChildren().add(new reportEStampRedeem_Bean("รวมของสาขา " + tempbranold,
                        "", "", " ", " ", countgroup + ""));
                        myroot.getChildren().add(subtree);
                        subtree.setU_barcode(tempbranold + "-" + tempbnameold);
                    }
                    subtree = new reportEStampRedeem_Bean();
                    countgroup = 0;
                    i = 1;

                    String bran = cvth.ASCII2Unicode(rs.getString("use_branch")) + " " + cvth.ASCII2Unicode(rs.getString("name"));
                    String barcode = cvth.ASCII2Unicode(rs.getString("barcode"));
                    String cam = cvth.ASCII2Unicode(rs.getString("campaign"));
                    String billno = cvth.ASCII2Unicode(rs.getString("use_billno"));
                    String date = Format.dateFmtShow.format(rs.getDate("use_date"));
                    String time = cvth.ASCII2Unicode(rs.getString("use_time"));
                    String point = rs.getString("point");

                    if (cam == null) {
                        cam = " ";
                    }

                    if (bran == null) {
                        bran = " ";
                    }

                    subtree.getChildren().add(new reportEStampRedeem_Bean(
                            barcode, cam, billno, date, time, point));
                } else {

                    String bran = cvth.ASCII2Unicode(rs.getString("use_branch")) + " " + cvth.ASCII2Unicode(rs.getString("name"));
                    String barcode = cvth.ASCII2Unicode(rs.getString("barcode"));
                    String cam = cvth.ASCII2Unicode(rs.getString("campaign"));
                    String billno = cvth.ASCII2Unicode(rs.getString("use_billno"));
                    String date = Format.dateFmtShow.format(rs.getDate("use_date"));
                    String time = cvth.ASCII2Unicode(rs.getString("use_time"));
                    String point = rs.getString("point");

                    if (cam == null) {
                        cam = " ";
                    }

                    if (bran == null) {
                        bran = " ";
                    }

                    subtree.getChildren().add(new reportEStampRedeem_Bean(barcode, cam, billno, date, time, point));
                }
                countgroup = countgroup + rs.getInt("point");
                counttotal = counttotal + rs.getInt("point");
                tempbranold = cvth.ASCII2Unicode(rs.getString("use_branch"));
                tempbnameold = cvth.ASCII2Unicode(rs.getString("name"));
            }
            if (subtree != null) {
                subtree.getChildren().add(new reportEStampRedeem_Bean("รวมของสาขา " + tempbranold,
                        "", "", " ", " ", countgroup + ""));
                subtree.setU_barcode(tempbran + "-" + tempbname);
                myroot.getChildren().add(subtree);
            }
            myroot.getChildren().add(new reportEStampRedeem_Bean("ยอดรวมทั้งสิ้น",
                    "", " ", " ", " ", counttotal + ""
            ));
        } else {
            while (rs.next()) {
                tempbran = rs.getString("use_branch");
                tempbname = rs.getString("name");
                Date dds, dde;
                try {
                    dds = Format.dateFmtSql.parse(rs.getString("use_date"));
                    dateU = Format.dateFmtShow.format(dds);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                if (!tempbranold.equals(tempbran)) {
                    if (subtree != null) {
//                        subtree.getChildren().add(new reportEStampRedeem_Bean(tempbranold,
//                                "", "", " ", " ", " "
//                        ));
                         subtree.getChildren().add(new reportEStampRedeem_Bean("รวมของสาขา " + tempbranold,
                        "", "", " ", " ", countgroup + ""));
                        myroot.getChildren().add(subtree);
                        subtree.setU_barcode(tempbranold + "-" + tempbnameold);
                    }
                    subtree = new reportEStampRedeem_Bean();
                    countgroup = 0;
                    i = 1;

                    String bran = rs.getString("use_branch") + " " + rs.getString("name");
                    String barcode = rs.getString("barcode");
                    String cam = rs.getString("campaign");
                    String billno = rs.getString("use_billno");
                    String date = Format.dateFmtShow.format(rs.getDate("use_date"));
                    String time = rs.getString("use_time");
                    String point = rs.getString("point");

                    if (cam == null) {
                        cam = " ";
                    }

                    if (bran == null) {
                        bran = " ";
                    }

                    subtree.getChildren().add(new reportEStampRedeem_Bean(
                            barcode, cam, billno, date, time, point
                    ));
                } else {

                    String bran = rs.getString("use_branch") + " " + rs.getString("name");
                    String barcode = rs.getString("barcode");
                    String cam = rs.getString("campaign");
                    String billno = rs.getString("use_billno");
                    String date = Format.dateFmtShow.format(rs.getDate("use_date"));
                    String time = rs.getString("use_time");
                    String point = rs.getString("point");

                    if (cam == null) {
                        cam = " ";
                    }

                    if (bran == null) {
                        bran = " ";
                    }

                    subtree.getChildren().add(new reportEStampRedeem_Bean(
                            barcode, cam, billno, date, time, point
                    ));
                }

                countgroup = countgroup + rs.getInt("point");
                counttotal = counttotal + rs.getInt("point");
                tempbranold = rs.getString("use_branch");
                tempbnameold = rs.getString("use_branch");
            }
            if (subtree != null) {
                subtree.getChildren().add(new reportEStampRedeem_Bean("รวมของสาขา " + tempbranold,
                        "", "", " ", " ", countgroup + ""));
                subtree.setU_barcode(tempbran + "-" + tempbname);
                myroot.getChildren().add(subtree);
            }
            myroot.getChildren().add(new reportEStampRedeem_Bean("ยอดรวมทั้งสิ้น",
                    "", " ", " ", " ", counttotal + ""
            ));
        }
        myroot.setU_barcode("Report List ");
    }

    @Override
    public int getColumnCount() {
        return 6;
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
        reportEStampRedeem_Bean treenode = (reportEStampRedeem_Bean) node;
        switch (column) {
            case 0:
                return treenode.getU_barcode();
            case 1:
                return treenode.getU_campaign();
            case 2:
                return treenode.getU_refno();
            case 3:
                return treenode.getU_date();
            case 4:
                return treenode.getU_time();
            case 5:
                return treenode.getU_point();

            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int column) {
        reportEStampRedeem_Bean treenode = (reportEStampRedeem_Bean) node;
        return treenode.getChildren().get(column);
    }

    @Override
    public int getChildCount(Object parent) {
        reportEStampRedeem_Bean treenode = (reportEStampRedeem_Bean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        reportEStampRedeem_Bean treenode = (reportEStampRedeem_Bean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportEStampRedeem_Bean treenode = (reportEStampRedeem_Bean) node;
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
