/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModel;

import borfunction.BORUtilities;
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
public class reportSumCuponModel extends AbstractTreeTableModel 
{
    private Statement stmt;
	private reportSumCuponBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportSumCuponModel(String sql,String code,String name) throws SQLException
    {
            db.dbconnect();
            stmt = null;
            double total[] = new double[36];
            for (int ct = 0 ; ct < total.length; ct++)
            {
                total[ct] = 0;
            }
            
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            myroot = new reportSumCuponBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                   
                        if(!code.equals("null"))
                        {
                        myroot.getChildren().add(new reportSumCuponBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                        cvth.ASCII2Unicode(rs.getString(name)),
                                                                        cvth.ASCII2Unicode(rs.getString("cucode")),
                                                                        cvth.ASCII2Unicode(rs.getString("cuname")),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        
                        }
                        else
                        {
                        myroot.getChildren().add(new reportSumCuponBean( "",
                                                                        "",
                                                                        cvth.ASCII2Unicode(rs.getString("cucode")),
                                                                        cvth.ASCII2Unicode(rs.getString("cuname")),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        }
                    
                  
                
                
                total[0] += rs.getDouble("sumqty");
                total[1] += rs.getDouble("sumamt");
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
            }
            myroot.getChildren().add(new reportSumCuponBean( "Total All",
                                                            "",
                                                            "",
                                                            "",
                                                            Format.doubleFmt.format(total[0]),
                                                            Format.doubleFmt.format(total[1])
                                                            
                                                                    ));
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
            else
            {
                while (rs.next()) {
                   
                        if(!code.equals("null"))
                        {
                        myroot.getChildren().add(new reportSumCuponBean( rs.getString(code),
                                                                        rs.getString(name),
                                                                        rs.getString("cucode"),
                                                                        rs.getString("cuname"),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        
                        }
                        else
                        {
                        myroot.getChildren().add(new reportSumCuponBean( "",
                                                                        "",
                                                                        rs.getString("cucode"),
                                                                        rs.getString("cuname"),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        }
                    
                  
                
                
                total[0] += rs.getDouble("sumqty");
                total[1] += rs.getDouble("sumamt");
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
            }
            myroot.getChildren().add(new reportSumCuponBean( "Total All",
                                                            "",
                                                            "",
                                                            "",
                                                            Format.doubleFmt.format(total[0]),
                                                            Format.doubleFmt.format(total[1])
                                                            
                                                                    ));
            myroot.setS_bran("Report List Of "+counttotal+" Record");
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
		reportSumCuponBean treenode = ( reportSumCuponBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
		case 1: return treenode.getBranname();
		case 2: return treenode.getCucode();
                case 3: return treenode.getCuname();
                case 4: return treenode.getSumqty();
                case 5: return treenode.getSumamt();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportSumCuponBean treenode = ( reportSumCuponBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportSumCuponBean treenode = ( reportSumCuponBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportSumCuponBean treenode = ( reportSumCuponBean )parent;
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
		 reportSumCuponBean treenode = ( reportSumCuponBean )node;
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
