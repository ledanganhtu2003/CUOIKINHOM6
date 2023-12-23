<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Course</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Update Course</h2>
        <form action="UpdateCourseServlet" method="post">
            <div class="form-group">
                <label for="CourseID">CourseID:</label>
                <input value="${course.courseId}" type="text" class="form-control" id="CourseID" name="CourseID" readonly>
            </div>

            <div class="form-group">
                <label for="CourseName">CourseName:</label>
                <input value="${course.courseName}" type="text" class="form-control" id="CourseName" name="CourseName" required>
            </div>

            <div class="form-group">
                <label for="TeacherID">TeacherID:</label>
                <input value="${course.teacherId}" type="text" class="form-control" id="TeacherID" name="TeacherID" required>
            </div>

            <div class="form-group">
                <label for="Time">Time:</label>
                <input value="${course.time}" type="text" class="form-control" id="Time" name="Time" required>
            </div>

            <button type="submit" class="btn btn-primary">Update Course</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
