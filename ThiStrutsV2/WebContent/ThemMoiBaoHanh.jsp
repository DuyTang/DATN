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
<title>Thêm Mới Bảo Hành</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
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
<div class="container">
<h1 >THÊM MỚI BẢO HÀNH</h1>
		<br>
		<html:form action="/themBH" method="post"  >
			<div class="row form-group">
				<label class="col-lg-2">Mã bảo hành:</label>
				<div class="col-lg-3">
					<html:text property="maBH" styleClass="form-control"
						readonly="true"></html:text>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Lần bảo hành:</label>
				<div class="col-lg-3">
					<html:text property="lanBaoHanh" styleClass="form-control"></html:text>
					<p style="color: red" />
					<html:errors property="lanBHError" />
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Tên khách hàng:</label>
				<div class="col-lg-3">
					<html:text property="tenKH" styleClass="form-control"></html:text>
					<p style="color: red">
						<html:errors property="tenKHError" />
					</p>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Ngày nhận máy:</label>
				<div class="col-lg-3">
					<html:text property="ngayNhanMay" styleClass="form-control"></html:text>
					<p style="color: red">
						<html:errors property="ngayNhanMayError" />
					</p>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Lý do bảo hành:</label>
				<div class="col-lg-3">
					<html:text property="lyDo" styleClass="form-control"></html:text>
					<p style="color: red">
						<html:errors property="lyDoError" />
					</p>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Cách xử lý:</label>
				<div class="col-lg-3">
					<html:text property="cachXuLy" styleClass="form-control"></html:text>
					<p style="color: red">
						<html:errors property="cachXuLyError" />
					</p>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Mã sản phẩm:</label>
				<div class="col-lg-3">
					<html:text property="IMEI" styleClass="form-control"></html:text>
					<p style="color: red">
						<html:errors property="imeiError" />
					</p>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Điện thoại:</label>
				<div class="col-lg-3">
					<html:text property="soDienThoai" styleClass="form-control"></html:text>
					<p style="color: red">
						<html:errors property="dienThoaiError" />
					</p>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<html:submit property="submit" value="THÊM MỚI"
						onclick="changeButtonName()" styleId="submit"
						styleClass="btn btn-success big"></html:submit>
					<html:link styleClass="btn btn-primary big" action="/danhSach">QUAY LẠI</html:link>
				</div>
			</div>
		</html:form>
		<br>
	</div>
	<jsp:include page="footer.jsp" />
</body>

</html>