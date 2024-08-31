<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        function jump(aid){
            url = "${pageContext.request.contextPath}/ShowApartmentMore?aid=" + aid;
            window.location.href = url;
        }
        function jump1(aid,sex){
            url = "${pageContext.request.contextPath}/InsertApartment?aid="+ aid +"&sex=" + sex;
            window.location.href = url;
        }
        $(document).ready(function (){
            $("#showApt").on("click",function (){
                $.ajax({
                    url:"${pageContext.request.contextPath}/ShowApartment",
                    type:"post",
                    data:JSON.stringify({aid:""}),
                    contentType:"application/json;charset-UTF-8",
                    dataType:"json",
                    success:function (map){
                        var arr = map.apt;
                        var len = arr.length;
                        var str = "";
                        for (var i = 0;i < len; i++){
                            str += "<tr>" +
                                "<td>" + arr[i].aid + "</td>" +
                                "<td>" + arr[i].apeople + "</td>" +
                                "<td>" + arr[i].nowapeople + "</td>" +
                                "<td>" + arr[i].roomnumber + "</td>" +
                                "<td>" + arr[i].asex + "</td>" +
                                "<td><button class='btnSelect'>查看详细信息</button></td>" +
                                "</tr>";
                        }
                        aptList.innerHTML = str;
                    },
                    error:function (){
                        alert("error");
                    }
                })
            })
            $("#myTableApt").on("click",".btnSelect",function (){
                var currentRow=$(this).closest("tr");
                var col1=currentRow.find("td:eq(0)").text(); //获得当前行第一个TD值
                jump(col1);
            })
            $("#InsertApt").on("click",function (){
                var aid = prompt("请输入新建宿舍楼的楼号");
                var sex = prompt("请输入新建宿舍楼的入住学生性别");
                if (!isNaN(parseInt(aid)) && aid != 0){
                    if (sex != null && sex != "" && (sex == "男" || sex == "女")){
                        jump1(aid,sex);
                    }else {
                        alert("请输入正确的性别");
                    }
                }else {
                    alert("请输入正确的楼号");
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

        .table1{
            display: inline-block;
            position:absolute;
            top: 200px;
            left: 400px;
            border-collapse: collapse;
            background-color: #d1d793;
        }
        .specialtr{
            border: none;
            background-color: #ebebcd;
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
            left: 660px;

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
<div class="h"><h1>&nbsp&nbsp公寓信息</h1></div>
    <table class="table1" id="myTableApt" border="1px">
        <thead>
        <tr class="specialtr">
            <td colspan="3"><button class="btn1" id="showApt">查询宿舍楼</button></td>
            <td colspan="3"><button class="btn1"id="InsertApt">添加新宿舍楼</button></td>
        </tr>
        <tr>
            <td>楼号</td>
            <td>应住人数</td>
            <td>实住人数</td>
            <td>房间数量</td>
            <td>公寓学生性别</td>
            <td width="130px">操作</td>
        </tr>
        </thead>
        <tbody id="aptList">

        </tbody>
    </table>

</body>
</html>