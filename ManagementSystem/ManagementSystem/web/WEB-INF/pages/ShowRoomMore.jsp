<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.edu.tyut.pojo.Student" %>
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
            position: absolute;
            top: 210px;
            left:200px;
        }
        .table1{
            display: inline-block;
            position: relative;
            top: 10%;
            left: 0%;
            border-collapse: collapse;
            background-color: #d1d793;}
        .h{
            position: absolute;
            top: 160px;
            left: 650px;
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
<div class="h"><h1>宿舍内信息</h1></div>
<div class="alltable">
    <table class="table1"id="myTableRoom" border="1px">
        <thead>
        <tr>
            <td width="100px">学号</td>
            <td width="100px">姓名</td>
            <td width="100px">性别</td>
            <td width="160px">专业</td>
            <td width="100px">年级</td>
            <td width="100px">班级</td>
            <td width="100px">宿舍状态</td>
        </tr>
        </thead>
        <tbody id="roomList">
        <%
            Student[] student = (Student[]) request.getAttribute("student");
            if (student != null && student.length != 0){
                for (int i = 0;i < student.length; i++) {
        %>
        <tr>
            <td><%=student[i].getSid()%></td>
            <td><%=student[i].getName()%></td>
            <td><%=student[i].getSex()%></td>
            <td><%=student[i].getMajor()%></td>
            <td><%=student[i].getGrade()%></td>
            <td><%=student[i].getStuclass()%></td>
            <td><%=student[i].getState()%></td>
        </tr>
        <%
            }
        }else {
        %>
        <tr>
            <td colspan="7">暂无学生入住</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
