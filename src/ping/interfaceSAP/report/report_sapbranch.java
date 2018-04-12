package ping.interfaceSAP.report;

import EStamp.*;
import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;

public class report_sapbranch extends AbstractTreeTableModel {

    private Statement stmt;
    private report_sapbranchbean myroot;
    dbUtility db = new dbUtility();
    showMessage msn = new showMessage();
    ThaiUtilities cvth = new ThaiUtilities();

    public report_sapbranch(String sql, String code) throws SQLException {
        db.dbconnect();
        stmt = null;
        String tempbtype = "", tempbtypeold = "", tempbtypename = "", tempbtypenameold = "";
        String tempdate = "", tempdateold = "";
        String dateU = "";
        double totalBranch = 0, totalBranch1 = 0;
        int countBranch = 0;
        int counttotal = 0;
        int i = 1;

        ResultSet rs = null;
        stmt = (Statement) dbUtility.con.createStatement();
        rs = stmt.executeQuery(sql);
        report_sapbranchbean subtree = null;
        myroot = new report_sapbranchbean();

        if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
            while (rs.next()) {
                tempbtype = cvth.ASCII2Unicode(rs.getString("btype"));
                tempbtypename = cvth.ASCII2Unicode(rs.getString("btname"));

                if (!tempbtypeold.equals(tempbtype)) {
                    if (subtree != null) {
                        subtree.getChildren().add(new report_sapbranchbean("รวมของประเภท " + tempbtypeold + " จำนวน " + countBranch + " สาขา", "", "", " ", " ", " "));
                        myroot.getChildren().add(subtree);
                        subtree.setBtype(tempbtypeold + "-" + tempbtypenameold);
                        countBranch = 0;
                    }
                    subtree = new report_sapbranchbean();
                    i = 1;

//                    String btype = cvth.ASCII2Unicode(rs.getString("btype")) + " " + cvth.ASCII2Unicode(rs.getString("btname"));
                    String btype = cvth.ASCII2Unicode(rs.getString("btype"));
                    String branchcode = cvth.ASCII2Unicode(rs.getString("bcode"));
                    String branchname = cvth.ASCII2Unicode(rs.getString("bname"));
                    String sapcode = cvth.ASCII2Unicode(rs.getString("sap_site_code"));
                    String sapname = cvth.ASCII2Unicode(rs.getString("sap_site_name"));
                    String sapcashbank = cvth.ASCII2Unicode(rs.getString("sap_site_cashbank"));

                    if (branchcode == null) {
                        branchcode = " ";
                    }
                    if (sapcode == null) {
                        sapcode = " ";
                    }
                    subtree.getChildren().add(new report_sapbranchbean(btype, branchcode, branchname, sapcode, sapname, sapcashbank));
                } else {
//                    String btype = cvth.ASCII2Unicode(rs.getString("btype")) + " " + cvth.ASCII2Unicode(rs.getString("btname"));
                    String btype = cvth.ASCII2Unicode(rs.getString("btype"));
                    String branchcode = cvth.ASCII2Unicode(rs.getString("bcode"));
                    String branchname = cvth.ASCII2Unicode(rs.getString("bname"));
                    String sapcode = cvth.ASCII2Unicode(rs.getString("sap_site_code"));
                    String sapname = cvth.ASCII2Unicode(rs.getString("sap_site_name"));
                    String sapcashbank = cvth.ASCII2Unicode(rs.getString("sap_site_cashbank"));

                    if (branchcode == null) {
                        branchcode = " ";
                    }
                    if (sapcode == null) {
                        sapcode = " ";
                    }
                    subtree.getChildren().add(new report_sapbranchbean(btype, branchcode, branchname, sapcode, sapname, sapcashbank));
                }
                countBranch++;
                counttotal++;
                tempbtypeold = cvth.ASCII2Unicode(rs.getString("btype"));
                tempbtypenameold = cvth.ASCII2Unicode(rs.getString("btname"));
            }
            if (subtree != null) {
                subtree.getChildren().add(new report_sapbranchbean("รวมของประเภท " + tempbtypeold + " จำนวน " + countBranch + " สาขา", "", "", " ", " ", ""));
                subtree.setBtype(tempbtype + "-" + tempbtypename);
                myroot.getChildren().add(subtree);
            }
            myroot.getChildren().add(new report_sapbranchbean("ยอดรวมทั้งสิ้น " + counttotal + " สาขา",
                    "", " ", " ", " ", ""
            ));
        } else {
            while (rs.next()) {
                tempbtype = rs.getString("btype");
                tempbtypename = rs.getString("btname");

                if (!tempbtypeold.equals(tempbtype)) {
                    if (subtree != null) {
                        subtree.getChildren().add(new report_sapbranchbean(tempbtypeold,
                                "", "", " ", " ", " "
                        ));
                        myroot.getChildren().add(subtree);
                        subtree.setBtype(tempbtypeold + "-" + tempbtypenameold);
                        countBranch = 0;
                    }
                    subtree = new report_sapbranchbean();
                    i = 1;

                    String btype = rs.getString("btype") + " " + rs.getString("btname");
                    String branchcode = rs.getString("bcode");
                    String branchname = rs.getString("bname");
                    String sapcode = rs.getString("sap_site_code");
                    String sapname = rs.getString("sap_site_name");
                    String sapcashbank = rs.getString("sap_site_cashbank");
                    if (branchcode == null) {
                        branchcode = " ";
                    }
                    if (sapcode == null) {
                        sapcode = " ";
                    }
                    subtree.getChildren().add(new report_sapbranchbean(btype, branchcode, branchname, sapcode, sapname, sapcashbank));

                } else {
//                    String btype = rs.getString("btype") + " " + rs.getString("btname");
                    String btype = rs.getString("btype");
                    String branchcode = rs.getString("bcode");
                    String branchname = rs.getString("bname");
                    String sapcode = rs.getString("sap_site_code");
                    String sapname = rs.getString("sap_site_name");
                    String sapcashbank = rs.getString("sap_site_cashbank");

                    if (branchcode == null) {
                        branchcode = " ";
                    }

                    if (sapcode == null) {
                        sapcode = " ";
                    }

                    subtree.getChildren().add(new report_sapbranchbean(btype, branchcode, branchname, sapcode, sapname, sapcashbank));
                }
                countBranch++;
                counttotal++;
                tempbtypeold = rs.getString("btype");
                tempbtypenameold = rs.getString("btname");
            }
            if (subtree != null) {
                subtree.getChildren().add(new report_sapbranchbean("รวมของประเภท " + tempbtypeold + " จำนวน " + countBranch + " สาขา",
                        "", "", " ", " ", ""));
                subtree.setBtype(tempbtype + "-" + tempbtypename);
                myroot.getChildren().add(subtree);
            }
            myroot.getChildren().add(new report_sapbranchbean("ยอดรวมทั้งสิ้น " + counttotal + " สาขา",
                    "", " ", " ", " ", " "
            ));
        }
        myroot.setBtype("Report List ");
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
        report_sapbranchbean treenode = (report_sapbranchbean) node;
        switch (column) {
            case 0:
                return treenode.getBtype();
            case 1:
                return treenode.getBranchcode();
            case 2:
                return treenode.getBranchname();
            case 3:
                return treenode.getSapcode();
            case 4:
                return treenode.getSapname();
            case 5:
                return treenode.getSapcashank();

            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int column) {
        report_sapbranchbean treenode = (report_sapbranchbean) node;
        return treenode.getChildren().get(column);
    }

    @Override
    public int getChildCount(Object parent) {
        report_sapbranchbean treenode = (report_sapbranchbean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        report_sapbranchbean treenode = (report_sapbranchbean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        report_sapbranchbean treenode = (report_sapbranchbean) node;
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
