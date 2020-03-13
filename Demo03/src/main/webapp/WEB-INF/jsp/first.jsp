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
<title>首页</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<!-- load css -->
<link rel="stylesheet" type="text/css"
	href="${basePath}common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="${basePath}common/global.css" media="all">
<link rel="stylesheet" type="text/css"
	href="${basePath}css/adminstyle.css" media="all">
</head>
<body>
	<div class="layui-layout layui-layout-admin" id="layui_layout">
		<!-- 顶部区域 -->
		<div class="layui-header header header-demo">
			<div class="layui-main">
				<!-- logo区域 -->
				<div class="admin-logo-box">
					<a class="logo" href="http://www.kuxuebao.net" title="logo">后台管理系统</a>
					<div class="larry-side-menu">
						<i class="fa fa-bars" aria-hidden="true"></i>
					</div>
				</div>
				<!-- 右侧导航 -->
				<ul class="layui-nav larry-header-item">
					<li class="layui-nav-item">账户名：${activeUser.username}</li>
					<li class="layui-nav-item"><a href="${basePath}logout.action">
							<i class="iconfont icon-exit"></i> 退出
					</a></li>
				</ul>
			</div>
		</div>
		<!-- 左侧侧边导航开始 -->
		<div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
			<div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">
				<!-- 左侧菜单 -->
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item layui-this"><a href="javascript:;"
						data-url="404.jsp"> <i class="iconfont icon-home1"
							data-icon='icon-home1'></i> <span>后台首页</span>
					</a></li>
					<li class="layui-nav-item layui-this"><a href="javascript:;"
						data-url="${basePath}myAccount.action?username=${activeUser.username}">
							<i class="iconfont icon-home1" data-icon='icon-home1'></i><span>账号信息</span>
					</a></li>
					<c:forEach items="${activeUser.sysRole.mlist}" var="menu">
						<li class="layui-nav-item"><a href="javascript:;"> <i
								class="iconfont icon-jiaoseguanli"></i> <span>${menu.right_tip}</span>
								<em class="layui-nav-more"></em>
						</a>
							<dl class="layui-nav-child">
								<c:forEach items="${menu.sysModles}" var="item">
									<dd>
										<a href="javascript:;" data-url="${basePath}${item.right_url}">
											<i class="iconfont icon-geren1" data-icon='icon-geren1'></i>
											<span>${item.right_tip}</span>
										</a>
									</dd>
								</c:forEach>
							</dl></li>
					</c:forEach>
					<!-- 友链设置 -->
					<li class="layui-nav-item layui-this"><a href="javascript:;"
						data-url="${basePath}websocket.action">
							<i class="iconfont icon-home1" data-icon='icon-home1'></i><span>聊天</span>
					</a></li>
				</ul>
			</div>
		</div>

		<!-- 左侧侧边导航结束 -->
		<!-- 右侧主体内容 -->
		<div class="layui-body" id="larry-body"
			style="bottom: 0; border-left: solid 2px #2299ee;">
			<div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab"
				lay-filter="demo" lay-allowclose="true">
				<div class="go-left key-press pressKey" id="titleLeft"
					title="滚动至最右侧">
					<i class="larry-icon larry-weibiaoti6-copy"></i>
				</div>
				<ul class="layui-tab-title">
					<li class="layui-this" id="admin-home"><i
						class="iconfont icon-diannao1"></i><em>后台首页</em></li>
				</ul>
				<div class="go-right key-press pressKey" id="titleRight"
					title="滚动至最左侧">
					<i class="larry-icon larry-right"></i>
				</div>
				<div class="layui-tab-content" style="min-height: 150px;">
					<div class="layui-tab-item layui-show">
						<iframe class="larry-iframe" data-id='0'
							src="${basePath}main.action"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!-- 底部区域 -->
		<div class="layui-footer layui-larry-foot" id="larry-footer">
			<div class="layui-mian">
				<p class="p-admin">
					<span>2019 &copy;</span> 武海强好帅
				</p>
			</div>
		</div>
	</div>
	<!-- 加载js文件-->
	<script type="text/javascript" src="${basePath}common/layui/layui.js"></script>
	<script type="text/javascript" src="${basePath}js/larry.js"></script>
	<script type="text/javascript" src="${basePath}js/index.js"></script>

</body>
</html>
