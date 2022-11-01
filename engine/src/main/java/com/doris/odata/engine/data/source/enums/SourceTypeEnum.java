package com.doris.odata.engine.data.source.enums;

import com.doris.odata.engine.chart.enums.ChartType;
import com.doris.odata.engine.chart.model.chart.config.BaseChartConfig;
import com.doris.odata.engine.chart.model.query.config.BaseQueryConfig;
import com.doris.odata.engine.chart.model.query.config.MysqlQueryConfig;
import com.doris.odata.engine.data.source.constant.DataSourceConstant;
import com.doris.odata.engine.data.source.model.property.MySqlSource;
import com.doris.odata.engine.data.source.model.property.SourceProperty;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author: origindoris
 * @Title: SourceTypeEnum
 * @Description:
 * @date: 2022/10/18 10:20
 */
public enum SourceTypeEnum {
    /**
     * 数据源类型
     */
    MYSQL(DataSourceConstant.MYSQL, "mysql", MySqlSource.class, MysqlQueryConfig.class),;
    private String type;

    private String desc;

    private Class<? extends SourceProperty> typeClass;

    private Class<? extends BaseQueryConfig> queryConfigClass;

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public Class<? extends BaseQueryConfig> getQueryConfigClass() {
        return queryConfigClass;
    }

    public Class<? extends SourceProperty> getTypeClass() {
        return typeClass;
    }

    SourceTypeEnum(String type, String desc, Class<? extends SourceProperty> typeClass, Class<? extends BaseQueryConfig> queryConfigClass) {
        this.type = type;
        this.desc = desc;
        this.typeClass = typeClass;
        this.queryConfigClass = queryConfigClass;
    }


    public static Class<? extends BaseQueryConfig> getQueryClass(String code){
        Optional<SourceTypeEnum> any = Arrays.stream(SourceTypeEnum.values()).filter(numberFormat -> code.equals(numberFormat.getType())).findAny();
        if (any.isEmpty()) {
            return null;
        }

        return any.get().getQueryConfigClass();
    }
}
