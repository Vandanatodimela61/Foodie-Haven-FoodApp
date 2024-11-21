<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            color: #333;
            text-align: center;
            padding: 50px;
        }
        .error-container {
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            padding: 20px;
            background-color: #fff;
            display: inline-block;
        }
        .error-title {
            font-size: 24px;
            color: #d9534f;
        }
        .error-message {
            font-size: 18px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-title">An Error Occurred</div>
        <div class="error-message">
            <p><%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "Unknown error occurred." %></p>
        </div>
        <div>
            <a href="home.jsp">Return to Home</a>
        </div>
    </div>
</body>
</html>
