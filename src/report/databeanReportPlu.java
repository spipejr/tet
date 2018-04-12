/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import dbutility.dbUtility;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import javax.swing.JOptionPane;
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class databeanReportPlu {
    private String code;
    private String name;
    private String gcode;
    private String gname;
    private String other1;
    private String other2;
    private String other3;
    private String other4;
    private String other5;
    private String other6;
    private String other7;
    private String other8;
    private String other9;
    private String other10;
    private static DecimalFormat DoubleFmt2 = new DecimalFormat("##,###,##0.0000");
    private static dbUtility db = new dbUtility();
    public static ThaiUtilities cvth = new ThaiUtilities();
    private static SimpleDateFormat dateTimeFmtSave = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    private static SimpleDateFormat dateTimeFmtShow = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);

    public databeanReportPlu() {
        db.dbconnect();
    }

    public databeanReportPlu(String code, String name, String gcode, String gname, String other1, String other2, String other3, String other4, String other5, String other6, String other7, String other8, String other9, String other10) {
        this.code = code;
        this.name = name;
        this.gcode = gcode;
        this.gname = gname;
        this.other1 = other1;
        this.other2 = other2;
        this.other3 = other3;
        this.other4 = other4;
        this.other5 = other5;
        this.other6 = other6;
        this.other7 = other7;
        this.other8 = other8;
        this.other9 = other9;
        this.other10 = other10;
    }

    public databeanReportPlu(String code, String name, String gcode, String gname, String other1, String other2, String other3, String other4, String other5, String other6, String other7) {
        this.code = code;
        this.name = name;
        this.gcode = gcode;
        this.gname = gname;
        this.other1 = other1;
        this.other2 = other2;
        this.other3 = other3;
        this.other4 = other4;
        this.other5 = other5;
        this.other6 = other6;
        this.other7 = other7;
    }

    public databeanReportPlu(String code, String name, String gcode, String gname, String other2, String other3, String other4, String other5, String other6) {
        this.code = code;
        this.name = name;
        this.gcode = gcode;
        this.gname = gname;
        this.other2 = other2;
        this.other3 = other3;
        this.other4 = other4;
        this.other5 = other5;
        this.other6 = other6;
    }
     
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther10() {
        return other10;
    }

    public void setOther10(String other10) {
        this.other10 = other10;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4;
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5;
    }

    public String getOther6() {
        return other6;
    }

    public void setOther6(String other6) {
        this.other6 = other6;
    }

    public String getOther7() {
        return other7;
    }

    public void setOther7(String other7) {
        this.other7 = other7;
    }

    public String getOther8() {
        return other8;
    }

    public void setOther8(String other8) {
        this.other8 = other8;
    }

    public String getOther9() {
        return other9;
    }

    public void setOther9(String other9) {
        this.other9 = other9;
    }
    
     public static Collection<databeanReportPlu> getPLUbyType(String Bgroup,String dept1,String dept2,String active1,String active2){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanReportPlu> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from blink b inner join product p on b.pcode = p.pcode inner join groupfile g on p.pgroup = g.groupcode where b.bgroup ='"+cvth.Unicode2ASCII(Bgroup)+"' and pgroup >= '"+cvth.Unicode2ASCII(dept1)+"' and pgroup <= '"+cvth.Unicode2ASCII(dept2)+"'"
                + " and pactive >= '"+active1+"' and pactive <='"+active2+"' order by bgroup,pgroup,pactive,b.pcode";
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
             
            
            
            
            col.add(new databeanReportPlu(cvth.ASCII2Unicode(rs.getString("b.pcode")),
                                            cvth.ASCII2Unicode(rs.getString("pdesc")),
                                            cvth.ASCII2Unicode(rs.getString("pgroup")),
                                            cvth.ASCII2Unicode(rs.getString("groupname")),
                                            cvth.ASCII2Unicode(rs.getString("pactive")),
                                            Format.doubleFmt.format(rs.getDouble("price1")),
                                            Format.doubleFmt.format(rs.getDouble("price2")),
                                            Format.doubleFmt.format(rs.getDouble("price3")),
                                            Format.doubleFmt.format(rs.getDouble("price4")),
                                            Format.doubleFmt.format(rs.getDouble("price5")),
                                            cvth.ASCII2Unicode(rs.getString("promotion1")),
                                            cvth.ASCII2Unicode(rs.getString("promotion2")),
                                            cvth.ASCII2Unicode(rs.getString("promotion3")),
                                            Format.dateFmtShow.format(rs.getDate("lastup"))
                                            ));
            }
            }
            else
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from blink b inner join product p on b.pcode = p.pcode inner join groupfile g on p.pgroup = g.groupcode where b.bgroup ='"+Bgroup+"' and pgroup >= '"+dept1+"' and pgroup <= '"+dept2+"'"
                + "and pactive >= '"+active1+"' and pactive <='"+active2+"' order by bgroup,pgroup,pactive,b.pcode";
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                
            
            
            col.add(new databeanReportPlu(rs.getString("b.pcode"),
                                            rs.getString("pdesc"),
                                            rs.getString("pgroup"),
                                            rs.getString("groupname"),
                                            rs.getString("pactive"),
                                            Format.doubleFmt.format(rs.getDouble("price1")),
                                            Format.doubleFmt.format(rs.getDouble("price2")),
                                            Format.doubleFmt.format(rs.getDouble("price3")),
                                            Format.doubleFmt.format(rs.getDouble("price4")),
                                            Format.doubleFmt.format(rs.getDouble("price5")),
                                            rs.getString("promotion1"),
                                            rs.getString("promotion2"),
                                            rs.getString("promotion3"),
                                            Format.dateFmtShow.format(rs.getDate("lastup"))
                                            ));
            }
                
                
                
                
                
            }
        } catch (Exception e) {
        }
        
        return col;
    }
     
     public static Collection<databeanReportPlu> getPosUser(String b1 , String b2){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanReportPlu> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from posuser "
                    + "left join branfile on posuser.macno = branfile.code "
                    + "where macno>='"+cvth.Unicode2ASCII(b1)+"' and macno<='"+cvth.Unicode2ASCII(b2)+"' order by macno";
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
             
            
            
            
            col.add(new databeanReportPlu(  cvth.ASCII2Unicode(rs.getString("posuser.name")),
                                            cvth.ASCII2Unicode(rs.getString("username")),
                                            cvth.ASCII2Unicode(rs.getString("macno")),
                                            cvth.ASCII2Unicode(rs.getString("branfile.name")),
                                            "",
                                            cvth.ASCII2Unicode(rs.getString("password")),
                                            cvth.ASCII2Unicode(rs.getString("usergroup")),
                                            dateTimeFmtShow.format(dateTimeFmtSave.parse(rs.getString("lastchangepassword"))),
                                            cvth.ASCII2Unicode(rs.getString("branchchange")),
                                            "",
                                            "",
                                            "",
                                            "",
                                            ""
                                            ));
            }
            }
            else
            {
                stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from posuser "
                    + "left join branfile on posuser.macno = branfile.code "
                    + "where macno>='"+cvth.Unicode2ASCII(b1)+"' and macno<='"+cvth.Unicode2ASCII(b2)+"' order by macno";
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
             
            col.add(new databeanReportPlu(  rs.getString("posuser.name"),
                                            rs.getString("username"),
                                            rs.getString("macno"),
                                            rs.getString("branfile.name"),
                                            "",
                                            rs.getString("password"),
                                            rs.getString("usergroup"),
                                            dateTimeFmtShow.format(dateTimeFmtSave.parse(rs.getString("lastchangepassword"))),
                                            rs.getString("branchchange"),
                                            "",
                                            "",
                                            "",
                                            "",
                                            ""
                                            ));
            }
                
            }
        } catch (Exception e) {
        }
        
        return col;
    }
     public static Collection<databeanReportPlu> getBorUser(){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanReportPlu> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from boruserlinux ";
                   
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
             
            
            
            
            col.add(new databeanReportPlu(  cvth.ASCII2Unicode(rs.getString("name")),
                                            cvth.ASCII2Unicode(rs.getString("username")),
                                            "",
                                            "",
                                            "",
                                            cvth.ASCII2Unicode(rs.getString("password")),
                                            cvth.ASCII2Unicode(rs.getString("usergroup")),
                                            dateTimeFmtShow.format(dateTimeFmtSave.parse(rs.getString("lastchangepassword"))),
                                            "",
                                            "",
                                            "",
                                            "",
                                            "",
                                            ""
                                            ));
            }
            }
            else
            {
                stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from boruserlinux ";
                   
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
             
            
            
            
            col.add(new databeanReportPlu(  rs.getString("name"),
                                            rs.getString("username"),
                                            "",
                                            "",
                                            "",
                                            rs.getString("password"),
                                            rs.getString("usergroup"),
                                            dateTimeFmtShow.format(dateTimeFmtSave.parse(rs.getString("lastchangepassword"))),
                                            "",
                                            "",
                                            "",
                                            "",
                                            "",
                                            ""
                                            ));
            }
                
            }
        } catch (Exception e) {
        }
        
        return col;
    }
     
     public static Collection<databeanReportPlu> getMenuList(){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanReportPlu> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select menucode,menuitem,plucode,pdesc,pprice11,menuactive from "
                + "menulist left join product on plucode = pcode "
                + "order by menucode,menuitem";
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
            
            col.add(new databeanReportPlu(  cvth.ASCII2Unicode(rs.getString("menuitem")),
                                            cvth.ASCII2Unicode(rs.getString("plucode")),
                                            cvth.ASCII2Unicode(rs.getString("menucode")),
                                            "",
                                            "",
                                            cvth.ASCII2Unicode(rs.getString("pdesc")),
                                            cvth.ASCII2Unicode(rs.getString("pprice11")),
                                            cvth.ASCII2Unicode(rs.getString("menuactive")),
                                            "",
                                            "",
                                            "",
                                            "",
                                            "",
                                            ""
                                            ));
            }
            }
            else
            {
               stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select menucode,menuitem,plucode,pdesc,pprice11,menuactive from "
                + "menulist left join product on plucode = pcode "
                + "order by menucode";
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
            
            col.add(new databeanReportPlu(  rs.getString("menuitem"),
                                            rs.getString("plucode"),
                                            rs.getString("menucode"),
                                            "",
                                            "",
                                            rs.getString("pdesc"),
                                            rs.getString("pprice11"),
                                            rs.getString("menuactive"),
                                            "",
                                            "",
                                            "",
                                            "",
                                            "",
                                            ""
                                            ));
            }
                
            }
        } catch (Exception e) {
        }
        
        return col;
    }
     
     public static Collection<databeanReportPlu> getPLU(String dept1,String dept2,String active1,String active2){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanReportPlu> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from product p inner join groupfile g on p.pgroup = g.groupcode where pgroup >= '"+cvth.Unicode2ASCII(dept1)+"' and pgroup <= '"+cvth.Unicode2ASCII(dept2)+"'"
                + " and pactive >= '"+active1+"' and pactive <='"+active2+"' order by p.pgroup,pactive,pcode";
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
             
            
            
            
            col.add(new databeanReportPlu(cvth.ASCII2Unicode(rs.getString("pcode")),
                                            cvth.ASCII2Unicode(rs.getString("pdesc")),
                                            cvth.ASCII2Unicode(rs.getString("pgroup")),
                                            cvth.ASCII2Unicode(rs.getString("groupname")),
                                            cvth.ASCII2Unicode(rs.getString("pactive")),
                                            Format.doubleFmt.format(rs.getDouble("pprice11")),
                                            Format.doubleFmt.format(rs.getDouble("pprice12")),
                                            Format.doubleFmt.format(rs.getDouble("pprice13")),
                                            Format.doubleFmt.format(rs.getDouble("pprice14")),
                                            Format.doubleFmt.format(rs.getDouble("pprice15")),
                                            cvth.ASCII2Unicode(rs.getString("pbarcode"))
                                            ));
            }
            }
            else
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from product p inner join groupfile g on p.pgroup = g.groupcode  where pgroup >= '"+cvth.Unicode2ASCII(dept1)+"' and pgroup <= '"+cvth.Unicode2ASCII(dept2)+"'"
                + " and pactive >= '"+active1+"' and pactive <='"+active2+"' order by p.pgroup,pactive,pcode";
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
             
            
            
            
            col.add(new databeanReportPlu(rs.getString("pcode"),
                                            rs.getString("pdesc"),
                                            rs.getString("pgroup"),
                                            rs.getString("groupname"),
                                            rs.getString("pactive"),
                                            Format.doubleFmt.format(rs.getDouble("pprice11")),
                                            Format.doubleFmt.format(rs.getDouble("pprice12")),
                                            Format.doubleFmt.format(rs.getDouble("pprice13")),
                                            Format.doubleFmt.format(rs.getDouble("pprice14")),
                                            Format.doubleFmt.format(rs.getDouble("pprice15")),
                                            rs.getString("pbarcode")
                                            ));
            }
                
                
                
                
                
            }
        } catch (Exception e) {
        }
        
        return col;
    }
     
     
    public static Collection<databeanReportPlu> getIng(String inggroup1,String inggroup2,String ing1,String ing2){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanReportPlu> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            db.dbconnect();
            stmt = (Statement) db.con.createStatement();
            
            String sql ="select i.incode as code,i.inname as name,m.*,i.*,p.* from menusetup m inner join ingredent i on m.incode = i.incode inner join product p on m.menucode=p.pcode "
                        + "where i.ingroup>='"+cvth.ASCII2Unicode(inggroup1)+"' and i.ingroup<='"+cvth.ASCII2Unicode(inggroup2)+"' "
                        + "and i.incode>= '"+cvth.ASCII2Unicode(ing1)+"' and i.incode<='"+cvth.ASCII2Unicode(ing2)+"' order by i.incode,menucode";
            rs = stmt.executeQuery(sql);
            int count = 0 ;
             
                while (rs.next()) {
            double cost = 0;
                double gp = 0;
                    cost = getCost(rs.getString("code"), rs.getString("menucode"));
            
            if(rs.getDouble("pprice11")>0)
            {
                gp = (cost/rs.getDouble("pprice11"));
            }
            else
            {
                gp = 0;
            }
            
            col.add(new databeanReportPlu( cvth.ASCII2Unicode(rs.getString("menucode")),
                                                cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                cvth.ASCII2Unicode(rs.getString("code")),
                                                cvth.ASCII2Unicode(rs.getString("inname")),
                                                Format.integerFmt.format(rs.getInt("inqty")),
                                                cvth.ASCII2Unicode(rs.getString("insubunit")),
                                                Format.doubleFmt.format(cost),
                                                Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                Format.percentFmt.format(gp)
                                            ));
            }
            }
            else
            {
            db.dbconnect();
            stmt = (Statement) db.con.createStatement();
            String sql ="select i.incode as code,i.inname as name,m.*,i.*,p.* from menusetup m inner join ingredent i on m.incode = i.incode inner join product p on m.menucode=p.pcode "
                        + "where i.ingroup>='"+inggroup1+"' and i.ingroup<='"+inggroup2+"' "
                        + "and i.incode>= '"+ing1+"' and i.incode<='"+ing2+"' order by i.incode,menucode";
            rs = stmt.executeQuery(sql);
            int count = 0 ;
             double cost = 0;
                double gp = 0;
                while (rs.next()) {
            cost = getCost(rs.getString("code"), rs.getString("menucode"));
            
            if(rs.getDouble("pprice11")>0)
            {
                gp = (cost/rs.getDouble("pprice11"));
            }
            else
            {
                gp = 0;
            }
            
            
            
            col.add(new databeanReportPlu( cvth.ASCII2Unicode(rs.getString("menucode")),
                                                cvth.ASCII2Unicode(rs.getString("pdesc")),
                                                cvth.ASCII2Unicode(rs.getString("i.incode")),
                                                cvth.ASCII2Unicode(rs.getString("inname")),
                                                Format.integerFmt.format(rs.getInt("inqty")),
                                                cvth.ASCII2Unicode(rs.getString("insubunit")),
                                                Format.doubleFmt.format(cost),
                                                Format.doubleFmt.format(rs.getDouble("pprice11")),
                                                Format.percentFmt.format(gp)
                                            ));
            }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        
        return col;
    }
    
    public static double getCost(String ingCode, String menucode) {

        double Cost = 0;
        double Pack = 0;
        double ans = 0;
        double Qty=0;
        try {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                String sql = "select * from ingredent i inner join menusetup m on i.incode = m.incode where i.InCode='" + ingCode + "' and menucode ='"+menucode+"'";
                Statement stmt = (com.mysql.jdbc.Statement) dbUtility.con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                       
                        
                        Cost = Double.valueOf(rs.getString("InCost"));
                        Pack = Double.valueOf(rs.getString("InPack"));
                        Qty = Double.valueOf(rs.getString("Inqty"));
                        
                       ans = (Cost*Qty)/Pack;
                       
                } 
                rs.close();
                stmt.close();
                
                 }
                 else
                 {
                String sql = "select * from ingredent i inner join menusetup m on i.incode = m.incode where i.InCode='" + ingCode + "' and menucode ='"+menucode+"'";

                Statement stmt = (com.mysql.jdbc.Statement) dbUtility.con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                       
                        Cost = Double.valueOf(rs.getString("InCost"));
                        Pack = Double.valueOf(rs.getString("InPack"));
                        Qty = Double.valueOf(rs.getString("Inqty"));
                        
                        
                       ans = (Cost*Qty)/Pack;
                       
                } 
                rs.close();
                stmt.close();
                 }
            } catch (Exception e) {
            }
       return ans;
    }
}
