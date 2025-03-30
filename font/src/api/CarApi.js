import axios from 'axios';

// 定义后端接口的基础路径
const BASE_URL = 'http://localhost:8080/Car';

// 添加到购物车的 API 方法
export const addCarApi = async (data) => {
    try {

        // 发送 POST 请求到后端的 /Car/addCar 接口
        const response = await axios.post(`${BASE_URL}/addCar`, data);
        return response.data; // 返回后端的响应数据
    } catch (error) {
        // 捕获请求错误，并抛出异常
        throw new Error(`Failed to add car: ${error.message}`);
    }
};

//查询用户的购物车
export const selectCarApi = async (account) => {
    try{
        const response = await axios.get(`${BASE_URL}/getCarById`, { params: { account } });
        return response.data;
    }catch(error){
        throw new Error(`Failed to selectCarApi: ${error.message}`);
    }
}

//提交订单
export const addOrderApi = async (data) => {
    try{
        console.log(data)
        const response = await axios.post(`${BASE_URL}/addOrder`, data);
    }catch (e){
        throw new Error(`Failed to add order: ${e}`);
    }


}