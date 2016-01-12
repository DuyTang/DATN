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
<title>Thêm sản phẩm cho đơn hàng</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style2.css" rel="stylesheet" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<body>
<br/>
	<h1>THÊM SẢN PHẨM CHO ĐƠN HÀNG</h1>
	<br/>
	<html:form action="/addOrderDetail">
		<table>
			<tr>
				<th></th>
				<th style="width: 250px;"></th>
				<th></th>
			<tr />
			<tr>
				<td>Mã hóa đơn:</td>
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
				<td><html:text name="orderDetailForm" styleId="txtMaLoaiSP"
						property="maLoaiSP" styleClass="form-control" /></td>
				<td><span style="color: red">*</span></td>
				<td><html:select styleId="cbHangSP"
						styleClass="form-control smallCombobox"
						onchange="ajaxGetArrSanPham()" property="tenHang"
						style="width: 180px">
						<option>--Chọn nhà sản xuất--</option>
						<html:optionsCollection name="orderDetailForm"
							property="arrHangSP" label="tenHang" value="tenHang"></html:optionsCollection>
					</html:select>
					<div id="cbTenSP" style="display: inline">
						<html:select property="tenSP" styleId="tenSP"
							styleClass="form-control smallCombobox"
							onchange="ajaxGetMaLoaiSP()" style="width: 500px">
							<html:optionsCollection name="orderDetailForm"
								property="arrSanPham" label="tenSP" value="maLoaiSP"></html:optionsCollection>
						</html:select>
					</div></td>
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
				<td>Prices:</td>
				<td><html:text name="orderDetailForm" property="giaBan"
						styleClass="form-control" styleId="txtGiaBan" /></td>
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
		<html:submit property="buttonClicked" value="SUBMIT"
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
	<script type="text/javascript">
		function ajaxGetArrSanPham() {
			var id = document.getElementById("cbHangSP").value;
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("cbTenSP").innerHTML = xmlhttp.responseText;
				}
			};
			xmlhttp.open("GET",
					"http://localhost:8080/ThiStrutsV2/getArrSanPham.do?tenHang="
							+ id, true);
			xmlhttp.send();
		}
	</script>
	<script type="text/javascript">
		function ajaxGetMaLoaiSP() {
			var maLoaiSPGiaBan = document.getElementById("tenSP").value
					.split("-");
			if ("null" == (maLoaiSPGiaBan[0])) {
				document.getElementById("txtMaLoaiSP")
						.setAttribute("value", "");
				document.getElementById("txtGiaBan").setAttribute("value", "");
			} else {
				document.getElementById("txtMaLoaiSP").setAttribute("value",
						maLoaiSPGiaBan[0]);
				document.getElementById("txtGiaBan").setAttribute("value",
						maLoaiSPGiaBan[1]);
			}
		}
	</script>
	
</body>
</html>