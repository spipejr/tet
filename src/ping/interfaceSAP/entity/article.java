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
public class article {

    private ArrayList<article> list = new ArrayList<article>();
    ThaiUtilities tu = new ThaiUtilities();
    private boolean have = false;
    private String pcode = "";
    private String pdesc = "";
    private String sap_article = "";
    private String sap_article_name = "";
    private String sap_article_barcode = "";
    private String sap_article_unit = "";
    private String sap_article_jde = "";
    private String sap_article_active = "";

    public article() {
    }

    public article(String pcode, String sap_article, String sap_article_name, String sap_article_barcode, String sap_article_unit, String sap_article_jde, String sap_article_active) {
        this.pcode = pcode;
        this.sap_article = sap_article;
        this.sap_article_name = sap_article_name;
        this.sap_article_barcode = sap_article_barcode;
        this.sap_article_unit = sap_article_unit;
        this.sap_article_jde = sap_article_jde;
        this.sap_article_active = sap_article_active;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public boolean isArticle() {
        return have;
    }

    public void setHave(boolean have) {
        this.have = have;
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

    public String getSap_article_barcode() {
        return sap_article_barcode;
    }

    public void setSap_article_barcode(String sap_article_barcode) {
        this.sap_article_barcode = sap_article_barcode;
    }

    public String getSap_article_unit() {
        return sap_article_unit;
    }

    public void setSap_article_unit(String sap_article_unit) {
        this.sap_article_unit = sap_article_unit;
    }

    public String getSap_article_jde() {
        return sap_article_jde;
    }

    public void setSap_article_jde(String sap_article_jde) {
        this.sap_article_jde = sap_article_jde;
    }

    public String getSap_article_active() {
        return sap_article_active;
    }

    public void setSap_article_active(String sap_article_active) {
        this.sap_article_active = sap_article_active;
    }

    public ArrayList<article> getListProductNoMap() {
        return list;
    }

    public void setList(ArrayList<article> list) {
        this.list = list;
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

    public ArrayList<article> seek() {
        ArrayList<article> _list = new ArrayList<article>();
        article _article = new article();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT sap_article, sap_article_name, sap_article_barcode, sap_article_unit, sap_article_jde, sap_article_active FROM product_sap order by sap_article";

        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    _article = new article();
                    _article.setSap_article(rs.getString("sap_article"));
                    _article.setSap_article_name(rs.getString("sap_article_name"));
                    _article.setSap_article_barcode(rs.getString("sap_article_barcode"));
                    _article.setSap_article_unit(rs.getString("sap_article_unit"));
                    _article.setSap_article_jde(rs.getString("sap_article_jde"));
                    _article.setSap_article_active(rs.getString("sap_article_active"));

                    _list.add(_article);
                } while (rs.next());
            }
        } catch (Exception e) {
            new showMessage().showMessageError(e.getMessage(), "seek()");
            e.printStackTrace();
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return _list;
    }

    public ArrayList<article> seek(String txt, String table) {
        ArrayList<article> _list = new ArrayList<article>();
        article _article = new article();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT sap_article, sap_article_name, sap_article_barcode, sap_article_unit, sap_article_jde, sap_article_active FROM product_sap "
                + "where " + table + " like ? "
                + "order by " + table;

        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                do {
                    _article = new article();
                    _article.setSap_article(rs.getString("sap_article"));
                    _article.setSap_article_name(rs.getString("sap_article_name"));
                    _article.setSap_article_barcode(rs.getString("sap_article_barcode"));
                    _article.setSap_article_unit(rs.getString("sap_article_unit"));
                    _article.setSap_article_jde(rs.getString("sap_article_jde"));
                    _article.setSap_article_active(rs.getString("sap_article_active"));

                    _list.add(_article);
                } while (rs.next());
            }
        } catch (Exception e) {
            new showMessage().showMessageError(e.getMessage(), "seek()");
            e.printStackTrace();
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return _list;
    }

    public article seek(String pcode) {
        article _article = new article();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select pcode, sap_article, sap_article_name, sap_article_barcode, sap_article_unit, sap_article_jde, sap_article_active from product where pcode=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, pcode);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                _article.setHave(true);
                _article.setSap_article(rs.getString("sap_article"));
                _article.setSap_article_name(rs.getString("sap_article_name"));
                _article.setSap_article_barcode(rs.getString("sap_article_barcode"));
                _article.setSap_article_unit(rs.getString("sap_article_unit"));
                _article.setSap_article_jde(rs.getString("sap_article_jde"));
                _article.setSap_article_active(rs.getString("sap_article_active"));
            } else {
                _article.setHave(false);
            }
        } catch (Exception e) {
            _article.setHave(false);
            new showMessage().showMessageError(e.getMessage(), "seek(" + pcode + ")");
            e.printStackTrace();
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return _article;
    }

    public article seekArticleMaster(String sap_article) {
        article _article = new article();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select sap_article, sap_article_name, sap_article_barcode, sap_article_unit, sap_article_jde, sap_article_active from product_sap where sap_article=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, sap_article);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                _article.setHave(true);
                _article.setSap_article(rs.getString("sap_article"));
                _article.setSap_article_name(rs.getString("sap_article_name"));
                _article.setSap_article_barcode(rs.getString("sap_article_barcode"));
                _article.setSap_article_unit(rs.getString("sap_article_unit"));
                _article.setSap_article_jde(rs.getString("sap_article_jde"));
                _article.setSap_article_active(rs.getString("sap_article_active"));
            } else {
                _article.setHave(false);
            }
        } catch (Exception e) {
            _article.setHave(false);
            new showMessage().showMessageError(e.getMessage(), "seekArticleMaster(" + sap_article + ")");
            e.printStackTrace();
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return _article;
    }

    public boolean execute() {
        boolean isOK = true;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT pcode FROM product where pcode=?";
        try {
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.pcode);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) { // update
                sql = "update product "
                        + "set sap_article=?, sap_article_name=?, sap_article_barcode=?, sap_article_unit=?, sap_article_jde=?, sap_article_active=? "
                        + "where pcode=?";
            }
            ps = dbutility.dbUtility.con.prepareStatement(sql);
            ps.setString(1, this.sap_article);
            ps.setString(2, this.sap_article_name);
            ps.setString(3, this.sap_article_barcode);
            ps.setString(4, this.sap_article_unit);
            ps.setString(5, this.sap_article_jde);
            ps.setString(6, this.sap_article_active);
            ps.setString(7, this.pcode);
            ps.executeUpdate();
        } catch (Exception e) {
            isOK = false;
            new showMessage().showMessageError(e.getMessage(), "execute()");
            e.printStackTrace();
        } finally {
            closePS(ps);
            closeRS(rs);
        }
        return isOK;
    }

    public void readZRTINT02_Article(String pathDirec, JProgressBar progress, JTextArea txtArea) {
        String productCode = "";
        String productName = "";
        String productActivate = "";
        String productBarcode = "";
        String productJDE = "";
        String productUnit = "";
        String tempBarcode = "";
        String tempUnit = "";
        String strdocnum = "";
        boolean baseUnit = false;
        String fileName = "";

        //==========================
        String DOCNUM = "";
        String MATNR = "";
        String ZEXTWG = "";
        String MEINH_1 = "";
        String UMREZ_1 = "";
        String UMREN_1 = "";
        String ZBASEUOM_1 = "";
        String ZPURCH_1 = "";
        String ZDELIVEY_1 = "";
        String EAN11_1 = "";
        String EANTP_1 = "";
        String HPEAN_1 = "";
        String MEINH_2 = "";
        String UMREZ_2 = "";
        String UMREN_2 = "";
        String ZBASEUOM_2 = "";
        String ZPURCH_2 = "";
        String ZDELIVEY_2 = "";
        String EAN11_2 = "";
        String EANTP_2 = "";
        String HPEAN_2 = "";
        String MEINH_3 = "";
        String UMREZ_3 = "";
        String UMREN_3 = "";
        String ZBASEUOM_3 = "";
        String ZPURCH_3 = "";
        String ZDELIVEY_3 = "";
        String EAN11_3 = "";
        String EANTP_3 = "";
        String HPEAN_3 = "";
        String MEINH_4 = "";
        String UMREZ_4 = "";
        String UMREN_4 = "";
        String ZBASEUOM_4 = "";
        String ZPURCH_4 = "";
        String ZDELIVEY_4 = "";
        String EAN11_4 = "";
        String EANTP_4 = "";
        String HPEAN_4 = "";
        String MEINH_5 = "";
        String UMREZ_5 = "";
        String UMREN_5 = "";
        String ZBASEUOM_5 = "";
        String ZPURCH_5 = "";
        String ZDELIVEY_5 = "";
        String EAN11_5 = "";
        String EANTP_5 = "";
        String HPEAN_5 = "";
        String MTART = "";
        String MAKTM = "";
        String BRAN_ID = "";
        String BISMT = "";
        int E1WBB03 = -1;
        //==========================
        try {
            txtArea.setText("");
            int totalItem = 0;
            File fXmlFile = new File(pathDirec);//SP1_ZRTINT02_20161020-110554-358.xml   , SP1_ZRTINT02_(PING).xml
            fileName = fXmlFile.getName();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("IDOC");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                NodeList listArticle = nNode.getChildNodes();
                for (int i = 0; i < listArticle.getLength(); i++) {
                    baseUnit = false;
                    productCode = "";
                    productName = "";
                    productActivate = "Y";
                    productBarcode = "";
                    productJDE = "";
                    productUnit = "";

                    DOCNUM = "";//have
                    MATNR = "";//have
                    ZEXTWG = "";//have
                    MEINH_1 = "";//have
                    UMREZ_1 = "";//have
                    UMREN_1 = "";//have
                    ZBASEUOM_1 = "";//have
                    ZPURCH_1 = "";//have
                    ZDELIVEY_1 = "";//have
                    EAN11_1 = "";//have
                    EANTP_1 = "";//have
                    HPEAN_1 = "";//have
                    MEINH_2 = "";//have
                    UMREZ_2 = "";//have
                    UMREN_2 = "";//have
                    ZBASEUOM_2 = "";//have
                    ZPURCH_2 = "";//have
                    ZDELIVEY_2 = "";//have
                    EAN11_2 = "";//have
                    EANTP_2 = "";//have
                    HPEAN_2 = "";//have
                    MEINH_3 = "";//have
                    UMREZ_3 = "";//have
                    UMREN_3 = "";//have
                    ZBASEUOM_3 = "";//have
                    ZPURCH_3 = "";//have
                    ZDELIVEY_3 = "";//have
                    EAN11_3 = "";//have
                    EANTP_3 = "";//have
                    HPEAN_3 = "";//have

                    MEINH_4 = "";//have
                    UMREZ_4 = "";//have
                    UMREN_4 = "";//have
                    ZBASEUOM_4 = "";//have
                    ZPURCH_4 = "";//have
                    ZDELIVEY_4 = "";//have
                    EAN11_4 = "";//have
                    EANTP_4 = "";//have
                    HPEAN_4 = "";//have

                    MEINH_5 = "";//have
                    UMREZ_5 = "";//have
                    UMREN_5 = "";//have
                    ZBASEUOM_5 = "";//have
                    ZPURCH_5 = "";//have
                    ZDELIVEY_5 = "";//have
                    EAN11_5 = "";//have
                    EANTP_5 = "";//have
                    HPEAN_5 = "";//have

                    MTART = "";//have
                    MAKTM = "";// have
                    BRAN_ID = "";//have
                    BISMT = "";//have
                    
                    E1WBB03 = -1;

                    nNode = listArticle.item(i);
                    if (nNode.getNodeName().equals("EDI_DC40")) {
                        strdocnum = nNode.getChildNodes().item(0).getTextContent();

                        DOCNUM = nNode.getChildNodes().item(0).getTextContent();
                    } else {
                        if (!nNode.getNodeName().equals("#text")) {
                            if (!nNode.getNodeName().equals("EDI_DC40")) {
                                NodeList nList2 = nNode.getChildNodes();
                                for (int j = 0; j < nList2.getLength(); j++) {
                                    nNode = nList2.item(j);

                                    if (!nNode.getNodeName().equals("#text")) {

                                        if (nNode.getNodeName().equals("E1WBB02")) {
                                            MTART = nNode.getTextContent();
                                        } else if (nNode.getNodeName().equals("ZE1WBB10")) {
                                            NodeList nListZE1WBB10 = nNode.getChildNodes();
                                            for (int k = 0; k < nListZE1WBB10.getLength(); k++) {
                                                nNode = nListZE1WBB10.item(k);
                                                if (nNode.getNodeName().equals("ZEXTWG")) {
                                                    ZEXTWG = nNode.getTextContent();
                                                } else if (nNode.getNodeName().equals("BRAN_ID")) {
                                                    BRAN_ID = nNode.getTextContent();
                                                }
                                            }
                                        } else if (nNode.getNodeName().equals("E1WBB03")) {
                                            E1WBB03++;
                                            NodeList nListE1WBB03 = nNode.getChildNodes();
                                            for (int b = 0; b < nListE1WBB03.getLength(); b++) {
                                                nNode = nListE1WBB03.item(b);
                                                if (nNode.getNodeName().equals("MEINH")) {
                                                    tempUnit = nNode.getTextContent();
                                                    if (E1WBB03 == 0) {
                                                        MEINH_1 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 1) {
                                                        MEINH_2 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 2) {
                                                        MEINH_3 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 3) {
                                                        MEINH_4 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 4) {
                                                        MEINH_5 = nNode.getTextContent();
                                                    }
                                                } else if (nNode.getNodeName().equals("UMREZ")) {
                                                    if (E1WBB03 == 0) {
                                                        UMREZ_1 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 1) {
                                                        UMREZ_2 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 2) {
                                                        UMREZ_3 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 3) {
                                                        UMREZ_4 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 4) {
                                                        UMREZ_5 = nNode.getTextContent();
                                                    }
                                                } else if (nNode.getNodeName().equals("UMREN")) {
                                                    if (E1WBB03 == 0) {
                                                        UMREN_1 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 1) {
                                                        UMREN_2 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 2) {
                                                        UMREN_3 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 3) {
                                                        UMREN_4 = nNode.getTextContent();
                                                    } else if (E1WBB03 == 4) {
                                                        UMREN_5 = nNode.getTextContent();
                                                    }
                                                } else if (nNode.getNodeName().equals("ZE1WBB03")) {
                                                    NodeList nListZE1WBB03 = nNode.getChildNodes();
                                                    for (int a = 0; a < nListZE1WBB03.getLength(); a++) {
                                                        nNode = nListZE1WBB03.item(a);

                                                        if (nNode.getNodeName().equals("ZBASEUOM")) {
                                                            if (E1WBB03 == 0) {
                                                                ZBASEUOM_1 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 1) {
                                                                ZBASEUOM_2 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 2) {
                                                                ZBASEUOM_3 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 3) {
                                                                ZBASEUOM_4 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 4) {
                                                                ZBASEUOM_5 = nNode.getTextContent();
                                                            }
                                                            if (nNode.getTextContent().equalsIgnoreCase("x")) {
                                                                baseUnit = true;
                                                                productUnit = tempUnit;
                                                            }
                                                        } else if (nNode.getNodeName().equals("ZPURCH")) {
                                                            if (E1WBB03 == 0) {
                                                                ZPURCH_1 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 1) {
                                                                ZPURCH_2 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 2) {
                                                                ZPURCH_3 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 3) {
                                                                ZPURCH_4 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 4) {
                                                                ZPURCH_5 = nNode.getTextContent();
                                                            }
                                                        } else if (nNode.getNodeName().equals("ZDELIVEY")) {
                                                            if (E1WBB03 == 0) {
                                                                ZDELIVEY_1 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 1) {
                                                                ZDELIVEY_2 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 2) {
                                                                ZDELIVEY_3 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 3) {
                                                                ZDELIVEY_4 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 4) {
                                                                ZDELIVEY_5 = nNode.getTextContent();
                                                            }
                                                        }
                                                    }
                                                } else if (nNode.getNodeName().equals("E1WBB04")) {
                                                    NodeList nListE1WBB04 = nNode.getChildNodes();
                                                    for (int c = 0; c < nListE1WBB04.getLength(); c++) {
                                                        nNode = nListE1WBB04.item(c);

                                                        if (nNode.getNodeName().equals("EAN11")) {
                                                            tempBarcode = nNode.getTextContent();
                                                            if (E1WBB03 == 0) {
                                                                EAN11_1 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 1) {
                                                                EAN11_2 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 2) {
                                                                EAN11_3 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 3) {
                                                                EAN11_4 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 4) {
                                                                EAN11_5 = nNode.getTextContent();
                                                            }
                                                        } else if (nNode.getNodeName().equals("EANTP")) {
                                                            if (E1WBB03 == 0) {
                                                                EANTP_1 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 1) {
                                                                EANTP_2 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 2) {
                                                                EANTP_3 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 3) {
                                                                EANTP_4 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 4) {
                                                                EANTP_5 = nNode.getTextContent();
                                                            }
                                                        } else if (nNode.getNodeName().equals("HPEAN")) {
                                                            if (E1WBB03 == 0) {
                                                                HPEAN_1 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 1) {
                                                                HPEAN_2 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 2) {
                                                                HPEAN_3 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 3) {
                                                                HPEAN_4 = nNode.getTextContent();
                                                            } else if (E1WBB03 == 4) {
                                                                HPEAN_5 = nNode.getTextContent();
                                                            }
                                                        }
                                                    }
                                                    if (baseUnit) {
                                                        productBarcode = tempBarcode;
                                                        baseUnit = false;
                                                    }
                                                }
                                            }
                                        } else if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                            if (nNode.getNodeName().equals("MATNR")) {
                                                productCode = nNode.getTextContent();

                                                MATNR = nNode.getTextContent();
                                            } else if (nNode.getNodeName().equals("ZE1WBB01")) {
                                                productJDE = nNode.getTextContent();

                                                BISMT = nNode.getTextContent();
                                            } else if (nNode.getNodeName().equals("E1WBB10")) {
                                                productName = nNode.getTextContent();

                                                MAKTM = nNode.getTextContent();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (productCode.length() > 0) {
                            totalItem++;
                            executeProductSAP(productCode, productName, productUnit, productJDE, productBarcode, productActivate, strdocnum,
                                    MATNR, ZEXTWG, MEINH_1, UMREZ_1, UMREN_1, ZBASEUOM_1, ZPURCH_1, ZDELIVEY_1, EAN11_1, EANTP_1, HPEAN_1, MEINH_2, UMREZ_2, UMREN_2, ZBASEUOM_2, ZPURCH_2, ZDELIVEY_2, EAN11_2, EANTP_2, HPEAN_2, MEINH_3, UMREZ_3, UMREN_3, ZBASEUOM_3, ZPURCH_3, ZDELIVEY_3, EAN11_3, EANTP_3, HPEAN_3, MEINH_4, UMREZ_4, UMREN_4, ZBASEUOM_4, ZPURCH_4, ZDELIVEY_4, EAN11_4, EANTP_4, HPEAN_4, MEINH_5, UMREZ_5, UMREN_5, ZBASEUOM_5, ZPURCH_5, ZDELIVEY_5, EAN11_5, EANTP_5, HPEAN_5, MTART, MAKTM, BRAN_ID, BISMT);

                            txtArea.append("Article : " + productCode + "\t" + productName + "\n");
                            txtArea.setCaretPosition(txtArea.getDocument().getLength());
                        }
                    }
                }
            }

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

    private void executeProductSAP(String productCode, String productName, String productUnit, String productJDE, String productBarcode, String productActivate, String docnum,
            String MATNR,//1
            String ZEXTWG,//2
            String MEINH_1,//3
            String UMREZ_1,//4
            String UMREN_1,//5
            String ZBASEUOM_1,//6
            String ZPURCH_1,//7
            String ZDELIVEY_1,//8
            String EAN11_1,//9
            String EANTP_1,//10
            String HPEAN_1,//11
            String MEINH_2,//12
            String UMREZ_2,//13
            String UMREN_2,//14
            String ZBASEUOM_2,//15
            String ZPURCH_2,//16
            String ZDELIVEY_2,//17
            String EAN11_2,//18
            String EANTP_2,//19
            String HPEAN_2,//20
            String MEINH_3,//21
            String UMREZ_3,//22
            String UMREN_3,//23
            String ZBASEUOM_3,//24
            String ZPURCH_3,//25
            String ZDELIVEY_3,//26
            String EAN11_3,//27
            String EANTP_3,//28
            String HPEAN_3,//29
            String MEINH_4,//30
            String UMREZ_4,//31
            String UMREN_4,//32
            String ZBASEUOM_4,//33
            String ZPURCH_4,//34
            String ZDELIVEY_4,//35
            String EAN11_4,//36
            String EANTP_4,//37
            String HPEAN_4,//38
            String MEINH_5,//39
            String UMREZ_5,//40
            String UMREN_5,//41
            String ZBASEUOM_5,//42
            String ZPURCH_5,//43
            String ZDELIVEY_5,//44
            String EAN11_5,//45
            String EANTP_5,//46
            String HPEAN_5,//47
            String MTART,//48
            String MAKTM,//49
            String BRAN_ID,//50
            String BISMT) {//51
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select sap_article, sap_article_name, sap_article_barcode, sap_article_unit, sap_article_jde, sap_article_active, sap_article_docnum from product_sap where sap_article=?";
        try {
            ps = dbUtility.con.prepareStatement(sql);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {//have
                sql = "update product_sap set "
                        + "sap_article_name=?, sap_article_barcode=?, sap_article_unit=?, sap_article_jde=?, sap_article_active=?, sap_article_docnum=?, "
                        + "MATNR=?, "
                        + "ZEXTWG=?, "
                        + "MEINH_1=?, "
                        + "UMREZ_1=?, "
                        + "UMREN_1=?, "
                        + "ZBASEUOM_1=?, "
                        + "ZPURCH_1=?, "
                        + "ZDELIVEY_1=?, "
                        + "EAN11_1=?, "
                        + "EANTP_1=?, "
                        + "HPEAN_1=?, "
                        + "MEINH_2=?, "
                        + "UMREZ_2=?, "
                        + "UMREN_2=?, "
                        + "ZBASEUOM_2=?, "
                        + "ZPURCH_2=?, "
                        + "ZDELIVEY_2=?, "
                        + "EAN11_2=?, "
                        + "EANTP_2=?, "
                        + "HPEAN_2=?, "
                        + "MEINH_3=?, "
                        + "UMREZ_3=?, "
                        + "UMREN_3=?, "
                        + "ZBASEUOM_3=?, "
                        + "ZPURCH_3=?, "
                        + "ZDELIVEY_3=?, "
                        + "EAN11_3=?, "
                        + "EANTP_3=?, "
                        + "HPEAN_3=?, "
                        + "MEINH_4=?, "
                        + "UMREZ_4=?, "
                        + "UMREN_4=?, "
                        + "ZBASEUOM_4=?, "
                        + "ZPURCH_4=?, "
                        + "ZDELIVEY_4=?, "
                        + "EAN11_4=?, "
                        + "EANTP_4=?, "
                        + "HPEAN_4=?, "
                        + "MEINH_5=?, "
                        + "UMREZ_5=?, "
                        + "UMREN_5=?, "
                        + "ZBASEUOM_5=?, "
                        + "ZPURCH_5=?, "
                        + "ZDELIVEY_5=?, "
                        + "EAN11_5=?, "
                        + "EANTP_5=?, "
                        + "HPEAN_5=?, "
                        + "MTART=?, "
                        + "MAKTM=?, "
                        + "BRAN_ID=?, "
                        + "BISMT=? "
                        + "where sap_article=?";
            } else {//haven't
                sql = "insert into product_sap(sap_article_name, sap_article_barcode, sap_article_unit, sap_article_jde, sap_article_active, sap_article_docnum, "
                        + "MATNR,"
                        + "ZEXTWG,"
                        + "MEINH_1,"
                        + "UMREZ_1,"
                        + "UMREN_1,"
                        + "ZBASEUOM_1,"
                        + "ZPURCH_1,"
                        + "ZDELIVEY_1,"
                        + "EAN11_1,"
                        + "EANTP_1,"
                        + "HPEAN_1,"
                        + "MEINH_2,"
                        + "UMREZ_2,"
                        + "UMREN_2,"
                        + "ZBASEUOM_2,"
                        + "ZPURCH_2,"
                        + "ZDELIVEY_2,"
                        + "EAN11_2,"
                        + "EANTP_2,"
                        + "HPEAN_2,"
                        + "MEINH_3,"
                        + "UMREZ_3,"
                        + "UMREN_3,"
                        + "ZBASEUOM_3,"
                        + "ZPURCH_3,"
                        + "ZDELIVEY_3,"
                        + "EAN11_3,"
                        + "EANTP_3,"
                        + "HPEAN_3,"
                        + "MEINH_4,"
                        + "UMREZ_4,"
                        + "UMREN_4,"
                        + "ZBASEUOM_4,"
                        + "ZPURCH_4,"
                        + "ZDELIVEY_4,"
                        + "EAN11_4,"
                        + "EANTP_4,"
                        + "HPEAN_4,"
                        + "MEINH_5,"
                        + "UMREZ_5,"
                        + "UMREN_5,"
                        + "ZBASEUOM_5,"
                        + "ZPURCH_5,"
                        + "ZDELIVEY_5,"
                        + "EAN11_5,"
                        + "EANTP_5,"
                        + "HPEAN_5,"
                        + "MTART,"
                        + "MAKTM,"
                        + "BRAN_ID,"
                        + "BISMT,"
                        + "sap_article) values("
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
            ps = dbUtility.con.prepareStatement(sql);
            ps.setString(1, productName);
            ps.setString(2, productBarcode);
            ps.setString(3, productUnit);
            ps.setString(4, productJDE);
            ps.setString(5, productActivate);
            ps.setString(6, docnum);

            ps.setString(7, MATNR);
            ps.setString(8, ZEXTWG);
            ps.setString(9, MEINH_1);
            ps.setString(10, UMREZ_1);
            ps.setString(11, UMREN_1);
            ps.setString(12, ZBASEUOM_1);
            ps.setString(13, ZPURCH_1);
            ps.setString(14, ZDELIVEY_1);
            ps.setString(15, EAN11_1);
            ps.setString(16, EANTP_1);
            ps.setString(17, HPEAN_1);
            ps.setString(18, MEINH_2);
            ps.setString(19, UMREZ_2);
            ps.setString(20, UMREN_2);
            ps.setString(21, ZBASEUOM_2);
            ps.setString(22, ZPURCH_2);
            ps.setString(23, ZDELIVEY_2);
            ps.setString(24, EAN11_2);
            ps.setString(25, EANTP_2);
            ps.setString(26, HPEAN_2);
            ps.setString(27, MEINH_3);
            ps.setString(28, UMREZ_3);
            ps.setString(29, UMREN_3);
            ps.setString(30, ZBASEUOM_3);
            ps.setString(31, ZPURCH_3);
            ps.setString(32, ZDELIVEY_3);
            ps.setString(33, EAN11_3);
            ps.setString(34, EANTP_3);
            ps.setString(35, HPEAN_3);
            ps.setString(36, MEINH_4);
            ps.setString(37, UMREZ_4);
            ps.setString(38, UMREN_4);
            ps.setString(39, ZBASEUOM_4);
            ps.setString(40, ZPURCH_4);
            ps.setString(41, ZDELIVEY_4);
            ps.setString(42, EAN11_4);
            ps.setString(43, EANTP_4);
            ps.setString(44, HPEAN_4);
            ps.setString(45, MEINH_5);
            ps.setString(46, UMREZ_5);
            ps.setString(47, UMREN_5);
            ps.setString(48, ZBASEUOM_5);
            ps.setString(49, ZPURCH_5);
            ps.setString(50, ZDELIVEY_5);
            ps.setString(51, EAN11_5);
            ps.setString(52, EANTP_5);
            ps.setString(53, HPEAN_5);
            ps.setString(54, MTART);
            ps.setString(55, MAKTM);
            ps.setString(56, BRAN_ID);
            ps.setString(57, BISMT);

            ps.setString(58, productCode);
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

    private void chkUpdateArticleMaster(String productCode, String productName, String productUnit, String productJDE, String productBarcode, String productActivate) {
        String sapConvert = tu.Unicode2ASCII(productName);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update product set "
                    + "sap_article_name=?, sap_article_barcode=?, sap_article_unit=?, sap_article_jde=?, sap_article_active=?, sap_article=? "
                    + "where pdesc=?";
            ps = dbUtility.con.prepareStatement(sql);
            ps.setString(1, productName);
            ps.setString(2, productBarcode);
            ps.setString(3, productUnit);
            ps.setString(4, productJDE);
            ps.setString(5, productActivate);
            ps.setString(6, productCode);
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

    public boolean productIsNotMapArticle(String bgroup1, String bgroup2) {
        boolean isNotMap = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        article ar = null;
        try {
            String sql = "select p.pcode, p.pdesc, p.sap_article, bl.bgroup from blink bl "
                    + "inner join product p on p.pcode=bl.pcode "
                    + "where (bl.bgroup>=? and bl.bgroup<=?) and p.sap_article='' and p.pactive='Y' "
                    + "group by p.pcode "
                    + "order by p.pcode";
            ps = dbUtility.con.prepareStatement(sql);
            ps.setString(1, bgroup1);
            ps.setString(2, bgroup2);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                isNotMap = true;
                list = new ArrayList<article>();
                do {
                    String pcode = rs.getString("p.pcode");
                    String pdesc = tu.ASCII2Unicode(rs.getString("p.pdesc"));

                    ar = new article();
                    ar.setPcode(pcode);
                    ar.setPdesc(pdesc);
                    this.list.add(ar);
                } while (rs.next());
            }
        } catch (Exception e) {
            isNotMap = true;
            new showMessage().showMessageError(e.getMessage(), "productIsNotMapArticle()");
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

    public void updateProductArticle(String strPcode, String strArticle) {
        article ar = new article();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update product set "
                    + "sap_article_name=?, sap_article_barcode=?, sap_article_unit=?, sap_article_jde=?, sap_article_active=?, sap_article=? "
                    + "where pcode=?";
            ar = ar.seekArticleMaster(strArticle);
            if (ar.isArticle()) {
                ps = dbUtility.con.prepareStatement(sql);
                ps.setString(1, ar.getSap_article_name());
                ps.setString(2, ar.getSap_article_barcode());
                ps.setString(3, ar.getSap_article_unit());
                ps.setString(4, ar.getSap_article_jde());
                ps.setString(5, ar.getSap_article_active());
                ps.setString(6, ar.getSap_article());
                ps.setString(7, strPcode);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            new showMessage().showMessageError(e.getMessage(), "updateProductArticle(" + strPcode + ", " + strArticle + ")");
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

    public void exportProductMapping(String parthFile) {
        utilitySAP us = new utilitySAP();
        StringBuilder str = new StringBuilder();
        String sql = "select pgroup, pcode, pdesc, sap_article, sap_article_name, sap_article_unit from product "
                + "where pactive='Y' and sap_article!='' "
                + "order by pgroup, pcode";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = dbUtility.con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            if (rs.getRow() != 0) {
                String pgroup, pcode, pdesc, sap_article, sap_article_name, sap_article_unit, line;
                do {
                    pgroup = rs.getString("pgroup");
                    pcode = rs.getString("pcode");
                    pdesc = tu.ASCII2Unicode(rs.getString("pdesc"));
                    sap_article = rs.getString("sap_article");
                    sap_article_name = rs.getString("sap_article_name");
                    sap_article_unit = rs.getString("sap_article_unit");

                    line = pgroup + "\t" + pcode + "\t" + pdesc + "\t" + sap_article + "\t" + sap_article_name + "\t" + sap_article_unit;
                    str.append(line + "\n");
                } while (rs.next());
                us.writeFile(parthFile, str);
            }
        } catch (Exception e) {
            new showMessage().showMessageError(e.getMessage(), "exportProductMapping");
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
