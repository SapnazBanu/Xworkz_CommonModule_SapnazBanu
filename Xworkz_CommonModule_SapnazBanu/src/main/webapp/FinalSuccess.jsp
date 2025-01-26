<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <title>Final Success</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-color: #121212;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            height: 100vh;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
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
            max-width: 600px;
        }

        p {
            font-size: 24px;
            margin-bottom: 20px;
            color: #f5ba42;
        }

        .message {
            font-size: 18px;
            margin-bottom: 20px;
        }

        img {
            margin-top: 20px;
            border: 3px solid #f5ba42;
            border-radius: 8px;
        }

        a {
            color: #f5ba42;
            text-decoration: none;
            font-size: 16px;
            margin-top: 20px;
            display: inline-block;
        }

        a:hover {
            color: #fff;
            background-color: #f5ba42;
            padding: 10px;
            border-radius: 5px;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <p>Final Success!</p>
        <div class="message">
            <span>${message}</span>
        </div>
        <div class="file-info">
            <span>File Name: ${fileName}</span>
        </div>
        <img src="/download?fileName=${fileName}" alt="${fileName}" width="500" height="400">
        <a href="index.jsp">Go to Home</a>
    </div>
</body>
</html>
