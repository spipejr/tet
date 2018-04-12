package EStamp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pos
 */
public class reportEStampGive_Bean {

    private String u_barcode;
    private String u_campaign;
    private String u_refno;
    private String u_date;
    private String u_time;
    private String u_point;

    public List<reportEStampGive_Bean> children = new ArrayList<reportEStampGive_Bean>();

    public reportEStampGive_Bean(String u_barcode, String u_campaign, String u_refno, String u_date, String u_time, String u_point) {
        this.u_barcode = u_barcode;
        this.u_campaign = u_campaign;
        this.u_refno = u_refno;
        this.u_date = u_date;
        this.u_time = u_time;
        this.u_point = u_point;
    }

    public String getU_barcode() {
        return u_barcode;
    }

    public void setU_barcode(String u_barcode) {
        this.u_barcode = u_barcode;
    }

    public String getU_campaign() {
        return u_campaign;
    }

    public void setU_campaign(String u_campaign) {
        this.u_campaign = u_campaign;
    }

    public String getU_refno() {
        return u_refno;
    }

    public void setU_refno(String u_refno) {
        this.u_refno = u_refno;
    }

    public String getU_date() {
        return u_date;
    }

    public void setU_date(String u_date) {
        this.u_date = u_date;
    }

    public String getU_time() {
        return u_time;
    }

    public void setU_time(String u_time) {
        this.u_time = u_time;
    }

    public String getU_point() {
        return u_point;
    }

    public void setU_point(String u_point) {
        this.u_point = u_point;
    }

    public List<reportEStampGive_Bean> getChildren() {
        return children;
    }

    public void setChildren(List<reportEStampGive_Bean> children) {
        this.children = children;
    }

    reportEStampGive_Bean() {

    }

}
