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

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>TRANG QUẢN LÝ</title>
<style type="text/css">
* {
	font-family: Segoe UI;
}

div {
	padding: 10px;
}

td {
	boder: solid 1px blue;
}

li {
	font-family: Segoe UI;
}

h1 {
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load("visualization", "1", {
		packages : [ "corechart" ]
	});
	google.setOnLoadCallback(drawChart);
	function drawChart() {
		var d = document.getElementById("thoiGian1").value;
		var d1 = document.getElementById("thoiGian2").value;
		var d2 = document.getElementById("soLuong1").value;
		var d3 = document.getElementById("soLuong2").value;

		if(d2 == 0 && d3 == 0) {
			document.getElementById('piechart_3d').innerHTML = "2 tháng không bán được sản phẩm nào";
			return;
		}
		
		var data = google.visualization.arrayToDataTable([
				[ 'Task', 'Hours per Day' ], [ d ,Number(d2)], [ d1, Number(d3) ] ]);

		var options = {
			title : 'So Sánh Doanh Số Bán Được(Theo Tháng)',
			is3D : true,
		};

		var chart = new google.visualization.PieChart(document
				.getElementById('piechart_3d'));
		chart.draw(data, options);
	}
</script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	

		<!-- /.nội dung code:  -->
		<!-- /.nội dung code:  -->
		<!-- /.nội dung code:  -->
		<div class="container">


			<div class="row">

				<div class="col-md-3">
					<ul class="nav nav-pills nav-stacked">
						<li class="active"><a href="#">Thống kê theo doanh số bán
								hàng</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">So sánh doanh số bán được <span
								class="caret"></span></a>
						<li style="display: block"><html:link
								action="/thongKeTheoThang-soLuong">Theo Tháng</html:link></li>
						<li><html:link action="/thongKeTheoNam-soLuong">Theo Năm</html:link>
						<li><html:link action="/thongKeTheoHangSanXuat-soLuong">Theo Hãng Sản Xuất</html:link>
						</li>
						<li><html:link action="/thongKeBieuDoNam-soLuong">Thống kê theo năm</html:link>
						</li>
						
					</ul>
		</div>
				<div class="clearfix visible-lg">

					<div id="piechart_3d" style="width: 900px;margin-left:250px; height: 500px;"></div>
					<input type="hidden" id= "thoiGian1" value='<bean:write name="thongKeForm" property="thoiGian1" />'>
					<input type="hidden" id= "thoiGian2" value='<bean:write name="thongKeForm" property="thoiGian2" />'>
					<input type="hidden" id= "soLuong1" value='<bean:write name="thongKeForm" property="soLuong1" />'>
					<input type="hidden" id= "soLuong2" value='<bean:write name="thongKeForm" property="soLuong2" />'>
				</div>
			</div>
		</div>



		<!-- /.nội dung code:  -->
		<!-- /.nội dung code:  -->
		<!-- /.nội dung code:  -->
		<jsp:include page="footer.jsp" />