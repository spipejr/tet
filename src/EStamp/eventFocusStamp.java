/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EStamp;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;

/**
 *
 * @author natee
 */
public class eventFocusStamp {

    formatStamp f = new formatStamp();
    Double d;
    String data;

    public void setFocusSwingNumber(final JTextField textfield, final String defa, final DecimalFormat sim) {
        textfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                data = f.convertDoubleString(textfield.getText().trim());
                if (data.length() > 0) {
                    if (f.isNumberic(data)) {
                        textfield.setText(data);
                    } else {
                        textfield.setText(defa);
                    }
                } else {
                    textfield.setText(defa);
                }
                textfield.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                data = f.convertDoubleString(textfield.getText().trim());
                if (data.length() > 0) {
                    if (f.isNumberic(data)) {
                        d = Double.parseDouble(data);
                        textfield.setText(sim.format(d));
                    } else {
                        textfield.setText(defa);
                    }
                } else {
                    textfield.setText(defa);
                }
            }
        });
    }

    public void setFocusSwing(final JTextField textfield) {
        textfield.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                data = textfield.getText();
                if (data.length() > 0) {
                    textfield.selectAll();
                } else {
                    textfield.setText("0");
                    textfield.selectAll();
                    textfield.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });
    }
}
