package Quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.logging.Logger;

public class SchedulerUtil {

    private static Logger _logger = Logger.getLogger(String.valueOf(SchedulerUtil.class));

    /**
     * [简单任务调度:每次执行间隔为多少毫秒，执行多少次] <br>
     * @param jobName 任务名字
     * @param jobGroupName 任务组名字
     * @param triggerName 触发器名字
     * @param triggerGroupName 触发器组名字
     * @param jobClass 任务类
     * @param time 时间间隔
     * @param count 执行几次<br>
     */

    public static void handleSimpleTrigger(String jobName, String jobGroupName,
                                           String triggerName, String triggerGroupName,
                                           Class jobClass, int time, int count) {
        // 通过schedulerFactory获取一个调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerFactory.getScheduler();

            // 创建jobDetail实例，绑定job实现类
            // 指明job的名称，所在的组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();

            // 定义调度触发规则， 使用simple Trigger规则
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName)
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(time)
                            .withRepeatCount(count)).startNow().build();

            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job,trigger);
            // 启动调度
            scheduler.start();
        } catch (Exception e) {
            _logger.warning("执行" + jobName + "组" + jobName + "任务出现异常：" + e.getMessage());
        }
    }

    /**
     * [复杂任务调度：每天几点几分几秒定时执行任务] <br>
     * @param jobName 任务名字
     * @param jobGroupName 任务组名字
     * @param triggerName 触发器名字
     * @param triggerGroupName 触发器组名字
     * @param jobClass 任务类
     * @param cron 触发规则<br>
     */
    public static void handleCronTrigger(String jobName, String jobGroupName,
                                         String triggerName, String triggerGroupName,
                                         Class jobClass, String cron) {
        // 通过schedulerFactory获取一个调度器
        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(jobClass)
                    .withIdentity(jobName, jobGroupName).build();
            // 定义调度触发规则
            //使用cornTrigger规则  每天18点30分
            Trigger trigger=TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .startNow().build();
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);
            // 启动调度
            scheduler.start();
        } catch (Exception e) {
            _logger.warning("执行"+jobName+"组"+jobName+"任务出现异常E:["+ e.getMessage() + "]");
        }
    }
}
