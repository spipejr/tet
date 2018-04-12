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
public class reportPlacAvgModel extends AbstractTreeTableModel 
{
    private Statement stmt;
	private reportPlaceAvgBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
    
        public reportPlacAvgModel(String sql,String code,String name) throws SQLException
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
            myroot = new reportPlaceAvgBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                   
                        
                        myroot.getChildren().add(new reportPlaceAvgBean( cvth.ASCII2Unicode(rs.getString("tgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("tname")),
                                                                        cvth.ASCII2Unicode(rs.getString("tbran")),
                                                                        cvth.ASCII2Unicode(rs.getString("tbranname")),
                                                                        Format.integerFmt.format(rs.getDouble("bran1")),
                                                                        Format.integerFmt.format(rs.getDouble("bran2")),
                                                                        Format.integerFmt.format(rs.getDouble("bran3")),
                                                                        Format.integerFmt.format(rs.getDouble("bran4")),
                                                                        Format.integerFmt.format(rs.getDouble("bran5")),
                                                                        Format.integerFmt.format(rs.getDouble("bran6")),
                                                                        Format.integerFmt.format(rs.getDouble("bran7")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran8")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran9"))
                                                                    ));
                        
                    
                  
                
                
                total[0] += rs.getDouble("bran1");
                total[1] += rs.getDouble("bran2");
                total[2] += rs.getDouble("bran3");
                total[3] += rs.getDouble("bran4");
                total[4] += rs.getDouble("bran5");
                total[5] += rs.getDouble("bran6");
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
            }
            myroot.getChildren().add(new reportPlaceAvgBean( "Total All",
                                                            "",
                                                            "",
                                                            "",
                                                            Format.integerFmt.format(total[0]),
                                                            Format.integerFmt.format(total[1]),
                                                            Format.integerFmt.format(total[2]),
                                                            Format.integerFmt.format(total[3]),
                                                            Format.integerFmt.format(total[4]),
                                                            Format.integerFmt.format(total[5]),
                                                            "",
                                                            "",
                                                            ""
                                                                    ));
            myroot.setCode("Report List Of "+counttotal+" Record");
            }
            else
            {
                while (rs.next()) {
                   
                        
                        myroot.getChildren().add(new reportPlaceAvgBean( rs.getString("tgroup"),
                                                                        rs.getString("tname"),
                                                                        rs.getString("tbran"),
                                                                        rs.getString("tbranname"),
                                                                        Format.integerFmt.format(rs.getDouble("bran1")),
                                                                        Format.integerFmt.format(rs.getDouble("bran2")),
                                                                        Format.integerFmt.format(rs.getDouble("bran3")),
                                                                        Format.integerFmt.format(rs.getDouble("bran4")),
                                                                        Format.integerFmt.format(rs.getDouble("bran5")),
                                                                        Format.integerFmt.format(rs.getDouble("bran6")),
                                                                        Format.integerFmt.format(rs.getDouble("bran7")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran8")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran9"))
                                                                    ));
                        
                    
                  
                
                
                total[0] += rs.getDouble("bran1");
                total[1] += rs.getDouble("bran2");
                total[2] += rs.getDouble("bran3");
                total[3] += rs.getDouble("bran4");
                total[4] += rs.getDouble("bran5");
                total[5] += rs.getDouble("bran6");
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
            }
            myroot.getChildren().add(new reportPlaceAvgBean( "Total All",
                                                            "",
                                                            "",
                                                            "",
                                                            Format.integerFmt.format(total[0]),
                                                            Format.integerFmt.format(total[1]),
                                                            Format.integerFmt.format(total[2]),
                                                            Format.integerFmt.format(total[3]),
                                                            Format.integerFmt.format(total[4]),
                                                            Format.integerFmt.format(total[5]),
                                                            "",
                                                            "",
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
		reportPlaceAvgBean treenode = ( reportPlaceAvgBean )node;
		switch( column )
		{
		case 0: return treenode.getCode();
		case 1: return treenode.getName();
		case 2: return treenode.getBranch();
                case 3: return treenode.getBranchname();
                case 4: return treenode.getB1();
                case 5: return treenode.getB2();
                case 6: return treenode.getB3();
                case 7: return treenode.getB4();
                case 8: return treenode.getB5();
                case 9: return treenode.getB6();
		case 10: return treenode.getB7();
		case 11: return treenode.getB8();
                case 12: return treenode.getB9();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportPlaceAvgBean treenode = ( reportPlaceAvgBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportPlaceAvgBean treenode = ( reportPlaceAvgBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportPlaceAvgBean treenode = ( reportPlaceAvgBean )parent;
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
		 reportPlaceAvgBean treenode = ( reportPlaceAvgBean )node;
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
