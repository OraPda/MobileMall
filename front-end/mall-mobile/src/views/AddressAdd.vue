<template>
  <div>
    <van-nav-bar title="联系人" left-arrow @click-left="$router.push('/addresslist')">
      <template #right>
        <van-icon name="search" size="18" @click="$router.push('/search')" />
      </template>
    </van-nav-bar>
    <van-address-edit
      :area-list="areaList"
      show-postal
      show-set-default
      show-search-result
      :search-result="searchResult"
      :area-columns-placeholder="['请选择', '请选择', '请选择']"
      @save="onSave"
    />
  </div>
</template>

<script>
import { areaList } from "@vant/area-data";
export default {
  name: "MallMobileAddressAdd",

  data() {
    return {
      areaList,
      searchResult: [],
    };
  },

  mounted() {},

  methods: {
    onSave(content) {
        console.log(content)
      this.$axios
        .post(
          "http://8.130.40.140:8008/api/address/edit?userId=" +
            this.$cookies.get("id"),
          {
            name: content.name,
            province: content.province,
            city: content.city,
            county: content.county,
            addressDetail: content.addressDetail,
            tel: content.tel,
          }
        )
        .then((res) => {
            this.$toast.success("添加成功！")
            this.$router.push({path:"/addresslist"})
        })
    },
  },
};
</script>

<style lang="scss" scoped>
</style>