package com.tap.main;

import com.tap.daoimpl.OrderItemDaoImpl;
import com.tap.model.OrderItem;

import java.util.List;
import java.util.Scanner;

public class OrderItemMain {
    public static void main(String[] args) {
        // Create an instance of OrderItemDaoImpl
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

        // Create a scanner object to take input from user
        Scanner scanner = new Scanner(System.in);

        // Input order item details from the user
        System.out.println("Enter order item details:");

        // Taking user input for the order item
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        
        System.out.print("Enter Menu ID: ");
        int menuId = scanner.nextInt();
        
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Enter Sub Total: ");
        float subTotal = scanner.nextFloat();

        // Create an OrderItem object using the user inputs
        OrderItem newOrderItem = new OrderItem(orderId, menuId, quantity, subTotal);

        // Insert the new order item into the database
        int result = orderItemDao.insertOrderItems(newOrderItem);

        if (result > 0) {
            System.out.println("Order item inserted successfully!");
            System.out.println("Inserted OrderItem: " + newOrderItem);
        } else {
            System.out.println("Failed to insert order item.");
        }

        // Fetch all order items
        System.out.println("\nFetching all order items:");
        List<OrderItem> allOrderItems = orderItemDao.getAllOrderItems();
        if (allOrderItems.isEmpty()) {
            System.out.println("No order items found.");
        } else {
            for (OrderItem orderItem : allOrderItems) {
                System.out.println(orderItem);
            }
        }

        // Fetch order item by order_id
        System.out.print("\nEnter the order ID to fetch the order item: ");
        int orderIdToFetch = scanner.nextInt();

        System.out.println("Fetching order item by order_id = " + orderIdToFetch + ":");
        OrderItem orderItemById = orderItemDao.getOrderItemById(orderIdToFetch);
        if (orderItemById != null) {
            System.out.println(orderItemById);
        } else {
            System.out.println("No order item found with order_id = " + orderIdToFetch);
        }

        // Fetch order items by a specific order_id (e.g., 1)
        System.out.print("\nEnter the order ID to fetch all order items for that order: ");
        int orderItemsForOrderId = scanner.nextInt();

        System.out.println("\nFetching all order items for order_id = " + orderItemsForOrderId + ":");
        List<OrderItem> orderItemsForOrder = orderItemDao.fetchOrdersItems(orderItemsForOrderId);
        if (orderItemsForOrder.isEmpty()) {
            System.out.println("No order items found for order_id = " + orderItemsForOrderId);
        } else {
            for (OrderItem orderItem : orderItemsForOrder) {
                System.out.println(orderItem);
            }
        }

        // Close scanner
        scanner.close();
    }
}
