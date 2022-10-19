package com.doris.hdata.engine.data.source.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson2.JSONObject;
import com.doris.hdata.common.util.Base64Util;
import com.doris.hdata.engine.data.source.enums.SourceTypeEnum;
import com.doris.hdata.engine.data.source.model.Source;
import com.doris.hdata.engine.data.source.model.property.MySqlSource;
import com.doris.hdata.engine.data.source.model.property.SourceProperty;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: origindoris
 * @Title: DruidUtil
 * @Description:
 * @date: 2022/10/18 15:00
 */
@Slf4j
public class DruidUtil {

    /**
     * 将数据源配置转换为druidDataSource
     *
     * @param sourceProperty
     * @return
     */
    public static DruidDataSource getDruidDataSource(SourceProperty sourceProperty) {
        if (!SourceTypeEnum.MYSQL.getType().equals(sourceProperty.getType())) {
            log.info("不支持mysql之外的数据库！");
            return null;
        }
        MySqlSource mySqlSource = (MySqlSource) sourceProperty;
        try (DruidDataSource druidDataSource = new DruidDataSource()) {
            druidDataSource.setUrl(mySqlSource.getUrl());
            druidDataSource.setPassword(Base64Util.decoder(mySqlSource.getPassword()));
            druidDataSource.setUsername(mySqlSource.getUserName());
            druidDataSource.setDriverClassName(mySqlSource.getDriverClassName());
            return druidDataSource;
        }
    }
}
