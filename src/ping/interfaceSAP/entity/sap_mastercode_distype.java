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
public class sap_mastercode_distype {

    private boolean have = false;
    private String dis_sap_code = "";
    private String dis_sap_name = "";
    private String dis_sale_type = "";
    private String dis_sale_description = "";
    private String sap_createuser = "";
    private String sap_createdate = "";
    private String sap_createtime = "";

    public sap_mastercode_distype() {
    }

    public sap_mastercode_distype(String dis_sap_code, String dis_sap_name, String dis_sale_type, String dis_sale_description, String sap_createuser, String sap_createdate, String sap_createtime) {
        this.dis_sap_code = dis_sap_code;
        this.dis_sap_name = dis_sap_name;
        this.dis_sale_type = dis_sale_type;
        this.dis_sale_description = dis_sale_description;
        this.sap_createdate = sap_createdate;
        this.sap_createtime = sap_createtime;
        this.sap_createuser = sap_createuser;
    }

    public boolean isHave() {
        return have;
    }

    public void setHave(boolean have) {
        this.have = have;
    }

    public String getDis_sap_code() {
        return dis_sap_code;
    }

    public void setDis_sap_code(String dis_sap_code) {
        this.dis_sap_code = dis_sap_code;
    }

    public String getDis_sap_name() {
        return dis_sap_name;
    }

    public void setDis_sap_name(String dis_sap_name) {
        this.dis_sap_name = dis_sap_name;
    }

    public String getDis_sale_type() {
        return dis_sale_type;
    }

    public void setDis_sale_type(String dis_sale_type) {
        this.dis_sale_type = dis_sale_type;
    }

    public String getDis_sale_description() {
        return dis_sale_description;
    }

    public void setDis_sale_description(String dis_sale_description) {
        this.dis_sale_description = dis_sale_description;
    }

    public String getSap_createuser() {
        return sap_createuser;
    }

    public void setSap_createuser(String sap_createuser) {
        this.sap_createuser = sap_createuser;
    }

    public String getSap_createdate() {
        return sap_createdate;
    }

    public void setSap_createdate(String sap_createdate) {
        this.sap_createdate = sap_createdate;
    }

    public String getSap_createtime() {
        return sap_createtime;
    }

    public void setSap_createtime(String sap_createtime) {
        this.sap_createtime = sap_createtime;
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

    public boolean execute() {
        boolean isOK = true;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT dis_sap_code, dis_sap_name, dis_sale_type, createuser, createdate, createtime "
                + "FROM sap_mastercode_distype where dis_sale_type=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.dis_sale_type);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {//update
                sql = "update sap_mastercode_distype set "
                        + "dis_sap_name=?, dis_sale_type=?, dis_sale_description=?, createuser=?, createdate=?, createtime=? "
                        + "where dis_sale_type=?";
            } else {//insert
                sql = "insert into sap_mastercode_distype(dis_sap_name, dis_sale_type, dis_sale_description, createuser, createdate, createtime, dis_sap_code) values(?,?,?,?,?,?,?)";
            }
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.dis_sap_name);
            ps.setString(2, this.dis_sale_type);
            ps.setString(3, this.dis_sale_description);
            ps.setString(4, this.sap_createuser);
            ps.setString(5, this.sap_createdate);
            ps.setString(6, this.sap_createtime);
            ps.setString(7, this.dis_sap_code);
            ps.executeUpdate();
        } catch (Exception e) {
            isOK = false;
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "sap_mastercode_distype().execute()");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return isOK;
    }
    
    public boolean delete() {
        boolean isOK = true;
        PreparedStatement ps = null;
        String sql = "delete FROM sap_mastercode_distype where dis_sap_code=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.dis_sap_code);
            ps.executeUpdate();
        } catch (Exception e) {
            isOK = false;
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "sap_mastercode_distype().delete()");
        } finally {
            closePS(ps);
        }
        return isOK;
    }
    
    public sap_mastercode_distype seek(String dis_sap_code) {
        sap_mastercode_distype smd = new sap_mastercode_distype();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT dis_sap_code, dis_sap_name, dis_sale_type, dis_sale_description, createuser, createdate, createtime "
                + "FROM sap_mastercode_distype where dis_sap_code=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, dis_sap_code);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {// have
                smd.setHave(true);
                smd.setDis_sap_code(rs.getString("dis_sap_code"));
                smd.setDis_sap_name(rs.getString("dis_sap_name"));
                smd.setDis_sale_type(rs.getString("dis_sale_type"));
                smd.setDis_sale_description(rs.getString("dis_sale_description"));
                smd.setSap_createdate(rs.getString("createdate"));
                smd.setSap_createtime(rs.getString("createtime"));
                smd.setSap_createuser(rs.getString("createuser"));
            } else { // haven't
                smd.setHave(false);
            }
        } catch (Exception e) {
            smd.setHave(false);
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "sap_mastercode_distype().seek(" + dis_sap_code + ")");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return smd;
    }
    
    public ArrayList<sap_mastercode_distype> seekAll() {
        ArrayList<sap_mastercode_distype> list = new ArrayList<sap_mastercode_distype>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT dis_sap_code FROM sap_mastercode_distype order by dis_sap_code";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    list.add(seek(rs.getString("dis_sap_code")));
                } while(rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "sap_mastercode_distype().seekAll()");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return list;
    }
}
