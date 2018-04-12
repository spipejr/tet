package utilititiesfunction;

import java.text.Format;
import javax.swing.table.DefaultTableCellRenderer;

public class TableTestFormatRenderer extends DefaultTableCellRenderer {

    private Format formatter;

    public TableTestFormatRenderer(Format formatter) {
        if (formatter == null) {
            throw new NullPointerException();
        }
        this.formatter = formatter;
    }

    protected void setValue(Object obj) {
        setText(obj == null ? "" : formatter.format(obj));
    }
}
