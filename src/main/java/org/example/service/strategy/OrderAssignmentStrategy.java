package org.example.service.strategy;

import org.example.model.Order;
import org.example.model.Restaurant;

import java.util.List;

public interface OrderAssignmentStrategy {

    Restaurant assignOrder(Order order, List<Restaurant> restaurantList);
}
