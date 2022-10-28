package com.doris.odata.common.exception;

import com.doris.odata.common.enums.ErrorCode;

/**
 * @author: origindoris
 * @Title: DataSourceException
 * @Description:
 * @date: 2022/10/18 11:26
 */
public class DataSourceException extends OriginDataException{
    public DataSourceException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public DataSourceException(ErrorCode errorCode) {
        super(errorCode);
    }

    public DataSourceException(ErrorCode errorCode, String detailMsg) {
        super(errorCode, detailMsg);
    }
}
