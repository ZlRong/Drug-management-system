<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>药品管理系统</title>
	<link rel="stylesheet" href="/dms/css/uikit.almost-flat.min.css" />
	<link rel="stylesheet" type="text/css" href="/dms/css/components/datepicker.css"/>
    <script src="/dms/js/jquery-2.0.0.min.js"></script>
    <script src="/dms/js/uikit.min.js"></script>
    <script src="/dms/js/components/datepicker.js"></script>
    <script>
		$(function(){
			$("#addpurchase").on('click',function(){
	    		var tb = $("#tb_purchase tbody");
	    		tb.append('<tr><td><input type="text" name="drugStandardCode"></td><td><input type="text" name="costPrice"></td><td><input type="text" name="number"></td><td><input type="text" name="mfg" data-uk-datepicker="{format:&#39;YYYY-MM-DD&#39;}"></td><td><input type="text" name="exp" data-uk-datepicker="{format:&#39;YYYY-MM-DD&#39;}"></td></tr>');
			});
		});
    </script>
</head>
<body>
	<div id="pageHead">
		<nav class="uk-navbar">
			<ul class="uk-navbar-nav">
				<li><a class="uk-button" href="/dms/index.action" >首页</a></li>
				<li><a class="uk-button" href="/dms/medicinestorehouse/query.action">库存管理</a></li>
				<li class="uk-active"><a class="uk-button" href="/dms/medicinepurchase/query.action">药品采购</a></li>
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
	<div id="pageBtn">
		<a id="addpurchase" class="uk-button uk-button-primary">添加</a>
	</div>
	<div id="pageBody" class='uk-panel uk-panel-box uk-margin uk-margin-left uk-margin-right'>
		<form class="uk-form uk-form-horizontal" action="/dms/medicinepurchase/add.action" method="post">

		    <fieldset data-uk-margin>
		        <legend>采购药品</legend>
				<table id="tb_purchase">
					<thead>
						<tr>
							<th>药品本位码</th>
							<th>成本</th>
							<th>数量</th>
							<th>生产日期</th>
							<th>过期日期</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" name="drugStandardCode"></td>
							<td><input type="text" name="costPrice"></td>
							<td><input type="text" name="number"></td>
							<td><input type="text" name="mfg" data-uk-datepicker="{format:'YYYY-MM-DD'}"></td>
							<td><input type="text" name="exp" data-uk-datepicker="{format:'YYYY-MM-DD'}"></td>
						</tr>
					</tbody>
				</table>
				
				<button class="uk-button uk-button-large uk-button-primary">确定</button>
		    </fieldset>

		</form>
	</div>
</body>
</html>