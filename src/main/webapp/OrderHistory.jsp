<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.OrderHistory"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order History</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            line-height: 1.6;
            color: #333;
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff8e1;
        }
        h2 {
            color: #e67e22;
            border-bottom: 3px solid #e67e22;
            padding-bottom: 10px;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0;
            box-shadow: 0 2px 3px rgba(0,0,0,0.1);
            background-color: white;
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #f2f2f2;
        }
        th {
            background-color: #e67e22;
            color: white;
            text-transform: uppercase;
            font-weight: 600;
        }
        tr:nth-child(even) {
            background-color: #ffe4b3;
        }
        tr:hover {
            background-color: #ffd9a3;
            transition: background-color 0.3s ease;
        }
        form {
            display: inline-block;
        }
        input[type="submit"] {
            background-color: #f39c12;
            color: white;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #d35400;
        }
        .no-orders {
            text-align: center;
            color: #7f8c8d;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 3px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <%
    List<OrderHistory> orderHistoryList = (List<OrderHistory>) session.getAttribute("orderhistorylist");
    if (orderHistoryList != null && !orderHistoryList.isEmpty()) {
    %>
    <h2>Check Your Orders Below</h2>
    <table>
        <thead>
            <tr>
                <th>S.no</th>
                <th>Order Date</th>
                <th>Total Amount</th>
                <th>Status</th>
                <th>Check Items</th>
            </tr>
        </thead>
        <tbody>
            <%
            int increment = 1;
            for (OrderHistory order : orderHistoryList) {
            %>
            <tr>
                <td><%= increment++ %></td>
                
                <td><%= order.getDate() %></td>
                <td><%= order.getTotalAmount() %></td>
                <td><%= order.getStatus() %></td>
                <td>
                    <form action="OrderItemList" method="get">
                        <input type="hidden" name="orderid" value="<%= order.getOrderId() %>">
                        <input type="submit" value="View Menu">
                    </form>
                </td>
                
            </tr>
            <%
            }
            %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <div class="no-orders">
        <p>No order history available.</p>
    </div>
    <%
    }
    %>
</body>
</html>
