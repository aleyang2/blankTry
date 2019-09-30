package Util;

import vo.SiteAllowedOriginVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class DBHelp {

    private static Logger logger = Logger.getLogger(DBHelp.class.getName());

    public DBHelp() {

    }

    // query all allowed_origins for a specific siteID
    private static final String QUERY_ALLOWED_ORIGINS_BY_SITEID =
            "SELECT ITEMVALUE\n" +
            "FROM WBXSITECONFIG\n" +
            "WHERE SITEID IN (SELECT SITEID FROM wbxsitewebdomain WHERE domainid=?) AND ITEMNAME = 'allowedOrigin' AND lastmofiedtime>date-1";


//    select s.siteid, s.sitename, c.itemvalue,
//    from wbxsite s, wbxsiteconfig c, wbxsitewebdomain d
//    where s.siteid=c.siteid and s.siteid=d.siteid
//    and d.domainid=? and c.itemname='AllowOrigin'
//    and c.lastmodifiedtime

    // Domain Name load to cache .

    // need to get whitelist (allowedOrigins) from database
    // SITEID ITEMNAME ITEMVALUE LASTMODIFIEDTIME
    public static SiteAllowedOriginVO getSiteAllowedOrigins(Connection conn, long siteID) throws SQLException {
        SiteAllowedOriginVO siteAllowedOriginVO = new SiteAllowedOriginVO();

        ResultSet rs = null;
        PreparedStatement preStatement = null;

        try {
            preStatement = conn.prepareStatement(QUERY_ALLOWED_ORIGINS_BY_SITEID);
            int step = 1;
            preStatement.setLong(1, siteID);
            siteAllowedOriginVO.setSiteID(siteID);
            rs = preStatement.executeQuery();
            while (rs.next()) {
                // The rs is going to be just one column with the allowedOrigins.
                // iterator to get a list of allowedOrigins.
                siteAllowedOriginVO.addAllowedOrigins(rs.getString(1));
            }
            // say we have a whitelist here get out
            List<String> allowedOrigins = siteAllowedOriginVO.getAllowedOrigins();
            // load it into filter by calling out the updating method.
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStatement != null) {
                preStatement.close();
            }
        }
        return siteAllowedOriginVO;
    }

    // Store SiteAllowedOriginVO in the cache.

}
