package com.example.logindemo.common;

import sun.applet.resources.MsgAppletViewer;

public enum ApiStatusEnum {
    SUCC(1000,"success"),
    FAIL(400,"fail"),
    SYSTEM_ERROR(1001,"系统错误"),
    SHORT_OF_PARAMS(1001,  "缺少参数！"),
;
    private Integer code;
    private String msg;

    public Integer getCode(){
        return code;
    }
    public void setCode(Integer code){
        this.code = code;

    }
    public String getMsg(){
        return msg;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    ApiStatusEnum(Integer code ,String  msg){
        this.code = code;
        this.msg = msg;
    }





}
