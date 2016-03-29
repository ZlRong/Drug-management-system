<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
	<div id="pageBody">
		<form class="uk-form uk-form-horizontal" action="/dms/user/update.action" method="post">

		    <fieldset data-uk-margin>
		        <legend>编辑员工</legend>
		        <div class="uk-text-center uk-width-1-1">
					<div class="uk-container-center uk-width-1-3">
						<input type="hidden" name="vo.id" value="${edit.id}">
						<div class="uk-form-row"><label class="uk-form-label">姓名：</label><input type="text" name="vo.name" value="${edit.name }" /></div>
						<div class="uk-form-row"><label class="uk-form-label">工号：</label><input type="text" name="vo.number" value="${edit.number }" /></div>
						<div class="uk-form-row"><label class="uk-form-label">地址：</label><input type="text" name="vo.address" value="${edit.address }" /></div>
						<div class="uk-form-row"><label class="uk-form-label">联系方式：</label><input type="text" name="vo.phone" value="${edit.phone }" /></div>
						<div class="uk-form-row"><label class="uk-form-label">职业：</label>
						<select name="vo.job">
							<option value="药品管理员" <c:if test="${edit.job=='药品管理员'}">selected="selected"</c:if>>药品管理员</option>
							<option value="药品销售员" <c:if test="${edit.job=='药品销售员'}">selected="selected"</c:if>>药品销售员</option>
							<option value="药品采购员" <c:if test="${edit.job=='药品采购员'}">selected="selected"</c:if>>药品采购员</option>
							<option value="经理" <c:if test="${edit.job=='经理'}">selected="selected"</c:if>>经理</option>
						</select></div>
						<div class="uk-form-row"><button class="uk-button uk-button-large uk-button-primary">确定</button></div>
					</div>
				</div>
		    </fieldset>

		</form>
	</div>
</body>
</html>