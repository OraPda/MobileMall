import axios from 'axios'
import {getToken} from '@/utils/token'

const service=axios.create({
    baseURL:'http://8.130.40.140:8008/api/',
    timeout:5000
});

let tokenHeaderName="malltoken";
//请求拦截器
service.interceptors.request.use(config=>{
    //统一添加token（请求头）
    let token=getToken();
    //let token=$cookies.get('token')
    config.headers[tokenHeaderName]=token;
    return config;
},err=>Promise.reject(err));

export default service;
