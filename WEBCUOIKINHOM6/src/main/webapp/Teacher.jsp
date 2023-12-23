<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Teacher Information</title>
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

        .teacher-link {
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
        <h1>Thông Tin Giảng Viên</h1>
        <button onclick="window.location.href='AddTeacher.jsp'">Add Teacher</button>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>TeacherID</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>DOB</th>
                    <th>Email</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${teacherList}">
                    <tr>
                        <td>${c.teacherID}</td>
                        <td>${c.firstName}</td>
                        <td>${c.lastName}</td>
                        <td>${c.DOB}</td>
                        <td>${c.email}</td>
                        <td class="action-links">
                            <a href="UpdateTeacherServlet?TeacherID=${c.teacherID}">Update</a>
                        </td>
                       <td class="action-links">
    <a href="javascript:void(0);" onclick="confirmDelete('${c.teacherID}')">Xóa</a>
</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
    <script>
        function confirmDelete(teacherID) {
            if (confirm('Bạn có chắc chắn muốn xóa giáo viên này không?')) {
                window.location.href = 'DeleteTeacherServlet?TeacherID=' + teacherID;
            }
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
