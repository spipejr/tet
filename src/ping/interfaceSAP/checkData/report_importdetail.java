/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.checkData;

import EStamp.showMessage;
import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author pos
 */
public class report_importdetail extends AbstractTreeTableModel {

    private Statement stmt;
    private report_importdetail_bean myroot;
    dbUtility db = new dbUtility();
    showMessage msn = new showMessage();
    ThaiUtilities cvth = new ThaiUtilities();

    public report_importdetail(String sql, String code) throws SQLException {
        db.dbconnect();
        stmt = null;

        ResultSet rs = null;
        stmt = (Statement) dbUtility.con.createStatement();
        rs = stmt.executeQuery(sql);
        report_importdetail_bean subtree = null;
        myroot = new report_importdetail_bean();

        String tempBranch = "", tempBranchName = "";
        String tempBranchOld = "", tempBranchOldName = "";

        int countbranch = 0;
        int counttotal = 0;
        int i = 1;

        if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
            while (rs.next()) {
                tempBranch = cvth.ASCII2Unicode(rs.getString("branchcode"));
                tempBranchName = cvth.ASCII2Unicode(rs.getString("name"));
                if (!tempBranchOld.equals(tempBranch)) {
                    if (subtree != null) {
                        subtree.getChildren().add(new report_importdetail_bean("รวมของสาขา " + tempBranchOld + "   จำนวน " + countbranch + " รายการ", ""));
                        myroot.getChildren().add(subtree);
                        subtree.setPcode(tempBranchOld + "-" + tempBranchOldName);
                    }
                    subtree = new report_importdetail_bean();
                    countbranch = 0;
                    i = 1;

                    String pcode = cvth.ASCII2Unicode(rs.getString("plu"));
                    String pdesc = cvth.ASCII2Unicode(rs.getString("pdesc"));

                    if (pcode == null) {
                        pcode = " ";
                    }

                    if (pdesc == null) {
                        pdesc = " ";
                    }
                    subtree.getChildren().add(new report_importdetail_bean(pcode, pdesc));
                } else {

                    String pcode = cvth.ASCII2Unicode(rs.getString("plu"));
                    String pdesc = cvth.ASCII2Unicode(rs.getString("pdesc"));

                    if (pcode == null) {
                        pcode = " ";
                    }

                    if (pdesc == null) {
                        pdesc = " ";
                    }

                    subtree.getChildren().add(new report_importdetail_bean(pcode, pdesc));
                }
                countbranch++;
                counttotal++;
                tempBranchOld = cvth.ASCII2Unicode(rs.getString("branchcode"));
                tempBranchOldName = cvth.ASCII2Unicode(rs.getString("name"));
            }
            if (subtree != null) {
                subtree.getChildren().add(new report_importdetail_bean("รวมของสาขา " + tempBranchOld + "   จำนวน " + countbranch + " รายการ", ""));
                subtree.setPcode(tempBranch + "-" + tempBranchName);
                myroot.getChildren().add(subtree);
            }
            myroot.getChildren().add(new report_importdetail_bean("ยอดรวมทั้งสิ้น   จำนวน " + counttotal + " รายการ", ""));
        } else {
            //UTF-8
        }
        myroot.setPcode("Report List ");
    }

    public int getColumnCount() {
        return 2;
    }

    public String getColumnName(int column) {
        switch (column) {
            default:
                return "Unknown";
        }
    }

    public Object getValueAt(Object node, int column) {
        report_importdetail_bean treenode = (report_importdetail_bean) node;
        switch (column) {
            case 0:
                return treenode.getPcode();
            case 1:
                return treenode.getPdesc();

            default:
                return "Unknown";
        }
    }

    public Object getChild(Object node, int column
    ) {
        report_importdetail_bean treenode = (report_importdetail_bean) node;
        return treenode.getChildren().get(column);
    }

    public int getChildCount(Object parent) {
        report_importdetail_bean treenode = (report_importdetail_bean) parent;
        return treenode.getChildren().size();
    }

    public int getIndexOfChild(Object parent, Object child) {
        report_importdetail_bean treenode = (report_importdetail_bean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        report_importdetail_bean treenode = (report_importdetail_bean) node;
        if (treenode.getChildren().size() > 0) {
            return false;
        }
        return true;
    }

    public Object getRoot() {
        return myroot;
    }
}
