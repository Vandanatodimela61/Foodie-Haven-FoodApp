<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
    <style>
        /* Color palette and fonts */
        body {
            background-color: red; /* S pink gradient */

            font-family: 'Arial', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        /* Centered registration form container */
        .register-container {
            background-color: #FFFFFF;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
            width: 400px;
            text-align: center;
        }

        /* Heading styles */
        h1 {
            color: #FF6F61; /* red */
            font-size: 28px;
            margin-bottom: 20px;
            border-bottom: 2px solid #3498db;
            display: inline-block;
            padding-bottom: 10px;
        }

        /* Form table styling */
        table {
            width: 100%;
        }

        td {
            padding: 10px 0;
            font-size: 16px;
            color: #555555;
        }

        /* Input field styles */
        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #CCCCCC;
            border-radius: 5px;
            font-size: 14px;
            transition: box-shadow 0.3s ease;
        }

        input[type="text"]:focus,
        input[type="password"]:focus,
        input[type="email"]:focus {
            box-shadow: 0 0 8px rgba(52, 152, 219, 0.5); /* Blue shadow on focus */
            outline: none; /* Remove default outline */
        }

        /* Submit button styling */
        input[type="submit"] {
            background-color: #27ae60; /* Green */
            color: white;
            border: none;
            padding: 12px 24px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: all 0.3s ease; /* Smooth transition */
            position: relative;
            overflow: hidden;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #2ecc71; /* Lighter green on hover */
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15); /* Add shadow effect */
        }

        input[type="submit"]:active {
            transform: scale(0.98); /* Shrink on click */
        }

        /* Ripple effect on click */
        input[type="submit"]::after {
            content: '';
            position: absolute;
            background: rgba(255, 255, 255, 0.5);
            width: 100px;
            height: 100px;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%) scale(0);
            border-radius: 50%;
            transition: transform 0.5s ease;
        }

        input[type="submit"]:active::after {
            transform: translate(-50%, -50%) scale(4); /* Ripple effect */
            opacity: 0; /* Fade out after ripple */
        }
        /* Add scale effect on hover */
        .register-container:hover {
            transform: scale(1.02); /* Slight zoom on hover */
        }

    </style>
</head>
<body>
    <div class="register-container">
        <h1>Registration</h1>
        <form action="ResgisterUser">
            <table>
                <tr>
                    <td><label for="username">Name</label></td>
                    <td><input type="text" id="username" name="username" placeholder="Enter your name" required></td>
                </tr>
                <tr>
                    <td><label for="password">Password</label></td>
                    <td><input type="password" id="password" name="password" placeholder="Enter your password" required></td>
                </tr>
                <tr>
                    <td><label for="email">Email</label></td>
                    <td><input type="email" id="email" name="email" placeholder="Enter your email" required></td>
                </tr>
                <tr>
                    <td><label for="address">Address</label></td>
                    <td><input type="text" id="address" name="address" placeholder="Enter your address"></td>
                </tr>
                <tr>
                    <td><label for="role">Role</label></td>
                    <td><input type="text" id="role" name="role" placeholder="Enter your role"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Register">
                    </td>
                </tr>
                <tr>
                	<td style="color:blue" colspan="2">Already have account?<a href="Login.jsp" aria-label="Login">Login</td>
                	
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
