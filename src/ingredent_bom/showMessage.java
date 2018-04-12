/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author natee
 */
public class showMessage {
    
    JLabel customFontText = new JLabel();
    Font f = new Font("Norasi", Font.PLAIN, 14);
    
    public showMessage() {
        customFontText.setFont(f);
    }
    
    public void showMessageInformation(String text) {
        customFontText.setText(text);
        JOptionPane.showMessageDialog(null, customFontText, "INFORMATION !!!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showMessageWarning(String text) {
        customFontText.setText(text);
        JOptionPane.showMessageDialog(null, customFontText, "WARNING !!!", JOptionPane.WARNING_MESSAGE);
    }
    
    public void showMessageError(String text) {
        customFontText.setText(text);
        JOptionPane.showMessageDialog(null, customFontText, "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    }
    
    public int showMessageConfirm(String yes, String no, String text) {
        Object[] options = {yes, no};
        customFontText.setText(text);
        int a = JOptionPane.showOptionDialog(null,
                customFontText,
                "CONFIRM DIALOG !!!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title
        return a;
    }
}
