/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModel;

import borfunction.BORUtilities;
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
public class reportSumTerminalModel extends AbstractTreeTableModel {

    private Statement stmt;
    private reportSumTerminalBean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public reportSumTerminalModel(String sql, String code, String name) throws SQLException {
        db.dbconnect();
        stmt = null;
        double total[] = new double[36];
        for (int ct = 0; ct < total.length; ct++) {
            total[ct] = 0;
        }

        int countgroup = 0;
        int counttotal = 0;
        int countdate = 0;
        int i = 1;
        ResultSet rs = null;
        stmt = (Statement) dbUtility.con.createStatement();

        rs = stmt.executeQuery(sql);
        myroot = new reportSumTerminalBean();
        if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
            while (rs.next()) {
                String Sap_Site_Code = "";
                if (code.equals("BranchCode")) {
                    Sap_Site_Code = "   (" + rs.getString("sap_site_code") + ")";
                }
                double bill = rs.getDouble("cust") - rs.getDouble("nre");
                if (!code.equals("null")) {
                    myroot.getChildren().add(new reportSumTerminalBean(cvth.ASCII2Unicode(rs.getString(code)) + Sap_Site_Code,
                            cvth.ASCII2Unicode(rs.getString(name)),
                            rs.getString("tday"),
                            utilititiesfunction.Format.dateFmtShow.format(rs.getDate("t_date")),
                            Format.doubleFmt.format(rs.getDouble("deptsum")),
                            Format.doubleFmt.format(rs.getDouble("service")),
                            Format.doubleFmt.format(rs.getDouble("disc")),
                            Format.doubleFmt.format(rs.getDouble("dsales")),
                            Format.doubleFmt.format(rs.getDouble("cash")),
                            Format.doubleFmt.format(rs.getDouble("misc")),
                            Format.doubleFmt.format(rs.getDouble("cupon")),
                            Format.doubleFmt.format(rs.getDouble("ar")),
                            Format.doubleFmt.format(rs.getDouble("salevat")),
                            Format.doubleFmt.format(rs.getDouble("SaleNon")),
                            Format.doubleFmt.format(rs.getDouble("SVat")),
                            Format.doubleFmt.format(bill),
                            Format.doubleFmt.format(rs.getDouble("pcust")),
                            Format.doubleFmt.format(rs.getDouble("void")),
                            Format.doubleFmt.format(rs.getDouble("refund")),
                            Format.doubleFmt.format(rs.getDouble("total")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("deptsum"), bill)),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("deptsum"), rs.getDouble("pcust"))),
                            Format.doubleFmt.format(rs.getDouble("Eatin")),
                            Format.doubleFmt.format(rs.getDouble("EatinNet")),
                            Format.doubleFmt.format(rs.getDouble("NEatin")),
                            Format.doubleFmt.format(rs.getDouble("CEatin")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Eatin"), rs.getDouble("NEatin"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Eatin"), rs.getDouble("CEatin"))),
                            Format.doubleFmt.format(rs.getDouble("TakeAway")),
                            Format.doubleFmt.format(rs.getDouble("TakeAwayNet")),
                            Format.doubleFmt.format(rs.getDouble("NTakeAway")),
                            Format.doubleFmt.format(rs.getDouble("CTakeAway")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("TakeAway"), rs.getDouble("NTakeAway"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("TakeAway"), rs.getDouble("CTakeAway"))),
                            Format.doubleFmt.format(rs.getDouble("Delivery")),
                            Format.doubleFmt.format(rs.getDouble("DeliveryNet")),
                            Format.doubleFmt.format(rs.getDouble("NDelivery")),
                            Format.doubleFmt.format(rs.getDouble("CDelivery")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Delivery"), rs.getDouble("NDelivery"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Delivery"), rs.getDouble("CDelivery"))),
                            Format.doubleFmt.format(rs.getDouble("Pinto")),
                            Format.doubleFmt.format(rs.getDouble("PintoNet")),
                            Format.doubleFmt.format(rs.getDouble("NPinto")),
                            Format.doubleFmt.format(rs.getDouble("CPinto")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Pinto"), rs.getDouble("NPinto"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Pinto"), rs.getDouble("CPinto"))),
                            Format.doubleFmt.format(rs.getDouble("Whole")),
                            Format.doubleFmt.format(rs.getDouble("WholeNet")),
                            Format.doubleFmt.format(rs.getDouble("NWhole")),
                            Format.doubleFmt.format(rs.getDouble("CWhole")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Whole"), rs.getDouble("NWhole"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Whole"), rs.getDouble("CWhole")))
                    ));

                } else {
                    myroot.getChildren().add(new reportSumTerminalBean("",
                            "",
                            rs.getString("tday"),
                            utilititiesfunction.Format.dateFmtShow.format(rs.getDate("t_date")),
                            Format.doubleFmt.format(rs.getDouble("deptsum")),
                            Format.doubleFmt.format(rs.getDouble("service")),
                            Format.doubleFmt.format(rs.getDouble("disc")),
                            Format.doubleFmt.format(rs.getDouble("dsales")),
                            Format.doubleFmt.format(rs.getDouble("cash")),
                            Format.doubleFmt.format(rs.getDouble("misc")),
                            Format.doubleFmt.format(rs.getDouble("cupon")),
                            Format.doubleFmt.format(rs.getDouble("ar")),
                            Format.doubleFmt.format(rs.getDouble("salevat")),
                            Format.doubleFmt.format(rs.getDouble("SaleNon")),
                            Format.doubleFmt.format(rs.getDouble("SVat")),
                            Format.doubleFmt.format(bill),
                            Format.doubleFmt.format(rs.getDouble("pcust")),
                            Format.doubleFmt.format(rs.getDouble("void")),
                            Format.doubleFmt.format(rs.getDouble("refund")),
                            Format.doubleFmt.format(rs.getDouble("total")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("deptsum"), bill)),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("deptsum"), rs.getDouble("pcust"))),
                            Format.doubleFmt.format(rs.getDouble("Eatin")),
                            Format.doubleFmt.format(rs.getDouble("EatinNet")),
                            Format.doubleFmt.format(rs.getDouble("NEatin")),
                            Format.doubleFmt.format(rs.getDouble("CEatin")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Eatin"), rs.getDouble("NEatin"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Eatin"), rs.getDouble("CEatin"))),
                            Format.doubleFmt.format(rs.getDouble("TakeAway")),
                            Format.doubleFmt.format(rs.getDouble("TakeAwayNet")),
                            Format.doubleFmt.format(rs.getDouble("NTakeAway")),
                            Format.doubleFmt.format(rs.getDouble("CTakeAway")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("TakeAway"), rs.getDouble("NTakeAway"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("TakeAway"), rs.getDouble("CTakeAway"))),
                            Format.doubleFmt.format(rs.getDouble("Delivery")),
                            Format.doubleFmt.format(rs.getDouble("DeliveryNet")),
                            Format.doubleFmt.format(rs.getDouble("NDelivery")),
                            Format.doubleFmt.format(rs.getDouble("CDelivery")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Delivery"), rs.getDouble("NDelivery"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Delivery"), rs.getDouble("CDelivery"))),
                            Format.doubleFmt.format(rs.getDouble("Pinto")),
                            Format.doubleFmt.format(rs.getDouble("PintoNet")),
                            Format.doubleFmt.format(rs.getDouble("NPinto")),
                            Format.doubleFmt.format(rs.getDouble("CPinto")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Pinto"), rs.getDouble("NPinto"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Pinto"), rs.getDouble("CPinto"))),
                            Format.doubleFmt.format(rs.getDouble("Whole")),
                            Format.doubleFmt.format(rs.getDouble("WholeNet")),
                            Format.doubleFmt.format(rs.getDouble("NWhole")),
                            Format.doubleFmt.format(rs.getDouble("CWhole")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Whole"), rs.getDouble("NWhole"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Whole"), rs.getDouble("CWhole")))
                    ));
                }

                total[0] += rs.getDouble("deptsum");
                total[1] += rs.getDouble("service");
                total[2] += rs.getDouble("disc");
                total[3] += rs.getDouble("dsales");
                total[4] += rs.getDouble("cash");
                total[5] += rs.getDouble("misc");
                total[6] += rs.getDouble("cupon");
                total[7] += rs.getDouble("ar");
                total[8] += rs.getDouble("salevat");
                total[9] += rs.getDouble("SaleNon");
                total[10] += rs.getDouble("SVat");
                total[11] += bill;
                total[12] += rs.getDouble("pcust");
                total[13] += rs.getDouble("void");
                total[14] += rs.getDouble("refund");
                total[15] += rs.getDouble("Eatin");
                total[16] += rs.getDouble("EatinNet");
                total[17] += rs.getDouble("NEatin");
                total[18] += rs.getDouble("CEatin");
                total[19] += rs.getDouble("TakeAway");
                total[20] += rs.getDouble("TakeAwayNet");
                total[21] += rs.getDouble("NTakeAway");
                total[22] += rs.getDouble("CTakeAway");
                total[23] += rs.getDouble("Delivery");
                total[24] += rs.getDouble("DeliveryNet");
                total[25] += rs.getDouble("NDelivery");
                total[26] += rs.getDouble("CDelivery");
                total[27] += rs.getDouble("Pinto");
                total[28] += rs.getDouble("PintoNet");
                total[29] += rs.getDouble("NPinto");
                total[30] += rs.getDouble("CPinto");
                total[31] += rs.getDouble("Whole");
                total[32] += rs.getDouble("WholeNet");
                total[33] += rs.getDouble("NWhole");
                total[34] += rs.getDouble("CWhole");
                total[35] += rs.getDouble("total");

                i++;
                countgroup++;
                counttotal++;
                countdate++;

            }
            myroot.getChildren().add(new reportSumTerminalBean("Total All",
                    "",
                    "",
                    "",
                    Format.doubleFmt.format(total[0]),
                    Format.doubleFmt.format(total[1]),
                    Format.doubleFmt.format(total[2]),
                    Format.doubleFmt.format(total[3]),
                    Format.doubleFmt.format(total[4]),
                    Format.doubleFmt.format(total[5]),
                    Format.doubleFmt.format(total[6]),
                    Format.doubleFmt.format(total[7]),
                    Format.doubleFmt.format(total[8]),
                    Format.doubleFmt.format(total[9]),
                    Format.doubleFmt.format(total[10]),
                    Format.doubleFmt.format(total[11]),
                    Format.doubleFmt.format(total[12]),
                    Format.doubleFmt.format(total[13]),
                    Format.doubleFmt.format(total[14]),
                    Format.doubleFmt.format(total[35]),
                    "",
                    "",
                    Format.doubleFmt.format(total[15]),
                    Format.doubleFmt.format(total[16]),
                    Format.doubleFmt.format(total[17]),
                    Format.doubleFmt.format(total[18]),
                    "",
                    "",
                    Format.doubleFmt.format(total[19]),
                    Format.doubleFmt.format(total[20]),
                    Format.doubleFmt.format(total[21]),
                    Format.doubleFmt.format(total[22]),
                    "",
                    "",
                    Format.doubleFmt.format(total[23]),
                    Format.doubleFmt.format(total[24]),
                    Format.doubleFmt.format(total[25]),
                    Format.doubleFmt.format(total[26]),
                    "",
                    "",
                    Format.doubleFmt.format(total[27]),
                    Format.doubleFmt.format(total[28]),
                    Format.doubleFmt.format(total[29]),
                    Format.doubleFmt.format(total[30]),
                    "",
                    "",
                    Format.doubleFmt.format(total[31]),
                    Format.doubleFmt.format(total[32]),
                    Format.doubleFmt.format(total[33]),
                    Format.doubleFmt.format(total[34]),
                    "",
                    ""
            ));
            myroot.setS_bran("Report List Of " + counttotal + " Record");
        } else {
            while (rs.next()) {
                 String Sap_Site_Code = "";
                if (code.equals("BranchCode")) {
                    Sap_Site_Code = "   (" + rs.getString("sap_site_code") + ")";
                }
                double bill = rs.getDouble("cust") - rs.getDouble("nre");
                if (!code.equals("null")) {
                    myroot.getChildren().add(new reportSumTerminalBean(rs.getString(code)+Sap_Site_Code,
                            rs.getString(name),
                            rs.getString("tday"),
                            utilititiesfunction.Format.dateFmtShow.format(rs.getDate("t_date")),
                            Format.doubleFmt.format(rs.getDouble("deptsum")),
                            Format.doubleFmt.format(rs.getDouble("service")),
                            Format.doubleFmt.format(rs.getDouble("disc")),
                            Format.doubleFmt.format(rs.getDouble("dsales")),
                            Format.doubleFmt.format(rs.getDouble("cash")),
                            Format.doubleFmt.format(rs.getDouble("misc")),
                            Format.doubleFmt.format(rs.getDouble("cupon")),
                            Format.doubleFmt.format(rs.getDouble("ar")),
                            Format.doubleFmt.format(rs.getDouble("salevat")),
                            Format.doubleFmt.format(rs.getDouble("SaleNon")),
                            Format.doubleFmt.format(rs.getDouble("SVat")),
                            Format.doubleFmt.format(bill),
                            Format.doubleFmt.format(rs.getDouble("pcust")),
                            Format.doubleFmt.format(rs.getDouble("void")),
                            Format.doubleFmt.format(rs.getDouble("refund")),
                            Format.doubleFmt.format(rs.getDouble("total")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("deptsum"), bill)),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("deptsum"), rs.getDouble("pcust"))),
                            Format.doubleFmt.format(rs.getDouble("Eatin")),
                            Format.doubleFmt.format(rs.getDouble("EatinNet")),
                            Format.doubleFmt.format(rs.getDouble("NEatin")),
                            Format.doubleFmt.format(rs.getDouble("CEatin")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Eatin"), rs.getDouble("NEatin"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Eatin"), rs.getDouble("CEatin"))),
                            Format.doubleFmt.format(rs.getDouble("TakeAway")),
                            Format.doubleFmt.format(rs.getDouble("TakeAwayNet")),
                            Format.doubleFmt.format(rs.getDouble("NTakeAway")),
                            Format.doubleFmt.format(rs.getDouble("CTakeAway")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("TakeAway"), rs.getDouble("NTakeAway"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("TakeAway"), rs.getDouble("CTakeAway"))),
                            Format.doubleFmt.format(rs.getDouble("Delivery")),
                            Format.doubleFmt.format(rs.getDouble("DeliveryNet")),
                            Format.doubleFmt.format(rs.getDouble("NDelivery")),
                            Format.doubleFmt.format(rs.getDouble("CDelivery")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Delivery"), rs.getDouble("NDelivery"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Delivery"), rs.getDouble("CDelivery"))),
                            Format.doubleFmt.format(rs.getDouble("Pinto")),
                            Format.doubleFmt.format(rs.getDouble("PintoNet")),
                            Format.doubleFmt.format(rs.getDouble("NPinto")),
                            Format.doubleFmt.format(rs.getDouble("CPinto")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Pinto"), rs.getDouble("NPinto"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Pinto"), rs.getDouble("CPinto"))),
                            Format.doubleFmt.format(rs.getDouble("Whole")),
                            Format.doubleFmt.format(rs.getDouble("WholeNet")),
                            Format.doubleFmt.format(rs.getDouble("NWhole")),
                            Format.doubleFmt.format(rs.getDouble("CWhole")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Whole"), rs.getDouble("NWhole"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Whole"), rs.getDouble("CWhole")))
                    ));

                } else {
                    myroot.getChildren().add(new reportSumTerminalBean("",
                            "",
                            rs.getString("tday"),
                            utilititiesfunction.Format.dateFmtShow.format(rs.getDate("t_date")),
                            Format.doubleFmt.format(rs.getDouble("deptsum")),
                            Format.doubleFmt.format(rs.getDouble("service")),
                            Format.doubleFmt.format(rs.getDouble("disc")),
                            Format.doubleFmt.format(rs.getDouble("dsales")),
                            Format.doubleFmt.format(rs.getDouble("cash")),
                            Format.doubleFmt.format(rs.getDouble("misc")),
                            Format.doubleFmt.format(rs.getDouble("cupon")),
                            Format.doubleFmt.format(rs.getDouble("ar")),
                            Format.doubleFmt.format(rs.getDouble("salevat")),
                            Format.doubleFmt.format(rs.getDouble("SaleNon")),
                            Format.doubleFmt.format(rs.getDouble("SVat")),
                            Format.doubleFmt.format(bill),
                            Format.doubleFmt.format(rs.getDouble("pcust")),
                            Format.doubleFmt.format(rs.getDouble("void")),
                            Format.doubleFmt.format(rs.getDouble("refund")),
                            Format.doubleFmt.format(rs.getDouble("total")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("deptsum"), bill)),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("deptsum"), rs.getDouble("pcust"))),
                            Format.doubleFmt.format(rs.getDouble("Eatin")),
                            Format.doubleFmt.format(rs.getDouble("EatinNet")),
                            Format.doubleFmt.format(rs.getDouble("NEatin")),
                            Format.doubleFmt.format(rs.getDouble("CEatin")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Eatin"), rs.getDouble("NEatin"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Eatin"), rs.getDouble("CEatin"))),
                            Format.doubleFmt.format(rs.getDouble("TakeAway")),
                            Format.doubleFmt.format(rs.getDouble("TakeAwayNet")),
                            Format.doubleFmt.format(rs.getDouble("NTakeAway")),
                            Format.doubleFmt.format(rs.getDouble("CTakeAway")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("TakeAway"), rs.getDouble("NTakeAway"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("TakeAway"), rs.getDouble("CTakeAway"))),
                            Format.doubleFmt.format(rs.getDouble("Delivery")),
                            Format.doubleFmt.format(rs.getDouble("DeliveryNet")),
                            Format.doubleFmt.format(rs.getDouble("NDelivery")),
                            Format.doubleFmt.format(rs.getDouble("CDelivery")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Delivery"), rs.getDouble("NDelivery"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Delivery"), rs.getDouble("CDelivery"))),
                            Format.doubleFmt.format(rs.getDouble("Pinto")),
                            Format.doubleFmt.format(rs.getDouble("PintoNet")),
                            Format.doubleFmt.format(rs.getDouble("NPinto")),
                            Format.doubleFmt.format(rs.getDouble("CPinto")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Pinto"), rs.getDouble("NPinto"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Pinto"), rs.getDouble("CPinto"))),
                            Format.doubleFmt.format(rs.getDouble("Whole")),
                            Format.doubleFmt.format(rs.getDouble("WholeNet")),
                            Format.doubleFmt.format(rs.getDouble("NWhole")),
                            Format.doubleFmt.format(rs.getDouble("CWhole")),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Whole"), rs.getDouble("NWhole"))),
                            Format.doubleFmt.format(BORUtilities.getAGV(rs.getDouble("Whole"), rs.getDouble("CWhole")))
                    ));
                }

                total[0] += rs.getDouble("deptsum");
                total[1] += rs.getDouble("service");
                total[2] += rs.getDouble("disc");
                total[3] += rs.getDouble("dsales");
                total[4] += rs.getDouble("cash");
                total[5] += rs.getDouble("misc");
                total[6] += rs.getDouble("cupon");
                total[7] += rs.getDouble("ar");
                total[8] += rs.getDouble("salevat");
                total[9] += rs.getDouble("SaleNon");
                total[10] += rs.getDouble("SVat");
                total[11] += bill;
                total[12] += rs.getDouble("pcust");
                total[13] += rs.getDouble("void");
                total[14] += rs.getDouble("refund");
                total[15] += rs.getDouble("Eatin");
                total[16] += rs.getDouble("EatinNet");
                total[17] += rs.getDouble("NEatin");
                total[18] += rs.getDouble("CEatin");
                total[19] += rs.getDouble("TakeAway");
                total[20] += rs.getDouble("TakeAwayNet");
                total[21] += rs.getDouble("NTakeAway");
                total[22] += rs.getDouble("CTakeAway");
                total[23] += rs.getDouble("Delivery");
                total[24] += rs.getDouble("DeliveryNet");
                total[25] += rs.getDouble("NDelivery");
                total[26] += rs.getDouble("CDelivery");
                total[27] += rs.getDouble("Pinto");
                total[28] += rs.getDouble("PintoNet");
                total[29] += rs.getDouble("NPinto");
                total[30] += rs.getDouble("CPinto");
                total[31] += rs.getDouble("Whole");
                total[32] += rs.getDouble("WholeNet");
                total[33] += rs.getDouble("NWhole");
                total[34] += rs.getDouble("CWhole");
                total[35] += rs.getDouble("total");

                i++;
                countgroup++;
                counttotal++;
                countdate++;

            }
            myroot.getChildren().add(new reportSumTerminalBean("Total All",
                    "",
                    "",
                    "",
                    Format.doubleFmt.format(total[0]),
                    Format.doubleFmt.format(total[1]),
                    Format.doubleFmt.format(total[2]),
                    Format.doubleFmt.format(total[3]),
                    Format.doubleFmt.format(total[4]),
                    Format.doubleFmt.format(total[5]),
                    Format.doubleFmt.format(total[6]),
                    Format.doubleFmt.format(total[7]),
                    Format.doubleFmt.format(total[8]),
                    Format.doubleFmt.format(total[9]),
                    Format.doubleFmt.format(total[10]),
                    Format.doubleFmt.format(total[11]),
                    Format.doubleFmt.format(total[12]),
                    Format.doubleFmt.format(total[13]),
                    Format.doubleFmt.format(total[14]),
                    Format.doubleFmt.format(total[35]),
                    "",
                    "",
                    Format.doubleFmt.format(total[15]),
                    Format.doubleFmt.format(total[16]),
                    Format.doubleFmt.format(total[17]),
                    Format.doubleFmt.format(total[18]),
                    "",
                    "",
                    Format.doubleFmt.format(total[19]),
                    Format.doubleFmt.format(total[20]),
                    Format.doubleFmt.format(total[21]),
                    Format.doubleFmt.format(total[22]),
                    "",
                    "",
                    Format.doubleFmt.format(total[23]),
                    Format.doubleFmt.format(total[24]),
                    Format.doubleFmt.format(total[25]),
                    Format.doubleFmt.format(total[26]),
                    "",
                    "",
                    Format.doubleFmt.format(total[27]),
                    Format.doubleFmt.format(total[28]),
                    Format.doubleFmt.format(total[29]),
                    Format.doubleFmt.format(total[30]),
                    "",
                    "",
                    Format.doubleFmt.format(total[31]),
                    Format.doubleFmt.format(total[32]),
                    Format.doubleFmt.format(total[33]),
                    Format.doubleFmt.format(total[34]),
                    "",
                    ""
            ));
            myroot.setS_bran("Report List Of " + counttotal + " Record");
        }
    }

    @Override
    public int getColumnCount() {
        return 51;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getValueAt(Object node, int column) {
        //System.out.println( "getValueAt: " + node + ", " + column );
        reportSumTerminalBean treenode = (reportSumTerminalBean) node;
        switch (column) {
            case 0:
                return treenode.getS_bran();
            case 1:
                return treenode.getBranname();
            case 2:
                return treenode.getTday();
            case 3:
                return treenode.getS_date();
            case 4:
                return treenode.getDeptsum();
            case 5:
                return treenode.getService();
            case 6:
                return treenode.getDiscount();
            case 7:
                return treenode.getNetsale();
            case 8:
                return treenode.getCash();
            case 9:
                return treenode.getMisc();
            case 10:
                return treenode.getCupon();
            case 11:
                return treenode.getAr();
            case 12:
                return treenode.getSalevat();
            case 13:
                return treenode.getSalenonvat();
            case 14:
                return treenode.getSvat();
            case 15:
                return treenode.getCust();
            case 16:
                return treenode.getPcust();
            case 17:
                return treenode.getVoids();
            case 18:
                return treenode.getRefund();
            case 19:
                return treenode.getPledge();
            case 20:
                return treenode.getANB();
            case 21:
                return treenode.getACB();
            case 22:
                return treenode.getE();
            case 23:
                return treenode.getEnet();
            case 24:
                return treenode.getNE();
            case 25:
                return treenode.getCE();
            case 26:
                return treenode.getANE();
            case 27:
                return treenode.getACE();
            case 28:
                return treenode.getT();
            case 29:
                return treenode.getTnet();
            case 30:
                return treenode.getNT();
            case 31:
                return treenode.getCT();
            case 32:
                return treenode.getANT();
            case 33:
                return treenode.getACT();
            case 34:
                return treenode.getD();
            case 35:
                return treenode.getDnet();
            case 36:
                return treenode.getND();
            case 37:
                return treenode.getCD();
            case 38:
                return treenode.getAND();
            case 39:
                return treenode.getACD();
            case 40:
                return treenode.getP();
            case 41:
                return treenode.getPnet();
            case 42:
                return treenode.getNP();
            case 43:
                return treenode.getCP();
            case 44:
                return treenode.getANP();
            case 45:
                return treenode.getACP();
            case 46:
                return treenode.getW();
            case 47:
                return treenode.getWnet();
            case 48:
                return treenode.getNW();
            case 49:
                return treenode.getCW();
            case 50:
                return treenode.getANW();
            case 51:
                return treenode.getACW();
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        reportSumTerminalBean treenode = (reportSumTerminalBean) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        reportSumTerminalBean treenode = (reportSumTerminalBean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        reportSumTerminalBean treenode = (reportSumTerminalBean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportSumTerminalBean treenode = (reportSumTerminalBean) node;
        if (treenode.getChildren().size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    public Object getRoot() {
        return myroot;
    }
}
