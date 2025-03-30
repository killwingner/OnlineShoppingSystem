// router/index.js
import { createRouter, createWebHashHistory } from "vue-router";
import store from "@/store"; // 确保引入 Vuex store

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: "/",
            component: () => import("@/views/login/Login.vue"),
        },
        {
            path: "/home",
            component: () => import("@/views/home/Home.vue"),
        },
        {
            path: "/my",
            component: () => import("@/views/my/My.vue"),
        },
        {
            path: "/car",
            component: () => import("@/views/car/Car.vue"),
        },
        {
            path: "/order",
            component: () => import("@/views/order/Order.vue"),
        },
        {
            path: "/details",
            component: () => import("@/views/details/Details.vue"),
        },
        {
            path: "/detail/:id",
            component: () => import("@/views/details/Details.vue"),
        },
        {
            path:'/signIn',
            component:()=>import("@/views/signIn/SignIn.vue")
        },
        {
            path:'/search/:value',
            component:() => import("@/views/srearch/search.vue")
        },
        {
            path:'/type/:Type',
            component:()=> import("@/views/Type/Type.vue")
        }

    ]
});

// 全局前置路由守卫
router.beforeEach((to, from, next) => {
    const account = store.state.account; // 获取 Vuex 中的 account 状态
    // 如果 account 为空且目标路由不是登录页，则跳转到登录页
    if (!account && to.path !== "/" ) {
        next({ path: "/" }); // 跳转到登录页
    } else {
        next(); // 继续执行路由跳转
    }
});

export default router;