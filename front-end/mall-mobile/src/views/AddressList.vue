<template>
  <div>
    <van-nav-bar title="联系人列表" left-arrow @click-left="$router.push('/user')">
      <template #right>
        <van-icon name="search" size="18" @click="$router.push('/search')" />
      </template>
    </van-nav-bar>
    <van-address-list
      v-model="chosenAddressId"
      :list="list"
      default-tag-text="默认"
      @add="onAdd"
      @edit="onEdit"
    />
  </div>
</template>

<script>
export default {
  name: "MallMobileAddressList",

  data() {
    return {
      chosenAddressId: "1",
      list: [],
      address: [],
      listupdate:[]
    };
  },

  mounted() {
    this.$axios.get("http://8.130.40.140:8008/api/address/list").then((res) => {
      console.log(res.data);
      this.listupdate = res.data
      res.data.forEach((item) => {
        // console.log(item)
        this.list.push({
          name: item.name,
          tel: item.tel,
          address: item.province + item.city + item.county + item.addressDetail,
          id: item.id,
          userId: item.userId,
          isDefault: item.isDefault,
        });
      });
    });
  },
  methods: {
    onAdd() {
      this.$router.push({ path: "/addressadd" });
    },
    onEdit(item, index) {
      //console.log(this.listupdate[index]);
      this.$router.push({
        path: "/addressupdate",
        query: {listupdate:this.listupdate[index] },
      });
    },
  },
};
</script>

<style lang="scss" scoped>
</style>