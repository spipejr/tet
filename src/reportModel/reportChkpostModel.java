/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModel;


import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;
/**
 *
 * @author natee
 */
public class reportChkpostModel extends AbstractTreeTableModel
{
    private Statement stmt;
	private reportChkpostBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
    public reportChkpostModel(String sql) throws SQLException
    {
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
            reportChkpostBean subtree = null;
            myroot = new reportChkpostBean();
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

                        subtree = new reportChkpostBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportChkpostBean( cvth.ASCII2Unicode(rs.getString("code")),
                                                                            cvth.ASCII2Unicode(rs.getString("BrCode")),
                                                                            cvth.ASCII2Unicode(rs.getString("BrName")),
                                                                            Format.dateFmtShow.format(rs.getDate("tDate")),
                                                                            cvth.ASCII2Unicode(rs.getString("Plu")),
                                                                            cvth.ASCII2Unicode(rs.getString("Terminal")),
                                                                            cvth.ASCII2Unicode(rs.getString("Cashier")),
                                                                            cvth.ASCII2Unicode(rs.getString("Cupon")),
                                                                            cvth.ASCII2Unicode(rs.getString("Inv")),
                                                                            cvth.ASCII2Unicode(rs.getString("Hour")),
                                                                            cvth.ASCII2Unicode(rs.getString("Rj")),
                                                                            cvth.ASCII2Unicode(rs.getString("Stc")),
                                                                            cvth.ASCII2Unicode(rs.getString("Cr")),
                                                                            cvth.ASCII2Unicode(rs.getString("bg")),
                                                                            cvth.ASCII2Unicode(rs.getString("Charge")),
                                                                            cvth.ASCII2Unicode(rs.getString("BI")),
                                                                            cvth.ASCII2Unicode(rs.getString("userpost"))
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportChkpostBean( cvth.ASCII2Unicode(rs.getString("code")),
                                                                            cvth.ASCII2Unicode(rs.getString("BrCode")),
                                                                            cvth.ASCII2Unicode(rs.getString("BrName")),
                                                                            Format.dateFmtShow.format(rs.getDate("tDate")),
                                                                            cvth.ASCII2Unicode(rs.getString("Plu")),
                                                                            cvth.ASCII2Unicode(rs.getString("Terminal")),
                                                                            cvth.ASCII2Unicode(rs.getString("Cashier")),
                                                                            cvth.ASCII2Unicode(rs.getString("Cupon")),
                                                                            cvth.ASCII2Unicode(rs.getString("Inv")),
                                                                            cvth.ASCII2Unicode(rs.getString("Hour")),
                                                                            cvth.ASCII2Unicode(rs.getString("Rj")),
                                                                            cvth.ASCII2Unicode(rs.getString("Stc")),
                                                                            cvth.ASCII2Unicode(rs.getString("Cr")),
                                                                            cvth.ASCII2Unicode(rs.getString("bg")),
                                                                            cvth.ASCII2Unicode(rs.getString("Charge")),
                                                                            cvth.ASCII2Unicode(rs.getString("BI")),
                                                                            cvth.ASCII2Unicode(rs.getString("userpost"))
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

                        subtree = new reportChkpostBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportChkpostBean( rs.getString("code"),
                                                                            rs.getString("BrCode"),
                                                                            rs.getString("BrName"),
                                                                            Format.dateFmtShow.format(rs.getDate("tDate")),
                                                                            rs.getString("Plu"),
                                                                            rs.getString("Terminal"),
                                                                            rs.getString("Cashier"),
                                                                            rs.getString("Cupon"),
                                                                            rs.getString("Inv"),
                                                                            rs.getString("Hour"),
                                                                            rs.getString("Rj"),
                                                                            rs.getString("Stc"),
                                                                            rs.getString("Cr"),
                                                                            rs.getString("bg"),
                                                                            rs.getString("Charge"),
                                                                            rs.getString("BI"),
                                                                            rs.getString("userpost")
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportChkpostBean( rs.getString("code"),
                                                                            rs.getString("BrCode"),
                                                                            rs.getString("BrName"),
                                                                            Format.dateFmtShow.format(rs.getDate("tDate")),
                                                                            rs.getString("Plu"),
                                                                            rs.getString("Terminal"),
                                                                            rs.getString("Cashier"),
                                                                            rs.getString("Cupon"),
                                                                            rs.getString("Inv"),
                                                                            rs.getString("Hour"),
                                                                            rs.getString("Rj"),
                                                                            rs.getString("Stc"),
                                                                            rs.getString("Cr"),
                                                                            rs.getString("bg"),
                                                                            rs.getString("Charge"),
                                                                            rs.getString("BI"),
                                                                            rs.getString("userpost")
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
    }
    
    @Override
	public int getColumnCount() 
	{
		return 17;
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
		reportChkpostBean treenode = ( reportChkpostBean )node;
		switch( column )
		{
		case 0: return treenode.getArea();
		case 1: return treenode.getBran();
		case 2: return treenode.getName();
                case 3: return treenode.getDate();
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
                case 16: return treenode.getPost();
                
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportChkpostBean treenode = ( reportChkpostBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportChkpostBean treenode = ( reportChkpostBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportChkpostBean treenode = ( reportChkpostBean )parent;
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
		 reportChkpostBean treenode = ( reportChkpostBean )node;
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
