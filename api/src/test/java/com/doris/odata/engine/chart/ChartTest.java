package com.doris.odata.engine.chart;

import com.alibaba.fastjson2.JSON;
import com.doris.odata.api.ApiApplication;
import com.doris.odata.common.exception.ChartException;
import com.doris.odata.engine.chart.enums.ChartType;
import com.doris.odata.engine.chart.model.Chart;
import com.doris.odata.engine.chart.model.chart.config.Polyline;
import com.doris.odata.engine.chart.model.query.config.MysqlQueryConfig;
import com.doris.odata.engine.chart.service.ChartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: origindoris
 * @Title: ChartTest
 * @Description:
 * @date: 2022/11/1 19:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ChartTest {

    @Autowired
    private ChartService chartService;


    @Test
    public void testAdd() throws ChartException {
        Chart chart = new Chart();
        chart.setChartName("测试图表");
        chart.setChartType(ChartType.BASE_POLYLINE.getCode());
        chart.setCreator("4929");
        chart.setCreatorName("hxx");
        chart.setTenantCode("test");
        chart.setTenantName("test");
        chart.setDeleteFlag(false);
        Polyline polyline = new Polyline();
        polyline.setXField("test");
        polyline.setYField("test");
        chart.setChartConfig(JSON.parseObject(JSON.toJSONString(polyline)));
        MysqlQueryConfig queryConfig = new MysqlQueryConfig();
        queryConfig.setSql("select * from test;");
        chart.setQueryConfig(JSON.parseObject(JSON.toJSONString(queryConfig)));
        chart.setSourceCode("test");
        Chart save = chartService.save(chart);
        System.out.println("save = " + save);
    }
}
