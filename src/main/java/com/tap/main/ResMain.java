package com.tap.main;

import java.util.List;
import java.util.Scanner;

import com.tap.dao.ResDao;
import com.tap.daoimpl.ResDaoImpl;
import com.tap.model.Restuarant;

public class ResMain {

    public static void main(String[] args) {
        ResDao resDao = new ResDaoImpl();  // Create an instance of the DAO implementation
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Restaurant Management ---");
            System.out.println("1. Add new Restaurant");
            System.out.println("2. View all Restaurants");
            System.out.println("3. Get Restaurant by ID");
            System.out.println("4. Delete Restaurant by ID");
            System.out.println("5. Update Restaurant's Active Status");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
            case 1:
                // Add a new restaurant
                System.out.print("Enter restaurant name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter cuisine type: ");
                String cuisineType = scanner.nextLine();
                
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                
                System.out.print("Enter admin ID: ");
                int adminId = scanner.nextInt();
                
                System.out.print("Enter rating (0 to 5): ");
                float rating = scanner.nextFloat();
                
                System.out.print("Is the restaurant active? (1 for Yes, 0 for No): ");
                int isActive = scanner.nextInt();
                scanner.nextLine();// consume newline
                System.out.print("Enter your image path: ");

                String img_path=scanner.nextLine();
                

                Restuarant newRestuarant = new Restuarant();
                newRestuarant.setResName(name);
                newRestuarant.setCuisinetype(cuisineType);
                newRestuarant.setAddress(address);
                newRestuarant.setAdmin_id(adminId);
                newRestuarant.setRating(rating);
                newRestuarant.setIsActive(isActive);
                newRestuarant.setImg_path(img_path);
                
                
                

                int insertResult = resDao.insertRestuarant(newRestuarant);
                System.out.println(insertResult > 0 ? "Restaurant added successfully!" : "Failed to add restaurant.");
                break;

                case 2: // View all Restaurants
                    List<Restuarant> restuarantList = resDao.getAllResu();
                    if (!restuarantList.isEmpty()) {
                        for (Restuarant r : restuarantList) {
                            System.out.println(r);
                        }
                    } else {
                        System.out.println("No restaurants found.");
                    }
                    break;

                case 3: // Get Restaurant by ID
                    System.out.print("Enter Restaurant ID: ");
                    int id = scanner.nextInt();
                    Restuarant restuarant = resDao.getResById(id);
                    if (restuarant != null) {
                        System.out.println(restuarant);
                    } else {
                        System.out.println("Restaurant not found.");
                    }
                    break;

                case 4: // Delete Restaurant by ID
                    System.out.print("Enter Restaurant ID to delete: ");
                    int deleteId = scanner.nextInt();
                    int deleteResult = resDao.deleteResById(deleteId);
                    if (deleteResult > 0) {
                        System.out.println("Restaurant deleted successfully.");
                    } else {
                        System.out.println("Failed to delete restaurant.");
                    }
                    break;

                case 5: // Update Restaurant Active Status by ID
                    System.out.print("Enter Restaurant ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new Active Status (1 = Active, 0 = Inactive): ");
                    int newStatus = scanner.nextInt();
                    int updateResult = resDao.updateResById(updateId, newStatus);
                    if (updateResult > 0) {
                        System.out.println("Restaurant status updated successfully.");
                    } else {
                        System.out.println("Failed to update status.");
                    }
                    break;

                case 6: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

