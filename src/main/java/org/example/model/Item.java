package org.example.model;

import org.example.constant.FoodItem;

public class Item {

    FoodItem foodItem;
    Integer price;

    public Item(FoodItem foodItem, Integer price) {
        this.foodItem = foodItem;
        this.price = price;
    }

    public Item(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
