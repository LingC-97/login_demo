package com.example.logindemo.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResult<T> implements Serializable {
    private Integer code;
    private  String msg;
    private T data;
    public ApiResult(Integer code, String msg, T data) {  //T data 是什么？ 是返回的json那一串结果
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public  static<T>  ApiResult<T> success ( T data){
        return  new ApiResult<>(0,"成功", data);
    }

    public static <T> ApiResult<T> success(){
        return  new ApiResult<>(0,"成功",null);

    }


    public static <T> ApiResult <T> failed(Integer errorCode ,String msg) {
        return new ApiResult<>(errorCode, msg,null);
    }



    //这个不太理解
    public static <T> ApiResult  <T>  failed(ApiStatusEnum errorCode ) {
        return failed(errorCode.getCode(), errorCode.getMsg());
    }


}


//    { code: 0,
//      msg:"成功",
//      data:{
//        id:1,
//        name:xiaochen,
//        password: 12345,
//      }
//    }

//    { code: 0,
//      msg:"成功",
//      data:null
//    }

//    { code: 1000,
//      msg:"fail",
//      data:null
//    }
