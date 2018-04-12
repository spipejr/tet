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
public class reportSumDeptCostModel extends AbstractTreeTableModel 
{
    private Statement stmt;
	private reportSumDeptCostBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportSumDeptCostModel(String sql,String code,String name) throws SQLException
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
            reportSumDeptCostBean subtree = null;
            myroot = new reportSumDeptCostBean( "รายงานททั้งหมด","","","","","","" );
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                tempbran = rs.getString(code);
                tempbname = cvth.ASCII2Unicode(rs.getString(name));
                double cost = 0.00;
                double per = 0.00;
//                if(rs.getString("pabtype").equals("R"))
//                {
//                    cost = rs.getDouble("s_qty")*calculateLCostPLU.calculatecost(rs.getString("s_pcode"));
//                }
//                else
//                {
//                    cost = rs.getDouble("s_qty")*rs.getDouble("pscost");
//                }
                if(rs.getDouble("s_amt")!=0)
                {
                    per = rs.getDouble("s_amt3")/rs.getDouble("s_amt")*100;
                }
                
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new reportSumDeptCostBean(tempbranold,"","Total "+code+" "+tempbranold
                                ,Format.doubleFmt.format(totalgroup1)
                                ,Format.doubleFmt.format(totalgroup2)
                                ,Format.doubleFmt.format(totalgroup3)
                        ,""
                         ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;
                        subtree.setS_bran(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportSumDeptCostBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportSumDeptCostBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("PGroupName")),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt3")),
                                                                        Format.doubleFmt.format(per)+"%"
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                        subtree.getChildren().add(new reportSumDeptCostBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("PGroupName")),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt3")),
                                                                        Format.doubleFmt.format(per)+"%"
                                                                    ));
                        
                    
                    
                    
                }
                
                totalgroup1 += rs.getDouble("s_qty");
                totalgroup2 += rs.getDouble("s_amt");
                totalgroup3 += rs.getDouble("s_amt3");
                
                
               
                
                
                total1 += rs.getDouble("s_qty");
                total2 += rs.getDouble("s_amt");
                total3 += rs.getDouble("s_amt3");
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString(code);
                tempbnameold = cvth.ASCII2Unicode(rs.getString(name));
                
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
            subtree.getChildren().add(new reportSumDeptCostBean(tempbran,"","Total "+code+" "+tempbran
                                ,Format.doubleFmt.format(totalgroup1)
                                ,Format.doubleFmt.format(totalgroup2)
                                ,Format.doubleFmt.format(totalgroup3)
                        ,""
                         ));
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            subtree.setS_bran(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            }
           
           myroot.getChildren().add(new reportSumDeptCostBean("Total All"
                    ,""
                    ,""
                    ,Format.doubleFmt.format(total1)
                    ,Format.doubleFmt.format(total2)
                    ,Format.doubleFmt.format(total3)
                    ,""
                     ));
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
            else
            {
               while (rs.next()) {
                
                tempbran = rs.getString(code);
                tempbname = rs.getString(name);
                double cost = 0.00;
                double per = 0.00;
//                if(rs.getString("pabtype").equals("R"))
//                {
//                    cost = rs.getDouble("s_qty")*calculateLCostPLU.calculatecost(rs.getString("s_pcode"));
//                }
//                else
//                {
//                    cost = rs.getDouble("s_qty")*rs.getDouble("pscost");
//                }
                if(rs.getDouble("s_amt")!=0)
                {
                    per = rs.getDouble("s_amt3")/rs.getDouble("s_amt")*100;
                }
                
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new reportSumDeptCostBean(tempbranold,"","Total "+code+" "+tempbranold
                                ,Format.doubleFmt.format(totalgroup1)
                                ,Format.doubleFmt.format(totalgroup2)
                                ,Format.doubleFmt.format(totalgroup3)
                        ,""
                         ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;
                        subtree.setS_bran(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportSumDeptCostBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportSumDeptCostBean( rs.getString(code),
                                                                        rs.getString("pgroup"),
                                                                        rs.getString("PGroupName"),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt3")),
                                                                        Format.doubleFmt.format(per)+"%"
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                        subtree.getChildren().add(new reportSumDeptCostBean( rs.getString(code),
                                                                        rs.getString("pgroup"),
                                                                        rs.getString("PGroupName"),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt3")),
                                                                        Format.doubleFmt.format(per)+"%"
                                                                    ));
                        
                    
                    
                    
                }
                
                totalgroup1 += rs.getDouble("s_qty");
                totalgroup2 += rs.getDouble("s_amt");
                totalgroup3 += rs.getDouble("s_amt3");
                
                
               
                
                
                total1 += rs.getDouble("s_qty");
                total2 += rs.getDouble("s_amt");
                total3 += rs.getDouble("s_amt3");
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString(code);
                tempbnameold = rs.getString(name);
                
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
            subtree.getChildren().add(new reportSumDeptCostBean(tempbran,"","Total "+code+" "+tempbran
                                ,Format.doubleFmt.format(totalgroup1)
                                ,Format.doubleFmt.format(totalgroup2)
                                ,Format.doubleFmt.format(totalgroup3)
                        ,""
                         ));
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            subtree.setS_bran(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            }
           
           myroot.getChildren().add(new reportSumDeptCostBean("Total All"
                    ,""
                    ,""
                    ,Format.doubleFmt.format(total1)
                    ,Format.doubleFmt.format(total2)
                    ,Format.doubleFmt.format(total3)
                    ,""
                     ));
            myroot.setS_bran("Report List Of "+counttotal+" Record");
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
		reportSumDeptCostBean treenode = ( reportSumDeptCostBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
		case 1: return treenode.getS_dept();
                case 2: return treenode.getPname();
                case 3: return treenode.getS_qty();
                case 4: return treenode.getS_amt();
                case 5: return treenode.getTotalcost();
                case 6: return treenode.getS_per();
		
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportSumDeptCostBean treenode = ( reportSumDeptCostBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportSumDeptCostBean treenode = ( reportSumDeptCostBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportSumDeptCostBean treenode = ( reportSumDeptCostBean )parent;
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
		 reportSumDeptCostBean treenode = ( reportSumDeptCostBean )node;
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
