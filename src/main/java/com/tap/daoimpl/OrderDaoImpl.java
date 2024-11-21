
package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.tap.dao.OrderDao;
import com.tap.dbutils.DBUtils;
import com.tap.model.Orders;
 // Assuming a utility class for managing DB connections

public class OrderDaoImpl implements OrderDao {

    // SQL Queries (modify according to your database schema)
    private static final String INSERT_ORDER = "INSERT INTO orders (user_id, restuarant_id, total_amount, status, paymethod) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private static final String DELETE_ORDER_BY_ID = "DELETE FROM orders WHERE order_id = ?";
    private static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE order_id = ?";

    
    @Override
    public int insertOrder(Orders order) {
        int orderId = 0;
        try (Connection con = DBUtils.myConnect();
             PreparedStatement pstmt = con.prepareStatement(INSERT_ORDER, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            // Set order parameters
            pstmt.setInt(1, order.getUser_id()); // user_id
            pstmt.setInt(2, order.getRestuarant_id()); // restaurant_id
            pstmt.setDouble(3, order.getTotal_amount()); // total_amount
            pstmt.setString(4, order.getStatus()); // status
            pstmt.setString(5, order.getPaymethod()); // paymethod
            
            // Execute the insert
            int affectedRows = pstmt.executeUpdate();
            
            // Retrieve the generated order_id
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        orderId = generatedKeys.getInt(1); // Get the generated order_id
                        System.out.println("Order inserted successfully with order_id: " + orderId);
                    }
                } catch (SQLException e) {
                    System.err.println("Error retrieving generated key: " + e.getMessage());
                }
            } else {
                System.err.println("Failed to insert order.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId; // Returns the generated order_id or 0 if not successful
    }

    @Override
    public List<Orders> getAllOrders() {
        List<Orders> ordersList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345"); 
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_ORDERS); 
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Orders order = new Orders();
                order.setOrder_id(rs.getInt("order_id"));
                order.setUser_id(rs.getInt("user_id"));
                order.setRestuarant_id(rs.getInt("restuarant_id"));
                order.setTotal_amount(rs.getFloat("total_amount"));
                order.setStatus(rs.getString("status"));
                order.setPaymethod(rs.getString("paymethod"));
                ordersList.add(order); // Add each order to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    @Override
    public int deleteOrderById(int order_id) {
        int result = 0;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345"); 
             PreparedStatement ps = conn.prepareStatement(DELETE_ORDER_BY_ID)) {

            ps.setInt(1, order_id);
            result = ps.executeUpdate(); // Execute the query and get the result
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result; // Returns the number of rows affected (1 if successful, 0 if not found)
    }

    @Override
    public Orders getOrderById(int order_id) {
        Orders order = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345"); 
             PreparedStatement ps = conn.prepareStatement(SELECT_ORDER_BY_ID)) {

            ps.setInt(1, order_id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    order = new Orders();
                    order.setOrder_id(rs.getInt("order_id"));
                    order.setUser_id(rs.getInt("user_id"));
                    order.setRestuarant_id(rs.getInt("restuarant_id"));
                    order.setTotal_amount(rs.getFloat("total_amount"));
                    order.setStatus(rs.getString("status"));
                    order.setPaymethod(rs.getString("paymethod"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order; // Returns the order object if found, or null if not found
    }


	
}
