/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class dataBeanCompany {

    private String code;
    private String name;
    private String other1;
    private String other2;
    private String other3;
    private String other4;
    private String other5;
    private String other6;
    private String other7;
    private String other8;
    private String other9;
    private String other10;
    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public dataBeanCompany(String code, String name, String other1, String other2, String other3, String other4, String other5, String other6, String other7, String other8, String other9, String other10) {
        this.code = code;
        this.name = name;
        this.other1 = other1;
        this.other2 = other2;
        this.other3 = other3;
        this.other4 = other4;
        this.other5 = other5;
        this.other6 = other6;
        this.other7 = other7;
        this.other8 = other8;
        this.other9 = other9;
        this.other10 = other10;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther10() {
        return other10;
    }

    public void setOther10(String other10) {
        this.other10 = other10;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4;
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5;
    }

    public String getOther6() {
        return other6;
    }

    public void setOther6(String other6) {
        this.other6 = other6;
    }

    public String getOther7() {
        return other7;
    }

    public void setOther7(String other7) {
        this.other7 = other7;
    }

    public String getOther8() {
        return other8;
    }

    public void setOther8(String other8) {
        this.other8 = other8;
    }

    public String getOther9() {
        return other9;
    }

    public void setOther9(String other9) {
        this.other9 = other9;
    }

    public static Collection<dataBeanCompany> getCompany() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<dataBeanCompany> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from company order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new dataBeanCompany(cvth.ASCII2Unicode(rs.getString("code")),
                            cvth.ASCII2Unicode(rs.getString("name")),
                            cvth.ASCII2Unicode(rs.getString("address")),
                            cvth.ASCII2Unicode(rs.getString("subprovince")),
                            cvth.ASCII2Unicode(rs.getString("province")),
                            cvth.ASCII2Unicode(rs.getString("city")),
                            cvth.ASCII2Unicode(rs.getString("post")),
                            cvth.ASCII2Unicode(rs.getString("tel")),
                            cvth.ASCII2Unicode(rs.getString("fax")),
                            cvth.ASCII2Unicode(rs.getString("emailaddress")),
                            cvth.ASCII2Unicode(rs.getString("businessid")),
                            cvth.ASCII2Unicode(rs.getString("tax"))));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from company order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new dataBeanCompany(rs.getString("code"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("subprovince"),
                            rs.getString("province"),
                            rs.getString("city"),
                            rs.getString("post"),
                            rs.getString("tel"),
                            rs.getString("fax"),
                            rs.getString("emailaddress"),
                            rs.getString("businessid"),
                            rs.getString("tax")));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

}
