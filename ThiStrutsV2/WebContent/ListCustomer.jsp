<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="header.jsp" />
<div>
	<h1>DANH SÁCH KHÁCH HÀNG</h1>
</div>
<div class="bs-example">
				<th align="left"><html:link styleClass="btn btn-success"
				action="/addCus">THÊM MỚI</html:link></th>
				<th align="left"><html:link styleClass="btn btn-primary"
				action="/allCus">TẤT CẢ</html:link></th>
				
<table class="table table-bordered" id="example" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th>Mã KH</th>
			<th>Họ tên</th>
			<th>Địa chỉ</th>
			<th style="width: 150px">Email</th>
			<th>Điện thoại</th>
			<th style="width: 150px">Hành động</th>
		</tr>
	</thead>
	<tbody>
		<logic:iterate name="listCus" property="list" id="kh">
			<tr>
				<th scope="row"><bean:write name="kh" property="maKH" /></th>
				<td><bean:write name="kh" property="tenKH" /></td>
				<td><bean:write name="kh" property="diaChi" /></td>
				<td><bean:write name="kh" property="email" /></td>
				<td><bean:write name="kh" property="soDienThoai" /></td>

				<td><bean:define id="makh" name="kh" property="maKH"></bean:define>
				<html:link action="/editCus?maKH=${makh}">
					<span class="btn btn-warning">Sửa</span>
				</html:link> 
				<html:link action="/delCus?maKH=${makh}" style="margin-left: 30px;">
					<span class="btn btn-danger">Xóa</span>
				</html:link></td>
			</tr>
		</logic:iterate>
	</tbody>
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