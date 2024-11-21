package com.tap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.userDaoImpl;
import com.tap.model.User;
import com.tap.dao.userDao;

/**
 * Servlet implementation class ResgisterUser
 */
@WebServlet("/ResgisterUser")
public class ResgisterUser extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		String role=req.getParameter("role");
		User u= new User(username,password,email,address,role);
		userDao udaoi= new userDaoImpl();
		int x=udaoi.insertUser(u);
		if(x>=0) {
			resp.sendRedirect("success.html");
			
		}else {
			resp.sendRedirect("failure.html");
		}
		
		
		
	    
		
	}

}
