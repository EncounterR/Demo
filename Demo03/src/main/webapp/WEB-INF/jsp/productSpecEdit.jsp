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
<title>商品规格信息修改</title>
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
<link rel="stylesheet" type="text/css"
	href="${basePath}common/global.css" media="all">
<link rel="stylesheet" type="text/css"
	href="${basePath}css/personal.css" media="all">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript"
	src="common/bootstrap/jquery/jquery.min.js"></script>
<script type="text/javascript">
	function doSubmit() {
		var flag = confirm("是否确认修改?");
		return flag
	}
	function add() {
		console.log("add");
		var str="<tr id=><td><b>新属性</b></td><td><input type='text' name='spec_names' class='layui-input' value=''></td><td><a onclick='del(this)' class='btn btn-default'>删除</a></td></tr>";
		$("table tr:last").after(str);
	}
	function del(r){
	    var i=r.parentNode.parentNode.rowIndex;
	    console.log(i);
	    document.getElementById('wu').deleteRow(i);
	}
</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>角色信息</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-5"
					action="${basePath}doEditProductSpec.action" method="post"
					onsubmit="return doSubmit()">
					<div class="layui-form-item">
						<label class="layui-form-label">规格编号</label>
						<div class="layui-input-block">
							<input type="text" name="spec_id"
								class="layui-input layui-disabled"
								value="${productSpec.spec_id}" readonly="readonly">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">规格名称</label>
						<div class="layui-input-block">
							<input type="text" name="spec_name" class="layui-input"
								value="${productSpec.spec_name}">
						</div>
					</div>
					<div class="layui-form-item">
						<table class="layui-table" id='wu'>
							<c:forEach items="${productSpec.plist}" var="item"
								varStatus="status">
								<tr>
									<td><b>属性名称${status.index+1}</b></td>
									<td><input type="text" name="spec_names"
										class="layui-input" value="${item.spec_name}"></td>
									<td><a onclick="del(this)"
										class="btn btn-default">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<a onclick="add()" class="layui-btn">添加新属性</a> <input
								type="submit" value="提交" class="layui-btn">
							<a href="javascript:history.go(-1)" class="layui-btn">返回</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="${basePath}common/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use([ 'form', 'upload' ], function() {
			var form = layui.form();
			layui.upload({
				url : '',//上传接口 
				success : function(res) {
					//上传成功后的回调 
					console.log(res)
				}
			});

		});
	</script>
</body>
</html>
