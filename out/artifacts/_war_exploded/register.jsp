<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>注册系统</title>
    <link href="register.css" rel="stylesheet">
</head>
<body>
<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册答疑系统</h1>
    </div>
    <form action="RegisterServlet" method="post">
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
<%--        <input type="checkbox" name="check" value="check" />记住自动登录<br>--%>
        <div class="buttons">
            <input value="注册并登录" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
    <br>
</div>
</body>
</html>
