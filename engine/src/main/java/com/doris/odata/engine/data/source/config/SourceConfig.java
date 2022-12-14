package com.doris.odata.engine.data.source.config;

import com.doris.odata.common.exception.DataSourceException;
import com.doris.odata.engine.data.source.constant.DataSourceConstant;
import com.doris.odata.engine.data.source.factory.DynamicDataSourceFactory;
import com.doris.odata.engine.data.source.model.Source;
import com.doris.odata.engine.data.source.service.DataSourceService;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author: origindoris
 * @Title: SourceConfig
 * @Description:
 * @date: 2022/10/19 10:31
 */
@Component
@DependsOn("dynamicDataSource")
public class SourceConfig {

    private final DataSourceService dataSourceService;

    public SourceConfig(DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }


    @PostConstruct
    public void init() throws DataSourceException {
        List<Source> sources = dataSourceService.queryAllByType(DataSourceConstant.MYSQL);
        for (Source source : sources) {
            DynamicDataSourceFactory.addDataSource(source);
        }
    }
}
