<template>
    <div>
        <van-search placeholder="搜索" shape="round" @click="toSearch"></van-search>
    </div>
</template>

<script>
export default {
    name: 'MallMobileSearchbar',

    data() {
        return {
            
        };
    },

    mounted() {
        
    },

    methods: {
        toSearch(){
            this.$router.push('/search');
        }
    },
};
</script>

<style lang="scss" scoped>

</style>