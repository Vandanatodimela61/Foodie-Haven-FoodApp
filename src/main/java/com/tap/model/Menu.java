package com.tap.model;

public class Menu {
	private  int menu_id;
	private  int restuarant_id;
	private  String item_name;
	private  String description;
	private  float price;
	private  String isAvailable;
	private String img_path;
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getRestuarant_id() {
		return restuarant_id;
	}
	public void setRestuarant_id(int restuarant_id) {
		this.restuarant_id = restuarant_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public Menu(int menu_id, int restuarant_id, String item_name, String description, float price, String isAvailable,
			String img_path) {
		super();
		this.menu_id = menu_id;
		this.restuarant_id = restuarant_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.img_path = img_path;
	}
	public Menu(int restuarant_id, String item_name, String description, float price, String isAvailable,
			String img_path) {
		super();
		this.restuarant_id = restuarant_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.img_path = img_path;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", restuarant_id=" + restuarant_id + ", item_name=" + item_name
				+ ", description=" + description + ", price=" + price + ", isAvailable=" + isAvailable + ", img_path="
				+ img_path + "]";
	}
	
	
	

}
