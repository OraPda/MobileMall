package com.edu.mall.interceptor;


import com.edu.mall.utils.JwtHelper;
import com.edu.mall.utils.ResponseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TokenInterceptor implements HandlerInterceptor {
    public static final String TOKEN_KEY="Mall-Token";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*判断token是否有效*/
        String token = request.getHeader(TOKEN_KEY);
        if(new JwtHelper().verifyTokenAndGetUserId(token)!=0){
            return true;
        }else {//无效
            Object result= ResponseUtils.fail(ResponseUtils.INVALID_TOKEN, "请先登录");
            String resultJson = new ObjectMapper().writeValueAsString(result);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(resultJson);
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
