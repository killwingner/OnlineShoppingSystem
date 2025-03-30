<script setup>
import router from "@/router/index.js";
const onClickLeft = ()=>{
    router.back()
}


</script>

<template>
    <van-nav-bar
        title="商品"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
    />

</template>

<style scoped>

</style>