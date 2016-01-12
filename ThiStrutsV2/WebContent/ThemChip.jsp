<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.Chip1"%>
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
<h3>THÊM MỚi MAINBOARD</h3>
<br>
<html:form action="/themChip" method="post">
	<div class="row form-group"><label class="col-lg-2">Mã Chip</label>
	<div class="col-lg-3"><html:text property="maChip"
		styleClass="form-control" readonly="true"> </html:text>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Tên Chip</label>
	<div class="col-lg-3"><html:text property="tenChip"
		styleClass="form-control" ></html:text>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">SocKet</label>
	<div class="col-lg-3"><html:text property="socket"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="cachXuLyError" /></p>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Giá bán</label>
	<div class="col-lg-3"><html:text property="gia"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="common.giaNhapSP" />
	</p>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Số Lượng</label>
	<div class="col-lg-3"><html:text property="soLuong"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="lyDoError" /></p>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Thời Gian BH</label>
	<div class="col-lg-3"><html:text property="thoiGianBH"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="cachXuLyError" /></p>
	</div>
	</div>

	<div class="row form-group">
	<div class="col-lg-3 col-lg-offset-2"><html:submit
		property="submit" value="Lưu" onclick="changeButtonName()"
		styleId="submit" styleClass="btn btn-success big"></html:submit>
	<html:link styleClass="btn btn-primary big" action="/danh-sach-chip">QUAY LẠI</html:link>
	</div>
	</div>
</html:form>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>