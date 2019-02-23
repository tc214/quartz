package org.tc.autotest.job;

import org.jboss.logging.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * 任务一
 * @DisallowConcurrentExecution : 不允许并发执行
 * @Component
 */
@DisallowConcurrentExecution
//@Component
public class FirScheduledJob implements Job {

    private static final Logger logger = Logger.getLogger(ScheduledJob.class);


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //开始执行任务....
        logger.info("执行自定义定时任务一...");

    }

}
