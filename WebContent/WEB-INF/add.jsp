<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>药品管理系统</title>
	<link rel="stylesheet" href="../css/uikit.almost-flat.min.css" />
    <script src="../js/uikit.min.js"></script>
    <script src="../js/jquery-2.0.0.min.js"></script>
    <script src="../js/components/pagination.min.js"></script>
</head>
<body>
	<div id="pageHead">
		<nav class="uk-navbar">
			<ul class="uk-navbar-nav">
				<li><a class="uk-button" href="">库存管理</a></li>
				<li><a class="uk-button" href="">药品采购</a></li>
				<li><a class="uk-button" href="">药品销售</a></li>
				<li><a class="uk-button" href="">药品统计</a></li>
			</ul>
		</nav>
	</div>
	
	<div id="pageBody">
		<form class="uk-form">

		    <fieldset data-uk-margin>
		        <legend>出售</legend>
		        <input type="text" placeholder="">
		        <input type="text" placeholder="">
		        <select>
		            <option>...</option>
		            <option>...</option>
		        </select>
		        <button class="uk-button">确定</button>
		        <label><input type="checkbox"></label>
		    </fieldset>

		</form>
	</div>
</body>
</html>