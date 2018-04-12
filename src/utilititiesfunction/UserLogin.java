/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilititiesfunction;

import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author s386
 */
public class UserLogin {

    public static UserLogin userlogin = null;
    private String UserName;
    private String Usergroup;
    private String Name;
    private String Mast1;
    private String Mast2;
    private String Mast3;
    private String Mast4;
    private String Mast5;
    private String Mast6;
    private String Mast7;
    private String Mast8;
    private String Mast9;
    private String Mast10;
    private String Mast11;
    private String Mast12;
    private String Mast13;
    private String Mast14;
    private String Mast15;
    private String Mast16;
    private String Mast17;
    private String Mast18;
    private String Mast19;
    private String Mast20;
    private String Mast21;
    private String Mast22;
    private String Mast23;
    private String Mast24;
    private String Mast25;
    private String M212;
    private String M213;
    private String M214;
    private String M215;
    private String M216;
    private String M217;

    private String Plu1;
    private String Plu2;
    private String Plu3;
    private String Plu4;
    private String Plu5;
    private String Plu6;
    private String Plu7;
    private String Plu8;
    private String Plu9;
    private String Plu10;
    private String Plu11;
    private String Plu12;
    private String Plu13;
    private String Plu14;
    private String Plu15;
    private String Plu16;
    private String Plu17;
    private String Plu18;
    private String Plu19;
    private String Plu20;
    private String Tran1;
    private String Tran2;
    private String Tran3;
    private String Tran4;
    private String Tran5;
    private String Tran6;
    private String Tran7;
    private String Tran8;
    private String Tran9;
    private String Tran10;
    private String Tran11;
    private String Rpt1;
    private String Rpt2;
    private String Rpt3;
    private String Rpt4;
    private String Rpt5;
    private String Rpt6;
    private String Rpt7;
    private String Rpt8;
    private String Rpt9;
    private String Rpt10;
    private String Rpt11;
    private String Rpt12;
    private String Rpt13;
    private String Rpt14;
    private String Rpt15;
    private String Rpt16;
    private String Rpt17;
    private String Rpt18;
    private String Rpt19;
    private String Rpt20;
    private String Rpt21;
    private String Rpt22;
    private String Rpt23;
    private String Rpt24;
    private String Rpt25;
    private String Rpt26;
    private String Rpt27;
    private String Rpt28;
    private String Rpt29;
    private String Rpt30;
    private String Rpt31;
    private String Rpt32;
    private String Rpt33;
    private String Rpt34;
    private String Rpt35;
    private String Rpt36;
    private String Rpt37;
    private String Rpt38;
    private String Rpt39;
    private String Rpt40;
    private String Rpt41;
    private String Rpt42;
    private String Rpt43;
    private String Rpt44;
    private String Rpt45;
    private String Rpt46;
    private String Rpt47;
    private String Rpt48;
    private String Rpt49;
    private String Rpt50;
    private String Cont1;
    private String Cont2;
    private String Cont3;
    private String Cont4;
    private String Cont5;
    private String Cont6;
    private String Cont7;
    private String Cont8;
    private String Cont9;
    private String Cont10;

    private String Mast26;
    private String Mast27;
    private String Mast28;
    private String Mast29;
    private String Mast30;
    private String Rpt51;
    private String Rpt52;

    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public boolean setActionMenu(String UserName) {
        boolean chk = false;
        userlogin = new UserLogin();
        try {
            db.dbconnect();
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String sql = "";
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                sql = "select * from borgrouplinux g inner join boruserlinux u on g.usergroup = u.usergroup  where username = '" + cvth.Unicode2ASCII(UserName) + "'";
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    userlogin.UserName = cvth.ASCII2Unicode(rs.getString("username"));
                    userlogin.Usergroup = cvth.ASCII2Unicode(rs.getString("u.Usergroup"));
                    userlogin.Name = cvth.ASCII2Unicode(rs.getString("u.name"));
                    userlogin.Mast1 = rs.getString("Mast1");
                    userlogin.Mast2 = rs.getString("Mast2");
                    userlogin.Mast3 = rs.getString("Mast3");
                    userlogin.Mast4 = rs.getString("Mast4");
                    userlogin.Mast5 = rs.getString("Mast5");
                    userlogin.Mast6 = rs.getString("Mast6");
                    userlogin.Mast7 = rs.getString("Mast7");
                    userlogin.Mast8 = rs.getString("Mast8");
                    userlogin.Mast9 = rs.getString("Mast9");
                    userlogin.Mast10 = rs.getString("Mast10");
                    userlogin.Mast11 = rs.getString("Mast11");
                    userlogin.Mast12 = rs.getString("Mast12");
                    userlogin.Mast13 = rs.getString("Mast13");
                    userlogin.Mast14 = rs.getString("Mast14");
                    userlogin.Mast15 = rs.getString("Mast15");
                    userlogin.Mast16 = rs.getString("Mast16");
                    userlogin.Mast17 = rs.getString("Mast17");
                    userlogin.Mast18 = rs.getString("Mast18");
                    userlogin.Mast19 = rs.getString("Mast19");
                    userlogin.Mast20 = rs.getString("Mast20");
                    userlogin.Mast21 = rs.getString("Mast21");
                    userlogin.Mast22 = rs.getString("Mast22");
                    userlogin.Mast23 = rs.getString("Mast23");
                    userlogin.Mast24 = rs.getString("Mast24");
                    userlogin.Mast25 = rs.getString("Mast25");

                    userlogin.M212 = rs.getString("M212");
                    userlogin.M213 = rs.getString("M213");
                    userlogin.M214 = rs.getString("M214");
                    userlogin.M215 = rs.getString("M215");
                    userlogin.M216 = rs.getString("M216");
                    userlogin.M217 = rs.getString("M217");

                    userlogin.Plu1 = rs.getString("Plu1");
                    userlogin.Plu2 = rs.getString("Plu2");
                    userlogin.Plu3 = rs.getString("Plu3");
                    userlogin.Plu4 = rs.getString("Plu4");
                    userlogin.Plu5 = rs.getString("Plu5");
                    userlogin.Plu6 = rs.getString("Plu6");
                    userlogin.Plu7 = rs.getString("Plu7");
                    userlogin.Plu8 = rs.getString("Plu8");
                    userlogin.Plu9 = rs.getString("Plu9");
                    userlogin.Plu10 = rs.getString("Plu10");
                    userlogin.Plu11 = rs.getString("Plu11");
                    userlogin.Plu12 = rs.getString("Plu12");
                    userlogin.Plu13 = rs.getString("Plu13");
                    userlogin.Plu14 = rs.getString("Plu14");
                    userlogin.Plu15 = rs.getString("Plu15");
                    userlogin.Plu16 = rs.getString("Plu16");
                    userlogin.Plu17 = rs.getString("Plu17");
                    userlogin.Plu18 = rs.getString("Plu18");
                    userlogin.Plu19 = rs.getString("Plu19");
                    userlogin.Plu20 = rs.getString("Plu20");
                    userlogin.Tran1 = rs.getString("Tran1");
                    userlogin.Tran2 = rs.getString("Tran2");
                    userlogin.Tran3 = rs.getString("Tran3");
                    userlogin.Tran4 = rs.getString("Tran4");
                    userlogin.Tran5 = rs.getString("Tran5");
                    userlogin.Tran6 = rs.getString("Tran6");
                    userlogin.Tran7 = rs.getString("Tran7");
                    userlogin.Tran8 = rs.getString("Tran8");
                    userlogin.Tran9 = rs.getString("Tran9");
                    userlogin.Tran10 = rs.getString("Tran10");
                    userlogin.Tran11 = rs.getString("Tran11");
                    userlogin.Rpt1 = rs.getString("Rpt1");
                    userlogin.Rpt2 = rs.getString("Rpt2");
                    userlogin.Rpt3 = rs.getString("Rpt3");
                    userlogin.Rpt4 = rs.getString("Rpt4");
                    userlogin.Rpt5 = rs.getString("Rpt5");
                    userlogin.Rpt6 = rs.getString("Rpt6");
                    userlogin.Rpt7 = rs.getString("Rpt7");
                    userlogin.Rpt8 = rs.getString("Rpt8");
                    userlogin.Rpt9 = rs.getString("Rpt9");
                    userlogin.Rpt10 = rs.getString("Rpt10");
                    userlogin.Rpt11 = rs.getString("Rpt11");
                    userlogin.Rpt12 = rs.getString("Rpt12");
                    userlogin.Rpt13 = rs.getString("Rpt13");
                    userlogin.Rpt14 = rs.getString("Rpt14");
                    userlogin.Rpt15 = rs.getString("Rpt15");
                    userlogin.Rpt16 = rs.getString("Rpt16");
                    userlogin.Rpt17 = rs.getString("Rpt17");
                    userlogin.Rpt18 = rs.getString("Rpt18");
                    userlogin.Rpt19 = rs.getString("Rpt19");
                    userlogin.Rpt20 = rs.getString("Rpt20");
                    userlogin.Rpt21 = rs.getString("Rpt21");
                    userlogin.Rpt22 = rs.getString("Rpt22");
                    userlogin.Rpt23 = rs.getString("Rpt23");
                    userlogin.Rpt24 = rs.getString("Rpt24");
                    userlogin.Rpt25 = rs.getString("Rpt25");
                    userlogin.Rpt26 = rs.getString("Rpt26");
                    userlogin.Rpt27 = rs.getString("Rpt27");
                    userlogin.Rpt28 = rs.getString("Rpt28");
                    userlogin.Rpt29 = rs.getString("Rpt29");
                    userlogin.Rpt30 = rs.getString("Rpt30");
                    userlogin.Rpt31 = rs.getString("Rpt31");
                    userlogin.Rpt32 = rs.getString("Rpt32");
                    userlogin.Rpt33 = rs.getString("Rpt33");
                    userlogin.Rpt34 = rs.getString("Rpt34");
                    userlogin.Rpt35 = rs.getString("Rpt35");
                    userlogin.Rpt36 = rs.getString("Rpt36");
                    userlogin.Rpt37 = rs.getString("Rpt37");
                    userlogin.Rpt38 = rs.getString("Rpt38");
                    userlogin.Rpt39 = rs.getString("Rpt39");
                    userlogin.Rpt40 = rs.getString("Rpt40");
                    userlogin.Rpt41 = rs.getString("Rpt41");
                    userlogin.Rpt42 = rs.getString("Rpt42");
                    userlogin.Rpt43 = rs.getString("Rpt43");
                    userlogin.Rpt44 = rs.getString("Rpt44");
                    userlogin.Rpt45 = rs.getString("Rpt45");
                    userlogin.Rpt46 = rs.getString("Rpt46");
                    userlogin.Rpt47 = rs.getString("Rpt47");
                    userlogin.Rpt48 = rs.getString("Rpt48");
                    userlogin.Rpt49 = rs.getString("Rpt49");
                    userlogin.Rpt50 = rs.getString("Rpt50");
                    userlogin.Cont1 = rs.getString("Cont1");
                    userlogin.Cont2 = rs.getString("Cont2");
                    userlogin.Cont3 = rs.getString("Cont3");
                    userlogin.Cont4 = rs.getString("Cont4");
                    userlogin.Cont5 = rs.getString("Cont5");
                    userlogin.Cont6 = rs.getString("Cont6");
                    userlogin.Cont7 = rs.getString("Cont7");
                    userlogin.Cont8 = rs.getString("Cont8");
                    userlogin.Cont9 = rs.getString("Cont9");
                    userlogin.Cont10 = rs.getString("Cont10");

                    userlogin.Mast26 = rs.getString("Mast26");
                    userlogin.Mast27 = rs.getString("Mast27");
                    userlogin.Mast28 = rs.getString("Mast28");
                    userlogin.Mast29 = rs.getString("Mast29");
                    userlogin.Mast30 = rs.getString("Mast30");
                    userlogin.Rpt51 = rs.getString("Rpt51");
//                    userlogin.Rpt52 = rs.getString("Rpt52");
                    chk = true;
                }

            } else {
                sql = "select * from borgrouplinux g inner join boruserlinux u on g.usergroup = u.usergroup  where username = '" + UserName + "'";
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    userlogin.UserName = rs.getString("username");
                    userlogin.Usergroup = rs.getString("u.Usergroup");
                    userlogin.Name = rs.getString("u.name");
                    userlogin.Mast1 = rs.getString("Mast1");
                    userlogin.Mast2 = rs.getString("Mast2");
                    userlogin.Mast3 = rs.getString("Mast3");
                    userlogin.Mast4 = rs.getString("Mast4");
                    userlogin.Mast5 = rs.getString("Mast5");
                    userlogin.Mast6 = rs.getString("Mast6");
                    userlogin.Mast7 = rs.getString("Mast7");
                    userlogin.Mast8 = rs.getString("Mast8");
                    userlogin.Mast9 = rs.getString("Mast9");
                    userlogin.Mast10 = rs.getString("Mast10");
                    userlogin.Mast11 = rs.getString("Mast11");
                    userlogin.Mast12 = rs.getString("Mast12");
                    userlogin.Mast13 = rs.getString("Mast13");
                    userlogin.Mast14 = rs.getString("Mast14");
                    userlogin.Mast15 = rs.getString("Mast15");
                    userlogin.Mast16 = rs.getString("Mast16");
                    userlogin.Mast17 = rs.getString("Mast17");
                    userlogin.Mast18 = rs.getString("Mast18");
                    userlogin.Mast19 = rs.getString("Mast19");
                    userlogin.Mast20 = rs.getString("Mast20");
                    userlogin.Mast21 = rs.getString("Mast21");
                    userlogin.Mast22 = rs.getString("Mast22");
                    userlogin.Mast23 = rs.getString("Mast23");
                    userlogin.Mast24 = rs.getString("Mast24");
                    userlogin.Mast25 = rs.getString("Mast25");

                    userlogin.M212 = rs.getString("M212");
                    userlogin.M213 = rs.getString("M213");
                    userlogin.M214 = rs.getString("M214");
                    userlogin.M215 = rs.getString("M215");
                    userlogin.M216 = rs.getString("M216");
                    userlogin.M217 = rs.getString("M217");

                    userlogin.Plu1 = rs.getString("Plu1");
                    userlogin.Plu2 = rs.getString("Plu2");
                    userlogin.Plu3 = rs.getString("Plu3");
                    userlogin.Plu4 = rs.getString("Plu4");
                    userlogin.Plu5 = rs.getString("Plu5");
                    userlogin.Plu6 = rs.getString("Plu6");
                    userlogin.Plu7 = rs.getString("Plu7");
                    userlogin.Plu8 = rs.getString("Plu8");
                    userlogin.Plu9 = rs.getString("Plu9");
                    userlogin.Plu10 = rs.getString("Plu10");
                    userlogin.Plu11 = rs.getString("Plu11");
                    userlogin.Plu12 = rs.getString("Plu12");
                    userlogin.Plu13 = rs.getString("Plu13");
                    userlogin.Plu14 = rs.getString("Plu14");
                    userlogin.Plu15 = rs.getString("Plu15");
                    userlogin.Plu16 = rs.getString("Plu16");
                    userlogin.Plu17 = rs.getString("Plu17");
                    userlogin.Plu18 = rs.getString("Plu18");
                    userlogin.Plu19 = rs.getString("Plu19");
                    userlogin.Plu20 = rs.getString("Plu20");
                    userlogin.Tran1 = rs.getString("Tran1");
                    userlogin.Tran2 = rs.getString("Tran2");
                    userlogin.Tran3 = rs.getString("Tran3");
                    userlogin.Tran4 = rs.getString("Tran4");
                    userlogin.Tran5 = rs.getString("Tran5");
                    userlogin.Tran6 = rs.getString("Tran6");
                    userlogin.Tran7 = rs.getString("Tran7");
                    userlogin.Tran8 = rs.getString("Tran8");
                    userlogin.Tran9 = rs.getString("Tran9");
                    userlogin.Tran10 = rs.getString("Tran10");
                    userlogin.Tran11 = rs.getString("Tran11");
                    userlogin.Rpt1 = rs.getString("Rpt1");
                    userlogin.Rpt2 = rs.getString("Rpt2");
                    userlogin.Rpt3 = rs.getString("Rpt3");
                    userlogin.Rpt4 = rs.getString("Rpt4");
                    userlogin.Rpt5 = rs.getString("Rpt5");
                    userlogin.Rpt6 = rs.getString("Rpt6");
                    userlogin.Rpt7 = rs.getString("Rpt7");
                    userlogin.Rpt8 = rs.getString("Rpt8");
                    userlogin.Rpt9 = rs.getString("Rpt9");
                    userlogin.Rpt10 = rs.getString("Rpt10");
                    userlogin.Rpt11 = rs.getString("Rpt11");
                    userlogin.Rpt12 = rs.getString("Rpt12");
                    userlogin.Rpt13 = rs.getString("Rpt13");
                    userlogin.Rpt14 = rs.getString("Rpt14");
                    userlogin.Rpt15 = rs.getString("Rpt15");
                    userlogin.Rpt16 = rs.getString("Rpt16");
                    userlogin.Rpt17 = rs.getString("Rpt17");
                    userlogin.Rpt18 = rs.getString("Rpt18");
                    userlogin.Rpt19 = rs.getString("Rpt19");
                    userlogin.Rpt20 = rs.getString("Rpt20");
                    userlogin.Rpt21 = rs.getString("Rpt21");
                    userlogin.Rpt22 = rs.getString("Rpt22");
                    userlogin.Rpt23 = rs.getString("Rpt23");
                    userlogin.Rpt24 = rs.getString("Rpt24");
                    userlogin.Rpt25 = rs.getString("Rpt25");
                    userlogin.Rpt26 = rs.getString("Rpt26");
                    userlogin.Rpt27 = rs.getString("Rpt27");
                    userlogin.Rpt28 = rs.getString("Rpt28");
                    userlogin.Rpt29 = rs.getString("Rpt29");
                    userlogin.Rpt30 = rs.getString("Rpt30");
                    userlogin.Rpt31 = rs.getString("Rpt31");
                    userlogin.Rpt32 = rs.getString("Rpt32");
                    userlogin.Rpt33 = rs.getString("Rpt33");
                    userlogin.Rpt34 = rs.getString("Rpt34");
                    userlogin.Rpt35 = rs.getString("Rpt35");
                    userlogin.Rpt36 = rs.getString("Rpt36");
                    userlogin.Rpt37 = rs.getString("Rpt37");
                    userlogin.Rpt38 = rs.getString("Rpt38");
                    userlogin.Rpt39 = rs.getString("Rpt39");
                    userlogin.Rpt40 = rs.getString("Rpt40");
                    userlogin.Rpt41 = rs.getString("Rpt41");
                    userlogin.Rpt42 = rs.getString("Rpt42");
                    userlogin.Rpt43 = rs.getString("Rpt43");
                    userlogin.Rpt44 = rs.getString("Rpt44");
                    userlogin.Rpt45 = rs.getString("Rpt45");
                    userlogin.Rpt46 = rs.getString("Rpt46");
                    userlogin.Rpt47 = rs.getString("Rpt47");
                    userlogin.Rpt48 = rs.getString("Rpt48");
                    userlogin.Rpt49 = rs.getString("Rpt49");
                    userlogin.Rpt50 = rs.getString("Rpt50");
                    userlogin.Cont1 = rs.getString("Cont1");
                    userlogin.Cont2 = rs.getString("Cont2");
                    userlogin.Cont3 = rs.getString("Cont3");
                    userlogin.Cont4 = rs.getString("Cont4");
                    userlogin.Cont5 = rs.getString("Cont5");
                    userlogin.Cont6 = rs.getString("Cont6");
                    userlogin.Cont7 = rs.getString("Cont7");
                    userlogin.Cont8 = rs.getString("Cont8");
                    userlogin.Cont9 = rs.getString("Cont9");
                    userlogin.Cont10 = rs.getString("Cont10");

                    userlogin.Mast26 = rs.getString("Mast26");
                    userlogin.Mast27 = rs.getString("Mast27");
                    userlogin.Mast28 = rs.getString("Mast28");
                    userlogin.Mast29 = rs.getString("Mast29");
                    userlogin.Mast30 = rs.getString("Mast30");
                    userlogin.Rpt51 = rs.getString("Rpt51");
//                    userlogin.Rpt52 = rs.getString("Rpt52");
                    chk = true;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return chk;

    }

    public UserLogin(String UserName, String Usergroup, String Name, String Mast1, String Mast2, String Mast3, String Mast4, String Mast5, String Mast6, String Mast7, String Mast8, String Mast9, String Mast10, String Mast11, String Mast12, String Mast13, String Mast14, String Mast15, String Mast16, String Mast17, String Mast18, String Mast19, String Mast20, String Mast21, String Mast22, String Mast23, String Mast24, String Mast25, String Plu1, String Plu2, String Plu3, String Plu4, String Plu5, String Plu6, String Plu7, String Plu8, String Plu9, String Plu10, String Plu11, String Plu12, String Plu13, String Plu14, String Plu15, String Plu16, String Plu17, String Plu18, String Plu19, String Plu20, String Tran1, String Tran2, String Tran3, String Tran4, String Tran5, String Tran6, String Tran7, String Tran8, String Tran9, String Tran10, String Tran11, String Rpt1, String Rpt2, String Rpt3, String Rpt4, String Rpt5, String Rpt6, String Rpt7, String Rpt8, String Rpt9, String Rpt10, String Rpt11, String Rpt12, String Rpt13, String Rpt14, String Rpt15, String Rpt16, String Rpt17, String Rpt18, String Rpt19, String Rpt20, String Rpt21, String Rpt22, String Rpt23, String Rpt24, String Rpt25, String Rpt26, String Rpt27, String Rpt28, String Rpt29, String Rpt30, String Rpt31, String Rpt32, String Rpt33, String Rpt34, String Rpt35, String Rpt36, String Rpt37, String Rpt38, String Rpt39, String Rpt40, String Rpt41, String Rpt42, String Rpt43, String Rpt44, String Rpt45, String Rpt46, String Rpt47, String Rpt48, String Rpt49, String Rpt50, String Cont1, String Cont2, String Cont3, String Cont4, String Cont5, String Cont6, String Cont7, String Cont8, String Cont9, String Cont10,
            String Mast26, String Mast27, String Mast28, String Mast29, String Mast30, String Rpt51, String Rpt52) {
        this.UserName = UserName;
        this.Usergroup = Usergroup;
        this.Name = Name;
        this.Mast1 = Mast1;
        this.Mast2 = Mast2;
        this.Mast3 = Mast3;
        this.Mast4 = Mast4;
        this.Mast5 = Mast5;
        this.Mast6 = Mast6;
        this.Mast7 = Mast7;
        this.Mast8 = Mast8;
        this.Mast9 = Mast9;
        this.Mast10 = Mast10;
        this.Mast11 = Mast11;
        this.Mast12 = Mast12;
        this.Mast13 = Mast13;
        this.Mast14 = Mast14;
        this.Mast15 = Mast15;
        this.Mast16 = Mast16;
        this.Mast17 = Mast17;
        this.Mast18 = Mast18;
        this.Mast19 = Mast19;
        this.Mast20 = Mast20;
        this.Mast21 = Mast21;
        this.Mast22 = Mast22;
        this.Mast23 = Mast23;
        this.Mast24 = Mast24;
        this.Mast25 = Mast25;

        this.M212 = M212;
        this.M213 = M213;
        this.M214 = M214;
        this.M215 = M215;
        this.M216 = M216;
        this.M217 = M217;

        this.Plu1 = Plu1;
        this.Plu2 = Plu2;
        this.Plu3 = Plu3;
        this.Plu4 = Plu4;
        this.Plu5 = Plu5;
        this.Plu6 = Plu6;
        this.Plu7 = Plu7;
        this.Plu8 = Plu8;
        this.Plu9 = Plu9;
        this.Plu10 = Plu10;
        this.Plu11 = Plu11;
        this.Plu12 = Plu12;
        this.Plu13 = Plu13;
        this.Plu14 = Plu14;
        this.Plu15 = Plu15;
        this.Plu16 = Plu16;
        this.Plu17 = Plu17;
        this.Plu18 = Plu18;
        this.Plu19 = Plu19;
        this.Plu20 = Plu20;
        this.Tran1 = Tran1;
        this.Tran2 = Tran2;
        this.Tran3 = Tran3;
        this.Tran4 = Tran4;
        this.Tran5 = Tran5;
        this.Tran6 = Tran6;
        this.Tran7 = Tran7;
        this.Tran8 = Tran8;
        this.Tran9 = Tran9;
        this.Tran10 = Tran10;
        this.Tran11 = Tran11;
        this.Rpt1 = Rpt1;
        this.Rpt2 = Rpt2;
        this.Rpt3 = Rpt3;
        this.Rpt4 = Rpt4;
        this.Rpt5 = Rpt5;
        this.Rpt6 = Rpt6;
        this.Rpt7 = Rpt7;
        this.Rpt8 = Rpt8;
        this.Rpt9 = Rpt9;
        this.Rpt10 = Rpt10;
        this.Rpt11 = Rpt11;
        this.Rpt12 = Rpt12;
        this.Rpt13 = Rpt13;
        this.Rpt14 = Rpt14;
        this.Rpt15 = Rpt15;
        this.Rpt16 = Rpt16;
        this.Rpt17 = Rpt17;
        this.Rpt18 = Rpt18;
        this.Rpt19 = Rpt19;
        this.Rpt20 = Rpt20;
        this.Rpt21 = Rpt21;
        this.Rpt22 = Rpt22;
        this.Rpt23 = Rpt23;
        this.Rpt24 = Rpt24;
        this.Rpt25 = Rpt25;
        this.Rpt26 = Rpt26;
        this.Rpt27 = Rpt27;
        this.Rpt28 = Rpt28;
        this.Rpt29 = Rpt29;
        this.Rpt30 = Rpt30;
        this.Rpt31 = Rpt31;
        this.Rpt32 = Rpt32;
        this.Rpt33 = Rpt33;
        this.Rpt34 = Rpt34;
        this.Rpt35 = Rpt35;
        this.Rpt36 = Rpt36;
        this.Rpt37 = Rpt37;
        this.Rpt38 = Rpt38;
        this.Rpt39 = Rpt39;
        this.Rpt40 = Rpt40;
        this.Rpt41 = Rpt41;
        this.Rpt42 = Rpt42;
        this.Rpt43 = Rpt43;
        this.Rpt44 = Rpt44;
        this.Rpt45 = Rpt45;
        this.Rpt46 = Rpt46;
        this.Rpt47 = Rpt47;
        this.Rpt48 = Rpt48;
        this.Rpt49 = Rpt49;
        this.Rpt50 = Rpt50;
        this.Cont1 = Cont1;
        this.Cont2 = Cont2;
        this.Cont3 = Cont3;
        this.Cont4 = Cont4;
        this.Cont5 = Cont5;
        this.Cont6 = Cont6;
        this.Cont7 = Cont7;
        this.Cont8 = Cont8;
        this.Cont9 = Cont9;
        this.Cont10 = Cont10;

        this.Mast26 = Mast26;
        this.Mast27 = Mast27;
        this.Mast28 = Mast28;
        this.Mast29 = Mast29;
        this.Mast30 = Mast30;
        this.Rpt51 = Rpt51;
        this.Rpt52 = Rpt52;
    }

    public String getMast26() {
        return Mast26;
    }

    public void setMast26(String Mast26) {
        this.Mast26 = Mast26;
    }

    public String getMast27() {
        return Mast27;
    }

    public void setMast27(String Mast27) {
        this.Mast27 = Mast27;
    }

    public String getMast28() {
        return Mast28;
    }

    public void setMast28(String Mast28) {
        this.Mast28 = Mast28;
    }

    public String getMast29() {
        return Mast29;
    }

    public void setMast29(String Mast29) {
        this.Mast29 = Mast29;
    }

    public String getMast30() {
        return Mast30;
    }

    public void setMast30(String Mast30) {
        this.Mast30 = Mast30;
    }

    public String getRpt51() {
        return Rpt51;
    }

    public void setRpt51(String Rpt51) {
        this.Rpt51 = Rpt51;
    }

    public String getRpt52() {
        return Rpt52;
    }

    public void setRpt52(String Rpt52) {
        this.Rpt52 = Rpt52;
    }
    
    

    public UserLogin() {

    }

    public String getCont1() {
        return Cont1;
    }

    public void setCont1(String Cont1) {
        this.Cont1 = Cont1;
    }

    public String getCont10() {
        return Cont10;
    }

    public void setCont10(String Cont10) {
        this.Cont10 = Cont10;
    }

    public String getCont2() {
        return Cont2;
    }

    public void setCont2(String Cont2) {
        this.Cont2 = Cont2;
    }

    public String getCont3() {
        return Cont3;
    }

    public void setCont3(String Cont3) {
        this.Cont3 = Cont3;
    }

    public String getCont4() {
        return Cont4;
    }

    public void setCont4(String Cont4) {
        this.Cont4 = Cont4;
    }

    public String getCont5() {
        return Cont5;
    }

    public void setCont5(String Cont5) {
        this.Cont5 = Cont5;
    }

    public String getCont6() {
        return Cont6;
    }

    public void setCont6(String Cont6) {
        this.Cont6 = Cont6;
    }

    public String getCont7() {
        return Cont7;
    }

    public void setCont7(String Cont7) {
        this.Cont7 = Cont7;
    }

    public String getCont8() {
        return Cont8;
    }

    public void setCont8(String Cont8) {
        this.Cont8 = Cont8;
    }

    public String getCont9() {
        return Cont9;
    }

    public void setCont9(String Cont9) {
        this.Cont9 = Cont9;
    }

    public String getMast1() {
        return Mast1;
    }

    public void setMast1(String Mast1) {
        this.Mast1 = Mast1;
    }

    public String getMast10() {
        return Mast10;
    }

    public void setMast10(String Mast10) {
        this.Mast10 = Mast10;
    }

    public String getMast11() {
        return Mast11;
    }

    public void setMast11(String Mast11) {
        this.Mast11 = Mast11;
    }

    public String getMast12() {
        return Mast12;
    }

    public void setMast12(String Mast12) {
        this.Mast12 = Mast12;
    }

    public String getMast13() {
        return Mast13;
    }

    public void setMast13(String Mast13) {
        this.Mast13 = Mast13;
    }

    public String getMast14() {
        return Mast14;
    }

    public void setMast14(String Mast14) {
        this.Mast14 = Mast14;
    }

    public String getMast15() {
        return Mast15;
    }

    public void setMast15(String Mast15) {
        this.Mast15 = Mast15;
    }

    public String getMast16() {
        return Mast16;
    }

    public void setMast16(String Mast16) {
        this.Mast16 = Mast16;
    }

    public String getMast17() {
        return Mast17;
    }

    public void setMast17(String Mast17) {
        this.Mast17 = Mast17;
    }

    public String getMast18() {
        return Mast18;
    }

    public void setMast18(String Mast18) {
        this.Mast18 = Mast18;
    }

    public String getMast19() {
        return Mast19;
    }

    public void setMast19(String Mast19) {
        this.Mast19 = Mast19;
    }

    public String getMast2() {
        return Mast2;
    }

    public void setMast2(String Mast2) {
        this.Mast2 = Mast2;
    }

    public String getMast20() {
        return Mast20;
    }

    public void setMast20(String Mast20) {
        this.Mast20 = Mast20;
    }

    public String getMast21() {
        return Mast21;
    }

    public void setMast21(String Mast21) {
        this.Mast21 = Mast21;
    }

    public String getMast22() {
        return Mast22;
    }

    public void setMast22(String Mast22) {
        this.Mast22 = Mast22;
    }

    public String getMast23() {
        return Mast23;
    }

    public void setMast23(String Mast23) {
        this.Mast23 = Mast23;
    }

    public String getMast24() {
        return Mast24;
    }

    public void setMast24(String Mast24) {
        this.Mast24 = Mast24;
    }

    public String getMast25() {
        return Mast25;
    }

    public void setMast25(String Mast25) {
        this.Mast25 = Mast25;
    }

    public String getMast3() {
        return Mast3;
    }

    public void setMast3(String Mast3) {
        this.Mast3 = Mast3;
    }

    public String getMast4() {
        return Mast4;
    }

    public void setMast4(String Mast4) {
        this.Mast4 = Mast4;
    }

    public String getMast5() {
        return Mast5;
    }

    public void setMast5(String Mast5) {
        this.Mast5 = Mast5;
    }

    public String getMast6() {
        return Mast6;
    }

    public void setMast6(String Mast6) {
        this.Mast6 = Mast6;
    }

    public String getMast7() {
        return Mast7;
    }

    public void setMast7(String Mast7) {
        this.Mast7 = Mast7;
    }

    public String getMast8() {
        return Mast8;
    }

    public void setMast8(String Mast8) {
        this.Mast8 = Mast8;
    }

    public String getMast9() {
        return Mast9;
    }

    public void setMast9(String Mast9) {
        this.Mast9 = Mast9;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPlu1() {
        return Plu1;
    }

    public void setPlu1(String Plu1) {
        this.Plu1 = Plu1;
    }

    public String getPlu10() {
        return Plu10;
    }

    public void setPlu10(String Plu10) {
        this.Plu10 = Plu10;
    }

    public String getPlu11() {
        return Plu11;
    }

    public void setPlu11(String Plu11) {
        this.Plu11 = Plu11;
    }

    public String getPlu12() {
        return Plu12;
    }

    public void setPlu12(String Plu12) {
        this.Plu12 = Plu12;
    }

    public String getPlu13() {
        return Plu13;
    }

    public void setPlu13(String Plu13) {
        this.Plu13 = Plu13;
    }

    public String getPlu14() {
        return Plu14;
    }

    public void setPlu14(String Plu14) {
        this.Plu14 = Plu14;
    }

    public String getPlu15() {
        return Plu15;
    }

    public void setPlu15(String Plu15) {
        this.Plu15 = Plu15;
    }

    public String getPlu16() {
        return Plu16;
    }

    public void setPlu16(String Plu16) {
        this.Plu16 = Plu16;
    }

    public String getPlu17() {
        return Plu17;
    }

    public void setPlu17(String Plu17) {
        this.Plu17 = Plu17;
    }

    public String getPlu18() {
        return Plu18;
    }

    public void setPlu18(String Plu18) {
        this.Plu18 = Plu18;
    }

    public String getPlu19() {
        return Plu19;
    }

    public void setPlu19(String Plu19) {
        this.Plu19 = Plu19;
    }

    public String getPlu2() {
        return Plu2;
    }

    public void setPlu2(String Plu2) {
        this.Plu2 = Plu2;
    }

    public String getPlu20() {
        return Plu20;
    }

    public void setPlu20(String Plu20) {
        this.Plu20 = Plu20;
    }

    public String getPlu3() {
        return Plu3;
    }

    public void setPlu3(String Plu3) {
        this.Plu3 = Plu3;
    }

    public String getPlu4() {
        return Plu4;
    }

    public void setPlu4(String Plu4) {
        this.Plu4 = Plu4;
    }

    public String getPlu5() {
        return Plu5;
    }

    public void setPlu5(String Plu5) {
        this.Plu5 = Plu5;
    }

    public String getPlu6() {
        return Plu6;
    }

    public void setPlu6(String Plu6) {
        this.Plu6 = Plu6;
    }

    public String getPlu7() {
        return Plu7;
    }

    public void setPlu7(String Plu7) {
        this.Plu7 = Plu7;
    }

    public String getPlu8() {
        return Plu8;
    }

    public void setPlu8(String Plu8) {
        this.Plu8 = Plu8;
    }

    public String getPlu9() {
        return Plu9;
    }

    public void setPlu9(String Plu9) {
        this.Plu9 = Plu9;
    }

    public String getRpt1() {
        return Rpt1;
    }

    public void setRpt1(String Rpt1) {
        this.Rpt1 = Rpt1;
    }

    public String getRpt10() {
        return Rpt10;
    }

    public void setRpt10(String Rpt10) {
        this.Rpt10 = Rpt10;
    }

    public String getRpt11() {
        return Rpt11;
    }

    public void setRpt11(String Rpt11) {
        this.Rpt11 = Rpt11;
    }

    public String getRpt12() {
        return Rpt12;
    }

    public void setRpt12(String Rpt12) {
        this.Rpt12 = Rpt12;
    }

    public String getRpt13() {
        return Rpt13;
    }

    public void setRpt13(String Rpt13) {
        this.Rpt13 = Rpt13;
    }

    public String getRpt14() {
        return Rpt14;
    }

    public void setRpt14(String Rpt14) {
        this.Rpt14 = Rpt14;
    }

    public String getRpt15() {
        return Rpt15;
    }

    public void setRpt15(String Rpt15) {
        this.Rpt15 = Rpt15;
    }

    public String getRpt16() {
        return Rpt16;
    }

    public void setRpt16(String Rpt16) {
        this.Rpt16 = Rpt16;
    }

    public String getRpt17() {
        return Rpt17;
    }

    public void setRpt17(String Rpt17) {
        this.Rpt17 = Rpt17;
    }

    public String getRpt18() {
        return Rpt18;
    }

    public void setRpt18(String Rpt18) {
        this.Rpt18 = Rpt18;
    }

    public String getRpt19() {
        return Rpt19;
    }

    public void setRpt19(String Rpt19) {
        this.Rpt19 = Rpt19;
    }

    public String getRpt2() {
        return Rpt2;
    }

    public void setRpt2(String Rpt2) {
        this.Rpt2 = Rpt2;
    }

    public String getRpt20() {
        return Rpt20;
    }

    public void setRpt20(String Rpt20) {
        this.Rpt20 = Rpt20;
    }

    public String getRpt21() {
        return Rpt21;
    }

    public void setRpt21(String Rpt21) {
        this.Rpt21 = Rpt21;
    }

    public String getRpt22() {
        return Rpt22;
    }

    public void setRpt22(String Rpt22) {
        this.Rpt22 = Rpt22;
    }

    public String getRpt23() {
        return Rpt23;
    }

    public void setRpt23(String Rpt23) {
        this.Rpt23 = Rpt23;
    }

    public String getRpt24() {
        return Rpt24;
    }

    public void setRpt24(String Rpt24) {
        this.Rpt24 = Rpt24;
    }

    public String getRpt25() {
        return Rpt25;
    }

    public void setRpt25(String Rpt25) {
        this.Rpt25 = Rpt25;
    }

    public String getRpt26() {
        return Rpt26;
    }

    public void setRpt26(String Rpt26) {
        this.Rpt26 = Rpt26;
    }

    public String getRpt27() {
        return Rpt27;
    }

    public void setRpt27(String Rpt27) {
        this.Rpt27 = Rpt27;
    }

    public String getRpt28() {
        return Rpt28;
    }

    public void setRpt28(String Rpt28) {
        this.Rpt28 = Rpt28;
    }

    public String getRpt29() {
        return Rpt29;
    }

    public void setRpt29(String Rpt29) {
        this.Rpt29 = Rpt29;
    }

    public String getRpt3() {
        return Rpt3;
    }

    public void setRpt3(String Rpt3) {
        this.Rpt3 = Rpt3;
    }

    public String getRpt30() {
        return Rpt30;
    }

    public void setRpt30(String Rpt30) {
        this.Rpt30 = Rpt30;
    }

    public String getRpt31() {
        return Rpt31;
    }

    public void setRpt31(String Rpt31) {
        this.Rpt31 = Rpt31;
    }

    public String getRpt32() {
        return Rpt32;
    }

    public void setRpt32(String Rpt32) {
        this.Rpt32 = Rpt32;
    }

    public String getRpt33() {
        return Rpt33;
    }

    public void setRpt33(String Rpt33) {
        this.Rpt33 = Rpt33;
    }

    public String getRpt34() {
        return Rpt34;
    }

    public void setRpt34(String Rpt34) {
        this.Rpt34 = Rpt34;
    }

    public String getRpt35() {
        return Rpt35;
    }

    public void setRpt35(String Rpt35) {
        this.Rpt35 = Rpt35;
    }

    public String getRpt36() {
        return Rpt36;
    }

    public void setRpt36(String Rpt36) {
        this.Rpt36 = Rpt36;
    }

    public String getRpt37() {
        return Rpt37;
    }

    public void setRpt37(String Rpt37) {
        this.Rpt37 = Rpt37;
    }

    public String getRpt38() {
        return Rpt38;
    }

    public void setRpt38(String Rpt38) {
        this.Rpt38 = Rpt38;
    }

    public String getRpt39() {
        return Rpt39;
    }

    public void setRpt39(String Rpt39) {
        this.Rpt39 = Rpt39;
    }

    public String getRpt4() {
        return Rpt4;
    }

    public void setRpt4(String Rpt4) {
        this.Rpt4 = Rpt4;
    }

    public String getRpt40() {
        return Rpt40;
    }

    public void setRpt40(String Rpt40) {
        this.Rpt40 = Rpt40;
    }

    public String getRpt41() {
        return Rpt41;
    }

    public void setRpt41(String Rpt41) {
        this.Rpt41 = Rpt41;
    }

    public String getRpt42() {
        return Rpt42;
    }

    public void setRpt42(String Rpt42) {
        this.Rpt42 = Rpt42;
    }

    public String getRpt43() {
        return Rpt43;
    }

    public void setRpt43(String Rpt43) {
        this.Rpt43 = Rpt43;
    }

    public String getRpt44() {
        return Rpt44;
    }

    public void setRpt44(String Rpt44) {
        this.Rpt44 = Rpt44;
    }

    public String getRpt45() {
        return Rpt45;
    }

    public void setRpt45(String Rpt45) {
        this.Rpt45 = Rpt45;
    }

    public String getRpt46() {
        return Rpt46;
    }

    public void setRpt46(String Rpt46) {
        this.Rpt46 = Rpt46;
    }

    public String getRpt47() {
        return Rpt47;
    }

    public void setRpt47(String Rpt47) {
        this.Rpt47 = Rpt47;
    }

    public String getRpt48() {
        return Rpt48;
    }

    public void setRpt48(String Rpt48) {
        this.Rpt48 = Rpt48;
    }

    public String getRpt49() {
        return Rpt49;
    }

    public void setRpt49(String Rpt49) {
        this.Rpt49 = Rpt49;
    }

    public String getRpt5() {
        return Rpt5;
    }

    public void setRpt5(String Rpt5) {
        this.Rpt5 = Rpt5;
    }

    public String getRpt50() {
        return Rpt50;
    }

    public void setRpt50(String Rpt50) {
        this.Rpt50 = Rpt50;
    }

    public String getRpt6() {
        return Rpt6;
    }

    public void setRpt6(String Rpt6) {
        this.Rpt6 = Rpt6;
    }

    public String getRpt7() {
        return Rpt7;
    }

    public void setRpt7(String Rpt7) {
        this.Rpt7 = Rpt7;
    }

    public String getRpt8() {
        return Rpt8;
    }

    public void setRpt8(String Rpt8) {
        this.Rpt8 = Rpt8;
    }

    public String getRpt9() {
        return Rpt9;
    }

    public void setRpt9(String Rpt9) {
        this.Rpt9 = Rpt9;
    }

    public String getTran1() {
        return Tran1;
    }

    public void setTran1(String Tran1) {
        this.Tran1 = Tran1;
    }

    public String getTran10() {
        return Tran10;
    }

    public void setTran10(String Tran10) {
        this.Tran10 = Tran10;
    }

    public String getTran11() {
        return Tran11;
    }

    public void setTran11(String Tran11) {
        this.Tran11 = Tran11;
    }

    public String getTran2() {
        return Tran2;
    }

    public void setTran2(String Tran2) {
        this.Tran2 = Tran2;
    }

    public String getTran3() {
        return Tran3;
    }

    public void setTran3(String Tran3) {
        this.Tran3 = Tran3;
    }

    public String getTran4() {
        return Tran4;
    }

    public void setTran4(String Tran4) {
        this.Tran4 = Tran4;
    }

    public String getTran5() {
        return Tran5;
    }

    public void setTran5(String Tran5) {
        this.Tran5 = Tran5;
    }

    public String getTran6() {
        return Tran6;
    }

    public void setTran6(String Tran6) {
        this.Tran6 = Tran6;
    }

    public String getTran7() {
        return Tran7;
    }

    public void setTran7(String Tran7) {
        this.Tran7 = Tran7;
    }

    public String getTran8() {
        return Tran8;
    }

    public void setTran8(String Tran8) {
        this.Tran8 = Tran8;
    }

    public String getTran9() {
        return Tran9;
    }

    public void setTran9(String Tran9) {
        this.Tran9 = Tran9;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUsergroup() {
        return Usergroup;
    }

    public void setUsergroup(String Usergroup) {
        this.Usergroup = Usergroup;
    }

    public String getM212() {
        return M212;
    }

    public void setM212(String M212) {
        this.M212 = M212;
    }

    public String getM213() {
        return M213;
    }

    public void setM213(String M213) {
        this.M213 = M213;
    }

    public String getM214() {
        return M214;
    }

    public void setM214(String M214) {
        this.M214 = M214;
    }

    public String getM215() {
        return M215;
    }

    public void setM215(String M215) {
        this.M215 = M215;
    }

    public String getM216() {
        return M216;
    }

    public void setM216(String M216) {
        this.M216 = M216;
    }

    public String getM217() {
        return M217;
    }

    public void setM217(String M217) {
        this.M217 = M217;
    }

}
