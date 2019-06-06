package com.gedi.projectmanagement.vo;

/**
 * @author wangyanbin
 * @description 返回类型工具类 200表示成功  500表示失败
 */
public class CodeAndMsgUtil {
    public static CodeAndMsg setOK(String msg, Object data){
        return new CodeAndMsg(200,msg,data);
    public static CodeAndMsg setOK(String msg, Object data) {
        return new CodeAndMsg(200, msg, data, true);
    }
    public static CodeAndMsg setERROR(String msg, Object data){
        return new CodeAndMsg(400,msg,null);

    public static CodeAndMsg setERROR(String msg, Object data) {
        return new CodeAndMsg(500, msg, null, false);
    }


}
