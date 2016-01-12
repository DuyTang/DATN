<%@page%>
<%@page%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>THÔNG TIN MUA HÀNG</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<div style="width: 150px; height: 50px">
	<html:link action="/home-page.do?soTrang=1?tenCPU="
		styleClass="btn btn-success">QUAY VỀ TRANG CHỦ</html:link>
</div>
<h1 style="text-align: center">
	<i><b>THÔNG BÁO XÁC NHẬN</b></i>
</h1>
<div style="text-align: right">
	<b>LAPTOP STORE </b><br /> Main office: Số 54
	Đường Hàn Mạc Tử - Khối 12 - P. Trung Đô - Tp. Vinh<br /> Tel :
	01675-750-986 - Fax : 84-4-3.869.3859 <br /> Tel : 01659-150-026
	Fax : 84-4-3.538.0099 <br /> E-mail : duytangdhv@gmail.com<br /> Website:
	http://www.laptopstore.vn/
</div>
<body>
	<div class="container">

		<div class="row">
			<html:form action="/hoa-don" method="post">

				<div class="col-lg-4"></div>
				<script type="text/javascript">
					
				</script>

			</html:form>
		</div>
		<br>
		<div class="bs-example">
			<div>
				<%
					String hoTen = request.getParameter("tenKH");
					String diaChi = request.getParameter("diaChiKH");
					String dienThoai = request.getParameter("sdtKH");
					String email = request.getParameter("emailKH");
				%>
				<p>
					Ông/bà: &nbsp;&nbsp;<b><%=hoTen%></b>
				</p>
				<p>
					Địa chỉ:&nbsp;&nbsp;<b><%=diaChi%></b>
				</p>
				<p>
					Điện thoại:&nbsp;&nbsp;<b><%=dienThoai%></b>
				</p>
				<p>
					Email:&nbsp;&nbsp;<b><%=email%></b>
				</p>


			</div>
			<table class="table table-striped">
				<h1>Chúng tôi đã nhận được yêu cầu của quý khách.</h1>
				<h1>Thư xác nhận sẽ được chuyển tới Email mà quý khách đã đăng kí.</h1>
				<h1>Vui lòng kiểm tra Mail.</h1>
				<h1>Chân thành cảm ơn.</b></h1>
			</table>
			<table>
				
				<tr>
					<td><b>Provided:</b> At LapTop Store immediately after customer
						payment</td>
				</tr>
				<tr>
					<td><b>Payment: </b> Cash, check or bank transfer</td>
				</tr>
				<tr>
					<td><b>Account Number: </b> Computer Corporation LapTop Store </td>
				</tr>
				<tr>
					<td>TNHH MTV HSBC Viet Nam - Vinh Branch (HSBC Việt Nam =
						CN Vinh) STK VND: 002-292738-001 STK USD: 002-292738-101</td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>