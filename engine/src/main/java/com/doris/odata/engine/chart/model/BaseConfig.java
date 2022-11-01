package com.doris.odata.engine.chart.model;

import com.doris.odata.common.enums.ErrorCode;
import com.doris.odata.common.exception.ChartException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author: origindoris
 * @Title: BaseChartConfig
 * @Description:
 * @date: 2022/11/1 16:31
 */
@Data
@Slf4j
public class BaseConfig implements Serializable {

    public void verifyParam() throws ChartException {
        try {
            verify();
        } catch (Exception e) {
            throw new ChartException(ErrorCode.CHART_CONFIG_ERROR, e.getMessage());
        }
    }

    protected void verify(){

    }
}
