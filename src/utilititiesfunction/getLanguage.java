/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilititiesfunction;

import directory_utility.DirectoryUtility;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXTreeTable;

/**
 *
 * @author s386
 */
public class getLanguage {

    ThaiUtilities cvth = new ThaiUtilities();
    public int chklang;
    String fFileName = "";
    String fEncoding = "UTF8";
    public String font;
    public int fontsize;
    String chkpath = "";
    String chkos = "";

    public getLanguage() {
        chkos = System.getProperty("os.name").toString().toLowerCase();
        if (chkos.equalsIgnoreCase("linux")) {
            chkpath = "";
        } else {
            chkpath = "C:";
        }
        fFileName = chkpath + "/spapplication/dbconfig/language/default.ini";
    }

    public void ConverCharSet(String inFile, String inCharsetName, String outFile, String outCharsetName) {
        DirectoryUtility dirUtil = new DirectoryUtility();
        try {
            dirUtil.getFileAndCreateDir(outFile);
        } catch (Exception ex) {
            ex.printStackTrace();
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

    public boolean copyFile(String des, String target) {
        boolean RetValues = false;
        new File(target).getParentFile().mkdir();
        if (des.equals(target)) {
            RetValues = true;
        } else {
            try {
                InputStream in = new FileInputStream(des);
                OutputStream out = new FileOutputStream(target);
                long max = 0;
                max = new File(des).length();
                byte[] buf = new byte[1024];
                int len;
                long use = 0;
                while ((len = in.read(buf)) > 0) {
                    use += len;
                    out.write(buf, 0, len);
                    out.flush();
                }
                in.close();
                out.close();
                RetValues = true;
            } catch (Exception e) {
                e.printStackTrace();
                RetValues = false;
            }
        }
        return RetValues;

    }

    public int getChklang() {
        File fObject = new File(chkpath + "/spapplication/dbconfig/language/default.ini");
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File default.ini");
            System.exit(0);
        } else {
            try {
                boolean eof = false;
                FileReader file = new FileReader(chkpath + "/spapplication/dbconfig/language/default.ini");
                BufferedReader buff = new BufferedReader(file);

                while (!eof) {
                    String line = buff.readLine();
                    if (line == null) {
                        eof = true;
                    } else {
                        if (!line.equals("")) {
                            String TempStr = line;
                            chklang = Integer.parseInt(TempStr);
                        }
                    }
                }
                buff.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return chklang;
    }

    public void setChklang(int chklang) {
        File fObject = new File(chkpath + "/spapplication/dbconfig/language/default.ini");
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File default.ini");
            System.exit(0);
        } else {
            try {

                Writer out = new OutputStreamWriter(new FileOutputStream(fFileName), fEncoding);
                try {
                    out.write(chklang + "");
                } finally {
                    out.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public void setTextPopupMenusetTextPop(String FormName, JPopupMenu popup) {
        //JOptionPane.showMessageDialog(null, popup.getName());
        Component[] compo = popup.getComponents();
        for (int i = 0; i < compo.length; i++) {
            if (compo[i] instanceof JMenuItem) {
                String itemname = "";
                itemname = getTextLunguage(FormName, compo[i].getName());
                ((JMenuItem) compo[i]).setText(itemname);
                ((JMenuItem) compo[i]).setFont(new Font(getFont(), Font.PLAIN, getFontsize()));
            }
        }
    }

    public void setText(String FormName, final Container c, int chklang) {
        if (chklang==0) {
            return ;
        }
        File fObject = new File(chkpath + "/spapplication/dbconfig/language/default.ini");
        File fObject2 = new File(chkpath + "/spapplication/dbconfig/language/" + FormName + ".ini");
        File fObject3 = new File(chkpath + "/spapplication/dbconfig/language/font.ini");
        File fObject4 = new File(chkpath + "/spapplication/dbconfig/language/msgerrors.ini");
        if (!fObject.canRead() || !fObject2.canRead() || !fObject3.canRead() || !fObject4.canRead()) {
            JOptionPane.showMessageDialog(null, "Can't Not File : default.ini or " + FormName + ".ini or font.ini or msgerrors.ini System is use Default for program.");
        } else {
            try {
                // setChklang(chklang);
                List Componentlist = getAllComponents(c);

                for (Object comp : Componentlist) {
                    Component com = (Component) comp;
                    String name = "";
                    //JOptionPane.showMessageDialog(null, com.getName());
                    name = getTextLunguage(FormName, com.getName());
                    if (com.getName() != null /*
                             * && com.getName().equals("label1")
                             */) {
                        if (com instanceof JLabel) {

                            ((JLabel) com).setText(name);
                            ((JLabel) com).setFont(new Font(getFont(), getFontStyle(com.getName()), getFontsize(com.getName())));
                        } else if (com instanceof JButton) {
                            ((JButton) com).setText(name);
                            ((JButton) com).setFont(new Font(getFont(), getFontStyle(com.getName()), getFontsize(com.getName())));
                        } else if (com instanceof JTabbedPane) {

                            Component[] compo = ((JTabbedPane) com).getComponents();
                            for (int i = 0; i < compo.length; i++) {

                                if (compo[i] instanceof JPanel) {
                                    String panelname = "";
                                    panelname = getTextLunguage(FormName, com.getName(), i);
                                    ((JTabbedPane) com).setTitleAt(i, panelname);
                                    ((JTabbedPane) com).setFont(new Font(getFont(), Font.BOLD, getFontsize()));

                                }
                            }

                        } else if (com instanceof JPanel) {
                        } else if (com instanceof JCheckBox) {
                            ((JCheckBox) com).setFont(new Font(getFont(), getFontStyle(com.getName()), getFontsize(com.getName())));
                            ((JCheckBox) com).setText(name);



                        } else if (com instanceof JRadioButton) {
                            ((JRadioButton) com).setText(name);
                            ((JRadioButton) com).setFont(new Font(getFont(), getFontStyle(com.getName()), getFontsize(com.getName())));
                        } else if (com instanceof JComboBox) {
                            int count = ((JComboBox) com).getItemCount();
                            ((JComboBox) com).setFont(new Font(getFont(), Font.PLAIN, getFontsize()));
                            ((JComboBox) com).removeAllItems();
                            for (int i = 0; i < count; i++) {
                                String cbolname = "";
                                cbolname = getTextLunguage(FormName, com.getName(), i);
                                ((JComboBox) com).addItem(cbolname);

                            }

                        } else if (com instanceof JMenu) {
                            ((JMenu) com).setText(name);
                            ((JMenu) com).setFont(new Font(getFont(), Font.BOLD, getFontsize()));
                            if (((JMenu) com).getItemCount() > 0) {


                                for (int i = 0; i < ((JMenu) com).getItemCount(); i++) {
                                    Component chkcom = ((JMenu) com).getItem(i);
                                    if ((chkcom != null)) {
                                        String getName = ((JMenu) com).getItem(i).getName();
                                        String Nameb = "";
                                        Nameb = getTextLunguage(FormName, getName);
                                        ((JMenu) com).getItem(i).setText(Nameb);
                                        ((JMenu) com).getItem(i).setFont(new Font(getFont(), Font.PLAIN, getFontsize()));

                                        if (((JMenu) com).getItem(i) instanceof JMenu) {

                                            JMenu test = (JMenu) ((JMenu) com).getItem(i);
                                            if (test.getItemCount() > 0) {
                                                for (int j = 0; j < test.getItemCount(); j++) {
                                                    Component chkcom2 = test.getItem(j);
                                                    if ((chkcom2 != null)) {
                                                        String getNames = test.getItem(j).getName();
                                                        String Namebs = "";
                                                        Namebs = getTextLunguage(FormName, getNames);
                                                        test.getItem(j).setText(Namebs);
                                                        test.getItem(j).setFont(new Font(getFont(), Font.PLAIN, getFontsize()));
                                                    }
                                                }

                                            }
                                        }

                                    }
                                }

                            }
                        } else if (com instanceof JPopupMenu) {
//                            Component[] compo = ((JPopupMenu)com).getComponents();
//                            for (int i = 0; i < compo.length; i++) {
//
//                                if (compo[i] instanceof JMenuItem) {
//                                    String itemname = "";
//                                    itemname = getTextLunguage(FormName, compo[i].getName());
//                                    ((JMenuItem)compo[i]).setText(itemname);
//                                    ((JMenuItem)compo[i]).setFont(new Font(getFont(), Font.PLAIN, getFontsize()));
//                                }
//                            }
                        } else if (com instanceof JTable) {
                            //JOptionPane.showMessageDialog(null, com.getName());
                            ((JTable) com).setShowGrid(true);
                            ((JTable) com).setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                            ((JTable) com).setRowSelectionAllowed(true);
                            ((JTable) com).setBackground(java.awt.Color.WHITE);
                            ((JTable) com).setGridColor(java.awt.Color.gray);
                            ((JTable) com).setRowHeight(20);
                            JTableHeader tbh = ((JTable) com).getTableHeader();
                            tbh.setFont(new Font(getFont(), Font.BOLD, getFontsize()));
                            TableColumnModel tbc = ((JTable) com).getColumnModel();
                            for (int i = 0; i < tbc.getColumnCount(); i++) {
                                String nametbc = getTextLunguage(FormName, com.getName(), i);
                                tbc.getColumn(i).setHeaderValue(nametbc);
                            }
                            //com.getClass().getName();

                        } //                        else if (com instanceof JXTreeTable) {
                        //                            JOptionPane.showMessageDialog(null, com.getName());
                        //                            ((JXTreeTable) com).setShowGrid(true);
                        //                            ((JXTreeTable) com).setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        //                            ((JXTreeTable) com).setRowSelectionAllowed(true);
                        //                            ((JXTreeTable) com).setBackground(java.awt.Color.WHITE);
                        //                            ((JXTreeTable) com).setGridColor(java.awt.Color.gray);
                        //                            ((JXTreeTable) com).setRowHeight(25);
                        //                            JTableHeader tbh = ((JXTreeTable) com).getTableHeader();
                        //                            tbh.setFont(new Font(getFont(), Font.BOLD, getFontsize()));
                        //                            TableColumnModel tbc = ((JXTreeTable) com).getColumnModel();
                        //                            for (int i = 0; i < tbc.getColumnCount(); i++) {
                        //                                String nametbc = getTextLunguage(FormName, com.getName(), i);
                        //                                tbc.getColumn(i).setHeaderValue(nametbc);
                        //                            }
                        //                            //com.getClass().getName();
                        //
                        //                        }
                        else if (com instanceof JTextField) {
                            ((JTextField) com).setFont(new Font(getFont(), Font.BOLD, getFontsize()));
                        }
                    }
                }
                if (c instanceof JFrame) {
                    ((JFrame) c).setTitle(getTitle(FormName));
                } else if (c instanceof JDialog) {
                    ((JDialog) c).setTitle(getTitle(FormName));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    public static List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<Component>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container) {
                compList.addAll(getAllComponents((Container) comp));
            }
        }
        return compList;
    }

    public String getTextLunguage(String FormName, String ComponentName) {
        String inFile = chkpath + "/spapplication/dbconfig/language/" + FormName + ".ini";
        String outFile = chkpath + "/spapplication/dbconfig/languageconvert/" + FormName + ".ini";
        String inCharset = "UTF-8";
        String outCharset = "TIS-620";
        if (!chkos.equalsIgnoreCase("linux")) {
            ConverCharSet(inFile, inCharset, outFile, outCharset);
        } else {
            copyFile(inFile, outFile);
        }
        File fObject = new File(outFile);
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File " + FormName + ".ini");
            System.exit(0);
        } else {
            try {
                boolean eof = false;
                FileReader file = new FileReader(outFile);
                BufferedReader buff = new BufferedReader(file);
                while (!eof) {
                    String line = buff.readLine();
                    if (line == null) {
                        eof = true;
                    } else {
                        if (!line.equals("")) {
                            String TempStr = line;
                            String ArrayStr[] = TempStr.split(":");

                            if (chklang == 3) {
                                if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ComponentName)) {
                                    return ArrayStr[3].toString();
                                }
                            } else if (chklang == 4) {

                                if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ComponentName)) {

                                    return ArrayStr[4].toString();
                                }
                            } else if (chklang == 5) {

                                if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ComponentName)) {

                                    return ArrayStr[5].toString();
                                }
                            } else if (chklang == 6) {
                                if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ComponentName)) {

                                    return ArrayStr[6].toString();
                                }
                            }
                        }
                    }
                }

                buff.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String getTextLunguage(String FormName, String ComponentName, int index) {
        String inFile = chkpath + "/spapplication/dbconfig/language/" + FormName + ".ini";
        String outFile = chkpath + "/spapplication/dbconfig/languageconvert/" + FormName + ".ini";
        String inCharset = "UTF-8";
        String outCharset = "TIS-620";
        if (!chkos.equalsIgnoreCase("linux")) {
            ConverCharSet(inFile, inCharset, outFile, outCharset);
        } else {
            copyFile(inFile, outFile);
        }
        File fObject = new File(outFile);
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File " + FormName + ".ini");
            System.exit(0);
        } else {
            try {
                boolean eof = false;
                FileReader file = new FileReader(outFile);
                BufferedReader buff = new BufferedReader(file);
                String i = index + "";
                while (!eof) {
                    String line = buff.readLine();
                    if (line == null) {
                        eof = true;
                    } else {
                        if (!line.equals("")) {
                            String TempStr = line;
                            String ArrayStr[] = TempStr.split(":");

                            if (chklang == 3) {
                                if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ComponentName) && ArrayStr[2].equals(i)) {
                                    return ArrayStr[3].toString();
                                }
                            } else if (chklang == 4) {

                                if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ComponentName) && ArrayStr[2].equals(i)) {

                                    return ArrayStr[4].toString();
                                }
                            } else if (chklang == 5) {

                                if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ComponentName) && ArrayStr[2].equals(i)) {

                                    return ArrayStr[5].toString();
                                }
                            } else if (chklang == 6) {
                                if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ComponentName) && ArrayStr[2].equals(i)) {

                                    return ArrayStr[6].toString();
                                }
                            }

                        }
                    }

                }

                buff.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String getTitle(String FormName) {
        String inFile = chkpath + "/spapplication/dbconfig/language/" + FormName + ".ini";
        String outFile = chkpath + "/spapplication/dbconfig/languageconvert/" + FormName + ".ini";
        String inCharset = "UTF-8";
        String outCharset = "TIS-620";
        if (!chkos.equalsIgnoreCase("linux")) {
            ConverCharSet(inFile, inCharset, outFile, outCharset);
        } else {
            copyFile(inFile, outFile);
        }
        File fObject = new File(outFile);
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File " + FormName + ".ini");
            System.exit(0);
        } else {
            try {
                boolean eof = false;
                FileReader file = new FileReader(outFile);
                BufferedReader buff = new BufferedReader(file);
                    while (!eof) {
                        String line = buff.readLine();
                        if (line == null) {
                            eof = true;
                        } else {
                            if (!line.equals("")) {
                                String TempStr = line;
                                String ArrayStr[] = TempStr.split(":");

                                if (chklang == 3) {
                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase("Title")) {
                                        return ArrayStr[3].toString();
                                    }
                                } else if (chklang == 4) {

                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase("Title")) {
                                        return ArrayStr[4].toString();
                                    }
                                } else if (chklang == 5) {

                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase("Title")) {
                                        return ArrayStr[5].toString();
                                    }
                                } else if (chklang == 6) {
                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase("Title")) {
                                        return ArrayStr[6].toString();
                                    }
                                }



                            }
                        }
                    }
                
                buff.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String getFont() {
        File fObject = new File(chkpath + "/spapplication/dbconfig/language/font.ini");
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File font.ini");
            System.exit(0);
        } else {
            try {
                boolean eof = false;
                FileReader file = new FileReader(chkpath + "/spapplication/dbconfig/language/font.ini");
                BufferedReader buff = new BufferedReader(file);

                while (!eof) {
                    String line = buff.readLine();
                    if (line == null) {
                        eof = true;
                    } else {
                        if (!line.equals("")) {
                            String TempStr = line;
                            String ArrayStr[] = TempStr.split(":");
                            if (this.chklang == 3) {
                                String fontarsub = ArrayStr[0].substring(0, ArrayStr[0].length() - 2);
                                font = fontarsub;
                            } else if (this.chklang == 4) {
                                String fontarsub = ArrayStr[1].substring(0, ArrayStr[1].length() - 2);
                                font = fontarsub;
                            } else if (this.chklang == 5) {
                                String fontarsub = ArrayStr[2].substring(0, ArrayStr[2].length() - 2);
                                font = fontarsub;
                            } else if (this.chklang == 6) {
                                String fontarsub = ArrayStr[3].substring(0, ArrayStr[3].length() - 2);
                                font = fontarsub;
                            }

                        }
                    }
                }
                buff.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return font;
    }

    public JLabel getMessageError(String FormName, String ErrorName) {
        String inFile = chkpath + "/spapplication/dbconfig/language/msgerrors.ini";
        String outFile = chkpath + "/spapplication/dbconfig/languageconvert/msgerrors.ini";
        String inCharset = "UTF-8";
        String outCharset = "TIS-620";
        if (!chkos.equalsIgnoreCase("linux")) {
            ConverCharSet(inFile, inCharset, outFile, outCharset);
        } else {
            copyFile(inFile, outFile);
        }
        JLabel text = new JLabel();
        int chklang = getChklang();
        text.setFont(new Font(getFont(), Font.PLAIN, getFontsize()));
        File fObject = new File(outFile);
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File msgerrors.ini");
            System.exit(0);
        } else {
            try {

                boolean eof = false;
                FileReader file = new FileReader(outFile);
                BufferedReader buff = new BufferedReader(file);
                
                    while (!eof) {
                        String line = buff.readLine();
                        if (line == null) {
                            eof = true;
                        } else {
                            if (!line.equals("")) {
                                String TempStr = line;
                                String ArrayStr[] = TempStr.split(":");

                                if (chklang == 3) {
                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ErrorName)) {
                                        text.setText(ArrayStr[2].toString());
                                    }
                                } else if (chklang == 4) {

                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ErrorName)) {

                                        text.setText(ArrayStr[3].toString());
                                    }
                                } else if (chklang == 5) {

                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ErrorName)) {

                                        text.setText(ArrayStr[4].toString());
                                    }
                                } else if (chklang == 6) {
                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ErrorName)) {

                                        text.setText(ArrayStr[5].toString());
                                    }
                                }
                            }
                        }
                    }
                
                buff.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return text;
    }

    public String getTextReport(String FormName, String prmName) {
        String inFile = chkpath + "/spapplication/dbconfig/language/txtReport.ini";
        String outFile = chkpath + "/spapplication/dbconfig/languageconvert/txtReport.ini";
        String inCharset = "UTF-8";
        String outCharset = "TIS-620";
        if (!chkos.equalsIgnoreCase("linux")) {
            ConverCharSet(inFile, inCharset, outFile, outCharset);
        } else {
            copyFile(inFile, outFile);
        }
        //JLabel text = new JLabel();
        String text = "";
        int chklang = getChklang();
        //text.setFont(new Font(getFont(), Font.PLAIN, getFontsize()));
        File fObject = new File(outFile);
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File txtReport.ini");
            System.exit(0);
        } else {
            try {

                boolean eof = false;
                FileReader file = new FileReader(outFile);
                BufferedReader buff = new BufferedReader(file);
                
                    while (!eof) {
                        String line = buff.readLine();
                        if (line == null) {
                            eof = true;
                        } else {
                            if (!line.equals("")) {
                                String TempStr = line;
                                String ArrayStr[] = TempStr.split(":");

                                if (chklang == 3) {
                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(prmName)) {
                                        text = ArrayStr[2].toString();
                                    }
                                } else if (chklang == 4) {

                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(prmName)) {

                                        text = ArrayStr[3].toString();
                                    }
                                } else if (chklang == 5) {

                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(prmName)) {

                                        text = ArrayStr[4].toString();
                                    }
                                } else if (chklang == 6) {
                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(prmName)) {

                                        text = ArrayStr[5].toString();
                                    }
                                }
                            }
                        }
                    }
                
                buff.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return text;
    }

    public String getTextCompanyReport() {
        String inFile = chkpath + "/spapplication/dbconfig/language/txtReport.ini";
        String outFile = chkpath + "/spapplication/dbconfig/languageconvert/txtReport.ini";
        String inCharset = "UTF-8";
        String outCharset = "TIS-620";
        if (!chkos.equalsIgnoreCase("linux")) {
            ConverCharSet(inFile, inCharset, outFile, outCharset);
        } else {
            copyFile(inFile, outFile);
        }
        //JLabel text = new JLabel();
        String FormName = "HeadCompany";
        String prmName = "HeadCompany";
        int chklang = getChklang();
        //text.setFont(new Font(getFont(), Font.PLAIN, getFontsize()));
        String text = "";
        File fObject = new File(outFile);
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File txtReport.ini");
            System.exit(0);
        } else {
            try {

                boolean eof = false;
                FileReader file = new FileReader(outFile);
                BufferedReader buff = new BufferedReader(file);
                
                    while (!eof) {
                        String line = buff.readLine();
                        if (line == null) {
                            eof = true;
                        } else {
                            if (!line.equals("")) {
                                String TempStr = line;
                                String ArrayStr[] = TempStr.split(":");
                                
                                 if (chklang == 0) {
                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(prmName)) {
                                        text = ArrayStr[2].toString();
                                    }
                                } else if (chklang == 3) {
                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(prmName)) {
                                        text = ArrayStr[2].toString();
                                    }
                                } else if (chklang == 4) {

                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(prmName)) {

                                        text = ArrayStr[3].toString();
                                    }
                                } else if (chklang == 5) {

                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(prmName)) {

                                        text = ArrayStr[4].toString();
                                    }
                                } else if (chklang == 6) {
                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(prmName)) {

                                        text = ArrayStr[5].toString();
                                    }
                                }



                            }
                        }
                    }
                
                buff.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return text;
    }

    public int getFontsize() {
        File fObject = new File(chkpath + "/spapplication/dbconfig/language/font.ini");
        if (!fObject.canRead()) {
            JOptionPane.showMessageDialog(null, "กรุณากำหนด File font.ini");
            System.exit(0);
        } else {
            try {
                boolean eof = false;
                FileReader file = new FileReader(chkpath + "/spapplication/dbconfig/language/font.ini");
                BufferedReader buff = new BufferedReader(file);

                while (!eof) {
                    String line = buff.readLine();
                    if (line == null) {
                        eof = true;
                    } else {
                        if (!line.equals("")) {
                            String TempStr = line;
                            String ArrayStr[] = TempStr.split(":");
                            if (this.chklang == 3) {
                                String fontarsub = ArrayStr[0].substring(ArrayStr[0].length() - 2);
                                fontsize = Integer.parseInt(fontarsub);
                            } else if (this.chklang == 4) {
                                String fontarsub = ArrayStr[1].substring(ArrayStr[1].length() - 2);
                                fontsize = Integer.parseInt(fontarsub);
                            } else if (this.chklang == 5) {
                                String fontarsub = ArrayStr[2].substring(ArrayStr[2].length() - 2);
                                fontsize = Integer.parseInt(fontarsub);
                            } else if (this.chklang == 6) {
                                String fontarsub = ArrayStr[3].substring(ArrayStr[3].length() - 2);
                                fontsize = Integer.parseInt(fontarsub);
                            }

                        }
                    }
                }
                buff.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fontsize;
    }

    public int getFontsize(String ComponentName) {
        int fontsize = getFontsize();
        int fontuse = 0;
        String Fonts = ComponentName.substring(0, 1);
        if (Fonts.equalsIgnoreCase("s")) {
            fontuse = fontsize - 2;
        } else if (Fonts.equalsIgnoreCase("m")) {
            fontuse = fontsize + 2;
        } else if (Fonts.equalsIgnoreCase("l")) {
            fontuse = fontsize + 4;
        } else if (Fonts.equalsIgnoreCase("x")) {
            fontuse = fontsize + 6;
        } else if (Fonts.equalsIgnoreCase("d")) {
            fontuse = fontsize;
        }
        return fontuse;
    }

    public int getFontStyle(String ComponentName) {

        int fontuse = 0;
        String Fonts = ComponentName.substring(1, 2);
        if (Fonts.equalsIgnoreCase("b")) {
            fontuse = Font.BOLD;
        } else if (Fonts.equalsIgnoreCase("i")) {
            fontuse = Font.ITALIC;
        } else if (Fonts.equalsIgnoreCase("u")) {
            fontuse = 3;
        } else if (Fonts.equalsIgnoreCase("_")) {
            fontuse = Font.PLAIN;
        }
        return fontuse;
    }

    public String subString(int Start, int length, String Name) {
        String resouce = "";
        resouce = Name.substring(Start, length);
        return resouce;
    }
}
