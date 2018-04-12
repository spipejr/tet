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
public class reportMonthModel  extends AbstractTreeTableModel
{
     private Statement stmt;
	private reportMonthBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportMonthModel(String sql,String code,String name) throws SQLException
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
            reportMonthBean subtree = null;
            myroot = new reportMonthBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                
                
                    tempbname = cvth.ASCII2Unicode(rs.getString("tgroup"));
                    tempbran = cvth.ASCII2Unicode(rs.getString("tname"));
                
               
                dif = rs.getDouble("mon01")-rs.getDouble("mon02");
                if(rs.getDouble("mon02")>0 )
                {
                    difper = (dif/rs.getDouble("mon02"))*100;
                }
                else
                {
                    difper = 0;
                }
                
                if(rs.getDouble("mon03")>0 )
                {
                    budper = (rs.getDouble("mon01")/rs.getDouble("mon03"))*100;
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
                    
                    subtree = new reportMonthBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportMonthBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("rjno")),
                                                                        cvth.ASCII2Unicode(rs.getString("dept")),
                                                                        cvth.ASCII2Unicode(rs.getString("descname")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon01")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon02")),
                                                                        Format.doubleFmt.format(dif),
                                                                        Format.doubleFmt.format(difper)+"%",
                                                                        Format.doubleFmt.format(rs.getDouble("mon03")),
                                                                        Format.doubleFmt.format(budper)+"%"
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                       subtree.getChildren().add(new reportMonthBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("rjno")),
                                                                        cvth.ASCII2Unicode(rs.getString("dept")),
                                                                        cvth.ASCII2Unicode(rs.getString("descname")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon01")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon02")),
                                                                        Format.doubleFmt.format(dif),
                                                                        Format.doubleFmt.format(difper)+"%",
                                                                        Format.doubleFmt.format(rs.getDouble("mon03")),
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
                
               
                dif = rs.getDouble("mon01")-rs.getDouble("mon02");
                if(rs.getDouble("mon02")>0 )
                {
                    difper = (dif/rs.getDouble("mon02"))*100;
                }
                else
                {
                    difper = 0;
                }
                
                if(rs.getDouble("mon03")>0 )
                {
                    budper = (rs.getDouble("mon01")/rs.getDouble("mon03"))*100;
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
                    
                    subtree = new reportMonthBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportMonthBean( rs.getString("tgroup"),
                                                                        rs.getString("rjno"),
                                                                        rs.getString("dept"),
                                                                        rs.getString("descname"),
                                                                        Format.doubleFmt.format(rs.getDouble("mon01")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon02")),
                                                                        Format.doubleFmt.format(dif),
                                                                        Format.doubleFmt.format(difper)+"%",
                                                                        Format.doubleFmt.format(rs.getDouble("mon03")),
                                                                        Format.doubleFmt.format(budper)+"%"
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                       subtree.getChildren().add(new reportMonthBean( rs.getString("tgroup"),
                                                                        rs.getString("rjno"),
                                                                        rs.getString("dept"),
                                                                        rs.getString("descname"),
                                                                        Format.doubleFmt.format(rs.getDouble("mon01")),
                                                                        Format.doubleFmt.format(rs.getDouble("mon02")),
                                                                        Format.doubleFmt.format(dif),
                                                                        Format.doubleFmt.format(difper)+"%",
                                                                        Format.doubleFmt.format(rs.getDouble("mon03")),
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
		reportMonthBean treenode = ( reportMonthBean )node;
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
               
                default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportMonthBean treenode = ( reportMonthBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportMonthBean treenode = ( reportMonthBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportMonthBean treenode = ( reportMonthBean )parent;
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
		 reportMonthBean treenode = ( reportMonthBean )node;
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
