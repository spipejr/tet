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
public class reportTopSaleByQtyModel extends AbstractTreeTableModel
{
    private Statement stmt;
	private reportTopSaleByQtyBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportTopSaleByQtyModel(String sql,String code,String name,int top) throws SQLException
    {
            db.dbconnect();
            stmt = null;
            String tempbran = " ";
            String tempbranold = " ";
            String tempdept = "";
            String tempdeptold = "";
            String tempbname = "";
            String tempbnameold = "";
            Date d_tempdate =null;
            Date d_tempdateold = null;
            
            
            
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            reportTopSaleByQtyBean subtree = null;
            reportTopSaleByQtyBean datetree = null;
            myroot = new reportTopSaleByQtyBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                
                
                tempbran = rs.getString(code);
                tempdept = rs.getString("PGroupCode");
                tempbname = cvth.ASCII2Unicode(rs.getString(name));
                if(!tempbranold.equals(tempbran))
                {
                    tempdeptold = "";
                    if(subtree != null)
                    {
                        
                      
                        myroot.getChildren().add(subtree);
                        subtree.setS_bran(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        
                    }
                    
                    subtree = new reportTopSaleByQtyBean();
                    countgroup = 0;
                    if(!tempdeptold.equals(tempdept))
                    {
                        i=1;
                        
                        
                        datetree = new reportTopSaleByQtyBean("DEPT : "+cvth.ASCII2Unicode(rs.getString("PGroupName")),"","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        
                        datetree.getChildren().add(new reportTopSaleByQtyBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        i+"",
                                                                        cvth.ASCII2Unicode(rs.getString("s_pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_price")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        
                    }
                    else
                    {
                        if(i<=top)
                        {
                        datetree.getChildren().add(new reportTopSaleByQtyBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        i+"",
                                                                        cvth.ASCII2Unicode(rs.getString("s_pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_price")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        }
                    }
                    
                }
                else
                {
                    if(!tempdeptold.equals(tempdept))
                    {
                        i=1;
                        
                        
                       datetree = new reportTopSaleByQtyBean("DEPT : "+cvth.ASCII2Unicode(rs.getString("PGroupName")),"","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        
                        datetree.getChildren().add(new reportTopSaleByQtyBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        i+"",
                                                                        cvth.ASCII2Unicode(rs.getString("s_pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_price")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        
                    }
                    else
                    {
                        if(i<=top)
                        {
                        datetree.getChildren().add(new reportTopSaleByQtyBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        i+"",
                                                                        cvth.ASCII2Unicode(rs.getString("s_pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_price")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        }
                    }
                    
                    
                }
                
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString(code);
                tempdeptold = rs.getString("pgroupcode");
                tempbnameold = cvth.ASCII2Unicode(rs.getString(name));
                
                
                
            }
//            
           
            
           if(subtree != null)
           {
            
            subtree.setS_bran(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            
            
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
            else
            {
              while (rs.next()) {
                
                
                
                tempbran = rs.getString(code);
                tempdept = rs.getString("PGroupCode");
                tempbname = rs.getString(name);
                if(!tempbranold.equals(tempbran))
                {
                    tempdeptold = "";
                    if(subtree != null)
                    {
                        
                      
                        myroot.getChildren().add(subtree);
                        subtree.setS_bran(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        
                    }
                    
                    subtree = new reportTopSaleByQtyBean();
                    countgroup = 0;
                    if(!tempdeptold.equals(tempdept))
                    {
                        i=1;
                        
                        
                        datetree = new reportTopSaleByQtyBean("DEPT : "+rs.getString("PGroupName"),"","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        
                        datetree.getChildren().add(new reportTopSaleByQtyBean( rs.getString(code),
                                                                        rs.getString("pgroup"),
                                                                        i+"",
                                                                        rs.getString("s_pcode"),
                                                                        rs.getString("pdesc"),
                                                                        Format.doubleFmt.format(rs.getDouble("s_price")),
                                                                        rs.getString("punit1"),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        
                    }
                    else
                    {
                        if(i<=top)
                        {
                        datetree.getChildren().add(new reportTopSaleByQtyBean( rs.getString(code),
                                                                        rs.getString("pgroup"),
                                                                        i+"",
                                                                        rs.getString("s_pcode"),
                                                                        rs.getString("pdesc"),
                                                                        Format.doubleFmt.format(rs.getDouble("s_price")),
                                                                        rs.getString("punit1"),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        }
                    }
                    
                }
                else
                {
                    if(!tempdeptold.equals(tempdept))
                    {
                        i=1;
                        
                        
                       datetree = new reportTopSaleByQtyBean("DEPT : "+rs.getString("PGroupName"),"","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        
                        datetree.getChildren().add(new reportTopSaleByQtyBean( rs.getString(code),
                                                                        rs.getString("pgroup"),
                                                                        i+"",
                                                                        rs.getString("s_pcode"),
                                                                        rs.getString("pdesc"),
                                                                        Format.doubleFmt.format(rs.getDouble("s_price")),
                                                                        rs.getString("punit1"),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        
                    }
                    else
                    {
                        if(i<=top)
                        {
                        datetree.getChildren().add(new reportTopSaleByQtyBean( rs.getString(code),
                                                                        rs.getString("pgroup"),
                                                                        i+"",
                                                                        rs.getString("s_pcode"),
                                                                        rs.getString("pdesc"),
                                                                        Format.doubleFmt.format(rs.getDouble("s_price")),
                                                                        rs.getString("punit1"),
                                                                        Format.integerFmt.format(rs.getInt("sumqty")),
                                                                        Format.doubleFmt.format(rs.getDouble("sumamt"))
                                                                        
                                                                    ));
                        }
                    }
                    
                    
                }
                
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString(code);
                tempdeptold = rs.getString("pgroupcode");
                tempbnameold = rs.getString(name);
                
                
                
            }
//            
           
            
           if(subtree != null)
           {
            
            subtree.setS_bran(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            
            
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
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
		reportTopSaleByQtyBean treenode = ( reportTopSaleByQtyBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
		case 1: return treenode.getS_dept();
                case 2: return treenode.getNo();    
		case 3: return treenode.getS_pcode();
                case 4: return treenode.getPname();
                case 5: return treenode.getPprice();
                case 6: return treenode.getPunit();
                case 7: return treenode.getSumqty();
                case 8: return treenode.getSumamt();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportTopSaleByQtyBean treenode = ( reportTopSaleByQtyBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportTopSaleByQtyBean treenode = ( reportTopSaleByQtyBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportTopSaleByQtyBean treenode = ( reportTopSaleByQtyBean )parent;
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
		 reportTopSaleByQtyBean treenode = ( reportTopSaleByQtyBean )node;
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
