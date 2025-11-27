<template>
  <div>
    <van-nav-bar title="商品详情" left-arrow @click-left="$router.go(-1)">
      <template #right>
        <van-icon name="search" size="18" @click="$router.push('/search')" />
      </template>
    </van-nav-bar>
    <van-swipe :autoplay="3000">
      <van-swipe-item>
        <img
          style="width: 100%; height: 300px; object-fit: cover"
          :src="image"
        />
      </van-swipe-item>
      <template #indicator>
        <div></div>
      </template>
    </van-swipe>
    <div style="padding: 10px">
      <div>
        <span style="color: red">
          <span style="font-size: 18px">￥</span>
          <span style="font-size: 33px">{{
            price | priceFormat
          }}</span
          >&nbsp;&nbsp;
          <del style="font-size: 16px; color: grey"
            >¥{{ oldprice | priceFormat }}</del
          >
          <span style="color: grey; font-size: 13px; float: right"
            >浏览31<br />销量32</span
          >
        </span>
      </div>
      <div>
        <br /><span style="font-size: 20px">{{ name }}</span>
        <br /><br />
        <span>{{ brief }}</span>
      </div>
    </div>
    <!-- <p>{{ this.$route.query.id }}</p> -->
    <van-goods-action style="bottom: 50px">
      <van-goods-action-icon icon="chat-o" text="客服"/>
      <van-goods-action-icon icon="cart-o" text="购物车" />
      <van-goods-action-icon v-show="isCollection" icon="star" text="已收藏" color=#ff5000 @click="onCollection"/>
      <van-goods-action-icon v-show="!isCollection" icon="star-o" text="收藏" @click="onCollection"/>
      <van-goods-action-button
        type="warning"
        text="加入购物车"
        @click="onClick"
      />
      <van-goods-action-button type="danger" text="立即购买" />
    </van-goods-action>
  </div>
</template>

<script>
export default {
  name: "MallMobileDetail",

  data() {
    return {
      isCollection:false,
      price:"",
      oldprice:"",
      image:"",
      name:"",
      brief:"",
      id:"",
      productId:"",
      list:[]
    };
  },

  mounted() {
    this.$axios
    .get("http://8.130.40.140:8008/admin/goods?id="+this.$route.query.id)
    .then((res) => {
      //console.log(res.data.data[0])
      this.id = res.data.data[0].goodsSn
      this.productId = res.data.data[0].id
      this.price = res.data.data[0].retailPrice
      this.oldprice = res.data.data[0].counterPrice
      this.image = res.data.data[0].picUrl
      this.name = res.data.data[0].name
      this.brief = res.data.data[0].brief
    })
    this.$axios
      .get("http://8.130.40.140:8008/admin/collect/list?id=" +
            this.$cookies.get("id"))
      .then((res) => {
        for(let n=0;n<res.data.data.length;n++){
          if(this.id == res.data.data[n].litemallGoods.goodsSn){
            this.isCollection = !this.isCollection
          }
        }
      })
  },

  methods: {
    onClick() {
      this.$axios
        .post(
          "http://8.130.40.140:8008/api/cart/add?userId=1",
          {
            goodsId: this.id,
            number: 1,
            productId: this.productId,
          }
        )
        .then((res) =>
          res.data
            ? this.$toast.success("添加成功！")
            : this.$toast.fail("添加失败！")
        )
        .catch(function (error) {
          console.log(error);
        });
    },
    onCollection(){
      this.isCollection = !this.isCollection
      if(this.isCollection){
        this.$axios
        .post("http://8.130.40.140:8008/admin/collect/add?userId=1",{
          valueId:this.id
        })
        .then((res) =>
          res.data
            ? this.$toast.success("已收藏！")
            : this.$toast.fail("失败！")
        )
      }else{
        this.$axios
        .post("http://8.130.40.140:8008/admin/collect/del?userId=1",{
          ids:[this.id]
        })
        .then((res) =>
          res.data
            ? this.$toast.success("已取消！")
            : this.$toast.fail("失败！")
        )
      }
    }
  },
};
</script>

<style>
.x {
  display: inline-block;
  margin-bottom: 10px;
}
</style>
