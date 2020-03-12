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
<title>角色管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css" href="common/layui/css/layui.css"
	media="all">
<link rel="stylesheet" type="text/css"
	href="common/bootstrap/css/bootstrap.css" media="all">
<link href="common/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="css/personal.css"
	media="all">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript"
	src="common/bootstrap/jquery/jquery.min.js"></script>
<!-- Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript"
	src="common/bootstrap/js/bootstrap.min.js"></script>
<script>
	function doDelSysRole(id) {
		$.ajax({
			url:"${basePath}doDelSysRole.action?id="+id,
			type:"post",
			dataType:"text", //响应的类型
			success:function(data){ //响应回来的内容
				if(data){
					$("#tr_"+id).remove();
				}
			}
		});
	}
</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<div class="layui-tab">
				<blockquote class="layui-elem-quote news_search">
					<div class="layui-inline">
						<a href="${basePath}sysRoleAdd.action" class="layui-btn layui-btn-normal newsAdd_btn">添加角色</a>
					</div>
				</blockquote>
				<!-- 操作日志 -->
				<div class="layui-form">
					<table class="layui-table">
						<colgroup>
							<col width="20%">
							<col width="20%">
							<col width="20%">
							<col width="20%">
							<col width="20%">
						</colgroup>
						<thead>
							<tr>
								<th>角色编号</th>
								<th>角色名称</th>
								<th>角色详情</th>
								<th>角色状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody class="news_content">
							<c:forEach items="${SysRole}" var="item">
								<tr id="tr_${item.role_id}">
									<td>${item.role_id}</td>
									<td>${item.role_name}</td>
									<td>${item.role_desc}</td>
									<td>${item.role_flag==0?'已停用':'正常'}</td>
									<td>
										<a href="${basePath}detSysRole.action?id=${item.role_id}" class="btn btn-default">详情</a>
										<a href="${basePath}editSysRole.action?id=${item.role_id}" class="btn btn-default">修改</a> 
										<a onclick="doDelSysRole('${item.role_id}')" class="btn btn-default">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="common/layui/layui.js"></script>
	<script type="text/javascript" src="js/newslist.js"></script>
</body>
</html>