<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="header.jsp" />
<!-- /.nội dung code:  -->
<!-- /.nội dung code:  -->
<!-- /.nội dung code:  -->


<h1>QUẢN LÝ SẢN PHẨM</h1>
<div class="row form-group">
	<div class="col-lg-2 pull-left">
		<html:link styleClass="btn btn-success" action="/themSP">THÊM MỚI</html:link>
	</div>

	<html:form action="quanLySanPham">
		<div class="col-lg-3">
			<html:select styleId="combo" onchange="kichHoat()" property="maHang" styleClass="form-control">
				<option value="">-- Chọn Hãng --</option>
				<html:optionsCollection name="danhSachSanPhamForm"
					property="arrHangSanPham" label="tenHang" value="maHang" />
			</html:select>
		</div>

		<div class="form-group">
			<input id="txtTimKiem"
				style="float: right; margin-right: 350px; width: 200px" type="text"
				class="form-control" placeholder="Tìm theo tên" onkeyup="timKiem()">
		</div>
	</html:form>
</div>

<br>
<div id="phanTrangDay">
	<div class="bs-example">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th width="70px">Mã loại SP</th>
					<th width="100px">Tên sản phẩm</th>
					<th width="50px">Giá nhập</th>
					<th width="50px">Giá bán</th>
					<th width="50px">Số lượng</th>
					<th width="100px">Hành động</th>
				</tr>
			</thead>
			<tbody>
				<logic:iterate name="danhSachSanPhamForm" property="arrSanPhamBean"
					id="sp">
					<tr>
						<th scope="row"><bean:write name="sp" property="maSP" /></th>
						<td><bean:write name="sp" property="tenSP" /></td>
						<td><bean:write name="sp" property="giaBanSP" /></td>
						<td><bean:write name="sp" property="giaNhapSP" /></td>
						<td><bean:write name="sp" property="soLuong" /></td>

						<bean:define id="masp" name="sp" property="maSP"></bean:define>
						<td><html:link  action="/suaSP?maLoaiSP=${masp}"><span class="btn btn-warning">Sửa</span></html:link>
							<html:link action="/xoaSP?maLoaiSP=${masp}"><span class="btn btn-danger">Xóa</span></html:link></td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
	</div>


	<button class="btn btn-default btn-sm" name="bu" id="dau" type="button"
		onclick="nutDau()"></button>
	<button class="btn btn-default btn-sm" name="bu" id="dau2"
		type="button" onclick="nutLui()"></button>
	<a id="chamDau"></a>
	<logic:iterate id="x" name="danhSachSanPhamForm"
		property="mangTongSoTrang">
		<button class="btn btn-default btn-sm" name="bu" type="button"
			value="<bean:write name="x"/>"
			onclick="loadProfile('<bean:write name="x"/>')">
			<bean:write name="x" />
		</button>
	</logic:iterate>
	<a id="chamSau"></a>
	<button class="btn btn-default btn-sm" name="bu" id="cuoi"
		type="button" onclick="nutTien()">></button>
	<button class="btn btn-default btn-sm" name="bu" id="cuoi2"
		type="button" onclick="nutCuoi()">>></button>


</div>

<script>
	var page2 = 1;
	var arr = document.getElementsByName("bu");
	$(arr[1]).prop('disabled', true);
	$(arr[1]).css("background-color", "#B2F0FF");
	$(arr[0]).prop('disabled', true);
	$(arr[0]).css("background-color", "#B2F0FF");
	$(arr[2]).prop('disabled', true);
	$(arr[2]).css("background-color", "#B2F0FF");
	hidePage(page2);
	hidePageKoCan(1);
	function kichHoat() {
		loadProfile(1);
	}
	function loadProfile(page) {
		page2 = page;
		var txtCombobox = document.getElementById("combo").value;
		var txtTim = document.getElementById("txtTimKiem").value;
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("phanTrangDay").innerHTML = xmlhttp.responseText;
				hidePage(page2);
				hidePageKoCan(page);
			}
		}
		if (page == 1) {
			xmlhttp.open("GET",
					"http://localhost:8080/ThiStrutsV2/quanLySanPham.do?soTrang=100&txtTimKiem="
							+ txtTim + "&maHang="+txtCombobox+"", true);
		} else
			xmlhttp.open("GET",
					"http://localhost:8080/ThiStrutsV2/quanLySanPham.do?soTrang="
							+ page + "&txtTimKiem=" + txtTim + "&maHang="+txtCombobox+"", true);
		xmlhttp.send();
	}
	function timKiem() {
		loadProfile(1);
	}
	function nutLui() {
		if (page2 <= 1) {
			return;
		} else {
			loadProfile(page2 - 1);
		}
	}
	function nutTien() {
		if (page2 >= arr.length - 4) {
			return;
		}
		loadProfile(Number(page2) + 1);
	}
	function nutDau() {
		loadProfile(1);
	}
	function nutCuoi() {
		loadProfile(arr.length - 4);
	}
	function hidePageKoCan(page) {
		if (arr[Number(page) + 4] != null) {
			var i = Number(page) + 3;
			for (i; i < arr.length; i++) {
				$(arr[i]).hide();
			}
			$('#cuoi').show();
			$('#cuoi2').show();
			document.getElementById("chamSau").innerHTML = "...";
		} else {
			document.getElementById("chamSau").innerHTML = " ";
		}
		if (arr[Number(page) - 2] != null) {
			var i = 0;
			for (i; i < Number(page) - 1; i++) {
				$(arr[i + 1]).hide();
			}
			$('#dau').show();
			$('#dau2').show();
			document.getElementById("chamDau").innerHTML = "...";
		} else {
			document.getElementById("chamDau").innerHTML = " ";
		}
	}
	function hidePage(page) {
		//alert(arr[page]);
		$(arr[Number(page) + 1]).prop('disabled', true);
		$(arr[Number(page) + 1]).css("background-color", "#B2F0FF");
		if (page == 1) {
			$(arr[1]).prop('disabled', true);
			$(arr[1]).css("background-color", "#B2F0FF");
			$(arr[0]).prop('disabled', true);
			$(arr[0]).css("background-color", "#B2F0FF");
		}
		if (page == (arr.length - 4)) {
			$(arr[arr.length - 1]).prop('disabled', true);
			$(arr[arr.length - 1]).css("background-color", "#B2F0FF");
			$(arr[arr.length - 2]).prop('disabled', true);
			$(arr[arr.length - 2]).css("background-color", "#B2F0FF");
		}
	}
</script>
<!-- /.nội dung code:  -->
<!-- /.nội dung code:  -->
<!-- /.nội dung code:  -->
<jsp:include page="footer.jsp" />
