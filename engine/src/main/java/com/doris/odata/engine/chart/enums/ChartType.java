package com.doris.odata.engine.chart.enums;

import com.doris.odata.engine.chart.model.chart.config.BaseChartConfig;
import com.doris.odata.engine.chart.model.chart.config.Polyline;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author: origindoris
 * @Title: ChartType
 * @Description:
 * @date: 2022/11/1 10:19
 */
public enum ChartType {
    /**
     * 图表类型
     */
    BASE_POLYLINE("basePolyline", "基础折线图", Polyline.class),;
    private String code;

    private String desc;

    private Class<? extends BaseChartConfig> typeClass;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Class<? extends BaseChartConfig> getTypeClass() {
        return typeClass;
    }

    ChartType(String code, String desc, Class<? extends BaseChartConfig> typeClass) {
        this.code = code;
        this.desc = desc;
        this.typeClass = typeClass;
    }


    public static Class<? extends BaseChartConfig> getChartClass(String code){
        Optional<ChartType> any = Arrays.stream(ChartType.values()).filter(numberFormat -> code.equals(numberFormat.getCode())).findAny();
        if (any.isEmpty()) {
            return null;
        }

        return any.get().getTypeClass();
    }
}
