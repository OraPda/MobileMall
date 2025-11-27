import request from '@/utils/request'
import {getToken} from '@/utils/token'
import Cookies from 'js-cookies'
//首页API
export function getHome(){
    return request({
        url:"home/index",
        method:"get"
    });
}
// 分类API
export function getCategory(){
    return request({
        url:"category/index",
        method:"get"
    });
}

export function getCurrentCategory(id){
    return request({
        url:"category/current?id="+id,
        method:"get",
    });
}

// 购物车API
export function getCart(){
    return request({
        // url:"cart/index?malltoken="+getToken(),
        url:"cart/index?userId="+$cookies.get('id'),
        method:"get"
    });
}

//登录
export function login(user){
    return request({
        url:"auth/login",
        method:"post",
        data:user
    });
}