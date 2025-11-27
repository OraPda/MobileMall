package com.edu.mall.service.impl;

import com.edu.mall.mapper.LitemallRegionMapper;
import com.edu.mall.pojo.LitemallRegion;
import com.edu.mall.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CityServiceImpl implements CityService {
    @Resource
    private LitemallRegionMapper litemallRegionMapper;
    @Override
    public List<LitemallRegion> selectAll() {
        return litemallRegionMapper.selectAll();
    }

    @Override
    public List<LitemallRegion> selectByType(Integer type) {
        return litemallRegionMapper.selectByType(type);
    }

    @Override
    public List<LitemallRegion> selectById(Integer id, Integer type) {
        return litemallRegionMapper.selectById(id,type);
    }

}
