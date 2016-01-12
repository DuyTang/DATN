<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.BaoHanh"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thay Đổi Thông Tin</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	function changeButtonName() {
		$('#submit').val('submit');
		$('#form').submit();
	}
</script>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container">
<h3>THAY ĐỔI THÔNG TIN BẢO HÀNH</h3>
<br>
<html:form action="/suaBH" method="post">
	<div class="row form-group"><label class="col-lg-2">
	Mã Bảo Hành</label>
	<div class="col-lg-3"><html:text property="maBH"
		styleClass="form-control" readonly="true"></html:text></div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Lần bảo hành</label>
	<div class="col-lg-3"><html:text property="lanBaoHanh"
		styleClass="form-control" readonly="true"></html:text></div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Mã sản phẩm</label>
	<div class="col-lg-3"><html:text property="IMEI"
		styleClass="form-control" readonly="true"></html:text></div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Tên khách hàng</label>
	<div class="col-lg-3"><html:text property="tenKH"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="tenKHError" /></p>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Ngày nhận máy</label>
	<div class="col-lg-3"><html:text property="ngayNhanMay"
		styleClass="form-control" readonly="true"></html:text>
	<p style="color: red"><html:errors property="ngayNhanMayError" />
	</p>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Lý do</label>
	<div class="col-lg-3"><html:text property="lyDo"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="lyDoError" /></p>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Cách xử lý</label>
	<div class="col-lg-3"><html:text property="cachXuLy"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="cachXuLyError" /></p>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Tình trạng</label>
	<div class="col-lg-3"><html:radio property="tinhTrangSua"
		value="Đã sửa" style="margin-right: 10px;">Đã sửa</html:radio> 
		</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Số điện thoại</label>
	<div class="col-lg-3"><html:text property="soDienThoai"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="dienThoaiError" /></p>
	</div>
	</div>


	<div class="row form-group">
	<div class="col-lg-3 col-lg-offset-2"><html:submit
		property="submit" value="Lưu" onclick="changeButtonName()"
		styleId="submit" styleClass="btn btn-success big"></html:submit>
	<html:link styleClass="btn btn-primary big" action="/danhSach">QUAY LẠI</html:link>
	</div>
	</div>
</html:form></div>
<jsp:include page="footer.jsp" />
</body>
</html>