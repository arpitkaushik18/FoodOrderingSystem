package org.example.dao;

import org.example.model.Item;
import org.example.model.Restaurant;

import java.util.List;

public interface RestaurantManagerDao {

    void addRestaurant(Restaurant restaurant);

    Restaurant getRestaurant(String restaurantName);
    void deleteRestaurant();

    List<Restaurant> getAllRestaurantBasedOnItemList(List<Item> itemList);
}
