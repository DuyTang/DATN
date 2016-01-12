<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="headerDoHangChiTiet.jsp" />

<script type="text/javascript">
        function show_alert()
        {
        alert("Đây là hộp thoại hiển thị cảnh báo!");
        }
</script>
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



<!-- strat the main content area -->

<div class="container">

	<div class="sixteen columns">

		<div class="box_head">
			<h3>GIỎ HÀNG</h3>
		</div>
		
		<!--end box_head -->
		<html:form action="/dat-hang" method="post">
			<table class="cart_table">

				<thead>
					<tr>
						<th class="first_td"><h4>SẢN PHẨM</h4></th>
						<th><h4>GIÁ</h4></th>
						<th><h4>SỐ LƯỢNG</h4></th>
						<th><h4>TỔNG TIỀN</h4></th>
						<th><h4></h4></th>
					</tr>
				</thead>
				<tbody id="content">
					<logic:iterate id="ab" name="arrSP">
						<bean:define name="ab" id="sp"></bean:define>
						<tr>
							<td><bean:write name="sp" property="tenSP" /></td>
							<td><input disabled="disabled" class="form-control" style="width: 120px" id="gia<bean:write name="sp" property="maSP" />"
								name="tinhGia"
								value="<bean:write name="sp" property="giaNhapSP" />"></td>
							<td><label> <input
									onclick="truSo('<bean:write name="sp" property="maSP" />')"
									class="gray_btn" type="button" id="min_qty" class="qty"
									value="-">
							</label> <label> <input
									onkeyup="kiemTra('<bean:write name="sp" property="maSP" />')"
									id="<bean:write name="sp" property="maSP" />" name="arrList"
									type="text" maxlength="12"
									value="<bean:write name="sp" property="soLuong" />" size="2">
							</label> <label> <input
									onclick="congSo('<bean:write name="sp" property="maSP" />')"
									class="gray_btn" type="button" id="max_qty" class="qty"
									value="+">
							</label></td>
							<td><input disabled="disabled" class="form-control" style="width: 120px"
								id="tongGia<bean:write name="sp" property="maSP" />"
								name="tongGia" value=""></td>

							<td><bean:define id="maSP" name="sp" property="maSP"></bean:define>
								<a class="btn btn-success"
								onclick="xoaDoHang('<bean:write name="sp" property="maSP" />')">XÓA</a>
								<a class="btn btn-success"
								onclick="suaDoHang('<bean:write name="sp" property="maSP" />')">SỬA</a>
							</td>

						</tr>
					</logic:iterate>
					<tr>
						<td></td>
						<td></td>
						<td>Tổng tiền</td>
						<td><input class="form-control" disabled="disabled" style="width:150px" id="tongAll"></td>
					</tr>
				</tbody>
			</table>
			<br/>
			<div style="float: right;width: 120px"><html:link action="/home-page.do?soTrang=1?tenCPU=" styleClass="btn btn-success">TIẾP TỤC MUA</html:link></div>
			<!--end cart_table-->
		</html:form>
		<!--end sixteen-->
		<!-- Start ordering information -->
		<br/>
		<br/>
		<div class="box_head">
			<h3>Thông tin khách hàng</h3>
		</div>
		<div class="row form-group">
			<div class="col-lg-6">
				<html:form action="/them-donHang">
					<input class="form-control" id = "tenKH" name="tenKH" placeholder="Họ tên">
					<input class="form-control" id = "diaChiKH" name="diaChiKH" placeholder="Địa chỉ">
					<input class="form-control" id = "emailKH" name="emailKH" placeholder="Email">
					<input class="form-control" id = "sdtKH" name="sdtKH" placeholder="Điện thoại">
					<input type="hidden" name="tongGiaGioHang" id="tongGiaGioHang" value="0"/>
					<input type="hidden" name="soLuong" id="soLuong" value="0"/>
					<div style="color: red" id = "loi"></div>
					<html:submit onclick="return validateKhachHang()" styleClass="btn btn-success form-control">ĐẶT HÀNG</html:submit>
				</html:form>
			</div>
			<div class="col-lg-6">
					<p class="textColor">Cách thức mua hàng:</p>
					1. Khách hàng chọn sản phẩm, điền đầy đủ thông tin cá nhân và gửi về hệ thống.<br>
					2. Chúng tôi sẽ liên lạc với bạn để xác nhận thông tin đơn hàng và thỏa thuận ngày nhận.<br>
					3. Nhân viên sẽ giao hàng và nhận thanh toán.<br>
					<div class="shopping_img" style="width: 400px; height: 50px">
                		<img src="http://www.philong.com.vn/Images/shopping.gif">
            	</div>
				</div>
					
		</div>
	<!-- End ordering information -->
	</div>
</div>
<div style="width: 1200px; margin: auto;padding-left: 30px"  ><jsp:include page="footerDoHangChiTiet.jsp" /></div>
<!--end container-->
<!-- end the main content area -->
<!-- start the footer area-->
