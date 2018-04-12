/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author soneping
 */
public class borpathsetup {

    private String path_sap_article;
    private String path_sap_site;
    private String use_sap_article;
    private String path_resultsap;
    private String path_resultsap_backup;

    public borpathsetup() {
    }

    public String getPath_sap_article() {
        return path_sap_article;
    }

    public void setPath_sap_article(String path_sap_article) {
        this.path_sap_article = path_sap_article;
    }

    public String getPath_sap_site() {
        return path_sap_site;
    }

    public void setPath_sap_site(String path_sap_site) {
        this.path_sap_site = path_sap_site;
    }

    public String getUse_sap_article() {
        return use_sap_article;
    }

    public void setUse_sap_article(String use_sap_article) {
        this.use_sap_article = use_sap_article;
    }

    public String getPath_resultsap() {
        return path_resultsap;
    }

    public void setPath_resultsap(String path_resultsap) {
        this.path_resultsap = path_resultsap;
    }

    public String getPath_resultsap_backup() {
        return path_resultsap_backup;
    }

    public void setPath_resultsap_backup(String path_resultsap_backup) {
        this.path_resultsap_backup = path_resultsap_backup;
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
    
    public void seekBORPathSetup() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select path_sap_article, path_sap_site, use_sap_article, path_resultsap, path_resultsap_backup from borpathsetup";
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                this.path_sap_article = rs.getString("path_sap_article");
                this.path_sap_site = rs.getString("path_sap_site");
                this.use_sap_article = rs.getString("use_sap_article");
                this.path_resultsap = rs.getString("path_resultsap");
                this.path_resultsap_backup = rs.getString("path_resultsap_backup");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closePS(ps);
            closeRS(rs);
        }
    }
}
