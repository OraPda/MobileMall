package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAddress record);

    int insertSelective(LitemallAddress record);

    LitemallAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallAddress record);

    int updateByPrimaryKey(LitemallAddress record);

    List<LitemallAddress> selectAll();

    LitemallAddress selectBydefult(@Param("is_default")Integer is_default);
}