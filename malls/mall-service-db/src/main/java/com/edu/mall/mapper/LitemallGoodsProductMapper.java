package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallGoods;
import com.edu.mall.pojo.LitemallGoodsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallGoodsProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGoodsProduct record);

    int insertSelective(LitemallGoodsProduct record);

    LitemallGoodsProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallGoodsProduct record);

    int updateByPrimaryKey(LitemallGoodsProduct record);

}