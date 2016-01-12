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
<title>Sửa sản phẩm của đơn hàng</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style2.css" rel="stylesheet" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<body>
	<br />
	<h2>SỬA SẢN PHẨM TRONG ĐƠN HÀNG</h2>
	<br />
	<html:form action="/editOrderDetail">
		<table>
			<tr>
				<th></th>
				<th style="width: 250px;"></th>
				<th></th>
			<tr />
			<tr>
				<td>Mã đơn hàng:</td>
				<td><html:text name="orderDetailForm" property="maHD"
						styleClass="form-control" readonly="true" /></td>
				<td><span style="color: red">*</span></td>
			</tr>
			<tr>
				<td>Mã chi tiết đơn hàng:</td>
				<td><html:text name="orderDetailForm"
						property="maChiTietDonHang" styleClass="form-control"
						readonly="true" /></td>
				<td><span style="color: red">*</span></td>
			</tr>
			<tr>
				<td>Mã loại sản phẩm:</td>
				<td><html:text name="orderDetailForm" property="maLoaiSP"
						styleClass="form-control" /></td>
				<td><span style="color: red">*</span></td>
			</tr>
			<tr>
				<td></td>
				<td class="errorMessage"><html:errors property="maLoaiSPError" /></td>
			</tr>
			<tr>
				<td>Mã sản phẩm:</td>
				<td><html:text name="orderDetailForm" property="imei"
						styleClass="form-control" /></td>
				<td><span style="color: red">*</span></td>
			</tr>
			<tr>
				<td></td>
				<td class="errorMessage"><html:errors property="imeiError" /></td>
			</tr>
			<tr>
				<td>Giá:</td>
				<td><html:text name="orderDetailForm" property="giaBan"
						styleClass="form-control" /></td>
				<td><span style="color: red">*</span></td>
			</tr>
			<tr>
				<td></td>
				<td class="errorMessage"><html:errors property="giaBanError" /></td>
			</tr>
			<tr>
				<td><span style="color: red">*</span> là bắt buộc nhập</td>
			</tr>
		</table>
		<html:submit property="buttonClicked" value="EDIT"
			styleClass="btn btn-success big"></html:submit>
		<bean:define id="maHD" name="orderDetailForm" property="maHD" />
		<html:link action="/showOrderDetail?maHD=${maHD}">
			<span class="btn btn-danger big">HỦY</span>
		</html:link>
	</html:form>

	<logic:notEqual name="orderDetailForm" property="message"
		value="success">
		<br />
		<p class="errorMessage">
			<bean:write name="orderDetailForm" property="message"></bean:write>
		</p>
	</logic:notEqual>
</body>
</html>