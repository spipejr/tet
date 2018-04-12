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
public class reportPlaceAvgBean {
    private String code;
    private String name;
    private String branch;
    private String branchname;
    private String b1;
    private String b2;
    private String b3;
    private String b4;
    private String b5;
    private String b6;
    private String b7;
    private String b8;
    private String b9;
    
    public List<reportPlaceAvgBean> children = new ArrayList<reportPlaceAvgBean>();

    public reportPlaceAvgBean(String code, String name, String branch, String branchname, String b1, String b2, String b3, String b4, String b5, String b6, String b7, String b8, String b9) {
        this.code = code;
        this.name = name;
        this.branch = branch;
        this.branchname = branchname;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
        this.b6 = b6;
        this.b7 = b7;
        this.b8 = b8;
        this.b9 = b9;
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

    public String getB4() {
        return b4;
    }

    public void setB4(String b4) {
        this.b4 = b4;
    }

    public String getB5() {
        return b5;
    }

    public void setB5(String b5) {
        this.b5 = b5;
    }

    public String getB6() {
        return b6;
    }

    public void setB6(String b6) {
        this.b6 = b6;
    }

    public String getB7() {
        return b7;
    }

    public void setB7(String b7) {
        this.b7 = b7;
    }

    public String getB8() {
        return b8;
    }

    public void setB8(String b8) {
        this.b8 = b8;
    }

    public String getB9() {
        return b9;
    }

    public void setB9(String b9) {
        this.b9 = b9;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public List<reportPlaceAvgBean> getChildren() {
        return children;
    }

    public void setChildren(List<reportPlaceAvgBean> children) {
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

    public reportPlaceAvgBean() {
    }
    
    
}
