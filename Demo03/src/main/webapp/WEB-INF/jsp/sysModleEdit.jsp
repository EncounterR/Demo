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
<title>修改权限信息</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="stylesheet" type="text/css" href="common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="css/personal.css" media="all">
	<script type="text/javascript">
	function doSubmit() {
		var flag = confirm("是否确认修改?");
		return flag
	}
	</script>
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>权限信息</span>
		</header><!-- /header -->
		<div class="larry-personal-body clearfix">
			<form class="layui-form col-lg-5" action="${basePath}doSysModleEdit.action" method="post" onsubmit="return doSubmit()">
			<div class="layui-form-item">
					<label class="layui-form-label">权限编号</label>
					<div class="layui-input-block">  
						<input type="text" name="right_code"  class="layui-input layui-disabled" value="${sysModle.right_code}" readonly="readonly" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">模块父编号</label>
					<div class="layui-input-block">  
						<input type="text" name="right_parent_code"  class="layui-input layui-disabled" value="${sysModle.right_parent_code}" readonly="readonly" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">权限类型</label>
					<div class="layui-input-block">  
						<input type="text" name="right_type"  class="layui-input layui-disabled" value="${sysModle.right_type}" readonly="readonly" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">url</label>
					<div class="layui-input-block">  
						<input type="text" name="right_url" class="layui-input layui-disabled" value="${sysModle.right_url}" readonly="readonly">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">显示</label>
					<div class="layui-input-block">  
						<input type="text" name="right_tip" class="layui-input" value="${sysModle.right_tip}" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">权限名称</label>
					<div class="layui-input-block">  
						<input type="text" name="right_text"  class="layui-input" value="${sysModle.right_text}" >
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<input	type="submit" value="提交" class="layui-btn" lay-submit="" lay-filter="demo1">
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script type="text/javascript" src="common/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','upload'],function(){
         var form = layui.form();
         layui.upload({ 
             url: '' ,//上传接口 
             success: function(res){
              //上传成功后的回调 
              console.log(res) 
            } 
         });

	});
</script>
</body>
</html>
