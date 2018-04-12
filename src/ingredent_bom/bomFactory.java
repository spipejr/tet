/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;
//ingredent_bom.bomFactory

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author natee
 */
//ingredent_bom.bomFactory
public class bomFactory {

    public static ArrayList<String> pcode = new ArrayList<String>();
    public static ArrayList<String> pdesc = new ArrayList<String>();
    public static ArrayList<String> unit = new ArrayList<String>();
    public static ArrayList<Double> price = new ArrayList<Double>();
    public static ArrayList<Integer> qty = new ArrayList<Integer>();
    public static ArrayList<String> plcode = new ArrayList<String>();
    public static ArrayList<String> plname = new ArrayList<String>();
    public static ArrayList<Double> pqty = new ArrayList<Double>();
    public static ArrayList<String> psubunit = new ArrayList<String>();
    public static ArrayList<String> saletype = new ArrayList<String>();
    public static ArrayList<Integer> formula = new ArrayList<Integer>();
    public static ArrayList<String> pactive = new ArrayList<String>();

    public bomFactory() {
        this.pcode.clear();
        this.pdesc.clear();
        this.unit.clear();
        this.price.clear();
        this.qty.clear();
        this.plcode.clear();
        this.plname.clear();
        this.pqty.clear();
        this.psubunit.clear();
        this.saletype.clear();
        this.formula.clear();
        this.pactive.clear();
    }

    public bomFactory(String pcode, String pdesc, String unit, Double price, int qty,
            String plcode, String plname, Double pqty, String psubunit, String saletype,
            int formula, String pactive) {
        this.pcode.add(pcode);
        this.pdesc.add(pdesc);
        this.unit.add(unit);
        this.price.add(price);
        this.qty.add(qty);
        this.plcode.add(plcode);
        this.plname.add(plname);
        this.pqty.add(pqty);
        this.psubunit.add(psubunit);
        this.saletype.add(saletype);
        this.formula.add(formula);
        this.pactive.add(pactive);
    }

    public static Collection<bom> createBeanCollection() {
        Collection<bom> col = new ArrayList();
        int _size = pcode.size();

        for (int i = 0; i < _size; i++) {
            col.add(new bom(pcode.get(i), pdesc.get(i), unit.get(i), price.get(i), qty.get(i),
                    plcode.get(i), plname.get(i), pqty.get(i), psubunit.get(i), saletype.get(i), formula.get(i), pactive.get(i)));
        }

        return col;
    }
}
