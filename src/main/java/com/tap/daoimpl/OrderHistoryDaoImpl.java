package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderHistoryDao;
import com.tap.dbutils.DBUtils;
import com.tap.model.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDao {

    @Override
    public int insertOrderHistory(OrderHistory orderHistory) {
        String sql = "INSERT INTO orderhistory (user_id, order_id, totalamount, status, date) VALUES (?, ?, ?, ?, ?)";
        int result = 0;

        try (Connection connection = DBUtils.myConnect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, orderHistory.getUserId());
            statement.setInt(2, orderHistory.getOrderId());
            statement.setInt(3, orderHistory.getTotalAmount());
            statement.setString(4, orderHistory.getStatus());
            statement.setTimestamp(5, orderHistory.getDate() != null ? orderHistory.getDate() : new Timestamp(System.currentTimeMillis()));

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<OrderHistory> fetchOrderHistoryByUserId(int userId) {
        String sql = "SELECT * FROM orderhistory WHERE user_id = ?";
        List<OrderHistory> orderHistoryList = new ArrayList<>();

        try (Connection connection = DBUtils.myConnect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderHistoryId = resultSet.getInt("orderhistory_id");
                int orderId = resultSet.getInt("order_id");
                int totalAmount = resultSet.getInt("totalamount");
                String status = resultSet.getString("status");
                Timestamp date = resultSet.getTimestamp("date");

                orderHistoryList.add(new OrderHistory(orderHistoryId, userId, orderId, totalAmount, status, date));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderHistoryList;
    }

    @Override
    public int updateOrderHistory(int orderHistoryId, String status) {
        String sql = "UPDATE orderhistory SET status = ? WHERE orderhistory_id = ?";
        int result = 0;

        try (Connection connection = DBUtils.myConnect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, status);
            statement.setInt(2, orderHistoryId);

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<OrderHistory> fetchOrderOnUserid(int userId) {
        String sql = "SELECT * FROM orderhistory WHERE user_id = ?";
        List<OrderHistory> orderHistoryList = new ArrayList<>();

        try (Connection connection = DBUtils.myConnect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderHistoryId = resultSet.getInt("orderhistory_id");
                int orderId = resultSet.getInt("order_id");
                int totalAmount = resultSet.getInt("totalamount");
                String status = resultSet.getString("status");
                Timestamp date = resultSet.getTimestamp("date");

                orderHistoryList.add(new OrderHistory(orderHistoryId, userId, orderId, totalAmount, status, date));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderHistoryList;
    }
}
