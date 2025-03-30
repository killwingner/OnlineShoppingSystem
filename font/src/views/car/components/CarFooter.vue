<script setup>
import { ref, defineProps, watch } from "vue";
import {addCarApi, addOrderApi} from "@/api/CarApi.js";
import store from "@/store/index.js";
import { showSuccessToast, showFailToast } from 'vant';
const props = defineProps({
    checked: Array, // 选中的商品索引
    data: Array, // 商品列表
});

const isCheckAll = ref(false); // 全选状态
const isIndeterminate = ref(false); // 半选状态
const totalPrice = ref(0); // 总价

// 动态更新全选状态和总价
watch(() => props.checked, (newValue) => {
    const checkedCount = newValue.length;
    isCheckAll.value = checkedCount === props.data.length; // 全选状态
    isIndeterminate.value = checkedCount > 0 && checkedCount < props.data.length; // 半选状态
    updateTotalPrice(); // 更新总价
}, { deep: true });

// 监听 props.data 的变化，更新总价
watch(() => props.data, () => {
    updateTotalPrice(); // 更新总价
}, { deep: true });

// 更新总价的函数
const updateTotalPrice = () => {
    totalPrice.value = props.data
        .filter((item) => props.checked.includes(item.id)) // 筛选出选中的商品
        .reduce((sum, item) => sum + parseFloat(item.money) * item.number, 0); // 累加价格（考虑数量）
};

function sleep(ms) {
    return new Promise(resolve => {
        setTimeout(resolve, ms);
    });
}

async function testSleep() {
    await sleep(500); // 休眠1秒
}

// 全选按钮的点击事件
const emit = defineEmits(["update:checked"]); // 定义事件

const handleCheckAll = () => {
    if (isCheckAll.value) {
        const newChecked = props.data.map((item) => item.id);
        emit("update:checked", newChecked); // 通知父组件更新 checked
    } else {
        emit("update:checked", []); // 清空选中项
    }
};

const addOrder = async () => {
    const selectedProducts = props.data.filter((item) => props.checked.includes(item.id));
    const data = {
        account: store.state.account,
        products: selectedProducts
    };
    try {
        const result = await addOrderApi(data);
        showSuccessToast('结算成功');
        await testSleep(); // 确保延迟完成后再触发事件
        emit("order-success"); // 触发事件
    } catch (error) {
        console.error("Error in addOrder:", error);
        showFailToast('结算失败');
    }
};
</script>

<template>
    <div class="footer">
        <van-checkbox
            v-model="isCheckAll"
            :indeterminate="isIndeterminate"
            @click="handleCheckAll"
        >
            全选
        </van-checkbox>
        <div>
            <span>
                总价:
            </span>
            <div class="total-price">
                ¥{{ totalPrice.toFixed(2) }}
            </div>
            <div>
                <van-button type="primary" @click="addOrder">结算</van-button>
            </div>
        </div>
    </div>
</template>

<style scoped>
.footer {
    font-size: 12px;
    color: #A1AAB8;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
    background-color: #fff;
    border-top: 1px solid #ddd;
}
.footer span {
    font-size: 16px;
    font-weight: bold;
}
.footer div {
    align-items: center;
    display: flex;
}
.footer .total-price {
    margin-right: 10px;
    font-size: 20px;
    font-weight: bold;
    color: #FD5001;
}
</style>