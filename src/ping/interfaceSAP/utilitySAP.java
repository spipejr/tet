/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP;

import dbutility.dbUtility;
import java.awt.Color;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import utilititiesfunction.ThaiUtilities;

/**
 *
 * @author soneping
 */
public class utilitySAP {

    public void resetTable(DefaultTableModel model) {
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            model.removeRow(0);
        }
    }

    public DefaultTableModel setTable(JTable tbl, String left, String center, String right) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        tbl.setShowGrid(true);
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl.setRowSelectionAllowed(true);
        tbl.setShowGrid(true);
        tbl.setGridColor(Color.black);
        JTableHeader header = tbl.getTableHeader();
        header.setFont(new java.awt.Font("Norasi", java.awt.Font.BOLD, 14));
        tbl.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
        tbl.setRowHeight(25);

        TableColumnModel tcm = tbl.getColumnModel();

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        tbl.setRowSorter(sorter);

        DefaultTableCellRenderer Renderer = null;
        String[] split;
        if (left.length() > 0) {
            split = left.split(",");
            Renderer = new DefaultTableCellRenderer();
            Renderer.setHorizontalAlignment(SwingConstants.LEFT);
            for (int i = 0; i < split.length; i++) {
                int col = Integer.parseInt(split[i]);
                tbl.getColumnModel().getColumn(col).setCellRenderer(Renderer);
            }
        }
        if (center.length() > 0) {
            split = center.split(",");
            Renderer = new DefaultTableCellRenderer();
            Renderer.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < split.length; i++) {
                int col = Integer.parseInt(split[i]);
                tbl.getColumnModel().getColumn(col).setCellRenderer(Renderer);
            }
        }
        if (right.length() > 0) {
            split = right.split(",");
            Renderer = new DefaultTableCellRenderer();
            Renderer.setHorizontalAlignment(SwingConstants.RIGHT);
            for (int i = 0; i < split.length; i++) {
                int col = Integer.parseInt(split[i]);
                tbl.getColumnModel().getColumn(col).setCellRenderer(Renderer);
            }
        }

        // =============== setFont Edit Cell ====================//
        JTextField textField = new JTextField();
        textField.setFont(new java.awt.Font("Norasi", java.awt.Font.PLAIN, 14));
        DefaultCellEditor dce = new DefaultCellEditor(textField);
        tbl.getColumnModel().getColumn(0).setCellEditor(dce);

        return model;
    }

    public Color colorDisable() {
        return new Color(237, 238, 228);
    }

    public Color colorEnable() {
        return Color.WHITE;
    }

    public void closeTextFiled(JTextField txt, boolean clear) {
        txt.setFocusable(false);
        txt.setBackground(colorDisable());
        if (clear) {
            txt.setText("");
        }
    }

    public void openTextFiled(JTextField txt, boolean clear, boolean focus) {
        txt.setFocusable(true);
        txt.setBackground(colorEnable());
        if (clear) {
            txt.setText("");
        }
        if (focus) {
            txt.requestFocus();
        }
    }

    public void cmdDateChoose(JTextField txt, JButton btn) {
        try {
            Point point = btn.getLocationOnScreen();
            utilities.DateChooser.DateChooserDialog dcd = new utilities.DateChooser.DateChooserDialog(null, true, point);
            dcd.setVisible(true);
            txt.setText(new formatDateNum().dateFmtShow((dcd.getSelectedDate().getTime())));
        } catch (Exception e) {
            txt.setText(new formatDateNum().dateFmtShow(new formatDateNum().nowDate()));
        } finally {
            txt.requestFocus();
        }
    }

    public String charSet(String TempStr) {
        return (!dbUtility.Char_Set.equalsIgnoreCase("utf-8") ? TempStr : TempStr);
    }

    public boolean copyFileProcess(String des, String target) {
        boolean success = false;

        new File(target).getParentFile().mkdir();
        if (des.equals(target)) {
            success = false;
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
                success = true;
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
                success = false;
            }
        }
        return success;
    }
    
    public String addZeroBefore(int num, String value) {
        StringBuffer _strGC;
        _strGC = new StringBuffer(value);
        while (_strGC.length() < num) {
            _strGC.insert(0, '0');
        }

        return _strGC.toString();
    }
    
    public void writeFile(String pathFile, StringBuilder str) {
        try {
            File file = new File(pathFile);
            PrintWriter writer = new PrintWriter(file, "UTF-8");//UTF-8, TIS-620
            BufferedWriter buff = new BufferedWriter(writer);
            buff.append(str);
            buff.flush();
            buff.close();
            file = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
