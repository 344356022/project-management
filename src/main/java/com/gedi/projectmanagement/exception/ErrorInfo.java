/*
 * Copyright © 2016-2017 WAWSCM Inc. All rights reserved.
 */
package com.gedi.projectmanagement.exception;

/**
 * 错误信息
 *
 * @author Wang Chengwei
 * @since 1.0.0
 */
public enum ErrorInfo implements ServiceError {

    UNAUTHORIZED("998", "权限不足"),
    UNLOGIN("999", "登陆失效"),
    MISSING_PARAMETERS("400", "缺少必要请求参数"),
    ILLEGAL_PARAMETER("401", "非法请求参数"),
    INTERNAL_EXCEPTION("500", "服务器内部异常"),
    NOT_SUPPORTED("415", "请求方法不支持"),
    NO_DATA_TO_CLEAN("88888", "没有可结算数据")
    ;

    private String errorCode;
    private String message;

    ErrorInfo(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
