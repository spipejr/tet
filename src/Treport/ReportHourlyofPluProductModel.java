/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treport;

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
 * @author pos
 */
public class ReportHourlyofPluProductModel extends AbstractTreeTableModel {
    private Statement stmt;
    private BeanReportHourlyofPluProduct myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();
    private String[] timeIn = new String[24];
    private int[] timeOut = new int[24];
    String times = "";
    
    public ReportHourlyofPluProductModel(String sql, String code, String name) throws SQLException {
        
            db.dbconnect();
            stmt = null;
            String tempproduct = " ";
            String tempproductold = " ";
            String tempdate = "";
            String tempdateold = "";
            String temppname = "";
            String tempbnameold = "";
            Date d_tempdate =null;
            Date d_tempdateold = null;
            double total1 = 0,total2 = 0;
            double totalgroup1 = 0,totalgroup2 = 0;
            
            
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            BeanReportHourlyofPluProduct subtree = null;
            myroot = new BeanReportHourlyofPluProduct( "รายงานททั้งหมด","","","","","","");
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                tempproduct = rs.getString("PCode");
                temppname = cvth.ASCII2Unicode(rs.getString("PDesc"));
                
                
                if(!tempproductold.equals(tempproduct))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new BeanReportHourlyofPluProduct("Total รหัสสินค้า "+tempproductold,"","","",Format.doubleFmt.format(totalgroup1),Format.doubleFmt.format(totalgroup2),""
                        ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;
                        subtree.setS_bran("รหัสสินค้า"+" "+tempproductold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new BeanReportHourlyofPluProduct();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new BeanReportHourlyofPluProduct(cvth.ASCII2Unicode(rs.getString(code)),
                            cvth.ASCII2Unicode(times),
                            cvth.ASCII2Unicode(rs.getString("PCode")),
                            cvth.ASCII2Unicode(rs.getString("PDesc")),
                            Format.doubleFmt.format(rs.getDouble("Qty")),
                            Format.doubleFmt.format(rs.getDouble("price")),
                            cvth.ASCII2Unicode(rs.getString("unit"))
                        ));
                    
                    
                }
                else
                {
                    
                        subtree.getChildren().add(new BeanReportHourlyofPluProduct(cvth.ASCII2Unicode(rs.getString(code)),
                            cvth.ASCII2Unicode(times),
                            cvth.ASCII2Unicode(rs.getString("PCode")),
                            cvth.ASCII2Unicode(rs.getString("PDesc")),
                            Format.doubleFmt.format(rs.getDouble("Qty")),
                            Format.doubleFmt.format(rs.getDouble("price")),
                            cvth.ASCII2Unicode(rs.getString("unit"))
                        ));
                    
                    
                    
                }
                
                totalgroup1 += rs.getDouble("Qty");
                totalgroup2 += rs.getDouble("price");


                total1 += rs.getDouble("Qty");
                total2 += rs.getDouble("price");
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempproductold = rs.getString("s_pcode");
                tempbnameold = cvth.ASCII2Unicode(rs.getString("pdesc"));
                
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
            subtree.getChildren().add(new BeanReportHourlyofPluProduct("Total รหัสสินค้า "+tempproduct,"","","",Format.doubleFmt.format(totalgroup1),Format.doubleFmt.format(totalgroup2),""
                    
                    ));
            subtree.setS_bran("รหัสสินค้า"+" "+tempproduct+" "+temppname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            myroot.getChildren().add(new BeanReportHourlyofPluProduct("Total All","","","",Format.doubleFmt.format(total1),Format.doubleFmt.format(total2),""
                    
                     ));
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
            else
            {
               while (rs.next()) {
                
                 tempproduct = rs.getString("PCode");
                temppname = cvth.ASCII2Unicode(rs.getString("PDesc"));
                
                
                if(!tempproductold.equals(tempproduct))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new BeanReportHourlyofPluProduct("Total รหัสสินค้า "+tempproductold,"","","",Format.doubleFmt.format(totalgroup1),Format.doubleFmt.format(totalgroup2),""
                        
                         ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;
                        subtree.setS_bran("รหัสสินค้า"+" "+tempproductold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new BeanReportHourlyofPluProduct();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new BeanReportHourlyofPluProduct(cvth.ASCII2Unicode(rs.getString(code)),
                           
                            
                            cvth.ASCII2Unicode(times),
                            cvth.ASCII2Unicode(rs.getString("PCode")),
                            cvth.ASCII2Unicode(rs.getString("PDesc")),
                            Format.doubleFmt.format(rs.getDouble("Qty")),
                            Format.doubleFmt.format(rs.getDouble("price")),
                            cvth.ASCII2Unicode(rs.getString("unit"))
                            ));
                        
                    
                    
                }
                else
                {
                    
                        subtree.getChildren().add(new BeanReportHourlyofPluProduct(cvth.ASCII2Unicode(rs.getString(code)),
                           
                            
                            cvth.ASCII2Unicode(times),
                            cvth.ASCII2Unicode(rs.getString("PCode")),
                            cvth.ASCII2Unicode(rs.getString("PDesc")),
                            Format.doubleFmt.format(rs.getDouble("Qty")),
                            Format.doubleFmt.format(rs.getDouble("price")),
                            cvth.ASCII2Unicode(rs.getString("unit"))
                            ));
                        
                    
                    
                    
                }
                
                totalgroup1 += rs.getDouble("Qty");
                totalgroup2 += rs.getDouble("price");


                total1 += rs.getDouble("Qty");
                total2 += rs.getDouble("price");
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempproductold = rs.getString("s_pcode");
                tempbnameold = rs.getString("pdesc");
                
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
            subtree.getChildren().add(new BeanReportHourlyofPluProduct("Total รหัสสินค้า "+tempproduct,"","","",Format.doubleFmt.format(totalgroup1),Format.doubleFmt.format(totalgroup2),""
                    
                    ));
            subtree.setS_bran("รหัสสินค้า"+" "+tempproduct+" "+temppname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            myroot.getChildren().add(new BeanReportHourlyofPluProduct("Total All","","","",Format.doubleFmt.format(total1)
                    ,Format.doubleFmt.format(total2),""
                     ));
            myroot.setS_bran("Report List Of "+counttotal+" Record");
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
        BeanReportHourly treenode = (BeanReportHourly) node;
        switch (column) {
            case 0:
                return treenode.getS_bran();
            case 1:
                return treenode.getHour();
            case 2:
                return treenode.getPcode();
            case 3:
                return treenode.getPdesc();
            case 4:
                return treenode.getQty();
            case 5:
                return treenode.getPrice();
            case 6:
                return treenode.getPUnit();
            
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        BeanReportHourly treenode = (BeanReportHourly) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        BeanReportHourly treenode = (BeanReportHourly) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        BeanReportHourly treenode = (BeanReportHourly) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        BeanReportHourly treenode = (BeanReportHourly) node;
        if (treenode.getChildren().size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    public Object getRoot() {
        return myroot;
    }
    private void setTime() {
           timeIn[0] = "00:00 - 00:59";
           timeIn[1] = "01:00 - 01:59";
           timeIn[2] = "02:00 - 02:59";
           timeIn[3] = "03:00 - 03:59";
           timeIn[4] = "04:00 - 04:59";
           timeIn[5] = "05:00 - 05:59";
           timeIn[6] = "06:00 - 06:59";
           timeIn[7] = "07:00 - 07:59";
           timeIn[8] = "08:00 - 08:59";
           timeIn[9] = "09:00 - 09:59";
           timeIn[10] = "10:00 - 10:59";
           timeIn[11] = "11:00 - 11:59";
           timeIn[12] = "12:00 - 12:59";
           timeIn[13] = "13:00 - 13:59";
           timeIn[14] = "14:00 - 14:59";
           timeIn[15] = "15:00 - 15:59";
           timeIn[16] = "16:00 - 16:59";
           timeIn[17] = "17:00 - 17:59";
           timeIn[18] = "18:00 - 18:59";
           timeIn[19] = "19:00 - 19:59";
           timeIn[20] = "20:00 - 20:59";
           timeIn[21] = "21:00 - 21:59";
           timeIn[22] = "22:00 - 22:59";
           timeIn[23] = "23:00 - 23:59";
    }
}
