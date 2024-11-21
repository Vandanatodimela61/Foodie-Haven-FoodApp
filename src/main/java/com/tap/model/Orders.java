package com.tap.model;

public class Orders {
    private int order_id;
    private int user_id;
    private int restuarant_id;
    private float total_amount;
    private String status;
    private String paymethod;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRestuarant_id() {
		return restuarant_id;
	}
	public void setRestuarant_id(int restuarant_id) {
		this.restuarant_id = restuarant_id;
	}
	public float getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public Orders(int order_id, int user_id, int restuarant_id, float total_amount, String status, String paymethod) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.restuarant_id = restuarant_id;
		this.total_amount = total_amount;
		this.status = status;
		this.paymethod = paymethod;
	}
	public Orders(int user_id, int restuarant_id, float total_amount, String status, String paymethod) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.restuarant_id = restuarant_id;
		this.total_amount = total_amount;
		this.status = status;
		this.paymethod = paymethod;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", user_id=" + user_id + ", restuarant_id=" + restuarant_id
				+ ", total_amount=" + total_amount + ", status=" + status + ", paymethod=" + paymethod + "]";
	}
	
    
    
	
    
}