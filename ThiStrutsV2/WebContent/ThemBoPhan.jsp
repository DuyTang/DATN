<%@page import="model.bean.LoaiBoPhan"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Thêm Bộ Phận</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
	function changeButtonName() {
		$('#submit').val('submit');
		$('#form').submit();
	}
</script>
</head>
<body>
<div class="container">
    <h3>Thêm mới Bộ Phận</h3>
    <br>
	<html:form action="/themBP" method="post">
        <div class="row form-group">
            <label class="col-lg-2">Mã Chi Tiết</label>
            <div class="col-lg-3">
            	<html:text property="maChiTiet" styleClass="form-control" readonly="true"></html:text>
            	<html:errors property="maChiTietError"/>
            </div>
        </div>
         <div class="row form-group">
            <label class="col-lg-2">Loại Bộ Phận</label>
            <div class="col-lg-3">
            	<html:select property="maLoai" styleClass="form-control">
            		<html:optionsCollection name="boPhanForm" property="listLoaiBoPhan" label="tenLoai" value="maLoai" />
            	</html:select>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Tên Chi Tiết</label>
            <div class="col-lg-3">
            	<html:text property="tenChiTiet" styleClass="form-control"></html:text>
            	<html:errors property="tenChiTietError"/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Giá</label>
            <div class="col-lg-3">
            	<html:text property="gia" styleClass="form-control"></html:text>
            	<html:errors property="giaError"/>
            </div>
        </div>
       <div class="row form-group">
            <label class="col-lg-2">Số Lượng</label>
            <div class="col-lg-3">
            	<html:text property="soLuong" styleClass="form-control"></html:text>
            	<html:errors property="soLuongError"/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Thời Gian BH</label>
            <div class="col-lg-3">
            	<html:text property="thoiGianBH" styleClass="form-control"></html:text>
            	<html:errors property="thoiGianBHError"/>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
            	<html:submit property="submit" value="Lưu" onclick="changeButtonName()"
					styleId="submit" styleClass="btn btn-success big"></html:submit>
                <html:link styleClass="btn btn-primary big" action="/danh-sach-bo-phan">QUAY LẠI</html:link>
            </div>
        </div>
    </html:form>
    <br>
</div>
</body>
</html>