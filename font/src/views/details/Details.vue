
<script setup>
import {ref} from 'vue';
import {useRoute, onBeforeRouteUpdate} from 'vue-router';
import Header from "@/views/details/components/Header.vue";
import Footer from "@/views/details/components/Footer.vue";
import {getProductById} from "@/api/ProductApi.js";

const loading = ref(false);
const onRefresh = () => {
    setTimeout(() => {
        showToast('刷新成功');
        loading.value = false;
    }, 1000);
};

// 获取当前路由对象
const route = useRoute();

// 定义响应式变量来存储动态参数
const id = ref(route.params.id);

// 定义加载状态和错误信息
const isLoading = ref(false);
const error = ref(null);

// 响应式变量，存储产品信息
const product = ref(null);

// 获取产品信息
const fetchProduct = async () => {
    isLoading.value = true; // 开始加载
    error.value = null; // 清除之前的错误信息

    try {
        product.value = await getProductById(id.value); // 调用封装的请求方法
    } catch (err) {
        console.error('Failed to fetch product:', err);
        error.value = err.message || 'Failed to load product'; // 设置错误信息
        product.value = null; // 确保 product 为 null，避免渲染错误
    } finally {
        isLoading.value = false; // 加载完成
    }
};

// 在组件初始化时调用
fetchProduct();

// 监听路由变化（当用户在同一个组件中切换参数时）
onBeforeRouteUpdate((to, from, next) => {
    id.value = to.params.id; // 更新 id 的值
    fetchProduct(); // 重新获取产品信息
    next(); // 确保路由更新
});
</script>

<template>
    <div class="details">
        <Header />
        <div class="container">
            <van-pull-refresh v-model="loading" @refresh="onRefresh" class="refresh">
                <div v-if="product">
                    <img :src="product.img" alt="图片">
                    <div>
                        <div class="price">
                            <span class="money">
                                <span>￥</span> {{ product.money || '加载中...' }}
                            </span>
                            <span class="buyNumber">
                                已售 {{ product.number || '加载中...' }}
                            </span>
                        </div>
                        <span class="description">{{ product.description || '加载中...' }}</span>
                    </div>
                </div>
                <div v-else>
                    <p v-if="isLoading">Loading...</p>
                    <p v-else-if="error" class="error">{{ error }}</p>
                </div>
                <div class="nav">
                    <span> 多人评价“没有色差” </span>
                    <span> 多人评价“质感很好” </span>
                    <span v-if="product"> 超{{ product.number || 0 }}加购 </span>
                    <span v-else>加载中...</span>
                </div>
            </van-pull-refresh>
        </div>
        <Footer :data="id"/>
    </div>
</template>

<style scoped>
.details{
    display: flex; /* 将 .details 设置为 flex 容器 */
    flex-direction: column; /* 子元素按垂直方向排列 */
    height: 100%; /* 确保父容器占满整个页面高度 */
    background: #FEFEFE;
    .container{
        flex: 1; /* 让 .container 占满剩余空间 */
        overflow: auto; /* 如果内容超出容器高度，允许滚动 */
        padding: 10px; /* 添加一些内边距，可根据需要调整 */
        .refresh{
            min-height: 90vh;
        }
        img{
            height: 10rem;
        }
        .price{
            display: flex;
            justify-content: space-between;
            .money{
                color: #FE6202;
                span{
                    margin-right: -10px;
                    margin-left: 10px;
                    font-size: 16px;
                }
                font-size: 30px;
            }

            .buyNumber{
                margin-top: 13px;
                font-size: 13px;
                margin-right: 20px;
            }
        }
        .description{
            font-size: 16px;
        }
        .nav{
            margin-top: 10px;
            display: flex;
            justify-content: start;
            font-size: 14px;
            span{
                text-wrap: nowrap;
                padding: 5px;
                border-radius: 5px;
                background: #F1F5F7;
                margin-left: 5px;
                margin-right: 5px;
            }
        }
    }
}

.error {
    color: red;
}


</style>