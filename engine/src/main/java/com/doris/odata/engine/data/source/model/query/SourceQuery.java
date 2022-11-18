package com.doris.odata.engine.data.source.model.query;

import com.doris.odata.common.model.BaseQuery;
import lombok.Data;

/**
 * @author: origindoris
 * @Title: SourceQuery
 * @Description:
 * @date: 2022/11/18 10:19
 */
@Data
public class SourceQuery extends BaseQuery {
    private String sourceType;

    private String sourceName;
}
