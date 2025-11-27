package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGoods record);

    int insertSelective(LitemallGoods record);

    LitemallGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallGoods record);

    int updateByPrimaryKeyWithBLOBs(LitemallGoods record);

    int updateByPrimaryKey(LitemallGoods record);

    List<LitemallGoods> selectGoodsList(LitemallGoods litemallGoods);

    List<LitemallGoods> selectLikeKeyWord(@Param("keyword") String keyword);

    List<LitemallGoods> selectGoodAndProduct(@Param("id") Integer id);


}