/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom_other;

import java.util.ArrayList;
import java.util.Collection;
//ingredent_bom_other.bommornFactory
/**
 *
 * @author user
 */
public class bommornFactory {

    public static ArrayList<String> pcode = new ArrayList<String>();
    public static ArrayList<String> pdesc = new ArrayList<String>();
    public static ArrayList<String> pgroup = new ArrayList<String>();
    public static ArrayList<String> groupname = new ArrayList<String>();
    public static ArrayList<String> punit1 = new ArrayList<String>();
    public static ArrayList<String> psubunit = new ArrayList<String>();
    public static ArrayList<Double> pscale = new ArrayList<Double>();
    public static ArrayList<Double> pacost = new ArrayList<Double>();
    public static ArrayList<String> bomacc = new ArrayList<String>();
    public static ArrayList<String> account = new ArrayList<String>();
    public static ArrayList<String> fix = new ArrayList<String>();

    public bommornFactory() {
        this.pcode.clear();
        this.pdesc.clear();
        this.pgroup.clear();
        this.groupname.clear();
        this.punit1.clear();
        this.psubunit.clear();
        this.pscale.clear();
        this.pacost.clear();
        this.bomacc.clear();
        this.account.clear();
        this.fix.clear();
    }

    public bommornFactory(String pcode, String pdesc, String pgroup, String groupname, String punit1,
            String psubunit, Double pscale, Double pacost, String bomacc, String account,
            String fix) {
        this.pcode.add(pcode);
        this.pdesc.add(pdesc);
        this.pgroup.add(pgroup);
        this.groupname.add(groupname);
        this.punit1.add(punit1);
        this.psubunit.add(psubunit);
        this.pscale.add(pscale);
        this.pacost.add(pacost);
        this.bomacc.add(bomacc);
        this.account.add(account);
        this.fix.add(fix);
    }
    
    public static Collection<bommorn> createBeanCollection() {
        Collection<bommorn> col = new ArrayList();
        int _size = pcode.size();

        for (int i = 0; i < _size; i++) {
            col.add(new bommorn(pcode.get(i), pdesc.get(i), pgroup.get(i), groupname.get(i), 
                    punit1.get(i), psubunit.get(i), pscale.get(i), pacost.get(i), bomacc.get(i), 
                    account.get(i), fix.get(i)));
        }

        return col;
    }
}
