<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.BaoHanh"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
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
		<h1>DANH SÁCH BẢO HÀNH</h1>
	</div>
	<html:link styleClass="btn btn-primary big" action="/daSua">ĐÃ SỬA</html:link>
	<html:link styleClass="btn btn-info big" action="/danhSach">DANH SÁCH</html:link>
	<html:link styleClass="btn btn-success big" action="/themBH">THÊM MỚI</html:link>
<div class="bs-example">
<table class="table table-bordered" id="example" cellspacing="0"
	width="100%">
	<thead>
		<tr>
			<th>Lần bảo hành</th>
			<th>Mã sản phẩm</th>
			<th>Tên khách hàng</th>
			<th>Ngày nhận máy</th>
			<th>Lý do</th>
			<th>Cách xử lý</th>
			<th>Số điện thoại</th>
			<th align="center">Hành động</th>
		</tr>
	</thead>
	
		<logic:iterate name="danhSach" property="list" id="kh">
			<tr>
				<td><bean:write name="kh" property="lanBaoHanh" /></td>
				<td><bean:write name="kh" property="IMEI" /></td>
				<td><bean:write name="kh" property="tenKH" /></td>
				<td><bean:write name="kh" property="ngayNhanMay" /></td>
				<td><bean:write name="kh" property="lyDo" /></td>
				<td><bean:write name="kh" property="cachXuLy" /></td>
				<td><bean:write name="kh" property="soDienThoai" /></td>


				<td align="center"><bean:define id="mabh" name="kh"
					property="maBH"></bean:define> <html:link
					action="/suaBH?maBH=${mabh}">
					<span class="btn btn-warning">Sửa</span>
				</html:link> 
				</td>
			</tr>
		</logic:iterate>
	
</table>
</div>

<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
$('#example').DataTable({
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