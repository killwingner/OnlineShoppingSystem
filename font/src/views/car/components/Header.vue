<script setup>
const onClickLeft = () => history.back();
</script>

<template>
    <van-nav-bar
        title="购物车"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
    />

</template>

<style scoped>


</style>