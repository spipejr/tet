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
public class reportCustAvgModel extends AbstractTreeTableModel 
{
    private Statement stmt;
	private reportCustAvgBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
    
        public reportCustAvgModel(String sql,String code,String name) throws SQLException
    {
            db.dbconnect();
            stmt = null;
            double total[] = new double[9];
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
            myroot = new reportCustAvgBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                   
                        
                        myroot.getChildren().add(new reportCustAvgBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("tname")),
                                                                        Format.integerFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran3"))
                                                                    ));
                        
                    
                  
                
                
                total[0] += rs.getDouble("bran1");
                total[1] += rs.getDouble("bran2");
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
            }
            myroot.getChildren().add(new reportCustAvgBean( "Total All",
                                                            "",
                                                            Format.integerFmt.format(total[0]),
                                                            Format.doubleFmt.format(total[1]),
                                                            ""
                                                                    ));
            myroot.setCode("Report List Of "+counttotal+" Record");
            }
            else
            {
                while (rs.next()) {
                   
                        
                        myroot.getChildren().add(new reportCustAvgBean( rs.getString("tgroup"),
                                                                        rs.getString("tname"),
                                                                        Format.integerFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran3"))
                                                                    ));
                        
                    
                  
                
                
                total[0] += rs.getDouble("bran1");
                total[1] += rs.getDouble("bran2");
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
            }
            myroot.getChildren().add(new reportCustAvgBean( "Total All",
                                                            "",
                                                            Format.integerFmt.format(total[0]),
                                                            Format.doubleFmt.format(total[1]),
                                                            ""
                                                                    ));
            myroot.setCode("Report List Of "+counttotal+" Record");
            }
    }
        
        @Override
	public int getColumnCount() 
	{
		return 51;
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
		reportCustAvgBean treenode = ( reportCustAvgBean )node;
		switch( column )
		{
		case 0: return treenode.getCode();
		case 1: return treenode.getName();
                case 2: return treenode.getB1();
                case 3: return treenode.getB2();
                case 4: return treenode.getB3();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportCustAvgBean treenode = ( reportCustAvgBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportCustAvgBean treenode = ( reportCustAvgBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportCustAvgBean treenode = ( reportCustAvgBean )parent;
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
		 reportCustAvgBean treenode = ( reportCustAvgBean )node;
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
