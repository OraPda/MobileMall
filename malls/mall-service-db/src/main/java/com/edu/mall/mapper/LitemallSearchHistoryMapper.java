package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallSearchHistory;

import java.util.List;

public interface LitemallSearchHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallSearchHistory record);

    int insertSelective(LitemallSearchHistory record);

    LitemallSearchHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallSearchHistory record);

    int updateByPrimaryKey(LitemallSearchHistory record);

    List<LitemallSearchHistory> selectQuery();
}