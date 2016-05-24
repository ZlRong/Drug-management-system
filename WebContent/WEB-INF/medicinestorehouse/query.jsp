<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>药品库存管理系统</title>
	<link rel="stylesheet" href="/dms/css/uikit.almost-flat.min.css" />
    <script src="/dms/js/jquery-2.0.0.min.js"></script>
    <script src="/dms/js/uikit.min.js"></script>
    <script src="/dms/js/components/pagination.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$('[data-uk-pagination]').on('select.uk.pagination', function(e, pageIndex){
    			$.ajax({
    	        	'url':'http://localhost:8081/dms/medicinestorehouse/JSONQuery.action',
    	        	'type':'post',
    	        	'data':{
    	        		'page.currentPage':pageIndex+1
    	        	},
    	        	'dataType':'json',
    	        	'success':function(data){
    	        		$('#tb-body').empty();
    	        		for(var i = 0;i<data.length;i++){
    	        			var row = '';
    	        			if(data[i].status=='已过期'){
        	        			row = row +'<tr style="background-color:#ff0000">'; 
    	        			}
    	        			else{
        	        			row = row +'<tr>'; 
    	        			}
    	        			row = row +'<td>'+data[i].id+'</td>';
    	        			row = row +'<td><a tid="'+data[i].medicineId+'" class="uk-button uk-button-link" href="#modaldetail" data-uk-modal="{target:\'#modaldetail\'}">'+data[i].medicineName+'</a></td>';
    	        			row = row +'<td>'+data[i].mfg+'</td>';
    	        			row = row +'<td>'+data[i].exp+'</td>';
    	        			row = row +'<td>'+data[i].number+'</td>';
    	        			row = row +'<td>'+data[i].costPrice+'</td>';
    	        			row = row +'<td>'+data[i].price+'</td>';
    	        			row = row +'<td>'+data[i].status+'</td>';
    	        			row = row +'<td>';
    	        			if(data[i].status=='已过期'){
        	        			row = row +'<a z-data="'+data[i].id+'" class="uk-button uk-button" href="/dms/medicinestorehouse/dealWith.action?vo.id='+data[i].id+'">处理</a>';
    	        			}
    	        			if(data[i].status=='已上架'){
        	        			row = row +'<a z-data="'+data[i].id+'" class="uk-button uk-button-primary" href="/dms/medicinestorehouse/downMedicine.action?vo.id='+data[i].id+'">下架</a>';
    	        			}
    	        			if(data[i].status=='未上架'){
        	        			row = row +'<a z-data="'+data[i].id+'" class="uk-button uk-button-primary upmedicine" href="#modalup" data-uk-modal="{target:\'#modalup\'}">上架</a>';
    	        			}
    	        			row = row +'</td>';
    	        			row = row +'</tr>';
    	        			$('#tb-body').append(row);
    	        		}
    	        		
    	        		$('a[tid]').on('click',function(){
	            			var s = $(this).attr('tid');
	            			window.iframedetail.location.href='/dms/medicineinfo/detail.action?vo.id='+s;
	            		});
    	        	}
    	        });
    	    });
    		
    		$('a[tid]').on('click',function(){
    			var s = $(this).attr('tid');
    			window.iframedetail.location.href='/dms/medicineinfo/detail.action?vo.id='+s;
    		});
    		
    		$('.upmedicine').click(function(){
    			var id = $(this).attr('z-data'); 
    			$('#upprice').val(id);
    		});
    		
    	});
    	
		var msg = '${msg}';
		if(msg!=''){
			$('#msg').text(msg);
			var modal = UIkit.modal("#modalmsg");
			modal.show();
		};
		
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
				<li class="uk-active"><a class="uk-button" href="/dms/medicinestorehouse/query.action">库存管理</a></li>
				<li><a class="uk-button" href="/dms/medicinepurchase/query.action">药品采购</a></li>
				<li><a class="uk-button" href="/dms/medicinesales/query.action">药品销售</a></li>
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
	<div id="pageBody" class='uk-panel uk-panel-box uk-margin-left uk-margin-right uk-margin'>
		<table class="uk-text-center uk-table uk-table-striped uk-table-hover">
			<thead>
				<tr>
					<th class="uk-text-center">库存id</th>
					<th class="uk-text-center">药品名称</th>
					<th class="uk-text-center">生产日期</th>
					<th class="uk-text-center">过期日期</th>
					<th class="uk-text-center">库存</th>
					<th class="uk-text-center">成本</th>
					<th class="uk-text-center">售价</th>
					<th class="uk-text-center">状态</th>
					<th class="uk-text-center">操作</th>
				</tr>
			</thead>
			<tbody id="tb-body">
				<c:forEach var="u" items="${query}">
					<tr <c:if test="${u.status=='已过期' }">style="background-color:#ff0000"</c:if>>
							<td>${u.id }</td>
							<td><a tid="${u.medicineId}" class="uk-button uk-button-link" href="#modaldetail" data-uk-modal="{target:'#modaldetail'}">${u.medicineName }</a></td>
							<td>${u.mfg }</td>
							<td>${u.exp }</td>
							<td>${u.number }</td>
							<td>${u.costPrice }</td>
							<td>${u.price }</td>
							<td>${u.status }</td>
							<td>
								<c:if test="${u.status=='已过期' }">
									<a z-data='${u.id }' class="uk-button uk-button" href="/dms/medicinestorehouse/dealWith.action?vo.id=${u.id }">处理</a>
								</c:if>
								<c:if test="${u.status=='已上架' }">
									<a z-data='${u.id }' class="uk-button uk-button-primary" href="/dms/medicinestorehouse/downMedicine.action?vo.id=${u.id }">下架</a>
								</c:if>
								<c:if test="${u.status=='未上架' }">
									<a z-data='${u.id }' class="uk-button uk-button-primary upmedicine" href="#modalup" data-uk-modal="{target:'#modalup'}">上架</a>
								</c:if>
							</td>
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
	<div id="modalup" class="uk-modal">
    <div class="uk-modal-dialog">
        <form class="uk-form" action="/dms/medicinestorehouse/upMedicine.action">
        	<input id="upprice" type="hidden" name="vo.id">
        	<input type="text" placeholder="售价" name="price">
        	<button class="uk-button uk-button-large uk-button-primary">上架</button>
        </form>
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