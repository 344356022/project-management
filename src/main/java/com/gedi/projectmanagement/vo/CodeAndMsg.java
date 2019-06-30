package com.gedi.projectmanagement.vo;

public class CodeAndMsg {
    private int code;
    private String msg;
    private Boolean result; //true 成功, false 失败
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public CodeAndMsg() {

    }
    public CodeAndMsg(int code, String msg, Object data, Boolean result) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.result = result;
    }
}
