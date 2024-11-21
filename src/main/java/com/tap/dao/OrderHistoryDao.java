package com.tap.dao;

import java.util.List;

import com.tap.model.OrderHistory;

public interface OrderHistoryDao {

    int insertOrderHistory(OrderHistory orderHistory);

    List<OrderHistory> fetchOrderHistoryByUserId(int user_id);

    int updateOrderHistory(int orderHistoryId, String status);

    List<OrderHistory> fetchOrderOnUserid(int userid);
}
