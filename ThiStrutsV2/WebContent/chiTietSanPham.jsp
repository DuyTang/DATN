<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="headerDoHangChiTiet.jsp" />

<style>
/* start Product detail*/
.product_detail_title {
	color: #B61014;
	text-Shadow: 0 0 1px rgba(182, 16, 20, 0.3);
	font-size: 22px;
	line-height: 26px;
}

.product_detail_ID {
	font-size: 13px;
}

.product_add_detail_btn {
	float: left;
	width: 120px;
	height: 32px;
	background: url(images/photos/product_add_detail_btn.png) no-repeat 0 0;
	margin-top: 22px;
}

.product_detail_price {
	font-size: 18px;
	margin-top: 15px;
	text-Shadow: 0 0 1px #bbb;
}

.product_detail_price span {
	color: #B61014;
	text-Shadow: 0 0 1px rgba(182, 16, 20, 0.3);
}

.promotion_bg {
	float: left;
	width: 95%;
	border: 1px dashed #B61013;
	margin-top: 15px;
	padding: 12px 2%;
	color: #B61013;
	font-size: 14px;
	text-Shadow: 0 0 1px rgba(182, 16, 20, 0.1);
}

/* end Product detail*/
th {
	font-weight: bold;
	font-size: 15px;
	width: 300px;
}

.btnSend {
	background-color: #B61014;
	border-radius: 0px 5px 0 5px;
	width: 50px;
}
</style>


<div class="container">
	<div class="sixteen columns">

		<div id="pageName">
			<div class="name_tag">
				<div class="shapLeft"></div>
				<div class="shapRight"></div>
			</div>
		</div>
		<!--end pageName-->

	</div>
</div>
<!-- container -->



<div class="container">
	<div class="sixteen columns">

		<div class="box_head">
			<h3>CHI TIẾT SẢN PHẨM</h3>
		</div>
		<!--end box_head -->
		<div class="row form-group">
			<div class="col-lg-4" style="text-align: center;">
				<div class="img">
					
					<img style="height: 300px;width: 300px" src="img/imgLapTop/<bean:write name="sanPhamForm" property="linkAnh" />" alt="product">
					
				</div>
			</div>
			<div class="col-lg-8">
				<p class="product_detail_title">
					<bean:write name="sanPhamForm" property="tenSP" />
					<bean:define id="maSP" name="sanPhamForm" property="maLoaiSP"></bean:define>
				</p>
				<div class="product_detail_price">
					GIÁ: <span><bean:write name="sanPhamForm"
							property="giaNhapSP" /></span>
				</div>
				<div class="product_detail_soluong">
					SỐ LƯỢNG: <span><bean:write name="sanPhamForm"
							property="soLuong" /></span>
				</div>
				<br>
				<html:link styleClass="btn btn-success"
					action="/do-hang?maSP=${maSP}"> MUA NGAY
				</html:link>
				<br />
				<br>
				<p>Thông tin sản phẩm:</p>
					CPU: <bean:write name="sanPhamForm" property="cpu" />,
				 	RAM:<bean:write name="sanPhamForm" property="ram" />,
					HHD:<bean:write name="sanPhamForm" property="diaCung" />,
					Màn hình:<bean:write name="sanPhamForm" property="manHinh" />,
				    Card Reader 5.1, Webcam 1.3M,
				<p>Bảo hành: <bean:write name="sanPhamForm" property="thoiGianBaoHanh" /> tháng</p>
				
			</div>
		</div>

		<!-- Start menu san pham -->

		<div id="mainNav" class="clearfix">
			<nav>
				<ul>
					<li><a class="hasdropdown" href="#ThongSo">THÔNG SỐ KỸ THUẬT</a></li>
					<li><a class="desktop hasdropdown" href="#binhLuan">BÌNH LUẬN</a>
					</li>
				</ul>
			</nav>
			<!--end nav-->
		</div>
		<br />
		<!-- End menu san pham -->
		<!-- Start Box -->
		<div id="ThongSo">
			<div class="box_head">
				<h3>THÔNG SỐ KỸ THUẬT</h3>
			</div>
			<table class="table table-bordered" >
				<tr>
					<th  style="text-align: right;">CPU</th>
					<td><bean:write name="sanPhamForm" property="cpu" /></td>
				</tr>
				<tr>
					<th style="text-align: right;">RAM</th>
					<td><bean:write name="sanPhamForm" property="ram" /></td>
				</tr>
				<tr>
					<th style="text-align: right;">HDD</th>
					<td>500 GB SATA</td>
				</tr>
				<tr>
					<th style="text-align: right;">MÀN HÌNH</th>
					<td><bean:write name="sanPhamForm" property="manHinh" /></td>
				</tr>
				<tr>
					<th style="text-align: right;">NGOẠI VI</th>
					<td>Card Reader 5.1, Webcam HD, Microphone</td>
				</tr>
				<tr>
					<th style="text-align: right;">ĐỒ HỌA</th>
					<td><bean:write name="sanPhamForm" property="doHoa" /></td>
				</tr>
				<tr>
					<th style="text-align: right;">TRỌNG LƯỢNG</th>
					<td><bean:write name="sanPhamForm" property="trongLuong" /></td>
				</tr>
				<tr>
					<th style="text-align: right;">HỆ ĐIỀU HÀNH</th>
					<td>Windows 8.1</td>
				</tr>
			</table>
		</div>
		<div id="binhLuan">
			<div class="box_head">
				<h3>BÌNH LUẬN</h3>
			</div>
			<!-- End Box -->
			<textarea rows="" cols="" class="form-control" placeholder="Bình luận"></textarea>
			<div class="row form-group" style="margin-top: 5px;">
				<div class="col-lg-1" style="width: 50px;">
					<img src="images/photos/comment_icon.png" />
				</div>
				<div class="col-lg-4">
					<input class="form-control" type="text" placeholder="Họ tên">
				</div>
				<div class="col-lg-4">
					<input class="form-control" type="email" placeholder="Email">
				</div>
				<div class="col-lg-3">
					<button class="btn btnSend">GỬI</button>
				</div>
			</div>
		</div>
	</div>
</div>
<div  style="width: 1200px;margin-left: 70px">
<jsp:include page="footerDoHangChiTiet.jsp" />
</div>
<!--end container-->
<!-- end the main content area -->
<!-- start the footer area-->
