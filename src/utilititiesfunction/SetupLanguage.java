/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilititiesfunction;

import directory_utility.DirectoryUtility;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import org.jdesktop.swingx.JXTreeTable;
/**
 *
 * @author user
 */
public class SetupLanguage extends javax.swing.JDialog {
    DefaultTableModel model;
    String frmName = "SetupLanguaue";
     getLanguage lang;
   // private final int HEADER_HEIGHT;
   
    /**
     * Creates new form SetupLanguage
     */
    public SetupLanguage(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
          JTableHeader header = setuptable.getTableHeader();
          TableColumnModel m = setuptable.getColumnModel();
         model = (DefaultTableModel)setuptable.getModel();
        setuptable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setuptable.getColumnModel().getColumn(0).setPreferredWidth(100);
        setuptable.getColumnModel().getColumn(1).setPreferredWidth(120);
        setuptable.getColumnModel().getColumn(2).setPreferredWidth(30);
        setuptable.getColumnModel().getColumn(3).setPreferredWidth(180);
        setuptable.getColumnModel().getColumn(4).setPreferredWidth(180);
        setuptable.getColumnModel().getColumn(5).setPreferredWidth(180);
        setuptable.getColumnModel().getColumn(6).setPreferredWidth(180);
         setuptable.setShowGrid(true);
        setuptable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setuptable.setRowSelectionAllowed(true);
        setuptable.setBackground(java.awt.Color.WHITE);
        setuptable.setGridColor(java.awt.Color.gray);
          header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        setuptable.setRowHeight(25);
      //  lang = new getLanguage();
        // lang.setText(frmName, this, lang.getChklang());
    
   
                  
    }
    
     
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author s386
 */


    ThaiUtilities cvth = new ThaiUtilities();
    public int chklang;
    String fFileName = "";
    String fEncoding = "UTF8";
    public String font;
    public int fontsize;
    String chkpath = "";
    String chkos = "";
    String formname="";
    public void getLanguage() {
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
              // JOptionPane.showMessageDialog(this, e);
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

    public void setTextPopupMenu(String FormName, JPopupMenu popup) {
        //JOptionPane.showMessageDialog(null, popup.getName());
        Component[] compo = popup.getComponents();
        for (int i = 0; i < compo.length; i++) {
            if (compo[i] instanceof JMenuItem) {
                String itemname = "";
               // itemname = getTextLunguage(FormName, compo[i].getName());
                //((JMenuItem) compo[i]).setText(itemname);
                ((JMenuItem) compo[i]).setFont(new Font(getFonts(), Font.PLAIN, getFontsize()));
            }
        }
    }
    String FormName = "";
    Container con = null;
    public void setText(String FormName, final Container c) {
        File fObject = new File(chkpath + "/spapplication/dbconfig/language/default.ini");
        File fObject2 = new File(chkpath + "/spapplication/dbconfig/language/" + FormName + ".ini");
        File fObject3 = new File(chkpath + "/spapplication/dbconfig/language/font.ini");
        File fObject4 = new File(chkpath + "/spapplication/dbconfig/language/msgerrors.ini");
        setFormname(FormName);
        chkos = System.getProperty("os.name").toString().toLowerCase();
         // JOptionPane.showMessageDialog(this, chkos);
         ThaiUtilities cvth = new ThaiUtilities();
       this.FormName = FormName;
       con = c;
          int cnt = model.getRowCount();
              if(cnt>0)
              {
                 
                  for(int i =0; i<cnt;i++)
                  {
                      model.removeRow(0);
                  }
              }
       /* if (!fObject.canRead() || !fObject2.canRead() || !fObject3.canRead() || !fObject4.canRead()) {
            JOptionPane.showMessageDialog(null, "Can't Not File : default.ini or " + FormName + ".ini or font.ini or msgerrors.ini System is use Default for program.");
        } else {*/
            try {
                String[] title = getTitle(FormName);
                if (c instanceof JFrame) {
                    if (((JFrame) c).getTitle() != null) {
                        
                        model.addRow(new Object[]{FormName, "Title", "-", title[2], title[3], title[4], title[5]});
                    } else {
                        model.addRow(new Object[]{FormName, "Title", "-", title[2], title[3], title[4], title[5]});
                    }
                } else if (c instanceof JDialog) {
                    if (((JDialog) c).getTitle() != null) {
                        model.addRow(new Object[]{FormName, "Title", "-", title[2], title[3], title[4], title[5]});
                    } else {
                        model.addRow(new Object[]{FormName, "Title", "-", title[2], title[3], title[4], title[5]});
                    }

                }
                // setChklang(chklang);
                List Componentlist = getAllComponents(c);

                for (Object comp : Componentlist) {
                    Component com = (Component) comp;
                  
                    //JOptionPane.showMessageDialog(null, com.getName());
                   String [] name = getTextLunguage(FormName, com.getName());
                  
                  
                    if (com.getName() != null) {
                            
                            
                        if (com instanceof JLabel) {
                            /* if(name[0].equals(""))
                             {
                                  model.addRow(new Object[]{FormName,com.getName(),name[0],((JLabel) com).getText(),name[2],name[3],""});
                                 
                             }
                             else*/
                            if(com.getName().equalsIgnoreCase("ComboBox.renderer")){
                              
                            }
                            else if(com.getName().equalsIgnoreCase("List.Cellrenderer")){
                              
                            }
                            else{
                                //if(((JLabel) com).getText()!=null){
                                     model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                                //}
                                //else{
                                     //model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                                //}
                            }
                            //((JLabel) com).setFont(new Font(getFonts(), getFontStyle(com.getName()), getFontsize(com.getName())));
                        } else if (com instanceof JButton) {
                             //System.out.println(com.getName()+name[0]+" "+name[1]+" "+name[2]);
                            if(com.getName().equalsIgnoreCase("ScrollBar.Button")){
                                
                            }
                            else if(com.getName().equalsIgnoreCase("ComboBox.arrowButton")){
                                //JOptionPane.showMessageDialog(this, "...");
                            }
                            else{
                               // if(((JButton) com).getText()!=null){
                                    model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                                //}
                                //else{
                                   // model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                               // }
                                
                            }
                            
                            
                           // ((JButton) com).setFont(new Font(getFonts(), getFontStyle(com.getName()), getFontsize(com.getName())));
                        } else if (com instanceof JTabbedPane) {

                            Component[] compo = ((JTabbedPane) com).getComponents();
                            for (int i = 0; i < compo.length; i++) {

                                if (compo[i] instanceof JPanel) {
                                  
                                   String[] panelname = getTextLunguage(FormName, com.getName(), i);
                                   System.out.print(panelname[0]);
                                   //if(((JTabbedPane) com).getTitleAt(i)!=null){
                                        model.addRow(new Object[]{FormName,com.getName(),i,panelname[1],panelname[2],panelname[3],""});
                                        //((JTabbedPane) com).getTitleAt(i) ; get componente text name
                                 //  }
                                 //  else{
                                      //  model.addRow(new Object[]{FormName,com.getName(),i,panelname[1],panelname[2],panelname[3],""});

                                  // }
                                  


                                }
                            }

                        } else if (com instanceof JPanel) {
                           // System.out.println(com.getName()+name[0]+" "+name[1]+" "+name[2]);
                        } else if (com instanceof JCheckBox) {
                           System.out.println(com.getName()+name[0]+" "+name[1]+" "+name[2]);
                          // if(((JCheckBox) com).getText()!=null){
                                   model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                           //}
                           //else{
                                   //model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                           //}
                  
                        } else if (com instanceof JRadioButton) {
                           System.out.println(com.getName()+name[0]+" "+name[1]+" "+name[2]);
                         //  if(((JRadioButton) com).getText()!=null){
                               model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                           //}
                           //else{
                             //  model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                           //}
                          
                           // ((JRadioButton) com).setFont(new Font(getFonts(), getFontStyle(com.getName()), getFontsize(com.getName())));
                        } else if (com instanceof JComboBox) {
                            
                       
                    
                            int count = ((JComboBox) com).getItemCount();
                           // ((JComboBox) com).setFont(new Font(getFonts(), Font.PLAIN, getFontsize()));
                           // ((JComboBox) com).removeAllItems();
                            
                            for (int i = 0; i < count; i++) {
                             
                             
                             String[] cbolname = getTextLunguage(FormName, com.getName(), i);
                               // if(((JComboBox) com).getItemAt(i)!=null){
                                     model.addRow(new Object[]{FormName,com.getName(),"-",cbolname[1],cbolname[2],cbolname[3],cbolname[4]});
                                //}
                                //else{
                                   //  model.addRow(new Object[]{FormName,com.getName(),"-",cbolname[1],cbolname[2],cbolname[3],cbolname[4]});
                               // }
                              

                            
                            
                            }

                        } else if (com instanceof JMenu) {
                         
                            //((JMenu) com).setFont(new Font(getFonts(), Font.BOLD, getFontsize()));
                            if (((JMenu) com).getItemCount() > 0) {
                                  // if(((JMenu) com).getText()!=null){
                                       model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                                   //}
                                   //else{
                                     //  model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                                   //}
                                   
                                for (int i = 0; i < ((JMenu) com).getItemCount(); i++) {
                                    Component chkcom = ((JMenu) com).getItem(i);
                                    if ((chkcom != null)) {
                                        String getName = ((JMenu) com).getItem(i).getName();
                                        // System.out.println(com.getName()+name[0]+" "+name[1]+" "+name[2]);
                                       
                                        //String Nameb = "";
                                     String[]  Nameb = getTextLunguage(FormName, getName);
                                    // if(((JMenu) com).getItem(i).getText()!=null){
                                            model.addRow(new Object[]{FormName,getName,"-",Nameb[1],Nameb[2],Nameb[3],Nameb[4]});
                                     //}
                                     //else{
                                       //     model.addRow(new Object[]{FormName,getName,"-",Nameb[1],Nameb[2],Nameb[3],Nameb[4]});
                                     //}
                                   
                                     //   ((JMenu) com).getItem(i).setText(Nameb);
                                       // ((JMenu) com).getItem(i).setFont(new Font(getFonts(), Font.PLAIN, getFontsize()));

                                        if (((JMenu) com).getItem(i) instanceof JMenu) {

                                            JMenu test = (JMenu) ((JMenu) com).getItem(i);
                                            if (test.getItemCount() > 0) {
                                                for (int j = 0; j < test.getItemCount(); j++) {
                                                    Component chkcom2 = test.getItem(j);
                                                    if ((chkcom2 != null)) {
                                                        String getNames = test.getItem(j).getName();
                                                        
                                                      
                                                        String [] Namebs = getTextLunguage(FormName, getNames);
                                                        // System.out.println(com.getName()+Namebs[0]+" "+Namebs[1]+" "+Namebs[2]);
                                                       // if(((JMenuItem) chkcom2).getText()!=null){
                                                             model.addRow(new Object[]{FormName,getNames,"-",Namebs[1],Namebs[2],Namebs[3],Namebs[4]});
                                      if (((JMenu)test).getItem(j) instanceof JMenu) {

                                            JMenu test1 = (JMenu) ((JMenu) test).getItem(j);
                                            if (test1.getItemCount() > 0) {
                                                for (int k = 0; k < test1.getItemCount(); k++) {
                                                    Component chkcom3 = test1.getItem(k);
                                                    if ((chkcom3 != null)) {
                                                        String getNames1 = test1.getItem(k).getName();
                                                        
                                                      
                                                        String [] Namebs1 = getTextLunguage(FormName, getNames1);
                                                        // System.out.println(com.getName()+Namebs[0]+" "+Namebs[1]+" "+Namebs[2]);
                                                       // if(((JMenuItem) chkcom2).getText()!=null){
                                                        //System.out.print(getNames1);
                                                            model.addRow(new Object[]{FormName,getNames1,"-",Namebs1[1],Namebs1[2],Namebs1[3],Namebs1[4]});
                                                       
                                                    }
                                                }

                                            }
                                      }
                                                    }
                                                }

                                            }
                                        }

                                    }
                                }

                            }
                            else
                            {
                                model.addRow(new Object[]{FormName,com.getName(),"-",name[1],name[2],name[3],name[4]});
                            }
                        } else if (com instanceof JPopupMenu) {
                           Component[] compo = ((JPopupMenu)com).getComponents();
                       for (int i = 0; i < compo.length; i++) {

                              if (compo[i] instanceof JMenuItem) {                                 
                                  String []itemname = getTextLunguage(FormName, com.getName(), i);
                             //   if(((JMenuItem) com).getText()!=null){
                                    model.addRow(new Object[]{FormName,com.getName(),"-",itemname[1],itemname[2],itemname[3],itemname[4]});
                               // }   
                                //else{
                                  //  model.addRow(new Object[]{FormName,com.getName(),"-",itemname[1],itemname[2],itemname[3],itemname[4]});
                                //}
                                
                              }
                           }
                        } else if (com instanceof JTable) {
                            //JOptionPane.showMessageDialog(null, com.getName());
                          /*  ((JTable) com).setShowGrid(true);
                            ((JTable) com).setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                            ((JTable) com).setRowSelectionAllowed(true);
                            ((JTable) com).setBackground(java.awt.Color.WHITE);
                            ((JTable) com).setGridColor(java.awt.Color.gray);
                            ((JTable) com).setRowHeight(20);
                            JTableHeader tbh = ((JTable) com).getTableHeader();
                            tbh.setFont(new Font(getFonts(), Font.BOLD, getFontsize()));*/
                            TableColumnModel tbc = ((JTable) com).getColumnModel();
                            for (int i = 0; i < tbc.getColumnCount(); i++) {
                                String nametbc[] = getTextLunguage(FormName, com.getName(), i);
                               
                               System.out.println(com.getName()+nametbc[0]+" "+nametbc[1]+" "+nametbc[2]);
                            //   if(tbc.getColumn(i).getHeaderValue().toString()!=null){
                                    model.addRow(new Object[]{FormName,com.getName(),i,nametbc[1],nametbc[2],nametbc[3],nametbc[4]});
                              // }
                               //else{
                                 //   model.addRow(new Object[]{FormName,com.getName(),i,nametbc[1],nametbc[2],nametbc[3],nametbc[4]});
                               //}
                               
                               // tbc.getColumn(i).setHeaderValue(nametbc);
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
                        /*else if (com instanceof JList) {
                            
                         int count = ((JList) com).getMaxSelectionIndex();
                           // ((JComboBox) com).setFont(new Font(getFonts(), Font.PLAIN, getFontsize()));
                           // ((JComboBox) com).removeAllItems();
                            
                          //  for (int i = 0; i < count; i++) {
                             
                             
                           //  String[] cbolname = getTextLunguage(FormName, com.getName(), i);
                          
                                model.addRow(new Object[]{FormName,com.getName(),"-",((JList) com).getSelectedValue().toString(),name[2],name[3],name[4]});

                            
                            
                            //}
                        }*/
                    }
                
                if (c instanceof JFrame) {
                   
                   
                } else if (c instanceof JDialog) {
                     
                   
                
                   }
                }  } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
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

    public String[] getTextLunguage(String FormName, String ComponentName) {
       
         chkos = System.getProperty("os.name").toString().toLowerCase();
        if (chkos.equalsIgnoreCase("linux")) {
            chkpath = "";
        } else {
            chkpath = "C:";
        }
        String outFile =  chkpath +"/spapplication/dbconfig/languageconvert/" + FormName + ".ini";
         String inFile = chkpath + "/spapplication/dbconfig/language/" + FormName + ".ini";
       
        String inCharset = "UTF-8";
        String outCharset = "TIS-620";
       
            //ConverCharSet(inFile, inCharset, outFile, outCharset);
         if (!chkos.equalsIgnoreCase("linux")) {
            ConverCharSet(inFile, inCharset, outFile, outCharset);
        } else {
            copyFile(inFile, outFile);
        }
            
       
        String [] result = new String[5];
        File fObject = new File(outFile);
        if (!fObject.canRead()) {
         //  JOptionPane.showMessageDialog(null, "กรุณากำหนด File " + FormName + ".ini");
           // System.exit(0);
            return result;
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
                            String []ArrayStr = TempStr.split(":");
                            
                           
                                if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ComponentName)) {
                                    for(int i = 0, ii =2; ii<ArrayStr.length; i++,ii++){
                                   result[i] = ArrayStr[ii].toString();
                                    
                                    }
                                    //System.out.print(result[1]);
                                    return result;
                                }
                                else{
                                    result[0]="-";
                                   result[1]="";
                                   result[2]="";
                                   result[3]="";
                                   result[4]=""; 
                                }

                                {
                            }
                        }
                    }
                }

                buff.close();

            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, e);
            }
        }
        return result;
    }

    public String []getTextLunguage(String FormName, String ComponentName, int index) {
      
        chkos = System.getProperty("os.name").toString().toLowerCase();
        if (chkos.equalsIgnoreCase("linux")) {
            chkpath = "";
        } else {
            chkpath = "C:";
        }
         String outFile =  chkpath +"/spapplication/dbconfig/languageconvert/" + FormName + ".ini";
         String inFile = chkpath + "/spapplication/dbconfig/language/" + FormName + ".ini";
       
        String inCharset = "UTF-8";
        String outCharset = "TIS-620";
        if (!chkos.equalsIgnoreCase("linux")) {
            ConverCharSet(inFile, inCharset, outFile, outCharset);
        } else {
            copyFile(inFile, outFile);
        }
         String [] result = new String[5];
       
        File fObject = new File(outFile);
        if (!fObject.canRead()) {
            //JOptionPane.showMessageDialog(null, "กรุณากำหนด File " + FormName + ".ini");
            
           return result;
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
                           
                           
                                if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase(ComponentName) && ArrayStr[2].equals(i)) {
                                   for(int j = 0, ii =2; ii<ArrayStr.length; j++,ii++){
                                   result[j] = ArrayStr[ii].toString();
                                    
                                    }
                                   return result;
                                }
                                else{
                                    result[0]=i;
                                     result[1]="";
                                      result[2]="";
                                       result[3]="";
                                       result[4]="";
                                       //return result;
                                }
                            
                                
                            

                        }
                    }

                }

                buff.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            }
        }
        return result;
    }

    public String[] getTitle(String FormName) {
      
        chkos = System.getProperty("os.name").toString().toLowerCase();
        if (chkos.equalsIgnoreCase("linux")) {
            chkpath = "";
        } else {
            chkpath = "C:";
        }
         String outFile = chkpath + "/spapplication/dbconfig/languageconvert/" + FormName + ".ini";
         String inFile = chkpath + "/spapplication/dbconfig/language/" + FormName + ".ini";
       
        String inCharset = "UTF-8";
        String outCharset = "TIS-620";
        if (!chkos.equalsIgnoreCase("linux")) {
            ConverCharSet(inFile, inCharset, outFile, outCharset);
        } else {
            copyFile(inFile, outFile);
        }
         String [] result = new String[6];
       
        File fObject = new File(outFile);
        if (!fObject.canRead()) {
          //  JOptionPane.showMessageDialog(null, "กรุณากำหนด File " + FormName + ".ini");
         return result;
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

                              
                                    if (ArrayStr[0].equalsIgnoreCase(FormName) && ArrayStr[1].equalsIgnoreCase("Title")) {
                                         for(int j = 0, ii =1; ii<ArrayStr.length; j++,ii++){
                                   
                                   result[j] = ArrayStr[ii].toString();
                                           
                                    
                                    }
                                    return result;
                                
                                    }
                               

                                   
                                    {
                                }



                            }
                        }
                    }
                
                buff.close();
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, e);
            }
        }
        return null;
    }

    public String getFonts() {
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
        text.setFont(new Font(getFonts(), Font.PLAIN, getFontsize()));
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
        //text.setFont(new Font(getFonts(), Font.PLAIN, getFontsize()));
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
        //text.setFont(new Font(getFonts(), Font.PLAIN, getFontsize()));
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


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        setuptable = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Setup Language to BOR System");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setuptable.setFont(new java.awt.Font("Norasi", 0, 14)); // NOI18N
        setuptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Fromname", "CompentName", "Index", "Default", "Thai", "English", "Local"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        setuptable.setName("tbsetlang");
        setuptable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setuptableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(setuptable);
        setuptable.getColumnModel().getColumn(0).setPreferredWidth(40);
        setuptable.getColumnModel().getColumn(1).setPreferredWidth(40);
        setuptable.getColumnModel().getColumn(2).setPreferredWidth(5);
        setuptable.getColumnModel().getColumn(3).setPreferredWidth(120);
        setuptable.getColumnModel().getColumn(4).setPreferredWidth(120);
        setuptable.getColumnModel().getColumn(5).setPreferredWidth(120);
        setuptable.getColumnModel().getColumn(6).setPreferredWidth(120);

        btnCancel.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel-icon.png"))); // NOI18N
        btnCancel.setText("ยกเลิก");
        btnCancel.setFocusable(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setIconTextGap(0);
        btnCancel.setName("db_btnCancel"); // NOI18N
        btnCancel.setRequestFocusEnabled(false);
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save-icon.png"))); // NOI18N
        btnSave.setText("บันทึกข้อมูล");
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setIconTextGap(0);
        btnSave.setName("db_btnSave"); // NOI18N
        btnSave.setRequestFocusEnabled(false);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Norasi", 1, 14)); // NOI18N
        jButton1.setText("Copy Default To Thai");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jLabel2.setFont(new java.awt.Font("Norasi", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Setup Language to BOR System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1032)/2, (screenSize.height-796)/2, 1032, 796);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      if (chkos.equalsIgnoreCase("linux")) {
            chkpath = "";
        } else {
            chkpath = "C:";
        }
        String inFile = chkpath + "/spapplication/dbconfig/language1/" + getFormname() + ".ini";
        String outFile = chkpath + "/spapplication/dbconfig/language/" + getFormname() + ".ini";
        String inCharset = "UTF-8";
        String outCharset = "TIS-620";
        String [] result = new String[5];
       
       setuptable.editingStopped(null);
        // model = (DefaultTableModel)setuptable.getModel();
         int col = model.getColumnCount(); 
        int row = model.getRowCount();
        String []rv = new String[row];
         StringBuffer sb=new StringBuffer();
        // String []resultvalue = new String[];
         for(int i = 0 ; i <row;i++){
             for(int j = 0;j<col;j++){
                 if(model.getValueAt(i, j)==null){
                     if(j==col-1){
                     sb.append("");
                 }
                     else{
                  sb.append(""+":");
                 }
                 }
                 
                 else{
                 if(j==col-1){
                     sb.append(model.getValueAt(i, j).toString());
                 }
                 else
                 sb.append(model.getValueAt(i, j).toString()+":");
                 }
             }
             
             rv[i] = sb.toString();
            //String rv = resultvalue;
           // JOptionPane.showMessageDialog(this,rv[i]);
            sb.delete(0,1000);
         }
         
        
         if (!chkos.equalsIgnoreCase("linux")) {
            //copyFile(inFile, outFile);
             DirectoryUtility dirUtil = new DirectoryUtility();
               try {
                 dirUtil.getFileAndCreateDir(inFile);
            } catch (Exception ex) {
                Logger.getLogger(SetupLanguage.class.getName()).log(Level.SEVERE, null, ex);
            }    
              writeToText(inFile, rv);
            ConverCharSet(inFile, outCharset, outFile, inCharset);
         }
         else{
              writeToText(outFile, rv);
         }
         
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoadThai();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void setuptableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setuptableMouseClicked
          int row = setuptable.getSelectedRow();
        int col = setuptable.getSelectedColumn();
        
            if (setuptable.editCellAt(row, col)) {
                Component editor = setuptable.getEditorComponent();
                editor.requestFocusInWindow();
                ((JTextComponent) editor).selectAll();
            }

    }//GEN-LAST:event_setuptableMouseClicked

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
            java.util.logging.Logger.getLogger(SetupLanguage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetupLanguage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetupLanguage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetupLanguage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                SetupLanguage dialog = new SetupLanguage(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable setuptable;
    // End of variables declaration//GEN-END:variables
public void writeToText(String pathFile, String[] data) {
        //System.out.println("write log: "+data);
       File file = new File(pathFile); 
       if(file.isFile()){
          // JOptionPane.showMessageDialog(this, "found");
       }
       else{
          //  JOptionPane.showMessageDialog(this, "not found");
       }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            writer.write("    0    	1      	 2     3       4   5    6\n");
            writer.write("Formname:ComponentName:Index:Default:Thai:Eng:Local\n");
            writer.write("--------------------------------------\n");
            for(int i=0;i<data.length;i++){
            writer.write(data[i]+"\n");
    
            }
             JOptionPane.showMessageDialog(this, "Saved");

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
public void setFormname(String formname){
        this.formname = formname;
}
public String getFormname( ){
       return this.formname ;
}

    private void LoadThai() {
        for(int i =0; i<setuptable.getRowCount();i++)
        {
            setuptable.setValueAt(setuptable.getValueAt(i, 3).toString(), i, 4);
        }
    }
}
