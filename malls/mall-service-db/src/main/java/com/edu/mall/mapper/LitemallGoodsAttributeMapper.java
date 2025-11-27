package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallGoodsAttribute;

public interface LitemallGoodsAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGoodsAttribute record);

    int insertSelective(LitemallGoodsAttribute record);

    LitemallGoodsAttribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallGoodsAttribute record);

    int updateByPrimaryKey(LitemallGoodsAttribute record);
}