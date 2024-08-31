<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        $(document).ready(function (){
            $("#selectMajor").on("click",function (){
                var m = "";
                $.ajax({
                    url:"${pageContext.request.contextPath}/listUnAllocation",
                    type:"post",
                    data:JSON.stringify({major:m}),
                    contentType:"application/json;charset-UTF-8",
                    dataType:"json",
                    success:function (map){
                        var arr = map.list;
                        var len = arr.length;
                        var str = "";
                        for (var i = 0; i < len; i++){
                            if (i == 0){
                                str += "<tr>" +
                                    "<td id='" + arr[i].major +"'>" + arr[i].major + "</td>" +
                                    "<td><button class='btnSelect'>查询学生</button></td>"
                                    + "</tr>";
                            }else if (arr[i].major != arr[i - 1].major){
                                str += "<tr>" +
                                    "<td id='" + arr[i].major +"'>" + arr[i].major + "</td>" +
                                    "<td><button class='btnSelect'>查询学生</button></td>"
                                    + "</tr>";
                            }
                        }
                        major.innerHTML = str;
                    },
                    error:function (){alert("error")},
                })
            })
            $("#myTable").on("click",".btnSelect",function (){
                var currentRow=$(this).closest("tr");
                var col1=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值
                $.ajax({
                    url:"${pageContext.request.contextPath}/listUnAllocation",
                    type:"post",
                    data:JSON.stringify({major:col1}),
                    contentType:"application/json;charset-UTF-8",
                    dataType:"json",
                    success:function (map){
                        var arr = map.list;
                        var len = arr.length;
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
                                "<td><button class='btnSelect2'>单独分配</button></td>" +
                                "</tr>";
                        }
                        myTableStu.innerHTML = str;
                    }
                })
            })
            $("#myTable2").on("click",".btnSelect2",function (){
                var currentRow=$(this).closest("tr");
                var col1=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值
                var col2=currentRow.find("td:eq(1)").text(); //获得当前行第二个TD值
                var col3=currentRow.find("td:eq(2)").text();
                var col4=currentRow.find("td:eq(3)").text();
                var col5=currentRow.find("td:eq(4)").text();
                var col6=currentRow.find("td:eq(5)").text();
                var col7=currentRow.find("td:eq(6)").text();
                $.ajax({
                    url:"${pageContext.request.contextPath}/AllocationStudent",
                    type:"post",
                    data:JSON.stringify({sid:col1,name:col2,sex:col3,major:col4,grade:col5,stuclass:col6,state:col7}),
                    contentType:"application/json;charset-UTF-8",
                    dataType:"json",
                    success:function (map){
                        var arr = map.student;
                        var major = arr.major;
                        $.ajax({
                            url:"${pageContext.request.contextPath}/listUnAllocation",
                            type:"post",
                            data:JSON.stringify({major:major}),
                            contentType:"application/json;charset-UTF-8",
                            dataType:"json",
                            success:function (map){
                                var arr = map.list;
                                var len = arr.length;
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
                                        "<td><button class='btnSelect2'>单独分配</button></td>" +
                                        "</tr>";
                                }
                                myTableStu.innerHTML = str;
                            },
                            error:function (){
                                alert("error");
                            }
                        })
                        var state = arr.state;
                        if (state == "已分配"){
                            alert("分配完成");
                        }else {
                            alert("分配失败，请检查宿舍状态");
                        }
                    },
                    error:function (){
                        alert("error");
                    }
                })
            })

            $("#btnAll").on("click",function (){
                let rows = $("#myTable2 tr");
                if (rows.length > 1){
                    let stu = [];
                    for (let a = 1; a < rows.length; a++){
                        let sid = $(rows[a]).children()[0].innerText;
                        let name = $(rows[a]).children()[1].innerText;
                        let sex = $(rows[a]).children()[2].innerText;
                        let major = $(rows[a]).children()[3].innerText;
                        let grade = $(rows[a]).children()[4].innerText;
                        let stuclass = $(rows[a]).children()[5].innerText;
                        let state = $(rows[a]).children()[6].innerText;
                        stu.push({sid:sid,name:name,sex:sex,major:major,grade:grade,stuclass:stuclass,state:state})
                    }
                    $.ajax({
                        url:"${pageContext.request.contextPath}/AllocationStudentList",
                        type:"post",
                        data:JSON.stringify(stu),
                        contentType:"application/json;charset-UTF-8",
                        dataType:"json",
                        success:function (map){
                            var arr = map.student;
                            var major = arr.major;
                            $.ajax({
                                url:"${pageContext.request.contextPath}/listUnAllocation",
                                type:"post",
                                data:JSON.stringify({major:major}),
                                contentType:"application/json;charset-UTF-8",
                                dataType:"json",
                                success:function (map){
                                    var arr = map.list;
                                    var len = arr.length;
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
                                            "<td><button class='btnSelect2'>单独分配</button></td>" +
                                            "</tr>";
                                    }
                                    myTableStu.innerHTML = str;
                                },
                                error:function (){
                                    alert("error");
                                }
                            })
                            var state = arr.state;
                            if (state == "已分配"){
                                alert("分配完成");
                            }else {
                                alert("部分学生分配失败，请检查宿舍状态");
                            }
                        },
                        error:function (){
                            alert("error");
                        }
                    })
                }
            });
        })
    </script>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background-color: #ebebcd;
        }
        .table1{
            display: inline-block;
            position: relative;
            top: 10%;
            left: 0%;
            border-collapse: collapse;
            background-color: #d1d793;
        }
        .table22{
            text-align: center;
            display: inline-block;
            position: absolute;
            top: 200px;
            left: 400px;
            border-collapse: collapse;
            background-color: #d1d793;
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
        td{
            border-collapse: collapse;
            padding-left: 20px;
            padding-right: 20px;
            padding-top: 10px;
            padding-bottom: 10px;
        }
        aside{
            top: 200px;
            float: left;
        }
        .findbtn{
            border: none;
            cursor:pointer;
            width: 100%;
            height:100%;
            border-radius: 2%;
            background-color: #b8dfba;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .specialtd{
            padding:0;
            height:40px;
        }
        .fenpeibtn{
            cursor:pointer;
        }
        .leadbtn:hover{
            background-color:#b8dfba ;
            color:black;
        }
        .findbtn:hover{
            background-color: #8ebdb8;
            color:#fff;
        }
        .btnSelect2{
            border: none;
            cursor:pointer;
            width: 100%;
            height:100%;
            border-radius: 2%;
            background-color: #d1d793;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .btnSelect2:hover{
            color:#fff;
        }
        .fenpeibtn{
            border: none;
            cursor:pointer;
            background-color: #d1d793;
            color: #000;
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
        }
        .fenpeibtn:hover{
            color: #fff;
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
            color:#fff;
        }
        .h{
            position: absolute;
            left: 660px;
            top:130px;
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
<div class="h"><h1>分配宿舍</h1></div>
<div class="table1">
    <aside>
        <table class="table1"id="myTable" border="1px">
            <thead>
            <tr>
                <td width="270px" class="specialtd" colspan="2" align="center">
                    <button class="findbtn"id="selectMajor">查询专业</button>
                </td>
            </tr>
            </thead>
            <tbody id="major">

            </tbody>
        </table>
    </aside>
</div>
    <table class="table22"id="myTable2" border="1px">
        <thead>
        <tr>
            <td width="100px">学号</td>
            <td width="80px">姓名</td>
            <td >性别</td>
            <td width="140px">专业</td>
            <td >年级</td>
            <td >班级</td>
            <td width="70px">宿舍状态</td>
            <td width="100px"><button class="fenpeibtn"id="btnAll">一键分配宿舍</button></td>
        </tr>
        </thead>
        <tbody id="myTableStu">
        </tbody>
    </table>
</body>
</html>