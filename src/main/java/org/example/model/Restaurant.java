package org.example.model;

import org.example.constant.FoodItem;

import java.util.HashMap;

public class Restaurant {

    String restaurantName;
    Integer maxOrderCanProcess;

    HashMap<FoodItem,Item> menu;

    Double rating;


    public Restaurant(String restaurantName, Integer maxOrderCanProcess, HashMap<FoodItem, Item> menu, Double rating) {
        this.restaurantName = restaurantName;
        this.maxOrderCanProcess = maxOrderCanProcess;
        this.menu = menu;
        this.rating = rating;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getMaxOrderCanProcess() {
        return maxOrderCanProcess;
    }

    public void setMaxOrderCanProcess(Integer maxOrderCanProcess) {
        this.maxOrderCanProcess = maxOrderCanProcess;
    }

    public HashMap<FoodItem, Item> getMenu() {
        return menu;
    }

    public void setMenu(HashMap<FoodItem, Item> menu) {
        this.menu = menu;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
