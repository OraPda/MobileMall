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
      show-delete
      show-set-default
      show-search-result
      :search-result="searchResult"
      :area-columns-placeholder="['请选择', '请选择', '请选择']"
      @save="onSave"
      @delete="onDelete"
      :address-info="{
        name:this.$route.query.listupdate.name,
        tel:this.$route.query.listupdate.tel,
        addressDetail:this.$route.query.listupdate.addressDetail,
        areaCode,
        isDefault:this.$route.query.listupdate.isDefault
      }"
    />
  </div>
</template>

<script>
import _ from "lodash";
import { areaList } from "@vant/area-data";
export default {
  name: "MallMobileAddressUpdate",

  data() {
    return {
      areaList,
      searchResult: [],
      areaCode:''
    };
  },

  mounted() {
     _.forEach(this.areaList.city_list, (o, c) => {
            if (o == this.$route.query.listupdate.city){
                let cityId = String(_.take(c, 2))
                _.forEach(this.areaList.county_list,(i, a) => {
                    if(i == this.$route.query.listupdate.county){
                        let countyId = String(_.take(a, 2))
                        if(cityId == countyId){
                            this.areaCode = a
                        }
                    }
                })
            }
        })
  },

  methods: {
    onSave(content) {
        console.log(content);
      this.$axios
        .put(
          "http://8.130.40.140:8008/api/address/edit?userId=" +
            this.$cookies.get("id"),
          {
            id:this.$route.query.listupdate.id,
            name: content.name,
            province: content.province,
            city: content.city,
            county: content.county,
            addressDetail: content.addressDetail,
            tel: content.tel,
            isDefault:content.isDefault
          }
        )
        .then((res) => {
            this.$toast.success("修改成功！")
            this.$router.push({path:"/addresslist"})
        })
    },
    onDelete() {
        this.$axios
        .delete("http://8.130.40.140:8008/api/address/del?userId=" +
            this.$cookies.get("id")+"&id="+this.$route.query.listupdate.id)
        .then((res) => {
            this.$toast.success("删除成功！")
            this.$router.push({path:"/addresslist"})
        })
    },
  },
};
</script>

<style lang="scss" scoped>
</style>