<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Success</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background-color: #121212;
            color: #ffffff;
            font-family: Arial, sans-serif;
        }

        .alert-success {
            background-color: #28a745;
            color: #ffffff;
            border-radius: 10px;
            padding: 20px;
            font-size: 16px;
            text-align: center;
        }

        .message {
            font-size: 18px;
            color: #f5ba42;
            text-align: center;
            margin-top: 20px;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="alert alert-success" role="alert">
            You have updated your profile successfully!!
        </div>

        <div class="message">
            ${message}
        </div>
    </div>
</body>
</html>
