<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
<head>
    <title>学生页面：留言总览</title>
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
                <h1 class="fw-light">学生页面：留言总览</h1>
                <a href="StudentNewServlet" class="btn btn-primary">返回学生界面</a>
            </div>
        </div>
    </section>
    <br><br>
    <div align="center">
        <form action="StudentAllMessageServlet" method="post">
        查询：<input type="text" name="keyword" align="center" value="${requestScope.keyword}">
        <input type="submit" >
    </form>
    </div>

    <div>
        <table align="center" border="3" cellspacing="0" class="table">
            <tr align="center">
                <th>序号</th>
                <th>留言标题</th>
                <th>留言内容</th>
                <th>留言人</th>
                <th>课程</th>
                <th>学院</th>
                <th>日期</th>
                <th>回答</th>
            </tr>
            <c:forEach var="list" items="${requestScope.messageList}" varStatus="status">
                <tr align="center">
                    <td>${status.count}</td>
                    <td>${list.title}</td>
                    <td>${list.text}</td>
                    <td>${list.studentName}</td>
                    <td>${list.courseName}</td>
                    <td>${list.answer}</td>
                    <td>${list.date}</td>

                    <c:if test="${not empty list.teacherName}">
                        <td><a href="StudentAnswerServlet?id=${list.id}">查看回答</a></td>
                    </c:if>
                    <c:if test="${empty list.teacherName}">
                        <td>未回答</td>
                    </c:if>


                </tr>

            </c:forEach>
        </table>


    </div>













        </div>
    </form>
</main>

</body>
</html>
