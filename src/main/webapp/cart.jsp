<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.tap.model.CartItem" %>
<%@ page import="com.tap.model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Menu" %>

<html>
<head>
    <title>Your Cart</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <style>
        /* General Page Styling */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background-color: #fff8e6;
            color: #333;
            line-height: 1.6;
            padding: 20px;
        }

        h1 {
            color: #ff6f00;
            font-size: 2.5em;
            text-align: center;
            margin-bottom: 30px;
            text-transform: uppercase;
            font-weight: bold;
            letter-spacing: 1px;
        }

        /* Cart Container */
        .cart-container {
            max-width: 900px;
            margin: 0 auto;
            padding: 20px;
        }

        /* Cart Items Section */
        .cart-items {
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 6px 16px rgba(255, 111, 0, 0.2);
            padding: 25px;
            margin-bottom: 20px;
        }

        .cart-item {
            display: flex;
            align-items: center;
            border: 2px solid #ffcc80;
            border-radius: 10px;
            padding: 15px;
            margin-bottom: 15px;
            background-color: #fff3e0;
            transition: all 0.3s ease;
            gap: 20px;
        }

        .cart-item:hover {
            box-shadow: 0 8px 20px rgba(255, 111, 0, 0.25);
            transform: translateY(-6px);
        }

        .cart-item img {
            width: 180px;
            height: 180px;
            object-fit: cover;
            border-radius: 10px;
            border: 3px solid #ffcc80;
            flex-shrink: 0;
            transition: transform 0.3s ease;
        }

        .cart-item img:hover {
            transform: scale(1.05);
        }

        .cart-item-details {
            flex-grow: 1;
            display: flex;
            flex-direction: column;
        }

        .cart-item-details p {
            margin: 5px 0;
            font-size: 1.1em;
            color: #ff6f00;
            font-weight: bold;
        }

        .cart-item-details .item-price {
            color: #e65100;
        }

        .cart-item-actions {
            display: flex;
            flex-direction: column;
            align-items: flex-end;
            gap: 10px;
        }

        /* Quantity Input */
        .quantity-control {
            display: flex;
            align-items: center;
            gap: 10px;
            margin-bottom: 10px;
        }

        input[type="number"] {
            width: 60px;
            padding: 5px;
            border: 1px solid #ffcc80;
            border-radius: 4px;
            text-align: center;
        }

        /* Buttons */
        .btn {
            padding: 10px 15px;
            font-size: 1em;
            color: #fff;
            text-decoration: none;
            border-radius: 6px;
            display: inline-block;
            text-align: center;
            transition: all 0.3s ease;
            cursor: pointer;
            border: none;
        }

        .btn:hover {
            transform: scale(1.05);
            opacity: 0.9;
        }

        .add-more-items-btn {
            background-color: #ff9800;
            margin-right: 10px;
        }

        .proceed-to-checkout-btn {
            background-color: #ff6f00;
        }

        .update-btn, .remove-btn {
            padding: 6px 10px;
            font-size: 0.9em;
            font-weight: bold;
            cursor: pointer;
        }

        .update-btn {
            background-color: #ffcc80;
            color: #ff6f00;
        }

        .remove-btn {
            background-color: #ff7043;
            color: #fff;
        }

        .cart-total {
            text-align: right;
            margin-top: 20px;
            font-size: 1.3em;
            color: #e65100;
            font-weight: bold;
        }

        .empty-cart {
            text-align: center;
            color: #888;
            padding: 50px 0;
            font-size: 1.2em;
        }

        /* Responsive Design */
        @media screen and (max-width: 768px) {
            .cart-item {
                flex-direction: column;
                text-align: center;
            }

            .cart-item img {
                width: 250px;
                height: 250px;
                margin-bottom: 15px;
            }

            .cart-item-actions {
                align-items: center;
                width: 100%;
            }

            .btn {
                width: 100%;
                margin: 5px 0;
            }
        }
    </style>
</head>
<body>
    <div class="cart-container">
        <h1>Your Shopping Cart</h1>
        
        <div class="cart-items">
            <%
                // Retrieve the cart from the session
                Cart cart = (Cart) session.getAttribute("cart");

                // Check if the cart is not null and contains items
                if (cart != null && !cart.getItems().isEmpty()) {
                    double totalCartPrice = 0.0;
                    // Loop through each cart item
                    for (CartItem item : cart.getItems()) {
                        double totalPrice = item.getQuantity() * item.getPrice(); // Calculate total price for the item
                        totalCartPrice += totalPrice;
            %>
                <div class="cart-item">
                    <!-- Display Item Image -->
                    <img src="<%= (item.getimg_path() != null && !item.getimg_path().isEmpty()) ? 
                        (item.getimg_path().startsWith("http") ? item.getimg_path() : request.getContextPath() + item.getimg_path()) 
                        : request.getContextPath() + "/images/default.jpg" %>"  
                        alt="<%= item.getName() != null ? item.getName() : "Cart Item Image" %>">
                    
                    <div class="cart-item-details">
                        <p><%= item.getName() %></p>
                        <p class="item-price">Price: ₹<%= String.format("%.2f", item.getPrice()) %></p>
                        <p>Total: ₹<%= String.format("%.2f", totalPrice) %></p>
                    </div>
                    
                    <div class="cart-item-actions">
                        <!-- Form to update quantity or remove the item -->
                        <form action="cart" method="post" class="quantity-control">
                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                            <label>Quantity: 
                                <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                            </label>
                            <input type="submit" name="action" value="update" class="btn update-btn">
                            <input type="submit" name="action" value="remove" class="btn remove-btn">
                        </form>
                        <p class="subtotal">Item Subtotal: ₹<%= String.format("%.2f", totalPrice) %></p>
                    </div>
                </div>
            <%
                    }
            %>
                <div class="cart-total">
                    Total Cart Value: ₹<%= String.format("%.2f", totalCartPrice) %>
                </div>
            <%
                } else {
            %>
                <div class="empty-cart">
                    <p>Your cart is empty. Start adding some delicious items!</p>
                </div>
            <%
                }
            %>
        </div>

        <!-- Action Buttons -->
        <div class="cart-actions">
            <a href="menu?restuarant_id=<%= session.getAttribute("restaurantId") %>" class="btn add-more-items-btn">Add More Items</a>
            
            <% 
                // Check if the cart exists and is not empty before showing checkout button
                if (cart != null && !cart.getItems().isEmpty()) {
            %>
                <form action="Checkout.jsp" method="post" style="display: inline-block;">
                    <input type="submit" value="Proceed to Checkout" class="btn proceed-to-checkout-btn">
                </form>
            <% } %>
        </div>
    </div>
</body>
</html>