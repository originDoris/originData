package com.doris.odata.engine.chart.model.query.config;

import com.doris.odata.engine.chart.model.BaseConfig;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: origindoris
 * @Title: BaseQueryConfig
 * @Description:
 * @date: 2022/11/1 16:29
 */
@Data
public class BaseQueryConfig extends BaseConfig {

    protected String type;
}
