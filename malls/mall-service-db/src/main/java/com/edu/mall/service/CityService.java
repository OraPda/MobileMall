package com.edu.mall.service;

import com.edu.mall.pojo.LitemallRegion;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CityService {
    List<LitemallRegion> selectAll();

    List<LitemallRegion> selectByType(@Param("type") Integer type);
    /*查询县*/
    List<LitemallRegion> selectById(Integer id,@Param("type") Integer type);
}
