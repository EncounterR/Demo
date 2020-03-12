<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>主页面</title>
<link type="text/css" href="css/stylesheet.css" rel="stylesheet"
	media="screen" />
<link type="text/css" href="css/font-awesome.min.css" rel="stylesheet" />
<link href="common/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript"
	src="common/bootstrap/jquery/jquery.min.js"></script>
<!-- Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript"
	src="common/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="tile tile-primary">
					<div class="tile-heading">
						订单总数 <span class="pull-right"> <i class="fa fa-caret-down"></i>-64%
						</span>
					</div>
					<div class="tile-body">
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"
							style="font-size: 50px"></span>
						<h2 class="pull-right">402</h2>
					</div>
					<div class="tile-footer">
						<a href="">显示详细...</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="tile tile-primary">
					<div class="tile-heading">
						销售总额 <span class="pull-right"> <i class="fa fa-caret-down"></i>-64%
						</span>
					</div>
					<div class="tile-body">
						<span class="glyphicon glyphicon-usd" aria-hidden="true"
							style="font-size: 50px"></span>
						<h2 class="pull-right">402</h2>
					</div>
					<div class="tile-footer">
						<a href="">显示详细...</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="tile tile-primary">
					<div class="tile-heading">
						客户总数 <span class="pull-right"> <i class="fa fa-caret-down"></i>-64%
						</span>
					</div>
					<div class="tile-body">
						<span class="glyphicon glyphicon-user" aria-hidden="true"
							style="font-size: 50px"></span>
						<h2 class="pull-right">402</h2>
					</div>
					<div class="tile-footer">
						<a href="">显示详细...</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row" style="margin-left: 2px; margin-right: 2px;">
		<div class="col-lg-4 col-md-12 col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span class="glyphicon glyphicon-user"></span> 用户活动
					</h3>
				</div>
				<ul class="list-group">
					<c:forEach items="${loginers}" var="item">
						<li class="list-group-item"><a href="">${item.username}</a>登录
							<br /> <small class="text-muted"><span
								class="glyphicon glyphicon-time"></span> <fmt:formatDate
									value="${item.datetime}" pattern="yyyy-MM-dd HH:mm:ss" /></small></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="col-lg-8 col-md-12 col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span class="glyphicon glyphicon-tasks"></span> 最新订单
					</h3>
				</div>
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<td class="text-right">订单号</td>
								<td>客户名称</td>
								<td>状态</td>
								<td>生成日期</td>
								<td class="text-right">金额</td>
								<td class="text-right">管理</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-right">423</td>
								<td>testset</td>
								<td>已取消</td>
								<td>2019-09-24 16:16:02</td>
								<td class="text-right">￥9.00</td>
								<td class="text-right"><a
									onclick="doSysuserDetail(${item.usr_id})"
									class="btn btn-default" data-toggle="modal"
									data-target="#myModal">查看</a></td>
							</tr>
							<tr>
								<td class="text-right">422</td>
								<td>zach</td>
								<td>已取消</td>
								<td>2019-09-24 14:04:11</td>
								<td class="text-right">￥99.99</td>
								<td class="text-right"><a href="" data-toggle="tooltip"
									title="查看" class="btn btn-info"><i class="fa fa-eye"></i></a></td>
							</tr>
							<tr>
								<td class="text-right">421</td>
								<td>123</td>
								<td>已取消</td>
								<td>2019-09-24 13:52:52</td>
								<td class="text-right">￥1,999.00</td>
								<td class="text-right"><a href="" data-toggle="tooltip"
									title="查看" class="btn btn-info"><i class="fa fa-eye"></i></a></td>
							</tr>
							<tr>
								<td class="text-right">420</td>
								<td>123</td>
								<td>已取消</td>
								<td>2019-09-24 12:18:29</td>
								<td class="text-right">￥8.88</td>
								<td class="text-right"><a href="" data-toggle="tooltip"
									title="查看" class="btn btn-info"><i class="fa fa-eye"></i></a></td>
							</tr>
							<tr>
								<td class="text-right">419</td>
								<td>rouben618</td>
								<td>已取消</td>
								<td>2019-09-23 18:11:46</td>
								<td class="text-right">￥1,271.00</td>
								<td class="text-right"><a href="" data-toggle="tooltip"
									title="查看" class="btn btn-info"><i class="fa fa-eye"></i></a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>