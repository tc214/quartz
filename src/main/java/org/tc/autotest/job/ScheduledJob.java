package org.tc.autotest.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.jboss.logging.Logger;

/**
 * 自定义定时任务
 */
public class ScheduledJob implements Job {

    private static final Logger logger = Logger.getLogger(ScheduledJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //开始执行任务....
        logger.info("执行自定义定时任务...");
    }
}

