/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ping.interfaceSAP.showMessage;

/**
 *
 * @author soneping
 */
public class sap_mastercode_cashbank {

    private boolean have = false;
    private String cash_code;
    private String cash_name;
    private String createuser;
    private String createdate;
    private String createtime;

    public sap_mastercode_cashbank() {
        this.have = false;
        this.cash_code = "";
        this.cash_name = "";
        this.createuser = "";
        this.createdate = "";
        this.createtime = "";
    }

    public sap_mastercode_cashbank(String cash_code, String cash_name, String createuser, String createdate, String createtime) {
        this.cash_code = cash_code;
        this.cash_name = cash_name;
        this.createuser = createuser;
        this.createdate = createdate;
        this.createtime = createtime;
    }

    private void closePS(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
                ps = null;
            }
        } catch (Exception e) {
        }
    }

    private void closeRS(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception e) {
        }
    }

    public String getCash_code() {
        return cash_code;
    }

    public void setCash_code(String cash_code) {
        this.cash_code = cash_code;
    }

    public String getCash_name() {
        return cash_name;
    }

    public void setCash_name(String cash_name) {
        this.cash_name = cash_name;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setHave(boolean have) {
        this.have = have;
    }

    public boolean isHave() {
        return have;
    }

    public boolean execute() {
        boolean isOK = true;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT cash_code, cash_name, createuser, createdate, createtime "
                + "FROM sap_mastercode_cashbank where cash_code=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.cash_code);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {//update
                sql = "update sap_mastercode_cashbank set "
                        + "cash_name=?, createuser=?, createdate=?, createtime=? "
                        + "where cash_code=?";
            } else {//insert
                sql = "insert into sap_mastercode_cashbank(cash_name, createuser, createdate, createtime, cash_code) values(?,?,?,?,?)";
            }
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.cash_name);
            ps.setString(2, this.createuser);
            ps.setString(3, this.createdate);
            ps.setString(4, this.createtime);
            ps.setString(5, this.cash_code);
            ps.executeUpdate();
        } catch (Exception e) {
            isOK = false;
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "sap_mastercode_cashbank().execute()");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return isOK;
    }
    
    public boolean delete() {
        boolean isOK = true;
        PreparedStatement ps = null;
        String sql = "delete FROM sap_mastercode_cashbank where cash_code=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.cash_code);
            ps.executeUpdate();
        } catch (Exception e) {
            isOK = false;
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "sap_mastercode_cashbank().delete()");
        } finally {
            closePS(ps);
        }
        return isOK;
    }
    
    public sap_mastercode_cashbank seek(String cash_code) {
        sap_mastercode_cashbank smd = new sap_mastercode_cashbank();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT cash_code, cash_name, createuser, createdate, createtime "
                + "FROM sap_mastercode_cashbank where cash_code=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, cash_code);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {// have
                smd.setHave(true);
                smd.setCash_code(rs.getString("cash_code"));
                smd.setCash_name(rs.getString("cash_name"));
                smd.setCreatedate(rs.getString("createdate"));
                smd.setCreatetime(rs.getString("createtime"));
                smd.setCreateuser(rs.getString("createuser"));
            } else { // haven't
                smd.setHave(false);
            }
        } catch (Exception e) {
            smd.setHave(false);
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "sap_mastercode_cashbank().seek(" + cash_code + ")");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return smd;
    }
    
    public ArrayList<sap_mastercode_cashbank> seekAll() {
        ArrayList<sap_mastercode_cashbank> list = new ArrayList<sap_mastercode_cashbank>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT cash_code FROM sap_mastercode_cashbank order by cash_code";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    list.add(seek(rs.getString("cash_code")));
                } while(rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "sap_mastercode_cashbank().seekAll()");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return list;
    }
}
