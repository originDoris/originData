package com.doris.odata.api.source;

import com.doris.odata.common.exception.DataSourceException;
import com.doris.odata.common.model.Result;
import com.doris.odata.engine.data.source.model.Source;
import com.doris.odata.engine.data.source.model.SourceType;
import com.doris.odata.engine.data.source.model.query.SourceQuery;
import com.doris.odata.engine.data.source.service.DataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: origindoris
 * @Title: DataSourceController
 * @Description:
 * @date: 2022/11/15 16:02
 */
@RestController
@RequestMapping("/source")
@Slf4j
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;


    @GetMapping("/querySourceType")
    public Result<List<SourceType>> querySourceType(){
        List<SourceType> sourceType = dataSourceService.getSourceType();
        return Result.success(sourceType);
    }

    @GetMapping("/queryList")
    public Result<Page<Source>> queryList(SourceQuery sourceQuery){
        Page<Source> sources = dataSourceService.queryList(sourceQuery);
        return Result.success(sources);
    }

    @PostMapping("/save")
    public Result<Source> save(@RequestBody Source source){
        Source save = null;
        try {
            save = dataSourceService.save(source);
        } catch (DataSourceException e) {
            log.info("保存数据出错", e);
            return Result.failure(e.getErrorCode(), e.getMessage());
        }
        return Result.success(save);
    }


}
