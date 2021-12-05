package com.example.spring_demo.common.utils.response;
/**
 * 枚举处理请求响应事件
 * */
public enum ResultCodeEnum implements PrintResultCode {
    R_SUCCESS("200","请求成功");
    private String code;
    private String message;
    ResultCodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public  String getCode(){return code;}
    public  void setCode(String code){this.code =code;}
    public  String getMessage(){return message;}
    public  void setMessage(String code){this.message =message;}

    /**
     * 就试试枚举里面实现接口行不行
     * */
    @Override
    public void print() {
        System.out.print(this.code+this.message);
    }
}

