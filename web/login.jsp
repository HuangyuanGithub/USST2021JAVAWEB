<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>登录系统</title>
    <link href="register.css" rel="stylesheet">
</head>
<body>
<div class="form-div">
    <div class="reg-content">
        <h1>欢迎登录答疑系统</h1>
    </div>
    <form action="LoginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                </td>

            </tr>
            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">

                </td>
            </tr>
        </table>
<%--        <input type="checkbox" name="check" value="check" align="center"/>记住自动登录<br>--%>
        <div class="buttons">
            <input value="登 录" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
    <br>
    <a href="register.jsp"><h4 align="center">新学生用户请注册</h4></a>
</div>
</body>
</html>