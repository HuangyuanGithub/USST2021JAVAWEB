<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>修改密码</title></head>
<header>
    <link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
    <script src="./bootstrap-5.1.3-dist/js/bootstrap.min.js"  crossorigin="anonymous"></script>

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
                <h1 class="fw-light">修改密码</h1>
            </div>
        </div>
    </section>

    <br><br>

    <form action="AlterServlet" method="post">
        <input type="hidden" name="status" value="${sessionScope.status}">
        <input type="hidden" name="username" value="${sessionScope.username}">
        <br><br>
    <h3 align="center">
        用户名：${sessionScope.username}<br><br>

        请输入新的密码:<br>
        <input type="password" name="password"/><br><br>

        <input type="button" class="btn btn-secondary" onclick="history.back(-1);" value="返回">
        <input type="submit" class="btn btn-primary" value="提交">
    </h3>
    </form>






    </h3>



</main>
</html>

