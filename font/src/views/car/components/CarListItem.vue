<script setup>
import { defineProps, defineEmits, ref, watch } from 'vue';

const props = defineProps({
    data: {
        type: Object,
        required: true
    }
});

const emit = defineEmits(['update:number']); // 声明事件

const localNumber = ref(props.data.number); // 使用本地副本

watch(localNumber, (newNumber) => {
    emit('update:number', props.data.id, newNumber); // 传递 item.id 和 newNumber
});
</script>

<template>
    <div class="product">
        <img :src="data.img" alt="图片">
        <div class="detail">
            <span>{{ data.description }}</span>
            <span>价格:{{ (data.money * localNumber).toFixed(2) }}</span>
        </div>
        <van-stepper v-model="localNumber" :max="data.number" @click.stop />
    </div>
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
}

.detail span {
    margin-bottom: 8px; /* 每行之间的间距 */
    font-size: 14px; /* 字体大小 */
    color: #333; /* 字体颜色 */
}

.detail span:last-child {
    margin-bottom: 0; /* 最后一行不需要间距 */
}
</style>