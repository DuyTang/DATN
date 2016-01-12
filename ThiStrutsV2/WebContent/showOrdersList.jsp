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
<title>Danh sách đơn đặt hàng</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
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

.glyphicon {
	margin-left: 10px;
}
</style>

<script>
	function formatNumber(num) {
		return document.write(num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g,
				"$1,"));
	}
</script>

<script>
	function xoa(maHD) {
		$.confirm({
			title : 'Xác nhận xóa',
			content : 'Bạn có muốn xóa đơn hàng ' + maHD + ' không?',
			confirm : function() {
				window.location.href = "/ThiStrutsV2/deleteOrder.do?maHD="
						+ maHD;
			},
			cancel : function() {
				return;
			}
		});
	}
	function xacNhanGiaoHang(maHD) {
		$
				.confirm({
					title : 'Xác nhận đã giao hàng',
					content : 'Bạn có muốn xác nhận đơn hàng '
							+ maHD
							+ ' đã được giao không? (bạn không thể hoàn tác nếu nhấn Ok)',
					confirm : function() {
						window.location.href = "/ThiStrutsV2/deliveredConfirm.do?maHD="
								+ maHD;
					},
					cancel : function() {
						return;
					}
				});
	}

	function showMessage(message) {
		$.alert({
			title : 'Thông báo',
			content : message,
			confirm : function() {
				return;
			}
		});
	}
</script>
<body>
	<div>
		<h1>DANH SÁCH ĐƠN ĐẶT HÀNG</h1>
	</div>
	<html:link action="/addOrder">
		<span class="btn btn-success big">THÊM MỚI ĐƠN ĐẶT HÀNG</span>
	</html:link>
	<br />
	<br />
	<table class="table table-bordered table-striped" id="example"
		style="width: 100%">
		<thead>
			<tr>
				<th>Mã ĐH</th>
				<th>Mã KH</th>
				<th>Ngày giao hàng</th>
				<th>Tổng tiền</th>
				<th>Tình trạng giao hàng</th>
				<th style="width: 156px">Hành động</th>
			</tr>
		</thead>
		<tbody>
			<logic:equal name="ordersListForm" property="message" value="success">
				<logic:iterate id="order" name="ordersListForm"
					property="ordersList">
					<tr>
						<th scope="row"><bean:write name="order" property="maHD"></bean:write></th>
						<td><bean:write name="order" property="maKH"></bean:write></td>
						<td><bean:write name="order" property="ngayGiaoHang"></bean:write></td>
						<td><script>
							formatNumber(
									'<bean:write name="order" property="tongTien"></bean:write>')
						</script></td>

						<bean:define id="maHD" name="order" property="maHD" />
						<td><logic:equal name="order" property="tinhTrangGiaoHang"
								value="true">
						Chưa giao
						<a class="glyphicon glyphicon-ok"
									onclick="xacNhanGiaoHang('<bean:write name="order" property="maHD" />')"></a>
							</logic:equal> <logic:notEqual name="order" property="tinhTrangGiaoHang"
								value="true">
						Đã giao
					</logic:notEqual></td>
						<td><logic:equal name="order" property="tinhTrangGiaoHang"
								value="true">
								<html:link action="/editOrder?maHD=${maHD}">
									<span class="btn btn-warning">Sửa</span>
								</html:link>
							</logic:equal> <logic:notEqual name="order" property="tinhTrangGiaoHang"
								value="true">
								<span class="btn btn-default">Sửa</span>
							</logic:notEqual> <logic:equal name="order" property="tinhTrangGiaoHang"
								value="true">
								<a class="btn btn-danger"
									onclick="xoa('<bean:write name="order" property="maHD" />')">
									Xóa</a>
							</logic:equal> <logic:notEqual name="order" property="tinhTrangGiaoHang"
								value="true">
								<span class="btn btn-default">Xóa</span>
							</logic:notEqual> <html:link action="/showOrderDetail?maHD=${maHD}">
								<span class="btn btn-info">Xem</span>
							</html:link></td>
					</tr>
				</logic:iterate>
			</logic:equal>
		<tbody>
	</table>
	<logic:notEqual name="ordersListForm" property="status"
		value="notError">
		<br />
		<p class="errorMessage">
			<bean:write name="ordersListForm" property="status"></bean:write>
		</p>
		<script>
			showMessage('<bean:write name="ordersListForm" property="status"/>');
		</script>
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