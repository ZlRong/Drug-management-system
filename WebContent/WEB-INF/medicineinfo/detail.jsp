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
	<div id="pageBody" class="uk-grid">
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">批准文号</div>
				${detail.licenseNumber}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">产品名称</div>
				${detail.medicineName}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">英文名称</div>
				${detail.medicineENName}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">商品名</div>
				${detail.productName}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">剂型</div>
				${detail.dosageForm}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">规格</div>
				${detail.spec}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">生产单位</div>
				${detail.productionUnit}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">生产地址</div>
				${detail.productionAddress}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">产品类别</div>
				${detail.medicineType}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">原批准文号</div>
				${detail.originalLicenseNumber}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">批准日期</div>
				${detail.licenseDate}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">药品本位码</div>
				${detail.drugStandardCode}
			</div>
		</div>
		<div class="uk-width-1-2">
			<div class="uk-panel uk-panel-box">
				<div class="uk-panel-title">药品本位码备注</div>
				${detail.drugStandardCodeRemark}
			</div>
		</div>
	</div>
</body>
</html>