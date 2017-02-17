package com.coderbike.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * <p>
 *     http://student-lp.iteye.com/blog/2093395
 *     http://www.cnblogs.com/teach/p/5675960.html
 * <p/>
 * Created with IDEA
 * author: imant
 * date: 2017/1/4 15:48
 */
public class SimpleQuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("SimpleQuartzJob 执行了：" + new Date() + ", " + context.getTrigger().getJobKey());
    }
}
