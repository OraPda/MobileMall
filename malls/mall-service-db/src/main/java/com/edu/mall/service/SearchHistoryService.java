package com.edu.mall.service;

import com.edu.mall.pojo.LitemallSearchHistory;

import java.util.List;

public interface SearchHistoryService {
    List<LitemallSearchHistory> selectKeyWord();

    int deleteById(Integer id);
}
