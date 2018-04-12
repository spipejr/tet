/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom;
//ingredent_bom.standardcostFactory
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author natee
 */
public class standardcostFactory {

    public static ArrayList<String> group = new ArrayList<String>();
    public static ArrayList<String> pcode = new ArrayList<String>();
    public static ArrayList<String> pdesc = new ArrayList<String>();
    public static ArrayList<Double> pscost = new ArrayList<Double>();
    public static ArrayList<String> punit1 = new ArrayList<String>();
    public static ArrayList<String> bomacc = new ArrayList<String>();

    public standardcostFactory() {
        this.group.clear();
        this.pcode.clear();
        this.pdesc.clear();
        this.pscost.clear();
        this.punit1.clear();
        this.bomacc.clear();
    }

    public standardcostFactory(String group, String pcode, String pdesc, Double pscost, String punit1, String bomacc) {
        this.group.add(group);
        this.pcode.add(pcode);
        this.pdesc.add(pdesc);
        this.pscost.add(pscost);
        this.punit1.add(punit1);
        this.bomacc.add(bomacc);
    }

    public static Collection<standardcost> createBeanCollection() {
        Collection<standardcost> col = new ArrayList();
        int _size = pcode.size();

        for (int i = 0; i < _size; i++) {
            col.add(new standardcost(group.get(i), pcode.get(i), pdesc.get(i), pscost.get(i), punit1.get(i), bomacc.get(i)));
        }

        return col;
    }
}
