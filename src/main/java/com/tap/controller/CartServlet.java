package com.tap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tap.dao.MenuDao;
import com.tap.daoimpl.MenuDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = getCartFromSession(session);

        String actionType = request.getParameter("action");

        if ("add".equals(actionType)) {
            handleAddItem(request, cart);
        } else if ("update".equals(actionType)) {
            handleUpdateItem(request, cart);
        } else if ("remove".equals(actionType)) {
            handleRemoveItem(request, cart);
        }

        session.setAttribute("cart", cart);
        redirectToCartPage(cart, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = getCartFromSession(request.getSession());
        if (cart == null || cart.getItems().isEmpty()) {
            request.setAttribute("message", "Your cart is empty.");
        }
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    private Cart getCartFromSession(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    private void handleAddItem(HttpServletRequest request, Cart cart) {
        try {
            String itemIdStr = request.getParameter("itemId");
            String quantityStr = request.getParameter("quantity");

            if (itemIdStr == null || quantityStr == null || !isValidQuantity(quantityStr)) {
                throw new IllegalArgumentException("Invalid item ID or quantity.");
            }

            int itemId = Integer.parseInt(itemIdStr);
            int quantity = Integer.parseInt(quantityStr);

            Menu menuItem = fetchMenuItem(itemId);
            if (menuItem != null) {
                CartItem cartItem = createCartItem(menuItem, quantity);
                cart.addItem(cartItem);
                request.getSession().setAttribute("restaurantId", menuItem.getRestuarant_id());
            } else {
                System.out.println("Error: Menu item not found.");
            }
        } catch (Exception e) {
            System.out.println("Error while adding item: " + e.getMessage());
        }
    }

    private boolean isValidQuantity(String quantityStr) {
        try {
            int quantity = Integer.parseInt(quantityStr);
            return quantity > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Menu fetchMenuItem(int itemId) {
        MenuDao menuDAO = new MenuDaoImpl();
        return menuDAO.getMenuById(itemId);
    }

    private CartItem createCartItem(Menu menuItem, int quantity) {
        return new CartItem(
                menuItem.getMenu_id(),
                menuItem.getRestuarant_id(),
                menuItem.getItem_name(),
                quantity,
                menuItem.getPrice(),
                menuItem.getImg_path()
        );
    }

    private void handleUpdateItem(HttpServletRequest request, Cart cart) {
        try {
            String itemIdStr = request.getParameter("itemId");
            String quantityStr = request.getParameter("quantity");

            if (itemIdStr == null || quantityStr == null || !isValidQuantity(quantityStr)) {
                throw new IllegalArgumentException("Invalid item ID or quantity.");
            }

            int itemId = Integer.parseInt(itemIdStr);
            int quantity = Integer.parseInt(quantityStr);

            cart.updateItemQuantity(itemId, quantity);
        } catch (Exception e) {
            System.out.println("Error while updating item: " + e.getMessage());
        }
    }

    private void handleRemoveItem(HttpServletRequest request, Cart cart) {
        try {
            String itemIdStr = request.getParameter("itemId");
            if (itemIdStr != null) {
                int itemId = Integer.parseInt(itemIdStr);
                cart.removeItem(itemId);
            } else {
                throw new IllegalArgumentException("Item ID cannot be null.");
            }
        } catch (Exception e) {
            System.out.println("Error while removing item: " + e.getMessage());
        }
    }

    private void redirectToCartPage(Cart cart, HttpServletResponse response) throws IOException {
        if (cart.getItems().isEmpty()) {
            response.sendRedirect("cart.jsp?message=Your cart is empty");
        } else {
            response.sendRedirect("cart.jsp");
        }
    }
}
