<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vn">
<head>
<img src="header-logo.png" alt="Logo" class="logo">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
   body::before {
    content: '';
    position: fixed;
    top: 0;
    left: 23%;
    width: 4px; 
    height: 100%;
    background-color: #ccc; 
    z-index: 3; 
}

body {
            font-family: 'Times New Roman', sans-serif;
            background-image: url('UED'); 
            background-size: cover; 
            background-repeat: repeat; 
            margin: 0;
            padding: 0;
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

 header {
            background-color: rgba(51, 51, 51, 0.5); 
            color: #fff;
            padding: 1em;
            width: 100%;
            position: relative;
        }


h1 {
    margin-bottom: 1em;
}

.logo {
    position: absolute;
    top: 10px;
    left: 80px;
    max-width: 2000px;
    max-height: 1000px;
}

.logout-btn {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin-top: 20px;
    cursor: pointer;
    position: absolute;
    top: 10px;
    right: 10px;
}

nav {
    margin-top: 10px;
    margin-left: 70px;
    display: flex;
    flex-direction: column;
    padding: 10px;
    width: 100%;
    align-items: flex-start;
    z-index: 1;
    position: relative;
    margin-bottom: 20px;
}

nav a {
    text-decoration: none;
        font-weight: bold;
        margin-bottom: 10px;
        padding: 5px;
        transition: color 0.3s, background-color 0.3s;
}

  nav a:hover {
        color: #fff;
        background-color: #555;
    }

section {
    margin: 20px;
    z-index: 2;
    position: relative;
}

.dark-background {
    background-color: #a6a6a6;
    height: 100vh;
    width: 100%;
    position: fixed;
    top: 0;
    left: 0;
    opacity: 0; 
    transition: opacity 0.3s;
}
    </style>
</head>
<body>

<div class="dark-background"></div>
    <header>
        <h1></h1>
    </header>
    <nav>       
        <a href="javascript:void(0);" onclick="loadContent('StudentServlet')">Thông tin sinh viên</a>
        <a href="javascript:void(0);" onclick="loadContent('TeacherServlet')">Thông tin giảng viên</a>
            <a href="javascript:void(0);" onclick="loadContent('CourseServlet')">Khóa học</a>
                    <a href="javascript:void(0);" onclick="loadContent('ResultServlet')">Kết quả</a>
        
    </nav>
    <form action="LogoutServlet" method="post">
        <button type="submit" class="logout-btn">Logout</button>
    </form>
    <section id="contentSection">
    </section>
    <script>
    function loadContent(page) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                document.getElementById('contentSection').innerHTML = xhr.responseText;
            }
        };
        xhr.open('GET', page, true);
        xhr.send();
    }
</script>

</body>
</html>
