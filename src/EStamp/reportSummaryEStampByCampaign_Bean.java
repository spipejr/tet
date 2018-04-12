package EStamp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pos
 */
public class reportSummaryEStampByCampaign_Bean {

    private String campaign;
    private String dateStr;
    private String dateEnd;
    private String point;
    private String redeem;

    public List<reportSummaryEStampByCampaign_Bean> children = new ArrayList<reportSummaryEStampByCampaign_Bean>();

    public reportSummaryEStampByCampaign_Bean(String campaign, String dateStr, String dateEnd, String point, String redeem) {
        this.campaign = campaign;
        this.dateStr = dateStr;
        this.dateEnd = dateEnd;
        this.point = point;
        this.redeem = redeem;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
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

    public List<reportSummaryEStampByCampaign_Bean> getChildren() {
        return children;
    }

    public void setChildren(List<reportSummaryEStampByCampaign_Bean> children) {
        this.children = children;
    }

    reportSummaryEStampByCampaign_Bean() {

    }

}
