package com.doris.odata.engine.data.source.repository;

import com.doris.odata.common.repository.AbstractCommonRepository;
import com.doris.odata.engine.data.source.model.Source;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

/**
 * @author: origindoris
 * @Title: DataSourceRepository
 * @Description: 数据源存储库
 * @date: 2022/10/18 10:08
 */
public interface DataSourceRepository extends AbstractCommonRepository<Source, Long> {

}
