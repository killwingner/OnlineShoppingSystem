<script setup>
import { ref, onMounted } from "vue";
import { SelectProduct } from "@/api/ProductApi.js";
import { useRoute } from "vue-router";
import NavListItem from "@/views/home/components/NavListItem.vue";
import Router from "@/router/index.js";
import router from "@/router/index.js";
import {TypeProduct} from "@/api/ProductApi";
const route = useRoute();
const value = route.params.Type;
const data = ref(null); // 定义 data 为响应式对象
const loading = ref(false);

const onClickLeft = () => {
    Router.push("/home");
};

const onRefresh = () => {
    setTimeout(() => {
        showToast("刷新成功");
        loading.value = false;
    }, 1000);
};

onMounted(async () => {
    try {
        const result = await TypeProduct(value);
        data.value = result; // 将 API 返回的数据赋值给 data
        console.log(data)
    } catch (error) {
        console.error("Failed to fetch data:", error);
    }
});

const showProduct = (id) => {
    router.push(`/detail/${Number(id)}`);
};
</script>

<template>
    <div class="search">
        <div class="header">
            <van-nav-bar
                :title="`${value}`"
                left-text="返回"
                left-arrow
                @click-left="onClickLeft"
            />
        </div>
        <div class="container">
            <van-pull-refresh v-model="loading" @refresh="onRefresh">
                <div v-if="data " class="product">
                    <div v-for="(item, index) in data" :key="item.index">
                        <NavListItem :data="item" @click="showProduct(item.id)"></NavListItem>
                    </div>
                </div>
                <div v-else>
                    加载中...
                </div>
            </van-pull-refresh>
        </div>
    </div>
</template>

<style scoped>
.product{
    width: 100%;
    display: flex;
    flex-wrap: wrap;
}

</style>