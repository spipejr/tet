/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilititiesfunction;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author root
 */
public class Format {
    public final static SimpleDateFormat dateFmtShow = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public final static SimpleDateFormat dateFmtSql = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    public final static SimpleDateFormat dateText = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    public final static SimpleDateFormat MonText = new SimpleDateFormat("MMM-yy", Locale.ENGLISH);
    public final static SimpleDateFormat dateTextShort = new SimpleDateFormat("yyMMdd", Locale.ENGLISH);
    public final static SimpleDateFormat dateFmtReport = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    public final static SimpleDateFormat timeFmt = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
    public final static DecimalFormat doubleFmt = new DecimalFormat("##,###,##0.00");
    public final static DecimalFormat qtyFmt = new DecimalFormat("##,###,##0.000");
    public final static DecimalFormat integerFmt = new DecimalFormat("##,###,##0");
    public final static DecimalFormat double3Fmt = new DecimalFormat("##,###,##0.000");
    public final static DecimalFormat percentFmt = new DecimalFormat("#,##0.00%");
    public final static DecimalFormat zero = new DecimalFormat("00");
    public final static DecimalFormat percentFmtnodot = new DecimalFormat("##,###,##0%");
    public final static SimpleDateFormat yearBackupPath = new SimpleDateFormat("yyyyMM", Locale.ENGLISH);
    public final static SimpleDateFormat DayName = new SimpleDateFormat("EEEE", Locale.ENGLISH);
    public final static SimpleDateFormat DayName2 = new SimpleDateFormat("EEE dd", Locale.ENGLISH);
    public final static SimpleDateFormat year = new SimpleDateFormat("yyyy", Locale.ENGLISH);
    public final static SimpleDateFormat mount = new SimpleDateFormat("MM", Locale.ENGLISH);
    public final static SimpleDateFormat MountYear= new SimpleDateFormat("/MM/yyyy", Locale.ENGLISH);
    public final static SimpleDateFormat daymount= new SimpleDateFormat("dd MMM", Locale.ENGLISH);
    public final static SimpleDateFormat fmmonthyear= new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);
    
    
}
