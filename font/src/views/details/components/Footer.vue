

<script setup>
import { ref } from 'vue';
import { useStore } from 'vuex';
import { Toast } from 'vant';
import { addCarApi } from '@/api/CarApi.js'; // 引入 API 方法
import { showSuccessToast, showFailToast } from 'vant';
// 使用 Vuex 的 store
const store = useStore();

// 商品数量，初始值为 1
const number = ref(1);

// 定义 props
const props = defineProps({
    data: {
        type: String,
        required: true
    }
});

// 从 props 中提取商品 ID
const id = props.data;

// 添加到购物车的方法
const addCar = async () => {
    try {
        // 调用 API 方法，传入参数
        const result = await addCarApi({
            account: store.state.account, // 假设 account 存储在 Vuex 的 state 中
            productId: id,               // 商品 ID
            number: number.value         // 商品数量
        });

        // 根据后端返回的结果处理逻辑
        if (result === 'success') {
            showSuccessToast('添加成功');
        } else {
            showFailToast('添加失败');
        }
    } catch (error) {

    }
};
</script>

<template>
    <div class="footer">
        <van-submit-bar
            button-text="加入购物车"
            @submit="addCar"
            class="submitBar">
            <template #top>
                <van-stepper v-model="number" class="stepper" />
            </template>
        </van-submit-bar>

    </div>
</template>

<style scoped>
:root {
    --primary-color: #FE6202; /* 主题颜色（橙色） */
    --hover-color: #D85500; /* 悬停状态颜色（稍微深一点的橙色） */
    --background-color: #f5f5f5; /* 背景颜色 */
    --text-color: #333; /* 文本颜色 */
    --border-color: #ebedf0; /* 边框颜色 */
}

.footer {
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: var(--background-color);
    padding: 10px;
}

.submitBar {
    width: 100%;
    display: flex;
    justify-content: space-between; /* 两端对齐 */
    align-items: center;
    border-radius: 8px;
    background-color: var(--primary-color);
    color: white;
    transition: background-color 0.3s ease;
    padding: 10px;
    font-size: 16px;
    font-weight: bold;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
}

.submitBar:hover {
    background-color: var(--hover-color); /* 使用预定义的悬停颜色 */
}

.stepper {
    margin-right: 0; /* 移除右边距 */
    width: 100px;
    border: 1px solid var(--border-color);
    border-radius: 4px;
    background-color: white;
    color: var(--text-color);
    padding: 5px 10px;
    font-size: 14px;
}
</style>
