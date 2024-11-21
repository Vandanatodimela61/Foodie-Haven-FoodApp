package com.tap.main;

import com.tap.dao.userDao;
import com.tap.daoimpl.userDaoImpl;
import com.tap.model.User;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        userDao userDao = new userDaoImpl();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("=== User Management System ===");
            System.out.println("1. Add New User");
            System.out.println("2. View All Users");
            System.out.println("3. Get User by ID");
            System.out.println("4. Delete User by ID");
            System.out.println("5. Update User Address");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Add New User
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Role (e.g., 'admin', 'customer'): ");
                    String role = scanner.nextLine();

                    User newUser = new User(username, password, email, address, role);
                    int insertResult = userDao.insertUser(newUser);
                    if (insertResult > 0) {
                        System.out.println("User added successfully.");
                    } else {
                        System.out.println("Failed to add user.");
                    }
                    break;

                case 2: // View All Users
                    List<User> userList = userDao.getAlluserData();
                    System.out.println("User List:");
                    for (User user : userList) {
                        System.out.println(user);
                    }
                    break;

                case 3: // Get User by ID
                    System.out.print("Enter User ID: ");
                    String email1 = scanner.nextLine();
                    User userByEmail = userDao.getUser(email1);
                    if (userByEmail != null) {
                        System.out.println("User found: " +userByEmail);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4: // Delete User by ID
                    System.out.print("Enter User ID to delete: ");
                    int deleteId = scanner.nextInt();
                    int deleteResult = userDao.deleteUserById(deleteId);
                    if (deleteResult > 0) {
                        System.out.println("User deleted successfully.");
                    } else {
                        System.out.println("Failed to delete user.");
                    }
                    break;

                case 5: // Update User Address
                    System.out.print("Enter User Name to update: ");
                    String updatePassword = scanner.nextLine();
                    System.out.print("Enter new user_id: ");
                    int newId = scanner.nextInt();
                    int updateResult = userDao.updateUserById(updatePassword, newId);
                    if (updateResult > 0) {
                        System.out.println("User address updated successfully.");
                    } else {
                        System.out.println("Failed to update user address.");
                    }
                    break;

                case 6: // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return; // Exit the main method

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
