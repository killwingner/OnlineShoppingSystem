<script setup>
import { onMounted, ref } from "vue";
import Footer from "@/components/Footer.vue";
import Header from "@/views/car/components/Header.vue";
import CarListItem from "@/views/car/components/CarListItem.vue";
import CarFooter from "@/views/car/components/CarFooter.vue";
import { selectCarApi } from "@/api/CarApi.js";
import store from "@/store/index.js";

const carProduct = ref([]);
const { account } = store.state;

const isValidAccount = () => {
    return account && account.id;
};

onMounted(async () => {
    try {
        const result = await selectCarApi(account);
        carProduct.value = result;
    } catch (e) {
        console.error("Error fetching carProduct:", e);
    }
});

const handleNumberUpdate = (id, newNumber) => {
    const item = carProduct.value.find((item) => item.id === id);
    if (item) {
        item.number = newNumber; // 更新数量
    } else {
        console.error("Item not found:", id);
    }
};

const checked = ref([]);

const loading = ref(false);
const onRefresh = () => {
    setTimeout(() => {
        showToast('刷新成功');
        loading.value = false;
    }, 1000);
};

// 监听子组件的事件
const handleOrderSuccess = async () => {
    // 清空购物车或重新加载数据
    carProduct.value = []; // 清空购物车

    checked.value = []; // 清空选中状态
    const result = await selectCarApi(account);
    carProduct.value = result;

};
</script>

<template>
    <div class="car">
        <Header/>
        <div class="content">
            <van-checkbox-group v-model="checked">
                <van-pull-refresh v-model="loading" @refresh="onRefresh" class="refresh" style="min-height: 90vh;">
                    <div v-for="(item, index) in carProduct" :key="item.id">
                        <van-checkbox :name="item.id">
                            <CarListItem :data="item" @update:number="handleNumberUpdate"/>
                        </van-checkbox>
                    </div>
                </van-pull-refresh>
            </van-checkbox-group>
        </div>
        <CarFooter
            :data="carProduct"
            :checked="checked"
            @update:checked="checked = $event"
            @order-success="handleOrderSuccess"
        ></CarFooter>
        <Footer/>
    </div>
</template>

<style scoped>
.car {
    display: flex;
    flex-flow: column;
    height: 100%;
}

.content {
    background: #F2F5F7;
    flex: 1;
    overflow: auto;

}
.refresh{
    min-height: 90px;
}
</style>