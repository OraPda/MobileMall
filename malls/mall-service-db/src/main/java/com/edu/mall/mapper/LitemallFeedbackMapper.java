package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallFeedback;

public interface LitemallFeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallFeedback record);

    int insertSelective(LitemallFeedback record);

    LitemallFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallFeedback record);

    int updateByPrimaryKey(LitemallFeedback record);
}