package org.tc.autotest.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.tc.autotest.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "t_autotest_cur_config")
public class TestConfigInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 45958282828932982L;

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 自动测试开关
     * 开：on,  关：off
     */
    @Column(name = "autotest_switch")
    private String autoTestSwitch;

    /**
     * 运行模式
     * 三种模式: mode1 mode2 mode3
     */
    @Column(name = "running_mode")
    private String runningMode;

    /**
     * 运行应用
     *
     */
    @Column(name = "running_app")
    private String runningApp;

    /**
     * 运行状态
     *  running stopped
     */
    @Column(name = "running_status")
    private String runningStatus;

    /**
     * 间隔时间模式
     * random_time solid_time
     */
    @Column(name = "interval_time_mode")
    private String intervalTimeMode;

    /**
     * 间隔时间：随机时间
     */
    @Column(name = "random_time")
    private String randomTime;

    /**
     * 间隔时间：固定时间, 单位：秒
     */
    @Column(name = "solid_time")
    private Integer solidTime;


    /**
     * 终止条件模式
     * operation_num running_time_length
     */
    @Column(name = "stop_condition_mode")
    private String stopConditionMode;

    /**
     * 终止条件：操作次数
     */
    @Column(name = "operation_num")
    private Long operationNum;

    /**
     * 终止条件：运行时长,单位: 秒
     */
    @Column(name = "running_time_length")
    private Long runningTimeLength;

    /**
     * 电台集合
     */
    @Column(name = "radios_ip")
    private String radiosIp;

    /**
     * 最后一次修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "last_modify_time")
    private Date lastModifyTime;




}
