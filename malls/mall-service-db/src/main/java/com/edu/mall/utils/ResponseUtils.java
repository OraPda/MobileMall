package com.edu.mall.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘仲英
 * @date 2022/9/27
 */
public class ResponseUtils {
    public static final int SUCCESS=0;
    public static final int INVALID_LOGIN=700;
    public static final int INVALID_TOKEN=501;
    /*成功响应*/
    public static Object ok(Object data){
        Map<String,Object> result=new HashMap<>();
        result.put("errno",SUCCESS);
        result.put("errmsg","成功");
        result.put("data",data);
        return result;
    }
    /*失败响应*/
    public static Object fail(int errno,String errmsg,Object data){
        Map<String,Object> result=new HashMap<>();
        result.put("errno",errno);
        result.put("errmsg",errmsg);
        result.put("data",data);
        return result;
    }
    public static Object fail(int errno,String errmsg){
        return fail(errno,errmsg,null);
    }
}
