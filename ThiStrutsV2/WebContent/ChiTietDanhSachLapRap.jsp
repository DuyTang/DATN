<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.SanPhamLapRap1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chi Tiết</title>
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
<h3>CHI TIẾT SẢN PHẨM LẮP RÁP </h3>
<br>
<html:form action="/chiTiet" method="post">
	<div class="row form-group"><label class="col-lg-2">Đĩa Cứng</label>
	<div class="col-lg-3" style="width: 500px"><html:text property="tenHDD"
		styleClass="form-control" > </html:text></div>
	</div>
	<div class="row form-group"><label class="col-lg-2">MainBoard</label>
	<div class="col-lg-3"><html:text property="tenMain"
		styleClass="form-control" ></html:text></div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Ram</label>
	<div class="col-lg-3"><html:text property="tenRam"
		styleClass="form-control"></html:text>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Số Lượng</label>
	<div class="col-lg-3"><html:text property="soLuong"
		styleClass="form-control"></html:text>
	
	</div>
	</div>
	
	<div class="row form-group"><label class="col-lg-2">Chuột</label>
	<div class="col-lg-3"><html:text property="tenChuot"
		styleClass="form-control"></html:text>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Bàn Phím</label>
	<div class="col-lg-3"style="width: 500px"><html:text property="tenBanPhim"
		styleClass="form-control"></html:text>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Màn Hình</label>
	<div class="col-lg-3" style="width: 500px"><html:text property="tenManHinh"
		styleClass="form-control"></html:text>
	</div>
	</div> 
	<div class="row form-group"><label class="col-lg-2">Case</label>
	<div class="col-lg-3" style="width: 500px"><html:text property="tenCase"
		styleClass="form-control"></html:text>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">Nguồn</label>
	<div class="col-lg-3" style="width: 500px"><html:text property="tenNguon"
		styleClass="form-control" ></html:text></div>
	</div>
	</div>
	<div class="row form-group"><label class="col-lg-2">DVD</label>
	<div class="col-lg-3" style="width: 500px"><html:text property="tenDVD"
		styleClass="form-control" ></html:text></div>
	</div>
	
	<div class="row form-group"><label class="col-lg-2">Tản Nhiệt</label>
	<div class="col-lg-3" style="width: 500px"><html:text property="tenTanNhiet"
		styleClass="form-control" ></html:text></div>
	</div>
	
	<div class="row form-group"><label class="col-lg-2">Phụ Kiện</label>
	<div class="col-lg-3" style="width: 500px"><html:text property="tenPhuKien"
		styleClass="form-control" ></html:text></div>
	</div>

	<div class="row form-group">
	<div class="col-lg-3 col-lg-offset-2">
	<html:link styleClass="btn btn-primary big" action="/danh-sach-splr">QUAY LẠI</html:link>
	</div>
	</div>
</html:form>
<jsp:include page="footer.jsp" />
</body>
</html>