package com.xrh.onlineshoppingsystem.generator.entity;

public class OrderPost extends Products{
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "OrderPost{" +
                "Status='" + Status + '\'' +
                '}';
    }

    public OrderPost() {
    }
}
