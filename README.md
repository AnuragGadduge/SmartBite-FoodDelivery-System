# 🍔 SmartBite - Food Delivery System

SmartBite is a console-based Food Delivery System built using Core Java.  
It simulates how a real-world food ordering platform works with Admin and Customer modules.

---

## 🚀 Features

### 👨‍💼 Admin Panel
- Add Restaurant
- Add Food Item to Restaurant
- View Restaurants & Menu
- View Orders
- Add Delivery Person
- Assign Delivery Person to Order

### 👤 Customer Panel
- Register Customer
- View Restaurants & Menu
- Add Food to Cart
- View Cart with Total Cost
- Place Order
- View Order History

---

## 🧠 Concepts Used

- OOP (Encapsulation, Inheritance, Polymorphism)
- Java Collections (ArrayList, HashMap)
- Package Structure
- Method Overriding
- StringBuilder
- Scanner (User Input Handling)

---

## 🏗 Project Structure

```
src/
 └── com/tns/fooddeliverysystem/
     ├── application/
     │     └── FoodDeliverySystem.java
     ├── entities/
     │     ├── User.java
     │     ├── Customer.java
     │     ├── Restaurant.java
     │     ├── FoodItem.java
     │     ├── Cart.java
     │     ├── Order.java
     │     └── DeliveryPerson.java
     └── services/
           ├── CustomerService.java
           ├── FoodService.java
           └── OrderService.java
```

---

## ▶️ How To Run

### Compile
```
javac -d bin src/com/tns/fooddeliverysystem/**/*.java
```

### Run
```
java -cp bin com.tns.fooddeliverysystem.application.FoodDeliverySystem
```

---

## 📌 Sample Flow

1. Admin adds restaurant
2. Admin adds food items
3. Customer registers
4. Customer adds items to cart
5. Customer places order
6. Admin assigns delivery person

---

## 🎯 Future Improvements

- Login Authentication
- Database Integration
- Payment Gateway
- GUI using JavaFX

---

## 👨‍💻 Developed By
Anurag V G  
T150100731  
SmartBite - Food Delivery System
