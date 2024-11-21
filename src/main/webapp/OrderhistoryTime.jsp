<%@page import="com.tap.daoimpl.MenuDaoImpl"%>
<%@page import="com.tap.model.Menu"%>
<%@page import="com.tap.model.OrderItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #fff4e6; /* Pale orange background */
            max-width: 1200px;
            margin: 0 auto;
        }
        h1 {
            text-align: center;
            color: #d35400; /* Dark orange */
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        th {
            background-color: #e67e22; /* Dark orange */
            color: white;
            padding: 15px;
        }
        td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        img {
            width: 100px;
            height: auto;
            border-radius: 5px;
        }
        .total-row {
            font-weight: bold;
            background-color: #ffe0b2;
        }
        .no-orders {
            text-align: center;
            font-size: 18px;
            color: #d35400;
        }
    </style>
</head>
<body>
    <h1>Order History</h1>
    <%
        List<OrderItem> orderItems = (List<OrderItem>) request.getAttribute("orderitemlist");
        if (orderItems != null && !orderItems.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>S.No</th>
                <th>Item Image</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Sub Total</th>
            </tr>
        </thead>
        <tbody>
            <%
                int serialNumber = 1;
                float totalAmount = 0;
                for (OrderItem orderItem : orderItems) {
                    MenuDaoImpl menuDao = new MenuDaoImpl();
                    Menu menu = menuDao.getMenuById(orderItem.getMenu_id());
            %>
            <tr>
                <td><%= serialNumber++ %></td>
                <td><img alt="<%= menu.getItem_name() %>" src="<%= menu.getImg_path() %>"></td>
                <td><%= menu.getItem_name() %></td>
                <td><%= orderItem.getQuantity() %></td>
                <td>$<%= orderItem.getSub_total() %></td>
            </tr>
            <%
                    totalAmount += orderItem.getSub_total();
                }
            %>
            <tr class="total-row">
                <td colspan="3" style="text-align: right;">Total</td>
                <td></td>
                <td>$<%= totalAmount %></td>
            </tr>
        </tbody>
    </table>
    <%
        } else {
    %>
    <p class="no-orders">No orders found.</p>
    <%
        }
    %>
</body>
</html>
