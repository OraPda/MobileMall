package com.edu.mall.service;

import com.edu.mall.dto.CollectDto;
import com.edu.mall.pojo.LitemallCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectService {

    /*收藏商品查询*/
    List<LitemallCollect> selectAll(Integer userId);

    /*收藏商品添加*/
    int addCollect(LitemallCollect litemallCollect, @Param("userId") Integer userId);

    /*商品批量选中*/


    /*商品收藏批量删除*/
    int deleteCollect(@Param("dto") CollectDto dto,@Param("userId")Integer userId);

    /*商品批量选中*/
    int updateType(@Param("dto") CollectDto dto, @Param("userId")Integer userId);
}
