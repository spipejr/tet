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
import utilititiesfunction.PUtility;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class databeanMasterfile2 {
    private String code;
    private String name;
    private String deptcode ;
    private String deptname ;
    
    private static dbUtility db = new dbUtility();
    public static ThaiUtilities cvth = new ThaiUtilities();

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
    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public databeanMasterfile2(String code, String name,String deptcode,String deptname) {
        this.code = code;
        this.name = name;
        this.deptcode = deptcode ;
        this.deptname = deptname ;
    }
    
    
    public static Collection<databeanMasterfile2> getGroupfile2(){

        Statement stmt = null;
        ResultSet rs = null;
        Collection<databeanMasterfile2> col = new ArrayList();
        try {
            if(!db.Char_Set.equalsIgnoreCase("utf-8"))
            {
            stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from groupfile order by groupcode" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new databeanMasterfile2(cvth.ASCII2Unicode(rs.getString("groupcode")),
                        cvth.ASCII2Unicode(rs.getString("groupname")),cvth.ASCII2Unicode(rs.getString("deptcode")),
                        cvth.ASCII2Unicode(PUtility.SeekDeptName(rs.getString("deptcode")))));
                count++;
               
            }
            }
            else
            {
             stmt = (Statement) dbUtility.con.createStatement();
            String sql = "select * from groupfile order by groupcode" ;
            rs = stmt.executeQuery(sql);
            int count = 0 ;
            while (rs.next()) {
                col.add(new databeanMasterfile2(rs.getString("groupcode"),
                        rs.getString("groupname"),rs.getString("deptcode"),PUtility.SeekDeptName(rs.getString("deptcode"))));
                count++;
                
            }
            }
        } catch (Exception e) {
        }
        
        return col;
    }
   
}
