<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<script type="text/javascript" src="js/login.js"></script>
<title>登录页面</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="login-pannel panel panel-primary">
				<div class="panel-heading">
					<!-----------------logo--------------->
					<div>
						<img src="image/logo.png">
					</div>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" action="login"
						method="post">
						<!------------------------------ 用户名输入框 ---------------------------->
						<div class="form-group" id="unameDiv">
							<label for="uname" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="uname" name="uname"
									placeholder="请输入用户名" onblur="validateEmpty(this.id);" autofocus>
							</div>
							<div class="col-sm-2" id="unameSpan"></div>
						</div>
						<!------------------------------ 密码输入框 ---------------------------->
						<div class="form-group" id="pwdDiv">
							<label for="pwd" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="pwd" name="pwd"
									placeholder="请输入密码" onblur="validateEmpty(this.id);">
							</div>
							<div class="col-sm-2" id="pwdSpan"></div>
						</div>
						<!------------------------------ 验证码输入框 ---------------------------->
						<div class="form-group" id="vcodeDiv">
							<label for="vcode" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="vcode" name="vcode"
									placeholder="请输入验证码" onblur="validateEmpty(this.id);">
							</div>
							<!------------------------验证码 ---------------------------->
							<div class="col-sm-4">
								<img src="getCode" onclick="this.src='getCode?'+Math.random()">
							</div>
							<div class="col-sm-2" id="vcodeSpan"></div>
						</div>
						<!------------------------------ 登录按钮---------------------------->
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-8">
								<button type="submit" class="btn btn-primary btn-lg btn-block"
									onclick="return validateSubmit();">登录</button>
							</div>
						</div>
						<!-----------------------------错误提示---------------------------->
						<div>
							<span style="color:red;">${msg}</span>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
