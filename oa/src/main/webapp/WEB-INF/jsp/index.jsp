<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/index.css">
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/clickOther.js"></script>
    <title>htglxt</title>
</head>
<body>
    <!-- header -->
    <div class="header">
        <div class="header-left">
            阿壮软件
        </div>
        <div class="header-right">
            <ul>
                <li id="sname">无姓名</li>
                <li id="sdep">无部门</li>
                <li id="sstatus">无状态</li>
                <li id="ssrc"><img src="images/user1.png" alt="demo"></li>
                <li id="login">登陆</li>
            </ul>
        </div>
    </div>
    <!-- login model -->
    <div class="login-model" id="loginModel">
        <h3>账号密码登陆</h3>
        <div>
            账号:<input type="text" placeholder="亲，这里输入账号哦~">
        </div>
        <div>
            密码:<input type="text" placeholder="亲，这里输入密码哦~">
        </div>
        <div>
            <button>登陆</button>
        </div>
    </div>

    <!-- left-nav -->
    <div class="left-nav">
        <ul>
            <li id="person" class="mouseClick">
                <p>个人办公</p>
            </li>
            <li id="information">
                <p>信息中心</p>
            </li>
            <li id="financial">
                <p>财务审批</p>
            </li>
            <li id="human">
                <p>人力资源</p>
            </li>
            <li id="attendance">
                <p>考勤管理</p>
            </li>
            <li id="asset">
                <p>资产管理</p>
            </li>
            <li id="knowledge">
                <p>知识管理</p>
            </li>
        </ul>
    </div>
    <!-- mian -->
    <div class="main">
        <div class="main-top-nav" id="mainTopNav">
            <div class="mouseClick" id="gzrb">工作日报</div>
            <div id="gzjh">工作计划</div>
            <div id="rwgl">任务管理</div>
            <div id="txl">通讯录</div>
        </div>
        <div class="focus-info">
            <!-- no login -->
            <div class="noLogin" id="noLogin" style="display: none;">
                您还没有登陆哦~请登陆后查看   点击<a href="javascript:;" id="clickLogin">登陆</a>
            </div>
            <iframe src="./others/gzrb.html" frameborder="0" style="min-width: 1570px;height: 610px;" id="iframeO"></iframe>
        </div>
    </div>
    <script src="js/index.js"></script>
</body> 
</html>