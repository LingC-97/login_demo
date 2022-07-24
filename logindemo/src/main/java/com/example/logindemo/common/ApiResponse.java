package com.example.logindemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private Integer code;
    private String msg;
    private HashMap<String ,Object> data;


    public static ApiResponse success(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.code = ApiStatusEnum.SUCC.getCode();
        apiResponse.msg = ApiStatusEnum.SUCC.getMsg();
        return apiResponse;
    }

    public static ApiResponse success(HashMap<String ,Object> data){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.code = ApiStatusEnum.SUCC.getCode();
        apiResponse.msg = ApiStatusEnum.SUCC.getMsg();
        apiResponse.data = data;
        return apiResponse;
    }
    public static ApiResponse fail(String msg){
        ApiResponse response = new ApiResponse();
        response.code = ApiStatusEnum.SYSTEM_ERROR.getCode();
        response.msg = msg;
        return response;
    }
    public static ApiResponse fail(ApiStatusEnum responseEnum,String msg){
        ApiResponse response = new ApiResponse();
        response.code = responseEnum.getCode();
        response.msg = msg;
        return response;
    }
//    public static ApiResponse fail(ApiStatusEnum responseEnum){
//        ApiResponse response = new ApiResponse();
//        response.code = responseEnum.getCode();
//        response.msg = responseEnum.getMsg();
//        return response;
//    }

    public static ApiResponse fail(){
        ApiResponse response = new ApiResponse();
        response.code = ApiStatusEnum.SYSTEM_ERROR.getCode();
        response.msg = ApiStatusEnum.SYSTEM_ERROR.getMsg();
        return response;
    }

    public static ApiResponse error(Throwable throwable) {
        ApiResponse response = new ApiResponse();
        response.code = ApiStatusEnum.SYSTEM_ERROR.getCode();
        response.msg = ApiStatusEnum.SYSTEM_ERROR.getMsg();
        response.appendData("exception", throwable);
        return response;

    }
    public ApiResponse list (List list){
        if(list != null ){
            data.put("list",list);
        }
        return this;
    }

    public ApiResponse appendData(String k,Object v){
        if(v!=null){
            data.put(k,v);
        }
        return this;
    }

    public ApiResponse total(long l){
        data.put("total",l);
        return this;
    }


}
