package com.edu.mall.controller;
import com.edu.mall.dto.CartProductUpdateDto;
import com.edu.mall.pojo.LitemallCart;
import com.edu.mall.service.MobileCartService;
import com.edu.mall.utils.ResponseUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins ="*")  //解决跨域
@RestController  //标注这个层  且  传输为json数据
@RequestMapping("/api/cart")   //类上的注解
public class CartController {
    @Resource
    private MobileCartService mobileCartService;
    @RequestMapping("/index")
    public Object getIndex(@Param("id") Integer userId){

        Object data=mobileCartService.getCartIndex(userId);
        return ResponseUtils.ok(data);
    }
    @RequestMapping(value = "/checked",method = RequestMethod.POST)
    public Object updateChecked( Integer userId,
                                @RequestBody CartProductUpdateDto dto){

        /*更新*/
        mobileCartService.updateChecked(dto,userId);
        /*重新查询*/
        Object data=mobileCartService.getCartIndex(userId);
        return  ResponseUtils.ok(data);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object delCartProducts(Integer userId,
                                  @RequestBody CartProductUpdateDto dto){
        mobileCartService.delCartProducts(dto,userId);
        /*重新查询*/
        Object data=mobileCartService.getCartIndex(userId);
        return  ResponseUtils.ok(data);
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Object updateNum(Integer userId,@RequestBody LitemallCart cart){
        mobileCartService.updateNum(cart,userId);
        Object data=mobileCartService.getCartIndex(userId);
        return ResponseUtils.ok(data);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addCartProducts(Integer userId,@RequestBody LitemallCart cart){
        mobileCartService.addCartProducts(cart,userId);
        Object data=mobileCartService.getCartIndex(userId);
        return ResponseUtils.ok(data);
    }

}