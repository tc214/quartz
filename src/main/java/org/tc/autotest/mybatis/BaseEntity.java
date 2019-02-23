package org.tc.autotest.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 6871498894265677368L;


    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "created_time")
    private Date createdTime;


    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "updated_time")
    private Date updatedTime;


    @Transient
    @JsonIgnore
    public boolean isNew() {
        return this.id == null;
    }


    @Transient
    private String orderBy;

    @Transient
    private Integer pageNum;

    @Transient
    private Integer pageSize;


}
