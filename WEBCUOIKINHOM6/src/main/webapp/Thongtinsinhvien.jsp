<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông Tin Sinh Viên</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
        }

        section {
            margin: 20px;
            padding-left: 0; 
        }
         table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        h1 {
            color: #007bff;
        }

        .nav-link {
            color: #000000;
        }

        .teacher-link {
            color: #ffffff;
        }

        .action-links {
            display: flex;
            justify-content: space-between;
        }
    </style>
</head>
<body>
    <section class="container mt-4">
        <h1>Thông Tin Sinh Viên</h1>
        <button onclick="window.location.href='AddStudent.jsp'">Add Student</button>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>SID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>DOB</th>
                    <th>Email</th>
                    <th>CourseID</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="x" items="${studentList}">
                    <tr>
                        <td>${x.SID}</td>
                        <td>${x.firstName}</td>
                        <td>${x.lastName}</td>
                        <td>${x.DOB}</td>
                        <td>${x.email}</td>
                        <td>${x.courseID}</td>
                        
                        <td class="action-links">
                            <a href="UpdateServlet?SID=${x.SID}">Update</a>
                        </td>
                        <td class="action-links">
                            <a href= "DeleteServlet?SID${x.SID}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <script>
            function confirmDelete(SID) {
                var result = confirm('Are you sure you want to delete this student?');
                
                if (result) {
                    window.location.href = 'DeleteServlet?SID=' + SID;
                }
            }
        </script>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </section>
</body>
</html>
