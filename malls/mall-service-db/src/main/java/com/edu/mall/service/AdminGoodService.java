package com.edu.mall.service;

import com.edu.mall.dto.AdminGoodsAddDto;
import com.edu.mall.pojo.LitemallGoods;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface AdminGoodService {

    List<LitemallGoods> queryAll();


    int addGoods(@Param("adminGoodsAddDto") AdminGoodsAddDto adminGoodsAddDto);

    PageInfo<LitemallGoods>  queryList();

    List<LitemallGoods> selectGoodById(@Param("id") Integer id);

    List<LitemallGoods> selectLikeKeyWord(@PathVariable("info")String info);
}
