package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.model.OrderHistory;
import com.tap.model.User;
import com.tap.daoimpl.OrderHistoryDaoImpl;

@WebServlet("/orderhistoryservlet")
public class OrderHistoryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get user object from session
        User userobj = (User) req.getSession().getAttribute("loggedInUser");

        if (userobj != null) {
            int userid = userobj.getUser_id();

            // Create OrderHistoryDaoImpl instance
            OrderHistoryDaoImpl orderhistoryobj = new OrderHistoryDaoImpl();

            // Fetch order history for the user
            List<OrderHistory> orderhistorylist = orderhistoryobj.fetchOrderOnUserid(userid);

            // Check if order history list is not null and set to session
            if (orderhistorylist != null && !orderhistorylist.isEmpty()) {
                req.getSession().setAttribute("orderhistorylist", orderhistorylist);
            } else {
                // In case no order history is found, set a message instead of null or empty list
                req.getSession().setAttribute("orderhistoryMessage", "No orders found.");
            }

            // Redirect or forward to OrderHistory.jsp
            // If OrderHistory.jsp is inside WEB-INF, you should forward the request:
            req.getRequestDispatcher("OrderHistory.jsp").forward(req, resp);
        } else {
            // If user is not logged in, redirect to Login.jsp
            resp.sendRedirect("Login.jsp");
        }
    }
}
