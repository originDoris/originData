package com.doris.hdata.common.exception;

import com.doris.hdata.common.enums.ErrorCode;

import java.text.MessageFormat;

/**
 * @author: origindoris
 * @Title: HDataException
 * @Description: 全局异常
 * @date: 2022/10/18 11:21
 */
public class HDataException extends Exception {

    private static final String ERROR_MSG_FORMAT = "{0}({1})";
    private Integer errorCode;

    private String errorMsg;

    public HDataException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public HDataException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode.getCode();
        this.errorMsg = errorCode.getMsg();
    }

    public HDataException(ErrorCode errorCode, String detailMsg) {
        super(errorCode.getMsg());
        String errMsg = MessageFormat.format(ERROR_MSG_FORMAT, errorCode.getMsg(), detailMsg);
        this.errorCode = errorCode.getCode();
        this.errorMsg = errMsg;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
