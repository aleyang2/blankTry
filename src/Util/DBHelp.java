package Util;

import sun.misc.Cache;
import vo.SiteAllowedOriginVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class DBHelp {

    private static Logger logger = Logger.getLogger(DBHelp.class.getName());

    private DBHelp() {

    }

    // query all allowed_origins for a specific siteID
    private static final String QUERY_ALLOWED_ORIGINS_BY_SITEID = "select ... ";

    // need to get whitelist (allowedOrigins) from database
    // SITEID ITEMNAME ITEMVALUE LASTMODIFIEDTIME
    public static SiteAllowedOriginVO getSiteAllowedOrigin(Connection conn, String sql, long siteID) throws SQLException {
        SiteAllowedOriginVO siteAllowedOriginVO = new SiteAllowedOriginVO();

        ResultSet rs = null;
        PreparedStatement preStatement = conn.prepareStatement(sql);

        try {
            preStatement = conn.prepareStatement(sql);
            rs = preStatement.executeQuery();
            if (rs.next()) {
                siteAllowedOriginVO.setSiteID(rs.getLong("siteid"));
                // iterator to get a list of allowedOrigins.
                siteAllowedOriginVO.setItemValue(rs.getString("itemValue"));
                //
            }
            // say we have a whitelist here get out
            List<String> allowedOrigins = siteAllowedOriginVO.getAllowedOrigins();
            // load it into filter by calling out the updating method.


        } catch (SQLException e) {
            if (sql.indexOf("wbxsitedomainmapping") > 0) {
                logger.info("No found wbxsitedomainmapping table!");
            } else {
                throw e;
            }
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

//    public static String tryCache(String s) {
//        Cache c =
//    }
}
