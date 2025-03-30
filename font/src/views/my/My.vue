<script setup>
import Footer from "@/components/Footer.vue";
import { ref } from 'vue';
import { useStore } from 'vuex';
import router from "@/router/index.js";

// 使用 Vuex 的 store
const store = useStore();


// 获取 Vuex 的 state
const { account, name } = store.state;



const handleLogout = () => {
    store.commit('logout');
};

const goToCar = ()=>{
    router.push('/car')
}

const goToOrder = ()=>{
    router.push('/order')
}

</script>

<template>
<div class="my">

    <div class="content">
        <div class="user">
            <div class="image">
                <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-yonghu"></use>
                </svg>
            </div>
            <span >{{name}}</span>
        </div>
        <div class="menu">
            <van-cell-group>
                <van-cell title="我的购物车" is-link to="/car" />
                <van-cell title="我的订单" is-link to="/order" />
                <van-cell title="退出登录" is-link to="/" />
            </van-cell-group>
        </div>


    </div>
    <Footer/>
</div>
</template>

<style scoped>
.my {
    display: flex;
    flex-direction: column;
    height: 100%;
    background-color: #f5f5f5;
    font-family: Arial, sans-serif;
}

.content {
    flex: 1;
    display: flex;
    flex-direction: column;
    padding: 20px;
    gap: 20px;
    overflow: auto;
}

.user {
    display: flex;
    align-items: center;
    gap: 10px;
    background-color: #EE0000; /* 红色背景 */
    padding: 15px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    color: #fff; /* 文字颜色调整为白色 */
}

.image {
    width: 50px;
    height: 50px;
    background-color: #ddd;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
}

.image svg {
    width: 30px;
    height: 30px;
    fill: #fff; /* 图标颜色调整为白色 */
}

.menu {
    display: flex;
    flex-direction: column;
    gap: 10px;
}

.menu-item {
    display: flex;
    align-items: center;
    gap: 10px;
    padding: 15px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    color: #333;
    text-decoration: none;
    font-size: 16px;
    cursor: pointer; /* 添加鼠标悬停效果 */
    transition: background-color 0.3s; /* 添加过渡效果 */
}

.menu-item:hover {
    background-color: #f0f0f0; /* 悬停时的背景颜色 */
}

.menu-item svg {
    width: 20px;
    height: 20px;
    fill: #666;
}

.logout {
    color: #ff4d4f; /* 退出登录按钮的颜色 */
    cursor: pointer;
}

.logout svg {
    fill: #ff4d4f;
}

.logout:hover {
    background-color: #ffe6e6;
}

@media (max-width: 768px) {
    .content {
        padding: 10px;
    }

    .user {
        flex-direction: column;
        gap: 5px;
    }

    .image {
        width: 40px;
        height: 40px;
    }

    .menu-item {
        padding: 10px;
        font-size: 14px;
    }
}
</style>