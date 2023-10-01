package org.example.model;

import org.example.Utill;
import org.example.constant.Status;

import java.util.List;

public class Order {


    String orderId;
    String customerName;

    Status orderStatus;

    List<Item> orderItems;

    public Order(String customerName, List<Item> orderItems) {
        orderId = String.valueOf(Utill.getId());
        this.customerName = customerName;
        this.orderStatus = Status.PLACED;
        this.orderItems = orderItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }
}
