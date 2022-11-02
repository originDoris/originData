package com.doris.odata.common.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: origindoris
 * @Title: BaseModel
 * @Description:
 * @date: 2022/10/14 15:56
 */
@Data
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "gmt_create")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date gmtCreate;

    @Column(name = "gmt_modified")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date gmtModified;

    @Column(name = "delete_flag")
    protected Boolean deleteFlag;

    @Column(name = "creator")
    @CreatedBy
    protected String creator;

    @Column(name = "creatorName")
    protected String creatorName;

    @Column(name = "tenant_code")
    private String tenantCode;

    @Column(name = "tenant_name")
    private String tenantName;

}
