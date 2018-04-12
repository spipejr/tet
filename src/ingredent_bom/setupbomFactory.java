/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;
//ingredent_bom.setupbomFactory
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author natee
 */
public class setupbomFactory {
    public static ArrayList<Integer> formula = new ArrayList<Integer>();
    public static ArrayList<String> plcode = new ArrayList<String>();
    public static ArrayList<String> plname = new ArrayList<String>();
    public static ArrayList<Double> pqty = new ArrayList<Double>();
    public static ArrayList<String> psubunit = new ArrayList<String>();
    public static ArrayList<String> saletype = new ArrayList<String>();
    
    public setupbomFactory() {
        this.formula.clear();
        this.plcode.clear();
        this.plname.clear();
        this.pqty.clear();
        this.psubunit.clear();
        this.saletype.clear();
    }
    
    public setupbomFactory(int formula,String plcode, String plname, Double pqty, String psubunit, String saletype) {
        this.formula.add(formula);
        this.plcode.add(plcode);
        this.plname.add(plname);
        this.pqty.add(pqty);
        this.psubunit.add(psubunit);
        this.saletype.add(saletype);
    }
    
    public static Collection<setupbom> createBeanCollection() {
        Collection<setupbom> col = new ArrayList();
        int _size = plcode.size();

        for (int i = 0; i < _size; i++) {
            col.add(new setupbom(formula.get(i), plcode.get(i), plname.get(i), pqty.get(i), psubunit.get(i), saletype.get(i)));
        }

        return col;
    }
}
