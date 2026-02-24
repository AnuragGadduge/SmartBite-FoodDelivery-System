package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private List<DeliveryPerson> deliveryPersons = new ArrayList<>();
    private int orderCounter = 1;

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public int getNextOrderId() {
        return orderCounter++;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrder(int orderId) {
        for (Order o : orders) {
            if (o.getOrderId() == orderId) return o;
        }
        return null;
    }

    public void addDeliveryPerson(DeliveryPerson deliveryPerson) {
        deliveryPersons.add(deliveryPerson);
    }

    public List<DeliveryPerson> getDeliveryPersons() {
        return deliveryPersons;
    }

    public DeliveryPerson getDeliveryPerson(int deliveryPersonId) {
        for (DeliveryPerson dp : deliveryPersons) {
            if (dp.getDeliveryPersonId() == deliveryPersonId) return dp;
        }
        return null;
    }

    public void assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
        Order order = getOrder(orderId);
        DeliveryPerson dp = getDeliveryPerson(deliveryPersonId);
        if (order != null && dp != null) {
            order.setDeliveryPerson(dp);
            System.out.println("Delivery person assigned to order successfully!");
        } else {
            System.out.println("Order or Delivery Person not found.");
        }
    }
}
