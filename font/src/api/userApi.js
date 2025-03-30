// api.js
import axios from "axios";
import {passwordInputProps} from "vant";

// 设置 axios 的基础配置
const apiClient = axios.create({
    baseURL: "http://localhost:8080", // 后端接口的基础路径
    timeout: 5000, // 请求超时时间
    headers: {
        "Content-Type": "application/json", // 默认请求头
    },
});

// 登录接口封装
export const login = async (account, password) => {
    try {
        const response = await apiClient.post("/user/login", {
            account,
            password,
        });
        console.log(response.data)
        return response.data;
    } catch (error) {
        throw new Error("登录失败：" + error.message);
    }
};

export const signIn = async (account,password,name) => {
    try{
        const response = await apiClient.post("/user/signIn", {
            account,
            password,
            name,
        });
        if (response.status === 200) {
            return response.data;
        }
    }catch (e){
        console.log(e)
    }
}