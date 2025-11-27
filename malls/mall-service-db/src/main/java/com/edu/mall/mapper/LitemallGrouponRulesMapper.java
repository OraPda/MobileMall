package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallGrouponRules;

import java.util.List;


public interface LitemallGrouponRulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallGrouponRules record);

    int insertSelective(LitemallGrouponRules record);

    LitemallGrouponRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallGrouponRules record);

    int updateByPrimaryKey(LitemallGrouponRules record);

    List<LitemallGrouponRules> selectGroupOnRulesList();
}