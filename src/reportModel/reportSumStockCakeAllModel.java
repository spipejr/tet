/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModel;

import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class reportSumStockCakeAllModel extends AbstractTreeTableModel {

    private Statement stmt;
    private reportSumStockCakeAllBean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public reportSumStockCakeAllModel(String sql) throws SQLException {
        db.dbconnect();
        stmt = null;
        String tempbran = "";
        String tempbranold = "";
        String tempdate = "";
        String tempdateold = "";
        String tempbname = "";
        String tempbnameold = "";
        Date d_tempdate = null;
        Date d_tempdateold = null;

        int countgroup = 0;
        int counttotal = 0;
        int countdate = 0;
        int i = 1;
        ResultSet rs = null;
        stmt = (Statement) dbUtility.con.createStatement();

        rs = stmt.executeQuery(sql);
        reportStockCakeBean subtree = null;
        reportStockCakeBean datetree = null;
        myroot = new reportSumStockCakeAllBean();
        if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
            while (rs.next()) {

                countgroup = 0;

                myroot.getChildren().add(new reportSumStockCakeAllBean(
                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                        cvth.ASCII2Unicode(rs.getString("pcode")),
                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                        cvth.ASCII2Unicode(rs.getString("punit1")),
                        Format.double3Fmt.format(rs.getDouble("rec")),
                        Format.double3Fmt.format(rs.getDouble("tfr")),
                        Format.double3Fmt.format(rs.getDouble("wid")),
                        Format.double3Fmt.format(rs.getDouble("ret")),
                        Format.double3Fmt.format(rs.getDouble("rfn")),
                        Format.double3Fmt.format(rs.getDouble("sal")),
                        Format.double3Fmt.format(rs.getDouble("adj"))
                ));

                i++;
                countgroup++;
                counttotal++;
                countdate++;

            }
//            Format.doubleFmt.format(totalgroup)

            myroot.setDept("Report List Of " + counttotal + " Record");
        } else {
            while (rs.next()) {

                countgroup = 0;

                myroot.getChildren().add(new reportSumStockCakeAllBean(
                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                        cvth.ASCII2Unicode(rs.getString("pcode")),
                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                        cvth.ASCII2Unicode(rs.getString("punit1")),
                        Format.double3Fmt.format(rs.getDouble("rec")),
                        Format.double3Fmt.format(rs.getDouble("tfr")),
                        Format.double3Fmt.format(rs.getDouble("wid")),
                        Format.double3Fmt.format(rs.getDouble("ret")),
                        Format.double3Fmt.format(rs.getDouble("rfn")),
                        Format.double3Fmt.format(rs.getDouble("sal")),
                        Format.double3Fmt.format(rs.getDouble("adj"))
                ));

                i++;
                countgroup++;
                counttotal++;
                countdate++;

            }

            myroot.setDept("Report List Of " + counttotal + " Record");
        }
    }

    @Override
    public int getColumnCount() {
        return 30;
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
        //System.out.println( "getValueAt: " + node + ", " + column );
        reportSumStockCakeAllBean treenode = (reportSumStockCakeAllBean) node;
        switch (column) {
            case 0:
                return treenode.getDept();
            case 1:
                return treenode.getPcode();
            case 2:
                return treenode.getPname();
            case 3:
                return treenode.getPrice();
            case 4:
                return treenode.getUnit();
            case 5:
                return treenode.getRec();
            case 6:
                return treenode.getTfr();
            case 7:
                return treenode.getWid();
            case 8:
                return treenode.getRet();
            case 9:
                return treenode.getRfn();
            case 10:
                return treenode.getSal();
            case 11:
                return treenode.getAdj();
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        reportSumStockCakeAllBean treenode = (reportSumStockCakeAllBean) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        reportSumStockCakeAllBean treenode = (reportSumStockCakeAllBean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        reportSumStockCakeAllBean treenode = (reportSumStockCakeAllBean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportSumStockCakeAllBean treenode = (reportSumStockCakeAllBean) node;
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
