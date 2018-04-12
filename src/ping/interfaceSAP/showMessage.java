/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author natee
 */
public class showMessage {

    JLabel customFontText = new JLabel();
    Font f = new Font("Norasi", Font.PLAIN, 14);

    public showMessage() {
        customFontText.setFont(f);
        UIManager.put("OptionPane.messageFont", f);
        UIManager.put("OptionPane.buttonFont", f);
    }

    public void showMessageInformation(String text, String title) {
        customFontText.setText(text);
        JOptionPane.showMessageDialog(null, customFontText, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMessageWarning(String text, String title) {
        customFontText.setText(text);
        JOptionPane.showMessageDialog(null, customFontText, title, JOptionPane.WARNING_MESSAGE);
    }

    public void showMessageError(String text, String title) {
        customFontText.setText(text);
        JOptionPane.showMessageDialog(null, customFontText, title, JOptionPane.ERROR_MESSAGE);
    }

    public boolean showMessageConfirm(String yes, String no, String text) {
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
        
        if (a == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
