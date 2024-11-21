<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Restuarant" %>
<%@ page import="java.util.stream.Collectors" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        /* Color Palette */
        
        :root {
            --primary-color: #FF6F61;       /* Coral */
            --secondary-color: #FFFFFF;    /* White */
            --accent-color: #6B5B93;        /* Lavender */
            --bg-color: #F5F5F5;            /* Light Gray */
            --text-color: #343A40;          /* Dark Gray */
            --border-color: #CED4DA;        /* Light Border Gray */
            --navbar-bg-color: #FF7F2A;     /* Deep Coral */
        }

        /* General Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: "Poppins", sans-serif;
            background-color: #fff3e0;
            color: var(--text-color);
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 0 10px;
        }

        .navbar {
            width: 100%;
            background-image: url('images/background10.jpg'); /* Add your image path here */
            background-size: cover;
            background-position: center;
            display: flex;
            align-items:flex-start;
            justify-content: space-between;
            padding: 20px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin: 20px 0;
            height: 500px;
            position: relative;
            background-color: black;
        }

        .navbar img {
    height:50px;  /* Increase the height */
    margin-right: 15px;
    width:auto;
    max-width: 100px; 
    /* You can also increase or remove this if needed */
}


        .navbar-title {
            font-size: 2em;   /* Adjust the size */
    color: var(--secondary-color);  /* White */
    font-weight: bold;  /* Make the font bold */
    font-family: 'Cursive';  /* Apply a cursive font */
    text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2); 
        }
        
        

        .navbar-search {
   position: absolute;
    top: 30%;
    left: 50%;
    transform: translate(-50%, -50%); /* Centers the navbar-search container both vertically and horizontally */
    text-align: center;  /* Centers the text inside */
    width: 80%;  /* Adjust width if needed */
}

.navbar-links {
    display: flex;
    align-items: center;
    gap: 30px;
    margin-left: auto;
}
.navbar-links a {
    text-decoration: none;
    color: #007BFF;
    font-weight: bold;
}

.navbar-links a:hover {
    color: #0056b3;
}


        .navbar-search form {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 10px;
        }

        .navbar a {
            margin: 0 10px;
            text-decoration: none;
            color: var(--secondary-color);
            font-weight: 500;
            transition: color 0.3s;
        }

        .navbar a:hover {
            color: var(--primary-color);
        }

        .welcome-message, .login-message {
            font-size: 1.2em;
            color: var(--accent-color);
            margin-right: auto;
        }

        h2 {
            font-size: 2em;
            color: var(--primary-color);
            margin: 20px 0;
            text-align: center;
            text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.1);
        }

        .container {
            width: 100%;
            max-width: 1200px;
            padding: 20px;
            background-color: transparent;
            border-radius: 8px;
            margin-top: 30px;
        }

        /* Search Form */
        form {
             display: flex;
    justify-content: center;
    margin-bottom: 20px;
        }

        input[type="text"] {
             padding: 8px 30px 8px 8px; /* Add extra padding on the left for the emoji */
    width: 70%;
    border: 1px solid var(--border-color);
    border-radius: 5px;
    font-size: 1em;
    margin-right: 10px;
    position: relative;
        }
        input[type="text"]::before {
    content: '🔍'; /* Search emoji */
    position: absolute;
    left: 10px;  /* Adjust the position of the emoji */
    top: 50%;
    transform: translateY(-50%);  /* Center the emoji vertically */
    font-size: 1.2em;  /* Adjust the size of the emoji */
    color: #6B5B93;  /* Change to desired color */
}

        button[type="submit"] {
            padding: 8px 20px;
            background-color: var(--primary-color);
            color: var(--secondary-color);
            border: none;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: var(--accent-color);
        }

        /* Restaurant List */
        .restaurant-list {
            display: grid;
    grid-template-columns: repeat(4, 1fr); 
   gap: 20px; /* Adjust the space between boxes */
    margin-top: 20px;
        }

        .restaurant {
            background-color: var(--secondary-color);
    border: 1px solid var(--border-color);
    border-radius: 12px;
    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
    padding: 15px; /* Add padding for more spacing inside */
    text-align: center;
     background-color: #ffe0b2;
        }

        .restaurant:hover {
            transform: translateY(-5px);
    box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
        }

        .restaurant img {
             width: 100%;
    height: 180px;
    object-fit: cover;
    border-radius: 10px;
    border: 3px solid black
        }

        .restaurant h3 {
            font-size: 1.5em;
    margin: 10px 0;
    color: black;
    font-weight: bold;
        }

        .restaurant p {
            margin: 10px 15px;
            font-size: 0.95em;
            color: var(--text-color);
        }

       /* Style for the View Menu link */
/* Style for the View Menu link */
.restaurant a {
    display: inline-block;
    padding: 5px 10px;  /* Adjust padding to control size */
    font-size: 0.9em;   /* Smaller font size */
    color: #fff;        /* Text color */
    background-color: #ff6600; /* Orange background color */
    border-radius: 4px; /* Rounded corners */
    text-decoration: none;
    transition: box-shadow 0.3s ease, transform 0.3s ease; /* Smooth transition */
}

/* Glow effect on hover */
.restaurant a:hover {
    background-color: #ff6600; /* Retain orange background */
    box-shadow: 0 0 8px 4px rgba(255, 165, 0, 0.6), 
                0 0 15px 10px rgba(255, 140, 0, 0.4); /* Glow effect */
    transform: scale(1.05); /* Slightly enlarge */
}



        /* Navbar and other elements */
        .navbar-title, .navbar a, .welcome-message, .login-message {
            color: var(--secondary-color);
        }
        h1 {
    font-size: 2em;
    color: white; /* Change color to white */
    margin: 15px 0;
    padding: 10px;
    border-radius: 8px;
    white-space: nowrap; /* Ensure the text stays in one line */
   font-family: Arial, sans-serif;
    font-style: italic;  /* Set the font style */
    font-weight: 300;  /* Optional: Add bold style */
}
.dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }


        
       
</style>

    </style> 

</head>
<body>
    <div class="navbar">
        <img src="images/Foodie Food Logo2.png" alt="Logo">
        
        <% User user = (User) session.getAttribute("loggedInUser"); %>
        <% if (user != null) { %>
            <h3 class="welcome-message"> </h3>
            <a href="cart">🛒 Cart</a>
            <a href="OrderHistory.jsp">📜 View Order History</a>
            <div class="dropdown">
            <a href="javascript:void(0)">Hey, <%= user.getUsername() %></a>
            <div class="dropdown-content">
                <a href="Profile.jsp">👤Profile</a>
                <a href="Resetpwd.jsp">🔒Change Password</a>
                <a href="Logout.jsp">🚪Logout</a>
            </div>
        </div>
    </div>
        <% 
        } else { %>
            <h3 class="login-message">You haven't logged in.</h3>
            <a href="signUp.jsp" aria-label="Sign Up">Sign Up</a>
            <a href="Login.jsp" aria-label="Login">Login</a>
        <% } %>
        
        <div class="navbar-search">
            <div class="navbar-title"><h2>Foodie Haven&#x1F374;</h2></div>
            <h1>Find the Most Delicious Food and Beverages Nearby</h1>
            <form action="home" method="get">
                <input type="text" name="searchQuery" placeholder="Search for restaurants...">
                <button type="submit">Search</button>
            </form>
        </div>   
    </div>

    <div class="container">
        <h1 style="text-align: left; color: tomato; font-weight: bold;font-family: 'Roboto', sans-serif;">
    Assortments
</h1>


		<h2 style="color:var(--text-color); font-weight: normal;; font-size: 1.5em; text-align: left; margin-bottom: 20px;">
   
Discover handpicked selections of the finest restaurants, cafes, pubs, and bars, tailored to the latest trends.
</h2>


        <!-- Restaurant List -->
        <section class="restaurant-list">
            <%
		        List<Restuarant> restuarantList = (List<Restuarant>) session.getAttribute("restuarantList");
		        if (restuarantList != null && !restuarantList.isEmpty()) {
		            for (Restuarant restuarant : restuarantList) {
		        %>
		            <div class="restaurant">
		                <img src="<%= restuarant.getImg_path() != null ? restuarant.getImg_path() : "images/default-image.jpg" %>" 
		                    alt="<%= restuarant.getResName() != null ? restuarant.getResName() : "Restaurant Image" %>">
		                <div class="restaurant-info">
		                    <h3><%= restuarant.getResName() %></h3>
		                    <p>
		                        Cuisine: <%= restuarant.getCuisinetype() %><br>
		                        Delivery Time: <%= restuarant.getDeliverytimel() %> mins<br>
		                        Rating: <%= restuarant.getRating() %>
		                    </p>
		                    <a href="menu?restuarant_id=<%= restuarant.getRestuarant_id() %>">View Menu</a>
		                </div>
		            </div>
		        <%
		            }
		        } else {
		        %>
		            <p>No restaurants available at the moment.</p>
		        <% } %>

        </section>
    </div>
</body>
</html>