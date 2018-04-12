/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author thanet
 */
public class dbUtility {
    public static Connection con=null;
    public static String HostName="localhost";
    public static String DbName="myborsys";
    public static String UserName="root";
    public static String Password="000000";
    public static String PortNumber="3306";
    public static String Char_Set="latin1";
    String chkpath = "";
    public void dbconnect() {
        try {
            String chkos = System.getProperty("os.name").toString().toLowerCase();
            if (chkos.equalsIgnoreCase("linux")) {
                chkpath = "";
            } else {
                chkpath = "C:";
            }
            getDbVar();
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + HostName + ":" + 
                    PortNumber + "/" + DbName+"?characterEncoding=UTF-8", UserName, Password);   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), 
                    "Database Connection Error !!!", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void getDbVar() {
        File fObject = new File(chkpath+"/spapplication/dbconfig/dbconnectbor.ini");
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File dbconnectbor.ini") ;
            System.exit(0);
        } else {
            try {
                boolean eof = false;
                FileReader file = new FileReader(chkpath+"/spapplication/dbconfig/dbconnectbor.ini");
                BufferedReader buff = new BufferedReader(file);

                while (!eof) {
                    String line = buff.readLine();
                    if (line == null) {
                        eof = true;
                    } else {
                        if (!line.equals("")) {
                            String TempStr = line;
                            if (TempStr.substring(0, 1).equals("1")) {
                                HostName = TempStr.substring(2);
                            }
                            if (TempStr.substring(0, 1).equals("2")) {
                                DbName = TempStr.substring(2);
                            }
                            if (TempStr.substring(0, 1).equals("3")) {
                                UserName = TempStr.substring(2);
                            }
                            if (TempStr.substring(0, 1).equals("4")) {
                                Password = TempStr.substring(2);
                            }
                            if (TempStr.substring(0, 1).equals("5")) {
                                PortNumber = TempStr.substring(2);
                            }
                            if (TempStr.substring(0, 1).equals("6")) {
                                Char_Set = TempStr.substring(2);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
