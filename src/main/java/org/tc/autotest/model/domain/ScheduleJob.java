package org.tc.autotest.model.domain;


import lombok.Data;

import java.io.Serializable;


/**
 * 定时任务实体类
 */
@Data
public class ScheduleJob implements Serializable {

    private static final long serialVersionUID = -264333970096858824L;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务所属群组名称
     */
    private String groupName;

}
