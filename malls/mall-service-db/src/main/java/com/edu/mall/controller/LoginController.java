package com.edu.mall.controller;
import com.edu.mall.dto.UpdateAdminPassword;
import com.edu.mall.pojo.LitemallUser;
import com.edu.mall.service.MobileUserService;
import com.edu.mall.utils.ResponseUtils;
import com.edu.mall.vo.MobileLoginVo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Resource
    private MobileUserService mobileUserService;
    /*登录*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestBody LitemallUser litemallUser){//把前端的json请求数据解析到当前对象中
        MobileLoginVo login = mobileUserService.loginCheck(litemallUser.getUsername(),litemallUser.getPassword());
        if(login!=null){
            return ResponseUtils.ok(login);
        }
        return ResponseUtils.fail(ResponseUtils.INVALID_LOGIN,"用户名或密码错误");
    }

    /*修改密码*/
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Object updatePassword(@RequestBody UpdateAdminPassword updateAdminPassword){
        int data = mobileUserService.updatePassword(updateAdminPassword);
        if (data > 0) {
            return ResponseUtils.ok(data);
        } else if (data == -1) {
            return ResponseUtils.fail(-1,"提交参数不合法");
        } else if (data == -2) {
            return ResponseUtils.fail(-2,"找不到该用户");
        } else if (data == -3) {
            return ResponseUtils.fail(-3,"旧密码错误");
        } else {
            return ResponseUtils.fail(-4,"未知错误");
        }
    }
    /*注册用户*/
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object register(@RequestBody LitemallUser litemallUser){
        Object data=mobileUserService.register(litemallUser);
        System.out.println(data);
        if (data==null){
         return ResponseUtils.fail(ResponseUtils.INVALID_LOGIN,"用户名已存在,注册失败");
        }
        return ResponseUtils.ok(data);
    }
    /*图片上传*/
    @RequestMapping(value = "{id}",method = RequestMethod.POST)
    public Object uploadPic(@RequestParam("pic") MultipartFile myFile, HttpServletRequest request, @PathVariable("id") Integer userId) {
        String path = request.getServletContext().getRealPath("/img/uploadFile");
        String originalFilename = myFile.getOriginalFilename();
        String randomName = UUID.randomUUID().toString().replace("-", "");
        int indexOf = originalFilename.lastIndexOf(".");
        String substring = originalFilename.substring(indexOf);
        String logoName = randomName + substring;
        System.out.println(logoName);
        System.out.println(path);
        int num = 0;
        try {
            File file = new File(path + "/" + logoName);
            if (!file.exists()){
                file.mkdirs();
            }
            myFile.transferTo(file);
            System.out.println("上传成功！" + path + "/" + logoName);
            //将图片的名称更新到数据库中
            LitemallUser litemallUser = new LitemallUser();
            litemallUser.setId(userId);
            litemallUser.setAvatar(logoName);
            num=mobileUserService.update(userId,litemallUser);
            if(num==1){
                return ResponseUtils.ok(num);
            }else{
                return ResponseUtils.fail(500,"服务器内部异常，请稍后再试！");
            }
        } catch (IOException e) {
            e.printStackTrace();
             return "图片上传出现问题！";
        }
    }
    /*修改用户信息*/
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Object updatePassword(@PathVariable("id") Integer userId,@RequestBody LitemallUser litemallUser){
        int data = mobileUserService.update(userId,litemallUser);
        if (data > 0) {
            return ResponseUtils.ok(data);
        } else {
            return ResponseUtils.fail(900,"未知错误");
        }
    }
    }
