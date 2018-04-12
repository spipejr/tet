/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
public class btype {
    private String typecode;
    private String typename;
    private String brancode;
    private String branname;
    dbUtility dbcon = null;
    public static ThaiUtilities cvth = new ThaiUtilities();

    public btype() {
        dbcon = new dbUtility();
        dbcon.dbconnect();
    }

    public btype(String typecode, String typename, String brancode, String branname) {
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

   
    
    public static Collection<btype> GetData2(String from , String to){
//        Collection<btype> col = new ArrayList();
//        col.add(new btype("BTCode","BTName"));
        Statement stmt = null;
        ResultSet rs = null;
        Collection<btype> col = new ArrayList();
        try {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from branfile inner join btype on branfile.btype = btype.btcode where btype.btcode >= '"+cvth.Unicode2ASCII(from)
                    +"' and btype.btcode <= '"+cvth.Unicode2ASCII(to)+"' order by btype.btcode,branfile.code" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new btype(cvth.ASCII2Unicode(rs.getString("BTCode")),
                        cvth.ASCII2Unicode(rs.getString("BTName")),cvth.ASCII2Unicode(rs.getString("code"))
                        ,cvth.ASCII2Unicode(rs.getString("name"))));
                count++;
            }
        } catch (Exception e) {
        }
        
        return col;
    }
    
}

