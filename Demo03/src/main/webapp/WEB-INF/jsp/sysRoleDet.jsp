<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>角色详情</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css"
	href="${basePath}common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="${basePath}common/bootstrap/css/bootstrap.css" media="all">
<link href="${basePath}common/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${basePath}common/global.css" media="all">
<link rel="stylesheet" type="text/css"
	href="${basePath}css/personal.css" media="all">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript"
	src="${basePath}common/bootstrap/jquery/jquery.min.js"></script>
<!-- Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript"
	src="${basePath}common/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<div class="layui-tab">
				<!-- 操作日志 -->
				<div class="layui-form news_list">
					<table class="layui-table">
						<colgroup>
							<col width="50%">
							<col width="50%">
						</colgroup>
						<thead>
							<tr>
								<th>属性名</th>
								<th>属性值</th>
							</tr>
						</thead>
						<tbody class="news_content">
							<tr>
								<td><b>角色id</b></td>
								<td>${sysRole.role_id}</td>
							</tr>
							<tr>
								<td><b>角色名</b></td>
								<td>${sysRole.role_name}</td>
							</tr>
							<tr>
								<td><b>角色详情</b></td>
								<td>${sysRole.role_desc}</td>
							</tr>
							<tr>
								<td><b>当前状态</b></td>
								<td>${sysRole.role_flag==0?'已停用':'正常'}</td>
							</tr>
							<tr>
								<td colspan="2"><h4><b>角色拥有的权限</b></h4></td>
							</tr>
							<c:forEach items="${sysRole.mlist}" var="item">
								<tr>
									<td><h4><b>${item.right_tip}</b></h4></td>
									<td>
										<table class="layui-table">
											<colgroup>
												<col width="100%">
											</colgroup>
											<c:forEach items="${item.sysModles}" var="itemm">
												<tr>
													<td>${itemm.right_tip}</td>
												</tr>
											</c:forEach>
										</table>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<a href="${basePath}rolelist.action" class="layui-btn">返回</a>
		</div>
	</div>
	<script type="text/javascript" src="${basePath}common/layui/layui.js"></script>
	<script type="text/javascript" src="${basePath}js/newslist.js"></script>
</body>
</html>