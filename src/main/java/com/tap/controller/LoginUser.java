package com.tap.controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.userDaoImpl;
import com.tap.model.User;

import com.tap.dao.userDao;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/login") // Change to lowercase
public class LoginUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        userDao ud = new userDaoImpl();
        User u = ud.getUser(email);

        if (u != null && password.equals(u.getPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedInUser", u);
            resp.sendRedirect("home");
        } else {
            req.setAttribute("errorMessage", "Invalid email or password");
            req.getRequestDispatcher("home.jsp").forward(req, resp); // Make sure the file name is 'login.jsp'
        }
    }
}
