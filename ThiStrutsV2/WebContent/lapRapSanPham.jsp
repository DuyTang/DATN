<%@page import="model.bean.Chip"%>
<%@page import="model.bean.Mainboard"%>
<%@page import="model.bean.Ram"%>
<%@page import="model.bean.ChiTietBoPhan"%>
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
<title>Danh Sách Lắp Ráp</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<style>
#table td select {
	width: auto;
}

.khung {
	width: 940px;
	margin: 0 auto;
}
</style>

<script>
	function changButtonValue() {
		$('#btnSubmit').val('submit');
		$('#form').submit();
	}
</script>

</head>

<jsp:include page="headerBaoHanh.jsp" />

<body>

	<div class="container">
		<div class="sixteen columns">

			<div id="pageName">
				<div class="name_tag">
					<p>
					</p>
					<div class="shapLeft"></div>
					<div class="shapRight"></div>
				</div>
			</div>
			<!--end pageName-->

		</div>
	</div>

	<div class="khung">

		<div class="box_head">
			<h3>XÂY DỰNG CẤU HÌNH MÁY</h3>
		</div>
		<h2></h2>
		<html:form action="/laprapsanpham" method="post" styleId="form">
			<div class="row form-group">
				<label class="col-lg-2">MAINBOARD:(*)</label>
				<div class="col-lg-8">
					<html:select property="maMainboard"
						styleClass="form-control Mainboard" styleId="Mainboard" >
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm" property="listMainboard"
							label="tenMainboard" value="giaVaLoaiMain" />
					</html:select>
					
				</div>
				<html:submit styleClass="btn btn-primary class DatHang"
								property="submit"  value="Chọn"
								onclick="changButtonValue()">Đặt hàng</html:submit>
				<html:errors property="mainError" />
			</div>
			
			<div class="row form-group">
				<label class="col-lg-2">CPU:(*)</label>
				<div class="col-lg-8">
					<html:select property="maChip" styleClass="form-control Chip"
						styleId="Chip">
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm" property="listChip"
							label="tenChip" value="giaVaLoai" />
					</html:select>
					
				</div>
				<html:errors property="chipError" />
			</div>
			<div class="row form-group">
				<label class="col-lg-2">RAM:(*)</label>
				<div class="col-lg-4">

					<html:select property="maRam" styleClass="form-control Ram"
						styleId="Ram">
						<option value="0-null">-- Chọn--</option>
						<html:optionsCollection name="lapRapForm" property="listRam"
							label="tenRam" value="giaVaLoai" />
					</html:select>
				</div>

				<label class="col-lg-2">Số Lượng:</label>
				<div class="col-lg-2">
					<html:select styleClass="form-control SoLuong"
						property="soLuongRam" styleId="SoLuong">
						<html:option value="">-- Chọn --</html:option>
						<html:option value="1">1</html:option>
						<html:option value="2">2</html:option>
						<html:option value="3">3</html:option>
						<html:option value="4">4</html:option>
						<html:option value="5">5</html:option>
					</html:select>
				</div>
				<html:errors property="ramError" />
			</div>
			<div class="row form-group">
				<label class="col-lg-2">HDD:(*)</label>
				<div class="col-lg-8">
					<html:select property="maHDD" styleClass="form-control HDD"
						styleId="HDD">
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm"
							property="listChiTietBoPhanHDD" label="tenBoPhan" value="giaVaMa" />
					</html:select>
				</div>
				<html:errors property="hddError" />
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Chuột</label>
				<div class="col-lg-8">
					<html:select property="maChuot" styleClass="form-control Chuot"
						styleId="Chuot">
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm"
							property="listChiTietBoPhanChuot" label="tenBoPhan"
							value="giaVaMa" />
					</html:select>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Bàn phím: </label>
				<div class="col-lg-8">
					<html:select property="maBanPhim" styleClass="form-control BanPhim"
						styleId="BanPhim">
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm"
							property="listChiTietBoPhanBanPhim" label="tenBoPhan"
							value="giaVaMa" />
					</html:select>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Màn hinh:</label>
				<div class="col-lg-8">
					<html:select property="maManHinh" styleClass="form-control ManHinh"
						styleId="ManHinh">
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm"
							property="listChiTietBoPhanManHinh" label="tenBoPhan"
							value="giaVaMa" />
					</html:select>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">CASE:(*)</label>
				<div class="col-lg-8">
					<html:select property="maCase" styleClass="form-control Case"
						styleId="Case">
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm"
							property="listChiTietBoPhanCase" label="tenBoPhan"
							value="giaVaMa" />
					</html:select>
				</div>
				<html:errors property="caseError" />
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Nguồn:(*)</label>
				<div class="col-lg-8">
					<html:select property="maNguon" styleClass="form-control Nguon"
						styleId="Nguon">
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm"
							property="listChiTietBoPhanNguon" label="tenBoPhan"
							value="giaVaMa" />
					</html:select>
				</div>
				<html:errors property="nguonError" />
			</div>
			<div class="row form-group">
				<label class="col-lg-2">DVD:</label>
				<div class="col-lg-8">
					<html:select property="maDVD" styleClass="form-control DVD"
						styleId="DVD">
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm"
							property="listChiTietBoPhanDVD" label="tenBoPhan" value="giaVaMa" />
					</html:select>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Tản nhiệt:</label>
				<div class="col-lg-8">
					<html:select property="maTanNhiet"
						styleClass="form-control TanNhiet" styleId="TanNhiet">
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm"
							property="listChiTietBoPhanTanNhiet" label="tenBoPhan"
							value="giaVaMa" />
					</html:select>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Phụ kiện:</label>
				<div class="col-lg-8">
					<html:select property="maPhuKien" styleClass="form-control PhuKien"
						styleId="PhuKien">
						<option value="0-null">-- Chọn --</option>
						<html:optionsCollection name="lapRapForm"
							property="listChiTietBoPhanPhuKien" label="tenBoPhan"
							value="giaVaMa" />
					</html:select>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Tổng tiền</label>
				<div class="col-lg-8">
					<b><html:text property="tongCong" styleId="total" readonly="true"></html:text></b>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2"></label>
				<h5 class="col-lg-8">
					<b>Thông tin khách hàng</b>
				</h5>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Họ và tên: (*)</label>
				<div class="col-lg-5">
					<html:text property="tenKH" styleClass="form-control"
						styleId="tenKH"></html:text>
					<html:errors property="tenkhError" />
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Địa chỉ: (*)</label>
				<div class="col-lg-5">
					<html:text property="diaChi" styleClass="form-control"
						styleId="diaChi"></html:text>
					<html:errors property="diachiError" />
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Email: (*)</label>
				<div class="col-lg-5">
					<html:text property="email" styleClass="form-control"
						styleId="email"></html:text>
					<html:errors property="emailError" />

				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Điện thoại: (*)</label>
				<div class="col-lg-5">
					<html:text property="soDienThoai" styleClass="form-control"
						styleId="sodienthoai"></html:text>
					<html:errors property="soDienThoaiError" />
				</div>
			</div>
			<html:hidden property="tinhTrang" value="true" />
			<html:hidden property="maSPLapRap" />
			<div class="row form-group">
				<label class="col-lg-2"></label>
				<div class="col-lg-5">
					<bean:write name="lapRapForm" property="date" />
				</div>
			</div>
			<html:hidden property="soLuong" value="1"></html:hidden>
			<html:hidden property="maHD" />
			<html:hidden property="maKH" />
			<div class="row form-group">
				<label class="col-lg-2"></label>
				<div class="col-lg-5">
					<div class="row form-group">
						<div class="col-lg-3 col-lg-offset-2">
							<html:submit styleClass="btn btn-primary class DatHang"
								property="submit" styleId="btnSubmit" value="Xác nhận"
								onclick="changButtonValue()">Đặt hàng</html:submit>
						</div>
						
						
						<div>
							<html:reset styleClass="btn btn-primary" value="Làm lại">Reset</html:reset>
						</div>
					</div>
				</div>
			</div>
		</html:form>
	</div>
	<div  style="width: 1200px;margin-left: 70px">
	<jsp:include page="footerDoHangChiTiet.jsp" />
	</div>
	<script src="js/validate1.js"></script>
</body>
</html>