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

public class reportActivateEStampBarcode extends AbstractTreeTableModel {

    private Statement stmt;
    private reportActivateEStampBarcode_Bean myroot;
    dbUtility db = new dbUtility();
    showMessage msn = new showMessage();
    ThaiUtilities cvth = new ThaiUtilities();

    public reportActivateEStampBarcode(String sql, String code) throws SQLException {
        db.dbconnect();
        stmt = null;
        double total4 = 0, total5 = 0, total1 = 0, total2 = 0, total3 = 0,
                total6 = 0, total7 = 0, total8 = 0, total9 = 0, total10 = 0, total11 = 0, totalCoupon = 0, totalVoucher = 0, totalAr = 0;
        double totalgroup1 = 0, totalgroup2 = 0, totalgroup3 = 0, totalgroup6 = 0, totalgroup7 = 0,
                totalgroup8 = 0, totalgroup9 = 0, totalgroup10 = 0, totalgroup4 = 0, totalgroup5 = 0, totalgroup11 = 0,
                totalgCoupon = 0, totalgVoucher = 0, totalgAr = 0;
        int countBarcode = 0;
        int countTotal = 0;
        int i = 1;

        ResultSet rs = null;
        stmt = (Statement) dbUtility.con.createStatement();
        rs = stmt.executeQuery(sql);
        reportActivateEStampBarcode_Bean subtree = null;
        myroot = new reportActivateEStampBarcode_Bean();

        String tempBranch = "", tempBranchName = "";
        String tempBranchOld = "", tempBranchOldName = "";

        String stamp_barcode = "", stamp_custphone = "", stamp_custname = "", stamp_date = "", stamp_time = "", stamp_macno = "", stamp_cashier = "";
        if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
            while (rs.next()) {
                tempBranch = cvth.ASCII2Unicode(rs.getString("stamp_branchAct"));
                tempBranchName = cvth.ASCII2Unicode(rs.getString("name"));
                if (!tempBranchOld.equals(tempBranch)) {
                    if (subtree != null) {
                        subtree.getChildren().add(new reportActivateEStampBarcode_Bean("รวมของสาขา " + tempBranchOld + " จำนวน " + countBarcode + " รายการ",
                        "", "", " ", " ", "", "", ""));
                        myroot.getChildren().add(subtree);
                        subtree.setStamp_branchact(tempBranchOld + "-" + tempBranchOldName);
                    }

                    countBarcode = 0;
                    subtree = new reportActivateEStampBarcode_Bean();

                    stamp_barcode = cvth.ASCII2Unicode(rs.getString("stamp_barcode"));
                    stamp_custphone = cvth.ASCII2Unicode(rs.getString("stamp_phone"));
                    stamp_custname = cvth.ASCII2Unicode(rs.getString("stamp_custname"));
                    stamp_date = Format.dateFmtShow.format(rs.getDate("stamp_dateact"));
                    stamp_time = cvth.ASCII2Unicode(rs.getString("stamp_timeact"));
                    stamp_macno = cvth.ASCII2Unicode(rs.getString("stamp_macnoact"));
                    stamp_cashier = cvth.ASCII2Unicode(rs.getString("stamp_cashieract"));

                    subtree.getChildren().add(new reportActivateEStampBarcode_Bean(tempBranch, stamp_barcode, stamp_custphone, stamp_custname,
                            stamp_date, stamp_time, stamp_macno, stamp_cashier));
                } else {
                    stamp_barcode = cvth.ASCII2Unicode(rs.getString("stamp_barcode"));
                    stamp_custphone = cvth.ASCII2Unicode(rs.getString("stamp_phone"));
                    stamp_custname = cvth.ASCII2Unicode(rs.getString("stamp_custname"));
                    stamp_date = Format.dateFmtShow.format(rs.getDate("stamp_dateact"));
                    stamp_time = cvth.ASCII2Unicode(rs.getString("stamp_timeact"));
                    stamp_macno = cvth.ASCII2Unicode(rs.getString("stamp_macnoact"));
                    stamp_cashier = cvth.ASCII2Unicode(rs.getString("stamp_cashieract"));

                    subtree.getChildren().add(new reportActivateEStampBarcode_Bean(tempBranch, stamp_barcode, stamp_custphone, stamp_custname,
                            stamp_date, stamp_time, stamp_macno, stamp_cashier));
                }
                tempBranchOld = cvth.ASCII2Unicode(rs.getString("stamp_branchAct"));
                tempBranchOldName = cvth.ASCII2Unicode(rs.getString("name"));
                countBarcode++;
                countTotal++;
            }
            if (subtree != null) {
                subtree.getChildren().add(new reportActivateEStampBarcode_Bean("รวมของสาขา " + tempBranchOld + " จำนวน " + countBarcode + " รายการ",
                        "", "", " ", " ", "", "", ""));
                subtree.setStamp_branchact(tempBranch + "-" + tempBranchName);
                myroot.getChildren().add(subtree);
            }
            myroot.getChildren().add(new reportActivateEStampBarcode_Bean("ยอดรวมทั้งสิ้น     จำนวน " + countTotal + " รายการ",
                    "", " ", " ", " ", "", "", ""
            ));

        } else {
            while (rs.next()) {

            }
        }

        myroot.setStamp_branchact("Report List ");
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column
    ) {
        switch (column) {
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getValueAt(Object node, int column
    ) {
        reportActivateEStampBarcode_Bean treenode = (reportActivateEStampBarcode_Bean) node;
        switch (column) {
            case 0:
                return treenode.getStamp_branchact();
            case 1:
                return treenode.getStamp_barcode();
            case 2:
                return treenode.getStamp_custphone();
            case 3:
                return treenode.getStamp_custname();
            case 4:
                return treenode.getStamp_date();
            case 5:
                return treenode.getStamp_time();
            case 6:
                return treenode.getStamp_macno();
            case 7:
                return treenode.getStamp_cashier();

            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int column
    ) {
        reportActivateEStampBarcode_Bean treenode = (reportActivateEStampBarcode_Bean) node;
        return treenode.getChildren().get(column);
    }

    @Override
    public int getChildCount(Object parent
    ) {
        reportActivateEStampBarcode_Bean treenode = (reportActivateEStampBarcode_Bean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child
    ) {
        reportActivateEStampBarcode_Bean treenode = (reportActivateEStampBarcode_Bean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportActivateEStampBarcode_Bean treenode = (reportActivateEStampBarcode_Bean) node;
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
