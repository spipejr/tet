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
 * @author s386
 */
public class reportSumMonthModel extends AbstractTreeTableModel
{
    private Statement stmt;
	private reportSumMonthBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportSumMonthModel(String sql,String code,String name) throws SQLException
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
            
            rs = stmt.executeQuery(sql);
            reportSumMonthBean subtree = null;
            myroot = new reportSumMonthBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                
                
                    tempbname = cvth.ASCII2Unicode(rs.getString("tgroup"));
                    tempbran = cvth.ASCII2Unicode(rs.getString("tname"));
                
               
                
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
                    
                    subtree = new reportSumMonthBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportSumMonthBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("rjno")),
                                                                        cvth.ASCII2Unicode(rs.getString("dept")),
                                                                        cvth.ASCII2Unicode(rs.getString("descname")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon01")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon02")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon03")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon04")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon05")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon06")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon07")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon08")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon09")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon10")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon11")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon12")),
                                                                        Format.doubleFmt.format(rs.getDouble("total"))
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                       subtree.getChildren().add(new reportSumMonthBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("rjno")),
                                                                        cvth.ASCII2Unicode(rs.getString("dept")),
                                                                        cvth.ASCII2Unicode(rs.getString("descname")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon01")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon02")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon03")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon04")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon05")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon06")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon07")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon08")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon09")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon10")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon11")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon12")),
                                                                        Format.doubleFmt.format(rs.getDouble("total"))
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
		reportSumMonthBean treenode = ( reportSumMonthBean )node;
		switch( column )
		{
		case 0: return treenode.getCode();
		case 1: return treenode.getNo();
		case 2: return treenode.getDept();
                case 3: return treenode.getDesc();
                case 4: return treenode.getM1();
                case 5: return treenode.getM2();
		case 6: return treenode.getM3();
		case 7: return treenode.getM4();
                case 8: return treenode.getM5();
                case 9: return treenode.getM6();
                case 10: return treenode.getM7();
                case 11: return treenode.getM8();
                case 12: return treenode.getM9();
                case 13: return treenode.getM10();
                case 14: return treenode.getM11();
                case 15: return treenode.getM12();
                case 16: return treenode.getTotal();
                default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportSumMonthBean treenode = ( reportSumMonthBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportSumMonthBean treenode = ( reportSumMonthBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportSumMonthBean treenode = ( reportSumMonthBean )parent;
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
		 reportSumMonthBean treenode = ( reportSumMonthBean )node;
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
