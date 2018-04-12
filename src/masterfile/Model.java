/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package masterfile;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author natee
 */
class Model extends DefaultTableModel {
    public static Connection con=null;
    public static String HostName="192.180.180.99";
//    public static String HostName="localhost";
//    public static String HostName="vmshady.no-ip.biz";
    public static String DbName="myborsys";
    public static String UserName="root";
    public static String Password="000000";
    public static String PortNumber="3306";
    public static String Char_Set="latin2";

    Model() {
        JTable table = new JTable(this);
        addColumn("Name");
        addColumn("Address");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root";
//
//            
//            , "root");
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + HostName + ":" + 
                    PortNumber + "/" + DbName+"?characterEncoding=utf-8", UserName, Password);  
            
String query = "select * from branchgroup";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("BGroupCode");
                String address = rs.getString("BGroupName");
                addRow(new Object[]{name, address});
            }
        } catch (Exception e) {
        }
    }
}