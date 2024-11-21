<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        /* Background color and font */
        body {
            background-color: #FFECB3; /* Light orange background */
            font-family: 'Arial', sans-serif;
        }

        /* Center container */
        .login-container {
            background-color: white;
            width: 320px;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 100px auto;
            text-align: center;
            transition: transform 0.3s ease; /* Animation for container */
        }

        /* Add scale effect on hover */
        .login-container:hover {
            transform: scale(1.01); /* Slight zoom on hover */
        }

        /* Title styling */
        h1 {
            color: #FF6F00; /* Orange color */
            margin-bottom: 30px;
            font-size: 28px;
            border-bottom: 2px solid #FF6F00; /* Orange border */
            display: inline-block;
            padding-bottom: 10px;
        }

        /* Table and input field styles */
        table {
            width: 100%;
            margin-top: 20px;
        }

        td {
            padding: 12px;
            font-size: 16px;
        }

        input[type="email"],
        input[type="password"] {
            width: 90%;
            padding: 8px;
            font-size: 14px;
            border-radius: 5px;
            border: 1px solid #FF9800; /* Orange border */
            transition: box-shadow 0.3s ease;
        }

        input[type="email"]:focus,
        input[type="password"]:focus {
            box-shadow: 0 0 5px rgba(255, 87, 34, 0.5); /* Darker orange shadow on focus */
            outline: none; /* Remove default outline */
        }

        /* Submit button style */
        input[type="submit"] {
            background-color: #FF7043; /* Medium orange */
            color: white;
            border: none;
            padding: 12px 24px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: all 0.3s ease; /* Smooth transition */
            position: relative;
            overflow: hidden;
        }

        input[type="submit"]:hover {
            background-color: #F4511E; /* Darker orange on hover */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Shadow on hover */
        }

        /* Button click effect */
        input[type="submit"]:active {
            transform: scale(0.98); /* Slightly shrink button when clicked */
        }

        /* Add a ripple effect */
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

        /* Icon styling */
        .icon {
            font-size: 18px;
            padding-right: 10px;
            color: #FF6F00; /* Orange color */
        }

        /* Link style */
        a {
            color: #FF6F00; /* Orange color */
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline; /* Underline effect on hover */
        }

    </style>
</head>
<body>
    <div class="login-container">
        <h1>Login</h1>
        <p>Don't have an account? <a href="Register.html" aria-label="Register">Sign Up</a></p>
        <form action="login" method="post">
            <table>
                <tr>
                    <td>
                        <label for="email">Email</label>
                    </td>
                    <td>
                        <input type="email" id="email" name="email" placeholder="Enter your email" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">Password</label>
                    </td>
                    <td>
                        <input type="password" id="password" name="password" placeholder="Enter your password" required>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Login">
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><a href="Resetpwd.jsp" aria-label="Reset">Forgot Password?</a></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
