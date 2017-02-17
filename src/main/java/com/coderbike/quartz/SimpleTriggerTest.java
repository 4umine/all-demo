package com.coderbike.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/1/4 16:01
 */
public class SimpleTriggerTest {

    public static void main(String[] args) {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            //testSimpleScheduler(scheduler);
            testCronTrigger(scheduler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static void testSimpleScheduler(Scheduler scheduler) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(SimpleQuartzJob.class)
                .withIdentity("job1", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .withRepeatCount(5))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();
    }

    public static void testCronTrigger(Scheduler scheduler) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(SimpleQuartzJob.class)
                .withIdentity("job1", "group1")
                .build();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger1", "cronGroup1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
                .build();

        scheduler.scheduleJob(jobDetail, cronTrigger);

        scheduler.start();
    }
}
