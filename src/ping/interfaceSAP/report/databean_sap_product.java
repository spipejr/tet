/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.report;

import EStamp.showMessage;
import dbutility.dbUtility;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author pos
 */
public class databean_sap_product {

    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();
    showMessage msn = new showMessage();

    private String pgroupcode = "";
    private String pgroupname = "";
    private String pcode = "";
    private String pname = "";
    private String pactive = "";
    private String sap_article = "";
    private String sap_article_name = "";
    private String bgroup = "";

    public databean_sap_product() {

    }
//ping.interfaceSAP.report.databean_sap_product

    public databean_sap_product(String pgroupcode, String pgroupname, String pcode, String pname, String pactive, String sap_article, String sap_article_name, String bgroup) {

        this.pgroupcode = pgroupcode;
        this.pgroupname = pgroupname;
        this.pcode = pcode;
        this.pname = pname;
        this.pactive = pactive;
        this.sap_article = sap_article;
        this.sap_article_name = sap_article_name;
        this.bgroup = bgroup;
    }

    public String getPgroupcode() {
        return pgroupcode;
    }

    public void setPgroupcode(String pgroupcode) {
        this.pgroupcode = pgroupcode;
    }

    public String getPgroupname() {
        return pgroupname;
    }

    public void setPgroupname(String pgroupname) {
        this.pgroupname = pgroupname;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPactive() {
        return pactive;
    }

    public void setPactive(String pactive) {
        this.pactive = pactive;
    }

    public String getSap_article() {
        return sap_article;
    }

    public void setSap_article(String sap_article) {
        this.sap_article = sap_article;
    }

    public String getSap_article_name() {
        return sap_article_name;
    }

    public void setSap_article_name(String sap_article_name) {
        this.sap_article_name = sap_article_name;
    }

    public String getBgroup() {
        return bgroup;
    }

    public void setBgroup(String bgroup) {
        this.bgroup = bgroup;
    }

    public static Collection getCollection(String seek) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<databean_sap_product> col = new ArrayList();
        String sql = seek;
        try {
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (db.Char_Set.equalsIgnoreCase("utf-8")) {
                        col.add(new databean_sap_product(
                                rs.getString("pgroup"),
                                rs.getString("groupname"),
                                rs.getString("pcode"),
                                rs.getString("pdesc"),
                                rs.getString("pactive"),
                                rs.getString("sap_article"),
                                rs.getString("sap_article_name"),
                                rs.getString("bgroup")
                        ));
                    } else {
                        col.add(new databean_sap_product(
                                cvth.ASCII2Unicode(rs.getString("pgroup")),
                                cvth.ASCII2Unicode(rs.getString("groupname")),
                                cvth.ASCII2Unicode(rs.getString("pcode")),
                                cvth.ASCII2Unicode(rs.getString("pdesc")),
                                cvth.ASCII2Unicode(rs.getString("pactive")),
                                cvth.ASCII2Unicode(rs.getString("sap_article")),
                                cvth.ASCII2Unicode(rs.getString("sap_article_name")),
                                cvth.ASCII2Unicode(rs.getString("bgroup"))
                        ));
                    }
                } while (rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return col;
    }
}
