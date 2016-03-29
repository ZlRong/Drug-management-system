<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>药品管理系统</title>
	<link rel="stylesheet" href="/dms/css/uikit.almost-flat.min.css" />
	<link rel="stylesheet" type="text/css" href="/dms/css/components/autocomplete.almost-flat.min.css"/>
    <script src="/dms/js/jquery-2.0.0.min.js"></script>
    <script src="/dms/js/uikit.min.js"></script>
    <script src="/dms/js/components/autocomplete.min.js"></script>
</head>
<body>
	<div id="pageHead">
		<nav class="uk-navbar">
			<ul class="uk-navbar-nav">
				<li><a class="uk-button" href="/dms/index.action" >首页</a></li>
				<li class="uk-active"><a class="uk-button" href="/dms/user/query.action">员工管理</a></li>
				<li><a class="uk-button" href="/dms/medicinestorehouse/query.action">库存管理</a></li>
				<li><a class="uk-button" href="/dms/medicinepurchase/query.action">药品采购</a></li>
				<li><a class="uk-button" href="/dms/medicinesales/query.action">药品销售</a></li>
				<li><a class="uk-button" href="/dms/medicinestatistics/query.action">药品统计</a></li>
			</ul>
			<div class="uk-navbar-flip uk-navbar-content uk-hidden-small">
		
				<div class="uk-display-inline">欢迎${user.name}</div>
				<div class="uk-button-group">
					<a class="uk-button uk-button-primary" href="/dms/login/toChangePassword.action">修改密码</a>
					<a class="uk-button uk-button-danger" href="/dms/login/logout.action">注销</a>
				</div>
			</div>
		</nav>
	</div>
	
	<div id="pageBody">
		<form class="uk-form uk-form-horizontal" action="/dms/user/add.action" method="post">

		    <fieldset data-uk-margin>
		        <legend>添加新员工</legend>
		        <div class="uk-text-center uk-width-1-1">
					<div class="uk-container-center uk-width-1-3">
						<div class="uk-form-row"><label class="uk-form-label">姓名：</label><input type="text" name="vo.name" /></div>
						<div class="uk-form-row"><label class="uk-form-label">工号：</label><input type="text" name="vo.number" /></div>
						<div class="uk-form-row"><label class="uk-form-label">地址：</label><input type="text" name="vo.address" /></div>
						<div class="uk-form-row"><label class="uk-form-label">联系方式：</label><input type="text" name="vo.phone" /></div>
						<div class="uk-form-row"><label class="uk-form-label">职业：</label>
						<select name="vo.job">
							<option value="药品管理员">药品管理员</option>
							<option value="药品销售员">药品销售员</option>
							<option value="药品采购员">药品采购员</option>
							<option value="经理">经理</option>
						</select></div>
						<div class="uk-form-row"><label class="uk-form-label">用户名：</label><input type="text" name="login.username" /></div>
						<div class="uk-form-row"><label class="uk-form-label">密码：</label><input type="password" name="login.password" /></div>
						<div class="uk-form-row"><button class="uk-button uk-button-large uk-button-primary">确定</button></div>
					</div>
				</div>
		    </fieldset>

		</form>
	</div>
</body>
</html>