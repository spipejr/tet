/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package borfunction;

import javax.swing.JTextField;

/**
 *
 * @author s386
 */
public class settext {
    public static void setTextLength(java.awt.event.KeyEvent evt,JTextField txt,int length) {                                  
        if (txt.getText().length() >= length) {
            evt.consume();
        }
        // TODO add your handling code here:
    } 
}
