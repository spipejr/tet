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
public class reportSumPluIngByPluModel extends AbstractTreeTableModel 
{
    private Statement stmt;
	private reportSumPluIngByPluBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportSumPluIngByPluModel(String sql,String code,String name) throws SQLException
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
            reportSumPluIngByPluBean subtree = null;
            myroot = new reportSumPluIngByPluBean( "รายงานททั้งหมด","","","","","","","","","","","" );
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                tempbran = rs.getString("tgroup");
                tempbname = cvth.ASCII2Unicode(rs.getString("tname"));
                double cost = 0.00;
                double per = 0.00;

                
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new reportSumPluIngByPluBean(tempbranold,"","Total "+code+" "+tempbranold
                                ,""
                                ,""
                                ,""
                                ,""
                                ,""
                                ,""
                                ,Format.doubleFmt.format(totalgroup1)
                                ,Format.doubleFmt.format(totalgroup2)
                                ,""
                         ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;
                        subtree.setS_bran(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportSumPluIngByPluBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportSumPluIngByPluBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("tdept")),
                                                                        cvth.ASCII2Unicode(rs.getString("tdeptname")),
                                                                        cvth.ASCII2Unicode(rs.getString("tcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("tpname")),
                                                                        cvth.ASCII2Unicode(rs.getString("tbank")),
                                                                        cvth.ASCII2Unicode(rs.getString("tday")),
                                                                        Format.doubleFmt.format(rs.getDouble("tprice")),
                                                                        cvth.ASCII2Unicode(rs.getString("tunit")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran3"))
                                                                        
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                        subtree.getChildren().add(new reportSumPluIngByPluBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("tdept")),
                                                                        cvth.ASCII2Unicode(rs.getString("tdeptname")),
                                                                        cvth.ASCII2Unicode(rs.getString("tcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("tpname")),
                                                                        cvth.ASCII2Unicode(rs.getString("tbank")),
                                                                        cvth.ASCII2Unicode(rs.getString("tday")),
                                                                        Format.doubleFmt.format(rs.getDouble("tprice")),
                                                                        cvth.ASCII2Unicode(rs.getString("tunit")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran3"))
                                                                        
                                                                    ));
                    
                    
                    
                }
                
                totalgroup1 += rs.getDouble("bran1");
                totalgroup2 += rs.getDouble("bran2");
                
                
               
                
                
                total1 += rs.getDouble("bran1");
                total2 += rs.getDouble("bran2");
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("tgroup");
                tempbnameold = cvth.ASCII2Unicode(rs.getString("tname"));
                
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
            subtree.getChildren().add(new reportSumPluIngByPluBean(tempbran,"","Total "+code+" "+tempbran
                                
                                ,""
                                ,""
                                ,""
                                ,""
                                ,""
                                ,""
                                ,Format.doubleFmt.format(totalgroup1)
                                ,Format.doubleFmt.format(totalgroup2)
                                ,""
                         ));
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            subtree.setS_bran(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            }
           
           myroot.getChildren().add(new reportSumPluIngByPluBean("Total All"
                    ,""
                    ,""
                    
                    ,""
                    ,""
                    ,""
                    ,""
                    ,""
                    ,""
                   ,Format.doubleFmt.format(total1)
                    ,Format.doubleFmt.format(total2)
                    ,""
                     ));
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
            else
            {
                while (rs.next()) {
                
                tempbran = rs.getString("tgroup");
                tempbname = rs.getString("tname");
                double cost = 0.00;
                double per = 0.00;

                
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new reportSumPluIngByPluBean(tempbranold,"","Total "+code+" "+tempbranold
                                ,""
                                ,""
                                ,""
                                ,""
                                ,""
                                ,""
                                ,Format.doubleFmt.format(totalgroup1)
                                ,Format.doubleFmt.format(totalgroup2)
                                ,""
                         ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;
                        subtree.setS_bran(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportSumPluIngByPluBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportSumPluIngByPluBean( rs.getString("tgroup"),
                                                                        rs.getString("tdept"),
                                                                        rs.getString("tdeptname"),
                                                                        rs.getString("tcode"),
                                                                        rs.getString("tpname"),
                                                                        rs.getString("tbank"),
                                                                        rs.getString("tday"),
                                                                        Format.doubleFmt.format(rs.getDouble("tprice")),
                                                                        rs.getString("tunit"),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran3"))
                                                                        
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                        subtree.getChildren().add(new reportSumPluIngByPluBean( rs.getString("tgroup"),
                                                                        rs.getString("tdept"),
                                                                        rs.getString("tdeptname"),
                                                                        rs.getString("tcode"),
                                                                        rs.getString("tpname"),
                                                                        rs.getString("tbank"),
                                                                        rs.getString("tday"),
                                                                        Format.doubleFmt.format(rs.getDouble("tprice")),
                                                                        rs.getString("tunit"),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran3"))
                                                                        
                                                                    ));
                    
                    
                    
                }
                
                totalgroup1 += rs.getDouble("bran1");
                totalgroup2 += rs.getDouble("bran2");
                
                
               
                
                
                total1 += rs.getDouble("bran1");
                total2 += rs.getDouble("bran2");
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("tgroup");
                tempbnameold = rs.getString("tname");
                
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
            subtree.getChildren().add(new reportSumPluIngByPluBean(tempbran,"","Total "+code+" "+tempbran
                                
                                ,""
                                ,""
                                ,""
                                ,""
                                ,""
                                ,""
                                ,Format.doubleFmt.format(totalgroup1)
                                ,Format.doubleFmt.format(totalgroup2)
                                ,""
                         ));
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            subtree.setS_bran(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            }
           
           myroot.getChildren().add(new reportSumPluIngByPluBean("Total All"
                    ,""
                    ,""
                    
                    ,""
                    ,""
                    ,""
                    ,""
                    ,""
                    ,""
                   ,Format.doubleFmt.format(total1)
                    ,Format.doubleFmt.format(total2)
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
		reportSumPluIngByPluBean treenode = ( reportSumPluIngByPluBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
		case 1: return treenode.getS_dept();
                case 2: return treenode.getS_deptname();
                case 3: return treenode.getPcode();
                case 4: return treenode.getPname();
                case 5: return treenode.getCode();
                case 6: return treenode.getName();    
                case 7: return treenode.getPrice();
                case 8: return treenode.getUnit();
		case 9: return treenode.getQty();
                case 10: return treenode.getTotcost();
		case 11: return treenode.getPqty();
                default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportSumPluIngByPluBean treenode = ( reportSumPluIngByPluBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportSumPluIngByPluBean treenode = ( reportSumPluIngByPluBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportSumPluIngByPluBean treenode = ( reportSumPluIngByPluBean )parent;
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
		 reportSumPluIngByPluBean treenode = ( reportSumPluIngByPluBean )node;
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
