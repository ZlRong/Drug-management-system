<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>药品统计</title>
	<link rel="stylesheet" href="/dms/css/uikit.almost-flat.min.css" />
	<link rel="stylesheet" type="text/css" href="/dms/css/components/datepicker.css"/>
	<link rel="stylesheet" type="text/css" href="/dms/css/components/form-select.css"/>
    <script src="/dms/js/jquery-2.0.0.min.js"></script>
    <script src="/dms/js/uikit.min.js"></script>
    <script src="/dms/js/components/datepicker.js"></script>
    <script src="/dms/js/components/form-select.js"></script>
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
				<li class="uk-active"><a class="uk-button" href="/dms/medicinestatistics/query.action">药品统计</a></li>
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
	<div id="pageBtn" class="uk-margin uk-text-center">
		<form class="uk-form" action="/dms/medicinestatistics/query.action" method="post">
			<input type="text" name="date" data-uk-datepicker="{format:'YYYY-MM-DD',maxDate:0}" placeholder="日期" />
			<button class="uk-button uk-button-primary">确定</button>
		</form>
	</div>
	<div id="pageBody" class='uk-margin-left uk-margin-right uk-margin'>
		<div class='uk-panel uk-panel-box uk-text-center uk-margin'>
			<h3>月统计</h3>
			<img src="/dms/chart/queryNumberAllMedicine.action?date=${dateStr}" />
			<img src="/dms/chart/querySalesAllMedicine.action?date=${dateStr}" />
		</div>
		<div class='uk-panel uk-panel-box uk-text-center uk-margin'>
			<h3>年统计</h3>
			<img src="/dms/chart/queryNumberAllMedicineYear.action?date=${dateStr}" />
			<img src="/dms/chart/querySalesAllMedicineYear.action?date=${dateStr}" />
		</div>
		<div class='uk-panel uk-panel-box uk-text-center uk-margin'>
			<h3>盈利分析</h3>
			<img src="/dms/chart/queryPA.action?date=${dateStr}" />
		</div>
	</div>
</body>
</html>