package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallGoodsSpecification;

public interface LitemallGoodsSpecificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGoodsSpecification record);

    int insertSelective(LitemallGoodsSpecification record);

    LitemallGoodsSpecification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallGoodsSpecification record);

    int updateByPrimaryKey(LitemallGoodsSpecification record);
}