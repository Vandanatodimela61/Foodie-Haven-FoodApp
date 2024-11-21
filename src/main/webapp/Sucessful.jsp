<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Successful</title>
    <style>
        /* Color Palette */
        :root {
            --primary-color: #FF6F61;  /* Coral */
            --accent-color: #FF69B4;    /* Hot Pink */
            --bg-color: #F0F8FF;        /* AliceBlue */
            --text-color: #4B0082;      /* Indigo */
            --button-color: #32CD32;    /* Lime Green */
            --button-hover: #228B22;    /* Forest Green */
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: var(--bg-color);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            text-align: center;
            background-color: var(--primary-color);
            color: var(--text-color);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 8px 30px rgba(0, 0, 0, 0.2);
            max-width: 500px;
            width: 90%;
            animation: fadeIn 1.5s ease-in-out;
        }

        h1 {
            font-size: 2.5em;
            color: var(--accent-color);
            margin-bottom: 20px;
            animation: bounceIn 2s infinite;
        }

        p {
            font-size: 1.2em;
            color: var(--text-color);
            margin-bottom: 30px;
        }

        .button {
            background-color: var(--button-color);
            color: white;
            padding: 15px 30px;
            text-decoration: none;
            font-size: 1.1em;
            border-radius: 8px;
            transition: background-color 0.3s, transform 0.3s;
        }

        .button:hover {
            background-color: var(--button-hover);
            transform: scale(1.05);
        }

        /* Keyframe Animations */
        @keyframes fadeIn {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        @keyframes bounceIn {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-10px);
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🎉 Congratulations! 🎉</h1>
        <p>Your registration was successful! Welcome to Crazy Foods, where your cravings will always be satisfied. Start exploring and enjoy a world of delicious flavors delivered to your doorstep!</p>
        <a href="Login.jsp" class="button">Proceed to Login</a>
    </div>
</body>
</html>
