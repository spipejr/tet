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
public class reportStockCakeModel extends AbstractTreeTableModel 
{
        private Statement stmt;
	private reportStockCakeBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
    
         public reportStockCakeModel(String sql) throws SQLException
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
            
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            reportStockCakeBean subtree = null;
            reportStockCakeBean datetree = null;
            myroot = new reportStockCakeBean();
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
                       
                        myroot.getChildren().add(subtree);
                        
                        subtree.setS_bran("Branch "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportStockCakeBean();
                    countgroup = 0;
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
                        
                        
                        datetree = new reportStockCakeBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","","","","","","","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportStockCakeBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bod")),
                                                                        Format.doubleFmt.format(rs.getDouble("rec")),
                                                                        Format.doubleFmt.format(rs.getDouble("tfr")),
                                                                        Format.doubleFmt.format(rs.getDouble("wid")),
                                                                        Format.doubleFmt.format(rs.getDouble("ret")),
                                                                        Format.doubleFmt.format(rs.getDouble("rfn")),
                                                                        Format.doubleFmt.format(rs.getDouble("sal")),
                                                                        Format.doubleFmt.format(rs.getDouble("adj")),
                                                                        Format.doubleFmt.format(rs.getDouble("eod")),
                                                                        Format.doubleFmt.format(rs.getDouble("pret")),
                                                                        cvth.ASCII2Unicode(rs.getString("tuser")),
                                                                        cvth.ASCII2Unicode(rs.getString("trem"))
                                                                    ));
                        
                    }
                    else
                    {
                        
                        datetree.getChildren().add(new reportStockCakeBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bod")),
                                                                        Format.doubleFmt.format(rs.getDouble("rec")),
                                                                        Format.doubleFmt.format(rs.getDouble("tfr")),
                                                                        Format.doubleFmt.format(rs.getDouble("wid")),
                                                                        Format.doubleFmt.format(rs.getDouble("ret")),
                                                                        Format.doubleFmt.format(rs.getDouble("rfn")),
                                                                        Format.doubleFmt.format(rs.getDouble("sal")),
                                                                        Format.doubleFmt.format(rs.getDouble("adj")),
                                                                        Format.doubleFmt.format(rs.getDouble("eod")),
                                                                        Format.doubleFmt.format(rs.getDouble("pret")),
                                                                        cvth.ASCII2Unicode(rs.getString("tuser")),
                                                                        cvth.ASCII2Unicode(rs.getString("trem"))
                                                                    ));
                    
                    }
                    
                }
                else
                {
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
                        
                        
                        datetree = new reportStockCakeBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","","","","","","","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportStockCakeBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bod")),
                                                                        Format.doubleFmt.format(rs.getDouble("rec")),
                                                                        Format.doubleFmt.format(rs.getDouble("tfr")),
                                                                        Format.doubleFmt.format(rs.getDouble("wid")),
                                                                        Format.doubleFmt.format(rs.getDouble("ret")),
                                                                        Format.doubleFmt.format(rs.getDouble("rfn")),
                                                                        Format.doubleFmt.format(rs.getDouble("sal")),
                                                                        Format.doubleFmt.format(rs.getDouble("adj")),
                                                                        Format.doubleFmt.format(rs.getDouble("eod")),
                                                                        Format.doubleFmt.format(rs.getDouble("pret")),
                                                                        cvth.ASCII2Unicode(rs.getString("tuser")),
                                                                        cvth.ASCII2Unicode(rs.getString("trem"))
                                                                    ));
                        
                    }
                    else
                    {
                        
                        datetree.getChildren().add(new reportStockCakeBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("pcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                                                                        cvth.ASCII2Unicode(rs.getString("punit1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bod")),
                                                                        Format.doubleFmt.format(rs.getDouble("rec")),
                                                                        Format.doubleFmt.format(rs.getDouble("tfr")),
                                                                        Format.doubleFmt.format(rs.getDouble("wid")),
                                                                        Format.doubleFmt.format(rs.getDouble("ret")),
                                                                        Format.doubleFmt.format(rs.getDouble("rfn")),
                                                                        Format.doubleFmt.format(rs.getDouble("sal")),
                                                                        Format.doubleFmt.format(rs.getDouble("adj")),
                                                                        Format.doubleFmt.format(rs.getDouble("eod")),
                                                                        Format.doubleFmt.format(rs.getDouble("pret")),
                                                                        cvth.ASCII2Unicode(rs.getString("tuser")),
                                                                        cvth.ASCII2Unicode(rs.getString("trem"))
                                                                    ));
                    
                    }
                    
                    
                }
                
                
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
           
            
           if(subtree != null)
           {
            
            subtree.setS_bran("Branch "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
          
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
                       
                        myroot.getChildren().add(subtree);
                        
                        subtree.setS_bran("Branch "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportStockCakeBean();
                    countgroup = 0;
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
                        
             
                        datetree = new reportStockCakeBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","","","","","","","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportStockCakeBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("pgroup"),
                                                                        rs.getString("pcode"),
                                                                        rs.getString("pdesc"),
                                                                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                                                                        rs.getString("punit1"),
                                                                        Format.doubleFmt.format(rs.getDouble("bod")),
                                                                        Format.doubleFmt.format(rs.getDouble("rec")),
                                                                        Format.doubleFmt.format(rs.getDouble("tfr")),
                                                                        Format.doubleFmt.format(rs.getDouble("wid")),
                                                                        Format.doubleFmt.format(rs.getDouble("ret")),
                                                                        Format.doubleFmt.format(rs.getDouble("rfn")),
                                                                        Format.doubleFmt.format(rs.getDouble("sal")),
                                                                        Format.doubleFmt.format(rs.getDouble("adj")),
                                                                        Format.doubleFmt.format(rs.getDouble("eod")),
                                                                        Format.doubleFmt.format(rs.getDouble("pret")),
                                                                        rs.getString("tuser"),
                                                                        rs.getString("trem")
                                                                    ));
                        
                    }
                    else
                    {
                        
                        datetree.getChildren().add(new reportStockCakeBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("pgroup"),
                                                                        rs.getString("pcode"),
                                                                        rs.getString("pdesc"),
                                                                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                                                                        rs.getString("punit1"),
                                                                        Format.doubleFmt.format(rs.getDouble("bod")),
                                                                        Format.doubleFmt.format(rs.getDouble("rec")),
                                                                        Format.doubleFmt.format(rs.getDouble("tfr")),
                                                                        Format.doubleFmt.format(rs.getDouble("wid")),
                                                                        Format.doubleFmt.format(rs.getDouble("ret")),
                                                                        Format.doubleFmt.format(rs.getDouble("rfn")),
                                                                        Format.doubleFmt.format(rs.getDouble("sal")),
                                                                        Format.doubleFmt.format(rs.getDouble("adj")),
                                                                        Format.doubleFmt.format(rs.getDouble("eod")),
                                                                        Format.doubleFmt.format(rs.getDouble("pret")),
                                                                        rs.getString("tuser"),
                                                                        rs.getString("trem")
                                                                    ));
                    
                    }
                    
                }
                else
                {
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
                        
                        
                        datetree = new reportStockCakeBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","","","","","","","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportStockCakeBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("pgroup"),
                                                                        rs.getString("pcode"),
                                                                        rs.getString("pdesc"),
                                                                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                                                                        rs.getString("punit1"),
                                                                        Format.doubleFmt.format(rs.getDouble("bod")),
                                                                        Format.doubleFmt.format(rs.getDouble("rec")),
                                                                        Format.doubleFmt.format(rs.getDouble("tfr")),
                                                                        Format.doubleFmt.format(rs.getDouble("wid")),
                                                                        Format.doubleFmt.format(rs.getDouble("ret")),
                                                                        Format.doubleFmt.format(rs.getDouble("rfn")),
                                                                        Format.doubleFmt.format(rs.getDouble("sal")),
                                                                        Format.doubleFmt.format(rs.getDouble("adj")),
                                                                        Format.doubleFmt.format(rs.getDouble("eod")),
                                                                        Format.doubleFmt.format(rs.getDouble("pret")),
                                                                        rs.getString("tuser"),
                                                                        rs.getString("trem")
                                                                    ));
                        
                    }
                    else
                    {
                        
                        datetree.getChildren().add(new reportStockCakeBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("pgroup"),
                                                                        rs.getString("pcode"),
                                                                        rs.getString("pdesc"),
                                                                        Format.doubleFmt.format(rs.getDouble("adjeod")),
                                                                        rs.getString("punit1"),
                                                                        Format.doubleFmt.format(rs.getDouble("bod")),
                                                                        Format.doubleFmt.format(rs.getDouble("rec")),
                                                                        Format.doubleFmt.format(rs.getDouble("tfr")),
                                                                        Format.doubleFmt.format(rs.getDouble("wid")),
                                                                        Format.doubleFmt.format(rs.getDouble("ret")),
                                                                        Format.doubleFmt.format(rs.getDouble("rfn")),
                                                                        Format.doubleFmt.format(rs.getDouble("sal")),
                                                                        Format.doubleFmt.format(rs.getDouble("adj")),
                                                                        Format.doubleFmt.format(rs.getDouble("eod")),
                                                                        Format.doubleFmt.format(rs.getDouble("pret")),
                                                                        rs.getString("tuser"),
                                                                        rs.getString("trem")
                                                                    ));
                    
                    }
                    
                    
                }
                
                
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
           
            
           if(subtree != null)
           {
            
            subtree.setS_bran("Branch "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
          
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
    }
        
    @Override
	public int getColumnCount() 
	{
		return 30;
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
		reportStockCakeBean treenode = ( reportStockCakeBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
		case 1: return treenode.getDate();
                case 2: return treenode.getDept();
		case 3: return treenode.getPcode();
                case 4: return treenode.getPname();
                case 5: return treenode.getPrice();
                case 6: return treenode.getUnit();
                case 7: return treenode.getBod();
                case 8: return treenode.getRec();
                case 9: return treenode.getTfr();
                case 10: return treenode.getWid();
		case 11: return treenode.getRet();
		case 12: return treenode.getRfn();
                case 13: return treenode.getSal();
                case 14: return treenode.getAdj();
                case 15: return treenode.getEod();
                case 16: return treenode.getPret();
                case 17: return treenode.getTuser();
                case 18: return treenode.getTrem();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportStockCakeBean treenode = ( reportStockCakeBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportStockCakeBean treenode = ( reportStockCakeBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportStockCakeBean treenode = ( reportStockCakeBean )parent;
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
		 reportStockCakeBean treenode = ( reportStockCakeBean )node;
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
