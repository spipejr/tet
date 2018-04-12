/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModel;

import borfunction.calculateLCostPLU;
import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.Format;
import utilititiesfunction.PUtility;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class reportLostDeptModel extends AbstractTreeTableModel {

    private Statement stmt;
    private reportLostDeptBean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public reportLostDeptModel(String sql, String code, String name) throws SQLException {
        db.dbconnect();
        stmt = null;
        String tempbran = " ";
        String tempbranold = " ";
        String tempdate = "";
        String tempdateold = "";
        String tempbname = "";
        String tempbnameold = "";
        Date d_tempdate = null;
        Date d_tempdateold = null;
        double total1 = 0, total2 = 0, total3 = 0;
        double totalgroup1 = 0, totalgroup2 = 0, totalgroup3 = 0;

        int countgroup = 0;
        int counttotal = 0;
        int countdate = 0;
        int i = 1;
        ResultSet rs = null;
        stmt = (Statement) dbUtility.con.createStatement();

        rs = stmt.executeQuery(sql);
        reportLostDeptBean subtree = null;
        myroot = new reportLostDeptBean("รายงานทั้งหมด", "", "", "", "", "");
        if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
            while (rs.next()) {
                tempbran = rs.getString("gcode");
                tempbname = rs.getString("gname");

                double per = 0.00;
                if (rs.getDouble("eatamt") > 0 && rs.getDouble("eatqty") != 0) {
                    per = (rs.getDouble("eatamt") / rs.getDouble("eatqty")) * 100;
                } else {
                    per = 0;
                }

                if (!tempbranold.equals(tempbran)) {
                    tempdateold = " ";
                    if (subtree != null) {
                        double per2 = 0.00;
                        if (totalgroup2 > 0 && totalgroup1 != 0) {
                            per2 = (totalgroup2 / totalgroup1) * 100;
                        } else {
                            per2 = 0;
                        }
                        subtree.getChildren().add(new reportLostDeptBean(tempbranold, "Total " + code + " ", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2), Format.doubleFmt.format(per2)+"%"
                        ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;
                        totalgroup2 = 0;
                        totalgroup3 = 0;
                        subtree.setS_bran(code + " " + tempbranold + " " + tempbnameold + " Total " + countgroup + " Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }

                    subtree = new reportLostDeptBean();
                    countgroup = 0;
                    i = 1;

                    subtree.getChildren().add(new reportLostDeptBean(cvth.ASCII2Unicode(rs.getString("gcode")),
                            cvth.ASCII2Unicode(rs.getString("deptcode")),
                            cvth.ASCII2Unicode(rs.getString("deptname")),
                            Format.doubleFmt.format(rs.getDouble("eatqty")),
                            Format.doubleFmt.format(rs.getDouble("eatamt")),
                            Format.doubleFmt.format(per) + "%"
                    ));

                } else {

                    subtree.getChildren().add(new reportLostDeptBean(cvth.ASCII2Unicode(rs.getString("gcode")),
                            cvth.ASCII2Unicode(rs.getString("deptcode")),
                            cvth.ASCII2Unicode(rs.getString("deptname")),
                            Format.doubleFmt.format(rs.getDouble("eatqty")),
                            Format.doubleFmt.format(rs.getDouble("eatamt")),
                            Format.doubleFmt.format(per) + "%"
                    ));

                }

                totalgroup1 += rs.getDouble("eatqty");
                totalgroup2 += rs.getDouble("eatamt");

                total1 += rs.getDouble("eatqty");
                total2 += rs.getDouble("eatamt");

//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("gcode");
                tempbnameold = rs.getString("gname");

            }
//            Format.doubleFmt.format(totalgroup)

            if (subtree != null) {
                double per2 = 0.00;
                if (totalgroup2 > 0 && totalgroup1 != 0) {
                    per2 = (totalgroup2 / totalgroup1) * 100;
                } else {
                    per2 = 0;
                }
                subtree.getChildren().add(new reportLostDeptBean(tempbran, "Total " + code + " ", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2), Format.doubleFmt.format(per2)+"%"
                ));
                //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));

                subtree.setS_bran(code + " " + tempbran + " " + tempbname + " Total " + countgroup + " Record");
                myroot.getChildren().add(subtree);
            }
            double per2 = 0.00;
            if (total2 > 0 && total1 != 0) {
                per2 = (total2 / total1) * 100;
            } else {
                per2 = 0;
            }

            myroot.getChildren().add(new reportLostDeptBean("Total All", "", "", Format.doubleFmt.format(total1), Format.doubleFmt.format(total2), Format.doubleFmt.format(per2)+"%"
            ));
            myroot.setS_bran("Report List Of " + counttotal + " Record");
        } else {
            while (rs.next()) {

                tempbran = rs.getString("gcode");
                tempbname = rs.getString("gname");

                double per = 0.00;
                if (rs.getDouble("eatamt") > 0 && rs.getDouble("eatqty") != 0) {
                    per = (rs.getDouble("eatamt") / rs.getDouble("eatqty")) * 100;
                } else {
                    per = 0;
                }

                if (!tempbranold.equals(tempbran)) {
                    tempdateold = " ";
                    if (subtree != null) {
                        double per2 = 0.00;
                        if (totalgroup2 > 0 && totalgroup1 != 0) {
                            per2 = (totalgroup2 / totalgroup1) * 100;
                        } else {
                            per2 = 0;
                        }

                        // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new reportLostDeptBean(tempbranold, "Total " + code + " ", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2), Format.doubleFmt.format(per2)+"%"
                        ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;
                        totalgroup2 = 0;
                        totalgroup3 = 0;
                        subtree.setS_bran(code + " " + tempbranold + " " + tempbnameold + " Total " + countgroup + " Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }

                    subtree = new reportLostDeptBean();
                    countgroup = 0;
                    i = 1;

                    subtree.getChildren().add(new reportLostDeptBean(rs.getString("gcode"),
                            rs.getString("deptcode"),
                            rs.getString("deptname"),
                            Format.doubleFmt.format(rs.getDouble("eatqty")),
                            Format.doubleFmt.format(rs.getDouble("eatamt")),
                            Format.doubleFmt.format(per) + "%"
                    ));

                } else {

                    subtree.getChildren().add(new reportLostDeptBean(rs.getString("gcode"),
                            rs.getString("deptcode"),
                            rs.getString("deptname"),
                            Format.doubleFmt.format(rs.getDouble("eatqty")),
                            Format.doubleFmt.format(rs.getDouble("eatamt")),
                            Format.doubleFmt.format(per) + "%"
                    ));

                }

                totalgroup1 += rs.getDouble("eatqty");
                totalgroup2 += rs.getDouble("eatamt");

                total1 += rs.getDouble("eatqty");
                total2 += rs.getDouble("eatamt");

//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("gcode");
                tempbnameold = rs.getString("gname");

            }
//            Format.doubleFmt.format(totalgroup)

            if (subtree != null) {
                double per2 = 0.00;
                if (totalgroup2 > 0 && totalgroup1 != 0) {
                    per2 = (totalgroup2 / totalgroup1) * 100;
                } else {
                    per2 = 0;
                }
                subtree.getChildren().add(new reportLostDeptBean(tempbran, "Total " + code + " ", "", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2), Format.doubleFmt.format(per2)+"%"
                ));
                //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));

                subtree.setS_bran(code + " " + tempbran + " " + tempbname + " Total " + countgroup + " Record");
                myroot.getChildren().add(subtree);
            }
            double per2 = 0.00;
            if (total2 > 0 && total1 != 0) {
                per2 = (total2 / total1) * 100;
            } else {
                per2 = 0;
            }
            myroot.getChildren().add(new reportLostDeptBean("Total All", "", "", Format.doubleFmt.format(total1), Format.doubleFmt.format(total2), Format.doubleFmt.format(per2)+"%"
            ));
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
        reportLostDeptBean treenode = (reportLostDeptBean) node;
        switch (column) {
            case 0:
                return treenode.getS_bran();
            case 1:
                return treenode.getDept();
            case 2:
                return treenode.getDeptname();
            case 3:
                return treenode.getSale();
            case 4:
                return treenode.getLost();
            case 5:
                return treenode.getPer();

            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        reportLostDeptBean treenode = (reportLostDeptBean) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        reportLostDeptBean treenode = (reportLostDeptBean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        reportLostDeptBean treenode = (reportLostDeptBean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportLostDeptBean treenode = (reportLostDeptBean) node;
        if (treenode.getChildren().size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    public Object getRoot() {
        return myroot;
    }

    public String getGroupName(String code, String tcode) {
        String retval = "";
        if (code.equals("BranchCode")) {
            retval = PUtility.SeekBranchName(tcode);
        } else if (code.equals("BTypeCode")) {
            retval = PUtility.SeekBTypeName(tcode);
        } else if (code.equals("BAreaCode")) {
            retval = PUtility.SeekAreaName(tcode);
        } else if (code.equals("BSizeCode")) {
            retval = PUtility.SeekSizeName(tcode);
        } else if (code.equals("BPlaneCode")) {
            retval = PUtility.SeekPlaneName(tcode);
        } else if (code.equals("BStoreCode")) {
            retval = PUtility.SeekStoreName(tcode);
        } else if (code.equals("CompanyCode")) {
            retval = PUtility.SeekComName(tcode);
        } else if (code.equals("BrandCode")) {
            retval = PUtility.SeekBrandName(tcode);
        } else if (code.equals("BustypeCode")) {
            retval = PUtility.SeekBusTypeName(tcode);
        } else if (code.equals("PGroupCode")) {
            retval = PUtility.SeekGroupName(tcode);
        }
        return retval;
    }

}
