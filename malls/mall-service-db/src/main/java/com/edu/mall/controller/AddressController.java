package com.edu.mall.controller;

import com.edu.mall.pojo.LitemallAddress;
import com.edu.mall.service.AddressService;
import com.edu.mall.utils.ResponseUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Resource
    private AddressService addressService;
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public Object addAddress(@RequestBody LitemallAddress litemallAddress, Integer userId){
        Object data=addressService.addAddress(litemallAddress,userId);
        return ResponseUtils.ok(data);
    }

        @RequestMapping("/list")
    public Object addAddress(){
        Object data=addressService.queryAll();
        return data;
    }
/*修改地址*/
    @RequestMapping(value = "/edit",method =RequestMethod.PUT )
    public Object updateDefult(@RequestBody LitemallAddress litemallAddress, Integer userId){
        addressService.updateAddress(litemallAddress,userId);
        Object data = addressService.queryAll();
        return ResponseUtils.ok(data);
    }
    /*删除*/
    @RequestMapping(value = "/del",method =RequestMethod.DELETE)
    public Object delAddress(@Param("id") Integer id, Integer userId){
        addressService.delAddress(id,userId);
        Object data = addressService.queryAll();
        return ResponseUtils.ok(data);
    }
}
