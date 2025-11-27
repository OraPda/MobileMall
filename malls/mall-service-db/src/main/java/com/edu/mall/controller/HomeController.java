package com.edu.mall.controller;

import com.edu.mall.service.MobileHomeService;
import com.edu.mall.utils.ResponseUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/home")
public class HomeController {
    @Resource
    private MobileHomeService mobileHomeService;
    @RequestMapping("/index")
    public Object index(){
        Object data=mobileHomeService.getHomeIndex();
        return ResponseUtils.ok(data);
    }
    @RequestMapping("/money")
    public Object money(){
        return "hello";
    }
}

