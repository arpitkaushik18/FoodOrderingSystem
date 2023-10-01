package org.example.service;

import org.example.dao.OrderServiceDao;
import org.example.model.Order;
import org.example.model.Restaurant;
import org.example.constant.Status;
import org.example.service.strategy.OrderAssignmentStrategy;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    private OrderAssignmentStrategy orderAssignmentStrategy;

    private OrderServiceDao orderServiceDao;

    private RestaurantManager restaurantManager;

    public OrderServiceImpl(OrderAssignmentStrategy orderAssignmentStrategy, OrderServiceDao orderServiceDao, RestaurantManager restaurantManager) {
        this.orderAssignmentStrategy = orderAssignmentStrategy;
        this.orderServiceDao = orderServiceDao;
        this.restaurantManager = restaurantManager;
    }

    @Override
    public void placeOrder(Order order) {
        List<Restaurant> restaurantList = restaurantManager.getRestaurantsBasedOnItem(order.getOrderItems());
        Restaurant validRestaurant = orderAssignmentStrategy.assignOrder(order,restaurantList);
        System.out.println("Order is assigned to : " + validRestaurant.getRestaurantName());
        order.setOrderStatus(Status.IN_PROGRESS);
        orderServiceDao.addOrder(validRestaurant.getRestaurantName(),order);
    }

    @Override
    public void updateOrderStatus(String restaurantName,String orderId) {
        orderServiceDao.updateOrderStatus(restaurantName,orderId);
        restaurantManager.updateRestaurant(restaurantName);
    }
}
