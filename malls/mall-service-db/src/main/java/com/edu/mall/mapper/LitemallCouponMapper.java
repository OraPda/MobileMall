package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallCoupon;

public interface LitemallCouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCoupon record);

    int insertSelective(LitemallCoupon record);

    LitemallCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallCoupon record);

    int updateByPrimaryKey(LitemallCoupon record);
}