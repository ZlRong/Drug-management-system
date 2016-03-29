<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>药品管理系统</title>
	<link rel="stylesheet" href="/dms/css/uikit.almost-flat.min.css" />
    <script src="/dms/js/jquery-2.0.0.min.js"></script>
    <script src="/dms/js/uikit.min.js"></script>
    <script src="/dms/js/components/pagination.min.js"></script>
    <script>
    
    	$(function(){
    		var error = '${error}';
    		if(error!=''){
    			$('#error').text(error);
    			var modal = UIkit.modal("#modalerror");
    			modal.show();
    		}
    	});
    	var validateForm = function(){
    		var pwd = $("#newpassword").val();
    		var cfgpwd = $("#cfgpwd").val();
    		if(pwd===cfgpwd){
    			return true;
    		}
    		else{
    			$("#msg").text("两次新密码不相同。");
    			return false;
    		}
    	}
    </script>
</head>
<body>
	<div id="pageHead">
		<nav class="uk-navbar">
			<ul class="uk-navbar-nav">
				<li><a class="uk-button" href="/dms/index.action" >首页</a></li>
				<li><a class="uk-button" href="/dms/user/query.action">员工管理</a></li>
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
		<form class="uk-form" action="/dms/login/changePassword.action" onsubmit="return validateForm()" method="post">

		    <fieldset data-uk-margin>
		        <legend>修改密码</legend>
		        <div class="uk-form-row"><input type="password" name="password" placeholder="原密码"></div>
		        <div class="uk-form-row"><input type="password" id="newpassword" name="newPassword" placeholder="新密码"></div>
		        <div class="uk-form-row"><input type="password" id="cfgpwd" placeholder="确认新密码"><span style="color:red" id="msg"></span></div>
		        <button class="uk-button">确定</button>
		    </fieldset>
		</form>
	</div>
	<div id="modalerror" class="uk-modal">
		<div class="uk-modal-dialog uk-modal-dialog-large">
			<a class="uk-modal-close uk-close"></a>
			<div id="error"></div>
		</div>
	</div>
</body>
</html>