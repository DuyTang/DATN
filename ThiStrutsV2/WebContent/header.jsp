<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>TRANG QUẢN LÝ</title>
<style type="text/css">
*{
	font-family: Segoe UI;
}
div {
	padding: 10px;
}

td {
	boder: solid 1px blue;
}

li{
	font-family: Segoe UI;
}

h1{
	text-align: center;
}
</style>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />
<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/plugins/morris.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>




<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div class="container" style="margin-bottom: 30px"></div>
	
	<div class="container">
		<ul class="nav nav-tabs" style="text-align: center; width: 100%;">
			<li role="presentation"><html:link action="/home-page.do;jsessionid=98694D3CF88025DAE7BDE0C6EE7C21E7?soTrang=1?tenCPU=">BACK</html:link></li>
			<li role="presentation" style="margin-left: 100px"><html:link action="/quanLySanPham?soTrang=1">SẢN PHẨM</html:link></li>
			<li role="presentation"><html:link action="/danh-sach-main">MAINBOARD</html:link></li>
			<li role="presentation"><html:link action="/danh-sach-ram">RAM</html:link></li>
			<li role="presentation"><html:link action="/danh-sach-chip">CHIP</html:link></li>
			<li role="presentation"><html:link action="/danh-sach-bo-phan">BỘ PHẬN</html:link></li>
			<li role="presentation"><html:link action="/list-cus">KHÁCH HÀNG</html:link></li>
			<li role="presentation"><html:link action="/ordersList">ĐƠN HÀNG</html:link></li>
			<li role="presentation"><html:link action="/danh-sach-splr">LẮP RÁP</html:link></li>
			<li role="presentation"><html:link action="/danh-sach">BẢO HÀNH</html:link></li>			
			<li role="presentation"><a href="thongKe.jsp">THỐNG KÊ</a></li>
		</ul>
	</div>
	<div class="container">