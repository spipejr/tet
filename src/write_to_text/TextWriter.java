/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package write_to_text;

import directory_utility.DirectoryUtility;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class TextWriter {

    public static void main(String[] args) {
        try {

            TextWriter tw = new TextWriter();
            for (int i = 0; i < 10; i++) {
                tw.writeToText("/root/AAA/BBB/CCC/DDD/new.txt", "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i);
            }
            tw.writeToText("/root/กลอน Test.txt", "อยาก delete แฟนเธอไป , แล้วลองใส่ หัวใจเรา , Format เธอให้ลืมเขา , upgrate เราใส่ใจเธอ ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToText(String pathFile, String data) {
        //System.out.println("write log: "+data);
    
        FileWriter writer = null;
        try {
            writer = new FileWriter(new DirectoryUtility().getFileAndCreateDir(pathFile), true);
//            writer.write((data == null ? "" : data));
            writer.write((data));
            writer.write(13);
            writer.write(10);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Write File!");
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }

    }
    public void writeToTextAscii(String pathFile, String data) {
        //System.out.println("write log: "+data);
        try {
            // output : Unicode to Cp850 (MS-DOS Latin-1)
            FileOutputStream fos = new FileOutputStream(new DirectoryUtility().getFileAndCreateDir(pathFile), true);
            Writer w =
                    new BufferedWriter(new OutputStreamWriter(fos, "TIS-620"));
            w.write(data);
            w.flush();
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
