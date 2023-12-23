<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Teacher</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
  <style>
        body {
            background-color: #f8f9fa; 
        }
        .container {
            background-color: #ffffff; 
            padding: 30px;
            border-radius: 10px; 
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
        }
        h2 {
            color: #007bff; 
        }
        label {
            color: #495057; 
        }
        .form-control {
            border-color: #007bff; 
        }
        .btn-primary {
            background-color: #007bff; 
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3; 
            border-color: #0056b3;
        }
    </style>
<body>
    <div class="container mt-4">
        <h2>Add Teacher</h2>
        <form action="AddTeacherServlet" method="post">
            <div class="form-group">
                <label for="TeacherID">TeacherID:</label>
                <input type="text" class="form-control" id="TeacherID" name="TeacherID" required>
            </div>

            <div class="form-group">
                <label for="FirstName">First Name:</label>
                <input type="text" class="form-control" id="FirstName" name="FirstName" required>
            </div>

            <div class="form-group">
                <label for="LastName">Last Name:</label>
                <input type="text" class="form-control" id="LastName" name="LastName" required>
            </div>

            <div class="form-group">
                <label for="dob">Date of Birth:</label>
                <input type="date" class="form-control" id="dob" name="DOB" required>
            </div>

            <div class="form-group">
                <label for="Email">Email:</label>
                <input type="email" class="form-control" id="Email" name="Email" required>
            </div>


            <button type="submit" class="btn btn-primary">Add Teacher</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
