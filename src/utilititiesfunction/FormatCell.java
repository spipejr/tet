/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilititiesfunction;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author s386
 */
public class FormatCell {

    public static DefaultTableCellRenderer r() {
        DefaultTableCellRenderer r;
        r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(SwingConstants.RIGHT);
        return r;

    }

    public static DefaultTableCellRenderer c() {
        DefaultTableCellRenderer c;
        c = new DefaultTableCellRenderer();
        c.setHorizontalAlignment(SwingConstants.CENTER);

        return c;
    }

    public static DefaultTableCellRenderer l() {
        DefaultTableCellRenderer l;
        l = new DefaultTableCellRenderer();
        l.setHorizontalAlignment(SwingConstants.LEFT);
        return l;
    }

    public static DefaultTableCellRenderer color1() {
        DefaultTableCellRenderer color1;
        color1 = new DefaultTableCellRenderer();
        color1.setHorizontalAlignment(SwingConstants.RIGHT);
        color1.setBackground(new Color(190, 253, 207));
        return color1;
    }

    public static DefaultTableCellRenderer color2() {
        DefaultTableCellRenderer color2;
        color2 = new DefaultTableCellRenderer();
        color2.setHorizontalAlignment(SwingConstants.RIGHT);
        color2.setBackground(new Color(255, 253, 207));
        return color2;
    }

    public static DefaultTableCellRenderer centerColor() {
        DefaultTableCellRenderer color2;
        color2 = new DefaultTableCellRenderer();
        color2.setHorizontalAlignment(SwingConstants.CENTER);
        color2.setBackground(new Color(210, 254, 250));
        return color2;
    }

    public static DefaultTableCellRenderer colorL() {
        DefaultTableCellRenderer color1;
        color1 = new DefaultTableCellRenderer();
        color1.setHorizontalAlignment(SwingConstants.LEFT);
        color1.setBackground(new Color(190, 253, 207));
        return color1;
    }
}
