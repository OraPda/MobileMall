package com.edu.mall.vo;

import java.util.Map;


public class MobileLoginVo {
    private Map<String,Object> userInfo;
    private String token;

    public Map<String, Object> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Map<String, Object> userInfo) {
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
