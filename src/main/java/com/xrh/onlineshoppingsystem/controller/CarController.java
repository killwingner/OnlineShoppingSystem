package com.xrh.onlineshoppingsystem.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xrh.onlineshoppingsystem.generator.entity.*;
import com.xrh.onlineshoppingsystem.generator.service.CarService;
import com.xrh.onlineshoppingsystem.generator.service.OrdersService;
import com.xrh.onlineshoppingsystem.generator.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/Car")
@CrossOrigin(origins = "http://localhost:5173")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    UserController userController;

    @Autowired
    ProductsService productsService;

    @Autowired
    OrdersService ordersService;

    @PostMapping("/addCar")
    public String addCar(@RequestBody addCarGet addCarGet) {
        System.out.println(addCarGet);
        Car car = new Car();
        car.setUserId(userController.getIdByAccount(addCarGet.getAccount()));
        car.setProductId(addCarGet.getProductId());
        car.setNumber(addCarGet.getNumber());
        carService.save(car);
        return "success";
    }

    @GetMapping("/getCarById")
    public List<Products> getCarById(String account) {
        Integer userId = userController.getIdByAccount(account); // 确保返回值为 Integer，而不是 int
        if (userId == null) {
            return new ArrayList<>(); // 如果 userId 为 null，直接返回空列表
        }
        QueryWrapper<Car> queryWrapper = new QueryWrapper<Car>().eq("user_id", userId);
        List<Car> cars = carService.list(queryWrapper);
        List<Products> products = new ArrayList<>(); // 使用可变列表
        for (Car car : cars) { // 遍历 cars 列表
            QueryWrapper<Products> productsQueryWrapper = new QueryWrapper<Products>().eq("id", car.getProductId());
            Products product = productsService.getOne(productsQueryWrapper);
            if (product != null) { // 检查 product 是否为 null
                product.setNumber(car.getNumber());
                products.add(product); // 添加到 products 列表
            }
        }

        return products.stream()
                .filter(p -> p.getNumber() > 0)
                .toList();
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody CaraddOrderGet caraddOrderGet) {
        int userId =  userController.getIdByAccount(caraddOrderGet.getAccount());
        QueryWrapper<Car> queryWrapper = new QueryWrapper<Car>()
                .eq("user_id", userId);
        List<Car> cars = carService.list(queryWrapper);
        for (int i = 0; i < caraddOrderGet.getProducts().size(); i++) {
            UpdateWrapper<Car> updateWrapper = new UpdateWrapper<Car>()
                    .eq("product_id", caraddOrderGet.getProducts().get(i).getId())
                    .setSql("number = number - {0}", caraddOrderGet.getProducts().get(i).getNumber());
            Orders orders =  new Orders ();
            orders.setUser_id(userId);
            orders.setProduct_id(caraddOrderGet.getProducts().get(i).getId());
            orders.setStatus("transiting");
            ordersService.save(orders);
            carService.update(updateWrapper);
        }

            return "success";
    }
}
