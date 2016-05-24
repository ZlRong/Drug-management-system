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
		<div id="pageBody">
		<h1>采购批次：${batchNumber}</h1>
		<table class="uk-text-center uk-table uk-table-striped uk-table-hover">
			<thead>
				<tr>
					<th class="uk-text-center">批准文号</th>
					<th class="uk-text-center">药品名称</th>
					<th class="uk-text-center">单价成本</th>
					<th class="uk-text-center">采购数量</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${query}">
					<tr>
						<td>${u.licenseNumber}</td>
						<td>${u.medicineName}</td>
						<td>${u.costPrice}</td>
						<td>${u.number}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>