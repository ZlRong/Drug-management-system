<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>药品管理系统</title>
	<link rel="stylesheet" href="css/uikit.almost-flat.min.css" />
    <script src="js/jquery-2.0.0.min.js"></script>
    <script src="js/uikit.min.js"></script>
    <script src="js/components/pagination.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$('[data-uk-pagination]').on('select.uk.pagination', function(e, pageIndex){
    	        alert('You have selected page: ' + (pageIndex+1));
    	    });
    		
    		$('a[tid]').on('click',function(){
    			var s = $(this).attr('tid');
    			window.iframedetail.location.href='medicineinfo/detail.action?vo.id='+s;
    		})
    	});
    	$('#modaldetail').on({

    	    'show.uk.modal': function(){
    	        console.log("Modal is visible.");
    	    },

    	    'hide.uk.modal': function(){
    	        console.log("Element is not visible.");
    	    }
    });
    </script>
</head>
<body>
	<div id="pageHead">
		<nav class="uk-navbar">
			<ul class="uk-navbar-nav">
				<li class="uk-active"><a class="uk-button" href="#" >首页</a></li>
				<li><a class="uk-button" href="/dms/medicinestorehouse/query.action">库存管理</a></li>
				<li><a class="uk-button" href="">药品采购</a></li>
				<li><a class="uk-button" href="">药品销售</a></li>
				<li><a class="uk-button" href="">药品统计</a></li>
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
		<table class="uk-text-center uk-table uk-table-striped uk-table-hover">
			<thead>
				<tr>
					<th class="uk-text-center">药品名称</th>
					<th class="uk-text-center">批准文号</th>
					<th class="uk-text-center">生产单位</th>
					<th class="uk-text-center">药品本位码</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${query}">
					<tr>
							<td><a tid="${u.id}" class="uk-button uk-button-link" href="#modaldetail" data-uk-modal="{target:'#modaldetail'}">${u.medicineName }</a></td>
							<td>${u.licenseNumber }</td>
							<td>${u.productionUnit }</td>
							<td>${u.drugStandardCode }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="pagination">
		<ul class="uk-pagination" data-uk-pagination="{items:${page.items}, itemsOnPage:${page.itemsOnPage}, currentPage:${page.currentPage}-1}"></ul>
	</div>
	<div id="modaldetail" class="uk-modal">
		<div class="uk-modal-dialog uk-modal-dialog-large">
			<a class="uk-modal-close uk-close"></a>
			<iframe frameborder="0" name="iframedetail" width="1100px" height="450px"></iframe>
		</div>
	</div>
</body>
</html>