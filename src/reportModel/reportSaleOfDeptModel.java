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
public class reportSaleOfDeptModel extends AbstractTreeTableModel 
{
        private Statement stmt;
	private reportSaleOfDeptBean myroot;
        ThaiUtilities cvth = new ThaiUtilities();
        dbUtility db = new dbUtility();
    public reportSaleOfDeptModel(String sql) throws SQLException
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
            double total1 = 0,total2 = 0,total3 = 0,total4 = 0,total5 = 0,total6 = 0,total7 = 0,total8= 0,total9 = 0
                   ,total10 = 0,total11 = 0,total12 = 0,total13 = 0,total14 = 0,total15 = 0,total16 = 0,total17= 0,total18 = 0
                    ,total19 = 0,total20 = 0,total21 = 0,total22 = 0,total23 = 0,total24 = 0,total25 = 0,total26 = 0;
            double totalgroup1 = 0,totalgroup2 = 0,totalgroup3 = 0,totalgroup4 = 0,totalgroup5 = 0,totalgroup6 = 0
                    ,totalgroup7 = 0,totalgroup8 = 0,totalgroup9 = 0,totalgroup10 = 0,totalgroup11 = 0,totalgroup12 = 0
                    ,totalgroup13 = 0,totalgroup14 = 0,totalgroup15 = 0,totalgroup16 = 0,totalgroup17 = 0,totalgroup18 = 0
                    ,totalgroup19 = 0,totalgroup20 = 0,totalgroup21 = 0,totalgroup22 = 0,totalgroup23 = 0,totalgroup24 = 0
                    ,totalgroup25 = 0,totalgroup26 = 0;
            
            double[] totaldate = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            int countgroup = 0;
            int counttotal = 0;
            int countdate = 0;
            int i=1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            
            rs = stmt.executeQuery(sql);
            reportSaleOfDeptBean subtree = null;
            reportSaleOfDeptBean datetree = null;
            myroot = new reportSaleOfDeptBean( "รายงานททั้งหมด","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
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
                        subtree.getChildren().add(new reportSaleOfDeptBean(tempbranold,"","","Total Branch "+tempbranold,Format.doubleFmt.format(totalgroup2),Format.doubleFmt.format(totalgroup3),Format.doubleFmt.format(totalgroup4)
                        ,Format.doubleFmt.format(totalgroup5),Format.doubleFmt.format(totalgroup6)
                        ,Format.doubleFmt.format(totalgroup7),Format.doubleFmt.format(totalgroup8)
                        ,Format.doubleFmt.format(totalgroup9),Format.doubleFmt.format(totalgroup10),Format.doubleFmt.format(totalgroup11)
                        ,Format.doubleFmt.format(totalgroup12),Format.doubleFmt.format(totalgroup13)
                        ,Format.doubleFmt.format(totalgroup14),Format.doubleFmt.format(totalgroup15)
                        ,Format.doubleFmt.format(totalgroup16),Format.doubleFmt.format(totalgroup17)
                        ,Format.doubleFmt.format(totalgroup18),Format.doubleFmt.format(totalgroup19)
                        ,Format.doubleFmt.format(totalgroup20),Format.doubleFmt.format(totalgroup21)
                        ,Format.doubleFmt.format(totalgroup22),Format.doubleFmt.format(totalgroup23)
                        ,Format.doubleFmt.format(totalgroup24),Format.doubleFmt.format(totalgroup25)
                         ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;totalgroup4 = 0;totalgroup5 = 0;totalgroup6 = 0;
                        totalgroup7 = 0;totalgroup8 = 0;totalgroup9 = 0;totalgroup10 = 0;totalgroup11 = 0;totalgroup12 = 0;
                        totalgroup13 = 0;totalgroup14 = 0;totalgroup15 = 0;totalgroup16 = 0;totalgroup17 = 0;totalgroup18 = 0;
                        totalgroup19 = 0;totalgroup20 = 0;totalgroup21 = 0;totalgroup22 = 0;totalgroup23 = 0;totalgroup24 = 0;
                        totalgroup25 = 0;totalgroup26 = 0;
                        subtree.setS_bran("Branch "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportSaleOfDeptBean();
                    countgroup = 0;
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
                        if(datetree!=null)
                        {
                            datetree.getChildren().add(new reportSaleOfDeptBean(tempbranold,"",""
                            ,"Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold),Format.doubleFmt.format(totaldate[1])
                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
                            ,Format.doubleFmt.format(totaldate[4]),Format.doubleFmt.format(totaldate[5])
                            ,Format.doubleFmt.format(totaldate[6]),Format.doubleFmt.format(totaldate[7])
                            ,Format.doubleFmt.format(totaldate[8]),Format.doubleFmt.format(totaldate[9]),Format.doubleFmt.format(totaldate[10])
                            ,Format.doubleFmt.format(totaldate[11]),Format.doubleFmt.format(totaldate[12])
                            ,Format.doubleFmt.format(totaldate[13]),Format.doubleFmt.format(totaldate[14])
                            ,Format.doubleFmt.format(totaldate[15]),Format.doubleFmt.format(totaldate[16])
                            ,Format.doubleFmt.format(totaldate[17]),Format.doubleFmt.format(totaldate[18])
                            ,Format.doubleFmt.format(totaldate[19]),Format.doubleFmt.format(totaldate[20])
                            ,Format.doubleFmt.format(totaldate[21]),Format.doubleFmt.format(totaldate[22])
                            ,Format.doubleFmt.format(totaldate[23]),Format.doubleFmt.format(totaldate[24])
                    ));
                            for(int j = 0; j < totaldate.length; j++)
                            {
                                totaldate[j] = 0;
                            }
                        }
                        
                        datetree = new reportSaleOfDeptBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportSaleOfDeptBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("groupname")),
                                                                        Format.integerFmt.format(rs.getInt("e_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_net")),
                                                                        Format.integerFmt.format(rs.getInt("t_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_net")),
                                                                        Format.integerFmt.format(rs.getInt("d_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_net")),
                                                                        Format.integerFmt.format(rs.getInt("p_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_net")),
                                                                        Format.integerFmt.format(rs.getInt("w_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_net")),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_net"))
                                                                    ));
                        
                    }
                    else
                    {
                        
                        datetree.getChildren().add(new reportSaleOfDeptBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("groupname")),
                                                                        Format.integerFmt.format(rs.getInt("e_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_net")),
                                                                        Format.integerFmt.format(rs.getInt("t_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_net")),
                                                                        Format.integerFmt.format(rs.getInt("d_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_net")),
                                                                        Format.integerFmt.format(rs.getInt("p_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_net")),
                                                                        Format.integerFmt.format(rs.getInt("w_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_net")),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_net"))
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
                            datetree.getChildren().add(new reportSaleOfDeptBean(tempbranold,"",""
                                    ,"Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold),Format.doubleFmt.format(totaldate[1])
                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
                            ,Format.doubleFmt.format(totaldate[4]),Format.doubleFmt.format(totaldate[5])
                            ,Format.doubleFmt.format(totaldate[6]),Format.doubleFmt.format(totaldate[7])
                            ,Format.doubleFmt.format(totaldate[8]),Format.doubleFmt.format(totaldate[9]),Format.doubleFmt.format(totaldate[10])
                            ,Format.doubleFmt.format(totaldate[11]),Format.doubleFmt.format(totaldate[12])
                            ,Format.doubleFmt.format(totaldate[13]),Format.doubleFmt.format(totaldate[14])
                            ,Format.doubleFmt.format(totaldate[15]),Format.doubleFmt.format(totaldate[16])
                            ,Format.doubleFmt.format(totaldate[17]),Format.doubleFmt.format(totaldate[18])
                            ,Format.doubleFmt.format(totaldate[19]),Format.doubleFmt.format(totaldate[20])
                            ,Format.doubleFmt.format(totaldate[21]),Format.doubleFmt.format(totaldate[22])
                            ,Format.doubleFmt.format(totaldate[23]),Format.doubleFmt.format(totaldate[24])
                    ));
                        for(int j = 0; j < totaldate.length; j++)
                            {
                                totaldate[j] = 0;
                            }
                        }
                        
                        datetree = new reportSaleOfDeptBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",cvth.ASCII2Unicode(rs.getString("s_pcode")),cvth.ASCII2Unicode(rs.getString("pdesc")),cvth.ASCII2Unicode(rs.getString("pprice11")),cvth.ASCII2Unicode(rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportSaleOfDeptBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("groupname")),
                                                                        Format.integerFmt.format(rs.getInt("e_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_net")),
                                                                        Format.integerFmt.format(rs.getInt("t_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_net")),
                                                                        Format.integerFmt.format(rs.getInt("d_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_net")),
                                                                        Format.integerFmt.format(rs.getInt("p_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_net")),
                                                                        Format.integerFmt.format(rs.getInt("w_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_net")),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_net"))
                                                                    ));
                        
                    }
                    else
                    {
                        
                        datetree.getChildren().add(new reportSaleOfDeptBean( cvth.ASCII2Unicode(rs.getString("s_bran")),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        cvth.ASCII2Unicode(rs.getString("pgroup")),
                                                                        cvth.ASCII2Unicode(rs.getString("groupname")),
                                                                        Format.integerFmt.format(rs.getInt("e_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_net")),
                                                                        Format.integerFmt.format(rs.getInt("t_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_net")),
                                                                        Format.integerFmt.format(rs.getInt("d_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_net")),
                                                                        Format.integerFmt.format(rs.getInt("p_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_net")),
                                                                        Format.integerFmt.format(rs.getInt("w_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_net")),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_net"))
                                                                    ));
                    
                    }
                    
                    
                }
                
                totalgroup2 += rs.getDouble("e_qty");
                totalgroup3 += rs.getDouble("e_amt");
                totalgroup4 += rs.getDouble("e_disc");
                totalgroup5 += rs.getDouble("e_net");
                totalgroup6 += rs.getDouble("t_qty");
                totalgroup7 += rs.getDouble("t_amt");
                totalgroup8 += rs.getDouble("t_disc");
                totalgroup9 += rs.getDouble("t_net");
                totalgroup10 += rs.getDouble("d_qty");
                totalgroup11 += rs.getDouble("d_amt");
                totalgroup12 += rs.getDouble("d_disc");
                totalgroup13 += rs.getDouble("d_net");
                totalgroup14 += rs.getDouble("p_qty");
                totalgroup15 += rs.getDouble("p_amt");
                totalgroup16 += rs.getDouble("p_disc");
                totalgroup17 += rs.getDouble("p_net");
                totalgroup18 += rs.getDouble("w_qty");
                totalgroup19 += rs.getDouble("w_amt");
                totalgroup20 += rs.getDouble("w_disc");
                totalgroup21 += rs.getDouble("w_net");
                totalgroup22 += rs.getDouble("s_qty");
                totalgroup23 += rs.getDouble("s_amt");
                totalgroup24 += rs.getDouble("s_disc");
                totalgroup25 += rs.getDouble("s_net");
                
                totaldate[1] += rs.getDouble("e_qty");
                totaldate[2] += rs.getDouble("e_amt");
                totaldate[3] += rs.getDouble("e_disc");
                totaldate[4] += rs.getDouble("e_net");
                totaldate[5] += rs.getDouble("t_qty");
                totaldate[6] += rs.getDouble("t_amt");
                totaldate[7] += rs.getDouble("t_disc");
                totaldate[8] += rs.getDouble("t_net");
                totaldate[9] += rs.getDouble("d_qty");
                totaldate[10] += rs.getDouble("d_amt");
                totaldate[11] += rs.getDouble("d_disc");
                totaldate[12] += rs.getDouble("d_net");
                totaldate[13] += rs.getDouble("p_qty");
                totaldate[14] += rs.getDouble("p_amt");
                totaldate[15] += rs.getDouble("p_disc");
                totaldate[16] += rs.getDouble("p_net");
                totaldate[17] += rs.getDouble("w_qty");
                totaldate[18] += rs.getDouble("w_amt");
                totaldate[19] += rs.getDouble("w_disc");
                totaldate[20] += rs.getDouble("w_net");
                totaldate[21] += rs.getDouble("s_qty");
                totaldate[22] += rs.getDouble("s_amt");
                totaldate[23] += rs.getDouble("s_disc");
                totaldate[24] += rs.getDouble("s_net");
                
                
                total2 += rs.getDouble("e_qty");
                total3 += rs.getDouble("e_amt");
                total4 += rs.getDouble("e_disc");
                total5 += rs.getDouble("e_net");
                total6 += rs.getDouble("t_qty");
                total7 += rs.getDouble("t_amt");
                total8 += rs.getDouble("t_disc");
                total9 += rs.getDouble("t_net");
                total10 += rs.getDouble("d_qty");
                total11 += rs.getDouble("d_amt");
                total12 += rs.getDouble("d_disc");
                total13 += rs.getDouble("d_net");
                total14 += rs.getDouble("p_qty");
                total15 += rs.getDouble("p_amt");
                total16 += rs.getDouble("p_disc");
                total17 += rs.getDouble("p_net");
                total18 += rs.getDouble("w_qty");
                total19 += rs.getDouble("w_amt");
                total20 += rs.getDouble("w_disc");
                total21 += rs.getDouble("w_net");
                total22 += rs.getDouble("s_qty");
                total23 += rs.getDouble("s_amt");
                total24 += rs.getDouble("s_disc");
                total25 += rs.getDouble("s_net");
//                totalall +=price;
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
                            datetree.getChildren().add(new reportSaleOfDeptBean(tempbran,"","","Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdate),Format.doubleFmt.format(totaldate[1])
                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
                            ,Format.doubleFmt.format(totaldate[4]),Format.doubleFmt.format(totaldate[5])
                            ,Format.doubleFmt.format(totaldate[6]),Format.doubleFmt.format(totaldate[7])
                            ,Format.doubleFmt.format(totaldate[8]),Format.doubleFmt.format(totaldate[9]),Format.doubleFmt.format(totaldate[10])
                            ,Format.doubleFmt.format(totaldate[11]),Format.doubleFmt.format(totaldate[12])
                            ,Format.doubleFmt.format(totaldate[13]),Format.doubleFmt.format(totaldate[14])
                            ,Format.doubleFmt.format(totaldate[15]),Format.doubleFmt.format(totaldate[16])
                            ,Format.doubleFmt.format(totaldate[17]),Format.doubleFmt.format(totaldate[18])
                            ,Format.doubleFmt.format(totaldate[19]),Format.doubleFmt.format(totaldate[20])
                            ,Format.doubleFmt.format(totaldate[21]),Format.doubleFmt.format(totaldate[22])
                            ,Format.doubleFmt.format(totaldate[23]),Format.doubleFmt.format(totaldate[24])
                    ));
                        }
            
           if(subtree != null)
           {
            subtree.getChildren().add(new reportSaleOfDeptBean(tempbran,"","","Total Branch "+tempbran,Format.doubleFmt.format(totalgroup2),Format.doubleFmt.format(totalgroup3),Format.doubleFmt.format(totalgroup4)
                    ,Format.doubleFmt.format(totalgroup5),Format.doubleFmt.format(totalgroup6)
                    ,Format.doubleFmt.format(totalgroup7),Format.doubleFmt.format(totalgroup8)
                    ,Format.doubleFmt.format(totalgroup9),Format.doubleFmt.format(totalgroup10),Format.doubleFmt.format(totalgroup11)
                    ,Format.doubleFmt.format(totalgroup12),Format.doubleFmt.format(totalgroup13)
                    ,Format.doubleFmt.format(totalgroup14),Format.doubleFmt.format(totalgroup15)
                    ,Format.doubleFmt.format(totalgroup16),Format.doubleFmt.format(totalgroup17)
                    ,Format.doubleFmt.format(totalgroup18),Format.doubleFmt.format(totalgroup19)
                    ,Format.doubleFmt.format(totalgroup20),Format.doubleFmt.format(totalgroup21)
                    ,Format.doubleFmt.format(totalgroup22),Format.doubleFmt.format(totalgroup23)
                    ,Format.doubleFmt.format(totalgroup24),Format.doubleFmt.format(totalgroup25)
                    ));
            subtree.setS_bran("Branch "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            myroot.getChildren().add(new reportSaleOfDeptBean("Total All","","",""
                    ,Format.doubleFmt.format(total2),Format.doubleFmt.format(total3),Format.doubleFmt.format(total4)
                    ,Format.doubleFmt.format(total5),Format.doubleFmt.format(total6)
                    ,Format.doubleFmt.format(total7),Format.doubleFmt.format(total8)
                    ,Format.doubleFmt.format(total9),Format.doubleFmt.format(total10),Format.doubleFmt.format(total11)
                    ,Format.doubleFmt.format(total12),Format.doubleFmt.format(total13)
                    ,Format.doubleFmt.format(total14),Format.doubleFmt.format(total15)
                    ,Format.doubleFmt.format(total16),Format.doubleFmt.format(total17)
                    ,Format.doubleFmt.format(total18),Format.doubleFmt.format(total19)
                    ,Format.doubleFmt.format(total20),Format.doubleFmt.format(total21)
                    ,Format.doubleFmt.format(total22),Format.doubleFmt.format(total23)
                    ,Format.doubleFmt.format(total24),Format.doubleFmt.format(total25)
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
                        subtree.getChildren().add(new reportSaleOfDeptBean(tempbranold,"","","Total Branch "+tempbranold,Format.doubleFmt.format(totalgroup2),Format.doubleFmt.format(totalgroup3),Format.doubleFmt.format(totalgroup4)
                        ,Format.doubleFmt.format(totalgroup5),Format.doubleFmt.format(totalgroup6)
                        ,Format.doubleFmt.format(totalgroup7),Format.doubleFmt.format(totalgroup8)
                        ,Format.doubleFmt.format(totalgroup9),Format.doubleFmt.format(totalgroup10),Format.doubleFmt.format(totalgroup11)
                        ,Format.doubleFmt.format(totalgroup12),Format.doubleFmt.format(totalgroup13)
                        ,Format.doubleFmt.format(totalgroup14),Format.doubleFmt.format(totalgroup15)
                        ,Format.doubleFmt.format(totalgroup16),Format.doubleFmt.format(totalgroup17)
                        ,Format.doubleFmt.format(totalgroup18),Format.doubleFmt.format(totalgroup19)
                        ,Format.doubleFmt.format(totalgroup20),Format.doubleFmt.format(totalgroup21)
                        ,Format.doubleFmt.format(totalgroup22),Format.doubleFmt.format(totalgroup23)
                        ,Format.doubleFmt.format(totalgroup24),Format.doubleFmt.format(totalgroup25)
                         ));
                        myroot.getChildren().add(subtree);
                        totalgroup1 = 0;totalgroup2 = 0;totalgroup3 = 0;totalgroup4 = 0;totalgroup5 = 0;totalgroup6 = 0;
                        totalgroup7 = 0;totalgroup8 = 0;totalgroup9 = 0;totalgroup10 = 0;totalgroup11 = 0;totalgroup12 = 0;
                        totalgroup13 = 0;totalgroup14 = 0;totalgroup15 = 0;totalgroup16 = 0;totalgroup17 = 0;totalgroup18 = 0;
                        totalgroup19 = 0;totalgroup20 = 0;totalgroup21 = 0;totalgroup22 = 0;totalgroup23 = 0;totalgroup24 = 0;
                        totalgroup25 = 0;totalgroup26 = 0;
                        subtree.setS_bran("Branch "+tempbranold+" "+tempbnameold +" Total "+countgroup+" Record");
                        //subtree = new reportSaleOfPluBean( rs.getString("s_bran"),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                    }
                    
                    subtree = new reportSaleOfDeptBean();
                    countgroup = 0;
                    if(!tempdateold.equals(tempdate))
                    {
                        i=1;
                        if(datetree!=null)
                        {
                            datetree.getChildren().add(new reportSaleOfDeptBean(tempbranold,"",""
                            ,"Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold),Format.doubleFmt.format(totaldate[1])
                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
                            ,Format.doubleFmt.format(totaldate[4]),Format.doubleFmt.format(totaldate[5])
                            ,Format.doubleFmt.format(totaldate[6]),Format.doubleFmt.format(totaldate[7])
                            ,Format.doubleFmt.format(totaldate[8]),Format.doubleFmt.format(totaldate[9]),Format.doubleFmt.format(totaldate[10])
                            ,Format.doubleFmt.format(totaldate[11]),Format.doubleFmt.format(totaldate[12])
                            ,Format.doubleFmt.format(totaldate[13]),Format.doubleFmt.format(totaldate[14])
                            ,Format.doubleFmt.format(totaldate[15]),Format.doubleFmt.format(totaldate[16])
                            ,Format.doubleFmt.format(totaldate[17]),Format.doubleFmt.format(totaldate[18])
                            ,Format.doubleFmt.format(totaldate[19]),Format.doubleFmt.format(totaldate[20])
                            ,Format.doubleFmt.format(totaldate[21]),Format.doubleFmt.format(totaldate[22])
                            ,Format.doubleFmt.format(totaldate[23]),Format.doubleFmt.format(totaldate[24])
                    ));
                            for(int j = 0; j < totaldate.length; j++)
                            {
                                totaldate[j] = 0;
                            }
                        }
                        
                        datetree = new reportSaleOfDeptBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",rs.getString("s_pcode")),rs.getString("pdesc")),rs.getString("pprice11")),rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportSaleOfDeptBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("pgroup"),
                                                                        rs.getString("groupname"),
                                                                        Format.integerFmt.format(rs.getInt("e_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_net")),
                                                                        Format.integerFmt.format(rs.getInt("t_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_net")),
                                                                        Format.integerFmt.format(rs.getInt("d_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_net")),
                                                                        Format.integerFmt.format(rs.getInt("p_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_net")),
                                                                        Format.integerFmt.format(rs.getInt("w_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_net")),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_net"))
                                                                    ));
                        
                    }
                    else
                    {
                        
                        datetree.getChildren().add(new reportSaleOfDeptBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("pgroup"),
                                                                        rs.getString("groupname"),
                                                                        Format.integerFmt.format(rs.getInt("e_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_net")),
                                                                        Format.integerFmt.format(rs.getInt("t_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_net")),
                                                                        Format.integerFmt.format(rs.getInt("d_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_net")),
                                                                        Format.integerFmt.format(rs.getInt("p_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_net")),
                                                                        Format.integerFmt.format(rs.getInt("w_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_net")),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_net"))
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
                            datetree.getChildren().add(new reportSaleOfDeptBean(tempbranold,"",""
                                    ,"Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdateold),Format.doubleFmt.format(totaldate[1])
                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
                            ,Format.doubleFmt.format(totaldate[4]),Format.doubleFmt.format(totaldate[5])
                            ,Format.doubleFmt.format(totaldate[6]),Format.doubleFmt.format(totaldate[7])
                            ,Format.doubleFmt.format(totaldate[8]),Format.doubleFmt.format(totaldate[9]),Format.doubleFmt.format(totaldate[10])
                            ,Format.doubleFmt.format(totaldate[11]),Format.doubleFmt.format(totaldate[12])
                            ,Format.doubleFmt.format(totaldate[13]),Format.doubleFmt.format(totaldate[14])
                            ,Format.doubleFmt.format(totaldate[15]),Format.doubleFmt.format(totaldate[16])
                            ,Format.doubleFmt.format(totaldate[17]),Format.doubleFmt.format(totaldate[18])
                            ,Format.doubleFmt.format(totaldate[19]),Format.doubleFmt.format(totaldate[20])
                            ,Format.doubleFmt.format(totaldate[21]),Format.doubleFmt.format(totaldate[22])
                            ,Format.doubleFmt.format(totaldate[23]),Format.doubleFmt.format(totaldate[24])
                    ));
                        for(int j = 0; j < totaldate.length; j++)
                            {
                                totaldate[j] = 0;
                            }
                        }
                        
                        datetree = new reportSaleOfDeptBean("Date "+utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),"","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                        subtree.getChildren().add(datetree);
                        //datetree.getChildren().add(new MyTreeNode( "Items "+i, "",rs.getString("s_pcode")),rs.getString("pdesc")),rs.getString("pprice11")),rs.getString("punit1")) ));
                        datetree.getChildren().add(new reportSaleOfDeptBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("pgroup"),
                                                                        rs.getString("groupname"),
                                                                        Format.integerFmt.format(rs.getInt("e_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_net")),
                                                                        Format.integerFmt.format(rs.getInt("t_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_net")),
                                                                        Format.integerFmt.format(rs.getInt("d_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_net")),
                                                                        Format.integerFmt.format(rs.getInt("p_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_net")),
                                                                        Format.integerFmt.format(rs.getInt("w_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_net")),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_net"))
                                                                    ));
                        
                    }
                    else
                    {
                        
                        datetree.getChildren().add(new reportSaleOfDeptBean( rs.getString("s_bran"),
                                                                        utilititiesfunction.Format.dateFmtShow.format(rs.getDate("s_date")),
                                                                        rs.getString("pgroup"),
                                                                        rs.getString("groupname"),
                                                                        Format.integerFmt.format(rs.getInt("e_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("e_net")),
                                                                        Format.integerFmt.format(rs.getInt("t_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("t_net")),
                                                                        Format.integerFmt.format(rs.getInt("d_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("d_net")),
                                                                        Format.integerFmt.format(rs.getInt("p_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("p_net")),
                                                                        Format.integerFmt.format(rs.getInt("w_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("w_net")),
                                                                        Format.integerFmt.format(rs.getInt("s_qty")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_amt")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_disc")),
                                                                        Format.doubleFmt.format(rs.getDouble("s_net"))
                                                                    ));
                    
                    }
                    
                    
                }
                
                totalgroup2 += rs.getDouble("e_qty");
                totalgroup3 += rs.getDouble("e_amt");
                totalgroup4 += rs.getDouble("e_disc");
                totalgroup5 += rs.getDouble("e_net");
                totalgroup6 += rs.getDouble("t_qty");
                totalgroup7 += rs.getDouble("t_amt");
                totalgroup8 += rs.getDouble("t_disc");
                totalgroup9 += rs.getDouble("t_net");
                totalgroup10 += rs.getDouble("d_qty");
                totalgroup11 += rs.getDouble("d_amt");
                totalgroup12 += rs.getDouble("d_disc");
                totalgroup13 += rs.getDouble("d_net");
                totalgroup14 += rs.getDouble("p_qty");
                totalgroup15 += rs.getDouble("p_amt");
                totalgroup16 += rs.getDouble("p_disc");
                totalgroup17 += rs.getDouble("p_net");
                totalgroup18 += rs.getDouble("w_qty");
                totalgroup19 += rs.getDouble("w_amt");
                totalgroup20 += rs.getDouble("w_disc");
                totalgroup21 += rs.getDouble("w_net");
                totalgroup22 += rs.getDouble("s_qty");
                totalgroup23 += rs.getDouble("s_amt");
                totalgroup24 += rs.getDouble("s_disc");
                totalgroup25 += rs.getDouble("s_net");
                
                totaldate[1] += rs.getDouble("e_qty");
                totaldate[2] += rs.getDouble("e_amt");
                totaldate[3] += rs.getDouble("e_disc");
                totaldate[4] += rs.getDouble("e_net");
                totaldate[5] += rs.getDouble("t_qty");
                totaldate[6] += rs.getDouble("t_amt");
                totaldate[7] += rs.getDouble("t_disc");
                totaldate[8] += rs.getDouble("t_net");
                totaldate[9] += rs.getDouble("d_qty");
                totaldate[10] += rs.getDouble("d_amt");
                totaldate[11] += rs.getDouble("d_disc");
                totaldate[12] += rs.getDouble("d_net");
                totaldate[13] += rs.getDouble("p_qty");
                totaldate[14] += rs.getDouble("p_amt");
                totaldate[15] += rs.getDouble("p_disc");
                totaldate[16] += rs.getDouble("p_net");
                totaldate[17] += rs.getDouble("w_qty");
                totaldate[18] += rs.getDouble("w_amt");
                totaldate[19] += rs.getDouble("w_disc");
                totaldate[20] += rs.getDouble("w_net");
                totaldate[21] += rs.getDouble("s_qty");
                totaldate[22] += rs.getDouble("s_amt");
                totaldate[23] += rs.getDouble("s_disc");
                totaldate[24] += rs.getDouble("s_net");
                
                
                total2 += rs.getDouble("e_qty");
                total3 += rs.getDouble("e_amt");
                total4 += rs.getDouble("e_disc");
                total5 += rs.getDouble("e_net");
                total6 += rs.getDouble("t_qty");
                total7 += rs.getDouble("t_amt");
                total8 += rs.getDouble("t_disc");
                total9 += rs.getDouble("t_net");
                total10 += rs.getDouble("d_qty");
                total11 += rs.getDouble("d_amt");
                total12 += rs.getDouble("d_disc");
                total13 += rs.getDouble("d_net");
                total14 += rs.getDouble("p_qty");
                total15 += rs.getDouble("p_amt");
                total16 += rs.getDouble("p_disc");
                total17 += rs.getDouble("p_net");
                total18 += rs.getDouble("w_qty");
                total19 += rs.getDouble("w_amt");
                total20 += rs.getDouble("w_disc");
                total21 += rs.getDouble("w_net");
                total22 += rs.getDouble("s_qty");
                total23 += rs.getDouble("s_amt");
                total24 += rs.getDouble("s_disc");
                total25 += rs.getDouble("s_net");
//                totalall +=price;
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
                            datetree.getChildren().add(new reportSaleOfDeptBean(tempbran,"","","Total Date "+utilititiesfunction.Format.dateFmtShow.format(d_tempdate),Format.doubleFmt.format(totaldate[1])
                            ,Format.doubleFmt.format(totaldate[2]),Format.doubleFmt.format(totaldate[3])
                            ,Format.doubleFmt.format(totaldate[4]),Format.doubleFmt.format(totaldate[5])
                            ,Format.doubleFmt.format(totaldate[6]),Format.doubleFmt.format(totaldate[7])
                            ,Format.doubleFmt.format(totaldate[8]),Format.doubleFmt.format(totaldate[9]),Format.doubleFmt.format(totaldate[10])
                            ,Format.doubleFmt.format(totaldate[11]),Format.doubleFmt.format(totaldate[12])
                            ,Format.doubleFmt.format(totaldate[13]),Format.doubleFmt.format(totaldate[14])
                            ,Format.doubleFmt.format(totaldate[15]),Format.doubleFmt.format(totaldate[16])
                            ,Format.doubleFmt.format(totaldate[17]),Format.doubleFmt.format(totaldate[18])
                            ,Format.doubleFmt.format(totaldate[19]),Format.doubleFmt.format(totaldate[20])
                            ,Format.doubleFmt.format(totaldate[21]),Format.doubleFmt.format(totaldate[22])
                            ,Format.doubleFmt.format(totaldate[23]),Format.doubleFmt.format(totaldate[24])
                    ));
                        }
            
           if(subtree != null)
           {
            subtree.getChildren().add(new reportSaleOfDeptBean(tempbran,"","","Total Branch "+tempbran,Format.doubleFmt.format(totalgroup2),Format.doubleFmt.format(totalgroup3),Format.doubleFmt.format(totalgroup4)
                    ,Format.doubleFmt.format(totalgroup5),Format.doubleFmt.format(totalgroup6)
                    ,Format.doubleFmt.format(totalgroup7),Format.doubleFmt.format(totalgroup8)
                    ,Format.doubleFmt.format(totalgroup9),Format.doubleFmt.format(totalgroup10),Format.doubleFmt.format(totalgroup11)
                    ,Format.doubleFmt.format(totalgroup12),Format.doubleFmt.format(totalgroup13)
                    ,Format.doubleFmt.format(totalgroup14),Format.doubleFmt.format(totalgroup15)
                    ,Format.doubleFmt.format(totalgroup16),Format.doubleFmt.format(totalgroup17)
                    ,Format.doubleFmt.format(totalgroup18),Format.doubleFmt.format(totalgroup19)
                    ,Format.doubleFmt.format(totalgroup20),Format.doubleFmt.format(totalgroup21)
                    ,Format.doubleFmt.format(totalgroup22),Format.doubleFmt.format(totalgroup23)
                    ,Format.doubleFmt.format(totalgroup24),Format.doubleFmt.format(totalgroup25)
                    ));
            subtree.setS_bran("Branch "+tempbran+" "+tempbname +" Total "+countgroup+" Record");
            myroot.getChildren().add(subtree);
           }
            //myroot.getChildren().add(new MyTreeNode("Total All","","","",Format.doubleFmt.format(totalall),""));
            
            myroot.getChildren().add(new reportSaleOfDeptBean("Total All","","",""
                    ,Format.doubleFmt.format(total2),Format.doubleFmt.format(total3),Format.doubleFmt.format(total4)
                    ,Format.doubleFmt.format(total5),Format.doubleFmt.format(total6)
                    ,Format.doubleFmt.format(total7),Format.doubleFmt.format(total8)
                    ,Format.doubleFmt.format(total9),Format.doubleFmt.format(total10),Format.doubleFmt.format(total11)
                    ,Format.doubleFmt.format(total12),Format.doubleFmt.format(total13)
                    ,Format.doubleFmt.format(total14),Format.doubleFmt.format(total15)
                    ,Format.doubleFmt.format(total16),Format.doubleFmt.format(total17)
                    ,Format.doubleFmt.format(total18),Format.doubleFmt.format(total19)
                    ,Format.doubleFmt.format(total20),Format.doubleFmt.format(total21)
                    ,Format.doubleFmt.format(total22),Format.doubleFmt.format(total23)
                    ,Format.doubleFmt.format(total24),Format.doubleFmt.format(total25)
                     ));
            myroot.setS_bran("Report List Of "+counttotal+" Record"); 
            }
    }
    @Override
	public int getColumnCount() 
	{
		return 27;
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
		reportSaleOfDeptBean treenode = ( reportSaleOfDeptBean )node;
		switch( column )
		{
		case 0: return treenode.getS_bran();
                case 1: return treenode.getDate();
		case 2: return treenode.getS_dept();
		case 3: return treenode.getGroupname();
                case 4: return treenode.getE_qty();
                case 5: return treenode.getE_amt();
                case 6: return treenode.getE_disc();
                case 7: return treenode.getE_net();
		case 8: return treenode.getT_qty();
		case 9: return treenode.getT_amt();
                case 10: return treenode.getT_disc();
                case 11: return treenode.getT_net();
                case 12: return treenode.getD_qty();
                case 13: return treenode.getD_amt();
                case 14: return treenode.getD_disc();
                case 15: return treenode.getD_net();
                case 16: return treenode.getP_qty();
		case 17: return treenode.getP_amt();
		case 18: return treenode.getP_disc();
                case 19: return treenode.getP_net();
                case 20: return treenode.getW_qty();
                case 21: return treenode.getW_amt();
                case 22: return treenode.getW_disc();
                case 23: return treenode.getW_net();
                case 24: return treenode.getS_qty();
                case 25: return treenode.getS_amt();
                case 26: return treenode.getS_disc();
                case 27: return treenode.getS_net();
		default: return "Unknown";
		}
	}

	@Override
	public Object getChild( Object node, int index ) 
	{
		reportSaleOfDeptBean treenode = ( reportSaleOfDeptBean )node;
		return treenode.getChildren().get( index );
	}

	@Override
	public int getChildCount( Object parent ) 
	{
		reportSaleOfDeptBean treenode = ( reportSaleOfDeptBean )parent;
		return treenode.getChildren().size();
	}

	@Override
	public int getIndexOfChild( Object parent, Object child ) 
	{
		reportSaleOfDeptBean treenode = ( reportSaleOfDeptBean )parent;
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
		 reportSaleOfDeptBean treenode = ( reportSaleOfDeptBean )node;
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
