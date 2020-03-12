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
<title>添加系统用户</title>
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
		var a = document.getElementsByName("usr_role_id");
		var num = 0;
		for (var i = 0; i < a.length; i++) {
			if (a[i].checked) {
				num++;
			}
		}
		if (num == 0) {
			alert("请选择选择系统用户所属角色");
			return false;
		} else {
			var flag = confirm("是否确认提交?");
			return flag;
		}
	}
	function hai(){
		//获取焦点
		$("#checkname").hide();
	}
	function wu(){
		//失去焦点  
		var name = document.getElementById("usr_name").value; 
		console.log(name);
		$.ajax({
			url:"${basePath}checkUsrname.action?name="+name,
			type:"post",
			dataType:"text", //响应的类型
			success:function(data){ //响应回来的内容
				console.log(data);
				if(data=="false"){
					console.log(data);
					$("#checkname").show();
				}
			}
		});
	}
</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>填写新用户信息</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-5"
					action="${basePath}doAddSysUsers.action" method="post"
					onsubmit="return doSubmit()">
					<div class="layui-form-item">
						<label class="layui-form-label"><b>用户名</b></label>
						<div class="layui-input-block">
							<input id="usr_name" type="text" name="usr_name" class="layui-input" value="" onfocus="hai()" onblur="wu()" placeholder="请输入用户名">
						</div>
						<div class="layui-input-block"><span id="checkname" hidden="" style="font-size: 18px;color: red;">用户名已存在!</span></div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><b>初始密码</b></label>
						<div class="layui-input-block">
							<input id="usr_pwd" type="text" name="usr_password"
								class="layui-input" value="" placeholder="请输入密码">
								<div class="layui-input-block"></div>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><b>所属角色</b></label>
						<div class="layui-input-block">
							<c:forEach items="${sysRoles}" var="item">
								<input type="radio" name="usr_role_id" value="${item.role_id}"
									title="${item.role_name}">
								<div class="layui-unselect layui-form-radio">
									<i class="layui-anim layui-icon"></i><span>${item.role_name}</span>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><b>姓名</b></label>
						<div class="layui-input-block">
							<input type="text" name="user_name" class="layui-input" value="" placeholder="请输入真实名字">
						</div>
					</div>
					<input type="text" name="usr_flag" value="1" hidden="hidden">
					<div class="layui-form-item">
						<div class="layui-input-block">
							<input type="submit" value="提交" class="layui-btn">
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
