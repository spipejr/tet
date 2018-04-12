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
public class reportCashModel extends AbstractTreeTableModel 
{
    private Statement stmt;
	private reportCashBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
    
        public reportCashModel(String sql,String code,String name) throws SQLException
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
            myroot = new reportCashBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                   
                        
                        myroot.getChildren().add(new reportCashBean( cvth.ASCII2Unicode(rs.getString("tbran")),
                                                                        cvth.ASCII2Unicode(rs.getString("tbranname")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                        cvth.ASCII2Unicode(rs.getString("tday")),
                                                                        Format.doubleFmt.format(rs.getDouble("temp1")),
                                                                        Format.doubleFmt.format(rs.getDouble("temp2")),
                                                                        Format.doubleFmt.format(rs.getDouble("temp3")),
                                                                        Format.doubleFmt.format(rs.getDouble("temp4"))
                                                                    ));
                        
                    
                  
                
                
//                total[0] += rs.getDouble("bran1");
//                total[1] += rs.getDouble("bran2");
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
            }
//            myroot.getChildren().add(new reportCashBean( "Total All",
//                                                            "",
//                                                            Format.integerFmt.format(total[0]),
//                                                            Format.doubleFmt.format(total[1]),
//                                                            ""
//                                                                    ));
            myroot.setCode("Report List Of "+counttotal+" Record");
            }
            else
            {
                while (rs.next()) {
                   
                        
                        myroot.getChildren().add(new reportCashBean( rs.getString("tbran"),
                                                                        rs.getString("tbranname"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                        rs.getString("tday"),
                                                                        Format.doubleFmt.format(rs.getDouble("temp1")),
                                                                        Format.doubleFmt.format(rs.getDouble("temp2")),
                                                                        Format.doubleFmt.format(rs.getDouble("temp3")),
                                                                        Format.doubleFmt.format(rs.getDouble("temp4"))
                                                                    ));
                        
                    
                  
                
                
//                total[0] += rs.getDouble("bran1");
//                total[1] += rs.getDouble("bran2");
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
            }
//            myroot.getChildren().add(new reportCashBean( "Total All",
//                                                            "",
//                                                            Format.integerFmt.format(total[0]),
//                                                            Format.doubleFmt.format(total[1]),
//                                                            ""
//                                                                    ));
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
		reportCashBean treenode = ( reportCashBean )node;
		switch( column )
		{
		case 0: return treenode.getCode();
		case 1: return treenode.getName();
                case 2: return treenode.getDate();
                case 3: return treenode.getDay();
                case 4: return treenode.getD1();
		case 5: return treenode.getD2();
                case 6: return treenode.getD3();
                case 7: return treenode.getD4();
                default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportCashBean treenode = ( reportCashBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportCashBean treenode = ( reportCashBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportCashBean treenode = ( reportCashBean )parent;
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
		 reportCashBean treenode = ( reportCashBean )node;
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
