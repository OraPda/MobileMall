<template>
  <div>
    <!-- 搜索栏 -->
    <SearchBar></SearchBar>
    <!-- 分类选择 -->
    <div>
      <!-- 左侧 -->
      <van-sidebar
        class="fl"
        style="height: 100%"
        @change="sidebarChange"
        v-model="activeIndex"
      >
        <van-sidebar-item
          v-for="(item, index) in categoryInfos.categoryList"
          :key="index"
          :title="item.name"
        ></van-sidebar-item>
      </van-sidebar>
      <!-- 右侧 -->
      <div class="right-content">
        <div class="right-top">
          <img
            :src="categoryInfos.currentCategory.picUrl"
            alt=""
            style="width: 250px"
          />
          <p class="desc">{{ categoryInfos.currentCategory.desc }}</p>
        </div>
        <van-grid column-num="3">
          <van-grid-item
            v-for="(item, index) in categoryInfos.currentSubCategory"
            :key="index"
            @click="$router.push({ path: '/detail', query: { id: item.id } })"
          >
            <img :src="item.picUrl" alt="" style="width: 70px" />
            <p class="name">{{ item.name }}</p>
          </van-grid-item>
        </van-grid>
      </div>
    </div>
  </div>
</template>

<script>
//import { getCategory, getCurrentCategory } from "@/api/api.js";
import SearchBar from "@/components/SearchBar.vue";

export default {
  name: "MallMobileCategory",

  data() {
    return {
      activeIndex: 0,
      categoryInfos: {
        currentCategory: {},
        categoryList: [],
        currentSubCategory: [],
      },
    };
  },
  created() {
    // getCategory().then(resp=>{
    //     this.categoryInfos=resp.data.data;
    // });
  },
  mounted() {
    this.$axios
      .get("http://8.130.40.140:8008/api/category/index")
      .then((res) => {
        this.categoryInfos = res.data.data;
      });
  },

  methods: {
    sidebarChange(index) {
      //console.info(index);
      this.$axios
        .get("http://8.130.40.140:8008/api/category/current?id="+this.categoryInfos.categoryList[index].id)
        .then((res) => {
          this.categoryInfos.currentCategory = res.data.data.currentCategory;
          this.categoryInfos.currentSubCategory =
            res.data.data.currentSubCategory;
        });
    //   getCurrentCategory(this.categoryInfos.categoryList[index].id).then(
    //     (resp) => {
    //       //console.info(resp.data.data)
    //       this.categoryInfos.currentCategory = resp.data.data.currentCategory;
    //       this.categoryInfos.currentSubCategory =
    //         resp.data.data.currentSubCategory;
    //     }
    //   );
    },
  },
  components: {
    SearchBar,
  },
};
</script>

<style>
.right-content {
  margin-left: 80px;
}
.right-top {
  text-align: center;
}
.right-top .desc {
  margin-top: 10px;
}
</style>