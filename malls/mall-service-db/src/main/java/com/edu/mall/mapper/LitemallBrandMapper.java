package com.edu.mall.mapper;

import com.edu.mall.pojo.LitemallBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallBrand record);

    int insertSelective(LitemallBrand record);

    LitemallBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LitemallBrand record);

    int updateByPrimaryKey(LitemallBrand record);

    List<LitemallBrand> selectBrandList(@Param("limit")Integer limit);
}