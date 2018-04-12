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
public class reportSumStockCakeModel extends AbstractTreeTableModel {

    private Statement stmt;
    private reportSumStockCakeBean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public reportSumStockCakeModel(String sql) throws SQLException {
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
        double totalgroup1 = 0;
        double totalgroup2 = 0;
        double total1 = 0;
        double total2 = 0;
        double totaldept1 = 0;
        double totaldept2 = 0;
        String tempgroup = "";
        String tempdept = "";

        int i = 1;
        ResultSet rs = null;
        stmt = (Statement) dbUtility.con.createStatement();

        rs = stmt.executeQuery(sql);
        reportSumStockCakeBean subtree = null;
        myroot = new reportSumStockCakeBean();
        if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
            while (rs.next()) {
                countgroup = 0;
                if ((!tempgroup.equals("")) && (!tempgroup.equals(rs.getString("s_bran")))) {
                    if (subtree != null) {
                        subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                        ));

                        subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Branch..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                        ));
                        myroot.getChildren().add(subtree);
                    } else {
                        myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                        ));
                        myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Branch..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                        ));
                    }
                    tempdept = "";
                    tempgroup = rs.getString("s_bran");
                    totalgroup1 = 0;
                    totalgroup2 = 0;
                    totaldept1 = 0;
                    totaldept2 = 0;

                }
                if ((!tempdept.equals("")) && (!tempdept.equals(rs.getString("pgroup")))) {
                    if (subtree != null) {
                        subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                        ));
                        myroot.getChildren().add(subtree);
                    } else {
                        myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                        ));
                    }
                    tempdept = rs.getString("pgroup");
                    totaldept1 = 0;
                    totaldept2 = 0;

                }
                tempgroup = rs.getString("s_bran");
                tempdept = rs.getString("pgroup");
                double madj = rs.getDouble("adjeod") * rs.getDouble("adj");
                double mbalance = rs.getDouble("adjeod") * rs.getDouble("eod");
                myroot.getChildren().add(new reportSumStockCakeBean(cvth.ASCII2Unicode(rs.getString("s_bran")),
                        cvth.ASCII2Unicode(rs.getString("name")),
                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                        cvth.ASCII2Unicode(rs.getString("pcode")),
                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                        cvth.ASCII2Unicode(rs.getString("punit1")),
                        Format.double3Fmt.format(rs.getDouble("bod")),
                        Format.double3Fmt.format(rs.getDouble("rec")),
                        Format.double3Fmt.format(rs.getDouble("tfr")),
                        Format.double3Fmt.format(rs.getDouble("wid")),
                        Format.double3Fmt.format(rs.getDouble("ret")),
                        Format.double3Fmt.format(rs.getDouble("rfn")),
                        Format.double3Fmt.format(rs.getDouble("sal")),
                        Format.double3Fmt.format(rs.getDouble("adj")),
                        Format.double3Fmt.format(rs.getDouble("eod")),
                        Format.double3Fmt.format(madj),
                        Format.double3Fmt.format(mbalance)
                ));
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                totalgroup1 = totalgroup1 + madj;
                totalgroup2 = totalgroup2 + mbalance;
                totaldept1 = totaldept1 + madj;
                totaldept2 = totaldept2 + mbalance;
                total1 = total1 + madj;
                total2 = total2 + mbalance;
            }
             if (subtree != null) {
                subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                ));

                subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Branch..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                ));
                subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Grand Total..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(total1), Format.doubleFmt.format(total2)
                ));
                myroot.getChildren().add(subtree);

            } else {
                myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                ));
                myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Branch..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                ));
                myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Grand Total..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(total1), Format.doubleFmt.format(total2)
                ));
            }
            myroot.setS_bran("Report List Of " + counttotal + " Record");
        } else {
            while (rs.next()) {
                countgroup = 0;
                if ((!tempgroup.equals("")) && (!tempgroup.equals(rs.getString("s_bran")))) {
                    if (subtree != null) {
                        subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                        ));

                        subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Branch..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                        ));
                        myroot.getChildren().add(subtree);
                    } else {
                        myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                        ));
                        myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Branch..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                        ));
                    }
                    tempdept = "";
                    tempgroup = rs.getString("s_bran");
                    totalgroup1 = 0;
                    totalgroup2 = 0;
                    totaldept1 = 0;
                    totaldept2 = 0;

                }
                if ((!tempdept.equals("")) && (!tempdept.equals(rs.getString("pgroup")))) {
                    if (subtree != null) {
                        subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                        ));
                        myroot.getChildren().add(subtree);
                    } else {
                        myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                        ));
                    }
                    tempdept = rs.getString("pgroup");
                    totaldept1 = 0;
                    totaldept2 = 0;

                }
                tempgroup = rs.getString("s_branch");
                tempdept = rs.getString("pgroup");

                double madj = rs.getDouble("adjeod") * rs.getDouble("adj");
                double mbalance = rs.getDouble("adjeod") * rs.getDouble("eod");
                myroot.getChildren().add(new reportSumStockCakeBean(rs.getString("s_bran"),
                        rs.getString("name"),
                        rs.getString("pgroup"),
                        rs.getString("pcode"),
                        rs.getString("pdesc"),
                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                        rs.getString("punit1"),
                        Format.double3Fmt.format(rs.getDouble("bod")),
                        Format.double3Fmt.format(rs.getDouble("rec")),
                        Format.double3Fmt.format(rs.getDouble("tfr")),
                        Format.double3Fmt.format(rs.getDouble("wid")),
                        Format.double3Fmt.format(rs.getDouble("ret")),
                        Format.double3Fmt.format(rs.getDouble("rfn")),
                        Format.double3Fmt.format(rs.getDouble("sal")),
                        Format.double3Fmt.format(rs.getDouble("adj")),
                        Format.double3Fmt.format(rs.getDouble("eod")),
                        Format.double3Fmt.format(madj),
                        Format.double3Fmt.format(mbalance)
                ));

                i++;
                countgroup++;
                counttotal++;
                countdate++;
                totalgroup1 = totalgroup1 + madj;
                totalgroup2 = totalgroup2 + mbalance;
                totaldept1 = totaldept1 + madj;
                totaldept2 = totaldept2 + mbalance;
                total1 = total1 + madj;
                total2 = total2 + mbalance;

            }
            if (subtree != null) {
                subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                ));

                subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Branch..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                ));
                myroot.getChildren().add(subtree);
                subtree.getChildren().add(new reportSumStockCakeBean(tempgroup, "Grand Total..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(total1), Format.doubleFmt.format(total2)
                ));
                myroot.getChildren().add(subtree);

            } else {
                myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Dept..... ", tempdept, "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totaldept1), Format.doubleFmt.format(totaldept2)
                ));
                myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Total Branch..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                ));
                 myroot.getChildren().add(new reportSumStockCakeBean(tempgroup, "Grand Total..... ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", Format.doubleFmt.format(total1), Format.doubleFmt.format(total2)
                ));
            }
            myroot.setS_bran("Report List Of " + counttotal + " Record");
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
        reportSumStockCakeBean treenode = (reportSumStockCakeBean) node;
        switch (column) {
            case 0:
                return treenode.getS_bran();
            case 1:
                return treenode.getS_name();
            case 2:
                return treenode.getDept();
            case 3:
                return treenode.getPcode();
            case 4:
                return treenode.getPname();
            case 5:
                return treenode.getPrice();
            case 6:
                return treenode.getUnit();
            case 7:
                return treenode.getBod();
            case 8:
                return treenode.getRec();
            case 9:
                return treenode.getTfr();
            case 10:
                return treenode.getWid();
            case 11:
                return treenode.getRet();
            case 12:
                return treenode.getRfn();
            case 13:
                return treenode.getSal();
            case 14:
                return treenode.getAdj();
            case 15:
                return treenode.getEod();
            case 16:
                return treenode.getPret();
            case 17:
                return treenode.getAmt();
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        reportSumStockCakeBean treenode = (reportSumStockCakeBean) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        reportSumStockCakeBean treenode = (reportSumStockCakeBean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        reportSumStockCakeBean treenode = (reportSumStockCakeBean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportSumStockCakeBean treenode = (reportSumStockCakeBean) node;
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
