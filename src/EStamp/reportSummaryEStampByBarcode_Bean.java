package EStamp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pos
 */
public class reportSummaryEStampByBarcode_Bean {

    private String campaign;
    private String custtel;
    private String custname;
    private String point;
    private String redeem;

    public List<reportSummaryEStampByBarcode_Bean> children = new ArrayList<reportSummaryEStampByBarcode_Bean>();

    public reportSummaryEStampByBarcode_Bean(String campaign, String custtel, String custname, String point, String redeem) {
        this.campaign = campaign;
        this.custtel = custtel;
        this.custname = custname;
        this.point = point;
        this.redeem = redeem;
    }

    public String getCusttel() {
        return custtel;
    }

    public void setCusttel(String custtel) {
        this.custtel = custtel;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getRedeem() {
        return redeem;
    }

    public void setRedeem(String redeem) {
        this.redeem = redeem;
    }

    public List<reportSummaryEStampByBarcode_Bean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSummaryEStampByBarcode_Bean> children) {
        this.children = children;
    }

    reportSummaryEStampByBarcode_Bean() {

    }

}
