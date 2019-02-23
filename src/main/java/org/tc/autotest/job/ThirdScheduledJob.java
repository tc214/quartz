package org.tc.autotest.job;

import org.jboss.logging.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;


/**
 * 任务三
 */
@DisallowConcurrentExecution
@Component
public class ThirdScheduledJob implements Job {

    private static final Logger logger = Logger.getLogger(ScheduledJob.class);


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //开始执行任务....
        logger.info("执行自定义定时任务...");

    }
}
