/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EStamp;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author natee
 */
public class utilityStamp {

    public static String chkpath = "";
    public static String chkos = "";

    public utilityStamp() {
        chkos = System.getProperty("os.name").toString().toLowerCase();
        if (chkos.equalsIgnoreCase("linux")) {
            chkpath = "";
        } else {
            chkpath = "C:";
        }
    }

    public void writeFile(String pathFile, StringBuilder str) {
        try {
            File file = new File(pathFile);
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            BufferedWriter buff = new BufferedWriter(writer);
            buff.append(str);
            buff.flush();
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void haveDirectory(String pathDirec) {
        File f = new File(pathDirec);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    public boolean haveFile(String pathFile) {
        boolean haveFile = false;

        File f = new File(pathFile);
        if (f.exists()) {
            haveFile = true;
        }

        return haveFile;
    }

    public Color colorDisable() {
        return new Color(237, 238, 228);
    }

    public Color colorEnable() {
        return Color.WHITE;
    }
    

    public boolean haveDataTextField(JTextField txt) {
        if (txt.getText().length() <= 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public String addZeroBefore(int num, int value) {
        Integer D = value;
        StringBuffer _strGC;

        D++;
        _strGC = new StringBuffer(D.toString());
        while (_strGC.length() < num) {
            _strGC.insert(0, '0');
        }

        return _strGC.toString();
    }
    
    public void chkCloseMenu() {
        
    }
}
