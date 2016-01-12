<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chi tiết đơn đặt hàng</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script src="js/bootstrap.min.js"></script>
<link href="css/style2.css" rel="stylesheet" />
<link href="css/jquery-confirm.min.css" rel="stylesheet" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/jquery-confirm.min.js"></script>
<script src="js/jquery.data.js"></script>


<!-- Thu vien cho chuc nang phan trang -->
<link rel="stylesheet" href="CSS/dataTables.bootstrap.min.css" />
<!-- Ket thuc chuc nang phan trang -->

<style>
.paginate_button {
	margin-right: 20px;
}
</style>

<script>
	function formatNumber(num) {
		return document.write(num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g,
				"$1,"));
	}
</script>


<script>
	$(document).ready(function() {
		$(".btn").click(function() {
			$("#row").hide(1000);
		});
	});

	function xoa(maCT, maHD) {
		$
				.confirm({
					title : 'Xác nhận xóa',
					content : 'Bạn có muốn xóa chi tiết đơn hàng có mã ' + maCT
							+ ' không?',
					confirm : function() {
						window.location.href = "/ThiStrutsV2/deleteOrderDetail.do?maChiTietDonHang="
								+ maCT + "&maHD=" + maHD;
					},
					cancel : function() {
						return;
					}
				});
	}
</script>

<body>
	<br />
	<h1>CHI TIẾT ĐƠN HÀNG</h1>
	<bean:define id="maHD" name="orderDetailListForm" property="maHD" />
	<bean:define id="orderInfor" name="orderDetailListForm"
		property="orderInfor"></bean:define>

	<!-- Don hang nao tinh trang = 1 thi cho hien thi nut them, sua, xoa -->
	<logic:equal name="orderInfor" property="tinhTrangGiaoHang" value="1">
		<html:link action="/addOrderDetail?maHD=${maHD}">
			<span class="btn btn-success big">THÊM SẢN PHẨM CHO ĐƠN HÀNG</span>
		</html:link>
	</logic:equal>
	<html:link action="/ordersList">
		<span class="btn btn-primary big">QUAY LẠI</span>
	</html:link>
	<br />
	<h3>Thông tin đơn hàng</h3>
	<p>
		<b>Tên khách hàng:</b>
		<bean:write name="orderInfor" property="tenKH"></bean:write>
	</p>
	<p>
		<b>Ngày đặt hàng:</b>
		<bean:write name="orderInfor" property="ngayDatHang"></bean:write>
	</p>
	<p>
		<b>Nơi giao hàng:</b>
		<bean:write name="orderInfor" property="noiGiaoHang"></bean:write>
	</p>
	<br />
	<table class="table table-bordered table-striped" id="example"
		style="width: 100%">
		<thead>
			<tr>
				<th>Mã HĐ</th>
				<th>Mã Chi Tiết HĐ</th>
				<th>Tên sản phẩm</th>
				<th>Mã sản phẩm</th>
				<th>Giá bán</th>
				<th style="width: 100px">Hành động</th>
			</tr>
		</thead>
		<logic:equal name="orderDetailListForm" property="message"
			value="success">
			<logic:iterate id="orderDetail" name="orderDetailListForm"
				property="orderDetailList">
				<tr>
					<td scope="row"><bean:write name="orderDetail" property="maHD" /></td>
					<td><bean:write name="orderDetail" property="maChiTietDonHang" /></td>
					<td><bean:write name="orderDetail" property="tenSP" /></td>
					<td><bean:write name="orderDetail" property="imei" /></td>
					<td><script>
						formatNumber(
								'<bean:write name="orderDetail" property="giaBan"></bean:write>')
					</script></td>
					<bean:define id="maChiTietDonHang" name="orderDetail"
						property="maChiTietDonHang" />
					<td><logic:equal name="orderInfor"
							property="tinhTrangGiaoHang" value="1">
							<html:link
								action="/editOrderDetail?maHD=${maHD}&maChiTietDonHang=${maChiTietDonHang}">
								<span class="btn btn-warning">Sửa</span>
							</html:link>
							<button class="btn btn-danger"
								onclick="xoa('<bean:write name="orderDetail" property="maChiTietDonHang" />',
							'<bean:write name="orderDetail" property="maHD" />')">
								Xóa</button>
						</logic:equal></td>
				</tr>
			</logic:iterate>
		</logic:equal>
	</table>

	<logic:notEqual name="orderDetailListForm" property="message"
		value="success">
		<br />
		<p class="errorMessage">
			<bean:write name="orderDetailListForm" property="message"></bean:write>
		</p>
	</logic:notEqual>

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
</body>
</html>