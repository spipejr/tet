/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package borfunction;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author s386
 */
public class GetComputerName {
    public String getComputerName()
    {   
        String computername= "";
        try {
            computername = InetAddress.getLocalHost().getHostName();
            
        } catch (UnknownHostException ex) {
        }
        return computername;
    }
}
