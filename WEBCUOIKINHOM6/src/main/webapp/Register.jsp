<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">User Registration</h2>
        <form action="RegisServlet" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="user">UserName</label>
                    <input type="text" class="form-control" name="username" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="password">PassWord</label>
                    <input type="text" class="form-control" name="password" required>
                </div>
                </div>
                                            <button type="submit" class="btn btn-primary">Register</button>
                
                </form>
                
                 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>