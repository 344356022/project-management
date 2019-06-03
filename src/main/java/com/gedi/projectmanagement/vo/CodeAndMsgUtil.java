package com.gedi.projectmanagement.vo;

public class CodeAndMsgUtil {
    public static CodeAndMsg setOK(String msg, Object data){
        return new CodeAndMsg(1000,msg,data);
    }
    public static CodeAndMsg setERROR(String msg, Object data){
        return new CodeAndMsg(2000,msg,null);
    }




}
