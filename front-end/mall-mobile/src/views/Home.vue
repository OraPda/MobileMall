<template>
    <div class="home-container">
        <!-- 搜索栏 -->
        <SearchBar></SearchBar>
        <!-- 轮播图 -->
        <van-swipe :autoplay="3000" indicator-color="white">
            <van-swipe-item v-for="(bn,index) in homeInfos.banner" :key="index">
                <img :src="bn.url" style="height:230px;" @click="$router.push({path:'/list'})"/>
            </van-swipe-item>
        </van-swipe>
        <!-- 分类引导 -->
        <van-grid column-num="6">
            <van-grid-item v-for="(chan,index) in homeInfos.channel" :key="index" :text="chan.name" :icon="chan.iconUrl"></van-grid-item>
        </van-grid>
        <!-- 团购专区 -->
        <div>
            <van-cell title="团购专区" value="更多团购内容" is-link></van-cell>
            <div>
                <van-card v-for="(groupon,index) in homeInfos.grouponList" :key="index"
                    :title="groupon.goodsName"
                    :desc="groupon.desc"
                    :price="groupon.grouponPrice|priceFormat"
                    :origin-price="groupon.retailPrice|priceFormat"
                    :thumb="groupon.picUrl">
                    <template #tags>
                        <van-tag plain type="primary">{{groupon.discountMember}}人成团</van-tag>
                        <van-tag plain type="danger">{{groupon.discount}}元再减</van-tag>
                    </template>
                </van-card>
            </div>
        </div>
        <!-- 品牌商直供 -->
        <div>
            <van-cell title="品牌商直供" value="更多品牌" is-link></van-cell>
            <van-grid column-num="2">
                <van-grid-item v-for="(b,index) in homeInfos.brandList" :key="index">
                    <img :src="b.picUrl" style="width:80%;"/>
                    <div>{{b.name}}</div>
                </van-grid-item>
            </van-grid>
        </div>
        <!-- 新品首发 -->
        <div>
            <van-cell title="新品首发" value="更多新品首发" is-link></van-cell>
            <van-row>
                <van-col span="12" v-for="(goods,index) in homeInfos.newGoodsList" :key="index" style="text-align:center;">
                    <img :src="goods.picUrl" style="width:180px;height:180px;" @click="onClick(goods)"/>
                    <p>{{goods.name}}</p>
                    <!-- <p style="color:#ab956d">¥{{goods.retailPrice|priceFormat}}&nbsp;<del style="font-size:13px;color:grey">¥{{goods.counterPrice|priceFormat}}</del></p> -->
                </van-col>
            </van-row>
        </div>
    </div>
</template>

<script>
import {getHome} from '@/api/api.js'
import SearchBar from '@/components/SearchBar.vue'

export default {
    name: 'MallMobileHome',

    data() {
        return {
            homeInfos:{}
        };
    },
    created(){
        // 发送请求，获取首页数据
        getHome().then(resp=>{
            this.homeInfos=resp.data.data;
        });
    },

    mounted() {
        
    },

    methods: {
        onClick(goods){
            this.$router.push({path:'/detail',
                query:{id:goods.goodsSn}})
        }
    },
    components:{
        SearchBar
    }
};
</script>

<style lang="css" scoped>
    .home-container{
        padding-bottom: 50px;
    }
</style>