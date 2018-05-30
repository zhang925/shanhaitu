<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.jeecgframework.core.util.SysThemesUtil,org.jeecgframework.core.enums.SysThemesEnum"%>
<%@include file="/context/mytags.jsp"%>
<%
    session.setAttribute("lang","zh-cn");
    SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
    String lhgdialogTheme = SysThemesUtil.getLhgdialogTheme(sysTheme);
%>

<%
    String pathBs = request.getContextPath();
    String basePathBs = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathBs+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title><t:mutiLang langKey="jeect.platform"/></title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <link rel="stylesheet" href="plug-in/bootstrap1/css/bootstrap.css" type="text/css"></link>
    <link rel="stylesheet" href="plug-in/bootstrap1/css/bootstrap-theme.css" type="text/css"></link>
    <script src="plug-in/jquery/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="plug-in/bootstrap1/js/bootstrap.js" type="text/javascript"></script>

    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <script>
        location.href = "loginController.do?login";
    </script>
</head>


<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <a class="navbar-brand" href="#" style="font-weight: bolder;">首页</a>
            <a class="navbar-brand" href="#" style="font-weight: bolder;">互联网联盟</a>
            <a class="navbar-brand" href="#" style="font-weight: bolder;">出海服务</a>
            <a class="navbar-brand" href="#" style="font-weight: bolder;">政策法规</a>
            <a class="navbar-brand" href="#" style="font-weight: bolder;">本地资讯</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
            <li><a href="/loginController.do?login"><span class="glyphicon glyphicon-log-in"></span> 后台测试登录</a></li>
        </ul>
    </div>
</nav>

<div style="border: 2px solid red;">
    <h1>这里是中部内容</h1>
</div>



</body>
</html>
