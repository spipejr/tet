/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report;
//report.databeanMasterfile
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
public class databeanMasterfile {

    private String code;
    private String name;
    private String other;
    private String deptcode;
    private String deptname;
    private static dbUtility db = new dbUtility();
    public static ThaiUtilities cvth = new ThaiUtilities();

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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public databeanMasterfile(String code, String name, String other) {
        this.code = code;
        this.name = name;
        this.other = other;
    }

    public static Collection<databeanMasterfile> getBankFile() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from bankfile order by bcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("BCode")),
                            cvth.ASCII2Unicode(rs.getString("BName")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from bankfile order by bcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("BCode"),
                            rs.getString("BName"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getPlane() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from plane order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("Code")),
                            cvth.ASCII2Unicode(rs.getString("Name")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from plane order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("Code"),
                            rs.getString("Name"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getArea() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from area order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("Code")),
                            cvth.ASCII2Unicode(rs.getString("Name")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from area order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("Code"),
                            rs.getString("Name"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getBranchGroup() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from branchgroup order by bgroupcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("bgroupcode")),
                            cvth.ASCII2Unicode(rs.getString("bgroupname")),
                            cvth.ASCII2Unicode(rs.getString("formula"))));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from branchgroup order by bgroupcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("bgroupcode"),
                            rs.getString("bgroupname"),rs.getString("formula")));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getBranchtype() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from btype order by btcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("btcode")),
                            cvth.ASCII2Unicode(rs.getString("btname")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from btype order by btcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("btcode"),
                            rs.getString("btname"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getBrand() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from brandfile order by brandcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("brandcode")),
                            cvth.ASCII2Unicode(rs.getString("brandname")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from brand order by brandcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("brandcode"),
                            rs.getString("brandname"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getSize() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from size order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("code")),
                            cvth.ASCII2Unicode(rs.getString("name")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from size order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("code"),
                            rs.getString("name"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getBussType() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from businesstype order by buscode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("buscode")),
                            cvth.ASCII2Unicode(rs.getString("busname")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from businesstype order by buscode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("buscode"),
                            rs.getString("busname"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getCrarea() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from crarea order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("code")),
                            cvth.ASCII2Unicode(rs.getString("name")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from crarea order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("code"),
                            rs.getString("name"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getStore() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from store order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("code")),
                            cvth.ASCII2Unicode(rs.getString("name")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from store order by code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("code"),
                            rs.getString("name"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getGroupfile() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from groupfile order by groupcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("groupcode")),
                            cvth.ASCII2Unicode(rs.getString("groupname")),
                            cvth.ASCII2Unicode(rs.getString("bomacc"))));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from groupfile order by groupcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("groupcode"),
                            rs.getString("groupname"),
                            rs.getString("bomacc")));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getDeptfile() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from deptfile order by deptcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("deptcode")),
                            cvth.ASCII2Unicode(rs.getString("deptname")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from deptfile order by deptcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("deptcode"),
                            rs.getString("deptname"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getInggroup() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from inggroup order by inggroupcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("inggroupcode")),
                            cvth.ASCII2Unicode(rs.getString("inggroupname")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from inggroup order by inggroupcode";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("inggroupcode"),
                            rs.getString("inggroupname"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }

    public static Collection<databeanMasterfile> getFastivalfile() {

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile> col = new ArrayList();
        try {
            if (!db.Char_Set.equalsIgnoreCase("utf-8")) {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from fastivalfile order by fast_code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(cvth.ASCII2Unicode(rs.getString("fast_code")),
                            cvth.ASCII2Unicode(rs.getString("fast_name")),""));
                    count++;
                }
            } else {
                stmt = (Statement) dbUtility.con.createStatement();
                String sql = "select * from fastivalfile order by fast_code";
                rs = stmt.executeQuery(sql);
                int count = 0;
                while (rs.next()) {
                    col.add(new databeanMasterfile(rs.getString("fast_code"),
                            rs.getString("fast_name"),""));
                    count++;
                }
            }
        } catch (Exception e) {
        }

        return col;
    }
}
