/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom.s_bom;

import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import ingredent_bom.formatDateNumber;
import java.sql.ResultSet;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author natee
 */
public class reportSBom_model extends AbstractTreeTableModel {

    formatDateNumber f = new formatDateNumber();
    private Statement stmt;
    private reportSBom_bean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public reportSBom_model(String sql) {
        try {
            db.dbconnect();
            stmt = null;
            String tempdept = " ";
            String tempdeptold = " ";
            String tempbname = "";
            String tempbnameold = "";

            String tempformula = "";
            String tempformulaold = "";

            String root = "";
            String rootPcode = "";

            int countgroup = 0;
            int counttotal = 0;
            int i = 1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            rs = stmt.executeQuery(sql);
            reportSBom_bean subtree = null;
            myroot = new reportSBom_bean();
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                while (rs.next()) {

                    tempdept = cvth.ASCII2Unicode(rs.getString("s.pdept"));
                    tempformula = cvth.ASCII2Unicode(rs.getString("s.pcode"));

                    if (!tempdeptold.equals(tempdept)) {

                        if (subtree != null) {
                            myroot.getChildren().add(subtree);
                            root = "Dept " + tempdeptold + "  Total " + countgroup + " Item(s)";
                            subtree.setPcode(root);

                        }

                        subtree = new reportSBom_bean();
                        i = 1;

                        if (i == 1) {
                            root = "(" + cvth.ASCII2Unicode(rs.getString("s.pdept")) + ") " + cvth.ASCII2Unicode(rs.getString("deptname"));
                            rootPcode = "(" + cvth.ASCII2Unicode(rs.getString("s.pcode")) + ") " + cvth.ASCII2Unicode(rs.getString("pluname"));
                        } else {
                            rootPcode = "";
                        }

                        countgroup = 0;
                        subtree.getChildren().add(new reportSBom_bean(
                                cvth.ASCII2Unicode(f.convertDatesqlToShow(rs.getString("s.s_date"))),
                                cvth.ASCII2Unicode(rs.getString("s.s_bran")),
                                root,
                                cvth.ASCII2Unicode(rs.getString("bomacc")),
                                rootPcode,
                                f.double3Fmt(rs.getDouble("s.pqty")),
                                cvth.ASCII2Unicode(rs.getString("plbom")),
                                "(" + cvth.ASCII2Unicode(rs.getString("s.plcode")) + ") " + cvth.ASCII2Unicode(rs.getString("plname")),
                                f.double3Fmt(rs.getDouble("s.plqty")),
                                f.double3Fmt(rs.getDouble("cost2")), // cost2 is pscost, cost1 is pacost
                                f.doubleFmtShow((rs.getDouble("s.plqty") * rs.getDouble("cost2")))));


                    } else {
                        if (!tempformulaold.equals(tempformula)) {
                            root = "";
                            rootPcode = "(" + cvth.ASCII2Unicode(rs.getString("s.pcode")) + ") " + cvth.ASCII2Unicode(rs.getString("pluname"));
                        } else {
                            root = "";
                            rootPcode = "";
                        }

                        subtree.getChildren().add(new reportSBom_bean(
                                cvth.ASCII2Unicode(f.convertDatesqlToShow(rs.getString("s.s_date"))),
                                cvth.ASCII2Unicode(rs.getString("s.s_bran")),
                                root,
                                cvth.ASCII2Unicode(rs.getString("bomacc")),
                                rootPcode,
                                f.double3Fmt(rs.getDouble("s.pqty")),
                                cvth.ASCII2Unicode(rs.getString("plbom")),
                                "(" + cvth.ASCII2Unicode(rs.getString("s.plcode")) + ") " + cvth.ASCII2Unicode(rs.getString("plname")),
                                f.double3Fmt(rs.getDouble("s.plqty")),
                                f.double3Fmt(rs.getDouble("cost2")), // cost2 is pscost, cost1 is pacost
                                f.doubleFmtShow((rs.getDouble("s.plqty") * rs.getDouble("cost2")))));
                    }


                    i++;
                    counttotal++;
                    countgroup++;
                    tempdeptold = cvth.ASCII2Unicode(rs.getString("s.pdept"));
                    tempbnameold = cvth.ASCII2Unicode(rs.getString("s.plcode"));
                    tempformulaold = cvth.ASCII2Unicode(rs.getString("s.pcode"));
                }


                if (subtree != null) {
                    subtree.setPcode("Dept " + tempdeptold + "  Total " + countgroup + " Item(s)");
                    myroot.getChildren().add(subtree);
                }
                myroot.setPcode("Report List Of " + counttotal + " Record");
            } else {
                while (rs.next()) {

                    tempdept = rs.getString("s.pdept");
                    tempformula = rs.getString("s.pcode");

                    if (!tempdeptold.equals(tempdept)) {

                        if (subtree != null) {
                            myroot.getChildren().add(subtree);
                            root = "Dept " + tempdeptold + "  Total " + countgroup + " Item(s)";
                            subtree.setPcode(root);

                        }

                        subtree = new reportSBom_bean();
                        i = 1;

                        if (i == 1) {
                            root = "(" + rs.getString("s.pdept") + ") " + rs.getString("deptname");
                            rootPcode = "(" + rs.getString("s.pcode") + ") " + rs.getString("pluname");
                        } else {
                            rootPcode = "";
                        }

                        countgroup = 0;
                        subtree.getChildren().add(new reportSBom_bean(
                                f.convertDatesqlToShow(rs.getString("s.s_date")),
                                rs.getString("s.s_bran"),
                                root,
                                rs.getString("bomacc"),
                                rootPcode,
                                f.double3Fmt(rs.getDouble("s.pqty")),
                                rs.getString("plbom"),
                                "(" + rs.getString("s.plcode") + ") " + rs.getString("plname"),
                                f.double3Fmt(rs.getDouble("s.plqty")),
                                f.double3Fmt(rs.getDouble("cost2")), // cost2 is pscost, cost1 is pacost
                                f.doubleFmtShow((rs.getDouble("s.plqty") * rs.getDouble("cost2")))));


                    } else {
                        if (!tempformulaold.equals(tempformula)) {
                            root = "";
                            rootPcode = "(" + rs.getString("s.pcode") + ") " + rs.getString("pluname");
                        } else {
                            root = "";
                            rootPcode = "";
                        }

                        subtree.getChildren().add(new reportSBom_bean(
                                f.convertDatesqlToShow(rs.getString("s.s_date")),
                                rs.getString("s.s_bran"),
                                root,
                                rs.getString("bomacc"),
                                rootPcode,
                                f.double3Fmt(rs.getDouble("s.pqty")),
                                rs.getString("plbom"),
                                "(" + rs.getString("s.plcode") + ") " + rs.getString("plname"),
                                f.double3Fmt(rs.getDouble("s.plqty")),
                                f.double3Fmt(rs.getDouble("cost2")), // cost2 is pscost, cost1 is pacost
                                f.doubleFmtShow((rs.getDouble("s.plqty") * rs.getDouble("cost2")))));
                    }


                    i++;
                    counttotal++;
                    countgroup++;
                    tempdeptold = rs.getString("s.pdept");
                    tempbnameold = rs.getString("s.plcode");
                    tempformulaold = rs.getString("s.pcode");
                }


                if (subtree != null) {
                    subtree.setPcode("Dept " + tempdeptold + "  Total " + countgroup + " Item(s)");
                    myroot.getChildren().add(subtree);
                }
                myroot.setPcode("Report List Of " + counttotal + " Record");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        //System.out.println( "getValueAt: " + node + ", " + column );
        reportSBom_bean treenode = (reportSBom_bean) node;
        switch (column) {
            case 0:
                return treenode.getDate();
            case 1:
                return treenode.getBranch();
            case 2:
                return treenode.getDept();
            case 3:
                return treenode.getBomacc();
            case 4:
                return treenode.getPcode();
            case 5:
                return treenode.getPqty();
            case 6:
                return treenode.getPlbomacc();
            case 7:
                return treenode.getPlcode();
            case 8:
                return treenode.getPlqty();
            case 9:
                return treenode.getPrice();
            case 10:
                return treenode.getAmount();

            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        reportSBom_bean treenode = (reportSBom_bean) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        reportSBom_bean treenode = (reportSBom_bean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        reportSBom_bean treenode = (reportSBom_bean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportSBom_bean treenode = (reportSBom_bean) node;
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
