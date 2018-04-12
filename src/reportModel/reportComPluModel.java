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
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class reportComPluModel extends AbstractTreeTableModel 
{
    
    private Statement stmt;
	private reportComPluBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportComPluModel(String sql,String code,String name) throws SQLException
    {
            db.dbconnect();
            stmt = null;
            String tempbran = " ";
            String tempbranold = " ";
            String tempdate = "";
            String tempdateold = "";
            String tempbname = "";
            String tempbnameold = "";
            Date d_tempdate =null;
            Date d_tempdateold = null;
            double total1 = 0,total2 = 0,total3 = 0;
            double totalgroup1 = 0,totalgroup2 = 0,totalgroup3 = 0;
            
            
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            reportComPluBean subtree = null;
            myroot = new reportComPluBean( "รายงานททั้งหมด","","","","","","","","","","","","","" );
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                tempbran = rs.getString("tgroup");
                tempbname = cvth.ASCII2Unicode(rs.getString("tgroupname"));
                double cost = 0.00;
                double per = 0.00;
                
                
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
//                        subtree.getChildren().add(new reportComPluBean("Total "+code+" "+tempbranold,"","",""
//                                ,""
//                                ,""
//                                ,Format.doubleFmt.format(totalgroup1)
//                                ,Format.doubleFmt.format(totalgroup2)
//                                ,Format.doubleFmt.format(totalgroup3)
//                        ,""
//                         ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;
                        subtree.setBran(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportComPluBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportComPluBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("tdept")),
                                                                        cvth.ASCII2Unicode(rs.getString("tpcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("tname")),
                                                                        Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.integerFmt.format(rs.getInt("tqty1")),
                                                                        Format.integerFmt.format(rs.getDouble("tqty2")),
                                                                        Format.integerFmt.format(rs.getDouble("tqtydif")),
                                                                        Format.integerFmt.format(rs.getDouble("tqtydifp"))+"%",
                                                                        Format.integerFmt.format(rs.getDouble("tamt1")),
                                                                        Format.integerFmt.format(rs.getDouble("tamt2")),
                                                                        Format.integerFmt.format(rs.getDouble("tamtdif")),
                                                                        Format.integerFmt.format(rs.getDouble("tamtdifp"))+"%"
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                        subtree.getChildren().add(new reportComPluBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("tdept")),
                                                                        cvth.ASCII2Unicode(rs.getString("tpcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("tname")),
                                                                        Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.integerFmt.format(rs.getInt("tqty1")),
                                                                        Format.integerFmt.format(rs.getDouble("tqty2")),
                                                                        Format.integerFmt.format(rs.getDouble("tqtydif")),
                                                                        Format.integerFmt.format(rs.getDouble("tqtydifp"))+"%",
                                                                        Format.integerFmt.format(rs.getDouble("tamt1")),
                                                                        Format.integerFmt.format(rs.getDouble("tamt2")),
                                                                        Format.integerFmt.format(rs.getDouble("tamtdif")),
                                                                        Format.integerFmt.format(rs.getDouble("tamtdifp"))+"%"
                                                                    ));
                        
                    
                    
                    
                }
                
//                totalgroup1 += rs.getDouble("s_qty");
//                totalgroup2 += rs.getDouble("s_amt");
//                totalgroup3 += cost;
//                
//                
//               
//                
//                
//                total1 += rs.getDouble("s_qty");
//                total2 += rs.getDouble("s_amt");
//                total3 += cost;
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("tgroup");
                tempbnameold = cvth.ASCII2Unicode(rs.getString("tgroupname"));
                
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
//            subtree.getChildren().add(new reportSumPluCostBean("Total "+code+" "+tempbran,"","",""
//                                ,""
//                                ,""
//                                ,Format.doubleFmt.format(totalgroup1)
//                                ,Format.doubleFmt.format(totalgroup2)
//                                ,Format.doubleFmt.format(totalgroup3)
//                        ,""
//                         ));
//            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
//            
            subtree.setBran(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            }
           
//           myroot.getChildren().add(new reportSumPluCostBean("Total All"
//                    ,""
//                    ,""
//                    ,""
//                    ,""
//                    ,""
//                    ,Format.doubleFmt.format(total1)
//                    ,Format.doubleFmt.format(total2)
//                    ,Format.doubleFmt.format(total3)
//                    ,""
//                     ));
            myroot.setBran("Report List Of "+counttotal+" Record");
            }
            else
            {
                while (rs.next()) {
                
                tempbran = rs.getString("tgroup");
                tempbname = rs.getString("tgroupname");
                double cost = 0.00;
                double per = 0.00;
                
                
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
//                        subtree.getChildren().add(new reportComPluBean("Total "+code+" "+tempbranold,"","",""
//                                ,""
//                                ,""
//                                ,Format.doubleFmt.format(totalgroup1)
//                                ,Format.doubleFmt.format(totalgroup2)
//                                ,Format.doubleFmt.format(totalgroup3)
//                        ,""
//                         ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;
                        subtree.setBran(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportComPluBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportComPluBean( rs.getString("tgroup"),
                                                                        rs.getString("tdept"),
                                                                        rs.getString("tpcode"),
                                                                        rs.getString("tname"),
                                                                        Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                                        rs.getString("punit1"),
                                                                        Format.integerFmt.format(rs.getInt("tqty1")),
                                                                        Format.integerFmt.format(rs.getDouble("tqty2")),
                                                                        Format.integerFmt.format(rs.getDouble("tqtydif")),
                                                                        Format.integerFmt.format(rs.getDouble("tqtydifp"))+"%",
                                                                        Format.integerFmt.format(rs.getDouble("tamt1")),
                                                                        Format.integerFmt.format(rs.getDouble("tamt2")),
                                                                        Format.integerFmt.format(rs.getDouble("tamtdif")),
                                                                        Format.integerFmt.format(rs.getDouble("tamtdifp"))+"%"
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                        subtree.getChildren().add(new reportComPluBean( rs.getString("tgroup"),
                                                                        rs.getString("tdept"),
                                                                        rs.getString("tpcode"),
                                                                        rs.getString("tname"),
                                                                        Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                                        rs.getString("punit1"),
                                                                        Format.integerFmt.format(rs.getInt("tqty1")),
                                                                        Format.integerFmt.format(rs.getDouble("tqty2")),
                                                                        Format.integerFmt.format(rs.getDouble("tqtydif")),
                                                                        Format.integerFmt.format(rs.getDouble("tqtydifp"))+"%",
                                                                        Format.integerFmt.format(rs.getDouble("tamt1")),
                                                                        Format.integerFmt.format(rs.getDouble("tamt2")),
                                                                        Format.integerFmt.format(rs.getDouble("tamtdif")),
                                                                        Format.integerFmt.format(rs.getDouble("tamtdifp"))+"%"
                                                                    ));
                        
                    
                    
                    
                }
                
//                totalgroup1 += rs.getDouble("s_qty");
//                totalgroup2 += rs.getDouble("s_amt");
//                totalgroup3 += cost;
//                
//                
//               
//                
//                
//                total1 += rs.getDouble("s_qty");
//                total2 += rs.getDouble("s_amt");
//                total3 += cost;
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("tgroup");
                tempbnameold = rs.getString("tgroupname");
                
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
//            subtree.getChildren().add(new reportSumPluCostBean("Total "+code+" "+tempbran,"","",""
//                                ,""
//                                ,""
//                                ,Format.doubleFmt.format(totalgroup1)
//                                ,Format.doubleFmt.format(totalgroup2)
//                                ,Format.doubleFmt.format(totalgroup3)
//                        ,""
//                         ));
//            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
//            
            subtree.setBran(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            }
           
//           myroot.getChildren().add(new reportSumPluCostBean("Total All"
//                    ,""
//                    ,""
//                    ,""
//                    ,""
//                    ,""
//                    ,Format.doubleFmt.format(total1)
//                    ,Format.doubleFmt.format(total2)
//                    ,Format.doubleFmt.format(total3)
//                    ,""
//                     ));
            myroot.setBran("Report List Of "+counttotal+" Record");
               
            }
    
    }
        
        @Override
	public int getColumnCount() 
	{
		return 30;
	}
	
	@Override
	public String getColumnName( int column )
	{
		switch( column )
		{
		default: return "Unknown";
		}
	}

	@Override
	public Object getValueAt( Object node, int column ) 
	{
		//System.out.println( "getValueAt: " + node + ", " + column );
		reportComPluBean treenode = ( reportComPluBean )node;
		switch( column )
		{
		case 0: return treenode.getBran();
		case 1: return treenode.getDept();
		case 2: return treenode.getPcode();
                case 3: return treenode.getPname();
                case 4: return treenode.getPrice();
                case 5: return treenode.getPunit();
                case 6: return treenode.getCom1();
                case 7: return treenode.getCom2();
                case 8: return treenode.getCom3();
                case 9: return treenode.getCom4();
                case 10: return treenode.getCom5();
                case 11: return treenode.getCom6();
                case 12: return treenode.getCom7();
                case 13: return treenode.getCom8();
		
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportComPluBean treenode = ( reportComPluBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportComPluBean treenode = ( reportComPluBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportComPluBean treenode = ( reportComPluBean )parent;
		for( int i=0; i>treenode.getChildren().size(); i++ )
		{
			if( treenode.getChildren().get( i ) == child )
			{
				return i;
			}
		}

		// TODO Auto-generated method stub
		return 0;
	}
	
	 public boolean isLeaf( Object node )
	 {
		 reportComPluBean treenode = ( reportComPluBean )node;
		 if( treenode.getChildren().size() > 0 )
		 {
			 return false;
		 }
		 return true;
	 }
	 
	 @Override
	 public Object getRoot()
	 {
		 return myroot;
	 }
    
}
