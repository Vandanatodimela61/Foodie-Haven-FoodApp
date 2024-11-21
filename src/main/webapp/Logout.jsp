<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
</head>
<body>
    <%
        // Remove the user session attribute
        session.removeAttribute("userobj");
        
        // Redirect to home page
        response.sendRedirect("Login.jsp");
    %>
</body>
</html>
