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
 * @author s386
 */
public class reportEmpAvgModel extends AbstractTreeTableModel
{
    private Statement stmt;
    private reportEmpAvgBean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();
    
    public reportEmpAvgModel(String sql,String code,String name) throws SQLException
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
            reportEmpAvgBean subtree = null;
            myroot = new reportEmpAvgBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
                
                while (rs.next()) {

                    tempbran = rs.getString("keycode");
                    tempbname = cvth.ASCII2Unicode(rs.getString("keyname"));


                    if(!tempbranold.equals(tempbran))
                    {
                        tempdateold = " ";
                        if(subtree != null)
                        {

                            myroot.getChildren().add(subtree);
                            subtree.setCode(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");

                        }

                        subtree = new reportEmpAvgBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportEmpAvgBean( cvth.ASCII2Unicode(rs.getString("keycode")),
                                                                            cvth.ASCII2Unicode(rs.getString("no")),
                                                                            cvth.ASCII2Unicode(rs.getString("dept")),
                                                                            Format.integerFmt.format(rs.getDouble("perqty")),
                                                                            Format.doubleFmt.format(rs.getDouble("totalsale")),
                                                                            Format.doubleFmt.format(rs.getDouble("peramount")),
                                                                            Format.doubleFmt.format(rs.getDouble("peramountday"))
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportEmpAvgBean( cvth.ASCII2Unicode(rs.getString("keycode")),
                                                                            cvth.ASCII2Unicode(rs.getString("no")),
                                                                            cvth.ASCII2Unicode(rs.getString("dept")),
                                                                            Format.integerFmt.format(rs.getDouble("perqty")),
                                                                            Format.doubleFmt.format(rs.getDouble("totalsale")),
                                                                            Format.doubleFmt.format(rs.getDouble("peramount")),
                                                                            Format.doubleFmt.format(rs.getDouble("peramountday"))
                                                                        ));





                    }


                    i++;
                    countgroup++;
                    counttotal++;
                    countdate++;
                    tempbranold = rs.getString("keycode");
                    tempbnameold = cvth.ASCII2Unicode(rs.getString("keyname"));




                }


            if(subtree != null)
            {

                subtree.setCode(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
                myroot.getChildren().add(subtree);
            }
                myroot.setCode("Report List Of "+counttotal+" Record");
                
              
            }
            else
            {
                while (rs.next()) {

                    tempbran = rs.getString("keycode");
                    tempbname = rs.getString("keyname");


                    if(!tempbranold.equals(tempbran))
                    {
                        tempdateold = " ";
                        if(subtree != null)
                        {

                            myroot.getChildren().add(subtree);
                            subtree.setCode(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");

                        }

                        subtree = new reportEmpAvgBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportEmpAvgBean( rs.getString("keycode"),
                                                                            rs.getString("no"),
                                                                            rs.getString("dept"),
                                                                            Format.integerFmt.format(rs.getDouble("perqty")),
                                                                            Format.doubleFmt.format(rs.getDouble("totalsale")),
                                                                            Format.doubleFmt.format(rs.getDouble("peramount")),
                                                                            Format.doubleFmt.format(rs.getDouble("peramountday"))
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportEmpAvgBean( rs.getString("keycode"),
                                                                            rs.getString("no"),
                                                                            rs.getString("dept"),
                                                                            Format.integerFmt.format(rs.getDouble("perqty")),
                                                                            Format.doubleFmt.format(rs.getDouble("totalsale")),
                                                                            Format.doubleFmt.format(rs.getDouble("peramount")),
                                                                            Format.doubleFmt.format(rs.getDouble("peramountday"))
                                                                        ));





                    }


                    i++;
                    countgroup++;
                    counttotal++;
                    countdate++;
                    tempbranold = rs.getString("keycode");
                    tempbnameold = rs.getString("keyname");




                }


            if(subtree != null)
            {

                subtree.setCode(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
                myroot.getChildren().add(subtree);
            }
                myroot.setCode("Report List Of "+counttotal+" Record");
                
            }
    }
    
    @Override
	public int getColumnCount() 
	{
		return 6;
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
		reportEmpAvgBean treenode = ( reportEmpAvgBean )node;
		switch( column )
		{
		case 0: return treenode.getCode();
		case 1: return treenode.getNo();
		case 2: return treenode.getDept();
                case 3: return treenode.getPerqty();
                case 4: return treenode.getT1();
                case 5: return treenode.getT2();
                case 6: return treenode.getT3();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportEmpAvgBean treenode = ( reportEmpAvgBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportEmpAvgBean treenode = ( reportEmpAvgBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportEmpAvgBean treenode = ( reportEmpAvgBean )parent;
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
		 reportEmpAvgBean treenode = ( reportEmpAvgBean )node;
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
