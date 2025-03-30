<script setup>
import {ref} from "vue";
import {signIn} from "@/api/userApi.js";
import router from "@/router/index.js";
import 'vant/es/toast/style'

import { showSuccessToast} from 'vant';

const username = ref('');
const password = ref('');
const account = ref('');
const formRef = ref(null);





const onSubmit = async () => {
    console.log(1)
    try {
        const signData = await signIn(account.value, password.value, username.value);
        console.log(signData)
        if (signData === 301) {
            console.log(2)
            showFailToast('账号冲突');
        } else {
            showSuccessToast('注册成功');
            history.back()
        }
    } catch (e) {
        console.error(e)
    }
};

const onClickLeft = () => history.back();
</script>

<template>
    <van-nav-bar
        title="注册"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
    />
    <div class="container">
        <div class="title">卓越购物</div>
        <van-form @submit="onSubmit" ref="formRef">
            <van-cell-group inset>
                <van-field
                    v-model="username"
                    name="用户名"
                    label="用户名"
                    placeholder="用户名"
                    :rules="[{ required: true, message: '请填写用户名' }]"
                />
                <van-field
                    v-model="account"
                    name="账号"
                    label="账号"
                    placeholder="请输入账号"
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
            <div style="margin: 16px;">
                <van-button round block type="primary" native-type="submit" >
                    提交
                </van-button>
            </div>
        </van-form>
    </div>
</template>

<style scoped>
.title {
    font-size: 40px;
    color: #EE0000;
    text-align: center;
    font-weight: bold;
    margin-bottom: 30px;
    margin-top: 100px;
}


</style>