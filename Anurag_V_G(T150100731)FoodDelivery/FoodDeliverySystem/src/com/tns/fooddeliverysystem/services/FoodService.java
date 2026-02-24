package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Restaurant;
import java.util.ArrayList;
import java.util.List;

public class FoodService {
    private List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Restaurant getRestaurant(int restaurantId) {
        for (Restaurant r : restaurants) {
            if (r.getId() == restaurantId) return r;
        }
        return null;
    }

    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> allFoodItems = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            allFoodItems.addAll(restaurant.getMenu());
        }
        return allFoodItems;
    }

    public void addFoodItemToRestaurant(int restaurantId, FoodItem foodItem) {
        Restaurant restaurant = getRestaurant(restaurantId);
        if (restaurant != null) {
            restaurant.addFoodItem(foodItem);
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    public void removeFoodItemFromRestaurant(int restaurantId, int foodItemId) {
        Restaurant restaurant = getRestaurant(restaurantId);
        if (restaurant != null) {
            restaurant.removeFoodItem(foodItemId);
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    public FoodItem getFoodItemById(int foodItemId) {
        for (FoodItem item : getAllFoodItems()) {
            if (item.getId() == foodItemId) return item;
        }
        return null;
    }
}
