<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
<head>
    <title>管理员页面：留言管理</title>
    <script>

    </script>
</head>
<body>
<header>
    <link href="bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="bootstrap-5.1.3-dist/js/bootstrap.min.js" crossorigin="anonymous"></script>

</header>
<main>
    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <div class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
                <span class="fs-4">当前用户：${sessionScope.username}</span>
            </div>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="alterPassword.jsp" class="nav-link" aria-current="page">修改密码</a></li>
                <li class="nav-item"><a href="login.jsp" class="nav-link active" aria-current="page">退出登录</a></li>
            </ul>
        </header>
    </div>

    <section class="py-3 text-center container" style="background-color: honeydew">
        <div class="row py-lg-3">
            <div class="col-lg-6 col-md-8 mx-auto">

                <c:if test="${sessionScope.status.equals(admin)}">
                <h1 class="fw-light">管理员页面：留言管理</h1>
                <a href="adminsterPage.jsp" class="btn btn-primary">返回管理员界面</a>
                </c:if>
                <c:if test="${sessionScope.status.equals(student)}">
                    <h1 class="fw-light">学生页面：留言管理</h1>
                    <a href="StudentNewServlet" class="btn btn-primary">返回学生界面</a>
                </c:if>
                <button type="button" class="btn btn-secondary my-2" onclick="history.back(-1);">返回上一界面</button>
            </div>
        </div>
    </section>

    <br><br>

    <form method="post" action="UpdateMessageServlet">
        <div align="center">
            <input type="hidden" name="id" value="${param.id}">
            <h3>请输入课程的信息:<br><br>
                标题：<input type="text" name="title" value="${param.title}" required="required"><br><br>
                内容：
                <textarea  id="answer" rows="5" cols="50"name="text" required="required"></textarea>
                <script>
                    document.getElementById("answer").value="${param.text}"
                </script>
                <br><br>
                <input type="submit" name="submit" >
            </h3>

        </div>
    </form>


</main>
</body>
</html>


