<%@ page import="com.tap.model.Cart" %>
<%@ page import="com.tap.model.CartItem" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
<style type="text/css">
    body {
        font-family: 'Poppins', sans-serif;
        margin: 0;
        padding: 20px;
        background-color: #fdf2e4;
        color: #333;
        animation: fadeIn 1s ease-out;
    }
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }

    .checkout-container {
        max-width: 800px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        animation: slideUp 0.5s ease-in-out;
    }
    @keyframes slideUp {
        from {
            transform: translateY(20px);
            opacity: 0;
        }
        to {
            transform: translateY(0);
            opacity: 1;
        }
    }

    h1, h2 {
        color: #FF5722;
        text-align: center;
        animation: fadeInUp 1s ease-out;
    }
    @keyframes fadeInUp {
        from {
            transform: translateY(10px);
            opacity: 0;
        }
        to {
            transform: translateY(0);
            opacity: 1;
        }
    }

    .cart-summary {
        margin-bottom: 20px;
        animation: fadeIn 1.5s ease-out;
    }

    .cart-item {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 0;
        border-bottom: 1px solid #e0e0e0;
        transition: transform 0.3s ease;
    }
    .cart-item:hover {
        transform: scale(1.02);
    }
    .cart-item:last-child {
        border-bottom: none;
    }
    .cart-item img {
        max-width: 60px;
        margin-right: 10px;
        border-radius: 5px;
        transition: transform 0.3s ease;
    }
    .cart-item img:hover {
        transform: scale(1.1);
    }
    .cart-item p {
        margin: 5px 0;
        font-size: 1rem;
    }

    .total-price {
        text-align: right;
        font-size: 1.3rem;
        font-weight: 600;
        color: #FF5722;
        margin-top: 20px;
    }

    .checkout-form {
        margin-top: 20px;
        animation: fadeIn 1.8s ease-out;
    }

    .checkout-form label {
        display: block;
        margin-bottom: 5px;
    }

    .checkout-form input, .checkout-form select {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border-radius: 5px;
        border: 1px solid #ccc;
        font-size: 1rem;
        transition: border-color 0.3s ease;
    }

    .checkout-form input:focus, .checkout-form select:focus {
        border-color: #FF5722;
        outline: none;
    }

    .checkout-form input[type="submit"] {
        background-color: #FF5722;
        color: #fff;
        border: none;
        cursor: pointer;
        font-size: 1rem;
        font-weight: 600;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }

    .checkout-form input[type="submit"]:hover {
        background-color: #FF7043;
        transform: scale(1.05);
    }

    .cart-empty {
        text-align: center;
        margin-top: 50px;
    }

    .cart-empty p {
        font-size: 1.2rem;
        color: #555;
    }
</style>
</head>
<body>
    <div class="checkout-container">
        <h1>Checkout</h1>
        <% 
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
                double totalAmount = 0.0;
        %>
        <div class="cart-summary">
            <h2>Order Summary</h2>
            <% 
                for (CartItem cartItem : cart.getItems()) {
                    double itemTotal = cartItem.getPrice() * cartItem.getQuantity();
                    totalAmount += itemTotal;
            %>
            <div class="cart-item">
                <img src="<%= cartItem.getimg_path() %>" alt="<%= cartItem.getName() %>">
                <p><strong><%= cartItem.getName() %></strong> (x<%= cartItem.getQuantity() %>)</p>
                <p>₹<%= String.format("%.2f", itemTotal) %></p>
            </div>
            <% 
                } 
            %>
            <div class="total-price">
                <p>Total: ₹<%= String.format("%.2f", totalAmount) %></p>
            </div>
        </div>
        <div class="checkout-form">
            <h2>Enter Your Details</h2>
            <form action="orderPlaced" method="post">
                <input type="hidden" name="userId" value="<%= session.getAttribute("userId") != null ? session.getAttribute("userId").toString() : "" %>">
                <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") != null ? session.getAttribute("restaurantId") : "" %>">
                <input type="text" id="name" name="name" required placeholder="Enter your full name">
                <input type="text" id="address" name="address" required placeholder="Enter your delivery address">
                <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required placeholder="Enter your phone number">
                <select id="paymentMode" name="paymentMode" required>
                    <option value="" disabled selected>Choose Payment Mode</option>
                    <option value="Cash on Delivery">Cash on Delivery</option>
                    <option value="Credit/Debit Card">Credit/Debit Card</option>
                    <option value="UPI">UPI</option>
                </select>
                <input type="text" name="totalAmount" value="<%= String.format("%.2f", totalAmount) %>" readonly>
                <input type="submit" value="Confirm Order">
            </form>
        </div>
        <% 
            } else { 
        %>
        <div class="cart-empty">
            <h2>Your Cart is Empty</h2>
            <p>Please add items to your cart before proceeding to checkout.</p>
        </div>
        <% 
            } 
        %>
    </div>
</body>
</html>