<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="basePath">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<meta charset="UTF-8">
<title>LarryCMS后台登录</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<!-- load css -->
<link rel="stylesheet" type="text/css" href="common/layui/css/layui.css"
	media="all">
<link rel="stylesheet" type="text/css" href="css/login.css" media="all">

</head>
<body>
	<div class="layui-canvs"></div>
	<div class="layui-layout layui-layout-login">
		<h1>
			<strong>CRM客户关系管理系统后台</strong> <em>Management System</em>
		</h1>
		<form id="loginform" name="loginform" action="${basePath}doLogin.action" method="post">
			<div class="layui-user-icon larry-login">
				<input type="text" id="usercode" name="username" placeholder="账号"
					class="login_txtbx" />
			</div>
			<div class="layui-pwd-icon larry-login">
				<input type="password" id="pwd" name="password" placeholder="密码"
					class="login_txtbx" />
			</div>
			<div class="layui-submit larry-login">
				<input type="button" value="立即登陆" class="submit_btn"/>
			</div>
		</form>
		<div id="error" class="layui-login-text">
			<p>${message}</p>
		</div>
	</div>
	<script type="text/javascript" src="common/layui/lay/dest/layui.all.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="jsplug/jparticle.jquery.js"></script>
	<script type="text/javascript">
		$(function() {
			$(".layui-canvs").jParticle({
				background : "#141414",
				color : "#E6E6E6"
			});
			$(".submit_btn").click(function() {
				$("#loginform").submit();
			});
		});
		$(document).ready(function(){
	        $("input").focus(function(){
	            $("#error").hide();
	        });
	    });
	</script>
</body>
</html>
