<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<head><title>学生页面</title></head>
  <header>
    <link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
    <script src="./bootstrap-5.1.3-dist/js/bootstrap.min.js"  crossorigin="anonymous"></script>

  </header>
  <main>
    <div class="container">
      <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <div class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
          <span class="fs-4">当前登录：${sessionScope.username}</span>
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
          <h1 class="fw-light">教师页面</h1>
          <p class="lead text-muted">您有<strong><font color="red">${requestScope.count}</font></strong>条待解答的问题，请点击下方按钮查看</p>
          <form name='form1' action='TeacherNewServlet' method='post'>
          <a href="javascript:document.form1.submit();" class="btn btn-primary">进行回答</a>
          </form>
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
            <h2>课程列表</h2>
            <p>显示自己所有讲授的课程列表。并可以选择进入某个课程的页面。进入课程页面后，可以查看当前的所有问题信息，并进行回答。</p>
            <a href="TeacherCourseServlet" class="btn btn-primary">
              点击进入
            </a>
          </div>
        </div>
        <div class="col d-flex align-items-start">
          <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
            <svg class="bi" width="1em" height="1em"><use xlink:href="#cpu-fill"/></svg>
          </div>
          <div>
            <h2>回答管理</h2>
            <br>
            <p>可以修改删除自己发表的任意回答信息</p>
            <br>
            <a href="TeacherAnswerServlet" class="btn btn-primary">
              点击进入
            </a>
          </div>
        </div>
        <div class="col d-flex align-items-start">
          <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
            <svg class="bi" width="1em" height="1em"><use xlink:href="#tools"/></svg>
          </div>
          <div>
            <h2>留言管理</h2>
            <br>
            <p>可以删除某个同学的提问信息</p>
            <br><br>
            <a href="TeacherDeleMessageServlet" class="btn btn-primary">
              点击进入
            </a>
          </div>
        </div>

        <div class="col d-flex align-items-start">
          <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
            <svg class="bi" width="1em" height="1em"><use xlink:href="#cpu-fill"/></svg>
          </div>
          <div>
            <h2>权限管理</h2>
            <p>可以设置自己的课程只允许某些同学浏览和提问，可以增加删除可以浏览提问该课程的学生</p>
            <br>
            <a href="AllExcludeServlet" class="btn btn-primary">
              点击进入
            </a>
          </div>
        </div>



      </div>
    </div>
  </main>
</html>
