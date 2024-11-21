package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemDao;
import com.tap.model.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao {

    // Database connection details (change these as per your actual database credentials)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/online_food_delivery";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345";

    // Insert OrderItem
    @Override
    public int insertOrderItems(OrderItem orderItem) {
        String query = "INSERT INTO orderitem (order_id, menu_id, quantity, sub_total) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameters for the prepared statement
            statement.setInt(1, orderItem.getOrder_id());
            statement.setInt(2, orderItem.getMenu_id());
            statement.setInt(3, orderItem.getQuantity());
            statement.setDouble(4, orderItem.getSub_total());

            // Execute update and get affected rows
            int affectedRows = statement.executeUpdate();

            return affectedRows;

        } catch (SQLException e) {
            // Log the exception with more context for better debugging
            System.err.println("Error inserting order item: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }


    // Get all OrderItems
    @Override
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();
        String query = "SELECT * FROM orderitem";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int orderitem_id = resultSet.getInt("orderitem_id");
                int order_id = resultSet.getInt("order_id");
                int menu_id = resultSet.getInt("menu_id");
                int quantity = resultSet.getInt("quantity");
                double sub_total = resultSet.getDouble("sub_total");

                OrderItem orderItem = new OrderItem(orderitem_id, order_id, menu_id, quantity, sub_total);
                orderItems.add(orderItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItems;
    }

    // Get OrderItem by order_id
    @Override
    public OrderItem getOrderItemById(int order_id) {
        String query = "SELECT * FROM orderitem WHERE order_id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, order_id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int orderitem_id = resultSet.getInt("orderitem_id");
                int menu_id = resultSet.getInt("menu_id");
                int quantity = resultSet.getInt("quantity");
                double sub_total = resultSet.getDouble("sub_total");

                return new OrderItem(orderitem_id, order_id, menu_id, quantity, sub_total);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // return null if no record is found
    }

    // Fetch OrderItems by order_id
    @Override
    public List<OrderItem> fetchOrdersItems(int order_id) {
        List<OrderItem> orderItems = new ArrayList<>();
        String query = "SELECT * FROM orderitem WHERE order_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, order_id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderitem_id = resultSet.getInt("orderitem_id");
                int menu_id = resultSet.getInt("menu_id");
                int quantity = resultSet.getInt("quantity");
                double sub_total = resultSet.getDouble("sub_total");

                OrderItem orderItem = new OrderItem(orderitem_id, order_id, menu_id, quantity, sub_total);
                orderItems.add(orderItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItems;
    }
}
