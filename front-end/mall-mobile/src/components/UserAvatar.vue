<template>
    <div class="user-header">
        <van-icon name="set" class="header-setting"></van-icon>
        <div class="user-avatar">
            <img :src="avatar" alt="">
            <div class="nickName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{nickName}}</div>
        </div>
    </div>
</template>

<script>
import avatar_default from '@/assets/images/avatar_default.png'
export default {
    name: 'MallMobileUseravatar',

    data() {
        return {
            avatar:avatar_default,
            nickName:'mall'
        };
    },

    mounted() {
        
    },

    methods: {
        
    },
};
</script>

<style>
    .user-header{
        height: 130px;
        background-color: #f00000;
    }
    .header-setting{
        float: right;
        font-size: 24px;
        color: white;
        padding: 10px;
    }
    .user-avatar{
        text-align: center;
        padding-top: 30px;
    }
    .user-avatar img{
        margin-left: 33px;
        width: 60px;
        height: 60px;
        border-radius: 30px;
    }
    .user-avatar .nickName{
        color: white;
        margin-top: 10px;
    }
</style>