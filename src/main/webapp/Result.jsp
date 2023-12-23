<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Result Page</title>
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
    </style>
</head>
<body>
    <section class="container mt-4">
        <h1>Result Information</h1>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ResultID</th>
                    <th>SID</th>
                    <th>CourseID</th>
                    <th>Grade</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="result" items="${resultList}">
                    <tr>
                        <td>${result.resultID}</td>
                        <td>${result.sID}</td>
                        <td>${result.courseID}</td>
                        <td>${result.grade}</td>
                        <td class="action-links">
            <a href="UpdateCourseServlet?CourseID=${result.courseId}">Update</a>
        </td>
        <td class="action-links">
            <a href="javascript:void(0);" onclick="confirmDelete(${result.courseId})">Delete</a>
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
