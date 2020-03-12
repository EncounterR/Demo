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
<script type="text/javascript">
	function doSubmit() {
		var a = document.getElementsByName("ids");
		var num=0;
		for (var i=0; i<a.length; i++){
			if(a[i].checked){
				num++;
			}
		}
		if(num==0){
			alert("请为该角色授予权限！");
			return false;
		}
		else{
			var flag = confirm("是否确认提交?");
			return flag;
		}	 	
	}
	</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>填写角色信息</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-5"
					action="${basePath}doSysRoleAdd.action" method="post"
					onsubmit="return doSubmit()">
					<div class="layui-form-item">
						<label class="layui-form-label">角色名</label>
						<div class="layui-input-block">
							<input id="role_name" type="text" name="role_name" class="layui-input" value="">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">角色详情</label>
						<div class="layui-input-block">
							<input id="role_desc" type="text" name="role_desc" class="layui-input"
								value="">
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><h4><b>分配权限</b></h4></label>
						<table class="layui-table">
							<tbody>
								<c:forEach items="${sysModle}" var="item">
									<tr>
										<td><b>${item.right_tip}</b></td>
									</tr>
									<tr>
										<c:forEach items="${item.sysModles}" var="modle">
											<td>
												<input name="ids" type="checkbox" value="${modle.right_code}" title="${modle.right_tip}">
											</td>
										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">状态</label>
						<div class="layui-input-block">
							<input type="radio" name="role_flag" value="1" title="正常"
								checked="">
							<div class="layui-unselect layui-form-radio layui-form-radioed">
								<i class="layui-anim layui-icon"></i><span>正常</span>
							</div>
							<input type="radio" name="role_flag" value="0" title="停用">
							<div class="layui-unselect layui-form-radio">
								<i class="layui-anim layui-icon"></i><span>停用</span>
							</div>
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
