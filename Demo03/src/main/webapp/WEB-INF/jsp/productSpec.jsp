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
<title>商品规格</title>
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
	function doDelProSpec(id) {
		$.ajax({
			url:"${basePath}doDelProSpec.action?id="+id,
			type:"get",
			dataType:"text", //响应的类型
			success:function(data){ //响应回来的内容
				console.log(data);
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
			<blockquote class="layui-elem-quote">
					<div class="layui-inline">
						<a href="${basePath}productSpecAdd.action"
							class="layui-btn layui-btn-normal">添加商品属性</a>
					</div>
				</blockquote>
				<!-- 操作日志 -->
				<div class="layui-form news_list">
					<table class="layui-table">
						<colgroup>
							<col width="10%">
							<col width="15%">
							<col width="65%">
							<col width="10%">
						</colgroup>
						<thead>
							<tr>
								<th>编号</th>
								<th>规格名称</th>
								<th>规格属性</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody class="news_content">
							<c:forEach items="${productSpecs}" var="item">
								<tr id="tr_${item.spec_id}">
									<td>${item.spec_id}</td>
									<td>${item.spec_name}</td>
									<td>
										<c:forEach items="${item.plist}" var="itemm" varStatus="status">${status.index+1}.${itemm.spec_name}&nbsp&nbsp&nbsp&nbsp</c:forEach>
									</td>
									<td>
										<a href="${basePath}ProSpecEdit.action?id=${item.spec_id}" class="btn btn-default">修改</a>
										<a onclick="doDelProSpec(${item.spec_id})" class="btn btn-default">删除</a>
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