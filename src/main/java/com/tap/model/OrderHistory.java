package com.tap.model;

import java.sql.Timestamp;

public class OrderHistory {

    private int orderHistoryId; // orderhistory_id in the table
    private int userId;         // user_id in the table
    private int orderId;        // order_id in the table
    private Timestamp date;     // date in the table (using Timestamp to store date and time)
    private int totalAmount;    // totalamount in the table (as an integer)
    private String status;      // status in the table (varchar)

    // Constructor with all fields
    public OrderHistory(int orderHistoryId, int userId, int orderId, int totalAmount, String status, Timestamp date) {
        this.orderHistoryId = orderHistoryId;
        this.userId = userId;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.date = date;
    }

    // Constructor without orderHistoryId (for new records)
    public OrderHistory(int userId, int orderId, int totalAmount, String status, Timestamp date) {
        this.userId = userId;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.date = date;
    }

    // Default constructor
    public OrderHistory() {
    }

    // Getters and Setters
    public int getOrderHistoryId() {
        return orderHistoryId;
    }

    public void setOrderHistoryId(int orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override toString() method for printing OrderHistory object
    @Override
    public String toString() {
        return "OrderHistory [orderHistoryId=" + orderHistoryId + ", userId=" + userId + ", orderId=" + orderId
                + ", totalAmount=" + totalAmount + ", status=" + status + ", date=" + date + "]";
    }
}
