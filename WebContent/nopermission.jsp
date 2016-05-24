<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>药品管理系统</title>
	<link rel="stylesheet" href="/dms/css/uikit.almost-flat.min.css" />
    <script src="/dms/js/jquery-2.0.0.min.js"></script>
    <script src="/dms/js/uikit.min.js"></script>
    <script src="/dms/js/components/pagination.min.js"></script>
</head>
<body>
	<div id="pageHead">
		<nav class="uk-navbar">
			<ul class="uk-navbar-nav">
				<li class="uk-active"><a class="uk-button" href="/dms/index.action" >首页</a></li>
				<li><a class="uk-button" href="/dms/user/query.action">员工管理</a></li>
				<li><a class="uk-button" href="/dms/medicinestorehouse/query.action">库存管理</a></li>
				<li><a class="uk-button" href="/dms/medicinepurchase/query.action">药品采购</a></li>
				<li><a class="uk-button" href="/dms/medicinesales/query.action">药品销售</a></li>
				<li><a class="uk-button" href="/dms/medicinestatistics/query.action">药品统计</a></li>
			</ul>
			<div class="uk-navbar-flip uk-navbar-content uk-hidden-small">
		
				<div class="uk-display-inline">欢迎&nbsp;${user.job}&nbsp;|&nbsp;${user.name}&nbsp;</div>
				<div class="uk-button-group">
					<a class="uk-button uk-button-primary" href="/dms/login/toChangePassword.action">修改密码</a>
					<a class="uk-button uk-button-danger" href="/dms/login/logout.action">注销</a>
				</div>
			</div>
		</nav>
	</div>
	
	<div id="pageBody" class='uk-panel uk-panel-box uk-margin-left uk-margin-right uk-margin'>
		<h1>没有权限!</h1>
	</div>
</body>
</html>