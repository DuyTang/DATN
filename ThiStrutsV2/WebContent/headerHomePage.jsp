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
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/home2.css">
<link rel="stylesheet" href="css/responsive.css">

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
<body onload="kiemTra()" style="margin-top; padding: 0px">

	<!--start header-->
	<header>
	
	<div id="middleHeader">
		<div class="container">
			<div class="sixteen columns">
				<div id="logo" >
					
					
				</div>
				<div id = "divB">
					<img src="images/icons/banner1.jpg" alt=""  width="935px" height="200px" align="right">
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
					TRANG CHỦ</html:link></li>
					<li><a style="width: 70px; text-align: center;" href="aboutUs.jsp">GIỚI THIỆU</a></li>
					<li><html:link action="/laprapsanpham"> XÂY DỰNG CẤU HÌNH MÁY </html:link></li>
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
						<html:link action="/login">Đăng Nhập</html:link>
						  </html:link>
					<!--end cart_content-->
				</div>
				<!--end cart-->

			</div>
			<!--end main-->
		</div>
		<!--end sixteen-->
	</div>
	<!--end container--> </header>
	<!--end header-->



	<div class="container">
		<div class="sixteen columns">

			<div id="slide_outer">
				<div class="mainslide">

					<div class="pagers center">
						<a class="prev slide_prev" href="#prev">Prev</a> <a
							class="nxt slide_nxt" href="#nxt">Next</a>
					</div>

					<ul class="cycle-slideshow clearfix" data-cycle-fx="scrollHorz"
						data-cycle-timeout="2000" data-cycle-slides="> li"
						data-cycle-pause-on-hover="true"
						data-cycle-prev="div.pagers a.slide_prev"
						data-cycle-next="div.pagers a.slide_nxt">
						<li class="clearfix">
							<div class="slide_img">
								<img src="images/icons/iphone_icon.png" alt="">
							</div>
							<div class="flex-caption">
								<h5>
									Sản Phẩm Nổi Bật<br> <span>Asus E402MA N2840/2GB/500GB/Win10</span>
								</h5>
									<p>Thông số kỹ thuật	
										CPU:	Intel, Celeron, N2840, 2.16 GHz
										RAM:	DDR3L (1 khe RAM), 2 GB, 1600 MHz
										Đĩa cứng:	HDD, 500 GB
										Màn hình rộng:	14 inch, HD (1366 x 768 pixels)
										</p>
										<p>
										Cảm ứng:	Không
										Đồ họa:	Integrated Graphics, Share
										Đĩa quang:	Không
										Webcam:	0.3 MP
										Chất liệu vỏ:	Vỏ nhựa
										Cổng giao tiếp:	VGA (D-Sub), USB 3.0, USB 2.0, LAN (RJ45), HDMI
										Kết nối khác:	Không
										PIN/Battery:	Li-Ion 2 cell
										Trọng lượng: (Kg)	1.65 kg</p>
								<a href="http://localhost:8080/ThiStrutsV2/chi-tietSP.do?maLoaiSP=SP16"><span>Chi Tiết</span><span class="shadow">8.699.000</span></a>
							</div>
						</li>

						<li class="clearfix">
							<div class="slide_img">
								<img src="images/icons/dell_icon.png" alt="">
							</div>
							<div class="flex-caption">
								<h5>
									Sản Phẩm Nổi Bật<br> <span>Dell Inspiron 3551 Celeron N2840/2GB/500GB/Win8.1</span>
								</h5>
								<p>Thông số kỹ thuật

									CPU:	Intel, Celeron, N2840, 2.16 GHz
									RAM:	DDR3L (1 khe RAM), 2 GB, 1600 MHz
									Đĩa cứng:	HDD, 500 GB
									Màn hình rộng:	15.6 inch, HD (1366 x 768 pixels)
								</p>
								<p>Cảm ứng:	Không
									Đồ họa:	Intel® HD Graphics, Share
									Đĩa quang:	Không
									Webcam:	0.9 MP(16:9)
									Chất liệu vỏ:	Vỏ nhựa
									Cổng giao tiếp:	USB 3.0, HDMI, 2 x USB 2.0
									Kết nối khác:	Bluetooth v4.0
									PIN/Battery:	Li-Ion 4 cell
									Trọng lượng: (Kg)	2.14</p>
								<a href="http://localhost:8080/ThiStrutsV2/chi-tietSP.do?maLoaiSP=SP09"><span>Chi Tiết</span><span class="shadow">8.990.000</span></a>
							</div>
						</li>

						<li class="clearfix">
							<div class="slide_img">
								<img src="images/icons/acer_icon.jpg" alt="">
							</div>
							<div class="flex-caption">
								<h5>
									Sản Phẩm Mới<br> <span>Acer Aspire ES1 411 N3540/2G/500G/Win8</span>
								</h5>
								<p>Thông số kỹ thuật
									CPU:	Intel, Pentium, N3540, 2.16 GHz
									RAM:	DDR3 (1 khe RAM), 2 GB, 1600 MHz
									Đĩa cứng:	HDD, 500 GB
									Màn hình rộng:	14 inch, HD (1366 x 768 pixels)
									</p>
								<p>
									Cảm ứng:	Không
									Đồ họa:	Intel® HD Graphics, Share
									Đĩa quang:	DVD Super Multi Double Layer
									Webcam:	0.3 MP
									Chất liệu vỏ:	Vỏ nhựa
									Cổng giao tiếp:	USB 3.0, USB 2.0, LAN (RJ45), HDMI
									Kết nối khác:	Bluetooth
									PIN/Battery:	Li-Ion 4 cell
									Trọng lượng: (Kg)	1.9
								</p>
								<a href="http://localhost:8080/ThiStrutsV2/chi-tietSP.do?maLoaiSP=SP31"><span>Chi Tiết</span><span class="shadow">10.000.000</span></a>
							</div>
						</li>
					</ul>
				</div>
				<div class="shadow_left"></div>
				<div class="shadow_right"></div>
			</div>
			
			<html:form action="home-page">
				<div style="display: inline-block; margin-bottom: 15px">
					<div style="float: right;">
					<a style="height: 40px;width:100px;margin-left: 20px" onclick="setLai()" class="btn btn-success">XEM TẤT CẢ</a>
					</div>
					<div style="float: right;">
						<input id="txtTimKiem"
							style="width: 150px; height: 40px; margin-left: 20px" type="text"
							class="form-control" placeholder="Search"
							onkeyup="ajaxHome('9999')" />

					</div>
					<div style="float: right;margin-left: 20px">
						<select onchange="ajaxHome('9999')" id="cbCPU" class="form-control"
							style="width: 150px; height: 40px">
							<option value="">--Chọn CPU--</option>
							<option value="3">Core i3</option>
							<option value="5">Core i5</option>
							<option value="7">Core i7</option>
							<option value="khac">Khác</option>
						</select>
					</div>
					<div style="float: right;margin-left: 300px">
						<html:select onchange="ajaxHome('9999')" styleId="cbHangSanPham"
							property="maHang" styleClass="form-control"
							style="width: 150px;height: 40px">
							<option value="">--Chọn hãng--</option>
							<html:optionsCollection name="trangChuForm"
								property="arrHangSanPham" label="tenHang" value="maHang" />
						</html:select>
					</div>
				</div>
			</html:form>



		</div>
	</div>
	<!-- container -->
	<!-- strat the main content area -->
