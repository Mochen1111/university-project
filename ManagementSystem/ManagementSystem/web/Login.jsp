<%--
  Created by IntelliJ IDEA.
  User: 27468
  Date: 2024/1/12
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        html {
            height: 100%;
        }
        body {
            height: 100%;
        }
        .container {
            height: 100%;
            background-color: #d1d793;
        }
        .login-wrapper {
            background-color: #ebebcd;
            width: 358px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%,-50%);
        }
        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }
        .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128,125,125);
            font-size: 15px;
            outline: none;
        }
        .input-item::placeholder {
            text-transform: uppercase;
        }
        .btn {
            text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 40px;
            background-color: #d1d793;
            color: #fff;
            cursor: pointer;
        }
        a {
            text-decoration-line: none;
            color: #abc1ee;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="login-wrapper">
            <div class="header">宿舍管理系统登录</div>
            <div class="form-wrapper">
                <form action="${pageContext.request.contextPath}/login" method="post">
                <input type="text" name="eid" placeholder="职工号" class="input-item">
                <input type="password" name="password" placeholder="请输入密码" class="input-item">
                <input type="submit" value="Login" class="btn">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
