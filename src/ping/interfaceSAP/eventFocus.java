/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;

/**
 *
 * @author natee
 */
public class eventFocus {

    formatDateNum f = new formatDateNum();
    Double d;
    String data;
    
    public void setMaxKeyChar(final JTextField txtfield, final int max) {
        txtfield.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (txtfield.getText().length() >= max) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

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
