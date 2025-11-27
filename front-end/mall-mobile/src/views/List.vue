<template>
  <div style="width: 100%; height: 100%; background-color: ghostwhite">
    <van-nav-bar title="商品列表" left-arrow @click-left="$router.go(-1)">
      <template #right>
        <van-icon name="search" size="18" @click="$router.push('/search')" />
      </template>
    </van-nav-bar>
    <div style="padding-bottom: 100px">
      <div class="splist_sx">
        <div
          :style="{ color: active == 1 ? '#f00' : '#444' }"
          @click="sortclick1()"
        >
          综合
        </div>
        <div
          :style="{ color: active == 2 ? '#f00' : '#444' }"
          @click="sortclick2()"
        >
          价格<span class="iconfont icon-jiantou_shangxiaqiehuan"></span>
        </div>
        <div
          :style="{ color: active == 3 ? '#f00' : '#444' }"
          @click="sortclick3()"
        >
          新品
        </div>
      </div>
      <!-- <van-tabs v-model="active">
        <van-tab>
          <template #title>综合</template> -->
      <van-row>
        <van-col
          span="11"
          v-for="(goods, index) in GoodsList"
          :key="index"
          v-show="index < num"
          style="text-align: center; background-color: white; marign: 5px"
          @click="onClick(goods)"
        >
          <img :src="goods.picUrl" style="width: 150px; height: 150px" />
          <div class="text">{{ goods.name }}</div>
          <p style="color: #ab956d">¥{{ goods.retailPrice | priceFormat }}</p>
        </van-col>
      </van-row>
      <div
        v-if="num < GoodsList.length"
        @click="showMore"
        style="text-align: center"
      >
        {{ txt }}
      </div>
      <!-- </van-tab>
        <van-tab>
          <template #title
            >价格<span class="iconfont icon-jiantou_shangxiaqiehuan"></span
          ></template>
        </van-tab>
        <van-tab>
          <template #title> <van-icon name="more-o" />新品</template>
          内容
        </van-tab>
      </van-tabs> -->
    </div>
  </div>
</template>

<script>
export default {
  name: "MallMobileList",

  data() {
    return {
      active: 1,
      GoodsList: [],
      GoodsListByPrice: [],
      isShow: true,
      txt: "点击加载更多",
      num: 10,
      xx: 10,
    };
  },

  mounted() {
    this.$axios
      .get("http://8.130.40.140:8008/admin/goods/list")
      .then((res) => {
        //console.log(res.data);
        this.GoodsList = res.data;
      })
      .catch(function (error) {
        console.log(error);
      });
  },

  methods: {
    showMore() {
      console.log(this.xx);
      if (this.xx <= this.GoodsList.length) {
        this.xx += 10;
        this.num = !this.isShow ? this.num : this.num + 10;
      } else {
        this.xx -= 10;
        this.isShow = !this.isShow;
        this.num = this.isShow ? this.num : this.GoodsList.length;
      }
    },
    onClick(goods) {
      this.$router.push({ path: "/detail", query: { id: goods.goodsSn } });
    },
    sortclick1() {
      this.active = 1;
      this.GoodsList.sort((a, b) => {
        return a.id - b.id;
      });
    },
    sortclick2() {
      this.active = 2;
      this.GoodsList.sort((a, b) => {
        return a.retailPrice - b.retailPrice;
      });
    },
    sortclick3() {
      this.active = 3;
      this.GoodsList.sort((a, b) => {
        return b.retailPrice - a.retailPrice;
        //return new Date(b.addTime).getTime() - new Date(a.addTime).getTime()
      });
    },
  },
};
</script>

<style>
.s {
  background-color: ghostwhite;
}
.text {
  font-size: 13px;
}
.splist_sx {
  width: 100%;
  margin: 5px 0;
  display: flex;
  align-items: center;
  background-color: #fff;
}
.splist_sx > div {
  width: calc(100% / 3);
  padding: 10px 0;
  font-size: 14px;
  color: #444;
  text-align: center;
}
</style>