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
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class reportEffectiveModel extends AbstractTreeTableModel
{
    private Statement stmt;
	private reportEffectiveBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
    
    public reportEffectiveModel(String sql) throws SQLException
    {
        db.dbconnect();
            stmt = null;
            String tempbran = "";
            String tempbranold = "";
            String tempdate = "";
            String tempdateold = "";
            String tempbname = "";
            String tempbnameold = "";
            Date d_tempdate =null;
            Date d_tempdateold = null;
            double total1 = 0;
            double totalgroup1 = 0;
            
            double[] totaldate = {0};
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            reportEffectiveBean subtree = null;
            reportEffectiveBean datetree = null;
            myroot = new reportEffectiveBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                d_tempdate = rs.getDate("eff_date");
                tempbran = rs.getString("bcode");
                tempdate = rs.getString("eff_date");
                tempbname = cvth.ASCII2Unicode(rs.getString("bname"));
                if(!tempdateold.equals(tempdate))
                {
                    tempbranold = "";
                    if(datetree != null)
                    {
                       
                        myroot.getChildren().add(datetree);
                        totalgroup1 = 0;
                        datetree.setS_bran("Effective "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold)+" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    datetree = new reportEffectiveBean();
                    countgroup = 0;
                    if(!tempbranold.equals(tempbran))
                    {
                        i=1;
                        
                        
                        subtree = new reportEffectiveBean("Branch "+tempbran+" "+tempbname +"","","","","","","","","","","","" );
                        datetree.getChildren().add(subtree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        subtree.getChildren().add(new reportEffectiveBean( cvth.ASCII2Unicode(rs.getString("bcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("price1")),
                                                                        Format.doubleFmt.format(rs.getDouble("price2")),
                                                                        Format.doubleFmt.format(rs.getDouble("price3")),
                                                                        Format.doubleFmt.format(rs.getDouble("price4")),
                                                                        Format.doubleFmt.format(rs.getDouble("price5")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion1")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion2")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion3")),
                                                                        cvth.ASCII2Unicode(rs.getString("flage"))
                                                                    ));
                        countdate = 0;
                    }
                    else
                    {
                        
                       subtree.getChildren().add(new reportEffectiveBean( cvth.ASCII2Unicode(rs.getString("bcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("price1")),
                                                                        Format.doubleFmt.format(rs.getDouble("price2")),
                                                                        Format.doubleFmt.format(rs.getDouble("price3")),
                                                                        Format.doubleFmt.format(rs.getDouble("price4")),
                                                                        Format.doubleFmt.format(rs.getDouble("price5")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion1")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion2")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion3")),
                                                                        cvth.ASCII2Unicode(rs.getString("flage"))
                                                                    ));
                    
                    }
                    
                }
                else
                {
                    if(!tempbranold.equals(tempbran))
                    {
                        i=1;
                        
                        
                        subtree = new reportEffectiveBean("Branch "+tempbran+" "+tempbname +"","","","","","","","","","","","" );
                        datetree.getChildren().add(subtree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        subtree.getChildren().add(new reportEffectiveBean( cvth.ASCII2Unicode(rs.getString("bcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("price1")),
                                                                        Format.doubleFmt.format(rs.getDouble("price2")),
                                                                        Format.doubleFmt.format(rs.getDouble("price3")),
                                                                        Format.doubleFmt.format(rs.getDouble("price4")),
                                                                        Format.doubleFmt.format(rs.getDouble("price5")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion1")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion2")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion3")),
                                                                        cvth.ASCII2Unicode(rs.getString("flage"))
                                                                    ));
                        countdate = 0;
                    }
                    else
                    {
                        
                       subtree.getChildren().add(new reportEffectiveBean( cvth.ASCII2Unicode(rs.getString("bcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("price1")),
                                                                        Format.doubleFmt.format(rs.getDouble("price2")),
                                                                        Format.doubleFmt.format(rs.getDouble("price3")),
                                                                        Format.doubleFmt.format(rs.getDouble("price4")),
                                                                        Format.doubleFmt.format(rs.getDouble("price5")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion1")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion2")),
                                                                        cvth.ASCII2Unicode(rs.getString("promotion3")),
                                                                        cvth.ASCII2Unicode(rs.getString("flage"))
                                                                    ));
                    
                    }
                    
                    
                }
                
                
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("bcode");
                tempdateold = rs.getString("eff_date");
                tempbnameold = cvth.ASCII2Unicode(rs.getString("bname"));
                d_tempdateold = rs.getDate("eff_date");
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(datetree != null)
           {
           
            datetree.setS_bran("Effective "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold)+" Total "+countgroup+" Record");
            myroot.getChildren().add(datetree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
            else
            {
               
            }
    }
        
        
    @Override
	public int getColumnCount() 
	{
		return 12;
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
		reportEffectiveBean treenode = ( reportEffectiveBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
		case 1: return treenode.getCode();
		case 2: return treenode.getName();
                case 3: return treenode.getPrice1();
                case 4: return treenode.getPrice2();
                case 5: return treenode.getPrice3();
                case 6: return treenode.getPrice4();
		case 7: return treenode.getPrice5();
		case 8: return treenode.getPro1();
                case 9: return treenode.getPro2();
                case 10: return treenode.getPro3();
                case 11: return treenode.getFlage();    
                
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportEffectiveBean treenode = ( reportEffectiveBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportEffectiveBean treenode = ( reportEffectiveBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportEffectiveBean treenode = ( reportEffectiveBean )parent;
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
		 reportEffectiveBean treenode = ( reportEffectiveBean )node;
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
