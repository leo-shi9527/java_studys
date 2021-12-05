package com.example.spring_demo.common.utils.response;

import org.springframework.util.StringUtils;

import java.io.Serializable;

public class AppResponse<T> implements Serializable {
    /** 请求码*/
    private String code;
    /**返回数据*/
    private  T data ;
    private  String message;
    public AppResponse() {}

    /**
     * 处理响应的结果,都用静态方法。那么有几个问题：
     * 1.这个静态方法是啥？
     * 2.其它语言是否有不同？
     * 3.类方法，成员方法都怎么实现呢？
     * */

    /**
     * @param data 请求结果
     * @return AppResponse
     * */
    public  static <T> AppResponse<T> success(T data){
        AppResponse<T> response = new AppResponse<T>();
        response.setCode(ResultCodeEnum.R_SUCCESS.getCode());
        response.setData(data);
        response.setMessage("");
        return  response ;
    }


    /**
     * @param result 请求结果,不需要数据,只要一些状态码,与状态信息
     * @return  AppResponse
     * */
    public  static  AppResponse<String> success(ResultCodeEnum result){
        AppResponse<String> response = new AppResponse<String>();
        response.setCode(result.getCode());
        // 有些请求不需要数据类型的返回结果,只要状态
        response.setData(result.getMessage());
        response.setMessage("请求成功");
        return response;
    }


    /**
     * 返回响应错误信息
     * @param errorCode 错误码
     * @return AppResponse
     * */
    public  static AppResponse<String> error(ResultCodeEnum errorCode){return error(errorCode,null);}



    /**
     * 利用多态的方式,提供丰富的错误处理函数.
     * 返回响应错误信息
     * @param errorCode 错误码
     * @param message 补充错误信息
     * @return AppResponse
     * */
    public  static AppResponse<String> error(ResultCodeEnum errorCode,String message){
        if (StringUtils.hasLength(message)){
            message = errorCode.getMessage();
        }
        AppResponse<String> response = new AppResponse<String>();
        response.setCode(errorCode.getCode());
        response.setMessage(message);
        response.setData("");
        return response;
    }
    /**
     * 提供更原始的错误方法,方便应对一些特殊的错误
     * */
    public static  AppResponse<String> error(String code,String message){
        AppResponse<String> response = new AppResponse<String>();
        response.setCode(code);
        response.setMessage(message);
        response.setData("");
        return response;
    }

    /**
     * 相关的 set ,get 方法,不知道有没有工具,不用写这些,以前 OC MRC 写 get,set 都写哭了,满屏的 get set,脑壳痛.
     * */
    public String getCode(){return  code;}
    public void setCode(String code){this.code = code;}
    public T getData(){return  data;}
    public  void setData(T data){this.data = data;}
    public String getMessage(){return message;}
    public void setMessage(String message){this.message = message;}

}
