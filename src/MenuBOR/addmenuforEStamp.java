package MenuBOR;

import dbutility.dbUtility;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utilititiesfunction.ThaiUtilities;

public class addmenuforEStamp {

    ThaiUtilities cvth = new ThaiUtilities();
    dbUtility db = new dbUtility();

    public addmenuforEStamp() {
        db.dbconnect();
    }

    public void addmenu() {
        if (checkField()) {
            AddBormenu();
        }
        if (checkFieldLinux()) {
            AddBormenulinux();
        }
    }

    private void AddBormenu() {
        //---- Maste File (Mast25 - Mast27)
        String Mast25 = "แฟ้มข้อมูล E-Stamp Campaign"; //mcode = M10710
        String Mast26 = "แฟ้มข้อมูล E-Stamp setting (แจกแสตมป์)"; //mcode = M10711
        String Mast27 = "แฟ้มข้อมูล E-Stamp setting (แลกแสตมป์)"; //mcode = M10712
        String Mast28 = "แฟ้มข้อมูล MovementType (SAP)"; //mcode = M10713
        String Mast29 = "แฟ้มข้อมูลรหัสส่วนลดในการขาย (SAP Mapping)"; //mcode = M10714
        String Mast30 = "แฟ้มข้อมูลธนาคารเพื่อนำเงินสดเข้าระบบ (SAP Mapping)"; //mcode = M10715

        try {
            String sql = "select * from bormenu where (mcode ='M10710' or mcode='M10711' or mcode='M10712' or mcode='M10713' "
                    + "or mcode='M10714' or mcode='M10715') ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() == 0) {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                    String inst = "insert into bormenu(mcode,mdesc) values"
                            + "('M10710','" + cvth.Unicode2ASCII(Mast25) + "' ) ,"
                            + "('M10711','" + cvth.Unicode2ASCII(Mast26) + "' ) ,"
                            + "('M10712','" + cvth.Unicode2ASCII(Mast27) + "' ) ,"
                            + "('M10713','" + cvth.Unicode2ASCII(Mast28) + "' ) ,"
                            + "('M10714','" + cvth.Unicode2ASCII(Mast29) + "' ) ,"
                            + "('M10715','" + cvth.Unicode2ASCII(Mast30) + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                } else {
                    String inst = "insert into bormenu(mcode,mdesc) values"
                            + "('M10710','" + Mast25 + "' ) ,"
                            + "('M10711','" + Mast26 + "' ) ,"
                            + "('M10712','" + Mast27 + "' ) ,"
                            + "('M10713','" + Mast28 + "' ) ,"
                            + "('M10714','" + Mast29 + "' ) ,"
                            + "('M10715','" + Mast30 + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                }
            }
        } catch (Exception e) {
        }

        //---- Tranfer (M308 - M309)
        String Tran8 = "Update Master From SAP"; //mcode = M308
        String Tran9 = "Import CSV File (Mapping SAP master)"; //mcode = M309

        try {
            String sql = "select * from bormenu where (mcode ='M308' or mcode='M309' ) ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() == 0) {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                    String inst = "insert into bormenu(mcode,mdesc) values"
                            + "('M308','" + cvth.Unicode2ASCII(Tran8) + "' ) ,"
                            + "('M309','" + cvth.Unicode2ASCII(Tran9) + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                } else {
                    String inst = "insert into bormenu(mcode,mdesc) values"
                            + "('M308','" + Tran8 + "' ) ,"
                            + "('M309','" + Tran9 + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                }
            }
        } catch (Exception e) {
        }

        //---- Report (Rpt48 - Rpt51)
        String Rpt48 = "รายงานสรุปการแจกและการแลกคะแนน E-Stamp"; //mcode = M40415
        String Rpt49 = "รายงานแสดงรายละเอียดการแจกคะแนน E-Stamp"; //mcode = M40416
        String Rpt50 = "รายงานแสดงรายละเอียดการแลกคะแนน E-Stamp"; //mcode = M40417
        String Rpt51 = "รายงานตรวจสอบการใช้บัตร E-Stamp"; //mcode = M40418

        try {
            String sql = "select * from bormenu where (mcode ='M40415' or mcode='M40416' or mcode='M40417' or mcode='M40418') ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() == 0) {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                    String inst = "insert into bormenu(mcode,mdesc) values"
                            + "('M40415','" + cvth.Unicode2ASCII(Rpt48) + "' ) ,"
                            + "('M40416','" + cvth.Unicode2ASCII(Rpt49) + "' ) ,"
                            + "('M40417','" + cvth.Unicode2ASCII(Rpt50) + "' ) ,"
                            + "('M40418','" + cvth.Unicode2ASCII(Rpt51) + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                } else {
                    String inst = "insert into bormenu(mcode,mdesc) values"
                            + "('M40415','" + Rpt48 + "' ) ,"
                            + "('M40416','" + Rpt49 + "' ) ,"
                            + "('M40417','" + Rpt50 + "' ) ,"
                            + "('M40418','" + Rpt51 + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                }
            }
        } catch (Exception e) {
        }

    }

    private void AddBormenulinux() {
        //---- Maste File (Mast25 - Mast27)
        String Mast25 = "แฟ้มข้อมูล E-Stamp Campaign"; //mcode = M10710
        String Mast26 = "แฟ้มข้อมูล E-Stamp setting (แจกแสตมป์)"; //mcode = M10711
        String Mast27 = "แฟ้มข้อมูล E-Stamp setting (แลกแสตมป์)"; //mcode = M10712
        String Mast28 = "แฟ้มข้อมูล MovementType (SAP)"; //mcode = M10713
        String Mast29 = "แฟ้มข้อมูลรหัสส่วนลดในการขาย (SAP Mapping)"; //mcode = M10714
        String Mast30 = "แฟ้มข้อมูลธนาคารเพื่อนำเงินสดเข้าระบบ (SAP Mapping)"; //mcode = M10715

        try {
            String sql = "select * from bormenulinux where (mcode ='Mast25' or mcode='Mast26' or mcode='Mast27' "
                    + "or mcode='Mast28' or mcode='Mast29' or mcode='Mast30') ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() == 0) {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                    String inst = "insert into bormenulinux(mgroup,mcode,mdesc) values"
                            + "('Masterfile', 'Mast25','" + cvth.Unicode2ASCII(Mast25) + "' ) ,"
                            + "('Masterfile', 'Mast26','" + cvth.Unicode2ASCII(Mast26) + "' ) ,"
                            + "('Masterfile', 'Mast27','" + cvth.Unicode2ASCII(Mast27) + "' ) ,"
                            + "('Masterfile', 'Mast28','" + cvth.Unicode2ASCII(Mast28) + "' ) ,"
                            + "('Masterfile', 'Mast29','" + cvth.Unicode2ASCII(Mast29) + "' ) ,"
                            + "('Masterfile', 'Mast30','" + cvth.Unicode2ASCII(Mast30) + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                } else {
                    String inst = "insert into bormenulinux(mgroup,mcode,mdesc) values"
                            + "('Masterfile', 'Mast25','" + Mast25 + "' ) ,"
                            + "('Masterfile', 'Mast26','" + Mast26 + "' ) ,"
                            + "('Masterfile', 'Mast27','" + Mast27 + "' ) ,"
                            + "('Masterfile', 'Mast28','" + Mast28 + "' ) ,"
                            + "('Masterfile', 'Mast29','" + Mast29 + "' ) ,"
                            + "('Masterfile', 'Mast30','" + Mast30 + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                }
            }
        } catch (Exception e) {
        }

        //---- Tranfer (M308 - M309)
        String Tran8 = "Update Master From SAP"; //mcode = M308
        String Tran9 = "Import CSV File (Mapping SAP master)"; //mcode = M309

        try {
            String sql = "select * from bormenu where (mcode ='Tran8' or mcode='Tran9' ) ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() == 0) {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                    String inst = "insert into bormenulinux(mgroup,mcode,mdesc) values"
                            + "('Transfer', 'Tran8' ,'" + cvth.Unicode2ASCII(Tran8) + "' ) ,"
                            + "('Transfer','Tran9' ,'" + cvth.Unicode2ASCII(Tran9) + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                } else {
                    String inst = "insert into bormenulinux(mgroup,mcode,mdesc) values"
                            + "('Tran8','" + Tran8 + "' ) ,"
                            + "('Tran9','" + Tran9 + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                }
            }
        } catch (Exception e) {
        }

        //---- Report (Rpt48 - Rpt51)
        String Rpt48 = "รายงานสรุปการแจกและการแลกคะแนน E-Stamp"; //mcode = M40415
        String Rpt49 = "รายงานแสดงรายละเอียดการแจกคะแนน E-Stamp"; //mcode = M40416
        String Rpt50 = "รายงานแสดงรายละเอียดการแลกคะแนน E-Stamp"; //mcode = M40417
        String Rpt51 = "รายงานตรวจสอบการใช้บัตร E-Stamp"; //mcode = M40418

        try {
            String sql = "select * from bormenulinux where (mcode ='Rpt48' or mcode='Rpt49' or mcode='Rpt50' or mcode='Rpt51') ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() == 0) {
                if (!dbUtility.Char_Set.equalsIgnoreCase("utf-8")) {
                    String inst = "insert into bormenulinux(mgroup, mcode, mdesc) values"
                            + "('Report', 'Rpt48','" + cvth.Unicode2ASCII(Rpt48) + "' ) ,"
                            + "('Report', 'Rpt49','" + cvth.Unicode2ASCII(Rpt49) + "' ) ,"
                            + "('Report', 'Rpt50','" + cvth.Unicode2ASCII(Rpt50) + "' ) ,"
                            + "('Report', 'Rpt51','" + cvth.Unicode2ASCII(Rpt51) + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                } else {
                    String inst = "insert into bormenulinux(mgroup, mcode, mdesc) values"
                            + "('Report', 'Rpt48','" + Rpt48 + "' ) ,"
                            + "('Report', 'Rpt49','" + Rpt49 + "' ) ,"
                            + "('Report', 'Rpt50','" + Rpt50 + "' ) ,"
                            + "('Report', 'Rpt51','" + Rpt51 + "' ) ";
                    PreparedStatement preUp = dbUtility.con.prepareStatement(inst);
                    preUp.executeUpdate();
                    preUp.close();
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean checkField() {
        boolean have = false;
        try {
            String sql = "select * from borgroup where (M10711!='' or M10712!='' or M10713!='' or M10714!='' or M10715!='' "
                    + "or M40418!='' ) ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() == 0) {
                have = true;
            } else {
                have = true;
            }
        } catch (Exception e) {
            try {
                String all = "ALTER TABLE `borgroup` "
                        + "ADD COLUMN `M10711` CHAR(1)  NOT NULL DEFAULT '0', "
                        + "ADD COLUMN `M10712` CHAR(1)  NOT NULL DEFAULT '0', "
                        + "ADD COLUMN `M10713` CHAR(1)  NOT NULL DEFAULT '0', "
                        + "ADD COLUMN `M10714` CHAR(1)  NOT NULL DEFAULT '0', "
                        + "ADD COLUMN `M10715` CHAR(1)  NOT NULL DEFAULT '0', "
                        + "ADD COLUMN `M40418` CHAR(1)  NOT NULL DEFAULT '0'  ;";
                PreparedStatement preUp = dbUtility.con.prepareStatement(all);
                preUp.executeUpdate();
                preUp.close();
                have = true;
            } catch (Exception ex) {
                have = false;
            }
        }

        return have;
    }

    private boolean checkFieldLinux() {
        boolean have = false;
        try {
            String sql = "select * from borgrouplinux where (Mast26!='' or Mast27!='' or Mast28!='' or Mast29!='' or Mast30!='' "
                    + "or Rpt51!='' ) ";
            PreparedStatement pre = dbUtility.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.first();
            if (rs.getRow() == 0) {
                have = true;
            } else {
                have = true;
            }
        } catch (Exception e) {
            try {
                String all = "ALTER TABLE `borgrouplinux` "
                        + "ADD COLUMN `Mast26` CHAR(1)  NOT NULL DEFAULT '0', "
                        + "ADD COLUMN `Mast27` CHAR(1)  NOT NULL DEFAULT '0', "
                        + "ADD COLUMN `Mast28` CHAR(1)  NOT NULL DEFAULT '0', "
                        + "ADD COLUMN `Mast29` CHAR(1)  NOT NULL DEFAULT '0', "
                        + "ADD COLUMN `Mast30` CHAR(1)  NOT NULL DEFAULT '0', "
                        + "ADD COLUMN `Rpt51` CHAR(1)  NOT NULL DEFAULT '0'  ;";
                PreparedStatement preUp = dbUtility.con.prepareStatement(all);
                preUp.executeUpdate();
                preUp.close();
                have = true;
            } catch (Exception ex) {
                have = false;
            }
        }

        return have;
    }
}
