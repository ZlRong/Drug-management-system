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
		<table class="uk-table">
			<thead>
				<tr>
					<th>药品名称</th>
					<th>批准文号</th>
					<th>生产单位</th>
					<th>药品本位码</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="pagination">
		<ul class="uk-pagination" data-uk-pagination="{items:100,itemsOnPage:20}"></ul>
	</div>
	
</body>
</html>