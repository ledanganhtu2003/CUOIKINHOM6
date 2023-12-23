<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Teacher</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
        }

        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }

        h2 {
            color: #007bff;
            text-align: center;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        label {
            color: #555555;
        }

        .form-control {
            margin-bottom: 15px;
        }

        button {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Teacher</h2>
        <form action="UpdateTeacherServlet" method="post">
            <div class="form-group">
                <label for="TeacherID">TeacherID:</label>
                <input value="${tc.teacherID}" type="text" class="form-control" id="teacherID" name="teacherID" readonly>
            </div>

            <div class="form-group">
                <label for="FirstName">First Name:</label>
                <input value="${tc.firstName}" type="text" class="form-control" id="firstName" name="firstName" required>
            </div>

            <div class="form-group">
                <label for="LastName">Last Name:</label>
                <input value="${tc.lastName}" type="text" class="form-control" id="lastName" name="lastName" required>
            </div>

            <div class="form-group">
                <label for="dob">Date of Birth:</label>
                <input value="${tc.DOB}" type="date" class="form-control" id="DOB" name="DOB" required>
            </div>

            <div class="form-group">
                <label for="Email">Email:</label>
                <input value= "${tc.email}" type="email" class="form-control" id="email" name="email" required>
            </div>

        
            <button type="submit" class="btn btn-primary">Update Teacher</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
