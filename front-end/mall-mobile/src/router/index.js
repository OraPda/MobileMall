import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import Category from '@/views/Category.vue'
import Cart from '@/views/Cart.vue'
import User from '@/views/User.vue'
import Search from '@/views/Search.vue'
import Login from '@/views/Login.vue'
import { getToken } from '@/utils/token.js'
import Detail from '@/views/Detail.vue'
import List from '@/views/List.vue'
import AddressList from '@/views/AddressList'
import AddressUpdate from '@/views/AddressUpdate'
import AddressAdd from '@/views/AddressAdd'
import Collection from '@/views/Collection'

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    redirect: "/home"
  },
  {
    name: "home",
    path: "/home",
    component: Home,
    meta: {
      showTab: true
    }
  },
  {
    name: "category",
    path: "/category",
    component: Category,
    meta: {
      showTab: true
    }
  },
  {
    name: "cart",
    path: "/cart",
    component: Cart,
    meta: {
      showTab: true,
      login: true
    }
  },
  {
    name: "user",
    path: "/user",
    component: User,
    meta: {
      showTab: true,
      login: true
    }
  },
  {
    name: "search",
    path: "/search",
    component: Search,
    meta: {
      showTab: true
    }
  },
  {
    name: "login",
    path: "/login",
    component: Login
  },
  {
    name: "detail",
    path: "/detail",
    component: Detail,
    meta: {
      showTab: true
    }
  },
  {
    name: "list",
    path: "/list",
    component: List,
    meta: {
      showTab: true
    }
  },
  {
    name: "addresslist",
    path: "/addresslist",
    component: AddressList
  },
  {
    name: "addressupdate",
    path: "/addressupdate",
    component: AddressUpdate
  },
  {
    name: "addressadd",
    path: "/addressadd",
    component: AddressAdd
  },
  {
    name: "collection",
    path: "/collection",
    component: Collection
  }
]

// 重写push方法
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function (location) {
  return originalPush.call(this, location).catch(err => err);
}

const router = new VueRouter({
  routes
})

//导航守卫
router.beforeEach((to, from, next) => {
  let token = getToken();
  if (!token) {//还没登录
    if (to.meta.login) {
      next({ name: "login", query: { redirect: to.path } });
    }
  }
  //登录了或者不需要登录
  next();//去目标页面
});

//路由拦截
// router.beforeEach((to, from, next) => {
//   let token = $cookies.get('token')
//   if(to.meta.login){
//     if(!token){
//       next({path:'login',query:{redirect:to.path}})
//     }else{
//       next()
//     }
//   }else{
//     next()
//   }
// })

export default router
