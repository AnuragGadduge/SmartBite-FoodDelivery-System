package com.tns.fooddeliverysystem.application;

import com.tns.fooddeliverysystem.entities.*;
import com.tns.fooddeliverysystem.services.*;

import java.util.Scanner;

public class FoodDeliverySystem {

    static CustomerService customerService = new CustomerService();
    static FoodService foodService = new FoodService();
    static OrderService orderService = new OrderService();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("   Welcome to SmartBite Delivery  ");
        System.out.println("==================================");

        int choice;

        do {
            System.out.println("\n1. Admin Panel");
            System.out.println("2. Customer Panel");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> adminMenu();
                case 2 -> customerMenu();
                case 3 -> System.out.println("Thank you for using SmartBite!");
                default -> System.out.println("Invalid option!");
            }

        } while (choice != 3);
    }

    static void adminMenu() {

        int choice;

        do {
            System.out.println("\n---- ADMIN PANEL ----");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item");
            System.out.println("3. View Restaurants");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Restaurant ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Restaurant Name: ");
                    String name = scanner.nextLine();
                    foodService.addRestaurant(new Restaurant(id, name));
                    System.out.println("Restaurant added successfully!");
                }

                case 2 -> {
                    System.out.print("Restaurant ID: ");
                    int rId = scanner.nextInt();
                    System.out.print("Food ID: ");
                    int fId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Food Name: ");
                    String fName = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    foodService.addFoodItemToRestaurant(rId, new FoodItem(fId, fName, price));
                    System.out.println("Food item added successfully!");
                }

                case 3 -> {
                    System.out.println("\n--- Restaurants ---");
                    if (foodService.getRestaurants().isEmpty()) {
                        System.out.println("No restaurants available.");
                    } else {
                        for (Restaurant r : foodService.getRestaurants()) {
                            System.out.println(r);
                        }
                    }
                }

                case 4 -> {
                    System.out.println("\n--- Orders ---");
                    if (orderService.getOrders().isEmpty()) {
                        System.out.println("No orders placed yet.");
                    } else {
                        for (Order o : orderService.getOrders()) {
                            System.out.println(o);
                        }
                    }
                }

                case 5 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid option!");
            }

        } while (choice != 5);
    }

    static void customerMenu() {

        int choice;

        do {
            System.out.println("\n---- CUSTOMER PANEL ----");
            System.out.println("1. Add Customer");
            System.out.println("2. View Restaurants");
            System.out.println("3. Add to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("User ID: ");
                    int uid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Contact: ");
                    long contact = scanner.nextLong();
                    scanner.nextLine();
                    customerService.addCustomer(new Customer(uid, name, contact));
                    System.out.println("Customer added successfully!");
                }

                case 2 -> {
                    System.out.println("\n--- Restaurants ---");
                    if (foodService.getRestaurants().isEmpty()) {
                        System.out.println("No restaurants available.");
                    } else {
                        for (Restaurant r : foodService.getRestaurants()) {
                            System.out.println(r);
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Customer ID: ");
                    int cId = scanner.nextInt();
                    System.out.print("Restaurant ID: ");
                    int rId = scanner.nextInt();
                    System.out.print("Food ID: ");
                    int fId = scanner.nextInt();
                    System.out.print("Quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();

                    Customer customer = customerService.getCustomer(cId);
                    Restaurant restaurant = foodService.getRestaurant(rId);

                    if (customer == null || restaurant == null) {
                        System.out.println("Invalid Customer or Restaurant.");
                        break;
                    }

                    FoodItem selected = null;
                    for (FoodItem item : restaurant.getMenu()) {
                        if (item.getId() == fId) {
                            selected = item;
                            break;
                        }
                    }

                    if (selected == null) {
                        System.out.println("Food item not found.");
                        break;
                    }

                    customer.getCart().addItem(selected, qty);
                    System.out.println("Item added to cart!");
                }

                case 4 -> {
                    System.out.print("Customer ID: ");
                    int cId = scanner.nextInt();
                    scanner.nextLine();
                    Customer customer = customerService.getCustomer(cId);

                    if (customer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }

                    System.out.println(customer.getCart());
                }

                case 5 -> {
                    System.out.print("Customer ID: ");
                    int cId = scanner.nextInt();
                    scanner.nextLine();
                    Customer customer = customerService.getCustomer(cId);

                    if (customer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }

                    if (customer.getCart().getItems().isEmpty()) {
                        System.out.println("Cart is empty!");
                        break;
                    }

                    int orderId = orderService.getNextOrderId();
                    Order order = new Order(orderId, customer);
                    orderService.placeOrder(order);
                    customer.getCart().clearCart();

                    System.out.println("Order placed successfully! Order ID: " + orderId);
                }

                case 6 -> {
                    System.out.println("\n--- Orders ---");
                    if (orderService.getOrders().isEmpty()) {
                        System.out.println("No orders placed yet.");
                    } else {
                        for (Order o : orderService.getOrders()) {
                            System.out.println(o);
                        }
                    }
                }

                case 7 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid option!");
            }

        } while (choice != 7);
    }
}