package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItem;

public interface OrderItemDao {
	int insertOrderItems(OrderItem OrdetItem);
	List<OrderItem> getAllOrderItems();
	OrderItem getOrderItemById(int order_id);
	List<OrderItem>fetchOrdersItems(int order_id);
	
	
	
	
}
