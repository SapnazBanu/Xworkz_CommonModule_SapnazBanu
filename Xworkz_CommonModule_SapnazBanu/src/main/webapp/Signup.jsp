<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('https://img.freepik.com/free-vector/abstract-geometric-wireframe-background_52683-59421.jpg?t=st=1734447885~exp=1734451485~hmac=f79025d1558a8b817a03c67c11eed60262c407ad7d6f5d8edbf3f95bdaea5389&w=996');
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);
            margin-top: 80px;
        }

        h1 {
            font-size: 2.5rem;
            color: #512da8;
            font-weight: bold;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            color: #3f51b5;
        }

        .form-control {
            border-radius: 10px;
        }

        .btn-primary {
            background-color: #512da8;
            border: none;
            border-radius: 10px;
            padding: 10px 20px;
            transition: background-color 0.3s;
        }

        .btn-primary:hover {
            background-color: #3f51b5;
        }

        footer {
            margin-top: 50px;
            text-align: center;
            color: #d1c4e9;
            font-size: 1em;
            padding: 10px;
            background-color: rgba(63, 81, 181, 0.7);
        }
    </style>
</head>
<body>

    <div class="container">
        <h1 class="text-center">Sign Up</h1>
        <form action="SignupServlet" method="POST">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter your full name" required onchange="onNameChange()">
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required onchange="onEmailChange()">
            </div>

            <div class="form-group">
                <label for="altEmail">Alternate Email</label>
                <input type="email" class="form-control" id="altEmail" name="altEmail" placeholder="Enter your alternate email" onchange="onAltEmailChange()">
            </div>

            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter your phone number" required onchange="onPhoneChange()">
            </div>

            <div class="form-group">
                <label for="altPhone">Alternate Phone Number</label>
                <input type="text" class="form-control" id="altPhone" name="altPhone" placeholder="Enter your alternate phone number" onchange="onAltPhoneChange()">
            </div>

            <div class="form-group">
                <label for="location">Location</label>
                <input type="text" class="form-control" id="location" name="location" placeholder="Enter your location" required onchange="onLocationChange()">
            </div>

            <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
        </form>
        ${name}
    </div>

    <!-- JavaScript Functions -->
    <script>
        function onNameChange() {
            var name = document.getElementById('name').value;
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_SapnazBanu/name/" + name, true);
            xhttp.send();
        }

        function onEmailChange() {
            var email = document.getElementById('email').value;
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_SapnazBanu/email/" + email, true);
            xhttp.send();
        }

        function onAltEmailChange() {
            var altEmail = document.getElementById('altEmail').value;
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_SapnazBanu/altEmail/" + altEmail, true);
            xhttp.send();
        }

        function onPhoneChange() {
            var phone = document.getElementById('phone').value;
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_SapnazBanu/phone/" + phone, true);
            xhttp.send();
        }

        function onAltPhoneChange() {
            var altPhone = document.getElementById('altPhone').value;
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_SapnazBanu/altPhone/" + altPhone, true);
            xhttp.send();
        }

        function onLocationChange() {
            var location = document.getElementById('location').value;
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_SapnazBanu/location/" + location, true);
            xhttp.send();
        }
    </script>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
