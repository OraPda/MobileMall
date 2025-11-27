<template>
  <div style="width: 100%; height: 100%; background-color: ghostwhite">
    <van-nav-bar title="我的收藏" left-arrow @click-left="$router.go(-1)">
      <template #right>
        <van-icon name="search" size="18" @click="$router.push('/search')" />
      </template>
    </van-nav-bar>
    <div style="text-align: right; padding: 5px 20px" @click="isDel = !isDel">
      <van-icon :name="isDel ? 'success' : 'setting-o'"></van-icon>&nbsp;{{
        isDel ? "完成" : "管理"
      }}
    </div>
    <van-checkbox-group
      v-model="checkedGoods"
      @change="groupChange"
      ref="checkboxGroup"
    >
      <van-row>
        <van-col
          span="11"
          v-for="(goods, index) in GoodsList"
          :key="index"
          v-show="index"
          style="text-align: center; background-color: white"
          @click="onClick(index, goods.goodsSn)"
        >
          <van-checkbox
            v-model="checked"
            v-show="isDel"
            :name="goods.id"
            ref="checkboxes"
            style="position: relative; top: 15px; left: 15px"
          ></van-checkbox>
          <div style="position: relative; top: -15px">
            <img :src="goods.picUrl" style="width: 150px; height: 150px" />
            <div class="text">{{ goods.name }}</div>
            <p style="color: #ab956d">¥{{ goods.retailPrice | priceFormat }}</p>
          </div>
        </van-col>
      </van-row>
      <br /><br /><br />
    </van-checkbox-group>
    <van-submit-bar v-show="isDel" button-text="删除" @submit="delSubmit">
      <van-checkbox
        v-model="checkedAll"
        @click="checkedAllChange"
        style="padding-right: 170px"
        >全选</van-checkbox
      >
    </van-submit-bar>
  </div>
</template>

<script>
export default {
  name: "MallMobileCollection",

  data() {
    return {
      checked: false,
      GoodsList: [],
      isDel: false,
      checkedGoods: [],
      checkedAll: false,
      checkedArray: [],
    };
  },

  mounted() {
    this.$axios
      .get(
        "http://8.130.40.140:8008/admin/collect/list?id=" +
          this.$cookies.get("id")
      )
      .then((res) => {
        //console.log(res.data.data)
        for (let n = 0; n < res.data.data.length; n++) {
          var arr = {
            id: res.data.data[n].litemallGoods.id,
            goodsSn: res.data.data[n].litemallGoods.goodsSn,
            name: res.data.data[n].litemallGoods.name,
            picUrl: res.data.data[n].litemallGoods.picUrl,
            retailPrice: res.data.data[n].litemallGoods.retailPrice,
          };
          this.GoodsList.push(arr);
          arr = [];
        }
        // console.log(res.data.data[0].litemallGoods)
        // let array = JSON.parse(JSON.stringify(res.data.data[0].litemallGoods))
        // this.GoodsList.push(array)
        // console.log(array)
      });
  },

  methods: {
    groupChange(checkedData) {
      this.checkedAll = this.checkedGoods.length === this.GoodsList.length;
      // 提交请求，修改后端数据
      //console.info("xx" + checkedData);
      let uncheckedArray = [];
      _.each(this.GoodsList, (item) => {
        if (checkedData.indexOf(item.id) !== -1) {
          this.checkedArray.push(item.goodsSn);
        } else {
          uncheckedArray.push(item.goodsSn);
        }
      });
      //console.info("xxx" + this.checkedArray);
      //console.info("qqq" + uncheckedArray);
    },
    checkedAllChange() {
      if (this.checkedGoods.length === this.GoodsList.length) {
        this.checkedGoods = [];
        this.checkedArray = []
      } else {
        this.GoodsList.forEach((p) => {
          if (this.checkedGoods.indexOf(p.id) === -1)
            this.checkedGoods.push(p.id);
        });
      }
    },
    onClick(index, goods) {
      if (this.isDel) {
        this.$refs.checkboxes[index].toggle();
      } else {
        this.$router.push({ path: "/detail", query: { id: goods } });
      }
    },
    delSubmit() {
      console.log(this.checkedArray);
      this.$axios
        .post(
          "http://8.130.40.140:8008/admin/collect/del?userId=" +
            this.$cookies.get("id"),
          {
            ids: this.checkedArray,
          }
        )
        .then((res) =>
          res.data
            ? this.$toast.success("删除成功！")
            : this.$toast.fail("删除失败！")
        );
    },
  },
};
</script>

<style>
.text {
  font-size: 13px;
}
</style>