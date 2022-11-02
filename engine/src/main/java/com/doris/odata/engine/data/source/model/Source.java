package com.doris.odata.engine.data.source.model;

import com.alibaba.fastjson2.JSONObject;
import com.doris.odata.common.constant.DeleteFlagConstant;
import com.doris.odata.common.model.BaseModel;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


/**
 * @author: origindoris
 * @Title: DataSource
 * @Description:
 * @date: 2022/10/14 17:13
 */
@Data
@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(name = "origin_data_data_source")
@Proxy(lazy = false)
@Where(clause = DeleteFlagConstant.DELETE_FIELD + " = '" + DeleteFlagConstant.NO + "'")
public class Source extends BaseModel {

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

    @Column(name = "source_code")
    private String sourceCode;
}
