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
public class RESULTSAPXML_articlelost {
    
    private String filename;
    private String strdate;
    private String branch;
    private String plu;

    public RESULTSAPXML_articlelost() {
    }

    public RESULTSAPXML_articlelost(String filename, String strdate, String branch, String plu) {
        this.filename = filename;
        this.strdate = strdate;
        this.branch = branch;
        this.plu = plu;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPlu() {
        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public String getStrdate() {
        return strdate;
    }

    public void setStrdate(String strdate) {
        this.strdate = strdate;
    }
    
    public void execute(ArrayList<RESULTSAPXML_articlelost> list) {
        PreparedStatement ps = null;
        String sql = "insert into articlelost(strdate, branchcode, plu) values(?,?,?)";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            
            for (int i=0 ; i<list.size() ; i++) {
                ps.setString(1, list.get(i).getStrdate());
                ps.setString(2, list.get(i).getBranch());
                ps.setString(3, list.get(i).getPlu());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "resultsapxml_articlelost.execute");
        } finally {
            closePS(ps);
        }
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
}
