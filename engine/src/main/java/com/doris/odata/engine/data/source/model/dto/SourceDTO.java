package com.doris.odata.engine.data.source.model.dto;

import com.doris.odata.engine.data.source.model.Source;
import lombok.Data;

/**
 * @author: origindoris
 * @Title: SourceDTO
 * @Description:
 * @date: 2022/11/24 14:30
 */
@Data
public class SourceDTO extends Source {

    private String sourceTypeName;

}
