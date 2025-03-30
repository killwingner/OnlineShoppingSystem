// src/api.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/Product';

// 获取产品信息
export const getProductById = async (id) => {
    const response = await axios.get(`${API_BASE_URL}/GetProductById`, { params: { id } });
    return response.data;
};

// 获取所有产品
export const getAllProducts = async () => {
    const response = await axios.get(`${API_BASE_URL}/GetAllProducts`);
    return response.data;
};

//搜索产品
export const SelectProduct = async (name) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/SelectProduct`, { params:{name}  });
        return response.data;
    } catch (error) {
        console.error("请求失败：", error);
        return null;
    }
};

//产品分类
export const TypeProduct = async (type) => {
    try {
        console.log(type);
        const response = await axios.get(`${API_BASE_URL}/TypeProduct`, { params:{type}  });
        return response.data;
    } catch (error) {
        console.error("请求失败：", error);
        return null;
    }
};
