package com.edu.mall.service.impl;

import com.edu.mall.dto.CollectDto;
import com.edu.mall.mapper.LitemallCollectMapper;
import com.edu.mall.pojo.LitemallCollect;
import com.edu.mall.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private LitemallCollectMapper litemallCollectMapper;
    @Override
    public List<LitemallCollect> selectAll(Integer userId) {

        return litemallCollectMapper.selectAll(userId);
    }

    @Override
    public int addCollect(LitemallCollect litemallCollect, Integer userId) {
        litemallCollect.setUserId(userId);

        return litemallCollectMapper.insertSelective(litemallCollect);
    }

    @Override
    public int deleteCollect( CollectDto dto, Integer userId) {
        return litemallCollectMapper.deleteIds(dto,userId);
    }

    @Override
    public int updateType(CollectDto dto, Integer userId) {
        return litemallCollectMapper.updateType(dto,userId);
    }
}
