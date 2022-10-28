package com.doris.odata.common.exception;

import com.doris.odata.common.enums.ErrorCode;

/**
 * @author: origindoris
 * @Title: ProcessException
 * @Description:
 * @date: 2022/10/18 15:48
 */
public class DataProcessException extends OriginDataException{
    public DataProcessException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public DataProcessException(ErrorCode errorCode) {
        super(errorCode);
    }

    public DataProcessException(ErrorCode errorCode, String detailMsg) {
        super(errorCode, detailMsg);
    }
}
