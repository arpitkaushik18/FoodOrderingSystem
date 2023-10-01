`Please Refer below section for feedback
Description: Implement an online food ordering system. Features:
1. This system has a tie-up with restaurants where each restaurant has a menu with all the
   items & their prices. Restaurants also have a rating out of 5.
2. Each restaurant has max #orders it can process at any given time. Beyond that, it
   shouldn’t be assigned any further orders until an ongoing order is completed.
3. Once an order is ACCEPTED, the restaurant can mark it as COMPLETED when the order is ready. This will free up the processing capacity of the restaurant. A restaurant can’t CANCEL an ACCEPTED order.
4. An order will be auto-assigned to a restaurant based on a selection strategy. Eg: Assign
   by lowest cost or best rating.
5. An order will be auto-assigned to a restaurant only if all the items in an order can be fulfilled by a single restaurant. Else the order will not be ACCEPTED.
   Requirement:
   Onboard a new restaurant with a menu.
   A customer should be able to place an order by giving items, respective quantities & selection strategy.
   Restaurants can mark ACCEPTED orders as COMPLETED. Orders once ACCEPTED can’t be CANCELLED by a restaurant.
   Order will be auto-assigned to a restaurant based on a selection strategy.
   Implement at least one restaurant selection strategy.
   A restaurant should be able to update its menu. For simplicity, a restaurant can't delete an item from the menu.
   Note: Do not use any database or NoSQL store, use an in-memory store.
   Expectation:
1. Make sure that you have working and demoable & functionally correct code.
2. Use proper abstractions, separation of concerns, proper entity modeling
3. Use appropriate design patterns wherever required.
4. The code should be modular, extensible, readable and unit-testable.
5. Proper exception handling is required.
6. Restaurant selection strategy must be pluggable
7. Concurrency handling (BONUS / Good to have)
8. Unit test cases (Bonus/ Good to have)

Assumptions:
Unique restaurant name
No need to create the user.
Sample test cases:
This is for illustration purposes only.
You can define your ways to take input.
You can use driver class or take input from console or you can write UT’s
1. Onboard Restaurants.

   ● R1
   “max_orders_that_can_be_processed_at_a_time” : 5, “Menu”: [Veg Biryani : Rs.100, Paneer Butter Masala: Rs.150],
   “rating”: 4.5/5

● R2
“max_orders_that_can_be_processed_at_a_time”: 5,
menu: [Paneer Butter Masala : Rs.175, Idli : Rs.10, Dosa : Rs.50, Veg Biryani : Rs. 80],
rating: 4/5

● R3
“max_orders_that_can_be_processed_at_a_time”: 1,
menu: [Gobi Manchurian : Rs.150, Idli : Rs.15, Paneer Butter Masala : Rs.175, Dosa: Rs.30 ],
rating: 4.9/5
2. Update restaurant menu

   ● ADD: {Restaurant_1, add, Chicken65, Rs.250}

   ● UPDATE: {Restaurant_2, update, Paneer Butter Masala, Rs.150}

3. Place Order
   Order1
   Input: { user: Ashwin, items: [ 3*Idli, 1*Dosa ], selection: Lowest cost }
   Output: Order assigned to R3

Order2.
Input: { user: Harish, items: [ 3*Idli, 1*Dosa ], selection: Lowest cost }
Output: Order assigned to R2 (Not R3 since it has reached its full capacity from Order1)
Order3:
Input: { user: Shruthi, items: [3*Veg Biryani], selection: ‘Highest rating’ }
Output: Order assigned to R1

4. Update Order Status:
   R3 marks Order1 as COMPLETED 
Order4:
   Input: { user: Harish, items: [ 3*Idli, 1*Dosa ], selection: Lowest cost }
   Output: Order assigned to R3 (since R3 has COMPLETED Order1)

Order5:
Input: {user: xyz, items: [1*Paneer Tikka, 1*Idli], selection: ‘Lowest cost}
Output: Order can’t be fulfilled (since none of the restaurants above serve Paneer Tikka) 