package com.xrh.onlineshoppingsystem.generator.entity;

import java.util.Arrays;
import java.util.List;

public class CaraddOrderGet {
    private String account;
    private List<ProductGet> products;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<ProductGet> getProducts() {
        return products;
    }

    public void setProducts(List<ProductGet> products) {
        this.products = products;
    }

    public CaraddOrderGet() {
    }

    @Override
    public String toString() {
        return "CaraddOrderGet{" +
                "account='" + account + '\'' +
                ", products=" + products +
                '}';
    }
}
