<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .head{
            background-color: #8ebdb8;
        }
        .dao11{
            margin: 0 auto;
        }

        .leadbtn{
            font-size: 20px;
            color:#fff;
            background: rgba(0, 0, 0, 0);
            width: 150px;
            height: 50px;
            border: none;
            cursor: pointer;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;

        }
        .leadbtn:hover{
            background-color:#b8dfba ;
            color:black;
        }
        body{
            background-color: #ebebcd;
        }
        td{
            text-align: center;
            border-collapse: collapse;
            padding-left: 20px;
            padding-right: 20px;
            padding-top: 10px;
            padding-bottom: 10px;
        }
        .alltable{
            background-color: #d1d793;
            width: 350px;
            height:320px;
            border-radius: 5%;
            position: relative;
            left: 40%;
            top:20%;
        }
        .h{
            font-size: 30px;
            position: absolute;
            top: -30%;
            left:15%
        }
        .btnSub{
            border: none;
            cursor:pointer;
            width: 80px;
            height:40px;
            border-radius: 15%;
            background-color: #b8dfba;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btnSub:hover{
            background-color: #8ebdb8;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="head">
    <div class="dao1">
        <table class="dao11" frame=vsides rules="cols">
            <tr>
                <td><button class="leadbtn" onclick="window.location.href='${pageContext.request.contextPath}/allocation'">分配宿舍</button></td>
                <td><button class="leadbtn" onclick="window.location.href='${pageContext.request.contextPath}/showAdmin'">管理员信息管理</button></td>
                <td><button class="leadbtn" onclick="window.location.href='${pageContext.request.contextPath}/showStudent'">学生信息管理</button></td>
                <td><button class="leadbtn" onclick="window.location.href='${pageContext.request.contextPath}/showApartment'">公寓信息管理</button></td>
                <td><button class="leadbtn" onclick="window.location.href='${pageContext.request.contextPath}/peopleLog'">外来人员登记</button></td>
                <td><button class="leadbtn" onclick="window.location.href='${pageContext.request.contextPath}/goodManage'">宿舍楼物品管理</button></td>
                <td><button class="leadbtn" id="home" onclick="window.location.href='${pageContext.request.contextPath}/jumpToBigAdmin'">返回首页</button></td>
            </tr>
        </table>
    </div>
</div>
<div class="alltable">
    <div class="h"><h2 >添加管理员</h2></div>
    <form action="${pageContext.request.contextPath}/InsertAdmin" method="post">
        <table class="table1">
            <tr>
                <td>职工号：</td><td><input type="text"  name="eid" id="eid"></td>
            </tr>
            <tr>
                <td>密码：</td><td><input type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td>姓名：</td><td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>性别：</td><td><input type="text" name="sex" id="sex"></td>
            </tr>
            <tr>
                <td>年龄：</td><td><input type="text" name="age" id="age"></td>
            </tr>
            <tr>
                <td>管理楼号：</td><td><input type="text" name="aid" id="aid"></td>
            </tr>
            <tr>
                <td colspan="2"><button class="btnSub">提交信息</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>