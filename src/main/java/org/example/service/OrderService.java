package org.example.service;

import org.example.model.Order;

public interface OrderService {

    void placeOrder(Order order);

    void updateOrderStatus(String restaurantName,String orderId);


}
