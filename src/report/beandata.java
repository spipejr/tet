/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report;


import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import utilititiesfunction.ThaiUtilities;



/**
 *
 * @author natee
 */
public class beandata {
    private String typecode;
    private String typename;
    private String brancode;
    private String branname;
    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public beandata() {
        db = new dbUtility();
        db.dbconnect();
    }

    public beandata(String typecode, String typename, String brancode, String branname) {
        this.typecode = typecode;
        this.typename = typename;
        this.brancode = brancode;
        this.branname = branname;
    }

    public String getBrancode() {
        return brancode;
    }

    public void setBrancode(String brancode) {
        this.brancode = brancode;
    }

    public String getBranname() {
        return branname;
    }

    public void setBranname(String branname) {
        this.branname = branname;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

   
    
    public static Collection<beandata> GetBType(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<beandata> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join btype on branfile.btype = btype.btcode where btype.btcode >= '"+cvth.Unicode2ASCII(from)
                    +"' and btype.btcode <= '"+cvth.Unicode2ASCII(to)+"' order by btype.btcode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("BTCode")),
                        cvth.ASCII2Unicode(rs.getString("BTName")),cvth.ASCII2Unicode(rs.getString("code"))
                        ,cvth.ASCII2Unicode(rs.getString("name"))));
                count++;
            }
            }
            else
            {
             stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join btype on branfile.btype = btype.btcode where btype.btcode >= '"+from
                    +"' and btype.btcode <= '"+to+"' order by btype.btcode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("BTCode"),
                        rs.getString("BTName")
                        ,rs.getString("code")
                        ,rs.getString("name")));
                count++;
            }
            }
        } catch (Exception e) {
        }
        
        return col;
    }
    
    public static Collection<beandata> GetArea(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<beandata> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join area on branfile.barea = area.Code where area.Code >= '"+cvth.Unicode2ASCII(from)
                    +"' and area.Code <= '"+cvth.Unicode2ASCII(to)+"' order by area.Code,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("area.Code")),
                        cvth.ASCII2Unicode(rs.getString("area.Name")),cvth.ASCII2Unicode(rs.getString("branfile.code"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.name"))));
                count++;
            }
            }
            else
            {
                stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join area on branfile.barea = area.Code where area.Code >= '"+from
                    +"' and area.Code <= '"+to+"' order by area.Code,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("area.Code"),
                        rs.getString("area.Name")
                        ,rs.getString("branfile.code")
                        ,rs.getString("branfile.name")));
                count++;
            }
            }
        } catch (Exception e) {
        }
        
        return col;
    }
    
    
    public static Collection<beandata> GetPlane(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<beandata> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join plane on branfile.bplane = plane.Code where plane.Code >= '"+cvth.Unicode2ASCII(from)
                    +"' and plane.Code <= '"+cvth.Unicode2ASCII(to)+"' order by plane.Code,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("plane.Code")),
                        cvth.ASCII2Unicode(rs.getString("plane.Name")),cvth.ASCII2Unicode(rs.getString("branfile.code"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.name"))));
                count++;
            }
            }
            else
            {
                stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join plane on branfile.bplane = plane.Code where plane.Code >= '"+from
                    +"' and plane.Code <= '"+to+"' order by plane.Code,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("plane.Code"),
                        rs.getString("plane.Name")
                        ,rs.getString("branfile.code")
                        ,rs.getString("branfile.name")));
                count++;
            }
            }
        } catch (Exception e) {
        }
        
        return col;
    }
    
    public static Collection<beandata> GetSize(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<beandata> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join size on branfile.bsize = size.Code where size.Code >= '"+cvth.Unicode2ASCII(from)
                    +"' and size.Code <= '"+cvth.Unicode2ASCII(to)+"' order by size.Code,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("size.Code")),
                        cvth.ASCII2Unicode(rs.getString("size.Name")),cvth.ASCII2Unicode(rs.getString("branfile.code"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.name"))));
                count++;
            }
            }
            else
            {
                stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join size on branfile.bsize = size.Code where size.Code >= '"+from
                    +"' and size.Code <= '"+to+"' order by size.Code,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("size.Code"),
                        rs.getString("size.Name")
                        ,rs.getString("branfile.code")
                        ,rs.getString("branfile.name")));
                count++;
            }
            }
        } catch (Exception e) {
        }
        
        return col;
    }
    
    public static Collection<beandata> GetStore(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<beandata> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join store on branfile.bstore = store.Code where store.Code >= '"+cvth.Unicode2ASCII(from)
                    +"' and store.Code <= '"+cvth.Unicode2ASCII(to)+"' order by store.Code,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("store.Code")),
                        cvth.ASCII2Unicode(rs.getString("store.Name")),cvth.ASCII2Unicode(rs.getString("branfile.code"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.name"))));
                count++;
            }
            }
            else
            {
                stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join store on branfile.bstore = store.Code where store.Code >= '"+from
                    +"' and store.Code <= '"+to+"' order by store.Code,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("store.Code"),
                        rs.getString("store.Name")
                        ,rs.getString("branfile.code")
                        ,rs.getString("branfile.name")));
                count++;
            }
            }
        } catch (Exception e) {
        }
        
        return col;
    }
    
    public static Collection<beandata> GetBgroup(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<beandata> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join branchgroup on branfile.bgroup = branchgroup.bgroupcode where branchgroup.bgroupcode >= '"+cvth.Unicode2ASCII(from)
                    +"' and branchgroup.bgroupcode <= '"+cvth.Unicode2ASCII(to)+"' order by branchgroup.bgroupcode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("branchgroup.bgroupcode")),
                        cvth.ASCII2Unicode(rs.getString("branchgroup.bgroupname"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.code"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.name"))));
                count++;
            }
            }
            else
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join branchgroup on branfile.bgroup = branchgroup.bgroupcode where branchgroup.bgroupcode >= '"+from
                    +"' and branchgroup.bgroupcode <= '"+to+"' order by branchgroup.bgroupcode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("branchgroup.bgroupcode"),
                        rs.getString("branchgroup.bgroupname")
                        ,rs.getString("branfile.code")
                        ,rs.getString("branfile.name")));
                count++;
            }
            }
        } catch (Exception e) {
        }
        
        return col;
    }
    public static Collection<beandata> GetBrand(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<beandata> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join brandfile on branfile.brandcode = brandfile.brandcode where brandfile.brandcode >= '"+cvth.Unicode2ASCII(from)
                    +"' and brandfile.brandcode <= '"+cvth.Unicode2ASCII(to)+"' order by brandfile.brandcode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("brandfile.brandcode")),
                        cvth.ASCII2Unicode(rs.getString("brandfile.brandname"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.code"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.name"))));
                count++;
            }
            }
            else
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join brandfile on branfile.brandcode = brandfile.brandcode where brandfile.brandcode >= '"+from
                    +"' and brandfile.brandcode <= '"+to+"' order by brandfile.brandcode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("brandfile.brandcode"),
                        rs.getString("brandfile.brandname")
                        ,rs.getString("branfile.code")
                        ,rs.getString("branfile.name")));
                count++;
            }
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return col;
    }
    public static Collection<beandata> GetBustype(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<beandata> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join businesstype on branfile.buscode = businesstype.buscode where branfile.buscode >= '"+cvth.Unicode2ASCII(from)
                    +"' and branfile.buscode <= '"+cvth.Unicode2ASCII(to)+"' order by branfile.buscode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("branfile.buscode")),
                        cvth.ASCII2Unicode(rs.getString("businesstype.busname"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.code"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.name"))));
                count++;
            }
            }
            else
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join businesstype on branfile.buscode = businesstype.buscode where branfile.buscode >= '"+cvth.Unicode2ASCII(from)
                    +"' and branfile.buscode <= '"+cvth.Unicode2ASCII(to)+"' order by branfile.buscode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("branfile.buscode"),
                        rs.getString("businesstype.busname")
                        ,rs.getString("branfile.code")
                        ,rs.getString("branfile.name")));
                count++;
            }
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return col;
    }
    
    public static Collection<beandata> GetCompany(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<beandata> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join company on branfile.companycode = company.code where branfile.companycode >= '"+cvth.Unicode2ASCII(from)
                    +"' and branfile.companycode <= '"+cvth.Unicode2ASCII(to)+"' order by branfile.companycode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("branfile.companycode")),
                        cvth.ASCII2Unicode(rs.getString("company.name"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.code"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.name"))));
                count++;
            }
            }
            else
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join company on branfile.companycode = company.code where branfile.companycode >= '"+from
                    +"' and branfile.companycode <= '"+to+"' order by branfile.companycode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("branfile.companycode"),
                        rs.getString("company.name")
                        ,rs.getString("branfile.code")
                        ,rs.getString("branfile.name")));
                count++;
            }
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return col;
    }
    
    public static Collection<beandata> GetCrArea(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<beandata> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join crarea on branfile.crarea = crarea.code where branfile.crarea >= '"+cvth.Unicode2ASCII(from)
                    +"' and branfile.crarea <= '"+cvth.Unicode2ASCII(to)+"' order by branfile.crarea,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("branfile.crarea")),
                        cvth.ASCII2Unicode(rs.getString("crarea.name"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.code"))
                        ,cvth.ASCII2Unicode(rs.getString("branfile.name"))));
                count++;
            }
            }
            else
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join crarea on branfile.crarea = crarea.code where branfile.crarea >= '"+from
                    +"' and branfile.crarea <= '"+to+"' order by branfile.crarea,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("branfile.crarea"),
                        rs.getString("crarea.name")
                        ,rs.getString("branfile.code")
                        ,rs.getString("branfile.name")));
                count++;
            }
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        }
        
        return col;
    }
    
    public static Collection<beandata> GetCampaign(String from , String to){

        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        Statement stmt2 = null;
        Collection<beandata> col = new ArrayList();
        try {
            
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            int count = 0 ;
            stmt2 = (Statement) dbUtility.con.createStatement();
            String sql2 = "SELECT * FROM campaignfile cam inner join cupon on cam.campaign_code = cupon.campaign_code where cam.campaign_code >= '"+cvth.Unicode2ASCII(from)
                    +"' and cam.campaign_code <= '"+cvth.Unicode2ASCII(to)+"' order by cam.campaign_code,cupon.cucode" ;
            rs2 = stmt2.executeQuery(sql2);
            while (rs2.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs2.getString("cam.campaign_code")),
                        cvth.ASCII2Unicode(rs2.getString("cam.campaign_name"))
                        ,cvth.ASCII2Unicode(rs2.getString("cupon.cucode"))
                        ,cvth.ASCII2Unicode(rs2.getString("cupon.cuname"))+" (Coupon)"));
                count++;
            }    
                
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "SELECT * FROM campaignfile cam inner join protab on cam.campaign_code = protab.campaign_code where cam.campaign_code >= '"+cvth.Unicode2ASCII(from)
                    +"' and cam.campaign_code <= '"+cvth.Unicode2ASCII(to)+"' order by cam.campaign_code,protab.procode" ;
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                col.add(new beandata(cvth.ASCII2Unicode(rs.getString("cam.campaign_code")),
                        cvth.ASCII2Unicode(rs.getString("cam.campaign_name"))
                        ,cvth.ASCII2Unicode(rs.getString("protab.procode"))
                        ,cvth.ASCII2Unicode(rs.getString("protab.prodesc"))+" (Promotion)"));
                count++;
            }
            
            
            }
            else
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join crarea on branfile.crarea = crarea.code where branfile.crarea >= '"+from
                    +"' and branfile.crarea <= '"+to+"' order by branfile.crarea,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new beandata(rs.getString("branfile.crarea"),
                        rs.getString("crarea.name")
                        ,rs.getString("branfile.code")
                        ,rs.getString("branfile.name")));
                count++;
            }
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return col;
    }
}

