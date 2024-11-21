package com.tap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.userDaoImpl;
import com.tap.model.User;

@WebServlet("/updatepassword")
public class PasswordUpdate extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Debugging: Print message when the request reaches the servlet
        System.out.println("Control reached the password update servlet");

        // Get the new password and confirm password from the request
        String password = req.getParameter("newpassword");
        String confirmpassword = req.getParameter("confirmpassword");

        // Retrieve the logged-in user object from the session
        User u = (User) req.getSession().getAttribute("loggedInUser");

        // If no user is logged in, redirect to the login page
        if(password.equals(confirmpassword))
	    {
	    	userDaoImpl obj  = new userDaoImpl();
	    	obj.updateUserById(confirmpassword, u.getUser_id());
	    	resp.sendRedirect("changepasswordsuccess.html");
	    }
	    else {
			resp.getWriter().println("Password and confirmpassword doesnt match");
		}
	
    }
}

