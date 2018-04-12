/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilititiesfunction;

/**
 *
 * @author natee
 */
import dbutility.dbUtility;
import ingredent_bom.formatDateNumber;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.jdesktop.swingx.JXTreeTable;

public class Export2Excel {

    public WritableCellFormat timesBoldUnderline;
    public WritableCellFormat times;
    public String inputFile;
    public int rowcount;
    public String a;
    public static String defaultpath = "";
    public String chkos = System.getProperty("os.name").toString().toLowerCase();
    ThaiUtilities cvth = new ThaiUtilities();

    public void setOutputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public File getDefaulepath() {
        if (defaultpath.equals("")) {
            if (!chkos.equalsIgnoreCase("linux")) {
                defaultpath = "C:";
            } else {
                defaultpath = "/spapplication";
            }
        }
        File f = new File(defaultpath + "/" + "filename.xls");
        return f;
    }

    public void setDefaultpath(File f) {
        this.defaultpath = f.getParent();
        //JOptionPane.showMessageDialog(null, defaultpath);
    }

    public void write(DefaultTableModel model, JTableHeader header) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel(excelSheet, header);
        createContent(excelSheet, model);
        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);

        workbook.write();
        workbook.close();
    }

    public void write2single(DefaultTableModel model, JTableHeader header) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel(excelSheet, header);
        createContent2(excelSheet, model);

        workbook.write();
        workbook.close();
    }

    public void writetableNoSum(JTable table, TableColumnModel header, String condition) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createHeadAndCondition(excelSheet, header, condition);
        createContentNoSum3(excelSheet, table);

        workbook.write();
        workbook.close();
    }

    public void writetableNoSumNoHead(JTable table, TableColumnModel header, String condition) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createHead(excelSheet, header);
        createContentNoSum3NoHead(excelSheet, table);

        workbook.write();
        workbook.close();
    }

    public void writeTreetableNoSum(JXTreeTable jxtreetable, TableColumnModel header) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel2(excelSheet, header);
        createContentNoSum(excelSheet, jxtreetable);

        workbook.write();
        workbook.close();
    }

    public void writeTreetableContditionNoSum(JXTreeTable jxtreetable, TableColumnModel header, String Condition) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);

        createHeadConditiontree(excelSheet, header, Condition);
        createContentNoSumTreeReport(excelSheet, jxtreetable);

        workbook.write();
        workbook.close();
    }

    public void writeTreetableNoSum2(JTable table, TableColumnModel header) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel2(excelSheet, header);
        createContentNoSum2(excelSheet, table);

        workbook.write();
        workbook.close();
    }

    public void writeTreetableTwotable(JXTreeTable jxtreetable, TableColumnModel header, JXTreeTable jxtreetable2, TableColumnModel header2) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report Summary", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel2(excelSheet, header);
        createContentChkpost1(excelSheet, jxtreetable);

        workbook.createSheet("Report Detail", 1);
        WritableSheet excelSheet2 = workbook.getSheet(1);
        createLabel2(excelSheet2, header2);
        createContentNoSum(excelSheet2, jxtreetable2);

        workbook.write();
        workbook.close();
    }

    public void createLabel(WritableSheet sheet, JTableHeader header)
            throws WriteException {
        // Lets create a times font
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        //times.setWrap(true);

        // Create create a bold font with unterlines
        WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
                UnderlineStyle.SINGLE);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        // Lets automatically wrap the cells
        //timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);

        // Write a few headers
        for (int h = 0; h < header.getTable().getColumnCount(); h++) {
//            addCaption(sheet, h, 0, header.getColumnModel().getColumn(h).toString());
            addCaption(sheet, h, 0, header.getTable().getColumnName(h).toString());
        }
//        addCaption(sheet, 1, 0, a);

    }

    public void createLabel2(WritableSheet sheet, TableColumnModel header)
            throws WriteException {
        // Lets create a times font
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        //times.setWrap(true);

        // Create create a bold font with unterlines
        WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
                UnderlineStyle.SINGLE);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        // Lets automatically wrap the cells
        //timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);

        int hcount = header.getColumnCount();
        // Write a few headers
        for (int h = 0; h < hcount; h++) {
//            addCaption(sheet, h, 0, header.getColumnModel().getColumn(h).toString());
            addCaption(sheet, h, 0, header.getColumn(h).getHeaderValue().toString());
        }
//        addCaption(sheet, 1, 0, a);

    }

    public void createHeadConditiontree(WritableSheet sheet, TableColumnModel header, String con)
            throws WriteException {

        // Lets create a times font
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        //times.setWrap(true);

        // Create create a bold font with unterlines
        WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
                UnderlineStyle.SINGLE);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        // Lets automatically wrap the cells
        //timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);

        String[] head, head1 = new String[2];
        int hcount = header.getColumnCount();

        addCaption(sheet, 0, 0, con);
        for (int h = 0; h < hcount; h++) {
            String head11 = header.getColumn(h).getHeaderValue() + "";
            if (head11.indexOf("<html>") >= 0) {
                head = head11.split("<html>");
                head1 = head[1].split("<br>");
                addCaption(sheet, h, 1, head1[0] + head1[1]);
            } else {
                addCaption(sheet, h, 1, header.getColumn(h).getHeaderValue().toString());
            }
        }

    }

    public void createContent(WritableSheet sheet, DefaultTableModel model) throws WriteException,
            RowsExceededException {
        // Write a few number
//    for (int i = 1; i < 10; i++) {
//      // First column
//      addNumber(sheet, 0, i, i + 10);
//      // Second column
//      addNumber(sheet, 1, i, i * i);
//    }
        // Lets calculate the sum of it
//        StringBuffer buf = new StringBuffer();
//        buf.append("SUM(A2:A10)");
//        Formula f = new Formula(0, 10, buf.toString());
//        sheet.addCell(f);
//        buf = new StringBuffer();
//        buf.append("SUM(B2:B10)");
//        f = new Formula(1, 10, buf.toString());
//        sheet.addCell(f);

        // e = ค่า sum
        // indexex = index excel
        // count = 
        // i = index ข้อมูล
        int e = 0;
        int indexex = 1;
        int count = model.getRowCount();
        for (int c = 0; c < model.getColumnCount(); c++) {
            for (int i = 0; i < count; i++) {

                // Check ข้อมูลจะ Sum เมื่อค่าช่องแรกต่างกัน
                int j = i;
                if (i != 0) {
                    String a = model.getValueAt(j - 1, 0).toString();
                    String b = model.getValueAt(j, 0).toString();
                    if (!a.equals(b)) {

                        if (c == 0) {
                            addLabel(sheet, 2, indexex, "จำนวนรวม " + e);
                        }
                        indexex++;
                        addLabel(sheet, c, indexex, model.getValueAt(i, c).toString());
                        e = 0;

                    } else {
                        addLabel(sheet, c, indexex, model.getValueAt(i, c).toString());
                    }
                } else {
                    addLabel(sheet, c, indexex, model.getValueAt(i, c).toString());

                }

                /// Sum ทั้งหมด
                if (c + 1 == model.getColumnCount()) {
                    if (i + 1 == model.getRowCount()) {
                        addLabel(sheet, c, indexex + 2, "จำนวนข้อมูลทั้งหมด " + model.getRowCount() + " รายการ");
                    }
                }
                e++;
                indexex++;
                // ใช้ครั้งเดียว
                if (i + 1 == model.getRowCount()) {

                    if (c == 0) {
                        addLabel(sheet, model.getColumnCount() - 1, indexex, "จำนวนรวม " + e);
                    }

                }

            }

            indexex = 1;
        }

    }

    public void createContent2(WritableSheet sheet, DefaultTableModel model) throws WriteException,
            RowsExceededException {

        int e = 0;
        int indexex = 1;
        int count = model.getRowCount();
        for (int c = 0; c < model.getColumnCount(); c++) {
            for (int i = 0; i < count; i++) {

                addLabel(sheet, c, indexex, model.getValueAt(i, c).toString());

                /// Sum ทั้งหมด
                if (c + 1 == model.getColumnCount()) {
                    if (i + 1 == model.getRowCount()) {
                        addLabel(sheet, c, indexex + 2, "จำนวนข้อมูลทั้งหมด " + model.getRowCount() + " รายการ");
                    }
                }
                e++;
                indexex++;

            }

            indexex = 1;
        }

    }

    public void createContentChkpost1(WritableSheet sheet, JXTreeTable model) throws WriteException,
            RowsExceededException {
        model.expandAll();
        int e = 0;
        int indexex = 1;
        int rowcount = model.getRowCount();
        int colcount = model.getColumnCount();
        for (int c = 0; c < colcount; c++) {
            for (int i = 0; i < rowcount; i++) {
                String aa = "";
                if (c != 0) {
                    TableCellRenderer tc = model.getCellRenderer(i, c);
                    DefaultTableCellRenderer d = (DefaultTableCellRenderer) tc;

                    if (d.getHorizontalAlignment() != 0) {
                        if (model.getValueAt(i, c) != null) {
                            aa = model.getValueAt(i, c).toString();
                        }
                        addLabel(sheet, c, indexex, aa);
                    } else {
                        double num = 0;
                        if (model.getValueAt(i, c) != null && !model.getValueAt(i, c).toString().equals("")) {
                            if (model.getValueAt(i, c).toString().indexOf("%") > 0) {
                                aa = model.getValueAt(i, c).toString();
                                addLabel(sheet, c, indexex, aa);
                            } else {
                                num = Double.parseDouble(PUtility.ConvertReal(model.getValueAt(i, c).toString()));
                                addNumber(sheet, c, indexex, num);
                            }
                        }

                    }
                } else {
                    if (c == 0 && model.getValueAt(i, c) != null) {
                        aa = model.getValueAt(i, c).toString();
                    }
                    addLabelNoAutosize(sheet, c, indexex, aa, 8000);
                }
//                /// Sum ทั้งหมด
//                if (c + 1 == model.getColumnCount()) {
//                    if (i + 1 == model.getRowCount()) {
//                        addLabel(sheet, 2, indexex + 2, "จำนวนข้อมูลทั้งหมด " + model.getRowCount() + " รายการ");
//                    }
//                }
                e++;
                indexex++;

            }

            indexex = 1;
        }
        model.collapseAll();

    }

    public void createContentNoSum(WritableSheet sheet, JXTreeTable model) throws WriteException,
            RowsExceededException {
        model.expandAll();
        int e = 0;
        int indexex = 1;
        int rowcount = model.getRowCount();
        int colcount = model.getColumnCount();
        for (int c = 0; c < colcount; c++) {
            for (int i = 0; i < rowcount; i++) {
                String aa = "";
                if (c != 0) {
                    TableCellRenderer tc = model.getCellRenderer(i, c);
                    DefaultTableCellRenderer d = (DefaultTableCellRenderer) tc;

                    if (d.getHorizontalAlignment() != 4) {
                        if (model.getValueAt(i, c) != null) {
                            aa = model.getValueAt(i, c).toString();
                        }
                        addLabel(sheet, c, indexex, aa);
                    } else {
                        double num = 0;
                        if (model.getValueAt(i, c) != null && !model.getValueAt(i, c).toString().equals("")) {
                            if (model.getValueAt(i, c).toString().indexOf("%") > 0) {
                                aa = model.getValueAt(i, c).toString();
                                addLabel(sheet, c, indexex, aa);
                            } else {
                                num = Double.parseDouble(PUtility.ConvertReal(model.getValueAt(i, c).toString()));
                                addNumber(sheet, c, indexex, num);
                            }
                        }

                    }
                } else {
                    if (c == 0 && model.getValueAt(i, c) != null) {
                        aa = model.getValueAt(i, c).toString();
                    }
                    addLabelNoAutosize(sheet, c, indexex, aa, 8000);
                }
//                /// Sum ทั้งหมด
//                if (c + 1 == model.getColumnCount()) {
//                    if (i + 1 == model.getRowCount()) {
//                        addLabel(sheet, 2, indexex + 2, "จำนวนข้อมูลทั้งหมด " + model.getRowCount() + " รายการ");
//                    }
//                }
                e++;
                indexex++;

            }

            indexex = 1;
        }
        model.collapseAll();

    }

    public void createContentNoSum2(WritableSheet sheet, JTable model) throws WriteException,
            RowsExceededException {

        int e = 0;
        int indexex = 1;
        int rowcount = model.getRowCount();
        int colcount = model.getColumnCount();
        for (int c = 0; c < colcount; c++) {

            for (int i = 0; i < rowcount; i++) {
                String aa = "";
                if (c != 0) {
                    TableCellRenderer tc = model.getCellRenderer(i, c);
                    DefaultTableCellRenderer d = (DefaultTableCellRenderer) tc;

                    if (d.getHorizontalAlignment() != 4) {
                        if (model.getValueAt(i, c) != null) {
                            aa = model.getValueAt(i, c).toString();
                        }
                        addLabel(sheet, c, indexex, aa);
                    } else {
                        double num = 0;
                        if (model.getValueAt(i, c) != null && !model.getValueAt(i, c).toString().equals("")) {

                            if (model.getValueAt(i, c).toString().indexOf("%") > 0) {
                                aa = model.getValueAt(i, c).toString();
                                addLabel(sheet, c, indexex, aa);
                            } else {
                                num = Double.parseDouble(PUtility.ConvertReal(model.getValueAt(i, c).toString()));
                                addNumber(sheet, c, indexex, num);
                            }
                        }

                    }
                } else {
                    if (c == 0 && model.getValueAt(i, c) != null) {
                        aa = model.getValueAt(i, c).toString();
                    }
                    addLabelNoAutosize(sheet, c, indexex, aa, 8000);
                }

//                /// Sum ทั้งหมด
//                if (c + 1 == model.getColumnCount()) {
//                    if (i + 1 == model.getRowCount()) {
//                        addLabel(sheet, 2, indexex + 2, "จำนวนข้อมูลทั้งหมด " + model.getRowCount() + " รายการ");
//                    }
//                }
                e++;
                indexex++;

            }

            indexex = 1;
        }

    }

    public void addCaption(WritableSheet sheet, int column, int row, String s)
            throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, s, timesBoldUnderline);
        sheet.addCell(label);

    }

    public void addNumber(WritableSheet sheet, int column, int row,
            double integer) throws WriteException, RowsExceededException {
        Number number;
        number = new Number(column, row, integer, times);
        sheet.addCell(number);
    }

    public void addLabel(WritableSheet sheet, int column, int row, String s)
            throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, times);
        sheet.addCell(label);
        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);
        sheet.setColumnView(column, cv);
    }

    public void addLabelNoAutosize(WritableSheet sheet, int column, int row, String s, int size)
            throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, times);
        sheet.addCell(label);
        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setSize(size);
        sheet.setColumnView(column, cv);
    }

    public static void main(String[] args) throws WriteException, IOException {
        Export2Excel test = new Export2Excel();
        test.setOutputFile("/home/natee/Desktop/test.xls");
//    test.write();
        System.out.println("Please check the result file under /home/natee/Desktop/test.xls ");
    }

    public void createHeadAndCondition(WritableSheet sheet, TableColumnModel header, String condition)
            throws WriteException {
        // Lets create a times font
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        //times.setWrap(true);

        // Create create a bold font with unterlines
        WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
                UnderlineStyle.SINGLE);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        // Lets automatically wrap the cells
        //timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);
        String[] head, head1 = new String[2];
        int hcount = header.getColumnCount();

        addCaption(sheet, 0, 0, condition);
        for (int h = 0; h < hcount; h++) {
            String head11 = header.getColumn(h).getHeaderValue() + "";
            if (head11.indexOf("<html>") >= 0) {
                head = head11.split("<html>");
                head1 = head[1].split("<br>");
                addCaption(sheet, h, 1, head1[0] + head1[1]);
            } else {
                addCaption(sheet, h, 1, header.getColumn(h).getHeaderValue().toString());
            }
        }
    }

    public void createHead(WritableSheet sheet, TableColumnModel header)
            throws WriteException {
        // Lets create a times font
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        //times.setWrap(true);

        // Create create a bold font with unterlines
        WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
                UnderlineStyle.SINGLE);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        // Lets automatically wrap the cells
        //timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);
        String[] head, head1 = new String[2];
        int hcount = header.getColumnCount();

        for (int h = 0; h < hcount; h++) {
            String head11 = header.getColumn(h).getHeaderValue() + "";
            if (head11.indexOf("<html>") >= 0) {
                head = head11.split("<html>");
                head1 = head[1].split("<br>");
                addCaption(sheet, h, 0, head1[0] + head1[1]);
            } else {
                addCaption(sheet, h, 0, header.getColumn(h).getHeaderValue().toString());
            }
        }
    }

    public void createContentNoSum3(WritableSheet sheet, JTable model) throws WriteException,
            RowsExceededException {

        int e = 0;
        int indexex = 2;
        int rowcount = model.getRowCount();
        int colcount = model.getColumnCount();
        for (int c = 0; c < colcount; c++) {
            for (int i = 0; i < rowcount; i++) {
                String aa = "";
                if (c != 0) {
                    TableCellRenderer tc = model.getCellRenderer(i, c);
                    DefaultTableCellRenderer d = (DefaultTableCellRenderer) tc;

                    if (d.getHorizontalAlignment() != 4) {
                        if (model.getValueAt(i, c) != null) {
                            aa = model.getValueAt(i, c).toString();
                        }
                        addLabel(sheet, c, indexex, aa);
                    } else {
                        double num = 0;
                        if (model.getValueAt(i, c) != null && !model.getValueAt(i, c).toString().equals("")) {

                            if (model.getValueAt(i, c).toString().indexOf("%") > 0) {
                                aa = model.getValueAt(i, c).toString();
                                addLabel(sheet, c, indexex, aa);
                            } else {
                                formatDateNumber f = new formatDateNumber();
                                if (f.isNumberic(PUtility.ConvertReal(model.getValueAt(i, c).toString()))) {
                                    num = Double.parseDouble(PUtility.ConvertReal(model.getValueAt(i, c).toString()));
                                    addNumber(sheet, c, indexex, num);
                                } else {
                                    aa = model.getValueAt(i, c).toString();
                                    addLabel(sheet, c, indexex, aa);
                                }
                            }
                        }

                    }
                } else {
                    if (c == 0 && model.getValueAt(i, c) != null) {
                        aa = model.getValueAt(i, c).toString();
                    }
                    addLabelNoAutosize(sheet, c, indexex, aa, 8000);
                }
                e++;
                indexex++;

            }

            indexex = 2;
        }

    }

    public void createContentNoSum3NoHead(WritableSheet sheet, JTable model) throws WriteException,
            RowsExceededException {

        int e = 0;
        int indexex = 1;
        int rowcount = model.getRowCount();
        int colcount = model.getColumnCount();
        for (int c = 0; c < colcount; c++) {
            for (int i = 0; i < rowcount; i++) {
                String aa = "";
                if (c != 0) {
                    TableCellRenderer tc = model.getCellRenderer(i, c);
                    DefaultTableCellRenderer d = (DefaultTableCellRenderer) tc;

                    if (d.getHorizontalAlignment() != 4) {
                        if (model.getValueAt(i, c) != null) {
                            aa = model.getValueAt(i, c).toString();
                        }
                        addLabel(sheet, c, indexex, aa);
                    } else {
                        double num = 0;
                        if (model.getValueAt(i, c) != null && !model.getValueAt(i, c).toString().equals("")) {

                            if (model.getValueAt(i, c).toString().indexOf("%") > 0) {
                                aa = model.getValueAt(i, c).toString();
                                addLabel(sheet, c, indexex, aa);
                            } else {
                                formatDateNumber f = new formatDateNumber();
                                if (f.isNumberic(PUtility.ConvertReal(model.getValueAt(i, c).toString()))) {
                                    num = Double.parseDouble(PUtility.ConvertReal(model.getValueAt(i, c).toString()));
                                    addNumber(sheet, c, indexex, num);
                                } else {
                                    aa = model.getValueAt(i, c).toString();
                                    addLabel(sheet, c, indexex, aa);
                                }
                            }
                        }

                    }
                } else {
                    if (c == 0 && model.getValueAt(i, c) != null) {
                        aa = model.getValueAt(i, c).toString();
                    }
                    addLabelNoAutosize(sheet, c, indexex, aa, 900);
                }
                e++;
                indexex++;

            }

            indexex = 1;
        }

    }

    public void writetableToUsergroup(JTable table, TableColumnModel header, String condition) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createHeadAndCondition(excelSheet, header, condition);
        createContentToUserGroup(excelSheet, table);

        workbook.write();
        workbook.close();
    }

    public void createContentToUserGroup(WritableSheet sheet, JTable model) throws WriteException,
            RowsExceededException {

        int e = 0;
        int indexex = 2;
        int rowcount = model.getRowCount();
        int colcount = model.getColumnCount();
        for (int c = 0; c < colcount; c++) {
            for (int i = 0; i < rowcount; i++) {
                String aa = "";
                if (model.getValueAt(i, c) != null) {
                    aa = model.getValueAt(i, c).toString();
                }
                if (c == 3) {
                    if (aa.equals("true")) {
                        aa = "Y";
                    } else {
                        aa = "N";
                    }
                }
                addLabel(sheet, c, indexex, aa);

                e++;
                indexex++;

            }

            indexex = 2;
        }

    }

    public void createContentNoSumTreeReport(WritableSheet sheet, JXTreeTable model) throws WriteException,
            RowsExceededException {
        model.expandAll();
        int e = 0;
        int indexex = 2;
        int rowcount = model.getRowCount();
        int colcount = model.getColumnCount();
        for (int c = 0; c < colcount; c++) {
            for (int i = 0; i < rowcount; i++) {
                String aa = "";
                if (c != 0) {
                    TableCellRenderer tc = model.getCellRenderer(i, c);
                    DefaultTableCellRenderer d = (DefaultTableCellRenderer) tc;

                    if (d.getHorizontalAlignment() != 4) {
                        if (model.getValueAt(i, c) != null) {
                            aa = model.getValueAt(i, c).toString();
                        }
                        addLabel(sheet, c, indexex, aa);
                    } else {
                        double num = 0;
                        if (model.getValueAt(i, c) != null && !model.getValueAt(i, c).toString().equals("")) {

                            if (model.getValueAt(i, c).toString().indexOf("%") > 0) {
                                aa = model.getValueAt(i, c).toString();
                                addLabel(sheet, c, indexex, aa);
                            } else {
                                try {
                                    num = Double.parseDouble(PUtility.ConvertReal(model.getValueAt(i, c).toString()));
                                    addNumber(sheet, c, indexex, num);
                                } catch (NumberFormatException  e2) {
                                    e2.printStackTrace();
                                }

                            }
                        }

                    }
                } else {

                    if (c == 0 && model.getValueAt(i, c) != null) {
                        aa = model.getValueAt(i, c).toString();
                    }
                    addLabelNoAutosize(sheet, c, indexex, aa, 8000);
                }
//                /// Sum ทั้งหมด
//                if (c + 1 == model.getColumnCount()) {
//                    if (i + 1 == model.getRowCount()) {
//                        addLabel(sheet, 2, indexex + 2, "จำนวนข้อมูลทั้งหมด " + model.getRowCount() + " รายการ");
//                    }
//                }
                e++;
                indexex++;

            }

            indexex = 2;
        }
        model.collapseAll();

    }

    public void writetableSheet(JTable[] jTable, String[] strCondition, String[] strSheetName) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);

        for (int i = 0; i < jTable.length; i++) {
            if (i == 0) {
                workbook.createSheet(strSheetName[i], i);
                WritableSheet excelSheet = workbook.getSheet(i);
                createHeadAndCondition(excelSheet, jTable[i].getColumnModel(), strCondition[i]);
                createContentNoSum3(excelSheet, jTable[i]);
            } else {
                try {
                    workbook.createSheet(strSheetName[i], i);
                    WritableSheet excelSheet2 = workbook.getSheet(i);
                    createHeadAndCondition(excelSheet2, jTable[i].getColumnModel(), strCondition[i]);
                    createContentNoSum3(excelSheet2, jTable[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        workbook.write();
        workbook.close();
    }

    public void writeTreetableContditionNoSum(JTable jTable1, TableColumnModel columnModel, String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
