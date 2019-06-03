package com.gedi.projectmanagement.util;

import java.util.UUID;

/**
 * @ClassName: UUID
 * @Description: 为了让数据库里的主键生成UUID
 * @Author zhangshuai
 * @Date 2019-06-03 10:04:54
 * @Version 1.0
 **/
public class UUIDUtil {

    /**
     * 带-的UUID
     *
     * @return 36位的字符串
     */
    public static String getUUID1() {
        return UUID.randomUUID().toString();
    }

    /**
     * 去掉-的UUID
     *
     * @return 32位的字符串
     */
    public static String getUUID2() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
