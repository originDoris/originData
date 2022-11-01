package com.doris.odata.engine.chart.model.chart.config;

import com.doris.odata.common.enums.ErrorCode;
import com.doris.odata.common.exception.ChartException;
import com.doris.odata.engine.chart.model.BaseConfig;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: origindoris
 * @Title: BaseChartConfig
 * @Description:
 * @date: 2022/11/1 10:47
 */
@Data
public class BaseChartConfig extends BaseConfig {

    protected String type;
}
