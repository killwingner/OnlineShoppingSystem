package com.xrh.onlineshoppingsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xrh.onlineshoppingsystem.generator.entity.Products;
import com.xrh.onlineshoppingsystem.generator.service.ProductsService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Product")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    ProductsService productsService;

    @GetMapping("/GetProductById")
    public Products getProductById(String id) {
        return productsService.getById(id);
    }

    @GetMapping("/SelectProduct")
    public List<Products> SelectProduct( String name) {
        System.out.println(name);
        QueryWrapper<Products> queryWrapper1 = new QueryWrapper<Products>()
                .like("description", name);
        QueryWrapper<Products> queryWrapper2 = new QueryWrapper<Products>()
                .like("type", name);
        List<Products> list = productsService.list(queryWrapper1);
        list.addAll(productsService.list(queryWrapper2));
        System.out.println(list);
        return list.isEmpty() ? null : list;
    }

    @GetMapping("TypeProduct")
    public List<Products> TypeProduct(String type) {
        System.out.println(type);
        QueryWrapper<Products> queryWrapper = new QueryWrapper<Products>()
                .like("type", type);
        List<Products> list = productsService.list(queryWrapper);
        System.out.println(list);
        return list.isEmpty() ? null : list;
    }



}
