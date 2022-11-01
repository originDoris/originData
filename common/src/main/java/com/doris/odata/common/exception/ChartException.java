package com.doris.odata.common.exception;

import com.doris.odata.common.enums.ErrorCode;

/**
 * @author: origindoris
 * @Title: ChartException
 * @Description:
 * @date: 2022/11/1 13:56
 */
public class ChartException extends OriginDataException{
    public ChartException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ChartException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ChartException(ErrorCode errorCode, String detailMsg) {
        super(errorCode, detailMsg);
    }
}
