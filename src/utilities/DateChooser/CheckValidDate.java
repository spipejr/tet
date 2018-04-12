/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.DateChooser;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author natee
 */
public class CheckValidDate {
    
     public boolean CheckValidDate(String input) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatter.setLenient(false);

        ParsePosition pp = new ParsePosition(0);
        Date invoiceDate = dateFormatter.parse(input, pp);
        if (pp.getErrorIndex() != -1 || pp.getIndex() != input.length()) {
       //     System.out.println("bad date: " + input);
            return false;
        } else {
        //    System.out.println(invoiceDate);
            return true;
        }
    }
    
}
