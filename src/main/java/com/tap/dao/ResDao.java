package com.tap.dao;

import java.util.List;

import com.tap.model.Restuarant;

public interface ResDao {
	int insertRestuarant(Restuarant Restuarant);
	List<Restuarant> getAllResu();
	Restuarant getResById(int restuarant_id);
	int deleteResById(int restuarant_id);
	int updateResById(int restuarant_id,int isActive);

}
