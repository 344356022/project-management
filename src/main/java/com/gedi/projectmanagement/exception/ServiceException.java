/*
 * Copyright © 2016-2017 WAWSCM Inc. All rights reserved.
 */
package com.gedi.projectmanagement.exception;

/**
 * 业务异常
 *
 * @author Wang Chengwei
 * @since 1.0.0
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 4688428236412306008L;
	private String errorCode;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(ServiceError errorInfo) {
        super(errorInfo.getMessage());
        this.errorCode = errorInfo.getErrorCode();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
