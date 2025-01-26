<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>

    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #121212;
            color: #ffffff;
            margin: 0;
            padding: 0;
        }

        h4 {
            text-align: center;
            color: #f5ba42;
            margin-top: 20px;
        }

        .container {
            width: 50%;
            margin: 0 auto;
            background-color: #1e1e1e;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.6);
            margin-top: 40px;
        }

        .form-group label {
            font-weight: bold;
            color: #f5ba42;
        }

        .form-control {
            background-color: #2b2b2b;
            color: #ffffff;
            border: 1px solid #444;
            border-radius: 8px;
        }

        .form-control:focus {
            background-color: #333;
            color: #ffffff;
            border-color: #f5ba42;
        }

        .btn-success {
            background-color: #f5ba42;
            border: none;
            color: #121212;
            font-weight: bold;
            border-radius: 8px;
            padding: 10px 20px;
            transition: all 0.3s;
        }

        .btn-success:hover {
            background-color: #ffcc66;
        }

        .error-msg {
            color: #ff4c4c;
            text-align: center;
            margin-bottom: 10px;
        }

        .msg {
            color: #4caf50;
            text-align: center;
            margin-bottom: 10px;
        }

        .navbar-custom {
            background-color: #1e1e1e;
            padding: 10px 0;
        }

        .navbar-brand img {
            height: 50px;
        }

        .navbar-nav {
            margin-left: auto;
        }

        .nav-link {
            font-size: 14px;
            color: #f5ba42;
            text-decoration: none;
            padding: 5px 10px;
        }

        .nav-link:hover {
            color: #ffcc66;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-custom">
    <a class="navbar-brand" href="https://x-workz.in/">
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz Logo">
    </a>
    <div class="navbar-nav ml-auto">
        <a class="nav-link" href="SignUp.jsp">SignUp</a>
        <a class="nav-link" href="SignIn.jsp">SignIn</a>
    </div>
</nav>

<div class="error-msg">
    ${ForgotError}
</div>

<div class="container">
    <h4>Set Your Password</h4>

    <form action="forgotPassword" method="POST">

        <div class="form-group">
            <label for="email" class="font-weight-bold">Email:</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
        </div>

        <div class="form-group">
            <label for="newPassword" class="font-weight-bold">New Password:</label>
            <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="Enter your new password" required>
        </div>

        <div class="form-group">
            <label for="confirmPassword" class="font-weight-bold">Confirm Password:</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Re-enter your new password" required>
        </div>

        <div class="form-group button-container">
            <button type="submit" class="btn btn-success">Save</button>
        </div>

        <div class="message">
            <p>${message}</p>
        </div>
    </form>
</div>

</body>
</html>
