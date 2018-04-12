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
public class reportSumHourlyModel extends AbstractTreeTableModel
{
    private Statement stmt;
	private reportSumHourlyBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
        public reportSumHourlyModel(String sql) throws SQLException
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
            double[] total1 = new double[57];
            double[] totalgroup1 = new double[57];
            
            for(int tc = 0; tc<total1.length; tc++)
            {
                total1[tc]=0;
            }
            
            for(int tc = 0; tc<totalgroup1.length; tc++)
            {
                totalgroup1[tc]=0;
            }
            
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            reportSumHourlyBean subtree = null;
            myroot = new reportSumHourlyBean();
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            while (rs.next()) {
                
                d_tempdate = rs.getDate("t_date");
                tempbran = rs.getString("s_bran");
                tempdate = rs.getString("t_date");
                tempbname = cvth.ASCII2Unicode(rs.getString("BranName"));
                if(!tempbranold.equals(tempbran))
                {
                    if(subtree != null)
                    {
                        
                       //Format.doubleFmt.format(totalgroup1) subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new reportSumHourlyBean(tempbranold,
                                "Total Branch "+tempbranold,
                                Format.doubleFmt.format(totalgroup1[0]),
                                Format.doubleFmt.format(totalgroup1[1]),
                                Format.doubleFmt.format(totalgroup1[2]),
                                Format.doubleFmt.format(totalgroup1[3]),
                                Format.doubleFmt.format(totalgroup1[4]),
                                Format.doubleFmt.format(totalgroup1[5]),
                                Format.doubleFmt.format(totalgroup1[6]),
                                Format.doubleFmt.format(totalgroup1[7]),
                                Format.doubleFmt.format(totalgroup1[8]),
                                Format.doubleFmt.format(totalgroup1[9]),
                                Format.doubleFmt.format(totalgroup1[10]),
                                Format.doubleFmt.format(totalgroup1[11]),
                                Format.doubleFmt.format(totalgroup1[12]),
                                Format.doubleFmt.format(totalgroup1[13]),
                                Format.doubleFmt.format(totalgroup1[14]),
                                Format.doubleFmt.format(totalgroup1[15]),
                                Format.doubleFmt.format(totalgroup1[16]),
                                Format.doubleFmt.format(totalgroup1[17]),
                                Format.doubleFmt.format(totalgroup1[18]),
                                Format.doubleFmt.format(totalgroup1[19]),
                                Format.doubleFmt.format(totalgroup1[20]),
                                Format.doubleFmt.format(totalgroup1[21]),
                                Format.doubleFmt.format(totalgroup1[22]),
                                Format.doubleFmt.format(totalgroup1[23]),
                                Format.doubleFmt.format(totalgroup1[24]),
                                Format.doubleFmt.format(totalgroup1[25]),
                                Format.doubleFmt.format(totalgroup1[26]),
                                Format.doubleFmt.format(totalgroup1[27]),
                                Format.doubleFmt.format(totalgroup1[28]),
                                Format.doubleFmt.format(totalgroup1[29]),
                                Format.doubleFmt.format(totalgroup1[30]),
                                Format.doubleFmt.format(totalgroup1[31]),
                                Format.doubleFmt.format(totalgroup1[32]),
                                Format.doubleFmt.format(totalgroup1[33]),
                                Format.doubleFmt.format(totalgroup1[34]),
                                Format.doubleFmt.format(totalgroup1[35]),
                                Format.doubleFmt.format(totalgroup1[36]),
                                Format.doubleFmt.format(totalgroup1[37]),
                                Format.doubleFmt.format(totalgroup1[38]),
                                Format.doubleFmt.format(totalgroup1[39]),
                                Format.doubleFmt.format(totalgroup1[40]),
                                Format.doubleFmt.format(totalgroup1[41]),
                                Format.doubleFmt.format(totalgroup1[42]),
                                Format.doubleFmt.format(totalgroup1[43]),
                                Format.doubleFmt.format(totalgroup1[44]),
                                Format.doubleFmt.format(totalgroup1[45]),
                                Format.doubleFmt.format(totalgroup1[46]),
                                Format.doubleFmt.format(totalgroup1[47]),
                                Format.doubleFmt.format(totalgroup1[48]),
                                Format.doubleFmt.format(totalgroup1[49]),
                                Format.doubleFmt.format(totalgroup1[50]),
                                Format.doubleFmt.format(totalgroup1[51]),
                                Format.doubleFmt.format(totalgroup1[52]),
                                Format.doubleFmt.format(totalgroup1[53]),
                                Format.doubleFmt.format(totalgroup1[54]),
                                Format.doubleFmt.format(totalgroup1[55]),
                                Format.doubleFmt.format(totalgroup1[56])
                    ));
                        
                        
                        
                        subtree.setS_bran("Branch "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        myroot.getChildren().add(subtree);
                        for(int j = 0; j < totalgroup1.length; j++)
                            {
                                totalgroup1[j] = 0;
                            }
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportSumHourlyBean();
                    countgroup = 0;
                    i=1;
                        subtree.getChildren().add(new reportSumHourlyBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        rs.getString("tempday"),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt24")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt24")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt24"))
                                                                    ));
                        
                   
                       
                    
                }
                else
                {
                        
                         subtree.getChildren().add(new reportSumHourlyBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        rs.getString("tempday"),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt24")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt24")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt24"))
                                                                    ));
                        
//                         
                    
                    
                    
                    
                }
                
                totalgroup1[0] += rs.getDouble("pnt1");
                totalgroup1[1] += rs.getDouble("cnt1");
                totalgroup1[2] += rs.getDouble("amt1");
                totalgroup1[3] += rs.getDouble("pnt7");
                totalgroup1[4] += rs.getDouble("cnt7");
                totalgroup1[5] += rs.getDouble("amt7");
                totalgroup1[6] += rs.getDouble("pnt8");
                totalgroup1[7] += rs.getDouble("cnt8");
                totalgroup1[8] += rs.getDouble("amt8");
                totalgroup1[9] += rs.getDouble("pnt9");
                totalgroup1[10] += rs.getDouble("cnt9");
                totalgroup1[11] += rs.getDouble("amt9");
                totalgroup1[12] += rs.getDouble("pnt10");
                totalgroup1[13] += rs.getDouble("cnt10");
                totalgroup1[14] += rs.getDouble("amt10");
                totalgroup1[15] += rs.getDouble("pnt11");
                totalgroup1[16] += rs.getDouble("cnt11");
                totalgroup1[17] += rs.getDouble("amt11");
                totalgroup1[18] += rs.getDouble("pnt12");
                totalgroup1[19] += rs.getDouble("cnt12");
                totalgroup1[20] += rs.getDouble("amt12");
                totalgroup1[21] += rs.getDouble("pnt13");
                totalgroup1[22] += rs.getDouble("cnt13");
                totalgroup1[23] += rs.getDouble("amt13");
                totalgroup1[24] += rs.getDouble("pnt14");
                totalgroup1[25] += rs.getDouble("cnt14");
                totalgroup1[26] += rs.getDouble("amt14");
                totalgroup1[27] += rs.getDouble("pnt15");
                totalgroup1[28] += rs.getDouble("cnt15");
                totalgroup1[29] += rs.getDouble("amt15");
                totalgroup1[30] += rs.getDouble("pnt16");
                totalgroup1[31] += rs.getDouble("cnt16");
                totalgroup1[32] += rs.getDouble("amt16");
                totalgroup1[33] += rs.getDouble("pnt17");
                totalgroup1[34] += rs.getDouble("cnt17");
                totalgroup1[35] += rs.getDouble("amt17");
                totalgroup1[36] += rs.getDouble("pnt18");
                totalgroup1[37] += rs.getDouble("cnt18");
                totalgroup1[38] += rs.getDouble("amt18");
                totalgroup1[39] += rs.getDouble("pnt19");
                totalgroup1[40] += rs.getDouble("cnt19");
                totalgroup1[41] += rs.getDouble("amt19");
                totalgroup1[42] += rs.getDouble("pnt20");
                totalgroup1[43] += rs.getDouble("cnt20");
                totalgroup1[44] += rs.getDouble("amt20");
                totalgroup1[45] += rs.getDouble("pnt21");
                totalgroup1[46] += rs.getDouble("cnt21");
                totalgroup1[47] += rs.getDouble("amt21");
                totalgroup1[48] += rs.getDouble("pnt22");
                totalgroup1[49] += rs.getDouble("cnt22");
                totalgroup1[50] += rs.getDouble("amt22");
                totalgroup1[51] += rs.getDouble("pnt23");
                totalgroup1[52] += rs.getDouble("cnt23");
                totalgroup1[53] += rs.getDouble("amt23");
                totalgroup1[54] += rs.getDouble("pnt24");
                totalgroup1[55] += rs.getDouble("cnt24");
                totalgroup1[56] += rs.getDouble("amt24");
                
               
                
                
                total1[0] += rs.getDouble("pnt1");
                total1[1] += rs.getDouble("cnt1");
                total1[2] += rs.getDouble("amt1");
                total1[3] += rs.getDouble("pnt7");
                total1[4] += rs.getDouble("cnt7");
                total1[5] += rs.getDouble("amt7");
                total1[6] += rs.getDouble("pnt8");
                total1[7] += rs.getDouble("cnt8");
                total1[8] += rs.getDouble("amt8");
                total1[9] += rs.getDouble("pnt9");
                total1[10] += rs.getDouble("cnt9");
                total1[11] += rs.getDouble("amt9");
                total1[12] += rs.getDouble("pnt10");
                total1[13] += rs.getDouble("cnt10");
                total1[14] += rs.getDouble("amt10");
                total1[15] += rs.getDouble("pnt11");
                total1[16] += rs.getDouble("cnt11");
                total1[17] += rs.getDouble("amt11");
                total1[18] += rs.getDouble("pnt12");
                total1[19] += rs.getDouble("cnt12");
                total1[20] += rs.getDouble("amt12");
                total1[21] += rs.getDouble("pnt13");
                total1[22] += rs.getDouble("cnt13");
                total1[23] += rs.getDouble("amt13");
                total1[24] += rs.getDouble("pnt14");
                total1[25] += rs.getDouble("cnt14");
                total1[26] += rs.getDouble("amt14");
                total1[27] += rs.getDouble("pnt15");
                total1[28] += rs.getDouble("cnt15");
                total1[29] += rs.getDouble("amt15");
                total1[30] += rs.getDouble("pnt16");
                total1[31] += rs.getDouble("cnt16");
                total1[32] += rs.getDouble("amt16");
                total1[33] += rs.getDouble("pnt17");
                total1[34] += rs.getDouble("cnt17");
                total1[35] += rs.getDouble("amt17");
                total1[36] += rs.getDouble("pnt18");
                total1[37] += rs.getDouble("cnt18");
                total1[38] += rs.getDouble("amt18");
                total1[39] += rs.getDouble("pnt19");
                total1[40] += rs.getDouble("cnt19");
                total1[41] += rs.getDouble("amt19");
                total1[42] += rs.getDouble("pnt20");
                total1[43] += rs.getDouble("cnt20");
                total1[44] += rs.getDouble("amt20");
                total1[45] += rs.getDouble("pnt21");
                total1[46] += rs.getDouble("cnt21");
                total1[47] += rs.getDouble("amt21");
                total1[48] += rs.getDouble("pnt22");
                total1[49] += rs.getDouble("cnt22");
                total1[50] += rs.getDouble("amt22");
                total1[51] += rs.getDouble("pnt23");
                total1[52] += rs.getDouble("cnt23");
                total1[53] += rs.getDouble("amt23");
                total1[54] += rs.getDouble("pnt24");
                total1[55] += rs.getDouble("cnt24");
                total1[56] += rs.getDouble("amt24");
                
                
               
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("s_bran");
                tempdateold = rs.getString("t_date");
                tempbnameold = cvth.ASCII2Unicode(rs.getString("BranName"));
                d_tempdateold = rs.getDate("t_date");
                
                
            }
          
           if(subtree != null)
           {
           subtree.getChildren().add(new reportSumHourlyBean(tempbran,
                                "Total Branch "+tempbran,
                                Format.doubleFmt.format(totalgroup1[0]),
                                Format.doubleFmt.format(totalgroup1[1]),
                                Format.doubleFmt.format(totalgroup1[2]),
                                Format.doubleFmt.format(totalgroup1[3]),
                                Format.doubleFmt.format(totalgroup1[4]),
                                Format.doubleFmt.format(totalgroup1[5]),
                                Format.doubleFmt.format(totalgroup1[6]),
                                Format.doubleFmt.format(totalgroup1[7]),
                                Format.doubleFmt.format(totalgroup1[8]),
                                Format.doubleFmt.format(totalgroup1[9]),
                                Format.doubleFmt.format(totalgroup1[10]),
                                Format.doubleFmt.format(totalgroup1[11]),
                                Format.doubleFmt.format(totalgroup1[12]),
                                Format.doubleFmt.format(totalgroup1[13]),
                                Format.doubleFmt.format(totalgroup1[14]),
                                Format.doubleFmt.format(totalgroup1[15]),
                                Format.doubleFmt.format(totalgroup1[16]),
                                Format.doubleFmt.format(totalgroup1[17]),
                                Format.doubleFmt.format(totalgroup1[18]),
                                Format.doubleFmt.format(totalgroup1[19]),
                                Format.doubleFmt.format(totalgroup1[20]),
                                Format.doubleFmt.format(totalgroup1[21]),
                                Format.doubleFmt.format(totalgroup1[22]),
                                Format.doubleFmt.format(totalgroup1[23]),
                                Format.doubleFmt.format(totalgroup1[24]),
                                Format.doubleFmt.format(totalgroup1[25]),
                                Format.doubleFmt.format(totalgroup1[26]),
                                Format.doubleFmt.format(totalgroup1[27]),
                                Format.doubleFmt.format(totalgroup1[28]),
                                Format.doubleFmt.format(totalgroup1[29]),
                                Format.doubleFmt.format(totalgroup1[30]),
                                Format.doubleFmt.format(totalgroup1[31]),
                                Format.doubleFmt.format(totalgroup1[32]),
                                Format.doubleFmt.format(totalgroup1[33]),
                                Format.doubleFmt.format(totalgroup1[34]),
                                Format.doubleFmt.format(totalgroup1[35]),
                                Format.doubleFmt.format(totalgroup1[36]),
                                Format.doubleFmt.format(totalgroup1[37]),
                                Format.doubleFmt.format(totalgroup1[38]),
                                Format.doubleFmt.format(totalgroup1[39]),
                                Format.doubleFmt.format(totalgroup1[40]),
                                Format.doubleFmt.format(totalgroup1[41]),
                                Format.doubleFmt.format(totalgroup1[42]),
                                Format.doubleFmt.format(totalgroup1[43]),
                                Format.doubleFmt.format(totalgroup1[44]),
                                Format.doubleFmt.format(totalgroup1[45]),
                                Format.doubleFmt.format(totalgroup1[46]),
                                Format.doubleFmt.format(totalgroup1[47]),
                                Format.doubleFmt.format(totalgroup1[48]),
                                Format.doubleFmt.format(totalgroup1[49]),
                                Format.doubleFmt.format(totalgroup1[50]),
                                Format.doubleFmt.format(totalgroup1[51]),
                                Format.doubleFmt.format(totalgroup1[52]),
                                Format.doubleFmt.format(totalgroup1[53]),
                                Format.doubleFmt.format(totalgroup1[54]),
                                Format.doubleFmt.format(totalgroup1[55]),
                                Format.doubleFmt.format(totalgroup1[56])
                    ));
            subtree.setS_bran("Branch "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
//           for(int j=0; j<total1.length;j++) {
//           JOptionPane.showMessageDialog(null, Format.doubleFmt.format(total1[j]));
//            }
             myroot.getChildren().add(new reportSumHourlyBean("Total All",
                                "",
                                Format.doubleFmt.format(total1[0]),
                                Format.doubleFmt.format(total1[1]),
                                Format.doubleFmt.format(total1[2]),
                                Format.doubleFmt.format(total1[3]),
                                Format.doubleFmt.format(total1[4]),
                                Format.doubleFmt.format(total1[5]),
                                Format.doubleFmt.format(total1[6]),
                                Format.doubleFmt.format(total1[7]),
                                Format.doubleFmt.format(total1[8]),
                                Format.doubleFmt.format(total1[9]),
                                Format.doubleFmt.format(total1[10]),
                                Format.doubleFmt.format(total1[11]),
                                Format.doubleFmt.format(total1[12]),
                                Format.doubleFmt.format(total1[13]),
                                Format.doubleFmt.format(total1[14]),
                                Format.doubleFmt.format(total1[15]),
                                Format.doubleFmt.format(total1[16]),
                                Format.doubleFmt.format(total1[17]),
                                Format.doubleFmt.format(total1[18]),
                                Format.doubleFmt.format(total1[19]),
                                Format.doubleFmt.format(total1[20]),
                                Format.doubleFmt.format(total1[21]),
                                Format.doubleFmt.format(total1[22]),
                                Format.doubleFmt.format(total1[23]),
                                Format.doubleFmt.format(total1[24]),
                                Format.doubleFmt.format(total1[25]),
                                Format.doubleFmt.format(total1[26]),
                                Format.doubleFmt.format(total1[27]),
                                Format.doubleFmt.format(total1[28]),
                                Format.doubleFmt.format(total1[29]),
                                Format.doubleFmt.format(total1[30]),
                                Format.doubleFmt.format(total1[31]),
                                Format.doubleFmt.format(total1[32]),
                                Format.doubleFmt.format(total1[33]),
                                Format.doubleFmt.format(total1[34]),
                                Format.doubleFmt.format(total1[35]),
                                Format.doubleFmt.format(total1[36]),
                                Format.doubleFmt.format(total1[37]),
                                Format.doubleFmt.format(total1[38]),
                                Format.doubleFmt.format(total1[39]),
                                Format.doubleFmt.format(total1[40]),
                                Format.doubleFmt.format(total1[41]),
                                Format.doubleFmt.format(total1[42]),
                                Format.doubleFmt.format(total1[43]),
                                Format.doubleFmt.format(total1[44]),
                                Format.doubleFmt.format(total1[45]),
                                Format.doubleFmt.format(total1[46]),
                                Format.doubleFmt.format(total1[47]),
                                Format.doubleFmt.format(total1[48]),
                                Format.doubleFmt.format(total1[49]),
                                Format.doubleFmt.format(total1[50]),
                                Format.doubleFmt.format(total1[51]),
                                Format.doubleFmt.format(total1[52]),
                                Format.doubleFmt.format(total1[53]),
                                Format.doubleFmt.format(total1[54]),
                                Format.doubleFmt.format(total1[55]),
                                Format.doubleFmt.format(total1[56])
                    ));
            myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
            else
            {
                
                while (rs.next()) {
                
                d_tempdate = rs.getDate("t_date");
                tempbran = rs.getString("s_bran");
                tempdate = rs.getString("t_date");
                tempbname = rs.getString("BranName");
                if(!tempbranold.equals(tempbran))
                {
                    if(subtree != null)
                    {
                        
                       //Format.doubleFmt.format(totalgroup1) subtree.getChildren().add(new MyTreeNode("Total Of Group","","","",Format.doubleFmt.format(totalgroup),""));
                        subtree.getChildren().add(new reportSumHourlyBean(tempbranold,
                                "Total Branch "+tempbranold,
                                Format.doubleFmt.format(totalgroup1[0]),
                                Format.doubleFmt.format(totalgroup1[1]),
                                Format.doubleFmt.format(totalgroup1[2]),
                                Format.doubleFmt.format(totalgroup1[3]),
                                Format.doubleFmt.format(totalgroup1[4]),
                                Format.doubleFmt.format(totalgroup1[5]),
                                Format.doubleFmt.format(totalgroup1[6]),
                                Format.doubleFmt.format(totalgroup1[7]),
                                Format.doubleFmt.format(totalgroup1[8]),
                                Format.doubleFmt.format(totalgroup1[9]),
                                Format.doubleFmt.format(totalgroup1[10]),
                                Format.doubleFmt.format(totalgroup1[11]),
                                Format.doubleFmt.format(totalgroup1[12]),
                                Format.doubleFmt.format(totalgroup1[13]),
                                Format.doubleFmt.format(totalgroup1[14]),
                                Format.doubleFmt.format(totalgroup1[15]),
                                Format.doubleFmt.format(totalgroup1[16]),
                                Format.doubleFmt.format(totalgroup1[17]),
                                Format.doubleFmt.format(totalgroup1[18]),
                                Format.doubleFmt.format(totalgroup1[19]),
                                Format.doubleFmt.format(totalgroup1[20]),
                                Format.doubleFmt.format(totalgroup1[21]),
                                Format.doubleFmt.format(totalgroup1[22]),
                                Format.doubleFmt.format(totalgroup1[23]),
                                Format.doubleFmt.format(totalgroup1[24]),
                                Format.doubleFmt.format(totalgroup1[25]),
                                Format.doubleFmt.format(totalgroup1[26]),
                                Format.doubleFmt.format(totalgroup1[27]),
                                Format.doubleFmt.format(totalgroup1[28]),
                                Format.doubleFmt.format(totalgroup1[29]),
                                Format.doubleFmt.format(totalgroup1[30]),
                                Format.doubleFmt.format(totalgroup1[31]),
                                Format.doubleFmt.format(totalgroup1[32]),
                                Format.doubleFmt.format(totalgroup1[33]),
                                Format.doubleFmt.format(totalgroup1[34]),
                                Format.doubleFmt.format(totalgroup1[35]),
                                Format.doubleFmt.format(totalgroup1[36]),
                                Format.doubleFmt.format(totalgroup1[37]),
                                Format.doubleFmt.format(totalgroup1[38]),
                                Format.doubleFmt.format(totalgroup1[39]),
                                Format.doubleFmt.format(totalgroup1[40]),
                                Format.doubleFmt.format(totalgroup1[41]),
                                Format.doubleFmt.format(totalgroup1[42]),
                                Format.doubleFmt.format(totalgroup1[43]),
                                Format.doubleFmt.format(totalgroup1[44]),
                                Format.doubleFmt.format(totalgroup1[45]),
                                Format.doubleFmt.format(totalgroup1[46]),
                                Format.doubleFmt.format(totalgroup1[47]),
                                Format.doubleFmt.format(totalgroup1[48]),
                                Format.doubleFmt.format(totalgroup1[49]),
                                Format.doubleFmt.format(totalgroup1[50]),
                                Format.doubleFmt.format(totalgroup1[51]),
                                Format.doubleFmt.format(totalgroup1[52]),
                                Format.doubleFmt.format(totalgroup1[53]),
                                Format.doubleFmt.format(totalgroup1[54]),
                                Format.doubleFmt.format(totalgroup1[55]),
                                Format.doubleFmt.format(totalgroup1[56])
                    ));
                        
                        
                        
                        subtree.setS_bran("Branch "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        myroot.getChildren().add(subtree);
                        for(int j = 0; j < totalgroup1.length; j++)
                            {
                                totalgroup1[j] = 0;
                            }
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportSumHourlyBean();
                    countgroup = 0;
                    i=1;
                        subtree.getChildren().add(new reportSumHourlyBean( rs.getString("s_bran"),
                                                                        rs.getString("tempday"),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt24")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt24")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt24"))
                                                                    ));
                        
                   
                       
                    
                }
                else
                {
                        
                         subtree.getChildren().add(new reportSumHourlyBean( rs.getString("s_bran"),
                                                                        rs.getString("tempday"),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt1")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt7")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt8")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt9")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt10")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt11")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt12")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt13")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt14")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt15")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt16")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt17")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt18")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt19")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt20")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt21")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt22")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt23")),
                                                                        Format.doubleFmt.format(rs.getDouble("pnt24")),
                                                                        Format.doubleFmt.format(rs.getDouble("cnt24")),
                                                                        Format.doubleFmt.format(rs.getDouble("amt24"))
                                                                    ));
                        
//                         
                    
                    
                    
                    
                }
                
                totalgroup1[0] += rs.getDouble("pnt1");
                totalgroup1[1] += rs.getDouble("cnt1");
                totalgroup1[2] += rs.getDouble("amt1");
                totalgroup1[3] += rs.getDouble("pnt7");
                totalgroup1[4] += rs.getDouble("cnt7");
                totalgroup1[5] += rs.getDouble("amt7");
                totalgroup1[6] += rs.getDouble("pnt8");
                totalgroup1[7] += rs.getDouble("cnt8");
                totalgroup1[8] += rs.getDouble("amt8");
                totalgroup1[9] += rs.getDouble("pnt9");
                totalgroup1[10] += rs.getDouble("cnt9");
                totalgroup1[11] += rs.getDouble("amt9");
                totalgroup1[12] += rs.getDouble("pnt10");
                totalgroup1[13] += rs.getDouble("cnt10");
                totalgroup1[14] += rs.getDouble("amt10");
                totalgroup1[15] += rs.getDouble("pnt11");
                totalgroup1[16] += rs.getDouble("cnt11");
                totalgroup1[17] += rs.getDouble("amt11");
                totalgroup1[18] += rs.getDouble("pnt12");
                totalgroup1[19] += rs.getDouble("cnt12");
                totalgroup1[20] += rs.getDouble("amt12");
                totalgroup1[21] += rs.getDouble("pnt13");
                totalgroup1[22] += rs.getDouble("cnt13");
                totalgroup1[23] += rs.getDouble("amt13");
                totalgroup1[24] += rs.getDouble("pnt14");
                totalgroup1[25] += rs.getDouble("cnt14");
                totalgroup1[26] += rs.getDouble("amt14");
                totalgroup1[27] += rs.getDouble("pnt15");
                totalgroup1[28] += rs.getDouble("cnt15");
                totalgroup1[29] += rs.getDouble("amt15");
                totalgroup1[30] += rs.getDouble("pnt16");
                totalgroup1[31] += rs.getDouble("cnt16");
                totalgroup1[32] += rs.getDouble("amt16");
                totalgroup1[33] += rs.getDouble("pnt17");
                totalgroup1[34] += rs.getDouble("cnt17");
                totalgroup1[35] += rs.getDouble("amt17");
                totalgroup1[36] += rs.getDouble("pnt18");
                totalgroup1[37] += rs.getDouble("cnt18");
                totalgroup1[38] += rs.getDouble("amt18");
                totalgroup1[39] += rs.getDouble("pnt19");
                totalgroup1[40] += rs.getDouble("cnt19");
                totalgroup1[41] += rs.getDouble("amt19");
                totalgroup1[42] += rs.getDouble("pnt20");
                totalgroup1[43] += rs.getDouble("cnt20");
                totalgroup1[44] += rs.getDouble("amt20");
                totalgroup1[45] += rs.getDouble("pnt21");
                totalgroup1[46] += rs.getDouble("cnt21");
                totalgroup1[47] += rs.getDouble("amt21");
                totalgroup1[48] += rs.getDouble("pnt22");
                totalgroup1[49] += rs.getDouble("cnt22");
                totalgroup1[50] += rs.getDouble("amt22");
                totalgroup1[51] += rs.getDouble("pnt23");
                totalgroup1[52] += rs.getDouble("cnt23");
                totalgroup1[53] += rs.getDouble("amt23");
                totalgroup1[54] += rs.getDouble("pnt24");
                totalgroup1[55] += rs.getDouble("cnt24");
                totalgroup1[56] += rs.getDouble("amt24");
                
               
                
                
                total1[0] += rs.getDouble("pnt1");
                total1[1] += rs.getDouble("cnt1");
                total1[2] += rs.getDouble("amt1");
                total1[3] += rs.getDouble("pnt7");
                total1[4] += rs.getDouble("cnt7");
                total1[5] += rs.getDouble("amt7");
                total1[6] += rs.getDouble("pnt8");
                total1[7] += rs.getDouble("cnt8");
                total1[8] += rs.getDouble("amt8");
                total1[9] += rs.getDouble("pnt9");
                total1[10] += rs.getDouble("cnt9");
                total1[11] += rs.getDouble("amt9");
                total1[12] += rs.getDouble("pnt10");
                total1[13] += rs.getDouble("cnt10");
                total1[14] += rs.getDouble("amt10");
                total1[15] += rs.getDouble("pnt11");
                total1[16] += rs.getDouble("cnt11");
                total1[17] += rs.getDouble("amt11");
                total1[18] += rs.getDouble("pnt12");
                total1[19] += rs.getDouble("cnt12");
                total1[20] += rs.getDouble("amt12");
                total1[21] += rs.getDouble("pnt13");
                total1[22] += rs.getDouble("cnt13");
                total1[23] += rs.getDouble("amt13");
                total1[24] += rs.getDouble("pnt14");
                total1[25] += rs.getDouble("cnt14");
                total1[26] += rs.getDouble("amt14");
                total1[27] += rs.getDouble("pnt15");
                total1[28] += rs.getDouble("cnt15");
                total1[29] += rs.getDouble("amt15");
                total1[30] += rs.getDouble("pnt16");
                total1[31] += rs.getDouble("cnt16");
                total1[32] += rs.getDouble("amt16");
                total1[33] += rs.getDouble("pnt17");
                total1[34] += rs.getDouble("cnt17");
                total1[35] += rs.getDouble("amt17");
                total1[36] += rs.getDouble("pnt18");
                total1[37] += rs.getDouble("cnt18");
                total1[38] += rs.getDouble("amt18");
                total1[39] += rs.getDouble("pnt19");
                total1[40] += rs.getDouble("cnt19");
                total1[41] += rs.getDouble("amt19");
                total1[42] += rs.getDouble("pnt20");
                total1[43] += rs.getDouble("cnt20");
                total1[44] += rs.getDouble("amt20");
                total1[45] += rs.getDouble("pnt21");
                total1[46] += rs.getDouble("cnt21");
                total1[47] += rs.getDouble("amt21");
                total1[48] += rs.getDouble("pnt22");
                total1[49] += rs.getDouble("cnt22");
                total1[50] += rs.getDouble("amt22");
                total1[51] += rs.getDouble("pnt23");
                total1[52] += rs.getDouble("cnt23");
                total1[53] += rs.getDouble("amt23");
                total1[54] += rs.getDouble("pnt24");
                total1[55] += rs.getDouble("cnt24");
                total1[56] += rs.getDouble("amt24");
                
                
               
                i++;
                countgroup++;
                counttotal++;
                countdate++;
                tempbranold = rs.getString("s_bran");
                tempdateold = rs.getString("t_date");
                tempbnameold = rs.getString("BranName");
                d_tempdateold = rs.getDate("t_date");
                
                
            }
          
           if(subtree != null)
           {
           subtree.getChildren().add(new reportSumHourlyBean(tempbran,
                                "Total Branch "+tempbran,
                                Format.doubleFmt.format(totalgroup1[0]),
                                Format.doubleFmt.format(totalgroup1[1]),
                                Format.doubleFmt.format(totalgroup1[2]),
                                Format.doubleFmt.format(totalgroup1[3]),
                                Format.doubleFmt.format(totalgroup1[4]),
                                Format.doubleFmt.format(totalgroup1[5]),
                                Format.doubleFmt.format(totalgroup1[6]),
                                Format.doubleFmt.format(totalgroup1[7]),
                                Format.doubleFmt.format(totalgroup1[8]),
                                Format.doubleFmt.format(totalgroup1[9]),
                                Format.doubleFmt.format(totalgroup1[10]),
                                Format.doubleFmt.format(totalgroup1[11]),
                                Format.doubleFmt.format(totalgroup1[12]),
                                Format.doubleFmt.format(totalgroup1[13]),
                                Format.doubleFmt.format(totalgroup1[14]),
                                Format.doubleFmt.format(totalgroup1[15]),
                                Format.doubleFmt.format(totalgroup1[16]),
                                Format.doubleFmt.format(totalgroup1[17]),
                                Format.doubleFmt.format(totalgroup1[18]),
                                Format.doubleFmt.format(totalgroup1[19]),
                                Format.doubleFmt.format(totalgroup1[20]),
                                Format.doubleFmt.format(totalgroup1[21]),
                                Format.doubleFmt.format(totalgroup1[22]),
                                Format.doubleFmt.format(totalgroup1[23]),
                                Format.doubleFmt.format(totalgroup1[24]),
                                Format.doubleFmt.format(totalgroup1[25]),
                                Format.doubleFmt.format(totalgroup1[26]),
                                Format.doubleFmt.format(totalgroup1[27]),
                                Format.doubleFmt.format(totalgroup1[28]),
                                Format.doubleFmt.format(totalgroup1[29]),
                                Format.doubleFmt.format(totalgroup1[30]),
                                Format.doubleFmt.format(totalgroup1[31]),
                                Format.doubleFmt.format(totalgroup1[32]),
                                Format.doubleFmt.format(totalgroup1[33]),
                                Format.doubleFmt.format(totalgroup1[34]),
                                Format.doubleFmt.format(totalgroup1[35]),
                                Format.doubleFmt.format(totalgroup1[36]),
                                Format.doubleFmt.format(totalgroup1[37]),
                                Format.doubleFmt.format(totalgroup1[38]),
                                Format.doubleFmt.format(totalgroup1[39]),
                                Format.doubleFmt.format(totalgroup1[40]),
                                Format.doubleFmt.format(totalgroup1[41]),
                                Format.doubleFmt.format(totalgroup1[42]),
                                Format.doubleFmt.format(totalgroup1[43]),
                                Format.doubleFmt.format(totalgroup1[44]),
                                Format.doubleFmt.format(totalgroup1[45]),
                                Format.doubleFmt.format(totalgroup1[46]),
                                Format.doubleFmt.format(totalgroup1[47]),
                                Format.doubleFmt.format(totalgroup1[48]),
                                Format.doubleFmt.format(totalgroup1[49]),
                                Format.doubleFmt.format(totalgroup1[50]),
                                Format.doubleFmt.format(totalgroup1[51]),
                                Format.doubleFmt.format(totalgroup1[52]),
                                Format.doubleFmt.format(totalgroup1[53]),
                                Format.doubleFmt.format(totalgroup1[54]),
                                Format.doubleFmt.format(totalgroup1[55]),
                                Format.doubleFmt.format(totalgroup1[56])
                    ));
            subtree.setS_bran("Branch "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
            
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
//           for(int j=0; j<total1.length;j++) {
//           JOptionPane.showMessageDialog(null, Format.doubleFmt.format(total1[j]));
//            }
             myroot.getChildren().add(new reportSumHourlyBean("Total All",
                                "",
                                Format.doubleFmt.format(total1[0]),
                                Format.doubleFmt.format(total1[1]),
                                Format.doubleFmt.format(total1[2]),
                                Format.doubleFmt.format(total1[3]),
                                Format.doubleFmt.format(total1[4]),
                                Format.doubleFmt.format(total1[5]),
                                Format.doubleFmt.format(total1[6]),
                                Format.doubleFmt.format(total1[7]),
                                Format.doubleFmt.format(total1[8]),
                                Format.doubleFmt.format(total1[9]),
                                Format.doubleFmt.format(total1[10]),
                                Format.doubleFmt.format(total1[11]),
                                Format.doubleFmt.format(total1[12]),
                                Format.doubleFmt.format(total1[13]),
                                Format.doubleFmt.format(total1[14]),
                                Format.doubleFmt.format(total1[15]),
                                Format.doubleFmt.format(total1[16]),
                                Format.doubleFmt.format(total1[17]),
                                Format.doubleFmt.format(total1[18]),
                                Format.doubleFmt.format(total1[19]),
                                Format.doubleFmt.format(total1[20]),
                                Format.doubleFmt.format(total1[21]),
                                Format.doubleFmt.format(total1[22]),
                                Format.doubleFmt.format(total1[23]),
                                Format.doubleFmt.format(total1[24]),
                                Format.doubleFmt.format(total1[25]),
                                Format.doubleFmt.format(total1[26]),
                                Format.doubleFmt.format(total1[27]),
                                Format.doubleFmt.format(total1[28]),
                                Format.doubleFmt.format(total1[29]),
                                Format.doubleFmt.format(total1[30]),
                                Format.doubleFmt.format(total1[31]),
                                Format.doubleFmt.format(total1[32]),
                                Format.doubleFmt.format(total1[33]),
                                Format.doubleFmt.format(total1[34]),
                                Format.doubleFmt.format(total1[35]),
                                Format.doubleFmt.format(total1[36]),
                                Format.doubleFmt.format(total1[37]),
                                Format.doubleFmt.format(total1[38]),
                                Format.doubleFmt.format(total1[39]),
                                Format.doubleFmt.format(total1[40]),
                                Format.doubleFmt.format(total1[41]),
                                Format.doubleFmt.format(total1[42]),
                                Format.doubleFmt.format(total1[43]),
                                Format.doubleFmt.format(total1[44]),
                                Format.doubleFmt.format(total1[45]),
                                Format.doubleFmt.format(total1[46]),
                                Format.doubleFmt.format(total1[47]),
                                Format.doubleFmt.format(total1[48]),
                                Format.doubleFmt.format(total1[49]),
                                Format.doubleFmt.format(total1[50]),
                                Format.doubleFmt.format(total1[51]),
                                Format.doubleFmt.format(total1[52]),
                                Format.doubleFmt.format(total1[53]),
                                Format.doubleFmt.format(total1[54]),
                                Format.doubleFmt.format(total1[55]),
                                Format.doubleFmt.format(total1[56])
                    ));
                myroot.setS_bran("Report List Of "+counttotal+" Record");
            }
    }
        
        
      @Override
	public int getColumnCount() 
	{
		return 59;
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
		reportSumHourlyBean treenode = ( reportSumHourlyBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
		case 1: return treenode.getS_date();
		case 2: return treenode.getPnt1();
                case 3: return treenode.getCnt1();
                case 4: return treenode.getAmt1();
                case 5: return treenode.getPnt2();
                case 6: return treenode.getCnt2();
		case 7: return treenode.getAmt2();
		case 8: return treenode.getPnt3();
                case 9: return treenode.getCnt3();
                case 10: return treenode.getAmt3();
                case 11: return treenode.getPnt4();
                case 12: return treenode.getCnt4();
		case 13: return treenode.getAmt4();
		case 14: return treenode.getPnt5();
                case 15: return treenode.getCnt5();
                case 16: return treenode.getAmt5();
                case 17: return treenode.getPnt6();
                case 18: return treenode.getCnt6();
                case 19: return treenode.getAmt6();
                case 20: return treenode.getPnt7();
                case 21: return treenode.getCnt7();
                case 22: return treenode.getAmt7();
                case 23: return treenode.getPnt8();
                case 24: return treenode.getCnt8();
                case 25: return treenode.getAmt8();
                case 26: return treenode.getPnt9();
                case 27: return treenode.getCnt9();
                case 28: return treenode.getAmt9();
                case 29: return treenode.getPnt10();
                case 30: return treenode.getCnt10();
                case 31: return treenode.getAmt10();
                case 32: return treenode.getPnt11();
                case 33: return treenode.getCnt11();
                case 34: return treenode.getAmt11();
                case 35: return treenode.getPnt12();
                case 36: return treenode.getCnt12();
                case 37: return treenode.getAmt12();
                case 38: return treenode.getPnt13();
                case 39: return treenode.getCnt13();
                case 40: return treenode.getAmt13();
                case 41: return treenode.getPnt14();
                case 42: return treenode.getCnt14();
                case 43: return treenode.getAmt14();
                case 44: return treenode.getPnt15();
                case 45: return treenode.getCnt15();
                case 46: return treenode.getAmt15();
                case 47: return treenode.getPnt16();
                case 48: return treenode.getCnt16();
                case 49: return treenode.getAmt16();
                case 50: return treenode.getPnt17();
                case 51: return treenode.getCnt17();
                case 52: return treenode.getAmt17();
                case 53: return treenode.getPnt18();
                case 54: return treenode.getCnt18();
                case 55: return treenode.getAmt18();
                case 56: return treenode.getPnt19();
                case 57: return treenode.getCnt19();
                case 58: return treenode.getAmt19();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportSumHourlyBean treenode = ( reportSumHourlyBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportSumHourlyBean treenode = ( reportSumHourlyBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportSumHourlyBean treenode = ( reportSumHourlyBean )parent;
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
		 reportSumHourlyBean treenode = ( reportSumHourlyBean )node;
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
