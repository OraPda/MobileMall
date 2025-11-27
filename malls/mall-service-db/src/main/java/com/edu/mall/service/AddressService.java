package com.edu.mall.service;

import com.edu.mall.pojo.LitemallAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface AddressService {
    /*查询所有地址*/
    List<LitemallAddress> queryAll();
    /*增加地址*/
    int addAddress(LitemallAddress litemallAddress, @Param("userId") Integer userId);
    /*修改地址*/
    int updateAddress(LitemallAddress litemallAddress,@Param("userId") Integer userId);
    /*删除地址*/
    int delAddress(Integer id,Integer userId);
}
