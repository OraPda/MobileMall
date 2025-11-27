import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import '@/assets/reset.css'
import Vant from 'vant'
import 'vant/lib/index.css'
//import '@/assets/iconfont/iconfont.css'
//import '@/api/mock'
import * as filters from '@/filter'
import 'animate.css'
import VueCookies from 'vue-cookies'
import axios from 'axios'

Vue.use(VueCookies)
Vue.use(Vant);
Vue.prototype.$axios = axios

// 注册所有过滤器
Object.keys(filters).forEach(key=>{
  Vue.filter(key,filters[key]);
});

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
