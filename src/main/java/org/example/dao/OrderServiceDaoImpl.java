package org.example.dao;

import org.example.model.Order;
import org.example.constant.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class OrderServiceDaoImpl implements OrderServiceDao{

    HashMap<String, List<Order>> restaurantToOrderList;

    public OrderServiceDaoImpl() {
        this.restaurantToOrderList = new HashMap<>();
    }

    @Override
    public void addOrder(String restaurantName, Order order) {

        if(restaurantToOrderList.containsKey(restaurantName)){
            restaurantToOrderList.get(restaurantName).add(order);
        }else{
            List<Order> orders = new ArrayList<>();
            orders.add(order);
            restaurantToOrderList.put(restaurantName, orders);
        }

    }

    @Override
    public void updateOrderStatus(String restaurantName, String orderId) {
        List<Order> orders = restaurantToOrderList.get(restaurantName);
        for(Order order : orders){
            if(Objects.equals(order.getOrderId(), orderId)){
                order.setOrderStatus(Status.COMPLETED);
            }
        }}
}
