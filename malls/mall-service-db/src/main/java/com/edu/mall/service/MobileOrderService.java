package com.edu.mall.service;

import com.edu.mall.dto.OrderProductUpdateDto;
import com.edu.mall.pojo.LitemallOrderGoods;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author YANG
 */

public interface MobileOrderService {
    Map<String,Object> getOrderIndex(Integer userId);

    int addOrderProducts(LitemallOrderGoods litemallOrderGoods, @Param("userId") Integer userId);

    int delOrderProducts(OrderProductUpdateDto dto, Integer userId);

}
