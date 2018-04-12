package utilities.DateChooser;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JTextField;

public class DateUtil {

    private DateUtil() {
        throw new AssertionError();
    }

    public static int getMaxDay(GregorianCalendar month) {
        int nday;
        switch (month.get(Calendar.MONTH)) {
            case 0:
                nday = 31;
                break;
            case 1:
                nday = month.isLeapYear(month.get(Calendar.MONTH)) ? 29 : 28;
                break;
            case 2:
                nday = 31;
                break;
            case 3:
                nday = 30;
                break;
            case 4:
                nday = 31;
                break;
            case 5:
                nday = 30;
                break;
            case 6:
                nday = 31;
                break;
            case 7:
                nday = 31;
                break;
            case 8:
                nday = 30;
                break;
            case 9:
                nday = 31;
                break;
            case 10:
                nday = 30;
                break;
            case 11:
                nday = 31;
                break;
            default:
                nday = 0;
                break;
        }
        return nday;
    }

    public static int getDistanceDays(Calendar gc1, Calendar gc2) {
        int elapsed = 0;
        GregorianCalendar g1, g2;
        if (gc2.after(gc1)) {
            g2 = (GregorianCalendar) gc2.clone();
            g1 = (GregorianCalendar) gc1.clone();
        } else {
            g2 = (GregorianCalendar) gc1.clone();
            g1 = (GregorianCalendar) gc2.clone();
        }
        g1.clear(Calendar.MILLISECOND);
        g1.clear(Calendar.SECOND);
        g1.clear(Calendar.MINUTE);
        g1.clear(Calendar.HOUR_OF_DAY);
        g2.clear(Calendar.MILLISECOND);
        g2.clear(Calendar.SECOND);
        g2.clear(Calendar.MINUTE);
        g2.clear(Calendar.HOUR_OF_DAY);
        while (g1.before(g2)) {
            g1.add(Calendar.DATE, 1);
            elapsed++;
        }
        return elapsed;
    }

    public static int getDistanceMonths(Calendar gc1, Calendar gc2) {
        int elapsed = 0;
        GregorianCalendar g1, g2;
        if (gc2.after(gc1)) {
            g2 = (GregorianCalendar) gc2.clone();
            g1 = (GregorianCalendar) gc1.clone();
        } else {
            g2 = (GregorianCalendar) gc1.clone();
            g1 = (GregorianCalendar) gc2.clone();
        }
        g1.clear(Calendar.MILLISECOND);
        g1.clear(Calendar.SECOND);
        g1.clear(Calendar.MINUTE);
        g1.clear(Calendar.HOUR_OF_DAY);
        g1.clear(Calendar.DATE);
        g2.clear(Calendar.MILLISECOND);
        g2.clear(Calendar.SECOND);
        g2.clear(Calendar.MINUTE);
        g2.clear(Calendar.HOUR_OF_DAY);
        g2.clear(Calendar.DATE);
        while (g1.before(g2)) {
            g1.add(Calendar.MONTH, 1);
            elapsed++;
        }
        return elapsed;
    }

    public static long getDistanceMillis(Calendar gc1, Calendar gc2) {
        Date d1 = gc1.getTime();
        Date d2 = gc2.getTime();
        long l1 = d1.getTime();
        long l2 = d2.getTime();
        long difference = l2 - l1;
        return difference;
    }

    public static long getDistanceSeconds(Calendar gc1, Calendar gc2) {
        Date d1 = gc1.getTime();
        Date d2 = gc2.getTime();
        long l1 = d1.getTime();
        long l2 = d2.getTime();
        long difference = l2 - l1;
        return difference / 1000;
    }

    public static int getMaximumDay(Calendar gc1) {
        gc1.set(Calendar.DAY_OF_MONTH, 1);
        GregorianCalendar gc2 = (GregorianCalendar) gc1.clone();
        gc2.add(Calendar.MONTH, 1);
        int count = 0;
        while (gc1.compareTo(gc2) <= -1) {
            gc1.add(Calendar.DAY_OF_MONTH, 1);
            count++;
        }
        return count;
    }

    public static GregorianCalendar fusionDate(Date day, Date time) {
        SimpleDateFormat year = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        SimpleDateFormat month = new SimpleDateFormat("M", Locale.ENGLISH);
        SimpleDateFormat date = new SimpleDateFormat("d", Locale.ENGLISH);
        SimpleDateFormat hour = new SimpleDateFormat("H", Locale.ENGLISH);
        SimpleDateFormat minute = new SimpleDateFormat("m", Locale.ENGLISH);
        SimpleDateFormat second = new SimpleDateFormat("s", Locale.ENGLISH);
        GregorianCalendar cal = null;
        cal = new GregorianCalendar(
                Integer.parseInt(year.format(day)),
                Integer.parseInt(month.format(day)) - 1,
                Integer.parseInt(date.format(day)),
                Integer.parseInt(hour.format(time)),
                Integer.parseInt(minute.format(time)),
                Integer.parseInt(second.format(time)));

        return cal;
    }

    public static GregorianCalendar convertDateToCal(Date day) {
        SimpleDateFormat year = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        SimpleDateFormat month = new SimpleDateFormat("M", Locale.ENGLISH);
        SimpleDateFormat date = new SimpleDateFormat("d", Locale.ENGLISH);
        SimpleDateFormat hour = new SimpleDateFormat("H", Locale.ENGLISH);
        SimpleDateFormat minute = new SimpleDateFormat("m", Locale.ENGLISH);
        SimpleDateFormat second = new SimpleDateFormat("s", Locale.ENGLISH);
        GregorianCalendar cal = null;
        try {
            cal = new GregorianCalendar(
                    Integer.parseInt(year.format(day)),
                    Integer.parseInt(month.format(day)) - 1,
                    Integer.parseInt(date.format(day)),
                    Integer.parseInt(hour.format(day)),
                    Integer.parseInt(minute.format(day)),
                    Integer.parseInt(second.format(day)));
        } catch (Exception ex) {
        }
        return cal;
    }

    public static GregorianCalendar showDateChooserDialog(JTextField jtext, JButton btn) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            GregorianCalendar cal;
            DateChooserDialog dcd = new DateChooserDialog(new javax.swing.JFrame(), true, btn.getLocationOnScreen());
            dcd.setVisible(true);
            if (dcd.getSelectedDate() != null) {
                cal = (GregorianCalendar) dcd.getSelectedDate();
                jtext.setText(fmt.format(cal.getTime()));
            } else {
                return null;
            }
            return cal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static GregorianCalendar showDateChooserDialog(JTextField jtext, SimpleDateFormat format) {
        try {
            SimpleDateFormat fmt = format;
            GregorianCalendar cal;
            DateChooserDialog dcd = new DateChooserDialog(null, true);
            dcd.setVisible(true);
            cal = (GregorianCalendar) dcd.getSelectedDate();
            if (cal != null) {
                jtext.setText(fmt.format(cal.getTime()));
            }
            return cal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Time lunarStay(Calendar lunarLanding, Calendar lunarDeparture) {

        long timeInMillis = getDistanceMillis(lunarLanding, lunarDeparture);
        long timeInSecons = getDistanceSeconds(lunarLanding, lunarDeparture);

        long day, hours, minutes, seconds, millis;

        hours = timeInSecons / 3600;
        timeInSecons = timeInSecons - (hours * 3600);
        minutes = timeInSecons / 60;
        timeInSecons = timeInSecons - (minutes * 60);
        seconds = timeInSecons;

        millis = timeInMillis % 1000;

        day = hours / 24;
        hours = hours % 24;

        return new Time(day, (int) hours, (int) minutes, (int) seconds, (int) millis);

    }

    public static void main(String[] args) {
        GregorianCalendar start = new GregorianCalendar(2007, 1, 1, 20, 20, 20);
        start.set(Calendar.MILLISECOND, 100);
        GregorianCalendar stop = new GregorianCalendar(2007, 1, 3, 10, 25, 20);
        stop.set(Calendar.MILLISECOND, 900);
//        System.out.println(lunarStay(start,stop).toString());

    }

    public static Date addDate(Date date, int amount) {
        Date d1 = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, amount);
        d1 = cal.getTime();
        return cal.getTime();
    }

    public static int getDate(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Calendar start_date = new GregorianCalendar();
        Calendar end_date = new GregorianCalendar();
        java.util.Date bDate, eDate;
        try {
            bDate = sdf.parse(date1);
            eDate = sdf.parse(date2);
            start_date.setTime(bDate);
            end_date.setTime(eDate);
        } catch (java.text.ParseException e) {
        }
        long bTime = start_date.getTimeInMillis();
        long eTime = end_date.getTimeInMillis();
        long dayAmount = eTime - bTime;
        int day = (int) (dayAmount / (1000 * 60 * 60 * 24));
        return day;
    }

}
