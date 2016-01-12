<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.SanPhamLapRap1"%>
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
		<h1>DANH SÁCH SẢN PHẨM LẮP RÁP</h1>
	</div>
	
	
	<div class="bs-example">
		<table class="table table-bordered" id="example" cellspacing="0"
			width="100%">
			<thead>
				<tr>
					<th>Mã HD</th>
					<th>Main</th>
					<th>Ram</th>
					<th>Số Lượng</th>
					<th>Chip</th>
					<th>Chuột</th>
					<th>Bàn Phím</th>
					<th>HDD</th>
					<th>Màn Hình</th>
					<th>Case</th>
					<th>Nguồn</th>
					<th>DVD</th>
					<th>Tản Nhiệt</th>
					<th>Phụ Kiện</th>
					<th></th>
				</tr>
			</thead>

			<logic:iterate name="dssplr" property="list" id="main">
				<tr>
					<td><bean:write name="main" property="maHD" /></td>
					<td><bean:write name="main" property="maMain" /></td>
					<td><bean:write name="main" property="maRam" /></td>
					<td><bean:write name="main" property="soLuongRam" /></td>
					<td><bean:write name="main" property="maChip" /></td>
					<td><bean:write name="main" property="maChuot" /></td>
					<td><bean:write name="main" property="maBanPhim" /></td>
					<td><bean:write name="main" property="maHDD" /></td>
					<td><bean:write name="main" property="maManHinh" /></td>
					<td><bean:write name="main" property="maCase" /></td>
					<td><bean:write name="main" property="maNguon" /></td>
					<td><bean:write name="main" property="maDVD" /></td>
					<td><bean:write name="main" property="maTanNhiet" /></td>
					<td><bean:write name="main" property="maPhuKien" /></td>
					<td>
                	<bean:define id="masplr" name="main" property="maSPLR"></bean:define>
                	<html:link action="/chiTiet?maSPLR=${masplr}">
                		<span class="btn btn-info">Chi Tiết</span>
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