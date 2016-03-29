<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="uk-height-1-1">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>药品管理系统登录</title>
	<link rel="stylesheet" type="text/css" href="/dms/css/uikit.almost-flat.min.css"/>
	<script src="/dms/js/jquery-2.0.0.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/dms/js/uikit.min.js" type="text/javascript" charset="utf-8"></script>

</head>
<body class="uk-height-1-1">
	<div class="uk-vertical-align uk-text-center uk-height-1-1">
		<div class="uk-vertical-align-middle" style="width: 250px;">
			<form id="loginForm" class="uk-panel uk-panel-box uk-form" action="login/login.action" method="post">
		<fieldset id="">
			<legend><label class="uk-h1">登录</label></legend>
			<div class="uk-form-row">
				<input class="uk-width-1-1 uk-form-large" type="text" id="username" name="vo.username" placeholder="用户名" />			
			</div>
			<div class="uk-form-row">
				<input class="uk-width-1-1 uk-form-large" type="password" id="password" name="vo.password" placeholder="密码" />			
			</div>	
			<div class="uk-form-row">
				<button class="uk-width-2-3 uk-button uk-button-large uk-button-primary">确定</button>
				
			</div>
		</fieldset>
	</form>
		</div>
	</div>
</body>
</html>