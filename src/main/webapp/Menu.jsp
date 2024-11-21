	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ page import="javax.servlet.http.HttpSession" %>
	<%@ page import="java.util.List" %>
	<%@ page import="com.tap.model.Menu" %>
	<%@ page import="com.tap.model.CartItem" %>
	<%@ page import="com.tap.model.Cart" %>
	
	<html>
	<head>
	    <title>Menu</title>
	    <link rel="stylesheet" href="css/menu.css">
	    <style>
	        /* Global styles */
	        body {
	            font-family: 'Arial', sans-serif;
	            margin: 0;
	            padding: 0;
	            background-color: #fff3e0; /* Light orange background */
	            color: #333;
	            line-height: 1.6;
	        }
	
	        h1 {
	            text-align: center;
	            color: Black; /* Deep orange for the title */
	            margin-top: 20px;
	            font-size: 2.5em;
	            font-weight: 700;
	        }
	
	        /* Container for menu items */
	        .menu-container {
	            display: flex;
	            flex-wrap: wrap;
	            justify-content: center;
	            margin-top: 20px;
	            gap: 20px;
	        }
	
	        /* Individual menu item */
	        .menu-item {
	            display: flex;
	            flex-direction: row;
	            align-items: center;
	            background-color: #ffe0b2; /* Light orange card background */
	            border: 1px solid #ffab40; /* Orange border */
	            border-radius: 10px;
	            width: 80%;
	            max-width: 900px;
	            padding: 10px;
	            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	            transition: transform 0.3s ease, box-shadow 0.3s ease;
	        }
	
	        .menu-item:hover {
	            transform: translateY(-5px);
	            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
	        }
	
	        /* Image styles */
	        .menu-item img {
	            width: 200px;
	            height: 150px;
	            object-fit: cover;
	            border-radius: 10px; /* Rounded corners */
	            border: 3px solid black; /* Orange border */
	        }
	
	        /* Content styles */
	        .menu-item-content {
	            flex-grow: 1;
	            margin-left: 20px;
	            display: flex;
	            flex-direction: column;
	            justify-content: center;
	        }
	
	        /* Title and description */
	        .menu-item-content h3 {
	            font-size: 1.5em;
	            color: #d84315; /* Deep orange for titles */
	            margin-bottom: 5px;
	        }
	
	        .menu-item-content p {
	            font-size: 1em;
	            color: Black; /* Dark orange for descriptions */
	            margin-bottom: 10px;
	        }
	
	        /* Price style */
	        .menu-item-content .price {
	            color: #e65100; /* Vibrant orange for prices */
	            font-size: 1.2em;
	            margin-bottom: 10px;
	        }
	
	        /* Form styles */
	        form {
	            display: flex;
	            flex-direction: row;
	            align-items: center;
	            gap: 10px;
	        }
	
	        .quantity-input {
	            width: 60px;
	            padding: 5px;
	            font-size: 1em;
	            border: 1px solid #ff6f00;
	            border-radius: 5px;
	        }
	
	        .add-to-cart-btn {
	            background-color: #ff6f00; /* Bright orange button */
	            color: white;
	            padding: 8px 15px;
	            border: none;
	            border-radius: 5px;
	            cursor: pointer;
	            transition: background-color 0.3s ease;
	        }
	
	        .add-to-cart-btn:hover {
	            background-color: #e65100; /* Darker orange on hover */
	        }
	
	        /* No items message */
	        .no-items {
	            text-align: center;
	            font-size: 1.5em;
	            color: #d84315; /* Deep orange for the message */
	            margin-top: 20px;
	        }
	    </style>
	</head>
	<body>
	    <h1>✦ Menu ✦</h1>
	    <div class="menu-container">
	        <% 
	            // Retrieve the list of menu items from session or request
	            List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
	            
	            if (menuList == null) {
	                menuList = (List<Menu>) session.getAttribute("menuList");
	            }
	
	            if (menuList != null && !menuList.isEmpty()) {
	                // Loop through each menu item
	                for (Menu menuItem : menuList) {
	        %>
	            <div class="menu-item">
	                <!-- Image on the left -->
	                <img src="<%= (menuItem.getImg_path() != null && !menuItem.getImg_path().isEmpty()) ? 
	                    (menuItem.getImg_path().startsWith("http") ? menuItem.getImg_path() : request.getContextPath() + menuItem.getImg_path()) 
	                    : request.getContextPath() + "/images/default.jpg" %>" 
	                    alt="<%= menuItem.getItem_name() != null ? menuItem.getItem_name() : "Menu Item Image" %>">
	                
	                <!-- Content on the right -->
	                <div class="menu-item-content">
	                    <h3><%= menuItem.getItem_name() %></h3>
	                    <p><%= menuItem.getDescription() %></p>
	                    <p class="price">Price: ₹<%= menuItem.getPrice() %></p>
	                    
	                    <!-- Add to Cart Form -->
	                    <form action="cart" method="post">
	                        <input type="hidden" name="itemId" value="<%= menuItem.getMenu_id() %>">
	                        <input type="hidden" name="restuarant_id" value="<%= menuItem.getRestuarant_id() %>">
	                        <label>Quantity:</label>
	                        <input type="number" name="quantity" value="1" min="1" class="quantity-input">
	                        <input type="hidden" name="action" value="add">
	                        <input type="submit" value="Add to Cart" class="add-to-cart-btn">
	                    </form>
	                </div>
	            </div>
	        <% 
	                }
	            } else { 
	        %>
	            <p class="no-items">No menu items available.</p>
	        <% 
	            } 
	        %>
	    </div>
	</body>
	</html>
