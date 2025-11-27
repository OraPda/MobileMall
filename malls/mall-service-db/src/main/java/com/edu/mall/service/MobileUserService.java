package com.edu.mall.service;


import com.edu.mall.dto.UpdateAdminPassword;
import com.edu.mall.pojo.LitemallUser;
import com.edu.mall.vo.MobileLoginVo;


public interface MobileUserService {
    MobileLoginVo loginCheck(String name, String password);

    /*修改密码*/
    int updatePassword(UpdateAdminPassword updateAdminPassword);


    /*注册用户*/
    LitemallUser register(LitemallUser litemallUser);

    /*修改用户信息*/
    int update(Integer userId,LitemallUser litemallUser);

}
