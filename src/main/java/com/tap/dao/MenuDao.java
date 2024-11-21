package com.tap.dao;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDao {
	int insertMenu(Menu menu);
	List<Menu> getAllMenu(int restuarant_id);
	Menu getMenuById(int menu_id);
	int deleteMenuById(int menu_id);
	int updateMenuById(int menu_id,String isAvailable);
	
	

}
