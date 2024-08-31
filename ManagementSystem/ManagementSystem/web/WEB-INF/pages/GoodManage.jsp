<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        function jump1(aid,rid,gname){
            var url = "${pageContext.request.contextPath}/DeleteGood?aid="+aid+"&rid="+rid+"&gname="+gname;
            window.location.href = url;
        }
        $(document).ready(function (){
            $("#selectAllGood").on("click",function (){
                var aid = $("#aid").val();
                if (!isNaN(parseInt(aid))){
                    $.ajax({
                        url:"${pageContext.request.contextPath}/selectGood?aid="+aid,
                        type:"get",
                        contentType:"application/json;charset-UTF-8",
                        dataType:"json",
                        success:function (map){
                            var arr = map.good;
                            var len = arr.length;
                            var str = "";
                            for (var i = 0; i < len; i++){
                                str += "<tr>" +
                                    "<td>" + arr[i].aid + "</td>" +
                                    "<td>" + arr[i].rid + "</td>" +
                                    "<td>" + arr[i].gname + "</td>" +
                                    "<td>" + arr[i].gnumber + "</td>" +
                                    "<td><button class='btnSelect1'>删除物品</button></td>" +
                                    "</tr>"
                            }
                            goodList.innerHTML = str;
                        },
                        error:function (){
                            alert("error");
                        }
                    })
                }else {
                    alert("请输入正确的楼号")
                }
            })
            $("#myTableGood").on("click",".btnSelect1",function (){
                var r = confirm("确认删除该物品？");
                if (r){
                    var currentRow=$(this).closest("tr");
                    var col1=currentRow.find("td:eq(0)").text(); //获得当前行第1个TD值
                    var col2=currentRow.find("td:eq(1)").text(); //获得当前行第2个TD值
                    var col3=currentRow.find("td:eq(2)").text(); //获得当前行第3个TD值
                    jump1(col1,col2,col3);
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
        .goodtable{
            display: inline-block;
            border-collapse: collapse;
            background-color: #d1d793;
        }
        .alltable{
            width:1000px;
            position: absolute;
            top: 200px;
            left:30%;

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
        .h{
            position: absolute;
            left: 612px;
            top: 120px;
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
<div class="h"> <h1 align="center">&nbsp&nbsp宿舍楼物品管理</h1></div>
<div class="alltable">
    <table class="goodtable" id="myTableGood" border="1px">
        <thead>
        <tr class="specialtr">
            <td>请输入楼号：</td>
            <td colspan="2"><input type="text" id="aid"></td>
            <td><button class="btn2" id="selectAllGood">查询物品信息</button></td>
            <td><button class="btn2"id="insertGood" onclick="window.location.href='${pageContext.request.contextPath}/insertGood'">添加物品</button></td>
        </tr>
        <tr>
            <td>楼号</td>
            <td>宿舍号</td>
            <td>物品信息</td>
            <td>物品数量</td>
            <td width="60px">操作</td>
        </tr>
        </thead>
        <tbody id="goodList">

        </tbody>
    </table>
</div>
</body>
</html>