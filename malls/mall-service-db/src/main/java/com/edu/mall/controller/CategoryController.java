package com.edu.mall.controller;

import com.edu.mall.service.MobileCategoryService;
import com.edu.mall.utils.ResponseUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Resource
    private MobileCategoryService mobileCategoryService;
    @RequestMapping("/index")
    public Object getIndex(){
        Object data=mobileCategoryService.getCategoryIndex();
        return ResponseUtils.ok(data);
    }
    @RequestMapping("/current")
    public Object getCategory(Integer id){
        Object data=mobileCategoryService.getCategoryAndSub(id);
        return ResponseUtils.ok(data);
    }
}
