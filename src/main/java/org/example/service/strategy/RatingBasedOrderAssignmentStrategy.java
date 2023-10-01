package org.example.service.strategy;

import org.example.exception.NoRestaurantAvailable;
import org.example.constant.FoodItem;
import org.example.model.Item;
import org.example.model.Order;
import org.example.model.Restaurant;

import java.util.HashMap;
import java.util.List;

public class RatingBasedOrderAssignmentStrategy implements OrderAssignmentStrategy{

    @Override
    public Restaurant assignOrder(Order order, List<Restaurant> restaurantList) {

        Restaurant validRestaurant = null;

        double maxRating = 0.0;

        for (Restaurant restaurant : restaurantList) {

            HashMap<FoodItem, Item> items = restaurant.getMenu();
            int itemCount = 0;
            for (Item item : order.getOrderItems()) {
                if(items.containsKey(item.getFoodItem())) {
                    itemCount += 1;
                }
            }

            if (itemCount == order.getOrderItems().size() && restaurant.getMaxOrderCanProcess() != 0 && maxRating < restaurant.getRating()) {
                validRestaurant = restaurant;
                validRestaurant.setMaxOrderCanProcess(restaurant.getMaxOrderCanProcess() - 1);
            }
        }
        if(validRestaurant == null){
            throw new NoRestaurantAvailable("Not possible to assign restaurant at moment");
        }
        return validRestaurant;

    }
}
