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
                    <h1 class="fw-light">学生页面</h1>
                    <p class="lead text-muted">您有<strong><font color="red">${requestScope.count}</font></strong>条解答未查看，请点击下方按钮查看</p>
                    <form name='form1' action='StudentNewServlet' method='post'>
                        <a href="javascript:document.form1.submit();" class="btn btn-primary">查看解答</a>
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
                        <h2>浏览课程</h2>
                        <p>可以按学院，教师分类浏览所有课程列表。可以选择进入某课程的页面，并显示该课程的相关信息和简介，以及该课程的所有留言问题与教师解答</p>

                        <a href="AllCollegeServlet" class="btn btn-primary">
                            按学院浏览
                        </a>&nbsp;&nbsp;&nbsp;

                        <a href="AllTeacherServlet" class="btn btn-primary">
                            按教师浏览
                        </a>
                    </div>
                </div>
                <div class="col d-flex align-items-start">
                    <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                        <svg class="bi" width="1em" height="1em"><use xlink:href="#cpu-fill"/></svg>
                    </div>
                    <div>
                        <h2>发表提问</h2>
                        <br>
                        <p>可以提出针对某课程的问题留言。留言包括标题，内容，时间日期。</p>
                        <br>
                        <a href="PostMessageServlet" class="btn btn-primary">
                            点击进入
                        </a>
                    </div>
                </div>
                <div class="col d-flex align-items-start">
                    <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                        <svg class="bi" width="1em" height="1em"><use xlink:href="#tools"/></svg>
                    </div>
                    <div>
                        <h2>留言总览</h2>
                        <p>可以浏览查看当前系统中所有学生的留言提问和教师回答，并可以按课程，教师，学院，以及问题内容的关键字等进行检索。</p>
                        <a href="StudentAllMessageServlet" class="btn btn-primary">
                            点击进入
                        </a>
                    </div>
                </div>
                <div class="col d-flex align-items-start">
                    <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                        <svg class="bi" width="1em" height="1em"><use xlink:href="#cpu-fill"/></svg>
                    </div>
                    <div>
                        <h2>管理留言</h2>
                        <br>
                        <p>可以查看修改或者删除自己发表的留言。</p>
                        <br>
                        <a href="StudentAlterMessageServlet" class="btn btn-primary">
                            点击进入
                        </a>
                    </div>
                </div>
            </div>
        </div>




    </main>
</html>
