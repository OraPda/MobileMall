<template>
    <div>
        <!-- 头像 -->
        <UserAvatar></UserAvatar>
        <!-- 我的订单 -->
        <div>
            <van-cell title="我的订单" value="全部订单" is-link></van-cell>
            <van-grid :column-num="4" icon-size="24px">
                <van-grid-item icon="credit-pay" text="待付款"></van-grid-item>
                <van-grid-item icon="send-gift-o" text="待发货"></van-grid-item>
                <van-grid-item icon="logistics" text="待收货"></van-grid-item>
                <van-grid-item icon="completed" text="已完成"></van-grid-item>
            </van-grid>
        </div>
        <!-- 我的优惠券 -->
        <div>
            <van-cell title="我的优惠券" value="全部优惠券" is-link></van-cell>
            <van-grid :column-num="3" icon-size="24px">
                <van-grid-item icon="cash-on-deliver" text="待使用"></van-grid-item>
                <van-grid-item icon="sign" text="已使用"></van-grid-item>
                <van-grid-item icon="arrow-left" text="过期关闭"></van-grid-item>
            </van-grid>
        </div>
        <div>
            <van-cell title="我的收藏" is-link icon="star-o" @click="$router.push({path:'/collection'})"></van-cell>
            <van-cell title="收货地址" is-link icon="location-o" @click="$router.push({path:'/addresslist'})"></van-cell>
            <van-cell title="服务中心" is-link icon="service-o"></van-cell>
        </div>
    </div>
</template>

<script>
import avatar_default from '@/assets/images/avatar_default.png'
import UserAvatar from '@/components/UserAvatar'
export default {
    name: 'MallMobileUser',

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
    components:{
        UserAvatar
    }
};
</script>

<style>
    .van-grid-item__text{
        font-size: 16px !important;
    }
</style>