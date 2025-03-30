

<script setup>
import { defineProps, ref, onMounted } from 'vue';

const props = defineProps({
    data: {
        type: Object,
        required: true
    }
});

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
</script>

<template>
    <div class="nav-list-item">
        <img :src="itemImg" :alt="itemImg">
        <div class="description">
            <p>{{ item.description }}</p>
            <div class="price">
                <span class="rmb">￥</span>
                <span class="moneyNumber">{{ item.money }}</span>
                <span class="buyNumber">已售{{ item.number }}</span>
            </div>
        </div>
    </div>
</template>

<style scoped>
.nav-list-item{
    border-radius: 10px;
    height: 300px;
    width: 160px;
    margin: 10px;
    img{
        width: 100%;
        height: 250px;
    }
    .description{
        margin-top: 0px;
        p{

            font-size: 16px;
            white-space: nowrap; /* 强制不换行 */
            text-align: center;
            overflow: hidden; /* 隐藏溢出部分 */
        }
        .price{
            margin-top: 0;
            .rmb{
                font-size: 12px;
                color: #FF690B;
            }
            .moneyNumber{
                font-size: 18px;
                color: #FF690B;
            }
            .buyNumber{
                margin-left: 10px;
                font-size: 12px;
                color: #51607A;
            }

        }

    }
}

</style>