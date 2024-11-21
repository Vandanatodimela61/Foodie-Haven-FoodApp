package com.tap.daoimpl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tap.dao.ResDao;
import com.tap.model.Restuarant;

public class ResDaoImpl implements ResDao {

	@Override
	public int insertRestuarant(Restuarant Restuarant) {
	    String query = "INSERT INTO restuarant (Resname, cuisinetype, address, admin_id, rating, isActive, img_path) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345");
	         PreparedStatement pstmt = conn.prepareStatement(query)) {
	        
	        pstmt.setString(1, Restuarant.getResName());
	        pstmt.setString(2, Restuarant.getCuisinetype());
	        pstmt.setInt(2, Restuarant.getDeliverytimel());
	        pstmt.setString(3, Restuarant.getAddress());
	        pstmt.setInt(4, Restuarant.getAdmin_id());
	        pstmt.setFloat(5, Restuarant.getRating());
	        pstmt.setInt(6, Restuarant.getIsActive());
	        
	        // Assuming the img_path field holds the relative path like "images/image1.jpg"
	        pstmt.setString(7, Restuarant.getImg_path());
	        
	        return pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 1;
	}


	@Override
	public List<Restuarant> getAllResu() {
	    List<Restuarant> restuarantList = new ArrayList<>();
	    String query = "SELECT * FROM restuarant";
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345");
	         PreparedStatement stmt = conn.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {
	        
	        while (rs.next()) {
	            Restuarant restuarant = new Restuarant();
	            restuarant.setRestuarant_id(rs.getInt("restuarant_id"));
	            restuarant.setResName(rs.getString("Resname"));
	            restuarant.setCuisinetype(rs.getString("cuisinetype"));
	            restuarant.setDeliverytimel(rs.getInt("deliverytimel"));
	            restuarant.setAddress(rs.getString("address"));
	            restuarant.setAdmin_id(rs.getInt("admin_id"));
	            restuarant.setRating(rs.getFloat("rating"));
	            restuarant.setIsActive(rs.getInt("isActive"));
	            
	            // Ensure the image path is retrieved correctly from the database
	            restuarant.setImg_path(rs.getString("img_path"));  // Get the img_path column value
	            
	            restuarantList.add(restuarant);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return restuarantList;
	}

	@Override
	public Restuarant getResById(int restuarant_id) {
	    String query = "SELECT * FROM restuarant WHERE restuarant_id = ?";
	    Restuarant restuarant = null;
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345");
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        
	        stmt.setInt(1, restuarant_id);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            restuarant = new Restuarant();
	            restuarant.setRestuarant_id(rs.getInt("restuarant_id"));
	            restuarant.setResName(rs.getString("Resname"));
	            restuarant.setCuisinetype(rs.getString("cuisinetype"));
	            restuarant.setDeliverytimel(rs.getInt("deliverytimel"));
	            restuarant.setAddress(rs.getString("address"));
	            restuarant.setAdmin_id(rs.getInt("admin_id"));
	            restuarant.setRating(rs.getFloat("rating"));
	            restuarant.setIsActive(rs.getInt("isActive"));
	            
	            // Set the img_path from the database
	            restuarant.setImg_path(rs.getString("img_path"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return restuarant;
	}

	@Override
	public int deleteResById(int restuarant_id) {
		String query = "DELETE FROM restuarant WHERE restuarant_id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, restuarant_id);
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
	}

	@Override
	public int updateResById(int restuarant_id, int isActive) {
		String query = "UPDATE restuarant SET isActive = ? WHERE restuarant_id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, isActive);
            stmt.setInt(2, restuarant_id);
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
	}

}
