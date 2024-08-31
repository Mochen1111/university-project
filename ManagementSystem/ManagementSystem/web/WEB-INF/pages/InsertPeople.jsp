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
            background-color: #d1d793;
            width: 350px;
            height:405px;
            border-radius: 5%;
            position: relative;
            left: 40%;
            top:20%;
        }
        .h{
            position: absolute;
            top: 20%;
            left: 44%;
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
<div class="h"><h1>&nbsp外来人员登记</h1></div>
<div class="alltable">
    <form action="${pageContext.request.contextPath}/InsertPeople" method="post">
        <table>
            <tr>
                <td>来访人姓名：</td><td><input type="text" name="vname" required></td>
            </tr>
            <tr>
                <td>年：</td><td><input type="text" name="yyyy" required></td>
            </tr>
            <tr>
                <td>月：</td><td><input type="text" name="mm" required></td>
            </tr>
            <tr>
                <td>日：</td><td><input type="text" name="dd" required></td>
            </tr>
            <tr>
                <td>来访楼号：</td><td><input type="text" name="aid" required></td>
            </tr>
            <tr>
                <td>来访宿舍：</td><td><input type="text" name="rid" required></td>
            </tr>
            <tr>
                <td>被访人姓名：</td><td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>物品信息：</td><td><input type="text" name="gname" required></td>
            </tr>
            <tr>
                <td colspan="2"><input class="btn1"type="submit" value="提交信息"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>