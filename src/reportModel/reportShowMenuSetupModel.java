/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModel;

import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.Format;
import utilititiesfunction.PUtility;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class reportShowMenuSetupModel extends AbstractTreeTableModel
{
    private Statement stmt;
	private reportShowMenuSetupBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        
        public reportShowMenuSetupModel(String sql) throws SQLException
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
            reportShowMenuSetupBean subtree = null;
            myroot = new reportShowMenuSetupBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
                double cost = 0;
                double gp = 0;
                while (rs.next()) {

                    tempbran = cvth.ASCII2Unicode(rs.getString("code"));
                    tempbname = cvth.ASCII2Unicode(rs.getString("name"));

            cost = getCost(rs.getString("code"), rs.getString("menucode"));
            
            if(rs.getDouble("pprice11")>0)
            {
                gp = (cost/rs.getDouble("pprice11"));
            }
            else
            {
                gp = 0;
            }
            
                    if(!tempbranold.equals(tempbran))
                    {
                        tempdateold = " ";
                        if(subtree != null)
                        {

                            myroot.getChildren().add(subtree);
                            subtree.setNo("Ingredients"+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");

                        }

                        subtree = new reportShowMenuSetupBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportShowMenuSetupBean( i+"",
                                                                            cvth.ASCII2Unicode(rs.getString("incode")),
                                                                            cvth.ASCII2Unicode(rs.getString("menucode")),
                                                                            cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                            Format.integerFmt.format(rs.getInt("inqty")),
                                                                            cvth.ASCII2Unicode(rs.getString("insubunit")),
                                                                            Format.doubleFmt.format(cost),
                                                                            Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                                            Format.percentFmt.format(gp)
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportShowMenuSetupBean( i+"",
                                                                            cvth.ASCII2Unicode(rs.getString("incode")),
                                                                            cvth.ASCII2Unicode(rs.getString("menucode")),
                                                                            cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                            Format.integerFmt.format(rs.getInt("inqty")),
                                                                            cvth.ASCII2Unicode(rs.getString("insubunit")),
                                                                            Format.doubleFmt.format(cost),
                                                                            Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                                            Format.percentFmt.format(gp)
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

                subtree.setNo("Ingredients"+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
                myroot.getChildren().add(subtree);
            }
                myroot.setNo("Report List Of "+counttotal+" Record");
                
                
            }
            else
            {
                 
            }
    }
        
    public double getCost(String ingCode, String menucode) {

        double Cost = 0;
        double Pack = 0;
        double ans = 0;
        double Qty=0;
try {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                String sql = "select * from ingredent i inner join menusetup m on i.incode = m.incode where i.InCode='" + ingCode + "' and menucode ='"+menucode+"'";
                stmt = (Statement) dbUtility.con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                       
                        
                        Cost = Double.valueOf(rs.getString("InCost"));
                        Pack = Double.valueOf(rs.getString("InPack"));
                        Qty = Double.valueOf(rs.getString("Inqty"));
                        
                       ans = (Cost*Qty)/Pack;
                       
                } 
                rs.close();
                stmt.close();
                
                 }
                 else
                 {
                String sql = "select * from ingredent i inner join menusetup m on i.incode = m.incode where i.InCode='" + ingCode + "' and menucode ='"+menucode+"'";

                stmt = (Statement) dbUtility.con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                       
                        Cost = Double.valueOf(rs.getString("InCost"));
                        Pack = Double.valueOf(rs.getString("InPack"));
                        Qty = Double.valueOf(rs.getString("Inqty"));
                        
                        
                       ans = (Cost*Qty)/Pack;
                       
                } 
                rs.close();
                stmt.close();
                 }
            } catch (Exception e) {
            }
       return ans;
    }
    
    @Override
	public int getColumnCount() 
	{
		return 9;
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
		reportShowMenuSetupBean treenode = ( reportShowMenuSetupBean )node;
		switch( column )
		{
                case 0: return treenode.getNo();
		case 1: return treenode.getIng();
		case 2: return treenode.getPcode();
		case 3: return treenode.getName();
                case 4: return treenode.getQty();
                case 5: return treenode.getUnit();
                case 6: return treenode.getCost();
                case 7: return treenode.getPrice();
		case 8: return treenode.getPercent();
                
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportShowMenuSetupBean treenode = ( reportShowMenuSetupBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportShowMenuSetupBean treenode = ( reportShowMenuSetupBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportShowMenuSetupBean treenode = ( reportShowMenuSetupBean )parent;
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
		 reportShowMenuSetupBean treenode = ( reportShowMenuSetupBean )node;
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
