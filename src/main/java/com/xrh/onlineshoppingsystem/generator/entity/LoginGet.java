package com.xrh.onlineshoppingsystem.generator.entity;

public class LoginGet {
    String account;
    String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginGet{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public LoginGet() {
    }
}
