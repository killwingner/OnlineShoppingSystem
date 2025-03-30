import 'amfe-flexible'
import { createApp } from 'vue'
import App from './App.vue'
import './assets/base.css'
import router from "@/router/index.js";
import '@/assets/vant.scss'
import store from './store/index.js'

// 创建 Vue 应用实例
const app = createApp(App);

// 使用路由
app.use(router).use(store);

// 挂载应用到 DOM
app.mount('#app');