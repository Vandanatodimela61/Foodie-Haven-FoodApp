<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Crazy Foods</title>
   <style>
    /* Body and background image styling */
    body {
        font-family: 'Arial', sans-serif;
        background-image: url('images/food4.jpg'); /* Path to your image */
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-attachment: fixed;
        transition: background-size 0.5s; /* Smooth transition */
    }

    body:hover {
        background-size: 120%; /* Zoom in on hover */
    }

    /* Fade-in effect */
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }

    /* Container styling */
    .container {
        background-color: rgba(0, 0, 0, 0); /* Fully transparent background */
        text-align: center; /* Center text */
        padding: 30px;
        border-radius: 15px;
        width: 90%;
        max-width: 600px;
        animation: fadeIn 1s ease-in; /* Fade-in effect */
    }

    /* Heading styling */
    h1 {
        font-family: 'Playfair Display', serif; /* Stylish font */
        font-size: 2.5em;
        color: #FF6F61; /* Coral color */
        margin-bottom: 15px;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7); /* Add shadow for readability */
    }

    /* Glowing effect on hover */
    h1:hover {
        text-shadow: 0 0 10px #FF6F61, 0 0 20px #FF6F61, 0 0 30px #FF6F61; /* Glowing effect */
        transition: text-shadow 0.3s; /* Smooth transition */
    }

    /* Paragraph text styling */
    p {
        font-size: 1.1em;
        color: #FFFFFF; /* White text for contrast */
        margin-bottom: 20px;
        text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.6); /* Add subtle shadow for better readability */
    }

    /* Button styling */
    .button {
        display: inline-block; /* Center align buttons */
        background-color: #32CD32; /* Lime Green */
        color: white;
        padding: 10px 20px;
        text-decoration: none;
        font-size: 1em;
        border-radius: 8px;
        margin: 0 10px; /* Space between buttons */
        transition: background-color 0.3s, transform 0.3s, box-shadow 0.3s; /* Update transition */
    }

    /* Button hover effect */
    .button:hover {
        background-color: #228B22; /* Darker green on hover */
        transform: scale(1.1); /* Increase scale for more emphasis */
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3); /* Add shadow on hover */
    }
</style>

</head>
<body>
    <div class="container">
        <h1>Welcome to Foodie Haven!</h1>
        <p>Your favorite meals delivered at lightning speed. Join us to explore a world of flavors and satisfy your cravings with Crazy Foods!</p>
        <a href="Register.html" class="button">Register</a>
        <a href="Login.jsp" class="button">Login</a>
    </div>
</body>
</html>
