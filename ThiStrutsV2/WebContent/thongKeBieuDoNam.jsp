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
<script type="text/javascript"
	src="https://www.google.com/jsapi?autoload={
            'modules':[{
              'name':'visualization',
              'version':'1',
              'packages':['corechart']
            }]
          }">
	
</script>

<script type="text/javascript">
	google.setOnLoadCallback(drawChart);

	function drawChart() {
		var giaTri = document.getElementsByName("arrGiaTri");
		var data = google.visualization.arrayToDataTable([
				[ 'Mounth', 'Sản phẩm' ], [ '1', Number(giaTri[0].value) ],
				[ '2', Number(giaTri[1].value) ],
				[ '3', Number(giaTri[2].value) ],
				[ '4', Number(giaTri[3].value) ],
				[ '5', Number(giaTri[4].value) ],
				[ '6', Number(giaTri[5].value) ],
				[ '7', Number(giaTri[6].value) ],
				[ '8', Number(giaTri[7].value) ],
				[ '9', Number(giaTri[8].value) ],
				[ '10', Number(giaTri[9].value) ],
				[ '11', Number(giaTri[10].value) ],
				[ '12', Number(giaTri[11].value) ], ]);

		var options = {
			title : 'Thống kê số SP bán được',
			curveType : 'function',
			legend : {
				position : 'bottom'
			}
		};

		var chart = new google.visualization.LineChart(document
				.getElementById('curve_chart'));

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

					<div id="curve_chart"
						style="width: 1000px; margin-left: 160px; height: 500px"></div>
					<logic:iterate name="thongKeBieuDoNamForm" property="arrGiaTri"
						id="chip2">
						<input type="hidden" name="arrGiaTri"
							value='<bean:write name="chip2"/>'>
					</logic:iterate>

				</div>


			</div>
		</div>



		<!-- /.nội dung code:  -->
		<!-- /.nội dung code:  -->
		<!-- /.nội dung code:  -->
		<jsp:include page="footer.jsp" />