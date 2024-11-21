
package com.tap.main;

import com.tap.dao.OrderDao;
import com.tap.daoimpl.OrderDaoImpl;
import com.tap.model.Orders;

import java.util.List;
import java.util.Scanner;

public class OrderMain {

    public static void main(String[] args) {

        OrderDao orderDao = new OrderDaoImpl();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            // Display the menu
            System.out.println("\n--- Order Management Menu ---");
            System.out.println("1. Insert a new order");
            System.out.println("2. View all orders");
            System.out.println("3. View an order by ID");
            System.out.println("4. Delete an order by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            // Get the user's choice
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Insert a new order
                    System.out.println("\n--- Insert New Order ---");
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter restuarant ID: ");
                    int restuarantId = scanner.nextInt();
                    System.out.print("Enter total amount: ");
                    float totalAmount = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    System.out.print("Enter payment method: ");
                    String payMethod = scanner.nextLine();
                    
                    Orders newOrder = new Orders(userId, restuarantId, totalAmount, status, payMethod);
                    int insertResult = orderDao.insertOrder(newOrder);
                    
                    if (insertResult > 0) {
                        System.out.println("Order inserted successfully!");
                    } else {
                        System.out.println("Failed to insert order.");
                    }
                    break;

                case 2:
                    // View all orders
                    System.out.println("\n--- All Orders ---");
                    List<Orders> ordersList = orderDao.getAllOrders();
                    if (!ordersList.isEmpty()) {
                        for (Orders order : ordersList) {
                            System.out.println(order);
                        }
                    } else {
                        System.out.println("No orders found.");
                    }
                    break;

                case 3:
                    // View order by ID
                    System.out.print("\nEnter order ID to view: ");
                    int orderIdToView = scanner.nextInt();
                    Orders retrievedOrder = orderDao.getOrderById(orderIdToView);
                    
                    if (retrievedOrder != null) {
                        System.out.println("Order details: " + retrievedOrder);
                    } else {
                        System.out.println("Order with ID " + orderIdToView + " not found.");
                    }
                    break;

                case 4:
                    // Delete order by ID
                    System.out.print("\nEnter order ID to delete: ");
                    int orderIdToDelete = scanner.nextInt();
                    int deleteResult = orderDao.deleteOrderById(orderIdToDelete);
                    
                    if (deleteResult > 0) {
                        System.out.println("Order with ID " + orderIdToDelete + " deleted successfully.");
                    } else {
                        System.out.println("Failed to delete order with ID " + orderIdToDelete + ".");
                    }
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
