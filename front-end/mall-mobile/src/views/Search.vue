<template>
  <div>
    <van-search
      v-model="search"
      shape="round"
      background="red"
      placeholder="请输入搜索关键词"
      @search="onSearch"
    />
    <div style="width: 100%; height: 100%; background-color: ghostwhite">
      <div class="x-box1">
        <p>最近搜索：</p>
        <br />
        <span
          class="hotsearch"
          v-for="(text, index) in newsearchtext"
          :key="index"
          >{{ text }}</span
        >
      </div>
      <div class="x-box2">
        <p>热门搜索：</p>
        <br />
        <span
          class="hotsearch"
          v-for="(text, index) in hotsearchtext"
          :key="index"
          @click="onClick(text)"
          >{{ text }}</span
        >
      </div>
      <div class="x-box3">
        <van-row v-if="isShow">
          <van-col
            span="11"
            v-for="(goods, index) in tableData"
            :key="index"
            style="text-align: center; background-color: white; marign: 5px"
            @click="$router.push({ path: '/detail', query: { id: goods.goodsSn } })"
          >
            <img :src="goods.picUrl" style="width: 150px; height: 150px" />
            <p style="font-size: 13px">{{ goods.name }}</p>
            <p style="color: #ab956d">¥{{ goods.retailPrice | priceFormat }}</p>
          </van-col>
        </van-row>
      </div>
      <div style="width: 100%; height: 200px; text-align: center">
        没有搜到该商品，换个关键字试试吧!
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MallMobileSearch",

  data() {
    return {
      search: "",
      hotsearchtext: ["保暖", "轻奢", "空调被"],
      newsearchtext: [],
      tableData: [],
      isShow: false,
    };
  },

  mounted() {
    this.$axios
      .get("http://8.130.40.140:8008/admin/goods/list")
      .then((res) => {
        //console.log(res.data);
        this.tableData = res.data;
        //console.log(this.tableData);
      })
      .catch(function (error) {
        console.log(error);
      });
  },

  methods: {
    onClick(text) {
      this.search = text;
	  this.onSearch()
    },
    onSearch() {
      this.newsearchtext.push(this.search);
      this.isShow = !this.isShow;
      let newtableData = [];
      if (this.search) {
        this.tableData.filter((item) => {
          if (item.name.indexOf(this.search) != -1) {
            newtableData.push(item);
          }
        });
        this.tableData = newtableData;
      }
      console.log(this.tableData);
    },
  },
};
</script>

<style>
.x-box1 {
  padding: 15px;
  padding-bottom: 100px;
}
.x-box2 {
  padding: 15px;
  padding-bottom: 30px;
}
.x-box3 {
  padding: 10px;
  padding-bottom: 100px;
}
.hotsearch {
  background-color: rgb(239, 237, 237);
  color: rgb(182, 181, 181);
  padding: 5px 10px;
  margin: 60px 10px;
  border-radius: 5px;
}
.van-col--11 {
  margin: 7px;
}
</style>