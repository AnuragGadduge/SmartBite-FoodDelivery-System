package com.tns.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private List<FoodItem> menu;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<FoodItem> getMenu() { return menu; }

    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    public void removeFoodItem(int foodItemId) {
        menu.removeIf(item -> item.getId() == foodItemId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Restaurant ID: " + id + ", Name: " + name + "\n");
        for (FoodItem item : menu) {
            sb.append("  - Food Item ID: ").append(item.getId())
              .append(", Name: ").append(item.getName())
              .append(", Price: Rs. ").append(item.getPrice()).append("\n");
        }
        return sb.toString();
    }
}
