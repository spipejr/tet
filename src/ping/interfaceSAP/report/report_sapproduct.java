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

public class report_sapproduct extends AbstractTreeTableModel {

    private Statement stmt;
    private report_sapproductbean myroot;
    dbUtility db = new dbUtility();
    showMessage msn = new showMessage();
    ThaiUtilities cvth = new ThaiUtilities();

    public report_sapproduct(String sql, String code) throws SQLException {
        db.dbconnect();
        stmt = null;
        String temppgroup = "", temppgroupold = "", temppgroupname = "", temppgroupnameold = "";
        String tempdate = "", tempdateold = "";
        String dateU = "";
        double totalBranch = 0, totalBranch1 = 0;
        int countBranch = 0;
        int counttotal = 0;
        int i = 1;

        ResultSet rs = null;
        stmt = (Statement) dbUtility.con.createStatement();
        rs = stmt.executeQuery(sql);
        report_sapproductbean subtree = null;
        myroot = new report_sapproductbean();

        if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
            while (rs.next()) {
                temppgroup = cvth.ASCII2Unicode(rs.getString("pgroup"));
                temppgroupname = cvth.ASCII2Unicode(rs.getString("groupname"));

                if (!temppgroupold.equals(temppgroup)) {
                    if (subtree != null) {
                        subtree.getChildren().add(new report_sapproductbean("รวมของกลุ่ม " + temppgroupold + " จำนวน " + countBranch + " รายการ", "", "", " ", " ", " ", " "));
                        myroot.getChildren().add(subtree);
                        subtree.setPgroup(temppgroupold + "-" + temppgroupnameold);
                        countBranch = 0;
                    }
                    subtree = new report_sapproductbean();
                    i = 1;

//                    String btype = cvth.ASCII2Unicode(rs.getString("pgroup")) + " " + cvth.ASCII2Unicode(rs.getString("groupname"));
                    String pgroup = cvth.ASCII2Unicode(rs.getString("pgroup"));
                    String pcode = cvth.ASCII2Unicode(rs.getString("pcode"));
                    String pname = cvth.ASCII2Unicode(rs.getString("pdesc"));
                    String pactive = cvth.ASCII2Unicode(rs.getString("pactive"));
                    String pbgroup = cvth.ASCII2Unicode(rs.getString("bgroup"));
                    String sapcode = cvth.ASCII2Unicode(rs.getString("sap_article"));
                    String sapname = cvth.ASCII2Unicode(rs.getString("sap_article_name"));

                    if (pgroup == null) {
                        pgroup = " ";
                    }
                    if (pcode == null) {
                        pcode = " ";
                    }
                    if (sapcode == null) {
                        sapcode = " ";
                    }
                    subtree.getChildren().add(new report_sapproductbean(pgroup, pcode, pname, pactive, sapcode, sapname, pbgroup));
                } else {
//                    String pgroup = cvth.ASCII2Unicode(rs.getString("pgroup")) + " " + cvth.ASCII2Unicode(rs.getString("groupname"));
                    String pgroup = cvth.ASCII2Unicode(rs.getString("pgroup"));
                    String pcode = cvth.ASCII2Unicode(rs.getString("pcode"));
                    String pname = cvth.ASCII2Unicode(rs.getString("pdesc"));
                    String pactive = cvth.ASCII2Unicode(rs.getString("pactive"));
                    String pbgroup = cvth.ASCII2Unicode(rs.getString("bgroup"));
                    String sapcode = cvth.ASCII2Unicode(rs.getString("sap_article"));
                    String sapname = cvth.ASCII2Unicode(rs.getString("sap_article_name"));

                    if (pgroup == null) {
                        pgroup = " ";
                    }
                    if (pcode == null) {
                        pcode = " ";
                    }
                    if (sapcode == null) {
                        sapcode = " ";
                    }
                    subtree.getChildren().add(new report_sapproductbean(pgroup, pcode, pname, pactive, sapcode, sapname, pbgroup));
                }
                countBranch++;
                counttotal++;
                temppgroupold = cvth.ASCII2Unicode(rs.getString("pgroup"));
                temppgroupnameold = cvth.ASCII2Unicode(rs.getString("groupname"));
            }
            if (subtree != null) {
                subtree.getChildren().add(new report_sapproductbean("รวมของกลุ่ม " + temppgroupold + " จำนวน " + countBranch + " รายการ", "", "", " ", " ", "", ""));
                subtree.setPgroup(temppgroup + "-" + temppgroupname);
                myroot.getChildren().add(subtree);
            }
            myroot.getChildren().add(new report_sapproductbean("ยอดรวมรายการสินค้าทั้งสิ้น " + counttotal + " รายการ",
                    "", " ", " ", " ", "", ""
            ));
        } else {
            while (rs.next()) {
                temppgroup = rs.getString("pgroup");
                temppgroupname = rs.getString("groupname");

                if (!temppgroupold.equals(temppgroup)) {
                    if (subtree != null) {
                        subtree.getChildren().add(new report_sapproductbean(temppgroupold,
                                "", "", " ", " ", " ", ""
                        ));
                        myroot.getChildren().add(subtree);
                        subtree.setPgroup(temppgroupold + "-" + temppgroupnameold);
                        countBranch = 0;
                    }
                    subtree = new report_sapproductbean();
                    i = 1;

                    String pgroup = rs.getString("pgroup") + " " + rs.getString("groupname");
                    String pcode = rs.getString("pcode");
                    String pname = rs.getString("pdesc");
                    String pactive = rs.getString("pactive");
                    String pbgroup = rs.getString("bgroup");
                    String sapcode = rs.getString("sap_article");
                    String sapname = rs.getString("sap_article_name");
                    if (pgroup == null) {
                        pgroup = " ";
                    }
                    if (pcode == null) {
                        pcode = " ";
                    }
                    if (sapcode == null) {
                        sapcode = " ";
                    }
                    subtree.getChildren().add(new report_sapproductbean(pgroup, pcode, pname, pactive, sapcode, sapname, pbgroup));

                } else {
//                    String btype = rs.getString("btype") + " " + rs.getString("btname");
                    String pgroup = rs.getString("pgroup") + " " + rs.getString("groupname");
                    String pcode = rs.getString("pcode");
                    String pname = rs.getString("pdesc");
                    String pactive = rs.getString("pactive");
                    String pbgroup = rs.getString("bgroup");
                    String sapcode = rs.getString("sap_article");
                    String sapname = rs.getString("sap_article_name");
                    if (pgroup == null) {
                        pgroup = " ";
                    }
                    if (pcode == null) {
                        pcode = " ";
                    }
                    if (sapcode == null) {
                        sapcode = " ";
                    }
                    subtree.getChildren().add(new report_sapproductbean(pgroup, pcode, pname, pactive, sapcode, sapname, pbgroup));
                }
                countBranch++;
                counttotal++;
                temppgroupold = rs.getString("pgroup");
                temppgroupnameold = rs.getString("groupname");
            }
            if (subtree != null) {
                subtree.getChildren().add(new report_sapproductbean("รวมของกลุ่ม " + temppgroupold + " จำนวน " + countBranch + " รายการ",
                        "", "", " ", " ", "", ""));
                subtree.setPgroup(temppgroup + "-" + temppgroupname);
                myroot.getChildren().add(subtree);
            }
            myroot.getChildren().add(new report_sapproductbean("ยอดรวมรายการสินค้าทั้งสิ้น " + counttotal + " รายการ",
                    "", " ", " ", " ", " ", ""
            ));
        }
        myroot.setPgroup("Report List ");
    }

    @Override
    public int getColumnCount() {
        return 7;
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
        report_sapproductbean treenode = (report_sapproductbean) node;
        switch (column) {
            case 0:
                return treenode.getPgroup();
            case 1:
                return treenode.getPcode();
            case 2:
                return treenode.getPname();
            case 3:
                return treenode.getPactive();
            case 4:
                return treenode.getSapcode();
            case 5:
                return treenode.getSapname();
            case 6:
                return treenode.getPbgroup();
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int column) {
        report_sapproductbean treenode = (report_sapproductbean) node;
        return treenode.getChildren().get(column);
    }

    @Override
    public int getChildCount(Object parent) {
        report_sapproductbean treenode = (report_sapproductbean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        report_sapproductbean treenode = (report_sapproductbean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        report_sapproductbean treenode = (report_sapproductbean) node;
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
