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
import utilititiesfunction.Format;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class dataBeanVender {
    private String code;
    private String name;
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
    private String other11;
    private String other12;
    private String other13;
    private String other14;
    private String other15;
    private String other16;
    private String other17;
    private String other18;
    private String other19;
    private String other20;
    private String other21;
    private String other22;
    private String other23;
    private String other24;
    private String other25;
    private static dbUtility db = null;
    public static ThaiUtilities cvth = new ThaiUtilities();
    
    

    public dataBeanVender(String code, String name, String other1, String other2, String other3, String other4, String other5, String other6, String other7, String other8, String other9, String other10, String other11, String other12, String other13, String other14, String other15, String other16, String other17, String other18, String other19, String other20, String other21, String other22, String other23, String other24, String other25) {
        this.code = code;
        this.name = name;
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
        this.other11 = other11;
        this.other12 = other12;
        this.other13 = other13;
        this.other14 = other14;
        this.other15 = other15;
        this.other16 = other16;
        this.other17 = other17;
        this.other18 = other18;
        this.other19 = other19;
        this.other20 = other20;
        this.other21 = other21;
        this.other22 = other22;
        this.other23 = other23;
        this.other24 = other24;
        this.other25 = other25;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getOther11() {
        return other11;
    }

    public void setOther11(String other11) {
        this.other11 = other11;
    }

    public String getOther12() {
        return other12;
    }

    public void setOther12(String other12) {
        this.other12 = other12;
    }

    public String getOther13() {
        return other13;
    }

    public void setOther13(String other13) {
        this.other13 = other13;
    }

    public String getOther14() {
        return other14;
    }

    public void setOther14(String other14) {
        this.other14 = other14;
    }

    public String getOther15() {
        return other15;
    }

    public void setOther15(String other15) {
        this.other15 = other15;
    }

    public String getOther16() {
        return other16;
    }

    public void setOther16(String other16) {
        this.other16 = other16;
    }

    public String getOther17() {
        return other17;
    }

    public void setOther17(String other17) {
        this.other17 = other17;
    }

    public String getOther18() {
        return other18;
    }

    public void setOther18(String other18) {
        this.other18 = other18;
    }

    public String getOther19() {
        return other19;
    }

    public void setOther19(String other19) {
        this.other19 = other19;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getOther20() {
        return other20;
    }

    public void setOther20(String other20) {
        this.other20 = other20;
    }

    public String getOther21() {
        return other21;
    }

    public void setOther21(String other21) {
        this.other21 = other21;
    }

    public String getOther22() {
        return other22;
    }

    public void setOther22(String other22) {
        this.other22 = other22;
    }

    public String getOther23() {
        return other23;
    }

    public void setOther23(String other23) {
        this.other23 = other23;
    }

    public String getOther24() {
        return other24;
    }

    public void setOther24(String other24) {
        this.other24 = other24;
    }

    public String getOther25() {
        return other25;
    }

    public void setOther25(String other25) {
        this.other25 = other25;
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
    
     public static Collection<dataBeanVender> getVender(){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<dataBeanVender> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from vender order by vcode" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new dataBeanVender(cvth.ASCII2Unicode(rs.getString("vcode")),
                        cvth.ASCII2Unicode(rs.getString("VName")),
                        cvth.ASCII2Unicode(rs.getString("Vaddress")),
                        cvth.ASCII2Unicode(rs.getString("VSubProvince")),
                        cvth.ASCII2Unicode(rs.getString("VProvince")),
                        cvth.ASCII2Unicode(rs.getString("VCity")),
                        cvth.ASCII2Unicode(rs.getString("VPost")),
                        cvth.ASCII2Unicode(rs.getString("VTel")),
                        cvth.ASCII2Unicode(rs.getString("VFax")),
                        cvth.ASCII2Unicode(rs.getString("VEmail")),
                        cvth.ASCII2Unicode(rs.getString("VBusType")),
                        Format.dateFmtShow.format(rs.getDate("VBusBegin")),
                        Format.integerFmt.format(rs.getFloat("VBusAssi")),
                        cvth.ASCII2Unicode(rs.getString("VVatNo")),
                        cvth.ASCII2Unicode(rs.getString("VTaxNo")),
                        cvth.ASCII2Unicode(rs.getString("VCrTerm")),
                        Format.doubleFmt.format(rs.getFloat("VCrAmount")),
                        cvth.ASCII2Unicode(rs.getString("VPayType")),
                        cvth.ASCII2Unicode(rs.getString("VBankAcc")),
                        cvth.ASCII2Unicode(rs.getString("VDiscount")),
                        cvth.ASCII2Unicode(rs.getString("VCharge")),
                        cvth.ASCII2Unicode(rs.getString("VContack")),
                        cvth.ASCII2Unicode(rs.getString("VDept")),
                        cvth.ASCII2Unicode(rs.getString("VConPur")),
                        cvth.ASCII2Unicode(rs.getString("VTran")),
                        cvth.ASCII2Unicode(rs.getString("VSendTime")),
                        cvth.ASCII2Unicode(rs.getString("VRemark"))));
                count++;
            }
            }
            else
            {
             stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from vender order by vcode" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new dataBeanVender(rs.getString("vcode"),
                        rs.getString("VName"),
                        rs.getString("Vaddress"),
                        rs.getString("VSubProvince"),
                        rs.getString("VProvince"),
                        rs.getString("VCity"),
                        rs.getString("VPost"),
                        rs.getString("VTel"),
                        rs.getString("VFax"),
                        rs.getString("VEmail"),
                        rs.getString("VBusType"),
                        Format.dateFmtShow.format(rs.getDate("VBusBegin")),
                        Format.integerFmt.format(rs.getFloat("VBusAssi")),
                        rs.getString("VVatNo"),
                        rs.getString("VTaxNo"),
                        rs.getString("VCrTerm"),
                        Format.doubleFmt.format(rs.getFloat("VCrAmount")),
                        rs.getString("VPayType"),
                        rs.getString("VBankAcc"),
                        rs.getString("VDiscount"),
                        rs.getString("VCharge"),
                        rs.getString("VContack"),
                        rs.getString("VDept"),
                        rs.getString("VConPur"),
                        rs.getString("VTran"),
                        rs.getString("VSendTime"),
                        rs.getString("VRemark")));
                count++;
            }
            }
        } catch (Exception e) {
        }
        
        return col;
    }
    
}
