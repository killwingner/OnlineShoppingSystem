<script setup>
import {onMounted, ref} from 'vue';
import Footer from "@/components/Footer.vue";
import Header from "@/views/order/components/Header.vue";
import OrderListItem from "@/views/order/components/OrderListItem.vue";
import {getOrder} from "@/api/OrderApi.js";
import store from "@/store/index.js";

const OrderProduct = ref([]); // 声明响应式变量

onMounted(async () => {
    try {
         // 使用 store.state.account
        OrderProduct.value = await getOrder(store.state.account); // 更新响应式变量
        console.log(OrderProduct)
    } catch (e) {
        console.error("Error fetching order:", e);
    }
});

const loading = ref(false);
const onRefresh = () => {
    setTimeout(() => {
        showToast('刷新成功');
        loading.value = false;
    }, 1000);
}
</script>

<template>
    <div class="order">
        <Header/>
        <div class="content">
            <van-pull-refresh v-model="loading" @refresh="onRefresh" style="min-height: 90vh;">
                <div v-for="(item, index) in OrderProduct" :key="index">
                        <OrderListItem :data="item"/>
                </div>
            </van-pull-refresh>
        </div>
        <Footer/>
    </div>
</template>

<style scoped>
.order {
    display: flex;
    flex-flow: column;
    height: 100%;
}
.order .content {
    background: #F2F5F7;
    flex: 1;
    overflow: auto;
}
.delete-button {
    height: 100%;
}
</style>