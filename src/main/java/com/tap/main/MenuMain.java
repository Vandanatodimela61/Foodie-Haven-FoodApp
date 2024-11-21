package com.tap.main;

import com.tap.daoimpl.MenuDaoImpl;
import com.tap.model.Menu;
import com.tap.model.Restuarant;

import java.util.List;
import java.util.Scanner;

import com.tap.dao.MenuDao;

public class MenuMain {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuDao menuDao = new MenuDaoImpl();
		Scanner sc=new Scanner(System.in);

        while(true) {
        	System.out.println("\n--- Menu Management ---");
            System.out.println("1. Add new menu");
            System.out.println("2. View all menus");
            System.out.println("3. Get menu by MenuID");
            System.out.println("5. Delete menu by MenuID");
            System.out.println("4. Update menu's Active Status");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch(choice) {
            	case 1:
            		Menu menu=new Menu();
            		
                    
                    System.out.println("Enter the restuarant_id:");
                    menu.setRestuarant_id(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter the item_name:");
                    menu.setItem_name(sc.nextLine());
                    System.out.println("Enter the  description:");
                    menu.setDescription(sc.nextLine());
                    System.out.println("Enter the price:");
                    float price=sc.nextFloat();
                    System.out.println("Enter it is available:");
                    String isAvailable=sc.nextLine();
                    System.out.println("Enter the Image Path:");
                    String img_path=sc.nextLine();
                    int result=menuDao.insertMenu(menu);
                    sc.nextLine();
                    if(result>0) {
                    		System.out.print(result+"Successfully inserted");
                    
                    } else {
                    		System.out.print("inserted falied");
                            
                    		
                    }
                    break;
            	case 2:
            		System.out.print("Enter Restuarant ID: ");
            		int id=sc.nextInt();
            		List<Menu> menus = menuDao.getAllMenu(id);
                    if (menus !=null) {
                        for (Menu m : menus) {
                            System.out.println(m);
                        }
                    } else {
                        System.out.println("No menus found.");
                    }
                    break; 
            	case 3:
            		System.out.print("Enter Menu ID: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new Active Status (Yes = Active, No = Inactive): ");
                    String newStatus = sc.nextLine();
                    int updateResult = menuDao.updateMenuById(updateId, newStatus);
                    if (updateResult > 0) {
                        System.out.println("Menu status updated successfully.");
                    } else {
                        System.out.println("Failed to update status.");
                    }
                    break;
            	case 4:
            		System.out.print("Enter Menu ID: ");
                    int id2 = sc.nextInt();
                    Menu menus1 = menuDao.getMenuById(id2);
                    if (menus1 != null) {
                        System.out.println(menus1);
                    } else {
                        System.out.println("Menu not found.");
                    }
                    break;
            	case 5:
            		System.out.print("Enter Restuarant ID to delete: ");
                    int deleteId = sc.nextInt();
                    int deleteResult = menuDao.deleteMenuById(deleteId);
                    if (deleteResult > 0) {
                        System.out.println("Restaurant deleted successfully.");
                    } else {
                        System.out.println("Failed to delete menu.");
                    }
                    break;
            	case 6: // Exit
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            	}
                    
            	
            	
                    
            		
            }
        }
       
		
        
        
        
        /*List<Menu> allMenus = menuDao.getAllMenu();
        for (Menu menu : allMenus) {
            System.out.println(menu);
        }*/

        // Get a menu item by ID
        /*Menu menu=menuDao.getMenuById(1);
        if (menu != null) {
            System.out.println("Retrieved Menu: " + menu);
        } else {
            System.out.println("Menu not found.");
        }*/
        
        /*int updatedRows = menuDao.updateMenuById(1, "No");
        System.out.println("Updated rows for menu availability: " + updatedRows);*/

        // Delete a menu item by ID
        /*int deletedRows = menuDao.deleteMenuById(1);
        System.out.println("Deleted rows for menu: " + deletedRows);*/

}
	


