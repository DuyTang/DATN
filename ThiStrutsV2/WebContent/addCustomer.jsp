<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="header.jsp" />
<script>
	function changeButtonName() {
		$('#submit').val('submit');
		$('#form').submit();
	}
</script>
	<div class="container">
    <h1>THÊM MỚI KHÁCH HÀNG</h1>
    <br>
	<html:form action="/addCus" method="post">
        <div class="row form-group">
            <label class="col-lg-2">Mã KH:</label>
            <div class="col-lg-3">
            	<html:text property="maKH" styleClass="form-control" readonly="true"></html:text>
            	<p style="color:red"/><html:errors property="maKHError"/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Tên KH:</label>
            <div class="col-lg-3">
            	<html:text property="tenKH" styleClass="form-control"></html:text>
            	<p style="color: red"><html:errors property="tenKHError"/></p>
            </div>
            <h4 style="color: red">*</h4>
        </div>
         <div class="row form-group">
            <label class="col-lg-2">Địa chỉ:</label>
            <div class="col-lg-3">
            	<html:text property="diaChi" styleClass="form-control"></html:text>
            	<p style="color: red"><html:errors property="diaChiError"/></p>
            </div>
            <h4 style="color: red">*</h4>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Email:</label>
            <div class="col-lg-3">
            	<html:text property="email" styleClass="form-control"></html:text>
            	<p style="color: red"><html:errors property="emailError"/></p>
            </div>
            <h4 style="color: red">*</h4>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Điện thoại:</label>
            <div class="col-lg-3">
            	<html:text property="soDienThoai" styleClass="form-control"></html:text>
            	<p style="color: red"><html:errors property="dienThoaiError"/></p>
            </div>
            <h4 style="color: red">*</h4>
        </div>
 
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
            	<html:submit property="submit" value="THÊM MỚI"
				onclick="changeButtonName()" styleId="submit"
				styleClass="btn btn-success big"></html:submit>
               <html:link styleClass="btn btn-primary"
				action="/currentCus">QUAY LẠI</html:link>
            </div>
        </div>
    </html:form>
    <br>
</div>
<jsp:include page="footer.jsp" />