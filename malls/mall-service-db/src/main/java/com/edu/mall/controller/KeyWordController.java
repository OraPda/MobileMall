package com.edu.mall.controller;

import com.edu.mall.pojo.LitemallSearchHistory;
import com.edu.mall.service.SearchHistoryService;
import com.edu.mall.utils.ResponseUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/search")
public class KeyWordController {
    @Resource
    private SearchHistoryService searchHistoryService;
    @RequestMapping("/keyword")
    public Object getIndex(){
        Object data =searchHistoryService.selectKeyWord();
        return ResponseUtils.ok(data);
    }
    @RequestMapping(value = "/keyword",method = RequestMethod.DELETE)
    public Object delKeyWord(@Param ("id")Integer id){
        int i =searchHistoryService.deleteById(id);
        if (i==1){
            Object data =searchHistoryService.selectKeyWord();
            return ResponseUtils.ok(data);
        }
        return ResponseUtils.fail(555,"删除失败");
    }
}
