<%--
  Created by IntelliJ IDEA.
  User: 27468
  Date: 2024/1/12
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        body {
            background-color: #ebebcd;
        }
        .xiao{
            position: relative;

            top: 60px;
            text-align: center;
        }
        .g0{
            font-size: 30px;
            text-align: center;
        }
        .btn1{
            font-size: 20px;
            width: 200px;
            height:200px;
            outline: 3px;
            border: 3px;
            cursor: pointer;
            color: black;
            position: relative;
            border-radius: 100%;
            background-color: #b8dfba;
            z-index: 1;
            overflow: hidden;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btn1:hover{
            background-color: #8ebdb8;
            color: #fff;}


        .btn2{
            font-size: 20px;
            width: 200px;
            height:200px;
            outline: none;
            border: none;
            cursor: pointer;
            color: black;
            position: relative;
            border-radius:100%;
            background-color: #b8dfba;
            z-index: 1;
            overflow: hidden;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btn2:hover{
            background-color: #8ebdb8;
            color: #fff;
        }
        .btn3{
            font-size: 20px;
            width: 200px;
            height:200px;
            outline: none;
            border: none;
            cursor: pointer;
            color: black;
            position: relative;
            border-radius:100%;
            background-color: #b8dfba;
            z-index: 1;
            overflow: hidden;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btn3:hover{
            background-color: #8ebdb8;
            color: #fff;
        }
        .btn4{
            font-size: 20px;
            width: 200px;
            height:200px;
            outline: none;
            border: none;
            cursor: pointer;
            color: black;
            position: relative;
            border-radius:100%;
            background-color: #b8dfba;
            z-index: 1;
            overflow: hidden;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btn4:hover{
            background-color: #8ebdb8;
            color: #fff;}
        .btn5{
            font-size: 20px;
            width: 200px;
            height:200px;
            outline: none;
            border: none;
            cursor: pointer;
            color: black;
            position: relative;
            border-radius:100%;
            background-color: #b8dfba;
            z-index: 1;
            overflow: hidden;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btn5:hover{
            background-color: #8ebdb8;
            color: #fff;}
        .btn6{
            font-size: 20px;
            width: 200px;
            height:200px;
            outline: none;
            border: none;
            cursor: pointer;
            color: black;
            position: relative;
            border-radius:100%;
            background-color: #b8dfba;
            z-index: 1;
            overflow: hidden;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;

        }
        .btn6:hover{
            background-color: #8ebdb8;
            color: #fff;}
        .g1{
            text-align: center;
            top: 500px;
        }
        .table1{
            position: absolute;
            display: inline-block;
            vertical-align: bottom;
            padding: 20px;
            left: 0%;
            top: 50%;
        }
    </style>
</head>
<body>
<div class="g0">
    <h1>XX宿舍管理系统</h1>
</div>
<div class="g1">
    <div class="xiao">
        <h1>欢迎使用宿舍管理系统，您是超级管理员</h1><br>
        <a href="${pageContext.request.contextPath}/Login.jsp">退出登录</a>
    </div>
    <table class="table1">
        <tr>
            <td>
                <form id="form1"action="${pageContext.request.contextPath}/allocation" method="post">
                    <button class="btn1">分配宿舍</button>
                </form>
            <td width="50px"></td>
            </td>
            <td>
                <form id="form2" action="${pageContext.request.contextPath}/showStudent" method="post">
                    <button class="btn2">学生信息管理</button>
                </form>
            </td>
            <td width="50px"></td>
            <td>
                <form id="form3" action="${pageContext.request.contextPath}/showApartment" method="post">
                    <button class="btn3">公寓信息管理</button>
                </form>
            </td>
            <td width="50px"></td>
            <td>
                <form id="form4" action="${pageContext.request.contextPath}/peopleLog" method="post">
                    <button class="btn4">外来人员登记</button>
                </form>
            </td>
            <td width="50px"></td>
            <td>
                <form id="form5" action="${pageContext.request.contextPath}/showAdmin" method="post">
                    <button class="btn5">管理员信息管理</button>
                </form>
            </td>
            <td width="50px"></td>
            <td>
                <form id="form6" action="${pageContext.request.contextPath}/goodManage" method="post">
                    <button class="btn6">宿舍楼物品管理</button>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>