package com.edu.mall.service.impl;

import com.edu.mall.dto.CartProductUpdateDto;
import com.edu.mall.mapper.LitemallCartMapper;
import com.edu.mall.mapper.LitemallGoodsMapper;
import com.edu.mall.mapper.LitemallGoodsProductMapper;
import com.edu.mall.mapper.LitemallOrderGoodsMapper;
import com.edu.mall.pojo.LitemallCart;
import com.edu.mall.pojo.LitemallGoods;
import com.edu.mall.pojo.LitemallGoodsProduct;
import com.edu.mall.pojo.LitemallOrderGoods;
import com.edu.mall.service.MobileCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MobileCartServiceImpl implements MobileCartService {
    @Resource
    private LitemallCartMapper litemallCartMapper;
    @Resource
    private LitemallGoodsMapper litemallGoodsMapper;
    @Resource
    private LitemallGoodsProductMapper litemallGoodsProductMapper;

    int checkedGoodsCount = 0;
    double goodsAmount = 0;
    double checkedGoodsAmount = 0;

    @Override
    public Map<String, Object> getCartIndex(Integer userId) {

        List<LitemallCart> litemallCarts = litemallCartMapper.selectCartProductsByUserId(userId);
        Map<String, Object> vo = new HashMap<>();
        vo.put("cartList", litemallCarts);
        Map<String, Object> cartTotal = new HashMap<>();
        cartTotal.put("goodsCount", litemallCarts.size());
        litemallCarts.forEach(product -> {
            goodsAmount += product.getPrice() * product.getNumber();
            if (product.getChecked()) {
                checkedGoodsCount++;
                checkedGoodsAmount += product.getPrice() * product.getNumber();
            }
        });

        cartTotal.put("checkedGoodsCount", checkedGoodsCount);
        cartTotal.put("goodsAmount", goodsAmount);
        cartTotal.put("checkedGoodsAmount", goodsAmount);
        vo.put("cartTotal", cartTotal);
        return vo;
    }

    @Override
    public int updateChecked(CartProductUpdateDto dto, Integer userId) {

        return litemallCartMapper.updateChecked(dto, userId);
    }

    @Override
    public int delCartProducts(CartProductUpdateDto dto, Integer userId) {
        return litemallCartMapper.deleteCartProducts(dto, userId);
    }

    @Override
    public int updateNum(LitemallCart litemallCar, Integer userId) {


        return litemallCartMapper.updateByPrimaryKeySelective(litemallCar);
    }


    @Override
    public int addCartProducts(LitemallCart litemallCart,Integer userId) {
        LitemallGoods litemallGoods = litemallGoodsMapper.selectByPrimaryKey(litemallCart.getGoodsId());
        LitemallGoodsProduct litemallGoodsProduct = litemallGoodsProductMapper.selectByPrimaryKey(litemallCart.getProductId());
        litemallCart.setUserId(userId);
        litemallCart.setGoodsSn(litemallGoods.getGoodsSn());
        litemallCart.setPicUrl(litemallGoods.getPicUrl());
        litemallCart.setGoodsName(litemallGoods.getName());
        litemallCart.setPrice(litemallGoodsProduct.getPrice());
        litemallCart.setSpecifications(litemallGoodsProduct.getSpecifications());
        return litemallCartMapper.insertSelective(litemallCart);
    }
}
