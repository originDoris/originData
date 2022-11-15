package com.doris.odata.engine.chart.constant;

import com.doris.odata.common.constant.DeleteFlagConstant;

/**
 * @author: origindoris
 * @Title: ChartConstant
 * @Description:
 * @date: 2022/11/1 17:24
 */
public class ChartConstant {

    public static final String TABLE_NAME = "origin_data_chart";
    public static final String CHART_CODE = "chartCode";

    public static final String DELETE_SQL = "UPDATE " + TABLE_NAME + " SET delete_flag = '" + DeleteFlagConstant.YES + "' where id = ?";

}
