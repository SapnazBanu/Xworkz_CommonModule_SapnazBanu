<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('https://img.freepik.com/free-vector/abstract-geometric-wireframe-background_52683-59421.jpg?t=st=1734447885~exp=1734451485~hmac=f79025d1558a8b817a03c67c11eed60262c407ad7d6f5d8edbf3f95bdaea5389&w=996');
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333; /* For readability */
        }
        /* Header Section */
        .header {
            padding: 15px;
            background-color: rgba(63, 81, 181, 0.85); /* Semi-transparent indigo */
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 2px solid #5c6bc0;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
        }
        .logo img {
            height: 60px;
        }
        .auth-links a {
            font-size: 1.2em;
            margin-right: 15px;
            text-decoration: none;
            color: #b39ddb; /* Light purple */
            font-weight: bold;
            transition: color 0.3s;
        }
        .auth-links a:hover {
            color: #9575cd; /* Darker purple on hover */
        }

        /* Content Container */
        .container {
            background-color: rgba(255, 255, 255, 0.9); /* Lightened semi-transparent white */
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);
            margin-top: 80px;
        }
        h1 {
            font-size: 2.8rem;
            margin-bottom: 20px;
            color: #512da8; /* Deep purple */
            font-weight: bold;
        }
        p {
            font-size: 1.2em;
            color: #3f51b5; /* Indigo for subtle contrast */
        }

        /* Footer Section */
        footer {
            margin-top: 50px;
            text-align: center;
            color: #d1c4e9; /* Light purple for the footer text */
            font-size: 1em;
            padding: 10px;
            background-color: rgba(63, 81, 181, 0.7); /* Footer background */
        }
        footer p {
            margin: 0;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <div class="header">
        <div class="logo">
            <img src="https://th.bing.com/th?id=OIP.5W588qZyeMAuWUs1PAIKyAAAAA&w=250&h=250&c=8&rs=1&qlt=90&o=6&pid=3.1&rm=2" alt="Logo">
        </div>
        <div class="auth-links">
            <a href="Signin.jsp" class="signin-link">SignIn</a>
            <a href="Signup.jsp" class="signup-link">SignUp</a>
        </div>
    </div>

    <!-- Body Content -->
    <div class="container text-center">
        <h1>Welcome to Sapna's Codeverse</h1>
        <p>Journey to coding excellence begins here.</p>
    </div>
    <!-- Bootstrap JS (Optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
