package org.tc.autotest.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class JobDto implements Serializable {

    private static final long serialVersionUID = -6568582406532372412L;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务组名
     */
    private String groupName;
}
