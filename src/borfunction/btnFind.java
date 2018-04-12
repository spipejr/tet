/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package borfunction;

import frmlist.*;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import masterfile.NimbusFrame;
import masterfile.VoidConfigSetup;
import utilities.DateChooser.DateChooserDialog;
import utilititiesfunction.Format;

/**
 *
 * @author s386
 */
public class btnFind {

    public void btnFindDept(JTextField textfield) {
        listGroupfile f = new listGroupfile(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.code.equals("")) {
            textfield.setText(f.code);
            textfield.requestFocus();
        }
    }

    public void btnFindPlu(JTextField textfield) {
        ListProduct f = new ListProduct(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.code.equals("")) {
            textfield.setText(f.code);
            textfield.requestFocus();
        }
    }

    public void btnFindPluAll(JTextField textfield) {
        ListProductAll f = new ListProductAll(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.code.equals("")) {
            textfield.setText(f.code);
            textfield.requestFocus();
        }
    }

    public void btnFindCupon(JTextField textfield) {
        listPoint f = new listPoint(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnFindBranch(JTextField textfield) {
        ListBranch f = new ListBranch(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.code.equals("")) {
            textfield.setText(f.code);
            textfield.requestFocus();
        }
    }

    public void btnFindBtype(JTextField textfield) {
        listBtype f = new listBtype(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnvoidconfig(JTextField textfield) {
        Browservoidconfig f = new Browservoidconfig(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.code.equals("")) {
            textfield.setText(f.code);
            textfield.requestFocus();
        }
    }

    public void btncashierNumber(JTextField textfield) {
        CashierNumber f = new CashierNumber(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnFindBarea(JTextField textfield) {
        listArea f = new listArea(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnFindBsize(JTextField textfield) {
        listSize f = new listSize(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnFindBplan(JTextField textfield) {
        listPlane f = new listPlane(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnFindBstore(JTextField textfield) {
        listStore f = new listStore(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnFindCompany(JTextField textfield) {
        listCompany f = new listCompany(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnFindBrand(JTextField textfield) {
        listBrand f = new listBrand(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnFindBusType(JTextField textfield) {
        listBustype f = new listBustype(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnFindPromotion(JTextField textfield) {
        listPromotion f = new listPromotion(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.bcode.equals("")) {
            textfield.setText(f.bcode);
            textfield.requestFocus();
        }
    }

    public void btnFindIngGroup(JTextField textfield) {
        listIngGroup f = new listIngGroup(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.code.equals("")) {
            textfield.setText(f.code);
            textfield.requestFocus();
        }
    }

    public void btnFindIng(JTextField textfield) {
        ListIngredent f = new ListIngredent(new NimbusFrame(), true);
        f.setVisible(true);
        if (!f.code.equals("")) {
            textfield.setText(f.code);
            textfield.requestFocus();
        }
    }

    public GregorianCalendar btncalendar(JFormattedTextField txt, JButton btn) {

        try {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            GregorianCalendar cal;
            DateChooserDialog dcd = new DateChooserDialog(new javax.swing.JFrame(), true, btn.getLocationOnScreen());
            dcd.setVisible(true);
            if (dcd.getSelectedDate() != null) {
                cal = (GregorianCalendar) dcd.getSelectedDate();
                txt.setText(fmt.format(cal.getTime()));
                txt.requestFocus();
            } else {
                return null;
            }
            return cal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public GregorianCalendar btncalendar2(JFormattedTextField txt, JButton btn) {

        try {
            SimpleDateFormat fmt = new SimpleDateFormat("MMM/yyyy");
            GregorianCalendar cal;
            DateChooserDialog dcd = new DateChooserDialog(new javax.swing.JFrame(), true, btn.getLocationOnScreen());
            dcd.setVisible(true);
            if (dcd.getSelectedDate() != null) {
                cal = (GregorianCalendar) dcd.getSelectedDate();
                txt.setText(fmt.format(cal.getTime()));
                txt.requestFocus();
            } else {
                return null;
            }
            return cal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
