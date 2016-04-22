<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC 测试</title>
		
		<script src="${ctx}/resources/jquery/jquery-1.12.1.min.js"></script>
		<script src="http://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
		
		<link rel="stylesheet" href="http://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
	</head>
	<body>
		<table id="users" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>用户名</th>
				<th>密码</th>
			</tr>
		</thead>
	</table>
		
		<script type="text/javascript">
		var table = 
		

		$(document).ready(function(){
			$('#users').DataTable({
				"processing": true,
			    "serverSide": true,		//开启服务器端分页
			    "order":[[0, "asc"]],  //默认排序方式， 从0开始第三列（2） 降序“desc”
				"ajax": {
					"type": "post",
					"url": "${ctx}/datatable"
				},
				"columns": [
				            {"data": "id", "orderable": true},
				            {"data": "username", "orderable": false},
				            {"data": "password", "orderable": false}
				        ],
				"lengthMenu": [[20,50,100], [20,50,100]],
				"scrollCollapse": true,
				"paging": true,
				"dom": '<"top">rlt<"bottom"ip>',
				"dataType": "json",
				"language": {
			        "lengthMenu": "每页 _MENU_ 条记录",
			        "zeroRecords": "没有找到记录",
			        "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 ) 共 _TOTAL_ 条",
			        "infoEmpty": "",
			        "infoFiltered": "总共 _MAX_ 条记录",
			        "paginate": {
			            "first": "首页",
			            "previous": "上一页",
			            "next": "下一页",
			            "last": "尾页"
			        }
			    }
			});
		});
		</script>
	</body>
</html>