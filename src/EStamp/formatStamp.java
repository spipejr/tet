/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EStamp;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author natee
 */
public class formatStamp {

    showMessage msn = new showMessage();
    Locale lc = new Locale("th", "TH");
    private final SimpleDateFormat dayFmtShowThai = new SimpleDateFormat("EEE", lc);
    private final SimpleDateFormat dateFmtShowThaiB = new SimpleDateFormat("EEE MMMM yy", lc);
    private final SimpleDateFormat dateFmtShowThai = new SimpleDateFormat("dd MMMM yyyy", lc);
    private final SimpleDateFormat dayFmtShowEU = new SimpleDateFormat("EEE", Locale.ENGLISH);
    private final SimpleDateFormat dateFmtShowEUB = new SimpleDateFormat("EEE MMMM yy", Locale.ENGLISH);
    private final SimpleDateFormat dateFmtShowEU = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    public final SimpleDateFormat dateFmtShow = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
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
    private final DecimalFormat intFmtSQL = new DecimalFormat("##0");
    private final DecimalFormat doubleFmtShow = new DecimalFormat("##,###,##0.00");
    private final DecimalFormat double3FmtShow = new DecimalFormat("##,###,##0.000");
    private final DecimalFormat double4FmtShow = new DecimalFormat("##,###,##0.0000");
    private final DecimalFormat doubleFmtSQL = new DecimalFormat("#0.00");
    private final DecimalFormat double3FmtSQL = new DecimalFormat("#0.000");
    private final DecimalFormat double4FmtSQL = new DecimalFormat("#0.0000");
    private final DecimalFormat percentFmt = new DecimalFormat("##,###,##0.00");
     private final SimpleDateFormat timeFmtmili = new SimpleDateFormat("HH:mm:ss:SS", Locale.ENGLISH);
    
     
      public String timeFmtmili(Object ob) {
        return timeFmtmili.format(ob);
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

    public DecimalFormat getIntFmtShow() {
        return intFmtShow;
    }

    public DecimalFormat getDoubleFmtSQL() {
        return doubleFmtSQL;
    }

    public DecimalFormat getDoubleFmtShow() {
        return doubleFmtShow;
    }

    public DecimalFormat getDouble3FmtSQL() {
        return double3FmtSQL;
    }

    public DecimalFormat getDouble3FmtShow() {
        return double3FmtShow;
    }

    public DecimalFormat getDouble4FmtSQL() {
        return double4FmtSQL;
    }

    public DecimalFormat getDouble4FmtShow() {
        return double4FmtShow;
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
    
    public String First(String Fdate){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 1);
        Date firstDateOfPreviousMonth = cal.getTime();

        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE)); // changed calendar to cal

        //Date lastDateOfPreviousMonth = cal.getTime();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String f_date = dateFormat.format(firstDateOfPreviousMonth);
        //String l_date = dateFormat.format(lastDateOfPreviousMonth);
        return f_date;
    }
    
    public String Last(String Ldate){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 1);
        //Date firstDateOfPreviousMonth = cal.getTime();

        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE)); // changed calendar to cal

        Date lastDateOfPreviousMonth = cal.getTime();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //String f_date = dateFormat.format(firstDateOfPreviousMonth);
        String l_date = dateFormat.format(lastDateOfPreviousMonth);
        return l_date;
    }
    
    public boolean checkFormatDate(String date) {
        try {
            Date d = dateFmtShow.parse(date);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public Boolean ChkDate(String tdate) {
        SimpleDateFormat DateFmt = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Boolean ReturnValue = true;
        Date TempDate = new Date();
        try {
            TempDate = DateFmt.parse(tdate);
            if (TempDate.getYear() > 2200) {
                msn.showMessageWarning("กรุณาป้อนวันที่ให้ถูกต้อง...EXP(dd/MM/yyyy) โดยป้อนปีเป็นปี คศ.เท่านั้น...");
                ReturnValue = false;
            } else {
                ReturnValue = true;
            }
        } catch (Exception ex) {
            msn.showMessageWarning("กรุณาป้อนวันที่ให้ถูกต้อง...EXP(dd/MM/yyyy)");
            ReturnValue = false;
        }

        return ReturnValue;
    }

    public boolean isNumberic(String number) {
        try {
            double num = Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean chkLimitDotNumber(String num, int limit) {
        boolean result = true;
        int index = 0;
        double d = 0;
        if (num.length() > 0) {
            index = num.indexOf(".");
            d = Double.parseDouble(convertDoubleString(num));
            if (d != 0) {
                if (index >= 0) {
                    String data = num.substring(index + 1);
                    if (data.length() >= limit) {
                        result = false;
                    } else {
                        result = true;
                    }
                }
            }
        }

        return result;
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

    public String[] setYearCombo() {
        String[] strYear = new String[4];
        int year = Integer.parseInt(year4Fmt(nowDate())) - 3;

        for (int i = 0; i < 4; i++) {
            strYear[i] = (year + i) + "";
        }
        return strYear;
    }
}
