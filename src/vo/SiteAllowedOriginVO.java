package vo;

import java.util.ArrayList;
import java.util.List;

public class SiteAllowedOriginVO {

    /**
     * site ID
     */
    private long siteID = -1;

    /**
     * itemValue
     */
    private String itemValue = "allowedOrigins";

    /** allowed Origins */
    private List<String> allowedOrigins = new ArrayList<>();

    public long getSiteID() {
        return siteID;
    }

    public void setSiteID(long siteID) {
        this.siteID = siteID;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public void addAllowedOrigins(String newOrigins) {
        this.allowedOrigins.add(newOrigins);
    }
}
