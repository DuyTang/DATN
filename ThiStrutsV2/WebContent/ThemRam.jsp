<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.Ram"%>
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
<h3>THÊM MỚi RAM</h3>
<br>
<html:form action="/themRam" method="post">
	<div class="row form-group"><label class="col-lg-2">
	Mã Ram</label>
	<div class="col-lg-3"><html:text property="maRam"
		styleClass="form-control" readonly="true"> </html:text></div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Tên Ram</label>
	<div class="col-lg-3"><html:text property="tenRam"
		styleClass="form-control" ></html:text></div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Loại Ram</label>
	<div class="col-lg-3"><html:text property="loaiRam"
		styleClass="form-control" ></html:text></div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Dung Lượng</label>
	<div class="col-lg-3"><html:text property="dungLuong"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="tenKHError" /></p>
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
	</div>Mã Ram</label>
	<div class="col-lg-3"><html:text property="maRam"
		styleClass="form-control" readonly="true"> </html:text></div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Tên Ram</label>
	<div class="col-lg-3"><html:text property="tenRam"
		styleClass="form-control" ></html:text>
		<p style="color: red"><html:errors property="tenRamError" /></p>
		</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Loại Ram</label>
	<div class="col-lg-3"><html:text property="loaiRam"
		styleClass="form-control" ></html:text>
		<p style="color: red"><html:errors property="loaiRamError" /></p>
		</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Dung Lượng</label>
	<div class="col-lg-3"><html:text property="dungLuong"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="dungLuongError" /></p>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Giá bán</label>
	<div class="col-lg-3"><html:text property="gia"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="giaError" />
	</p>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Số Lượng</label>
	<div class="col-lg-3"><html:text property="soLuong"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="soLuongError" /></p>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Thời Gian BH</label>
	<div class="col-lg-3"><html:text property="thoiGianBH"
		styleClass="form-control"></html:text>
	<p style="color: red"><html:errors property="thoiGianError" /></p>
	</div>
	</div>
	</div>


	<div class="row form-group">
	<div class="col-lg-3 col-lg-offset-2"><html:submit
		property="submit" value="Lưu" onclick="changeButtonName()"
		styleId="submit" styleClass="btn btn-success big"></html:submit>
	<html:link styleClass="btn btn-primary big" action="/danh-sach-ram">QUAY LẠI</html:link>
	</div>
	</div>
</html:form>
<jsp:include page="footer.jsp" />
</body>
</html>