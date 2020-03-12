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
<title>添加商品</title>
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
<script type="text/javascript" src="${basePath}zyupload/jquery-1.7.2.js"></script>
<link rel="stylesheet"
	href="${basePath}zyupload/zyupload-1.0.0.min.css " type="text/css">
<!-- 引用控制层插件样式 -->
<script type="text/javascript"
	src="${basePath}zyupload/zyupload-1.0.0.min.js"></script>
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
	function doDelSysuser(id) {
		$.ajax({
			url:"${basePath}/doDelSysuser.action?id="+id,
			type:"post",
			dataType:"text", //响应的类型
			success:function(data){ //响应回来的内容
				if(data=="true"){
					$("#tr_"+id).remove();
				}
			}
		});
	}
	function doSpec(){
		$.ajax({
			url:"${basePath}/doDelSysuser.action?id="+id,
			type:"post",
			dataType:"json", //响应的类型
			success:function(data){ //响应回来的内容
				
			}
		});
	}
</script>
<style>
div {
	display: block;
}

#preview {
	margin-top: 10px
}

ul {
	width: 100%;
}

li {
	display: inline
}
</style>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>填写商品信息</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-5"
					action="${basePath}doProductsAdd.action" method="post"
					onsubmit="return doSubmit()">
					<div class="layui-form-item">
						<label class="layui-form-label"><b>商品名称</b></label>
						<div class="layui-input-block">
							<input id="prod_name" type="text" name="prod_name"
								class="layui-input" value="" placeholder="请输入商品名">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><b>商品分类</b></label>
						<div class="layui-input-block">
							<select class="form-control" name="prod_type">
								<c:forEach items="${productCate}" var="item">
									<option value="${item.cate_name}">${item.cate_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><b>商品规格</b></label>
						<table class="layui-table" style="margin-left: 120px">
							<tr>
								<c:forEach items="${productSpec}" var="item">
									<td><input name="spec_names" type="checkbox" value="${item.spec_name}" title="${item.spec_name}"></td>
								</c:forEach>
								<td>
									<a onclick="doSpec()" class="btn btn-default">生成全部规格</a>
								</td>
							</tr>
						</table>
					</div>
					<div class="layui-form-item" style="width: 890px; height: 340px">
						<label class="layui-form-label"><b>商品主图</b></label>
						<div id="zyupload" class="zyupload"></div>
						<input type="text" value="" id="wu" name="prod_pic"
							style="display: none">
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><b>商品价格</b></label>
						<div class="layui-input-block">
							<input type="text" name="prod_price" class="layui-input" value=""
								placeholder="请输入商品价格">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><b>库存数</b></label>
						<div class="layui-input-block">
							<input type="text" name="prod_number" class="layui-input"
								value="" placeholder="请输入库存数">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><b>是否上架</b></label>
						<div class="layui-input-block">
							<input type="radio" name="prod_flat" value="1" title="是"
								checked="">
							<div class="layui-unselect layui-form-radio layui-form-radioed">
								<i class="layui-anim layui-icon"></i><span>是</span>
							</div>
							<input type="radio" name="prod_flat" value="0" title="否">
							<div class="layui-unselect layui-form-radio">
								<i class="layui-anim layui-icon"></i><span>否</span>
							</div>
						</div>
					</div>
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
</body>
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
	$(function() {
		// 初始化插件
		$("#zyupload").zyUpload({
			width : "650px", // 宽度
			height : "400px", // 宽度
			itemWidth : "140px", // 文件项的宽度
			itemHeight : "115px", // 文件项的高度
			url : "${basePath}fileUpload.action", // 上传文件的路径
			fileType : [ "jpg", "png", "PNG", "JPG" ],// 上传文件的类型
			fileSize : 51200000, // 上传文件的大小
			multiple : true, // 是否可以多个文件上传
			dragDrop : true, // 是否可以拖动上传文件
			tailor : true, // 是否可以裁剪图片
			del : true, // 是否可以删除文件
			finishDel : false, // 是否在上传文件完成后删除预览
			/* 外部获得的回调接口 */
			// 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
			onSelect : function(selectFiles, allFiles) {
			},
			// 删除一个文件的回调方法
			onDelete : function(file) {
				alert("当前删除了此文件：" + file.name);
			},
			// 每文件上传成功的回调方法
			onSuccess : function(file, str) {
				alert("此文件上传成功：" + file.name);
				alert(str);
				$("#wu").val(str);
			},
			// 文件上传失败的回调方法
			onFailure : function(file, response) {
				alert("此文件上传失败:" + file.name);
			},
			// 上传完成的回调方法
			onComplete : function(response) {
				alert("所有文件上传完成！！！");
				var data = JSON.parse(response);
				alert(data.rc + "," + data.msg + "," + data.value);
			}
		});
	});
	function doSubmit() {
		var a = $("#wu").val();
		//var a = document.getElementsByName("prod_pic").value;
		console.log(a);
		if (a == "") {
			alert("请上传商品图片！");
			return false;
		} else {
			var flag = confirm("是否确认提交?");
			return flag;
		}
	}
</script>
</body>
</html>
