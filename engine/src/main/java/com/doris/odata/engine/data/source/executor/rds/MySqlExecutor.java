package com.doris.odata.engine.data.source.executor.rds;

import com.doris.odata.common.exception.HDataException;
import com.doris.odata.engine.data.source.constant.DataSourceConstant;
import com.doris.odata.engine.data.source.executor.RdbExecutor;
import com.doris.odata.engine.data.source.model.Source;
import com.doris.odata.engine.data.source.service.DataSourceService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author: origindoris
 * @Title: MySqlExecutor
 * @Description:
 * @date: 2022/10/18 14:12
 */
@Component(DataSourceConstant.MYSQL)
public class MySqlExecutor implements RdbExecutor {

    private final DataSourceService dataSourceService;

    public MySqlExecutor(DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }

    @Override
    public List<Map> query(Source source, String sql) throws HDataException {
        return dataSourceService.execNativeQuery(sql, source.getSourceCode());
    }

}
