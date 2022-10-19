package com.doris.hdata.engine.data.source.model;

import com.alibaba.fastjson2.JSONObject;
import com.doris.hdata.engine.data.source.model.property.SourceProperty;
import com.doris.hdata.common.model.BaseModel;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author: origindoris
 * @Title: DataSource
 * @Description:
 * @date: 2022/10/14 17:13
 */
@Data
@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(name = "hdata_data_source")
@Proxy(lazy = false)
public class Source extends BaseModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "source_type")
    @NotBlank(message = "数据源类型不能为空！")
    private String sourceType;

    @NotBlank(message = "数据源名称不能为空！")
    @Column(name = "source_name")
    private String sourceName;

    @Column(name = "source_property")
    @Type(type = "json")
    @NotBlank(message = "数据源属性不能为空！")
    private JSONObject sourceProperty;

    @Column(name = "tenant_code")
    private String tenantCode;

    @Column(name = "source_code")
    private String sourceCode;

    @Column(name = "tenant_name")
    private String tenantName;

    @Column(name = "gmt_create")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date gmtCreate;

    @Column(name = "gmt_modified")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date gmtModified;

    @Column(name = "delete_flag")
    protected Boolean deleteFlag;

    @Column(name = "creator")
    protected String creator;

    @Column(name = "creatorName")
    protected String creatorName;
}
