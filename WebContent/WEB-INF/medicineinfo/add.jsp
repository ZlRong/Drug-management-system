<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>药品管理系统</title>
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
		<form class="uk-form uk-form-horizontal" action="/dms/medicineinfo/add.action" method="post">

		    <fieldset data-uk-margin>
		        <legend>添加药品信息</legend>
				<div class="uk-grid">
						<div class="uk-width-1-3">
						<label class="uk-form-label">批准文号</label>
						<input type="text" placeholder="" name="vo.licenseNumber" />
					</div>
					<div class="uk-width-1-3">
						<label class="uk-form-label">产品名称</label>
						<input type="text" placeholder="" name="vo.medicineName" />
					</div>
					<div class="uk-width-1-3">
						<label class="uk-form-label">英文名称</label>
						<input type="text" placeholder="" name="vo.medicineENName" />
					</div>
					<div class="uk-width-1-3">
						<label class="uk-form-label">商品名</label>
						<input type="text" placeholder="" name="vo.productName" />
					</div>
					<div class="uk-width-1-3">
						<label class="uk-form-label">剂型</label>
						<input type="text" placeholder="" name="vo.dosageForm" />
					</div>
					<div class="uk-width-1-3">
							<label class="uk-form-label">规格</label>
							<input type="text" placeholder="" name="vo.spec" />
					</div>
					<div class="uk-width-1-3">
						<label class="uk-form-label">生产单位</label>
						<input type="text" placeholder="" name="vo.productionUnit" />
					</div>
					<div class="uk-width-1-3">
						<label class="uk-form-label">生产地址</label>
						<input type="text" placeholder="" name="vo.productionAddress" />
					</div>
					<div class="uk-width-1-3">
						<label class="uk-form-label">产品类别</label>
						<input type="text" placeholder="" name="vo.medicineType" />
					</div>
					<div class="uk-width-1-3">
						<label class="uk-form-label">原批准文号</label>
						<input type="text" placeholder="" name="vo.originalLicenseNumber" />
					</div>
					<div class="uk-width-1-3">
							<label class="uk-form-label">批准日期</label>
							<input type="text" placeholder="" name="vo.licenseDate" data-uk-datepicker="{format:'YYYY-MM-DD',maxDate:0}" />
					</div>
					<div class="uk-width-1-3">
						<label class="uk-form-label">药品本位码</label>
						<input type="text" placeholder="" name="vo.drugStandardCode" />
					</div>
					<div class="uk-width-1-1">
						<label class="uk-form-label">药品本位码备注</label>
						<input type="text" class="uk-form-width-large" placeholder="" name="vo.drugStandardCodeRemark" />
					</div>
			
				</div>
				<button class="uk-button uk-button-large uk-button-primary">确定</button>
		    </fieldset>

		</form>
	</div>
</body>
</html>