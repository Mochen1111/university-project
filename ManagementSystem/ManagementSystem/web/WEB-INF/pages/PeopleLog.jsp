<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        $(document).ready(function (){
            $("#selectAllPeo").on("click",function (){
                $.ajax({
                    url:"${pageContext.request.contextPath}/PeopleLog",
                    type:"post",
                    data:JSON.stringify({vname:""}),
                    contentType:"application/json;charset-UTF-8",
                    dataType:"json",
                    success:function (map){
                        var arr = map.people;
                        var len = arr.length;
                        var str = "";
                        for (var i = 0;i < len; i++){
                            str += "<tr>" +
                                "<td>" + arr[i].vname + "</td>" +
                                "<td>" + arr[i].yyyy + "年" + "</td>" +
                                "<td>" + arr[i].mm + "月" + "</td>" +
                                "<td>" + arr[i].dd + "日" + "</td>" +
                                "<td>" + arr[i].aid + "</td>" +
                                "<td>" + arr[i].rid + "</td>" +
                                "<td>" + arr[i].name + "</td>" +
                                "<td>" + arr[i].gname + "</td>" +
                                "</tr>";
                        }
                        peopleList.innerHTML = str;
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
        .table1{
            display: inline-block;
            position: absolute;
            top: 200px;
            left:350px;
            border-collapse: collapse;
            background-color: #d1d793;
        }
        .specialtr{
            border: none;
            background-color: #ebebcd;
        }
        .h{
            position: absolute;
            top: 130px;
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
<div class="h"><h1>外来人员登记</h1></div>
    <table class="table1" id="myTablePeo" border="1px">
        <thead>
        <tr class="specialtr">
            <td colspan="4"><button class="btn2" id="selectAllPeo">查询出入登记信息</button></td>
            <td colspan="4"><button class="btn2" id="insertAllPeo" onclick="window.location.href='${pageContext.request.contextPath}/insertAllPeople'">登记来访信息</button></td>
        </tr>
        <tr>
            <td>来访人姓名</td>
            <td colspan="3" width="200px">来访日期</td>
            <td>来访楼号</td>
            <td>来访宿舍</td>
            <td>被访人姓名</td>
            <td>物品信息</td>
        </tr>
        </thead>
        <tbody id="peopleList">

        </tbody>
    </table>

</body>
</html>