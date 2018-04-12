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
public class databean_sap_branchfile {

    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();
    showMessage msn = new showMessage();

    private String bgcode = "";
    private String bgname = "";
    private String bcode = "";
    private String bname = "";
    private String sap_site_code = "";
    private String sap_site_name = "";
    private String sap_site_cashbank = "";

    public databean_sap_branchfile() {

    }
//ping.interfaceSAP.report.databean_sap_branchfile
    public databean_sap_branchfile(String bgcode, String bgname, String bcode, String bname, String sap_site_code, String sap_site_name, String sap_site_cashbank) {

        this.bgcode = bgcode;
        this.bgname = bgname;
        this.bcode = bcode;
        this.bname = bname;
        this.sap_site_code = sap_site_code;
        this.sap_site_name = sap_site_name;
        this.sap_site_cashbank = sap_site_cashbank;
    }

    public String getBgcode() {
        return bgcode;
    }

    public void setBgcode(String bgcode) {
        this.bgcode = bgcode;
    }

    public String getBgname() {
        return bgname;
    }

    public void setBgname(String bgname) {
        this.bgname = bgname;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getSap_site_code() {
        return sap_site_code;
    }

    public void setSap_site_code(String sap_site_code) {
        this.sap_site_code = sap_site_code;
    }

    public String getSap_site_name() {
        return sap_site_name;
    }

    public void setSap_site_name(String sap_site_name) {
        this.sap_site_name = sap_site_name;
    }

    public String getSap_site_cashbank() {
        return sap_site_cashbank;
    }

    public void setSap_site_cashbank(String sap_site_cashbank) {
        this.sap_site_cashbank = sap_site_cashbank;
    }

    public static Collection getCollection(String seek) {
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pre = null;
        Collection<databean_sap_branchfile> col = new ArrayList();
        String sql = seek;
        try {
            pre = dbUtility.con.prepareStatement(sql);
            rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    if (db.Char_Set.equalsIgnoreCase("utf-8")) {
                        col.add(new databean_sap_branchfile(
                                rs.getString("btype"),
                                rs.getString("btname"),
                                rs.getString("bcode"),
                                rs.getString("bname"),
                                rs.getString("sap_site_code"),
                                rs.getString("sap_site_name"),
                                rs.getString("sap_site_cashbank")
                        ));
                    } else {
                        col.add(new databean_sap_branchfile(
                                cvth.ASCII2Unicode(rs.getString("btype")),
                                cvth.ASCII2Unicode(rs.getString("btname")),
                                cvth.ASCII2Unicode(rs.getString("bcode")),
                                cvth.ASCII2Unicode(rs.getString("bname")),
                                cvth.ASCII2Unicode(rs.getString("sap_site_code")),
                                cvth.ASCII2Unicode(rs.getString("sap_site_name")),
                                cvth.ASCII2Unicode(rs.getString("sap_site_cashbank"))
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
