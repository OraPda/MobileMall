package com.edu.mall.service;

import com.edu.mall.dto.CartProductUpdateDto;
import com.edu.mall.pojo.LitemallCart;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface MobileCartService {
    Map<String,Object> getCartIndex(Integer userId);

    int updateChecked(CartProductUpdateDto dto, Integer userId);

    int delCartProducts(CartProductUpdateDto dto, Integer userId);

    /*修改购物车数量*/
    int updateNum(LitemallCart litemallCar,@Param("userId") Integer userId);
    /*增加购物车*/
    int addCartProducts(LitemallCart litemallCar,@Param("userId") Integer userId);
}
