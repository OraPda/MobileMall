package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallAd;

import java.util.List;

public interface LitemallAdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAd record);

    int insertSelective(LitemallAd record);

    LitemallAd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallAd record);

    int updateByPrimaryKey(LitemallAd record);

    List<LitemallAd> selectList();
}