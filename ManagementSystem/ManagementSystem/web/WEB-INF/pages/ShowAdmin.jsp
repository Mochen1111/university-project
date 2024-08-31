<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        function jump(eid){
            url = "${pageContext.request.contextPath}/ShowEmployeeMore?eid="+ eid;
            window.location.href = url;
        }
        function jump1(eid){
            url = "${pageContext.request.contextPath}/DeleteEmployee?eid="+ eid;
            window.location.href = url;
        }
        $(document).ready(function (){
            $("#showAdmin").on("click",function (){
                $.ajax({
                    url:"${pageContext.request.contextPath}/ShowEmployee",
                    type:"post",
                    data:JSON.stringify({name:""}),
                    contentType:"application/json;charset-UTF-8",
                    dataType:"json",
                    success:function (map){
                        var arr = map.list;
                        var len = arr.length;
                        var str = "";
                        for (var i = 0; i < len; i++){
                            str += "<tr>" +
                                "<td>" + arr[i].eid + "</td>" +
                                "<td>" + arr[i].name + "</td>" +
                                "<td>" + arr[i].sex + "</td>" +
                                "<td>" + arr[i].age + "</td>" +
                                "<td>" + arr[i].aid + "</td>" +
                                "<td><button class='btnSelect'>查看详细信息</button></td>" +
                                "<td><button class='btnSelect1'>删除管理员</button></td>" +
                                "</tr>";
                        }
                        adminList.innerHTML = str;
                    },
                    error:function (){
                        alert("error");
                    }
                })
            })
            $("#myTableEmp").on("click",".btnSelect",function (){
                var currentRow=$(this).closest("tr");
                var col1=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值
                jump(col1);
            })
            $("#myTableEmp").on("click",".btnSelect1",function (){
                var r = confirm("确认删除该管理员？");
                if (r){
                    var currentRow=$(this).closest("tr");
                    var col1=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值
                    jump1(col1);
                }
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
            position: absolute;
            top: 210px;
            left: 430px;
            border-collapse: collapse;
            background-color: #d1d793;
        }
        .specialtr{
            border: none;
            background-color: #ebebcd;
        }
        .btn2{
            border: none;
            cursor:pointer;
            width: 110px;
            height:40px;
            border-radius: 15%;
            background-color: #b8dfba;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btn2:hover{
            background-color: #8ebdb8;
            color: #fff;
        }
        .h{
            position: absolute;
            top: 20%;
            left: 45%;
        }
        .btnSelect{
            border: none;
            cursor:pointer;
            width: 100%;
            height:100%;
            border-radius: 2%;
            background-color: #d1d793;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btnSelect:hover{
            color: #fff;
        }
        .btnSelect1{
            border: none;
            cursor:pointer;
            width: 100%;
            height:100%;
            border-radius: 2%;
            background-color: #d1d793;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btnSelect1:hover{
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
<div class="h"><h1>管理员信息</h1></div>
<div class="alltable">
    <table class="table1" id="myTableEmp" border="1px">
        <thead>
        <tr class="specialtr">
            <td colspan="4"><button class="btn2" id="showAdmin">查询管理员信息</button></td>
            <td colspan="3"><button class="btn2" id="insertAdmin" onclick="window.location.href='${pageContext.request.contextPath}/insertAdmin'">添加管理员</button></td>
        </tr>
        <tr>
            <td>职工号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>管理楼号</td>
            <td width="200px" colspan="2">操作</td>
        </tr>
        </thead>
        <tbody id="adminList">

        </tbody>
    </table>
</div>
</body>
</html>