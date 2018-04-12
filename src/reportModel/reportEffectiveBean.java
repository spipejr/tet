/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s386
 */
public class reportEffectiveBean {
    private String s_bran;
    private String code;
    private String name;
    private String price1;
    private String price2;
    private String price3;
    private String price4;
    private String price5;
    private String pro1;
    private String pro2;
    private String pro3;
    private String flage;
    
    public List<reportEffectiveBean> children = new ArrayList<reportEffectiveBean>();

    public reportEffectiveBean(String s_bran, String code, String name, String price1, String price2, String price3, String price4, String price5, String pro1, String pro2, String pro3, String flage) {
        this.s_bran = s_bran;
        this.code = code;
        this.name = name;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.price4 = price4;
        this.price5 = price5;
        this.pro1 = pro1;
        this.pro2 = pro2;
        this.pro3 = pro3;
        this.flage = flage;
    }

    public reportEffectiveBean() {
    }
    
    
    public List<reportEffectiveBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportEffectiveBean> children) {
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlage() {
        return flage;
    }

    public void setFlage(String flage) {
        this.flage = flage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getPrice3() {
        return price3;
    }

    public void setPrice3(String price3) {
        this.price3 = price3;
    }

    public String getPrice4() {
        return price4;
    }

    public void setPrice4(String price4) {
        this.price4 = price4;
    }

    public String getPrice5() {
        return price5;
    }

    public void setPrice5(String price5) {
        this.price5 = price5;
    }

    public String getPro1() {
        return pro1;
    }

    public void setPro1(String pro1) {
        this.pro1 = pro1;
    }

    public String getPro2() {
        return pro2;
    }

    public void setPro2(String pro2) {
        this.pro2 = pro2;
    }

    public String getPro3() {
        return pro3;
    }

    public void setPro3(String pro3) {
        this.pro3 = pro3;
    }

    public String getS_bran() {
        return s_bran;
    }

    public void setS_bran(String s_bran) {
        this.s_bran = s_bran;
    }

    
}
