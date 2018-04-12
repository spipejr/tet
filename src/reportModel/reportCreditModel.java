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

public class reportCreditModel extends AbstractTreeTableModel
{
    private Statement stmt;
	private reportCreditBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportCreditModel(String sql) throws SQLException
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
            reportCreditBean subtree = null;
            reportCreditBean datetree = null;
            myroot = new reportCreditBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                d_tempdate = rs.getDate("s_date");
                tempbran = rs.getString("s_bran");
                tempdate = rs.getString("s_date");
                tempbname = cvth.ASCII2Unicode(rs.getString("name"));
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = "";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new reportCreditBean(tempbranold,"","","Total Branch "
                    ,Format.doubleFmt.format(totalgroup1),"",""
                    ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;
                        subtree.setS_bran("Branch "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportCreditBean();
                    countgroup = 0;
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
                        if(datetree!=null)
                        {
                            datetree.getChildren().add(new reportCreditBean(tempbranold,"","","Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold)
                            ,Format.doubleFmt.format(totaldate[0])
                            ,"",""
                            ));
                            
                            for(int j = 0; j < totaldate.length; j++)
                            {
                                totaldate[j] = 0;
                            }
                        }
                        
                        datetree = new reportCreditBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportCreditBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("crcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("crname")),
                                                                        Format.doubleFmt.format(rs.getDouble("cramt")),
                                                                        cvth.ASCII2Unicode(rs.getString("cracc")),
                                                                        cvth.ASCII2Unicode(rs.getString("CrId"))
                                                                    ));
                        
                    }
                    else
                    {
                        
                        datetree.getChildren().add(new reportCreditBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("crcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("crname")),
                                                                        Format.doubleFmt.format(rs.getDouble("cramt")),
                                                                        cvth.ASCII2Unicode(rs.getString("cracc")),
                                                                        cvth.ASCII2Unicode(rs.getString("CrId"))
                                                                    ));
                    
                    }
                    
                }
                else
                {
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
                        if(datetree!=null)
                        {
                            datetree.getChildren().add(new reportCreditBean(tempbranold,"","","Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold)
                            ,Format.doubleFmt.format(totaldate[0])
                            ,"",""
                            ));
                            
                        for(int j = 0; j < totaldate.length; j++)
                            {
                                totaldate[j] = 0;
                            }
                        }
                        
                        datetree = new reportCreditBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","");
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                         datetree.getChildren().add(new reportCreditBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("crcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("crname")),
                                                                        Format.doubleFmt.format(rs.getDouble("cramt")),
                                                                        cvth.ASCII2Unicode(rs.getString("cracc")),
                                                                        cvth.ASCII2Unicode(rs.getString("CrId"))
                                                                    ));
                        
                    }
                    else
                    {
                        
                         datetree.getChildren().add(new reportCreditBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("crcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("crname")),
                                                                        Format.doubleFmt.format(rs.getDouble("cramt")),
                                                                        cvth.ASCII2Unicode(rs.getString("cracc")),
                                                                        cvth.ASCII2Unicode(rs.getString("CrId"))
                                                                    ));
                    
                    }
                    
                    
                }
                
                totalgroup1 += rs.getDouble("cramt");
                
                
                totaldate[0] += rs.getDouble("cramt");
                
                
                total1 += rs.getDouble("cramt");
                
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("s_bran");
                tempdateold = rs.getString("s_date");
                tempbnameold = cvth.ASCII2Unicode(rs.getString("name"));
                d_tempdateold = rs.getDate("s_date");
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           if(datetree!=null)
                        {
                            datetree.getChildren().add(new reportCreditBean(tempbran,"","","Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdate)
                            ,Format.doubleFmt.format(totaldate[0])
                            ,"",""
                            ));
                        }
            
           if(subtree != null)
           {
            subtree.getChildren().add(new reportCreditBean(tempbran,"","","Total Branch "
                    ,Format.doubleFmt.format(totalgroup1),"",""
                    ));
            subtree.setS_bran("Branch "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            myroot.getChildren().add(new reportCreditBean("Total All","","","",Format.doubleFmt.format(total1),"",""
                     ));
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
            else
            {
               while (rs.next()) {
                
                d_tempdate = rs.getDate("s_date");
                tempbran = rs.getString("s_bran");
                tempdate = rs.getString("s_date");
                tempbname = rs.getString("name");
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = "";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new reportCreditBean(tempbranold,"","","Total Branch "
                    ,Format.doubleFmt.format(totalgroup1),"",""
                    ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;
                        subtree.setS_bran("Branch "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportCreditBean();
                    countgroup = 0;
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
                        if(datetree!=null)
                        {
                            datetree.getChildren().add(new reportCreditBean(tempbranold,"","","Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold)
                            ,Format.doubleFmt.format(totaldate[0])
                            ,"",""
                            ));
                            
                            for(int j = 0; j < totaldate.length; j++)
                            {
                                totaldate[j] = 0;
                            }
                        }
                        
                        datetree = new reportCreditBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",rs.getString("s_pcode")),rs.getString("pdesc")),rs.getString("pprice11")),rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportCreditBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("crcode"),
                                                                        rs.getString("crname"),
                                                                        Format.doubleFmt.format(rs.getDouble("cramt")),
                                                                        rs.getString("cracc"),
                                                                        rs.getString("CrId")
                                                                    ));
                        
                    }
                    else
                    {
                        
                        datetree.getChildren().add(new reportCreditBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("crcode"),
                                                                        rs.getString("crname"),
                                                                        Format.doubleFmt.format(rs.getDouble("cramt")),
                                                                        rs.getString("cracc"),
                                                                        rs.getString("CrId")
                                                                    ));
                    
                    }
                    
                }
                else
                {
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
                        if(datetree!=null)
                        {
                            datetree.getChildren().add(new reportCreditBean(tempbranold,"","","Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold)
                            ,Format.doubleFmt.format(totaldate[0])
                            ,"",""
                            ));
                            
                        for(int j = 0; j < totaldate.length; j++)
                            {
                                totaldate[j] = 0;
                            }
                        }
                        
                        datetree = new reportCreditBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","");
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",rs.getString("s_pcode")),rs.getString("pdesc")),rs.getString("pprice11")),rs.getString("punit1")) ));
                         datetree.getChildren().add(new reportCreditBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("crcode"),
                                                                        rs.getString("crname"),
                                                                        Format.doubleFmt.format(rs.getDouble("cramt")),
                                                                        rs.getString("cracc"),
                                                                        rs.getString("CrId")
                                                                    ));
                        
                    }
                    else
                    {
                        
                         datetree.getChildren().add(new reportCreditBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("crcode"),
                                                                        rs.getString("crname"),
                                                                        Format.doubleFmt.format(rs.getDouble("cramt")),
                                                                        rs.getString("cracc"),
                                                                        rs.getString("CrId")
                                                                    ));
                    
                    }
                    
                    
                }
                
                totalgroup1 += rs.getDouble("cramt");
                
                
                totaldate[0] += rs.getDouble("cramt");
                
                
                total1 += rs.getDouble("cramt");
                
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("s_bran");
                tempdateold = rs.getString("s_date");
                tempbnameold = rs.getString("name");
                d_tempdateold = rs.getDate("s_date");
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           if(datetree!=null)
                        {
                            datetree.getChildren().add(new reportCreditBean(tempbran,"","","Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdate)
                            ,Format.doubleFmt.format(totaldate[0])
                            ,"",""
                            ));
                        }
            
           if(subtree != null)
           {
            subtree.getChildren().add(new reportCreditBean(tempbran,"","","Total Branch "
                    ,Format.doubleFmt.format(totalgroup1),"",""
                    ));
            subtree.setS_bran("Branch "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            myroot.getChildren().add(new reportCreditBean("Total All","","","",Format.doubleFmt.format(total1),"",""
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
		reportCreditBean treenode = ( reportCreditBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
                case 1: return treenode.getDate();
		case 2: return treenode.getCrcode();
		case 3: return treenode.getCrname();
                case 4: return treenode.getCramt();
                case 5: return treenode.getCracc();
                case 6: return treenode.getCrld();  
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportCreditBean treenode = ( reportCreditBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportCreditBean treenode = ( reportCreditBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportCreditBean treenode = ( reportCreditBean )parent;
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
		 reportCreditBean treenode = ( reportCreditBean )node;
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
