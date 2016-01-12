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
<title>Thêm đơn hàng</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style2.css" rel="stylesheet" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.js"></script>
<script src="js/jquery-ui.min.js"></script>

<script>
	$(document).ready(function() {
		$(".datepicker").datepicker({
			dateFormat : 'dd/mm/yy'
		});
		$("#dateFormatPlaceHolder").attr("placeholder", "dd/MM/yyyy");
	});
</script>

<body>
	<h1>THÊM MỚI ĐƠN ĐẶT HÀNG</h1>
	<br/>
	<html:form action="/addOrder">
		<table>
			<tr>
				<td>Mã đơn hàng:</td>
				<td><html:text name="orderForm" property="maHD"
						styleClass="form-control" readonly="true" /></td>
				<td><span style="color: red">*</span></td>
			</tr>
			<tr>
				<td>Mã khách hàng:</td>
				<td><html:text name="orderForm" property="maKH"
						styleClass="form-control" /></td>
				<td><span style="color: red">*</span></td>
			</tr>
			<tr>
				<td></td>
				<td class="errorMessage"><html:errors
						property="maKhachHangError" /></td>
			</tr>
			<tr>
				<td>Ngày đặt hàng:</td>
				<td><html:text name="orderForm" property="ngayDatHang"
						styleClass="form-control" readonly="true" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Ngày giao hàng:</td>
				<td><html:text name="orderForm" property="ngayGiaoHang"
						styleClass="form-control datepicker"
						styleId="dateFormatPlaceHolder" /></td>
				<td><span style="color: red">*</span></td>
			</tr>
			<tr>
				<td></td>
				<td class="errorMessage"><html:errors
						property="ngayGiaoHangError" /></td>
			</tr>
			<tr>
				<td>Nơi giao hàng:</td>
				<td><html:textarea name="orderForm" property="noiGiaoHang"
						styleClass="form-control" /></td>
			</tr>
			<tr>
				<td>Tổng tiền:</td>
				<td><html:text name="orderForm" property="tongTien"
						styleClass="form-control" /></td>
				<td><span style="color: red">*</span></td>
			</tr>
			<tr>
				<td></td>
				<td class="errorMessage"><html:errors property="tongTienError" /></td>
			</tr>
			<tr>
				<td>Tình trạng giao hàng:</td>
				<td><html:radio name="orderForm" property="tinhTrangGiaoHang"
						value="1">Chưa giao</html:radio> &nbsp;&nbsp;&nbsp;<html:radio
						name="orderForm" property="tinhTrangGiaoHang" value="0"
						disabled="true">Đã giao</html:radio></td>
			</tr>
			<tr>
				<td><span style="color: red">*</span> là bắt buộc nhập</td>
			</tr>
		</table>
		<html:submit property="buttonClicked" value="SUBMIT"
			styleClass="btn btn-success big"></html:submit>
		<html:link action="/ordersList">
			<span class="btn btn-danger big">HỦY</span>
		</html:link>
	</html:form>

	<logic:notEqual name="orderForm" property="message" value="success">
		<br />
		<p class="errorMessage">
			<bean:write name="orderForm" property="message"></bean:write>
		</p>
	</logic:notEqual>
</body>
</html>