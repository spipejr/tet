package system.os.utility;

import dbutility.dbUtility;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClassPath {

    dbUtility db = new dbUtility();
    Statement stmt;
    //check os
    public static String OS = System.getProperty("os.name").toLowerCase();
    public static String backuppath = "";
    public static String datapath = "";
    public static String serverpath = "";
    public static String serverpathfg = "";
    public static String PathTemp = "";
    public static String PathConvert = "" ;
    public static String PATHFIX = "";
    public static String PATH = "";
    //operator system
    public static String ROOT = "";
    public static String TMP = "";
    public  static String comp = "" ;

    public void  ClassPath() {
        if (OS.equalsIgnoreCase("linux")) {
            PATH = "/";
        } else {
            PATH = "C:/";
        }
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
            comp = addr.getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClassPath.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.dbconnect();
        ResultSet rs = null;
        try {
            stmt = (Statement) db.con.createStatement();
            String sql = "select * from borpathsetup";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if (OS.equalsIgnoreCase("linux")) {
                    backuppath = rs.getString("backuppath");
                    datapath = rs.getString("datapath");
                    serverpath = rs.getString("serverpath");
                    serverpathfg = rs.getString("serverpathfg");
                    PathTemp = "/spapplication/temp";
                    PathConvert = "/spapplication/tempconvert";
                } else {
                    backuppath = rs.getString("backuppath_w");
                    datapath = rs.getString("datapath_w");
                    serverpath = rs.getString("serverpath_w");
                    serverpathfg = rs.getString("serverpathfg_w");
                    PathTemp = "C:/spapplication/temp";
                    PathConvert = "C:/spapplication/tempconvert";
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
    }
}
