<template>
    <div>
        <!-- <ul>
            <li v-for="(tab,index) in tabs" :key="index">{{tab.name}}</li>
        </ul> -->
        <van-tabbar route active-color="#ee0a24">
            <van-tabbar-item v-for="(tab,index) in tabs" :key="index" :icon="tab.icon" :to="tab.path">{{tab.name}}</van-tabbar-item>
        </van-tabbar>
    </div>
</template>

<script>
export default {
    name: 'MallMobileTabbar',

    data() {
        return {
            tabs:[
                {
                    name:"精选",
                    icon:"fire-o",
                    path:"/home"
                },
                {
                    name:"分类",
                    icon:"apps-o",
                    path:"/category"
                },
                {
                    name:"购物车",
                    icon:"shopping-cart-o",
                    path:"/cart"
                },
                {
                    name:"我的",
                    icon:"user-o",
                    path:"/user"
                },
            ]
        };
    },

    mounted() {
        
    },

    methods: {
        
    },
};
</script>

<style lang="scss" scoped>

</style>