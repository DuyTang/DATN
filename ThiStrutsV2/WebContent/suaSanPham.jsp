<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="header.jsp" />
<!-- /.nội dung code:  -->
<!-- /.nội dung code:  -->
<br>

<h1>CHỈNH SỬA SẢN PHẨM</h1>
<br>
<html:form action="/suaSP" method="post" enctype="multipart/form-data">
	<div class="row form-group">
		<label class="col-lg-2">Mã loại sản phẩm:</label>
		<div class="col-lg-3">
			<html:text property="maLoaiSP" styleClass="form-control"
				readonly="true"></html:text>
		</div>
	</div>


	<div class="row form-group">
		<label class="col-lg-2">Tên sản phẩm:</label>
		<div class="col-lg-3">
			<html:text property="tenSP" styleClass="form-control"></html:text>
		</div><span style="color: red">*</span>
		<html:errors property="common.tenSP" />
	</div>

	<div class="row form-group">
		<label class="col-lg-2">Giá nhập</label>
		<div class="col-lg-3">
			<html:text property="giaNhapSP" styleClass="form-control"></html:text>
		</div><span style="color: red">*</span>
		<html:errors property="common.giaNhapSP" />
	</div>

	<div class="row form-group">
		<label class="col-lg-2">Giá bán</label>
		<div class="col-lg-3">
			<html:text property="giaBanSP" styleClass="form-control"></html:text>
		</div><span style="color: red">*</span>
		<html:errors property="common.giaBanSP" />
	</div>

	<br>
	<div class="row form-group">
		<label class="col-lg-2">Hình ảnh</label>
		<html:file style="margin-left: 190px" property="anhSP"
			onchange="readURL(this);"></html:file>
		<div style="margin-left: 190px">
			<img id="blah" src="#" alt="your image" />
		</div><span style="color: red">*</span>
		<html:errors property="common.giaBanSP" />
	</div>

	<script type="text/javascript">
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#blah').attr('src', e.target.result).width(150).height(
							200);
				};

				reader.readAsDataURL(input.files[0]);
			}
		}
	</script>
	<html:errors property="common.file" />
	<br>

	<div class="row form-group">
		<label class="col-lg-2">Thời hạn bảo hành</label>
		<div class="col-lg-3">
			<html:text property="thoiGianBaoHanh" styleClass="form-control"></html:text>
		</div><span style="color: red">*</span>
		<html:errors property="common.thoiGianBaoHang" />
	</div>

	<div class="row form-group">
		<label class="col-lg-2">Số lượng</label>
		<div class="col-lg-3">
			<html:text property="soLuong" styleClass="form-control"></html:text>
		</div><span style="color: red">*</span>
		<html:errors property="common.soLuong" />
	</div>

	<div class="row form-group">
		<label class="col-lg-2">Sản phẩm mới?</label>
		<div class="col-lg-3">
			<html:checkbox property="sanPhamMoi" value="1"></html:checkbox>
		</div>
	</div>

	<div class="row form-group">
		<label class="col-lg-2">Loại sản phẩm</label>
		<div class="col-lg-3">
			<html:select property="maLoai" styleClass="form-control">
				<html:optionsCollection name="sanPhamForm" property="arrLoaiSanPham"
					label="tenLoai" value="maLoai" />
			</html:select>
		</div>
	</div>

	<div class="row form-group">
		<label class="col-lg-2">Hãng sản xuất</label>
		<div class="col-lg-3">
			<html:select property="maHang" styleClass="form-control">
				<html:optionsCollection name="sanPhamForm" property="arrHangSanPham"
					label="tenHang" value="maHang" />
			</html:select>
		</div>
	</div>

	<div class="row form-group">
		<label class="col-lg-2">CPU</label>
		<div class="col-lg-3">
			<html:text property="cpu" styleClass="form-control"></html:text>
		</div>
	</div>

	<div class="row form-group">
		<label class="col-lg-2">RAM</label>
		<div class="col-lg-3">
			<html:text property="ram" styleClass="form-control"></html:text>
		</div>
	</div>

	<div class="row form-group">
		<label class="col-lg-2">Màn hình</label>
		<div class="col-lg-3">
			<html:text property="manHinh" styleClass="form-control"></html:text>
		</div>
	</div>

	<div class="row form-group">
		<label class="col-lg-2">HDD</label>
		<div class="col-lg-3">
			<html:text property="diaCung" styleClass="form-control"></html:text>
		</div>
	</div>

	<div class="row form-group">
		<label class="col-lg-2">Đồ họa</label>
		<div class="col-lg-3">
			<html:text property="doHoa" styleClass="form-control"></html:text>
		</div>
	</div>

	<div class="row form-group">
		<label class="col-lg-2">Trọng lượng</label>
		<div class="col-lg-3">
			<html:text property="trongLuong" styleClass="form-control"></html:text>
		</div>
	</div>

	<div class="row form-group">
		<div class="col-lg-3 col-lg-offset-2">
			<html:submit styleClass="btn btn-primary" property="submit"
				value="submit"></html:submit>
			<html:link styleClass="btn btn-primary"
				action="/quanLySanPham.do?soTrang=1">Hủy</html:link>
		</div>
	</div>
</html:form>
<!-- /.nội dung code:  -->
<!-- /.nội dung code:  -->
<jsp:include page="footer.jsp" />
