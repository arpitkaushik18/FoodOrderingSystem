package org.example.dao;

import org.example.constant.FoodItem;
import org.example.model.Item;
import org.example.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestaurantManagerDaoImpl implements RestaurantManagerDao{

    HashMap<String, Restaurant> restaurantHashMap;

    public RestaurantManagerDaoImpl() {
        this.restaurantHashMap = new HashMap<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantHashMap.put(restaurant.getRestaurantName(),restaurant);
    }

    @Override
    public Restaurant getRestaurant(String restaurantName) {
        return restaurantHashMap.get(restaurantName);
    }


    public void deleteRestaurant() {

    }

    @Override
    public List<Restaurant> getAllRestaurantBasedOnItemList(List<Item> itemList) {

        List<Restaurant> restaurantsWithAllItems = new ArrayList<>();

        for(Restaurant restaurant : restaurantHashMap.values()){

            HashMap<FoodItem,Item> menuList = restaurant.getMenu();

            int countOfItemAvailable = 0;

            for(Item item : itemList){
                if(menuList.containsKey(item.getFoodItem())){
                    countOfItemAvailable+=1;
                }
            }

            if(countOfItemAvailable == itemList.size()){
                restaurantsWithAllItems.add(restaurant);
            }


        }

        return restaurantsWithAllItems;
    }
}
