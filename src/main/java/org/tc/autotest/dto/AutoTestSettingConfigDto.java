package org.tc.autotest.dto;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 */
@Data
public class AutoTestSettingConfigDto implements Serializable {
    private static final long serialVersionUID = -3599630825681985964L;


    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 自动测试开关
     * 开：on,  关：off
     */
    private String autoTestSwitch;

    /**
     * 运行模式
     * 三种模式: mode1 mode2 mode3
     */
    private String runningMode;

    /**
     * 运行应用
     *
     */
    private String runningApp;

    /**
     * 运行状态
     *  running stopped
     */
    private String runningStatus;

    /**
     * 间隔时间模式
     * random_time solid_time
     */
    private String intervalTimeMode;

    /**
     * 间隔时间：随机时间
     */
    private String randomTime;

    /**
     * 间隔时间：固定时间, 单位：秒
     */
    private Integer solidTime;


    /**
     * 终止条件模式
     * operation_num running_time_length
     */
    private String stopConditionMode;

    /**
     * 终止条件：操作次数
     */
    private Long operationNum;

    /**
     * 终止条件：运行时长,单位: 秒
     */
    private Long runningTimeLength;

    /**
     * 电台集合
     */
    private String radiosIp;



}
