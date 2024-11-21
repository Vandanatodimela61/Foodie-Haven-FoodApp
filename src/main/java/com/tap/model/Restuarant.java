package com.tap.model;

public class Restuarant {
	private int restuarant_id;
	private String resName;
	private String cuisinetype;
	private int deliverytimel;
	private String address;
	private int admin_id;
	private float rating;
	private int isActive;
	private String img_path;
	public int getRestuarant_id() {
		return restuarant_id;
	}
	public void setRestuarant_id(int restuarant_id) {
		this.restuarant_id = restuarant_id;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getCuisinetype() {
		return cuisinetype;
	}
	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}
	public int getDeliverytimel() {
		return deliverytimel;
	}
	public void setDeliverytimel(int deliverytimel) {
		this.deliverytimel = deliverytimel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public Restuarant(int restuarant_id, String resName, String cuisinetype, int deliverytimel, String address,
			int admin_id, float rating, int isActive, String img_path) {
		super();
		this.restuarant_id = restuarant_id;
		this.resName = resName;
		this.cuisinetype = cuisinetype;
		this.deliverytimel = deliverytimel;
		this.address = address;
		this.admin_id = admin_id;
		this.rating = rating;
		this.isActive = isActive;
		this.img_path = img_path;
	}
	public Restuarant(String resName, String cuisinetype, int deliverytimel, String address, int admin_id, float rating,
			int isActive, String img_path) {
		super();
		this.resName = resName;
		this.cuisinetype = cuisinetype;
		this.deliverytimel = deliverytimel;
		this.address = address;
		this.admin_id = admin_id;
		this.rating = rating;
		this.isActive = isActive;
		this.img_path = img_path;
	}
	public Restuarant() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Restuarant [restuarant_id=" + restuarant_id + ", resName=" + resName + ", cuisinetype=" + cuisinetype
				+ ", deliverytimel=" + deliverytimel + ", address=" + address + ", admin_id=" + admin_id + ", rating="
				+ rating + ", isActive=" + isActive + ", img_path=" + img_path + "]";
	}
	
	

}
