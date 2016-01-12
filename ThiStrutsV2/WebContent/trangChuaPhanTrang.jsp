<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<div class="bs-example">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th width="70px">Mã sản phẩm</th>
					<th width="100px">Tên sản phẩm</th>
					<th width="50px">Giá nhập</th>
					<th width="50px">Giá bán</th>
					<th width="50px">Số lượng</th>
					<th width="100px"></th>
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
	<button class="btn btn-default btn-sm" name="bu" id="dau" type="button" onclick="nutDau()"><<</button>
	<button class="btn btn-default btn-sm" name="bu" id="dau2" type="button" onclick="nutLui()"><</button>
	<a id="chamDau"></a>
	<logic:iterate id="x" name="danhSachSanPhamForm"
		property="mangTongSoTrang">
		<button class="btn btn-default btn-sm" name="bu" type="button" value="<bean:write name="x"/>"
			onclick="loadProfile('<bean:write name="x"/>')">
			<bean:write name="x" />
		</button>
	</logic:iterate>
	<a id="chamSau"></a>
	<button class="btn btn-default btn-sm" name="bu" id="cuoi" type="button" onclick="nutTien()">></button>
	<button class="btn btn-default btn-sm" name="bu" id="cuoi2" type="button" onclick="nutCuoi()">>></button>
</div>
</html>