/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.entity;

import dbutility.dbUtility;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ping.interfaceSAP.showMessage;
import ping.interfaceSAP.utilitySAP;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author soneping
 */
public class site {

    private ArrayList<site> list = new ArrayList<site>();
    ThaiUtilities tu = new ThaiUtilities();
    ThaiUtilities cvth = new ThaiUtilities();
    private boolean haveSite = false;
    private String bcode = "";
    private String bname = "";
    private String sap_code = "";
    private String sap_name = "";
    private String sap_type = "";
    private String sap_costcenter = "";
    private String sap_address = "";
    private String sap_locality = "";
    private String sap_site_cashbank = "";

    public site() {
    }

    public site(String bcode, String sap_code, String sap_name, String sap_type, String sap_costcenter, String sap_address, String sap_locality, String sap_site_cashbank) {
        this.bcode = bcode;
        this.sap_code = sap_code;
        this.sap_name = sap_name;
        this.sap_type = sap_type;
        this.sap_costcenter = sap_costcenter;
        this.sap_address = sap_address;
        this.sap_locality = sap_locality;
        this.sap_site_cashbank = sap_site_cashbank;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public boolean haveSite() {
        return haveSite;
    }

    public void setHaveSite(boolean haveSite) {
        this.haveSite = haveSite;
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

    public void setSap_name(String sap_name) {
        this.sap_name = sap_name;
    }

    public String getSap_type() {
        return sap_type;
    }

    public void setSap_type(String sap_type) {
        this.sap_type = sap_type;
    }

    public String getSap_costcenter() {
        return sap_costcenter;
    }

    public void setSap_costcenter(String sap_costcenter) {
        this.sap_costcenter = sap_costcenter;
    }

    public String getSap_address() {
        return sap_address;
    }

    public void setSap_address(String sap_address) {
        this.sap_address = sap_address;
    }

    public String getSap_locality() {
        return sap_locality;
    }

    public void setSap_locality(String sap_locality) {
        this.sap_locality = sap_locality;
    }

    public String getSap_site_cashbank() {
        return sap_site_cashbank;
    }

    public void setSap_site_cashbank(String sap_site_cashbank) {
        this.sap_site_cashbank = sap_site_cashbank;
    }

    public ArrayList<site> getListSiteNoMap() {
        return list;
    }

    public void setList(ArrayList<site> list) {
        this.list = list;
    }

    public boolean execute() {
        boolean isOK = true;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT code, sap_site_code, sap_site_name, sap_site_type, sap_site_costcenter, sap_site_address, sap_site_locality "
                + "FROM branfile where code=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.bcode);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {//update
                sql = "update branfile set sap_site_code=?, sap_site_name=?, sap_site_type=?, sap_site_costcenter=?, sap_site_address=?, sap_site_locality=?, sap_site_cashbank=? where code=?";
            }
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                ps = dbutility.dbUtility.con.prepareStatement(sql);
                ps.setString(1, cvth.Unicode2ASCII(this.sap_code));
                ps.setString(2, cvth.Unicode2ASCII((this.sap_name.length() > 50 ? this.sap_name.substring(0, 50) : this.sap_name)));
                ps.setString(3, cvth.Unicode2ASCII(this.sap_type));
                ps.setString(4, cvth.Unicode2ASCII(this.sap_costcenter));
                ps.setString(5, cvth.Unicode2ASCII((this.sap_address.length() > 255 ? this.sap_address.substring(0, 255) : this.sap_address)));
                ps.setString(6, cvth.Unicode2ASCII((this.sap_locality.length() > 50 ? this.sap_locality.substring(0, 50) : this.sap_locality)));
                ps.setString(7, cvth.Unicode2ASCII(this.sap_site_cashbank));
                ps.setString(8, cvth.Unicode2ASCII(this.bcode));
                ps.executeUpdate();
            } else {
                ps = dbutility.dbUtility.con.prepareStatement(sql);
                ps.setString(1, this.sap_code);
                ps.setString(2, (this.sap_name.length() > 50 ? this.sap_name.substring(0, 50) : this.sap_name));
                ps.setString(3, this.sap_type);
                ps.setString(4, this.sap_costcenter);
                ps.setString(5, (this.sap_address.length() > 255 ? this.sap_address.substring(0, 255) : this.sap_address));
                ps.setString(6, (this.sap_locality.length() > 50 ? this.sap_locality.substring(0, 50) : this.sap_locality));
                ps.setString(7, this.sap_site_cashbank);
                ps.setString(8, this.bcode);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            isOK = false;
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "execute()");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return isOK;
    }

    public ArrayList<site> seek(String txt, String table) {
        ArrayList<site> list = new ArrayList<site>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT sap_site_code, sap_site_name, sap_site_type, sap_site_costcenter, sap_site_address, sap_site_locality "
                + "FROM branfile_sap "
                + "where " + table + " like ? "
                + "order by sap_site_type, " + table;

        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                site _site;
                do {
                    _site = new site(
                            "",
                            rs.getString("sap_site_code"),
                            rs.getString("sap_site_name"),
                            rs.getString("sap_site_type"),
                            rs.getString("sap_site_costcenter"),
                            rs.getString("sap_site_address"),
                            rs.getString("sap_site_locality"),
                            "");
                    list.add(_site);
                } while (rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "seek()");
        } finally {
            closePS(ps);
            closeRS(rs);
        }

        return list;
    }

    public ArrayList<site> seek() {
        ArrayList<site> list = new ArrayList<site>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT sap_site_code, sap_site_name, sap_site_type, sap_site_costcenter, sap_site_address, sap_site_locality "
                + "FROM branfile_sap order by sap_site_type, sap_site_code";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                site _site;
                do {
                    _site = new site(
                            "",
                            rs.getString("sap_site_code"),
                            rs.getString("sap_site_name"),
                            rs.getString("sap_site_type"),
                            rs.getString("sap_site_costcenter"),
                            rs.getString("sap_site_address"),
                            rs.getString("sap_site_locality"),
                            "");
                    list.add(_site);
                } while (rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "seek()");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return list;
    }

    public site seekSiteMaster(String sap_site_code) {
        site _site = new site();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT sap_site_code, sap_site_name, sap_site_type, sap_site_costcenter, sap_site_address, sap_site_locality "
                + "FROM branfile_sap where sap_site_code=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, sap_site_code);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {//have
                _site.setHaveSite(true);
                haveSite = true;
                _site.setSap_code(rs.getString("sap_site_code"));
                _site.setSap_name(rs.getString("sap_site_name"));
                _site.setSap_type(rs.getString("sap_site_type"));
                _site.setSap_costcenter(rs.getString("sap_site_costcenter"));
                _site.setSap_address(rs.getString("sap_site_address"));
                _site.setSap_locality(rs.getString("sap_site_locality"));
            } else {
                _site.setHaveSite(false);
                haveSite = false;
            }
        } catch (Exception e) {
            _site.setHaveSite(false);
            haveSite = false;
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "seekSiteMaster(" + sap_site_code + ")");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return _site;
    }

    public void seek(String bcode) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT code, sap_site_code, sap_site_name, sap_site_type, sap_site_costcenter, sap_site_address, sap_site_locality, sap_site_cashbank "
                + "FROM branfile where code=?";

        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, bcode);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {//have
                setHaveSite(true);
                haveSite = true;
//                _site.setBcode(bcode);
//                _site.setSap_code(rs.getString("sap_site_code"));
//                _site.setSap_name(rs.getString("sap_site_name"));
//                _site.setSap_type(rs.getString("sap_site_type"));
//                _site.setSap_costcenter(rs.getString("sap_site_costcenter"));
//                _site.setSap_address(rs.getString("sap_site_address"));
//                _site.setSap_locality(rs.getString("sap_site_locality"));
//                _site.setSap_site_cashbank(rs.getString("sap_site_cashbank"));
                setBcode(bcode);
                setSap_code(rs.getString("sap_site_code"));
                setSap_name(rs.getString("sap_site_name"));
                setSap_type(rs.getString("sap_site_type"));
                System.out.println("Seek// " + rs.getString("sap_site_type"));
                setSap_costcenter(rs.getString("sap_site_costcenter"));
                setSap_address(rs.getString("sap_site_address"));
                setSap_locality(rs.getString("sap_site_locality"));
                setSap_site_cashbank(rs.getString("sap_site_cashbank"));
            } else {
                setHaveSite(false);
                haveSite = false;
                setBcode("");
                setSap_code("");
                setSap_name("");
                setSap_type("");
                setSap_costcenter("");
                setSap_address("");
                setSap_locality("");
                setSap_site_cashbank("");
            }
        } catch (Exception e) {
            setHaveSite(false);
            haveSite = false;
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "seek(" + bcode + ")");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
//        return _site;
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

    public void readZRTINT01_SiteMaster(String pathDirec, JProgressBar progress, JTextArea txtArea) {
        String sap_code = "";//WERKS
        String sap_name = "";//NAME1
        String sap_type = "";//KTOKD : 0100 = Factory, Z100/ Z110 = BranchCode
        String sap_costcenter = "";//COST_CENTER
        String sap_address = "";// HOUSE_NUM1 + HOUSE_NUM2 + STR_SUPPL1 + STR_SUPPL3
        String sap_locality = "";//LOCATION
        String strdocnum = "";
        String fileName = "";
        try {
            txtArea.setText("");
            int totalItem = 0;
            File fXmlFile = new File(pathDirec);//SP1_ZRTINT02_20161020-110554-358.xml   , SP1_ZRTINT02_(PING).xml
            fileName = fXmlFile.getName();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("IDOC");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                NodeList listArticle = nNode.getChildNodes();
                for (int i = 0; i < listArticle.getLength(); i++) {
                    sap_code = "";//WERKS
                    sap_name = "";//NAME1
                    sap_type = "";//KTOKD : 0100 = Factory, Z100/ Z110 = BranchCode
                    sap_costcenter = "";//COST_CENTER
                    sap_address = "";// HOUSE_NUM1 + HOUSE_NUM2 + STR_SUPPL1 + STR_SUPPL3
                    sap_locality = "";//LOCATION
                    nNode = listArticle.item(i);
                    if (nNode.getNodeName().equals("EDI_DC40")) {
                        strdocnum = nNode.getChildNodes().item(0).getTextContent();
                    } else if (!nNode.getNodeName().equals("#text")) {
                        System.out.println("SiteMaster :" + nNode.getNodeName() + " => i(" + i + ")");

                        NodeList nList1 = nNode.getChildNodes();
                        for (int j = 0; j < nList1.getLength(); j++) {
                            nNode = nList1.item(j);

                            if (!nNode.getNodeName().equals("#text")) {
                                System.out.println("\tElement :" + nNode.getNodeName() + " => NodeLength(" + nNode.getChildNodes().getLength() + ")");

                                if (nNode.getNodeName().equals("KUNNR")) {
                                    sap_code = nNode.getChildNodes().item(0).getTextContent();
                                } else if (nNode.getNodeName().equals("KTOKD")) {
                                    sap_type = nNode.getChildNodes().item(0).getTextContent();
                                } else if (nNode.getNodeName().equals("ZBCODE") && nNode.getChildNodes().getLength() >= 3 && nNode.getChildNodes().item(2).getNodeName().equals("COST_CENTER")) {
                                    sap_costcenter = nNode.getChildNodes().item(2).getTextContent();
                                } else if (nNode.getNodeName().equals("NAME1")) {
                                    sap_name = nNode.getChildNodes().item(0).getTextContent();
                                } else if (nNode.getNodeName().equals("ZADDRESS")) {
                                    NodeList nList2 = nNode.getChildNodes();

                                    for (int k = 0; k < nList2.getLength(); k++) {
                                        nNode = nList2.item(k);
                                        if (nNode.getNodeName().equals("HOUSE_NUM1")) {
                                            sap_address = nNode.getChildNodes().item(0).getTextContent();
                                        } else if (nNode.getNodeName().equals("HOUSE_NUM2")) {
                                            sap_address = sap_address + " " + nNode.getChildNodes().item(0).getTextContent();
                                        } else if (nNode.getNodeName().equals("STR_SUPPL1")) {
                                            sap_address = sap_address + " " + nNode.getChildNodes().item(0).getTextContent();
                                        } else if (nNode.getNodeName().equals("STR_SUPPL3")) {
                                            sap_address = sap_address + " " + nNode.getChildNodes().item(0).getTextContent();
                                        } else if (nNode.getNodeName().equals("LOCATION")) {
                                            sap_locality = nNode.getChildNodes().item(0).getTextContent();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    System.out.println("sap_type        " + (sap_type.equals("0100") ? "FACTORY" : "BRANCH")); // (sap_type.equals("0100") ? "Factory" : sap_type.equals("Z100") ? "Branch01" : "Branch02")
                    System.out.println("sap_code        " + sap_code);
                    System.out.println("sap_name        " + sap_name);
                    System.out.println("sap_costcenter  " + sap_costcenter);
                    System.out.println("sap_address     " + sap_address);
                    System.out.println("sap_locality    " + sap_locality);
                    System.out.println("strdocnum   " + strdocnum);
                    if (sap_code.length() > 0) {
                        totalItem++;
                        executeSiteMaster(sap_code, sap_name, sap_costcenter, sap_address, sap_locality, (sap_type.equals("0100") ? "FACTORY" : "BRANCH"), strdocnum);
                        txtArea.append("Site : " + sap_code + "\t" + sap_name + "\n");
                        txtArea.setCaretPosition(txtArea.getDocument().getLength());
                    }
                }
            }
            System.out.println("+++++++++++++++++++++++++++++");
            progress.setIndeterminate(false);
            txtArea.append("----------------------------------------------------------------------------" + "\n");
            txtArea.setCaretPosition(txtArea.getDocument().getLength());
            txtArea.append("Total : " + totalItem + " from File " + fileName + "\n");
            txtArea.setCaretPosition(txtArea.getDocument().getLength());
            txtArea.append("==============================" + "\n");
            txtArea.setCaretPosition(txtArea.getDocument().getLength());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean executeSiteMaster(String sap_code, String sap_name, String sap_costcenter, String sap_address, String sap_locality, String sap_type, String strdocnum) {
        boolean isOK = true;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "delete from branfile_sap where sap_site_docnum=?";
        try {
//            ps = dbutility.dbUtility.con.prepareStatement(sql);// delete doc num from file
//            ps.setString(1, strdocnum);
//            ps.executeUpdate();

            sql = "SELECT sap_site_type, sap_site_code, sap_site_name, sap_site_costcenter, sap_site_address, sap_site_locality, sap_site_docnum "
                    + "FROM branfile_sap where sap_site_code=?";
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, sap_code);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) { // have
                sql = "update branfile_sap set "
                        + "sap_site_type=?, sap_site_name=?, sap_site_costcenter=?, sap_site_address=?, sap_site_locality=?, sap_site_docnum=? "
                        + "where sap_site_code=?";
            } else { // haven't
                sql = "insert into branfile_sap(sap_site_type, sap_site_name, sap_site_costcenter, sap_site_address, sap_site_locality, sap_site_docnum, sap_site_code) values(?,?,?,?,?,?,?)";
            }
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, sap_type);
            ps.setString(2, (sap_name.length() > 50 ? sap_name.substring(0, 50) : sap_name));
            ps.setString(3, sap_costcenter);
            ps.setString(4, (sap_address.length() > 255 ? sap_address.substring(0, 255) : sap_address));
            ps.setString(5, (sap_locality.length() > 50 ? sap_locality.substring(0, 50) : sap_locality));
            ps.setString(6, (strdocnum.length() > 25 ? strdocnum.substring(0, 25) : strdocnum));
            ps.setString(7, sap_code);
            ps.executeUpdate();

//            chkUpdateSiteMaster(sap_code,
//                    (sap_name.length() > 50 ? sap_name.substring(0, 50) : sap_name),
//                    sap_costcenter,
//                    (sap_address.length() > 255 ? sap_address.substring(0, 255) : sap_address),
//                    (sap_locality.length() > 50 ? sap_locality.substring(0, 50) : sap_locality),
//                    sap_type);
        } catch (Exception e) {
            isOK = false;
            e.printStackTrace();
            new showMessage().showMessageError(e.getMessage(), "executeSiteMaster()");
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return isOK;
    }

    private void chkUpdateSiteMaster(String sap_code, String sap_name, String sap_costcenter, String sap_address, String sap_locality, String sap_type) {
        String sapConvert = tu.Unicode2ASCII(sap_name);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update branfile set "
                    + "sap_site_code=?, sap_site_name=?, sap_site_type=?, sap_site_costcenter=?, sap_site_address=?, sap_site_locality=? "
                    + "where Name=? ";
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, sap_code);
            ps.setString(2, sap_name);
            ps.setString(3, sap_type);
            ps.setString(4, sap_costcenter);
            ps.setString(5, sap_address);
            ps.setString(6, sap_locality);
            ps.setString(7, sapConvert);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
            } catch (Exception e) {
            }
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (Exception e) {
            }
        }
    }

    public boolean branfileNotMapSite() {
        boolean isNotMap = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        site si = null;
        try {
//            String sql = "select code, name, sap_site_code from branfile where sap_site_code=''";
            String sql = "select code, name, sap_site_code from branfile where sap_site_code='' or sap_site_cashbank=''";
            ps = dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                isNotMap = true;
                list = new ArrayList<site>();
                do {
                    String bcode = rs.getString("code");
                    String bname = tu.ASCII2Unicode(rs.getString("name"));

                    si = new site();
                    si.setBcode(bcode);
                    si.setBname(bname);
                    this.list.add(si);
                } while (rs.next());
            }
        } catch (Exception e) {
            isNotMap = true;
            new showMessage().showMessageError(e.getMessage(), "branfileNotMapSite()");
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
            } catch (Exception e) {
            }
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (Exception e) {
            }
        }
        return isNotMap;
    }

    public void updateBranfileSite(String strBcode, String strSite, String cashBank) {
        site si = new site();
        utilitySAP us = new utilitySAP();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update branfile set "
                    + "sap_site_code=?, sap_site_name=?, sap_site_type=?, sap_site_costcenter=?, sap_site_address=?, sap_site_locality=?, sap_site_cashbank=? "
                    + "where code=? ";
            if (strSite.length() == 10) {
                si = si.seekSiteMaster(strSite);
            } else {
                strSite = us.addZeroBefore(10, strSite);
                si = si.seekSiteMaster(strSite);
            }
            if (si.haveSite()) {
                System.out.println("have " + strSite);
                ps = dbUtility.con.prepareStatement(sql);
                ps.setString(1, si.getSap_code());
                ps.setString(2, si.getSap_name());
                ps.setString(3, si.getSap_type());
                ps.setString(4, si.getSap_costcenter());
                ps.setString(5, si.getSap_address());
                ps.setString(6, si.getSap_locality());
                ps.setString(7, cashBank);
                ps.setString(8, strBcode);
                ps.executeUpdate();
            } else {
                System.out.println("haven't " + strSite);
            }
        } catch (Exception e) {
            new showMessage().showMessageError(e.getMessage(), "updateBranfileSite(" + strBcode + ", " + strSite + ", " + cashBank + ")");
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
            } catch (Exception e) {
            }
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (Exception e) {
            }
        }
    }

    public void exportBranfileMapping(String parthFile) {
        utilitySAP us = new utilitySAP();
        StringBuilder str = new StringBuilder();
        String sql = "select btype, code, name, sap_site_code, sap_site_name, sap_site_cashbank, companycode, sap_site_costcenter "
                + "from branfile where sap_site_code !='' order by btype, code, companycode";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                String btype, code, name, sap_site_code, sap_site_name, sap_site_cashbank, companycode, sap_site_costcenter, line;
                do {
                    btype = rs.getString("btype");
                    code = rs.getString("code");
                    name = tu.ASCII2Unicode(rs.getString("name"));
                    sap_site_code = rs.getString("sap_site_code");
                    sap_site_name = rs.getString("sap_site_name");
                    sap_site_cashbank = rs.getString("sap_site_cashbank");
                    companycode = rs.getString("companycode");
                    sap_site_costcenter = rs.getString("sap_site_costcenter");

                    line = btype + "\t" + code + "\t" + name + "\t" + sap_site_code + "\t" + sap_site_name + "\t" + sap_site_cashbank + "\t" + companycode + "\t" + sap_site_costcenter;
                    str.append(line + "\n");
                } while (rs.next());
                us.writeFile(parthFile, str);
            }
        } catch (Exception e) {
            new showMessage().showMessageError(e.getMessage(), "exportBranfileMapping");
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
            } catch (Exception e) {
            }
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (Exception e) {
            }
        }
    }
}
