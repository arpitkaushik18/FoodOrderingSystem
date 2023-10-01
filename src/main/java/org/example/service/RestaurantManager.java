package org.example.service;

import org.example.model.Item;
import org.example.model.Restaurant;

import java.util.List;

public interface RestaurantManager {

    void onboardRestaurant(Restaurant restaurant);

    void updateRestaurantMenu(String restaurantName, Item item);
    void updateRestaurant(String restaurantName);

    List<Restaurant> getRestaurantsBasedOnItem(List<Item> items);
}
