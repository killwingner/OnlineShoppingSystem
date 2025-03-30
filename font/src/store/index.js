import { createStore } from 'vuex';

const store = createStore({
    state() {
        return {
            account: localStorage.getItem('account') || "", // 初始化时从 localStorage 读取
            name: localStorage.getItem('name') || "", // 初始化时从 localStorage 读取

        };
    },
    mutations: {

        login(state, payload) {
            state.account = payload.account;
            state.name = payload.name;
            localStorage.setItem('account', payload.account); // 存储到 localStorage
            localStorage.setItem('name', payload.name); // 存储到 localStorage
        },
        logout(state) {
            state.account = null; // 清除 Vuex 中的 account
            state.name = null; // 清除 Vuex 中的 name
            localStorage.removeItem('account'); // 从 localStorage 中移除 account
            localStorage.removeItem('name'); // 从 localStorage 中移除 name
        }
    }
});

export default store;