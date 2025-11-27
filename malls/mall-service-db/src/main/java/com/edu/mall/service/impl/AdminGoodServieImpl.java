package com.edu.mall.service.impl;

import com.edu.mall.dto.AdminGoodsAddDto;
import com.edu.mall.mapper.*;
import com.edu.mall.pojo.*;
import com.edu.mall.service.AdminGoodService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AdminGoodServieImpl implements AdminGoodService {
    @Resource
    private LitemallGoodsMapper litemallGoodsMapper;
    @Resource
    private LitemallGoodsProductMapper litemallGoodsProductMapper;
    @Resource
    private LitemallGoodsSpecificationMapper litemallGoodsSpecificationMapper;
    @Resource
    private LitemallGoodsAttributeMapper litemallGoodsAttributeMapper;
    @Resource
    private LitemallSearchHistoryMapper litemallSearchHistoryMapper;
    @Override
    public List<LitemallGoods> queryAll() {
        LitemallGoods litemallGoods=new LitemallGoods();
        return litemallGoodsMapper.selectGoodsList(litemallGoods);
    }

    @Override
    public int addGoods(AdminGoodsAddDto adminGoodsAddDto) {
        LitemallGoods litemallGoods=adminGoodsAddDto.getGoods();
        LitemallGoodsProduct litemallGoodsProduct=adminGoodsAddDto.getProducts();
        LitemallGoodsSpecification litemallGoodsSpecification=adminGoodsAddDto.getSpecifications();
        LitemallGoodsAttribute litemallGoodsAttribute=adminGoodsAddDto.getAttributes();
        litemallGoodsProductMapper.insertSelective(litemallGoodsProduct);
        litemallGoodsSpecificationMapper.insertSelective(litemallGoodsSpecification);
        litemallGoodsAttributeMapper.insertSelective(litemallGoodsAttribute);
        return litemallGoodsMapper.insertSelective(litemallGoods);
    }

    @Override
    public PageInfo<LitemallGoods> queryList() {
        return null;
    }

    @Override
    public List<LitemallGoods> selectGoodById(Integer id) {
        return litemallGoodsMapper.selectGoodAndProduct(id);
    }

    @Override
    public List<LitemallGoods> selectLikeKeyWord(String info) {
        LitemallSearchHistory litemallSearchHistory=new LitemallSearchHistory();
        litemallSearchHistory.setKeyword(info);
        litemallSearchHistory.setUserId(1);
        litemallSearchHistoryMapper.insertSelective(litemallSearchHistory);
        return litemallGoodsMapper.selectLikeKeyWord(info);
    }
}
