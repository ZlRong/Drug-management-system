<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>药品销售系统</title>
	<link rel="stylesheet" href="/dms/css/uikit.almost-flat.min.css" />
    <script src="/dms/js/jquery-2.0.0.min.js"></script>
    <script src="/dms/js/uikit.min.js"></script>
    <script src="/dms/js/components/pagination.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$('[data-uk-pagination]').on('select.uk.pagination', function(e, pageIndex){
    			$.ajax({
    	        	'url':'http://localhost:8081/dms/medicinesales/JSONQuery.action',
    	        	'type':'post',
    	        	'data':{
    	        		'page.currentPage':pageIndex+1
    	        	},
    	        	'dataType':'json',
    	        	'success':function(data){
    	        		$('#tb-body').empty();
    	        		for(var i = 0;i<data.length;i++){
    	        			var row = '';
        	        		row = row +'<tr>'; 
    	        			row = row +'<td><a tid="'+data[i].saleBatchNumber+'" class="uk-button uk-button-link" href="#modaldetail" data-uk-modal="{target:\'#modaldetail\'}">'+data[i].saleBatchNumber+'</a></td>';
    	        			row = row +'<td>'+data[i].saleDate+'</td>';
    	        			row = row +'<td>'+data[i].name+'</td>';
    	        			row = row +'</tr>';
    	        			$('#tb-body').append(row);
    	        		}

    	        		$('a[tid]').on('click',function(){
    	        			var s = $(this).attr('tid');
    	        			window.iframedetail.location.href='/dms/medicinesales/detail.action?vo.saleBatchNumber='+s;
    	        		});
    	        	}
    	        });
    	    });
    		
    		$('a[tid]').on('click',function(){
    			var s = $(this).attr('tid');
    			window.iframedetail.location.href='/dms/medicinesales/detail.action?vo.saleBatchNumber='+s;
    		});
    		
    		var msg = '${msg}';
    		if(msg!=''){
    			$('#msg').text(msg);
    			var modal = UIkit.modal("#modalmsg");
    			modal.show();
    		};
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
				<li><a class="uk-button" href="/dms/index.action" >首页</a></li>
				<li><a class="uk-button" href="/dms/user/query.action">员工管理</a></li>
				<li><a class="uk-button" href="/dms/medicinestorehouse/query.action">库存管理</a></li>
				<li><a class="uk-button" href="/dms/medicinepurchase/query.action">药品采购</a></li>
				<li class="uk-active"><a class="uk-button" href="/dms/medicinesales/query.action">药品销售</a></li>
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
		<a class="uk-button uk-button-primary" href="/dms/medicinesales/toAdd.action">销售</a>
	</div>
	<div id="pageBody">
		<table class="uk-text-center uk-table uk-table-striped uk-table-hover">
			<thead>
				<tr>
					<th class="uk-text-center">销售批次</th>
					<th class="uk-text-center">销售日期</th>
					<th class="uk-text-center">用户</th>
				</tr>
			</thead>
			<tbody id="tb-body">
				<c:forEach var="u" items="${query}">
					<tr>
						<td><a tid="${u.saleBatchNumber}" class="uk-button uk-button-link" href="#modaldetail" data-uk-modal="{target:'#modaldetail'}">${u.saleBatchNumber }</a></td>
						<td>${u.saleDate }</td>
						<td>${u.name }</td>
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
	<div id="modalmsg" class="uk-modal">
		<div class="uk-modal-dialog uk-modal-dialog-large">
			<a class="uk-modal-close uk-close"></a>
			<div id="msg"></div>
		</div>
	</div>
</body>
</html>