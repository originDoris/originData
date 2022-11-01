package com.doris.odata.engine.chart.model.query.config;

import lombok.Data;
import org.springframework.util.Assert;

/**
 * @author: origindoris
 * @Title: MysqlQueryConfig
 * @Description:
 * @date: 2022/11/1 16:37
 */
@Data
public class MysqlQueryConfig extends BaseQueryConfig {
    private String sql;

    @Override
    protected void verify() {
        super.verify();
        Assert.notNull(sql,"查询sql不能为空！");
    }
}
