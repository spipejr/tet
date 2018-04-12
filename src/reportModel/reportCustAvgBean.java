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
public class reportCustAvgBean {
     private String code;
    private String name;
    private String b1;
    private String b2;
    private String b3;
    
    public List<reportCustAvgBean> children = new ArrayList<reportCustAvgBean>();

    public reportCustAvgBean(String code, String name, String b1, String b2, String b3) {
        this.code = code;
        this.name = name;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
    }

    public reportCustAvgBean() {
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    public List<reportCustAvgBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportCustAvgBean> children) {
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
