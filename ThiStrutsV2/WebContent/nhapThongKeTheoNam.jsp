<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<jsp:include page="header.jsp" />
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

			<html:form action="/thongKeTheoNam-soLuong" method="post">

				<label class="col-lg-2" style="width: 300px">Nhập năm
					(thứ nhất)(YYYY) </label>
				<html:text property="thoiGian1" styleClass="form-control"
					style="width:100px"></html:text>
				<p style="color: red">
					<html:errors property="tenKHError" />
				</p>
				<br>
				<label class="col-lg-2" style="width: 300px">Nhập năm
					(thứ hai)(YYYY) </label>
				<html:text property="thoiGian2" styleClass="form-control"
					style="width:100px"></html:text>
				<p style="color: red">
					<html:errors property="tenKHError" />
				</p>
				<br>
						<html:submit property="submit" value="Xem"
							 styleId="submit"
							styleClass="btn btn-success big"></html:submit>
			</html:form>
		</div>
	</div>
</div>

<!-- /.nội dung code:  -->
<!-- /.nội dung code:  -->
<!-- /.nội dung code:  -->
<jsp:include page="footer.jsp" />
