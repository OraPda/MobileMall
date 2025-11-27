package com.edu.mall.controller;

import com.edu.mall.dto.OrderProductUpdateDto;
import com.edu.mall.pojo.LitemallOrderGoods;
import com.edu.mall.service.MobileOrderService;
import com.edu.mall.utils.ResponseUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins ="*")  //解决跨域
@RestController  //标注这个层  且  传输为json数据
@RequestMapping("/api/order")   //类上的注解
@ResponseBody
@Controller

public class OrderController {
    @Resource
    private MobileOrderService mobileOrderService;
    @RequestMapping("/index")
    public Object getIndex(@Param("id") Integer userId){

        Object data=mobileOrderService.getOrderIndex(userId);
        return ResponseUtils.ok(data);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object delOrderProducts( @RequestBody OrderProductUpdateDto dto,Integer userId){
        mobileOrderService.delOrderProducts(dto,userId);
        /*重新查询*/
        Object data=mobileOrderService.getOrderIndex(userId);
        return  ResponseUtils.ok(data);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addOrderProducts(Integer userId,@RequestBody LitemallOrderGoods orderGoods){
        mobileOrderService.addOrderProducts(orderGoods,userId);
        Object data=mobileOrderService.getOrderIndex(userId);
        return ResponseUtils.ok(data);
    }

}
