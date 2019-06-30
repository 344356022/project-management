package com.gedi.projectmanagement.config;

public class URLConstant {
    /**
     * 钉钉网关gettoken地址
     */
    public static final String URL_GET_TOKKEN = "https://oapi.dingtalk.com/gettoken";

    /**
     * 获取用户在企业内userId的接口URL
     */
    public static final String URL_GET_USER_INFO = "https://oapi.dingtalk.com/user/getuserinfo";

    /**
     * 获取用户姓名的接口url
     */
    public static final String URL_USER_GET = "https://oapi.dingtalk.com/user/get";

    /**
     * 获取部门用户
     *
     */

    public static final String URL_USER_SimpleList = "https://oapi.dingtalk.com/user/simplelist";


    /**
     * 获取部门用户详情
     *
     */

    public static final String URL_USER_LISTBYPAGE = "https://oapi.dingtalk.com/user/listbypage";

    /**
     * 获取部门信息列表
     */
    public static final String DEPARTMENT_LIST = "https://oapi.dingtalk.com/department/list";

    /**
     * 获取部门详细信息
     */
    public static final String DEPARTMENT_DETAIL = "https://oapi.dingtalk.com/department/get";


    /**
     * 创建用户
     *
     */
    public static final String USER_CREATE = "https://oapi.dingtalk.com/user/create";

    /**
     * 更新用户
     *
     */
    public static final String USER_UPDATE = "https://oapi.dingtalk.com/user/update";

    /**
     * 删除用户
     *
     */
    public static final String USER_DELETA = "https://oapi.dingtalk.com/user/delete";

    /**
     * 获取用户信息详情
     *
     */
    public static final String USER_DETAIL = "https://oapi.dingtalk.com/user/get";

    /**
     * 获取管理员列表
     *
     */
    public static final String USER_ADMIN = "https://oapi.dingtalk.com/user/get_admin";

}
