<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password - Crazy Foods</title>
    <style>
        /* General reset and font styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #FFECB3; /* Light orange background */
            color: #333;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* Profile container styling */
        .profile {
            background-color: white;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #FF6F00; /* Orange heading */
        }

        /* Form styling */
        form {
            display: flex;
            flex-direction: column;
        }

        table {
            width: 100%;
            margin-bottom: 20px;
        }

        td {
            padding: 10px;
            text-align: left;
            width: 50%;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #FFA500; /* Orange border */
            border-radius: 4px;
            font-size: 14px;
        }

        input[type="submit"] {
            background-color: #FF5722; /* Orange button */
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
            margin-top: 20px;
        }

        input[type="submit"]:hover {
            background-color: #FF8C00; /* Darker orange on hover */
        }

        /* Centering the form on small screens */
        @media (max-width: 480px) {
            .profile {
                width: 90%;
                padding: 15px;
            }
        }
    </style>
</head>
<body>
  <div class="profile">
    <h2>Update Password</h2>
    <form action="updatepassword">
        <table>
            <tr>
                <td>New Password:</td>
                <td><input type="text" name="newpassword"></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><input type="password" name="confirmpassword"></td>
            </tr>
        </table>
        <center><input type="submit" name="Submit" id=""></center>
    </form>
  </div>
</body>
</html>
