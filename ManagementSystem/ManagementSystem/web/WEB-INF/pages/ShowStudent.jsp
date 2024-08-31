<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        function jump(sid){
            url = "${pageContext.request.contextPath}/updateStudent?sid="+ sid;
            window.location.href = url;
        }
        function jump1(){
            url = "${pageContext.request.contextPath}/insertStudent";
            window.location.href = url;
        }

        $(document).ready(function (){
            $("#btnAll").on("click",function (){
                $.ajax({
                    url:"${pageContext.request.contextPath}/ShowStudent",
                    type:"post",
                    data:JSON.stringify({}),
                    contentType:"application/json;charset-UTF-8",
                    dataType:"json",
                    success:function (map){
                        var arr = map.student;
                        if (arr){
                            var len = arr.length;
                        }
                        var str = "";
                        for (var i = 0; i < len; i++){
                            str += "<tr>" +
                                "<td>" + arr[i].sid + "</td>" +
                                "<td>" + arr[i].name + "</td>" +
                                "<td>" + arr[i].sex + "</td>" +
                                "<td>" + arr[i].major + "</td>" +
                                "<td>" + arr[i].grade + "</td>" +
                                "<td>" + arr[i].stuclass + "</td>" +
                                "<td>" + arr[i].state + "</td>" +
                                "<td><button class='btnSelect1'>管理学生信息</button></td>" +
                                "<td><button class='btnSelect2'>删除学生信息</button></td>" +
                                "</tr>";
                        }
                        stuList.innerHTML = str;
                    },
                    error:function (){
                        alert("error");
                    }
                })
            })
            $("#stuTable").on("click",".btnSelect2",function (){
                var r = confirm("确认删除该学生？");
                if (r){
                    var currentRow=$(this).closest("tr");
                    var col1=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值
                    var col2=currentRow.find("td:eq(1)").text(); //获得当前行第二个TD值
                    var col3=currentRow.find("td:eq(2)").text();
                    var col4=currentRow.find("td:eq(3)").text();
                    var col5=currentRow.find("td:eq(4)").text();
                    var col6=currentRow.find("td:eq(5)").text();
                    var col7=currentRow.find("td:eq(6)").text();
                    $.ajax({
                        url:"${pageContext.request.contextPath}/DeleteStudent",
                        type:"post",
                        data:JSON.stringify({sid:col1,name:col2,sex:col3,major:col4,grade:col5,stuclass:col6,state:col7}),
                        contentType:"application/json;charset-UTF-8",
                        dataType:"json",
                        success:function (){
                            $.ajax({
                                url:"${pageContext.request.contextPath}/ShowStudent",
                                type:"post",
                                data:JSON.stringify({}),
                                contentType:"application/json;charset-UTF-8",
                                dataType:"json",
                                success:function (map){
                                    var arr = map.student;
                                    if (arr){
                                        var len = arr.length;
                                    }
                                    var str = "";
                                    for (var i = 0; i < len; i++){
                                        str += "<tr>" +
                                            "<td>" + arr[i].sid + "</td>" +
                                            "<td>" + arr[i].name + "</td>" +
                                            "<td>" + arr[i].sex + "</td>" +
                                            "<td>" + arr[i].major + "</td>" +
                                            "<td>" + arr[i].grade + "</td>" +
                                            "<td>" + arr[i].stuclass + "</td>" +
                                            "<td>" + arr[i].state + "</td>" +
                                            "<td><button class='btnSelect1'>管理学生信息</button></td>" +
                                            "<td><button class='btnSelect2'>删除学生信息</button></td>" +
                                            "</tr>";
                                    }
                                    stuList.innerHTML = str;
                                },
                                error:function (){
                                    alert("error");
                                }
                            })
                        },
                        error:function (){
                            alert("error");
                        }
                    })
                }
            })

            $("#stuTable").on("click",".btnSelect1",function (){
                var currentRow=$(this).closest("tr");
                var col1=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值
                jump(col1);
            })
            $("#btnInsert").on("click",function (){
                jump1();
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
        .alltable{
            position: absolute;
            width:1000px;
            top: 200px;
            left: 17%;
        }
        .table1{
            display: inline-block;
            border-collapse: collapse;
            background-color: #d1d793;
        }
        .specialtr{
            border: none;
            background-color: #ebebcd;
        }
        .btnSelect1{
            border: none;
            cursor: pointer;
            background-color: #d1d793;
            color: #000;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btnSelect1:hover{
            color: #fff;
        }
        .btnSelect2{
            border: none;
            cursor: pointer;
            background-color: #d1d793;
            color: #000;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btnSelect2:hover{
            color: #fff;
        }
        .h{
           position: absolute;
            top: 140px;
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
<div class="h"><h1>学生信息管理</h1></div>
<div class="alltable">
    <table class="table1"id="stuTable" border="1px">
        <thead>
        <tr class="specialtr">
            <td colspan="5"><button class="btn2"id="btnAll">查询所有学生信息</button></td>
            <td colspan="4"><button class="btn1"id="btnInsert">添加学生信息</button></td>
        </tr>
        <tr>
            <td width="70px">学号</td>
            <td width="100px">姓名</td>
            <td>性别</td>
            <td width="130px">专业</td>
            <td>年级</td>
            <td>班级</td>
            <td>宿舍状态</td>
            <td colspan="2" width="205px">操作</td>
        </tr>
        </thead>
        <tbody id="stuList">

        </tbody>
    </table>
</div>
</body>
</html>