/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import dbutility.dbUtility;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class processcr extends javax.swing.JDialog {
    dbUtility db = new dbUtility();

    /**
     * Creates new form processcr
     */
    public processcr(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fromactivate() ;
    }
    public void fromactivate() {
        Thread pcr = new Thread(new ProcessCr());
        pcr.start();
    }
    class ProcessCr extends javax.swing.JDialog implements Runnable {
        int maxrec = 0 ;
        int currec = 0 ;
        public void run() {
            //Terminal
            maxrec = 0 ;
            currec = 0 ;
            try {
                Statement stmt = (Statement) dbUtility.con.createStatement();
                String SqlQuery = "delete from tempcr " ;
                stmt.executeUpdate(SqlQuery);
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            try {
                Statement stmt = (Statement) dbUtility.con.createStatement();
                String SqlQuery = "insert into tempcr "
                        + "select s.s_bran,s.s_date,b_macno,count(*),sum(b_cramt1) from s_credit s "
                        + "inner join dterminal d on s.s_bran=d.s_bran and s.s_date=d.t_date and s.b_macno=d.t_macno "
                        + "where misc=0 "
                        + "group by s.s_bran,s.s_date,b_macno ";
                stmt.executeUpdate(SqlQuery);
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String SqlQuery = "select *from tempcr "
                    + "order by s_bran,s_date,macno";
            ResultSet rec = stmt.executeQuery(SqlQuery);
            rec.last();
            maxrec = rec.getRow() ;
            currec = 0 ;
            rec.first();
            if (rec.getRow() != 0) {
                do {
                    currec++ ;
                    ProcessStr.setText("(T)Process Rec : "+currec+" / "+maxrec+"    Branch "+rec.getString("s_bran")+" Date "+rec.getString("s_date"));
                    UpdateTerminal(rec.getString("s_bran"),rec.getString("s_date"),rec.getString("macno"),
                            rec.getDouble("cnt"),rec.getDouble("cramt")) ;
                    
                } while (rec.next()) ;
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
            
        //Cashier
        maxrec = 0 ;
        currec = 0 ;
        try {
                Statement stmt = (Statement) dbUtility.con.createStatement();
                String SqlQuery = "delete from tempcr " ;
                stmt.executeUpdate(SqlQuery);
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            try {
                Statement stmt = (Statement) dbUtility.con.createStatement();
                String SqlQuery = "insert into tempcr "
                        + "select s.s_bran,s.s_date,b_cashier,count(*),sum(b_cramt1) from s_credit s "
                        + "inner join dcashier d on s.s_bran=d.s_bran and s.s_date=d.t_date and s.b_cashier=d.t_cashno "
                        + "where misc=0 "
                        + "group by s.s_bran,s.s_date,b_cashier ";
                stmt.executeUpdate(SqlQuery);
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {
            Statement stmt = (Statement) dbUtility.con.createStatement();
            String SqlQuery = "select *from tempcr "
                    + "order by s_bran,s_date,macno";
            ResultSet rec = stmt.executeQuery(SqlQuery);
            rec.last();
            maxrec = rec.getRow() ;
            currec = 0 ;
            rec.first();
            if (rec.getRow() != 0) {
                do {
                    currec++ ;
                    ProcessStr.setText("(C)Process Rec : "+currec+" / "+maxrec+"    Branch "+rec.getString("s_bran")+" Date "+rec.getString("s_date"));
                    UpdateCashier(rec.getString("s_bran"),rec.getString("s_date"),rec.getString("macno"),
                            rec.getDouble("cnt"),rec.getDouble("cramt")) ;
                    
                } while (rec.next()) ;
            }
            rec.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
          
            
            
        JOptionPane.showMessageDialog(null, "จำนวนรายการที่ Update "+currec +"  จบการทำงาน");    
            
        }
        private void UpdateTerminal(String s_bran,String s_date,String macno,double cnt,double cramt) {
            try {
                Statement stmt = (Statement) dbUtility.con.createStatement();
                String SqlQuery = "update dterminal set nmisc=?,misc=? "
                        + "where s_bran=? and t_date=? and t_macno=?";
                PreparedStatement prm = (PreparedStatement) dbUtility.con.prepareStatement(SqlQuery);
                prm.setDouble(1, cnt );
                prm.setDouble(2, cramt);
                prm.setString(3, s_bran);
                prm.setString(4, s_date);
                prm.setString(5, macno);
                prm.executeUpdate(); prm.close();
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        private void UpdateCashier(String s_bran,String s_date,String macno,double cnt,double cramt) {
            try {
                Statement stmt = (Statement) dbUtility.con.createStatement();
                String SqlQuery = "update dcashier set nmisc=?,misc=? "
                        + "where s_bran=? and t_date=? and t_cashno=?";
                PreparedStatement prm = (PreparedStatement) dbUtility.con.prepareStatement(SqlQuery);
                prm.setDouble(1, cnt );
                prm.setDouble(2, cramt);
                prm.setString(3, s_bran);
                prm.setString(4, s_date);
                prm.setString(5, macno);
                prm.executeUpdate(); prm.close();
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProcessStr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("รายการปรับยอดบัตรเครดิต");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProcessStr.setFont(new java.awt.Font("Norasi", 1, 16)); // NOI18N
        ProcessStr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProcessStr.setText("Process Record");
        getContentPane().add(ProcessStr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 100));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-649)/2, (screenSize.height-146)/2, 649, 146);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(processcr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(processcr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(processcr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(processcr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                processcr dialog = new processcr(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ProcessStr;
    // End of variables declaration//GEN-END:variables
}
