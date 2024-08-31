<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.edu.tyut.pojo.Room" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        function jump(rid,aid){
            var url = "${pageContext.request.contextPath}/ShowRoomMore?rid="+ rid +"&aid=" + aid;
            window.location.href = url;
        }
        $(document).ready(function (){
            $("#myTableRoom").on("click",".btnSelect",function (){
                var currentRow=$(this).closest("tr");
                var col1=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值
                var col4=currentRow.find("td:eq(3)").text(); //获得当前行第四个TD值
                jump(col1,col4);
            })
        })
    </script>
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
        .table1{
            display: inline-block;
            position: relative;
            top: 10%;
            left: 0%;
            border-collapse: collapse;
            background-color: #d1d793;}

        .alltable{
            position: absolute;
            top:210px;
            left:400px;
            display: inline-block;
            border-collapse: collapse;
            background-color: #d1d793;
        }

        .btnSelect{
            border: none;
            cursor: pointer;
            background-color: #d1d793;
            color: #000;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btnSelect:hover{
            color: #fff;
        }
        .h{
            position: absolute;
            top: 130px;
            left: 610px;
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
<div class="h"><h1>楼内各宿舍信息</h1></div>
<div class="alltable">
    <table class="table1" id="myTableRoom" border="1px">
        <thead>
        <tr>
            <td>宿舍号</td>
            <td>应住人数</td>
            <td>实住人数</td>
            <td>楼号</td>
            <td>宿舍学生性别</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody id="roomList">
        <%
            List<Room> list = (List<Room>) request.getAttribute("room");
            if (list != null && list.size() != 0){
                for (Room room:
                        list) {
        %>
        <tr>
            <td><%=room.getRid()%></td>
            <td><%=room.getRpeople()%></td>
            <td><%=room.getNowrpeople()%></td>
            <td><%=room.getAid()%></td>
            <td><%=room.getSex()%></td>
            <td><button class='btnSelect'>查看详细信息</button></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>