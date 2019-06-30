/*
 * Copyright © 2016-2017 WAWSCM Inc. All rights reserved.
 */
package com.gedi.projectmanagement.exception;

/**
 * 业务错误信息
 *
 * @author Wang Chengwei
 * @since 1.0.0
 */
public interface ServiceError {

    /**
     * 获取错误代码
     */
    String getErrorCode();

    /**
     * 获取错误信息
     */
    String getMessage();
}
