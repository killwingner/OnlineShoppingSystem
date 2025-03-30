import axios from 'axios';

// 定义后端接口的基础路径
const BASE_URL = 'http://localhost:8080/Orders';

export const getOrder = async (account)=>{
    try{
        const response = await axios.get('http://localhost:8080/Orders/getOrder',{params:{account:account}});
        return response.data;
    }catch(error){
        throw new Error(`Failed to get car: ${error.message}`);
    }
}

export const success = async (orderId)=>{
    try{
        console.log(orderId)
        const response = await axios.get(`${BASE_URL}/success`,{params:{orderId: orderId}} );
        return response.data;
    }catch(error){
        throw new Error(`Failed to get order: ${error.message}`);
    }
};

export const Del = async (orderId)=>{
    try{
        console.log(orderId)
        const response = await axios.get(`${BASE_URL}/DelOrder`,{params:{orderId: orderId}} );
        return response.data;
    }catch(error){
        throw new Error(`Failed to get order: ${error.message}`);
    }
};