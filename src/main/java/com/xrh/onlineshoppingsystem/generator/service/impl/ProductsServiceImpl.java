package com.xrh.onlineshoppingsystem.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xrh.onlineshoppingsystem.generator.service.ProductsService;
import com.xrh.onlineshoppingsystem.generator.entity.Products;
import com.xrh.onlineshoppingsystem.generator.mapper.ProductsMapper;
import org.springframework.stereotype.Service;

/**
* @author 星
* @description 针对表【products】的数据库操作Service实现
* @createDate 2025-02-14 14:23:25
*/
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products>
    implements ProductsService {

}




