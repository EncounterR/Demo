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
<title>修改用户信息</title>
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
			<span>用户信息</span>
		</header><!-- /header -->
		<div class="larry-personal-body clearfix">
			<form class="layui-form col-lg-5" action="${basePath}doSysUserEdit.action" method="post" onsubmit="return doSubmit()">
			<div class="layui-form-item">
					<label class="layui-form-label">用户编号</label>
					<div class="layui-input-block">  
						<input type="text" name="usr_id"  class="layui-input layui-disabled" value="${sysUser.usr_id}" readonly="readonly" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-block">  
						<input type="text" name="usr_name"  class="layui-input layui-disabled" value="${sysUser.usr_name}" readonly="readonly" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">密码</label>
					<div class="layui-input-block">  
						<input type="text" name="usr_password"  class="layui-input" value="${sysUser.usr_password}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">  
						<input type="text" name="user_name"  class="layui-input" value="${sysUser.user_name}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">角色</label>
					<div class="layui-input-block">
						<c:forEach items="${sysRoles}" var="item">
						<input type="radio" name="usr_role_id" value="${item.role_id}" title="${item.role_name}"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>${item.role_name}</span></div>
						</c:forEach>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">是否停用</label>
					<div class="layui-input-block">
						<input type="radio" name="usr_flag" value="1" title="否" checked=""><div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon"></i><span>否</span></div>
						<input type="radio" name="usr_flag" value="0"title="是"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>是</span></div>
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
