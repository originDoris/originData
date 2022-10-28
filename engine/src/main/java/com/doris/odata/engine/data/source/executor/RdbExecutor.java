package com.doris.odata.engine.data.source.executor;

import com.doris.odata.common.exception.OriginDataException;
import com.doris.odata.engine.data.source.model.Source;

import java.util.List;
import java.util.Map;

/**
 * @author: origindoris
 * @Title: RDBExecutor
 * @Description: 关系型数据库执行器
 * @date: 2022/10/18 14:10
 */
public interface RdbExecutor extends DataSourceExecutor{

    /**
     * 查询数据
     *
     * @param source 数据源
     * @param sql sql语句
     * @return
     */
    List<Map> query(Source source, String sql) throws OriginDataException;



}
