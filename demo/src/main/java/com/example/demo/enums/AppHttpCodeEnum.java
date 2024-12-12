package com.example.demo.enums;

public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"Success"),
    SYSTEM_ERROR(500,"Error"),
    CAR_NOT_FOUND(404, "Product Not Found")
    ;
    int code;
    String msg;
    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
