<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.Ram"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
div {
	padding: 10px;
}

td {
	boder: solid 1px blue;
}
</style>
</head>
<body>
	<div>
		<h1>DANH SÁCH RAM</h1>
	</div>
	
	
	<div class="bs-example">
		<table class="table table-bordered" id="example" cellspacing="0"
			width="100%">
			<thead>
				<tr>
					<th>Mã Ram</th>
					<th>Tên Ram</th>
					<th>Loại Ram</th>
					<th style="width: 30px">Dung Lượng</th>
					<th>Giá</th>
					<th>Số Lượng</th>
					<th>Thời gian BH</th>
					<th style="width: 115px"><html:link styleClass="btn btn-success big" action="/themRam">THÊM MỚI</html:link></th>
				</tr>
			</thead>

			<logic:iterate name="dsram" property="list" id="ram">
				<tr>
					<td><bean:write name="ram" property="maRam" /></td>
					<td><bean:write name="ram" property="tenRam" /></td>
					<td><bean:write name="ram" property="loaiRam" /></td>
					<td><bean:write name="ram" property="dungLuong" /></td>
					<td><bean:write name="ram" property="gia" /></td>
					<td><bean:write name="ram" property="soLuong" /></td>
					<td><bean:write name="ram" property="thoiGianBH" /></td>
					
					<td><bean:define id="maram" name="ram" property="maRam"></bean:define>
					<html:link action="/suaRam?maRam=${maram}">
						<span class="btn btn-warning">Sửa</span>
					</html:link> 
					<html:link action="/xoaRam?maRam=${maram}" style="margin-left: 30px;">
						<span class="btn btn-danger">Xóa</span>
					</html:link>
					</td>
				</tr>
			</logic:iterate>

		</table>
	</div>

	<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$('#example')
				.DataTable(
						{
							"language" : {
								"sProcessing" : "Đang xử lý...",
								"sLengthMenu" : "Xem _MENU_ mục",
								"sZeroRecords" : "Không tìm thấy dòng nào phù hợp",
								"sInfo" : "Đang xem _START_ đến _END_ trong tổng số _TOTAL_ mục",
								"sInfoEmpty" : "Đang xem 0 đến 0 trong tổng số 0 mục",
								"sInfoFiltered" : "(được lọc từ _MAX_ mục)",
								"sInfoPostFix" : "",
								"sSearch" : "Tìm:",
								"sUrl" : "",
								"oPaginate" : {
									"sFirst" : "Đầu",
									"sPrevious" : "Trước",
									"sNext" : "Tiếp",
									"sLast" : "Cuối"
								},
								"pagingType" : "simple"
							}
						});
	</script>

	<jsp:include page="footer.jsp" />
</body>
</html>