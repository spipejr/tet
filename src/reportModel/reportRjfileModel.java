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
public class reportRjfileModel extends AbstractTreeTableModel
{
        private Statement stmt;
	private reportRjfileBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportRjfileModel(String sql) throws SQLException
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
            double[] total1 = {0,0,0,0};
            double[] totalgroup1 = {0,0,0,0};
            
            double[] totaldate = {0,0,0,0};
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            reportRjfileBean subtree = null;
            reportRjfileBean datetree = null;
            myroot = new reportRjfileBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                d_tempdate = rs.getDate("tdate");
                tempbran = rs.getString("brcode");
                tempdate = rs.getString("tdate");
                tempbname = cvth.ASCII2Unicode(rs.getString("name"));
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = "";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
//                        subtree.getChildren().add(new reportRjfileBean("Total Branch "+tempbran,"",""
//                    ,"","",""
//                    ,Format.doubleFmt.format(totalgroup1[0]),Format.doubleFmt.format(totalgroup1[1])
//                    ,Format.doubleFmt.format(totalgroup1[2]),Format.doubleFmt.format(totalgroup1[3])
//                    ));
                        myroot.getChildren().add(subtree);
                        for(int j = 0; j < totalgroup1.length; j++)
                            {
                                totalgroup1[j] = 0;
                            }
                        subtree.setS_bran("Branch "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportRjfileBean();
                    countgroup = 0;
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
//                        if(datetree!=null)
//                        {
//                            datetree.getChildren().add(new reportRjfileBean("Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold),"",""
//                            ,"","",""
//                            ,Format.doubleFmt.format(totaldate[0]),Format.doubleFmt.format(totaldate[1])
//                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
//                            ));
//                            
//                            for(int j = 0; j < totaldate.length; j++)
//                            {
//                                totaldate[j] = 0;
//                            }
//                        }
                        
                        datetree = new reportRjfileBean("Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdate),"","","","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportRjfileBean( cvth.ASCII2Unicode(rs.getString("brcode")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                        cvth.ASCII2Unicode(rs.getString("rjline")),
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
                        
                        datetree.getChildren().add(new reportRjfileBean( cvth.ASCII2Unicode(rs.getString("brcode")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                        cvth.ASCII2Unicode(rs.getString("rjline")),
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
                    
                }
                else
                {
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
//                        if(datetree!=null)
//                        {
//                            datetree.getChildren().add(new reportRjfileBean("Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold),"",""
//                            ,"","",""
//                            ,Format.doubleFmt.format(totaldate[0]),Format.doubleFmt.format(totaldate[1])
//                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
//                            ));
//                            
//                        for(int j = 0; j < totaldate.length; j++)
//                            {
//                                totaldate[j] = 0;
//                            }
//                        }
                        
                        datetree = new reportRjfileBean("Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdate),"","","","","","","","","","");
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                         datetree.getChildren().add(new reportRjfileBean( cvth.ASCII2Unicode(rs.getString("brcode")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                        cvth.ASCII2Unicode(rs.getString("rjline")),
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
                        
                         datetree.getChildren().add(new reportRjfileBean( cvth.ASCII2Unicode(rs.getString("brcode")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                        cvth.ASCII2Unicode(rs.getString("rjline")),
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
                    
                    
                }
                
                totalgroup1[0] += rs.getDouble("mac1");
                totalgroup1[1] += rs.getDouble("mac2");
                totalgroup1[2] += rs.getDouble("mac3");
                totalgroup1[3] += rs.getDouble("total");
                
                
                totaldate[0] += rs.getDouble("mac1");
                totaldate[1] += rs.getDouble("mac2");
                totaldate[2] += rs.getDouble("mac3");
                totaldate[3] += rs.getDouble("total");
                
                
                total1[0] += rs.getDouble("mac1");
                total1[1] += rs.getDouble("mac2");
                total1[2] += rs.getDouble("mac3");
                total1[3] += rs.getDouble("total");
                
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("brcode");
                tempdateold = rs.getString("tdate");
                tempbnameold = cvth.ASCII2Unicode(rs.getString("name"));
                d_tempdateold = rs.getDate("tdate");
                
                
            }
//            Format.doubleFmt.format(totalgroup)
//           if(datetree!=null)
//                        {
//                            datetree.getChildren().add(new reportRjfileBean("Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdate),"",""
//                            ,"","",""
//                            ,Format.doubleFmt.format(totaldate[0]),Format.doubleFmt.format(totaldate[1])
//                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
//                            ));
//                        }
            
           if(subtree != null)
           {
//            subtree.getChildren().add(new reportRjfileBean("Total Branch "+tempbran,"",""
//                    ,"","",""
//                    ,Format.doubleFmt.format(totalgroup1[0]),Format.doubleFmt.format(totalgroup1[1])
//                    ,Format.doubleFmt.format(totalgroup1[2]),Format.doubleFmt.format(totalgroup1[3])
//                    ));
            subtree.setS_bran("Branch "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
//            myroot.getChildren().add(new reportRjfileBean("Total All","",""
//            ,"","",""
//            ,Format.doubleFmt.format(total1[0]),Format.doubleFmt.format(total1[1])
//            ,Format.doubleFmt.format(total1[2]),Format.doubleFmt.format(total1[3])
//                     ));
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
            else
            {
               while (rs.next()) {
                
                d_tempdate = rs.getDate("tdate");
                tempbran = rs.getString("brcode");
                tempdate = rs.getString("tdate");
                tempbname = rs.getString("name");
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = "";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
//                        subtree.getChildren().add(new reportRjfileBean("Total Branch "+tempbran,"",""
//                    ,"","",""
//                    ,Format.doubleFmt.format(totalgroup1[0]),Format.doubleFmt.format(totalgroup1[1])
//                    ,Format.doubleFmt.format(totalgroup1[2]),Format.doubleFmt.format(totalgroup1[3])
//                    ));
                        myroot.getChildren().add(subtree);
                        for(int j = 0; j < totalgroup1.length; j++)
                            {
                                totalgroup1[j] = 0;
                            }
                        subtree.setS_bran("Branch "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportRjfileBean();
                    countgroup = 0;
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
//                        if(datetree!=null)
//                        {
//                            datetree.getChildren().add(new reportRjfileBean("Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold),"",""
//                            ,"","",""
//                            ,Format.doubleFmt.format(totaldate[0]),Format.doubleFmt.format(totaldate[1])
//                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
//                            ));
//                            
//                            for(int j = 0; j < totaldate.length; j++)
//                            {
//                                totaldate[j] = 0;
//                            }
//                        }
            
                        datetree = new reportRjfileBean("Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdate),"","","","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportRjfileBean( rs.getString("brcode"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                        rs.getString("rjline"),
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
                        
                         datetree.getChildren().add(new reportRjfileBean( rs.getString("brcode"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                        rs.getString("rjline"),
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
                    
                }
                else
                {
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
//                        if(datetree!=null)
//                        {
//                            datetree.getChildren().add(new reportRjfileBean("Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold),"",""
//                            ,"","",""
//                            ,Format.doubleFmt.format(totaldate[0]),Format.doubleFmt.format(totaldate[1])
//                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
//                            ));
//                            
//                        for(int j = 0; j < totaldate.length; j++)
//                            {
//                                totaldate[j] = 0;
//                            }
//                        }
                        
                        datetree = new reportRjfileBean("Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdate),"","","","","","","","","","");
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                          datetree.getChildren().add(new reportRjfileBean( rs.getString("brcode"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                        rs.getString("rjline"),
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
                        
                          datetree.getChildren().add(new reportRjfileBean( rs.getString("brcode"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("tdate")),
                                                                        rs.getString("rjline"),
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
                    
                    
                }
                
//                totalgroup1[0] += rs.getDouble("mac1");
//                totalgroup1[1] += rs.getDouble("mac2");
//                totalgroup1[2] += rs.getDouble("mac3");
//                totalgroup1[3] += rs.getDouble("total");
//                
//                
//                totaldate[0] += rs.getDouble("mac1");
//                totaldate[1] += rs.getDouble("mac2");
//                totaldate[2] += rs.getDouble("mac3");
//                totaldate[3] += rs.getDouble("total");
//                
//                
//                total1[0] += rs.getDouble("mac1");
//                total1[1] += rs.getDouble("mac2");
//                total1[2] += rs.getDouble("mac3");
//                total1[3] += rs.getDouble("total");
                
                
                
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("brcode");
                tempdateold = rs.getString("tdate");
                tempbnameold = rs.getString("name");
                d_tempdateold = rs.getDate("tdate");
                
                
            }
//            Format.doubleFmt.format(totalgroup)
//           if(datetree!=null)
//                        {
//                            datetree.getChildren().add(new reportRjfileBean("Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdate),"",""
//                            ,"","",""
//                            ,Format.doubleFmt.format(totaldate[0]),Format.doubleFmt.format(totaldate[1])
//                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
//                            ));
//                        }
            
           if(subtree != null)
           {
//            subtree.getChildren().add(new reportRjfileBean("Total Branch "+tempbran,"",""
//                    ,"","",""
//                    ,Format.doubleFmt.format(totalgroup1[0]),Format.doubleFmt.format(totalgroup1[1])
//                    ,Format.doubleFmt.format(totalgroup1[2]),Format.doubleFmt.format(totalgroup1[3])
//                    ));
            subtree.setS_bran("Branch "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
//            myroot.getChildren().add(new reportRjfileBean("Total All","",""
//            ,"","",""
//            ,Format.doubleFmt.format(total1[0]),Format.doubleFmt.format(total1[1])
//            ,Format.doubleFmt.format(total1[2]),Format.doubleFmt.format(total1[3])
//                     ));
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
		reportRjfileBean treenode = ( reportRjfileBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
                case 1: return treenode.getDate();
		case 2: return treenode.getNo();
		case 3: return treenode.getDept();
                case 4: return treenode.getAccno();
                case 5: return treenode.getSubacc();
                case 6: return treenode.getDesc();
                case 7: return treenode.getMac1();
		case 8: return treenode.getMac2();
		case 9: return treenode.getMac3();
                case 10: return treenode.getTotal();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportRjfileBean treenode = ( reportRjfileBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportRjfileBean treenode = ( reportRjfileBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportRjfileBean treenode = ( reportRjfileBean )parent;
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
		 reportRjfileBean treenode = ( reportRjfileBean )node;
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
