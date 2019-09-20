package vo;

import java.sql.Timestamp;

/**
 *
 * Mapping to WBXSITERENAME <br>
 *
 * @version 1.0
 */public class SiteInfoVO {

    /** site ID */
    private long siteID = -1;

    /** the old site name */
    private String oldSiteName = "";

    /** the new site name */
    private String newSiteName = "";

    /** the last modified time */
    private Timestamp lastModifiedTime = null;

    /** the domain name for current site*/
    private String domainName = "";

    /** the site URL */
    private String siteURL = "";

    private long oldSiteID=-1;
    private long newSiteID=-1;

    /**
     * Get site ID
     * @return
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Set site ID
     * @param siteID
     */
    public void setSiteID(long siteID) {
        this.siteID = siteID;
    }

    /**
     * Get old site name
     * @return
     */
    public String getOldSiteName() {
        return oldSiteName;
    }

    /**
     * Set old site name
     * @param oldSiteName
     */
    public void setOldSiteName(String oldSiteName) {
        this.oldSiteName = oldSiteName;
    }

    /**
     * Get new site name
     * @return
     */
    public String getNewSiteName() {
        return newSiteName;
    }

    /**
     * Set new site name
     * @param newSiteName
     */
    public void setNewSiteName(String newSiteName) {
        this.newSiteName = newSiteName;
    }

    // 12/2/2014 Craig Lin: for migrated siteID mapping
    /**
     * Get old site ID
     * @return
     */
    public long getOldSiteID() {
        return oldSiteID;
    }

    /**
     * Set old site ID
     * @param oldSiteID
     */
    public void setOldSiteID(long oldSiteID) {
        this.oldSiteID = oldSiteID;
    }

    /**
     * Get new site ID
     * @return
     */
    public long getNewSiteID() {
        return newSiteID;
    }

    /**
     * Set new site ID
     * @param newSiteID
     */
    public void setNewSiteID(long newSiteID) {
        this.newSiteID = newSiteID;
    }

    /**
     * get the last modified time
     * @return
     */
    public Timestamp getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * set the last modified time
     * @param lastModifiedTime
     */
    public void setLastModifiedTime(Timestamp lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * get domain name for current site
     * @return
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * set domain name for current site
     * @param domainName
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * Get site URL
     * @return
     */
    public String getSiteURL() {
        return siteURL;
    }

    /**
     * Set site URL
     * @param siteURL
     */
    public void setSiteURL(String siteURL) {
        this.siteURL = siteURL;
    }

    /**
     * To string
     */
    public String toString() {
        StringBuffer buf = new StringBuffer()
                .append(" \n  ----Site rename info ----:")
                .append(" \n domainName : " + this.getDomainName())
                .append(" \n siteURL : " + this.getSiteURL())
                .append(" \n siteID : " + this.getSiteID())
                .append(" \n oldSiteName :" + this.getOldSiteName())
                .append(" \n newSiteName :" + this.getNewSiteName())
                .append(" \n lastModifiedTime:" + this.getLastModifiedTime());
        return buf.toString();
    }
}

