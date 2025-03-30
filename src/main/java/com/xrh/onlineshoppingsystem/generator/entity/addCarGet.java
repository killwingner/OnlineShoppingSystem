package com.xrh.onlineshoppingsystem.generator.entity;




public class addCarGet {

    private int productId;

    private String account;

    private int number;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "addCarGet{" +
                "productId=" + productId +
                ", account='" + account + '\'' +
                ", number=" + number +
                '}';
    }
}
