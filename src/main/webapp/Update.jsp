<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Update Student</h2>
        <form action="UpdateServlet" method="post">
            <div class="form-group">
                <label for="SID">SID:</label>
                <input value="${st.SID}" type="text" class="form-control" id="SID" name="SID" readonly>
            </div>

            <div class="form-group">
                <label for="FirstName">First Name:</label>
                <input value="${st.firstName}" type="text" class="form-control" id="firstName" name="firstName" required>
            </div>

            <div class="form-group">
                <label for="LastName">Last Name:</label>
                <input value="${st.lastName}" type="text" class="form-control" id="lastName" name="lastName" required>
            </div>

            <div class="form-group">
                <label for="dob">Date of Birth:</label>
                <input ${st.DOB} type="date" class="form-control" id="DOB" name="DOB" required>
            </div>

            <div class="form-group">
                <label for="Email">Email:</label>
                <input ${st.email} type="email" class="form-control" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="CourseID">Course ID:</label>
                <input ${st.courseID} type="text" class="form-control" id="courseID" name="courseID" required>
            </div>

            <button type="submit" class="btn btn-primary">Update Student</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
