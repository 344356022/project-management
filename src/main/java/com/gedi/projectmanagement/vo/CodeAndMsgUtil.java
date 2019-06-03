package com.gedi.projectmanagement.vo;

/**
 * @author wangyanbin
 * @description 返回类型工具类 1000表示成功  2000表示失败
 */
public class CodeAndMsgUtil {
    public static CodeAndMsg setOK(String msg, Object data){
        return new CodeAndMsg(1000,msg,data);
    }
    public static CodeAndMsg setERROR(String msg, Object data){
        return new CodeAndMsg(2000,msg,null);
    }




}
