package com.doris.odata.engine.data.source.service;

import com.alibaba.fastjson2.JSONObject;
import com.doris.odata.common.enums.ErrorCode;
import com.doris.odata.common.exception.DataProcessException;
import com.doris.odata.common.exception.DataSourceException;
import com.doris.odata.common.interceptor.UserInfoThreadLocal;
import com.doris.odata.common.model.UserInfo;
import com.doris.odata.common.util.StrongUuidGenerator;
import com.doris.odata.engine.data.source.constant.DataSourceConstant;
import com.doris.odata.engine.data.source.context.DataSourceContext;
import com.doris.odata.engine.data.source.factory.DynamicDataSourceFactory;
import com.doris.odata.engine.data.source.model.Source;
import com.doris.odata.engine.data.source.repository.DataSourceRepository;
import com.doris.odata.engine.data.source.util.SourcePropertyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author: origindoris
 * @Title: DataSourceService
 * @Description:
 * @date: 2022/10/18 14:38
 */
@Service
@Slf4j
@Valid
@Validated
public class DataSourceService {


    private final DataSourceRepository dataSourceRepository;

    private final EntityManager entityManager;

    private static final StrongUuidGenerator IdGenerator = new StrongUuidGenerator();

    public DataSourceService(@Lazy DataSourceRepository dataSourceRepository, EntityManager entityManager) {
        this.dataSourceRepository = dataSourceRepository;
        this.entityManager = entityManager;
    }

    public List<Source> queryAllByType(@NotBlank(message = "数据源类型不能为空！") String sourceType) {
       return dataSourceRepository.findAll((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(DataSourceConstant.SOURCE_TYPE), sourceType));
    }


    /**
     * 执行本地查询，支持切换数据源
     * @param sql sql 语句
     * @param dataSourceKey 数据源key
     * @return
     * @throws DataProcessException
     * @throws DataSourceException
     */
    public List<Map> execNativeQuery(String sql, String dataSourceKey) throws DataProcessException, DataSourceException {
        if (!DynamicDataSourceFactory.getDataSourceMap().containsKey(dataSourceKey)) {
            Optional<Source> sourceDetail = dataSourceRepository.findOne((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(DataSourceConstant.SOURCE_CODE), dataSourceKey));
            if (sourceDetail.isEmpty()) {
                throw new DataProcessException(ErrorCode.PROCESS_DATA_SOURCE_NOT_EXIST);
            }
            DynamicDataSourceFactory.addDataSource(sourceDetail.get());
        }
        DataSourceContext.setDataSource(dataSourceKey);
        Query nativeQuery = entityManager.createNativeQuery(sql);
        List resultList = nativeQuery.getResultList();
        DataSourceContext.clearDataSourceKey();
        List<Map> maps = new ArrayList<>();
        for (Object o : resultList) {
            maps.add(new org.apache.commons.beanutils.BeanMap(o));
        }
        return maps;
    }


    /**
     * 保存数据源
     *
     * @param source
     * @return
     */
    public Source save(@Valid @NotNull(message = "数据源信息不能为空！") Source source) throws DataSourceException {
        UserInfo userInfo = UserInfoThreadLocal.get();
        JSONObject sourceProperty = source.getSourceProperty();
        SourcePropertyUtil.verify(sourceProperty);
        if (StringUtils.isBlank(source.getSourceCode())) {
            source.setSourceCode(IdGenerator.getNextId());
        }
        source.setCreator(userInfo.getEmpId());
        source.setCreatorName(userInfo.getNick());
        source.setTenantCode(userInfo.getTenantCode());
        return dataSourceRepository.save(source);
    }
}
