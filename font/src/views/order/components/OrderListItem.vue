<script setup>
import { defineProps, onMounted, ref } from "vue";
import {Del, success} from "@/api/OrderApi.js";
import { showSuccessToast, showFailToast } from 'vant';
// 先声明 props
const props = defineProps({
    data: {
        type: Object,
        required: true
    }
});

// 然后使用 props
const item = props.data;
const itemImg = ref('');

onMounted(() => {
    try {
        itemImg.value = new URL(item.img, import.meta.url).href;
    } catch (error) {
        console.error('Error loading image:', error);
        itemImg.value = '/path/to/default/image.jpg'; // 默认图片路径
    }
});

function sleep(ms) {
    return new Promise(resolve => {
        setTimeout(resolve, ms);
    });
}

async function testSleep() {
    await sleep(500); // 休眠1秒
}


const toSuccess = async () => {
    try {
        const result = await success(item.id);
        showSuccessToast('收货成功');
        await testSleep();
        item.status = 'success'; // 直接更新本地数据
    } catch (error) {
        console.error("Error in toSuccess:", error);
    }
};

const Delete = async () => {
    try {
        const result = await Del(item.id); // 假设 Del 是一个删除订单的 API
        showSuccessToast('删除成功');
        setTimeout(()=>{
            window.location.reload();
        },2000)
    } catch (error) {
        console.error("Error in Del:", error);
        showFailToast('删除失败');
    }
};

</script>

<template>
    <van-swipe-cell>
    <div class="product">
        <img :src="itemImg" alt="图片">
        <div class="detail">
            <span>{{ item.description }}</span>
            <van-button type="primary" class="shouHuo" v-if="item.status === 'transiting'" @click="toSuccess">确认收货</van-button>
            <span class="zhuangTai" v-if="item.status === 'success'" >订单完成</span>
        </div>
    </div>
    <template #right>
        <van-button square type="danger" text="删除"  class="delete-button" @click="Delete"/>
    </template>
    </van-swipe-cell>
</template>

<style scoped>
.product {
    display: flex;
    flex-direction: row; /* 水平排列 */
    align-items: center; /* 垂直居中对齐 */
    justify-content: flex-start; /* 内容从左侧开始 */
    gap: 16px; /* 图片和详情之间的间距 */
    padding: 16px; /* 内边距 */
    border-bottom: 1px solid #ddd; /* 底部分割线 */
    background-color: #fff; /* 背景颜色 */
}

.product img {
    width: 80px; /* 图片宽度 */
    height: 80px; /* 图片高度 */
    object-fit: cover; /* 保证图片填充整个容器 */
    border-radius: 8px; /* 圆角 */
}

.detail {
    display: flex;
    flex-direction: column; /* 垂直排列 */
    flex: 1; /* 占据剩余空间 */
    align-items: end;
    .shouHuo{
        width: 40%;
    }
    .zhuangTai{
        color: #55a532;
    }
}

.detail span {
    margin-bottom: 8px; /* 每行之间的间距 */
    font-size: 14px; /* 字体大小 */
    color: #333; /* 字体颜色 */
}

.detail span:last-child {
    margin-bottom: 0; /* 最后一行不需要间距 */
}
.delete-button{
    height: 100%;
}
</style>