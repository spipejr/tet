/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;

import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author natee
 */
public class reportPOSBOM_model extends AbstractTreeTableModel {

    formatDateNumber f = new formatDateNumber();
    private Statement stmt;
    private reportPOSBOM_bean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public reportPOSBOM_model(String sql) {
        try {
            db.dbconnect();
            stmt = null;
            String tempbran = " ";
            String tempbranold = " ";
            String tempbname = "";
            String tempbnameold = "";

            String tempformula = "";
            String tempformulaold = "";

            String root = "";

            int countgroup = 0;
            int counttotal = 0;
            int i = 1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            rs = stmt.executeQuery(sql);
            reportPOSBOM_bean subtree = null;
            myroot = new reportPOSBOM_bean();
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                while (rs.next()) {

                    tempbran = cvth.ASCII2Unicode(rs.getString("pcode"));
                    tempformula = cvth.ASCII2Unicode(rs.getString("pcode"));
//                    tempformula = cvth.ASCII2Unicode(rs.getString("formula"));

                    if (!tempbranold.equals(tempbran)) {

                        if (subtree != null) {
                            myroot.getChildren().add(subtree);
                            root = "PLU" + " " + tempbranold + " " + tempbnameold + " Total Ingredent " + countgroup + " Item(s)";
                            subtree.setPcode(root);

                        }

//                        if (!tempformulaold.equals(tempformula)) {
//                            root = "สูตรที่  " + cvth.ASCII2Unicode(rs.getString("formula"));
//                        } else {
//                            root = "";
//                        }
                        subtree = new reportPOSBOM_bean();
                        i = 1;

                        if (i == 1) {
//                             root = "สูตรที่  " + cvth.ASCII2Unicode(rs.getString("formula"));
                            root = cvth.ASCII2Unicode(rs.getString("pcode"));
                        }

                        countgroup = 0;
                        subtree.getChildren().add(new reportPOSBOM_bean(
                                root,
                                cvth.ASCII2Unicode(rs.getString("plcode")),
                                cvth.ASCII2Unicode(rs.getString("plname")),
                                cvth.ASCII2Unicode(rs.getString("pactive")),
                                f.double3Fmt(rs.getDouble("qty")),
                                cvth.ASCII2Unicode(rs.getString("subunit")),
                                cvth.ASCII2Unicode(rs.getString("saletype")),
                                cvth.ASCII2Unicode(rs.getString("formula"))));

                    } else {
                        if (!tempformulaold.equals(tempformula)) {
//                            root = "สูตรที่  " + tempformula;
                            root = cvth.ASCII2Unicode(rs.getString("pcode"));
                        } else {
                            root = tempformulaold;
                        }
                        subtree.getChildren().add(new reportPOSBOM_bean(
                                root,
                                cvth.ASCII2Unicode(rs.getString("plcode")),
                                cvth.ASCII2Unicode(rs.getString("plname")),
                                cvth.ASCII2Unicode(rs.getString("pactive")),
                                f.double3Fmt(rs.getDouble("qty")),
                                cvth.ASCII2Unicode(rs.getString("subunit")),
                                cvth.ASCII2Unicode(rs.getString("saletype")),
                                cvth.ASCII2Unicode(rs.getString("formula"))));
                    }

                    i++;
                    counttotal++;
                    countgroup++;
                    tempbranold = cvth.ASCII2Unicode(rs.getString("pcode"));
                    tempbnameold = cvth.ASCII2Unicode(rs.getString("pdesc"));
//                    tempformulaold = cvth.ASCII2Unicode(rs.getString("formula"));
                    tempformulaold = cvth.ASCII2Unicode(rs.getString("pcode"));
                }

                if (subtree != null) {
                    subtree.setPcode("PLU" + " " + tempbranold + " " + tempbnameold + " Total Ingredent " + countgroup + " Item(s)");
                    myroot.getChildren().add(subtree);
                }
                myroot.setPcode("Report List Of " + counttotal + " Record");
            } else {
                while (rs.next()) {

                    tempbran = (rs.getString("pcode"));
                    tempformula = (rs.getString("formula"));

                    if (!tempbranold.equals(tempbran)) {

                        if (subtree != null) {
                            myroot.getChildren().add(subtree);
                            root = "PLU" + " " + tempbranold + " " + tempbnameold + " Total Ingredent " + countgroup + " Item(s)";
                            subtree.setPcode(root);

                        }

//                        if (!tempformulaold.equals(tempformula)) {
//                            root = "สูตรที่  " + (rs.getString("formula"));
//                        } else {
//                            root = "";
//                        }
                        subtree = new reportPOSBOM_bean();
                        i = 1;

                        if (i == 1) {
//                            root = "สูตรที่  " + (rs.getString("formula"));
                            root = (rs.getString("pcode"));
                        }

                        countgroup = 0;
                        subtree.getChildren().add(new reportPOSBOM_bean(
                                root,
                                (rs.getString("plcode")),
                                (rs.getString("plname")),
                                (rs.getString("pactive")),
                                f.double3Fmt(rs.getDouble("qty")),
                                (rs.getString("subunit")),
                                (rs.getString("saletype")),
                                (rs.getString("formula"))));

                    } else {
                        if (!tempformulaold.equals(tempformula)) {
                            root = tempformula;
                        } else {
                            root = tempformulaold;
                        }
                        subtree.getChildren().add(new reportPOSBOM_bean(
                                root,
                                (rs.getString("plcode")),
                                (rs.getString("plname")),
                                (rs.getString("pactive")),
                                f.double3Fmt(rs.getDouble("qty")),
                                (rs.getString("subunit")),
                                (rs.getString("saletype")),
                                (rs.getString("formula"))));
                    }

                    i++;
                    counttotal++;
                    countgroup++;
                    tempbranold = (rs.getString("pcode"));
                    tempbnameold = (rs.getString("pdesc"));
//                    tempformulaold = (rs.getString("formula"));
                    tempformulaold = (rs.getString("pcode"));
                }

                if (subtree != null) {
                    subtree.setPcode("PLU" + " " + tempbranold + " " + tempbnameold + " Total Ingredent " + countgroup + " Item(s)");
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
        return 8;
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
        reportPOSBOM_bean treenode = (reportPOSBOM_bean) node;
        switch (column) {
            case 0:
                return treenode.getPcode();
            case 1:
                return treenode.getPlcode();
            case 2:
                return treenode.getPlname();
            case 3:
                return treenode.getPactive();
            case 4:
                return treenode.getPqty();
            case 5:
                return treenode.getPsubunit();
            case 6:
                return treenode.getSaletype();
            case 7:
                return treenode.getFormula();

            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        reportPOSBOM_bean treenode = (reportPOSBOM_bean) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        reportPOSBOM_bean treenode = (reportPOSBOM_bean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        reportPOSBOM_bean treenode = (reportPOSBOM_bean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportPOSBOM_bean treenode = (reportPOSBOM_bean) node;
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
