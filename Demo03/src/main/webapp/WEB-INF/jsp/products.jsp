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
<title>商品管理</title>
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
	function doDelProduct(id) {
		$.ajax({
			url:"${basePath}/doDelProduct.action?id="+id,
			type:"post",
			dataType:"text", //响应的类型
			success:function(data){ //响应回来的内容
				if(data=="true"){
					$("#tr_"+id).remove();
				}
			}
		});
	}
</script>
<style>
	.parent {
    width: 100%;
    height: 20px;
    position: relative;
}

.child {
    width: 200px;
    height: 19px;
    margin: auto;
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
}
</style>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<div class="layui-tab">
				<blockquote class="layui-elem-quote news_search">
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input value="" placeholder="请输入关键字"
								class="layui-input search_input" type="text">
						</div>
						<a class="layui-btn search_btn">查询</a>
					</div>
					<div class="layui-inline">
						<a href="${basePath}productsAdd.action"
							class="layui-btn layui-btn-normal">添加商品</a>
					</div>
				</blockquote>
				<!-- 操作日志 -->
				<div class="layui-form news_list">
					<table class="layui-table">
						<colgroup>
							<col width="40%">
							<col width="10%">
							<col width="15%">
							<col width="10%">
							<col width="5%">
							<col width="5%">
							<col width="15%">
						</colgroup>
						<thead>
							<tr>
								<th>商品名称</th>
								<th>商品图片</th>
								<th>商品型号</th>
								<th>价格</th>
								<th>库存</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody class="news_content">
							<c:forEach items="${pageInfo.getList()}" var="item">
								<tr id="tr_${item.prod_id}">
									<td>${item.prod_name}</td>
									<td><img src="/products/wu/${item.prod_pic}" class="img-thumbnail"></td>
									<td>${item.prod_type}</td>
									<td>￥${item.prod_price}</td>
									<td>${item.prod_number}</td>
									<td>${item.prod_flat==0?'已下架':'已上架'}</td>
									<td><a onclick="doSysuserDetail(${item.prod_id})"
										class="btn btn-default" data-toggle="modal"
										data-target="#myModal">详情</a> <a
										href="${basePath}sysUserEdit.action?id=${item.prod_id}"
										class="btn btn-default">修改</a>
										<a onclick="doDelProduct(${item.prod_id})" class="btn btn-default">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<div class="parent">
	    <div class="child">
		<c:if test="${page>1}">
			<a href="${basePath}productlist.action?page=1" class="layui-btn">首页</a>
			<a href="${basePath}productlist.action?page=${page-1}" class="layui-btn">上一页</a>
		</c:if>
		<span class="btn btn-default">${page}</span>
		<c:if test="${page!=maxSize}">
			<a href="${basePath}productlist.action?page=${page+1}" class="layui-btn">下一页</a>
			<a href="${basePath}productlist.action?page=${maxSize}" class="layui-btn">尾页</a>
		</c:if>
		</div>
	</div>
	<script type="text/javascript" src="${basePath}common/layui/layui.js"></script>
	<script type="text/javascript" src="${basePath}js/newslist.js"></script>
</body>
</html>
