<%@page import="model.bean.LoaiBoPhan"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.BoPhan"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
div {
	padding: 10px;
}

td {
	boder: solid 1px blue;
}
</style>
</head>
<body>
	<h1  align="center">DANH SÁCH BỘ PHẬN</h1>
    <div class="row">
        <html:form action="/danh-sach-bo-phan" method="get">
            <div class="col-lg-4">
                <html:select property="maLoai" styleClass="form-control">
					<option value="">-- Chọn Loại Bộ Phận --</option>
					<html:optionsCollection name="danhSachBoPhanForm" property="listLoaiBoPhan" 
						label="tenLoai" value="maLoai" />
				</html:select>
            </div>
            <div>
               <script type="text/javascript">
            	$("[name='maLoai']").val('<bean:write name="danhSachBoPhanForm" property="maLoai"/>');
            </script>
            <html:submit styleClass="btn btn-primary">Xem</html:submit>
           </div>
         
        </html:form>
    </div>
    <br>
    <div class="bs-example">
        <table table class="table table-bordered" id="example" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Mã Chi Tiết</th>
                <th>Loại</th>
                <th style="width: 320px">Tên Chi Tiết</th>
                <th>Giá </th>
                <th>Số Lượng</th>
                <th>Thời Gian BH</th>
                <th><html:link styleClass="btn btn-success big" action="/themBP">Thêm mới</html:link></th>
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="danhSachBoPhanForm" property="listBoPhan" id="bp">
            	<tr>
                <th scope="row">
                	<bean:write name="bp" property="maChiTiet"/>
				</th>
                <td>
                	<bean:write name="bp" property="tenLoai"/>
                </td>
                <td>
                	<bean:write name="bp" property="tenChiTiet"/>
				</td>
                <td>
                	<bean:write name="bp" property="gia"/>
                </td>
                <td>
                	<bean:write name="bp" property="soLuong"/>
                </td>
                <td>
                	<bean:write name="bp" property="thoiGianBH"/>
                </td>
                <td>
                	<bean:define id="maChiTiet" name="bp" property="maChiTiet"></bean:define>
                	<html:link action="/suaBP?maChiTiet=${maChiTiet}">
                		<span class="btn btn-warning">Sửa</span>
                	</html:link>
                	<html:link action="/xoaBP?maChiTiet=${maChiTiet}" style="margin-left: 30px;">
                		<span class="btn btn-danger">Xóa</span>
                	</html:link>
                </td>
            </tr>
            </logic:iterate>
            </tbody>
        </table>
    </div>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$('#example')
				.DataTable(
						{
							"language" : {
								"sProcessing" : "Đang xử lý...",
								"sLengthMenu" : "Xem _MENU_ mục",
								"sZeroRecords" : "Không tìm thấy dòng nào phù hợp",
								"sInfo" : "Đang xem _START_ đến _END_ trong tổng số _TOTAL_ mục",
								"sInfoEmpty" : "Đang xem 0 đến 0 trong tổng số 0 mục",
								"sInfoFiltered" : "(được lọc từ _MAX_ mục)",
								"sInfoPostFix" : "",
								"sSearch" : "Tìm:",
								"sUrl" : "",
								"oPaginate" : {
									"sFirst" : "Đầu",
									"sPrevious" : "Trước",
									"sNext" : "Tiếp",
									"sLast" : "Cuối"
								},
								"pagingType" : "simple"
							}
						});
	</script>
</body>
</html>