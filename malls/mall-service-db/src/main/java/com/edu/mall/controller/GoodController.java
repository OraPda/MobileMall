package com.edu.mall.controller;

import com.edu.mall.dto.AdminGoodsAddDto;
import com.edu.mall.pojo.LitemallGoods;
import com.edu.mall.service.AdminGoodService;
import com.edu.mall.utils.ResponseUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/admin/goods")
public class GoodController {
    @Resource
    private AdminGoodService adminGoodService;
    @RequestMapping("/list")
    public Object getIndex(){
        return adminGoodService.queryAll();
    }
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public Object addGoods(@RequestBody AdminGoodsAddDto adminGoodsAddDto){
        adminGoodService.addGoods(adminGoodsAddDto);
        Object data=adminGoodService.queryAll();
    return ResponseUtils.ok(data);
    }
    @RequestMapping("")
    public Object selectById(Integer id){
        Object data= adminGoodService.selectGoodById(id);
        return ResponseUtils.ok(data);
    }
    @RequestMapping("keyword")
    public Object selectLike(String keyword){
        Object data= adminGoodService.selectLikeKeyWord(keyword);
        return ResponseUtils.ok(data);
    }
}
