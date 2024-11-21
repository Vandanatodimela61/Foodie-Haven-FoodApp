package com.tap.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.OrderHistoryDao;
import com.tap.dao.OrderItemDao;
import com.tap.dao.OrderDao;
import com.tap.daoimpl.OrderHistoryDaoImpl;
import com.tap.daoimpl.OrderItemDaoImpl;
import com.tap.daoimpl.OrderDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItem;
import com.tap.model.Orders;
import com.tap.model.User;

@WebServlet("/orderPlaced")
public class OrderPlacedServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Control reached OrderPlacedServlet");

        // Get session and user details
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            // User not logged in, redirect to login page
            System.out.println("User not logged in. Redirecting to login page.");
            resp.sendRedirect("Login.jsp");
            return;
        }

        if (cart == null || cart.getItems().isEmpty()) {
            // Cart is empty or expired
            System.out.println("Cart is empty or expired.");
            resp.sendRedirect("cart.jsp?message=Your+cart+is+empty+or+has+expired.");
            return;
        }

        int userId = user.getUser_id();
        String paymentMode = req.getParameter("paymentMode");
        int totalAmount;
        int restaurantId;

        // Safely retrieve and parse totalAmount parameter
        try {
            String totalAmountParam = req.getParameter("totalAmount");
            if (totalAmountParam == null || totalAmountParam.isEmpty()) {
                throw new NumberFormatException("Total amount is missing");
            }
            // Remove non-numeric characters
            totalAmountParam = totalAmountParam.replaceAll("[^0-9.]", "");
            totalAmount = (int) Float.parseFloat(totalAmountParam);
        } catch (NumberFormatException e) {
            System.out.println("Invalid totalAmount format: " + e.getMessage());
            resp.sendRedirect("ErrorPage.html?error=Invalid+totalAmount+format");
            return;
        }

        // Retrieve restaurantId parameter safely
        try {
            restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Invalid or missing restaurantId.");
            resp.sendRedirect("ErrorPage.html?error=Invalid+or+missing+restaurantId");
            return;
        }

        // Create Orders object
        Orders order = new Orders();
        order.setUser_id(userId);
        order.setPaymethod(paymentMode);
        order.setRestuarant_id(restaurantId);
        order.setTotal_amount(totalAmount);

        // Create DAO instances
        OrderDao orderDAO = new OrderDaoImpl();
        OrderItemDao orderItemDAO = new OrderItemDaoImpl();
        OrderHistoryDao orderHistoryDAO = new OrderHistoryDaoImpl();

        try {
            // Insert order into OrderTable
            int orderId = orderDAO.insertOrder(order);

            if (orderId > 0) {
                System.out.println("Order data inserted successfully. Order ID: " + orderId);

                // Retrieve cart items and insert into OrderItem table
                for (CartItem cartItem : cart.getItems()) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrder_id(orderId);
                    orderItem.setMenu_id(cartItem.getItemId());
                    orderItem.setQuantity(cartItem.getQuantity());
                    orderItem.setSub_total(cartItem.getSubtotal());

                    if (orderItemDAO.insertOrderItems(orderItem) <= 0) {
                        throw new SQLException("Failed to insert order item. Menu ID: " + cartItem.getItemId());
                    }
                }

                // Insert order history
                OrderHistory orderHistory = new OrderHistory();
                orderHistory.setOrderId(orderId);
                orderHistory.setUserId(userId);
                orderHistory.setTotalAmount(totalAmount);
                orderHistory.setStatus("Delivered");

                int historyResult = orderHistoryDAO.insertOrderHistory(orderHistory);
                if (historyResult > 0) {
                    List<OrderHistory> orderHistoryList = orderHistoryDAO.fetchOrderHistoryByUserId(userId);
                    session.setAttribute("orderhistorylist", orderHistoryList);
                    System.out.println("Order history updated and added to session.");
                } else {
                    throw new SQLException("Failed to insert order history for Order ID: " + orderId);
                }

                // Redirect to success page with order details
                resp.sendRedirect("OrderSucess.html?orderId=" + orderId + "&totalAmount=" + totalAmount);
            } else {
                System.out.println("Failed to insert order data.");
                resp.sendRedirect("ErrorPage.html?error=Failed+to+place+order");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
            resp.sendRedirect("ErrorPage.html?error=Database+error");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            resp.sendRedirect("ErrorPage.html?error=An+unexpected+error+occurred");
        }
    }
}
