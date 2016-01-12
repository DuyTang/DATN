<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html >
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="model.bean.SanPhamBean"%>
<%@page import="java.util.ArrayList"%>
<html>

<head>
<style>
.menu {
	width: 550px;
	height: 50px;
	margin-left: 400px;
	background-color: red;
}

select {
	margin-top: -50px;
}
</style>
<!-- Basic Page Needs
  ================================================== -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>LAPTOP Store</title>
<meta name="description" content="">
<meta name="author" content="Ahmed Saeed">
<meta charset="UTF-8" />
<!-- Mobile Specific Metas
  ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
  ================================================== -->
<link rel="stylesheet" href="css/contact.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/home2.css">
<link rel="stylesheet" href="css/responsive.css">

<link rel="stylesheet" href="css/cart.css">
<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>
		<link rel="stylesheet" type="text/css" href="css/ie8-and-down.css" />
	<![endif]-->

<!-- Favicons
	================================================== -->
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="images/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="images/apple-touch-icon-114x114.png">

</head>
<body onload="tinh()">

	<!--start header-->
	<header>

		<div id="middleHeader">
			<div class="container">
				<div class="sixteen columns">
					<div id="logo">
						<div id = "divB">
					<img src="images/icons/banner1.jpg" alt=""  width="935px" height="200px" align="right">
				</div>

					</div>


				</div>
				<!--end sixteen-->
			</div>
			<!--end container-->
		</div>
		<!--end middleHeader-->

		<div class="container">
			<div class="sixteen columns">
				<div id="mainNav" class="clearfix">
					<nav>
						<ul>
							<li style="text-align: center;"><html:link action="/home-page.do?soTrang=1?tenCPU=">
							TRANG CHỦ </html:link></li>
							<li><a style="width: 70px; text-align: center;" href="aboutUs.jsp">GIỚI THIỆU</a></li>
							<li><html:link action="/laprapsanpham">XÂY DỰNG CẤU HÌNH MÁY</html:link></li>
							<li><html:link action="/da-sua"> BẢO HÀNH </html:link></li>
						</ul>

					</nav>
					<!--end nav-->

					<div id="cart">
						<html:link action="/do-hang"><img
						src="images/icons/cart_icon.png" alt="">
						<% HttpSession session2 = request.getSession(); 
						ArrayList<SanPhamBean> arr = (ArrayList<SanPhamBean>) session.getAttribute("arrSP");
						if(arr == null) {
							out.print("0 Items");
						}
						else {
							out.print(arr.size()+" Items");
						}
						%>
						  </html:link>
						<!--end cart_content-->
					</div>
					<!--end cart-->

				</div>
				<!--end main-->
			</div>
			<!--end sixteen-->
		</div>
		<!--end container-->
	</header>
	<!--end header-->