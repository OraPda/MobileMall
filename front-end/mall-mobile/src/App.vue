<template>
  <div>
    <!-- 路由组件显示位置 -->
    <transition enter-active-class="animate__bounceInRight" mode="out-in">
      <router-view></router-view>
    </transition>
    <!-- 像使用标签一样用组件 -->
    <Tabbar v-if="$route.meta.showTab"></Tabbar>
  </div>
</template>

<script>
import Tabbar from "@/components/Tabbar.vue"//引入自定义的组件

export default {
  name: 'MallMobileApp',

  data() {
    return {
      
    };
  },

  mounted() {
    
  },

  methods: {
    
  },
  // 注册组件
  components:{
    Tabbar
  }
};
</script>

<style lang="scss" scoped>

</style>
