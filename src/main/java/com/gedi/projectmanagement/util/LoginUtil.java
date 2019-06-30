package com.gedi.projectmanagement.util;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.gedi.projectmanagement.config.URLConstant;
import com.gedi.projectmanagement.exception.ServiceException;
import com.taobao.api.ApiException;

/**
 * @Author: renpu
 * @Date: 2019/6/13 18:18
 * @Description:
 */
public class LoginUtil {

    public static String login(String authCode) {

        //(requestAuthCode);

        //获取accessToken,注意正是代码要有异常流处理
        String accessToken = AccessTokenUtil.getToken();
        //获取用户信息，调用相应的接口
        DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_GET_USER_INFO);
        //创建OapiUserGetuserinfoRequest对象
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        //获取前台传递过来的authCode；
        request.setCode(authCode);
        //设定请求的方式
        request.setHttpMethod("GET");
        OapiUserGetuserinfoResponse response;
        try {
            response = client.execute(request, accessToken);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new ServiceException("登录超时,请刷新后重试");
        }
        //3.查询得到当前用户的userId
        // 获得到userId之后应用应该处理应用自身的登录会话管理（session）,避免后续的业务交互（前端到应用服务端）每次都要重新获取用户身份，提升用户体验
        String userId = response.getUserid();

        return userId;
    }


    private static String getUserName(String accessToken, String userId) {
        try {
            DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_USER_GET);
            OapiUserGetRequest request = new OapiUserGetRequest();
            request.setUserid(userId);
            request.setHttpMethod("GET");
            OapiUserGetResponse response = client.execute(request, accessToken);
            return response.getName();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }

    }



}
