package com.doris.odata.engine.chart.util;

import com.alibaba.fastjson2.JSONObject;
import com.doris.odata.common.enums.ErrorCode;
import com.doris.odata.common.exception.ChartException;
import com.doris.odata.engine.chart.enums.ChartType;
import com.doris.odata.engine.chart.model.Chart;
import com.doris.odata.engine.chart.model.chart.config.BaseChartConfig;
import com.doris.odata.engine.chart.model.query.config.BaseQueryConfig;
import com.doris.odata.engine.data.source.enums.SourceTypeEnum;

/**
 * @author: origindoris
 * @Title: QueryConfigUtil
 * @Description:
 * @date: 2022/11/1 17:09
 */
public class QueryConfigUtil {

    public static BaseQueryConfig parseBaseQueryConfig(Chart chart,String sourceType) throws ChartException {
        JSONObject queryConfig = chart.getQueryConfig();
        Class<? extends BaseQueryConfig> aClass = SourceTypeEnum.getQueryClass(sourceType);
        if (aClass == null) {
            throw new ChartException(ErrorCode.CHART_SOURCE_TYPE_ILLEGAL);
        }
        return JSONObject.parseObject(queryConfig.toJSONString(), aClass);
    }
}
