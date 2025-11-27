package com.edu.mall.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.edu.mall.dto.UpdateAdminPassword;
import com.edu.mall.mapper.LitemallUserMapper;
import com.edu.mall.pojo.LitemallUser;
import com.edu.mall.service.MobileUserService;
import com.edu.mall.utils.BCryptPasswordEncoder;
import com.edu.mall.utils.JwtHelper;
import com.edu.mall.vo.MobileLoginVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;


@Service
public class MobileUserServiceImpl implements MobileUserService {
    @Resource
    private LitemallUserMapper litemallUserMapper;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    private JwtHelper jwtHelper=new JwtHelper();

    @Override
    public MobileLoginVo loginCheck(String name, String password) {
        MobileLoginVo vo=new MobileLoginVo();
        LitemallUser litemallUser = litemallUserMapper.selectUserByUsername(name);
        if(litemallUser!=null){
            /*比对密码*/
            /*litemallUser.getPassword().equals(password)*/
            if(encoder.matches(password,litemallUser.getPassword())){
                System.out.println("登录成功");
                Map<String,Object> userInfo=new HashMap<>();
                userInfo.put("nickName",litemallUser.getNickname());
                userInfo.put("avatarUrl",litemallUser.getAvatar());
                userInfo.put("userId",litemallUser.getId());
                vo.setUserInfo(userInfo);
                vo.setToken(jwtHelper.createToken(litemallUser.getId()));
                return vo;
            }
        }
        return null;
    }

    @Override
    public int updatePassword(UpdateAdminPassword updateAdminPassword) {
        if(StrUtil.isEmpty(updateAdminPassword.getUsername())
                || StrUtil.isEmpty(updateAdminPassword.getOldPassword())
                ||StrUtil.isEmpty(updateAdminPassword.getNewPassword())){
            return -1;
        }
        LitemallUser userList=litemallUserMapper.selectUserByUsername(updateAdminPassword.getUsername());
        if(userList==null){
            return -2;
        }
        if(!encoder.matches(updateAdminPassword.getOldPassword(),userList.getPassword())){
            return -3;
        }
        userList.setPassword(encoder.encode(updateAdminPassword.getNewPassword()));
        int i = litemallUserMapper.updateByPrimaryKeySelective(userList);
        System.out.println(i);
        return 1;
    }

    @Override
    public LitemallUser register(LitemallUser litemallUser) {
        System.out.println(litemallUser.getUsername());
        System.out.println(litemallUserMapper.selectUserByUsername(litemallUser.getUsername()));
        if(litemallUserMapper.selectUserByUsername(litemallUser.getUsername())==null) {
            String passWord = encoder.encode(litemallUser.getPassword());
            litemallUser.setPassword(passWord);
            litemallUser.setStatus((byte) 0);
            litemallUserMapper.insertSelective(litemallUser);
            return litemallUser;
        }
        return null;
    }

    @Override
    public int update(Integer userId, LitemallUser litemallUser) {
        System.out.println(11);
        litemallUser.setId(userId);
        LitemallUser user = litemallUserMapper.selectByPrimaryKey(userId);
        if (user.getPassword().equals(litemallUser.getPassword())){
            litemallUser.setPassword(null);
        }else {
            if(StrUtil.isEmpty(litemallUser.getPassword())){
                litemallUser.setPassword(null);
            }else{
                litemallUser.setPassword(encoder.encode(litemallUser.getPassword()));
            }
        }
        int i=litemallUserMapper.updateByPrimaryKeySelective(litemallUser);
        return i;
    }


}
