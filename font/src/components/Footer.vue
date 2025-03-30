<script setup>

</script>

<template>
    <div class="footer">
        <div class="item">
            <router-link to="/home" class="nav-item" active-class="active">
                <template v-slot:default>
                    <van-icon name="wap-home-o" size="30" />
                    首页
                </template>
            </router-link>
        </div>

        <div class="item">
            <router-link to="/car" class="nav-item" active-class="active">
                <template v-slot:default>
                    <van-icon name="cart-o" size="30" />
                    购物车
                </template>
            </router-link>
        </div>

        <div class="item">
            <router-link to="/order" class="nav-item" active-class="active">
                <template v-slot:default>
                    <van-icon name="balance-list-o" size="30" />
                    订单
                </template>
            </router-link>
        </div>

        <div class="item">
            <router-link to="/my" class="nav-item" active-class="active">
                <template v-slot:default>
                    <van-icon name="user-circle-o" size="30" />
                    我的
                </template>
            </router-link>
        </div>
    </div>
</template>

<style scoped>
.footer{
    display: flex;
    background: #fff;
    border-top: .5px solid #eee;
    .item{
        flex: 1;
        .active{
            color: #FF5F00;
        }
    }
    .nav-item{
        display: flex;
        flex-flow: column;
        align-items: center;
        white-space: nowrap;
        font-size: 12px;
    }
}
</style>