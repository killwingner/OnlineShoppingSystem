<script setup>
import { ref } from "vue";
import { login } from "@/api/userApi.js"; // 引入封装好的 login 方法
import store from "@/store/index.js";
import router from "@/router/index.js";
const account = ref(""); // 用户名
const password = ref(""); // 密码
import 'vant/es/toast/style'
const handleLogin = async () => {
    try {
        // 调用封装的 login 方法
        const loginData = await login(account.value, password.value);
        if(loginData === null){
            showFailToast('登陆失败');
        }else{
            store.commit("login",{
                account: account.value,
                name: loginData
            } );
            await router.push('/home')
        }

    } catch (error) {
        console.error("登录失败：", error.message);
        alert("登录失败：" + error.message);
    }
};

const signIn = ()=>{
    router.push('/signIn')
}
</script>

<template>
    <div class="container">
        <div class="title">卓越购物</div>
        <van-form @submit="handleLogin" class="loginFrom">
            <van-cell-group inset>
                <van-field
                    v-model="account"
                    name="账号"
                    label="账号"
                    placeholder="账号"
                    :rules="[{ required: true, message: '请填写账号' }]"
                />
                <van-field
                    v-model="password"
                    type="password"
                    name="密码"
                    label="密码"
                    placeholder="密码"
                    :rules="[{ required: true, message: '请填写密码' }]"
                />
            </van-cell-group>
            <div class="button">
                <van-button block type="primary" native-type="submit" class="loginButton">
                    登陆
                </van-button>
                <van-button block type="primary" class="signButton" @click="signIn">
                    注册
                </van-button>
            </div>
        </van-form>
    </div>
</template>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
}
.title {
    font-size: 40px;
    color: #EE0000;
    text-align: center;
    font-weight: bold;
    margin-bottom: 30px;
    margin-top: 100px;
}
.loginFrom {
    .button {
        display: flex;
        justify-content: space-between;
        margin-top: 30px;
        .loginButton {
            width: 3.3rem;
        }
        .signButton {
            width: 3.3rem;
        }
    }
}
</style>