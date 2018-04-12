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
public class reportSumRjfileModel extends AbstractTreeTableModel
{
    private Statement stmt;
    private reportSumRjfileBean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();
    
    public reportSumRjfileModel(String sql,String code,String name) throws SQLException
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
            reportSumRjfileBean subtree = null;
            myroot = new reportSumRjfileBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
                if(!code.equals("rjline"))
                {
                while (rs.next()) {

                    tempbran = rs.getString(code);
                    tempbname = cvth.ASCII2Unicode(rs.getString(name));


                    if(!tempbranold.equals(tempbran))
                    {
                        tempdateold = " ";
                        if(subtree != null)
                        {

                            myroot.getChildren().add(subtree);
                            subtree.setS_bran(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");

                        }

                        subtree = new reportSumRjfileBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportSumRjfileBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                            cvth.ASCII2Unicode(rs.getString("rjno")),
                                                                            cvth.ASCII2Unicode(rs.getString("dept")),
                                                                            cvth.ASCII2Unicode(rs.getString("account")),
                                                                            cvth.ASCII2Unicode(rs.getString("sub")),
                                                                            cvth.ASCII2Unicode(rs.getString("descname")),
                                                                            Format.doubleFmt.format(rs.getDouble("mac1")),
                                                                            Format.doubleFmt.format(rs.getDouble("mac2")),
                                                                            Format.doubleFmt.format(rs.getDouble("mac3")),
                                                                            Format.doubleFmt.format(rs.getDouble("total"))
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportSumRjfileBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                            cvth.ASCII2Unicode(rs.getString("rjno")),
                                                                            cvth.ASCII2Unicode(rs.getString("dept")),
                                                                            cvth.ASCII2Unicode(rs.getString("account")),
                                                                            cvth.ASCII2Unicode(rs.getString("sub")),
                                                                            cvth.ASCII2Unicode(rs.getString("descname")),
                                                                            Format.doubleFmt.format(rs.getDouble("mac1")),
                                                                            Format.doubleFmt.format(rs.getDouble("mac2")),
                                                                            Format.doubleFmt.format(rs.getDouble("mac3")),
                                                                            Format.doubleFmt.format(rs.getDouble("total"))
                                                                        ));





                    }


                    i++;
                    countgroup++;
                    counttotal++;
                    countdate++;
                    tempbranold = rs.getString(code);
                    tempbnameold = cvth.ASCII2Unicode(rs.getString(name));




                }


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
                
                
                    myroot.getChildren().add(new reportSumRjfileBean( cvth.ASCII2Unicode(rs.getString(code)),
                                                                        cvth.ASCII2Unicode(rs.getString("rjno")),
                                                                        cvth.ASCII2Unicode(rs.getString("dept")),
                                                                        cvth.ASCII2Unicode(rs.getString("account")),
                                                                        cvth.ASCII2Unicode(rs.getString("sub")),
                                                                        cvth.ASCII2Unicode(rs.getString("descname")),
                                                                        Format.doubleFmt.format(rs.getDouble("mac1")),
                                                                        Format.doubleFmt.format(rs.getDouble("mac2")),
                                                                        Format.doubleFmt.format(rs.getDouble("mac3")),
                                                                        Format.doubleFmt.format(rs.getDouble("total"))
                                                                    ));
                        
                    
                    
               
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
                
            }
           
           
            myroot.setS_bran("Report List Of "+counttotal+" Record");
                }
            }
            else
            {
                if(!code.equals("rjline"))
                {
                while (rs.next()) {

                    tempbran = rs.getString(code);
                    tempbname = rs.getString(name);


                    if(!tempbranold.equals(tempbran))
                    {
                        tempdateold = " ";
                        if(subtree != null)
                        {

                            myroot.getChildren().add(subtree);
                            subtree.setS_bran(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");

                        }

                        subtree = new reportSumRjfileBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportSumRjfileBean( rs.getString(code),
                                                                            rs.getString("rjno"),
                                                                            rs.getString("dept"),
                                                                            rs.getString("account"),
                                                                            rs.getString("sub"),
                                                                            rs.getString("descname"),
                                                                            Format.doubleFmt.format(rs.getDouble("mac1")),
                                                                            Format.doubleFmt.format(rs.getDouble("mac2")),
                                                                            Format.doubleFmt.format(rs.getDouble("mac3")),
                                                                            Format.doubleFmt.format(rs.getDouble("total"))
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportSumRjfileBean( rs.getString(code),
                                                                            rs.getString("rjno"),
                                                                            rs.getString("dept"),
                                                                            rs.getString("account"),
                                                                            rs.getString("sub"),
                                                                            rs.getString("descname"),
                                                                            Format.doubleFmt.format(rs.getDouble("mac1")),
                                                                            Format.doubleFmt.format(rs.getDouble("mac2")),
                                                                            Format.doubleFmt.format(rs.getDouble("mac3")),
                                                                            Format.doubleFmt.format(rs.getDouble("total"))
                                                                        ));





                    }


                    i++;
                    countgroup++;
                    counttotal++;
                    countdate++;
                    tempbranold = rs.getString(code);
                    tempbnameold = rs.getString(name);




                }


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
                
                
                    myroot.getChildren().add(new reportSumRjfileBean( rs.getString(code),
                                                                        rs.getString("rjno"),
                                                                        rs.getString("dept"),
                                                                        rs.getString("account"),
                                                                        rs.getString("sub"),
                                                                        rs.getString("descname"),
                                                                        Format.doubleFmt.format(rs.getDouble("mac1")),
                                                                        Format.doubleFmt.format(rs.getDouble("mac2")),
                                                                        Format.doubleFmt.format(rs.getDouble("mac3")),
                                                                        Format.doubleFmt.format(rs.getDouble("total"))
                                                                    ));
                        
                    
                    
               
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
                
            }
           
           
            myroot.setS_bran("Report List Of "+counttotal+" Record");
                }
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
		reportSumRjfileBean treenode = ( reportSumRjfileBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
		case 1: return treenode.getNo();
		case 2: return treenode.getDept();
                case 3: return treenode.getAccno();
                case 4: return treenode.getSubacc();
                case 5: return treenode.getDesc();
                case 6: return treenode.getMac1();
		case 7: return treenode.getMac2();
		case 8: return treenode.getMac3();
                case 9: return treenode.getTotal();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportSumRjfileBean treenode = ( reportSumRjfileBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportSumRjfileBean treenode = ( reportSumRjfileBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportSumRjfileBean treenode = ( reportSumRjfileBean )parent;
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
		 reportSumRjfileBean treenode = ( reportSumRjfileBean )node;
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
