/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredent_bom.s_bom;
//ingredent_bom.s_bom.sbomfactory

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author natee
 */
public class sbomfactory {
    public static ArrayList<String> date = new ArrayList<String>();
    public static ArrayList<String> branch = new ArrayList<String>();
    public static ArrayList<String> dept = new ArrayList<String>();
    public static ArrayList<String> bomacc = new ArrayList<String>();
    public static ArrayList<String> pcode = new ArrayList<String>();
    public static ArrayList<Double> pqty = new ArrayList<Double>();
    public static ArrayList<String> plbomacc = new ArrayList<String>();
    public static ArrayList<String> plcode = new ArrayList<String>();
    public static ArrayList<Double> plqty = new ArrayList<Double>();
    public static ArrayList<Double> price = new ArrayList<Double>();
    public static ArrayList<Double> amount = new ArrayList<Double>();
    
    public sbomfactory() {
        this.date.clear();
        this.branch.clear();
        this.dept.clear();
        this.bomacc.clear();
        this.pcode.clear();
        this.pqty.clear();
        this.plbomacc.clear();
        this.plcode.clear();
        this.plqty.clear();
        this.price.clear();
        this.amount.clear();
    }
    
    public sbomfactory(String date, String bran, String dept, String bomacc,
            String pcode, double pqty, String plbomacc, String plcode, double plqty, double price, double amount) {
        this.date.add(date);
        this.branch.add(bran);
        this.dept.add(dept);
        this.bomacc.add(bomacc);
        this.pcode.add(pcode);
        this.pqty.add(pqty);
        this.plbomacc.add(plbomacc);
        this.plcode.add(plcode);
        this.plqty.add(plqty);
        this.price.add(price);
        this.amount.add(amount);
    }
    
    public static Collection<sbom> createBeanCollection() {
        Collection<sbom> col = new ArrayList();
        int _size = pcode.size();

        for (int i = 0; i < _size; i++) {
            col.add(new sbom(date.get(i), branch.get(i), dept.get(i), bomacc.get(i), 
                    pcode.get(i), pqty.get(i), 
                    plbomacc.get(i), plcode.get(i), 
                    plqty.get(i), price.get(i), amount.get(i)));
        }

        return col;
    }
}
