package com.doris.odata.engine.chart.service;

import com.doris.odata.common.enums.ErrorCode;
import com.doris.odata.common.exception.ChartException;
import com.doris.odata.common.interceptor.UserInfoThreadLocal;
import com.doris.odata.common.model.UserInfo;
import com.doris.odata.common.util.StrongUuidGenerator;
import com.doris.odata.engine.chart.constant.ChartConstant;
import com.doris.odata.engine.chart.model.Chart;
import com.doris.odata.engine.chart.model.chart.config.BaseChartConfig;
import com.doris.odata.engine.chart.model.query.config.BaseQueryConfig;
import com.doris.odata.engine.chart.repository.ChartRepository;
import com.doris.odata.engine.chart.util.ChartConfigUtil;
import com.doris.odata.engine.chart.util.QueryConfigUtil;
import com.doris.odata.engine.data.source.constant.DataSourceConstant;
import com.doris.odata.engine.data.source.model.Source;
import com.doris.odata.engine.data.source.service.DataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author: origindoris
 * @Title: ChartService
 * @Description:
 * @date: 2022/11/1 14:00
 */
@Service
@Slf4j
@Valid
@Validated
public class ChartService {

    private final ChartRepository chartRepository;

    private final DataSourceService dataSourceService;

    private static final StrongUuidGenerator IdGenerator = new StrongUuidGenerator();

    public ChartService(ChartRepository chartRepository, DataSourceService dataSourceService) {
        this.chartRepository = chartRepository;
        this.dataSourceService = dataSourceService;
    }

    public Chart save(@Valid @NotNull(message = "图表信息不能为空！") Chart chart) throws ChartException {
        UserInfo userInfo = UserInfoThreadLocal.get();
        BaseChartConfig baseChartConfig = ChartConfigUtil.parseChartConfig(chart);
        baseChartConfig.verifyParam();
        Source source = dataSourceService.detailByCode(chart.getSourceCode());
        if (source == null) {
            throw new ChartException(ErrorCode.CHART_USES_SOURCE_NOT_EXIST);
        }
        BaseQueryConfig baseQueryConfig = QueryConfigUtil.parseBaseQueryConfig(chart, source.getSourceType());
        baseQueryConfig.verifyParam();
        chart.setCreator(userInfo.getEmpId());
        chart.setCreatorName(userInfo.getNick());
        chart.setChartCode(IdGenerator.getNextId());
        chart.setTenantCode(userInfo.getTenantCode());
        return chartRepository.save(chart);
    }


    public Chart detailByCode(@NotBlank(message = "图表代码不能为空！") String chartCode){
        Optional<Chart> optional = chartRepository.findOne((root, query, criteriaBuilder) -> {
            criteriaBuilder.equal(root.get(ChartConstant.CHART_CODE), chartCode);
            return criteriaBuilder.and(criteriaBuilder.equal(root.get(ChartConstant.CHART_CODE), chartCode));
        });
        return optional.orElse(null);
    }




}
