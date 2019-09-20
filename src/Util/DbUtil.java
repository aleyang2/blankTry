package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// build connection etc.
public class DbUtil {

    Connection con;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://127.0.0.1:3306/CorsTest";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "Tearose1184?";

    private static DbUtil instance = new DbUtil();

    public DbUtil () {

    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        return con;
    }

//    public static DbUtil getInstance() {
//        return instance;
//    }
//
//    public SiteInfoVO lookupSiteandDomain(long siteID,
//                                          String siteName) throws SQLException {
//
//        SiteInfoVO siteVO = null;
//
//        //Get site information from cache by siteID or siteName
//        if (siteID > 0) {
//            siteVO = Cache.getSiteIDSiteVO(siteID);
//        }else {
//            siteVO = Cache.getSiteNameSiteVO(siteName);
//        }
//
//        if (null != siteVO) {
//            logger.info("Returning site and domain info from CACHE! for " + siteVO.getSiteID());
//            return siteVO;
//        }
//
//        //Loop all data source to get site information by siteID or siteName
//        String[] doArray = Config.getInstance().getWebDBJNDINames();
//        if (doArray.length == 0) {
//            logger.error("No WebDB JNDI Names configured in config file");
//            return null;
//        }
//
//        for (int i = 0; i < doArray.length; i++) {
//            Connection conn = null;
//            try {
//                //Get connection by WebDB JNDI Name
//                conn = getConnection(doArray[i]);
//                if (null != conn) {
//                    siteVO = DBHelp.getSiteandDomain(conn, siteID, siteName);
//                    if (null != siteVO) {
//                        logger.info("Returning site and domain info by SiteID or SiteName from " + doArray[i]);
//                        Cache.putSiteIDSiteVO(siteVO.getSiteID(), siteVO);
//                        if (!StringUtil.isNullOrEmpty(siteName)) {
//                            Cache.putSiteNameSiteVO(siteName, siteVO);
//                        }
//                        return siteVO;
//                    }else {
//                        logger.info("Could not find site and domain info by SiteID or SiteName from " + doArray[i]);
//                    }
//                }
//            } catch (Exception e) {
//                logger.error("Failed to look up site and domain name by SiteID or SiteName");
//                logger.error(e);
//                e.printStackTrace();
//            }finally {
//                DBHelp.closeConnection(conn);
//            }
//        }
//        return null;
//    }
}
