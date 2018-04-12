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
public class reportChksumModel extends AbstractTreeTableModel
{
    private Statement stmt;
	private reportChksumBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportChksumModel(String sql) throws SQLException
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
            
            
            
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            reportChksumBean subtree = null;
            myroot = new reportChksumBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
                
                while (rs.next()) {

                    tempbran = cvth.ASCII2Unicode(rs.getString("code"));
                    tempbname = cvth.ASCII2Unicode(rs.getString("name"));


                    if(!tempbranold.equals(tempbran))
                    {
                        tempdateold = " ";
                        if(subtree != null)
                        {

                            myroot.getChildren().add(subtree);
                            subtree.setArea("Area"+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");

                        }

                        subtree = new reportChksumBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportChksumBean( cvth.ASCII2Unicode(rs.getString("code")),
                                                                            cvth.ASCII2Unicode(rs.getString("BrCode")),
                                                                            cvth.ASCII2Unicode(rs.getString("BrName")),
                                                                            Format.integerFmt.format(rs.getInt("TotalDate")),
                                                                            Format.integerFmt.format(rs.getInt("Plu")),
                                                                            Format.integerFmt.format(rs.getInt("Terminal")),
                                                                            Format.integerFmt.format(rs.getInt("Cashier")),
                                                                            Format.integerFmt.format(rs.getInt("Cupon")),
                                                                            Format.integerFmt.format(rs.getInt("Inv")),
                                                                            Format.integerFmt.format(rs.getInt("Hour")),
                                                                            Format.integerFmt.format(rs.getInt("Rj")),
                                                                            Format.integerFmt.format(rs.getInt("Stc")),
                                                                            Format.integerFmt.format(rs.getInt("Cr")),
                                                                            Format.integerFmt.format(rs.getInt("bg")),
                                                                            Format.integerFmt.format(rs.getInt("Charge")),
                                                                            Format.integerFmt.format(rs.getInt("BI"))
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportChksumBean( cvth.ASCII2Unicode(rs.getString("code")),
                                                                            cvth.ASCII2Unicode(rs.getString("brcode")),
                                                                            cvth.ASCII2Unicode(rs.getString("brname")),
                                                                            Format.integerFmt.format(rs.getInt("TotalDate")),
                                                                            Format.integerFmt.format(rs.getInt("Plu")),
                                                                            Format.integerFmt.format(rs.getInt("Terminal")),
                                                                            Format.integerFmt.format(rs.getInt("Cashier")),
                                                                            Format.integerFmt.format(rs.getInt("Cupon")),
                                                                            Format.integerFmt.format(rs.getInt("Inv")),
                                                                            Format.integerFmt.format(rs.getInt("Hour")),
                                                                            Format.integerFmt.format(rs.getInt("Rj")),
                                                                            Format.integerFmt.format(rs.getInt("Stc")),
                                                                            Format.integerFmt.format(rs.getInt("Cr")),
                                                                            Format.integerFmt.format(rs.getInt("bg")),
                                                                            Format.integerFmt.format(rs.getInt("Charge")),
                                                                            Format.integerFmt.format(rs.getInt("BI"))
                                                                        ));





                    }


                    i++;
                    countgroup++;
                    counttotal++;
                    countdate++;
                    tempbranold = cvth.ASCII2Unicode(rs.getString("code"));
                    tempbnameold = cvth.ASCII2Unicode(rs.getString("name"));




                }


            if(subtree != null)
            {

                subtree.setArea("Area"+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
                myroot.getChildren().add(subtree);
            }
                myroot.setArea("Report List Of "+counttotal+" Record");
                
                
            }
            else
            {
                 while (rs.next()) {

                    tempbran = rs.getString("code");
                    tempbname = rs.getString("name");


                    if(!tempbranold.equals(tempbran))
                    {
                        tempdateold = " ";
                        if(subtree != null)
                        {

                            myroot.getChildren().add(subtree);
                            subtree.setArea("Area"+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");

                        }

                        subtree = new reportChksumBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportChksumBean( rs.getString("code"),
                                                                            rs.getString("BrCode"),
                                                                            rs.getString("BrName"),
                                                                            Format.integerFmt.format(rs.getInt("TotalDate")),
                                                                            Format.integerFmt.format(rs.getInt("Plu")),
                                                                            Format.integerFmt.format(rs.getInt("Terminal")),
                                                                            Format.integerFmt.format(rs.getInt("Cashier")),
                                                                            Format.integerFmt.format(rs.getInt("Cupon")),
                                                                            Format.integerFmt.format(rs.getInt("Inv")),
                                                                            Format.integerFmt.format(rs.getInt("Hour")),
                                                                            Format.integerFmt.format(rs.getInt("Rj")),
                                                                            Format.integerFmt.format(rs.getInt("Stc")),
                                                                            Format.integerFmt.format(rs.getInt("Cr")),
                                                                            Format.integerFmt.format(rs.getInt("bg")),
                                                                            Format.integerFmt.format(rs.getInt("Charge")),
                                                                            Format.integerFmt.format(rs.getInt("BI"))
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportChksumBean( rs.getString("code"),
                                                                            rs.getString("brcode"),
                                                                            rs.getString("brname"),
                                                                            Format.integerFmt.format(rs.getInt("TotalDate")),
                                                                            Format.integerFmt.format(rs.getInt("Plu")),
                                                                            Format.integerFmt.format(rs.getInt("Terminal")),
                                                                            Format.integerFmt.format(rs.getInt("Cashier")),
                                                                            Format.integerFmt.format(rs.getInt("Cupon")),
                                                                            Format.integerFmt.format(rs.getInt("Inv")),
                                                                            Format.integerFmt.format(rs.getInt("Hour")),
                                                                            Format.integerFmt.format(rs.getInt("Rj")),
                                                                            Format.integerFmt.format(rs.getInt("Stc")),
                                                                            Format.integerFmt.format(rs.getInt("Cr")),
                                                                            Format.integerFmt.format(rs.getInt("bg")),
                                                                            Format.integerFmt.format(rs.getInt("Charge")),
                                                                            Format.integerFmt.format(rs.getInt("BI"))
                                                                        ));





                    }


                    i++;
                    countgroup++;
                    counttotal++;
                    countdate++;
                    tempbranold = rs.getString("code");
                    tempbnameold = rs.getString("name");




                }


            if(subtree != null)
            {

                subtree.setArea("Area"+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
                myroot.getChildren().add(subtree);
            }
                myroot.setArea("Report List Of "+counttotal+" Record");
            }
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
        }
    }
        
    
    @Override
	public int getColumnCount() 
	{
		return 16;
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
		reportChksumBean treenode = ( reportChksumBean )node;
		switch( column )
		{
		case 0: return treenode.getArea();
		case 1: return treenode.getBran();
		case 2: return treenode.getName();
                case 3: return treenode.getTotaldate();
                case 4: return treenode.getPlu();
                case 5: return treenode.getTerminal();
                case 6: return treenode.getCashier();
		case 7: return treenode.getCupon();
                case 8: return treenode.getInv();
		case 9: return treenode.getHour();
                case 10: return treenode.getRj();
                case 11: return treenode.getStc();
                case 12: return treenode.getCredit();
                case 13: return treenode.getKitchen();
		case 14: return treenode.getCharge();
		case 15: return treenode.getBi();
                
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportChksumBean treenode = ( reportChksumBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportChksumBean treenode = ( reportChksumBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportChksumBean treenode = ( reportChksumBean )parent;
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
		 reportChksumBean treenode = ( reportChksumBean )node;
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
