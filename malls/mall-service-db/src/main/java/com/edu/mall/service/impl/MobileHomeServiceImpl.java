package com.edu.mall.service.impl;

import com.edu.mall.mapper.*;
import com.edu.mall.pojo.LitemallGoods;
import com.edu.mall.service.MobileHomeService;
import com.edu.mall.vo.MobileHomeVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MobileHomeServiceImpl implements MobileHomeService {
    @Resource
    private LitemallAdMapper litemallAdMapper;
    @Resource
    private LitemallCategoryMapper litemallCategoryMapper;
    @Resource
    private LitemallGrouponRulesMapper litemallGrouponRulesMapper;
    @Resource
    private LitemallGoodsMapper litemallGoodsMapper;
    @Resource
    private LitemallTopicMapper litemallTopicMapper;
    @Resource
    private LitemallBrandMapper litemallBrandMapper;
    @Override
    public MobileHomeVo getHomeIndex() {
        MobileHomeVo vo=new MobileHomeVo();
        /*广告数据列表*/
        vo.setBanner(litemallAdMapper.selectList());
        /*分类引导*/
       vo.setChannel(litemallCategoryMapper.selectLevel1List());
       /*团购*/
        vo.setGrouponList(litemallGrouponRulesMapper.selectGroupOnRulesList());
        /*品牌商*/
        vo.setBrandList(litemallBrandMapper.selectBrandList(6));
        /*新品*/
        LitemallGoods litemallGoods=new LitemallGoods();
        litemallGoods.setIsNew(true);
        litemallGoods.setLimit(6);
        vo.setNewGoodsList(litemallGoodsMapper.selectGoodsList(litemallGoods));
        /*热卖*/
        litemallGoods.clear();
        litemallGoods.setIsHot(true);
        litemallGoods.setLimit(6);
        vo.setHotGoodsList(litemallGoodsMapper.selectGoodsList(litemallGoods));
        /*主题*/
        vo.setTopicList(litemallTopicMapper.selectTopicList(4));
        return vo;
    }
}
