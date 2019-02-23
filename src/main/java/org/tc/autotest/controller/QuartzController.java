package org.tc.autotest.controller;

import org.tc.autotest.dto.JobDto;
import org.tc.autotest.job.ScheduledJob;
import org.tc.autotest.manage.SchedulerManager;
import org.tc.autotest.model.domain.ScheduleJob;
import org.tc.autotest.wrapper.WrapMapper;
import org.tc.autotest.wrapper.Wrapper;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 *  定时任务控制器
 *
 */


@RestController
@RequestMapping("/quartz")
public class QuartzController {

    private static Logger logger = LoggerFactory.getLogger(QuartzController.class);

    @Autowired
    public SchedulerManager schedulerManager;

    //初始化启动所有的Job，服务启动时执行一次
    @PostConstruct
    public void initialize() {
        try {
            reStartAllJobs();
            logger.info("INIT SUCCESS");
        } catch (SchedulerException e) {
            logger.info("INIT EXCEPTION : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 动态定时任务一：由SimpleTrigger管理
     * 安裝-》卸载
     * @return
     */
    @RequestMapping(value = "/job1", method = RequestMethod.GET)
    public String scheduleJobFirst() {
        try {
            //创建一个定时器对象
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            schedulerManager.startJob1Repeat();
            return "启动定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "启动定时器失败";
    }

    /**
     * 静态定时任务示例：由Cron表达式控制
     * @return
     */
    @RequestMapping(value = "/job2",method = RequestMethod.GET)
    public String scheduleJob2() {
        try {
            //每五秒执行一次
            schedulerManager.startJob("0/5 * * * * ?","job2","group2", ScheduledJob.class);
            //0 0/5 14 * * ? 在每天下午2点到下午2:55期间的每5分钟触发
            //0 50 14 * * ?  在每天下午2点50分5秒执行一次
//            myScheduler.startJob("5 50 14 * * ?","job2","group2", ScheduledJob.class);
            return "启动定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "启动定时器失败";
    }

    /**
     * 删除定时器
     * @return String
     */
    @RequestMapping(value = "/del_job2", method = RequestMethod.GET)
    public String deleteScheduleJob2() {
        try {
            schedulerManager.deleteJob("job2","group2");
            return "删除定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "删除定时器失败";
    }

    /**
     * 清除所有定时器
     * @return String
     */
    @RequestMapping(value = "/del_all_job", method = RequestMethod.GET)
    public String deleteAllScheduleJob() {
        try {
            schedulerManager.clearAll();
            return "清除所有定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "清除定时器失败";
    }

    /**
     * 暂停定时任务
     * @param ScheduleJob
     * @return result
     * @throws SchedulerException
     */
    @RequestMapping(value = "/pause_job", method = RequestMethod.POST)
    public String pauseScheduleJob(@RequestBody ScheduleJob job) {
        try {
            String jobName = job.getJobName();
            String groupName = job.getGroupName();
            schedulerManager.pauseJob(jobName, groupName);
            return "暂停定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "暂停定时器失败";
    }

    /**
     * 恢复定时任务
     * @param job
     * @return result
     * @throws SchedulerException
     */
    @RequestMapping(value = "/resume_job", method = RequestMethod.POST)
    public String resumeScheduleJob(@RequestBody ScheduleJob job) {
        try {
            String jobName = job.getJobName();
            String groupName = job.getGroupName();
            schedulerManager.resumeJob(jobName, groupName);
            return "恢复定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "恢复定时器失败";
    }

    /**
     * 重新启动所有的job
     * todo
     */
    private void reStartAllJobs() throws SchedulerException {

    }

    /**
     * 获取指定job状态
     */
    @RequestMapping(value = "/job_status", method = RequestMethod.POST)
    public Wrapper<String> getJobStatus(@RequestBody JobDto dto) throws SchedulerException {
        String res = "pending";
        if (dto != null) {
            String jobName = dto.getJobName();
//            jobName="job1";
            String jobGroup = dto.getGroupName();
            List<JobExecutionContext> jobContexts = schedulerManager.getCurrentlyExecutingJobs();
            for (JobExecutionContext context : jobContexts) {
                if (jobName.equals(context.getTrigger().getJobKey().getName())) {
                    res = "running";
                    break;
                }
            }

//            res = "stopped";

        }
        return WrapMapper.ok(res);
    }

}

