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
public class reportSumWasteOfPluModel extends AbstractTreeTableModel {

    private Statement stmt;
    private reportSumWastePluBean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public reportSumWasteOfPluModel(String sql, String code, String name) throws SQLException {
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
        reportSumWastePluBean subtree = null;
        myroot = new reportSumWastePluBean("รายงานททั้งหมด", "", "", "", "", "", "", "");
        if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
            while (rs.next()) {
                tempbran = rs.getString(code);
                tempbname = cvth.ASCII2Unicode(rs.getString(name));
                if (!tempbranold.equals(tempbran)) {
                    tempdateold = " ";
                    if (subtree != null) {
                        subtree.getChildren().add(new reportSumWastePluBean(tempbranold, "", "", "Total " + code + " " + tempbranold, " ", " ", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                        ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;
                        totalgroup2 = 0;
                        subtree.setS_bran(code + " " + tempbranold + " " + tempbnameold + " Total " + countgroup + " Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }

                    subtree = new reportSumWastePluBean();
                    countgroup = 0;
                    i = 1;

                    subtree.getChildren().add(new reportSumWastePluBean(cvth.ASCII2Unicode(rs.getString(code)),
                            cvth.ASCII2Unicode(rs.getString("pgroup")),
                            cvth.ASCII2Unicode(rs.getString("r_pcode")),
                            cvth.ASCII2Unicode(rs.getString("pdesc")),
                            Format.doubleFmt.format(rs.getDouble("r_cost")),
                            cvth.ASCII2Unicode(rs.getString("punit1")),
                            Format.integerFmt.format(rs.getInt("qty")),
                            Format.doubleFmt.format(rs.getDouble("amt"))
                    ));

                } else {

                    subtree.getChildren().add(new reportSumWastePluBean(cvth.ASCII2Unicode(rs.getString(code)),
                            cvth.ASCII2Unicode(rs.getString("pgroup")),
                            cvth.ASCII2Unicode(rs.getString("r_pcode")),
                            cvth.ASCII2Unicode(rs.getString("pdesc")),
                            Format.doubleFmt.format(rs.getDouble("r_cost")),
                            cvth.ASCII2Unicode(rs.getString("punit1")),
                            Format.integerFmt.format(rs.getInt("qty")),
                            Format.doubleFmt.format(rs.getDouble("amt"))
                    ));

                }

                totalgroup1 += rs.getDouble("qty");
                totalgroup2 += rs.getDouble("amt");
                total1 += rs.getDouble("qty");
                total2 += rs.getDouble("amt");
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString(code);
                tempbnameold = cvth.ASCII2Unicode(rs.getString(name));

            }
            if (subtree != null) {
                subtree.getChildren().add(new reportSumWastePluBean(tempbranold, "", "", "Total " + code + " " + tempbranold, " ", " ", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                ));
                subtree.setS_bran(code + " " + tempbran + " " + tempbname + " Total " + countgroup + " Record");
                myroot.getChildren().add(subtree);
            }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));

            myroot.getChildren().add(new reportSumWastePluBean("Total All", "", "", "", "", "", Format.doubleFmt.format(total1), Format.doubleFmt.format(total2)
            ));
            myroot.setS_bran("Report List Of " + counttotal + " Record");
        } else {
            while (rs.next()) {

                tempbran = rs.getString(code);
                tempbname = rs.getString(name);

                if (!tempbranold.equals(tempbran)) {
                    tempdateold = " ";
                    if (subtree != null) {
                        subtree.getChildren().add(new reportSumWastePluBean(tempbranold, "", "", "Total " + code + " " + tempbranold, " ", " ", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                        ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;
                        totalgroup2 = 0;
                        subtree.setS_bran(code + " " + tempbranold + " " + tempbnameold + " Total " + countgroup + " Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }

                    subtree = new reportSumWastePluBean();
                    countgroup = 0;
                    i = 1;

                    subtree.getChildren().add(new reportSumWastePluBean(rs.getString(code),
                            rs.getString("pgroup"),
                            rs.getString("r_pcode"),
                            rs.getString("pdesc"),
                            Format.doubleFmt.format(rs.getDouble("r_cost")),
                            rs.getString("punit1"),
                            Format.integerFmt.format(rs.getInt("qty")),
                            Format.doubleFmt.format(rs.getDouble("amt"))
                    ));

                } else {

                    subtree.getChildren().add(new reportSumWastePluBean(rs.getString(code),
                            rs.getString("pgroup"),
                            rs.getString("r_pcode"),
                            rs.getString("pdesc"),
                            Format.doubleFmt.format(rs.getDouble("r_cost")),
                            rs.getString("punit1"),
                            Format.integerFmt.format(rs.getInt("qty")),
                            Format.doubleFmt.format(rs.getDouble("amt"))
                    ));

                }

                totalgroup1 += rs.getDouble("qty");
                totalgroup2 += rs.getDouble("amt");
                total1 += rs.getDouble("qty");
                total2 += rs.getDouble("amt");
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString(code);
                tempbnameold = rs.getString(name);

            }
//            Format.doubleFmt.format(totalgroup)

            if (subtree != null) {
                subtree.getChildren().add(new reportSumWastePluBean(tempbranold, "", "", "Total " + code + " " + tempbranold, " ", " ", Format.doubleFmt.format(totalgroup1), Format.doubleFmt.format(totalgroup2)
                ));
                subtree.setS_bran(code + " " + tempbran + " " + tempbname + " Total " + countgroup + " Record");
                myroot.getChildren().add(subtree);
            }
            myroot.getChildren().add(new reportSumWastePluBean("Total All", "", "", "", "", "", Format.doubleFmt.format(total1), Format.doubleFmt.format(total2)
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
        reportSumWastePluBean treenode = (reportSumWastePluBean) node;
        switch (column) {
            case 0:
                return treenode.getS_bran();
            case 1:
                return treenode.getS_dept();
            case 2:
                return treenode.getS_pcode();
            case 3:
                return treenode.getPname();
            case 4:
                return treenode.getPprice();
            case 5:
                return treenode.getPunit();
            case 6:
                return treenode.getE_qty();
            case 7:
                return treenode.getE_amt();
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        reportSumWastePluBean treenode = (reportSumWastePluBean) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        reportSumWastePluBean treenode = (reportSumWastePluBean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        reportSumWastePluBean treenode = (reportSumWastePluBean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportSumWastePluBean treenode = (reportSumWastePluBean) node;
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
