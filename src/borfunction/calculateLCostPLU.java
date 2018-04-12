/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package borfunction;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import dbutility.dbUtility;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import utilititiesfunction.PUtility;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author s386
 */
public class calculateLCostPLU {

   
         
        private static Statement stmt;
       private static ThaiUtilities cvth = new ThaiUtilities();
        public static double calculatecost(String PLUcode)
        {
         double cost = 0;
         double pack = 0;
         double qty = 0;
         double  total = 0 ;
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
            try {
                 stmt = (Statement) dbUtility.con.createStatement();
                String sqlmenuplu = "select * from menusetup inner join ingredent on menusetup.incode = ingredent.incode where menucode = '"+cvth.Unicode2ASCII(PLUcode) +"'";
                  ResultSet rsmenuplu = stmt.executeQuery(sqlmenuplu);
                  while(rsmenuplu.next())
                  {
                  qty = Double.valueOf(rsmenuplu.getString("inqty"));
                  cost = Double.valueOf(rsmenuplu.getString("incost"));
                  pack = Double.valueOf(rsmenuplu.getString("inpack"));
                  total += (cost*qty)/pack;
                  }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            }
            else
            {
                 try {
                 stmt = (Statement) dbUtility.con.createStatement();
                String sqlmenuplu = "select * from menusetup inner join ingredent on menusetup.incode = ingredent.incode where menucode = '"+PLUcode +"'";
                  ResultSet rsmenuplu = stmt.executeQuery(sqlmenuplu);
                  while(rsmenuplu.next())
                  {
                  qty = Double.valueOf(rsmenuplu.getString("inqty"));
                  cost = Double.valueOf(rsmenuplu.getString("incost"));
                  pack = Double.valueOf(rsmenuplu.getString("inpack"));
                  total += (cost*qty)/pack;
                  }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            }
    
          return total;
        }
        public static void updatecostPLU(String PLUcode,double cost)
        {
         
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
            try {
                 String sqlplu = "update product set plcost = ? where pcode = ?";
                  PreparedStatement prm = (PreparedStatement) dbUtility.con.prepareStatement(sqlplu);
                  prm.setDouble(1, cost);
                  prm.setString(2, cvth.Unicode2ASCII(PLUcode));
                  prm.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            }
            else
            {
                 try {
                String sqlplu = "update product set plcost = ? where pcode = ?";
                  PreparedStatement prm = (PreparedStatement) dbUtility.con.prepareStatement(sqlplu);
                  prm.setDouble(1, cost);
                  prm.setString(2, PLUcode);
                  prm.executeUpdate();
                     
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            }
    
        }
        public static void updatePsetselectqtyPLU(String PLUcode,int qty)
        {
         
            if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
            try {
                 String sqlplu = "update product set psetselectqty = ? where pcode = ?";
                  PreparedStatement prm = (PreparedStatement) dbUtility.con.prepareStatement(sqlplu);
                  prm.setInt(1, qty);
                  prm.setString(2, cvth.Unicode2ASCII(PLUcode));
                  prm.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            }
            else
            {
                 try {
                String sqlplu = "update product set psetselectqty = ? where pcode = ?";
                  PreparedStatement prm = (PreparedStatement) dbUtility.con.prepareStatement(sqlplu);
                  prm.setInt(1, qty);
                  prm.setString(2, PLUcode);
                  prm.executeUpdate();
                     
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            }
    
        }
}
