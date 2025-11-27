package com.edu.mall.service.impl;


import com.edu.mall.dto.OrderProductUpdateDto;
import com.edu.mall.mapper.LitemallGoodsMapper;
import com.edu.mall.mapper.LitemallGoodsProductMapper;
import com.edu.mall.mapper.LitemallOrderGoodsMapper;
import com.edu.mall.mapper.LitemallOrderMapper;
import com.edu.mall.pojo.LitemallGoods;
import com.edu.mall.pojo.LitemallGoodsProduct;
import com.edu.mall.pojo.LitemallOrder;
import com.edu.mall.pojo.LitemallOrderGoods;
import com.edu.mall.service.MobileOrderService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MobileOrderServiceImpl implements MobileOrderService {
    @Resource
    private LitemallOrderMapper litemallOrderMapper;
    @Resource
    private LitemallGoodsMapper litemallGoodsMapper;
    @Resource
    private LitemallGoodsProductMapper litemallGoodsProductMapper;
    @Resource
    private LitemallOrderGoodsMapper litemallOrderGoodsMapper;
    @Resource
    private LitemallOrder litemallOrder;

    double goodsAmount = 0;
    @Override
    public Map<String, Object> getOrderIndex(Integer userId) {
        List<LitemallOrder> litemallOrders = litemallOrderMapper.selectOrderProductsByUserId(userId);
        Map<String, Object> vo = new HashMap<>();
        vo.put("orderList", litemallOrders);
        Map<String, Object> orderTotal = new HashMap<>();
        orderTotal.put("goodsCount", litemallOrders.size());
        litemallOrders.forEach(product -> {
            goodsAmount = product.getOrderPrice() + product.getIntegralPrice();
        });
        orderTotal.put("goodsAmount", goodsAmount);
        vo.put("orderTotal", orderTotal);
        return vo;
    }

    @Override
    public int addOrderProducts(LitemallOrderGoods litemallOrderGoods, Integer userId) {
        LitemallGoods litemallGoods = litemallGoodsMapper.selectByPrimaryKey(litemallOrderGoods.getGoodsId());
        LitemallGoodsProduct litemallGoodsProduct = litemallGoodsProductMapper.selectByPrimaryKey(litemallOrderGoods.getProductId());
        litemallOrder.setUserId(userId);
        litemallOrderGoods.setGoodsSn(litemallGoods.getGoodsSn());
        litemallOrderGoods.setPicUrl(litemallGoods.getPicUrl());
        litemallOrderGoods.setGoodsName(litemallGoods.getName());
        litemallOrderGoods.setPrice(BigDecimal.valueOf(litemallGoodsProduct.getPrice()));
        litemallOrderGoods.setSpecifications(litemallGoodsProduct.getSpecifications());
        return litemallOrderGoodsMapper.insertSelective(litemallOrderGoods);
    }

    @Override
    public int delOrderProducts(OrderProductUpdateDto dto, Integer userId) {
        return litemallOrderMapper.deleteOrderProducts(dto, userId);
    }
}
