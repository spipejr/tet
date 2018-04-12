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
import javax.swing.JOptionPane;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author natee
 */
public class reportFastivalModel extends AbstractTreeTableModel
{
    private Statement stmt;
	private reportFastivalBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportFastivalModel(String sql,String code,String name) throws SQLException
    {
        try {
            
        
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
            double dif = 0;
            double difper = 0;
            double budper = 0;
            rs = stmt.executeQuery(sql);
            reportFastivalBean subtree = null;
            myroot = new reportFastivalBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                
                
                    tempbname = cvth.ASCII2Unicode(rs.getString("tgroup"));
                    tempbran = cvth.ASCII2Unicode(rs.getString("tname"));
                
               
                dif = rs.getDouble("bran1")-rs.getDouble("bran2");
                if(rs.getDouble("bran2")>0 )
                {
                    difper = (dif/rs.getDouble("bran2"))*100;
                }
                else
                {
                    difper = 0;
                }
                
                if(rs.getDouble("bran3")>0 )
                {
                    budper = (rs.getDouble("bran1")/rs.getDouble("bran3"))*100;
                }
                else
                {
                    budper = 0;
                }
                
                
                
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
                    
                    subtree = new reportFastivalBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportFastivalBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("tque")),
                                                                        cvth.ASCII2Unicode(rs.getString("tcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("tpname")),
                                                                        cvth.ASCII2Unicode(rs.getString("tprice")),
                                                                        cvth.ASCII2Unicode(rs.getString("tunit")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(dif),
                                                                        Format.doubleFmt.format(difper)+"%",
                                                                        Format.doubleFmt.format(rs.getDouble("bran3")),
                                                                        Format.doubleFmt.format(budper)+"%"
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                       subtree.getChildren().add(new reportFastivalBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("tque")),
                                                                        cvth.ASCII2Unicode(rs.getString("tcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("tpname")),
                                                                        cvth.ASCII2Unicode(rs.getString("tprice")),
                                                                        cvth.ASCII2Unicode(rs.getString("tunit")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(dif),
                                                                        Format.doubleFmt.format(difper)+"%",
                                                                        Format.doubleFmt.format(rs.getDouble("bran3")),
                                                                        Format.doubleFmt.format(budper)+"%"
                                                                    ));
                    
                    
                    
                }
                
               
                
                
               
                
                
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
                    tempbnameold = cvth.ASCII2Unicode(rs.getString("tgroup"));
                    tempbranold = cvth.ASCII2Unicode(rs.getString("tname"));
                
                
                
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
                
                
                
                    tempbname = rs.getString("tgroup");
                    tempbran = rs.getString("tname");
                
               
                dif = rs.getDouble("bran1")-rs.getDouble("bran2");
                if(rs.getDouble("bran2")>0 )
                {
                    difper = (dif/rs.getDouble("bran2"))*100;
                }
                else
                {
                    difper = 0;
                }
                
                if(rs.getDouble("bran3")>0 )
                {
                    budper = (rs.getDouble("bran1")/rs.getDouble("bran3"))*100;
                }
                else
                {
                    budper = 0;
                }
                
                
                
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
                    
                    subtree = new reportFastivalBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportFastivalBean( rs.getString("tgroup"),
                                                                        rs.getString("tque"),
                                                                        rs.getString("tcode"),
                                                                        rs.getString("tpname"),
                                                                        rs.getString("tprice"),
                                                                        rs.getString("tunit"),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(dif),
                                                                        Format.doubleFmt.format(difper)+"%",
                                                                        Format.doubleFmt.format(rs.getDouble("bran3")),
                                                                        Format.doubleFmt.format(budper)+"%"
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                       subtree.getChildren().add(new reportFastivalBean( rs.getString("tgroup"),
                                                                        rs.getString("tque"),
                                                                        rs.getString("tcode"),
                                                                        rs.getString("tpname"),
                                                                        rs.getString("tprice"),
                                                                        rs.getString("tunit"),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(dif),
                                                                        Format.doubleFmt.format(difper)+"%",
                                                                        Format.doubleFmt.format(rs.getDouble("bran3")),
                                                                        Format.doubleFmt.format(budper)+"%"
                                                                    ));
                    
                    
                    
                }
                
               
                
                
               
                
                
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
                    tempbnameold = rs.getString("tgroup");
                    tempbranold = rs.getString("tname");
                
                
                
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
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e);
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
		reportFastivalBean treenode = ( reportFastivalBean )node;
		switch( column )
		{
		case 0: return treenode.getCode();
		case 1: return treenode.getQue();
		case 2: return treenode.getPcode();
                case 3: return treenode.getPname();
                case 4: return treenode.getPrice();
                case 5: return treenode.getUnit();
		case 6: return treenode.getD1();
		case 7: return treenode.getD2();
                case 8: return treenode.getD3();
                case 9: return treenode.getD4();
                case 10: return treenode.getD5();
                case 11: return treenode.getD6();    
                default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportFastivalBean treenode = ( reportFastivalBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportFastivalBean treenode = ( reportFastivalBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportFastivalBean treenode = ( reportFastivalBean )parent;
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
		 reportFastivalBean treenode = ( reportFastivalBean )node;
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
