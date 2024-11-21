package com.tap.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tap.dao.MenuDao;
import com.tap.daoimpl.MenuDaoImpl;
import com.tap.model.Menu;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Validate and parse restuarant_id from the request parameter
        String restaurantIdParam = req.getParameter("restuarant_id");
        String restaurantName = req.getParameter("restaurantname");

        // Check if restuarant_id is missing
        if (restaurantIdParam == null || restaurantIdParam.isEmpty()) {
            req.setAttribute("errorMessage", "Restaurant ID is missing.");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        try {
            // Parse the restaurant ID from the request
            int restaurantId = Integer.parseInt(restaurantIdParam);

            // Initialize the MenuDao to interact with the database
            MenuDao menuDao = new MenuDaoImpl();

            // Fetch the menu list based on restaurant ID
            List<Menu> menuList = menuDao.getAllMenu(restaurantId); // Fetch menus using the restaurant ID

            if (menuList != null && !menuList.isEmpty()) {
                // If menus are found, forward the data to the view (Menu.jsp)
                req.setAttribute("menuList", menuList); // Pass the menu items
                req.setAttribute("restaurantname", restaurantName); // Pass restaurant name
                req.setAttribute("restuarant_id", restaurantId); // Pass restaurant ID
               
                req.getRequestDispatcher("Menu.jsp").forward(req, resp);
            } else {
                // If no menus are found for the given restaurant ID, show error
                req.setAttribute("errorMessage", "No menu items available for this restaurant.");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            // Handle error if restuarant_id is not properly formatted
            req.setAttribute("errorMessage", "Invalid restaurant ID format.");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        } catch (Exception e) {
            // General error handling
            req.setAttribute("errorMessage", "An error occurred while processing the menu request.");
            e.printStackTrace(); // Log error
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
