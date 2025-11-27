package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallOrderGoods;

import java.util.List;

public interface LitemallOrderGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallOrderGoods record);

    int insertSelective(LitemallOrderGoods record);

    LitemallOrderGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallOrderGoods record);

    int updateByPrimaryKey(LitemallOrderGoods record);

}