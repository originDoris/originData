package com.doris.odata.api.source;

import com.doris.odata.common.model.Result;
import com.doris.odata.engine.data.source.model.SourceType;
import com.doris.odata.engine.data.source.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: origindoris
 * @Title: DataSourceController
 * @Description:
 * @date: 2022/11/15 16:02
 */
@RestController
@RequestMapping("/source")
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;


    @GetMapping("/querySourceType")
    public Result<List<SourceType>> querySourceType(){
        List<SourceType> sourceType = dataSourceService.getSourceType();
        return Result.success(sourceType);
    }


}
