package com.tap.dao;

import java.util.List;

import com.tap.model.Orders;

public interface OrderDao {
	
	int insertOrder(Orders order);
	List<Orders> getAllOrders();
	
	int deleteOrderById(int order_id);
	Orders getOrderById(int order_id);
	

}
