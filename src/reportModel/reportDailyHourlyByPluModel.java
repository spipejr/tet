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
import utilititiesfunction.PUtility;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class reportDailyHourlyByPluModel extends AbstractTreeTableModel {

    private Statement stmt;
    private reportDailyHourluByPluBean myroot;
    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public reportDailyHourlyByPluModel(String sql, String code, String name) throws SQLException {
        try {
            db.dbconnect();
            stmt = null;
            String tempbran = "";
            String tempbranold = "";
            String tempbname = "";
            String tempbnameold = "";
            Date d_tempdate = null;
            Date d_tempdateold = null;
            double qty00 = 0;
            double qty01 = 0;
            double qty02 = 0;
            double qty03 = 0;
            double qty04 = 0;
            double qty05 = 0;
            double qty06 = 0;
            double qty07 = 0;
            double qty08 = 0;
            double qty09 = 0;
            double qty10 = 0;
            double qty11 = 0;
            double qty12 = 0;
            double qty13 = 0;
            double qty14 = 0;
            double qty15 = 0;
            double qty16 = 0;
            double qty17 = 0;
            double qty18 = 0;
            double qty19 = 0;
            double qty20 = 0;
            double qty21 = 0;
            double qty22 = 0;
            double qty23 = 0;
            double totalqty = 0;
            double amt00 = 0;
            double amt01 = 0;
            double amt02 = 0;
            double amt03 = 0;
            double amt04 = 0;
            double amt05 = 0;
            double amt06 = 0;
            double amt07 = 0;
            double amt08 = 0;
            double amt09 = 0;
            double amt10 = 0;
            double amt11 = 0;
            double amt12 = 0;
            double amt13 = 0;
            double amt14 = 0;
            double amt15 = 0;
            double amt16 = 0;
            double amt17 = 0;
            double amt18 = 0;
            double amt19 = 0;
            double amt20 = 0;
            double amt21 = 0;
            double amt22 = 0;
            double amt23 = 0;
            double totalamt = 0;

            double tqty00 = 0;
            double tqty01 = 0;
            double tqty02 = 0;
            double tqty03 = 0;
            double tqty04 = 0;
            double tqty05 = 0;
            double tqty06 = 0;
            double tqty07 = 0;
            double tqty08 = 0;
            double tqty09 = 0;
            double tqty10 = 0;
            double tqty11 = 0;
            double tqty12 = 0;
            double tqty13 = 0;
            double tqty14 = 0;
            double tqty15 = 0;
            double tqty16 = 0;
            double tqty17 = 0;
            double tqty18 = 0;
            double tqty19 = 0;
            double tqty20 = 0;
            double tqty21 = 0;
            double tqty22 = 0;
            double tqty23 = 0;
            double ttotalqty = 0;
            double tamt00 = 0;
            double tamt01 = 0;
            double tamt02 = 0;
            double tamt03 = 0;
            double tamt04 = 0;
            double tamt05 = 0;
            double tamt06 = 0;
            double tamt07 = 0;
            double tamt08 = 0;
            double tamt09 = 0;
            double tamt10 = 0;
            double tamt11 = 0;
            double tamt12 = 0;
            double tamt13 = 0;
            double tamt14 = 0;
            double tamt15 = 0;
            double tamt16 = 0;
            double tamt17 = 0;
            double tamt18 = 0;
            double tamt19 = 0;
            double tamt20 = 0;
            double tamt21 = 0;
            double tamt22 = 0;
            double tamt23 = 0;
            double ttotalamt = 0;
            int countgroup = 0;
            int counttotal = 0;
            int i = 1;
            ResultSet rs = null;
            stmt = (Statement) dbUtility.con.createStatement();
            double dif = 0;
            double difper = 0;
            double budper = 0;
            rs = stmt.executeQuery(sql);
            reportDailyHourluByPluBean subtree = null;
            myroot = new reportDailyHourluByPluBean();
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                while (rs.next()) {
                    if (!code.equals("All")) {
                        tempbran = rs.getString(code);
                        tempbname = getName(code, tempbran);
                    } else {
                        tempbran = "ALL";
                        tempbname = "Sum All";
                    }
                    if ((!tempbranold.equals(tempbran)) && (!tempbranold.equals(""))) {
                        if (subtree != null) {
                            subtree.getChildren().add(new reportDailyHourluByPluBean(tempbranold,
                                    tempbnameold,
                                    "",
                                    "",
                                    "Total Group........",
                                    "",
                                    "",
                                    Format.doubleFmt.format(qty00),
                                    Format.doubleFmt.format(amt00),
                                    Format.doubleFmt.format(qty01),
                                    Format.doubleFmt.format(amt01),
                                    Format.doubleFmt.format(qty02),
                                    Format.doubleFmt.format(amt02),
                                    Format.doubleFmt.format(qty03),
                                    Format.doubleFmt.format(amt03),
                                    Format.doubleFmt.format(qty04),
                                    Format.doubleFmt.format(amt04),
                                    Format.doubleFmt.format(qty05),
                                    Format.doubleFmt.format(amt05),
                                    Format.doubleFmt.format(qty06),
                                    Format.doubleFmt.format(amt06),
                                    Format.doubleFmt.format(qty07),
                                    Format.doubleFmt.format(amt07),
                                    Format.doubleFmt.format(qty08),
                                    Format.doubleFmt.format(amt08),
                                    Format.doubleFmt.format(qty09),
                                    Format.doubleFmt.format(amt09),
                                    Format.doubleFmt.format(qty10),
                                    Format.doubleFmt.format(amt10),
                                    Format.doubleFmt.format(qty11),
                                    Format.doubleFmt.format(amt11),
                                    Format.doubleFmt.format(qty12),
                                    Format.doubleFmt.format(amt12),
                                    Format.doubleFmt.format(qty13),
                                    Format.doubleFmt.format(amt13),
                                    Format.doubleFmt.format(qty14),
                                    Format.doubleFmt.format(amt14),
                                    Format.doubleFmt.format(qty15),
                                    Format.doubleFmt.format(amt15),
                                    Format.doubleFmt.format(qty16),
                                    Format.doubleFmt.format(amt16),
                                    Format.doubleFmt.format(qty17),
                                    Format.doubleFmt.format(amt17),
                                    Format.doubleFmt.format(qty18),
                                    Format.doubleFmt.format(amt18),
                                    Format.doubleFmt.format(qty19),
                                    Format.doubleFmt.format(amt19),
                                    Format.doubleFmt.format(qty20),
                                    Format.doubleFmt.format(amt20),
                                    Format.doubleFmt.format(qty21),
                                    Format.doubleFmt.format(amt21),
                                    Format.doubleFmt.format(qty22),
                                    Format.doubleFmt.format(amt22),
                                    Format.doubleFmt.format(qty23),
                                    Format.doubleFmt.format(amt23),
                                    Format.doubleFmt.format(totalqty),
                                    Format.doubleFmt.format(totalamt)
                            ));
                            qty00 = 0;
                            qty01 = 0;
                            qty02 = 0;
                            qty03 = 0;
                            qty04 = 0;
                            qty05 = 0;
                            qty06 = 0;
                            qty07 = 0;
                            qty08 = 0;
                            qty09 = 0;
                            qty10 = 0;
                            qty11 = 0;
                            qty12 = 0;
                            qty13 = 0;
                            qty14 = 0;
                            qty15 = 0;
                            qty16 = 0;
                            qty17 = 0;
                            qty18 = 0;
                            qty19 = 0;
                            qty20 = 0;
                            qty21 = 0;
                            qty22 = 0;
                            qty23 = 0;
                            totalqty = 0;
                            amt01 = 0;
                            amt02 = 0;
                            amt03 = 0;
                            amt04 = 0;
                            amt05 = 0;
                            amt06 = 0;
                            amt07 = 0;
                            amt08 = 0;
                            amt09 = 0;
                            amt10 = 0;
                            amt11 = 0;
                            amt12 = 0;
                            amt13 = 0;
                            amt14 = 0;
                            amt15 = 0;
                            amt16 = 0;
                            amt17 = 0;
                            amt18 = 0;
                            amt19 = 0;
                            amt20 = 0;
                            amt21 = 0;
                            amt22 = 0;
                            amt23 = 0;
                            totalamt = 0;
                            myroot.getChildren().add(subtree);
                            subtree.setCode(code + " " + tempbranold + " " + tempbnameold + " Total " + countgroup + " Record");
                        }

                        subtree = new reportDailyHourluByPluBean();
                        countgroup = 0;
                        i = 1;
                        subtree.getChildren().add(new reportDailyHourluByPluBean(tempbran,
                                tempbname,
                                cvth.ASCII2Unicode(rs.getString("pgroup")),
                                cvth.ASCII2Unicode(rs.getString("pcode")),
                                cvth.ASCII2Unicode(rs.getString("pdesc")),
                                cvth.ASCII2Unicode(rs.getString("r_price")),
                                cvth.ASCII2Unicode(rs.getString("punit1")),
                                Format.doubleFmt.format(rs.getDouble("qty00")),
                                Format.doubleFmt.format(rs.getDouble("amt00")),
                                Format.doubleFmt.format(rs.getDouble("qty01")),
                                Format.doubleFmt.format(rs.getDouble("amt01")),
                                Format.doubleFmt.format(rs.getDouble("qty02")),
                                Format.doubleFmt.format(rs.getDouble("amt02")),
                                Format.doubleFmt.format(rs.getDouble("qty03")),
                                Format.doubleFmt.format(rs.getDouble("amt03")),
                                Format.doubleFmt.format(rs.getDouble("qty04")),
                                Format.doubleFmt.format(rs.getDouble("amt04")),
                                Format.doubleFmt.format(rs.getDouble("qty05")),
                                Format.doubleFmt.format(rs.getDouble("amt05")),
                                Format.doubleFmt.format(rs.getDouble("qty06")),
                                Format.doubleFmt.format(rs.getDouble("amt06")),
                                Format.doubleFmt.format(rs.getDouble("qty07")),
                                Format.doubleFmt.format(rs.getDouble("amt07")),
                                Format.doubleFmt.format(rs.getDouble("qty08")),
                                Format.doubleFmt.format(rs.getDouble("amt08")),
                                Format.doubleFmt.format(rs.getDouble("qty09")),
                                Format.doubleFmt.format(rs.getDouble("amt09")),
                                Format.doubleFmt.format(rs.getDouble("qty10")),
                                Format.doubleFmt.format(rs.getDouble("amt10")),
                                Format.doubleFmt.format(rs.getDouble("qty11")),
                                Format.doubleFmt.format(rs.getDouble("amt11")),
                                Format.doubleFmt.format(rs.getDouble("qty12")),
                                Format.doubleFmt.format(rs.getDouble("amt12")),
                                Format.doubleFmt.format(rs.getDouble("qty13")),
                                Format.doubleFmt.format(rs.getDouble("amt13")),
                                Format.doubleFmt.format(rs.getDouble("qty14")),
                                Format.doubleFmt.format(rs.getDouble("amt14")),
                                Format.doubleFmt.format(rs.getDouble("qty15")),
                                Format.doubleFmt.format(rs.getDouble("amt15")),
                                Format.doubleFmt.format(rs.getDouble("qty16")),
                                Format.doubleFmt.format(rs.getDouble("amt16")),
                                Format.doubleFmt.format(rs.getDouble("qty17")),
                                Format.doubleFmt.format(rs.getDouble("amt17")),
                                Format.doubleFmt.format(rs.getDouble("qty18")),
                                Format.doubleFmt.format(rs.getDouble("amt18")),
                                Format.doubleFmt.format(rs.getDouble("qty19")),
                                Format.doubleFmt.format(rs.getDouble("amt19")),
                                Format.doubleFmt.format(rs.getDouble("qty20")),
                                Format.doubleFmt.format(rs.getDouble("amt20")),
                                Format.doubleFmt.format(rs.getDouble("qty21")),
                                Format.doubleFmt.format(rs.getDouble("amt21")),
                                Format.doubleFmt.format(rs.getDouble("qty22")),
                                Format.doubleFmt.format(rs.getDouble("amt22")),
                                Format.doubleFmt.format(rs.getDouble("qty23")),
                                Format.doubleFmt.format(rs.getDouble("amt23")),
                                Format.doubleFmt.format(rs.getDouble("totalqty")),
                                Format.doubleFmt.format(rs.getDouble("totalamt"))
                        ));

                    } else {
                        if (subtree == null) {
                            subtree = new reportDailyHourluByPluBean();
                        }
                        subtree.getChildren().add(new reportDailyHourluByPluBean(tempbran,
                                tempbname,
                                cvth.ASCII2Unicode(rs.getString("pgroup")),
                                cvth.ASCII2Unicode(rs.getString("pcode")),
                                cvth.ASCII2Unicode(rs.getString("pdesc")),
                                cvth.ASCII2Unicode(rs.getString("r_price")),
                                cvth.ASCII2Unicode(rs.getString("punit1")),
                                Format.doubleFmt.format(rs.getDouble("qty00")),
                                Format.doubleFmt.format(rs.getDouble("amt00")),
                                Format.doubleFmt.format(rs.getDouble("qty01")),
                                Format.doubleFmt.format(rs.getDouble("amt01")),
                                Format.doubleFmt.format(rs.getDouble("qty02")),
                                Format.doubleFmt.format(rs.getDouble("amt02")),
                                Format.doubleFmt.format(rs.getDouble("qty03")),
                                Format.doubleFmt.format(rs.getDouble("amt03")),
                                Format.doubleFmt.format(rs.getDouble("qty04")),
                                Format.doubleFmt.format(rs.getDouble("amt04")),
                                Format.doubleFmt.format(rs.getDouble("qty05")),
                                Format.doubleFmt.format(rs.getDouble("amt05")),
                                Format.doubleFmt.format(rs.getDouble("qty06")),
                                Format.doubleFmt.format(rs.getDouble("amt06")),
                                Format.doubleFmt.format(rs.getDouble("qty07")),
                                Format.doubleFmt.format(rs.getDouble("amt07")),
                                Format.doubleFmt.format(rs.getDouble("qty08")),
                                Format.doubleFmt.format(rs.getDouble("amt08")),
                                Format.doubleFmt.format(rs.getDouble("qty09")),
                                Format.doubleFmt.format(rs.getDouble("amt09")),
                                Format.doubleFmt.format(rs.getDouble("qty10")),
                                Format.doubleFmt.format(rs.getDouble("amt10")),
                                Format.doubleFmt.format(rs.getDouble("qty11")),
                                Format.doubleFmt.format(rs.getDouble("amt11")),
                                Format.doubleFmt.format(rs.getDouble("qty12")),
                                Format.doubleFmt.format(rs.getDouble("amt12")),
                                Format.doubleFmt.format(rs.getDouble("qty13")),
                                Format.doubleFmt.format(rs.getDouble("amt13")),
                                Format.doubleFmt.format(rs.getDouble("qty14")),
                                Format.doubleFmt.format(rs.getDouble("amt14")),
                                Format.doubleFmt.format(rs.getDouble("qty15")),
                                Format.doubleFmt.format(rs.getDouble("amt15")),
                                Format.doubleFmt.format(rs.getDouble("qty16")),
                                Format.doubleFmt.format(rs.getDouble("amt16")),
                                Format.doubleFmt.format(rs.getDouble("qty17")),
                                Format.doubleFmt.format(rs.getDouble("amt17")),
                                Format.doubleFmt.format(rs.getDouble("qty18")),
                                Format.doubleFmt.format(rs.getDouble("amt18")),
                                Format.doubleFmt.format(rs.getDouble("qty19")),
                                Format.doubleFmt.format(rs.getDouble("amt19")),
                                Format.doubleFmt.format(rs.getDouble("qty20")),
                                Format.doubleFmt.format(rs.getDouble("amt20")),
                                Format.doubleFmt.format(rs.getDouble("qty21")),
                                Format.doubleFmt.format(rs.getDouble("amt21")),
                                Format.doubleFmt.format(rs.getDouble("qty22")),
                                Format.doubleFmt.format(rs.getDouble("amt22")),
                                Format.doubleFmt.format(rs.getDouble("qty23")),
                                Format.doubleFmt.format(rs.getDouble("amt23")),
                                Format.doubleFmt.format(rs.getDouble("totalqty")),
                                Format.doubleFmt.format(rs.getDouble("totalamt"))
                        ));
                    }

                    i++;
                    countgroup++;
                    counttotal++;
                    qty00 = qty00 + rs.getDouble("qty00");
                    qty01 = qty01 + rs.getDouble("qty01");
                    qty02 = qty02 + rs.getDouble("qty02");
                    qty03 = qty03 + rs.getDouble("qty03");
                    qty04 = qty04 + rs.getDouble("qty04");
                    qty05 = qty05 + rs.getDouble("qty05");
                    qty06 = qty06 + rs.getDouble("qty06");
                    qty07 = qty07 + rs.getDouble("qty07");
                    qty08 = qty08 + rs.getDouble("qty08");
                    qty09 = qty09 + rs.getDouble("qty09");
                    qty10 = qty10 + rs.getDouble("qty10");
                    qty11 = qty11 + rs.getDouble("qty11");
                    qty12 = qty12 + rs.getDouble("qty12");
                    qty13 = qty13 + rs.getDouble("qty13");
                    qty14 = qty14 + rs.getDouble("qty14");
                    qty15 = qty15 + rs.getDouble("qty15");
                    qty16 = qty16 + rs.getDouble("qty16");
                    qty17 = qty17 + rs.getDouble("qty17");
                    qty18 = qty18 + rs.getDouble("qty18");
                    qty19 = qty19 + rs.getDouble("qty19");
                    qty20 = qty20 + rs.getDouble("qty20");
                    qty21 = qty21 + rs.getDouble("qty21");
                    qty22 = qty22 + rs.getDouble("qty22");
                    qty23 = qty23 + rs.getDouble("qty23");
                    totalqty = totalqty + rs.getDouble("totalqty");
                    amt00 = amt00 + rs.getDouble("amt00");
                    amt01 = amt01 + rs.getDouble("amt01");
                    amt02 = amt02 + rs.getDouble("amt02");
                    amt03 = amt03 + rs.getDouble("amt03");
                    amt04 = amt04 + rs.getDouble("amt04");
                    amt05 = amt05 + rs.getDouble("amt05");
                    amt06 = amt06 + rs.getDouble("amt06");
                    amt07 = amt07 + rs.getDouble("amt07");
                    amt08 = amt08 + rs.getDouble("amt08");
                    amt09 = amt09 + rs.getDouble("amt09");
                    amt10 = amt10 + rs.getDouble("amt10");
                    amt11 = amt11 + rs.getDouble("amt11");
                    amt12 = amt12 + rs.getDouble("amt12");
                    amt13 = amt13 + rs.getDouble("amt13");
                    amt14 = amt14 + rs.getDouble("amt14");
                    amt15 = amt15 + rs.getDouble("amt15");
                    amt16 = amt16 + rs.getDouble("amt16");
                    amt17 = amt17 + rs.getDouble("amt17");
                    amt18 = amt18 + rs.getDouble("amt18");
                    amt19 = amt19 + rs.getDouble("amt19");
                    amt20 = amt20 + rs.getDouble("amt20");
                    amt21 = amt21 + rs.getDouble("amt21");
                    amt22 = amt22 + rs.getDouble("amt22");
                    amt23 = amt23 + rs.getDouble("amt23");
                    totalamt = totalamt + rs.getDouble("totalamt");
                    tqty00 = tqty00 + rs.getDouble("qty00");
                    tqty01 = tqty01 + rs.getDouble("qty01");
                    tqty02 = tqty02 + rs.getDouble("qty02");
                    tqty03 = tqty03 + rs.getDouble("qty03");
                    tqty04 = tqty04 + rs.getDouble("qty04");
                    tqty05 = tqty05 + rs.getDouble("qty05");
                    tqty06 = tqty06 + rs.getDouble("qty06");
                    tqty07 = tqty07 + rs.getDouble("qty07");
                    tqty08 = tqty08 + rs.getDouble("qty08");
                    tqty09 = tqty09 + rs.getDouble("qty09");
                    tqty10 = tqty10 + rs.getDouble("qty10");
                    tqty11 = tqty11 + rs.getDouble("qty11");
                    tqty12 = tqty12 + rs.getDouble("qty12");
                    tqty13 = tqty13 + rs.getDouble("qty13");
                    tqty14 = tqty14 + rs.getDouble("qty14");
                    tqty15 = tqty15 + rs.getDouble("qty15");
                    tqty16 = tqty16 + rs.getDouble("qty16");
                    tqty17 = tqty17 + rs.getDouble("qty17");
                    tqty18 = tqty18 + rs.getDouble("qty18");
                    tqty19 = tqty19 + rs.getDouble("qty19");
                    tqty20 = tqty20 + rs.getDouble("qty20");
                    tqty21 = tqty21 + rs.getDouble("qty21");
                    tqty22 = tqty22 + rs.getDouble("qty22");
                    tqty23 = tqty23 + rs.getDouble("qty23");
                    ttotalqty = ttotalqty + rs.getDouble("totalqty");
                    tamt00 = tamt00 + rs.getDouble("amt00");
                    tamt01 = tamt01 + rs.getDouble("amt01");
                    tamt02 = tamt02 + rs.getDouble("amt02");
                    tamt03 = tamt03 + rs.getDouble("amt03");
                    tamt04 = tamt04 + rs.getDouble("amt04");
                    tamt05 = tamt05 + rs.getDouble("amt05");
                    tamt06 = tamt06 + rs.getDouble("amt06");
                    tamt07 = tamt07 + rs.getDouble("amt07");
                    tamt08 = tamt08 + rs.getDouble("amt08");
                    tamt09 = tamt09 + rs.getDouble("amt09");
                    tamt10 = tamt10 + rs.getDouble("amt10");
                    tamt11 = tamt11 + rs.getDouble("amt11");
                    tamt12 = tamt12 + rs.getDouble("amt12");
                    tamt13 = tamt13 + rs.getDouble("amt13");
                    tamt14 = tamt14 + rs.getDouble("amt14");
                    tamt15 = tamt15 + rs.getDouble("amt15");
                    tamt16 = tamt16 + rs.getDouble("amt16");
                    tamt17 = tamt17 + rs.getDouble("amt17");
                    tamt18 = tamt18 + rs.getDouble("amt18");
                    tamt19 = tamt19 + rs.getDouble("amt19");
                    tamt20 = tamt20 + rs.getDouble("amt20");
                    tamt21 = tamt21 + rs.getDouble("amt21");
                    tamt22 = tamt22 + rs.getDouble("amt22");
                    tamt23 = tamt23 + rs.getDouble("amt23");
                    ttotalamt = ttotalamt + rs.getDouble("totalamt");
                    if (!code.equals("All")) {
                        tempbranold = rs.getString(code);
                        tempbnameold = getName(code, tempbranold);
                    }
                }
                if (subtree != null) {
                    subtree.getChildren().add(new reportDailyHourluByPluBean(tempbranold,
                            tempbnameold,
                            "",
                            "",
                            "Total Group........",
                            "",
                            "",
                            Format.doubleFmt.format(qty00),
                            Format.doubleFmt.format(amt00),
                            Format.doubleFmt.format(qty01),
                            Format.doubleFmt.format(amt01),
                            Format.doubleFmt.format(qty02),
                            Format.doubleFmt.format(amt02),
                            Format.doubleFmt.format(qty03),
                            Format.doubleFmt.format(amt03),
                            Format.doubleFmt.format(qty04),
                            Format.doubleFmt.format(amt04),
                            Format.doubleFmt.format(qty05),
                            Format.doubleFmt.format(amt05),
                            Format.doubleFmt.format(qty06),
                            Format.doubleFmt.format(amt06),
                            Format.doubleFmt.format(qty07),
                            Format.doubleFmt.format(amt07),
                            Format.doubleFmt.format(qty08),
                            Format.doubleFmt.format(amt08),
                            Format.doubleFmt.format(qty09),
                            Format.doubleFmt.format(amt09),
                            Format.doubleFmt.format(qty10),
                            Format.doubleFmt.format(amt10),
                            Format.doubleFmt.format(qty11),
                            Format.doubleFmt.format(amt11),
                            Format.doubleFmt.format(qty12),
                            Format.doubleFmt.format(amt12),
                            Format.doubleFmt.format(qty13),
                            Format.doubleFmt.format(amt13),
                            Format.doubleFmt.format(qty14),
                            Format.doubleFmt.format(amt14),
                            Format.doubleFmt.format(qty15),
                            Format.doubleFmt.format(amt15),
                            Format.doubleFmt.format(qty16),
                            Format.doubleFmt.format(amt16),
                            Format.doubleFmt.format(qty17),
                            Format.doubleFmt.format(amt17),
                            Format.doubleFmt.format(qty18),
                            Format.doubleFmt.format(amt18),
                            Format.doubleFmt.format(qty19),
                            Format.doubleFmt.format(amt19),
                            Format.doubleFmt.format(qty20),
                            Format.doubleFmt.format(amt20),
                            Format.doubleFmt.format(qty21),
                            Format.doubleFmt.format(amt21),
                            Format.doubleFmt.format(qty22),
                            Format.doubleFmt.format(amt22),
                            Format.doubleFmt.format(qty23),
                            Format.doubleFmt.format(amt23),
                            Format.doubleFmt.format(totalqty),
                            Format.doubleFmt.format(totalamt)
                    ));
                    subtree.getChildren().add(new reportDailyHourluByPluBean("",
                            "",
                            "",
                            "",
                            "Grand Total........",
                            "",
                            "",
                            Format.doubleFmt.format(tqty00),
                            Format.doubleFmt.format(tamt00),
                            Format.doubleFmt.format(tqty01),
                            Format.doubleFmt.format(tamt01),
                            Format.doubleFmt.format(tqty02),
                            Format.doubleFmt.format(tamt02),
                            Format.doubleFmt.format(tqty03),
                            Format.doubleFmt.format(tamt03),
                            Format.doubleFmt.format(tqty04),
                            Format.doubleFmt.format(tamt04),
                            Format.doubleFmt.format(tqty05),
                            Format.doubleFmt.format(tamt05),
                            Format.doubleFmt.format(tqty06),
                            Format.doubleFmt.format(tamt06),
                            Format.doubleFmt.format(tqty07),
                            Format.doubleFmt.format(tamt07),
                            Format.doubleFmt.format(tqty08),
                            Format.doubleFmt.format(tamt08),
                            Format.doubleFmt.format(tqty09),
                            Format.doubleFmt.format(tamt09),
                            Format.doubleFmt.format(tqty10),
                            Format.doubleFmt.format(tamt10),
                            Format.doubleFmt.format(tqty11),
                            Format.doubleFmt.format(tamt11),
                            Format.doubleFmt.format(tqty12),
                            Format.doubleFmt.format(tamt12),
                            Format.doubleFmt.format(tqty13),
                            Format.doubleFmt.format(tamt13),
                            Format.doubleFmt.format(tqty14),
                            Format.doubleFmt.format(tamt14),
                            Format.doubleFmt.format(tqty15),
                            Format.doubleFmt.format(tamt15),
                            Format.doubleFmt.format(tqty16),
                            Format.doubleFmt.format(tamt16),
                            Format.doubleFmt.format(tqty17),
                            Format.doubleFmt.format(tamt17),
                            Format.doubleFmt.format(tqty18),
                            Format.doubleFmt.format(tamt18),
                            Format.doubleFmt.format(tqty19),
                            Format.doubleFmt.format(tamt19),
                            Format.doubleFmt.format(tqty20),
                            Format.doubleFmt.format(tamt20),
                            Format.doubleFmt.format(tqty21),
                            Format.doubleFmt.format(tamt21),
                            Format.doubleFmt.format(tqty22),
                            Format.doubleFmt.format(tamt22),
                            Format.doubleFmt.format(tqty23),
                            Format.doubleFmt.format(tamt23),
                            Format.doubleFmt.format(ttotalqty),
                            Format.doubleFmt.format(ttotalamt)
                    ));
                    subtree.setCode(code + " " + tempbran + " " + tempbname + " Total " + countgroup + " Record");
                    myroot.getChildren().add(subtree);
                }
                myroot.setCode("Report List Of " + counttotal + " Record");
            } else {
                while (rs.next()) {
                    if (!code.equals("All")) {
                        tempbran = rs.getString(code);
                        tempbname = getName(code, tempbran);
                    } else {
                        tempbran = "ALL";
                        tempbname = "Sum All";
                    }
                    if (!tempbranold.equals(tempbran)) {
                        if (subtree != null) {
                            // myroot.getChildren().add(subtree);
                            subtree.getChildren().add(new reportDailyHourluByPluBean(tempbranold,
                                    tempbnameold,
                                    "",
                                    "",
                                    "Total Group........",
                                    "",
                                    "",
                                    Format.doubleFmt.format(qty00),
                                    Format.doubleFmt.format(amt00),
                                    Format.doubleFmt.format(qty01),
                                    Format.doubleFmt.format(amt01),
                                    Format.doubleFmt.format(qty02),
                                    Format.doubleFmt.format(amt02),
                                    Format.doubleFmt.format(qty03),
                                    Format.doubleFmt.format(amt03),
                                    Format.doubleFmt.format(qty04),
                                    Format.doubleFmt.format(amt04),
                                    Format.doubleFmt.format(qty05),
                                    Format.doubleFmt.format(amt05),
                                    Format.doubleFmt.format(qty06),
                                    Format.doubleFmt.format(amt06),
                                    Format.doubleFmt.format(qty07),
                                    Format.doubleFmt.format(amt07),
                                    Format.doubleFmt.format(qty08),
                                    Format.doubleFmt.format(amt08),
                                    Format.doubleFmt.format(qty09),
                                    Format.doubleFmt.format(amt09),
                                    Format.doubleFmt.format(qty10),
                                    Format.doubleFmt.format(amt10),
                                    Format.doubleFmt.format(qty11),
                                    Format.doubleFmt.format(amt11),
                                    Format.doubleFmt.format(qty12),
                                    Format.doubleFmt.format(amt12),
                                    Format.doubleFmt.format(qty13),
                                    Format.doubleFmt.format(amt13),
                                    Format.doubleFmt.format(qty14),
                                    Format.doubleFmt.format(amt14),
                                    Format.doubleFmt.format(qty15),
                                    Format.doubleFmt.format(amt15),
                                    Format.doubleFmt.format(qty16),
                                    Format.doubleFmt.format(amt16),
                                    Format.doubleFmt.format(qty17),
                                    Format.doubleFmt.format(amt17),
                                    Format.doubleFmt.format(qty18),
                                    Format.doubleFmt.format(amt18),
                                    Format.doubleFmt.format(qty19),
                                    Format.doubleFmt.format(amt19),
                                    Format.doubleFmt.format(qty20),
                                    Format.doubleFmt.format(amt20),
                                    Format.doubleFmt.format(qty21),
                                    Format.doubleFmt.format(amt21),
                                    Format.doubleFmt.format(qty22),
                                    Format.doubleFmt.format(amt22),
                                    Format.doubleFmt.format(qty23),
                                    Format.doubleFmt.format(amt23),
                                    Format.doubleFmt.format(totalqty),
                                    Format.doubleFmt.format(totalamt)
                            ));
                            qty00 = 0;
                            qty01 = 0;
                            qty02 = 0;
                            qty03 = 0;
                            qty04 = 0;
                            qty05 = 0;
                            qty06 = 0;
                            qty07 = 0;
                            qty08 = 0;
                            qty09 = 0;
                            qty10 = 0;
                            qty11 = 0;
                            qty12 = 0;
                            qty13 = 0;
                            qty14 = 0;
                            qty15 = 0;
                            qty16 = 0;
                            qty17 = 0;
                            qty18 = 0;
                            qty19 = 0;
                            qty20 = 0;
                            qty21 = 0;
                            qty22 = 0;
                            qty23 = 0;
                            totalqty = 0;
                            amt01 = 0;
                            amt02 = 0;
                            amt03 = 0;
                            amt04 = 0;
                            amt05 = 0;
                            amt06 = 0;
                            amt07 = 0;
                            amt08 = 0;
                            amt09 = 0;
                            amt10 = 0;
                            amt11 = 0;
                            amt12 = 0;
                            amt13 = 0;
                            amt14 = 0;
                            amt15 = 0;
                            amt16 = 0;
                            amt17 = 0;
                            amt18 = 0;
                            amt19 = 0;
                            amt20 = 0;
                            amt21 = 0;
                            amt22 = 0;
                            amt23 = 0;
                            totalamt = 0;
                            myroot.getChildren().add(subtree);
                            subtree.setCode(code + " " + tempbranold + " " + tempbnameold + " Total " + countgroup + " Record");
                        }
                        subtree = new reportDailyHourluByPluBean();
                        countgroup = 0;
                        i = 1;
                        subtree.getChildren().add(new reportDailyHourluByPluBean(tempbran,
                                tempbname,
                                rs.getString("pgroup"),
                                rs.getString("pcode"),
                                rs.getString("pdesc"),
                                rs.getString("r_price"),
                                rs.getString("punit1"),
                                Format.doubleFmt.format(rs.getDouble("qty00")),
                                Format.doubleFmt.format(rs.getDouble("amt00")),
                                Format.doubleFmt.format(rs.getDouble("qty01")),
                                Format.doubleFmt.format(rs.getDouble("amt01")),
                                Format.doubleFmt.format(rs.getDouble("qty02")),
                                Format.doubleFmt.format(rs.getDouble("amt02")),
                                Format.doubleFmt.format(rs.getDouble("qty03")),
                                Format.doubleFmt.format(rs.getDouble("amt03")),
                                Format.doubleFmt.format(rs.getDouble("qty04")),
                                Format.doubleFmt.format(rs.getDouble("amt04")),
                                Format.doubleFmt.format(rs.getDouble("qty05")),
                                Format.doubleFmt.format(rs.getDouble("amt05")),
                                Format.doubleFmt.format(rs.getDouble("qty06")),
                                Format.doubleFmt.format(rs.getDouble("amt06")),
                                Format.doubleFmt.format(rs.getDouble("qty07")),
                                Format.doubleFmt.format(rs.getDouble("amt07")),
                                Format.doubleFmt.format(rs.getDouble("qty08")),
                                Format.doubleFmt.format(rs.getDouble("amt08")),
                                Format.doubleFmt.format(rs.getDouble("qty09")),
                                Format.doubleFmt.format(rs.getDouble("amt09")),
                                Format.doubleFmt.format(rs.getDouble("qty10")),
                                Format.doubleFmt.format(rs.getDouble("amt10")),
                                Format.doubleFmt.format(rs.getDouble("qty11")),
                                Format.doubleFmt.format(rs.getDouble("amt11")),
                                Format.doubleFmt.format(rs.getDouble("qty12")),
                                Format.doubleFmt.format(rs.getDouble("amt12")),
                                Format.doubleFmt.format(rs.getDouble("qty13")),
                                Format.doubleFmt.format(rs.getDouble("amt13")),
                                Format.doubleFmt.format(rs.getDouble("qty14")),
                                Format.doubleFmt.format(rs.getDouble("amt14")),
                                Format.doubleFmt.format(rs.getDouble("qty15")),
                                Format.doubleFmt.format(rs.getDouble("amt15")),
                                Format.doubleFmt.format(rs.getDouble("qty16")),
                                Format.doubleFmt.format(rs.getDouble("amt16")),
                                Format.doubleFmt.format(rs.getDouble("qty17")),
                                Format.doubleFmt.format(rs.getDouble("amt17")),
                                Format.doubleFmt.format(rs.getDouble("qty18")),
                                Format.doubleFmt.format(rs.getDouble("amt18")),
                                Format.doubleFmt.format(rs.getDouble("qty19")),
                                Format.doubleFmt.format(rs.getDouble("amt19")),
                                Format.doubleFmt.format(rs.getDouble("qty20")),
                                Format.doubleFmt.format(rs.getDouble("amt20")),
                                Format.doubleFmt.format(rs.getDouble("qty21")),
                                Format.doubleFmt.format(rs.getDouble("amt21")),
                                Format.doubleFmt.format(rs.getDouble("qty22")),
                                Format.doubleFmt.format(rs.getDouble("amt22")),
                                Format.doubleFmt.format(rs.getDouble("qty23")),
                                Format.doubleFmt.format(rs.getDouble("amt23")),
                                Format.doubleFmt.format(rs.getDouble("totalqty")),
                                Format.doubleFmt.format(rs.getDouble("totalamt"))
                        ));

                    } else {
                        if (subtree == null) {
                            subtree = new reportDailyHourluByPluBean();
                        }
                        subtree.getChildren().add(new reportDailyHourluByPluBean(tempbran,
                                tempbname,
                                rs.getString("pgroup"),
                                rs.getString("pcode"),
                                rs.getString("pdesc"),
                                rs.getString("r_price"),
                                rs.getString("punit1"),
                                Format.doubleFmt.format(rs.getDouble("qty00")),
                                Format.doubleFmt.format(rs.getDouble("amt00")),
                                Format.doubleFmt.format(rs.getDouble("qty01")),
                                Format.doubleFmt.format(rs.getDouble("amt01")),
                                Format.doubleFmt.format(rs.getDouble("qty02")),
                                Format.doubleFmt.format(rs.getDouble("amt02")),
                                Format.doubleFmt.format(rs.getDouble("qty03")),
                                Format.doubleFmt.format(rs.getDouble("amt03")),
                                Format.doubleFmt.format(rs.getDouble("qty04")),
                                Format.doubleFmt.format(rs.getDouble("amt04")),
                                Format.doubleFmt.format(rs.getDouble("qty05")),
                                Format.doubleFmt.format(rs.getDouble("amt05")),
                                Format.doubleFmt.format(rs.getDouble("qty06")),
                                Format.doubleFmt.format(rs.getDouble("amt06")),
                                Format.doubleFmt.format(rs.getDouble("qty07")),
                                Format.doubleFmt.format(rs.getDouble("amt07")),
                                Format.doubleFmt.format(rs.getDouble("qty08")),
                                Format.doubleFmt.format(rs.getDouble("amt08")),
                                Format.doubleFmt.format(rs.getDouble("qty09")),
                                Format.doubleFmt.format(rs.getDouble("amt09")),
                                Format.doubleFmt.format(rs.getDouble("qty10")),
                                Format.doubleFmt.format(rs.getDouble("amt10")),
                                Format.doubleFmt.format(rs.getDouble("qty11")),
                                Format.doubleFmt.format(rs.getDouble("amt11")),
                                Format.doubleFmt.format(rs.getDouble("qty12")),
                                Format.doubleFmt.format(rs.getDouble("amt12")),
                                Format.doubleFmt.format(rs.getDouble("qty13")),
                                Format.doubleFmt.format(rs.getDouble("amt13")),
                                Format.doubleFmt.format(rs.getDouble("qty14")),
                                Format.doubleFmt.format(rs.getDouble("amt14")),
                                Format.doubleFmt.format(rs.getDouble("qty15")),
                                Format.doubleFmt.format(rs.getDouble("amt15")),
                                Format.doubleFmt.format(rs.getDouble("qty16")),
                                Format.doubleFmt.format(rs.getDouble("amt16")),
                                Format.doubleFmt.format(rs.getDouble("qty17")),
                                Format.doubleFmt.format(rs.getDouble("amt17")),
                                Format.doubleFmt.format(rs.getDouble("qty18")),
                                Format.doubleFmt.format(rs.getDouble("amt18")),
                                Format.doubleFmt.format(rs.getDouble("qty19")),
                                Format.doubleFmt.format(rs.getDouble("amt19")),
                                Format.doubleFmt.format(rs.getDouble("qty20")),
                                Format.doubleFmt.format(rs.getDouble("amt20")),
                                Format.doubleFmt.format(rs.getDouble("qty21")),
                                Format.doubleFmt.format(rs.getDouble("amt21")),
                                Format.doubleFmt.format(rs.getDouble("qty22")),
                                Format.doubleFmt.format(rs.getDouble("amt22")),
                                Format.doubleFmt.format(rs.getDouble("qty23")),
                                Format.doubleFmt.format(rs.getDouble("amt23")),
                                Format.doubleFmt.format(rs.getDouble("totalqty")),
                                Format.doubleFmt.format(rs.getDouble("totalamt"))
                        ));
                    }
                    i++;
                    countgroup++;
                    counttotal++;
                    qty00 = qty00 + rs.getDouble("qty00");
                    qty01 = qty01 + rs.getDouble("qty01");
                    qty02 = qty02 + rs.getDouble("qty02");
                    qty03 = qty03 + rs.getDouble("qty03");
                    qty04 = qty04 + rs.getDouble("qty04");
                    qty05 = qty05 + rs.getDouble("qty05");
                    qty06 = qty06 + rs.getDouble("qty06");
                    qty07 = qty07 + rs.getDouble("qty07");
                    qty08 = qty08 + rs.getDouble("qty08");
                    qty09 = qty09 + rs.getDouble("qty09");
                    qty10 = qty10 + rs.getDouble("qty10");
                    qty11 = qty11 + rs.getDouble("qty11");
                    qty12 = qty12 + rs.getDouble("qty12");
                    qty13 = qty13 + rs.getDouble("qty13");
                    qty14 = qty14 + rs.getDouble("qty14");
                    qty15 = qty15 + rs.getDouble("qty15");
                    qty16 = qty16 + rs.getDouble("qty16");
                    qty17 = qty17 + rs.getDouble("qty17");
                    qty18 = qty18 + rs.getDouble("qty18");
                    qty19 = qty19 + rs.getDouble("qty19");
                    qty20 = qty20 + rs.getDouble("qty20");
                    qty21 = qty21 + rs.getDouble("qty21");
                    qty22 = qty22 + rs.getDouble("qty22");
                    qty23 = qty23 + rs.getDouble("qty23");
                    totalqty = totalqty + rs.getDouble("totalqty");
                    amt00 = amt00 + rs.getDouble("amt00");
                    amt01 = amt01 + rs.getDouble("amt01");
                    amt02 = amt02 + rs.getDouble("amt02");
                    amt03 = amt03 + rs.getDouble("amt03");
                    amt04 = amt04 + rs.getDouble("amt04");
                    amt05 = amt05 + rs.getDouble("amt05");
                    amt06 = amt06 + rs.getDouble("amt06");
                    amt07 = amt07 + rs.getDouble("amt07");
                    amt08 = amt08 + rs.getDouble("amt08");
                    amt09 = amt09 + rs.getDouble("amt09");
                    amt10 = amt10 + rs.getDouble("amt10");
                    amt11 = amt11 + rs.getDouble("amt11");
                    amt12 = amt12 + rs.getDouble("amt12");
                    amt13 = amt13 + rs.getDouble("amt13");
                    amt14 = amt14 + rs.getDouble("amt14");
                    amt15 = amt15 + rs.getDouble("amt15");
                    amt16 = amt16 + rs.getDouble("amt16");
                    amt17 = amt17 + rs.getDouble("amt17");
                    amt18 = amt18 + rs.getDouble("amt18");
                    amt19 = amt19 + rs.getDouble("amt19");
                    amt20 = amt20 + rs.getDouble("amt20");
                    amt21 = amt21 + rs.getDouble("amt21");
                    amt22 = amt22 + rs.getDouble("amt22");
                    amt23 = amt23 + rs.getDouble("amt23");
                    totalamt = totalamt + rs.getDouble("totalamt");
                    tqty00 = tqty00 + rs.getDouble("qty00");
                    tqty01 = tqty01 + rs.getDouble("qty01");
                    tqty02 = tqty02 + rs.getDouble("qty02");
                    tqty03 = tqty03 + rs.getDouble("qty03");
                    tqty04 = tqty04 + rs.getDouble("qty04");
                    tqty05 = tqty05 + rs.getDouble("qty05");
                    tqty06 = tqty06 + rs.getDouble("qty06");
                    tqty07 = tqty07 + rs.getDouble("qty07");
                    tqty08 = tqty08 + rs.getDouble("qty08");
                    tqty09 = tqty09 + rs.getDouble("qty09");
                    tqty10 = tqty10 + rs.getDouble("qty10");
                    tqty11 = tqty11 + rs.getDouble("qty11");
                    tqty12 = tqty12 + rs.getDouble("qty12");
                    tqty13 = tqty13 + rs.getDouble("qty13");
                    tqty14 = tqty14 + rs.getDouble("qty14");
                    tqty15 = tqty15 + rs.getDouble("qty15");
                    tqty16 = tqty16 + rs.getDouble("qty16");
                    tqty17 = tqty17 + rs.getDouble("qty17");
                    tqty18 = tqty18 + rs.getDouble("qty18");
                    tqty19 = tqty19 + rs.getDouble("qty19");
                    tqty20 = tqty20 + rs.getDouble("qty20");
                    tqty21 = tqty21 + rs.getDouble("qty21");
                    tqty22 = tqty22 + rs.getDouble("qty22");
                    tqty23 = tqty23 + rs.getDouble("qty23");
                    ttotalqty = ttotalqty + rs.getDouble("totalqty");
                    tamt00 = tamt00 + rs.getDouble("amt00");
                    tamt01 = tamt01 + rs.getDouble("amt01");
                    tamt02 = tamt02 + rs.getDouble("amt02");
                    tamt03 = tamt03 + rs.getDouble("amt03");
                    tamt04 = tamt04 + rs.getDouble("amt04");
                    tamt05 = tamt05 + rs.getDouble("amt05");
                    tamt06 = tamt06 + rs.getDouble("amt06");
                    tamt07 = tamt07 + rs.getDouble("amt07");
                    tamt08 = tamt08 + rs.getDouble("amt08");
                    tamt09 = tamt09 + rs.getDouble("amt09");
                    tamt10 = tamt10 + rs.getDouble("amt10");
                    tamt11 = tamt11 + rs.getDouble("amt11");
                    tamt12 = tamt12 + rs.getDouble("amt12");
                    tamt13 = tamt13 + rs.getDouble("amt13");
                    tamt14 = tamt14 + rs.getDouble("amt14");
                    tamt15 = tamt15 + rs.getDouble("amt15");
                    tamt16 = tamt16 + rs.getDouble("amt16");
                    tamt17 = tamt17 + rs.getDouble("amt17");
                    tamt18 = tamt18 + rs.getDouble("amt18");
                    tamt19 = tamt19 + rs.getDouble("amt19");
                    tamt20 = tamt20 + rs.getDouble("amt20");
                    tamt21 = tamt21 + rs.getDouble("amt21");
                    tamt22 = tamt22 + rs.getDouble("amt22");
                    tamt23 = tamt23 + rs.getDouble("amt23");
                    ttotalamt = ttotalamt + rs.getDouble("totalamt");
                    if (!code.equals("All")) {
                        tempbranold = rs.getString(code);
                        tempbnameold = getName(code, tempbranold);
                    }
                }
                if (subtree != null) {
                    subtree.getChildren().add(new reportDailyHourluByPluBean(tempbranold,
                            tempbnameold,
                            "",
                            "",
                            "Total Group........",
                            "",
                            "",
                            Format.doubleFmt.format(qty00),
                            Format.doubleFmt.format(amt00),
                            Format.doubleFmt.format(qty01),
                            Format.doubleFmt.format(amt01),
                            Format.doubleFmt.format(qty02),
                            Format.doubleFmt.format(amt02),
                            Format.doubleFmt.format(qty03),
                            Format.doubleFmt.format(amt03),
                            Format.doubleFmt.format(qty04),
                            Format.doubleFmt.format(amt04),
                            Format.doubleFmt.format(qty05),
                            Format.doubleFmt.format(amt05),
                            Format.doubleFmt.format(qty06),
                            Format.doubleFmt.format(amt06),
                            Format.doubleFmt.format(qty07),
                            Format.doubleFmt.format(amt07),
                            Format.doubleFmt.format(qty08),
                            Format.doubleFmt.format(amt08),
                            Format.doubleFmt.format(qty09),
                            Format.doubleFmt.format(amt09),
                            Format.doubleFmt.format(qty10),
                            Format.doubleFmt.format(amt10),
                            Format.doubleFmt.format(qty11),
                            Format.doubleFmt.format(amt11),
                            Format.doubleFmt.format(qty12),
                            Format.doubleFmt.format(amt12),
                            Format.doubleFmt.format(qty13),
                            Format.doubleFmt.format(amt13),
                            Format.doubleFmt.format(qty14),
                            Format.doubleFmt.format(amt14),
                            Format.doubleFmt.format(qty15),
                            Format.doubleFmt.format(amt15),
                            Format.doubleFmt.format(qty16),
                            Format.doubleFmt.format(amt16),
                            Format.doubleFmt.format(qty17),
                            Format.doubleFmt.format(amt17),
                            Format.doubleFmt.format(qty18),
                            Format.doubleFmt.format(amt18),
                            Format.doubleFmt.format(qty19),
                            Format.doubleFmt.format(amt19),
                            Format.doubleFmt.format(qty20),
                            Format.doubleFmt.format(amt20),
                            Format.doubleFmt.format(qty21),
                            Format.doubleFmt.format(amt21),
                            Format.doubleFmt.format(qty22),
                            Format.doubleFmt.format(amt22),
                            Format.doubleFmt.format(qty23),
                            Format.doubleFmt.format(amt23),
                            Format.doubleFmt.format(totalqty),
                            Format.doubleFmt.format(totalamt)
                    ));
                    subtree.getChildren().add(new reportDailyHourluByPluBean("",
                            "",
                            "",
                            "",
                            "Grand Total........",
                            "",
                            "",
                            Format.doubleFmt.format(tqty00),
                            Format.doubleFmt.format(tamt00),
                            Format.doubleFmt.format(tqty01),
                            Format.doubleFmt.format(tamt01),
                            Format.doubleFmt.format(tqty02),
                            Format.doubleFmt.format(tamt02),
                            Format.doubleFmt.format(tqty03),
                            Format.doubleFmt.format(tamt03),
                            Format.doubleFmt.format(tqty04),
                            Format.doubleFmt.format(tamt04),
                            Format.doubleFmt.format(tqty05),
                            Format.doubleFmt.format(tamt05),
                            Format.doubleFmt.format(tqty06),
                            Format.doubleFmt.format(tamt06),
                            Format.doubleFmt.format(tqty07),
                            Format.doubleFmt.format(tamt07),
                            Format.doubleFmt.format(tqty08),
                            Format.doubleFmt.format(tamt08),
                            Format.doubleFmt.format(tqty09),
                            Format.doubleFmt.format(tamt09),
                            Format.doubleFmt.format(tqty10),
                            Format.doubleFmt.format(tamt10),
                            Format.doubleFmt.format(tqty11),
                            Format.doubleFmt.format(tamt11),
                            Format.doubleFmt.format(tqty12),
                            Format.doubleFmt.format(tamt12),
                            Format.doubleFmt.format(tqty13),
                            Format.doubleFmt.format(tamt13),
                            Format.doubleFmt.format(tqty14),
                            Format.doubleFmt.format(tamt14),
                            Format.doubleFmt.format(tqty15),
                            Format.doubleFmt.format(tamt15),
                            Format.doubleFmt.format(tqty16),
                            Format.doubleFmt.format(tamt16),
                            Format.doubleFmt.format(tqty17),
                            Format.doubleFmt.format(tamt17),
                            Format.doubleFmt.format(tqty18),
                            Format.doubleFmt.format(tamt18),
                            Format.doubleFmt.format(tqty19),
                            Format.doubleFmt.format(tamt19),
                            Format.doubleFmt.format(tqty20),
                            Format.doubleFmt.format(tamt20),
                            Format.doubleFmt.format(tqty21),
                            Format.doubleFmt.format(tamt21),
                            Format.doubleFmt.format(tqty22),
                            Format.doubleFmt.format(tamt22),
                            Format.doubleFmt.format(tqty23),
                            Format.doubleFmt.format(tamt23),
                            Format.doubleFmt.format(ttotalqty),
                            Format.doubleFmt.format(ttotalamt)
                    ));
                    subtree.setCode(code + " " + tempbran + " " + tempbname + " Total " + countgroup + " Record");
                    myroot.getChildren().add(subtree);
                }
                myroot.setCode("Report List Of " + counttotal + " Record");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public int getColumnCount() {
        return 30;
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
        reportDailyHourluByPluBean treenode = (reportDailyHourluByPluBean) node;
        switch (column) {
            case 0:
                return treenode.getCode();
            case 1:
                return treenode.getName();
            case 2:
                return treenode.getQue();
            case 3:
                return treenode.getPcode();
            case 4:
                return treenode.getPname();
            case 5:
                return treenode.getPrice();
            case 6:
                return treenode.getUnit();
            case 7:
                return treenode.getB1();
            case 8:
                return treenode.getB2();
            case 9:
                return treenode.getB3();
            case 10:
                return treenode.getB4();
            case 11:
                return treenode.getB5();
            case 12:
                return treenode.getB6();
            case 13:
                return treenode.getB7();
            case 14:
                return treenode.getB8();
            case 15:
                return treenode.getB9();
            case 16:
                return treenode.getB10();
            case 17:
                return treenode.getB11();
            case 18:
                return treenode.getB12();
            case 19:
                return treenode.getB13();
            case 20:
                return treenode.getB14();
            case 21:
                return treenode.getB15();
            case 22:
                return treenode.getB16();
            case 23:
                return treenode.getB17();
            case 24:
                return treenode.getB18();
            case 25:
                return treenode.getB19();
            case 26:
                return treenode.getB20();
            case 27:
                return treenode.getB21();
            case 28:
                return treenode.getB22();
            case 29:
                return treenode.getB23();
            case 30:
                return treenode.getB24();
            case 31:
                return treenode.getB25();
            case 32:
                return treenode.getB26();
            case 33:
                return treenode.getB27();
            case 34:
                return treenode.getB28();
            case 35:
                return treenode.getB29();
            case 36:
                return treenode.getB30();
            case 37:
                return treenode.getB31();
            case 38:
                return treenode.getB32();
            case 39:
                return treenode.getB33();
            case 40:
                return treenode.getB34();
            case 41:
                return treenode.getB35();
            case 42:
                return treenode.getB36();
            case 43:
                return treenode.getB37();
            case 44:
                return treenode.getB38();
            case 45:
                return treenode.getB39();
            case 46:
                return treenode.getB40();
            case 47:
                return treenode.getB41();
            case 48:
                return treenode.getB42();
            case 49:
                return treenode.getB43();
            case 50:
                return treenode.getB44();
            case 51:
                return treenode.getB45();
            case 52:
                return treenode.getB46();
            case 53:
                return treenode.getB47();
            case 54:
                return treenode.getB48();
            case 55:
                return treenode.getB49();
            case 56:
                return treenode.getB50();
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        reportDailyHourluByPluBean treenode = (reportDailyHourluByPluBean) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        reportDailyHourluByPluBean treenode = (reportDailyHourluByPluBean) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        reportDailyHourluByPluBean treenode = (reportDailyHourluByPluBean) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        reportDailyHourluByPluBean treenode = (reportDailyHourluByPluBean) node;
        if (treenode.getChildren().size() > 0) {
            return false;
        }
        return true;
    }

    public String getName(String code, String TCode) {
        String retval = "";
        if (code.equals("BranchCode")) {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                retval = cvth.ASCII2Unicode(PUtility.SeekBranchName(TCode));
            } else {
                retval = PUtility.SeekBranchName(TCode);
            }
        } else if (code.equals("BtypeCode")) {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                retval = cvth.ASCII2Unicode(PUtility.SeekBTypeName(TCode));
            } else {
                retval = PUtility.SeekBTypeName(TCode);
            }
        } else if (code.equals("BAreaCode")) {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                retval = cvth.ASCII2Unicode(PUtility.SeekAreaName(TCode));
            } else {
                retval = PUtility.SeekAreaName(TCode);
            }
        } else if (code.equals("BSizeCode")) {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                retval = cvth.ASCII2Unicode(PUtility.SeekSizeName(TCode));
            } else {
                retval = PUtility.SeekSizeName(TCode);
            }
        } else if (code.equals("BPlanCode")) {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                retval = cvth.ASCII2Unicode(PUtility.SeekPlaneName(TCode));
            } else {
                retval = PUtility.SeekPlaneName(TCode);
            }
        } else if (code.equals("BStoreCode")) {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                retval = cvth.ASCII2Unicode(PUtility.SeekStoreName(TCode));
            } else {
                retval = PUtility.SeekStoreName(TCode);
            }
        } else if (code.equals("CompanyCode")) {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                retval = cvth.ASCII2Unicode(PUtility.SeekComName(TCode));
            } else {
                retval = PUtility.SeekComName(TCode);
            }
        } else if (code.equals("BrandCode")) {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                retval = cvth.ASCII2Unicode(PUtility.SeekBrandName(TCode));
            } else {
                retval = PUtility.SeekBrandName(TCode);
            }
        } else if (code.equals("BustypeCode")) {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                retval = cvth.ASCII2Unicode(PUtility.SeekBusTypeName(TCode));
            } else {
                retval = PUtility.SeekBusTypeName(TCode);
            }
        }
        return retval;
    }

    @Override
    public Object getRoot() {
        return myroot;
    }

}
