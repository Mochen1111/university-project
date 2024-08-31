<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        $(document).ready(function (){
            $(".btnSub").on("click",function (){
                let eid = $("#eid").val();
                let password = $("#password").val();
                let name = $("#name").val();
                let sex = $("#sex").val();
                let age = $("#age").val();
                let aid = $("#aid").val();
                $.ajax({
                    url:"${pageContext.request.contextPath}/UpdateEmp",
                    type:"post",
                    data:JSON.stringify({eid:eid,password:password,name:name,sex:sex,age:age,aid:aid}),
                    contentType:"application/json;charset-UTF-8",
                    dataType:"json",
                    success:function (map) {
                        var str = map.employee;
                        var str1 = "修改后的信息为：\n" +
                            str.eid + "\n" +
                            str.password + "\n" +
                            str.name + "\n" +
                            str.sex + "\n" +
                            str.age + "\n" +
                            str.aid;
                        alert(str1);
                    },
                    error:function (){
                        alert("error");
                    }
                })
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
        .alltable{
            position: relative;
            width: 400px;
            top: 20%;
            left: 38%;
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
            top: 20%;
            left: 41%;
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
<div class="h"><h1>&nbsp管理员信息修改</h1></div>
<div class="alltable">
    <table class="table1"id="updateAd" border="1px">
        <tr>
            <td>职工号：</td><td><input type="text" readonly value="${employee.eid}" name="eid" id="eid"></td>
        </tr>
        <tr>
            <td>修改密码：</td><td><input type="password" value="${employee.password}" name="password" id="password"></td>
        </tr>
        <tr>
            <td>姓名：</td><td><input type="text" value="${employee.name}" name="name" id="name"></td>
        </tr>
        <tr>
            <td>性别：</td><td><input type="text" value="${employee.sex}" name="sex" id="sex"></td>
        </tr>
        <tr>
            <td>年龄：</td><td><input type="text" value="${employee.age}" name="age" id="age"></td>
        </tr>
        <tr>
            <td>管理楼号：</td><td><input type="text" value="${employee.aid}" name="aid" id="aid"></td>
        </tr>
        <tr>
            <td colspan="2"><button class="btnSub">提交信息</button></td>
        </tr>
    </table>
</div>
</body>
</html>