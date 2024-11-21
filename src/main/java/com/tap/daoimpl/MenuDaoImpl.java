package com.tap.daoimpl;

import com.tap.dao.MenuDao;
import com.tap.model.Menu;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {
	
	private static Connection con;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<Menu> result;
	

	@Override
	public int insertMenu(Menu menu) {
	
		String sql = "INSERT INTO menu (restuarant_id, item_name, description, price, isAvailable,img_path) VALUES (?,?, ?, ?, ?, ?)";
		int rowseffected=1;
        try {
        	pstmt=con.prepareStatement(sql);
        	
        	
            pstmt.setInt(1, menu.getRestuarant_id());
            pstmt.setString(2, menu.getItem_name());
            pstmt.setString(3, menu.getDescription());
            pstmt.setFloat(4, menu.getPrice());
            pstmt.setString(5, menu.getIsAvailable());
            pstmt.setString(6, menu.getImg_path());
            rowseffected=pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowseffected; 
	}

	@Override
	public List<Menu> getAllMenu(int restuarant_id) {
	    String sql = "SELECT * FROM menu WHERE restuarant_id = ?";
	    List<Menu> menus = new ArrayList<>();
	    try {
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, restuarant_id);
	        rs = pstmt.executeQuery();

	        // Debugging: Check if the query returns any results
	        if (!rs.next()) {
	            System.out.println("No menu items found for restaurant_id: " + restuarant_id);
	        } else {
	            do {
	                Menu menu = new Menu();
	                menu.setMenu_id(rs.getInt("menu_id"));
	                menu.setRestuarant_id(rs.getInt("restuarant_id"));
	                menu.setItem_name(rs.getString("item_name"));
	                menu.setDescription(rs.getString("description"));
	                menu.setPrice(rs.getFloat("price"));
	                menu.setIsAvailable(rs.getString("isAvailable"));
	                menu.setImg_path(rs.getString("img_path"));
	               
	                menus.add(menu);
	            } while (rs.next());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close();
	            if (rs != null) rs.close();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }

	    // Return the list of menus
	    return menus;
	}


	@Override
	public Menu getMenuById(int menu_id) {
		String sql = "SELECT * FROM menu WHERE menu_id = ?";
	    Menu menu = null;
	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        	ps.setInt(1, menu_id);
	        	ResultSet rs = ps.executeQuery();
	        	if (rs.next()) {
	                menu = new Menu();
	                menu.setMenu_id(rs.getInt("menu_id"));
	                menu.setRestuarant_id(rs.getInt("restuarant_id"));
	                menu.setItem_name(rs.getString("item_name"));
	                menu.setDescription(rs.getString("description"));
	                menu.setPrice(rs.getFloat("price"));
	                menu.setIsAvailable(rs.getString("isAvailable"));
	                menu.setImg_path(rs.getString("img_path"));
	                    
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return menu;
	}
	

	@Override
	public int deleteMenuById(int restuarant_id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM menu WHERE menu_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, restuarant_id);
            return ps.executeUpdate(); // Return number of rows deleted
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
	public int updateMenuById(int menu_id, String isAvailable) {
		String sql = "UPDATE menu SET isAvailable = ? WHERE menu_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, isAvailable);
            ps.setInt(2, menu_id);
            return ps.executeUpdate(); // Return number of rows updated
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

    
}
