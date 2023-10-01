package org.example.dao;

import org.example.model.Order;

public interface OrderServiceDao {

    void addOrder(String restaurantName, Order order);

    void updateOrderStatus(String restaurantName, String orderId);

}
