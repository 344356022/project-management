/*
 * Copyright © 2016-2018 WAWSCM Inc. All rights reserved.
 */
package com.gedi.projectmanagement.base;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * 通用mapper
 *
 * @author zhang xingya
 * @since 1.0.0
 */
public interface GeneralMapper<T> extends Mapper<T>, MySqlMapper<T> {

    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
     *
     * @param recordList bean数据
     * @return 操作行数
     */
    @InsertProvider(type = InsertListPlusProvider.class, method = "dynamicSQL")
    int batchInsert(List<T> recordList);

}
