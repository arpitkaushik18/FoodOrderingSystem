package org.example.service.strategy;

import org.example.exception.NoRestaurantAvailable;
import org.example.constant.FoodItem;
import org.example.model.Item;
import org.example.model.Order;
import org.example.model.Restaurant;

import java.util.HashMap;
import java.util.List;

public class CostBasedOrderAssignmentStrategy implements OrderAssignmentStrategy {
    public CostBasedOrderAssignmentStrategy() {
    }

    @Override
    public Restaurant assignOrder(Order order, List<Restaurant> restaurantList) {

        Restaurant validRestaurant = null;

        int minCost = Integer.MAX_VALUE;

        for(Restaurant restaurant : restaurantList){

            HashMap<FoodItem, Item> items = restaurant.getMenu();

            int val = 0;

            for(Item item : order.getOrderItems()){
                val += items.get(item.getFoodItem()).getPrice();
            }

            if(val < minCost && restaurant.getMaxOrderCanProcess() != 0){
                validRestaurant = restaurant;
                validRestaurant.setMaxOrderCanProcess(restaurant.getMaxOrderCanProcess()-1);
            }

        }

        if(validRestaurant == null){
            throw new NoRestaurantAvailable("Not possible to assign restaurant at moment");
        }

        return validRestaurant;
    }
}
