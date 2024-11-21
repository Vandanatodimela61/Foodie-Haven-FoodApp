<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile Information</title>
    <style type="text/css">
        body {
            font-family: "Poppins", sans-serif;
            margin: 0px 80px;
            background-color: #ffe0b2; /* Light orange background for the page */
        }
        .profile {
            border: 3px solid #ff9800; /* Orange border for profile box */
            margin: 0px auto;
            margin-top: 100px;
            max-width: 600px;
            background-color: #ff5722; /* Dark orange for profile box */
            color: white;
            border-radius: 15px;
            padding: 30px;
            text-align: center;
            box-sizing: border-box;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3); /* Shadow effect */
        }
        h2 {
            margin-bottom: 30px;
            font-size: 2rem;
            color: #fff; /* White color for heading */
        }
        table {
            width: 100%;
            border-spacing: 10px;
            text-align: left;
        }
        table td, th {
            line-height: 2rem;
            color: white; /* Ensuring text is white in the table */
        }
        td {
            padding: 5px;
        }
        input[type="text"],
        input[type="password"] {
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
            border: 1px solid #ff9800; /* Orange border for input fields */
            font-size: 1rem;
            width: 90%;
            text-align: center;
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #ff7043; /* Medium orange for submit button */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1rem;
        }
        input[type="submit"]:hover {
            background-color: #e64a19; /* Darker orange on hover */
        }
        .profile p {
            color: white; /* White text for user not logged in message */
            font-size: 1.2rem;
        }
    </style>
</head>
<body>
    <% 
        User userobj = (User) session.getAttribute("loggedInUser"); 
        if (userobj != null) {
    %>
    <div class="profile">
        <h2>Profile Information</h2>
        <form action="updateProfile" method="post">
            <table>
                <tr>
                    <td>UserName:</td>
                    <td>
                        <input type="text" name="username" value="<%= userobj.getUsername() %>" 
                               placeholder="Enter your username" required>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <input type="text" name="email" value="<%= userobj.getEmail() %>" 
                               placeholder="Enter your email" required>
                    </td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td>
                        <input type="text" name="address" value="<%= userobj.getAddress() %>" 
                               placeholder="Enter your address" required>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Update Profile">
        </form>
    </div>
    <% 
        } else {
    %>
    <div class="profile">
        <h2>User not logged in</h2>
        <p>Please log in to access your profile information.</p>
    </div>
    <% 
        }
    %>
</body>
</html>
