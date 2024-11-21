package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.*;
import com.tap.daoimpl.*;
import com.tap.model.Menu;
import com.tap.model.Restuarant;

@WebServlet("/home")
public class Home extends HttpServlet{
	ResDaoImpl restaurantDAO;
	MenuDaoImpl menuDao;
	private int restuarant_id;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		restaurantDAO = new ResDaoImpl();
		List<Restuarant> restuarantList=restaurantDAO.getAllResu();
			HttpSession session = request.getSession();
			
			session.setAttribute("restuarantList",restuarantList);
	
			response.sendRedirect("home.jsp");
			
		
		
		
		
		
	}
	
	
	
	
	
	

}