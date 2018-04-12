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
 * @author natee
 */
public class reportBudFastModel extends AbstractTreeTableModel
{
    private Statement stmt;
	private reportBudFastBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportBudFastModel(String sql,String code,String name) throws SQLException
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
            reportBudFastBean subtree = null;
            myroot = new reportBudFastBean("รายงานททั้งหมด","","","","","","");
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                tempbran = cvth.ASCII2Unicode(rs.getString(code));
                if(!code.equals("PluGroup"))
                {
                    tempbname = cvth.ASCII2Unicode(rs.getString(name));
                }
                else
                {
                    tempbname= "";
                }
                double per = 0.00;
                
                
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;
                        subtree.setCode(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportBudFastBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportBudFastBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                        cvth.ASCII2Unicode(rs.getString("pque")),
                                                                        cvth.ASCII2Unicode(rs.getString("pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.doubleFmt.format(rs.getDouble("amount"))
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                       subtree.getChildren().add(new reportBudFastBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                        cvth.ASCII2Unicode(rs.getString("pque")),
                                                                        cvth.ASCII2Unicode(rs.getString("pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.doubleFmt.format(rs.getDouble("amount"))
                                                                    ));
                        
                    
                    
                    
                }
                
               
                
                
               
                
                
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = cvth.ASCII2Unicode(rs.getString(code));
                
                if(!code.equals("PluGroup"))
                {
                    tempbnameold = cvth.ASCII2Unicode(rs.getString(name));
                }
                else
                {
                    tempbnameold= "";
                }
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
            
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            subtree.setCode(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            }
           
           
            myroot.setCode("Report List Of "+counttotal+" Record");
            }
            else
            {
               while (rs.next()) {
                
                tempbran = rs.getString(code);
                if(!code.equals("PluGroup"))
                {
                    tempbname = rs.getString(name);
                }
                else
                {
                    tempbname= "";
                }
                double per = 0.00;
                
                
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;
                        subtree.setCode(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportBudFastBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportBudFastBean( rs.getString(code),
                                                                        rs.getString("pque"),
                                                                        rs.getString("pcode"),
                                                                        rs.getString("pdesc"),
                                                                        Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                                        rs.getString("punit1"),
                                                                        Format.doubleFmt.format(rs.getDouble("amount"))
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                       subtree.getChildren().add(new reportBudFastBean( rs.getString(code),
                                                                        rs.getString("pque"),
                                                                        rs.getString("pcode"),
                                                                        rs.getString("pdesc"),
                                                                        Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                                        rs.getString("punit1"),
                                                                        Format.doubleFmt.format(rs.getDouble("amount"))
                                                                    ));
                        
                    
                    
                    
                }
                
               
                
                
               
                
                
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString(code);
                
                if(!code.equals("PluGroup"))
                {
                    tempbnameold = rs.getString(name);
                }
                else
                {
                    tempbnameold= "";
                }
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
            
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            subtree.setCode(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            }
           
           
            myroot.setCode("Report List Of "+counttotal+" Record");
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
		reportBudFastBean treenode = ( reportBudFastBean )node;
		switch( column )
		{
		case 0: return treenode.getCode();
		case 1: return treenode.getQue();
		case 2: return treenode.getPcode();
                case 3: return treenode.getPname();
                case 4: return treenode.getPrice();
                case 5: return treenode.getUnit();
		case 6: return treenode.getAmount();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportBudFastBean treenode = ( reportBudFastBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportBudFastBean treenode = ( reportBudFastBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportBudFastBean treenode = ( reportBudFastBean )parent;
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
		 reportBudFastBean treenode = ( reportBudFastBean )node;
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
