package org.example;

import org.example.dao.OrderServiceDaoImpl;
import org.example.dao.RestaurantManagerDaoImpl;
import org.example.constant.FoodItem;
import org.example.model.Item;
import org.example.model.Order;
import org.example.model.Restaurant;
import org.example.service.OrderService;
import org.example.service.OrderServiceImpl;
import org.example.service.RestaurantManager;
import org.example.service.RestaurantManagerImpl;
import org.example.service.strategy.CostBasedOrderAssignmentStrategy;
import org.example.service.strategy.RatingBasedOrderAssignmentStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */

//Onboard Restaurants.
//
//        ● R1 “max_orders_that_can_be_processed_at_a_time” : 5, “Menu”: [Veg Biryani : Rs.100, Paneer Butter Masala: Rs.150], “rating”: 4.5/5
//
//        ● R2 “max_orders_that_can_be_processed_at_a_time”: 5, menu: [Paneer Butter Masala : Rs.175, Idli : Rs.10, Dosa : Rs.50, Veg Biryani : Rs. 80], rating: 4/5
//
//        ● R3 “max_orders_that_can_be_processed_at_a_time”: 1, menu: [Gobi Manchurian : Rs.150, Idli : Rs.15, Paneer Butter Masala : Rs.175, Dosa: Rs.30 ], rating: 4.9/5
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        RestaurantManager restaurantManager = new RestaurantManagerImpl(new RestaurantManagerDaoImpl());

        HashMap<FoodItem,Item> menuList1 = new HashMap<>();
        menuList1.put(FoodItem.VEG_BRIYANI,new Item(FoodItem.VEG_BRIYANI,100));
        menuList1.put(FoodItem.PANEER_BUTTER_MASALA,new Item(FoodItem.PANEER_BUTTER_MASALA,150));
        Restaurant restaurant1 = new Restaurant("R1",5,menuList1,4.5);

        HashMap<FoodItem,Item> menuList2 = new HashMap<>();
        menuList2.put(FoodItem.VEG_BRIYANI,new Item(FoodItem.VEG_BRIYANI,80));
        menuList2.put(FoodItem.PANEER_BUTTER_MASALA,new Item(FoodItem.PANEER_BUTTER_MASALA,175));
        menuList2.put(FoodItem.IDLI,new Item(FoodItem.IDLI,10));
        menuList2.put(FoodItem.DOSA,new Item(FoodItem.DOSA,50));
        Restaurant restaurant2 = new Restaurant("R2",5,menuList2,4.0);

        HashMap<FoodItem,Item> menuList3 = new HashMap<>();
        menuList3.put(FoodItem.GOBI_MUNCHURIAN,new Item(FoodItem.GOBI_MUNCHURIAN,150));
        menuList3.put(FoodItem.PANEER_BUTTER_MASALA,new Item(FoodItem.PANEER_BUTTER_MASALA,175));
        menuList3.put(FoodItem.IDLI,new Item(FoodItem.IDLI,15));
        menuList3.put(FoodItem.DOSA,new Item(FoodItem.DOSA,30));
        Restaurant restaurant3 = new Restaurant("R3",1,menuList3,4.9);


        restaurantManager.onboardRestaurant(restaurant1);
        restaurantManager.onboardRestaurant(restaurant2);
        restaurantManager.onboardRestaurant(restaurant3);


        restaurantManager.updateRestaurantMenu("R1",new Item(FoodItem.CHICKEN65,250));
        restaurantManager.updateRestaurantMenu("R2",new Item(FoodItem.PANEER_BUTTER_MASALA,150));

        List<Item> itemList = new ArrayList<>();

        Item item1 = new Item(FoodItem.IDLI);
        Item item2 = new Item(FoodItem.DOSA);

        itemList.add(item1);
        itemList.add(item2);


        Order order = new Order("Ashwin",itemList);

        OrderService orderService = new OrderServiceImpl(new CostBasedOrderAssignmentStrategy(), new OrderServiceDaoImpl(), restaurantManager);
        OrderService orderService1 = new OrderServiceImpl(new RatingBasedOrderAssignmentStrategy(), new OrderServiceDaoImpl(), restaurantManager);

        orderService.placeOrder(order);




        Order order1 = new Order("Harish",itemList);
        orderService.placeOrder(order1);



        List<Item> itemList1 = new ArrayList<>();

        Item item3 = new Item(FoodItem.VEG_BRIYANI);

        itemList1.add(item3);

        Order order2 = new Order("Shruthi",itemList1);
        orderService1.placeOrder(order2);

        orderService.updateOrderStatus("R3",order.getOrderId());

        orderService.placeOrder(order1);

        List<Item> itemList2 = new ArrayList<>();

        Item item4 = new Item(FoodItem.PANEER_TIKKA);

        itemList2.add(item4);
        Order order3 = new Order("xyz",itemList2);
        orderService.placeOrder(order3);



    }
}
