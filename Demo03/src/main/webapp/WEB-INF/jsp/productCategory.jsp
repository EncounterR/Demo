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
<title>商品分类管理</title>
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
	function doSysuserDetail(id) {
		$.ajax({
			url:"${basePath}doSysuserDetail.action?id="+id,
			type:"get",
			dataType:"json", //响应的类型
			success:function(data){ //响应回来的内容
				console.log(data)
				var flag=null;
				$("#myModal .modal-body>table tr:gt(0)").remove();
				var str="<tr><td>"+data.usr_id+"</td><td>"+data.usr_name+"</td><td>"+data.usr_password+"</td><td>"+data.usr_role_id+"</td><td>"+data.user_name+"</td></tr>";
				$("#myModal .modal-body>table tr:eq(0)").after(str);
			}
		});
	}
	function doDelProductCategory(id) {
		$.ajax({
			url:"${basePath}/doDelProductCategory.action?id="+id,
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
						<a href="${basePath}productCategoryAdd.action"
							class="layui-btn layui-btn-normal">添加商品分类</a>
					</div>
				</blockquote>
				<!-- 操作日志 -->
				<div class="layui-form news_list">
					<table class="layui-table">
						<colgroup>
							<col width="15%">
							<col width="15%">
							<col width="25%">
						</colgroup>
						<thead>
							<tr>
								<th>编号</th>
								<th>商品分类名称</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody class="news_content">
							<c:forEach items="${productCate}" var="item">
								<tr id="tr_${item.id}">
									<td>${item.id}</td>
									<td>${item.cate_name}</td>
									<td>
										<a href="${basePath}productCategoryEdit.action?id=${item.id}" class="btn btn-default">修改</a> 
										<a onclick="doDelProductCategory(${item.id})" class="btn btn-default">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="${basePath}common/layui/layui.js"></script>
	<script type="text/javascript" src="${basePath}js/newslist.js"></script>
</body>
</html>
