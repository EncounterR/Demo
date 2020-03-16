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
<html>
<head>
<meta charset="utf-8">
<title>聊天室</title>

<!-- Favicon -->
<link rel="icon" href="${basePath}dist/media/img/favicon.png"
	type="image/png">

<!-- Soho css -->
<link rel="stylesheet" href="${basePath}dist/css/soho.min.css">
<!-- JQuery -->
<script src="${basePath}common/bootstrap/jquery/jquery.min.js"></script>

<!-- Popper.js -->
<script src="${basePath}vendor/popper.min.js"></script>

<!-- Bootstrap -->
<script src="${basePath}vendor/bootstrap/bootstrap.min.js"></script>

<!-- Nicescroll -->
<script src="${basePath}vendor/jquery.nicescroll.min.js"></script>

<!-- Soho -->
<script src="${basePath}dist/js/soho.min.js"></script>

<!-- Examples -->
<script src="${basePath}dist/js/examples.js"></script>
</head>
<body>

	<!-- page loading -->
	<div class="page-loading"></div>
	<!-- ./ page loading -->
	<!-- layout -->
	<div class="layout">

		<!-- content -->
		<div class="content">

			<!-- sidebar group -->
			<div class="sidebar-group">

				<!-- Chats sidebar -->
				<div id="chats" class="sidebar active">
					<header>
						<span>Chats</span>
					</header>
					<form action="">
						<input type="text" class="form-control" placeholder="Search chat">
					</form>
					<div class="sidebar-body">
						<ul class="list-group list-group-flush" id="onLineUser">
							<li class="list-group-item open-chat">
								<div>
									<figure class="avatar">
										<img src="${basePath}dist/media/img/man_avatar3.jpg"
											class="rounded-circle">
									</figure>
								</div>
								<div class="users-list-body">
									<h5>武海强</h5>
									<div class="users-list-action action-toggle">
										<div class="dropdown">
											<a data-toggle="dropdown" href="#"> <i class="ti-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a href="#" class="dropdown-item">打开</a> <a href="#"
													data-navigation-target="contact-information"
													class="dropdown-item">自我介绍</a> <a href="#"
													class="dropdown-item">删除</a>
											</div>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<!-- ./ Chats sidebar -->

				<!-- Friends sidebar -->
				<div id="friends" class="sidebar">
					<form action="">
						<input type="text" class="form-control" placeholder="Search chat">
					</form>
					<div class="sidebar-body">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">
								<div>
									<figure class="avatar">
										<img src="${basePath}dist/media/img/man_avatar3.jpg"
											class="rounded-circle">
									</figure>
								</div>
								<div class="users-list-body">
									<h5>武海强</h5>
									<p>哈哈哈哈哈哈</p>
									<div class="users-list-action action-toggle">
										<div class="dropdown">
											<a data-toggle="dropdown" href="#"> <i class="ti-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a href="#" class="dropdown-item">打开</a> <a href="#"
													class="dropdown-item">删除</a>
											</div>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<!-- ./ Friends sidebar -->
			</div>
			<!-- ./ sidebar group -->

			<!-- chat -->
			<div class="chat">
				<div class="chat-header">
					<div class="chat-header-user">
						<figure class="avatar avatar-lg">
							<img src="${basePath}dist/media/img/man_avatar3.jpg"
								class="rounded-circle">
						</figure>
						<div>
							<h5>武海强</h5>
							<small class="text-muted"> <i>在线</i>
							</small>
						</div>
					</div>
					<div class="chat-header-action">
						<ul class="list-inline">
							<li class="list-inline-item"><a href="#"
								class="btn btn-secondary" data-toggle="dropdown"> <i
									class="ti-more"></i>
							</a>
								<div class="dropdown-menu dropdown-menu-right">
									<a href="#" class="dropdown-item">删除</a>
									<div class="dropdown-divider"></div>
									<a href="#" class="dropdown-item">Block</a>
								</div></li>
						</ul>
					</div>
				</div>
				<div class="chat-body">
					<!-- .no-message -->
					<!--
                <div class="no-message-container">
                    <i class="fa fa-comments-o"></i>
                    <p>Select a chat to read messages</p>
                </div>
                -->
					<div class="messages">
						<div class="message-item outgoing-message">
							<div class="message-content">早上好！武海强大帅哥！！</div>
							<div class="message-action">
								Am 09:34 <i class="ti-double-check"></i>
							</div>
						</div>
						<div class="message-item">
							<div class="message-content">早上好啊！</div>
							<div class="message-action">Pm 14:20</div>
						</div>
						<div class="message-item outgoing-message">
							<div class="message-content">干啥呢？</div>
							<div class="message-action">
								Pm 14:25 <i class="ti-double-check"></i>
							</div>
						</div>
						<div class="message-item">
							<div class="message-content">没干啥！</div>
							<div class="message-action">Pm 14:20</div>
						</div>
						<div class="message-item">
							<div class="message-content message-file">
								<div class="file-icon">
									<i class="ti-file"></i>
								</div>
								<div>
									<div>
										文件.pdf <i class="text-muted small">(50KB)</i>
									</div>
									<ul class="list-inline">
										<li class="list-inline-item"><a href="#">下载</a></li>
										<li class="list-inline-item"><a href="#">View</a></li>
									</ul>
								</div>
							</div>
							<div class="message-action">Pm 14:25</div>
						</div>
					</div>
				</div>
				<div class="chat-footer">
					<form action="">
						<input type="text" class="form-control" placeholder="输入内容"
							aria-label="Recipient's username"
							aria-describedby="button-addon2">
						<div class="form-buttons">
							<button class="btn btn-primary btn-floating" type="submit">
								<i class="fa fa-send"></i>
							</button>
						</div>
					</form>
				</div>
			</div>
			<!-- ./ chat -->
		</div>
		<!-- ./ content -->
		<input type="text" value="${username}" id="username"
			style="display: none" />
	</div>
	<!-- ./ layout -->
	<script type="text/javascript">
		var webSocket;
		var commWebSocket;
		console.log(document.getElementById('username').value);
		if ("WebSocket" in window) {
			webSocket = new WebSocket("ws://localhost:8080/websocket/"
					+ document.getElementById('username').value);

			//连通之后的回调事件
			webSocket.onopen = function() {
				//webSocket.send( document.getElementById('username').value+"已经上线了");
				console.log("已经连通了websocket");
				setMessageInnerHTML("已经连通了websocket");
			};

			//接收后台服务端的消息
			webSocket.onmessage = function(evt) {
				var received_msg = evt.data;
				console.log("数据已接收:" + received_msg);
				var obj = JSON.parse(received_msg);
				console.log("可以解析成json:" + obj.messageType);
				//1代表上线 2代表下线 3代表在线名单 4代表普通消息
				if (obj.messageType == 1) {
					//把名称放入到selection当中供选择
					var onlineName = obj.username;
					var option = "<option>" + onlineName + "</option>";
					$("#onLineUser").append(option);
					setMessageInnerHTML(onlineName + "上线了");
				} else if (obj.messageType == 2) {
					$("#onLineUser").empty();
					var onlineName = obj.onlineUsers;
					var offlineName = obj.username;
					var option = "<option>" + "--所有--" + "</option>";
					for (var i = 0; i < onlineName.length; i++) {
						if (!(onlineName[i] == document
								.getElementById('username').value)) {
							option += "<option>" + onlineName[i] + "</option>"
						}
					}
					$("#onLineUser").append(option);

					setMessageInnerHTML(offlineName + "下线了");
				} else if (obj.messageType == 3) {
					var onlineName = obj.onlineUsers;
					var option = null;
					for (var i = 0; i < onlineName.length; i++) {
						if (!(onlineName[i] == document
								.getElementById('username').value)) {
							option += "<li class='list-group-item open-chat'><div><figure class='avatar'><img src='${basePath}dist/media/img/man_avatar3.jpg' class='rounded-circle'></figure></div><div class='users-list-body'><h5>"
									+ onlineName[i]
									+ "</h5><div class='users-list-action action-toggle'><div class='dropdown'><div class='dropdown-menu dropdown-menu-right'><a href='#' class='dropdown-item'>打开</a><a href='#' data-navigation-target='contact-information' class='dropdown-item'>自我介绍</a><a href='#' class='dropdown-item'>删除</a></div></div></div>"
						}
					}
					$("#onLineUser").append(option);
					console.log("获取了在线的名单" + onlineName.toString());
				} else {
					setMessageInnerHTML(obj.fromusername + "对" + obj.tousername
							+ "说：" + obj.textMessage);
				}
			};

			//连接关闭的回调事件
			webSocket.onclose = function() {
				console.log("连接已关闭...");
				setMessageInnerHTML("连接已经关闭....");
			};
		} else {
			// 浏览器不支持 WebSocket
			alert("您的浏览器不支持 WebSocket!");
		}
		//将消息显示在网页上
		function setMessageInnerHTML(innerHTML) {
			document.getElementById('message').innerHTML += innerHTML + '<br/>';
		}

		function closeWebSocket() {
			//直接关闭websocket的连接
			webSocket.close();
		}

		function send() {
			var selectText = $("#onLineUser").find("option:selected").text();
			if (selectText == "--所有--") {
				selectText = "All";
			} else {
				setMessageInnerHTML(document.getElementById('username').value
						+ "对" + selectText + "说：" + $("#text").val());
			}
			var message = {
				"message" : document.getElementById('text').value,
				"username" : document.getElementById('username').value,
				"to" : selectText
			};
			webSocket.send(JSON.stringify(message));
			$("#text").val("");

		}
	</script>
</body>
</html>