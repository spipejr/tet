/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;

import dbutility.dbUtility;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author natee
 */
public class formatDateNumber {

    dbUtility db = new dbUtility();
    ThaiUtilities cvth = new ThaiUtilities();

    public formatDateNumber() {
        db.dbconnect();
        chkos = System.getProperty("os.name").toString().toLowerCase();
        if (!chkos.equalsIgnoreCase("linux")) {
            chkpath = "C:";
        }
    }
    public static String chkos = "";
    public static String chkpath = "";
    Locale lc = new Locale("th", "TH");
    private final SimpleDateFormat docCancelDate = new SimpleDateFormat("yyMMddHHmmss", Locale.ENGLISH);
    private final SimpleDateFormat dayFmtShowThai = new SimpleDateFormat("EEE", lc);
    private final SimpleDateFormat dateFmtShowThaiB = new SimpleDateFormat("EEE MMMM yy", lc);
    private final SimpleDateFormat dateFmtShowThai = new SimpleDateFormat("dd MMMM yyyy", lc);
    private final SimpleDateFormat dayFmtShowEU = new SimpleDateFormat("EEE", Locale.ENGLISH);
    private final SimpleDateFormat dateFmtShowEUB = new SimpleDateFormat("EEE MMMM yy", Locale.ENGLISH);
    private final SimpleDateFormat dateFmtShowEU = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    private final SimpleDateFormat dateFmtShow = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private final SimpleDateFormat dateFmtSQL = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private final SimpleDateFormat datetimeFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    private final SimpleDateFormat dateFmt = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    private final SimpleDateFormat timeFmt = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
    private final SimpleDateFormat xtimeFmt = new SimpleDateFormat("HH.mm.ss", Locale.ENGLISH);
    private final SimpleDateFormat time2Fmt = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
    private final SimpleDateFormat time2FmtSS = new SimpleDateFormat("mm:ss", Locale.ENGLISH);
    private final SimpleDateFormat monthFmt = new SimpleDateFormat("MM", Locale.ENGLISH);
    private final SimpleDateFormat yearFmt = new SimpleDateFormat("yy", Locale.ENGLISH);
    private final SimpleDateFormat year4Fmt = new SimpleDateFormat("yyyy", Locale.ENGLISH);
    private final SimpleDateFormat dayFmt = new SimpleDateFormat("dd", Locale.ENGLISH);
    private final DecimalFormat intFmtShow = new DecimalFormat("##,###,##0");
    private final DecimalFormat doubleFmtShow = new DecimalFormat("##,###,##0.00");
    private final DecimalFormat double3FmtShow = new DecimalFormat("##,###,##0.000");
    private final DecimalFormat double4FmtShow = new DecimalFormat("##,###,##0.0000");
    private final DecimalFormat doubleFmtSQL = new DecimalFormat("#0.00");
    private final DecimalFormat double3FmtSQL = new DecimalFormat("#0.000");
    private final DecimalFormat double4FmtSQL = new DecimalFormat("#0.0000");
    private final DecimalFormat percentFmt = new DecimalFormat("##,###,##0.00");

    public String docCancelDate(Object ob) {
        return docCancelDate.format(ob);
    }

    public String dateFmtShowEUB(Object ob) {
        return dateFmtShowEUB.format(ob);
    }

    public String dayFmtShowEU(Object ob) {
        return dayFmtShowEU.format(ob);
    }

    public String dateFmtShowThaiB(Object ob) {
        return dateFmtShowThaiB.format(ob);
    }

    public String dayFmtShowThai(Object ob) {
        return dayFmtShowThai.format(ob);
    }

    public String dateFmtShowEU(Object ob) {
        return dateFmtShowEU.format(ob);
    }

    public SimpleDateFormat getDateFmt() {
        return dateFmt;
    }

    public SimpleDateFormat getDateFmtSQL() {
        return dateFmtSQL;
    }

    public SimpleDateFormat getDateFmtShow() {
        return dateFmtShow;
    }

    public SimpleDateFormat getDatetimeFmt() {
        return datetimeFmt;
    }

    public SimpleDateFormat getDayFmt() {
        return dayFmt;
    }

    public SimpleDateFormat getMonthFmt() {
        return monthFmt;
    }

    public SimpleDateFormat getTime2Fmt() {
        return time2Fmt;
    }

    public SimpleDateFormat getTime2FmtSS() {
        return time2FmtSS;
    }

    public SimpleDateFormat getTimeFmt() {
        return timeFmt;
    }

    public SimpleDateFormat getYear4Fmt() {
        return year4Fmt;
    }

    public SimpleDateFormat getYearFmt() {
        return yearFmt;
    }

    public String dateFmtThaiShow(Object ob) {
        return dateFmtShowThai.format(ob);
    }

    public String intFmtShow(Object ob) {
        return intFmtShow.format(ob);
    }

    public Date nowDate() {
        return new Date(System.currentTimeMillis());
    }

    public String dateFmtShow(Object ob) {
        return dateFmtShow.format(ob);
    }

    public String dateFmtSQL(Object ob) {
        return dateFmtSQL.format(ob);
    }

    public String datetimeFmt(Object ob) {
        return datetimeFmt.format(ob);
    }

    public String timeFmt(Object ob) {
        return timeFmt.format(ob);
    }

    public String xtimeFmt(Object ob) {
        return xtimeFmt.format(ob);
    }

    public String time2Fmt(Object ob) {
        return time2Fmt.format(ob);
    }

    public String time2FmtSS(Object ob) {
        return time2FmtSS.format(ob);
    }

    public String monthFmt(Object ob) {
        return monthFmt.format(ob);
    }

    public String yearFmt(Object ob) {
        return yearFmt.format(ob);
    }

    public String year4Fmt(Object ob) {
        return year4Fmt.format(ob);
    }

    public String dayFmt(Object ob) {
        return dayFmt.format(ob);
    }

    public String doubleFmtShow(Object ob) {
        return doubleFmtShow.format(ob);
    }

    public String double3Fmt(Object ob) {
        return double3FmtShow.format(ob);
    }

    public String double4FmtShow(Object ob) {
        return double4FmtShow.format(ob);
    }

    public String doubleFmtSQL(Object ob) {
        return doubleFmtSQL.format(ob);
    }

    public String double3FmtSQL(Object ob) {
        return double3FmtSQL.format(ob);
    }

    public String double4FmtSQL(Object ob) {
        return double4FmtSQL.format(ob);
    }

    public String percentFmt(Object ob) {
        return percentFmt.format(ob) + "%";
    }

    public String intFmt(double ob) {
        int a = (int) ob;
        return a + "";
    }

    public String convertDateshowToSQL(String _date) {
        String date = "";
        String[] split = _date.split("/");
        date = split[2] + "-" + split[1] + "-" + split[0];

        return date;
    }

    public String convertDatesqlToShow(String _date) {
        String date = "";
        String[] split = _date.split("-");
        date = split[2] + "/" + split[1] + "/" + split[0];

        return date;
    }

    public boolean checkFormatDate(String date) {
        try {
            Date d = dateFmtShow.parse(date);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean isNumberic(String number) {
        try {
            double num = Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String convertDoubleString(String _value) {
        String REPLACE = "";
        String REGEX = ",";
        String result = "";

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(_value);
        result = matcher.replaceAll(REPLACE);

        return result;
    }

    public boolean searchSaleType(String saletype, String regex) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(saletype);

        return matcher.find();
    }

    public String[] setYearCombo() {
        String[] strYear = new String[4];
        int year = Integer.parseInt(year4Fmt(nowDate())) - 3;

        for (int i = 0; i < 4; i++) {
            strYear[i] = (year + i) + "";
        }
        return strYear;
    }

    public Color colorDisable() {
        return new Color(237, 238, 228);
    }

    public Color colorEnable() {
        return Color.WHITE;
    }

    public void updateIngredent(String Tplcode) {
        Double cost = 0.0000;
        Double[] type = new Double[5];
        ArrayList<Double> formu = new ArrayList<Double>();

        for (int i = 0; i < 5; i++) {
            type[i] = 0.000;
        }
//        type[0] = Eat In
//        type[1] = Take Away
//        type[2] = Delivery
//        type[3] = Pinto
//        type[4] = Wholesale

        String pcode = "";
        String plcode = "";
        Double qty = 0.000;
        Double avg = 0.000;
        Double price = 0.0000;
        Double scale = 0.000;
        String saletype = "";
        int formula = 1;
        int tempformula = 1;

        int totalFormula = 1;
        int countType = 1;

        try {
            String seekPcodeFromPlcode = "select pcode from posbom where plcode=? group by pcode";
            String seekFormula = "select formula from posbom where pcode=? group by formula";
            String seekPcode = "select "
                    + "p.pacost as cost,"
                    + "p.pscale as scale,"
                    + "b.plcode as plcode,"
                    + "b.pqty as qty,"
                    + "b.saletype as type,"
                    + "b.formula as formula "
                    + "from posbom b "
                    + "left join product p on p.pcode=b.plcode "
                    + "where b.pcode=? and b.formula=? "
                    + "order by b.formula";
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                PreparedStatement preChageIngredent = dbUtility.con.prepareStatement(seekPcodeFromPlcode);
                preChageIngredent.setString(1, cvth.Unicode2ASCII(Tplcode));
                ResultSet rsC = preChageIngredent.executeQuery();
                rsC.first();
                if (rsC.getRow() != 0) {
                    do {
                        formu.clear();
                        pcode = cvth.ASCII2Unicode(rsC.getString("pcode"));

                        PreparedStatement preF = dbUtility.con.prepareStatement(seekFormula);
                        preF.setString(1, cvth.Unicode2ASCII(pcode));
                        ResultSet rsF = preF.executeQuery();
                        rsF.first();
                        if (rsF.getRow() != 0) {

                            do {
                                int f = rsF.getInt("formula");

                                PreparedStatement pre = dbUtility.con.prepareStatement(seekPcode);
                                pre.setString(1, cvth.Unicode2ASCII(pcode));
                                pre.setInt(2, f);
                                ResultSet rs = pre.executeQuery();
                                rs.first();
                                if (rs.getRow() != 0) {
                                    do {
                                        plcode = "";
                                        qty = 0.000;
                                        avg = 0.000;
                                        price = 0.0000;
                                        scale = 0.000;
                                        saletype = "";
                                        formula = 1;

                                        plcode = cvth.ASCII2Unicode(rs.getString("plcode"));
                                        qty = rs.getDouble("qty");
                                        price = rs.getDouble("cost");
                                        scale = rs.getDouble("scale");
                                        saletype = cvth.ASCII2Unicode(rs.getString("type"));
                                        if (scale > 0) {
                                            avg = qty * (price / scale);
                                        }

                                        if (searchSaleType(saletype, "E")) {
                                            type[0] = type[0] + avg;
                                        }
                                        if (searchSaleType(saletype, "T")) {
                                            type[1] = type[1] + avg;
                                        }
                                        if (searchSaleType(saletype, "D")) {
                                            type[2] = type[2] + avg;
                                        }
                                        if (searchSaleType(saletype, "P")) {
                                            type[3] = type[3] + avg;
                                        }
                                        if (searchSaleType(saletype, "W")) {
                                            type[4] = type[4] + avg;
                                        }
                                    } while (rs.next());
                                }
                                rs.close();
                                pre.close();
                                rs = null;
                                pre = null;

                                for (int i = 0; i < 5; i++) {
                                    if (type[i] > 0) {
                                        countType++;
                                    }
                                }
                                Double sumAvg = (type[0] + type[1] + type[2] + type[3] + type[4]) / countType;
                                formu.add(sumAvg);
                                totalFormula++;
                            } while (rsF.next());
                        }
                        rsF.close();
                        preF.close();
                        rsF = null;
                        preF = null;

                        for (int j = 0; j < formu.size(); j++) {
                            cost = cost + formu.get(j);
                        }
                        cost = cost / formu.size();

                        updatePLCost(pcode, cost);


                    } while (rsC.next());
                }
                rsC.close();
                preChageIngredent.close();
                rsC = null;
                preChageIngredent = null;
            } else {
                PreparedStatement preChageIngredent = dbUtility.con.prepareStatement(seekPcodeFromPlcode);
                preChageIngredent.setString(1, (Tplcode));
                ResultSet rsC = preChageIngredent.executeQuery();
                rsC.first();
                if (rsC.getRow() != 0) {
                    do {
                        formu.clear();
                        pcode = (rsC.getString("pcode"));

                        PreparedStatement preF = dbUtility.con.prepareStatement(seekFormula);
                        preF.setString(1, (pcode));
                        ResultSet rsF = preF.executeQuery();
                        rsF.first();
                        if (rsF.getRow() != 0) {

                            do {
                                int f = rsF.getInt("formula");

                                PreparedStatement pre = dbUtility.con.prepareStatement(seekPcode);
                                pre.setString(1, (pcode));
                                pre.setInt(2, f);
                                ResultSet rs = pre.executeQuery();
                                rs.first();
                                if (rs.getRow() != 0) {
                                    do {
                                        plcode = "";
                                        qty = 0.000;
                                        avg = 0.000;
                                        price = 0.0000;
                                        scale = 0.000;
                                        saletype = "";
                                        formula = 1;

                                        plcode = (rs.getString("plcode"));
                                        qty = rs.getDouble("qty");
                                        price = rs.getDouble("cost");
                                        scale = rs.getDouble("scale");
                                        saletype = (rs.getString("type"));
                                        if (scale > 0) {
                                            avg = qty * (price / scale);
                                        }

                                        if (searchSaleType(saletype, "E")) {
                                            type[0] = type[0] + avg;
                                        }
                                        if (searchSaleType(saletype, "T")) {
                                            type[1] = type[1] + avg;
                                        }
                                        if (searchSaleType(saletype, "D")) {
                                            type[2] = type[2] + avg;
                                        }
                                        if (searchSaleType(saletype, "P")) {
                                            type[3] = type[3] + avg;
                                        }
                                        if (searchSaleType(saletype, "W")) {
                                            type[4] = type[4] + avg;
                                        }
                                    } while (rs.next());
                                }
                                rs.close();
                                pre.close();
                                rs = null;
                                pre = null;

                                for (int i = 0; i < 5; i++) {
                                    if (type[i] > 0) {
                                        countType++;
                                    }
                                }
                                Double sumAvg = (type[0] + type[1] + type[2] + type[3] + type[4]) / countType;
                                formu.add(sumAvg);
                                totalFormula++;
                            } while (rsF.next());
                        }
                        rsF.close();
                        preF.close();
                        rsF = null;
                        preF = null;

                        for (int j = 0; j < formu.size(); j++) {
                            cost = cost + formu.get(j);
                        }
                        cost = cost / formu.size();

                        updatePLCost(pcode, cost);
                    } while (rsC.next());
                }
                rsC.close();
                preChageIngredent.close();
                rsC = null;
                preChageIngredent = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public Double calculateCostProduct(String pcode) {
        Double cost = 0.0000;
        Double[] type = new Double[5];
        ArrayList<Double> formu = new ArrayList<Double>();
        boolean notHave = false;

        for (int i = 0; i < 5; i++) {
            type[i] = 0.000;
        }
//        type[0] = Eat In
//        type[1] = Take Away
//        type[2] = Delivery
//        type[3] = Pinto
//        type[4] = Wholesale
        String plcode = "";
        Double qty = 0.000;
        Double avg = 0.000;
        Double price = 0.0000;
        Double scale = 0.000;
        String saletype = "";
        int formula = 1;
        int tempformula = 1;

        int totalFormula = 1;
        int countType = 1;

        try {
//            String seekTFormula = "select count(formula) from posbom where pcode=? group by formula";
            String seekFormula = "select formula from posbom where pcode=? group by formula";
            String seekPcode = "select "
                    + "p.pacost as cost,"
                    + "p.pscale as scale,"
                    + "b.plcode as plcode,"
                    + "b.pqty as qty,"
                    + "b.saletype as type,"
                    + "b.formula as formula "
                    + "from posbom b "
                    + "left join product p on p.pcode=b.plcode "
                    + "where b.pcode=? and b.formula=? "
                    + "order by b.formula";
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
//                PreparedStatement preTotalF = dbUtility.con.prepareStatement(s);

                PreparedStatement preF = dbUtility.con.prepareStatement(seekFormula);
                preF.setString(1, cvth.Unicode2ASCII(pcode));
                ResultSet rsF = preF.executeQuery();
                rsF.first();
                if (rsF.getRow() != 0) {

                    do {
                        int f = rsF.getInt("formula");

                        PreparedStatement pre = dbUtility.con.prepareStatement(seekPcode);
                        pre.setString(1, cvth.Unicode2ASCII(pcode));
                        pre.setInt(2, f);
                        ResultSet rs = pre.executeQuery();
                        rs.first();
                        if (rs.getRow() != 0) {
                            do {
                                plcode = "";
                                qty = 0.000;
                                avg = 0.000;
                                price = 0.0000;
                                scale = 0.000;
                                saletype = "";
                                formula = 1;

                                plcode = cvth.ASCII2Unicode(rs.getString("plcode"));
                                qty = rs.getDouble("qty");
                                price = rs.getDouble("cost");
                                scale = rs.getDouble("scale");
                                saletype = cvth.ASCII2Unicode(rs.getString("type"));
                                if (scale > 0) {
                                    avg = qty * (price / scale);
                                }

                                if (searchSaleType(saletype, "E")) {
                                    type[0] = type[0] + avg;
                                }
                                if (searchSaleType(saletype, "T")) {
                                    type[1] = type[1] + avg;
                                }
                                if (searchSaleType(saletype, "D")) {
                                    type[2] = type[2] + avg;
                                }
                                if (searchSaleType(saletype, "P")) {
                                    type[3] = type[3] + avg;
                                }
                                if (searchSaleType(saletype, "W")) {
                                    type[4] = type[4] + avg;
                                }
                            } while (rs.next());
                        }
                        rs.close();
                        pre.close();
                        rs = null;
                        pre = null;

                        for (int i = 0; i < 5; i++) {
                            if (type[i] > 0) {
                                countType++;
                            }
                        }
                        Double sumAvg = (type[0] + type[1] + type[2] + type[3] + type[4]) / countType;
                        formu.add(sumAvg);
                        totalFormula++;
                    } while (rsF.next());
                } else {
                    notHave = true;
                }
                rsF.close();
                preF.close();
                rsF = null;
                preF = null;

                if (notHave) {
                    cost = 0.0000;
                } else {
                    if (formu.size() > 0) {
                        for (int j = 0; j < formu.size(); j++) {
                            cost = cost + formu.get(j);
                        }
                        cost = cost / formu.size();
                    }
                }
            } else {
                PreparedStatement preF = dbUtility.con.prepareStatement(seekFormula);
                preF.setString(1, (pcode));
                ResultSet rsF = preF.executeQuery();
                rsF.first();
                if (rsF.getRow() != 0) {

                    do {
                        int f = rsF.getInt("formula");

                        PreparedStatement pre = dbUtility.con.prepareStatement(seekPcode);
                        pre.setString(1, (pcode));
                        pre.setInt(2, f);
                        ResultSet rs = pre.executeQuery();
                        rs.first();
                        if (rs.getRow() != 0) {
                            do {
                                plcode = "";
                                qty = 0.000;
                                avg = 0.000;
                                price = 0.0000;
                                scale = 0.000;
                                saletype = "";
                                formula = 1;

                                plcode = (rs.getString("plcode"));
                                qty = rs.getDouble("qty");
                                price = rs.getDouble("cost");
                                scale = rs.getDouble("scale");
                                saletype = (rs.getString("type"));
                                if (scale > 0) {
                                    avg = qty * (price / scale);
                                }

                                if (searchSaleType(saletype, "E")) {
                                    type[0] = type[0] + avg;
                                }
                                if (searchSaleType(saletype, "T")) {
                                    type[1] = type[1] + avg;
                                }
                                if (searchSaleType(saletype, "D")) {
                                    type[2] = type[2] + avg;
                                }
                                if (searchSaleType(saletype, "P")) {
                                    type[3] = type[3] + avg;
                                }
                                if (searchSaleType(saletype, "W")) {
                                    type[4] = type[4] + avg;
                                }
                            } while (rs.next());
                        }
                        rs.close();
                        pre.close();
                        rs = null;
                        pre = null;

                        for (int i = 0; i < 5; i++) {
                            if (type[i] > 0) {
                                countType++;
                            }
                        }
                        Double sumAvg = (type[0] + type[1] + type[2] + type[3] + type[4]) / countType;
                        formu.add(sumAvg);
                        totalFormula++;
                    } while (rsF.next());
                } else {
                    notHave = true;
                }
                rsF.close();
                preF.close();
                rsF = null;
                preF = null;

                if (notHave) {
                    cost = 0.0000;
                } else {
                    if (formu.size() > 0) {
                        for (int j = 0; j < formu.size(); j++) {
                            cost = cost + formu.get(j);
                        }
                        cost = cost / formu.size();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0000;
        }

        return cost;
    }

    public void updatePLCost(String pcode, Double cost) {
        showMessage msn = new showMessage();
        try {
            String sql = "update product set plcost=? where pcode=?";

            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                PreparedStatement pre = dbUtility.con.prepareStatement(sql);
                pre.setDouble(1, cost);
                pre.setString(2, cvth.Unicode2ASCII(pcode));
                pre.executeUpdate();
                pre.close();
                pre = null;
            } else {
                PreparedStatement pre = dbUtility.con.prepareStatement(sql);
                pre.setDouble(1, cost);
                pre.setString(2, (pcode));
                pre.executeUpdate();
                pre.close();
                pre = null;
            }
        } catch (Exception e) {
            msn.showMessageError("เกิดความผิดพลาดบางประการ (plcost)");
            e.printStackTrace();
            return;
        }
    }
    
    public void writeFileIni(String pathFile, StringBuilder str) {
        try {
            File file = new File(pathFile);
            String line = "";
//            PrintWriter writer = new PrintWriter(file, "UTF-8");
            PrintWriter writer = new PrintWriter(file, "windows-874");
            BufferedWriter buff = new BufferedWriter(writer);
            buff.append(str);
            buff.flush();
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
