<template>
  <div>
    <!-- 顶部编辑 -->
    <div class="tab-cart">
      <div class="cart-header">
        <van-icon :name="isEditor ? 'success' : 'edit'"></van-icon>
        <span @click="isEditor = !isEditor">{{
          isEditor ? "完成" : "编辑"
        }}</span>
      </div>
    </div>
    <!-- 购物车商品列表 -->
    <div style="padding-bottom: 100px">
      <van-checkbox-group v-model="checkedGoods" @change="groupChange">
        <van-swipe-cell
          :disabled="!isEditor"
          v-for="(item, index) in cartInfo.cartList"
          :key="index"
        >
          <!-- 自定义的显示内容 -->
          <div class="goods-item">
            <van-checkbox
              v-model="item.checked"
              :name="item.id"
              style="margin-left: 10px"
            ></van-checkbox>
            <van-card
              :num="item.number"
              :price="item.price | priceFormat"
              :title="item.goodsName"
              :thumb="item.picUrl"
              style="width: 100%; background-color: white"
            >
              <!-- 规格 -->
              <template #tags>
                <div>
                  <van-tag
                    plain
                    v-for="(s, index) in item.specifications"
                    :key="index"
                    >{{ s }}</van-tag
                  >
                </div>
              </template>
              <!-- 底部日期 -->
              <template #footer>
                <div v-if="!isEditor">添加日期:{{ item.addTime }}</div>
                <van-stepper
                  @change="numChange(item)"
                  v-else
                  v-model="item.number"
                ></van-stepper>
              </template>
            </van-card>
          </div>
          <!-- 右边划出的内容 -->
          <template #right>
            <van-button
              text="删除"
              type="danger"
              style="height: 100%"
              @click="delItem(item)"
            ></van-button>
          </template>
        </van-swipe-cell>
      </van-checkbox-group>
    </div>

    <div v-if="!cartInfo.cartList.length">购物车空空如也</div>

    <!-- 底部结算 -->
    <van-submit-bar
      style="bottom: 50px"
      :loading="loading"
      :price="totalPrice"
      :button-text="isEditor ? '删除' : '结算'"
      label="总计"
      @submit="cartSubmit"
    >
      <van-checkbox v-model="checkedAll" @click="checkedAllChange"
        >全选</van-checkbox
      >
    </van-submit-bar>
  </div>
</template>

<script>
import { getCart } from "@/api/api.js";
import _ from "lodash";

export default {
  name: "MallMobileCart",

  data() {
    return {
      checkedArray:[],
      loading: false,
      isEditor: false,
      checkedGoods: [],
      checkedAll: false,
      cartInfo: {
        cartTotal: {
          goodsCount: 0,
          checkedGoodsCount: 0,
          goodsAmount: 0,
          checkedGoodsAmount: 0,
        },
        cartList: [],
      },
    };
  },

  // 计算属性
  computed: {
    totalPrice() {
      return this.cartInfo.cartList.reduce((total, item) => {
        return (total +=
          this.checkedGoods.indexOf(item.id) !== -1
            ? item.price * item.number * 100
            : 0);
      }, 0);
    },
  },

  created() {
    // getCart().then(resp=>{
    //     console.info(resp.data.data);
    //     this.cartInfo=resp.data.data;
    //     this.getCheckedList();
    // });
  },

  mounted() {
    this.$axios
      .get(
        "http://8.130.40.140:8008/api/cart/index?userId=" +
          this.$cookies.get("id")
      )
      .then((res) => {
        console.log(res.data.data);
        this.cartInfo = res.data.data;
        this.getCheckedList();
      })
      .catch(function (error) {});
    //   this.$axios.put("http://8.130.40.140:8008/api/cart/checked", {
    //         productIds: [101],
    //         isChecked: 1,
    //         userId:1
    //       })
    //       .then((res) =>
    //       res.data
    //         ? this.$toast.success("删除成功！")
    //         : this.$toast.fail("删除失败！")
    //     )
    //     .catch(function (error) {});
  },

  methods: {
    groupChange(checkedData) {
      this.checkedAll =
        this.checkedGoods.length === this.cartInfo.cartList.length;
      // 提交请求，修改后端数据
      //console.info("xx" + checkedData);
      let uncheckedArray = [];
      _.each(this.cartInfo.cartList, (item) => {
        if (checkedData.indexOf(item.id) !== -1) {
          this.checkedArray.push(item.productId);
          this.$axios.post(
            "http://8.130.40.140:8008/api/cart/checked?userId=" +
              this.$cookies.get("id"),
            {
              productIds: [item.productId],
              isChecked: 1,
            }
          );
        } else {
          uncheckedArray.push(item.productId);
          this.$axios.post(
            "http://8.130.40.140:8008/api/cart/checked?userId=" +
              this.$cookies.get("id"),
            {
              productIds: [item.productId],
              isChecked: 0,
            }
          );
        }
      });
      console.info("xxx" + this.checkedArray);
      console.info(uncheckedArray);
    },
    getCheckedList() {
      this.cartInfo.cartList.forEach((p) => {
        if (p.checked) {
          this.checkedGoods.push(p.id);
        }
      });
    },
    checkedAllChange() {
      if (this.checkedGoods.length === this.cartInfo.cartList.length) {
        this.checkedGoods = [];
      } else {
        this.cartInfo.cartList.forEach((p) => {
          if (this.checkedGoods.indexOf(p.id) === -1)
            this.checkedGoods.push(p.id);
        });
      }
    },
    delItem(item) {
      //let delArray=[item.productId];
      console.log(item.productId);
      //console.info(`删除${delArray}`);
      //let index=_.findIndex(this.cartInfo.cartList,e=>e.id==item.id);
      //this.cartInfo.cartList.splice(index,1);
      this.$axios
        .post(
          "http://8.130.40.140:8008/api/cart/delete?userId=" +
            this.$cookies.get("id"),
          {
            productIds: [item.productId],
          }
        )
        .then((res) =>
          res.data
            ? this.$toast.success("删除成功！")
            : this.$toast.fail("删除失败！")
        )
        .catch(function (error) {
          console.log(error);
        });
    },
    numChange(item) {
      //console.info(item.number);
      this.$axios
        .put("http://8.130.40.140:8008/api/cart/update", {
          number: item.number,
          goodsId: item.goodsId,
          id: item.id,
          productId: item.productId,
        })
        .then((res) =>
          res.data
            ? this.$toast.success("修改成功！")
            : this.$toast.fail("修改失败！")
        )
        .catch(function (error) {});
    },
    cartSubmit() {
      console.log(this.checkedArray)
      this.$axios
        .post(
          "http://8.130.40.140:8008/api/cart/delete?userId=" +
            this.$cookies.get("id"),
          {
            productIds: this.checkedArray,
          }
        )
        .then((res) =>
          res.data
            ? this.$toast.success("删除成功！")
            : this.$toast.fail("删除失败！")
        )
        .catch(function (error) {
          console.log(error);
        });
      // if (this.isEditor) {
      //   let delArray = [];
      //   this.cartInfo.cartList.forEach((item) => {
      //     delArray.push(item.productId);
      //   });
      //   console.info(`删除${delArray}`);
      //   this.cartInfo.cartList = [];
      //   this.isEditor = false;
      // } else {
      //   console.info("正在结算");
      //   this.loading = true;
      // }
    },
  },
};
</script>

<style>
.cart-header {
  text-align: right;
  height: 46px;
  line-height: 46px;
  margin-right: 15px;
}
.goods-item {
  display: flex;
  align-items: center;
}
</style>