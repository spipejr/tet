package utilititiesfunction;

import directory_utility.DirectoryUtility;
import java.io.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Surapol
 */
public class ThaiUtilities {
         public String Unicode2ASCII(String unicode) { // แปลง Unicode เป็น ASCII 
             if(unicode==null) {
                 return "" ;
             }
                StringBuffer ascii = new StringBuffer(unicode); // กำหนดพื้นที่ใช้งานชั่วคราว
                int code;
                for(int i = 0; i < unicode.length(); i++) { // ลูปเท่าจำนวนตัวอักษร
                        code = (int)unicode.charAt(i); // อ่านค่ารหัสที่ละตัวอักษร
                        if ((0xE01<=code) && (code <= 0xE5B )) // ตรวจสอบว่าอยู่ในช่วงภาษาไทยของ Unicode หรือไม่
                            ascii.setCharAt( i, (char)(code - 0xD60)); // หากใช้แปลงเป็นภาษาไทยในช่วงของ ASCII
                }
                return ascii.toString(); // แปลงข้อมูลกลับไปเป็นแบบ String เพื่อใช้งานต่อไป
        }

        public String ASCII2Unicode(String ascii) {
            if(ascii==null) {
                return "" ;
            }
                StringBuffer unicode = new StringBuffer(ascii);
                int code;
                for(int i = 0; i < ascii.length(); i++) {
                        code = (int)ascii.charAt(i);
                        if ((0xA1 <= code) && (code <= 0xFB)) // ตรวจสอบว่าอยู่ในช่วงภาษาไทยของ ASCII หรือไม่
                                unicode.setCharAt( i, (char)(code + 0xD60)); // หากใช้แปลงเป็นภาษาไทยในช่วงของ Unicode
                }
                return unicode.toString(); // แปลงข้อมูลกลับไปเป็นแบบ String เพื่อใช้งานต่อไป
        }
        
        public void ConverCharSet(String inFile, String inCharsetName, String outFile, String outCharsetName) {
            DirectoryUtility dirUtil = new DirectoryUtility();
            try {
                dirUtil.getFileAndCreateDir(outFile);
            } catch (Exception ex) {
            }
            try {
               
                InputStreamReader in = new InputStreamReader(
                        new FileInputStream(inFile), inCharsetName);
                OutputStreamWriter out = new OutputStreamWriter(
                        new FileOutputStream(outFile), outCharsetName);
                int c = in.read();
                int n = 0;
                while (c != -1) {
                    out.write(c);
                    n++;
                    c = in.read();
                }
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
      }
       public void ConverCharSet2(String inFile, String inCharsetName, String outFile, String outCharsetName) {
       
        }
        public void copyfile(String srFile, String dtFile) {
            try {
                File f1 = new File(srFile);
                File f2 = new File(dtFile);
                InputStream in = new FileInputStream(f1);
                OutputStream out = new FileOutputStream(f2);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                //System.out.println("File copied.");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage() + " in the specified directory.");
                System.exit(0);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
}


