
<%@page import="model.bean.SanPhamLapRap"%>
<%@page%>
<%@page%>
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
<title>DANH SÁCH SẢN PHẨM LẮP RÁP</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<div style="width: 150px; height: 50px">
	<html:link action="/home-page.do?soTrang=1?tenCPU="
		styleClass="btn btn-success">QUAY VỀ TRANG CHỦ</html:link>
</div>
<h1 style="text-align: center">
	<i><b><u>BẢNG CHÀO GIÁ</u></b></i>
</h1>
<div style="text-align: right">
	<b>LAPTOP STORE </b><br /> Main office: Số 54
	Đường Hàn Mạc Tử - Khối 12 - P. Trung Đô - Tp. Vinh<br /> Tel :
	01675-750-986 - Fax : 84-4-3.869.3859 <br /> Tel : 01659-150-026
	Fax : 84-4-3.538.0099 <br /> E-mail : duytangdhv@gmail.com<br /> Website:
	http://www.laptopstore.vn/
</div>
<body>
	<div class="container">

		<div class="row">
			<html:form action="/danhsachlaprap" method="post">

				<div class="col-lg-4"></div>
				<script type="text/javascript">
					
				</script>

			</html:form>
		</div>
		<br>
		<div class="bs-example">
			<div>
				<%
					String hoTen = request.getParameter("tenKH");
					String diaChi = request.getParameter("diaChi");
					String dienThoai = request.getParameter("soDienThoai");
					String email = request.getParameter("email");
				%>
				<p>
					Ông/bà: &nbsp;&nbsp;<b><%=hoTen%></b>
				</p>
				<p>
					Địa chỉ:&nbsp;&nbsp;<b><%=diaChi%></b>
				</p>
				<p>
					Điện thoại:&nbsp;&nbsp;<b><%=dienThoai%></b>
				</p>
				<p>
					Email:&nbsp;&nbsp;<b><%=email%></b>
				</p>


			</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="150px">Mã loại SP</th>                 
						<th>Tên Sản Phẩm</th>                 
						<th>Số lượng</th>   
						<th>Đơn giá</th>
						<th width="100px">Bảo hành</th>    
					</tr>
				</thead>
				<tbody>
					<!--   list chi tiết bộ phận chip        -->
					<logic:iterate name="lapRapForm" property="listChip" id="chip">
						<tr>
							<th scope="row"><bean:write name="chip" property="maChip" />
							</th>
							<td><bean:write name="chip" property="tenChip" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>
							</td>
							<td><bean:write name="chip" property="gia" /></td>
							<td><bean:write name="chip" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>

					<!--   list chi tiết bộ phận HDD  -->
					<logic:iterate name="lapRapForm" property="listChiTietBoPhanHDD"
						id="hdd">
						<tr>
							<th scope="row"><bean:write name="hdd" property="maChiTiet" />
							</th>
							<td><bean:write name="hdd" property="tenBoPhan" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>
							</td>
							<td><bean:write name="hdd" property="gia" /></td>
							<td><bean:write name="hdd" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<!--   list chi tiết bộ phận Main  -->
					<logic:iterate name="lapRapForm" property="listMainboard" id="main">
						<tr>
							<th scope="row"><bean:write name="main"
									property="maMainboard" /></th>
							<td><bean:write name="main" property="tenMainboard" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>
							</td>
							<td><bean:write name="main" property="gia" /></td>
							<td><bean:write name="main" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<!--   list chi tiết bộ phận ram  -->
					<logic:iterate name="lapRapForm" property="listRam" id="ram">
						<tr>
							<th scope="row"><bean:write name="ram" property="maRam" /></th>
							<td><bean:write name="ram" property="tenRam" /></td>
							<td>
								<%
									String a = request.getParameter("soLuongRam");
								%> <html:text property="soLuong" readonly="true"
									value="<%=a%>"></html:text>
							</td>
							<td><bean:write name="ram" property="gia" /></td>
							<td><bean:write name="ram" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<!--   list chi tiết bộ phận chuot  -->
					<logic:iterate name="lapRapForm" property="listChiTietBoPhanChuot"
						id="chuot">
						<tr>
							<th scope="row"><bean:write name="chuot"
									property="maChiTiet" /></th>
							<td><bean:write name="chuot" property="tenBoPhan" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>
							</td>
							<td><bean:write name="chuot" property="gia" /></td>
							<td><bean:write name="chuot" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<!--   list chi tiết bộ phận ban phim  -->
					<logic:iterate name="lapRapForm"
						property="listChiTietBoPhanBanPhim" id="bp">
						<tr>
							<th scope="row"><bean:write name="bp" property="maChiTiet" />
							</th>
							<td><bean:write name="bp" property="tenBoPhan" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>
							</td>
							<td><bean:write name="bp" property="gia" /></td>
							<td><bean:write name="bp" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<!--   list chi tiết bộ phận man hinh  -->
					<logic:iterate name="lapRapForm"
						property="listChiTietBoPhanManHinh" id="mh">
						<tr>
							<th scope="row"><bean:write name="mh" property="maChiTiet" />
							</th>
							<td><bean:write name="mh" property="tenBoPhan" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>
							</td>
							<td><bean:write name="mh" property="gia" /></td>
							<td><bean:write name="mh" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<!--   list chi tiết bộ phận Case  -->
					<logic:iterate name="lapRapForm" property="listChiTietBoPhanCase"
						id="case1">
						<tr>
							<th scope="row"><bean:write name="case1"
									property="maChiTiet" /></th>
							<td><bean:write name="case1" property="tenBoPhan" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>
							</td>
							<td><bean:write name="case1" property="gia" /></td>
							<td><bean:write name="case1" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<!--   list chi tiết bộ phận nguon  -->
					<logic:iterate name="lapRapForm" property="listChiTietBoPhanNguon"
						id="nguon">
						<tr>
							<th scope="row"><bean:write name="nguon"
									property="maChiTiet" /></th>
							<td><bean:write name="nguon" property="tenBoPhan" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>
							</td>
							<td><bean:write name="nguon" property="gia" /></td>
							<td><bean:write name="nguon" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<!--   list chi tiết bộ phận DVD  -->
					<logic:iterate name="lapRapForm" property="listChiTietBoPhanDVD"
						id="dvd">
						<tr>
							<th scope="row"><bean:write name="dvd" property="maChiTiet" />
							</th>
							<td><bean:write name="dvd" property="tenBoPhan" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>
							</td>
							<td><bean:write name="dvd" property="gia" /></td>
							<td><bean:write name="dvd" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<!--   list chi tiết bộ phận tan nhiet  -->
					<logic:iterate name="lapRapForm"
						property="listChiTietBoPhanTanNhiet" id="tn">
						<tr>
							<th scope="row"><bean:write name="tn" property="maChiTiet" />
							</th>
							<td><bean:write name="tn" property="tenBoPhan" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>
							</td>
							<td><bean:write name="tn" property="gia" /></td>
							<td><bean:write name="tn" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<!--   list chi tiết bộ phận phu kien  -->
					<logic:iterate name="lapRapForm"
						property="listChiTietBoPhanPhuKien" id="pk">
						<tr>
							<th scope="row"><bean:write name="pk" property="maChiTiet" />
							</th>
							<td><bean:write name="pk" property="tenBoPhan" /></td>
							<td><html:text property="soLuong" readonly="true" value="1"></html:text>

							</td>
							<td><bean:write name="pk" property="gia" /></td>
							<td><bean:write name="pk" property="thoiGianBH" /></td>
						</tr>
					</logic:iterate>
					<tr>
						<%
							String tongTien = request.getParameter("tongCong");
						%>
						<td></td>
						<td></td>
						
						<td><b>TỔNG TIỀN:</b></td>
						<td width="40px"><b><html:text property="tongCong"
									readonly="true" value="<%=tongTien%>" styleId="tongTien"></html:text></b>
						</td>
					</tr>
				</tbody>

			</table>
			<table>
				<tr>
					<td><b>Provided:</b> At LapTop Store immediately after customer payment</td>
				</tr>
				<tr>
					<td><b>Payment: </b> Cash, check or bank transfer</td>
				</tr>
				<tr>
					<td><b>Account Number: </b> Computer Corporation LapTop Store </td>
				</tr>
				<tr>
					<td>TNHH MTV HSBC Viet Nam - Vinh Branch (HSBC Việt Nam =
						CN Vinh) STK VND: 002-292738-001 STK USD: 002-292738-101</td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>