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
        .btn1{
            border: none;
            cursor:pointer;
            width: 80px;
            height:40px;
            border-radius: 15%;
            background-color: #b8dfba;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btn1:hover{
            background-color: #8ebdb8;
            color: #fff;
        }
        .alltable{
            width: 400px;
            position: absolute;
            top: 210px;
            left: 640px;
        }
        .table1{
            display: inline-block;
            position: relative;
            top: 10%;
            left: 0%;
            border-collapse: collapse;
            background-color: #d1d793;
        }
        .h{
            position: absolute;
            top: 160px;
            left: 630px;
        }

    </style>
</head>
<body>
<div class="head">
    <div class="dao1">
        <table class="dao11" frame=vsides rules="cols" >
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
<div class="h"><h1>管理员详细信息</h1></div>
<div class="alltable">

    <table class="table1" border="1px">
        <tr>
            <td>职工号：</td><td>${list.get(0).eid}</td>
        </tr>
        <tr>
            <td>密码：</td><td>${list.get(0).password}</td>
        </tr>
        <tr>
            <td>姓名：</td><td>${list.get(0).name}</td>
        </tr>
        <tr>
            <td>性别：</td><td>${list.get(0).sex}</td>
        </tr>
        <tr>
            <td>年龄：</td><td>${list.get(0).age}</td>
        </tr>
        <tr>
            <td>管理楼号:</td><td>${list.get(0).aid}</td>
        </tr>
        <tr>
            <td colspan="2"><button class="btn1"id="updateEmp" onclick="window.location.href='${pageContext.request.contextPath}/updateEmp?eid='+${list.get(0).eid}">修改信息</button></td>
        </tr>
    </table>
</div>
</body>
</html>