package com.edu.mall.controller;

import com.edu.mall.dto.CollectDto;
import com.edu.mall.pojo.LitemallCollect;
import com.edu.mall.service.CollectService;
import com.edu.mall.utils.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/admin/collect")
public class CollectsController {
    @Resource
    private CollectService collectService;
    @RequestMapping("/list")
    public Object getIndex(Integer id){
        Object data = collectService.selectAll(id);
        System.out.println(data);
        return ResponseUtils.ok(data);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addList(@RequestBody LitemallCollect litemallCollect,Integer userId){
        collectService.addCollect(litemallCollect,userId);
        Object data = collectService.selectAll(userId);
        System.out.println(data);
        return ResponseUtils.ok(data);
    }
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Object delList(@RequestBody CollectDto dto,Integer userId){
        collectService.deleteCollect(dto,userId);
        Object data = collectService.selectAll(userId);
        System.out.println(data);
        return ResponseUtils.ok(data);
    }
    /*修改是否选中*/
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Object updateList(@RequestBody CollectDto dto, Integer userId){
        collectService.updateType(dto,userId);
        Object data = collectService.selectAll(userId);
        System.out.println(data);
        return ResponseUtils.ok(data);
    }
}
