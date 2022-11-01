package com.doris.odata.engine.chart.util;

import com.alibaba.fastjson2.JSONObject;
import com.doris.odata.common.enums.ErrorCode;
import com.doris.odata.common.exception.ChartException;
import com.doris.odata.engine.chart.enums.ChartType;
import com.doris.odata.engine.chart.model.Chart;
import com.doris.odata.engine.chart.model.chart.config.BaseChartConfig;

/**
 * @author: origindoris
 * @Title: ChartConfigUtil
 * @Description:
 * @date: 2022/11/1 11:14
 */
public class ChartConfigUtil {

    public static BaseChartConfig parseChartConfig(Chart chart) throws ChartException {
        String chartType = chart.getChartType();
        JSONObject chartConfig = chart.getChartConfig();
        Class<? extends BaseChartConfig> aClass = ChartType.getChartClass(chartType);
        if (aClass == null) {
            throw new ChartException(ErrorCode.CHART_TYPE_ILLEGAL);
        }
        return JSONObject.parseObject(chartConfig.toJSONString(), aClass);
    }
}
