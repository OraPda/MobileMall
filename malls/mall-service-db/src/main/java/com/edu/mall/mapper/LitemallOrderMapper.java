package com.edu.mall.mapper;

import com.edu.mall.dto.CartProductUpdateDto;
import com.edu.mall.dto.OrderProductUpdateDto;
import com.edu.mall.pojo.LitemallCart;
import com.edu.mall.pojo.LitemallOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yang
 * @createtime 2023.04
 */

public interface LitemallOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallOrder record);

    int insertSelective(LitemallOrder record);

    LitemallOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallOrder record);

    int updateByPrimaryKey(LitemallOrder record);

    /*查询下单商品列表*/
    List<LitemallOrder> selectOrderProductsByUserId(@Param("userId") Integer userId);

    /*删除下单商品*/
    int deleteOrderProducts(@Param("dto") OrderProductUpdateDto orderProductUpdateDto, @Param("userId")Integer userId);
}