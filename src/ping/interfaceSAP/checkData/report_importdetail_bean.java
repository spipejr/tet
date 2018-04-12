/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping.interfaceSAP.checkData;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pos
 */
public class report_importdetail_bean {

    private String pcode;
    private String pdesc;
    public List<report_importdetail_bean> children = new ArrayList<report_importdetail_bean>();

    public report_importdetail_bean() {

    }
    
     public report_importdetail_bean(String pcode, String pdesc) {
         this.pcode = pcode;
         this.pdesc = pdesc;
     }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public List<report_importdetail_bean> getChildren() {
        return children;
    }

    public void setChildren(List<report_importdetail_bean> children) {
        this.children = children;
    }
     
     
}
