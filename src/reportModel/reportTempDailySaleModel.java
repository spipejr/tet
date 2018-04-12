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
import javax.swing.JOptionPane;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class reportTempDailySaleModel extends AbstractTreeTableModel
{
        private Statement stmt;
	private reportTempDailySaleBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        
        public reportTempDailySaleModel(String sql,String code,String name) throws SQLException
    {
        try {
            
        
            db.dbconnect();
            stmt = null;
            String tempbran = " ";
            String tempbranold = " ";
            String tempdate = "";
            String tempdateold = "";
            String tempbname = "";
            String tempbnameold = "";
            Date d_tempdate =null;
            Date d_tempdateold = null;
            double total1 = 0,total2 = 0,total3 = 0;
            double totalgroup1 = 0,totalgroup2 = 0,totalgroup3 = 0;
            
            
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            double dif = 0;
            double difper = 0;
            double budper = 0;
            rs = stmt.executeQuery(sql);
            reportTempDailySaleBean subtree = null;
            myroot = new reportTempDailySaleBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                
                
                    tempbname = cvth.ASCII2Unicode(rs.getString("tdeptname"));
                    tempbran = cvth.ASCII2Unicode(rs.getString("tdept"));
                
               
                
                
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;
                        subtree.setQue("Dept "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportTempDailySaleBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportTempDailySaleBean( cvth.ASCII2Unicode(rs.getString("tdept")),
                                                                        cvth.ASCII2Unicode(rs.getString("tcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("tpname")),
                                                                        cvth.ASCII2Unicode(rs.getString("tprice")),
                                                                        cvth.ASCII2Unicode(rs.getString("tunit")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran3")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran4")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran5")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran6")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran7")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran8")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran9")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran10")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran11")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran12")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran13")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran14")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran15")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran16")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran17")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran18")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran19")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran20")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran21")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran22")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran23")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran24")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran25")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran26")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran27")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran28")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran29")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran30")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran31")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran32")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran33")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran34")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran35")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran36")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran37")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran38")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran39")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran40")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran41")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran42")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran43")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran44")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran45")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran46")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran47")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran48")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran49")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran50")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran51")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran52")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran53")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran54")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran55")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran56")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran57")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran58")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran59")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran60")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran61")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran62")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran63")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran64")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran65")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran66")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran67")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran68")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran69")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran70")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran71")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran72")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran73")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran74")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran75")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran76")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran77")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran78")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran79")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran80")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran81")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran82")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran83")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran84")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran85")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran86")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran87")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran88")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran89")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran90")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran91")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran92")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran93")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran94")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran95")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran96")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran97")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran98")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran99")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran100")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran101"))
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                       subtree.getChildren().add(new reportTempDailySaleBean( cvth.ASCII2Unicode(rs.getString("tdept")),
                                                                        cvth.ASCII2Unicode(rs.getString("tcode")),
                                                                        cvth.ASCII2Unicode(rs.getString("tpname")),
                                                                        cvth.ASCII2Unicode(rs.getString("tprice")),
                                                                        cvth.ASCII2Unicode(rs.getString("tunit")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran3")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran4")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran5")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran6")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran7")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran8")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran9")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran10")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran11")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran12")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran13")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran14")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran15")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran16")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran17")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran18")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran19")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran20")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran21")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran22")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran23")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran24")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran25")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran26")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran27")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran28")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran29")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran30")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran31")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran32")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran33")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran34")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran35")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran36")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran37")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran38")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran39")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran40")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran41")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran42")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran43")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran44")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran45")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran46")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran47")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran48")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran49")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran50")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran51")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran52")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran53")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran54")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran55")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran56")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran57")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran58")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran59")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran60")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran61")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran62")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran63")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran64")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran65")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran66")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran67")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran68")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran69")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran70")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran71")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran72")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran73")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran74")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran75")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran76")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran77")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran78")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran79")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran80")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran81")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran82")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran83")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran84")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran85")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran86")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran87")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran88")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran89")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran90")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran91")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran92")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran93")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran94")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran95")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran96")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran97")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran98")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran99")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran100")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran101"))
                                                                    ));
                        
                    
                    
                }
                
               
                
                
               
                
                
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
                    tempbnameold = cvth.ASCII2Unicode(rs.getString("tdeptname"));
                    tempbranold = cvth.ASCII2Unicode(rs.getString("tdept"));
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
            
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            subtree.setQue("Dept "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            }
           
           
            myroot.setQue("Report List Of "+counttotal+" Record");
            }
            else
            {
                while (rs.next()) {
                
                
                
                    tempbname = rs.getString("tdeptname");
                    tempbran = rs.getString("tdept");
                
               
                
                
                if(!tempbranold.equals(tempbran))
                {
                    tempdateold = " ";
                    if(subtree != null)
                    {
                        
                       // subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;
                        subtree.setQue("Dept "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportTempDailySaleBean();
                    countgroup = 0;
                        i=1;
                        
                        subtree.getChildren().add(new reportTempDailySaleBean( rs.getString("tdept"),
                                                                        rs.getString("tcode"),
                                                                        rs.getString("tpname"),
                                                                        rs.getString("tprice"),
                                                                        rs.getString("tunit"),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran3")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran4")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran5")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran6")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran7")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran8")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran9")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran10")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran11")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran12")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran13")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran14")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran15")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran16")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran17")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran18")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran19")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran20")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran21")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran22")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran23")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran24")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran25")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran26")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran27")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran28")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran29")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran30")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran31")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran32")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran33")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran34")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran35")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran36")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran37")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran38")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran39")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran40")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran41")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran42")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran43")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran44")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran45")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran46")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran47")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran48")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran49")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran50")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran51")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran52")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran53")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran54")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran55")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran56")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran57")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran58")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran59")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran60")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran61")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran62")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran63")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran64")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran65")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran66")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran67")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran68")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran69")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran70")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran71")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran72")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran73")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran74")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran75")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran76")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran77")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran78")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran79")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran80")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran81")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran82")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran83")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran84")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran85")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran86")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran87")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran88")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran89")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran90")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran91")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran92")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran93")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran94")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran95")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran96")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran97")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran98")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran99")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran100")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran101"))
                                                                    ));
                        
                    
                    
                }
                else
                {
                    
                       subtree.getChildren().add(new reportTempDailySaleBean( rs.getString("tdept"),
                                                                        rs.getString("tcode"),
                                                                        rs.getString("tpname"),
                                                                        rs.getString("tprice"),
                                                                        rs.getString("tunit"),
                                                                        Format.doubleFmt.format(rs.getDouble("bran1")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran2")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran3")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran4")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran5")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran6")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran7")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran8")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran9")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran10")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran11")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran12")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran13")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran14")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran15")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran16")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran17")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran18")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran19")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran20")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran21")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran22")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran23")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran24")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran25")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran26")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran27")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran28")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran29")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran30")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran31")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran32")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran33")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran34")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran35")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran36")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran37")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran38")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran39")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran40")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran41")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran42")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran43")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran44")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran45")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran46")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran47")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran48")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran49")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran50")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran51")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran52")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran53")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran54")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran55")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran56")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran57")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran58")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran59")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran60")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran61")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran62")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran63")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran64")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran65")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran66")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran67")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran68")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran69")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran70")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran71")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran72")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran73")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran74")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran75")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran76")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran77")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran78")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran79")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran80")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran81")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran82")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran83")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran84")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran85")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran86")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran87")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran88")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran89")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran90")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran91")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran92")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran93")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran94")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran95")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran96")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran97")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran98")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran99")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran100")),
                                                                        Format.doubleFmt.format(rs.getDouble("bran101"))
                                                                    ));
                        
                    
                    
                }
                
               
                
                
               
                
                
                
//                totalall +=price;
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                
                
                
                    tempbnameold = rs.getString("tdeptname");
                    tempbranold = rs.getString("tdept");
                
                
                
            }
//            Format.doubleFmt.format(totalgroup)
           
            
           if(subtree != null)
           {
            
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            subtree.setQue("Dept "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            }
           
           
            myroot.setQue("Report List Of "+counttotal+" Record");
                
            }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e);
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
		reportTempDailySaleBean treenode = ( reportTempDailySaleBean )node;
		switch( column )
		{
		case 0: return treenode.getQue();
		case 1: return treenode.getPcode();
		case 2: return treenode.getPname();
                case 3: return treenode.getPrice();
                case 4: return treenode.getUnit();
                case 5: return treenode.getB1();
		case 6: return treenode.getB2();
		case 7: return treenode.getB3();
                case 8: return treenode.getB4();
                case 9: return treenode.getB5();
                case 10: return treenode.getB6();
                case 11: return treenode.getB7();    
                case 12: return treenode.getB8();
                case 13: return treenode.getB9();
                case 14: return treenode.getB10();
                case 15: return treenode.getB11();
                case 16: return treenode.getB12();
                case 17: return treenode.getB13();
                case 18: return treenode.getB14();
                case 19: return treenode.getB15();
                case 20: return treenode.getB16();
                case 21: return treenode.getB17();
                case 22: return treenode.getB18();
                case 23: return treenode.getB19();
                case 24: return treenode.getB20();
                case 25: return treenode.getB21();
                case 26: return treenode.getB22();
                case 27: return treenode.getB23();
                case 28: return treenode.getB24();
                case 29: return treenode.getB25();
                case 30: return treenode.getB26();
                case 31: return treenode.getB27();
                case 32: return treenode.getB28();
                case 33: return treenode.getB29();
                case 34: return treenode.getB30();
                case 35: return treenode.getB31();
                case 36: return treenode.getB32();
                case 37: return treenode.getB33();
                case 38: return treenode.getB34();
                case 39: return treenode.getB35();
                case 40: return treenode.getB36();
                case 41: return treenode.getB37();
                case 42: return treenode.getB38();
                case 43: return treenode.getB39();
                case 44: return treenode.getB40();
                case 45: return treenode.getB41();
                case 46: return treenode.getB42();
                case 47: return treenode.getB43();
                case 48: return treenode.getB44();
                case 49: return treenode.getB45();
                case 50: return treenode.getB46();
                case 51: return treenode.getB47();
                case 52: return treenode.getB48();
                case 53: return treenode.getB49();
                case 54: return treenode.getB50();
                case 55: return treenode.getB51();
                case 56: return treenode.getB52();
                case 57: return treenode.getB53();
                case 58: return treenode.getB54();
                case 59: return treenode.getB55();
                case 60: return treenode.getB56();
                case 61: return treenode.getB57();
                case 62: return treenode.getB58();
                case 63: return treenode.getB59();
                case 64: return treenode.getB60();
                case 65: return treenode.getB61();
                case 66: return treenode.getB62();
                case 67: return treenode.getB63();
                case 68: return treenode.getB64();
                case 69: return treenode.getB65();
                case 70: return treenode.getB66();
                case 71: return treenode.getB67();
                case 72: return treenode.getB68();
                case 73: return treenode.getB69();
                case 74: return treenode.getB70();
                case 75: return treenode.getB71();
                case 76: return treenode.getB72();
                case 77: return treenode.getB73();
                case 78: return treenode.getB74();
                case 79: return treenode.getB75();
                case 80: return treenode.getB76();
                case 81: return treenode.getB77();
                case 82: return treenode.getB78();
                case 83: return treenode.getB79();
                case 84: return treenode.getB80();
                case 85: return treenode.getB81();
                case 86: return treenode.getB82();
                case 87: return treenode.getB83();
                case 88: return treenode.getB84();
                case 89: return treenode.getB85();
                case 90: return treenode.getB86();
                case 91: return treenode.getB87();
                case 92: return treenode.getB88();
                case 93: return treenode.getB89();
                case 94: return treenode.getB90();
                case 95: return treenode.getB91();
                case 96: return treenode.getB92();
                case 97: return treenode.getB93();
                case 98: return treenode.getB94();
                case 99: return treenode.getB95();
                case 100: return treenode.getB96();
                case 101: return treenode.getB97();
                case 102: return treenode.getB98();
                case 103: return treenode.getB99();
                case 104: return treenode.getB100();
                case 105: return treenode.getB101();
                
                default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportTempDailySaleBean treenode = ( reportTempDailySaleBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportTempDailySaleBean treenode = ( reportTempDailySaleBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportTempDailySaleBean treenode = ( reportTempDailySaleBean )parent;
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
		 reportTempDailySaleBean treenode = ( reportTempDailySaleBean )node;
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
