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
public class reportVatModel extends AbstractTreeTableModel
{
    private Statement stmt;
    private reportVatBean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();
    
    public reportVatModel(String sql,String code,String name) throws SQLException
    {
            db.dbconnect();
            stmt = null;
            String tempbran = " ";
            String tempbranold = " ";
            String tempdate = "";
            String tempdateold = "";
            String tempbname = "";
            String tempbnameold = "";
            
            double total1 = 0,total2 = 0,total3 = 0,total4 = 0,total5 = 0;
            double totalgroup1 = 0,totalgroup2 = 0,totalgroup3 = 0,totalgroup4 = 0,totalgroup5 = 0;
            
            
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            reportVatBean subtree = null;
            myroot = new reportVatBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
                
                while (rs.next()) {

                    tempbran = rs.getString("TBran");
                    tempbname = cvth.ASCII2Unicode(rs.getString("tbranname"));


                    if(!tempbranold.equals(tempbran))
                    {
                        tempdateold = " ";
                        if(subtree != null)
                        {
                            
                            subtree.getChildren().add(new reportVatBean(tempbranold
                                    ,""
                                    ,"Total Branch "+tempbranold
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup1)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup2)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup3)
                                    ,Format.doubleFmt.format(totalgroup4)
                                    ,Format.doubleFmt.format(totalgroup5)
                         ));
                            
                            myroot.getChildren().add(subtree);
                            totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;totalgroup4 = 0;totalgroup5 = 0;
                            
                            subtree.setCode(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                            
                        }

                        subtree = new reportVatBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportVatBean( cvth.ASCII2Unicode(rs.getString("tbran")),
                                                                            cvth.ASCII2Unicode(rs.getString("tarea")),
                                                                            utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac1")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac1bs")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac1be")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac1amt")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac2")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac2bs")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac2be")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac2amt")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac3")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac3bs")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac3be")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac3amt")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmacamt")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmacv"))
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportVatBean( cvth.ASCII2Unicode(rs.getString("tbran")),
                                                                            cvth.ASCII2Unicode(rs.getString("tarea")),
                                                                            utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac1")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac1bs")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac1be")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac1amt")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac2")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac2bs")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac2be")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac2amt")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac3")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac3bs")),
                                                                            cvth.ASCII2Unicode(rs.getString("tmac3be")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac3amt")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmacamt")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmacv"))
                                                                        ));





                    }
                    totalgroup1 += rs.getDouble("tmac1amt");
                    totalgroup2 += rs.getDouble("tmac2amt");
                    totalgroup3 += rs.getDouble("tmac3amt");
                    totalgroup4 += rs.getDouble("tmacamt");
                    totalgroup5 += rs.getDouble("tmacv");
                    
                    total1 += rs.getDouble("tmac1amt");
                    total2 += rs.getDouble("tmac2amt");
                    total3 += rs.getDouble("tmac3amt");
                    total4 += rs.getDouble("tmacamt");
                    total5 += rs.getDouble("tmacv");

                    i++;
                    countgroup++;
                    counttotal++;
                    countdate++;
                    tempbranold = rs.getString("tbran");
                    tempbnameold = cvth.ASCII2Unicode(rs.getString("tbranname"));


                    

                }


            if(subtree != null)
            {
                 subtree.getChildren().add(new reportVatBean(tempbranold
                                    ,""
                                    ,"Total Branch "+tempbranold
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup1)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup2)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup3)
                                    ,Format.doubleFmt.format(totalgroup4)
                                    ,Format.doubleFmt.format(totalgroup5)
                         ));
                subtree.setCode(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
                myroot.getChildren().add(subtree);
            }
             myroot.getChildren().add(new reportVatBean("Total All "
                                    ,""
                                    ,""
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(total1)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(total2)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(total3)
                                    ,Format.doubleFmt.format(total4)
                                    ,Format.doubleFmt.format(total5)
                         ));
                myroot.setCode("Report List Of "+counttotal+" Record");
                
              
            }
            else
            {
                while (rs.next()) {

                    tempbran = rs.getString("TBran");
                    tempbname = rs.getString("tbranname");


                    if(!tempbranold.equals(tempbran))
                    {
                        tempdateold = " ";
                        if(subtree != null)
                        {
                            
                            subtree.getChildren().add(new reportVatBean(tempbranold
                                    ,""
                                    ,"Total Branch "+tempbranold
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup1)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup2)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup3)
                                    ,Format.doubleFmt.format(totalgroup4)
                                    ,Format.doubleFmt.format(totalgroup5)
                         ));
                            
                            myroot.getChildren().add(subtree);
                            totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;totalgroup4 = 0;totalgroup5 = 0;
                            
                            subtree.setCode(code+" "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                            
                        }

                        subtree = new reportVatBean();
                        countgroup = 0;
                            i=1;

                            subtree.getChildren().add(new reportVatBean( rs.getString("tbran"),
                                                                            rs.getString("tarea"),
                                                                            utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                            rs.getString("tmac1"),
                                                                            rs.getString("tmac1bs"),
                                                                            rs.getString("tmac1be"),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac1amt")),
                                                                            rs.getString("tmac2"),
                                                                            rs.getString("tmac2bs"),
                                                                            rs.getString("tmac2be"),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac2amt")),
                                                                            rs.getString("tmac3"),
                                                                            rs.getString("tmac3bs"),
                                                                            rs.getString("tmac3be"),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac3amt")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmacamt")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmacv"))
                                                                        ));



                    }
                    else
                    {
                        subtree.getChildren().add(new reportVatBean( rs.getString("tbran"),
                                                                            rs.getString("tarea"),
                                                                            utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                            rs.getString("tmac1"),
                                                                            rs.getString("tmac1bs"),
                                                                            rs.getString("tmac1be"),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac1amt")),
                                                                            rs.getString("tmac2"),
                                                                            rs.getString("tmac2bs"),
                                                                            rs.getString("tmac2be"),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac2amt")),
                                                                            rs.getString("tmac3"),
                                                                            rs.getString("tmac3bs"),
                                                                            rs.getString("tmac3be"),
                                                                            Format.doubleFmt.format(rs.getDouble("tmac3amt")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmacamt")),
                                                                            Format.doubleFmt.format(rs.getDouble("tmacv"))
                                                                        ));





                    }
                    totalgroup1 += rs.getDouble("tmac1amt");
                    totalgroup2 += rs.getDouble("tmac2amt");
                    totalgroup3 += rs.getDouble("tmac3amt");
                    totalgroup4 += rs.getDouble("tmacamt");
                    totalgroup5 += rs.getDouble("tmacv");
                    
                    total1 += rs.getDouble("tmac1amt");
                    total2 += rs.getDouble("tmac2amt");
                    total3 += rs.getDouble("tmac3amt");
                    total4 += rs.getDouble("tmacamt");
                    total5 += rs.getDouble("tmacv");

                    i++;
                    countgroup++;
                    counttotal++;
                    countdate++;
                    tempbranold = rs.getString("tbran");
                    tempbnameold = rs.getString("tbranname");


                    

                }


            if(subtree != null)
            {
                 subtree.getChildren().add(new reportVatBean(tempbranold
                                    ,""
                                    ,"Total Branch "+tempbranold
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup1)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup2)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(totalgroup3)
                                    ,Format.doubleFmt.format(totalgroup4)
                                    ,Format.doubleFmt.format(totalgroup5)
                         ));
                subtree.setCode(code+" "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
                myroot.getChildren().add(subtree);
            }
             myroot.getChildren().add(new reportVatBean("Total All "
                                    ,""
                                    ,""
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(total1)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(total2)
                                    ,""
                                    ,""
                                    ,""
                                    ,Format.doubleFmt.format(total3)
                                    ,Format.doubleFmt.format(total4)
                                    ,Format.doubleFmt.format(total5)
                         ));
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
		reportVatBean treenode = ( reportVatBean )node;
		switch( column )
		{
		case 0: return treenode.getCode();
		case 1: return treenode.getArea();
		case 2: return treenode.getDate();
                case 3: return treenode.getM11();
                case 4: return treenode.getM12();
                case 5: return treenode.getM13();
                case 6: return treenode.getM14();
                case 7: return treenode.getM21();
                case 8: return treenode.getM22();
                case 9: return treenode.getM23();
                case 10: return treenode.getM24();
                case 11: return treenode.getM31();
                case 12: return treenode.getM32();
                case 13: return treenode.getM33();
                case 14: return treenode.getM34();
                case 15: return treenode.getT1();
                case 16: return treenode.getT2();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportVatBean treenode = ( reportVatBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportVatBean treenode = ( reportVatBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportVatBean treenode = ( reportVatBean )parent;
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
		 reportVatBean treenode = ( reportVatBean )node;
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
