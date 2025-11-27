<template>
    <div>
        <UserAvatar></UserAvatar>
        <div>
            <van-field
                v-model="username"
                left-icon="username"
                placeholder="请输入用户名"
                clearable></van-field>
            <van-field
                v-model="password"
                left-icon="lock"
                :type="passwordVisible?'text':'password'"
                :right-icon="password?passwordVisible?'eye-open':'eye-close':''"
                @click-right-icon="passwordVisible=!passwordVisible"
                placeholder="请输入密码"></van-field>
        </div>
        <div class="clearfix" style="margin:10px 15px;">
            <div class="fl">免费注册</div>
            <div class="fr">忘记密码</div>
        </div>  
        <div style="margin:0 15px;">           
            <van-button style="width:100%;" type="danger" @click="dologin">登录</van-button> 
        </div>    
    </div>
</template>

<script>
import UserAvatar from '@/components/UserAvatar'
import {login} from '@/api/api.js'
import {setToken} from '@/utils/token.js'

export default {
    name: 'MallMobileLogin',

    data() {
        return {
            username:"",
            password:"",
            passwordVisible:false
        };
    },

    mounted() {
        
    },

    methods: {
        dologin(){
            // console.info(this.username+this.password);
            login({username:this.username,password:this.password}).then(resp=>{
                this.$cookies.set('id',resp.data.data.userInfo.userId)
                if(resp.data.errno==0){
                    // 登录成功
                    // console.log(resp.data.data.userInfo.userId)
                    // console.log(this.$cookies.get('id'))
                    setToken(resp.data.data.token);
                    //重定向到原目标页面
                    console.info(this.$route.query.redirect);
                    this.$router.push(this.$route.query.redirect?this.$route.query.redirect:'/user');
                }
            });
        }
    },
    components:{
        UserAvatar
    }
};
</script>

<style lang="scss" scoped>

</style>