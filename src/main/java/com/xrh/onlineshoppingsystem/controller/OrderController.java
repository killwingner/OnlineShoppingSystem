package com.xrh.onlineshoppingsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xrh.onlineshoppingsystem.generator.entity.OrderPost;
import com.xrh.onlineshoppingsystem.generator.entity.Orders;
import com.xrh.onlineshoppingsystem.generator.entity.Products;
import com.xrh.onlineshoppingsystem.generator.service.OrdersService;
import com.xrh.onlineshoppingsystem.generator.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Controller
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Orders")

public class OrderController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    UserController userController;

    @Autowired
    ProductsService productsService;


    @GetMapping("/getOrder")
    public Products[] getOrder(String account) {
        int userId =  userController.getIdByAccount(account);
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<Orders>()
                .eq("user_id", userId);
        List<Orders> orders = ordersService.list(queryWrapper);
        List<OrderPost> products = new ArrayList<>(); // 使用可变列表
        for (Orders order : orders) {
            QueryWrapper<Products> productsQueryWrapper = new QueryWrapper<Products>().eq("id", order.getProduct_id());
            Products product = productsService.getOne(productsQueryWrapper);
            if (product != null) { // 检查 product 是否为 null
                OrderPost orderPost  = new OrderPost();
                orderPost.setId(order.getId());
                orderPost.setImg(product.getImg());
                orderPost.setMoney(product.getMoney());
                orderPost.setStatus(order.getStatus().toString());
                orderPost.setDescription(product.getDescription());
                products.add(orderPost);
            }
        }
        return products.toArray(new Products[0]);
    }

    @GetMapping("/success")
    public String success(int orderId) {
        UpdateWrapper<Orders> Wrapper = new UpdateWrapper<Orders>().eq("id", orderId)
                .set("status", "success");
        ordersService.update(Wrapper);
        return "success";
    }

    @GetMapping("/DelOrder")
    public String DelOrder(int orderId) {
        ordersService.removeById(orderId);
        return "success";
    }
}
