package com.edu.mall.mapper;

import com.edu.mall.dto.CartProductUpdateDto;
import com.edu.mall.pojo.LitemallCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCart record);

    int insertSelective(LitemallCart record);

    LitemallCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallCart record);

    int updateByPrimaryKey(LitemallCart record);

    /*查询购物车商品列表*/
    List<LitemallCart> selectCartProductsByUserId(@Param("userId") Integer userId);

    /*修改购物车货品选择状态*/
    int updateChecked(@Param("dto") CartProductUpdateDto cartProductUpdateDto, @Param("userId")Integer userId);

    int deleteCartProducts(@Param("dto") CartProductUpdateDto cartProductUpdateDto, @Param("userId")Integer userId);
    /*删除购物车列表*/


}