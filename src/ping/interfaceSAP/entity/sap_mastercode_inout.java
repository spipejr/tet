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
public class sap_mastercode_inout {

    private boolean have = false;
    private String sap_code = "";
    private String sap_name = "";
    private String sap_type = "";
    private String sap_createuser = "";
    private String sap_createdate = "";
    private String sap_createtime = "";
    private String sap_trantype = "" ;
    private String sap_active = "" ;

    public sap_mastercode_inout() {
    }

    public sap_mastercode_inout(String sap_code, String sap_name, String sap_type, String sap_createuser, String sap_createdate, String sap_createtime,String sap_trantype,String sap_active) {
        this.sap_code = sap_code;
        this.sap_name = sap_name;
        this.sap_type = sap_type;
        this.sap_createuser = sap_createuser;
        this.sap_createdate = sap_createdate;
        this.sap_createtime = sap_createtime;
        this.sap_trantype = sap_trantype ;
        this.sap_active = sap_active ;
    }

    public boolean isHave() {
        return have;
    }

    public void setHave(boolean have) {
        this.have = have;
    }

    public String getSap_code() {
        return sap_code;
    }

    public void setSap_code(String sap_code) {
        this.sap_code = sap_code;
    }

    public String getSap_name() {
        return sap_name;
    }
    public String getSap_trantype() {
        return sap_trantype;
    }
    public String getSap_active() {
        return sap_active;
    }

    public void setSap_name(String sap_name) {
        this.sap_name = sap_name;
    }
    public void setSap_trantype(String sap_trantype) {
        this.sap_trantype = sap_trantype;
    }
    public void setSap_active(String sap_avtive) {
        this.sap_active = sap_avtive;
    }

    public String getSap_type() {
        return sap_type;
    }

    public void setSap_type(String sap_type) {
        this.sap_type = sap_type;
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

  
    
    public sap_mastercode_inout seek(String sap_code) {
        sap_mastercode_inout smi = new sap_mastercode_inout();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * "
                + "FROM sap_mastercode_inout where sap_code=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, sap_code);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) { // have
                smi.setHave(true);
                smi.setSap_code(rs.getString("sap_code"));
                smi.setSap_name(rs.getString("sap_name"));
                smi.setSap_type(rs.getString("sap_type"));
                smi.setSap_createuser(rs.getString("sap_createuser"));
                smi.setSap_createdate(rs.getString("sap_createdate"));
                smi.setSap_createtime(rs.getString("sap_createtime"));
                smi.setSap_trantype(rs.getString("sap_trantype"));
                smi.setSap_active(rs.getString("sap_active"));
            } else { // haven't
                smi.setHave(false);
            }
        } catch (Exception e) {
            smi.setHave(false);
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "sap_mastercode_inout().seek(" + sap_code + ")");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return smi;
    }
    
    public ArrayList<sap_mastercode_inout> seekAll() {
        ArrayList<sap_mastercode_inout> list = new ArrayList<sap_mastercode_inout>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT sap_code FROM sap_mastercode_inout order by sap_code";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    list.add(seek(rs.getString("sap_code")));
                } while(rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "sap_mastercode_inout().seekAll()");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return list;
    }
}
