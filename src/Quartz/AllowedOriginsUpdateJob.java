package Quartz;


import Util.Cache;
import Util.DBHelp;
import Util.DbUtil;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import vo.SiteAllowedOriginVO;

import java.sql.Connection;
import java.sql.SQLException;

// Update the SiteAllowedOriginVO that stored in cache
public class AllowedOriginsUpdateJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        try {
            conn = dbUtil.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        DBHelp dbHelp = new DBHelp();

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        // Here assume siteId is string. Can change afterwards.
        Long siteId = Long.parseLong(jobDataMap.getString("siteID"));

        try {
            SiteAllowedOriginVO testSiteAllowedOrigin = dbHelp.getSiteAllowedOrigins(conn, siteId);
            Cache.putSiteAllowedOriginVO(siteId, testSiteAllowedOrigin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}










