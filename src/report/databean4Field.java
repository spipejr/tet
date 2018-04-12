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
import javax.swing.JTable;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class databean4Field {

    private String code;
    private String name;
    private String other1;
    private String other2;

    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public databean4Field(){
         db = new dbUtility();
        db.dbconnect();
    }
            
    public databean4Field(String code, String name, String other1, String other2) {
        this.code = code;
        this.name = name;
        this.other1 = other1;
        this.other2 = other2;
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

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public static Collection<databean4Field> getCrAccNo() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databean4Field> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from craccno order by bank_code,bank_sub";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databean4Field(cvth.ASCII2Unicode(rs.getString("bank_code")),
                            cvth.ASCII2Unicode(rs.getString("bank_sub")),
                            cvth.ASCII2Unicode(rs.getString("bank_name")),
                            cvth.ASCII2Unicode(rs.getString("bank_acc"))));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from craccno order by bank_code,bank_sub";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databean4Field(rs.getString("bank_code"),
                            rs.getString("bank_sub"),
                            rs.getString("bank_name"),
                            rs.getString("bank_acc")));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databean4Field> getUserGroup(JTable tbl) {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databean4Field> col = new ArrayList();
        try {

            for (int i = 0; i < tbl.getRowCount(); i++) {
                boolean onact = Boolean.parseBoolean(tbl.getValueAt(i, 3).toString());
                String act = "";
                if (onact) {
                    act = "Y";
                } else {
                    act = "N";
                }
                col.add(new databean4Field(tbl.getValueAt(i, 0).toString(), tbl.getValueAt(i, 1).toString(), tbl.getValueAt(i, 2).toString(), act));
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databean4Field> getBorUserGroup(JTable tbl) {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databean4Field> col = new ArrayList();
        try {

            for (int i = 0; i < tbl.getRowCount(); i++) {
                col.add(new databean4Field(tbl.getValueAt(i, 0).toString(), tbl.getValueAt(i, 1).toString(), tbl.getValueAt(i, 2).toString(), tbl.getValueAt(i, 3).toString()));
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databean4Field> getCampaign() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databean4Field> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from campaignfile order by campaign_code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databean4Field(cvth.ASCII2Unicode(rs.getString("campaign_code")),
                            cvth.ASCII2Unicode(rs.getString("campaign_name")),
                            Format.dateFmtShow.format(rs.getDate("campaign_start")),
                            Format.dateFmtShow.format(rs.getDate("campaign_stop"))));

                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from campaignfile order by campaign_code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databean4Field(rs.getString("campaign_code"),
                            rs.getString("campaign_name"),
                            Format.dateFmtShow.format(rs.getDate("campaign_start")),
                            Format.dateFmtShow.format(rs.getDate("campaign_stop"))));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

}
