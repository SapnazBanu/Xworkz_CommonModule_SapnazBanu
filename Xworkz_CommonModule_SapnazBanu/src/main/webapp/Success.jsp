<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success Page</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #121212;
            color: #fff;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url('https://th.bing.com/th/id/OIP.QhgRvtMFC7Ih3SeUPY88egHaEo?w=262&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7');
            background-size: cover;
            background-position: center;
        }

        .container {
            text-align: center;
            background-color: rgba(0, 0, 0, 0.7);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.5);
            width: 80%;
            max-width: 500px;
        }

        h1 {
            color: #f5ba42;
            font-size: 30px;
        }

        p {
            font-size: 18px;
            color: #ddd;
        }

        .btn {
            background-color: #f5ba42;
            color: black;
            padding: 12px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
            display: inline-block;
        }

        .btn:hover {
            background-color: #fff;
            color: #f5ba42;
            border: 1px solid #f5ba42;
        }

        .message {
            color: #f5ba42;
            font-size: 18px;
            margin-top: 20px;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>User successfully signed in!</h1>
        <a href="index.jsp" class="btn">Go to Home</a>
        <a href="updateAgain" class="btn">Update Your Profile Here!</a>

        <div class="message">
            ${message}
        </div>
    </div>
</body>

</html>
