package com.doris.odata.engine.chart.model;

import com.alibaba.fastjson2.JSONObject;
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
 * @Title: Chart
 * @Description:
 * @date: 2022/10/28 18:13
 */

@Data
@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(name = "origin_data_chart")
@Proxy(lazy = false)
public class Chart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

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

    @Column(name = "tenant_code")
    private String tenantCode;

    @Column(name = "source_code")
    @NotBlank(message = "数据源名称不能为空！")
    private String sourceCode;

    @Column(name = "tenant_name")
    private String tenantName;

    @Column(name = "query_config")
    @Type(type = "json")
    private JSONObject queryConfig;

    @Column(name = "chart_code")
    private String chartCode;

    @Column(name = "chart_type")
    @NotBlank(message = "图表类型不能为空！")
    private String chartType;

    @Column(name = "chart_config")
    @Type(type = "json")
    private JSONObject chartConfig;

    @Column(name = "chart_name")
    @NotBlank(message = "图表名称不能为空！")
    private String chartName;

}
