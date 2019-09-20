package Util;

import org.apache.log4j.Logger;
import vo.SiteAllowedOriginVO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Cache {

    private static Logger logger = Logger.getLogger(Cache.class.getName());

    private static Map siteEnforceHttpMap = new ConcurrentHashMap();

    private static long elapsedTimeStamp = System.currentTimeMillis();

    private static final long ONE_HOUR = 60 * 60 * 1000;

    public static synchronized void cleanMaps() {
        siteEnforceHttpMap.clear();
    }

    public static String flushCache() {
        cleanMaps();
        return "Flush cache succeed.";
    }

    public static void flushStaticVariables() {
        if (System.currentTimeMillis() - elapsedTimeStamp > ONE_HOUR) {
            logger.debug("Flush cache as expired 1 hour");
            flushStaticMaps();
        }
    }

    private static synchronized void flushStaticMaps() {
        siteEnforceHttpMap.clear();
        elapsedTimeStamp = System.currentTimeMillis();
    }

    //
    public static Object putSiteAllowedOriginVO(long siteId, SiteAllowedOriginVO siteAllowedOriginVO) {
        return siteEnforceHttpMap.put(String.valueOf(siteId), siteAllowedOriginVO);
    }

    public static SiteAllowedOriginVO getSiteAllowedOriginVO(long siteId) {
        return (SiteAllowedOriginVO) siteEnforceHttpMap.get(String.valueOf(siteId));
    }
}
