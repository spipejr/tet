package EStamp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pos
 */
public class reportSummaryEStampByBranch_Bean {

    private String branch;
    private String campaogncode;
    private String campaognname;
    private String point;
    private String redeem;
//    private String point;
//    private String redeem;

    public List<reportSummaryEStampByBranch_Bean> children = new ArrayList<reportSummaryEStampByBranch_Bean>();

    public reportSummaryEStampByBranch_Bean(String branch, String campaogncode, String campaognname, String point, String redeem) {
        this.branch = branch;
        this.campaogncode = campaogncode;
        this.campaognname = campaognname;
        this.point = point;
        this.redeem = redeem;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCampaogncode() {
        return campaogncode;
    }

    public void setCampaogncode(String campaogncode) {
        this.campaogncode = campaogncode;
    }

    public String getCampaognname() {
        return campaognname;
    }

    public void setCampaognname(String campaognname) {
        this.campaognname = campaognname;
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

    public List<reportSummaryEStampByBranch_Bean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSummaryEStampByBranch_Bean> children) {
        this.children = children;
    }

    reportSummaryEStampByBranch_Bean() {

    }

}
