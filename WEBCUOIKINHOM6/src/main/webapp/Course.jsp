<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Course</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
        }

        section {
            margin: 20px;
        }

        h1 {
            color: #007bff;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #dee2e6;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: #ffffff;
        }

        .action-links {
            float: right;
            margin-right: 20px;
            color: #ffffff;
            text-decoration: none;
            background-color: #007bff;
            padding: 10px 15px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <section class="container mt-4">
        <h1>Thông Tin Khóa Học</h1>
        <a href="AddCourse.jsp" class="btn btn-primary">Add Course</a>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>CourseID</th>
                    <th>CourseName</th>
                    <th>TeacherID</th>
                    <th>Time</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach var="a" items="${courseList}">
    <tr>
        <td>${a.courseId}</td>
        <td>${a.courseName}</td>
        <td>${a.teacherId}</td>
        <td>${a.time}</td>
        <td class="action-links">
            <a href="UpdateCourseServlet?CourseID=${a.courseId}">Update</a>
        </td>
        <td class="action-links">
            <a href="javascript:void(0);" onclick="confirmDelete(${a.courseId})">Delete</a>
        </td>
    </tr>
    
</c:forEach>
            </tbody>

        </table>
    </section>
    <script>
        function confirmDelete(courseId) {
            var result = confirm('Are you sure you want to delete this course?');
            
            if (result) {
                window.location.href = 'DeleteServlet?CourseID=' + courseId;
            }
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
