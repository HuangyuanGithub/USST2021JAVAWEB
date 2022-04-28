<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
<head>
    <title>学生页面：课程浏览</title>
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
                <h1 class="fw-light">学生页面：课程浏览</h1>
                <a href="StudentNewServlet" class="btn btn-primary">返回学生界面</a>
                <button type="button" class="btn btn-secondary my-2" onclick="history.back(-1);">返回上一界面</button>
            </div>
        </div>
    </section>
    <c:forEach var="list" items="${requestScope.courseList}" varStatus="status">
    <div align="center">
        <dl >
        <dt>${list.name}</dt>
        <dd>${list.collegeName}</dd>
        <dd>${list.detail}</dd>
        </dl>
    </div>
    </c:forEach>
    <br><br>
    <div>
        <table align="center" border="3" cellspacing="0" class="table">
            <tr align="center">
                <th>序号</th>
                <th>标题</th>
                <th>内容</th>
                <th>日期</th>
                <th>回答</th>
            </tr>
            <c:forEach var="list" items="${requestScope.messageList}" varStatus="status">
                <tr align="center">
                    <td>${status.count}</td>
                    <td>${list.title}</td>
                    <td>${list.text}</td>
                    <td>${list.date}</td>
                    <c:if test="${empty list.answer}">
                        <td>未解答</td>
                    </c:if>
                    <c:if test="${not empty list.answer}">
                        <td>${list.answer}</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>

