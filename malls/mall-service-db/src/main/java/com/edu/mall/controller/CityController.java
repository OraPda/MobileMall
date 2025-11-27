package com.edu.mall.controller;

import com.edu.mall.service.CityService;
import com.edu.mall.utils.ResponseUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@CrossOrigin
@RestController
@RequestMapping("/api/city")
public class CityController {
    @Resource
    private CityService cityService;
    @RequestMapping("")
    public Object getIndex(){
        Object data=cityService.selectAll();
        return ResponseUtils.ok(data);
    }
    @RequestMapping("/list")
    public Object selectByType(Integer type){
        Object data=cityService.selectByType(type);
        return ResponseUtils.ok(data);
    }
    @RequestMapping("/list/one")
    public Object selectById(Integer id, Integer type){
        Object data=cityService.selectById(id, type);
        return ResponseUtils.ok(data);
    }

}
