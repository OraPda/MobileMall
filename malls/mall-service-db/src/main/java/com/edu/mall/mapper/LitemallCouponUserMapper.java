package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallCouponUser;

public interface LitemallCouponUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallCouponUser record);

    int insertSelective(LitemallCouponUser record);

    LitemallCouponUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallCouponUser record);

    int updateByPrimaryKey(LitemallCouponUser record);
}