<script setup>
import Footer from "@/components/Footer.vue";
import {reactive} from "vue";
import NavListItem from "@/views/home/components/NavListItem.vue";
import router from "@/router/index.js";
import {ref} from "vue";

import {Value} from "sass";
let data = reactive({
    sort:[
        {
            name:"运动",
            icon:"icon-yundonghuwai-copy",
        },
        {
            name:"鞋",
            icon:"icon-pixie",
        },
        {
            name:"厨具",
            icon:"icon-chuju",
        },
        {
            name:"男装",
            icon:"icon-nanzhuang",
        },
        {
            name:"数码",
            icon:"icon-shoujishuma",
        },
        {
            name:"电脑",
            icon:"icon-diannaobangong"
        }
    ],
    contentNavList:[
        {
            index:'1',
            img:"/img/huwai/1.jpg",
            type:"户外",
            description:"桌子户外便携露营野餐桌椅超轻铝合金折叠桌",
            money:"403",
            number:"400"
        },
        {
            index:'2',
            img:"/img/huwai/2.jpg",
            type:"户外",
            description:"强光小型手电筒可充电挂钩随身背包灯多功能户外暖光露营灯",
            money:"9.9",
            number:"1000"
        },
        {
            index:'3',
            img:"/img/huwai/3.jpg",
            type:"户外",
            description:"户外折叠椅子钓鱼椅桶架排队便携沙滩椅露营小马扎凳",
            money:"69",
            number:"100"
        },
        {
            index:'4',
            img:"/img/xie/1.jpg",
            type:"鞋",
            description:"厚底短脸马丁靴低帮男女鞋Collier BEX中古松糕工装鞋子",
            money:"307.82",
            number:"300"
        },
        {
            index:'5',
            img:"/img/xie/2.jpg",
            type:"鞋",
            description:"男鞋春季新款户外徒步登山鞋透气男士休闲老爹鞋舒适运动鞋男",
            money:"359",
            number:"2000"
        },
        {
            index:'6',
            img:"/img/xie/3.jpg",
            type:"鞋",
            description:"男鞋2025新款潮流百搭板鞋春夏男士透气轻便软底运动休闲潮鞋",
            money:"79.9",
            number:"7000"
        },
        {
            index:'7',
            img:"/img/xie/4.jpg",
            type:"鞋",
            description:"厚底乐福鞋女2024新款秋冬黑色英伦风小皮鞋女2025新款单鞋",
            money:"299",
            number:"9000"
        },
        {
            index:'8',
            img:"/img/chujv/1.jpg",
            type:"厨具",
            description:"菜刀菜板全套超快锋利厨房刀具套装家用切菜刀宿舍砧板厨具二合一",
            money:"139",
            number:"400000"
        },
        {
            index:'9',
            img:"/img/chujv/2.jpg",
            type:"厨具",
            description:"德国刀具厨房用品菜刀菜板套装全套家用辅食切片刀砍骨刀组合1789",
            money:"59",
            number:"300000"
        },
        {
            index:'10',
            img:"/img/chujv/3.jpg",
            type:"厨具",
            description:"WUC钛金刀具德国进口钢材抗菌不锈钢厨房厨具菜刀家用套装组合",
            money:"79",
            number:"400"
        },
        {
            index:'11',
            img:"/img/nanzhuang/1.jpg",
            type:"男装",
            description:"MrBu布先生棒球领短袖t恤男2025春夏新款中年立领短袖上衣AT15060",
            money:"338",
            number:"100"
        },
        {
            index:'12',
            img:"/img/nanzhuang/2.jpg",
            type:"男装",
            description:"【纯棉+重磅260g】罗蒙男士圆领短袖T恤2024夏季薄款时尚阔版上衣",
            money:"59",
            number:"61"
        },
        {
            index:'13',
            img:"/img/nanzhuang/3.jpg",
            type:"男装",
            description:"【柒先生新商务系列】柒牌男装满印T恤夏季索罗纳短袖圆领体恤衫",
            money:"119",
            number:"2"
        },
        {
            index:'14',
            img:"/img/shuma/1.jpg",
            type:"数码",
            description:"Ricoh/理光 GR CCD数码相机深邃蓝调 森山大道 人文扫街便携直出",
            money:"1289",
            number:"200"
        },
        {
            index:'15',
            img:"/img/shuma/2.jpg",
            type:"数码",
            description:"Canon佳能V10数码相机摄像机运动vlog直播录像机美颜自拍dv高清4K",
            money:"2258",
            number:"100"
        },
        {
            index:'16',
            img:"/img/shuma/3.jpg",
            type:"数码",
            description:"VALKYRIE/瓦尔基里 VK S1游戏耳机 三模 低延迟电竞芯片 FPS专用",
            money:"149",
            number:"600"
        },
        {
            index:'17',
            img:"/img/diannao/1.jpg",
            type:"电脑",
            description:"【政府补贴20%】ROG枪神8 14代i9 16英寸 星云屏游戏笔记本电脑RTX4060/4070满血显卡全新酷睿CPU玩家国度",
            money:"13999",
            number:"5000"
        },
        {
            index:'18',
            img:"/img/diannao/2.jpg",
            type:"电脑",
            description:"【政府补贴20%】联想拯救者Y7000P 酷睿i7/i9 RTX4070可选拯救者Y9000P AI电竞游戏笔记本电脑",
            money:"7999",
            number:"40000"
        },
        {
            index:'19',
            img:"/img/diannao/3.jpg",
            type:"电脑",
            description:"【政府补贴20%】机械革命 旷世16Pro 英特尔酷睿i9-13900HX 16英寸游戏本笔记本电脑RTX4060显卡学生官方旗舰",
            money:"7999",
            number:"10000"
        },


    ]

})

const showProduct = (id) => {
    router.push(`/detail/${Number(id)}`);
};

const loading = ref(false);
const onRefresh = () => {
    setTimeout(() => {
        showToast('刷新成功');
        loading.value = false;
    }, 1000);
};

const Select = async () => {
    if (!searchValue.value) {
        showToast("请输入搜索内容");
        return;
    }

    await router.push(`/search/${searchValue.value}`);

};
const searchValue = ref('');

const Type = async (type)=>{
    console.log(type);

    await router.push(`/type/${type}`)
}
</script>

<template>
    <div class="home">
        <div class="content">
            <div class="header">
                <div class="text">卓越购物</div>
                <div class="location">
                    <van-icon name="location-o" />
                    <span>北京</span>
                    <van-icon name="arrow" />
                </div>
            </div>
            <div   class="main">
                <div class="mainBG" >
                    <div class="search">
                        <input type="text" v-model="searchValue">
                        <div class="searchText" @click="Select">搜索</div>
                    </div>
                </div>
                <div class="container">
                    <div class="sort">
                        <div v-for="(item,index) in data.sort" :key="index">
                            <div @click="Type(item.name)">
                                <svg class="icon" aria-hidden="true">
                                    <use :xlink:href="`#${item.icon}`"></use>
                                </svg>
                                {{item.name}}
                            </div>
                        </div>
                    </div>
                    <van-pull-refresh v-model="loading" @refresh="onRefresh">
                        <div class="product" >
                            <div  v-for="(item,index) in data.contentNavList" :key="item.index">
                                <NavListItem :data="item" @click="showProduct(item.index)"></NavListItem>
                            </div>
                        </div>
                    </van-pull-refresh>


                </div>

            </div>
        </div>
        <Footer/>
    </div>
</template>

<style scoped>
.home {
    background: #f5fff7; /* 修改背景为浅绿色 */
}

.header {
    background: #2e7d32 !important; /* 修改头部为深绿色 */
    padding: 15px 80px !important; /* 增加左右边距 */
}

.text {
    font-size: 28px !important;
}

.mainBG {
    background: #2e7d32 !important;
    border-radius: 30px 30px 0 0;
    padding: 20px 80px !important; /* 增加左右边距 */
}

.search {
    max-width: 800px; /* 限制搜索框最大宽度 */
    margin: 0 auto; /* 居中 */
}

.searchText {
    background: #388e3c !important; /* 修改搜索按钮颜色 */
    right: 10px !important;
    width: 80px !important;
}

.sort {
    max-width: 1200px;
    margin: 0 auto;
    padding: 40px 0 !important;
}

.sort div {
    width: 16.66% !important; /* 6个分类一行 */
    margin: 20px 0;
}

.icon {
    width: 60px !important; /* 调整图标大小 */
    height: 60px !important;
}

.product {
    max-width: 1200px;
    margin: 0 auto;
    display: grid !important;
    grid-template-columns: repeat(4, 1fr); /* 4列网格布局 */
    gap: 30px;
    padding: 0 20px;
}

/* 新增电脑端hover效果 */
.product div:hover {
    transform: translateY(-5px);
    transition: transform 0.3s ease;
}

/* 响应式调整 */
@media (max-width: 1200px) {
    .product {
        grid-template-columns: repeat(3, 1fr);
    }
}

@media (max-width: 992px) {
    .product {
        grid-template-columns: repeat(2, 1fr);
    }
}

.location {
    font-size: 16px !important;
}

.container {
    padding-bottom: 60px;
}
</style>