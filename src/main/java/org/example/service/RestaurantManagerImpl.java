package org.example.service;

import org.example.dao.RestaurantManagerDao;
import org.example.constant.FoodItem;
import org.example.model.Item;
import org.example.model.Restaurant;

import java.util.HashMap;
import java.util.List;

public class RestaurantManagerImpl implements RestaurantManager{

    RestaurantManagerDao restaurantManagerDao;

    public RestaurantManagerImpl(RestaurantManagerDao restaurantManagerDao) {
        this.restaurantManagerDao = restaurantManagerDao;
    }

    public void onboardRestaurant(Restaurant restaurant) {
        restaurantManagerDao.addRestaurant(restaurant);
    }

    public void updateRestaurantMenu(String restaurantName, Item item) {
        Restaurant restaurant = restaurantManagerDao.getRestaurant(restaurantName);
        HashMap<FoodItem, Item> itemMap = restaurant.getMenu();

        if(itemMap.containsKey(item.getFoodItem())){
            itemMap.get(item.getFoodItem()).setPrice(item.getPrice());
        }else{
            itemMap.put(item.getFoodItem(),item);
        }
        restaurant.setMenu(itemMap);
        restaurantManagerDao.addRestaurant(restaurant);
    }

    @Override
    public void updateRestaurant(String restaurantName) {
        Restaurant restaurant = restaurantManagerDao.getRestaurant(restaurantName);
        restaurant.setMaxOrderCanProcess(restaurant.getMaxOrderCanProcess()+1);
        restaurantManagerDao.addRestaurant(restaurant);
    }

    @Override
    public List<Restaurant> getRestaurantsBasedOnItem(List<Item> items) {
        return restaurantManagerDao.getAllRestaurantBasedOnItemList(items);
    }

}
