package com.edu.mall.service.impl;

import com.edu.mall.mapper.LitemallSearchHistoryMapper;
import com.edu.mall.pojo.LitemallSearchHistory;
import com.edu.mall.service.SearchHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SerachHistoryServiceImpl implements SearchHistoryService {
    @Resource
    private LitemallSearchHistoryMapper litemallSearchHistoryMapper;

    @Override
    public List<LitemallSearchHistory> selectKeyWord() {
        return litemallSearchHistoryMapper.selectQuery();
    }

    @Override
    public int deleteById(Integer id) {
        return litemallSearchHistoryMapper.deleteByPrimaryKey(id);
    }
}
