<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>管理员页面</title></head>
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
<%--    <c:if test="${empty sessionScope.username}"> </c:if>--%>

<%--    <% if(request.getSession().getAttribute("userId")==null) response.sendRedirect("/common/toLogin.action"); %>--%>
    <section class="py-3 text-center container" style="background-color: honeydew">
      <div class="row py-lg-3">
        <div class="col-lg-6 col-md-8 mx-auto">
          <h1 class="fw-light">管理员页面</h1>
        </div>
      </div>
    </section>


    <div class="container px-4 py-5" style="background-color: #e7f1ff">
      <div class="row g-4 py-5 row-cols-1 row-cols-lg-4">
        <div class="col d-flex align-items-start">
          <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
            <svg class="bi" width="1em" height="1em"><use xlink:href="#toggles2"/></svg>
          </div>
          <div>
            <h2>课程管理</h2>
            <p>增删改课程信息，包括课程名称，授课教师，课程内容描述，开课学院。</p>
            <a href="AllCourseServlet" class="btn btn-primary">
              点击进入
            </a>
          </div>
        </div>
        <div class="col d-flex align-items-start">
          <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
            <svg class="bi" width="1em" height="1em"><use xlink:href="#cpu-fill"/></svg>
          </div>
          <div>
            <h2>教师管理</h2>
            <p>增删改教师，包括教师名称，所讲授课程，教师职称，教师简介</p>
            <a href="AllTeacherServlet" class="btn btn-primary">
              点击进入
            </a>
          </div>
        </div>
        <div class="col d-flex align-items-start">
          <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
            <svg class="bi" width="1em" height="1em"><use xlink:href="#tools"/></svg>
          </div>
          <div>
            <h2>学院管理</h2>
            <p>增删改学院信息</p>
            <br>


            <form name='form1' action='AllCollegeServlet' method='post'>
              <a href='javascript:document.form1.submit();' class="btn btn-primary">点击进入</a>
            </form>
          </div>
        </div>
        <div class="col d-flex align-items-start">
          <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
            <svg class="bi" width="1em" height="1em"><use xlink:href="#cpu-fill"/></svg>
          </div>
          <div>
            <h2>留言管理</h2>
            <p>删除或修改所有课程交流和留言信息。</p>
            <a href="AllMessageServlet" class="btn btn-primary">
              点击进入
            </a>
          </div>
        </div>
      </div>
    </div>




  </main>
</html>
