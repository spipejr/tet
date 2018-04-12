/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilititiesfunction;

import dbutility.dbUtility;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
 
/**
 *
 * @author natee 
 */
public class PUtility {

    Font myfont = new Font("Tahoma", Font.PLAIN, 14);
    static SimpleDateFormat Dateft = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    Date date = new Date();
    static ThaiUtilities cvth = new ThaiUtilities();

    public static Boolean ChkValidDate(Date tdate) {
        Boolean ReturnValue = true;
        String TempStr = "";
        try {
            TempStr = Dateft.format(tdate);
            ReturnValue = true;
        } catch (Exception e) {
            ReturnValue = false;
        }
        return ReturnValue;
    }

    public static String ConvertReal(String TStr) {
        String TempStr = "";
        if (TStr.indexOf(",") > 0) {
            for (int i = 0; i < TStr.length(); i++) {
                char ch = TStr.charAt(i);
                String StrCh = "";
                StrCh = StrCh + ch;
                if (!StrCh.equals(",")) {
                    TempStr = TempStr + StrCh;
                }
            }
        } else {
            TempStr = TStr;
        }
        return TempStr;
    }

    public static Boolean ChkDate(String tdate) {
        SimpleDateFormat DateFmt = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Boolean ReturnValue = true;
        Date TempDate = new Date();
        try {
            TempDate = DateFmt.parse(tdate);
            if (TempDate.getYear() > 2200) {
                JOptionPane.showMessageDialog(null, "กรุณาป้อนวันที่ให้ถูกต้อง...EXP(dd/MM/yyyy) โดยป้อนปีเป็นปี คศ.เท่านั้น...");
                ReturnValue = false;
            } else {
                ReturnValue = true;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "กรุณาป้อนวันที่ให้ถูกต้อง...EXP(dd/MM/yyyy)");
            ReturnValue = false;
        }

        return ReturnValue;
    }

    public static Calendar StrToCalendar(String tdate) {
        SimpleDateFormat DateFmt = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Boolean ReturnValue = true;
        Calendar ca2 = new GregorianCalendar();
        Date TempDate = new Date();
        int dd = Integer.parseInt(tdate.substring(0, 2));
        int mm = Integer.parseInt(tdate.substring(3, 5));
        int yy = Integer.parseInt(tdate.substring(6, 10));
        ca2.set(Calendar.YEAR, yy);
        ca2.set(Calendar.MONTH, mm - 1);
        ca2.set(Calendar.DATE, dd);
        ca2.set(Calendar.HOUR, 0);
        ca2.set(Calendar.MINUTE, 0);
        ca2.set(Calendar.SECOND, 0);
        return ca2;
    }

    public static int getDaysBetween(java.util.Calendar d1, java.util.Calendar d2) {
        if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end

            java.util.Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(java.util.Calendar.DAY_OF_YEAR)
                - d1.get(java.util.Calendar.DAY_OF_YEAR);
        int y2 = d2.get(java.util.Calendar.YEAR);
        if (d1.get(java.util.Calendar.YEAR) != y2) {
            d1 = (java.util.Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
                d1.add(java.util.Calendar.YEAR, 1);
            } while (d1.get(java.util.Calendar.YEAR) != y2);
        }
        return days;
    }

    public static Boolean ShowConfirmMsg(String ConfirmMsg) {
        int option = JOptionPane.showConfirmDialog(null, ConfirmMsg, "Confirm Dialog ....", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    public static String Addzero(String Str, int Len) {
        String TempStr = "";
        String ReturnStr = "";
        int StrLen = Str.trim().length();
        if (StrLen < Len) {
            for (int i = 1; i <= Len - StrLen; i++) {
                TempStr = TempStr + "0";
            }
            ReturnStr = TempStr + Str.trim();
        } else {
            ReturnStr = Str;
        }
        return ReturnStr;
    }

    public static boolean ChkNumValue(String Str) {
        String NumList[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "-", ","};
        StringBuilder StrBuf = new StringBuilder();
        char ch;
        String Tmp;
        int Num = 0;
        int Chk = 0;
        for (int j = 0; j < Str.length(); j++) {
            ch = Str.charAt(j);
            Tmp = "";
            Tmp = Tmp + ch;

            Chk = 0;
            for (int i = 0; i < NumList.length; i++) {
                if (NumList[i].equals(Tmp)) {
                    Chk++;
                }
            }
            if (Chk > 0) {
                Num++;
            }
        }
        if (Num == Str.length() && Str.length() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String DataFull(String Str, int Len) {
        String ReturnStr = "";
        String AddStr = "";
        if (Len < Str.length()) {
            ReturnStr = Str.substring(0, Len - 1);
        } else {
            for (int i = 1; i <= (Len - Str.length()); i++) {
                AddStr = AddStr + " ";
            }
            ReturnStr = AddStr + Str.trim();
        }
        return ReturnStr;
    }

    public static String CurDate() {
        Date d = new Date();
        String StrDate;
        return StrDate = Dateft.format(d);
    }

    public static void ShowMsg(String StrMsg) {
        //JOptionPane jd = new JOptionPane() ;

        JOptionPane.showMessageDialog(null, StrMsg, "Show Message Dialog...", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowError(String StrMsg) {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), StrMsg, "Show Error Dialog...", JOptionPane.ERROR_MESSAGE);

    }

    public static void ShowMyMsg(java.awt.Component TComponent, String StrMsg) {
        JOptionPane.showMessageDialog(TComponent, StrMsg, "Show Error Dialog...", JOptionPane.ERROR_MESSAGE);

    }

    public static void ShowWaring(String StrMsg) {
        JOptionPane.showMessageDialog(null, StrMsg, "Show Waring Dialog...", JOptionPane.WARNING_MESSAGE);
    }

    public static String SeekGroupName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from groupfile where groupcode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("groupname");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("groupname"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    public static String SeekDeptName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from deptfile where deptcode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
             if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("deptname");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("deptname"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }

    public static String SeekProductName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from product where pcode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("pdesc");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("pdesc"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    public static String SeekProductUnit(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from product where pcode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
             if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("punit1");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("punit1"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    public static String SeekProductGroup(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from product where pcode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = "";
            } else {
                ReturnValues = rec.getString("pgroup");
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    
    public static String getcampaignname(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from campaignfile where campaign_code='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {

                ReturnValues = "";
            } else {
                ReturnValues = cvth.ASCII2Unicode(rec.getString("campaign_name"));
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    public static String getcampaigncode(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from protab where procode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = "";
            } else {
                ReturnValues = cvth.ASCII2Unicode(rec.getString("campaign_code"));
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    public static String getcampaigncode2(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from cupon where cucode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = "";
            } else {
                ReturnValues = cvth.ASCII2Unicode(rec.getString("campaign_code"));
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    
    public static boolean ChkCampignOK(String TCode) {
        boolean ReturnValues = false;
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from campaignfile where campaign_code='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = false;
            } else {
                ReturnValues = true;
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    
    public static boolean ChkDeptOK(String TCode) {
        boolean ReturnValues = false;
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from deptfile where deptcode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = false;
            } else {
                ReturnValues = true;
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }

    public static String SeekBranchName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from branfile where code='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("name");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("name"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    public static String SeekBTypeName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from btype where btcode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
             if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("btname");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("btname"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    public static String SeekAreaName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from area where code='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("name");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("name"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
     public static String SeekSizeName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from size where code='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("name");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("name"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
     public static String SeekPlaneName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from plane where code='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("name");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("name"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
     public static String SeekStoreName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from store where code='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
            if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("name");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("name"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
     public static String SeekComName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from company where code='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
             if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("name");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("name"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
     public static String SeekBrandName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from brandfile where brandcode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
             if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("brandname");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("brandname"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
     public static String SeekBusTypeName(String TCode) {
        String ReturnValues = "";
        try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String UserGroupFile = "select *from businesstype where buscode='" + TCode + "'";
            ResultSet rec = stmt.executeQuery(UserGroupFile);
            rec.first();
             if (rec.getRow() == 0) {
                ReturnValues = "*****";
            } else {
                if (dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                     ReturnValues = rec.getString("busname");
                } else {
                    ReturnValues = cvth.ASCII2Unicode(rec.getString("busname"));
                }
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            PUtility.ShowError(e.getMessage());
        }
        return ReturnValues;
    }
    public static String ConvertPersent(String TStr) {
        String TempStr = "";
        if (TStr.indexOf("%") > 0) {
            for (int i = 0; i < TStr.length(); i++) {
                char ch = TStr.charAt(i);
                String StrCh = "";
                StrCh = StrCh + ch;
                if (!StrCh.equals("%")) {
                    TempStr = TempStr + StrCh;
                }
            }
        } else {
            TempStr = TStr;
        }
        return TempStr;
    }

    public static boolean CheckPersent(String TStr) {
        boolean TempStr = false;
        if (TStr.indexOf("%") > 0) {
            for (int i = 0; i < TStr.length(); i++) {
                char ch = TStr.charAt(i);
                String StrCh = "";
                StrCh = StrCh + ch;
                if (StrCh.equals("%")) {
                    TempStr = true;
                }
            }
        }

        return TempStr;
    }

    public static boolean CheckPersent2(String TStr) {
        boolean TempStr = true;
        String p = "%";
        int pCount = 0;
        char c = 0;
        int index = TStr.indexOf(p);

        if(index == 0){
            TempStr = false;
        }
        while (index > 0) {
            pCount++;
            index -= p.length();
            char ch = TStr.charAt(index);
            
            c = ch;

            if (c < '0' || c > '9'||c == ' ' ){
                  TempStr = false;
            }
            if (c =='.'){
                TempStr = true;
            }

             }
        int index2 = TStr.indexOf(p);
            while (index2 <  TStr.length()-1) {
            pCount++;
            index2 += p.length();
            char ch2 = TStr.charAt(index2);
            
            c = ch2;

           if (c != ' ' || c != ','){
                  TempStr = false;
            }

        }

        return TempStr;
       
    }

    public static String ConvertPlus(String TStr) {
        String TempStr = "";
        if (TStr.indexOf("+") > 0) {
            for (int i = 0; i < TStr.length(); i++) {
                char ch = TStr.charAt(i);
                String StrCh = "";
                StrCh = StrCh + ch;
                if (!StrCh.equals("+")) {
                    TempStr = TempStr + StrCh;
                }
            }
        } else {
            TempStr = TStr;
        }
        return TempStr;
    }

    public static String ConvertPlusTest(String TStr) {
        String TempStr = "";
        if (TStr.indexOf("+") > 0) {
            for (int i = 0; i < TStr.length(); i++) {
                char ch = TStr.charAt(i);
                String StrCh = ",";
                StrCh = ch + StrCh;
                if (!StrCh.equals("+")) {
                    TempStr = TempStr + StrCh;
                }
            }
        } else {
            TempStr = TStr;
        }
        return TempStr;
    }

    public static boolean CheckFmtPersent(String TStr) {
        boolean TempStr = false;
        if (TStr.indexOf("%") > 0) {
            for (int i = 0; i < TStr.length(); i++) {

                char ch = TStr.charAt(i);


//                Character.isLetterOrDigit(i);

                String StrCh = "";
                StrCh = StrCh + ch;
                if (StrCh.equals("%")) {
                    TempStr = true;

                }
            }
        }
        return TempStr;
    }
    
//    public static String ConvertInt(String TStr) {
//        String TempStr = "";
//        int pCount = 0;
//        int a = TStr.length();
//        char c = 0;
////        int index = TStr.indexOf(p);
//
//       
//        while (TStr.length() > 0) {
//            pCount++;
//            
//            char ch = TStr.charAt(a);
//            
//            c = ch;
//
//            if (c < '0' || c > '9'){
//                   c = ' ';
//            }
//            
//             }
//       
//
//        return TempStr;
//       
//    }
    
    public static boolean CheckStringDay(String TStr) {
        boolean TempStr = true;
        String p = "วัน";
        int pCount = 0;
        char c = 0;
        int index = TStr.indexOf(p);

        if(index == 0){
            TempStr = false;
        }
        while (index > 0) {
            pCount++;
            index -= p.length();
            char ch = TStr.charAt(index);
            
            c = ch;

            if (c < '0' || c > '9'||c == ' ' ){
                  TempStr = false;
            }
            
            int index2 = TStr.indexOf(p);
            while (index2 <  TStr.length()-1) {
            pCount++;
            index2 += p.length();
            char ch2 = TStr.charAt(index2);
            
            c = ch2;

           if (c != ' ' ){
                  TempStr = false;
            }

        }
            

             }
       

        return TempStr;
       
    }
    
    public static String ConvertStringDay(String TStr) {
        String TempStr = "";
        if (TStr.length() > 0) {
            for (int i = 0; i < TStr.length(); i++) {
                char ch = TStr.charAt(i);
                
                String StrCh = "";
                StrCh = StrCh + ch;
                
                boolean d = ch < '0' || ch > '9'||ch == ' ';
                if ( !d ) {
                    TempStr = TempStr + StrCh;
                }
            }
        } else {
            TempStr = TStr;
        }
        return TempStr;
    }

}
