<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
<head>
    <title>管理员页面：课程管理</title>
    <script>
        function del(){
            if(confirm("是否删除")) {
                return true;
            }else{
                return false;
            }
        }
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
                <h1 class="fw-light">管理员页面：课程管理<br>（查看教师）</h1>
                <a href="adminsterPage.jsp" class="btn btn-primary">返回管理员界面</a>

                <form id="form1" action="AllCourseServlet" method="post">
                    <button  class="btn btn-secondary my-2" onclick="document.getElementById('form1').submit();">返回上一界面</button>
                </form>
            </div>
        </div>
    </section>
    <br><br>
    <div align="center">当前课程：${sessionScope.courseName}</div>
    <div>
        <table align="center" border="3" cellspacing="0" class="table">
            <tr align="center">
                <th>序号</th>
                <th>用户名</th>
                <th>职位</th>
                <th>基本信息</th>
                <th>操作</th>
            </tr>
            <c:forEach var="list" items="${requestScope.list}" varStatus="status">
                <tr align="center">
                    <td>${status.count}</td>
                    <td>${list.username}</td>
                    <td>${list.position}</td>
                    <td>${list.detail}</td>
                    <td><a onclick="javascript:return del()" href="UpdateTeachTeacherServlet?ID=${requestScope.ID}&id=${list.id}" style="color: red">删除</a><td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div align="center"><a href="UpdateTeachCourseServlet?id=${requestScope.ID}&name=${requestScope.name}" class="btn btn-primary" >+新增老师</a></div>
</main>
</body>
</html>

